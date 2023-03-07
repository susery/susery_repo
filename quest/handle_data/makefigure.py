import  os
import  sys

BASE_DIR = os.path.dirname(os.path.dirname( os.path.abspath(__file__) ))
sys.path.append(BASE_DIR )

import mplfinance as mpf
import pandas as pd
import numpy as np
import warnings
from db import datasource
warnings.filterwarnings('ignore')

# 通过数据库查询数据 组合画图
def go_makefigure(ts_code,start_date,end_date):
    conn = datasource.get_ds()
    cu = conn.cursor()
    table = ts_code +'_daily'
    sql = "SELECT * FROM `%s` t where t.trade_date BETWEEN \"%s\" AND \"%s\" ORDER BY t.trade_date" % (table,start_date,end_date)
    cu.execute(sql)

    figure(cu,5,21)
    conn.close()


# 画图逻辑 df为数据 ， short为短线值  long为长线值
def figure(df,short,long):
    df = pd.DataFrame(df)
    df.rename(columns={'_open': 'Open','close': 'Close','high': 'High','low': 'Low','vol': 'Volume'}, inplace=True)
    df1=df[['Open','Close','High','Low','Volume','trade_date']]
    df1['Open'] = pd.to_numeric(df1['Open'])
    df1['Close'] = pd.to_numeric(df1['Close'])
    df1['High'] = pd.to_numeric(df1['High'])
    df1['Low'] = pd.to_numeric(df1['Low'])
    df1['Volume'] = pd.to_numeric(df1['Volume'])
    df1['trade_date']=pd.to_datetime(df1['trade_date'])
    df1.set_index("trade_date", inplace=True)

    df1['short_ma']=None
    df1['long_ma']=None

    for i in df1['Close'].iteritems():
        df1['short_ma']=df1['Close'].rolling(short).mean()
        df1['long_ma']=df1['Close'].rolling(long).mean()
    df1['up_cross']=np.nan
    df1['down_cross']=np.nan

    for i in range(len(df1['Close'])):
        if df1['short_ma'][i]>df1['long_ma'][i] and df1['short_ma'][i-1]<df1['long_ma'][i-1]:
            df1['up_cross'][i]=df1['short_ma'][i] 
        if df1['short_ma'][i]<df1['long_ma'][i] and df1['short_ma'][i-1]>df1['long_ma'][i-1]:
            df1['down_cross'][i]=df1['short_ma'][i]  

    add_plot = [
        mpf.make_addplot(df1['up_cross'], scatter=True, markersize=50, marker='^', color='g'),
        mpf.make_addplot(df1['down_cross'], scatter=True, markersize=50, marker='v', color='r'),
    ]

    mpf_style=mpf.available_styles() 
    mpf.plot(df1, addplot=add_plot, type='candle',mav=(short,long),style=mpf_style[11], show_nontrading=False)





