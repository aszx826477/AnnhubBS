.class public Lcom/qihoo/util/OverseaApplication;
.super Landroid/app/Application;
.source "SourceFile"


# static fields
.field private static loadDexToC:Z

.field private static selfLoad:Z

.field private static ᵢˋ:Landroid/content/Context;

.field private static ᵢˎ:Ljava/lang/String;

.field private static ᵢˏ:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const/4 v0, 0x0

    sput-object v0, Lcom/qihoo/util/OverseaApplication;->ᵢˎ:Ljava/lang/String;

    .line 20
    const/4 v0, 0x0

    sput-boolean v0, Lcom/qihoo/util/OverseaApplication;->loadDexToC:Z

    .line 21
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lcom/qihoo/util/OverseaApplication;->ᵢˏ:Ljava/util/Map;

    .line 22
    const/4 v0, 0x1

    sput-boolean v0, Lcom/qihoo/util/OverseaApplication;->selfLoad:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    return-void
.end method

.method public static getAppContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/qihoo/util/OverseaApplication;->ᵢˋ:Landroid/content/Context;

    return-object v0
.end method

.method public static getDir()Ljava/lang/String;
    .locals 1

    .prologue
    .line 109
    sget-object v0, Lcom/qihoo/util/OverseaApplication;->ᵢˎ:Ljava/lang/String;

    return-object v0
.end method

.method public static getString2(I)Ljava/lang/String;
    .locals 3

    .prologue
    .line 119
    sget-object v0, Lcom/qihoo/util/OverseaApplication;->ᵢˏ:Ljava/util/Map;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 120
    if-nez v0, :cond_0

    .line 121
    invoke-static {p0}, Lcom/qihoo/util/OverseaApplication;->interface14(I)Ljava/lang/String;

    move-result-object v0

    .line 122
    sget-object v1, Lcom/qihoo/util/OverseaApplication;->ᵢˏ:Ljava/util/Map;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 124
    :cond_0
    return-object v0
.end method

.method public static getString2(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 129
    :try_start_0
    invoke-static {p0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 130
    invoke-static {v0}, Lcom/qihoo/util/OverseaApplication;->getString2(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 133
    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static native interface11(I)V
.end method

.method public static native interface14(I)Ljava/lang/String;
.end method

.method public static native interface20()Z
.end method

.method public static load()V
    .locals 1

    .prologue
    .line 88
    invoke-static {}, Lcom/qihoo/util/OverseaApplication;->ᵢˋ()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 90
    :try_start_0
    const-string v0, "safety_x86"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 97
    :goto_0
    return-void

    :catch_0
    move-exception v0

    .line 95
    :cond_0
    const-string v0, "safety"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static load(Landroid/app/Application;Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 67
    .line 68
    sput-object p1, Lcom/qihoo/util/OverseaApplication;->ᵢˋ:Landroid/content/Context;

    if-eqz p1, :cond_0

    .line 69
    sget-object v0, Lcom/qihoo/util/OverseaApplication;->ᵢˋ:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v0

    .line 70
    if-eqz v0, :cond_0

    .line 71
    invoke-virtual {v0}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    .line 72
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/.jiagu"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/qihoo/util/OverseaApplication;->ᵢˎ:Ljava/lang/String;

    .line 75
    :cond_0
    invoke-static {}, Lcom/qihoo/util/OverseaApplication;->interface20()Z

    move-result v0

    if-nez v0, :cond_1

    .line 76
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/System;->exit(I)V

    .line 1137
    :cond_1
    sget-boolean v0, Lcom/qihoo/util/OverseaApplication;->loadDexToC:Z

    if-eqz v0, :cond_2

    .line 1139
    :try_start_0
    const-string v0, "jgdtc"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Error; {:try_start_0 .. :try_end_0} :catch_0

    .line 1142
    :cond_2
    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private static ᵢˋ()Z
    .locals 7

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 30
    :try_start_0
    sget-object v3, Landroid/os/Build;->SUPPORTED_32_BIT_ABIS:[Ljava/lang/String;

    array-length v4, v3

    move v2, v1

    :goto_0
    if-ge v2, v4, :cond_2

    aget-object v5, v3, v2

    .line 31
    const-string v6, "x86"

    invoke-virtual {v5, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 62
    :cond_0
    :goto_1
    return v0

    .line 30
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 35
    :cond_2
    sget-object v2, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    const-string v3, "x86"

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    sget-object v2, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    const-string v3, "x86"

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_1

    move-result v2

    if-nez v2, :cond_0

    .line 44
    :cond_3
    const/4 v3, 0x0

    .line 46
    :try_start_1
    new-instance v2, Ljava/io/RandomAccessFile;

    const-string v4, "/system/build.prop"

    const-string v5, "r"

    invoke-direct {v2, v4, v5}, Ljava/io/RandomAccessFile;-><init>(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 47
    :try_start_2
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->readLine()Ljava/lang/String;

    move-result-object v3

    .line 48
    :goto_2
    if-eqz v3, :cond_5

    .line 49
    const-string v4, "ro.product.cpu.abi"

    invoke-virtual {v3, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_4

    const-string v4, "x86"

    invoke-virtual {v3, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z
    :try_end_2
    .catch Ljava/io/FileNotFoundException; {:try_start_2 .. :try_end_2} :catch_9
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_8
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result v3

    if-eqz v3, :cond_4

    .line 58
    :try_start_3
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    goto :goto_1

    :catch_0
    move-exception v1

    goto :goto_1

    .line 39
    :catch_1
    move-exception v2

    sget-object v2, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    const-string v3, "x86"

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    sget-object v2, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    const-string v3, "x86"

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3

    goto :goto_1

    .line 51
    :cond_4
    :try_start_4
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->readLine()Ljava/lang/String;
    :try_end_4
    .catch Ljava/io/FileNotFoundException; {:try_start_4 .. :try_end_4} :catch_9
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_8
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    move-result-object v3

    goto :goto_2

    .line 58
    :cond_5
    :try_start_5
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_6

    :cond_6
    :goto_3
    move v0, v1

    .line 62
    goto :goto_1

    :catch_2
    move-exception v0

    move-object v0, v3

    .line 57
    :goto_4
    if-eqz v0, :cond_6

    .line 58
    :try_start_6
    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->close()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    goto :goto_3

    .line 61
    :catch_3
    move-exception v0

    goto :goto_3

    :catch_4
    move-exception v0

    move-object v2, v3

    .line 57
    :goto_5
    if-eqz v2, :cond_6

    .line 58
    :try_start_7
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_5

    goto :goto_3

    .line 61
    :catch_5
    move-exception v0

    goto :goto_3

    .line 56
    :catchall_0
    move-exception v0

    move-object v2, v3

    .line 57
    :goto_6
    if-eqz v2, :cond_7

    .line 58
    :try_start_8
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_7

    .line 61
    :cond_7
    :goto_7
    throw v0

    :catch_6
    move-exception v0

    goto :goto_3

    :catch_7
    move-exception v1

    goto :goto_7

    .line 56
    :catchall_1
    move-exception v0

    goto :goto_6

    :catch_8
    move-exception v0

    goto :goto_5

    :catch_9
    move-exception v0

    move-object v0, v2

    goto :goto_4
.end method


# virtual methods
.method protected attachBaseContext(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 101
    invoke-super {p0, p1}, Landroid/app/Application;->attachBaseContext(Landroid/content/Context;)V

    .line 102
    sget-boolean v0, Lcom/qihoo/util/OverseaApplication;->selfLoad:Z

    if-eqz v0, :cond_0

    .line 103
    invoke-static {}, Lcom/qihoo/util/OverseaApplication;->load()V

    .line 105
    :cond_0
    invoke-static {p0, p1}, Lcom/qihoo/util/OverseaApplication;->load(Landroid/app/Application;Landroid/content/Context;)V

    .line 106
    return-void
.end method
