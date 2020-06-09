.class public Lorg/hackcode/ProxyApplication;
.super Landroid/app/Application;
.source "ProxyApplication.java"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-string v0, "hackcodejiagu"

    .line 17
    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 14
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    return-void
.end method

.method private native start(Landroid/app/Application;Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Object;)V
.end method


# virtual methods
.method public attachBaseContext(Landroid/content/Context;)V
    .locals 4

    .line 136
    invoke-super {p0, p1}, Landroid/app/Application;->attachBaseContext(Landroid/content/Context;)V

    const-string v0, "demo"

    const-string v1, "[JiaguApk]=>attachBaseContext() start..."

    .line 138
    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :try_start_0
    const-string v0, "android.app.ActivityThread"

    const-string v1, "currentActivityThread"

    const/4 v2, 0x0

    .line 142
    new-array v3, v2, [Ljava/lang/Class;

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v3, v2}, Lorg/hackcode/ReflectUtils;->invokeStaticMethod(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 143
    invoke-virtual {p0}, Lorg/hackcode/ProxyApplication;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const-string v2, "android.app.ActivityThread"

    const-string v3, "mPackages"

    .line 144
    invoke-static {v2, v0, v3}, Lorg/hackcode/ReflectUtils;->getFieldObject(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 145
    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/ref/WeakReference;

    .line 147
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "/data/data/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "/lib"

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Landroid/content/Context;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/ClassLoader;->getParent()Ljava/lang/ClassLoader;

    move-result-object p1

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    invoke-direct {p0, p0, v1, p1, v0}, Lorg/hackcode/ProxyApplication;->start(Landroid/app/Application;Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p1

    const-string v0, "demo"

    .line 150
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "[JiaguApk]=>attachBaseContext() "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {p1}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v0, p1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :goto_0
    const-string p1, "demo"

    const-string v0, "[JiaguApk]=>attachBaseContext() end..."

    .line 154
    invoke-static {p1, v0}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method

.method public bytesToHexString([B)Ljava/lang/String;
    .locals 6

    .line 21
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, ""

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    if-eqz p1, :cond_3

    .line 22
    array-length v1, p1

    if-gtz v1, :cond_0

    goto :goto_1

    :cond_0
    const/4 v1, 0x0

    move v2, v1

    .line 25
    :goto_0
    array-length v3, p1

    if-ge v2, v3, :cond_2

    .line 26
    aget-byte v3, p1, v2

    and-int/lit16 v3, v3, 0xff

    .line 27
    invoke-static {v3}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v3

    .line 28
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v4

    const/4 v5, 0x2

    if-ge v4, v5, :cond_1

    .line 29
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 31
    :cond_1
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 33
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_3
    :goto_1
    const/4 p1, 0x0

    return-object p1
.end method

.method public onCreate()V
    .locals 10

    const/4 v0, 0x1

    :try_start_0
    const-string v1, "org.litepal.LitePalApplication"

    const-string v2, "android.app.ActivityThread"

    const-string v3, "currentActivityThread"

    const/4 v4, 0x0

    .line 45
    new-array v5, v4, [Ljava/lang/Class;

    new-array v6, v4, [Ljava/lang/Object;

    invoke-static {v2, v3, v5, v6}, Lorg/hackcode/ReflectUtils;->invokeStaticMethod(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    const-string v3, "android.app.ActivityThread"

    const-string v5, "mBoundApplication"

    .line 52
    invoke-static {v3, v2, v5}, Lorg/hackcode/ReflectUtils;->getFieldObject(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    const-string v5, "android.app.ActivityThread$AppBindData"

    const-string v6, "info"

    .line 58
    invoke-static {v5, v3, v6}, Lorg/hackcode/ReflectUtils;->getFieldObject(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    if-nez v5, :cond_0

    const-string v6, "demo"

    const-string v7, "[JiaguApk]=>onCreate()=>loadedApkInfo is null!!!"

    .line 62
    invoke-static {v6, v7}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    :cond_0
    const-string v6, "demo"

    .line 64
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "[JiaguApk]=>onCreate()=>loadedApkInfo:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :goto_0
    const-string v6, "android.app.LoadedApk"

    const-string v7, "mApplication"

    const/4 v8, 0x0

    .line 70
    invoke-static {v6, v7, v5, v8}, Lorg/hackcode/ReflectUtils;->setFieldObject(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    const-string v6, "android.app.ActivityThread"

    const-string v7, "mInitialApplication"

    .line 77
    invoke-static {v6, v2, v7}, Lorg/hackcode/ReflectUtils;->getFieldObject(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    const-string v7, "android.app.ActivityThread"

    const-string v9, "mAllApplications"

    .line 87
    invoke-static {v7, v2, v9}, Lorg/hackcode/ReflectUtils;->getFieldObject(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/ArrayList;

    .line 91
    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    const-string v6, "android.app.LoadedApk"

    const-string v7, "mApplicationInfo"

    .line 97
    invoke-static {v6, v5, v7}, Lorg/hackcode/ReflectUtils;->getFieldObject(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/pm/ApplicationInfo;

    const-string v7, "android.app.ActivityThread$AppBindData"

    const-string v9, "appInfo"

    .line 104
    invoke-static {v7, v3, v9}, Lorg/hackcode/ReflectUtils;->getFieldObject(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/pm/ApplicationInfo;

    .line 108
    iput-object v1, v6, Landroid/content/pm/ApplicationInfo;->className:Ljava/lang/String;

    .line 109
    iput-object v1, v3, Landroid/content/pm/ApplicationInfo;->className:Ljava/lang/String;

    const-string v1, "android.app.LoadedApk"

    const-string v3, "makeApplication"

    const/4 v6, 0x2

    .line 114
    new-array v7, v6, [Ljava/lang/Class;

    sget-object v9, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v9, v7, v4

    const-class v9, Landroid/app/Instrumentation;

    aput-object v9, v7, v0

    new-array v6, v6, [Ljava/lang/Object;

    .line 117
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    aput-object v9, v6, v4

    aput-object v8, v6, v0

    .line 114
    invoke-static {v1, v3, v5, v7, v6}, Lorg/hackcode/ReflectUtils;->invokeMethod(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/Application;

    const-string v3, "android.app.ActivityThread"

    const-string v4, "mInitialApplication"

    .line 118
    invoke-static {v3, v4, v2, v1}, Lorg/hackcode/ReflectUtils;->setFieldObject(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    if-nez v1, :cond_1

    const-string v1, "demo"

    const-string v2, "[JiaguApk]=>onCreate()=>app is null!!!"

    .line 121
    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 123
    :cond_1
    invoke-virtual {v1}, Landroid/app/Application;->onCreate()V

    const-string v1, "demo"

    const-string v2, "[JiaguApk]=>onCreate() success!"

    .line 124
    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception v1

    const-string v2, "demo"

    .line 127
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[JiaguApk]=>onCreate() "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {v1}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :goto_1
    const-string v1, "Enforced by 01hackcode"

    .line 129
    invoke-static {p0, v1, v0}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    return-void
.end method
