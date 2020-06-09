.class public Lcom/bumptech/glide/load/model/stream/HttpUrlGlideUrlLoader;
.super Ljava/lang/Object;
.source "HttpUrlGlideUrlLoader.java"

# interfaces
.implements Lcom/bumptech/glide/load/model/ModelLoader;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/bumptech/glide/load/model/stream/HttpUrlGlideUrlLoader$Factory;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/bumptech/glide/load/model/ModelLoader<",
        "Lcom/bumptech/glide/load/model/GlideUrl;",
        "Ljava/io/InputStream;",
        ">;"
    }
.end annotation


# instance fields
.field private final modelCache:Lcom/bumptech/glide/load/model/ModelCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/load/model/ModelCache<",
            "Lcom/bumptech/glide/load/model/GlideUrl;",
            "Lcom/bumptech/glide/load/model/GlideUrl;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 41
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/bumptech/glide/load/model/stream/HttpUrlGlideUrlLoader;-><init>(Lcom/bumptech/glide/load/model/ModelCache;)V

    .line 42
    return-void
.end method

.method public constructor <init>(Lcom/bumptech/glide/load/model/ModelCache;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/model/ModelCache<",
            "Lcom/bumptech/glide/load/model/GlideUrl;",
            "Lcom/bumptech/glide/load/model/GlideUrl;",
            ">;)V"
        }
    .end annotation

    .line 44
    .local p1, "modelCache":Lcom/bumptech/glide/load/model/ModelCache;, "Lcom/bumptech/glide/load/model/ModelCache<Lcom/bumptech/glide/load/model/GlideUrl;Lcom/bumptech/glide/load/model/GlideUrl;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    iput-object p1, p0, Lcom/bumptech/glide/load/model/stream/HttpUrlGlideUrlLoader;->modelCache:Lcom/bumptech/glide/load/model/ModelCache;

    .line 46
    return-void
.end method


# virtual methods
.method public getResourceFetcher(Lcom/bumptech/glide/load/model/GlideUrl;II)Lcom/bumptech/glide/load/data/DataFetcher;
    .locals 3
    .param p1, "model"    # Lcom/bumptech/glide/load/model/GlideUrl;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/model/GlideUrl;",
            "II)",
            "Lcom/bumptech/glide/load/data/DataFetcher<",
            "Ljava/io/InputStream;",
            ">;"
        }
    .end annotation

    .line 51
    move-object v0, p1

    .line 52
    .local v0, "url":Lcom/bumptech/glide/load/model/GlideUrl;
    iget-object v1, p0, Lcom/bumptech/glide/load/model/stream/HttpUrlGlideUrlLoader;->modelCache:Lcom/bumptech/glide/load/model/ModelCache;

    if-eqz v1, :cond_1

    .line 53
    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2, v2}, Lcom/bumptech/glide/load/model/ModelCache;->get(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object v1

    move-object v0, v1

    check-cast v0, Lcom/bumptech/glide/load/model/GlideUrl;

    .line 54
    if-nez v0, :cond_0

    .line 55
    iget-object v1, p0, Lcom/bumptech/glide/load/model/stream/HttpUrlGlideUrlLoader;->modelCache:Lcom/bumptech/glide/load/model/ModelCache;

    invoke-virtual {v1, p1, v2, v2, p1}, Lcom/bumptech/glide/load/model/ModelCache;->put(Ljava/lang/Object;IILjava/lang/Object;)V

    .line 56
    move-object v0, p1

    goto :goto_0

    .line 54
    :cond_0
    goto :goto_0

    .line 52
    :cond_1
    nop

    .line 59
    :goto_0
    new-instance v1, Lcom/bumptech/glide/load/data/HttpUrlFetcher;

    invoke-direct {v1, v0}, Lcom/bumptech/glide/load/data/HttpUrlFetcher;-><init>(Lcom/bumptech/glide/load/model/GlideUrl;)V

    return-object v1
.end method

.method public bridge synthetic getResourceFetcher(Ljava/lang/Object;II)Lcom/bumptech/glide/load/data/DataFetcher;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # I
    .param p3, "x2"    # I

    .line 19
    move-object v0, p1

    check-cast v0, Lcom/bumptech/glide/load/model/GlideUrl;

    invoke-virtual {p0, v0, p2, p3}, Lcom/bumptech/glide/load/model/stream/HttpUrlGlideUrlLoader;->getResourceFetcher(Lcom/bumptech/glide/load/model/GlideUrl;II)Lcom/bumptech/glide/load/data/DataFetcher;

    move-result-object v0

    return-object v0
.end method
