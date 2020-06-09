# coding:utf-8
import os
import zipfile
import random
import shutil
import string
from elf_header import ELF


def unzip(file_name):
    zip_file = zipfile.ZipFile(file_name)
    if os.path.isdir(file_name + "_files"):
        pass
    else:
        os.mkdir(file_name + "_files")
    for names in zip_file.namelist():
        zip_file.extract(names, file_name + "_files/")
    zip_file.close()
    return file_name + "_files"


def zip_dir(dir_name, zip_file_name):
    file_list = []
    if os.path.isfile(dir_name):
        file_list.append(dir_name)
    else:
        for root, dirs, files in os.walk(dir_name):
            for name in files:
                file_list.append(os.path.join(root, name))

    zf = zipfile.ZipFile(zip_file_name, "w", zipfile.zlib.DEFLATED)
    for tar in file_list:
        arc_name = tar[len(dir_name):]
        zf.write(tar, arc_name)
    zf.close()


def genRandomStr(length):
    chars = string.ascii_letters+string.digits
    return ''.join([random.choice(chars) for i in range(length)])  # 得出的结果中字符会有重复的


def modify_ehdr_and_delete_shdr(apk_dir):
    """
    修改ELF header(e_shoff和e_shnum属性)和删除section header table
    TODO: 指定目标so文件
    """
    for root, dirs, files in os.walk(apk_dir):
        for name in files:
            filepath = root + os.path.sep + name
            if filepath.endswith('libhackcodejiagu.so'):
                print('   - Modifying \"', filepath, '\" ELF header...')
                dex = ELF(filepath)
                file_size = os.path.getsize(filepath)
                shdr_offset = dex.elf32_Ehdr.e_shoff
                shdr_size = dex.elf32_Ehdr.e_shnum * dex.elf32_Ehdr.e_shentsize

                src_file = file(filepath, 'rb')
                dst_file = file(filepath + '2', 'wb')
                # 1.破坏ELF Header
                dst_file.write(src_file.read(32))  # 保存e_shoff之前的内容
                src_file.read(4)
                dst_file.write(genRandomStr(4))  # 修复e_shoff

                dst_file.write(src_file.read(12))  # 保存e_shoff到e_shnum之间的内容
                src_file.read(2)
                dst_file.write(genRandomStr(2))  # 修复e_shnum

                # 2.删除section header table
                # 读取section header table之前的内容
                dst_file.write(src_file.read(shdr_offset - 50))

                # 读取section header table之后的内容
                src_file.seek(shdr_offset + shdr_size, 0)
                dst_file.write(src_file.read())

                src_file.close()
                dst_file.close()

                shutil.move(filepath + '2', filepath)
