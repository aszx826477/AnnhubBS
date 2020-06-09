.class Lcom/baidu/location/b/h$a;
.super Landroid/content/BroadcastReceiver;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/baidu/location/b/h;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "a"
.end annotation


# instance fields
.field final synthetic a:Lcom/baidu/location/b/h;

.field private b:J

.field private c:Z


# direct methods
.method private constructor <init>(Lcom/baidu/location/b/h;)V
    .locals 2

    iput-object p1, p0, Lcom/baidu/location/b/h$a;->a:Lcom/baidu/location/b/h;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/baidu/location/b/h$a;->b:J

    const/4 p1, 0x0

    iput-boolean p1, p0, Lcom/baidu/location/b/h$a;->c:Z

    return-void
.end method

.method synthetic constructor <init>(Lcom/baidu/location/b/h;Lcom/baidu/location/b/h$1;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/b/h$a;-><init>(Lcom/baidu/location/b/h;)V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3

    if-nez p1, :cond_0

    return-void

    :cond_0
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object p1

    const-string v0, "android.net.wifi.SCAN_RESULTS"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide p1

    const-wide/16 v0, 0x3e8

    div-long/2addr p1, v0

    sput-wide p1, Lcom/baidu/location/b/h;->a:J

    iget-object p1, p0, Lcom/baidu/location/b/h$a;->a:Lcom/baidu/location/b/h;

    invoke-static {p1}, Lcom/baidu/location/b/h;->b(Lcom/baidu/location/b/h;)Landroid/os/Handler;

    move-result-object p1

    new-instance p2, Lcom/baidu/location/b/i;

    invoke-direct {p2, p0}, Lcom/baidu/location/b/i;-><init>(Lcom/baidu/location/b/h$a;)V

    invoke-virtual {p1, p2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    :cond_1
    const-string v0, "android.net.wifi.STATE_CHANGE"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_4

    const-string p1, "networkInfo"

    invoke-virtual {p2, p1}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Landroid/net/NetworkInfo;

    invoke-virtual {p1}, Landroid/net/NetworkInfo;->getState()Landroid/net/NetworkInfo$State;

    move-result-object p1

    sget-object p2, Landroid/net/NetworkInfo$State;->CONNECTED:Landroid/net/NetworkInfo$State;

    invoke-virtual {p1, p2}, Landroid/net/NetworkInfo$State;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_2

    return-void

    :cond_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide p1

    iget-wide v0, p0, Lcom/baidu/location/b/h$a;->b:J

    sub-long/2addr p1, v0

    const-wide/16 v0, 0x1388

    cmp-long v2, p1, v0

    if-gez v2, :cond_3

    return-void

    :cond_3
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide p1

    iput-wide p1, p0, Lcom/baidu/location/b/h$a;->b:J

    iget-boolean p1, p0, Lcom/baidu/location/b/h$a;->c:Z

    if-nez p1, :cond_4

    const/4 p1, 0x1

    iput-boolean p1, p0, Lcom/baidu/location/b/h$a;->c:Z

    :cond_4
    :goto_0
    return-void
.end method
