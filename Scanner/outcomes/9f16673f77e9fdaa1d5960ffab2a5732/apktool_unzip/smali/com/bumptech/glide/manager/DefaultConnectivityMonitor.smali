.class Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;
.super Ljava/lang/Object;
.source "DefaultConnectivityMonitor.java"

# interfaces
.implements Lcom/bumptech/glide/manager/ConnectivityMonitor;


# instance fields
.field private final connectivityReceiver:Landroid/content/BroadcastReceiver;

.field private final context:Landroid/content/Context;

.field private isConnected:Z

.field private isRegistered:Z

.field private final listener:Lcom/bumptech/glide/manager/ConnectivityMonitor$ConnectivityListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/bumptech/glide/manager/ConnectivityMonitor$ConnectivityListener;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "listener"    # Lcom/bumptech/glide/manager/ConnectivityMonitor$ConnectivityListener;

    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    new-instance v0, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor$1;

    invoke-direct {v0, p0}, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor$1;-><init>(Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;)V

    iput-object v0, p0, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->connectivityReceiver:Landroid/content/BroadcastReceiver;

    .line 29
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->context:Landroid/content/Context;

    .line 30
    iput-object p2, p0, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->listener:Lcom/bumptech/glide/manager/ConnectivityMonitor$ConnectivityListener;

    .line 31
    return-void
.end method

.method static synthetic access$000(Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;)Z
    .locals 1
    .param p0, "x0"    # Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;

    .line 10
    iget-boolean v0, p0, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->isConnected:Z

    return v0
.end method

.method static synthetic access$002(Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;
    .param p1, "x1"    # Z

    .line 10
    iput-boolean p1, p0, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->isConnected:Z

    return p1
.end method

.method static synthetic access$100(Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;Landroid/content/Context;)Z
    .locals 1
    .param p0, "x0"    # Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;
    .param p1, "x1"    # Landroid/content/Context;

    .line 10
    invoke-direct {p0, p1}, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->isConnected(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$200(Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;)Lcom/bumptech/glide/manager/ConnectivityMonitor$ConnectivityListener;
    .locals 1
    .param p0, "x0"    # Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;

    .line 10
    iget-object v0, p0, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->listener:Lcom/bumptech/glide/manager/ConnectivityMonitor$ConnectivityListener;

    return-object v0
.end method

.method private isConnected(Landroid/content/Context;)Z
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .line 53
    const-string v0, "connectivity"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 55
    .local v0, "connectivityManager":Landroid/net/ConnectivityManager;
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    .line 56
    .local v1, "networkInfo":Landroid/net/NetworkInfo;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v2, 0x1

    goto :goto_0

    :cond_0
    const/4 v2, 0x0

    :goto_0
    return v2
.end method

.method private register()V
    .locals 4

    .line 34
    iget-boolean v0, p0, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->isRegistered:Z

    if-eqz v0, :cond_0

    .line 35
    return-void

    .line 38
    :cond_0
    iget-object v0, p0, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->context:Landroid/content/Context;

    invoke-direct {p0, v0}, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->isConnected(Landroid/content/Context;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->isConnected:Z

    .line 39
    iget-object v0, p0, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->context:Landroid/content/Context;

    iget-object v1, p0, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->connectivityReceiver:Landroid/content/BroadcastReceiver;

    new-instance v2, Landroid/content/IntentFilter;

    const-string v3, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-direct {v2, v3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 40
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->isRegistered:Z

    .line 41
    return-void
.end method

.method private unregister()V
    .locals 2

    .line 44
    iget-boolean v0, p0, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->isRegistered:Z

    if-nez v0, :cond_0

    .line 45
    return-void

    .line 48
    :cond_0
    iget-object v0, p0, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->context:Landroid/content/Context;

    iget-object v1, p0, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->connectivityReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 49
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->isRegistered:Z

    .line 50
    return-void
.end method


# virtual methods
.method public onDestroy()V
    .locals 0

    .line 72
    return-void
.end method

.method public onStart()V
    .locals 0

    .line 61
    invoke-direct {p0}, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->register()V

    .line 62
    return-void
.end method

.method public onStop()V
    .locals 0

    .line 66
    invoke-direct {p0}, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;->unregister()V

    .line 67
    return-void
.end method
