# coding:utf-8
import os
import subprocess
import re


def recompile_TuokeApk_Project(application_name):

    """
    1.修改 String appClassName = "com.targetapk.MyApplication";
    2.重新编译
    """

    file_path = 'TuokeApk/app/src/main/java/org/hackcode/ProxyApplication.java'
    new_file_path = 'TuokeApk/app/src/main/java/org/hackcode/ProxyApplication2.java'
    file_in = open(file_path)
    file_out = open(new_file_path, 'w')
    while 1:
        line = file_in.readline()
        if not line:
            break
        pattern = re.compile(r'.*String.*appClassName.*=.*\".*\";.*')
        if re.search(pattern, line):
            print '[+] Find \"String appClassName = ...\", replace it with \"' + application_name + '\"'
            file_out.write('\t\t\tString appClassName = \"' + application_name + '\";\n')
        else:
            file_out.write(line)
    file_in.close()
    file_out.close()

    os.remove(file_path)
    os.rename(new_file_path, file_path)

    # 重新编译TuokeApk工程
    os.chdir('TuokeApk/')

    print '[+] Gradle clean waiting...'
    subprocess.Popen(["gradle", "clean"], shell=True, stdout=subprocess.PIPE).stdout.read()
    print '[+] Gradle build waiting...'
    out = subprocess.Popen(["gradle", "build"], shell=True, stdout=subprocess.PIPE).stdout.read()
    if out.find('BUILD SUCCESSFUL') < 0:
        print 'Build error!'
        return False
    print '[+] Rebuild TuokeApk project successfully!'
    os.chdir('../')

    return True
