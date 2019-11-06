import pymysql
import parse_xls
import config

data_path = config.data_path 

# MySQL Connection 연결
conn = pymysql.connect(host=config.db_host, port=config.db_host, user=config.db_user, password=config.db_password,
                       db=config.db_database, charset='utf8')
 
curs = conn.cursor()
sql = """insert into toilet(id, name, location_x, location_y, state, address, type, telephone, time, handicapped, diaper, bell)
         values (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)"""

        
data_list = parse_xls.get_data_list(data_path)

for data in data_list :
    curs.execute(sql, (data["id"], data["name"], data["location_x"], data["location_y"], data["state"], data["address"], data["type"], data["telephone"], data["time"], data["handicapped"], data["diaper"], data["bell"]))

conn.commit()
conn.close()