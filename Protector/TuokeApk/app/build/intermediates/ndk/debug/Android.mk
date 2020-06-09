LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := hackcodejiagu
LOCAL_LDFLAGS := -Wl,--build-id
LOCAL_SRC_FILES := \
	/home/yelbee/Documents/apk-auto-enforce/TuokeApk/app/src/main/jni/Android.mk \
	/home/yelbee/Documents/apk-auto-enforce/TuokeApk/app/src/main/jni/hackcodejiagu.c \
	/home/yelbee/Documents/apk-auto-enforce/TuokeApk/app/src/main/jni/Application.mk \

LOCAL_C_INCLUDES += /home/yelbee/Documents/apk-auto-enforce/TuokeApk/app/src/main/jni
LOCAL_C_INCLUDES += /home/yelbee/Documents/apk-auto-enforce/TuokeApk/app/src/debug/jni

include $(BUILD_SHARED_LIBRARY)
