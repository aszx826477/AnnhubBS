# 统计扫描后的数据，如高危、中危、低危、提醒漏洞的数量等，更新到数据库中

import mysql
import re
import math


def data_analyse(src_path):
    db = mysql.connect_db()
    file_name_obj = re.search(r'apk_sources/(.*?\.apk)', src_path, re.M)
    file_name = file_name_obj.group(1)
    # mysql.analyse_data_and_insert(db, file_name)

    apk_id = mysql.get_apk_id(db, file_name)
    print("apk_id = %d" % apk_id)
    user_id = mysql.get_user_id(db, file_name)
    print("user_id = %d" % user_id)

    high_num = mysql.get_leak_num(db, apk_id, 3)
    middle_num = mysql.get_leak_num(db, apk_id, 2)
    low_num = mysql.get_leak_num(db, apk_id, 1)
    warning_num = mysql.get_leak_num(db, apk_id, 0)
    # 计算漏洞的总数量
    total_num = high_num + middle_num + low_num + warning_num
    # 计算分数
    # score_weight = 8 * 0 + 4 * 1 + 2 * 0 + 2
    score_weight = 8 * high_num + 4 * middle_num + 2 * middle_num + warning_num
    score = math.floor(0.985 ** score_weight * 100)
    # 判断应用的安全等级
    if 90 < score < 100:
        level = -1  # 安全
    elif score > 70:
        level = 0  # 合格
    elif score > 50:
        level = 1  # 警告
    else:
        level = 2  # 危险
    mysql.update_table_apk(db, high_num, middle_num, low_num, warning_num, total_num, score, level, apk_id)
    scanned_flag = mysql.get_scanned_flag(db, apk_id)
    if scanned_flag == 0:
        res = mysql.get_pre_scanned_data(db, user_id)
        file_scan_num = res['file_scan_num'] + 1
        file_leak_num = res['file_leak_num'] + total_num
        mysql.update_table_user_and_scanned_flag(db, file_scan_num, file_leak_num, total_num, apk_id, user_id)
