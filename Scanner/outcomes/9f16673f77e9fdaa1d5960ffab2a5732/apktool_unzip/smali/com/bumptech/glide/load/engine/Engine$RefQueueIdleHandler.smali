.class Lcom/bumptech/glide/load/engine/Engine$RefQueueIdleHandler;
.super Ljava/lang/Object;
.source "Engine.java"

# interfaces
.implements Landroid/os/MessageQueue$IdleHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bumptech/glide/load/engine/Engine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "RefQueueIdleHandler"
.end annotation


# instance fields
.field private final activeResources:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Lcom/bumptech/glide/load/Key;",
            "Ljava/lang/ref/WeakReference<",
            "Lcom/bumptech/glide/load/engine/EngineResource<",
            "*>;>;>;"
        }
    .end annotation
.end field

.field private final queue:Ljava/lang/ref/ReferenceQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/ReferenceQueue<",
            "Lcom/bumptech/glide/load/engine/EngineResource<",
            "*>;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/Map;Ljava/lang/ref/ReferenceQueue;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map<",
            "Lcom/bumptech/glide/load/Key;",
            "Ljava/lang/ref/WeakReference<",
            "Lcom/bumptech/glide/load/engine/EngineResource<",
            "*>;>;>;",
            "Ljava/lang/ref/ReferenceQueue<",
            "Lcom/bumptech/glide/load/engine/EngineResource<",
            "*>;>;)V"
        }
    .end annotation

    .line 350
    .local p1, "activeResources":Ljava/util/Map;, "Ljava/util/Map<Lcom/bumptech/glide/load/Key;Ljava/lang/ref/WeakReference<Lcom/bumptech/glide/load/engine/EngineResource<*>;>;>;"
    .local p2, "queue":Ljava/lang/ref/ReferenceQueue;, "Ljava/lang/ref/ReferenceQueue<Lcom/bumptech/glide/load/engine/EngineResource<*>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 351
    iput-object p1, p0, Lcom/bumptech/glide/load/engine/Engine$RefQueueIdleHandler;->activeResources:Ljava/util/Map;

    .line 352
    iput-object p2, p0, Lcom/bumptech/glide/load/engine/Engine$RefQueueIdleHandler;->queue:Ljava/lang/ref/ReferenceQueue;

    .line 353
    return-void
.end method


# virtual methods
.method public queueIdle()Z
    .locals 3

    .line 357
    iget-object v0, p0, Lcom/bumptech/glide/load/engine/Engine$RefQueueIdleHandler;->queue:Ljava/lang/ref/ReferenceQueue;

    invoke-virtual {v0}, Ljava/lang/ref/ReferenceQueue;->poll()Ljava/lang/ref/Reference;

    move-result-object v0

    check-cast v0, Lcom/bumptech/glide/load/engine/Engine$ResourceWeakReference;

    .line 358
    .local v0, "ref":Lcom/bumptech/glide/load/engine/Engine$ResourceWeakReference;
    if-eqz v0, :cond_0

    .line 359
    iget-object v1, p0, Lcom/bumptech/glide/load/engine/Engine$RefQueueIdleHandler;->activeResources:Ljava/util/Map;

    invoke-static {v0}, Lcom/bumptech/glide/load/engine/Engine$ResourceWeakReference;->access$000(Lcom/bumptech/glide/load/engine/Engine$ResourceWeakReference;)Lcom/bumptech/glide/load/Key;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 358
    :cond_0
    nop

    .line 362
    :goto_0
    const/4 v1, 0x1

    return v1
.end method
