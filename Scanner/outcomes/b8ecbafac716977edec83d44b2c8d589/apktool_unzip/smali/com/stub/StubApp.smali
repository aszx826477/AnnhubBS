.class public final Lcom/stub/StubApp;
.super Landroid/app/Application;
.source "SourceFile"


# static fields
.field private static loadDexToC:Z

.field private static loadFromLib:Z

.field private static needX86Bridge:Z

.field public static strEntryApplication:Ljava/lang/String;

.field private static ᵢˋ:Landroid/app/Application;

.field private static ᵢˎ:Landroid/app/Application;

.field private static ᵢˏ:Ljava/lang/String;

.field private static ᵢˑ:Landroid/content/Context;

.field private static ᵢי:Ljava/lang/String;

.field private static ᵢـ:Ljava/lang/String;

.field private static ᵢٴ:Ljava/lang/String;

.field private static ᵢᐧ:Ljava/lang/String;

.field private static ᵢᴵ:Ljava/lang/String;

.field private static ᵢᵎ:Ljava/util/Map;
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
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 31
    sput-object v1, Lcom/stub/StubApp;->ᵢˋ:Landroid/app/Application;

    .line 32
    const-string v0, "com.qihoo360.crypt.entryRunApplication"

    sput-object v0, Lcom/stub/StubApp;->strEntryApplication:Ljava/lang/String;

    .line 33
    sput-object v1, Lcom/stub/StubApp;->ᵢˎ:Landroid/app/Application;

    .line 34
    const-string v0, "libjiagu"

    sput-object v0, Lcom/stub/StubApp;->ᵢˏ:Ljava/lang/String;

    .line 36
    const/4 v2, 0x0

    sput-boolean v2, Lcom/stub/StubApp;->loadFromLib:Z

    .line 37
    const/4 v2, 0x0

    sput-boolean v2, Lcom/stub/StubApp;->needX86Bridge:Z

    .line 38
    const/4 v2, 0x0

    sput-boolean v2, Lcom/stub/StubApp;->loadDexToC:Z

    .line 41
    sput-object v1, Lcom/stub/StubApp;->ᵢי:Ljava/lang/String;

    .line 42
    sput-object v1, Lcom/stub/StubApp;->ᵢـ:Ljava/lang/String;

    .line 43
    sput-object v1, Lcom/stub/StubApp;->ᵢٴ:Ljava/lang/String;

    .line 44
    sput-object v1, Lcom/stub/StubApp;->ᵢᐧ:Ljava/lang/String;

    .line 45
    sput-object v1, Lcom/stub/StubApp;->ᵢᴵ:Ljava/lang/String;

    .line 46
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lcom/stub/StubApp;->ᵢᵎ:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    return-void
.end method

.method public static getAppContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 61
    sget-object v0, Lcom/stub/StubApp;->ᵢˑ:Landroid/content/Context;

    return-object v0
.end method

.method public static getDir()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    sget-object v0, Lcom/stub/StubApp;->ᵢᐧ:Ljava/lang/String;

    return-object v0
.end method

.method public static getOrigApplicationContext(Landroid/content/Context;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 65
    sget-object v0, Lcom/stub/StubApp;->ᵢˋ:Landroid/app/Application;

    if-ne p0, v0, :cond_0

    .line 66
    sget-object p0, Lcom/stub/StubApp;->ᵢˎ:Landroid/app/Application;

    .line 68
    :cond_0
    return-object p0
.end method

.method public static getSoPath1()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    sget-object v0, Lcom/stub/StubApp;->ᵢـ:Ljava/lang/String;

    return-object v0
.end method

.method public static getSoPath2()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    sget-object v0, Lcom/stub/StubApp;->ᵢٴ:Ljava/lang/String;

    return-object v0
.end method

.method public static getString2(I)Ljava/lang/String;
    .locals 3

    .prologue
    .line 473
    sget-object v0, Lcom/stub/StubApp;->ᵢᵎ:Ljava/util/Map;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 474
    if-nez v0, :cond_0

    .line 475
    invoke-static {p0}, Lcom/stub/StubApp;->interface14(I)Ljava/lang/String;

    move-result-object v0

    .line 476
    sget-object v1, Lcom/stub/StubApp;->ᵢᵎ:Ljava/util/Map;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 478
    :cond_0
    return-object v0
.end method

.method public static getString2(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 483
    :try_start_0
    invoke-static {p0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 484
    invoke-static {v0}, Lcom/stub/StubApp;->getString2(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 488
    :goto_0
    return-object v0

    .line 485
    :catch_0
    move-exception v0

    .line 486
    invoke-virtual {v0}, Ljava/lang/NumberFormatException;->printStackTrace()V

    .line 488
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static native interface11(I)V
.end method

.method public static native interface12(Ldalvik/system/DexFile;)Ljava/util/Enumeration;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ldalvik/system/DexFile;",
            ")",
            "Ljava/util/Enumeration",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public static native interface13(IJJJIIJ)J
.end method

.method public static native interface14(I)Ljava/lang/String;
.end method

.method public static native interface17(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
.end method

.method public static native interface18(Ljava/lang/Class;Ljava/lang/String;)Ljava/io/InputStream;
.end method

.method public static native interface19(Ljava/lang/ClassLoader;Ljava/lang/String;)Ljava/io/InputStream;
.end method

.method public static native interface20()V
.end method

.method public static native interface5(Landroid/app/Application;)V
.end method

.method public static native interface6(Ljava/lang/String;)Ljava/lang/String;
.end method

.method public static native interface7(Landroid/app/Application;Landroid/content/Context;)Z
.end method

.method public static native interface8(Landroid/app/Application;Landroid/content/Context;)Z
.end method

.method public static isX86Arch()Z
    .locals 8

    .prologue
    const/4 v3, 0x0

    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 177
    :try_start_0
    sget-object v4, Landroid/os/Build;->SUPPORTED_32_BIT_ABIS:[Ljava/lang/String;

    array-length v5, v4

    move v2, v1

    :goto_0
    if-ge v2, v5, :cond_2

    aget-object v6, v4, v2

    .line 178
    const-string v7, "x86"

    invoke-virtual {v6, v7}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 237
    :cond_0
    :goto_1
    return v0

    .line 177
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 182
    :cond_2
    sget-object v2, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    const-string v4, "x86"

    invoke-virtual {v2, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    sget-object v2, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    const-string v4, "x86"

    invoke-virtual {v2, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_5

    move-result v2

    if-nez v2, :cond_0

    .line 188
    :try_start_1
    new-instance v2, Ljava/io/RandomAccessFile;

    const-string v4, "/system/build.prop"

    const-string v5, "r"

    invoke-direct {v2, v4, v5}, Ljava/io/RandomAccessFile;-><init>(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 189
    :try_start_2
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->readLine()Ljava/lang/String;

    move-result-object v4

    .line 190
    :goto_2
    if-eqz v4, :cond_4

    .line 191
    const-string v5, "ro.product.cpu.abi"

    invoke-virtual {v4, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_3

    const-string v5, "x86"

    invoke-virtual {v4, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z
    :try_end_2
    .catch Ljava/io/FileNotFoundException; {:try_start_2 .. :try_end_2} :catch_12
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_11
    .catchall {:try_start_2 .. :try_end_2} :catchall_3

    move-result v4

    if-eqz v4, :cond_3

    .line 204
    :try_start_3
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_5

    goto :goto_1

    :catch_0
    move-exception v1

    goto :goto_1

    .line 193
    :cond_3
    :try_start_4
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->readLine()Ljava/lang/String;
    :try_end_4
    .catch Ljava/io/FileNotFoundException; {:try_start_4 .. :try_end_4} :catch_12
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_11
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    move-result-object v4

    goto :goto_2

    .line 204
    :cond_4
    :try_start_5
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_c
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_5

    :cond_5
    :goto_3
    move v0, v1

    .line 237
    goto :goto_1

    :catch_1
    move-exception v2

    move-object v2, v3

    .line 203
    :goto_4
    if-eqz v2, :cond_5

    .line 204
    :try_start_6
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6 .. :try_end_6} :catch_5

    goto :goto_3

    .line 207
    :catch_2
    move-exception v0

    goto :goto_3

    :catch_3
    move-exception v2

    move-object v2, v3

    .line 203
    :goto_5
    if-eqz v2, :cond_5

    .line 204
    :try_start_7
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_7 .. :try_end_7} :catch_5

    goto :goto_3

    .line 207
    :catch_4
    move-exception v0

    goto :goto_3

    .line 202
    :catchall_0
    move-exception v2

    move-object v4, v2

    move-object v5, v3

    .line 203
    :goto_6
    if-eqz v5, :cond_6

    .line 204
    :try_start_8
    invoke-virtual {v5}, Ljava/io/RandomAccessFile;->close()V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_d
    .catch Ljava/lang/NoSuchFieldError; {:try_start_8 .. :try_end_8} :catch_5

    .line 207
    :cond_6
    :goto_7
    :try_start_9
    throw v4
    :try_end_9
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_9} :catch_5

    .line 211
    :catch_5
    move-exception v2

    sget-object v2, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    const-string v4, "x86"

    invoke-virtual {v2, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    sget-object v2, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    const-string v4, "x86"

    invoke-virtual {v2, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 216
    :try_start_a
    new-instance v2, Ljava/io/RandomAccessFile;

    const-string v4, "/system/build.prop"

    const-string v5, "r"

    invoke-direct {v2, v4, v5}, Ljava/io/RandomAccessFile;-><init>(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_a
    .catch Ljava/io/FileNotFoundException; {:try_start_a .. :try_end_a} :catch_8
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_a
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    .line 217
    :try_start_b
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->readLine()Ljava/lang/String;

    move-result-object v3

    .line 218
    :goto_8
    if-eqz v3, :cond_8

    .line 219
    const-string v4, "ro.product.cpu.abi"

    invoke-virtual {v3, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_7

    const-string v4, "x86"

    invoke-virtual {v3, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z
    :try_end_b
    .catch Ljava/io/FileNotFoundException; {:try_start_b .. :try_end_b} :catch_10
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_b} :catch_f
    .catchall {:try_start_b .. :try_end_b} :catchall_2

    move-result v3

    if-eqz v3, :cond_7

    .line 232
    :try_start_c
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_6

    goto/16 :goto_1

    :catch_6
    move-exception v1

    goto/16 :goto_1

    .line 221
    :cond_7
    :try_start_d
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->readLine()Ljava/lang/String;
    :try_end_d
    .catch Ljava/io/FileNotFoundException; {:try_start_d .. :try_end_d} :catch_10
    .catch Ljava/io/IOException; {:try_start_d .. :try_end_d} :catch_f
    .catchall {:try_start_d .. :try_end_d} :catchall_2

    move-result-object v3

    goto :goto_8

    .line 232
    :cond_8
    :try_start_e
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_e} :catch_7

    goto :goto_3

    .line 235
    :catch_7
    move-exception v0

    goto :goto_3

    :catch_8
    move-exception v0

    .line 231
    :goto_9
    if-eqz v3, :cond_5

    .line 232
    :try_start_f
    invoke-virtual {v3}, Ljava/io/RandomAccessFile;->close()V
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_f} :catch_9

    goto :goto_3

    .line 235
    :catch_9
    move-exception v0

    goto :goto_3

    :catch_a
    move-exception v0

    move-object v2, v3

    .line 231
    :goto_a
    if-eqz v2, :cond_5

    .line 232
    :try_start_10
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_10
    .catch Ljava/lang/Exception; {:try_start_10 .. :try_end_10} :catch_b

    goto :goto_3

    .line 235
    :catch_b
    move-exception v0

    goto :goto_3

    .line 230
    :catchall_1
    move-exception v0

    move-object v2, v3

    .line 231
    :goto_b
    if-eqz v2, :cond_9

    .line 232
    :try_start_11
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_11
    .catch Ljava/lang/Exception; {:try_start_11 .. :try_end_11} :catch_e

    .line 235
    :cond_9
    :goto_c
    throw v0

    .line 207
    :catch_c
    move-exception v0

    goto/16 :goto_3

    :catch_d
    move-exception v2

    goto :goto_7

    :catch_e
    move-exception v1

    goto :goto_c

    .line 230
    :catchall_2
    move-exception v0

    goto :goto_b

    :catch_f
    move-exception v0

    goto :goto_a

    :catch_10
    move-exception v0

    move-object v3, v2

    goto :goto_9

    .line 202
    :catchall_3
    move-exception v4

    move-object v5, v2

    goto :goto_6

    :catch_11
    move-exception v4

    goto/16 :goto_5

    :catch_12
    move-exception v4

    goto/16 :goto_4
.end method

.method public static native mark(Landroid/location/LocationManager;Ljava/lang/String;)Landroid/location/Location;
.end method

.method public static native mark()V
.end method

.method public static native mark(Landroid/location/Location;)V
.end method

.method public static native declared-synchronized n01031(Ljava/lang/Object;)Z
.end method

.method public static native declared-synchronized n0103210(Ljava/lang/Object;JZ)V
.end method

.method public static native declared-synchronized n01033(Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native declared-synchronized n010333(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n0110()V
.end method

.method public static native n0111()I
.end method

.method public static native n01110(I)V
.end method

.method public static native n01111(I)I
.end method

.method public static native n011111(II)I
.end method

.method public static native n0111111(IBS)I
.end method

.method public static native n011111113(ZIIBB)Ljava/lang/Object;
.end method

.method public static native n011113(BB)Ljava/lang/Object;
.end method

.method public static native n0111131331(ZZLjava/lang/Object;ZLjava/lang/Object;Ljava/lang/Object;)Z
.end method

.method public static native n01111313331(ZZLjava/lang/Object;ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
.end method

.method public static native n01113(I)Ljava/lang/Object;
.end method

.method public static native n011133(ILjava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n0112()J
.end method

.method public static native n01120(J)V
.end method

.method public static native n01121(J)Z
.end method

.method public static native n011211(JI)I
.end method

.method public static native n01122(J)J
.end method

.method public static native n011222(JJ)J
.end method

.method public static native n0112220(JJJ)V
.end method

.method public static native n01123(J)Ljava/lang/Object;
.end method

.method public static native n01123313(JLjava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;
.end method

.method public static native n0112333(JLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n011233331(JLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
.end method

.method public static native n0113()Ljava/lang/Object;
.end method

.method public static native n01130(Ljava/lang/Object;)V
.end method

.method public static native n01131(Ljava/lang/Object;)Z
.end method

.method public static native n011310(Ljava/lang/Object;I)V
.end method

.method public static native n011311(Ljava/lang/Object;I)I
.end method

.method public static native n0113111(Ljava/lang/Object;II)I
.end method

.method public static native n01131111(Ljava/lang/Object;IIZ)I
.end method

.method public static native n01131113(Ljava/lang/Object;IIZ)Ljava/lang/Object;
.end method

.method public static native n0113112(Ljava/lang/Object;II)J
.end method

.method public static native n0113113(Ljava/lang/Object;II)Ljava/lang/Object;
.end method

.method public static native n01131131(Ljava/lang/Object;IILjava/lang/Object;)I
.end method

.method public static native n011311311(Ljava/lang/Object;IILjava/lang/Object;I)Z
.end method

.method public static native n011311311113(Ljava/lang/Object;IILjava/lang/Object;ZZZZ)Ljava/lang/Object;
.end method

.method public static native n011313(Ljava/lang/Object;I)Ljava/lang/Object;
.end method

.method public static native n0113130(Ljava/lang/Object;ILjava/lang/Object;)V
.end method

.method public static native n0113131(Ljava/lang/Object;ILjava/lang/Object;)Z
.end method

.method public static native n011313111(Ljava/lang/Object;ILjava/lang/Object;II)Z
.end method

.method public static native n01131330(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n01132(Ljava/lang/Object;)J
.end method

.method public static native n011320(Ljava/lang/Object;J)V
.end method

.method public static native n011322(Ljava/lang/Object;J)J
.end method

.method public static native n0113231(Ljava/lang/Object;JLjava/lang/Object;)I
.end method

.method public static native n01132320(Ljava/lang/Object;JLjava/lang/Object;J)V
.end method

.method public static native n0113233(Ljava/lang/Object;JLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n011323313(Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;
.end method

.method public static native n01132333(Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n01133(Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n011330(Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n011331(Ljava/lang/Object;Ljava/lang/Object;)I
.end method

.method public static native n0113310(Ljava/lang/Object;Ljava/lang/Object;I)V
.end method

.method public static native n01133110(Ljava/lang/Object;Ljava/lang/Object;ZI)V
.end method

.method public static native n011331110(Ljava/lang/Object;Ljava/lang/Object;IIZ)V
.end method

.method public static native n0113311113(Ljava/lang/Object;Ljava/lang/Object;ZZZZ)Ljava/lang/Object;
.end method

.method public static native n011331113(Ljava/lang/Object;Ljava/lang/Object;III)Ljava/lang/Object;
.end method

.method public static native n011331123(Ljava/lang/Object;Ljava/lang/Object;IIJ)Ljava/lang/Object;
.end method

.method public static native n01133113(Ljava/lang/Object;Ljava/lang/Object;II)Ljava/lang/Object;
.end method

.method public static native n0113311311110(Ljava/lang/Object;Ljava/lang/Object;IILjava/lang/Object;ZZZZ)V
.end method

.method public static native n011331133(Ljava/lang/Object;Ljava/lang/Object;IILjava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n0113313(Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;
.end method

.method public static native n01133130(Ljava/lang/Object;Ljava/lang/Object;ZLjava/lang/Object;)V
.end method

.method public static native n0113313113(Ljava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;II)Ljava/lang/Object;
.end method

.method public static native n011331330(Ljava/lang/Object;Ljava/lang/Object;ZLjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n0113320(Ljava/lang/Object;Ljava/lang/Object;J)V
.end method

.method public static native n011333(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n0113330(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n0113331(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
.end method

.method public static native n01133310(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Z)V
.end method

.method public static native n01133323(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;J)Ljava/lang/Object;
.end method

.method public static native n0113333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n01133330(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n01133331(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
.end method

.method public static native n01133333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n011333333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method private static ᵢˋ(Landroid/content/Context;)Landroid/app/Application;
    .locals 2

    .prologue
    .line 81
    :try_start_0
    sget-object v0, Lcom/stub/StubApp;->ᵢˎ:Landroid/app/Application;

    if-nez v0, :cond_0

    .line 82
    invoke-virtual {p0}, Landroid/content/Context;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    .line 83
    if-eqz v0, :cond_0

    .line 84
    sget-object v1, Lcom/stub/StubApp;->strEntryApplication:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 85
    if-eqz v0, :cond_0

    .line 86
    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Application;

    sput-object v0, Lcom/stub/StubApp;->ᵢˎ:Landroid/app/Application;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 92
    :cond_0
    :goto_0
    sget-object v0, Lcom/stub/StubApp;->ᵢˎ:Landroid/app/Application;

    return-object v0

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private static ᵢˋ(Ljava/lang/String;ZZ)Ljava/lang/String;
    .locals 3

    .prologue
    .line 327
    sget-object v0, Lcom/stub/StubApp;->ᵢˏ:Ljava/lang/String;

    .line 328
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x17

    if-ge v1, v2, :cond_0

    .line 329
    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v1

    .line 330
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 332
    :cond_0
    if-eqz p1, :cond_1

    if-nez p2, :cond_1

    .line 333
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "_64.so"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 338
    :goto_0
    return-object v0

    .line 335
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".so"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private static ᵢˋ(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 8

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 357
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 359
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, p2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 367
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_0

    .line 368
    invoke-virtual {v2}, Ljava/io/File;->mkdir()Z

    .line 370
    :cond_0
    :try_start_0
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 372
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 373
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/res/Resources;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v4

    invoke-virtual {v4, p1}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v4

    .line 374
    new-instance v5, Ljava/io/FileInputStream;

    invoke-direct {v5, v2}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 375
    new-instance v6, Ljava/io/BufferedInputStream;

    invoke-direct {v6, v4}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 376
    new-instance v7, Ljava/io/BufferedInputStream;

    invoke-direct {v7, v5}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 378
    invoke-static {v6, v7}, Lcom/stub/StubApp;->ᵢˋ(Ljava/io/BufferedInputStream;Ljava/io/BufferedInputStream;)Z

    move-result v2

    if-eqz v2, :cond_3

    move v2, v0

    .line 382
    :goto_0
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    .line 383
    invoke-virtual {v5}, Ljava/io/InputStream;->close()V

    .line 384
    invoke-virtual {v6}, Ljava/io/BufferedInputStream;->close()V

    .line 385
    invoke-virtual {v7}, Ljava/io/BufferedInputStream;->close()V

    .line 386
    if-eqz v2, :cond_1

    .line 406
    :goto_1
    return v0

    .line 390
    :cond_1
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v2

    invoke-virtual {v2, p1}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v2

    .line 391
    new-instance v4, Ljava/io/FileOutputStream;

    invoke-direct {v4, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    .line 393
    const/16 v3, 0x1c00

    new-array v3, v3, [B

    .line 395
    :goto_2
    invoke-virtual {v2, v3}, Ljava/io/InputStream;->read([B)I

    move-result v5

    if-lez v5, :cond_2

    .line 396
    const/4 v6, 0x0

    invoke-virtual {v4, v3, v6, v5}, Ljava/io/FileOutputStream;->write([BII)V

    goto :goto_2

    .line 403
    :catch_0
    move-exception v0

    move v0, v1

    goto :goto_1

    .line 398
    :cond_2
    invoke-virtual {v4}, Ljava/io/FileOutputStream;->close()V

    .line 399
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :cond_3
    move v2, v1

    goto :goto_0
.end method

.method private static ᵢˋ(Ljava/io/BufferedInputStream;Ljava/io/BufferedInputStream;)Z
    .locals 7

    .prologue
    const/4 v0, 0x0

    .line 412
    :try_start_0
    invoke-virtual {p0}, Ljava/io/BufferedInputStream;->available()I

    move-result v2

    .line 413
    invoke-virtual {p1}, Ljava/io/BufferedInputStream;->available()I

    move-result v1

    .line 415
    if-ne v2, v1, :cond_0

    .line 416
    new-array v3, v2, [B

    .line 417
    new-array v4, v1, [B

    .line 419
    invoke-virtual {p0, v3}, Ljava/io/BufferedInputStream;->read([B)I

    .line 420
    invoke-virtual {p1, v4}, Ljava/io/BufferedInputStream;->read([B)I

    move v1, v0

    .line 422
    :goto_0
    if-ge v1, v2, :cond_2

    .line 423
    aget-byte v5, v3, v1

    aget-byte v6, v4, v1
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    if-eq v5, v6, :cond_1

    .line 436
    :cond_0
    :goto_1
    return v0

    .line 422
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 427
    :cond_2
    const/4 v0, 0x1

    goto :goto_1

    :catch_0
    move-exception v1

    goto :goto_1

    .line 435
    :catch_1
    move-exception v1

    goto :goto_1
.end method


# virtual methods
.method protected final attachBaseContext(Landroid/content/Context;)V
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 242
    invoke-super {p0, p1}, Landroid/app/Application;->attachBaseContext(Landroid/content/Context;)V

    .line 243
    sput-object p1, Lcom/stub/StubApp;->ᵢˑ:Landroid/content/Context;

    .line 244
    sget-object v0, Lcom/stub/StubApp;->ᵢˋ:Landroid/app/Application;

    if-nez v0, :cond_0

    .line 245
    sput-object p0, Lcom/stub/StubApp;->ᵢˋ:Landroid/app/Application;

    .line 247
    :cond_0
    sget-object v0, Lcom/stub/StubApp;->ᵢˎ:Landroid/app/Application;

    if-nez v0, :cond_6

    .line 249
    invoke-static {}, Lcom/stub/StubApp;->isX86Arch()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    .line 250
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 251
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 252
    sget-object v2, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    const-string v4, "64"

    invoke-virtual {v2, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    sget-object v2, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    const-string v4, "64"

    invoke-virtual {v2, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 253
    :cond_1
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 255
    :cond_2
    sget-object v2, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    const-string v4, "mips"

    invoke-virtual {v2, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_3

    sget-object v2, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    const-string v4, "mips"

    invoke-virtual {v2, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 256
    :cond_3
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 258
    :cond_4
    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_5

    sget-boolean v2, Lcom/stub/StubApp;->needX86Bridge:Z

    if-eqz v2, :cond_5

    .line 259
    const-string v2, "X86Bridge"

    invoke-static {v2}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 260
    :cond_5
    sget-boolean v2, Lcom/stub/StubApp;->loadFromLib:Z

    if-eqz v2, :cond_a

    .line 261
    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_9

    sget-boolean v2, Lcom/stub/StubApp;->needX86Bridge:Z

    if-nez v2, :cond_9

    .line 262
    const-string v2, "jiagu_x86"

    invoke-static {v2}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 301
    :goto_0
    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    .line 3492
    sget-boolean v0, Lcom/stub/StubApp;->loadDexToC:Z

    if-eqz v0, :cond_6

    .line 3493
    sget-boolean v0, Lcom/stub/StubApp;->loadFromLib:Z

    if-eqz v0, :cond_10

    .line 3495
    :try_start_0
    const-string v0, "jgdtc"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Error; {:try_start_0 .. :try_end_0} :catch_3

    .line 304
    :cond_6
    :goto_1
    sget-object v0, Lcom/stub/StubApp;->ᵢˋ:Landroid/app/Application;

    invoke-static {v0}, Lcom/stub/StubApp;->interface5(Landroid/app/Application;)V

    .line 305
    sget-object v0, Lcom/stub/StubApp;->ᵢˎ:Landroid/app/Application;

    if-nez v0, :cond_8

    .line 306
    invoke-static {p1}, Lcom/stub/StubApp;->ᵢˋ(Landroid/content/Context;)Landroid/app/Application;

    move-result-object v0

    sput-object v0, Lcom/stub/StubApp;->ᵢˎ:Landroid/app/Application;

    .line 307
    sget-object v0, Lcom/stub/StubApp;->ᵢˎ:Landroid/app/Application;

    if-eqz v0, :cond_17

    .line 309
    :try_start_1
    const-class v0, Landroid/app/Application;

    const-string v1, "attach"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Class;

    const/4 v3, 0x0

    const-class v4, Landroid/content/Context;

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 310
    if-eqz v0, :cond_7

    .line 311
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    .line 312
    sget-object v1, Lcom/stub/StubApp;->ᵢˎ:Landroid/app/Application;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-virtual {v0, v1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 317
    :cond_7
    sget-object v0, Lcom/stub/StubApp;->ᵢˎ:Landroid/app/Application;

    invoke-static {v0, p1}, Lcom/stub/StubApp;->interface8(Landroid/app/Application;Landroid/content/Context;)Z

    .line 324
    :cond_8
    :goto_2
    return-void

    .line 264
    :cond_9
    const-string v2, "jiagu"

    invoke-static {v2}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    goto :goto_0

    .line 267
    :cond_a
    invoke-virtual {p1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    .line 269
    :try_start_2
    invoke-virtual {p1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_4

    move-result-object v2

    .line 273
    :goto_3
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "/.jiagu"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 274
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    invoke-static {v4, v2, v5}, Lcom/stub/StubApp;->ᵢˋ(Ljava/lang/String;ZZ)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/stub/StubApp;->ᵢᴵ:Ljava/lang/String;

    .line 275
    invoke-static {v4, v6, v6}, Lcom/stub/StubApp;->ᵢˋ(Ljava/lang/String;ZZ)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/stub/StubApp;->ᵢי:Ljava/lang/String;

    .line 276
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v5, Lcom/stub/StubApp;->ᵢי:Ljava/lang/String;

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/stub/StubApp;->ᵢـ:Ljava/lang/String;

    .line 277
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v5, Lcom/stub/StubApp;->ᵢᴵ:Ljava/lang/String;

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/stub/StubApp;->ᵢٴ:Ljava/lang/String;

    .line 278
    sput-object v4, Lcom/stub/StubApp;->ᵢᐧ:Ljava/lang/String;

    .line 279
    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_b

    .line 280
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/stub/StubApp;->ᵢˏ:Ljava/lang/String;

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, "_mips.so"

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sget-object v5, Lcom/stub/StubApp;->ᵢי:Ljava/lang/String;

    invoke-static {p1, v2, v4, v5}, Lcom/stub/StubApp;->ᵢˋ(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    .line 286
    :goto_4
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_f

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_f

    .line 288
    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_d

    sget-boolean v2, Lcom/stub/StubApp;->needX86Bridge:Z

    if-nez v2, :cond_d

    .line 289
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/stub/StubApp;->ᵢˏ:Ljava/lang/String;

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, "_x64.so"

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sget-object v5, Lcom/stub/StubApp;->ᵢᴵ:Ljava/lang/String;

    invoke-static {p1, v2, v4, v5}, Lcom/stub/StubApp;->ᵢˋ(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    .line 293
    :goto_5
    if-eqz v2, :cond_e

    .line 294
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "/"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v4, Lcom/stub/StubApp;->ᵢᴵ:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/System;->load(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 281
    :cond_b
    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_c

    sget-boolean v2, Lcom/stub/StubApp;->needX86Bridge:Z

    if-nez v2, :cond_c

    .line 282
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/stub/StubApp;->ᵢˏ:Ljava/lang/String;

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, "_x86.so"

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sget-object v5, Lcom/stub/StubApp;->ᵢי:Ljava/lang/String;

    invoke-static {p1, v2, v4, v5}, Lcom/stub/StubApp;->ᵢˋ(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    goto :goto_4

    .line 284
    :cond_c
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/stub/StubApp;->ᵢˏ:Ljava/lang/String;

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, ".so"

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sget-object v5, Lcom/stub/StubApp;->ᵢי:Ljava/lang/String;

    invoke-static {p1, v2, v4, v5}, Lcom/stub/StubApp;->ᵢˋ(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    goto/16 :goto_4

    .line 291
    :cond_d
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/stub/StubApp;->ᵢˏ:Ljava/lang/String;

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, "_a64.so"

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sget-object v5, Lcom/stub/StubApp;->ᵢᴵ:Ljava/lang/String;

    invoke-static {p1, v2, v4, v5}, Lcom/stub/StubApp;->ᵢˋ(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    goto :goto_5

    .line 296
    :cond_e
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "/"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v4, Lcom/stub/StubApp;->ᵢי:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/System;->load(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 298
    :cond_f
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "/"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v4, Lcom/stub/StubApp;->ᵢי:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/System;->load(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 3500
    :cond_10
    sget-object v0, Lcom/stub/StubApp;->ᵢˑ:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    .line 3502
    :try_start_3
    sget-object v4, Lcom/stub/StubApp;->ᵢˑ:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2

    move-result-object v0

    .line 3506
    :goto_6
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v4, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ".jiagu"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 4342
    const-string v0, "libjgdtc"

    .line 4343
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0x17

    if-ge v5, v6, :cond_11

    .line 4344
    invoke-virtual {v4}, Ljava/lang/String;->hashCode()I

    move-result v5

    .line 4345
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 4347
    :cond_11
    if-eqz v3, :cond_12

    if-nez v1, :cond_12

    .line 4348
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, "_64.so"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 3508
    :goto_7
    if-eqz v1, :cond_13

    .line 3509
    sget-object v1, Lcom/stub/StubApp;->ᵢˑ:Landroid/content/Context;

    const-string v2, "libjgdtc_mips.so"

    invoke-static {v1, v2, v4, v0}, Lcom/stub/StubApp;->ᵢˋ(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    .line 3520
    :goto_8
    :try_start_4
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/System;->load(Ljava/lang/String;)V
    :try_end_4
    .catch Ljava/lang/Error; {:try_start_4 .. :try_end_4} :catch_0

    goto/16 :goto_1

    :catch_0
    move-exception v0

    goto/16 :goto_1

    .line 4350
    :cond_12
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, ".so"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_7

    .line 3510
    :cond_13
    if-eqz v2, :cond_14

    if-nez v3, :cond_14

    .line 3511
    sget-object v1, Lcom/stub/StubApp;->ᵢˑ:Landroid/content/Context;

    const-string v2, "libjgdtc_x86.so"

    invoke-static {v1, v2, v4, v0}, Lcom/stub/StubApp;->ᵢˋ(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    goto :goto_8

    .line 3512
    :cond_14
    if-eqz v2, :cond_15

    if-eqz v3, :cond_15

    .line 3513
    sget-object v1, Lcom/stub/StubApp;->ᵢˑ:Landroid/content/Context;

    const-string v2, "libjgdtc_x64.so"

    invoke-static {v1, v2, v4, v0}, Lcom/stub/StubApp;->ᵢˋ(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    goto :goto_8

    .line 3514
    :cond_15
    if-nez v2, :cond_16

    if-nez v1, :cond_16

    if-eqz v3, :cond_16

    .line 3515
    sget-object v1, Lcom/stub/StubApp;->ᵢˑ:Landroid/content/Context;

    const-string v2, "libjgdtc_a64.so"

    invoke-static {v1, v2, v4, v0}, Lcom/stub/StubApp;->ᵢˋ(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    goto :goto_8

    .line 3517
    :cond_16
    sget-object v1, Lcom/stub/StubApp;->ᵢˑ:Landroid/content/Context;

    const-string v2, "libjgdtc.so"

    invoke-static {v1, v2, v4, v0}, Lcom/stub/StubApp;->ᵢˋ(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    goto :goto_8

    .line 314
    :catch_1
    move-exception v0

    .line 315
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Failed to call attachBaseContext."

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 319
    :cond_17
    invoke-static {v7}, Ljava/lang/System;->exit(I)V

    goto/16 :goto_2

    :catch_2
    move-exception v4

    goto/16 :goto_6

    .line 3498
    :catch_3
    move-exception v0

    goto/16 :goto_1

    :catch_4
    move-exception v4

    goto/16 :goto_3
.end method

.method public native declared-synchronized n1100()V
.end method

.method public native declared-synchronized n1101()I
.end method

.method public native declared-synchronized n11010(I)V
.end method

.method public native declared-synchronized n1101110(ZII)V
.end method

.method public native declared-synchronized n11011130(ZIILjava/lang/Object;)V
.end method

.method public native declared-synchronized n1101130(IILjava/lang/Object;)V
.end method

.method public native declared-synchronized n11011310(ZILjava/lang/Object;I)V
.end method

.method public native declared-synchronized n110120(IJ)V
.end method

.method public native declared-synchronized n11013(I)Ljava/lang/Object;
.end method

.method public native declared-synchronized n110130(ILjava/lang/Object;)V
.end method

.method public native declared-synchronized n1101321(ILjava/lang/Object;J)Z
.end method

.method public native declared-synchronized n1101330(ILjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native declared-synchronized n1102()J
.end method

.method public native declared-synchronized n11020(J)V
.end method

.method public native declared-synchronized n1103()Ljava/lang/Object;
.end method

.method public native declared-synchronized n11030(Ljava/lang/Object;)V
.end method

.method public native declared-synchronized n11031(Ljava/lang/Object;)Z
.end method

.method public native declared-synchronized n110310(Ljava/lang/Object;Z)V
.end method

.method public native declared-synchronized n110311(Ljava/lang/Object;I)Z
.end method

.method public native declared-synchronized n110323(Ljava/lang/Object;J)Ljava/lang/Object;
.end method

.method public native declared-synchronized n11033(Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native declared-synchronized n110331(Ljava/lang/Object;Ljava/lang/Object;)Z
.end method

.method public native n1110()V
.end method

.method public native n1111()Z
.end method

.method public native n11110(I)V
.end method

.method public native n11111(I)I
.end method

.method public native n111110(IZ)V
.end method

.method public native n111111(II)I
.end method

.method public native n1111110(III)V
.end method

.method public native n11111110(IIIZ)V
.end method

.method public native n111111110(ZIIII)V
.end method

.method public native n11111111111111130(ZZIIZZZIIZZZLjava/lang/Object;)V
.end method

.method public native n111111113(IIIZZ)Ljava/lang/Object;
.end method

.method public native n11111113(IIIZ)Ljava/lang/Object;
.end method

.method public native n1111113(ZZZ)Ljava/lang/Object;
.end method

.method public native n11111130(ZIILjava/lang/Object;)V
.end method

.method public native n111113(II)Ljava/lang/Object;
.end method

.method public native n1111130(IILjava/lang/Object;)V
.end method

.method public native n11111310(ZILjava/lang/Object;I)V
.end method

.method public native n111113131(ZZLjava/lang/Object;ZLjava/lang/Object;)Z
.end method

.method public native n11111320(IZLjava/lang/Object;J)V
.end method

.method public native n11111331(ZZLjava/lang/Object;Ljava/lang/Object;)Z
.end method

.method public native n11111333(IILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11112(I)J
.end method

.method public native n111120(IJ)V
.end method

.method public native n11112110(IJZZ)V
.end method

.method public native n111122(BJ)J
.end method

.method public native n1111222(BJJ)J
.end method

.method public native n111123(IJ)Ljava/lang/Object;
.end method

.method public native n1111230(IJLjava/lang/Object;)V
.end method

.method public native n11112330(IJLjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n11113(I)Ljava/lang/Object;
.end method

.method public native n111130(ILjava/lang/Object;)V
.end method

.method public native n111131(ILjava/lang/Object;)Z
.end method

.method public native n1111310(ILjava/lang/Object;Z)V
.end method

.method public native n1111311(ILjava/lang/Object;I)Z
.end method

.method public native n11113110(ILjava/lang/Object;IZ)V
.end method

.method public native n11113111(ILjava/lang/Object;IZ)Z
.end method

.method public native n111131130(ILjava/lang/Object;ZZLjava/lang/Object;)V
.end method

.method public native n1111313(ILjava/lang/Object;Z)Ljava/lang/Object;
.end method

.method public native n1111320(ILjava/lang/Object;J)V
.end method

.method public native n111133(ILjava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n1111330(ILjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n1111333(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11113330(ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n1111333120(ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;IJ)V
.end method

.method public native n1112()J
.end method

.method public native n11120(J)V
.end method

.method public native n11121(J)I
.end method

.method public native n111211(JI)I
.end method

.method public native n11122(J)J
.end method

.method public native n11123(J)Ljava/lang/Object;
.end method

.method public native n111230(JLjava/lang/Object;)V
.end method

.method public native n111231(JLjava/lang/Object;)Z
.end method

.method public native n11123111(JLjava/lang/Object;II)Z
.end method

.method public native n111232(JLjava/lang/Object;)J
.end method

.method public native n1112320(JLjava/lang/Object;J)V
.end method

.method public native n111233(JLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n1112330(JLjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n1113()Ljava/lang/Object;
.end method

.method public native n11130(Ljava/lang/Object;)V
.end method

.method public native n11131(Ljava/lang/Object;)Z
.end method

.method public native n111310(Ljava/lang/Object;I)V
.end method

.method public native n111311(Ljava/lang/Object;I)Z
.end method

.method public native n1113110(Ljava/lang/Object;II)V
.end method

.method public native n1113111(Ljava/lang/Object;II)I
.end method

.method public native n11131110(Ljava/lang/Object;IBI)V
.end method

.method public native n111311110(Ljava/lang/Object;IIZZ)V
.end method

.method public native n1113113(Ljava/lang/Object;ZI)Ljava/lang/Object;
.end method

.method public native n11131133(Ljava/lang/Object;IILjava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n111312(Ljava/lang/Object;Z)J
.end method

.method public native n111313(Ljava/lang/Object;Z)Ljava/lang/Object;
.end method

.method public native n1113130(Ljava/lang/Object;ZLjava/lang/Object;)V
.end method

.method public native n1113131(Ljava/lang/Object;ZLjava/lang/Object;)Z
.end method

.method public native n11131310(Ljava/lang/Object;ILjava/lang/Object;I)V
.end method

.method public native n111313111(Ljava/lang/Object;ILjava/lang/Object;II)Z
.end method

.method public native n1113133(Ljava/lang/Object;ZLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11131333(Ljava/lang/Object;ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n111313330(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n1113133330(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n1113133333333330(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n11132(Ljava/lang/Object;)J
.end method

.method public native n111320(Ljava/lang/Object;J)V
.end method

.method public native n111321(Ljava/lang/Object;J)I
.end method

.method public native n1113210(Ljava/lang/Object;JI)V
.end method

.method public native n1113213(Ljava/lang/Object;JI)Ljava/lang/Object;
.end method

.method public native n111321320(Ljava/lang/Object;JILjava/lang/Object;J)V
.end method

.method public native n111322(Ljava/lang/Object;J)J
.end method

.method public native n1113220(Ljava/lang/Object;JJ)V
.end method

.method public native n11132210(Ljava/lang/Object;JJI)V
.end method

.method public native n1113223(Ljava/lang/Object;JJ)Ljava/lang/Object;
.end method

.method public native n11132233(Ljava/lang/Object;JJLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n1113223310(Ljava/lang/Object;JJLjava/lang/Object;Ljava/lang/Object;I)V
.end method

.method public native n11132233110(Ljava/lang/Object;JJLjava/lang/Object;Ljava/lang/Object;IZ)V
.end method

.method public native n111322332110(Ljava/lang/Object;JJLjava/lang/Object;Ljava/lang/Object;JIZ)V
.end method

.method public native n111323(Ljava/lang/Object;J)Ljava/lang/Object;
.end method

.method public native n1113230(Ljava/lang/Object;JLjava/lang/Object;)V
.end method

.method public native n11132320(Ljava/lang/Object;JLjava/lang/Object;J)V
.end method

.method public native n1113233(Ljava/lang/Object;JLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11132330(Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n111323310(Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;I)V
.end method

.method public native n1113233110(Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;IZ)V
.end method

.method public native n11132331210(Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;IJZ)V
.end method

.method public native n11132333(Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n111323330(Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n11133(Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n111330(Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n111331(Ljava/lang/Object;Ljava/lang/Object;)I
.end method

.method public native n1113310(Ljava/lang/Object;Ljava/lang/Object;Z)V
.end method

.method public native n11133110(Ljava/lang/Object;Ljava/lang/Object;ZI)V
.end method

.method public native n1113311230(Ljava/lang/Object;Ljava/lang/Object;IIJLjava/lang/Object;)V
.end method

.method public native n11133130(Ljava/lang/Object;Ljava/lang/Object;ZLjava/lang/Object;)V
.end method

.method public native n111331330(Ljava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n1113320(Ljava/lang/Object;Ljava/lang/Object;J)V
.end method

.method public native n1113321(Ljava/lang/Object;Ljava/lang/Object;J)Z
.end method

.method public native n11133211(Ljava/lang/Object;Ljava/lang/Object;JI)Z
.end method

.method public native n1113323(Ljava/lang/Object;Ljava/lang/Object;J)Ljava/lang/Object;
.end method

.method public native n111332320(Ljava/lang/Object;Ljava/lang/Object;JLjava/lang/Object;J)V
.end method

.method public native n111332330(Ljava/lang/Object;Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n1113323311110(Ljava/lang/Object;Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;ZZZZ)V
.end method

.method public native n111333(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n1113330(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n1113331(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)I
.end method

.method public native n11133310(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Z)V
.end method

.method public native n111333110(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;IZ)V
.end method

.method public native n11133311130(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;ZIILjava/lang/Object;)V
.end method

.method public native n111333113(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;IZ)Ljava/lang/Object;
.end method

.method public native n111333120(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;IJ)V
.end method

.method public native n111333130(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;)V
.end method

.method public native n1113331310(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;Z)V
.end method

.method public native n11133313110(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;IZ)V
.end method

.method public native n1113333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11133330(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n11133331(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)I
.end method

.method public native n1113333130(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;)V
.end method

.method public native n11133333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n111333330(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n111333333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public final onCreate()V
    .locals 6

    .prologue
    .line 113
    invoke-super {p0}, Landroid/app/Application;->onCreate()V

    .line 115
    sget-boolean v0, Lcom/qihoo/util/Configuration;->ENABLE_CRASH_REPORT:Z

    if-eqz v0, :cond_0

    .line 1147
    :try_start_0
    const-string v0, "com.qihoo.bugreport.CrashReport"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 1148
    const-string v1, "prepareInit"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Class;

    invoke-virtual {v0, v1, v2}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 1149
    const/4 v1, 0x0

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_4

    .line 2103
    :cond_0
    :goto_0
    sget-object v0, Lcom/stub/StubApp;->ᵢˋ:Landroid/app/Application;

    invoke-virtual {v0}, Landroid/app/Application;->getBaseContext()Landroid/content/Context;

    move-result-object v0

    .line 2105
    :try_start_1
    sget-object v1, Lcom/stub/StubApp;->ᵢˎ:Landroid/app/Application;

    invoke-static {v1, v0}, Lcom/stub/StubApp;->interface7(Landroid/app/Application;Landroid/content/Context;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3

    .line 121
    :goto_1
    sget-object v0, Lcom/stub/StubApp;->ᵢˎ:Landroid/app/Application;

    if-eqz v0, :cond_1

    .line 122
    sget-object v0, Lcom/stub/StubApp;->ᵢˎ:Landroid/app/Application;

    invoke-virtual {v0}, Landroid/app/Application;->onCreate()V

    .line 125
    :cond_1
    sget-boolean v0, Lcom/qihoo/util/Configuration;->ENABLE_CRASH_REPORT:Z

    if-eqz v0, :cond_2

    .line 2159
    :try_start_2
    const-string v0, "com.qihoo.bugreport.CrashReport"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 2160
    const-string v1, "init"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Class;

    const/4 v3, 0x0

    const-class v4, Landroid/content/Context;

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 2161
    const/4 v1, 0x0

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/stub/StubApp;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_2

    .line 128
    :goto_2
    sget-object v0, Lcom/stub/StubApp;->ᵢˎ:Landroid/app/Application;

    .line 3136
    :try_start_3
    const-string v1, "com.qihoo.jiagutracker.TrackerMain"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 3137
    const-string v2, "init"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Class;

    const/4 v4, 0x0

    const-class v5, Landroid/app/Application;

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 3138
    const/4 v2, 0x0

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_1

    .line 3170
    :cond_2
    :goto_3
    :try_start_4
    const-string v0, "com.qihoo.util.bxb.init.DJadInit"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    const-string v1, "init"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Class;

    const/4 v3, 0x0

    const-class v4, Landroid/content/Context;

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 3171
    invoke-virtual {p0}, Lcom/stub/StubApp;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_0

    .line 3172
    :goto_4
    return-void

    .line 132
    :catch_0
    move-exception v0

    goto :goto_4

    :catch_1
    move-exception v0

    goto :goto_3

    :catch_2
    move-exception v0

    goto :goto_2

    :catch_3
    move-exception v0

    goto :goto_1

    :catch_4
    move-exception v0

    goto/16 :goto_0
.end method
