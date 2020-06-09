.class Lcom/bumptech/glide/load/resource/gif/GifResourceDecoder$GifDecoderPool;
.super Ljava/lang/Object;
.source "GifResourceDecoder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bumptech/glide/load/resource/gif/GifResourceDecoder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "GifDecoderPool"
.end annotation


# instance fields
.field private final pool:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue<",
            "Lcom/bumptech/glide/gifdecoder/GifDecoder;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .locals 1

    .line 117
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 118
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/bumptech/glide/util/Util;->createQueue(I)Ljava/util/Queue;

    move-result-object v0

    iput-object v0, p0, Lcom/bumptech/glide/load/resource/gif/GifResourceDecoder$GifDecoderPool;->pool:Ljava/util/Queue;

    return-void
.end method


# virtual methods
.method public declared-synchronized obtain(Lcom/bumptech/glide/gifdecoder/GifDecoder$BitmapProvider;)Lcom/bumptech/glide/gifdecoder/GifDecoder;
    .locals 2
    .param p1, "bitmapProvider"    # Lcom/bumptech/glide/gifdecoder/GifDecoder$BitmapProvider;

    monitor-enter p0

    .line 121
    :try_start_0
    iget-object v0, p0, Lcom/bumptech/glide/load/resource/gif/GifResourceDecoder$GifDecoderPool;->pool:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bumptech/glide/gifdecoder/GifDecoder;

    .line 122
    .local v0, "result":Lcom/bumptech/glide/gifdecoder/GifDecoder;
    if-nez v0, :cond_0

    .line 123
    new-instance v1, Lcom/bumptech/glide/gifdecoder/GifDecoder;

    invoke-direct {v1, p1}, Lcom/bumptech/glide/gifdecoder/GifDecoder;-><init>(Lcom/bumptech/glide/gifdecoder/GifDecoder$BitmapProvider;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-object v0, v1

    goto :goto_0

    .line 122
    .end local p0    # "this":Lcom/bumptech/glide/load/resource/gif/GifResourceDecoder$GifDecoderPool;
    :cond_0
    nop

    .line 125
    :goto_0
    monitor-exit p0

    return-object v0

    .line 120
    .end local v0    # "result":Lcom/bumptech/glide/gifdecoder/GifDecoder;
    .end local p1    # "bitmapProvider":Lcom/bumptech/glide/gifdecoder/GifDecoder$BitmapProvider;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized release(Lcom/bumptech/glide/gifdecoder/GifDecoder;)V
    .locals 1
    .param p1, "decoder"    # Lcom/bumptech/glide/gifdecoder/GifDecoder;

    monitor-enter p0

    .line 129
    :try_start_0
    invoke-virtual {p1}, Lcom/bumptech/glide/gifdecoder/GifDecoder;->clear()V

    .line 130
    iget-object v0, p0, Lcom/bumptech/glide/load/resource/gif/GifResourceDecoder$GifDecoderPool;->pool:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 131
    monitor-exit p0

    return-void

    .line 128
    .end local p0    # "this":Lcom/bumptech/glide/load/resource/gif/GifResourceDecoder$GifDecoderPool;
    .end local p1    # "decoder":Lcom/bumptech/glide/gifdecoder/GifDecoder;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method
