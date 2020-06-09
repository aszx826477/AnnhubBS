# coding:utf-8
import subprocess
import shutil
from xml.dom import minidom
import zipfile 
import os
import sys
import codecs
import time
import cleaner
import utils
import recompiler
import config


'''
一、针对目标app不存在自定义application的情况
    1.反编译目标app
        (Windows)    apktool.bat d Target.apk
        (Linux)      java jar apktool.jar d Target.apk 
    2.检测manifest文件是否有自定义的Application，并假设没有自定义Application
    3.如果没有自定义Application，则复制smali文件夹，跟反编译后的app下的smali合并: cp -rf smali Target/
    4.修改manifest文件，将自定义Application设定为“org.hackcode.ProxyApplication”
    5.重打包目标app
    6.提取重打包后的apk中的classes.dex文件，并压缩为TargetApk.zip文件，并将重打包的app命名为Target.modified.apk
    7.合并TuokeApk项目下的classes.dex和TargetApk.zip(加固),生成classes.dex
    8.将合并生成的新classes.dex文件与Target.modified.apk中的classes.dex替换
    9.复制TuokeApk项目下的lib目录下的所有文件和文件夹到目标app中
    10.将修改后的app重压缩成zip文件
    11.签名
'''


def main(filepath=None):
    cleaner.clean_project_files()
    if filepath:
        input_filename = filepath
    else:
        input_filename = sys.argv[1]
    shutil.copyfile(input_filename, 'Target.apk')

    # Step1: 反编译目标app
    print '[+] Apktool decompile'
    out = subprocess.Popen('java -jar tools/apktool.jar d Target.apk', stdout=subprocess.PIPE, shell=True).stdout.read()
    if out.find('error') > 0 or out.find('exception') > 0:
        print '[Error] apktool decompiled error!'
        return
    print '[+] Apktool decompiled Target.apk successfully!'

    # Step2: 检测manifest文件是否有自定义的Application
    doc = minidom.parse('Target/AndroidManifest.xml')
    root = doc.documentElement
    application_node = root.getElementsByTagName('application')[0]
    applicationName = application_node.getAttribute('android:name')

    packageName = root.getAttribute('package')
    if applicationName:
        if not applicationName.startswith(packageName) and applicationName.startswith('.'):
            applicationName = packageName + applicationName
        print '[+] Target app\'s Application: ', applicationName
        # Step3: 修改JiguApk工程中ProxyApplication中的applicationName变量为目标app的Application名称
        recompiler.recompile_TuokeApk_Project(applicationName)
    else:
        print '[+] Target.apk has no self-defined Application!'
        applicationName = 'com.targetapk.MyApplication'
        recompile_TuokeApk_Project(applicationName)
        # Step3: 复制smali文件夹，跟反编译后的app下的smali合并
        print '[+] Copy smali folder into Target folder...'
        out = subprocess.Popen('cp -rf smali Target/', stdout=subprocess.PIPE).stdout.read()

    # Step4: 修改manifest文件，将自定义Application设定为“org.hackcode.ProxyApplication”
    print '[+] Modified AndroidManifest.xml...'
    application_node.setAttribute('android:name', 'org.hackcode.ProxyApplication')
    file_handle = codecs.open('%s/Target/AndroidManifest.xml' % config.WORK_DIR, 'w', 'utf-8')
    root.writexml(file_handle)
    file_handle.close()

    # Step5: 重打包目标app
    print '[+] Apktool build Target'
    out = subprocess.Popen('java -jar tools/apktool.jar b Target', stdout=subprocess.PIPE, shell=True).stdout.read()

    if out.find('error') > 0 or out.find('exception') > 0:
        print '[Error] apktool recompiled error!'
        return
    print '[+] Apktool recompiled Target successfully!'

    # Step6: 将重打包的app命名为Target.modified.apk,并提取重打包后的apk中的classes.dex文件，并压缩为TargetApk.zip文件
    print '[+] Rename target app: \"Target.modified.apk\"'
    shutil.copyfile('%s/Target/dist/Target.apk' % config.WORK_DIR, 'Target.modified.apk')
    extracted_dir = utils.unzip('Target.modified.apk')

    print '[+] Extracted classes.dex from Target.modifed.apk into TargetApk.zip'
    shutil.copyfile(extracted_dir + '/classes.dex', 'classes.dex')
    
    # 写入classes.dex
    f = zipfile.ZipFile('TargetApk.zip', 'w', zipfile.ZIP_DEFLATED)
    f.write('classes.dex')
    f.close()
    os.remove('classes.dex')
    
    # Step7: 合并TuokeApk/bin/classes.dex和TargetApk.zip(加固),生成classes.dex
    shutil.copyfile('TuokeApk/app/build/intermediates/transforms/dexMerger/release/0/classes.dex', 'tuoke.dex')
    subprocess.Popen(
        'java -jar tools/JiaguApk.jar tuoke.dex TargetApk.zip',
        stdout=subprocess.PIPE,
        shell=True).stdout.read()

    # Step8: 将合并生成的新classes.dex文件与Target.modified.apk中的classes.dex替换
    print '[+] Replace \"%s\" with \"classes.dex\"' % (extracted_dir + '/classes.dex', )
    shutil.copyfile('classes.dex', extracted_dir + '/classes.dex')

    # Step9: 复制TuokeApk/libs目录下的所有文件和文件夹到目标app中
    print('[+] Copying TuokeApk/app/build/intermediates/ndk/release/lib/...')
    if not os.path.exists(extracted_dir + '/lib/'):
        os.mkdir(extracted_dir + '/lib/')
        for item in os.listdir('TuokeApk/app/build/intermediates/ndk/release/lib/'):
            if not os.path.exists(extracted_dir + '/lib/' + item):
                shutil.copytree('TuokeApk/app/build/intermediates/ndk/release/lib/' + item, extracted_dir + '/lib/' + item)
            else:
                shutil.copyfile(
                    'TuokeApk/app/build/intermediates/ndk/release/lib/' + item + '/libhackcodejiagu.so',
                    extracted_dir + '/lib/' +
                    item +
                    '/libhackcodejiagu.so')
    else:
        for item in os.listdir(extracted_dir + '/lib/'):
            shutil.copyfile(
                'TuokeApk/app/build/intermediates/ndk/release/lib/' + item + '/libhackcodejiagu.so',
                extracted_dir + '/lib/' + item + '/libhackcodejiagu.so')

    # 破坏SO文件的ELF头部（删除 ELF header）
    utils.modify_ehdr_and_delete_shdr(extracted_dir)

    # Step10: 将修改后的app重压缩成zip文件
    print '[+] Compress %s folder into Target.modified.2.apk' % extracted_dir
    utils.zip_dir(extracted_dir, 'Target.modified.2.apk')

    # Step11: 签名
    print '[+] Signning...'
    # input_filename = 'weather.apk'
    output_filename = input_filename[:input_filename.rfind('apk')] + 'signed.apk'
    out = subprocess.Popen(
        'java -jar tools/signapk.jar tools/testkey.x509.pem tools/testkey.pk8 Target.modified.2.apk ' + output_filename,
        stdout=subprocess.PIPE,
        shell=True).stdout.read()
    cleaner.clean_project_files()


if __name__ == '__main__':
    start = time.time()
    main()
    end = time.time()
    print("Total time running %s seconds" %(str(end - start)))
    
     

    
    










