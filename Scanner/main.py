import utils
import os
import decompiler
import scanner
import constant

file_list = []

for files in os.walk(constant.APK_SOURCES_DIR):
    file_list = files[2]  # get a apk name list

for i in range(0, file_list.__len__(), 1):
    file_name = file_list[i]
    src_path = constant.APK_SOURCES_DIR + file_name
    file_md5 = utils.get_file_md5(src_path)

    file_size = os.path.getsize(src_path)
    file_size /= float(1024 * 1024)
    file_size = round(file_size, 2)
    print('1. file_md5: ' + file_md5)
    print('2. file_name: ' + file_name)
    print('3. file_size: ' + str(file_size) + 'MB')
    dst_path = constant.OUTCOMES_DIR + file_md5 + '/'

    try:
        utils.make_dir(dst_path)
    except OSError:
        print('3. The Num.' + str(i) + ' apk workspace has existed')
    else:
        print('>> The Num.' + str(i) + ' workspace is been created in outcomes successfully')
        decompiler.decompile(src_path)
        utils.remove_file_or_dir('apktool_unzip', dst_path)
        utils.remove_file_or_dir('apk_enjarify.jar', dst_path)
        utils.remove_file_or_dir('procyon_decompile_java/', dst_path)
        print('7. Scanner: Begin static analysis...')

        src_path = constant.APK_SOURCES_DIR + file_name
        dst_path = constant.OUTCOMES_DIR + file_md5 + '/'
        # scanner.do_static_scan(src_path, dst_path)
        # scanner.do_dynamic_scan(src_path, dst_path)
        # print('------The Num.' + str(i) + ' apk scanning finishes------\n')
