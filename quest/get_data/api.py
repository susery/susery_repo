import  os
import  sys

BASE_DIR = os.path.dirname(os.path.dirname( os.path.abspath(__file__) ))
sys.path.append(BASE_DIR )

from db import datasource
from db import sqlutil
import tushare as ts
import time

pro = ts.pro_api('f5350c30ca2a9cc88665e05cde4e1488a4b2d0768d74531d254505da')

#根据接口获取的数据存库
def into_db(tableName,fields,data):
    conn = datasource.get_ds()
    sqlutil.create_table(conn,tableName,fields)
    sqlutil.insert_data(conn,tableName,data)
    conn.close()

def into_db_new(tableName,fields,data):
    conn = datasource.get_ds()
    sqlutil.create_table(conn,tableName,fields)
    sqlutil.insert_data(conn,tableName,data)


#获取基础信息数据，包括股票代码、名称、上市日期、退市日期等
def stock_basic():
    fields = [
        "ts_code",
        "symbol",
        "name",
        "area",
        "industry",
        "market",
        "list_date",
        "fullname",
        "cnspell",
        "exchange",
        "curr_type",
        "list_status",
        "delist_date",
        "is_hs"
    ]
    data = pro.stock_basic(**{
        "ts_code": "",
        "name": "",
        "exchange": "",
        "market": "",
        "is_hs": "",
        "list_status": "L",
        "limit": "",
        "offset": ""
    }, fields=fields)
    tableName = 'stock_basic'
    into_db(tableName,fields,data)

#获取各大交易所交易日历数据,默认提取的是上交所
def trade_cal():
    fields=[
        "exchange",
        "cal_date",
        "is_open",
        "pretrade_date"
    ]
    data = pro.trade_cal(**{
        "exchange": "",
        "cal_date": "",
        "start_date": "",
        "end_date": "",
        "is_open": "",
        "limit": "",
        "offset": ""
    }, fields=fields)
    tableName = 'trade_cal'
    into_db(tableName,fields,data)


def stock_company():
    fields=[
        "ts_code",
        "exchange",
        "chairman",
        "manager",
        "secretary",
        "reg_capital",
        "setup_date",
        "province",
        "city",
        "website",
        "email",
        "employees",
        "business_scope",
        "main_business"
    ]
    data = pro.stock_company(**{
        "ts_code": "",
        "exchange": "",
        "status": "",
        "limit": "",
        "offset": ""
    }, fields=fields)
    tableName = 'stock_company'
    conn = datasource.get_ds()
    cu = conn.cursor()
    sql =  'CREATE TABLE IF NOT EXISTS %s(' % tableName
    with conn.cursor() as cu:
        for i in range(len(fields)):

            if i == (len(fields)-1):
                if fields[i] == 'business_scope' or fields[i] =='main_business':
                    sql += '%s text);' % fields[i]
                else:
                    sql += '%s varchar(150));' % fields[i]
            else:
                if fields[i] == 'business_scope' or fields[i] =='main_business':
                    sql += '%s text,' % fields[i]
                else:
                    sql += '%s varchar(150),' % fields[i]
        print(sql)
        cu.execute(sql)
    sqlutil.insert_data(conn,tableName,data)
    conn.close()

#获取日行情数据（所有股票）
def daily(start_date,end_date):
    conn = datasource.get_ds()
    cu = conn.cursor()
    cu.execute("SELECT ts_code FROM stock_basic")
    fields=[
            "ts_code",
            "trade_date",
            "open",
            "high",
            "low",
            "close",
            "pre_close",
            "change",
            "pct_chg",
            "vol",
            "amount"
        ]
    for row in cu:
        ts_code = row['ts_code']
        data = pro.daily(**{
            "ts_code": ts_code,
            "trade_date": "",
            "start_date": start_date,
            "end_date": end_date,
            "offset": "",
            "limit": ""
        }, fields=fields)
        tableName = ts_code + '_daily'
        fields[2] = '_open'
        fields[7] = '_change'
        data.rename(columns={'open':'_open'},inplace=True)
        data.rename(columns={'change':'_change'},inplace=True)
        into_db_new(tableName,fields,data)
        fields[2] = 'open'
        fields[7] = 'change'
        time.sleep(1)

    conn.close()

#获取当前时间日行情数据（所有股票）
def  daily_today():
    conn = datasource.get_ds()
    cu = conn.cursor()
    cu.execute("SELECT ts_code FROM stock_basic")
    # trade_date = '20230228'
    trade_date = time.strftime("%Y%m%d")
    fields=[
            "ts_code",
            "trade_date",
            "open",
            "high",
            "low",
            "close",
            "pre_close",
            "change",
            "pct_chg",
            "vol",
            "amount"
        ]
    for row in cu:
        ts_code = row['ts_code']
        data = pro.daily(**{
            "ts_code": ts_code,
            "trade_date": trade_date,
            "offset": "",
            "limit": ""
        }, fields=fields)
        tableName = ts_code + '_daily'
        fields[2] = '_open'
        fields[7] = '_change'
        data.rename(columns={'open':'_open'},inplace=True)
        data.rename(columns={'change':'_change'},inplace=True)
        sqlutil.create_table(conn,tableName,fields)
        sqlutil.insert_data(conn,tableName,data)
        fields[2] = 'open'
        fields[7] = 'change'
        time.sleep(1)

    conn.close()
