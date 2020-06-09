.class public Lcom/baidu/location/a/k$e;
.super Lcom/baidu/location/BDAbstractLocationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/baidu/location/a/k;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "e"
.end annotation


# instance fields
.field final synthetic a:Lcom/baidu/location/a/k;


# direct methods
.method public constructor <init>(Lcom/baidu/location/a/k;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/a/k$e;->a:Lcom/baidu/location/a/k;

    invoke-direct {p0}, Lcom/baidu/location/BDAbstractLocationListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceiveLocation(Lcom/baidu/location/BDLocation;)V
    .locals 3

    iget-object v0, p0, Lcom/baidu/location/a/k$e;->a:Lcom/baidu/location/a/k;

    invoke-static {v0}, Lcom/baidu/location/a/k;->a(Lcom/baidu/location/a/k;)Z

    move-result v0

    if-eqz v0, :cond_5

    if-eqz p1, :cond_5

    new-instance v0, Lcom/baidu/location/BDLocation;

    invoke-direct {v0, p1}, Lcom/baidu/location/BDLocation;-><init>(Lcom/baidu/location/BDLocation;)V

    invoke-virtual {v0}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result p1

    invoke-virtual {v0}, Lcom/baidu/location/BDLocation;->getCoorType()Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0x3d

    if-eq p1, v2, :cond_1

    const/16 v2, 0xa1

    if-eq p1, v2, :cond_1

    const/16 v2, 0x42

    if-ne p1, v2, :cond_0

    goto :goto_0

    :cond_0
    iget-object p1, p0, Lcom/baidu/location/a/k$e;->a:Lcom/baidu/location/a/k;

    invoke-static {p1}, Lcom/baidu/location/a/k;->b(Lcom/baidu/location/a/k;)Lcom/baidu/location/a/k$a;

    move-result-object p1

    const/4 v0, 0x5

    invoke-virtual {p1, v0}, Lcom/baidu/location/a/k$a;->obtainMessage(I)Landroid/os/Message;

    move-result-object p1

    goto :goto_3

    :cond_1
    :goto_0
    if-eqz v1, :cond_4

    const-string p1, "gcj02"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_2

    const-string p1, "gcj2wgs"

    invoke-static {v0, p1}, Lcom/baidu/location/LocationClient;->getBDLocationInCoorType(Lcom/baidu/location/BDLocation;Ljava/lang/String;)Lcom/baidu/location/BDLocation;

    move-result-object v0

    goto :goto_2

    :cond_2
    const-string p1, "bd09"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_3

    const-string p1, "bd092gcj"

    :goto_1
    invoke-static {v0, p1}, Lcom/baidu/location/LocationClient;->getBDLocationInCoorType(Lcom/baidu/location/BDLocation;Ljava/lang/String;)Lcom/baidu/location/BDLocation;

    move-result-object p1

    const-string v0, "gcj2wgs"

    invoke-static {p1, v0}, Lcom/baidu/location/LocationClient;->getBDLocationInCoorType(Lcom/baidu/location/BDLocation;Ljava/lang/String;)Lcom/baidu/location/BDLocation;

    move-result-object v0

    goto :goto_2

    :cond_3
    const-string p1, "bd09ll"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_4

    const-string p1, "bd09ll2gcj"

    goto :goto_1

    :cond_4
    :goto_2
    iget-object p1, p0, Lcom/baidu/location/a/k$e;->a:Lcom/baidu/location/a/k;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    invoke-static {p1, v1, v2}, Lcom/baidu/location/a/k;->a(Lcom/baidu/location/a/k;J)J

    iget-object p1, p0, Lcom/baidu/location/a/k$e;->a:Lcom/baidu/location/a/k;

    new-instance v1, Lcom/baidu/location/BDLocation;

    invoke-direct {v1, v0}, Lcom/baidu/location/BDLocation;-><init>(Lcom/baidu/location/BDLocation;)V

    invoke-static {p1, v1}, Lcom/baidu/location/a/k;->a(Lcom/baidu/location/a/k;Lcom/baidu/location/BDLocation;)Lcom/baidu/location/BDLocation;

    iget-object p1, p0, Lcom/baidu/location/a/k$e;->a:Lcom/baidu/location/a/k;

    invoke-static {p1}, Lcom/baidu/location/a/k;->b(Lcom/baidu/location/a/k;)Lcom/baidu/location/a/k$a;

    move-result-object p1

    const/4 v1, 0x2

    invoke-virtual {p1, v1}, Lcom/baidu/location/a/k$a;->obtainMessage(I)Landroid/os/Message;

    move-result-object p1

    iput-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    :goto_3
    invoke-virtual {p1}, Landroid/os/Message;->sendToTarget()V

    :cond_5
    return-void
.end method
