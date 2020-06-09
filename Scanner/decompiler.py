# 反编译APK文件

import subprocess


def decompile(filepath):
    # 使用Apktool

    print('4. Apktool: Geting the resources and smali code...')
    cmd_1 = 'java -jar tools/apktool.jar d ' + filepath + ' -o apktool_unzip'
    res = subprocess.run(cmd_1, bufsize=0, stdout=subprocess.PIPE, shell=True)
    if res.returncode == 1:
        print('4. Apktool executes error')
        exit()

    # 使用enjarify
    print('5. Enjarify: Transfering apk to jar...')
    cmd_2 = 'python3 -O -m tools.enjarify.enjarify.main ' + filepath + ' -o apk_enjarify.jar'
    res = subprocess.run(cmd_2, bufsize=0, stdout=subprocess.PIPE, shell=True)
    if res.returncode == 1:
        print('5. Enjarify executes error')
        exit()

    # 使用procyon
    print('6. Procyon: Decompiling jar to java code...')
    cmd_3 = 'java -jar tools/procyon.jar apk_enjarify.jar -o procyon_decompile_java'
    res = subprocess.run(cmd_3, bufsize=0, stdout=subprocess.PIPE, shell=True)
    if res.returncode == 1:
        print('6. Procyon executes error')
        exit()

