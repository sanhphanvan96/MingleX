import MySQLdb
import time
def try_to_connect():
    print("Trying to connect minglex-mysql.")
    try:
        connection = MySQLdb.connect(
                host = 'minglex-mysql',
                user = 'root',
                passwd = '1')
        cursor = connection.cursor()
        cursor.execute("USE minglexdb")
    except Exception, e:
        print str(e)
        time.sleep(5)
        try_to_connect()

try_to_connect()