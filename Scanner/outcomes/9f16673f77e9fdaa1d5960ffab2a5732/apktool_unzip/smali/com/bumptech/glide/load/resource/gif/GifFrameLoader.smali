.class Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;
.super Ljava/lang/Object;
.source "GifFrameLoader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$FrameSignature;,
        Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget;,
        Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$FrameLoaderCallback;,
        Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$FrameCallback;
    }
.end annotation


# instance fields
.field private final callback:Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$FrameCallback;

.field private current:Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget;

.field private final gifDecoder:Lcom/bumptech/glide/gifdecoder/GifDecoder;

.field private final handler:Landroid/os/Handler;

.field private isCleared:Z

.field private isLoadPending:Z

.field private isRunning:Z

.field private requestBuilder:Lcom/bumptech/glide/GenericRequestBuilder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/GenericRequestBuilder<",
            "Lcom/bumptech/glide/gifdecoder/GifDecoder;",
            "Lcom/bumptech/glide/gifdecoder/GifDecoder;",
            "Landroid/graphics/Bitmap;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$FrameCallback;Lcom/bumptech/glide/gifdecoder/GifDecoder;II)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "callback"    # Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$FrameCallback;
    .param p3, "gifDecoder"    # Lcom/bumptech/glide/gifdecoder/GifDecoder;
    .param p4, "width"    # I
    .param p5, "height"    # I

    .line 43
    invoke-static {p1}, Lcom/bumptech/glide/Glide;->get(Landroid/content/Context;)Lcom/bumptech/glide/Glide;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bumptech/glide/Glide;->getBitmapPool()Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    move-result-object v0

    invoke-static {p1, p3, p4, p5, v0}, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->getRequestBuilder(Landroid/content/Context;Lcom/bumptech/glide/gifdecoder/GifDecoder;IILcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;)Lcom/bumptech/glide/GenericRequestBuilder;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, p2, p3, v1, v0}, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;-><init>(Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$FrameCallback;Lcom/bumptech/glide/gifdecoder/GifDecoder;Landroid/os/Handler;Lcom/bumptech/glide/GenericRequestBuilder;)V

    .line 45
    return-void
.end method

.method constructor <init>(Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$FrameCallback;Lcom/bumptech/glide/gifdecoder/GifDecoder;Landroid/os/Handler;Lcom/bumptech/glide/GenericRequestBuilder;)V
    .locals 4
    .param p1, "callback"    # Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$FrameCallback;
    .param p2, "gifDecoder"    # Lcom/bumptech/glide/gifdecoder/GifDecoder;
    .param p3, "handler"    # Landroid/os/Handler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$FrameCallback;",
            "Lcom/bumptech/glide/gifdecoder/GifDecoder;",
            "Landroid/os/Handler;",
            "Lcom/bumptech/glide/GenericRequestBuilder<",
            "Lcom/bumptech/glide/gifdecoder/GifDecoder;",
            "Lcom/bumptech/glide/gifdecoder/GifDecoder;",
            "Landroid/graphics/Bitmap;",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .line 48
    .local p4, "requestBuilder":Lcom/bumptech/glide/GenericRequestBuilder;, "Lcom/bumptech/glide/GenericRequestBuilder<Lcom/bumptech/glide/gifdecoder/GifDecoder;Lcom/bumptech/glide/gifdecoder/GifDecoder;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->isRunning:Z

    .line 33
    iput-boolean v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->isLoadPending:Z

    .line 49
    if-nez p3, :cond_0

    .line 50
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    new-instance v2, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$FrameLoaderCallback;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v3}, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$FrameLoaderCallback;-><init>(Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$1;)V

    invoke-direct {v0, v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;Landroid/os/Handler$Callback;)V

    move-object p3, v0

    goto :goto_0

    .line 49
    :cond_0
    nop

    .line 52
    :goto_0
    iput-object p1, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->callback:Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$FrameCallback;

    .line 53
    iput-object p2, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->gifDecoder:Lcom/bumptech/glide/gifdecoder/GifDecoder;

    .line 54
    iput-object p3, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->handler:Landroid/os/Handler;

    .line 55
    iput-object p4, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->requestBuilder:Lcom/bumptech/glide/GenericRequestBuilder;

    .line 56
    return-void
.end method

.method private static getRequestBuilder(Landroid/content/Context;Lcom/bumptech/glide/gifdecoder/GifDecoder;IILcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "gifDecoder"    # Lcom/bumptech/glide/gifdecoder/GifDecoder;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .param p4, "bitmapPool"    # Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/bumptech/glide/gifdecoder/GifDecoder;",
            "II",
            "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;",
            ")",
            "Lcom/bumptech/glide/GenericRequestBuilder<",
            "Lcom/bumptech/glide/gifdecoder/GifDecoder;",
            "Lcom/bumptech/glide/gifdecoder/GifDecoder;",
            "Landroid/graphics/Bitmap;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .line 172
    new-instance v0, Lcom/bumptech/glide/load/resource/gif/GifFrameResourceDecoder;

    invoke-direct {v0, p4}, Lcom/bumptech/glide/load/resource/gif/GifFrameResourceDecoder;-><init>(Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;)V

    .line 173
    .local v0, "frameResourceDecoder":Lcom/bumptech/glide/load/resource/gif/GifFrameResourceDecoder;
    new-instance v1, Lcom/bumptech/glide/load/resource/gif/GifFrameModelLoader;

    invoke-direct {v1}, Lcom/bumptech/glide/load/resource/gif/GifFrameModelLoader;-><init>()V

    .line 174
    .local v1, "frameLoader":Lcom/bumptech/glide/load/resource/gif/GifFrameModelLoader;
    invoke-static {}, Lcom/bumptech/glide/load/resource/NullEncoder;->get()Lcom/bumptech/glide/load/Encoder;

    move-result-object v2

    .line 175
    .local v2, "sourceEncoder":Lcom/bumptech/glide/load/Encoder;, "Lcom/bumptech/glide/load/Encoder<Lcom/bumptech/glide/gifdecoder/GifDecoder;>;"
    invoke-static {p0}, Lcom/bumptech/glide/Glide;->with(Landroid/content/Context;)Lcom/bumptech/glide/RequestManager;

    move-result-object v3

    const-class v4, Lcom/bumptech/glide/gifdecoder/GifDecoder;

    invoke-virtual {v3, v1, v4}, Lcom/bumptech/glide/RequestManager;->using(Lcom/bumptech/glide/load/model/ModelLoader;Ljava/lang/Class;)Lcom/bumptech/glide/RequestManager$GenericModelRequest;

    move-result-object v3

    invoke-virtual {v3, p1}, Lcom/bumptech/glide/RequestManager$GenericModelRequest;->load(Ljava/lang/Object;)Lcom/bumptech/glide/RequestManager$GenericModelRequest$GenericTypeRequest;

    move-result-object v3

    const-class v4, Landroid/graphics/Bitmap;

    invoke-virtual {v3, v4}, Lcom/bumptech/glide/RequestManager$GenericModelRequest$GenericTypeRequest;->as(Ljava/lang/Class;)Lcom/bumptech/glide/GenericTranscodeRequest;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/bumptech/glide/GenericTranscodeRequest;->sourceEncoder(Lcom/bumptech/glide/load/Encoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/bumptech/glide/GenericRequestBuilder;->decoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    move-result-object v3

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lcom/bumptech/glide/GenericRequestBuilder;->skipMemoryCache(Z)Lcom/bumptech/glide/GenericRequestBuilder;

    move-result-object v3

    sget-object v4, Lcom/bumptech/glide/load/engine/DiskCacheStrategy;->NONE:Lcom/bumptech/glide/load/engine/DiskCacheStrategy;

    invoke-virtual {v3, v4}, Lcom/bumptech/glide/GenericRequestBuilder;->diskCacheStrategy(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/GenericRequestBuilder;

    move-result-object v3

    invoke-virtual {v3, p2, p3}, Lcom/bumptech/glide/GenericRequestBuilder;->override(II)Lcom/bumptech/glide/GenericRequestBuilder;

    move-result-object v3

    return-object v3
.end method

.method private loadNextFrame()V
    .locals 5

    .line 95
    iget-boolean v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->isRunning:Z

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->isLoadPending:Z

    if-eqz v0, :cond_0

    goto :goto_0

    .line 98
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->isLoadPending:Z

    .line 100
    iget-object v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->gifDecoder:Lcom/bumptech/glide/gifdecoder/GifDecoder;

    invoke-virtual {v0}, Lcom/bumptech/glide/gifdecoder/GifDecoder;->advance()V

    .line 101
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    iget-object v2, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->gifDecoder:Lcom/bumptech/glide/gifdecoder/GifDecoder;

    invoke-virtual {v2}, Lcom/bumptech/glide/gifdecoder/GifDecoder;->getNextDelay()I

    move-result v2

    int-to-long v2, v2

    add-long/2addr v0, v2

    .line 102
    .local v0, "targetTime":J
    new-instance v2, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget;

    iget-object v3, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->handler:Landroid/os/Handler;

    iget-object v4, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->gifDecoder:Lcom/bumptech/glide/gifdecoder/GifDecoder;

    invoke-virtual {v4}, Lcom/bumptech/glide/gifdecoder/GifDecoder;->getCurrentFrameIndex()I

    move-result v4

    invoke-direct {v2, v3, v4, v0, v1}, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget;-><init>(Landroid/os/Handler;IJ)V

    .line 103
    .local v2, "next":Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget;
    iget-object v3, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->requestBuilder:Lcom/bumptech/glide/GenericRequestBuilder;

    new-instance v4, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$FrameSignature;

    invoke-direct {v4}, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$FrameSignature;-><init>()V

    invoke-virtual {v3, v4}, Lcom/bumptech/glide/GenericRequestBuilder;->signature(Lcom/bumptech/glide/load/Key;)Lcom/bumptech/glide/GenericRequestBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/bumptech/glide/GenericRequestBuilder;->into(Lcom/bumptech/glide/request/target/Target;)Lcom/bumptech/glide/request/target/Target;

    .line 106
    return-void

    .line 95
    .end local v0    # "targetTime":J
    .end local v2    # "next":Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget;
    :cond_1
    :goto_0
    nop

    .line 96
    return-void
.end method


# virtual methods
.method public clear()V
    .locals 1

    .line 81
    invoke-virtual {p0}, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->stop()V

    .line 82
    iget-object v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->current:Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget;

    if-eqz v0, :cond_0

    .line 83
    invoke-static {v0}, Lcom/bumptech/glide/Glide;->clear(Lcom/bumptech/glide/request/target/Target;)V

    .line 84
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->current:Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget;

    goto :goto_0

    .line 82
    :cond_0
    nop

    .line 86
    :goto_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->isCleared:Z

    .line 88
    return-void
.end method

.method public getCurrentFrame()Landroid/graphics/Bitmap;
    .locals 1

    .line 91
    iget-object v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->current:Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget;->getResource()Landroid/graphics/Bitmap;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method onFrameReady(Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget;)V
    .locals 4
    .param p1, "delayTarget"    # Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget;

    .line 110
    iget-boolean v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->isCleared:Z

    const/4 v1, 0x2

    if-eqz v0, :cond_0

    .line 111
    iget-object v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v1, p1}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 112
    return-void

    .line 115
    :cond_0
    iget-object v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->current:Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget;

    .line 116
    .local v0, "previous":Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget;
    iput-object p1, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->current:Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget;

    .line 117
    iget-object v2, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->callback:Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$FrameCallback;

    invoke-static {p1}, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget;->access$100(Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget;)I

    move-result v3

    invoke-interface {v2, v3}, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader$FrameCallback;->onFrameReady(I)V

    .line 119
    if-eqz v0, :cond_1

    .line 120
    iget-object v2, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->handler:Landroid/os/Handler;

    invoke-virtual {v2, v1, v0}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v1}, Landroid/os/Message;->sendToTarget()V

    goto :goto_0

    .line 119
    :cond_1
    nop

    .line 123
    :goto_0
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->isLoadPending:Z

    .line 124
    invoke-direct {p0}, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->loadNextFrame()V

    .line 125
    return-void
.end method

.method public setFrameTransformation(Lcom/bumptech/glide/load/Transformation;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/Transformation<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .line 60
    .local p1, "transformation":Lcom/bumptech/glide/load/Transformation;, "Lcom/bumptech/glide/load/Transformation<Landroid/graphics/Bitmap;>;"
    if-eqz p1, :cond_0

    .line 63
    iget-object v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->requestBuilder:Lcom/bumptech/glide/GenericRequestBuilder;

    const/4 v1, 0x1

    new-array v1, v1, [Lcom/bumptech/glide/load/Transformation;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/GenericRequestBuilder;->transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/GenericRequestBuilder;

    move-result-object v0

    iput-object v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->requestBuilder:Lcom/bumptech/glide/GenericRequestBuilder;

    .line 64
    return-void

    .line 61
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "Transformation must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public start()V
    .locals 1

    .line 67
    iget-boolean v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->isRunning:Z

    if-eqz v0, :cond_0

    .line 68
    return-void

    .line 70
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->isRunning:Z

    .line 71
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->isCleared:Z

    .line 73
    invoke-direct {p0}, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->loadNextFrame()V

    .line 74
    return-void
.end method

.method public stop()V
    .locals 1

    .line 77
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bumptech/glide/load/resource/gif/GifFrameLoader;->isRunning:Z

    .line 78
    return-void
.end method
