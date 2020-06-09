import pymysql
import math


# 打开数据库连接
def connect_db():
    db = pymysql.connect("localhost", "root", "25506216", "annhub")
    return db


# 关闭数据库连接
def close_db(db):
    db.close()


# SQL 查询语句
# 使用百分号 -> 字符串拼接
# 使用逗号 -> 参数化查询
# 注意此处的占位符统统是%s字符串类型，不再区分字符串，数字或者其他类型，另外%s不能加引号
# 使用逗号，变量是作为execute的参数传入的，由MySQLdb的内置方法把变量解释成合适的内容
# 使用百分号%则是用Python编译器对%s执行相应的替代
# 使用百分号%这种方法是有漏洞的，有些时候（比如包含某些特殊字符的时候）不能正常解析
# 甚至会有注入漏洞。一般情况下都要把变量作为execute的参数传入。
def insert_into_db(db, apk_name, identity, result, level, num):
    # 使用 cursor() 方法创建一个游标对象 cursor
    cursor = db.cursor()
    sql_1 = "select apk_id from apk where apk_name = %s"
    param_1 = apk_name
    try:
        cursor.execute(sql_1, param_1)
        # 获取一行的结果
        row = cursor.fetchone()
        apk_id = row[0]
    except pymysql.DatabaseError:
        print("SQL_1 select error")
    else:
        sql_2 = "select count from report where apk_id = %s and identity = %s"
        param_2 = (apk_id, identity)
        try:
            cursor.execute(sql_2, param_2)
            num_rows = cursor.rowcount
            print("num_rows = %d" % num_rows)
        except pymysql.DatabaseError:
            print("SQL_2 select error")
        else:
            if num_rows == 0:
                # 没有查询到扫描结果才执行数据的插入操作
                sql_3 = "insert into report(apk_id, identity, result, level, num) values(%s, %s, %s, %s, %s)"
                param_3 = (apk_id, identity, result, level, num)
                try:
                    cursor.execute(sql_3, param_3)
                    db.commit()
                    print("insert successfully: apk_id = %d, identity = %s" % (apk_id, identity))
                except pymysql.DatabaseError:
                    db.rollback()
                    print("SQL_3 Insert Error")
            else:
                print("scanned result has already existed")
                # 扫描结果存在的情况下则尝试进行结果的更新操作

                sql_4 = "update report set result = %s, level = %s, num = %s where apk_id = %s and identity = %s"
                param_4 = (result, level, num, apk_id, identity)
                try:
                    cursor.execute(sql_4, param_4)
                    db.commit()
                    print("update successfully: apk_id = %d, identify = %s" % (apk_id, identity))
                except pymysql.DatabaseError:
                    db.rollback()
                    print("SQL_4 update error")


def get_apk_id(db, apk_name):
    cursor = db.cursor()
    sql = "select apk_id from apk where apk_name = %s"
    try:
        cursor.execute(sql, apk_name)
        # 获取一行的结果
        row = cursor.fetchone()
        apk_id = row[0]
    except pymysql.DatabaseError:
        print("SQL get_apk_id select error")
    else:
        return apk_id


def get_user_id(db, apk_name):
    cursor = db.cursor()
    sql = "select user_id from apk where apk_name = %s"
    try:
        cursor.execute(sql, apk_name)
        # 获取一行的结果
        row = cursor.fetchone()
        user_id = row[0]
    except pymysql.DatabaseError:
        print("SQL get_user_id select error")
    else:
        return user_id


def get_leak_num(db, apk_id, level):
    cursor = db.cursor()
    sql = "select count from report where apk_id = %s and level = %s"
    param = (apk_id, level)
    try:
        cursor.execute(sql, param)
        leak_num = cursor.rowcount
    except pymysql.DatabaseError:
        print("SQL get_leak_num level = %s select error" % level)
    else:
        return leak_num


def update_table_apk(db, high_num, middle_num, low_num, warning_num, total_num, score, level, apk_id):
    cursor = db.cursor()
    # 更新apk表的信息
    sql = "update apk set " \
          "high = %s, middle = %s, low = %s, warning = %s, total = %s, score = %s, level = %s " \
          "where apk_id = %s"
    param = (high_num, middle_num, low_num, warning_num, total_num, score, level, apk_id)
    print("Table apk: "
          "high = %s, middle = %s, low = %s, warning = %s, total = %s, score = %s, level = %s, apk_id = %s"
          % param)
    try:
        cursor.execute(sql, param)
        db.commit()
        print("SQL update_table_apk update successfully")
    except pymysql.DatabaseError:
        db.rollback()
        print("SQL update_table_apk update error")


def get_scanned_flag(db, apk_id):
    cursor = db.cursor()
    sql = "select scanned from apk where apk_id = %s"
    try:
        cursor.execute(sql, apk_id)
        row = cursor.fetchone()
        scanned_flag = row[0]
        print("scanned_flag = %s" % scanned_flag)
    except pymysql.DatabaseError:
        print("SQL get_scanned_flag select error")
    else:
        return scanned_flag


def get_pre_scanned_data(db, user_id):
    cursor = db.cursor()
    # 获取拥有该应用的用户的已扫描应用数，和漏洞总数
    sql = "select file_scan_num, file_leak_num from user where user_id = %s"
    try:
        cursor.execute(sql, user_id)
        row = cursor.fetchone()
        file_scan_num = row[0]
        file_leak_num = row[1]
        print("file_scan_num = %s, file_leak_num = %s" % (file_scan_num, file_leak_num))
    except pymysql.DatabaseError:
        print("SQL get_pre_scanned_data select error")
    else:
        return {'file_scan_num': file_scan_num, 'file_leak_num': file_leak_num}


def update_table_user_and_scanned_flag(db, file_scan_num, file_leak_num, total_num, apk_id, user_id):
    cursor = db.cursor()
    # 更新user表的信息
    sql_1 = "update user " \
            "set file_scan_num = %s, file_leak_num = %s " \
            "where user_id = %s"
    param_1 = (file_scan_num, file_leak_num, user_id)
    try:
        cursor.execute(sql_1, param_1)
        db.commit()
        print("Table user: file_scan_num = %s, file_leak_num = %s"
              % (file_scan_num, file_leak_num))
    except pymysql.DatabaseError:
        db.rollback()
        print("SQL update_table_user update error")
    else:
        sql_2 = "update apk set scanned = 1 where apk_id = %s"
        try:
            cursor.execute(sql_2, apk_id)
            db.commit()
            print("scanned --> 1")
        except pymysql.DatabaseError:
            db.rollback()
            print("SQL update scanned flag update error")
