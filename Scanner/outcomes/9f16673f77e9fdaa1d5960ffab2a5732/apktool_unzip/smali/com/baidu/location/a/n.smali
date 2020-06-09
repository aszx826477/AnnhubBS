.class public Lcom/baidu/location/a/n;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/hardware/SensorEventListener;


# static fields
.field private static c:Lcom/baidu/location/a/n;


# instance fields
.field private a:[F

.field private b:Landroid/hardware/SensorManager;

.field private d:F

.field private e:Z

.field private f:Z

.field private g:Z


# direct methods
.method private constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/baidu/location/a/n;->e:Z

    iput-boolean v0, p0, Lcom/baidu/location/a/n;->f:Z

    iput-boolean v0, p0, Lcom/baidu/location/a/n;->g:Z

    return-void
.end method

.method public static declared-synchronized a()Lcom/baidu/location/a/n;
    .locals 2

    const-class v0, Lcom/baidu/location/a/n;

    monitor-enter v0

    :try_start_0
    sget-object v1, Lcom/baidu/location/a/n;->c:Lcom/baidu/location/a/n;

    if-nez v1, :cond_0

    new-instance v1, Lcom/baidu/location/a/n;

    invoke-direct {v1}, Lcom/baidu/location/a/n;-><init>()V

    sput-object v1, Lcom/baidu/location/a/n;->c:Lcom/baidu/location/a/n;

    :cond_0
    sget-object v1, Lcom/baidu/location/a/n;->c:Lcom/baidu/location/a/n;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method


# virtual methods
.method public a(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/baidu/location/a/n;->e:Z

    return-void
.end method

.method public declared-synchronized b()V
    .locals 3

    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/baidu/location/a/n;->g:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    monitor-exit p0

    return-void

    :cond_0
    :try_start_1
    iget-boolean v0, p0, Lcom/baidu/location/a/n;->e:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v0, :cond_1

    monitor-exit p0

    return-void

    :cond_1
    :try_start_2
    iget-object v0, p0, Lcom/baidu/location/a/n;->b:Landroid/hardware/SensorManager;

    if-nez v0, :cond_2

    invoke-static {}, Lcom/baidu/location/f;->getServiceContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "sensor"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/hardware/SensorManager;

    iput-object v0, p0, Lcom/baidu/location/a/n;->b:Landroid/hardware/SensorManager;

    :cond_2
    iget-object v0, p0, Lcom/baidu/location/a/n;->b:Landroid/hardware/SensorManager;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/baidu/location/a/n;->b:Landroid/hardware/SensorManager;

    const/16 v1, 0xb

    invoke-virtual {v0, v1}, Landroid/hardware/SensorManager;->getDefaultSensor(I)Landroid/hardware/Sensor;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-boolean v1, p0, Lcom/baidu/location/a/n;->e:Z

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/baidu/location/a/n;->b:Landroid/hardware/SensorManager;

    const/4 v2, 0x3

    invoke-virtual {v1, p0, v0, v2}, Landroid/hardware/SensorManager;->registerListener(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z

    :cond_3
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/baidu/location/a/n;->g:Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized c()V
    .locals 1

    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/baidu/location/a/n;->g:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    monitor-exit p0

    return-void

    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/baidu/location/a/n;->b:Landroid/hardware/SensorManager;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/baidu/location/a/n;->b:Landroid/hardware/SensorManager;

    invoke-virtual {v0, p0}, Landroid/hardware/SensorManager;->unregisterListener(Landroid/hardware/SensorEventListener;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/baidu/location/a/n;->b:Landroid/hardware/SensorManager;

    :cond_1
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/baidu/location/a/n;->g:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public d()Z
    .locals 1

    iget-boolean v0, p0, Lcom/baidu/location/a/n;->e:Z

    return v0
.end method

.method public e()F
    .locals 1

    iget v0, p0, Lcom/baidu/location/a/n;->d:F

    return v0
.end method

.method public onAccuracyChanged(Landroid/hardware/Sensor;I)V
    .locals 0

    return-void
.end method

.method public onSensorChanged(Landroid/hardware/SensorEvent;)V
    .locals 4
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    iget-object v0, p1, Landroid/hardware/SensorEvent;->sensor:Landroid/hardware/Sensor;

    invoke-virtual {v0}, Landroid/hardware/Sensor;->getType()I

    move-result v0

    const/16 v1, 0xb

    if-eq v0, v1, :cond_0

    goto :goto_2

    :cond_0
    iget-object p1, p1, Landroid/hardware/SensorEvent;->values:[F

    invoke-virtual {p1}, [F->clone()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [F

    iput-object p1, p0, Lcom/baidu/location/a/n;->a:[F

    iget-object p1, p0, Lcom/baidu/location/a/n;->a:[F

    if-eqz p1, :cond_2

    const/16 v0, 0x9

    new-array v0, v0, [F

    const/4 v1, 0x0

    :try_start_0
    invoke-static {v0, p1}, Landroid/hardware/SensorManager;->getRotationMatrixFromVector([F[F)V

    const/4 p1, 0x3

    new-array p1, p1, [F

    invoke-static {v0, p1}, Landroid/hardware/SensorManager;->getOrientation([F[F)[F

    const/4 v0, 0x0

    aget p1, p1, v0

    float-to-double v2, p1

    invoke-static {v2, v3}, Ljava/lang/Math;->toDegrees(D)D

    move-result-wide v2

    double-to-float p1, v2

    iput p1, p0, Lcom/baidu/location/a/n;->d:F

    iget p1, p0, Lcom/baidu/location/a/n;->d:F

    cmpl-float p1, p1, v1

    if-ltz p1, :cond_1

    iget p1, p0, Lcom/baidu/location/a/n;->d:F

    :goto_0
    float-to-double v2, p1

    goto :goto_1

    :cond_1
    iget p1, p0, Lcom/baidu/location/a/n;->d:F

    const/high16 v0, 0x43b40000    # 360.0f

    add-float/2addr p1, v0

    goto :goto_0

    :goto_1
    invoke-static {v2, v3}, Ljava/lang/Math;->floor(D)D

    move-result-wide v2

    double-to-float p1, v2

    iput p1, p0, Lcom/baidu/location/a/n;->d:F
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    :catch_0
    move-exception p1

    iput v1, p0, Lcom/baidu/location/a/n;->d:F

    :cond_2
    :goto_2
    return-void
.end method
