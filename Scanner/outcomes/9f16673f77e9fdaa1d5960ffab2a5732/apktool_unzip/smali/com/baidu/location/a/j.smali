.class public Lcom/baidu/location/a/j;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/baidu/lbsapi/auth/LBSAuthManagerListener;


# static fields
.field private static a:Ljava/lang/Object;

.field private static b:Lcom/baidu/location/a/j;


# instance fields
.field private c:I

.field private d:Landroid/content/Context;

.field private e:J

.field private f:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/baidu/location/a/j;->a:Ljava/lang/Object;

    const/4 v0, 0x0

    sput-object v0, Lcom/baidu/location/a/j;->b:Lcom/baidu/location/a/j;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcom/baidu/location/a/j;->c:I

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/baidu/location/a/j;->d:Landroid/content/Context;

    const-wide/16 v1, 0x0

    iput-wide v1, p0, Lcom/baidu/location/a/j;->e:J

    iput-object v0, p0, Lcom/baidu/location/a/j;->f:Ljava/lang/String;

    return-void
.end method

.method public static a()Lcom/baidu/location/a/j;
    .locals 2

    sget-object v0, Lcom/baidu/location/a/j;->a:Ljava/lang/Object;

    monitor-enter v0

    :try_start_0
    sget-object v1, Lcom/baidu/location/a/j;->b:Lcom/baidu/location/a/j;

    if-nez v1, :cond_0

    new-instance v1, Lcom/baidu/location/a/j;

    invoke-direct {v1}, Lcom/baidu/location/a/j;-><init>()V

    sput-object v1, Lcom/baidu/location/a/j;->b:Lcom/baidu/location/a/j;

    :cond_0
    sget-object v1, Lcom/baidu/location/a/j;->b:Lcom/baidu/location/a/j;

    monitor-exit v0

    return-object v1

    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public static b(Landroid/content/Context;)Ljava/lang/String;
    .locals 1

    :try_start_0
    invoke-static {p0}, Lcom/baidu/lbsapi/auth/LBSAuthManager;->getInstance(Landroid/content/Context;)Lcom/baidu/lbsapi/auth/LBSAuthManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/baidu/lbsapi/auth/LBSAuthManager;->getPublicKey(Landroid/content/Context;)Ljava/lang/String;

    move-result-object p0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p0

    invoke-virtual {p0}, Ljava/lang/Exception;->printStackTrace()V

    const/4 p0, 0x0

    :goto_0
    return-object p0
.end method

.method public static c(Landroid/content/Context;)Ljava/lang/String;
    .locals 0

    :try_start_0
    invoke-static {p0}, Lcom/baidu/lbsapi/auth/LBSAuthManager;->getInstance(Landroid/content/Context;)Lcom/baidu/lbsapi/auth/LBSAuthManager;

    move-result-object p0

    invoke-virtual {p0}, Lcom/baidu/lbsapi/auth/LBSAuthManager;->getMCode()Ljava/lang/String;

    move-result-object p0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p0

    invoke-virtual {p0}, Ljava/lang/Exception;->printStackTrace()V

    const/4 p0, 0x0

    :goto_0
    return-object p0
.end method


# virtual methods
.method public a(Landroid/content/Context;)V
    .locals 3

    iput-object p1, p0, Lcom/baidu/location/a/j;->d:Landroid/content/Context;

    iget-object p1, p0, Lcom/baidu/location/a/j;->d:Landroid/content/Context;

    invoke-static {p1}, Lcom/baidu/lbsapi/auth/LBSAuthManager;->getInstance(Landroid/content/Context;)Lcom/baidu/lbsapi/auth/LBSAuthManager;

    move-result-object p1

    const-string v0, "lbs_locsdk"

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {p1, v1, v0, v2, p0}, Lcom/baidu/lbsapi/auth/LBSAuthManager;->authenticate(ZLjava/lang/String;Ljava/util/Hashtable;Lcom/baidu/lbsapi/auth/LBSAuthManagerListener;)I

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/baidu/location/a/j;->e:J

    return-void
.end method

.method public b()Z
    .locals 8

    iget v0, p0, Lcom/baidu/location/a/j;->c:I

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    const/16 v2, 0x25a

    if-eq v0, v2, :cond_0

    const/16 v2, 0x259

    if-eq v0, v2, :cond_0

    const/16 v2, -0xa

    if-eq v0, v2, :cond_0

    const/16 v2, -0xb

    if-eq v0, v2, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :cond_0
    const/4 v0, 0x1

    :goto_0
    iget-object v2, p0, Lcom/baidu/location/a/j;->d:Landroid/content/Context;

    if-eqz v2, :cond_3

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/baidu/location/a/j;->e:J

    sub-long/2addr v2, v4

    const/4 v4, 0x0

    if-eqz v0, :cond_1

    const-wide/32 v5, 0x5265c00

    cmp-long v7, v2, v5

    if-lez v7, :cond_3

    goto :goto_1

    :cond_1
    const-wide/16 v5, 0x0

    cmp-long v7, v2, v5

    if-ltz v7, :cond_2

    const-wide/16 v5, 0x2710

    cmp-long v7, v2, v5

    if-lez v7, :cond_3

    :cond_2
    :goto_1
    iget-object v2, p0, Lcom/baidu/location/a/j;->d:Landroid/content/Context;

    invoke-static {v2}, Lcom/baidu/lbsapi/auth/LBSAuthManager;->getInstance(Landroid/content/Context;)Lcom/baidu/lbsapi/auth/LBSAuthManager;

    move-result-object v2

    const-string v3, "lbs_locsdk"

    invoke-virtual {v2, v1, v3, v4, p0}, Lcom/baidu/lbsapi/auth/LBSAuthManager;->authenticate(ZLjava/lang/String;Ljava/util/Hashtable;Lcom/baidu/lbsapi/auth/LBSAuthManagerListener;)I

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    iput-wide v1, p0, Lcom/baidu/location/a/j;->e:J

    :cond_3
    return v0
.end method

.method public onAuthResult(ILjava/lang/String;)V
    .locals 3

    iput p1, p0, Lcom/baidu/location/a/j;->c:I

    iget v0, p0, Lcom/baidu/location/a/j;->c:I

    if-nez v0, :cond_0

    sget-object p1, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v0, "LocationAuthManager Authentication AUTHENTICATE_SUCC"

    invoke-static {p1, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    :cond_0
    sget-object v0, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "LocationAuthManager Authentication Error errorcode = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, " , msg = "

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v0, p1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    :goto_0
    if-eqz p2, :cond_1

    :try_start_0
    new-instance p1, Lorg/json/JSONObject;

    invoke-direct {p1, p2}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string p2, "token"

    invoke-virtual {p1, p2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    if-eqz p2, :cond_1

    const-string p2, "token"

    invoke-virtual {p1, p2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lcom/baidu/location/a/j;->f:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception p1

    invoke-virtual {p1}, Ljava/lang/Exception;->printStackTrace()V

    :cond_1
    :goto_1
    return-void
.end method
