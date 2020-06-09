.class Lcom/baidu/location/b/e$a;
.super Landroid/location/GnssStatus$Callback;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x18
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/baidu/location/b/e;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "a"
.end annotation


# instance fields
.field final synthetic a:Lcom/baidu/location/b/e;


# direct methods
.method private constructor <init>(Lcom/baidu/location/b/e;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/b/e$a;->a:Lcom/baidu/location/b/e;

    invoke-direct {p0}, Landroid/location/GnssStatus$Callback;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/baidu/location/b/e;Lcom/baidu/location/b/f;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/b/e$a;-><init>(Lcom/baidu/location/b/e;)V

    return-void
.end method


# virtual methods
.method public onFirstFix(I)V
    .locals 0

    return-void
.end method

.method public onSatelliteStatusChanged(Landroid/location/GnssStatus;)V
    .locals 7

    iget-object v0, p0, Lcom/baidu/location/b/e$a;->a:Lcom/baidu/location/b/e;

    invoke-static {v0}, Lcom/baidu/location/b/e;->c(Lcom/baidu/location/b/e;)Landroid/location/LocationManager;

    move-result-object v0

    if-nez v0, :cond_0

    return-void

    :cond_0
    invoke-virtual {p1}, Landroid/location/GnssStatus;->getSatelliteCount()I

    move-result v0

    iget-object v1, p0, Lcom/baidu/location/b/e$a;->a:Lcom/baidu/location/b/e;

    invoke-static {v1}, Lcom/baidu/location/b/e;->d(Lcom/baidu/location/b/e;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    :goto_0
    if-ge v1, v0, :cond_3

    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {p1, v1}, Landroid/location/GnssStatus;->usedInFix(I)Z

    move-result v5

    if-eqz v5, :cond_2

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {p1, v1}, Landroid/location/GnssStatus;->getConstellationType(I)I

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_1

    add-int/lit8 v3, v3, 0x1

    invoke-virtual {p1, v1}, Landroid/location/GnssStatus;->getCn0DbHz(I)F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-virtual {p1, v1}, Landroid/location/GnssStatus;->getAzimuthDegrees(I)F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-virtual {p1, v1}, Landroid/location/GnssStatus;->getElevationDegrees(I)F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/high16 v5, 0x3f800000    # 1.0f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_1
    iget-object v5, p0, Lcom/baidu/location/b/e$a;->a:Lcom/baidu/location/b/e;

    invoke-static {v5}, Lcom/baidu/location/b/e;->d(Lcom/baidu/location/b/e;)Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_3
    invoke-static {v2}, Lcom/baidu/location/b/e;->a(I)I

    invoke-static {v3}, Lcom/baidu/location/b/e;->b(I)I

    return-void
.end method

.method public onStarted()V
    .locals 0

    return-void
.end method

.method public onStopped()V
    .locals 2

    iget-object v0, p0, Lcom/baidu/location/b/e$a;->a:Lcom/baidu/location/b/e;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/baidu/location/b/e;->b(Lcom/baidu/location/b/e;Landroid/location/Location;)V

    iget-object v0, p0, Lcom/baidu/location/b/e$a;->a:Lcom/baidu/location/b/e;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/baidu/location/b/e;->a(Lcom/baidu/location/b/e;Z)V

    invoke-static {v1}, Lcom/baidu/location/b/e;->a(I)I

    invoke-static {v1}, Lcom/baidu/location/b/e;->b(I)I

    return-void
.end method
