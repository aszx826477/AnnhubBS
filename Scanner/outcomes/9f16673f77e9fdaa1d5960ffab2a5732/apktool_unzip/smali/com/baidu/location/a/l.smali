.class public Lcom/baidu/location/a/l;
.super Lcom/baidu/location/a/i;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/baidu/location/a/l$a;,
        Lcom/baidu/location/a/l$b;
    }
.end annotation


# static fields
.field public static h:Z

.field private static i:Lcom/baidu/location/a/l;


# instance fields
.field private A:D

.field private B:Z

.field private C:J

.field private D:J

.field private E:Lcom/baidu/location/a/l$a;

.field private F:Z

.field private G:Z

.field private H:Z

.field private I:Z

.field private J:Z

.field private K:Lcom/baidu/location/a/l$b;

.field private L:Z

.field private M:I

.field private N:J

.field private O:Z

.field final e:I

.field public f:Lcom/baidu/location/a/i$b;

.field public final g:Landroid/os/Handler;

.field private j:Z

.field private k:Ljava/lang/String;

.field private l:Lcom/baidu/location/BDLocation;

.field private m:Lcom/baidu/location/BDLocation;

.field private n:Lcom/baidu/location/b/g;

.field private o:Lcom/baidu/location/b/a;

.field private p:Lcom/baidu/location/b/g;

.field private q:Lcom/baidu/location/b/a;

.field private r:Z

.field private volatile s:Z

.field private t:Z

.field private u:J

.field private v:J

.field private w:Lcom/baidu/location/Address;

.field private x:Ljava/lang/String;

.field private y:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/baidu/location/Poi;",
            ">;"
        }
    .end annotation
.end field

.field private z:D


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    sput-object v0, Lcom/baidu/location/a/l;->i:Lcom/baidu/location/a/l;

    const/4 v0, 0x0

    sput-boolean v0, Lcom/baidu/location/a/l;->h:Z

    return-void
.end method

.method private constructor <init>()V
    .locals 6

    invoke-direct {p0}, Lcom/baidu/location/a/i;-><init>()V

    const/16 v0, 0x3e8

    iput v0, p0, Lcom/baidu/location/a/l;->e:I

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->j:Z

    const/4 v1, 0x0

    iput-object v1, p0, Lcom/baidu/location/a/l;->f:Lcom/baidu/location/a/i$b;

    iput-object v1, p0, Lcom/baidu/location/a/l;->k:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    iput-object v1, p0, Lcom/baidu/location/a/l;->m:Lcom/baidu/location/BDLocation;

    iput-object v1, p0, Lcom/baidu/location/a/l;->n:Lcom/baidu/location/b/g;

    iput-object v1, p0, Lcom/baidu/location/a/l;->o:Lcom/baidu/location/b/a;

    iput-object v1, p0, Lcom/baidu/location/a/l;->p:Lcom/baidu/location/b/g;

    iput-object v1, p0, Lcom/baidu/location/a/l;->q:Lcom/baidu/location/b/a;

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->r:Z

    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/baidu/location/a/l;->s:Z

    iput-boolean v2, p0, Lcom/baidu/location/a/l;->t:Z

    const-wide/16 v3, 0x0

    iput-wide v3, p0, Lcom/baidu/location/a/l;->u:J

    iput-wide v3, p0, Lcom/baidu/location/a/l;->v:J

    iput-object v1, p0, Lcom/baidu/location/a/l;->w:Lcom/baidu/location/Address;

    iput-object v1, p0, Lcom/baidu/location/a/l;->x:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/a/l;->y:Ljava/util/List;

    iput-boolean v2, p0, Lcom/baidu/location/a/l;->B:Z

    iput-wide v3, p0, Lcom/baidu/location/a/l;->C:J

    iput-wide v3, p0, Lcom/baidu/location/a/l;->D:J

    iput-object v1, p0, Lcom/baidu/location/a/l;->E:Lcom/baidu/location/a/l$a;

    iput-boolean v2, p0, Lcom/baidu/location/a/l;->F:Z

    iput-boolean v2, p0, Lcom/baidu/location/a/l;->G:Z

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->H:Z

    new-instance v5, Lcom/baidu/location/a/i$a;

    invoke-direct {v5, p0}, Lcom/baidu/location/a/i$a;-><init>(Lcom/baidu/location/a/i;)V

    iput-object v5, p0, Lcom/baidu/location/a/l;->g:Landroid/os/Handler;

    iput-boolean v2, p0, Lcom/baidu/location/a/l;->I:Z

    iput-boolean v2, p0, Lcom/baidu/location/a/l;->J:Z

    iput-object v1, p0, Lcom/baidu/location/a/l;->K:Lcom/baidu/location/a/l$b;

    iput-boolean v2, p0, Lcom/baidu/location/a/l;->L:Z

    iput v2, p0, Lcom/baidu/location/a/l;->M:I

    iput-wide v3, p0, Lcom/baidu/location/a/l;->N:J

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->O:Z

    new-instance v0, Lcom/baidu/location/a/i$b;

    invoke-direct {v0, p0}, Lcom/baidu/location/a/i$b;-><init>(Lcom/baidu/location/a/i;)V

    iput-object v0, p0, Lcom/baidu/location/a/l;->f:Lcom/baidu/location/a/i$b;

    return-void
.end method

.method static synthetic a(Lcom/baidu/location/a/l;Landroid/os/Message;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/a/l;->h(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic a(Lcom/baidu/location/a/l;)Z
    .locals 0

    iget-boolean p0, p0, Lcom/baidu/location/a/l;->L:Z

    return p0
.end method

.method static synthetic a(Lcom/baidu/location/a/l;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/baidu/location/a/l;->L:Z

    return p1
.end method

.method private a(Lcom/baidu/location/b/a;)Z
    .locals 2

    invoke-static {}, Lcom/baidu/location/b/b;->a()Lcom/baidu/location/b/b;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/b/b;->f()Lcom/baidu/location/b/a;

    move-result-object v0

    iput-object v0, p0, Lcom/baidu/location/a/l;->b:Lcom/baidu/location/b/a;

    iget-object v0, p0, Lcom/baidu/location/a/l;->b:Lcom/baidu/location/b/a;

    if-ne v0, p1, :cond_0

    const/4 p1, 0x0

    return p1

    :cond_0
    iget-object v0, p0, Lcom/baidu/location/a/l;->b:Lcom/baidu/location/b/a;

    const/4 v1, 0x1

    if-eqz v0, :cond_2

    if-nez p1, :cond_1

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/baidu/location/a/l;->b:Lcom/baidu/location/b/a;

    invoke-virtual {p1, v0}, Lcom/baidu/location/b/a;->a(Lcom/baidu/location/b/a;)Z

    move-result p1

    xor-int/2addr p1, v1

    return p1

    :cond_2
    :goto_0
    return v1
.end method

.method private a(Lcom/baidu/location/b/g;)Z
    .locals 2

    invoke-static {}, Lcom/baidu/location/b/h;->a()Lcom/baidu/location/b/h;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/b/h;->o()Lcom/baidu/location/b/g;

    move-result-object v0

    iput-object v0, p0, Lcom/baidu/location/a/l;->a:Lcom/baidu/location/b/g;

    iget-object v0, p0, Lcom/baidu/location/a/l;->a:Lcom/baidu/location/b/g;

    if-ne p1, v0, :cond_0

    const/4 p1, 0x0

    return p1

    :cond_0
    iget-object v0, p0, Lcom/baidu/location/a/l;->a:Lcom/baidu/location/b/g;

    const/4 v1, 0x1

    if-eqz v0, :cond_2

    if-nez p1, :cond_1

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/baidu/location/a/l;->a:Lcom/baidu/location/b/g;

    invoke-virtual {p1, v0}, Lcom/baidu/location/b/g;->c(Lcom/baidu/location/b/g;)Z

    move-result p1

    xor-int/2addr p1, v1

    return p1

    :cond_2
    :goto_0
    return v1
.end method

.method static synthetic b(Lcom/baidu/location/a/l;)Z
    .locals 0

    iget-boolean p0, p0, Lcom/baidu/location/a/l;->t:Z

    return p0
.end method

.method static synthetic b(Lcom/baidu/location/a/l;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/baidu/location/a/l;->t:Z

    return p1
.end method

.method public static declared-synchronized c()Lcom/baidu/location/a/l;
    .locals 2

    const-class v0, Lcom/baidu/location/a/l;

    monitor-enter v0

    :try_start_0
    sget-object v1, Lcom/baidu/location/a/l;->i:Lcom/baidu/location/a/l;

    if-nez v1, :cond_0

    new-instance v1, Lcom/baidu/location/a/l;

    invoke-direct {v1}, Lcom/baidu/location/a/l;-><init>()V

    sput-object v1, Lcom/baidu/location/a/l;->i:Lcom/baidu/location/a/l;

    :cond_0
    sget-object v1, Lcom/baidu/location/a/l;->i:Lcom/baidu/location/a/l;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method private c(Landroid/os/Message;)V
    .locals 3

    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "isWaitingLocTag"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    sput-boolean v1, Lcom/baidu/location/a/l;->h:Z

    :cond_0
    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/baidu/location/a/a;->d(Landroid/os/Message;)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v1, v2

    const-string v0, "this type %d is illegal"

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :pswitch_0
    invoke-static {}, Lcom/baidu/location/b/e;->a()Lcom/baidu/location/b/e;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/b/e;->i()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-direct {p0, p1}, Lcom/baidu/location/a/l;->e(Landroid/os/Message;)V

    goto :goto_0

    :pswitch_1
    invoke-direct {p0, p1}, Lcom/baidu/location/a/l;->g(Landroid/os/Message;)V

    goto :goto_0

    :pswitch_2
    invoke-direct {p0, p1}, Lcom/baidu/location/a/l;->d(Landroid/os/Message;)V

    :cond_1
    :goto_0
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method static synthetic c(Lcom/baidu/location/a/l;)Z
    .locals 0

    iget-boolean p0, p0, Lcom/baidu/location/a/l;->F:Z

    return p0
.end method

.method static synthetic c(Lcom/baidu/location/a/l;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/baidu/location/a/l;->F:Z

    return p1
.end method

.method private d(Landroid/os/Message;)V
    .locals 1

    invoke-static {}, Lcom/baidu/location/b/e;->a()Lcom/baidu/location/b/e;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/b/e;->i()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0, p1}, Lcom/baidu/location/a/l;->e(Landroid/os/Message;)V

    invoke-static {}, Lcom/baidu/location/a/n;->a()Lcom/baidu/location/a/n;

    move-result-object p1

    invoke-virtual {p1}, Lcom/baidu/location/a/n;->c()V

    goto :goto_0

    :cond_0
    invoke-direct {p0, p1}, Lcom/baidu/location/a/l;->g(Landroid/os/Message;)V

    invoke-static {}, Lcom/baidu/location/a/n;->a()Lcom/baidu/location/a/n;

    move-result-object p1

    invoke-virtual {p1}, Lcom/baidu/location/a/n;->b()V

    :goto_0
    return-void
.end method

.method static synthetic d(Lcom/baidu/location/a/l;)Z
    .locals 0

    iget-boolean p0, p0, Lcom/baidu/location/a/l;->G:Z

    return p0
.end method

.method private e(Landroid/os/Message;)V
    .locals 11

    invoke-static {}, Lcom/baidu/location/b/e;->a()Lcom/baidu/location/b/e;

    move-result-object p1

    invoke-virtual {p1}, Lcom/baidu/location/b/e;->f()Ljava/lang/String;

    move-result-object p1

    new-instance v0, Lcom/baidu/location/BDLocation;

    invoke-direct {v0, p1}, Lcom/baidu/location/BDLocation;-><init>(Ljava/lang/String;)V

    sget-object p1, Lcom/baidu/location/d/j;->g:Ljava/lang/String;

    const-string v1, "all"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    const/4 v1, 0x0

    if-nez p1, :cond_0

    sget-boolean p1, Lcom/baidu/location/d/j;->h:Z

    if-nez p1, :cond_0

    sget-boolean p1, Lcom/baidu/location/d/j;->i:Z

    if-eqz p1, :cond_4

    :cond_0
    const/4 p1, 0x2

    new-array p1, p1, [F

    iget-wide v2, p0, Lcom/baidu/location/a/l;->A:D

    iget-wide v4, p0, Lcom/baidu/location/a/l;->z:D

    invoke-virtual {v0}, Lcom/baidu/location/BDLocation;->getLatitude()D

    move-result-wide v6

    invoke-virtual {v0}, Lcom/baidu/location/BDLocation;->getLongitude()D

    move-result-wide v8

    move-object v10, p1

    invoke-static/range {v2 .. v10}, Landroid/location/Location;->distanceBetween(DDDD[F)V

    const/4 v2, 0x0

    aget p1, p1, v2

    const/high16 v2, 0x42c80000    # 100.0f

    cmpg-float p1, p1, v2

    if-gez p1, :cond_3

    iget-object p1, p0, Lcom/baidu/location/a/l;->w:Lcom/baidu/location/Address;

    if-eqz p1, :cond_1

    invoke-virtual {v0, p1}, Lcom/baidu/location/BDLocation;->setAddr(Lcom/baidu/location/Address;)V

    :cond_1
    iget-object p1, p0, Lcom/baidu/location/a/l;->x:Ljava/lang/String;

    if-eqz p1, :cond_2

    invoke-virtual {v0, p1}, Lcom/baidu/location/BDLocation;->setLocationDescribe(Ljava/lang/String;)V

    :cond_2
    iget-object p1, p0, Lcom/baidu/location/a/l;->y:Ljava/util/List;

    if-eqz p1, :cond_4

    invoke-virtual {v0, p1}, Lcom/baidu/location/BDLocation;->setPoiList(Ljava/util/List;)V

    goto :goto_0

    :cond_3
    const/4 p1, 0x1

    iput-boolean p1, p0, Lcom/baidu/location/a/l;->B:Z

    invoke-direct {p0, v1}, Lcom/baidu/location/a/l;->g(Landroid/os/Message;)V

    :cond_4
    :goto_0
    iput-object v0, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    iput-object v1, p0, Lcom/baidu/location/a/l;->m:Lcom/baidu/location/BDLocation;

    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object p1

    invoke-virtual {p1, v0}, Lcom/baidu/location/a/a;->a(Lcom/baidu/location/BDLocation;)V

    return-void
.end method

.method private f(Landroid/os/Message;)V
    .locals 4

    invoke-static {}, Lcom/baidu/location/b/h;->a()Lcom/baidu/location/b/h;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/b/h;->f()Z

    move-result v0

    if-eqz v0, :cond_2

    const/4 p1, 0x1

    iput-boolean p1, p0, Lcom/baidu/location/a/l;->t:Z

    iget-object v0, p0, Lcom/baidu/location/a/l;->K:Lcom/baidu/location/a/l$b;

    if-nez v0, :cond_0

    new-instance v0, Lcom/baidu/location/a/l$b;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/baidu/location/a/l$b;-><init>(Lcom/baidu/location/a/l;Lcom/baidu/location/a/l$1;)V

    iput-object v0, p0, Lcom/baidu/location/a/l;->K:Lcom/baidu/location/a/l$b;

    :cond_0
    iget-boolean v0, p0, Lcom/baidu/location/a/l;->L:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/baidu/location/a/l;->K:Lcom/baidu/location/a/l$b;

    if-eqz v0, :cond_1

    iget-object v1, p0, Lcom/baidu/location/a/l;->g:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    :cond_1
    iget-object v0, p0, Lcom/baidu/location/a/l;->g:Landroid/os/Handler;

    iget-object v1, p0, Lcom/baidu/location/a/l;->K:Lcom/baidu/location/a/l$b;

    const-wide/16 v2, 0xdac

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    iput-boolean p1, p0, Lcom/baidu/location/a/l;->L:Z

    goto :goto_0

    :cond_2
    invoke-direct {p0, p1}, Lcom/baidu/location/a/l;->h(Landroid/os/Message;)V

    :goto_0
    return-void
.end method

.method private g(Landroid/os/Message;)V
    .locals 2

    const/4 v0, 0x0

    iput v0, p0, Lcom/baidu/location/a/l;->M:I

    iget-boolean v0, p0, Lcom/baidu/location/a/l;->r:Z

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    iput v0, p0, Lcom/baidu/location/a/l;->M:I

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/baidu/location/a/l;->D:J

    invoke-static {}, Lcom/baidu/location/b/h;->a()Lcom/baidu/location/b/h;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/b/h;->j()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0, p1}, Lcom/baidu/location/a/l;->f(Landroid/os/Message;)V

    goto :goto_0

    :cond_0
    invoke-direct {p0, p1}, Lcom/baidu/location/a/l;->h(Landroid/os/Message;)V

    goto :goto_0

    :cond_1
    invoke-direct {p0, p1}, Lcom/baidu/location/a/l;->f(Landroid/os/Message;)V

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/baidu/location/a/l;->D:J

    :goto_0
    return-void
.end method

.method private h(Landroid/os/Message;)V
    .locals 11

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/baidu/location/a/l;->u:J

    sub-long/2addr v0, v2

    iget-boolean v2, p0, Lcom/baidu/location/a/l;->s:Z

    if-eqz v2, :cond_0

    const-wide/16 v2, 0x2ee0

    cmp-long v4, v0, v2

    if-gtz v4, :cond_0

    return-void

    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/baidu/location/a/l;->u:J

    sub-long/2addr v0, v2

    const-wide/16 v2, 0x0

    cmp-long v4, v0, v2

    if-lez v4, :cond_2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v4, p0, Lcom/baidu/location/a/l;->u:J

    sub-long/2addr v0, v4

    const-wide/16 v4, 0x3e8

    cmp-long v6, v0, v4

    if-gez v6, :cond_2

    iget-object p1, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    if-eqz p1, :cond_1

    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object p1

    iget-object v0, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {p1, v0}, Lcom/baidu/location/a/a;->a(Lcom/baidu/location/BDLocation;)V

    :cond_1
    invoke-direct {p0}, Lcom/baidu/location/a/l;->k()V

    return-void

    :cond_2
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->s:Z

    iget-object v1, p0, Lcom/baidu/location/a/l;->o:Lcom/baidu/location/b/a;

    invoke-direct {p0, v1}, Lcom/baidu/location/a/l;->a(Lcom/baidu/location/b/a;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/baidu/location/a/l;->j:Z

    iget-object v1, p0, Lcom/baidu/location/a/l;->n:Lcom/baidu/location/b/g;

    invoke-direct {p0, v1}, Lcom/baidu/location/a/l;->a(Lcom/baidu/location/b/g;)Z

    move-result v1

    const/4 v4, 0x0

    if-nez v1, :cond_8

    iget-boolean v1, p0, Lcom/baidu/location/a/l;->j:Z

    if-nez v1, :cond_8

    iget-object v1, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    if-eqz v1, :cond_8

    iget-boolean v1, p0, Lcom/baidu/location/a/l;->B:Z

    if-nez v1, :cond_8

    iget-object v1, p0, Lcom/baidu/location/a/l;->m:Lcom/baidu/location/BDLocation;

    if-eqz v1, :cond_3

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    iget-wide v7, p0, Lcom/baidu/location/a/l;->v:J

    sub-long/2addr v5, v7

    const-wide/16 v7, 0x7530

    cmp-long v1, v5, v7

    if-lez v1, :cond_3

    iget-object v1, p0, Lcom/baidu/location/a/l;->m:Lcom/baidu/location/BDLocation;

    iput-object v1, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    iput-object v4, p0, Lcom/baidu/location/a/l;->m:Lcom/baidu/location/BDLocation;

    :cond_3
    invoke-static {}, Lcom/baidu/location/a/n;->a()Lcom/baidu/location/a/n;

    move-result-object v1

    invoke-virtual {v1}, Lcom/baidu/location/a/n;->d()Z

    move-result v1

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    invoke-static {}, Lcom/baidu/location/a/n;->a()Lcom/baidu/location/a/n;

    move-result-object v5

    invoke-virtual {v5}, Lcom/baidu/location/a/n;->e()F

    move-result v5

    invoke-virtual {v1, v5}, Lcom/baidu/location/BDLocation;->setDirection(F)V

    :cond_4
    iget-object v1, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {v1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result v1

    const/16 v5, 0x3e

    if-ne v1, v5, :cond_6

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    iget-wide v8, p0, Lcom/baidu/location/a/l;->N:J

    sub-long/2addr v6, v8

    cmp-long v1, v6, v2

    if-gtz v1, :cond_5

    goto :goto_0

    :cond_5
    move-wide v2, v6

    :cond_6
    :goto_0
    iget-object v1, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {v1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result v1

    const/16 v6, 0x3d

    if-eq v1, v6, :cond_7

    iget-object v1, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {v1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result v1

    const/16 v6, 0xa1

    if-eq v1, v6, :cond_7

    iget-object v1, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {v1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result v1

    if-ne v1, v5, :cond_8

    const-wide/16 v5, 0x3a98

    cmp-long v1, v2, v5

    if-gez v1, :cond_8

    :cond_7
    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object p1

    iget-object v0, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {p1, v0}, Lcom/baidu/location/a/a;->a(Lcom/baidu/location/BDLocation;)V

    invoke-direct {p0}, Lcom/baidu/location/a/l;->k()V

    return-void

    :cond_8
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    iput-wide v1, p0, Lcom/baidu/location/a/l;->u:J

    invoke-virtual {p0, v4}, Lcom/baidu/location/a/l;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/baidu/location/a/l;->J:Z

    if-nez v1, :cond_c

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->J:Z

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    iput-wide v5, p0, Lcom/baidu/location/a/l;->N:J

    invoke-direct {p0}, Lcom/baidu/location/a/l;->j()[Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    iget-wide v7, p0, Lcom/baidu/location/a/l;->C:J

    sub-long v7, v5, v7

    const-wide/32 v9, 0xea60

    cmp-long v3, v7, v9

    if-lez v3, :cond_9

    iput-wide v5, p0, Lcom/baidu/location/a/l;->C:J

    :cond_9
    invoke-static {}, Lcom/baidu/location/b/h;->a()Lcom/baidu/location/b/h;

    move-result-object v3

    invoke-virtual {v3}, Lcom/baidu/location/b/h;->l()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_a

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lcom/baidu/location/a/l;->b()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    aget-object v1, v1, v2

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    :cond_a
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, ""

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lcom/baidu/location/a/l;->b()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    aget-object v1, v1, v2

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_1
    iget-object v3, p0, Lcom/baidu/location/a/l;->b:Lcom/baidu/location/b/a;

    if-eqz v3, :cond_b

    iget-object v3, p0, Lcom/baidu/location/a/l;->b:Lcom/baidu/location/b/a;

    invoke-virtual {v3}, Lcom/baidu/location/b/a;->g()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_b

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p0, Lcom/baidu/location/a/l;->b:Lcom/baidu/location/b/a;

    invoke-virtual {v5}, Lcom/baidu/location/b/a;->g()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    :cond_b
    invoke-static {}, Lcom/baidu/location/d/b;->a()Lcom/baidu/location/d/b;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/baidu/location/d/b;->a(Z)Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_c

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    :cond_c
    iget-object v3, p0, Lcom/baidu/location/a/l;->k:Ljava/lang/String;

    if-eqz v3, :cond_d

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/baidu/location/a/l;->k:Ljava/lang/String;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v4, p0, Lcom/baidu/location/a/l;->k:Ljava/lang/String;

    :cond_d
    iget-object v3, p0, Lcom/baidu/location/a/l;->f:Lcom/baidu/location/a/i$b;

    invoke-virtual {v3, v1}, Lcom/baidu/location/a/i$b;->a(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/baidu/location/a/l;->b:Lcom/baidu/location/b/a;

    iput-object v1, p0, Lcom/baidu/location/a/l;->o:Lcom/baidu/location/b/a;

    iget-object v1, p0, Lcom/baidu/location/a/l;->a:Lcom/baidu/location/b/g;

    iput-object v1, p0, Lcom/baidu/location/a/l;->n:Lcom/baidu/location/b/g;

    iget-boolean v1, p0, Lcom/baidu/location/a/l;->r:Z

    if-ne v1, v0, :cond_e

    iput-boolean v2, p0, Lcom/baidu/location/a/l;->r:Z

    invoke-static {}, Lcom/baidu/location/b/h;->i()Z

    move-result v0

    if-eqz v0, :cond_e

    if-eqz p1, :cond_e

    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/baidu/location/a/a;->e(Landroid/os/Message;)I

    :cond_e
    iget p1, p0, Lcom/baidu/location/a/l;->M:I

    if-lez p1, :cond_10

    const/4 v0, 0x2

    if-ne p1, v0, :cond_f

    invoke-static {}, Lcom/baidu/location/b/h;->a()Lcom/baidu/location/b/h;

    move-result-object p1

    invoke-virtual {p1}, Lcom/baidu/location/b/h;->f()Z

    :cond_f
    iput v2, p0, Lcom/baidu/location/a/l;->M:I

    :cond_10
    return-void
.end method

.method private j()[Ljava/lang/String;
    .locals 10

    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, ""

    const/4 v2, 0x0

    aput-object v1, v0, v2

    const-string v1, "Location failed beacuse we can not get any loc information!"

    const/4 v3, 0x1

    aput-object v1, v0, v3

    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    const-string v4, "&apl="

    invoke-virtual {v1, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-static {}, Lcom/baidu/location/f;->getServiceContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/baidu/location/d/j;->a(Landroid/content/Context;)I

    move-result v4

    if-ne v4, v3, :cond_0

    const-string v5, "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!"

    aput-object v5, v0, v3

    :cond_0
    invoke-virtual {v1, v4}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    invoke-static {}, Lcom/baidu/location/f;->getServiceContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Lcom/baidu/location/d/j;->c(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "0|0|"

    invoke-virtual {v5, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_1

    const-string v6, "Location failed beacuse we can not get any loc information without any location permission!"

    aput-object v6, v0, v3

    :cond_1
    invoke-virtual {v1, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v7, 0x17

    if-lt v6, v7, :cond_3

    const-string v6, "&loc="

    invoke-virtual {v1, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-static {}, Lcom/baidu/location/f;->getServiceContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lcom/baidu/location/d/j;->b(Landroid/content/Context;)I

    move-result v6

    if-nez v6, :cond_2

    const-string v7, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!"

    aput-object v7, v0, v3

    const/4 v7, 0x1

    goto :goto_0

    :cond_2
    const/4 v7, 0x0

    :goto_0
    invoke-virtual {v1, v6}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    goto :goto_1

    :cond_3
    const/4 v7, 0x0

    :goto_1
    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v8, 0x13

    if-lt v6, v8, :cond_4

    const-string v6, "&lmd="

    invoke-virtual {v1, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-static {}, Lcom/baidu/location/f;->getServiceContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lcom/baidu/location/d/j;->b(Landroid/content/Context;)I

    move-result v6

    if-ltz v6, :cond_4

    invoke-virtual {v1, v6}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    :cond_4
    invoke-static {}, Lcom/baidu/location/b/b;->a()Lcom/baidu/location/b/b;

    move-result-object v6

    invoke-virtual {v6}, Lcom/baidu/location/b/b;->g()Ljava/lang/String;

    move-result-object v6

    invoke-static {}, Lcom/baidu/location/b/h;->a()Lcom/baidu/location/b/h;

    move-result-object v8

    invoke-virtual {v8}, Lcom/baidu/location/b/h;->g()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v1, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v1, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-static {}, Lcom/baidu/location/f;->getServiceContext()Landroid/content/Context;

    move-result-object v9

    invoke-static {v9}, Lcom/baidu/location/d/j;->d(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const/16 v9, 0x3e

    if-ne v4, v3, :cond_5

    invoke-static {}, Lcom/baidu/location/a/b;->a()Lcom/baidu/location/a/b;

    move-result-object v3

    const/4 v4, 0x7

    const-string v5, "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!"

    :goto_2
    invoke-virtual {v3, v9, v4, v5}, Lcom/baidu/location/a/b;->a(IILjava/lang/String;)V

    goto :goto_3

    :cond_5
    const-string v3, "0|0|"

    invoke-virtual {v5, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_6

    invoke-static {}, Lcom/baidu/location/a/b;->a()Lcom/baidu/location/a/b;

    move-result-object v3

    const/4 v4, 0x4

    const-string v5, "Location failed beacuse we can not get any loc information without any location permission!"

    goto :goto_2

    :cond_6
    if-eqz v7, :cond_7

    invoke-static {}, Lcom/baidu/location/a/b;->a()Lcom/baidu/location/a/b;

    move-result-object v3

    const/4 v4, 0x5

    const-string v5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!"

    goto :goto_2

    :cond_7
    if-eqz v6, :cond_8

    if-eqz v8, :cond_8

    const-string v3, "&sim=1"

    invoke-virtual {v6, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8

    const-string v3, "&wifio=1"

    invoke-virtual {v8, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_8

    invoke-static {}, Lcom/baidu/location/a/b;->a()Lcom/baidu/location/a/b;

    move-result-object v3

    const/4 v4, 0x6

    const-string v5, "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!"

    goto :goto_2

    :cond_8
    invoke-static {}, Lcom/baidu/location/a/b;->a()Lcom/baidu/location/a/b;

    move-result-object v3

    const/16 v4, 0x9

    const-string v5, "Location failed beacuse we can not get any loc information!"

    goto :goto_2

    :goto_3
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v2

    return-object v0
.end method

.method private k()V
    .locals 2

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->s:Z

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->G:Z

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->H:Z

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->B:Z

    invoke-direct {p0}, Lcom/baidu/location/a/l;->l()V

    iget-boolean v1, p0, Lcom/baidu/location/a/l;->O:Z

    if-eqz v1, :cond_0

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->O:Z

    :cond_0
    return-void
.end method

.method private l()V
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/baidu/location/a/v;->a()Lcom/baidu/location/a/v;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/a/v;->c()V

    :cond_0
    return-void
.end method


# virtual methods
.method public a(Lcom/baidu/location/BDLocation;)Lcom/baidu/location/Address;
    .locals 11

    sget-object v0, Lcom/baidu/location/d/j;->g:Ljava/lang/String;

    const-string v1, "all"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_0

    sget-boolean v0, Lcom/baidu/location/d/j;->h:Z

    if-nez v0, :cond_0

    sget-boolean v0, Lcom/baidu/location/d/j;->i:Z

    if-eqz v0, :cond_2

    :cond_0
    const/4 v0, 0x2

    new-array v0, v0, [F

    iget-wide v2, p0, Lcom/baidu/location/a/l;->A:D

    iget-wide v4, p0, Lcom/baidu/location/a/l;->z:D

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLatitude()D

    move-result-wide v6

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLongitude()D

    move-result-wide v8

    move-object v10, v0

    invoke-static/range {v2 .. v10}, Landroid/location/Location;->distanceBetween(DDDD[F)V

    const/4 p1, 0x0

    aget p1, v0, p1

    const/high16 v0, 0x42c80000    # 100.0f

    cmpg-float p1, p1, v0

    if-gez p1, :cond_1

    iget-object p1, p0, Lcom/baidu/location/a/l;->w:Lcom/baidu/location/Address;

    if-eqz p1, :cond_2

    return-object p1

    :cond_1
    iput-object v1, p0, Lcom/baidu/location/a/l;->x:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/a/l;->y:Ljava/util/List;

    const/4 p1, 0x1

    iput-boolean p1, p0, Lcom/baidu/location/a/l;->B:Z

    invoke-direct {p0, v1}, Lcom/baidu/location/a/l;->g(Landroid/os/Message;)V

    :cond_2
    return-object v1
.end method

.method public a()V
    .locals 12

    iget-object v0, p0, Lcom/baidu/location/a/l;->E:Lcom/baidu/location/a/l$a;

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    iget-boolean v2, p0, Lcom/baidu/location/a/l;->F:Z

    if-eqz v2, :cond_0

    iput-boolean v1, p0, Lcom/baidu/location/a/l;->F:Z

    iget-object v2, p0, Lcom/baidu/location/a/l;->g:Landroid/os/Handler;

    invoke-virtual {v2, v0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    :cond_0
    invoke-static {}, Lcom/baidu/location/b/e;->a()Lcom/baidu/location/b/e;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/b/e;->i()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-static {}, Lcom/baidu/location/b/e;->a()Lcom/baidu/location/b/e;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/b/e;->f()Ljava/lang/String;

    move-result-object v0

    new-instance v2, Lcom/baidu/location/BDLocation;

    invoke-direct {v2, v0}, Lcom/baidu/location/BDLocation;-><init>(Ljava/lang/String;)V

    sget-object v0, Lcom/baidu/location/d/j;->g:Ljava/lang/String;

    const-string v3, "all"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-boolean v0, Lcom/baidu/location/d/j;->h:Z

    if-nez v0, :cond_1

    sget-boolean v0, Lcom/baidu/location/d/j;->i:Z

    if-eqz v0, :cond_4

    :cond_1
    const/4 v0, 0x2

    new-array v0, v0, [F

    iget-wide v3, p0, Lcom/baidu/location/a/l;->A:D

    iget-wide v5, p0, Lcom/baidu/location/a/l;->z:D

    invoke-virtual {v2}, Lcom/baidu/location/BDLocation;->getLatitude()D

    move-result-wide v7

    invoke-virtual {v2}, Lcom/baidu/location/BDLocation;->getLongitude()D

    move-result-wide v9

    move-object v11, v0

    invoke-static/range {v3 .. v11}, Landroid/location/Location;->distanceBetween(DDDD[F)V

    aget v0, v0, v1

    const/high16 v1, 0x42c80000    # 100.0f

    cmpg-float v0, v0, v1

    if-gez v0, :cond_4

    iget-object v0, p0, Lcom/baidu/location/a/l;->w:Lcom/baidu/location/Address;

    if-eqz v0, :cond_2

    invoke-virtual {v2, v0}, Lcom/baidu/location/BDLocation;->setAddr(Lcom/baidu/location/Address;)V

    :cond_2
    iget-object v0, p0, Lcom/baidu/location/a/l;->x:Ljava/lang/String;

    if-eqz v0, :cond_3

    invoke-virtual {v2, v0}, Lcom/baidu/location/BDLocation;->setLocationDescribe(Ljava/lang/String;)V

    :cond_3
    iget-object v0, p0, Lcom/baidu/location/a/l;->y:Ljava/util/List;

    if-eqz v0, :cond_4

    invoke-virtual {v2, v0}, Lcom/baidu/location/BDLocation;->setPoiList(Ljava/util/List;)V

    :cond_4
    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/baidu/location/a/a;->a(Lcom/baidu/location/BDLocation;)V

    :goto_0
    invoke-direct {p0}, Lcom/baidu/location/a/l;->k()V

    return-void

    :cond_5
    iget-boolean v0, p0, Lcom/baidu/location/a/l;->G:Z

    if-eqz v0, :cond_6

    invoke-direct {p0}, Lcom/baidu/location/a/l;->k()V

    return-void

    :cond_6
    iget-boolean v0, p0, Lcom/baidu/location/a/l;->j:Z

    const/4 v1, 0x0

    if-nez v0, :cond_7

    iget-object v0, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    if-eqz v0, :cond_7

    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object v0

    iget-object v2, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {v0, v2}, Lcom/baidu/location/a/a;->a(Lcom/baidu/location/BDLocation;)V

    goto :goto_1

    :cond_7
    new-instance v0, Lcom/baidu/location/BDLocation;

    invoke-direct {v0}, Lcom/baidu/location/BDLocation;-><init>()V

    const/16 v2, 0x3f

    invoke-virtual {v0, v2}, Lcom/baidu/location/BDLocation;->setLocType(I)V

    iput-object v1, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/baidu/location/a/a;->a(Lcom/baidu/location/BDLocation;)V

    :goto_1
    iput-object v1, p0, Lcom/baidu/location/a/l;->m:Lcom/baidu/location/BDLocation;

    goto :goto_0
.end method

.method public a(Landroid/os/Message;)V
    .locals 2

    iget-object v0, p0, Lcom/baidu/location/a/l;->E:Lcom/baidu/location/a/l$a;

    if-eqz v0, :cond_0

    iget-boolean v1, p0, Lcom/baidu/location/a/l;->F:Z

    if-eqz v1, :cond_0

    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/baidu/location/a/l;->F:Z

    iget-object v1, p0, Lcom/baidu/location/a/l;->g:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    :cond_0
    iget-object p1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast p1, Lcom/baidu/location/BDLocation;

    if-eqz p1, :cond_1

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result v0

    const/16 v1, 0xa7

    if-ne v0, v1, :cond_1

    iget-boolean v0, p0, Lcom/baidu/location/a/l;->J:Z

    if-eqz v0, :cond_1

    const/16 v0, 0x3e

    invoke-virtual {p1, v0}, Lcom/baidu/location/BDLocation;->setLocType(I)V

    :cond_1
    invoke-virtual {p0, p1}, Lcom/baidu/location/a/l;->b(Lcom/baidu/location/BDLocation;)V

    return-void
.end method

.method public b(Landroid/os/Message;)V
    .locals 1

    iget-boolean v0, p0, Lcom/baidu/location/a/l;->I:Z

    if-nez v0, :cond_0

    return-void

    :cond_0
    invoke-direct {p0, p1}, Lcom/baidu/location/a/l;->c(Landroid/os/Message;)V

    return-void
.end method

.method public b(Lcom/baidu/location/BDLocation;)V
    .locals 13

    new-instance v0, Lcom/baidu/location/BDLocation;

    invoke-direct {v0, p1}, Lcom/baidu/location/BDLocation;-><init>(Lcom/baidu/location/BDLocation;)V

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->hasAddr()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getAddress()Lcom/baidu/location/Address;

    move-result-object v0

    iput-object v0, p0, Lcom/baidu/location/a/l;->w:Lcom/baidu/location/Address;

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLongitude()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/baidu/location/a/l;->z:D

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLatitude()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/baidu/location/a/l;->A:D

    :cond_0
    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLocationDescribe()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLocationDescribe()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/baidu/location/a/l;->x:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLongitude()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/baidu/location/a/l;->z:D

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLatitude()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/baidu/location/a/l;->A:D

    :cond_1
    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getPoiList()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getPoiList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/baidu/location/a/l;->y:Ljava/util/List;

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLongitude()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/baidu/location/a/l;->z:D

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLatitude()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/baidu/location/a/l;->A:D

    :cond_2
    invoke-static {}, Lcom/baidu/location/b/e;->a()Lcom/baidu/location/b/e;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/b/e;->i()Z

    move-result v0

    const/high16 v1, 0x42c80000    # 100.0f

    const/4 v2, 0x2

    const/4 v3, 0x0

    if-eqz v0, :cond_7

    invoke-static {}, Lcom/baidu/location/b/e;->a()Lcom/baidu/location/b/e;

    move-result-object p1

    invoke-virtual {p1}, Lcom/baidu/location/b/e;->f()Ljava/lang/String;

    move-result-object p1

    new-instance v0, Lcom/baidu/location/BDLocation;

    invoke-direct {v0, p1}, Lcom/baidu/location/BDLocation;-><init>(Ljava/lang/String;)V

    sget-object p1, Lcom/baidu/location/d/j;->g:Ljava/lang/String;

    const-string v4, "all"

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_3

    sget-boolean p1, Lcom/baidu/location/d/j;->h:Z

    if-nez p1, :cond_3

    sget-boolean p1, Lcom/baidu/location/d/j;->i:Z

    if-eqz p1, :cond_6

    :cond_3
    new-array p1, v2, [F

    iget-wide v4, p0, Lcom/baidu/location/a/l;->A:D

    iget-wide v6, p0, Lcom/baidu/location/a/l;->z:D

    invoke-virtual {v0}, Lcom/baidu/location/BDLocation;->getLatitude()D

    move-result-wide v8

    invoke-virtual {v0}, Lcom/baidu/location/BDLocation;->getLongitude()D

    move-result-wide v10

    move-object v12, p1

    invoke-static/range {v4 .. v12}, Landroid/location/Location;->distanceBetween(DDDD[F)V

    aget p1, p1, v3

    cmpg-float p1, p1, v1

    if-gez p1, :cond_6

    iget-object p1, p0, Lcom/baidu/location/a/l;->w:Lcom/baidu/location/Address;

    if-eqz p1, :cond_4

    invoke-virtual {v0, p1}, Lcom/baidu/location/BDLocation;->setAddr(Lcom/baidu/location/Address;)V

    :cond_4
    iget-object p1, p0, Lcom/baidu/location/a/l;->x:Ljava/lang/String;

    if-eqz p1, :cond_5

    invoke-virtual {v0, p1}, Lcom/baidu/location/BDLocation;->setLocationDescribe(Ljava/lang/String;)V

    :cond_5
    iget-object p1, p0, Lcom/baidu/location/a/l;->y:Ljava/util/List;

    if-eqz p1, :cond_6

    invoke-virtual {v0, p1}, Lcom/baidu/location/BDLocation;->setPoiList(Ljava/util/List;)V

    :cond_6
    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object p1

    invoke-virtual {p1, v0}, Lcom/baidu/location/a/a;->a(Lcom/baidu/location/BDLocation;)V

    invoke-direct {p0}, Lcom/baidu/location/a/l;->k()V

    return-void

    :cond_7
    iget-boolean v0, p0, Lcom/baidu/location/a/l;->G:Z

    if-eqz v0, :cond_b

    new-array v0, v2, [F

    iget-object v1, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    if-eqz v1, :cond_8

    invoke-virtual {v1}, Lcom/baidu/location/BDLocation;->getLatitude()D

    move-result-wide v4

    iget-object v1, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {v1}, Lcom/baidu/location/BDLocation;->getLongitude()D

    move-result-wide v6

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLatitude()D

    move-result-wide v8

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLongitude()D

    move-result-wide v10

    move-object v12, v0

    invoke-static/range {v4 .. v12}, Landroid/location/Location;->distanceBetween(DDDD[F)V

    :cond_8
    aget v0, v0, v3

    const/high16 v1, 0x41200000    # 10.0f

    cmpl-float v0, v0, v1

    if-lez v0, :cond_9

    iput-object p1, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    iget-boolean v0, p0, Lcom/baidu/location/a/l;->H:Z

    if-nez v0, :cond_a

    iput-boolean v3, p0, Lcom/baidu/location/a/l;->H:Z

    goto :goto_0

    :cond_9
    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getUserIndoorState()I

    move-result v0

    const/4 v1, -0x1

    if-le v0, v1, :cond_a

    iput-object p1, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    :goto_0
    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/baidu/location/a/a;->a(Lcom/baidu/location/BDLocation;)V

    :cond_a
    invoke-direct {p0}, Lcom/baidu/location/a/l;->k()V

    return-void

    :cond_b
    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result v0

    const/16 v4, 0xa7

    const/4 v5, 0x1

    const/16 v6, 0xa1

    if-ne v0, v4, :cond_c

    invoke-static {}, Lcom/baidu/location/a/b;->a()Lcom/baidu/location/a/b;

    move-result-object v0

    const/16 v1, 0x8

    const-string v2, "NetWork location failed because baidu location service can not caculate the location!"

    invoke-virtual {v0, v4, v1, v2}, Lcom/baidu/location/a/b;->a(IILjava/lang/String;)V

    goto :goto_2

    :cond_c
    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result v0

    if-ne v0, v6, :cond_10

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x13

    if-lt v0, v4, :cond_e

    invoke-static {}, Lcom/baidu/location/f;->getServiceContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/baidu/location/d/j;->b(Landroid/content/Context;)I

    move-result v0

    if-eqz v0, :cond_d

    if-ne v0, v2, :cond_e

    :cond_d
    const/4 v0, 0x1

    goto :goto_1

    :cond_e
    const/4 v0, 0x0

    :goto_1
    if-eqz v0, :cond_f

    invoke-static {}, Lcom/baidu/location/a/b;->a()Lcom/baidu/location/a/b;

    move-result-object v0

    const-string v1, "NetWork location successful, open gps will be better!"

    invoke-virtual {v0, v6, v5, v1}, Lcom/baidu/location/a/b;->a(IILjava/lang/String;)V

    goto :goto_2

    :cond_f
    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getRadius()F

    move-result v0

    cmpl-float v0, v0, v1

    if-ltz v0, :cond_10

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getNetworkLocationType()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_10

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getNetworkLocationType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "cl"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_10

    invoke-static {}, Lcom/baidu/location/b/h;->a()Lcom/baidu/location/b/h;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/b/h;->g()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_10

    const-string v1, "&wifio=1"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10

    invoke-static {}, Lcom/baidu/location/a/b;->a()Lcom/baidu/location/a/b;

    move-result-object v0

    const-string v1, "NetWork location successful, open wifi will be better!"

    invoke-virtual {v0, v6, v2, v1}, Lcom/baidu/location/a/b;->a(IILjava/lang/String;)V

    :cond_10
    :goto_2
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/baidu/location/a/l;->m:Lcom/baidu/location/BDLocation;

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result v1

    if-ne v1, v6, :cond_11

    const-string v1, "cl"

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getNetworkLocationType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_11

    iget-object v1, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    if-eqz v1, :cond_11

    invoke-virtual {v1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result v1

    if-ne v1, v6, :cond_11

    const-string v1, "wf"

    iget-object v2, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {v2}, Lcom/baidu/location/BDLocation;->getNetworkLocationType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_11

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    iget-wide v6, p0, Lcom/baidu/location/a/l;->v:J

    sub-long/2addr v1, v6

    const-wide/16 v6, 0x7530

    cmp-long v4, v1, v6

    if-gez v4, :cond_11

    iput-object p1, p0, Lcom/baidu/location/a/l;->m:Lcom/baidu/location/BDLocation;

    const/4 v3, 0x1

    :cond_11
    if-eqz v3, :cond_12

    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object v1

    iget-object v2, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {v1, v2}, Lcom/baidu/location/a/a;->a(Lcom/baidu/location/BDLocation;)V

    goto :goto_3

    :cond_12
    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/baidu/location/a/a;->a(Lcom/baidu/location/BDLocation;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    iput-wide v1, p0, Lcom/baidu/location/a/l;->v:J

    :goto_3
    invoke-static {p1}, Lcom/baidu/location/d/j;->a(Lcom/baidu/location/BDLocation;)Z

    move-result v1

    if-eqz v1, :cond_13

    if-nez v3, :cond_14

    iput-object p1, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    goto :goto_4

    :cond_13
    iput-object v0, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    :cond_14
    :goto_4
    sget-object p1, Lcom/baidu/location/a/l;->c:Ljava/lang/String;

    const-string v1, "ssid\":\""

    const-string v2, "\""

    invoke-static {p1, v1, v2}, Lcom/baidu/location/d/j;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result p1

    const/high16 v1, -0x80000000

    if-eq p1, v1, :cond_15

    iget-object v1, p0, Lcom/baidu/location/a/l;->n:Lcom/baidu/location/b/g;

    if-eqz v1, :cond_15

    invoke-virtual {v1, p1}, Lcom/baidu/location/b/g;->c(I)Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lcom/baidu/location/a/l;->k:Ljava/lang/String;

    goto :goto_5

    :cond_15
    iput-object v0, p0, Lcom/baidu/location/a/l;->k:Ljava/lang/String;

    :goto_5
    invoke-static {}, Lcom/baidu/location/b/h;->i()Z

    invoke-direct {p0}, Lcom/baidu/location/a/l;->k()V

    return-void
.end method

.method public c(Lcom/baidu/location/BDLocation;)V
    .locals 1

    new-instance v0, Lcom/baidu/location/BDLocation;

    invoke-direct {v0, p1}, Lcom/baidu/location/BDLocation;-><init>(Lcom/baidu/location/BDLocation;)V

    iput-object v0, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    return-void
.end method

.method public d()V
    .locals 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->r:Z

    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/baidu/location/a/l;->s:Z

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->I:Z

    return-void
.end method

.method public e()V
    .locals 2

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->s:Z

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->t:Z

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->G:Z

    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/baidu/location/a/l;->H:Z

    invoke-virtual {p0}, Lcom/baidu/location/a/l;->i()V

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->I:Z

    return-void
.end method

.method public f()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/a/l;->x:Ljava/lang/String;

    return-object v0
.end method

.method public g()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lcom/baidu/location/Poi;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/baidu/location/a/l;->y:Ljava/util/List;

    return-object v0
.end method

.method public h()V
    .locals 1

    iget-boolean v0, p0, Lcom/baidu/location/a/l;->t:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/baidu/location/a/l;->h(Landroid/os/Message;)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/baidu/location/a/l;->t:Z

    :cond_0
    return-void
.end method

.method public i()V
    .locals 1

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/baidu/location/a/l;->l:Lcom/baidu/location/BDLocation;

    return-void
.end method
