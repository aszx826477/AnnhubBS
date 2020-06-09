.class public Lcom/bumptech/glide/manager/ConnectivityMonitorFactory;
.super Ljava/lang/Object;
.source "ConnectivityMonitorFactory.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public build(Landroid/content/Context;Lcom/bumptech/glide/manager/ConnectivityMonitor$ConnectivityListener;)Lcom/bumptech/glide/manager/ConnectivityMonitor;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "listener"    # Lcom/bumptech/glide/manager/ConnectivityMonitor$ConnectivityListener;

    .line 13
    const-string v0, "android.permission.ACCESS_NETWORK_STATE"

    invoke-virtual {p1, v0}, Landroid/content/Context;->checkCallingOrSelfPermission(Ljava/lang/String;)I

    move-result v0

    .line 14
    .local v0, "res":I
    if-nez v0, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    .line 15
    .local v1, "hasPermission":Z
    :goto_0
    if-eqz v1, :cond_1

    .line 16
    new-instance v2, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;

    invoke-direct {v2, p1, p2}, Lcom/bumptech/glide/manager/DefaultConnectivityMonitor;-><init>(Landroid/content/Context;Lcom/bumptech/glide/manager/ConnectivityMonitor$ConnectivityListener;)V

    return-object v2

    .line 18
    :cond_1
    new-instance v2, Lcom/bumptech/glide/manager/NullConnectivityMonitor;

    invoke-direct {v2}, Lcom/bumptech/glide/manager/NullConnectivityMonitor;-><init>()V

    return-object v2
.end method
