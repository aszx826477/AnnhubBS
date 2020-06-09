# Utils模块提供一些通用的函数方法，以便更好在开发中进行复用

import shutil
import os
import hashlib

FILE_SLIM = (100*1024*1024)  # 100MB


def make_dir(dirpath):
    os.mkdir(dirpath)


def remove_file_or_dir(src, dst):
    shutil.move(src, dst)


def get_file_md5(filepath):
    hmd5 = hashlib.md5()
    fp = open(filepath, "rb")
    f_size = os.stat(filepath).st_size
    # If the file size > 100MB, it will use patch-read method to calculate MD5
    if f_size > FILE_SLIM:
        while f_size > FILE_SLIM:
            hmd5.update(fp.read(FILE_SLIM))
            f_size /= FILE_SLIM

            if (f_size > 0)and (f_size <= FILE_SLIM):
                hmd5.update(fp.read())
            else:
                hmd5.update(fp.read())
    else:
        hmd5 = hashlib.md5(fp.read())

    fp.close()
    return hmd5.hexdigest()
