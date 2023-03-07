import pymysql

config = {
    'host': '127.0.0.1',
    'port': 3306,
    'user': 'root',
    'password': 'root@123456',
    'db': 'stock',
    'charset': 'utf8mb4',
    'cursorclass': pymysql.cursors.DictCursor,
}

#获取数据源
def get_ds():
    conn = pymysql.connect(**config)
    return conn

