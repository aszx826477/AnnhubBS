.class Lcom/baidu/location/a/a$a;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/baidu/location/a/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "a"
.end annotation


# instance fields
.field public a:Ljava/lang/String;

.field public b:Landroid/os/Messenger;

.field public c:Lcom/baidu/location/LocationClientOption;

.field public d:I

.field final synthetic e:Lcom/baidu/location/a/a;


# direct methods
.method public constructor <init>(Lcom/baidu/location/a/a;Landroid/os/Message;)V
    .locals 5

    iput-object p1, p0, Lcom/baidu/location/a/a$a;->e:Lcom/baidu/location/a/a;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/baidu/location/a/a$a;->a:Ljava/lang/String;

    iput-object v0, p0, Lcom/baidu/location/a/a$a;->b:Landroid/os/Messenger;

    new-instance v0, Lcom/baidu/location/LocationClientOption;

    invoke-direct {v0}, Lcom/baidu/location/LocationClientOption;-><init>()V

    iput-object v0, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    const/4 v0, 0x0

    iput v0, p0, Lcom/baidu/location/a/a$a;->d:I

    iget-object v1, p2, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    iput-object v1, p0, Lcom/baidu/location/a/a$a;->b:Landroid/os/Messenger;

    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "packName"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/baidu/location/a/a$a;->a:Ljava/lang/String;

    iget-object v1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "prodName"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/baidu/location/LocationClientOption;->prodName:Ljava/lang/String;

    invoke-static {}, Lcom/baidu/location/d/b;->a()Lcom/baidu/location/d/b;

    move-result-object v1

    iget-object v2, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    iget-object v2, v2, Lcom/baidu/location/LocationClientOption;->prodName:Ljava/lang/String;

    iget-object v3, p0, Lcom/baidu/location/a/a$a;->a:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lcom/baidu/location/d/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "coorType"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/baidu/location/LocationClientOption;->coorType:Ljava/lang/String;

    iget-object v1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "addrType"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/baidu/location/LocationClientOption;->addrType:Ljava/lang/String;

    iget-object v1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "enableSimulateGps"

    invoke-virtual {v2, v3, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, v1, Lcom/baidu/location/LocationClientOption;->enableSimulateGps:Z

    sget-boolean v1, Lcom/baidu/location/d/j;->l:Z

    const/4 v2, 0x1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean v1, v1, Lcom/baidu/location/LocationClientOption;->enableSimulateGps:Z

    if-eqz v1, :cond_0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v1, 0x1

    :goto_1
    sput-boolean v1, Lcom/baidu/location/d/j;->l:Z

    sget-object v1, Lcom/baidu/location/d/j;->g:Ljava/lang/String;

    const-string v3, "all"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    iget-object v1, v1, Lcom/baidu/location/LocationClientOption;->addrType:Ljava/lang/String;

    sput-object v1, Lcom/baidu/location/d/j;->g:Ljava/lang/String;

    :cond_2
    iget-object v1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v3

    const-string v4, "openGPS"

    invoke-virtual {v3, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v3

    iput-boolean v3, v1, Lcom/baidu/location/LocationClientOption;->openGps:Z

    iget-object v1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v3

    const-string v4, "scanSpan"

    invoke-virtual {v3, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    iput v3, v1, Lcom/baidu/location/LocationClientOption;->scanSpan:I

    iget-object v1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v3

    const-string v4, "timeOut"

    invoke-virtual {v3, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    iput v3, v1, Lcom/baidu/location/LocationClientOption;->timeOut:I

    iget-object v1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v3

    const-string v4, "priority"

    invoke-virtual {v3, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    iput v3, v1, Lcom/baidu/location/LocationClientOption;->priority:I

    iget-object v1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v3

    const-string v4, "location_change_notify"

    invoke-virtual {v3, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v3

    iput-boolean v3, v1, Lcom/baidu/location/LocationClientOption;->location_change_notify:Z

    iget-object v1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v3

    const-string v4, "needDirect"

    invoke-virtual {v3, v4, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, v1, Lcom/baidu/location/LocationClientOption;->mIsNeedDeviceDirect:Z

    iget-object v1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v3

    const-string v4, "isneedaltitude"

    invoke-virtual {v3, v4, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, v1, Lcom/baidu/location/LocationClientOption;->isNeedAltitude:Z

    sget-boolean v1, Lcom/baidu/location/d/j;->h:Z

    if-nez v1, :cond_4

    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v1

    const-string v3, "isneedaptag"

    invoke-virtual {v1, v3, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_3

    goto :goto_2

    :cond_3
    const/4 v1, 0x0

    goto :goto_3

    :cond_4
    :goto_2
    const/4 v1, 0x1

    :goto_3
    sput-boolean v1, Lcom/baidu/location/d/j;->h:Z

    sget-boolean v1, Lcom/baidu/location/d/j;->i:Z

    if-nez v1, :cond_6

    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v1

    const-string v3, "isneedaptagd"

    invoke-virtual {v1, v3, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_5

    goto :goto_4

    :cond_5
    const/4 v2, 0x0

    :cond_6
    :goto_4
    sput-boolean v2, Lcom/baidu/location/d/j;->i:Z

    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "autoNotifyLocSensitivity"

    const/high16 v3, 0x3f000000    # 0.5f

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;F)F

    move-result v1

    sput v1, Lcom/baidu/location/d/j;->Q:F

    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "wifitimeout"

    const v3, 0x7fffffff

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    sget v2, Lcom/baidu/location/d/j;->ae:I

    if-ge v1, v2, :cond_7

    sput v1, Lcom/baidu/location/d/j;->ae:I

    :cond_7
    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "autoNotifyMaxInterval"

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    sget v2, Lcom/baidu/location/d/j;->V:I

    if-lt v1, v2, :cond_8

    sput v1, Lcom/baidu/location/d/j;->V:I

    :cond_8
    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "autoNotifyMinDistance"

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    sget v2, Lcom/baidu/location/d/j;->X:I

    if-lt v1, v2, :cond_9

    sput v1, Lcom/baidu/location/d/j;->X:I

    :cond_9
    invoke-virtual {p2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object p2

    const-string v1, "autoNotifyMinTimeInterval"

    invoke-virtual {p2, v1, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result p2

    sget v0, Lcom/baidu/location/d/j;->W:I

    if-lt p2, v0, :cond_a

    sput p2, Lcom/baidu/location/d/j;->W:I

    :cond_a
    iget-object p2, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    iget p2, p2, Lcom/baidu/location/LocationClientOption;->scanSpan:I

    iget-object p2, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean p2, p2, Lcom/baidu/location/LocationClientOption;->mIsNeedDeviceDirect:Z

    if-nez p2, :cond_b

    iget-object p2, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean p2, p2, Lcom/baidu/location/LocationClientOption;->isNeedAltitude:Z

    if-eqz p2, :cond_c

    :cond_b
    invoke-static {}, Lcom/baidu/location/a/n;->a()Lcom/baidu/location/a/n;

    move-result-object p2

    iget-object v0, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean v0, v0, Lcom/baidu/location/LocationClientOption;->mIsNeedDeviceDirect:Z

    invoke-virtual {p2, v0}, Lcom/baidu/location/a/n;->a(Z)V

    invoke-static {}, Lcom/baidu/location/a/n;->a()Lcom/baidu/location/a/n;

    move-result-object p2

    invoke-virtual {p2}, Lcom/baidu/location/a/n;->b()V

    :cond_c
    iget-boolean p2, p1, Lcom/baidu/location/a/a;->b:Z

    iget-object v0, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean v0, v0, Lcom/baidu/location/LocationClientOption;->isNeedAltitude:Z

    or-int/2addr p2, v0

    iput-boolean p2, p1, Lcom/baidu/location/a/a;->b:Z

    return-void
.end method

.method private a(I)V
    .locals 1

    const/4 v0, 0x0

    invoke-static {v0, p1}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object p1

    :try_start_0
    iget-object v0, p0, Lcom/baidu/location/a/a$a;->b:Landroid/os/Messenger;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/baidu/location/a/a$a;->b:Landroid/os/Messenger;

    invoke-virtual {v0, p1}, Landroid/os/Messenger;->send(Landroid/os/Message;)V

    :cond_0
    const/4 p1, 0x0

    iput p1, p0, Lcom/baidu/location/a/a$a;->d:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p1

    instance-of p1, p1, Landroid/os/DeadObjectException;

    if-eqz p1, :cond_1

    iget p1, p0, Lcom/baidu/location/a/a$a;->d:I

    add-int/lit8 p1, p1, 0x1

    iput p1, p0, Lcom/baidu/location/a/a$a;->d:I

    :cond_1
    :goto_0
    return-void
.end method

.method private a(ILandroid/os/Bundle;)V
    .locals 1

    const/4 v0, 0x0

    invoke-static {v0, p1}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object p1

    invoke-virtual {p1, p2}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    :try_start_0
    iget-object p2, p0, Lcom/baidu/location/a/a$a;->b:Landroid/os/Messenger;

    if-eqz p2, :cond_0

    iget-object p2, p0, Lcom/baidu/location/a/a$a;->b:Landroid/os/Messenger;

    invoke-virtual {p2, p1}, Landroid/os/Messenger;->send(Landroid/os/Message;)V

    :cond_0
    const/4 p1, 0x0

    iput p1, p0, Lcom/baidu/location/a/a$a;->d:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p1

    instance-of p2, p1, Landroid/os/DeadObjectException;

    if-eqz p2, :cond_1

    iget p2, p0, Lcom/baidu/location/a/a$a;->d:I

    add-int/lit8 p2, p2, 0x1

    iput p2, p0, Lcom/baidu/location/a/a$a;->d:I

    :cond_1
    invoke-virtual {p1}, Ljava/lang/Exception;->printStackTrace()V

    :goto_0
    return-void
.end method

.method private a(ILjava/lang/String;Lcom/baidu/location/BDLocation;)V
    .locals 1

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    invoke-virtual {v0, p2, p3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    const-class p2, Lcom/baidu/location/BDLocation;

    invoke-virtual {p2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object p2

    invoke-virtual {v0, p2}, Landroid/os/Bundle;->setClassLoader(Ljava/lang/ClassLoader;)V

    const/4 p2, 0x0

    invoke-static {p2, p1}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object p1

    invoke-virtual {p1, v0}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    :try_start_0
    iget-object p2, p0, Lcom/baidu/location/a/a$a;->b:Landroid/os/Messenger;

    if-eqz p2, :cond_0

    iget-object p2, p0, Lcom/baidu/location/a/a$a;->b:Landroid/os/Messenger;

    invoke-virtual {p2, p1}, Landroid/os/Messenger;->send(Landroid/os/Message;)V

    :cond_0
    const/4 p1, 0x0

    iput p1, p0, Lcom/baidu/location/a/a$a;->d:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p1

    instance-of p1, p1, Landroid/os/DeadObjectException;

    if-eqz p1, :cond_1

    iget p1, p0, Lcom/baidu/location/a/a$a;->d:I

    add-int/lit8 p1, p1, 0x1

    iput p1, p0, Lcom/baidu/location/a/a$a;->d:I

    :cond_1
    :goto_0
    return-void
.end method

.method static synthetic a(Lcom/baidu/location/a/a$a;I)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/a/a$a;->a(I)V

    return-void
.end method

.method static synthetic a(Lcom/baidu/location/a/a$a;ILandroid/os/Bundle;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/baidu/location/a/a$a;->a(ILandroid/os/Bundle;)V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    iget-object v0, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean v0, v0, Lcom/baidu/location/LocationClientOption;->location_change_notify:Z

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    sget-boolean v0, Lcom/baidu/location/d/j;->b:Z

    if-eqz v0, :cond_0

    const/16 v0, 0x36

    goto :goto_0

    :cond_0
    const/16 v0, 0x37

    :goto_0
    invoke-direct {p0, v0}, Lcom/baidu/location/a/a$a;->a(I)V

    :cond_1
    return-void
.end method

.method public a(Lcom/baidu/location/BDLocation;)V
    .locals 1

    const/16 v0, 0x15

    invoke-virtual {p0, p1, v0}, Lcom/baidu/location/a/a$a;->a(Lcom/baidu/location/BDLocation;I)V

    return-void
.end method

.method public a(Lcom/baidu/location/BDLocation;I)V
    .locals 8

    new-instance v0, Lcom/baidu/location/BDLocation;

    invoke-direct {v0, p1}, Lcom/baidu/location/BDLocation;-><init>(Lcom/baidu/location/BDLocation;)V

    const/16 p1, 0x15

    if-ne p2, p1, :cond_0

    const/16 p1, 0x1b

    const-string v1, "locStr"

    invoke-direct {p0, p1, v1, v0}, Lcom/baidu/location/a/a$a;->a(ILjava/lang/String;Lcom/baidu/location/BDLocation;)V

    :cond_0
    iget-object p1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    iget-object p1, p1, Lcom/baidu/location/LocationClientOption;->coorType:Ljava/lang/String;

    if-eqz p1, :cond_4

    iget-object p1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    iget-object p1, p1, Lcom/baidu/location/LocationClientOption;->coorType:Ljava/lang/String;

    const-string v1, "gcj02"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_4

    invoke-virtual {v0}, Lcom/baidu/location/BDLocation;->getLongitude()D

    move-result-wide v1

    invoke-virtual {v0}, Lcom/baidu/location/BDLocation;->getLatitude()D

    move-result-wide v3

    const-wide/16 v5, 0x1

    cmpl-double p1, v1, v5

    if-eqz p1, :cond_4

    cmpl-double p1, v3, v5

    if-eqz p1, :cond_4

    invoke-virtual {v0}, Lcom/baidu/location/BDLocation;->getCoorType()Ljava/lang/String;

    move-result-object p1

    const/4 v5, 0x1

    const/4 v6, 0x0

    if-eqz p1, :cond_1

    invoke-virtual {v0}, Lcom/baidu/location/BDLocation;->getCoorType()Ljava/lang/String;

    move-result-object p1

    const-string v7, "gcj02"

    invoke-virtual {p1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_2

    :cond_1
    invoke-virtual {v0}, Lcom/baidu/location/BDLocation;->getCoorType()Ljava/lang/String;

    move-result-object p1

    if-nez p1, :cond_3

    :cond_2
    iget-object p1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    iget-object p1, p1, Lcom/baidu/location/LocationClientOption;->coorType:Ljava/lang/String;

    invoke-static {v1, v2, v3, v4, p1}, Lcom/baidu/location/Jni;->coorEncrypt(DDLjava/lang/String;)[D

    move-result-object p1

    aget-wide v1, p1, v6

    invoke-virtual {v0, v1, v2}, Lcom/baidu/location/BDLocation;->setLongitude(D)V

    aget-wide v1, p1, v5

    invoke-virtual {v0, v1, v2}, Lcom/baidu/location/BDLocation;->setLatitude(D)V

    iget-object p1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    iget-object p1, p1, Lcom/baidu/location/LocationClientOption;->coorType:Ljava/lang/String;

    :goto_0
    invoke-virtual {v0, p1}, Lcom/baidu/location/BDLocation;->setCoorType(Ljava/lang/String;)V

    goto :goto_1

    :cond_3
    invoke-virtual {v0}, Lcom/baidu/location/BDLocation;->getCoorType()Ljava/lang/String;

    move-result-object p1

    if-eqz p1, :cond_4

    invoke-virtual {v0}, Lcom/baidu/location/BDLocation;->getCoorType()Ljava/lang/String;

    move-result-object p1

    const-string v7, "wgs84"

    invoke-virtual {p1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_4

    iget-object p1, p0, Lcom/baidu/location/a/a$a;->c:Lcom/baidu/location/LocationClientOption;

    iget-object p1, p1, Lcom/baidu/location/LocationClientOption;->coorType:Ljava/lang/String;

    const-string v7, "bd09ll"

    invoke-virtual {p1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_4

    const-string p1, "wgs842mc"

    invoke-static {v1, v2, v3, v4, p1}, Lcom/baidu/location/Jni;->coorEncrypt(DDLjava/lang/String;)[D

    move-result-object p1

    aget-wide v1, p1, v6

    invoke-virtual {v0, v1, v2}, Lcom/baidu/location/BDLocation;->setLongitude(D)V

    aget-wide v1, p1, v5

    invoke-virtual {v0, v1, v2}, Lcom/baidu/location/BDLocation;->setLatitude(D)V

    const-string p1, "wgs84mc"

    goto :goto_0

    :cond_4
    :goto_1
    const-string p1, "locStr"

    invoke-direct {p0, p2, p1, v0}, Lcom/baidu/location/a/a$a;->a(ILjava/lang/String;Lcom/baidu/location/BDLocation;)V

    return-void
.end method
