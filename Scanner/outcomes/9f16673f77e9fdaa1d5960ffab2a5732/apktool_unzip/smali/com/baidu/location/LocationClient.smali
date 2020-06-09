.class public final Lcom/baidu/location/LocationClient;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/baidu/location/a/c$a;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/baidu/location/LocationClient$a;,
        Lcom/baidu/location/LocationClient$b;
    }
.end annotation


# static fields
.field public static final CONNECT_HOT_SPOT_FALSE:I = 0x0

.field public static final CONNECT_HOT_SPOT_TRUE:I = 0x1

.field public static final CONNECT_HOT_SPOT_UNKNOWN:I = -0x1

.field public static final LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_GPS:I = 0x1

.field public static final LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_WIFI:I = 0x2

.field public static final LOC_DIAGNOSTIC_TYPE_FAIL_UNKNOWN:I = 0x9

.field public static final LOC_DIAGNOSTIC_TYPE_NEED_CHECK_LOC_PERMISSION:I = 0x4

.field public static final LOC_DIAGNOSTIC_TYPE_NEED_CHECK_NET:I = 0x3

.field public static final LOC_DIAGNOSTIC_TYPE_NEED_CLOSE_FLYMODE:I = 0x7

.field public static final LOC_DIAGNOSTIC_TYPE_NEED_INSERT_SIMCARD_OR_OPEN_WIFI:I = 0x6

.field public static final LOC_DIAGNOSTIC_TYPE_NEED_OPEN_PHONE_LOC_SWITCH:I = 0x5

.field public static final LOC_DIAGNOSTIC_TYPE_SERVER_FAIL:I = 0x8


# instance fields
.field private A:Ljava/lang/Boolean;

.field private B:Z

.field private C:Lcom/baidu/location/a/c;

.field private D:Z

.field private E:Z

.field private F:Z

.field private G:Landroid/content/ServiceConnection;

.field private a:J

.field private b:Ljava/lang/String;

.field private c:Lcom/baidu/location/LocationClientOption;

.field private d:Lcom/baidu/location/LocationClientOption;

.field private e:Z

.field private f:Landroid/content/Context;

.field private g:Landroid/os/Messenger;

.field private h:Lcom/baidu/location/LocationClient$a;

.field private final i:Landroid/os/Messenger;

.field private j:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/baidu/location/BDLocationListener;",
            ">;"
        }
    .end annotation
.end field

.field private k:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/baidu/location/BDAbstractLocationListener;",
            ">;"
        }
    .end annotation
.end field

.field private l:Lcom/baidu/location/BDLocation;

.field private m:Z

.field private n:Z

.field private o:Z

.field private p:Lcom/baidu/location/LocationClient$b;

.field private q:Z

.field private final r:Ljava/lang/Object;

.field private s:J

.field private t:J

.field private u:Ljava/lang/String;

.field private v:Ljava/lang/String;

.field private w:Z

.field private x:Z

.field private y:Ljava/lang/Boolean;

.field private z:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/baidu/location/LocationClient;->a:J

    const/4 v2, 0x0

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->b:Ljava/lang/String;

    new-instance v3, Lcom/baidu/location/LocationClientOption;

    invoke-direct {v3}, Lcom/baidu/location/LocationClientOption;-><init>()V

    iput-object v3, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    new-instance v3, Lcom/baidu/location/LocationClientOption;

    invoke-direct {v3}, Lcom/baidu/location/LocationClientOption;-><init>()V

    iput-object v3, p0, Lcom/baidu/location/LocationClient;->d:Lcom/baidu/location/LocationClientOption;

    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->e:Z

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->g:Landroid/os/Messenger;

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->j:Ljava/util/ArrayList;

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->k:Ljava/util/ArrayList;

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->l:Lcom/baidu/location/BDLocation;

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->m:Z

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->n:Z

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->o:Z

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->p:Lcom/baidu/location/LocationClient$b;

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->q:Z

    new-instance v4, Ljava/lang/Object;

    invoke-direct {v4}, Ljava/lang/Object;-><init>()V

    iput-object v4, p0, Lcom/baidu/location/LocationClient;->r:Ljava/lang/Object;

    iput-wide v0, p0, Lcom/baidu/location/LocationClient;->s:J

    iput-wide v0, p0, Lcom/baidu/location/LocationClient;->t:J

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->u:Ljava/lang/String;

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->w:Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/baidu/location/LocationClient;->x:Z

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, p0, Lcom/baidu/location/LocationClient;->y:Ljava/lang/Boolean;

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, p0, Lcom/baidu/location/LocationClient;->z:Ljava/lang/Boolean;

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/baidu/location/LocationClient;->A:Ljava/lang/Boolean;

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->C:Lcom/baidu/location/a/c;

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->D:Z

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->E:Z

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->F:Z

    new-instance v0, Lcom/baidu/location/b;

    invoke-direct {v0, p0}, Lcom/baidu/location/b;-><init>(Lcom/baidu/location/LocationClient;)V

    iput-object v0, p0, Lcom/baidu/location/LocationClient;->G:Landroid/content/ServiceConnection;

    iput-object p1, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    new-instance p1, Lcom/baidu/location/LocationClientOption;

    invoke-direct {p1}, Lcom/baidu/location/LocationClientOption;-><init>()V

    iput-object p1, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    new-instance p1, Lcom/baidu/location/LocationClientOption;

    invoke-direct {p1}, Lcom/baidu/location/LocationClientOption;-><init>()V

    iput-object p1, p0, Lcom/baidu/location/LocationClient;->d:Lcom/baidu/location/LocationClientOption;

    new-instance p1, Lcom/baidu/location/LocationClient$a;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-direct {p1, v0, p0}, Lcom/baidu/location/LocationClient$a;-><init>(Landroid/os/Looper;Lcom/baidu/location/LocationClient;)V

    iput-object p1, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    new-instance p1, Landroid/os/Messenger;

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    invoke-direct {p1, v0}, Landroid/os/Messenger;-><init>(Landroid/os/Handler;)V

    iput-object p1, p0, Lcom/baidu/location/LocationClient;->i:Landroid/os/Messenger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/baidu/location/LocationClientOption;)V
    .locals 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/baidu/location/LocationClient;->a:J

    const/4 v2, 0x0

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->b:Ljava/lang/String;

    new-instance v3, Lcom/baidu/location/LocationClientOption;

    invoke-direct {v3}, Lcom/baidu/location/LocationClientOption;-><init>()V

    iput-object v3, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    new-instance v3, Lcom/baidu/location/LocationClientOption;

    invoke-direct {v3}, Lcom/baidu/location/LocationClientOption;-><init>()V

    iput-object v3, p0, Lcom/baidu/location/LocationClient;->d:Lcom/baidu/location/LocationClientOption;

    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->e:Z

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->g:Landroid/os/Messenger;

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->j:Ljava/util/ArrayList;

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->k:Ljava/util/ArrayList;

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->l:Lcom/baidu/location/BDLocation;

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->m:Z

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->n:Z

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->o:Z

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->p:Lcom/baidu/location/LocationClient$b;

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->q:Z

    new-instance v4, Ljava/lang/Object;

    invoke-direct {v4}, Ljava/lang/Object;-><init>()V

    iput-object v4, p0, Lcom/baidu/location/LocationClient;->r:Ljava/lang/Object;

    iput-wide v0, p0, Lcom/baidu/location/LocationClient;->s:J

    iput-wide v0, p0, Lcom/baidu/location/LocationClient;->t:J

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->u:Ljava/lang/String;

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->w:Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/baidu/location/LocationClient;->x:Z

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, p0, Lcom/baidu/location/LocationClient;->y:Ljava/lang/Boolean;

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, p0, Lcom/baidu/location/LocationClient;->z:Ljava/lang/Boolean;

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/baidu/location/LocationClient;->A:Ljava/lang/Boolean;

    iput-object v2, p0, Lcom/baidu/location/LocationClient;->C:Lcom/baidu/location/a/c;

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->D:Z

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->E:Z

    iput-boolean v3, p0, Lcom/baidu/location/LocationClient;->F:Z

    new-instance v0, Lcom/baidu/location/b;

    invoke-direct {v0, p0}, Lcom/baidu/location/b;-><init>(Lcom/baidu/location/LocationClient;)V

    iput-object v0, p0, Lcom/baidu/location/LocationClient;->G:Landroid/content/ServiceConnection;

    iput-object p1, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    iput-object p2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    new-instance p1, Lcom/baidu/location/LocationClientOption;

    invoke-direct {p1, p2}, Lcom/baidu/location/LocationClientOption;-><init>(Lcom/baidu/location/LocationClientOption;)V

    iput-object p1, p0, Lcom/baidu/location/LocationClient;->d:Lcom/baidu/location/LocationClientOption;

    new-instance p1, Lcom/baidu/location/LocationClient$a;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object p2

    invoke-direct {p1, p2, p0}, Lcom/baidu/location/LocationClient$a;-><init>(Landroid/os/Looper;Lcom/baidu/location/LocationClient;)V

    iput-object p1, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    new-instance p1, Landroid/os/Messenger;

    iget-object p2, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    invoke-direct {p1, p2}, Landroid/os/Messenger;-><init>(Landroid/os/Handler;)V

    iput-object p1, p0, Lcom/baidu/location/LocationClient;->i:Landroid/os/Messenger;

    return-void
.end method

.method static synthetic a(Lcom/baidu/location/LocationClient;)Landroid/os/Messenger;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/LocationClient;->g:Landroid/os/Messenger;

    return-object p0
.end method

.method static synthetic a(Lcom/baidu/location/LocationClient;Landroid/os/Messenger;)Landroid/os/Messenger;
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/LocationClient;->g:Landroid/os/Messenger;

    return-object p1
.end method

.method static synthetic a(Lcom/baidu/location/LocationClient;Lcom/baidu/location/LocationClient$b;)Lcom/baidu/location/LocationClient$b;
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/LocationClient;->p:Lcom/baidu/location/LocationClient$b;

    return-object p1
.end method

.method static synthetic a(Lcom/baidu/location/LocationClient;Lcom/baidu/location/a/c;)Lcom/baidu/location/a/c;
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/LocationClient;->C:Lcom/baidu/location/a/c;

    return-object p1
.end method

.method private a()V
    .locals 5

    iget-boolean v0, p0, Lcom/baidu/location/LocationClient;->e:Z

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    return-void

    :cond_0
    iget-object v0, p0, Lcom/baidu/location/LocationClient;->A:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    const/4 v2, 0x0

    if-eqz v0, :cond_1

    new-instance v0, Lcom/baidu/location/c;

    invoke-direct {v0, p0}, Lcom/baidu/location/c;-><init>(Lcom/baidu/location/LocationClient;)V

    invoke-virtual {v0}, Lcom/baidu/location/c;->start()V

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/baidu/location/LocationClient;->A:Ljava/lang/Boolean;

    :cond_1
    iget-object v0, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/baidu/location/LocationClient;->b:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/baidu/location/LocationClient;->b:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, "_bdls_v2.9"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/baidu/location/LocationClient;->u:Ljava/lang/String;

    new-instance v0, Landroid/content/Intent;

    iget-object v3, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    const-class v4, Lcom/baidu/location/f;

    invoke-direct {v0, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    :try_start_0
    const-string v3, "debug_dev"

    iget-boolean v4, p0, Lcom/baidu/location/LocationClient;->B:Z

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v3

    :goto_0
    iget-object v3, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    if-nez v3, :cond_2

    new-instance v3, Lcom/baidu/location/LocationClientOption;

    invoke-direct {v3}, Lcom/baidu/location/LocationClientOption;-><init>()V

    iput-object v3, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    :cond_2
    const-string v3, "cache_exception"

    iget-object v4, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean v4, v4, Lcom/baidu/location/LocationClientOption;->isIgnoreCacheException:Z

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    const-string v3, "kill_process"

    iget-object v4, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean v4, v4, Lcom/baidu/location/LocationClientOption;->isIgnoreKillProcess:Z

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    :try_start_1
    iget-object v3, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    iget-object v4, p0, Lcom/baidu/location/LocationClient;->G:Landroid/content/ServiceConnection;

    invoke-virtual {v3, v0, v4, v1}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_1

    :catch_1
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    iput-boolean v2, p0, Lcom/baidu/location/LocationClient;->e:Z

    :goto_1
    return-void
.end method

.method private a(I)V
    .locals 4

    iget-object p1, p0, Lcom/baidu/location/LocationClient;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getCoorType()Ljava/lang/String;

    move-result-object p1

    if-nez p1, :cond_0

    iget-object p1, p0, Lcom/baidu/location/LocationClient;->l:Lcom/baidu/location/BDLocation;

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-object v0, v0, Lcom/baidu/location/LocationClientOption;->coorType:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lcom/baidu/location/BDLocation;->setCoorType(Ljava/lang/String;)V

    :cond_0
    iget-boolean p1, p0, Lcom/baidu/location/LocationClient;->m:Z

    const/16 v0, 0x43

    const/16 v1, 0x42

    const/4 v2, 0x1

    if-eq p1, v2, :cond_2

    iget-object p1, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean p1, p1, Lcom/baidu/location/LocationClientOption;->location_change_notify:Z

    if-ne p1, v2, :cond_1

    iget-object p1, p0, Lcom/baidu/location/LocationClient;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result p1

    const/16 v2, 0x3d

    if-eq p1, v2, :cond_2

    :cond_1
    iget-object p1, p0, Lcom/baidu/location/LocationClient;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result p1

    if-eq p1, v1, :cond_2

    iget-object p1, p0, Lcom/baidu/location/LocationClient;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result p1

    if-eq p1, v0, :cond_2

    iget-boolean p1, p0, Lcom/baidu/location/LocationClient;->w:Z

    if-nez p1, :cond_2

    iget-object p1, p0, Lcom/baidu/location/LocationClient;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result p1

    const/16 v2, 0xa1

    if-ne p1, v2, :cond_6

    :cond_2
    iget-object p1, p0, Lcom/baidu/location/LocationClient;->j:Ljava/util/ArrayList;

    if-eqz p1, :cond_3

    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/baidu/location/BDLocationListener;

    iget-object v3, p0, Lcom/baidu/location/LocationClient;->l:Lcom/baidu/location/BDLocation;

    invoke-interface {v2, v3}, Lcom/baidu/location/BDLocationListener;->onReceiveLocation(Lcom/baidu/location/BDLocation;)V

    goto :goto_0

    :cond_3
    iget-object p1, p0, Lcom/baidu/location/LocationClient;->k:Ljava/util/ArrayList;

    if-eqz p1, :cond_4

    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_1
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/baidu/location/BDAbstractLocationListener;

    iget-object v3, p0, Lcom/baidu/location/LocationClient;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {v2, v3}, Lcom/baidu/location/BDAbstractLocationListener;->onReceiveLocation(Lcom/baidu/location/BDLocation;)V

    goto :goto_1

    :cond_4
    iget-object p1, p0, Lcom/baidu/location/LocationClient;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result p1

    if-eq p1, v1, :cond_6

    iget-object p1, p0, Lcom/baidu/location/LocationClient;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result p1

    if-ne p1, v0, :cond_5

    goto :goto_2

    :cond_5
    const/4 p1, 0x0

    iput-boolean p1, p0, Lcom/baidu/location/LocationClient;->m:Z

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/baidu/location/LocationClient;->t:J

    :cond_6
    :goto_2
    return-void
.end method

.method private a(ILandroid/app/Notification;)V
    .locals 3

    :try_start_0
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    const-class v2, Lcom/baidu/location/f;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string v1, "notification"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    const-string p2, "id"

    invoke-virtual {v0, p2, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    const-string p1, "command"

    const/4 p2, 0x1

    invoke-virtual {v0, p1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-lt p1, v1, :cond_0

    iget-object p1, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    invoke-virtual {p1, v0}, Landroid/content/Context;->startForegroundService(Landroid/content/Intent;)Landroid/content/ComponentName;

    goto :goto_0

    :cond_0
    iget-object p1, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    invoke-virtual {p1, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    :goto_0
    iput-boolean p2, p0, Lcom/baidu/location/LocationClient;->F:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception p1

    :goto_1
    return-void
.end method

.method private a(Landroid/os/Message;)V
    .locals 7

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/baidu/location/LocationClient;->n:Z

    if-eqz p1, :cond_6

    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    if-nez v1, :cond_0

    goto/16 :goto_1

    :cond_0
    iget-object p1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast p1, Lcom/baidu/location/LocationClientOption;

    iget-object v1, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    invoke-virtual {v1, p1}, Lcom/baidu/location/LocationClientOption;->optionEquals(Lcom/baidu/location/LocationClientOption;)Z

    move-result v1

    if-nez v1, :cond_6

    iget-object v1, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget v1, v1, Lcom/baidu/location/LocationClientOption;->scanSpan:I

    iget v2, p1, Lcom/baidu/location/LocationClientOption;->scanSpan:I

    const/4 v3, 0x0

    if-eq v1, v2, :cond_4

    :try_start_0
    iget-object v1, p0, Lcom/baidu/location/LocationClient;->r:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-boolean v2, p0, Lcom/baidu/location/LocationClient;->o:Z

    const/4 v4, 0x1

    if-ne v2, v4, :cond_1

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    iget-object v5, p0, Lcom/baidu/location/LocationClient;->p:Lcom/baidu/location/LocationClient$b;

    invoke-virtual {v2, v5}, Lcom/baidu/location/LocationClient$a;->removeCallbacks(Ljava/lang/Runnable;)V

    iput-boolean v0, p0, Lcom/baidu/location/LocationClient;->o:Z

    :cond_1
    iget v0, p1, Lcom/baidu/location/LocationClientOption;->scanSpan:I

    const/16 v2, 0x3e8

    if-lt v0, v2, :cond_3

    iget-boolean v0, p0, Lcom/baidu/location/LocationClient;->o:Z

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->p:Lcom/baidu/location/LocationClient$b;

    if-nez v0, :cond_2

    new-instance v0, Lcom/baidu/location/LocationClient$b;

    invoke-direct {v0, p0, v3}, Lcom/baidu/location/LocationClient$b;-><init>(Lcom/baidu/location/LocationClient;Lcom/baidu/location/b;)V

    iput-object v0, p0, Lcom/baidu/location/LocationClient;->p:Lcom/baidu/location/LocationClient$b;

    :cond_2
    iget-object v0, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->p:Lcom/baidu/location/LocationClient$b;

    iget v5, p1, Lcom/baidu/location/LocationClientOption;->scanSpan:I

    int-to-long v5, v5

    invoke-virtual {v0, v2, v5, v6}, Lcom/baidu/location/LocationClient$a;->postDelayed(Ljava/lang/Runnable;J)Z

    iput-boolean v4, p0, Lcom/baidu/location/LocationClient;->o:Z

    :cond_3
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v0
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    :catch_0
    move-exception v0

    :cond_4
    :goto_0
    new-instance v0, Lcom/baidu/location/LocationClientOption;

    invoke-direct {v0, p1}, Lcom/baidu/location/LocationClientOption;-><init>(Lcom/baidu/location/LocationClientOption;)V

    iput-object v0, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-object p1, p0, Lcom/baidu/location/LocationClient;->g:Landroid/os/Messenger;

    if-nez p1, :cond_5

    return-void

    :cond_5
    const/16 p1, 0xf

    :try_start_3
    invoke-static {v3, p1}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object p1

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->i:Landroid/os/Messenger;

    iput-object v0, p1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    invoke-direct {p0}, Lcom/baidu/location/LocationClient;->c()Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->g:Landroid/os/Messenger;

    invoke-virtual {v0, p1}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_1

    :catch_1
    move-exception p1

    invoke-virtual {p1}, Ljava/lang/Exception;->printStackTrace()V

    :cond_6
    :goto_1
    return-void
.end method

.method private a(Landroid/os/Message;I)V
    .locals 2

    iget-boolean v0, p0, Lcom/baidu/location/LocationClient;->e:Z

    if-nez v0, :cond_0

    return-void

    :cond_0
    :try_start_0
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object p1

    const-class v0, Lcom/baidu/location/BDLocation;

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->setClassLoader(Ljava/lang/ClassLoader;)V

    const-string v0, "locStr"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/baidu/location/BDLocation;

    iput-object p1, p0, Lcom/baidu/location/LocationClient;->l:Lcom/baidu/location/BDLocation;

    iget-object p1, p0, Lcom/baidu/location/LocationClient;->l:Lcom/baidu/location/BDLocation;

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result p1

    const/16 v0, 0x3d

    if-ne p1, v0, :cond_1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/baidu/location/LocationClient;->s:J

    :cond_1
    invoke-direct {p0, p2}, Lcom/baidu/location/LocationClient;->a(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p1

    :goto_0
    return-void
.end method

.method private a(Lcom/baidu/location/BDLocation;)V
    .locals 2

    iget-boolean v0, p0, Lcom/baidu/location/LocationClient;->x:Z

    if-eqz v0, :cond_0

    return-void

    :cond_0
    iput-object p1, p0, Lcom/baidu/location/LocationClient;->l:Lcom/baidu/location/BDLocation;

    iget-boolean v0, p0, Lcom/baidu/location/LocationClient;->E:Z

    if-nez v0, :cond_1

    invoke-virtual {p1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result v0

    const/16 v1, 0xa1

    if-ne v0, v1, :cond_1

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/baidu/location/LocationClient;->D:Z

    :cond_1
    iget-object v0, p0, Lcom/baidu/location/LocationClient;->j:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/baidu/location/BDLocationListener;

    invoke-interface {v1, p1}, Lcom/baidu/location/BDLocationListener;->onReceiveLocation(Lcom/baidu/location/BDLocation;)V

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/baidu/location/LocationClient;->k:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/baidu/location/BDAbstractLocationListener;

    invoke-virtual {v1, p1}, Lcom/baidu/location/BDAbstractLocationListener;->onReceiveLocation(Lcom/baidu/location/BDLocation;)V

    goto :goto_1

    :cond_3
    return-void
.end method

.method static synthetic a(Lcom/baidu/location/LocationClient;ILandroid/app/Notification;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/baidu/location/LocationClient;->a(ILandroid/app/Notification;)V

    return-void
.end method

.method static synthetic a(Lcom/baidu/location/LocationClient;Landroid/os/Message;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/LocationClient;->a(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic a(Lcom/baidu/location/LocationClient;Landroid/os/Message;I)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/baidu/location/LocationClient;->a(Landroid/os/Message;I)V

    return-void
.end method

.method static synthetic a(Lcom/baidu/location/LocationClient;Lcom/baidu/location/BDLocation;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/LocationClient;->a(Lcom/baidu/location/BDLocation;)V

    return-void
.end method

.method private a(Z)V
    .locals 3

    :try_start_0
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    const-class v2, Lcom/baidu/location/f;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string v1, "removenotify"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    const-string p1, "command"

    const/4 v1, 0x2

    invoke-virtual {v0, p1, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    iget-object p1, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    invoke-virtual {p1, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    const/4 p1, 0x1

    iput-boolean p1, p0, Lcom/baidu/location/LocationClient;->F:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p1

    :goto_0
    return-void
.end method

.method static synthetic a(Lcom/baidu/location/LocationClient;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/baidu/location/LocationClient;->e:Z

    return p1
.end method

.method private b()V
    .locals 5

    iget-boolean v0, p0, Lcom/baidu/location/LocationClient;->e:Z

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->g:Landroid/os/Messenger;

    if-nez v0, :cond_0

    goto :goto_5

    :cond_0
    const/16 v0, 0xc

    const/4 v1, 0x0

    invoke-static {v1, v0}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v0

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->i:Landroid/os/Messenger;

    iput-object v2, v0, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    :try_start_0
    iget-object v2, p0, Lcom/baidu/location/LocationClient;->g:Landroid/os/Messenger;

    invoke-virtual {v2, v0}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    :goto_0
    const/4 v0, 0x0

    :try_start_1
    iget-object v2, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    iget-object v3, p0, Lcom/baidu/location/LocationClient;->G:Landroid/content/ServiceConnection;

    invoke-virtual {v2, v3}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V

    iget-boolean v2, p0, Lcom/baidu/location/LocationClient;->F:Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    if-eqz v2, :cond_1

    :try_start_2
    new-instance v2, Landroid/content/Intent;

    iget-object v3, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    const-class v4, Lcom/baidu/location/f;

    invoke-direct {v2, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    iget-object v3, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    invoke-virtual {v3, v2}, Landroid/content/Context;->stopService(Landroid/content/Intent;)Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_1

    :catch_1
    move-exception v2

    :goto_1
    :try_start_3
    iput-boolean v0, p0, Lcom/baidu/location/LocationClient;->F:Z
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2

    goto :goto_2

    :catch_2
    move-exception v2

    :cond_1
    :goto_2
    iget-object v2, p0, Lcom/baidu/location/LocationClient;->r:Ljava/lang/Object;

    monitor-enter v2

    :try_start_4
    iget-boolean v3, p0, Lcom/baidu/location/LocationClient;->o:Z

    const/4 v4, 0x1

    if-ne v3, v4, :cond_2

    iget-object v3, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    iget-object v4, p0, Lcom/baidu/location/LocationClient;->p:Lcom/baidu/location/LocationClient$b;

    invoke-virtual {v3, v4}, Lcom/baidu/location/LocationClient$a;->removeCallbacks(Ljava/lang/Runnable;)V

    iput-boolean v0, p0, Lcom/baidu/location/LocationClient;->o:Z
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_3
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_3

    :catchall_0
    move-exception v0

    goto :goto_4

    :catch_3
    move-exception v3

    :cond_2
    :goto_3
    :try_start_5
    monitor-exit v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    iput-object v1, p0, Lcom/baidu/location/LocationClient;->g:Landroid/os/Messenger;

    iput-boolean v0, p0, Lcom/baidu/location/LocationClient;->n:Z

    iput-boolean v0, p0, Lcom/baidu/location/LocationClient;->w:Z

    iput-boolean v0, p0, Lcom/baidu/location/LocationClient;->e:Z

    iput-boolean v0, p0, Lcom/baidu/location/LocationClient;->D:Z

    iput-boolean v0, p0, Lcom/baidu/location/LocationClient;->E:Z

    return-void

    :goto_4
    :try_start_6
    monitor-exit v2
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    throw v0

    :cond_3
    :goto_5
    return-void
.end method

.method private b(Landroid/os/Message;)V
    .locals 1

    if-eqz p1, :cond_2

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    if-nez v0, :cond_0

    goto :goto_0

    :cond_0
    iget-object p1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast p1, Lcom/baidu/location/BDLocationListener;

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->j:Ljava/util/ArrayList;

    if-nez v0, :cond_1

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/baidu/location/LocationClient;->j:Ljava/util/ArrayList;

    :cond_1
    iget-object v0, p0, Lcom/baidu/location/LocationClient;->j:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->j:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_2
    :goto_0
    return-void
.end method

.method static synthetic b(Lcom/baidu/location/LocationClient;Landroid/os/Message;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/LocationClient;->b(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic b(Lcom/baidu/location/LocationClient;)Z
    .locals 0

    iget-boolean p0, p0, Lcom/baidu/location/LocationClient;->x:Z

    return p0
.end method

.method static synthetic b(Lcom/baidu/location/LocationClient;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/baidu/location/LocationClient;->o:Z

    return p1
.end method

.method private c()Landroid/os/Bundle;
    .locals 3

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    return-object v0

    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string v1, "packName"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->b:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "prodName"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-object v2, v2, Lcom/baidu/location/LocationClientOption;->prodName:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "coorType"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-object v2, v2, Lcom/baidu/location/LocationClientOption;->coorType:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "addrType"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-object v2, v2, Lcom/baidu/location/LocationClientOption;->addrType:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "openGPS"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean v2, v2, Lcom/baidu/location/LocationClientOption;->openGps:Z

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    const-string v1, "location_change_notify"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean v2, v2, Lcom/baidu/location/LocationClientOption;->location_change_notify:Z

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    const-string v1, "scanSpan"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget v2, v2, Lcom/baidu/location/LocationClientOption;->scanSpan:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    const-string v1, "enableSimulateGps"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean v2, v2, Lcom/baidu/location/LocationClientOption;->enableSimulateGps:Z

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    const-string v1, "timeOut"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget v2, v2, Lcom/baidu/location/LocationClientOption;->timeOut:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    const-string v1, "priority"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget v2, v2, Lcom/baidu/location/LocationClientOption;->priority:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    const-string v1, "map"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->y:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    const-string v1, "import"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->z:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    const-string v1, "needDirect"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean v2, v2, Lcom/baidu/location/LocationClientOption;->mIsNeedDeviceDirect:Z

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    const-string v1, "isneedaptag"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean v2, v2, Lcom/baidu/location/LocationClientOption;->isNeedAptag:Z

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    const-string v1, "isneedpoiregion"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean v2, v2, Lcom/baidu/location/LocationClientOption;->isNeedPoiRegion:Z

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    const-string v1, "isneedregular"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean v2, v2, Lcom/baidu/location/LocationClientOption;->isNeedRegular:Z

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    const-string v1, "isneedaptagd"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean v2, v2, Lcom/baidu/location/LocationClientOption;->isNeedAptagd:Z

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    const-string v1, "isneedaltitude"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean v2, v2, Lcom/baidu/location/LocationClientOption;->isNeedAltitude:Z

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    const-string v1, "autoNotifyMaxInterval"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    invoke-virtual {v2}, Lcom/baidu/location/LocationClientOption;->a()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    const-string v1, "autoNotifyMinTimeInterval"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    invoke-virtual {v2}, Lcom/baidu/location/LocationClientOption;->getAutoNotifyMinTimeInterval()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    const-string v1, "autoNotifyMinDistance"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    invoke-virtual {v2}, Lcom/baidu/location/LocationClientOption;->getAutoNotifyMinDistance()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    const-string v1, "autoNotifyLocSensitivity"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    invoke-virtual {v2}, Lcom/baidu/location/LocationClientOption;->b()F

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putFloat(Ljava/lang/String;F)V

    const-string v1, "wifitimeout"

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget v2, v2, Lcom/baidu/location/LocationClientOption;->wifiCacheTimeOut:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    return-object v0
.end method

.method static synthetic c(Lcom/baidu/location/LocationClient;)Lcom/baidu/location/LocationClient$a;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    return-object p0
.end method

.method private c(Landroid/os/Message;)V
    .locals 1

    if-eqz p1, :cond_2

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    if-nez v0, :cond_0

    goto :goto_0

    :cond_0
    iget-object p1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast p1, Lcom/baidu/location/BDAbstractLocationListener;

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->k:Ljava/util/ArrayList;

    if-nez v0, :cond_1

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/baidu/location/LocationClient;->k:Ljava/util/ArrayList;

    :cond_1
    iget-object v0, p0, Lcom/baidu/location/LocationClient;->k:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->k:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_2
    :goto_0
    return-void
.end method

.method static synthetic c(Lcom/baidu/location/LocationClient;Landroid/os/Message;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/LocationClient;->e(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic c(Lcom/baidu/location/LocationClient;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/baidu/location/LocationClient;->q:Z

    return p1
.end method

.method static synthetic d(Lcom/baidu/location/LocationClient;)Landroid/os/Messenger;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/LocationClient;->i:Landroid/os/Messenger;

    return-object p0
.end method

.method private d()V
    .locals 7

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->g:Landroid/os/Messenger;

    if-nez v0, :cond_0

    return-void

    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/baidu/location/LocationClient;->s:J

    sub-long/2addr v0, v2

    const-wide/16 v2, 0xbb8

    const/4 v4, 0x1

    const/4 v5, 0x0

    cmp-long v6, v0, v2

    if-gtz v6, :cond_1

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget-boolean v0, v0, Lcom/baidu/location/LocationClientOption;->location_change_notify:Z

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lcom/baidu/location/LocationClient;->n:Z

    if-eqz v0, :cond_4

    :cond_1
    iget-boolean v0, p0, Lcom/baidu/location/LocationClient;->w:Z

    if-eqz v0, :cond_2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/baidu/location/LocationClient;->t:J

    sub-long/2addr v0, v2

    const-wide/16 v2, 0x4e20

    cmp-long v6, v0, v2

    if-gtz v6, :cond_2

    iget-boolean v0, p0, Lcom/baidu/location/LocationClient;->n:Z

    if-eqz v0, :cond_4

    :cond_2
    const/16 v0, 0x16

    invoke-static {v5, v0}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v0

    iget-boolean v1, p0, Lcom/baidu/location/LocationClient;->n:Z

    if-eqz v1, :cond_3

    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    const-string v2, "isWaitingLocTag"

    iget-boolean v3, p0, Lcom/baidu/location/LocationClient;->n:Z

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/baidu/location/LocationClient;->n:Z

    invoke-virtual {v0, v1}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    :cond_3
    :try_start_0
    iget-object v1, p0, Lcom/baidu/location/LocationClient;->i:Landroid/os/Messenger;

    iput-object v1, v0, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    iget-object v1, p0, Lcom/baidu/location/LocationClient;->g:Landroid/os/Messenger;

    invoke-virtual {v1, v0}, Landroid/os/Messenger;->send(Landroid/os/Message;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/baidu/location/LocationClient;->a:J

    iput-boolean v4, p0, Lcom/baidu/location/LocationClient;->m:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    :cond_4
    :goto_0
    iget-object v0, p0, Lcom/baidu/location/LocationClient;->r:Ljava/lang/Object;

    monitor-enter v0

    :try_start_1
    iget-object v1, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    if-eqz v1, :cond_6

    iget-object v1, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget v1, v1, Lcom/baidu/location/LocationClientOption;->scanSpan:I

    const/16 v2, 0x3e8

    if-lt v1, v2, :cond_6

    iget-boolean v1, p0, Lcom/baidu/location/LocationClient;->o:Z

    if-nez v1, :cond_6

    iget-object v1, p0, Lcom/baidu/location/LocationClient;->p:Lcom/baidu/location/LocationClient$b;

    if-nez v1, :cond_5

    new-instance v1, Lcom/baidu/location/LocationClient$b;

    invoke-direct {v1, p0, v5}, Lcom/baidu/location/LocationClient$b;-><init>(Lcom/baidu/location/LocationClient;Lcom/baidu/location/b;)V

    iput-object v1, p0, Lcom/baidu/location/LocationClient;->p:Lcom/baidu/location/LocationClient$b;

    :cond_5
    iget-object v1, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->p:Lcom/baidu/location/LocationClient$b;

    iget-object v3, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    iget v3, v3, Lcom/baidu/location/LocationClientOption;->scanSpan:I

    int-to-long v5, v3

    invoke-virtual {v1, v2, v5, v6}, Lcom/baidu/location/LocationClient$a;->postDelayed(Ljava/lang/Runnable;J)Z

    iput-boolean v4, p0, Lcom/baidu/location/LocationClient;->o:Z

    :cond_6
    monitor-exit v0

    return-void

    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method private d(Landroid/os/Message;)V
    .locals 1

    if-eqz p1, :cond_1

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    if-nez v0, :cond_0

    goto :goto_0

    :cond_0
    iget-object p1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast p1, Lcom/baidu/location/BDAbstractLocationListener;

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->k:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->k:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    :cond_1
    :goto_0
    return-void
.end method

.method static synthetic d(Lcom/baidu/location/LocationClient;Landroid/os/Message;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/LocationClient;->c(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic d(Lcom/baidu/location/LocationClient;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/baidu/location/LocationClient;->E:Z

    return p1
.end method

.method static synthetic e(Lcom/baidu/location/LocationClient;)Landroid/os/Bundle;
    .locals 0

    invoke-direct {p0}, Lcom/baidu/location/LocationClient;->c()Landroid/os/Bundle;

    move-result-object p0

    return-object p0
.end method

.method private e(Landroid/os/Message;)V
    .locals 1

    if-eqz p1, :cond_1

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    if-nez v0, :cond_0

    goto :goto_0

    :cond_0
    iget-object p1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast p1, Lcom/baidu/location/BDLocationListener;

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->j:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->j:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    :cond_1
    :goto_0
    return-void
.end method

.method static synthetic e(Lcom/baidu/location/LocationClient;Landroid/os/Message;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/LocationClient;->d(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic e(Lcom/baidu/location/LocationClient;Z)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/LocationClient;->a(Z)V

    return-void
.end method

.method static synthetic f(Lcom/baidu/location/LocationClient;)Lcom/baidu/location/LocationClientOption;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    return-object p0
.end method

.method static synthetic g(Lcom/baidu/location/LocationClient;)Ljava/lang/Boolean;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/LocationClient;->A:Ljava/lang/Boolean;

    return-object p0
.end method

.method public static getBDLocationInCoorType(Lcom/baidu/location/BDLocation;Ljava/lang/String;)Lcom/baidu/location/BDLocation;
    .locals 5

    new-instance v0, Lcom/baidu/location/BDLocation;

    invoke-direct {v0, p0}, Lcom/baidu/location/BDLocation;-><init>(Lcom/baidu/location/BDLocation;)V

    invoke-virtual {p0}, Lcom/baidu/location/BDLocation;->getLongitude()D

    move-result-wide v1

    invoke-virtual {p0}, Lcom/baidu/location/BDLocation;->getLatitude()D

    move-result-wide v3

    invoke-static {v1, v2, v3, v4, p1}, Lcom/baidu/location/Jni;->coorEncrypt(DDLjava/lang/String;)[D

    move-result-object p0

    const/4 p1, 0x1

    aget-wide v1, p0, p1

    invoke-virtual {v0, v1, v2}, Lcom/baidu/location/BDLocation;->setLatitude(D)V

    const/4 p1, 0x0

    aget-wide v1, p0, p1

    invoke-virtual {v0, v1, v2}, Lcom/baidu/location/BDLocation;->setLongitude(D)V

    return-object v0
.end method

.method static synthetic h(Lcom/baidu/location/LocationClient;)Lcom/baidu/location/a/c;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/LocationClient;->C:Lcom/baidu/location/a/c;

    return-object p0
.end method

.method static synthetic i(Lcom/baidu/location/LocationClient;)Landroid/content/Context;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    return-object p0
.end method

.method static synthetic j(Lcom/baidu/location/LocationClient;)Lcom/baidu/location/LocationClientOption;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/LocationClient;->d:Lcom/baidu/location/LocationClientOption;

    return-object p0
.end method

.method static synthetic k(Lcom/baidu/location/LocationClient;)Ljava/lang/Object;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/LocationClient;->r:Ljava/lang/Object;

    return-object p0
.end method

.method static synthetic l(Lcom/baidu/location/LocationClient;)Ljava/util/ArrayList;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/LocationClient;->j:Ljava/util/ArrayList;

    return-object p0
.end method

.method static synthetic m(Lcom/baidu/location/LocationClient;)Ljava/util/ArrayList;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/LocationClient;->k:Ljava/util/ArrayList;

    return-object p0
.end method

.method static synthetic n(Lcom/baidu/location/LocationClient;)Z
    .locals 0

    iget-boolean p0, p0, Lcom/baidu/location/LocationClient;->n:Z

    return p0
.end method

.method static synthetic o(Lcom/baidu/location/LocationClient;)Lcom/baidu/location/LocationClient$b;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/LocationClient;->p:Lcom/baidu/location/LocationClient$b;

    return-object p0
.end method

.method static synthetic p(Lcom/baidu/location/LocationClient;)V
    .locals 0

    invoke-direct {p0}, Lcom/baidu/location/LocationClient;->a()V

    return-void
.end method

.method static synthetic q(Lcom/baidu/location/LocationClient;)V
    .locals 0

    invoke-direct {p0}, Lcom/baidu/location/LocationClient;->b()V

    return-void
.end method

.method static synthetic r(Lcom/baidu/location/LocationClient;)V
    .locals 0

    invoke-direct {p0}, Lcom/baidu/location/LocationClient;->d()V

    return-void
.end method

.method static synthetic s(Lcom/baidu/location/LocationClient;)Z
    .locals 0

    iget-boolean p0, p0, Lcom/baidu/location/LocationClient;->E:Z

    return p0
.end method

.method static synthetic t(Lcom/baidu/location/LocationClient;)Z
    .locals 0

    iget-boolean p0, p0, Lcom/baidu/location/LocationClient;->D:Z

    return p0
.end method


# virtual methods
.method public disableAssistantLocation()V
    .locals 1

    invoke-static {}, Lcom/baidu/location/a/k;->a()Lcom/baidu/location/a/k;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/a/k;->b()V

    return-void
.end method

.method public disableLocInForeground(Z)V
    .locals 2

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string v1, "removenotify"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    iget-object p1, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    const/16 v1, 0x2c0

    invoke-virtual {p1, v1}, Lcom/baidu/location/LocationClient$a;->obtainMessage(I)Landroid/os/Message;

    move-result-object p1

    invoke-virtual {p1, v0}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    invoke-virtual {p1}, Landroid/os/Message;->sendToTarget()V

    return-void
.end method

.method public enableAssistantLocation(Landroid/webkit/WebView;)V
    .locals 2

    invoke-static {}, Lcom/baidu/location/a/k;->a()Lcom/baidu/location/a/k;

    move-result-object v0

    iget-object v1, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    invoke-virtual {v0, v1, p1, p0}, Lcom/baidu/location/a/k;->a(Landroid/content/Context;Landroid/webkit/WebView;Lcom/baidu/location/LocationClient;)V

    return-void
.end method

.method public enableLocInForeground(ILandroid/app/Notification;)V
    .locals 2

    if-lez p1, :cond_0

    if-eqz p2, :cond_0

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string v1, "id"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    const-string p1, "notification"

    invoke-virtual {v0, p1, p2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    iget-object p1, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    const/16 p2, 0x2bf

    invoke-virtual {p1, p2}, Lcom/baidu/location/LocationClient$a;->obtainMessage(I)Landroid/os/Message;

    move-result-object p1

    invoke-virtual {p1, v0}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    invoke-virtual {p1}, Landroid/os/Message;->sendToTarget()V

    goto :goto_0

    :cond_0
    const-string p1, "baidu_location_Client"

    const-string p2, "can not startLocInForeground if the param is unlegal"

    invoke-static {p1, p2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :goto_0
    return-void
.end method

.method public getAccessKey()Ljava/lang/String;
    .locals 4

    :try_start_0
    iget-object v0, p0, Lcom/baidu/location/LocationClient;->f:Landroid/content/Context;

    invoke-static {v0}, Lcom/baidu/location/a/j;->b(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/baidu/location/LocationClient;->v:Ljava/lang/String;

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->v:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "KEY=%s"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/baidu/location/LocationClient;->v:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "please setting key from Manifest.xml"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    return-object v0
.end method

.method public getLastKnownLocation()Lcom/baidu/location/BDLocation;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->l:Lcom/baidu/location/BDLocation;

    return-object v0
.end method

.method public getLocOption()Lcom/baidu/location/LocationClientOption;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->c:Lcom/baidu/location/LocationClientOption;

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    const-string v0, "7.5.2"

    return-object v0
.end method

.method public isStarted()Z
    .locals 1

    iget-boolean v0, p0, Lcom/baidu/location/LocationClient;->e:Z

    return v0
.end method

.method public onReceiveLocation(Lcom/baidu/location/BDLocation;)V
    .locals 2

    iget-boolean v0, p0, Lcom/baidu/location/LocationClient;->E:Z

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    iget-boolean v0, p0, Lcom/baidu/location/LocationClient;->D:Z

    if-nez v0, :cond_0

    return-void

    :cond_0
    if-nez p1, :cond_1

    return-void

    :cond_1
    iget-object v0, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    const/16 v1, 0x2bd

    invoke-virtual {v0, v1}, Lcom/baidu/location/LocationClient$a;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    return-void
.end method

.method public registerLocationListener(Lcom/baidu/location/BDAbstractLocationListener;)V
    .locals 2

    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    const/16 v1, 0x514

    invoke-virtual {v0, v1}, Lcom/baidu/location/LocationClient$a;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    return-void

    :cond_0
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "please set a non-null listener"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public registerLocationListener(Lcom/baidu/location/BDLocationListener;)V
    .locals 2

    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Lcom/baidu/location/LocationClient$a;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    return-void

    :cond_0
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "please set a non-null listener"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public requestHotSpotState()Z
    .locals 3

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->g:Landroid/os/Messenger;

    const/4 v1, 0x0

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lcom/baidu/location/LocationClient;->e:Z

    if-nez v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    const/16 v2, 0x196

    :try_start_0
    invoke-static {v0, v2}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v0

    iget-object v2, p0, Lcom/baidu/location/LocationClient;->g:Landroid/os/Messenger;

    invoke-virtual {v2, v0}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x1

    return v0

    :catch_0
    move-exception v0

    :cond_1
    :goto_0
    return v1
.end method

.method public requestLocation()I
    .locals 6

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->g:Landroid/os/Messenger;

    const/4 v1, 0x1

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->i:Landroid/os/Messenger;

    if-nez v0, :cond_0

    goto :goto_1

    :cond_0
    iget-object v0, p0, Lcom/baidu/location/LocationClient;->j:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v0, v1, :cond_2

    :cond_1
    iget-object v0, p0, Lcom/baidu/location/LocationClient;->k:Ljava/util/ArrayList;

    if-eqz v0, :cond_4

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v0, v1, :cond_2

    goto :goto_0

    :cond_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/baidu/location/LocationClient;->a:J

    sub-long/2addr v2, v4

    const-wide/16 v4, 0x3e8

    cmp-long v0, v2, v4

    if-gez v0, :cond_3

    const/4 v0, 0x6

    return v0

    :cond_3
    iput-boolean v1, p0, Lcom/baidu/location/LocationClient;->n:Z

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Lcom/baidu/location/LocationClient$a;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    const/4 v1, 0x0

    iput v1, v0, Landroid/os/Message;->arg1:I

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    return v1

    :cond_4
    :goto_0
    const/4 v0, 0x2

    return v0

    :cond_5
    :goto_1
    return v1
.end method

.method public restart()V
    .locals 4

    invoke-virtual {p0}, Lcom/baidu/location/LocationClient;->stop()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/baidu/location/LocationClient;->x:Z

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    const/4 v1, 0x1

    const-wide/16 v2, 0x3e8

    invoke-virtual {v0, v1, v2, v3}, Lcom/baidu/location/LocationClient$a;->sendEmptyMessageDelayed(IJ)Z

    return-void
.end method

.method public setLocOption(Lcom/baidu/location/LocationClientOption;)V
    .locals 2

    if-nez p1, :cond_0

    new-instance p1, Lcom/baidu/location/LocationClientOption;

    invoke-direct {p1}, Lcom/baidu/location/LocationClientOption;-><init>()V

    :cond_0
    invoke-virtual {p1}, Lcom/baidu/location/LocationClientOption;->a()I

    move-result v0

    if-lez v0, :cond_1

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lcom/baidu/location/LocationClientOption;->setScanSpan(I)V

    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Lcom/baidu/location/LocationClientOption;->setLocationNotify(Z)V

    :cond_1
    new-instance v0, Lcom/baidu/location/LocationClientOption;

    invoke-direct {v0, p1}, Lcom/baidu/location/LocationClientOption;-><init>(Lcom/baidu/location/LocationClientOption;)V

    iput-object v0, p0, Lcom/baidu/location/LocationClient;->d:Lcom/baidu/location/LocationClientOption;

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lcom/baidu/location/LocationClient$a;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    return-void
.end method

.method public start()V
    .locals 2

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/baidu/location/LocationClient;->x:Z

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/baidu/location/LocationClient$a;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    return-void
.end method

.method public stop()V
    .locals 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/baidu/location/LocationClient;->x:Z

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Lcom/baidu/location/LocationClient$a;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/baidu/location/LocationClient;->C:Lcom/baidu/location/a/c;

    return-void
.end method

.method public unRegisterLocationListener(Lcom/baidu/location/BDAbstractLocationListener;)V
    .locals 2

    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    const/16 v1, 0x578

    invoke-virtual {v0, v1}, Lcom/baidu/location/LocationClient$a;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    return-void

    :cond_0
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "please set a non-null listener"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public unRegisterLocationListener(Lcom/baidu/location/BDLocationListener;)V
    .locals 2

    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->h:Lcom/baidu/location/LocationClient$a;

    const/4 v1, 0x6

    invoke-virtual {v0, v1}, Lcom/baidu/location/LocationClient$a;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    return-void

    :cond_0
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "please set a non-null listener"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public updateLocation(Landroid/location/Location;)Z
    .locals 2

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->g:Landroid/os/Messenger;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/baidu/location/LocationClient;->i:Landroid/os/Messenger;

    if-eqz v0, :cond_1

    if-nez p1, :cond_0

    goto :goto_1

    :cond_0
    const/4 v0, 0x0

    const/16 v1, 0x39

    :try_start_0
    invoke-static {v0, v1}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v0

    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    iget-object p1, p0, Lcom/baidu/location/LocationClient;->g:Landroid/os/Messenger;

    invoke-virtual {p1, v0}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p1

    invoke-virtual {p1}, Ljava/lang/Exception;->printStackTrace()V

    :goto_0
    const/4 p1, 0x1

    return p1

    :cond_1
    :goto_1
    const/4 p1, 0x0

    return p1
.end method
