# coding:utf-8

import os
import shutil
import subprocess


def remove_without_exception(item, mode):
    if mode == 'd':
        try:
            shutil.rmtree(item)
        except Exception as e:
            pass
    else:
        try:
            os.remove(item)
        except Exception as e:
            pass


def clean_project_files():
    remove_without_exception('Target', 'd')
    remove_without_exception('Target.modified.apk_files', 'd')
    remove_without_exception('Target.apk', 'f')
    remove_without_exception('Target.modified.apk', 'f')
    remove_without_exception('Target.modified.2.apk', 'f')
    remove_without_exception('classes.dex', 'f')
    remove_without_exception('TargetApk.zip', 'f')
    remove_without_exception('tuoke.dex', 'f')

    os.chdir('TuokeApk/')
    print '[+] Gradle clean waiting...'
    subprocess.Popen(["gradle", "clean"], shell=True, stdout=subprocess.PIPE).stdout.read()
    os.chdir('../')