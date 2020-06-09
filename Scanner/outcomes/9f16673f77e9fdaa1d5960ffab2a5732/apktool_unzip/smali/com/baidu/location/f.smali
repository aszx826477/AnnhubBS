.class public Lcom/baidu/location/f;
.super Landroid/app/Service;


# static fields
.field public static isServing:Z

.field public static isStartedServing:Z

.field public static mC:Landroid/content/Context;

.field public static replaceFileName:Ljava/lang/String;


# instance fields
.field a:Lcom/baidu/location/LLSInterface;

.field b:Lcom/baidu/location/LLSInterface;

.field c:Lcom/baidu/location/LLSInterface;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-string v0, "repll.jar"

    sput-object v0, Lcom/baidu/location/f;->replaceFileName:Ljava/lang/String;

    const/4 v0, 0x0

    sput-object v0, Lcom/baidu/location/f;->mC:Landroid/content/Context;

    const/4 v0, 0x0

    sput-boolean v0, Lcom/baidu/location/f;->isServing:Z

    sput-boolean v0, Lcom/baidu/location/f;->isStartedServing:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/baidu/location/f;->a:Lcom/baidu/location/LLSInterface;

    iput-object v0, p0, Lcom/baidu/location/f;->b:Lcom/baidu/location/LLSInterface;

    iput-object v0, p0, Lcom/baidu/location/f;->c:Lcom/baidu/location/LLSInterface;

    return-void
.end method

.method private a(Ljava/io/File;)Z
    .locals 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/baidu/location/d/j;->h()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "/grtcfrsa.dat"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    :try_start_0
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_1

    new-instance v0, Ljava/io/RandomAccessFile;

    const-string v3, "rw"

    invoke-direct {v0, v2, v3}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    const-wide/16 v2, 0xc8

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->readBoolean()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->readBoolean()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->readInt()I

    move-result v2

    if-eqz v2, :cond_0

    new-array v3, v2, [B

    invoke-virtual {v0, v3, v1, v2}, Ljava/io/RandomAccessFile;->read([BII)I

    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, v3}, Ljava/lang/String;-><init>([B)V

    const-string v3, "SHA-256"

    invoke-static {p1, v3}, Lcom/baidu/location/d/j;->a(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    if-eqz p1, :cond_0

    const-string v3, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB"

    invoke-static {p1, v2, v3}, Lcom/baidu/location/d/j;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_0

    const/4 p1, 0x1

    const/4 v1, 0x1

    :cond_0
    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p1

    :cond_1
    :goto_0
    return v1
.end method

.method public static getFrameVersion()F
    .locals 1

    const v0, 0x40f0a3d7    # 7.52f

    return v0
.end method

.method public static getJarFileName()Ljava/lang/String;
    .locals 1

    const-string v0, "app.jar"

    return-object v0
.end method

.method public static getServiceContext()Landroid/content/Context;
    .locals 1

    sget-object v0, Lcom/baidu/location/f;->mC:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/f;->c:Lcom/baidu/location/LLSInterface;

    invoke-interface {v0, p1}, Lcom/baidu/location/LLSInterface;->onBind(Landroid/content/Intent;)Landroid/os/IBinder;

    move-result-object p1

    return-object p1
.end method

.method public onCreate()V
    .locals 6
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/baidu/location/f;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sput-object v0, Lcom/baidu/location/f;->mC:Landroid/content/Context;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    new-instance v0, Lcom/baidu/location/c/a;

    invoke-direct {v0}, Lcom/baidu/location/c/a;-><init>()V

    iput-object v0, p0, Lcom/baidu/location/f;->b:Lcom/baidu/location/LLSInterface;

    const/4 v0, 0x0

    :try_start_0
    new-instance v1, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/baidu/location/d/j;->h()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sget-object v3, Lcom/baidu/location/f;->replaceFileName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    new-instance v2, Ljava/io/File;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/baidu/location/d/j;->h()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sget-object v4, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, "app.jar"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    :cond_0
    invoke-virtual {v1, v2}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    :cond_1
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_2

    new-instance v1, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/baidu/location/d/j;->h()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, "app.jar"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v1}, Lcom/baidu/location/f;->a(Ljava/io/File;)Z

    move-result v1

    if-eqz v1, :cond_2

    new-instance v1, Ldalvik/system/DexClassLoader;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/baidu/location/d/j;->h()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, "app.jar"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Lcom/baidu/location/d/j;->h()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0}, Lcom/baidu/location/f;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v4

    invoke-direct {v1, v2, v3, v0, v4}, Ldalvik/system/DexClassLoader;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V

    const-string v2, "com.baidu.serverLoc.LocationService"

    invoke-virtual {v1, v2}, Ldalvik/system/DexClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/baidu/location/LLSInterface;

    iput-object v1, p0, Lcom/baidu/location/f;->a:Lcom/baidu/location/LLSInterface;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v1

    iput-object v0, p0, Lcom/baidu/location/f;->a:Lcom/baidu/location/LLSInterface;

    :cond_2
    :goto_0
    iget-object v1, p0, Lcom/baidu/location/f;->a:Lcom/baidu/location/LLSInterface;

    if-eqz v1, :cond_3

    invoke-interface {v1}, Lcom/baidu/location/LLSInterface;->getVersion()D

    move-result-wide v1

    iget-object v3, p0, Lcom/baidu/location/f;->b:Lcom/baidu/location/LLSInterface;

    invoke-interface {v3}, Lcom/baidu/location/LLSInterface;->getVersion()D

    move-result-wide v3

    cmpl-double v5, v1, v3

    if-ltz v5, :cond_3

    iget-object v1, p0, Lcom/baidu/location/f;->a:Lcom/baidu/location/LLSInterface;

    iput-object v1, p0, Lcom/baidu/location/f;->c:Lcom/baidu/location/LLSInterface;

    iput-object v0, p0, Lcom/baidu/location/f;->b:Lcom/baidu/location/LLSInterface;

    goto :goto_1

    :cond_3
    iget-object v1, p0, Lcom/baidu/location/f;->b:Lcom/baidu/location/LLSInterface;

    iput-object v1, p0, Lcom/baidu/location/f;->c:Lcom/baidu/location/LLSInterface;

    iput-object v0, p0, Lcom/baidu/location/f;->a:Lcom/baidu/location/LLSInterface;

    :goto_1
    const/4 v0, 0x1

    sput-boolean v0, Lcom/baidu/location/f;->isServing:Z

    iget-object v0, p0, Lcom/baidu/location/f;->c:Lcom/baidu/location/LLSInterface;

    invoke-interface {v0, p0}, Lcom/baidu/location/LLSInterface;->onCreate(Landroid/content/Context;)V

    return-void
.end method

.method public onDestroy()V
    .locals 1

    const/4 v0, 0x0

    sput-boolean v0, Lcom/baidu/location/f;->isServing:Z

    iget-object v0, p0, Lcom/baidu/location/f;->c:Lcom/baidu/location/LLSInterface;

    invoke-interface {v0}, Lcom/baidu/location/LLSInterface;->onDestroy()V

    sget-boolean v0, Lcom/baidu/location/f;->isStartedServing:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/baidu/location/f;->stopForeground(Z)V

    :cond_0
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 4

    if-eqz p1, :cond_1

    :try_start_0
    const-string v0, "command"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    const/4 v2, 0x1

    if-ne v0, v2, :cond_0

    const-string v0, "id"

    invoke-virtual {p1, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    const-string v1, "notification"

    invoke-virtual {p1, v1}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/app/Notification;

    invoke-virtual {p0, v0, v1}, Lcom/baidu/location/f;->startForeground(ILandroid/app/Notification;)V

    sput-boolean v2, Lcom/baidu/location/f;->isStartedServing:Z

    goto :goto_0

    :cond_0
    const/4 v3, 0x2

    if-ne v0, v3, :cond_1

    const-string v0, "removenotify"

    invoke-virtual {p1, v0, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    invoke-virtual {p0, v0}, Lcom/baidu/location/f;->stopForeground(Z)V

    sput-boolean v1, Lcom/baidu/location/f;->isStartedServing:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/baidu/location/f;->c:Lcom/baidu/location/LLSInterface;

    invoke-interface {v0, p1, p2, p3}, Lcom/baidu/location/LLSInterface;->onStartCommand(Landroid/content/Intent;II)I

    move-result p1

    return p1
.end method

.method public onTaskRemoved(Landroid/content/Intent;)V
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/f;->c:Lcom/baidu/location/LLSInterface;

    invoke-interface {v0, p1}, Lcom/baidu/location/LLSInterface;->onTaskRemoved(Landroid/content/Intent;)V

    return-void
.end method

.method public onUnbind(Landroid/content/Intent;)Z
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/f;->c:Lcom/baidu/location/LLSInterface;

    invoke-interface {v0, p1}, Lcom/baidu/location/LLSInterface;->onUnBind(Landroid/content/Intent;)Z

    move-result p1

    return p1
.end method
