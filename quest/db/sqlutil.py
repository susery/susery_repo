# 根据表名及字段信息建表
def create_table(conn,tableName,fields):
    cu = conn.cursor()
    sql =  'CREATE TABLE IF NOT EXISTS `%s`(' % tableName
    with conn.cursor() as cu:
        for i in range(len(fields)):

            if i == (len(fields)-1):
                sql += '%s varchar(150));' % fields[i]
            else:
                sql += '%s varchar(150),' % fields[i]

        print(sql)
        cu.execute(sql)



# 根据表名及数据信息新增
def insert_data(conn,tableName,data):
    vs = data.values
    cols = data.columns
    with conn.cursor() as cu:
        for row in vs:
            sql_str = "insert into `%s`(" % tableName
            for c in range(len(cols)):
                sql_str += str(cols[c]) 
                if c != (len(cols)-1):
                    sql_str += ','
                else:
                    sql_str+=')'
            sql_str+='values('
            for i in range(len(cols)):
                sql_str+='\''+str(row[i])+'\''
                if i != (len(cols)-1):
                    sql_str+=','
                else:
                    sql_str+=');'
            print(sql_str)
            cu.execute(sql_str)

    conn.commit()
