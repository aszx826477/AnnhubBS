.class public Lcom/bumptech/glide/RequestManager;
.super Ljava/lang/Object;
.source "RequestManager.java"

# interfaces
.implements Lcom/bumptech/glide/manager/LifecycleListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/bumptech/glide/RequestManager$RequestManagerConnectivityListener;,
        Lcom/bumptech/glide/RequestManager$OptionsApplier;,
        Lcom/bumptech/glide/RequestManager$GenericModelRequest;,
        Lcom/bumptech/glide/RequestManager$ImageModelRequest;,
        Lcom/bumptech/glide/RequestManager$VideoModelRequest;,
        Lcom/bumptech/glide/RequestManager$DefaultOptions;
    }
.end annotation


# instance fields
.field private final context:Landroid/content/Context;

.field private final glide:Lcom/bumptech/glide/Glide;

.field private final lifecycle:Lcom/bumptech/glide/manager/Lifecycle;

.field private options:Lcom/bumptech/glide/RequestManager$DefaultOptions;

.field private final optionsApplier:Lcom/bumptech/glide/RequestManager$OptionsApplier;

.field private final requestTracker:Lcom/bumptech/glide/manager/RequestTracker;

.field private final treeNode:Lcom/bumptech/glide/manager/RequestManagerTreeNode;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/bumptech/glide/manager/Lifecycle;Lcom/bumptech/glide/manager/RequestManagerTreeNode;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "lifecycle"    # Lcom/bumptech/glide/manager/Lifecycle;
    .param p3, "treeNode"    # Lcom/bumptech/glide/manager/RequestManagerTreeNode;

    .line 53
    new-instance v4, Lcom/bumptech/glide/manager/RequestTracker;

    invoke-direct {v4}, Lcom/bumptech/glide/manager/RequestTracker;-><init>()V

    new-instance v5, Lcom/bumptech/glide/manager/ConnectivityMonitorFactory;

    invoke-direct {v5}, Lcom/bumptech/glide/manager/ConnectivityMonitorFactory;-><init>()V

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-direct/range {v0 .. v5}, Lcom/bumptech/glide/RequestManager;-><init>(Landroid/content/Context;Lcom/bumptech/glide/manager/Lifecycle;Lcom/bumptech/glide/manager/RequestManagerTreeNode;Lcom/bumptech/glide/manager/RequestTracker;Lcom/bumptech/glide/manager/ConnectivityMonitorFactory;)V

    .line 54
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Lcom/bumptech/glide/manager/Lifecycle;Lcom/bumptech/glide/manager/RequestManagerTreeNode;Lcom/bumptech/glide/manager/RequestTracker;Lcom/bumptech/glide/manager/ConnectivityMonitorFactory;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "lifecycle"    # Lcom/bumptech/glide/manager/Lifecycle;
    .param p3, "treeNode"    # Lcom/bumptech/glide/manager/RequestManagerTreeNode;
    .param p4, "requestTracker"    # Lcom/bumptech/glide/manager/RequestTracker;
    .param p5, "factory"    # Lcom/bumptech/glide/manager/ConnectivityMonitorFactory;

    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/bumptech/glide/RequestManager;->context:Landroid/content/Context;

    .line 59
    iput-object p2, p0, Lcom/bumptech/glide/RequestManager;->lifecycle:Lcom/bumptech/glide/manager/Lifecycle;

    .line 60
    iput-object p3, p0, Lcom/bumptech/glide/RequestManager;->treeNode:Lcom/bumptech/glide/manager/RequestManagerTreeNode;

    .line 61
    iput-object p4, p0, Lcom/bumptech/glide/RequestManager;->requestTracker:Lcom/bumptech/glide/manager/RequestTracker;

    .line 62
    invoke-static {p1}, Lcom/bumptech/glide/Glide;->get(Landroid/content/Context;)Lcom/bumptech/glide/Glide;

    move-result-object v0

    iput-object v0, p0, Lcom/bumptech/glide/RequestManager;->glide:Lcom/bumptech/glide/Glide;

    .line 63
    new-instance v0, Lcom/bumptech/glide/RequestManager$OptionsApplier;

    invoke-direct {v0, p0}, Lcom/bumptech/glide/RequestManager$OptionsApplier;-><init>(Lcom/bumptech/glide/RequestManager;)V

    iput-object v0, p0, Lcom/bumptech/glide/RequestManager;->optionsApplier:Lcom/bumptech/glide/RequestManager$OptionsApplier;

    .line 65
    new-instance v0, Lcom/bumptech/glide/RequestManager$RequestManagerConnectivityListener;

    invoke-direct {v0, p4}, Lcom/bumptech/glide/RequestManager$RequestManagerConnectivityListener;-><init>(Lcom/bumptech/glide/manager/RequestTracker;)V

    invoke-virtual {p5, p1, v0}, Lcom/bumptech/glide/manager/ConnectivityMonitorFactory;->build(Landroid/content/Context;Lcom/bumptech/glide/manager/ConnectivityMonitor$ConnectivityListener;)Lcom/bumptech/glide/manager/ConnectivityMonitor;

    move-result-object v0

    .line 71
    .local v0, "connectivityMonitor":Lcom/bumptech/glide/manager/ConnectivityMonitor;
    invoke-static {}, Lcom/bumptech/glide/util/Util;->isOnBackgroundThread()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 72
    new-instance v1, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v2, Lcom/bumptech/glide/RequestManager$1;

    invoke-direct {v2, p0, p2}, Lcom/bumptech/glide/RequestManager$1;-><init>(Lcom/bumptech/glide/RequestManager;Lcom/bumptech/glide/manager/Lifecycle;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    .line 79
    :cond_0
    invoke-interface {p2, p0}, Lcom/bumptech/glide/manager/Lifecycle;->addListener(Lcom/bumptech/glide/manager/LifecycleListener;)V

    .line 81
    :goto_0
    invoke-interface {p2, v0}, Lcom/bumptech/glide/manager/Lifecycle;->addListener(Lcom/bumptech/glide/manager/LifecycleListener;)V

    .line 82
    return-void
.end method

.method static synthetic access$000(Ljava/lang/Object;)Ljava/lang/Class;
    .locals 1
    .param p0, "x0"    # Ljava/lang/Object;

    .line 43
    invoke-static {p0}, Lcom/bumptech/glide/RequestManager;->getSafeClass(Ljava/lang/Object;)Ljava/lang/Class;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/bumptech/glide/RequestManager;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/bumptech/glide/RequestManager;

    .line 43
    iget-object v0, p0, Lcom/bumptech/glide/RequestManager;->context:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$200(Lcom/bumptech/glide/RequestManager;)Lcom/bumptech/glide/Glide;
    .locals 1
    .param p0, "x0"    # Lcom/bumptech/glide/RequestManager;

    .line 43
    iget-object v0, p0, Lcom/bumptech/glide/RequestManager;->glide:Lcom/bumptech/glide/Glide;

    return-object v0
.end method

.method static synthetic access$300(Lcom/bumptech/glide/RequestManager;)Lcom/bumptech/glide/manager/RequestTracker;
    .locals 1
    .param p0, "x0"    # Lcom/bumptech/glide/RequestManager;

    .line 43
    iget-object v0, p0, Lcom/bumptech/glide/RequestManager;->requestTracker:Lcom/bumptech/glide/manager/RequestTracker;

    return-object v0
.end method

.method static synthetic access$400(Lcom/bumptech/glide/RequestManager;)Lcom/bumptech/glide/manager/Lifecycle;
    .locals 1
    .param p0, "x0"    # Lcom/bumptech/glide/RequestManager;

    .line 43
    iget-object v0, p0, Lcom/bumptech/glide/RequestManager;->lifecycle:Lcom/bumptech/glide/manager/Lifecycle;

    return-object v0
.end method

.method static synthetic access$500(Lcom/bumptech/glide/RequestManager;)Lcom/bumptech/glide/RequestManager$OptionsApplier;
    .locals 1
    .param p0, "x0"    # Lcom/bumptech/glide/RequestManager;

    .line 43
    iget-object v0, p0, Lcom/bumptech/glide/RequestManager;->optionsApplier:Lcom/bumptech/glide/RequestManager$OptionsApplier;

    return-object v0
.end method

.method static synthetic access$800(Lcom/bumptech/glide/RequestManager;)Lcom/bumptech/glide/RequestManager$DefaultOptions;
    .locals 1
    .param p0, "x0"    # Lcom/bumptech/glide/RequestManager;

    .line 43
    iget-object v0, p0, Lcom/bumptech/glide/RequestManager;->options:Lcom/bumptech/glide/RequestManager$DefaultOptions;

    return-object v0
.end method

.method private static getSafeClass(Ljava/lang/Object;)Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;)",
            "Ljava/lang/Class<",
            "TT;>;"
        }
    .end annotation

    .line 641
    .local p0, "model":Ljava/lang/Object;, "TT;"
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method private loadGeneric(Ljava/lang/Class;)Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;)",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "TT;>;"
        }
    .end annotation

    .line 625
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    iget-object v0, p0, Lcom/bumptech/glide/RequestManager;->context:Landroid/content/Context;

    invoke-static {p1, v0}, Lcom/bumptech/glide/Glide;->buildStreamModelLoader(Ljava/lang/Class;Landroid/content/Context;)Lcom/bumptech/glide/load/model/ModelLoader;

    move-result-object v0

    .line 626
    .local v0, "streamModelLoader":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<TT;Ljava/io/InputStream;>;"
    iget-object v1, p0, Lcom/bumptech/glide/RequestManager;->context:Landroid/content/Context;

    invoke-static {p1, v1}, Lcom/bumptech/glide/Glide;->buildFileDescriptorModelLoader(Ljava/lang/Class;Landroid/content/Context;)Lcom/bumptech/glide/load/model/ModelLoader;

    move-result-object v10

    .line 628
    .local v10, "fileDescriptorModelLoader":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<TT;Landroid/os/ParcelFileDescriptor;>;"
    if-eqz p1, :cond_1

    if-nez v0, :cond_1

    if-eqz v10, :cond_0

    goto :goto_0

    .line 629
    :cond_0
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unknown type "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v3, ". You must provide a Model of a type for"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, " which there is a registered ModelLoader, if you are using a custom model, you must first call"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, " Glide#register with a ModelLoaderFactory for your custom model class"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 628
    :cond_1
    :goto_0
    nop

    .line 634
    iget-object v11, p0, Lcom/bumptech/glide/RequestManager;->optionsApplier:Lcom/bumptech/glide/RequestManager$OptionsApplier;

    new-instance v12, Lcom/bumptech/glide/DrawableTypeRequest;

    iget-object v5, p0, Lcom/bumptech/glide/RequestManager;->context:Landroid/content/Context;

    iget-object v6, p0, Lcom/bumptech/glide/RequestManager;->glide:Lcom/bumptech/glide/Glide;

    iget-object v7, p0, Lcom/bumptech/glide/RequestManager;->requestTracker:Lcom/bumptech/glide/manager/RequestTracker;

    iget-object v8, p0, Lcom/bumptech/glide/RequestManager;->lifecycle:Lcom/bumptech/glide/manager/Lifecycle;

    move-object v1, v12

    move-object v2, p1

    move-object v3, v0

    move-object v4, v10

    move-object v9, v11

    invoke-direct/range {v1 .. v9}, Lcom/bumptech/glide/DrawableTypeRequest;-><init>(Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoader;Lcom/bumptech/glide/load/model/ModelLoader;Landroid/content/Context;Lcom/bumptech/glide/Glide;Lcom/bumptech/glide/manager/RequestTracker;Lcom/bumptech/glide/manager/Lifecycle;Lcom/bumptech/glide/RequestManager$OptionsApplier;)V

    invoke-virtual {v11, v12}, Lcom/bumptech/glide/RequestManager$OptionsApplier;->apply(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/GenericRequestBuilder;

    move-result-object v1

    check-cast v1, Lcom/bumptech/glide/DrawableTypeRequest;

    return-object v1
.end method


# virtual methods
.method public from(Ljava/lang/Class;)Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;)",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "TT;>;"
        }
    .end annotation

    .line 621
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-direct {p0, p1}, Lcom/bumptech/glide/RequestManager;->loadGeneric(Ljava/lang/Class;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    return-object v0
.end method

.method public fromBytes()Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "[B>;"
        }
    .end annotation

    .line 576
    const-class v0, [B

    invoke-direct {p0, v0}, Lcom/bumptech/glide/RequestManager;->loadGeneric(Ljava/lang/Class;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    new-instance v1, Lcom/bumptech/glide/signature/StringSignature;

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/bumptech/glide/signature/StringSignature;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableTypeRequest;->signature(Lcom/bumptech/glide/load/Key;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    sget-object v1, Lcom/bumptech/glide/load/engine/DiskCacheStrategy;->NONE:Lcom/bumptech/glide/load/engine/DiskCacheStrategy;

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->diskCacheStrategy(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->skipMemoryCache(Z)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/bumptech/glide/DrawableTypeRequest;

    return-object v0
.end method

.method public fromFile()Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    .line 454
    const-class v0, Ljava/io/File;

    invoke-direct {p0, v0}, Lcom/bumptech/glide/RequestManager;->loadGeneric(Ljava/lang/Class;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    return-object v0
.end method

.method public fromMediaStore()Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "Landroid/net/Uri;",
            ">;"
        }
    .end annotation

    .line 413
    const-class v0, Landroid/net/Uri;

    iget-object v1, p0, Lcom/bumptech/glide/RequestManager;->context:Landroid/content/Context;

    invoke-static {v0, v1}, Lcom/bumptech/glide/Glide;->buildStreamModelLoader(Ljava/lang/Class;Landroid/content/Context;)Lcom/bumptech/glide/load/model/ModelLoader;

    move-result-object v0

    .line 414
    .local v0, "genericStreamLoader":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<Landroid/net/Uri;Ljava/io/InputStream;>;"
    new-instance v3, Lcom/bumptech/glide/load/model/stream/MediaStoreStreamLoader;

    iget-object v1, p0, Lcom/bumptech/glide/RequestManager;->context:Landroid/content/Context;

    invoke-direct {v3, v1, v0}, Lcom/bumptech/glide/load/model/stream/MediaStoreStreamLoader;-><init>(Landroid/content/Context;Lcom/bumptech/glide/load/model/ModelLoader;)V

    .line 415
    .local v3, "mediaStoreLoader":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<Landroid/net/Uri;Ljava/io/InputStream;>;"
    const-class v1, Landroid/net/Uri;

    iget-object v2, p0, Lcom/bumptech/glide/RequestManager;->context:Landroid/content/Context;

    invoke-static {v1, v2}, Lcom/bumptech/glide/Glide;->buildFileDescriptorModelLoader(Ljava/lang/Class;Landroid/content/Context;)Lcom/bumptech/glide/load/model/ModelLoader;

    move-result-object v10

    .line 418
    .local v10, "fileDescriptorModelLoader":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<Landroid/net/Uri;Landroid/os/ParcelFileDescriptor;>;"
    iget-object v11, p0, Lcom/bumptech/glide/RequestManager;->optionsApplier:Lcom/bumptech/glide/RequestManager$OptionsApplier;

    new-instance v12, Lcom/bumptech/glide/DrawableTypeRequest;

    const-class v2, Landroid/net/Uri;

    iget-object v5, p0, Lcom/bumptech/glide/RequestManager;->context:Landroid/content/Context;

    iget-object v6, p0, Lcom/bumptech/glide/RequestManager;->glide:Lcom/bumptech/glide/Glide;

    iget-object v7, p0, Lcom/bumptech/glide/RequestManager;->requestTracker:Lcom/bumptech/glide/manager/RequestTracker;

    iget-object v8, p0, Lcom/bumptech/glide/RequestManager;->lifecycle:Lcom/bumptech/glide/manager/Lifecycle;

    move-object v1, v12

    move-object v4, v10

    move-object v9, v11

    invoke-direct/range {v1 .. v9}, Lcom/bumptech/glide/DrawableTypeRequest;-><init>(Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoader;Lcom/bumptech/glide/load/model/ModelLoader;Landroid/content/Context;Lcom/bumptech/glide/Glide;Lcom/bumptech/glide/manager/RequestTracker;Lcom/bumptech/glide/manager/Lifecycle;Lcom/bumptech/glide/RequestManager$OptionsApplier;)V

    invoke-virtual {v11, v12}, Lcom/bumptech/glide/RequestManager$OptionsApplier;->apply(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/GenericRequestBuilder;

    move-result-object v1

    check-cast v1, Lcom/bumptech/glide/DrawableTypeRequest;

    return-object v1
.end method

.method public fromResource()Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .line 492
    const-class v0, Ljava/lang/Integer;

    invoke-direct {p0, v0}, Lcom/bumptech/glide/RequestManager;->loadGeneric(Ljava/lang/Class;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    iget-object v1, p0, Lcom/bumptech/glide/RequestManager;->context:Landroid/content/Context;

    invoke-static {v1}, Lcom/bumptech/glide/signature/ApplicationVersionSignature;->obtain(Landroid/content/Context;)Lcom/bumptech/glide/load/Key;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableTypeRequest;->signature(Lcom/bumptech/glide/load/Key;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/bumptech/glide/DrawableTypeRequest;

    return-object v0
.end method

.method public fromString()Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 304
    const-class v0, Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/bumptech/glide/RequestManager;->loadGeneric(Ljava/lang/Class;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    return-object v0
.end method

.method public fromUri()Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "Landroid/net/Uri;",
            ">;"
        }
    .end annotation

    .line 339
    const-class v0, Landroid/net/Uri;

    invoke-direct {p0, v0}, Lcom/bumptech/glide/RequestManager;->loadGeneric(Ljava/lang/Class;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    return-object v0
.end method

.method public fromUrl()Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "Ljava/net/URL;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 527
    const-class v0, Ljava/net/URL;

    invoke-direct {p0, v0}, Lcom/bumptech/glide/RequestManager;->loadGeneric(Ljava/lang/Class;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    return-object v0
.end method

.method public isPaused()Z
    .locals 1

    .line 136
    invoke-static {}, Lcom/bumptech/glide/util/Util;->assertMainThread()V

    .line 137
    iget-object v0, p0, Lcom/bumptech/glide/RequestManager;->requestTracker:Lcom/bumptech/glide/manager/RequestTracker;

    invoke-virtual {v0}, Lcom/bumptech/glide/manager/RequestTracker;->isPaused()Z

    move-result v0

    return v0
.end method

.method public load(Landroid/net/Uri;)Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri;",
            ")",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "Landroid/net/Uri;",
            ">;"
        }
    .end annotation

    .line 317
    invoke-virtual {p0}, Lcom/bumptech/glide/RequestManager;->fromUri()Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/bumptech/glide/DrawableTypeRequest;->load(Ljava/lang/Object;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/bumptech/glide/DrawableTypeRequest;

    return-object v0
.end method

.method public load(Ljava/io/File;)Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 1
    .param p1, "file"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            ")",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    .line 431
    invoke-virtual {p0}, Lcom/bumptech/glide/RequestManager;->fromFile()Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/bumptech/glide/DrawableTypeRequest;->load(Ljava/lang/Object;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/bumptech/glide/DrawableTypeRequest;

    return-object v0
.end method

.method public load(Ljava/lang/Integer;)Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 1
    .param p1, "resourceId"    # Ljava/lang/Integer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Integer;",
            ")",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .line 466
    invoke-virtual {p0}, Lcom/bumptech/glide/RequestManager;->fromResource()Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/bumptech/glide/DrawableTypeRequest;->load(Ljava/lang/Object;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/bumptech/glide/DrawableTypeRequest;

    return-object v0
.end method

.method public load(Ljava/lang/Object;)Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;)",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "TT;>;"
        }
    .end annotation

    .line 598
    .local p1, "model":Ljava/lang/Object;, "TT;"
    invoke-static {p1}, Lcom/bumptech/glide/RequestManager;->getSafeClass(Ljava/lang/Object;)Ljava/lang/Class;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/bumptech/glide/RequestManager;->loadGeneric(Ljava/lang/Class;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/bumptech/glide/DrawableTypeRequest;->load(Ljava/lang/Object;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/bumptech/glide/DrawableTypeRequest;

    return-object v0
.end method

.method public load(Ljava/lang/String;)Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 1
    .param p1, "string"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 284
    invoke-virtual {p0}, Lcom/bumptech/glide/RequestManager;->fromString()Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/bumptech/glide/DrawableTypeRequest;->load(Ljava/lang/Object;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/bumptech/glide/DrawableTypeRequest;

    return-object v0
.end method

.method public load(Ljava/net/URL;)Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 1
    .param p1, "url"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/net/URL;",
            ")",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "Ljava/net/URL;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 509
    invoke-virtual {p0}, Lcom/bumptech/glide/RequestManager;->fromUrl()Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/bumptech/glide/DrawableTypeRequest;->load(Ljava/lang/Object;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/bumptech/glide/DrawableTypeRequest;

    return-object v0
.end method

.method public load([B)Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 1
    .param p1, "model"    # [B
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([B)",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "[B>;"
        }
    .end annotation

    .line 561
    invoke-virtual {p0}, Lcom/bumptech/glide/RequestManager;->fromBytes()Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/bumptech/glide/DrawableTypeRequest;->load(Ljava/lang/Object;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/bumptech/glide/DrawableTypeRequest;

    return-object v0
.end method

.method public load([BLjava/lang/String;)Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 2
    .param p1, "model"    # [B
    .param p2, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([B",
            "Ljava/lang/String;",
            ")",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "[B>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 549
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/RequestManager;->load([B)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    new-instance v1, Lcom/bumptech/glide/signature/StringSignature;

    invoke-direct {v1, p2}, Lcom/bumptech/glide/signature/StringSignature;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableTypeRequest;->signature(Lcom/bumptech/glide/load/Key;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/bumptech/glide/DrawableTypeRequest;

    return-object v0
.end method

.method public loadFromMediaStore(Landroid/net/Uri;)Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri;",
            ")",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "Landroid/net/Uri;",
            ">;"
        }
    .end annotation

    .line 381
    invoke-virtual {p0}, Lcom/bumptech/glide/RequestManager;->fromMediaStore()Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/bumptech/glide/DrawableTypeRequest;->load(Ljava/lang/Object;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/bumptech/glide/DrawableTypeRequest;

    return-object v0
.end method

.method public loadFromMediaStore(Landroid/net/Uri;Ljava/lang/String;JI)Lcom/bumptech/glide/DrawableTypeRequest;
    .locals 2
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "mimeType"    # Ljava/lang/String;
    .param p3, "dateModified"    # J
    .param p5, "orientation"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri;",
            "Ljava/lang/String;",
            "JI)",
            "Lcom/bumptech/glide/DrawableTypeRequest<",
            "Landroid/net/Uri;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 368
    new-instance v0, Lcom/bumptech/glide/signature/MediaStoreSignature;

    invoke-direct {v0, p2, p3, p4, p5}, Lcom/bumptech/glide/signature/MediaStoreSignature;-><init>(Ljava/lang/String;JI)V

    .line 369
    .local v0, "signature":Lcom/bumptech/glide/load/Key;
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/RequestManager;->loadFromMediaStore(Landroid/net/Uri;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/bumptech/glide/DrawableTypeRequest;->signature(Lcom/bumptech/glide/load/Key;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v1

    check-cast v1, Lcom/bumptech/glide/DrawableTypeRequest;

    return-object v1
.end method

.method public onDestroy()V
    .locals 1

    .line 221
    iget-object v0, p0, Lcom/bumptech/glide/RequestManager;->requestTracker:Lcom/bumptech/glide/manager/RequestTracker;

    invoke-virtual {v0}, Lcom/bumptech/glide/manager/RequestTracker;->clearRequests()V

    .line 222
    return-void
.end method

.method public onLowMemory()V
    .locals 1

    .line 95
    iget-object v0, p0, Lcom/bumptech/glide/RequestManager;->glide:Lcom/bumptech/glide/Glide;

    invoke-virtual {v0}, Lcom/bumptech/glide/Glide;->clearMemory()V

    .line 96
    return-void
.end method

.method public onStart()V
    .locals 0

    .line 203
    invoke-virtual {p0}, Lcom/bumptech/glide/RequestManager;->resumeRequests()V

    .line 204
    return-void
.end method

.method public onStop()V
    .locals 0

    .line 212
    invoke-virtual {p0}, Lcom/bumptech/glide/RequestManager;->pauseRequests()V

    .line 213
    return-void
.end method

.method public onTrimMemory(I)V
    .locals 1
    .param p1, "level"    # I

    .line 88
    iget-object v0, p0, Lcom/bumptech/glide/RequestManager;->glide:Lcom/bumptech/glide/Glide;

    invoke-virtual {v0, p1}, Lcom/bumptech/glide/Glide;->trimMemory(I)V

    .line 89
    return-void
.end method

.method public pauseRequests()V
    .locals 1

    .line 147
    invoke-static {}, Lcom/bumptech/glide/util/Util;->assertMainThread()V

    .line 148
    iget-object v0, p0, Lcom/bumptech/glide/RequestManager;->requestTracker:Lcom/bumptech/glide/manager/RequestTracker;

    invoke-virtual {v0}, Lcom/bumptech/glide/manager/RequestTracker;->pauseRequests()V

    .line 149
    return-void
.end method

.method public pauseRequestsRecursive()V
    .locals 2

    .line 165
    invoke-static {}, Lcom/bumptech/glide/util/Util;->assertMainThread()V

    .line 166
    invoke-virtual {p0}, Lcom/bumptech/glide/RequestManager;->pauseRequests()V

    .line 167
    iget-object v0, p0, Lcom/bumptech/glide/RequestManager;->treeNode:Lcom/bumptech/glide/manager/RequestManagerTreeNode;

    invoke-interface {v0}, Lcom/bumptech/glide/manager/RequestManagerTreeNode;->getDescendants()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bumptech/glide/RequestManager;

    .line 168
    .local v1, "requestManager":Lcom/bumptech/glide/RequestManager;
    invoke-virtual {v1}, Lcom/bumptech/glide/RequestManager;->pauseRequests()V

    goto :goto_0

    .line 167
    .end local v1    # "requestManager":Lcom/bumptech/glide/RequestManager;
    :cond_0
    nop

    .line 170
    .end local v0    # "i$":Ljava/util/Iterator;
    return-void
.end method

.method public resumeRequests()V
    .locals 1

    .line 179
    invoke-static {}, Lcom/bumptech/glide/util/Util;->assertMainThread()V

    .line 180
    iget-object v0, p0, Lcom/bumptech/glide/RequestManager;->requestTracker:Lcom/bumptech/glide/manager/RequestTracker;

    invoke-virtual {v0}, Lcom/bumptech/glide/manager/RequestTracker;->resumeRequests()V

    .line 181
    return-void
.end method

.method public resumeRequestsRecursive()V
    .locals 2

    .line 189
    invoke-static {}, Lcom/bumptech/glide/util/Util;->assertMainThread()V

    .line 190
    invoke-virtual {p0}, Lcom/bumptech/glide/RequestManager;->resumeRequests()V

    .line 191
    iget-object v0, p0, Lcom/bumptech/glide/RequestManager;->treeNode:Lcom/bumptech/glide/manager/RequestManagerTreeNode;

    invoke-interface {v0}, Lcom/bumptech/glide/manager/RequestManagerTreeNode;->getDescendants()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bumptech/glide/RequestManager;

    .line 192
    .local v1, "requestManager":Lcom/bumptech/glide/RequestManager;
    invoke-virtual {v1}, Lcom/bumptech/glide/RequestManager;->resumeRequests()V

    goto :goto_0

    .line 191
    .end local v1    # "requestManager":Lcom/bumptech/glide/RequestManager;
    :cond_0
    nop

    .line 194
    .end local v0    # "i$":Ljava/util/Iterator;
    return-void
.end method

.method public setDefaultOptions(Lcom/bumptech/glide/RequestManager$DefaultOptions;)V
    .locals 0
    .param p1, "options"    # Lcom/bumptech/glide/RequestManager$DefaultOptions;

    .line 126
    iput-object p1, p0, Lcom/bumptech/glide/RequestManager;->options:Lcom/bumptech/glide/RequestManager$DefaultOptions;

    .line 127
    return-void
.end method

.method public using(Lcom/bumptech/glide/load/model/ModelLoader;Ljava/lang/Class;)Lcom/bumptech/glide/RequestManager$GenericModelRequest;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<A:",
            "Ljava/lang/Object;",
            "T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "TA;TT;>;",
            "Ljava/lang/Class<",
            "TT;>;)",
            "Lcom/bumptech/glide/RequestManager$GenericModelRequest<",
            "TA;TT;>;"
        }
    .end annotation

    .line 238
    .local p1, "modelLoader":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<TA;TT;>;"
    .local p2, "dataClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    new-instance v0, Lcom/bumptech/glide/RequestManager$GenericModelRequest;

    invoke-direct {v0, p0, p1, p2}, Lcom/bumptech/glide/RequestManager$GenericModelRequest;-><init>(Lcom/bumptech/glide/RequestManager;Lcom/bumptech/glide/load/model/ModelLoader;Ljava/lang/Class;)V

    return-object v0
.end method

.method public using(Lcom/bumptech/glide/load/model/stream/StreamByteArrayLoader;)Lcom/bumptech/glide/RequestManager$ImageModelRequest;
    .locals 1
    .param p1, "modelLoader"    # Lcom/bumptech/glide/load/model/stream/StreamByteArrayLoader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/model/stream/StreamByteArrayLoader;",
            ")",
            "Lcom/bumptech/glide/RequestManager$ImageModelRequest<",
            "[B>;"
        }
    .end annotation

    .line 260
    new-instance v0, Lcom/bumptech/glide/RequestManager$ImageModelRequest;

    invoke-direct {v0, p0, p1}, Lcom/bumptech/glide/RequestManager$ImageModelRequest;-><init>(Lcom/bumptech/glide/RequestManager;Lcom/bumptech/glide/load/model/ModelLoader;)V

    return-object v0
.end method

.method public using(Lcom/bumptech/glide/load/model/stream/StreamModelLoader;)Lcom/bumptech/glide/RequestManager$ImageModelRequest;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/bumptech/glide/load/model/stream/StreamModelLoader<",
            "TT;>;)",
            "Lcom/bumptech/glide/RequestManager$ImageModelRequest<",
            "TT;>;"
        }
    .end annotation

    .line 249
    .local p1, "modelLoader":Lcom/bumptech/glide/load/model/stream/StreamModelLoader;, "Lcom/bumptech/glide/load/model/stream/StreamModelLoader<TT;>;"
    new-instance v0, Lcom/bumptech/glide/RequestManager$ImageModelRequest;

    invoke-direct {v0, p0, p1}, Lcom/bumptech/glide/RequestManager$ImageModelRequest;-><init>(Lcom/bumptech/glide/RequestManager;Lcom/bumptech/glide/load/model/ModelLoader;)V

    return-object v0
.end method

.method public using(Lcom/bumptech/glide/load/model/file_descriptor/FileDescriptorModelLoader;)Lcom/bumptech/glide/RequestManager$VideoModelRequest;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/bumptech/glide/load/model/file_descriptor/FileDescriptorModelLoader<",
            "TT;>;)",
            "Lcom/bumptech/glide/RequestManager$VideoModelRequest<",
            "TT;>;"
        }
    .end annotation

    .line 271
    .local p1, "modelLoader":Lcom/bumptech/glide/load/model/file_descriptor/FileDescriptorModelLoader;, "Lcom/bumptech/glide/load/model/file_descriptor/FileDescriptorModelLoader<TT;>;"
    new-instance v0, Lcom/bumptech/glide/RequestManager$VideoModelRequest;

    invoke-direct {v0, p0, p1}, Lcom/bumptech/glide/RequestManager$VideoModelRequest;-><init>(Lcom/bumptech/glide/RequestManager;Lcom/bumptech/glide/load/model/ModelLoader;)V

    return-object v0
.end method
