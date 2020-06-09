.class Lcom/bumptech/glide/load/resource/gif/GifFrameModelLoader;
.super Ljava/lang/Object;
.source "GifFrameModelLoader.java"

# interfaces
.implements Lcom/bumptech/glide/load/model/ModelLoader;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/bumptech/glide/load/resource/gif/GifFrameModelLoader$GifFrameDataFetcher;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/bumptech/glide/load/model/ModelLoader<",
        "Lcom/bumptech/glide/gifdecoder/GifDecoder;",
        "Lcom/bumptech/glide/gifdecoder/GifDecoder;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    return-void
.end method


# virtual methods
.method public getResourceFetcher(Lcom/bumptech/glide/gifdecoder/GifDecoder;II)Lcom/bumptech/glide/load/data/DataFetcher;
    .locals 1
    .param p1, "model"    # Lcom/bumptech/glide/gifdecoder/GifDecoder;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/gifdecoder/GifDecoder;",
            "II)",
            "Lcom/bumptech/glide/load/data/DataFetcher<",
            "Lcom/bumptech/glide/gifdecoder/GifDecoder;",
            ">;"
        }
    .end annotation

    .line 12
    new-instance v0, Lcom/bumptech/glide/load/resource/gif/GifFrameModelLoader$GifFrameDataFetcher;

    invoke-direct {v0, p1}, Lcom/bumptech/glide/load/resource/gif/GifFrameModelLoader$GifFrameDataFetcher;-><init>(Lcom/bumptech/glide/gifdecoder/GifDecoder;)V

    return-object v0
.end method

.method public bridge synthetic getResourceFetcher(Ljava/lang/Object;II)Lcom/bumptech/glide/load/data/DataFetcher;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # I
    .param p3, "x2"    # I

    .line 8
    move-object v0, p1

    check-cast v0, Lcom/bumptech/glide/gifdecoder/GifDecoder;

    invoke-virtual {p0, v0, p2, p3}, Lcom/bumptech/glide/load/resource/gif/GifFrameModelLoader;->getResourceFetcher(Lcom/bumptech/glide/gifdecoder/GifDecoder;II)Lcom/bumptech/glide/load/data/DataFetcher;

    move-result-object v0

    return-object v0
.end method
