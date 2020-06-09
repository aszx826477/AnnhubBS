.class public Lorg/litepal/tablemanager/Connector;
.super Ljava/lang/Object;
.source "Connector.java"


# static fields
.field private static mLitePalAttr:Lorg/litepal/parser/LitePalAttr;

.field private static mLitePalHelper:Lorg/litepal/tablemanager/LitePalOpenHelper;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static buildConnection()Lorg/litepal/tablemanager/LitePalOpenHelper;
    .locals 4

    .line 112
    sget-object v0, Lorg/litepal/tablemanager/Connector;->mLitePalAttr:Lorg/litepal/parser/LitePalAttr;

    if-nez v0, :cond_0

    .line 113
    invoke-static {}, Lorg/litepal/parser/LitePalParser;->parseLitePalConfiguration()V

    .line 114
    invoke-static {}, Lorg/litepal/parser/LitePalAttr;->getInstance()Lorg/litepal/parser/LitePalAttr;

    move-result-object v0

    sput-object v0, Lorg/litepal/tablemanager/Connector;->mLitePalAttr:Lorg/litepal/parser/LitePalAttr;

    goto :goto_0

    .line 112
    :cond_0
    nop

    .line 116
    :goto_0
    sget-object v0, Lorg/litepal/tablemanager/Connector;->mLitePalAttr:Lorg/litepal/parser/LitePalAttr;

    invoke-virtual {v0}, Lorg/litepal/parser/LitePalAttr;->checkSelfValid()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 117
    sget-object v0, Lorg/litepal/tablemanager/Connector;->mLitePalHelper:Lorg/litepal/tablemanager/LitePalOpenHelper;

    if-nez v0, :cond_2

    .line 118
    sget-object v0, Lorg/litepal/tablemanager/Connector;->mLitePalAttr:Lorg/litepal/parser/LitePalAttr;

    invoke-virtual {v0}, Lorg/litepal/parser/LitePalAttr;->getDbName()Ljava/lang/String;

    move-result-object v0

    .line 119
    .local v0, "dbName":Ljava/lang/String;
    const-string v1, "external"

    sget-object v2, Lorg/litepal/tablemanager/Connector;->mLitePalAttr:Lorg/litepal/parser/LitePalAttr;

    invoke-virtual {v2}, Lorg/litepal/parser/LitePalAttr;->getStorage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 120
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lorg/litepal/LitePalApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v2, v3}, Landroid/content/Context;->getExternalFilesDir(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, "/databases/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 119
    :cond_1
    nop

    .line 122
    :goto_1
    new-instance v1, Lorg/litepal/tablemanager/LitePalOpenHelper;

    sget-object v2, Lorg/litepal/tablemanager/Connector;->mLitePalAttr:Lorg/litepal/parser/LitePalAttr;

    invoke-virtual {v2}, Lorg/litepal/parser/LitePalAttr;->getVersion()I

    move-result v2

    invoke-direct {v1, v0, v2}, Lorg/litepal/tablemanager/LitePalOpenHelper;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lorg/litepal/tablemanager/Connector;->mLitePalHelper:Lorg/litepal/tablemanager/LitePalOpenHelper;

    goto :goto_2

    .line 117
    .end local v0    # "dbName":Ljava/lang/String;
    :cond_2
    nop

    .line 124
    :goto_2
    sget-object v0, Lorg/litepal/tablemanager/Connector;->mLitePalHelper:Lorg/litepal/tablemanager/LitePalOpenHelper;

    return-object v0

    .line 126
    :cond_3
    new-instance v0, Lorg/litepal/exceptions/InvalidAttributesException;

    const-string v1, "Uncaught invalid attributes exception happened"

    invoke-direct {v0, v1}, Lorg/litepal/exceptions/InvalidAttributesException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static getDatabase()Landroid/database/sqlite/SQLiteDatabase;
    .locals 1

    .line 95
    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    return-object v0
.end method

.method public static declared-synchronized getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    .locals 3

    const-class v0, Lorg/litepal/tablemanager/Connector;

    monitor-enter v0

    .line 80
    :try_start_0
    invoke-static {}, Lorg/litepal/tablemanager/Connector;->buildConnection()Lorg/litepal/tablemanager/LitePalOpenHelper;

    move-result-object v1

    .line 81
    .local v1, "litePalHelper":Lorg/litepal/tablemanager/LitePalOpenHelper;
    invoke-virtual {v1}, Lorg/litepal/tablemanager/LitePalOpenHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v2

    .line 79
    .end local v1    # "litePalHelper":Lorg/litepal/tablemanager/LitePalOpenHelper;
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    .locals 3

    const-class v0, Lorg/litepal/tablemanager/Connector;

    monitor-enter v0

    .line 62
    :try_start_0
    invoke-static {}, Lorg/litepal/tablemanager/Connector;->buildConnection()Lorg/litepal/tablemanager/LitePalOpenHelper;

    move-result-object v1

    .line 63
    .local v1, "litePalHelper":Lorg/litepal/tablemanager/LitePalOpenHelper;
    invoke-virtual {v1}, Lorg/litepal/tablemanager/LitePalOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v2

    .line 61
    .end local v1    # "litePalHelper":Lorg/litepal/tablemanager/LitePalOpenHelper;
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method
