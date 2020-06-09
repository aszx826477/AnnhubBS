.class Lcom/bumptech/glide/load/engine/EngineRunnable;
.super Ljava/lang/Object;
.source "EngineRunnable.java"

# interfaces
.implements Ljava/lang/Runnable;
.implements Lcom/bumptech/glide/load/engine/executor/Prioritized;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/bumptech/glide/load/engine/EngineRunnable$EngineRunnableManager;,
        Lcom/bumptech/glide/load/engine/EngineRunnable$Stage;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "EngineRunnable"


# instance fields
.field private final decodeJob:Lcom/bumptech/glide/load/engine/DecodeJob;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/load/engine/DecodeJob<",
            "***>;"
        }
    .end annotation
.end field

.field private volatile isCancelled:Z

.field private final manager:Lcom/bumptech/glide/load/engine/EngineRunnable$EngineRunnableManager;

.field private final priority:Lcom/bumptech/glide/Priority;

.field private stage:Lcom/bumptech/glide/load/engine/EngineRunnable$Stage;


# direct methods
.method public constructor <init>(Lcom/bumptech/glide/load/engine/EngineRunnable$EngineRunnableManager;Lcom/bumptech/glide/load/engine/DecodeJob;Lcom/bumptech/glide/Priority;)V
    .locals 1
    .param p1, "manager"    # Lcom/bumptech/glide/load/engine/EngineRunnable$EngineRunnableManager;
    .param p3, "priority"    # Lcom/bumptech/glide/Priority;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/engine/EngineRunnable$EngineRunnableManager;",
            "Lcom/bumptech/glide/load/engine/DecodeJob<",
            "***>;",
            "Lcom/bumptech/glide/Priority;",
            ")V"
        }
    .end annotation

    .line 37
    .local p2, "decodeJob":Lcom/bumptech/glide/load/engine/DecodeJob;, "Lcom/bumptech/glide/load/engine/DecodeJob<***>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    iput-object p1, p0, Lcom/bumptech/glide/load/engine/EngineRunnable;->manager:Lcom/bumptech/glide/load/engine/EngineRunnable$EngineRunnableManager;

    .line 39
    iput-object p2, p0, Lcom/bumptech/glide/load/engine/EngineRunnable;->decodeJob:Lcom/bumptech/glide/load/engine/DecodeJob;

    .line 40
    sget-object v0, Lcom/bumptech/glide/load/engine/EngineRunnable$Stage;->CACHE:Lcom/bumptech/glide/load/engine/EngineRunnable$Stage;

    iput-object v0, p0, Lcom/bumptech/glide/load/engine/EngineRunnable;->stage:Lcom/bumptech/glide/load/engine/EngineRunnable$Stage;

    .line 41
    iput-object p3, p0, Lcom/bumptech/glide/load/engine/EngineRunnable;->priority:Lcom/bumptech/glide/Priority;

    .line 42
    return-void
.end method

.method private decode()Lcom/bumptech/glide/load/engine/Resource;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/load/engine/Resource<",
            "*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 98
    invoke-direct {p0}, Lcom/bumptech/glide/load/engine/EngineRunnable;->isDecodingFromCache()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 99
    invoke-direct {p0}, Lcom/bumptech/glide/load/engine/EngineRunnable;->decodeFromCache()Lcom/bumptech/glide/load/engine/Resource;

    move-result-object v0

    return-object v0

    .line 101
    :cond_0
    invoke-direct {p0}, Lcom/bumptech/glide/load/engine/EngineRunnable;->decodeFromSource()Lcom/bumptech/glide/load/engine/Resource;

    move-result-object v0

    return-object v0
.end method

.method private decodeFromCache()Lcom/bumptech/glide/load/engine/Resource;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/load/engine/Resource<",
            "*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 106
    const/4 v0, 0x0

    .line 108
    .local v0, "result":Lcom/bumptech/glide/load/engine/Resource;, "Lcom/bumptech/glide/load/engine/Resource<*>;"
    :try_start_0
    iget-object v1, p0, Lcom/bumptech/glide/load/engine/EngineRunnable;->decodeJob:Lcom/bumptech/glide/load/engine/DecodeJob;

    invoke-virtual {v1}, Lcom/bumptech/glide/load/engine/DecodeJob;->decodeResultFromCache()Lcom/bumptech/glide/load/engine/Resource;

    move-result-object v1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-object v0, v1

    .line 113
    goto :goto_0

    .line 109
    :catch_0
    move-exception v1

    .line 110
    .local v1, "e":Ljava/lang/Exception;
    const-string v2, "EngineRunnable"

    const/4 v3, 0x3

    invoke-static {v2, v3}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 111
    const-string v2, "EngineRunnable"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Exception decoding result from cache: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 110
    :cond_0
    nop

    .line 115
    .end local v1    # "e":Ljava/lang/Exception;
    :goto_0
    if-nez v0, :cond_1

    .line 116
    iget-object v1, p0, Lcom/bumptech/glide/load/engine/EngineRunnable;->decodeJob:Lcom/bumptech/glide/load/engine/DecodeJob;

    invoke-virtual {v1}, Lcom/bumptech/glide/load/engine/DecodeJob;->decodeSourceFromCache()Lcom/bumptech/glide/load/engine/Resource;

    move-result-object v0

    goto :goto_1

    .line 115
    :cond_1
    nop

    .line 118
    :goto_1
    return-object v0
.end method

.method private decodeFromSource()Lcom/bumptech/glide/load/engine/Resource;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/load/engine/Resource<",
            "*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 122
    iget-object v0, p0, Lcom/bumptech/glide/load/engine/EngineRunnable;->decodeJob:Lcom/bumptech/glide/load/engine/DecodeJob;

    invoke-virtual {v0}, Lcom/bumptech/glide/load/engine/DecodeJob;->decodeFromSource()Lcom/bumptech/glide/load/engine/Resource;

    move-result-object v0

    return-object v0
.end method

.method private isDecodingFromCache()Z
    .locals 2

    .line 81
    iget-object v0, p0, Lcom/bumptech/glide/load/engine/EngineRunnable;->stage:Lcom/bumptech/glide/load/engine/EngineRunnable$Stage;

    sget-object v1, Lcom/bumptech/glide/load/engine/EngineRunnable$Stage;->CACHE:Lcom/bumptech/glide/load/engine/EngineRunnable$Stage;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private onLoadComplete(Lcom/bumptech/glide/load/engine/Resource;)V
    .locals 1
    .param p1, "resource"    # Lcom/bumptech/glide/load/engine/Resource;

    .line 85
    iget-object v0, p0, Lcom/bumptech/glide/load/engine/EngineRunnable;->manager:Lcom/bumptech/glide/load/engine/EngineRunnable$EngineRunnableManager;

    invoke-interface {v0, p1}, Lcom/bumptech/glide/load/engine/EngineRunnable$EngineRunnableManager;->onResourceReady(Lcom/bumptech/glide/load/engine/Resource;)V

    .line 86
    return-void
.end method

.method private onLoadFailed(Ljava/lang/Exception;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;

    .line 89
    invoke-direct {p0}, Lcom/bumptech/glide/load/engine/EngineRunnable;->isDecodingFromCache()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 90
    sget-object v0, Lcom/bumptech/glide/load/engine/EngineRunnable$Stage;->SOURCE:Lcom/bumptech/glide/load/engine/EngineRunnable$Stage;

    iput-object v0, p0, Lcom/bumptech/glide/load/engine/EngineRunnable;->stage:Lcom/bumptech/glide/load/engine/EngineRunnable$Stage;

    .line 91
    iget-object v0, p0, Lcom/bumptech/glide/load/engine/EngineRunnable;->manager:Lcom/bumptech/glide/load/engine/EngineRunnable$EngineRunnableManager;

    invoke-interface {v0, p0}, Lcom/bumptech/glide/load/engine/EngineRunnable$EngineRunnableManager;->submitForSource(Lcom/bumptech/glide/load/engine/EngineRunnable;)V

    goto :goto_0

    .line 93
    :cond_0
    iget-object v0, p0, Lcom/bumptech/glide/load/engine/EngineRunnable;->manager:Lcom/bumptech/glide/load/engine/EngineRunnable$EngineRunnableManager;

    invoke-interface {v0, p1}, Lcom/bumptech/glide/load/engine/EngineRunnable$EngineRunnableManager;->onException(Ljava/lang/Exception;)V

    .line 95
    :goto_0
    return-void
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .line 45
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bumptech/glide/load/engine/EngineRunnable;->isCancelled:Z

    .line 46
    iget-object v0, p0, Lcom/bumptech/glide/load/engine/EngineRunnable;->decodeJob:Lcom/bumptech/glide/load/engine/DecodeJob;

    invoke-virtual {v0}, Lcom/bumptech/glide/load/engine/DecodeJob;->cancel()V

    .line 47
    return-void
.end method

.method public getPriority()I
    .locals 1

    .line 127
    iget-object v0, p0, Lcom/bumptech/glide/load/engine/EngineRunnable;->priority:Lcom/bumptech/glide/Priority;

    invoke-virtual {v0}, Lcom/bumptech/glide/Priority;->ordinal()I

    move-result v0

    return v0
.end method

.method public run()V
    .locals 5

    .line 51
    iget-boolean v0, p0, Lcom/bumptech/glide/load/engine/EngineRunnable;->isCancelled:Z

    if-eqz v0, :cond_0

    .line 52
    return-void

    .line 55
    :cond_0
    const/4 v0, 0x0

    .line 56
    .local v0, "exception":Ljava/lang/Exception;
    const/4 v1, 0x0

    .line 58
    .local v1, "resource":Lcom/bumptech/glide/load/engine/Resource;, "Lcom/bumptech/glide/load/engine/Resource<*>;"
    :try_start_0
    invoke-direct {p0}, Lcom/bumptech/glide/load/engine/EngineRunnable;->decode()Lcom/bumptech/glide/load/engine/Resource;

    move-result-object v2
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-object v1, v2

    .line 64
    goto :goto_1

    .line 59
    :catch_0
    move-exception v2

    .line 60
    .local v2, "e":Ljava/lang/Exception;
    const-string v3, "EngineRunnable"

    const/4 v4, 0x2

    invoke-static {v3, v4}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 61
    const-string v3, "EngineRunnable"

    const-string v4, "Exception decoding"

    invoke-static {v3, v4, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 60
    :cond_1
    nop

    .line 63
    :goto_0
    move-object v0, v2

    .line 66
    .end local v2    # "e":Ljava/lang/Exception;
    :goto_1
    iget-boolean v2, p0, Lcom/bumptech/glide/load/engine/EngineRunnable;->isCancelled:Z

    if-eqz v2, :cond_3

    .line 67
    if-eqz v1, :cond_2

    .line 68
    invoke-interface {v1}, Lcom/bumptech/glide/load/engine/Resource;->recycle()V

    goto :goto_2

    .line 67
    :cond_2
    nop

    .line 70
    :goto_2
    return-void

    .line 73
    :cond_3
    if-nez v1, :cond_4

    .line 74
    invoke-direct {p0, v0}, Lcom/bumptech/glide/load/engine/EngineRunnable;->onLoadFailed(Ljava/lang/Exception;)V

    goto :goto_3

    .line 76
    :cond_4
    invoke-direct {p0, v1}, Lcom/bumptech/glide/load/engine/EngineRunnable;->onLoadComplete(Lcom/bumptech/glide/load/engine/Resource;)V

    .line 78
    :goto_3
    return-void
.end method
