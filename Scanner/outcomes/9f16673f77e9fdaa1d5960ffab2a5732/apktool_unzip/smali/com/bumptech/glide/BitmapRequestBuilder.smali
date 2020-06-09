.class public Lcom/bumptech/glide/BitmapRequestBuilder;
.super Lcom/bumptech/glide/GenericRequestBuilder;
.source "BitmapRequestBuilder.java"

# interfaces
.implements Lcom/bumptech/glide/BitmapOptions;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<ModelType:",
        "Ljava/lang/Object;",
        "TranscodeType:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/bumptech/glide/GenericRequestBuilder<",
        "TModelType;",
        "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
        "Landroid/graphics/Bitmap;",
        "TTranscodeType;>;",
        "Lcom/bumptech/glide/BitmapOptions;"
    }
.end annotation


# instance fields
.field private final bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

.field private decodeFormat:Lcom/bumptech/glide/load/DecodeFormat;

.field private downsampler:Lcom/bumptech/glide/load/resource/bitmap/Downsampler;

.field private imageDecoder:Lcom/bumptech/glide/load/ResourceDecoder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Ljava/io/InputStream;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field private videoDecoder:Lcom/bumptech/glide/load/ResourceDecoder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Landroid/os/ParcelFileDescriptor;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/bumptech/glide/provider/LoadProvider;Ljava/lang/Class;Lcom/bumptech/glide/GenericRequestBuilder;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/provider/LoadProvider<",
            "TModelType;",
            "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
            "Landroid/graphics/Bitmap;",
            "TTranscodeType;>;",
            "Ljava/lang/Class<",
            "TTranscodeType;>;",
            "Lcom/bumptech/glide/GenericRequestBuilder<",
            "TModelType;***>;)V"
        }
    .end annotation

    .line 57
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    .local p1, "loadProvider":Lcom/bumptech/glide/provider/LoadProvider;, "Lcom/bumptech/glide/provider/LoadProvider<TModelType;Lcom/bumptech/glide/load/model/ImageVideoWrapper;Landroid/graphics/Bitmap;TTranscodeType;>;"
    .local p2, "transcodeClass":Ljava/lang/Class;, "Ljava/lang/Class<TTranscodeType;>;"
    .local p3, "other":Lcom/bumptech/glide/GenericRequestBuilder;, "Lcom/bumptech/glide/GenericRequestBuilder<TModelType;***>;"
    invoke-direct {p0, p1, p2, p3}, Lcom/bumptech/glide/GenericRequestBuilder;-><init>(Lcom/bumptech/glide/provider/LoadProvider;Ljava/lang/Class;Lcom/bumptech/glide/GenericRequestBuilder;)V

    .line 50
    sget-object v0, Lcom/bumptech/glide/load/resource/bitmap/Downsampler;->AT_LEAST:Lcom/bumptech/glide/load/resource/bitmap/Downsampler;

    iput-object v0, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->downsampler:Lcom/bumptech/glide/load/resource/bitmap/Downsampler;

    .line 58
    iget-object v0, p3, Lcom/bumptech/glide/GenericRequestBuilder;->glide:Lcom/bumptech/glide/Glide;

    invoke-virtual {v0}, Lcom/bumptech/glide/Glide;->getBitmapPool()Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    move-result-object v0

    iput-object v0, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    .line 59
    iget-object v0, p3, Lcom/bumptech/glide/GenericRequestBuilder;->glide:Lcom/bumptech/glide/Glide;

    invoke-virtual {v0}, Lcom/bumptech/glide/Glide;->getDecodeFormat()Lcom/bumptech/glide/load/DecodeFormat;

    move-result-object v0

    iput-object v0, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->decodeFormat:Lcom/bumptech/glide/load/DecodeFormat;

    .line 61
    new-instance v0, Lcom/bumptech/glide/load/resource/bitmap/StreamBitmapDecoder;

    iget-object v1, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    iget-object v2, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->decodeFormat:Lcom/bumptech/glide/load/DecodeFormat;

    invoke-direct {v0, v1, v2}, Lcom/bumptech/glide/load/resource/bitmap/StreamBitmapDecoder;-><init>(Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Lcom/bumptech/glide/load/DecodeFormat;)V

    iput-object v0, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->imageDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    .line 62
    new-instance v0, Lcom/bumptech/glide/load/resource/bitmap/FileDescriptorBitmapDecoder;

    iget-object v1, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    iget-object v2, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->decodeFormat:Lcom/bumptech/glide/load/DecodeFormat;

    invoke-direct {v0, v1, v2}, Lcom/bumptech/glide/load/resource/bitmap/FileDescriptorBitmapDecoder;-><init>(Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Lcom/bumptech/glide/load/DecodeFormat;)V

    iput-object v0, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->videoDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    .line 63
    return-void
.end method

.method private downsample(Lcom/bumptech/glide/load/resource/bitmap/Downsampler;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 3
    .param p1, "downsampler"    # Lcom/bumptech/glide/load/resource/bitmap/Downsampler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/resource/bitmap/Downsampler;",
            ")",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 111
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    iput-object p1, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->downsampler:Lcom/bumptech/glide/load/resource/bitmap/Downsampler;

    .line 112
    new-instance v0, Lcom/bumptech/glide/load/resource/bitmap/StreamBitmapDecoder;

    iget-object v1, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    iget-object v2, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->decodeFormat:Lcom/bumptech/glide/load/DecodeFormat;

    invoke-direct {v0, p1, v1, v2}, Lcom/bumptech/glide/load/resource/bitmap/StreamBitmapDecoder;-><init>(Lcom/bumptech/glide/load/resource/bitmap/Downsampler;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Lcom/bumptech/glide/load/DecodeFormat;)V

    iput-object v0, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->imageDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    .line 113
    new-instance v0, Lcom/bumptech/glide/load/resource/bitmap/ImageVideoBitmapDecoder;

    iget-object v1, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->imageDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    iget-object v2, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->videoDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    invoke-direct {v0, v1, v2}, Lcom/bumptech/glide/load/resource/bitmap/ImageVideoBitmapDecoder;-><init>(Lcom/bumptech/glide/load/ResourceDecoder;Lcom/bumptech/glide/load/ResourceDecoder;)V

    invoke-super {p0, v0}, Lcom/bumptech/glide/GenericRequestBuilder;->decoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 114
    return-object p0
.end method


# virtual methods
.method public animate(I)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .param p1, "animationId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 330
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->animate(I)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 331
    return-object p0
.end method

.method public animate(Landroid/view/animation/Animation;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/animation/Animation;",
            ")",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 341
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->animate(Landroid/view/animation/Animation;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 342
    return-object p0
.end method

.method public animate(Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .param p1, "animator"    # Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;",
            ")",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 350
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->animate(Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 351
    return-object p0
.end method

.method public bridge synthetic animate(I)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->animate(I)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic animate(Landroid/view/animation/Animation;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Landroid/view/animation/Animation;

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->animate(Landroid/view/animation/Animation;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic animate(Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->animate(Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method applyCenterCrop()V
    .locals 0

    .line 508
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/BitmapRequestBuilder;->centerCrop()Lcom/bumptech/glide/BitmapRequestBuilder;

    .line 509
    return-void
.end method

.method applyFitCenter()V
    .locals 0

    .line 503
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/BitmapRequestBuilder;->fitCenter()Lcom/bumptech/glide/BitmapRequestBuilder;

    .line 504
    return-void
.end method

.method public approximate()Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 73
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    sget-object v0, Lcom/bumptech/glide/load/resource/bitmap/Downsampler;->AT_LEAST:Lcom/bumptech/glide/load/resource/bitmap/Downsampler;

    invoke-direct {p0, v0}, Lcom/bumptech/glide/BitmapRequestBuilder;->downsample(Lcom/bumptech/glide/load/resource/bitmap/Downsampler;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public asIs()Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 84
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    sget-object v0, Lcom/bumptech/glide/load/resource/bitmap/Downsampler;->NONE:Lcom/bumptech/glide/load/resource/bitmap/Downsampler;

    invoke-direct {p0, v0}, Lcom/bumptech/glide/BitmapRequestBuilder;->downsample(Lcom/bumptech/glide/load/resource/bitmap/Downsampler;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public atMost()Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 96
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    sget-object v0, Lcom/bumptech/glide/load/resource/bitmap/Downsampler;->AT_MOST:Lcom/bumptech/glide/load/resource/bitmap/Downsampler;

    invoke-direct {p0, v0}, Lcom/bumptech/glide/BitmapRequestBuilder;->downsample(Lcom/bumptech/glide/load/resource/bitmap/Downsampler;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public cacheDecoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Ljava/io/File;",
            "Landroid/graphics/Bitmap;",
            ">;)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 178
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    .local p1, "cacheDecoder":Lcom/bumptech/glide/load/ResourceDecoder;, "Lcom/bumptech/glide/load/ResourceDecoder<Ljava/io/File;Landroid/graphics/Bitmap;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->cacheDecoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 179
    return-object p0
.end method

.method public bridge synthetic cacheDecoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/ResourceDecoder;

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->cacheDecoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public centerCrop()Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 278
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;

    iget-object v1, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->glide:Lcom/bumptech/glide/Glide;

    invoke-virtual {v1}, Lcom/bumptech/glide/Glide;->getBitmapCenterCrop()Lcom/bumptech/glide/load/resource/bitmap/CenterCrop;

    move-result-object v1

    const/4 v2, 0x0

    aput-object v1, v0, v2

    invoke-virtual {p0, v0}, Lcom/bumptech/glide/BitmapRequestBuilder;->transform([Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic centerCrop()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/BitmapRequestBuilder;->centerCrop()Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public clone()Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 481
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0}, Lcom/bumptech/glide/GenericRequestBuilder;->clone()Lcom/bumptech/glide/GenericRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/bumptech/glide/BitmapRequestBuilder;

    return-object v0
.end method

.method public bridge synthetic clone()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/BitmapRequestBuilder;->clone()Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/BitmapRequestBuilder;->clone()Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public decoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
            "Landroid/graphics/Bitmap;",
            ">;)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 169
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    .local p1, "decoder":Lcom/bumptech/glide/load/ResourceDecoder;, "Lcom/bumptech/glide/load/ResourceDecoder<Lcom/bumptech/glide/load/model/ImageVideoWrapper;Landroid/graphics/Bitmap;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->decoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 170
    return-object p0
.end method

.method public bridge synthetic decoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/ResourceDecoder;

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->decoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public diskCacheStrategy(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .param p1, "strategy"    # Lcom/bumptech/glide/load/engine/DiskCacheStrategy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/engine/DiskCacheStrategy;",
            ")",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 426
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->diskCacheStrategy(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 427
    return-object p0
.end method

.method public bridge synthetic diskCacheStrategy(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/engine/DiskCacheStrategy;

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->diskCacheStrategy(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public dontAnimate()Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 321
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0}, Lcom/bumptech/glide/GenericRequestBuilder;->dontAnimate()Lcom/bumptech/glide/GenericRequestBuilder;

    .line 322
    return-object p0
.end method

.method public bridge synthetic dontAnimate()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/BitmapRequestBuilder;->dontAnimate()Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public dontTransform()Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 463
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0}, Lcom/bumptech/glide/GenericRequestBuilder;->dontTransform()Lcom/bumptech/glide/GenericRequestBuilder;

    .line 464
    return-object p0
.end method

.method public bridge synthetic dontTransform()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/BitmapRequestBuilder;->dontTransform()Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public encoder(Lcom/bumptech/glide/load/ResourceEncoder;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/ResourceEncoder<",
            "Landroid/graphics/Bitmap;",
            ">;)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 187
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    .local p1, "encoder":Lcom/bumptech/glide/load/ResourceEncoder;, "Lcom/bumptech/glide/load/ResourceEncoder<Landroid/graphics/Bitmap;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->encoder(Lcom/bumptech/glide/load/ResourceEncoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 188
    return-object p0
.end method

.method public bridge synthetic encoder(Lcom/bumptech/glide/load/ResourceEncoder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/ResourceEncoder;

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->encoder(Lcom/bumptech/glide/load/ResourceEncoder;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public error(I)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .param p1, "resourceId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 389
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->error(I)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 390
    return-object p0
.end method

.method public error(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/drawable/Drawable;",
            ")",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 398
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->error(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 399
    return-object p0
.end method

.method public bridge synthetic error(I)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->error(I)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic error(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Landroid/graphics/drawable/Drawable;

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->error(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public fallback(I)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .param p1, "resourceId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 380
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->fallback(I)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 381
    return-object p0
.end method

.method public fallback(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/drawable/Drawable;",
            ")",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 374
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->fallback(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 375
    return-object p0
.end method

.method public bridge synthetic fallback(I)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->fallback(I)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic fallback(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Landroid/graphics/drawable/Drawable;

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->fallback(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public fitCenter()Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 291
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;

    iget-object v1, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->glide:Lcom/bumptech/glide/Glide;

    invoke-virtual {v1}, Lcom/bumptech/glide/Glide;->getBitmapFitCenter()Lcom/bumptech/glide/load/resource/bitmap/FitCenter;

    move-result-object v1

    const/4 v2, 0x0

    aput-object v1, v0, v2

    invoke-virtual {p0, v0}, Lcom/bumptech/glide/BitmapRequestBuilder;->transform([Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic fitCenter()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/BitmapRequestBuilder;->fitCenter()Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public format(Lcom/bumptech/glide/load/DecodeFormat;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 4
    .param p1, "format"    # Lcom/bumptech/glide/load/DecodeFormat;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/DecodeFormat;",
            ")",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 239
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    iput-object p1, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->decodeFormat:Lcom/bumptech/glide/load/DecodeFormat;

    .line 240
    new-instance v0, Lcom/bumptech/glide/load/resource/bitmap/StreamBitmapDecoder;

    iget-object v1, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->downsampler:Lcom/bumptech/glide/load/resource/bitmap/Downsampler;

    iget-object v2, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    invoke-direct {v0, v1, v2, p1}, Lcom/bumptech/glide/load/resource/bitmap/StreamBitmapDecoder;-><init>(Lcom/bumptech/glide/load/resource/bitmap/Downsampler;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Lcom/bumptech/glide/load/DecodeFormat;)V

    iput-object v0, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->imageDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    .line 241
    new-instance v0, Lcom/bumptech/glide/load/resource/bitmap/FileDescriptorBitmapDecoder;

    new-instance v1, Lcom/bumptech/glide/load/resource/bitmap/VideoBitmapDecoder;

    invoke-direct {v1}, Lcom/bumptech/glide/load/resource/bitmap/VideoBitmapDecoder;-><init>()V

    iget-object v2, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    invoke-direct {v0, v1, v2, p1}, Lcom/bumptech/glide/load/resource/bitmap/FileDescriptorBitmapDecoder;-><init>(Lcom/bumptech/glide/load/resource/bitmap/VideoBitmapDecoder;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Lcom/bumptech/glide/load/DecodeFormat;)V

    iput-object v0, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->videoDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    .line 242
    new-instance v0, Lcom/bumptech/glide/load/resource/file/FileToStreamDecoder;

    new-instance v1, Lcom/bumptech/glide/load/resource/bitmap/StreamBitmapDecoder;

    iget-object v2, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->downsampler:Lcom/bumptech/glide/load/resource/bitmap/Downsampler;

    iget-object v3, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    invoke-direct {v1, v2, v3, p1}, Lcom/bumptech/glide/load/resource/bitmap/StreamBitmapDecoder;-><init>(Lcom/bumptech/glide/load/resource/bitmap/Downsampler;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Lcom/bumptech/glide/load/DecodeFormat;)V

    invoke-direct {v0, v1}, Lcom/bumptech/glide/load/resource/file/FileToStreamDecoder;-><init>(Lcom/bumptech/glide/load/ResourceDecoder;)V

    invoke-super {p0, v0}, Lcom/bumptech/glide/GenericRequestBuilder;->cacheDecoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 243
    new-instance v0, Lcom/bumptech/glide/load/resource/bitmap/ImageVideoBitmapDecoder;

    iget-object v1, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->imageDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    iget-object v2, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->videoDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    invoke-direct {v0, v1, v2}, Lcom/bumptech/glide/load/resource/bitmap/ImageVideoBitmapDecoder;-><init>(Lcom/bumptech/glide/load/ResourceDecoder;Lcom/bumptech/glide/load/ResourceDecoder;)V

    invoke-super {p0, v0}, Lcom/bumptech/glide/GenericRequestBuilder;->decoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 244
    return-object p0
.end method

.method public imageDecoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Ljava/io/InputStream;",
            "Landroid/graphics/Bitmap;",
            ">;)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 201
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    .local p1, "decoder":Lcom/bumptech/glide/load/ResourceDecoder;, "Lcom/bumptech/glide/load/ResourceDecoder<Ljava/io/InputStream;Landroid/graphics/Bitmap;>;"
    iput-object p1, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->imageDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    .line 202
    new-instance v0, Lcom/bumptech/glide/load/resource/bitmap/ImageVideoBitmapDecoder;

    iget-object v1, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->videoDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    invoke-direct {v0, p1, v1}, Lcom/bumptech/glide/load/resource/bitmap/ImageVideoBitmapDecoder;-><init>(Lcom/bumptech/glide/load/ResourceDecoder;Lcom/bumptech/glide/load/ResourceDecoder;)V

    invoke-super {p0, v0}, Lcom/bumptech/glide/GenericRequestBuilder;->decoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 203
    return-object p0
.end method

.method public into(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;
    .locals 1
    .param p1, "view"    # Landroid/widget/ImageView;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/ImageView;",
            ")",
            "Lcom/bumptech/glide/request/target/Target<",
            "TTranscodeType;>;"
        }
    .end annotation

    .line 498
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->into(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;

    move-result-object v0

    return-object v0
.end method

.method public listener(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/request/RequestListener<",
            "-TModelType;TTranscodeType;>;)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 408
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    .local p1, "requestListener":Lcom/bumptech/glide/request/RequestListener;, "Lcom/bumptech/glide/request/RequestListener<-TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->listener(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 409
    return-object p0
.end method

.method public bridge synthetic listener(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/request/RequestListener;

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->listener(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public load(Ljava/lang/Object;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TModelType;)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 475
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    .local p1, "model":Ljava/lang/Object;, "TModelType;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->load(Ljava/lang/Object;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 476
    return-object p0
.end method

.method public bridge synthetic load(Ljava/lang/Object;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->load(Ljava/lang/Object;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public override(II)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .param p1, "width"    # I
    .param p2, "height"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 435
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1, p2}, Lcom/bumptech/glide/GenericRequestBuilder;->override(II)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 436
    return-object p0
.end method

.method public bridge synthetic override(II)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I
    .param p2, "x1"    # I

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1, p2}, Lcom/bumptech/glide/BitmapRequestBuilder;->override(II)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public placeholder(I)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .param p1, "resourceId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 359
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->placeholder(I)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 360
    return-object p0
.end method

.method public placeholder(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/drawable/Drawable;",
            ")",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 368
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->placeholder(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 369
    return-object p0
.end method

.method public bridge synthetic placeholder(I)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->placeholder(I)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic placeholder(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Landroid/graphics/drawable/Drawable;

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->placeholder(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public priority(Lcom/bumptech/glide/Priority;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .param p1, "priority"    # Lcom/bumptech/glide/Priority;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/Priority;",
            ")",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 249
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->priority(Lcom/bumptech/glide/Priority;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 250
    return-object p0
.end method

.method public bridge synthetic priority(Lcom/bumptech/glide/Priority;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/Priority;

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->priority(Lcom/bumptech/glide/Priority;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public signature(Lcom/bumptech/glide/load/Key;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .param p1, "signature"    # Lcom/bumptech/glide/load/Key;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/Key;",
            ")",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 469
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->signature(Lcom/bumptech/glide/load/Key;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 470
    return-object p0
.end method

.method public bridge synthetic signature(Lcom/bumptech/glide/load/Key;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/Key;

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->signature(Lcom/bumptech/glide/load/Key;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public sizeMultiplier(F)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .param p1, "sizeMultiplier"    # F
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(F)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 160
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->sizeMultiplier(F)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 161
    return-object p0
.end method

.method public bridge synthetic sizeMultiplier(F)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # F

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->sizeMultiplier(F)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public skipMemoryCache(Z)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .param p1, "skip"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 417
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->skipMemoryCache(Z)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 418
    return-object p0
.end method

.method public bridge synthetic skipMemoryCache(Z)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Z

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->skipMemoryCache(Z)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public sourceEncoder(Lcom/bumptech/glide/load/Encoder;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/Encoder<",
            "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
            ">;)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 454
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    .local p1, "sourceEncoder":Lcom/bumptech/glide/load/Encoder;, "Lcom/bumptech/glide/load/Encoder<Lcom/bumptech/glide/load/model/ImageVideoWrapper;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->sourceEncoder(Lcom/bumptech/glide/load/Encoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 455
    return-object p0
.end method

.method public bridge synthetic sourceEncoder(Lcom/bumptech/glide/load/Encoder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/Encoder;

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->sourceEncoder(Lcom/bumptech/glide/load/Encoder;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public thumbnail(F)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .param p1, "sizeMultiplier"    # F
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(F)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 122
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->thumbnail(F)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 123
    return-object p0
.end method

.method public thumbnail(Lcom/bumptech/glide/BitmapRequestBuilder;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "*TTranscodeType;>;)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 151
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    .local p1, "thumbnailRequest":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<*TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->thumbnail(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 152
    return-object p0
.end method

.method public thumbnail(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/GenericRequestBuilder<",
            "***TTranscodeType;>;)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 445
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    .local p1, "thumbnailRequest":Lcom/bumptech/glide/GenericRequestBuilder;, "Lcom/bumptech/glide/GenericRequestBuilder<***TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->thumbnail(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 446
    return-object p0
.end method

.method public bridge synthetic thumbnail(F)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # F

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->thumbnail(F)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic thumbnail(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/GenericRequestBuilder;

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->thumbnail(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public transcoder(Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder<",
            "Landroid/graphics/Bitmap;",
            "TTranscodeType;>;)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 312
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    .local p1, "transcoder":Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;, "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder<Landroid/graphics/Bitmap;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->transcoder(Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 313
    return-object p0
.end method

.method public bridge synthetic transcoder(Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->transcoder(Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public varargs transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/bumptech/glide/load/Transformation<",
            "Landroid/graphics/Bitmap;",
            ">;)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 302
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    .local p1, "transformations":[Lcom/bumptech/glide/load/Transformation;, "[Lcom/bumptech/glide/load/Transformation<Landroid/graphics/Bitmap;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 303
    return-object p0
.end method

.method public varargs transform([Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 0
    .param p1, "transformations"    # [Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;",
            ")",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 264
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 265
    return-object p0
.end method

.method public bridge synthetic transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # [Lcom/bumptech/glide/load/Transformation;

    .line 46
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;->transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public videoDecoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Landroid/os/ParcelFileDescriptor;",
            "Landroid/graphics/Bitmap;",
            ">;)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TTranscodeType;>;"
        }
    .end annotation

    .line 215
    .local p0, "this":Lcom/bumptech/glide/BitmapRequestBuilder;, "Lcom/bumptech/glide/BitmapRequestBuilder<TModelType;TTranscodeType;>;"
    .local p1, "decoder":Lcom/bumptech/glide/load/ResourceDecoder;, "Lcom/bumptech/glide/load/ResourceDecoder<Landroid/os/ParcelFileDescriptor;Landroid/graphics/Bitmap;>;"
    iput-object p1, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->videoDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    .line 216
    new-instance v0, Lcom/bumptech/glide/load/resource/bitmap/ImageVideoBitmapDecoder;

    iget-object v1, p0, Lcom/bumptech/glide/BitmapRequestBuilder;->imageDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    invoke-direct {v0, v1, p1}, Lcom/bumptech/glide/load/resource/bitmap/ImageVideoBitmapDecoder;-><init>(Lcom/bumptech/glide/load/ResourceDecoder;Lcom/bumptech/glide/load/ResourceDecoder;)V

    invoke-super {p0, v0}, Lcom/bumptech/glide/GenericRequestBuilder;->decoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 217
    return-object p0
.end method
