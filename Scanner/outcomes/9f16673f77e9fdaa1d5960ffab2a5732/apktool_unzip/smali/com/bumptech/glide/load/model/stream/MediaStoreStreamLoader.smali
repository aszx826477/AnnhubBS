.class public Lcom/bumptech/glide/load/model/stream/MediaStoreStreamLoader;
.super Ljava/lang/Object;
.source "MediaStoreStreamLoader.java"

# interfaces
.implements Lcom/bumptech/glide/load/model/ModelLoader;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/bumptech/glide/load/model/ModelLoader<",
        "Landroid/net/Uri;",
        "Ljava/io/InputStream;",
        ">;"
    }
.end annotation


# instance fields
.field private final context:Landroid/content/Context;

.field private final uriLoader:Lcom/bumptech/glide/load/model/ModelLoader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "Landroid/net/Uri;",
            "Ljava/io/InputStream;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/bumptech/glide/load/model/ModelLoader;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "Landroid/net/Uri;",
            "Ljava/io/InputStream;",
            ">;)V"
        }
    .end annotation

    .line 24
    .local p2, "uriLoader":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<Landroid/net/Uri;Ljava/io/InputStream;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/bumptech/glide/load/model/stream/MediaStoreStreamLoader;->context:Landroid/content/Context;

    .line 26
    iput-object p2, p0, Lcom/bumptech/glide/load/model/stream/MediaStoreStreamLoader;->uriLoader:Lcom/bumptech/glide/load/model/ModelLoader;

    .line 27
    return-void
.end method


# virtual methods
.method public getResourceFetcher(Landroid/net/Uri;II)Lcom/bumptech/glide/load/data/DataFetcher;
    .locals 7
    .param p1, "model"    # Landroid/net/Uri;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri;",
            "II)",
            "Lcom/bumptech/glide/load/data/DataFetcher<",
            "Ljava/io/InputStream;",
            ">;"
        }
    .end annotation

    .line 31
    new-instance v6, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher;

    iget-object v1, p0, Lcom/bumptech/glide/load/model/stream/MediaStoreStreamLoader;->context:Landroid/content/Context;

    iget-object v0, p0, Lcom/bumptech/glide/load/model/stream/MediaStoreStreamLoader;->uriLoader:Lcom/bumptech/glide/load/model/ModelLoader;

    invoke-interface {v0, p1, p2, p3}, Lcom/bumptech/glide/load/model/ModelLoader;->getResourceFetcher(Ljava/lang/Object;II)Lcom/bumptech/glide/load/data/DataFetcher;

    move-result-object v3

    move-object v0, v6

    move-object v2, p1

    move v4, p2

    move v5, p3

    invoke-direct/range {v0 .. v5}, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher;-><init>(Landroid/content/Context;Landroid/net/Uri;Lcom/bumptech/glide/load/data/DataFetcher;II)V

    return-object v6
.end method

.method public bridge synthetic getResourceFetcher(Ljava/lang/Object;II)Lcom/bumptech/glide/load/data/DataFetcher;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # I
    .param p3, "x2"    # I

    .line 20
    move-object v0, p1

    check-cast v0, Landroid/net/Uri;

    invoke-virtual {p0, v0, p2, p3}, Lcom/bumptech/glide/load/model/stream/MediaStoreStreamLoader;->getResourceFetcher(Landroid/net/Uri;II)Lcom/bumptech/glide/load/data/DataFetcher;

    move-result-object v0

    return-object v0
.end method
