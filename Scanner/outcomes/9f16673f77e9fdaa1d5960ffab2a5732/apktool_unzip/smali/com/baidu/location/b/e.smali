.class public Lcom/baidu/location/b/e;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/baidu/location/b/e$b;,
        Lcom/baidu/location/b/e$a;,
        Lcom/baidu/location/b/e$c;,
        Lcom/baidu/location/b/e$d;
    }
.end annotation


# static fields
.field private static C:D

.field private static D:Ljava/lang/String;

.field private static c:Lcom/baidu/location/b/e;

.field private static m:I

.field private static n:I

.field private static u:Ljava/lang/String;


# instance fields
.field private A:I

.field private B:I

.field private E:J

.field private F:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Ljava/util/ArrayList<",
            "Ljava/lang/Float;",
            ">;>;"
        }
    .end annotation
.end field

.field private final a:J

.field private final b:J

.field private d:Landroid/content/Context;

.field private e:Landroid/location/LocationManager;

.field private f:Landroid/location/Location;

.field private g:Lcom/baidu/location/b/e$c;

.field private h:Lcom/baidu/location/b/e$d;

.field private i:Landroid/location/GpsStatus;

.field private j:Lcom/baidu/location/b/e$a;

.field private k:Z

.field private l:Lcom/baidu/location/b/e$b;

.field private o:J

.field private p:Z

.field private q:Z

.field private r:Ljava/lang/String;

.field private s:Z

.field private t:J

.field private v:Landroid/os/Handler;

.field private final w:I

.field private final x:I

.field private final y:I

.field private final z:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    const/4 v0, 0x0

    sput-object v0, Lcom/baidu/location/b/e;->c:Lcom/baidu/location/b/e;

    const/4 v1, 0x0

    sput v1, Lcom/baidu/location/b/e;->m:I

    sput v1, Lcom/baidu/location/b/e;->n:I

    sput-object v0, Lcom/baidu/location/b/e;->u:Ljava/lang/String;

    const-wide/high16 v0, 0x4059000000000000L    # 100.0

    sput-wide v0, Lcom/baidu/location/b/e;->C:D

    const-string v0, ""

    sput-object v0, Lcom/baidu/location/b/e;->D:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-wide/16 v0, 0x3e8

    iput-wide v0, p0, Lcom/baidu/location/b/e;->a:J

    const-wide/16 v0, 0x2328

    iput-wide v0, p0, Lcom/baidu/location/b/e;->b:J

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/baidu/location/b/e;->e:Landroid/location/LocationManager;

    iput-object v0, p0, Lcom/baidu/location/b/e;->g:Lcom/baidu/location/b/e$c;

    iput-object v0, p0, Lcom/baidu/location/b/e;->h:Lcom/baidu/location/b/e$d;

    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/baidu/location/b/e;->k:Z

    iput-object v0, p0, Lcom/baidu/location/b/e;->l:Lcom/baidu/location/b/e$b;

    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lcom/baidu/location/b/e;->o:J

    iput-boolean v1, p0, Lcom/baidu/location/b/e;->p:Z

    iput-boolean v1, p0, Lcom/baidu/location/b/e;->q:Z

    iput-object v0, p0, Lcom/baidu/location/b/e;->r:Ljava/lang/String;

    iput-boolean v1, p0, Lcom/baidu/location/b/e;->s:Z

    iput-wide v2, p0, Lcom/baidu/location/b/e;->t:J

    iput-object v0, p0, Lcom/baidu/location/b/e;->v:Landroid/os/Handler;

    const/4 v0, 0x1

    iput v0, p0, Lcom/baidu/location/b/e;->w:I

    const/4 v4, 0x2

    iput v4, p0, Lcom/baidu/location/b/e;->x:I

    const/4 v4, 0x3

    iput v4, p0, Lcom/baidu/location/b/e;->y:I

    const/4 v4, 0x4

    iput v4, p0, Lcom/baidu/location/b/e;->z:I

    iput-wide v2, p0, Lcom/baidu/location/b/e;->E:J

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lcom/baidu/location/b/e;->F:Ljava/util/ArrayList;

    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x18

    if-lt v2, v3, :cond_0

    :try_start_0
    const-string v2, "android.location.GnssStatus"

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    iput-boolean v0, p0, Lcom/baidu/location/b/e;->k:Z
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    iput-boolean v1, p0, Lcom/baidu/location/b/e;->k:Z

    :cond_0
    :goto_0
    return-void
.end method

.method static synthetic a(D)D
    .locals 0

    sput-wide p0, Lcom/baidu/location/b/e;->C:D

    return-wide p0
.end method

.method static synthetic a(I)I
    .locals 0

    sput p0, Lcom/baidu/location/b/e;->m:I

    return p0
.end method

.method static synthetic a(Lcom/baidu/location/b/e;I)I
    .locals 0

    iput p1, p0, Lcom/baidu/location/b/e;->A:I

    return p1
.end method

.method static synthetic a(Lcom/baidu/location/b/e;J)J
    .locals 0

    iput-wide p1, p0, Lcom/baidu/location/b/e;->t:J

    return-wide p1
.end method

.method static synthetic a(Lcom/baidu/location/b/e;Landroid/location/GpsStatus;)Landroid/location/GpsStatus;
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/b/e;->i:Landroid/location/GpsStatus;

    return-object p1
.end method

.method public static declared-synchronized a()Lcom/baidu/location/b/e;
    .locals 2

    const-class v0, Lcom/baidu/location/b/e;

    monitor-enter v0

    :try_start_0
    sget-object v1, Lcom/baidu/location/b/e;->c:Lcom/baidu/location/b/e;

    if-nez v1, :cond_0

    new-instance v1, Lcom/baidu/location/b/e;

    invoke-direct {v1}, Lcom/baidu/location/b/e;-><init>()V

    sput-object v1, Lcom/baidu/location/b/e;->c:Lcom/baidu/location/b/e;

    :cond_0
    sget-object v1, Lcom/baidu/location/b/e;->c:Lcom/baidu/location/b/e;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static a(Landroid/location/Location;)Ljava/lang/String;
    .locals 11

    if-nez p0, :cond_0

    const/4 p0, 0x0

    goto/16 :goto_2

    :cond_0
    invoke-virtual {p0}, Landroid/location/Location;->getSpeed()F

    move-result v0

    float-to-double v0, v0

    const-wide v2, 0x400ccccccccccccdL    # 3.6

    invoke-static {v0, v1}, Ljava/lang/Double;->isNaN(D)Z

    mul-double v0, v0, v2

    double-to-float v0, v0

    invoke-virtual {p0}, Landroid/location/Location;->hasSpeed()Z

    move-result v1

    const/high16 v2, -0x40800000    # -1.0f

    if-nez v1, :cond_1

    const/high16 v0, -0x40800000    # -1.0f

    :cond_1
    invoke-virtual {p0}, Landroid/location/Location;->hasAccuracy()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-virtual {p0}, Landroid/location/Location;->getAccuracy()F

    move-result v1

    goto :goto_0

    :cond_2
    const/high16 v1, -0x40800000    # -1.0f

    :goto_0
    float-to-int v1, v1

    invoke-virtual {p0}, Landroid/location/Location;->hasAltitude()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-virtual {p0}, Landroid/location/Location;->getAltitude()D

    move-result-wide v3

    goto :goto_1

    :cond_3
    const-wide v3, 0x4081580000000000L    # 555.0

    :goto_1
    invoke-virtual {p0}, Landroid/location/Location;->hasBearing()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-virtual {p0}, Landroid/location/Location;->getBearing()F

    move-result v2

    :cond_4
    sget-object v5, Ljava/util/Locale;->CHINA:Ljava/util/Locale;

    const-string v6, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d&ll_snr=%.1f"

    const/16 v7, 0xb

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-virtual {p0}, Landroid/location/Location;->getLongitude()D

    move-result-wide v9

    invoke-static {v9, v10}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x1

    invoke-virtual {p0}, Landroid/location/Location;->getLatitude()D

    move-result-wide v9

    invoke-static {v9, v10}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x2

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    aput-object v0, v7, v8

    const/4 v0, 0x3

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    aput-object v2, v7, v0

    const/4 v0, 0x4

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v7, v0

    const/4 v0, 0x5

    sget v1, Lcom/baidu/location/b/e;->m:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v7, v0

    const/4 v0, 0x6

    invoke-static {v3, v4}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    aput-object v1, v7, v0

    const/4 v0, 0x7

    invoke-virtual {p0}, Landroid/location/Location;->getTime()J

    move-result-wide v1

    const-wide/16 v3, 0x3e8

    div-long/2addr v1, v3

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p0

    aput-object p0, v7, v0

    const/16 p0, 0x8

    sget v0, Lcom/baidu/location/b/e;->m:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v7, p0

    const/16 p0, 0x9

    sget v0, Lcom/baidu/location/b/e;->n:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v7, p0

    const/16 p0, 0xa

    sget-wide v0, Lcom/baidu/location/b/e;->C:D

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    aput-object v0, v7, p0

    invoke-static {v5, v6, v7}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    :goto_2
    return-object p0
.end method

.method private a(DDF)V
    .locals 7

    const/4 v0, 0x0

    const-wide v1, 0x4052496801711948L    # 73.146973

    cmpg-double v3, p1, v1

    if-ltz v3, :cond_2

    const-wide v1, 0x4060e81600f34507L    # 135.252686

    cmpl-double v3, p1, v1

    if-gtz v3, :cond_2

    const-wide v1, 0x404b212096787ce9L    # 54.258807

    cmpl-double v3, p3, v1

    if-gtz v3, :cond_2

    const-wide v1, 0x402d35ae81882adcL    # 14.604847

    cmpg-double v3, p3, v1

    if-ltz v3, :cond_2

    const/high16 v1, 0x41900000    # 18.0f

    cmpl-float p5, p5, v1

    if-lez p5, :cond_0

    goto :goto_0

    :cond_0
    sget-wide v1, Lcom/baidu/location/d/j;->s:D

    sub-double v1, p1, v1

    sget-wide v3, Lcom/baidu/location/d/j;->t:D

    sub-double/2addr v3, p3

    const-wide v5, 0x408f400000000000L    # 1000.0

    mul-double v1, v1, v5

    double-to-int p5, v1

    mul-double v3, v3, v5

    double-to-int v1, v3

    const/4 v2, 0x2

    if-lez p5, :cond_1

    const/16 v3, 0x32

    if-ge p5, v3, :cond_1

    if-lez v1, :cond_1

    if-ge v1, v3, :cond_1

    mul-int/lit8 v1, v1, 0x32

    add-int/2addr v1, p5

    shr-int/lit8 p1, v1, 0x2

    and-int/lit8 p2, v1, 0x3

    sget-boolean p3, Lcom/baidu/location/d/j;->w:Z

    if-eqz p3, :cond_2

    sget-object p3, Lcom/baidu/location/d/j;->v:[B

    aget-byte p1, p3, p1

    mul-int/lit8 p2, p2, 0x2

    shr-int/2addr p1, p2

    and-int/lit8 p1, p1, 0x3

    move v0, p1

    goto :goto_0

    :cond_1
    sget-object p5, Ljava/util/Locale;->CHINA:Ljava/util/Locale;

    const-string v1, "&ll=%.5f|%.5f"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    aput-object v3, v2, v0

    const/4 v3, 0x1

    invoke-static {p3, p4}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {p5, v1, v2}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p5

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p5, "&im="

    invoke-virtual {v1, p5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {}, Lcom/baidu/location/d/b;->a()Lcom/baidu/location/d/b;

    move-result-object p5

    invoke-virtual {p5}, Lcom/baidu/location/d/b;->b()Ljava/lang/String;

    move-result-object p5

    invoke-virtual {v1, p5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    sput-wide p1, Lcom/baidu/location/d/j;->q:D

    sput-wide p3, Lcom/baidu/location/d/j;->r:D

    :cond_2
    :goto_0
    sget p1, Lcom/baidu/location/d/j;->u:I

    if-eq p1, v0, :cond_3

    sput v0, Lcom/baidu/location/d/j;->u:I

    :cond_3
    return-void
.end method

.method static synthetic a(Lcom/baidu/location/b/e;Landroid/location/Location;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/b/e;->e(Landroid/location/Location;)V

    return-void
.end method

.method static synthetic a(Lcom/baidu/location/b/e;Ljava/lang/String;Landroid/location/Location;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/baidu/location/b/e;->a(Ljava/lang/String;Landroid/location/Location;)V

    return-void
.end method

.method static synthetic a(Lcom/baidu/location/b/e;Z)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/b/e;->b(Z)V

    return-void
.end method

.method private a(Ljava/lang/String;Landroid/location/Location;)V
    .locals 3

    if-nez p2, :cond_0

    return-void

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object p1

    invoke-virtual {p1}, Lcom/baidu/location/a/a;->c()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {}, Lcom/baidu/location/b/h;->a()Lcom/baidu/location/b/h;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/b/h;->e()Z

    move-result v0

    invoke-static {}, Lcom/baidu/location/b/b;->a()Lcom/baidu/location/b/b;

    move-result-object v1

    invoke-virtual {v1}, Lcom/baidu/location/b/b;->f()Lcom/baidu/location/b/a;

    move-result-object v1

    new-instance v2, Lcom/baidu/location/b/a;

    invoke-direct {v2, v1}, Lcom/baidu/location/b/a;-><init>(Lcom/baidu/location/b/a;)V

    invoke-static {v2}, Lcom/baidu/location/a/t;->a(Lcom/baidu/location/b/a;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    invoke-static {v1, v2}, Lcom/baidu/location/a/t;->a(J)V

    new-instance v1, Landroid/location/Location;

    invoke-direct {v1, p2}, Landroid/location/Location;-><init>(Landroid/location/Location;)V

    invoke-static {v1}, Lcom/baidu/location/a/t;->a(Landroid/location/Location;)V

    invoke-static {p1}, Lcom/baidu/location/a/t;->a(Ljava/lang/String;)V

    if-nez v0, :cond_1

    invoke-static {}, Lcom/baidu/location/a/t;->c()Lcom/baidu/location/b/a;

    move-result-object p2

    const/4 v0, 0x0

    invoke-static {}, Lcom/baidu/location/a/t;->d()Landroid/location/Location;

    move-result-object v1

    invoke-static {p2, v0, v1, p1}, Lcom/baidu/location/a/v;->a(Lcom/baidu/location/b/a;Lcom/baidu/location/b/g;Landroid/location/Location;Ljava/lang/String;)V

    :cond_1
    return-void
.end method

.method public static a(Landroid/location/Location;Landroid/location/Location;Z)Z
    .locals 8

    const/4 v0, 0x0

    if-ne p0, p1, :cond_0

    return v0

    :cond_0
    const/4 v1, 0x1

    if-eqz p0, :cond_9

    if-nez p1, :cond_1

    goto :goto_0

    :cond_1
    invoke-virtual {p1}, Landroid/location/Location;->getSpeed()F

    move-result v2

    const/high16 v3, 0x40a00000    # 5.0f

    if-eqz p2, :cond_3

    sget p2, Lcom/baidu/location/d/j;->u:I

    const/4 v4, 0x3

    if-eq p2, v4, :cond_2

    invoke-static {}, Lcom/baidu/location/d/d;->a()Lcom/baidu/location/d/d;

    move-result-object p2

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v4

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v6

    invoke-virtual {p2, v4, v5, v6, v7}, Lcom/baidu/location/d/d;->a(DD)Z

    move-result p2

    if-nez p2, :cond_3

    :cond_2
    cmpg-float p2, v2, v3

    if-gez p2, :cond_3

    return v1

    :cond_3
    invoke-virtual {p1, p0}, Landroid/location/Location;->distanceTo(Landroid/location/Location;)F

    move-result p0

    sget p1, Lcom/baidu/location/d/j;->K:F

    cmpl-float p1, v2, p1

    if-lez p1, :cond_5

    sget p1, Lcom/baidu/location/d/j;->M:F

    cmpl-float p0, p0, p1

    if-lez p0, :cond_4

    const/4 v0, 0x1

    :cond_4
    return v0

    :cond_5
    sget p1, Lcom/baidu/location/d/j;->J:F

    cmpl-float p1, v2, p1

    if-lez p1, :cond_7

    sget p1, Lcom/baidu/location/d/j;->L:F

    cmpl-float p0, p0, p1

    if-lez p0, :cond_6

    const/4 v0, 0x1

    :cond_6
    return v0

    :cond_7
    cmpl-float p0, p0, v3

    if-lez p0, :cond_8

    const/4 v0, 0x1

    :cond_8
    return v0

    :cond_9
    :goto_0
    return v1
.end method

.method static synthetic a(Lcom/baidu/location/b/e;)Z
    .locals 0

    iget-boolean p0, p0, Lcom/baidu/location/b/e;->q:Z

    return p0
.end method

.method static synthetic b(I)I
    .locals 0

    sput p0, Lcom/baidu/location/b/e;->n:I

    return p0
.end method

.method static synthetic b(Lcom/baidu/location/b/e;I)I
    .locals 0

    iput p1, p0, Lcom/baidu/location/b/e;->B:I

    return p1
.end method

.method static synthetic b(Lcom/baidu/location/b/e;J)J
    .locals 0

    iput-wide p1, p0, Lcom/baidu/location/b/e;->o:J

    return-wide p1
.end method

.method static synthetic b(Lcom/baidu/location/b/e;)Landroid/os/Handler;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/b/e;->v:Landroid/os/Handler;

    return-object p0
.end method

.method public static b(Landroid/location/Location;)Ljava/lang/String;
    .locals 1

    invoke-static {p0}, Lcom/baidu/location/b/e;->a(Landroid/location/Location;)Ljava/lang/String;

    move-result-object p0

    if-eqz p0, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p0, "&g_tp=0"

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    :cond_0
    return-object p0
.end method

.method static synthetic b(Lcom/baidu/location/b/e;Landroid/location/Location;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/b/e;->d(Landroid/location/Location;)V

    return-void
.end method

.method private b(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/baidu/location/b/e;->s:Z

    if-eqz p1, :cond_0

    invoke-virtual {p0}, Lcom/baidu/location/b/e;->i()Z

    move-result p1

    if-nez p1, :cond_0

    :cond_0
    return-void
.end method

.method static synthetic b(Lcom/baidu/location/b/e;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/baidu/location/b/e;->p:Z

    return p1
.end method

.method static synthetic c(Lcom/baidu/location/b/e;)Landroid/location/LocationManager;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/b/e;->e:Landroid/location/LocationManager;

    return-object p0
.end method

.method public static c(Landroid/location/Location;)Ljava/lang/String;
    .locals 1

    invoke-static {p0}, Lcom/baidu/location/b/e;->a(Landroid/location/Location;)Ljava/lang/String;

    move-result-object p0

    if-eqz p0, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sget-object p0, Lcom/baidu/location/b/e;->u:Ljava/lang/String;

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    :cond_0
    return-object p0
.end method

.method static synthetic d(Lcom/baidu/location/b/e;)Ljava/util/ArrayList;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/b/e;->F:Ljava/util/ArrayList;

    return-object p0
.end method

.method private d(Landroid/location/Location;)V
    .locals 2

    iget-object v0, p0, Lcom/baidu/location/b/e;->v:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1, p1}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object p1

    iget-object v0, p0, Lcom/baidu/location/b/e;->v:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    return-void
.end method

.method static synthetic e(Lcom/baidu/location/b/e;)Landroid/location/GpsStatus;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/b/e;->i:Landroid/location/GpsStatus;

    return-object p0
.end method

.method private e(Landroid/location/Location;)V
    .locals 13

    const/4 v0, 0x0

    if-eqz p1, :cond_7

    sget v1, Lcom/baidu/location/b/e;->m:I

    if-nez v1, :cond_0

    :try_start_0
    invoke-virtual {p1}, Landroid/location/Location;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "satellites"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v2

    :cond_0
    :goto_0
    if-nez v1, :cond_1

    sget-boolean v1, Lcom/baidu/location/d/j;->l:Z

    if-nez v1, :cond_1

    return-void

    :cond_1
    iput-object p1, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    sget p1, Lcom/baidu/location/b/e;->m:I

    iget-object v1, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    const/4 v2, 0x2

    const/4 v3, 0x1

    if-nez v1, :cond_2

    iput-object v0, p0, Lcom/baidu/location/b/e;->r:Ljava/lang/String;

    move-object v4, v0

    goto/16 :goto_3

    :cond_2
    new-instance v4, Landroid/location/Location;

    invoke-direct {v4, v1}, Landroid/location/Location;-><init>(Landroid/location/Location;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    iget-object v1, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v1, v5, v6}, Landroid/location/Location;->setTime(J)V

    iget-object v1, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v1}, Landroid/location/Location;->getSpeed()F

    move-result v1

    float-to-double v7, v1

    const-wide v9, 0x400ccccccccccccdL    # 3.6

    invoke-static {v7, v8}, Ljava/lang/Double;->isNaN(D)Z

    mul-double v7, v7, v9

    double-to-float v1, v7

    iget-object v7, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v7}, Landroid/location/Location;->hasSpeed()Z

    move-result v7

    if-nez v7, :cond_3

    const/high16 v1, -0x40800000    # -1.0f

    const/high16 v12, -0x40800000    # -1.0f

    goto :goto_1

    :cond_3
    move v12, v1

    :goto_1
    if-nez p1, :cond_4

    :try_start_1
    iget-object v1, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v1}, Landroid/location/Location;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    const-string v7, "satellites"

    invoke-virtual {v1, v7}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result p1
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_2

    :catch_1
    move-exception v1

    :cond_4
    :goto_2
    sget-object v1, Ljava/util/Locale;->CHINA:Ljava/util/Locale;

    const-string v7, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d"

    const/4 v8, 0x6

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    iget-object v10, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v10}, Landroid/location/Location;->getLongitude()D

    move-result-wide v10

    invoke-static {v10, v11}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v10

    aput-object v10, v8, v9

    iget-object v9, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v9}, Landroid/location/Location;->getLatitude()D

    move-result-wide v9

    invoke-static {v9, v10}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v9

    aput-object v9, v8, v3

    invoke-static {v12}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v9

    aput-object v9, v8, v2

    const/4 v9, 0x3

    iget-object v10, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v10}, Landroid/location/Location;->getBearing()F

    move-result v10

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x4

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    aput-object p1, v8, v9

    const/4 p1, 0x5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v8, p1

    invoke-static {v1, v7, v8}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lcom/baidu/location/b/e;->r:Ljava/lang/String;

    iget-object p1, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v8

    iget-object p1, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v10

    move-object v7, p0

    invoke-direct/range {v7 .. v12}, Lcom/baidu/location/b/e;->a(DDF)V

    :goto_3
    :try_start_2
    invoke-static {}, Lcom/baidu/location/a/g;->a()Lcom/baidu/location/a/g;

    move-result-object p1

    iget-object v1, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {p1, v1}, Lcom/baidu/location/a/g;->a(Landroid/location/Location;)Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    goto :goto_4

    :catch_2
    move-exception p1

    :goto_4
    if-eqz v4, :cond_5

    invoke-static {}, Lcom/baidu/location/a/d;->a()Lcom/baidu/location/a/d;

    move-result-object p1

    invoke-virtual {p1, v4}, Lcom/baidu/location/a/d;->a(Landroid/location/Location;)V

    :cond_5
    invoke-virtual {p0}, Lcom/baidu/location/b/e;->i()Z

    move-result p1

    if-eqz p1, :cond_6

    iget-object p1, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    if-eqz p1, :cond_6

    invoke-direct {p0}, Lcom/baidu/location/b/e;->j()Ljava/lang/String;

    move-result-object p1

    sput-object p1, Lcom/baidu/location/b/e;->D:Ljava/lang/String;

    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object p1

    invoke-virtual {p0}, Lcom/baidu/location/b/e;->f()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/baidu/location/a/a;->a(Ljava/lang/String;)V

    sget p1, Lcom/baidu/location/b/e;->m:I

    if-le p1, v2, :cond_6

    iget-object p1, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-static {p1, v3}, Lcom/baidu/location/a/v;->a(Landroid/location/Location;Z)Z

    move-result p1

    if-eqz p1, :cond_6

    invoke-static {}, Lcom/baidu/location/b/h;->a()Lcom/baidu/location/b/h;

    move-result-object p1

    invoke-virtual {p1}, Lcom/baidu/location/b/h;->e()Z

    move-result p1

    invoke-static {}, Lcom/baidu/location/b/b;->a()Lcom/baidu/location/b/b;

    move-result-object v1

    invoke-virtual {v1}, Lcom/baidu/location/b/b;->f()Lcom/baidu/location/b/a;

    move-result-object v1

    new-instance v2, Lcom/baidu/location/b/a;

    invoke-direct {v2, v1}, Lcom/baidu/location/b/a;-><init>(Lcom/baidu/location/b/a;)V

    invoke-static {v2}, Lcom/baidu/location/a/t;->a(Lcom/baidu/location/b/a;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    invoke-static {v1, v2}, Lcom/baidu/location/a/t;->a(J)V

    new-instance v1, Landroid/location/Location;

    iget-object v2, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-direct {v1, v2}, Landroid/location/Location;-><init>(Landroid/location/Location;)V

    invoke-static {v1}, Lcom/baidu/location/a/t;->a(Landroid/location/Location;)V

    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object v1

    invoke-virtual {v1}, Lcom/baidu/location/a/a;->c()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/baidu/location/a/t;->a(Ljava/lang/String;)V

    if-nez p1, :cond_6

    invoke-static {}, Lcom/baidu/location/a/t;->c()Lcom/baidu/location/b/a;

    move-result-object p1

    invoke-static {}, Lcom/baidu/location/a/t;->d()Landroid/location/Location;

    move-result-object v1

    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object v2

    invoke-virtual {v2}, Lcom/baidu/location/a/a;->c()Ljava/lang/String;

    move-result-object v2

    invoke-static {p1, v0, v1, v2}, Lcom/baidu/location/a/v;->a(Lcom/baidu/location/b/a;Lcom/baidu/location/b/g;Landroid/location/Location;Ljava/lang/String;)V

    :cond_6
    return-void

    :cond_7
    iput-object v0, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    return-void
.end method

.method static synthetic f(Lcom/baidu/location/b/e;)I
    .locals 2

    iget v0, p0, Lcom/baidu/location/b/e;->B:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/baidu/location/b/e;->B:I

    return v0
.end method

.method private j()Ljava/lang/String;
    .locals 10

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/baidu/location/b/e;->F:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    const/16 v2, 0x20

    if-gt v1, v2, :cond_4

    iget-object v1, p0, Lcom/baidu/location/b/e;->F:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-nez v1, :cond_0

    goto/16 :goto_2

    :cond_0
    iget-object v1, p0, Lcom/baidu/location/b/e;->F:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    const/4 v2, 0x1

    const/4 v3, 0x1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v5

    const/4 v6, 0x5

    if-eq v5, v6, :cond_1

    goto :goto_0

    :cond_1
    const/4 v5, 0x0

    if-eqz v3, :cond_2

    const/4 v3, 0x0

    goto :goto_1

    :cond_2
    const-string v6, "|"

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :goto_1
    const-string v6, "%.1f;"

    new-array v7, v2, [Ljava/lang/Object;

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    aput-object v8, v7, v5

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v6, "%.1f;"

    new-array v7, v2, [Ljava/lang/Object;

    const/4 v8, 0x2

    invoke-virtual {v4, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    aput-object v9, v7, v5

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v6, "%.0f;"

    new-array v7, v2, [Ljava/lang/Object;

    invoke-virtual {v4, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    aput-object v8, v7, v5

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v6, "%.0f;"

    new-array v7, v2, [Ljava/lang/Object;

    const/4 v8, 0x3

    invoke-virtual {v4, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    aput-object v8, v7, v5

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v6, "%.0f"

    new-array v7, v2, [Ljava/lang/Object;

    const/4 v8, 0x4

    invoke-virtual {v4, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    aput-object v4, v7, v5

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    :cond_3
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_4
    :goto_2
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public a(Z)V
    .locals 0

    if-eqz p1, :cond_0

    invoke-virtual {p0}, Lcom/baidu/location/b/e;->c()V

    goto :goto_0

    :cond_0
    invoke-virtual {p0}, Lcom/baidu/location/b/e;->d()V

    :goto_0
    return-void
.end method

.method public declared-synchronized b()V
    .locals 8

    monitor-enter p0

    :try_start_0
    sget-boolean v0, Lcom/baidu/location/f;->isServing:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    monitor-exit p0

    return-void

    :cond_0
    :try_start_1
    invoke-static {}, Lcom/baidu/location/f;->getServiceContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/baidu/location/b/e;->d:Landroid/content/Context;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    iget-object v0, p0, Lcom/baidu/location/b/e;->d:Landroid/content/Context;

    const-string v1, "location"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    iput-object v0, p0, Lcom/baidu/location/b/e;->e:Landroid/location/LocationManager;

    iget-boolean v0, p0, Lcom/baidu/location/b/e;->k:Z

    const/4 v1, 0x0

    if-nez v0, :cond_1

    new-instance v0, Lcom/baidu/location/b/e$b;

    invoke-direct {v0, p0, v1}, Lcom/baidu/location/b/e$b;-><init>(Lcom/baidu/location/b/e;Lcom/baidu/location/b/f;)V

    iput-object v0, p0, Lcom/baidu/location/b/e;->l:Lcom/baidu/location/b/e$b;

    iget-object v0, p0, Lcom/baidu/location/b/e;->e:Landroid/location/LocationManager;

    iget-object v2, p0, Lcom/baidu/location/b/e;->l:Lcom/baidu/location/b/e$b;

    invoke-virtual {v0, v2}, Landroid/location/LocationManager;->addGpsStatusListener(Landroid/location/GpsStatus$Listener;)Z

    goto :goto_0

    :cond_1
    new-instance v0, Lcom/baidu/location/b/e$a;

    invoke-direct {v0, p0, v1}, Lcom/baidu/location/b/e$a;-><init>(Lcom/baidu/location/b/e;Lcom/baidu/location/b/f;)V

    iput-object v0, p0, Lcom/baidu/location/b/e;->j:Lcom/baidu/location/b/e$a;

    iget-object v0, p0, Lcom/baidu/location/b/e;->e:Landroid/location/LocationManager;

    iget-object v2, p0, Lcom/baidu/location/b/e;->j:Lcom/baidu/location/b/e$a;

    invoke-virtual {v0, v2}, Landroid/location/LocationManager;->registerGnssStatusCallback(Landroid/location/GnssStatus$Callback;)Z

    :goto_0
    new-instance v0, Lcom/baidu/location/b/e$d;

    invoke-direct {v0, p0, v1}, Lcom/baidu/location/b/e$d;-><init>(Lcom/baidu/location/b/e;Lcom/baidu/location/b/f;)V

    iput-object v0, p0, Lcom/baidu/location/b/e;->h:Lcom/baidu/location/b/e$d;

    iget-object v2, p0, Lcom/baidu/location/b/e;->e:Landroid/location/LocationManager;

    const-string v3, "passive"

    const-wide/16 v4, 0x2328

    const/4 v6, 0x0

    iget-object v7, p0, Lcom/baidu/location/b/e;->h:Lcom/baidu/location/b/e$d;

    invoke-virtual/range {v2 .. v7}, Landroid/location/LocationManager;->requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    :catch_0
    move-exception v0

    :goto_1
    :try_start_3
    new-instance v0, Lcom/baidu/location/b/f;

    invoke-direct {v0, p0}, Lcom/baidu/location/b/f;-><init>(Lcom/baidu/location/b/e;)V

    iput-object v0, p0, Lcom/baidu/location/b/e;->v:Landroid/os/Handler;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public c()V
    .locals 7

    sget-object v0, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v1, "start gps..."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget-boolean v0, p0, Lcom/baidu/location/b/e;->q:Z

    if-eqz v0, :cond_0

    return-void

    :cond_0
    :try_start_0
    new-instance v0, Lcom/baidu/location/b/e$c;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/baidu/location/b/e$c;-><init>(Lcom/baidu/location/b/e;Lcom/baidu/location/b/f;)V

    iput-object v0, p0, Lcom/baidu/location/b/e;->g:Lcom/baidu/location/b/e$c;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    :try_start_1
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iget-object v1, p0, Lcom/baidu/location/b/e;->e:Landroid/location/LocationManager;

    const-string v2, "gps"

    const-string v3, "force_xtra_injection"

    invoke-virtual {v1, v2, v3, v0}, Landroid/location/LocationManager;->sendExtraCommand(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    :goto_0
    :try_start_2
    iget-object v1, p0, Lcom/baidu/location/b/e;->e:Landroid/location/LocationManager;

    const-string v2, "gps"

    const-wide/16 v3, 0x3e8

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/baidu/location/b/e;->g:Lcom/baidu/location/b/e$c;

    invoke-virtual/range {v1 .. v6}, Landroid/location/LocationManager;->requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/baidu/location/b/e;->E:J

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/baidu/location/b/e;->q:Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_1

    :catch_1
    move-exception v0

    :goto_1
    return-void
.end method

.method public d()V
    .locals 2

    iget-boolean v0, p0, Lcom/baidu/location/b/e;->q:Z

    if-nez v0, :cond_0

    return-void

    :cond_0
    iget-object v0, p0, Lcom/baidu/location/b/e;->e:Landroid/location/LocationManager;

    if-eqz v0, :cond_1

    :try_start_0
    iget-object v1, p0, Lcom/baidu/location/b/e;->g:Lcom/baidu/location/b/e$c;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/baidu/location/b/e;->g:Lcom/baidu/location/b/e$c;

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->removeUpdates(Landroid/location/LocationListener;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    :cond_1
    :goto_0
    const/4 v0, 0x0

    sput v0, Lcom/baidu/location/d/j;->d:I

    sput v0, Lcom/baidu/location/d/j;->u:I

    const/4 v1, 0x0

    iput-object v1, p0, Lcom/baidu/location/b/e;->g:Lcom/baidu/location/b/e$c;

    iput-boolean v0, p0, Lcom/baidu/location/b/e;->q:Z

    invoke-direct {p0, v0}, Lcom/baidu/location/b/e;->b(Z)V

    return-void
.end method

.method public declared-synchronized e()V
    .locals 2

    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/baidu/location/b/e;->d()V

    iget-object v0, p0, Lcom/baidu/location/b/e;->e:Landroid/location/LocationManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    monitor-exit p0

    return-void

    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/baidu/location/b/e;->l:Lcom/baidu/location/b/e$b;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/baidu/location/b/e;->e:Landroid/location/LocationManager;

    iget-object v1, p0, Lcom/baidu/location/b/e;->l:Lcom/baidu/location/b/e$b;

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->removeGpsStatusListener(Landroid/location/GpsStatus$Listener;)V

    :cond_1
    iget-boolean v0, p0, Lcom/baidu/location/b/e;->k:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/baidu/location/b/e;->j:Lcom/baidu/location/b/e$a;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/baidu/location/b/e;->e:Landroid/location/LocationManager;

    iget-object v1, p0, Lcom/baidu/location/b/e;->j:Lcom/baidu/location/b/e$a;

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->unregisterGnssStatusCallback(Landroid/location/GnssStatus$Callback;)V

    :cond_2
    iget-object v0, p0, Lcom/baidu/location/b/e;->e:Landroid/location/LocationManager;

    iget-object v1, p0, Lcom/baidu/location/b/e;->h:Lcom/baidu/location/b/e$d;

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->removeUpdates(Landroid/location/LocationListener;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catch_0
    move-exception v0

    :goto_0
    const/4 v0, 0x0

    :try_start_2
    iput-object v0, p0, Lcom/baidu/location/b/e;->l:Lcom/baidu/location/b/e$b;

    iput-object v0, p0, Lcom/baidu/location/b/e;->e:Landroid/location/LocationManager;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public f()Ljava/lang/String;
    .locals 12

    iget-object v0, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    if-eqz v0, :cond_6

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "{\"result\":{\"time\":\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {}, Lcom/baidu/location/d/j;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\"s\":\"%f\",\"n\":\"%d\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v1}, Landroid/location/Location;->hasAccuracy()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v1}, Landroid/location/Location;->getAccuracy()F

    move-result v1

    goto :goto_0

    :cond_0
    const/high16 v1, 0x41200000    # 10.0f

    :goto_0
    float-to-int v1, v1

    iget-object v2, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v2}, Landroid/location/Location;->getSpeed()F

    move-result v2

    float-to-double v2, v2

    const-wide v4, 0x400ccccccccccccdL    # 3.6

    invoke-static {v2, v3}, Ljava/lang/Double;->isNaN(D)Z

    mul-double v2, v2, v4

    double-to-float v2, v2

    iget-object v3, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v3}, Landroid/location/Location;->hasSpeed()Z

    move-result v3

    if-nez v3, :cond_1

    const/high16 v2, -0x40800000    # -1.0f

    :cond_1
    const/4 v3, 0x2

    new-array v4, v3, [D

    invoke-static {}, Lcom/baidu/location/d/d;->a()Lcom/baidu/location/d/d;

    move-result-object v5

    iget-object v6, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v6}, Landroid/location/Location;->getLongitude()D

    move-result-wide v6

    iget-object v8, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v8}, Landroid/location/Location;->getLatitude()D

    move-result-wide v8

    invoke-virtual {v5, v6, v7, v8, v9}, Lcom/baidu/location/d/d;->a(DD)Z

    move-result v5

    const/4 v6, 0x0

    const/4 v7, 0x1

    if-eqz v5, :cond_3

    iget-object v4, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v4}, Landroid/location/Location;->getLongitude()D

    move-result-wide v4

    iget-object v8, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v8}, Landroid/location/Location;->getLatitude()D

    move-result-wide v8

    const-string v10, "gps2gcj"

    invoke-static {v4, v5, v8, v9, v10}, Lcom/baidu/location/Jni;->coorEncrypt(DDLjava/lang/String;)[D

    move-result-object v4

    aget-wide v8, v4, v6

    const-wide/16 v10, 0x0

    cmpl-double v5, v8, v10

    if-gtz v5, :cond_2

    aget-wide v8, v4, v7

    cmpl-double v5, v8, v10

    if-gtz v5, :cond_2

    iget-object v5, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v5}, Landroid/location/Location;->getLongitude()D

    move-result-wide v8

    aput-wide v8, v4, v6

    iget-object v5, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v5}, Landroid/location/Location;->getLatitude()D

    move-result-wide v8

    aput-wide v8, v4, v7

    :cond_2
    const/4 v5, 0x1

    goto :goto_1

    :cond_3
    iget-object v5, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v5}, Landroid/location/Location;->getLongitude()D

    move-result-wide v8

    aput-wide v8, v4, v6

    iget-object v5, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v5}, Landroid/location/Location;->getLatitude()D

    move-result-wide v8

    aput-wide v8, v4, v7

    const/4 v5, 0x0

    :goto_1
    sget-object v8, Ljava/util/Locale;->CHINA:Ljava/util/Locale;

    const/4 v9, 0x6

    new-array v9, v9, [Ljava/lang/Object;

    aget-wide v10, v4, v6

    invoke-static {v10, v11}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v10

    aput-object v10, v9, v6

    aget-wide v10, v4, v7

    invoke-static {v10, v11}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v4

    aput-object v4, v9, v7

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v9, v3

    const/4 v1, 0x3

    iget-object v3, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v3}, Landroid/location/Location;->getBearing()F

    move-result v3

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    aput-object v3, v9, v1

    const/4 v1, 0x4

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    aput-object v2, v9, v1

    const/4 v1, 0x5

    sget v2, Lcom/baidu/location/b/e;->m:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v9, v1

    invoke-static {v8, v0, v9}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    if-nez v5, :cond_4

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, ",\"in_cn\":\"0\""

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_4
    iget-object v1, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v1}, Landroid/location/Location;->hasAltitude()Z

    move-result v1

    if-eqz v1, :cond_5

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sget-object v0, Ljava/util/Locale;->CHINA:Ljava/util/Locale;

    const-string v2, ",\"h\":%.2f}}"

    new-array v3, v7, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v4}, Landroid/location/Location;->getAltitude()D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v0, v2, v3}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_2

    :cond_5
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, "}}"

    :goto_2
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_3

    :cond_6
    const/4 v0, 0x0

    :goto_3
    return-object v0
.end method

.method public g()Landroid/location/Location;
    .locals 6

    iget-object v0, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    const/4 v1, 0x0

    if-nez v0, :cond_0

    return-object v1

    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v0, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v0}, Landroid/location/Location;->getTime()J

    move-result-wide v4

    sub-long/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Math;->abs(J)J

    move-result-wide v2

    const-wide/32 v4, 0xea60

    cmp-long v0, v2, v4

    if-lez v0, :cond_1

    return-object v1

    :cond_1
    iget-object v0, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    return-object v0
.end method

.method public h()Z
    .locals 8

    const/4 v0, 0x1

    const/4 v1, 0x0

    const-wide/16 v2, 0x0

    :try_start_0
    iget-object v4, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    if-eqz v4, :cond_1

    iget-object v4, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v4}, Landroid/location/Location;->getLatitude()D

    move-result-wide v4

    cmpl-double v6, v4, v2

    if-eqz v6, :cond_1

    iget-object v4, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v4}, Landroid/location/Location;->getLongitude()D

    move-result-wide v4

    cmpl-double v6, v4, v2

    if-eqz v6, :cond_1

    sget v4, Lcom/baidu/location/b/e;->m:I

    const/4 v5, 0x2

    if-gt v4, v5, :cond_0

    iget-object v4, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v4}, Landroid/location/Location;->getExtras()Landroid/os/Bundle;

    move-result-object v4

    const-string v6, "satellites"

    const/4 v7, 0x3

    invoke-virtual {v4, v6, v7}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v2
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    if-le v2, v5, :cond_1

    :cond_0
    return v0

    :cond_1
    return v1

    :catch_0
    move-exception v4

    iget-object v4, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    if-eqz v4, :cond_2

    invoke-virtual {v4}, Landroid/location/Location;->getLatitude()D

    move-result-wide v4

    cmpl-double v6, v4, v2

    if-eqz v6, :cond_2

    iget-object v4, p0, Lcom/baidu/location/b/e;->f:Landroid/location/Location;

    invoke-virtual {v4}, Landroid/location/Location;->getLongitude()D

    move-result-wide v4

    cmpl-double v6, v4, v2

    if-eqz v6, :cond_2

    return v0

    :cond_2
    return v1
.end method

.method public i()Z
    .locals 6

    invoke-virtual {p0}, Lcom/baidu/location/b/e;->h()Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_0

    return v1

    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/baidu/location/b/e;->t:J

    sub-long/2addr v2, v4

    const-wide/16 v4, 0x2710

    cmp-long v0, v2, v4

    if-lez v0, :cond_1

    return v1

    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-boolean v2, p0, Lcom/baidu/location/b/e;->p:Z

    if-eqz v2, :cond_2

    iget-wide v2, p0, Lcom/baidu/location/b/e;->o:J

    sub-long/2addr v0, v2

    const-wide/16 v2, 0xbb8

    cmp-long v4, v0, v2

    if-gez v4, :cond_2

    const/4 v0, 0x1

    return v0

    :cond_2
    iget-boolean v0, p0, Lcom/baidu/location/b/e;->s:Z

    return v0
.end method
