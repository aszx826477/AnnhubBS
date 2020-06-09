.class public Lcom/bumptech/glide/GifRequestBuilder;
.super Lcom/bumptech/glide/GenericRequestBuilder;
.source "GifRequestBuilder.java"

# interfaces
.implements Lcom/bumptech/glide/BitmapOptions;
.implements Lcom/bumptech/glide/DrawableOptions;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<ModelType:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/bumptech/glide/GenericRequestBuilder<",
        "TModelType;",
        "Ljava/io/InputStream;",
        "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
        "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
        ">;",
        "Lcom/bumptech/glide/BitmapOptions;",
        "Lcom/bumptech/glide/DrawableOptions;"
    }
.end annotation


# direct methods
.method constructor <init>(Lcom/bumptech/glide/provider/LoadProvider;Ljava/lang/Class;Lcom/bumptech/glide/GenericRequestBuilder;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/provider/LoadProvider<",
            "TModelType;",
            "Ljava/io/InputStream;",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            ">;",
            "Ljava/lang/Class<",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            ">;",
            "Lcom/bumptech/glide/GenericRequestBuilder<",
            "TModelType;***>;)V"
        }
    .end annotation

    .line 41
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    .local p1, "loadProvider":Lcom/bumptech/glide/provider/LoadProvider;, "Lcom/bumptech/glide/provider/LoadProvider<TModelType;Ljava/io/InputStream;Lcom/bumptech/glide/load/resource/gif/GifDrawable;Lcom/bumptech/glide/load/resource/gif/GifDrawable;>;"
    .local p2, "transcodeClass":Ljava/lang/Class;, "Ljava/lang/Class<Lcom/bumptech/glide/load/resource/gif/GifDrawable;>;"
    .local p3, "other":Lcom/bumptech/glide/GenericRequestBuilder;, "Lcom/bumptech/glide/GenericRequestBuilder<TModelType;***>;"
    invoke-direct {p0, p1, p2, p3}, Lcom/bumptech/glide/GenericRequestBuilder;-><init>(Lcom/bumptech/glide/provider/LoadProvider;Ljava/lang/Class;Lcom/bumptech/glide/GenericRequestBuilder;)V

    .line 42
    return-void
.end method

.method private toGifTransformations([Lcom/bumptech/glide/load/Transformation;)[Lcom/bumptech/glide/load/resource/gif/GifDrawableTransformation;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/bumptech/glide/load/Transformation<",
            "Landroid/graphics/Bitmap;",
            ">;)[",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawableTransformation;"
        }
    .end annotation

    .line 197
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    .local p1, "bitmapTransformations":[Lcom/bumptech/glide/load/Transformation;, "[Lcom/bumptech/glide/load/Transformation<Landroid/graphics/Bitmap;>;"
    array-length v0, p1

    new-array v0, v0, [Lcom/bumptech/glide/load/resource/gif/GifDrawableTransformation;

    .line 198
    .local v0, "transformations":[Lcom/bumptech/glide/load/resource/gif/GifDrawableTransformation;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p1

    if-ge v1, v2, :cond_0

    .line 199
    new-instance v2, Lcom/bumptech/glide/load/resource/gif/GifDrawableTransformation;

    aget-object v3, p1, v1

    iget-object v4, p0, Lcom/bumptech/glide/GifRequestBuilder;->glide:Lcom/bumptech/glide/Glide;

    invoke-virtual {v4}, Lcom/bumptech/glide/Glide;->getBitmapPool()Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/bumptech/glide/load/resource/gif/GifDrawableTransformation;-><init>(Lcom/bumptech/glide/load/Transformation;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;)V

    aput-object v2, v0, v1

    .line 198
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 201
    .end local v1    # "i":I
    :cond_0
    return-object v0
.end method


# virtual methods
.method public bridge synthetic animate(I)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->animate(I)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic animate(Landroid/view/animation/Animation;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Landroid/view/animation/Animation;

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->animate(Landroid/view/animation/Animation;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic animate(Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->animate(Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public animate(I)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .param p1, "animationId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 280
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->animate(I)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 281
    return-object p0
.end method

.method public animate(Landroid/view/animation/Animation;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/animation/Animation;",
            ")",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 291
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->animate(Landroid/view/animation/Animation;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 292
    return-object p0
.end method

.method public animate(Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .param p1, "animator"    # Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;",
            ")",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 300
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->animate(Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 301
    return-object p0
.end method

.method applyCenterCrop()V
    .locals 0

    .line 431
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/GifRequestBuilder;->centerCrop()Lcom/bumptech/glide/GifRequestBuilder;

    .line 432
    return-void
.end method

.method applyFitCenter()V
    .locals 0

    .line 426
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/GifRequestBuilder;->fitCenter()Lcom/bumptech/glide/GifRequestBuilder;

    .line 427
    return-void
.end method

.method public bridge synthetic cacheDecoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/ResourceDecoder;

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->cacheDecoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public cacheDecoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Ljava/io/File;",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            ">;)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 115
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    .local p1, "cacheDecoder":Lcom/bumptech/glide/load/ResourceDecoder;, "Lcom/bumptech/glide/load/ResourceDecoder<Ljava/io/File;Lcom/bumptech/glide/load/resource/gif/GifDrawable;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->cacheDecoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 116
    return-object p0
.end method

.method public bridge synthetic centerCrop()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/GifRequestBuilder;->centerCrop()Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public centerCrop()Lcom/bumptech/glide/GifRequestBuilder;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 149
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;

    iget-object v1, p0, Lcom/bumptech/glide/GifRequestBuilder;->glide:Lcom/bumptech/glide/Glide;

    invoke-virtual {v1}, Lcom/bumptech/glide/Glide;->getBitmapCenterCrop()Lcom/bumptech/glide/load/resource/bitmap/CenterCrop;

    move-result-object v1

    const/4 v2, 0x0

    aput-object v1, v0, v2

    invoke-virtual {p0, v0}, Lcom/bumptech/glide/GifRequestBuilder;->transformFrame([Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/GifRequestBuilder;->clone()Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public clone()Lcom/bumptech/glide/GifRequestBuilder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 421
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0}, Lcom/bumptech/glide/GenericRequestBuilder;->clone()Lcom/bumptech/glide/GenericRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/bumptech/glide/GifRequestBuilder;

    return-object v0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/GifRequestBuilder;->clone()Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic crossFade()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/GifRequestBuilder;->crossFade()Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic crossFade(I)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->crossFade(I)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic crossFade(II)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I
    .param p2, "x1"    # I

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1, p2}, Lcom/bumptech/glide/GifRequestBuilder;->crossFade(II)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic crossFade(Landroid/view/animation/Animation;I)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Landroid/view/animation/Animation;
    .param p2, "x1"    # I

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1, p2}, Lcom/bumptech/glide/GifRequestBuilder;->crossFade(Landroid/view/animation/Animation;I)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public crossFade()Lcom/bumptech/glide/GifRequestBuilder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 233
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    new-instance v0, Lcom/bumptech/glide/request/animation/DrawableCrossFadeFactory;

    invoke-direct {v0}, Lcom/bumptech/glide/request/animation/DrawableCrossFadeFactory;-><init>()V

    invoke-super {p0, v0}, Lcom/bumptech/glide/GenericRequestBuilder;->animate(Lcom/bumptech/glide/request/animation/GlideAnimationFactory;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 234
    return-object p0
.end method

.method public crossFade(I)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 1
    .param p1, "duration"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 242
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    new-instance v0, Lcom/bumptech/glide/request/animation/DrawableCrossFadeFactory;

    invoke-direct {v0, p1}, Lcom/bumptech/glide/request/animation/DrawableCrossFadeFactory;-><init>(I)V

    invoke-super {p0, v0}, Lcom/bumptech/glide/GenericRequestBuilder;->animate(Lcom/bumptech/glide/request/animation/GlideAnimationFactory;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 243
    return-object p0
.end method

.method public crossFade(II)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 2
    .param p1, "animationId"    # I
    .param p2, "duration"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 261
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    new-instance v0, Lcom/bumptech/glide/request/animation/DrawableCrossFadeFactory;

    iget-object v1, p0, Lcom/bumptech/glide/GifRequestBuilder;->context:Landroid/content/Context;

    invoke-direct {v0, v1, p1, p2}, Lcom/bumptech/glide/request/animation/DrawableCrossFadeFactory;-><init>(Landroid/content/Context;II)V

    invoke-super {p0, v0}, Lcom/bumptech/glide/GenericRequestBuilder;->animate(Lcom/bumptech/glide/request/animation/GlideAnimationFactory;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 263
    return-object p0
.end method

.method public crossFade(Landroid/view/animation/Animation;I)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 1
    .param p1, "animation"    # Landroid/view/animation/Animation;
    .param p2, "duration"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/animation/Animation;",
            "I)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 252
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    new-instance v0, Lcom/bumptech/glide/request/animation/DrawableCrossFadeFactory;

    invoke-direct {v0, p1, p2}, Lcom/bumptech/glide/request/animation/DrawableCrossFadeFactory;-><init>(Landroid/view/animation/Animation;I)V

    invoke-super {p0, v0}, Lcom/bumptech/glide/GenericRequestBuilder;->animate(Lcom/bumptech/glide/request/animation/GlideAnimationFactory;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 253
    return-object p0
.end method

.method public bridge synthetic decoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/ResourceDecoder;

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->decoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public decoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Ljava/io/InputStream;",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            ">;)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 105
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    .local p1, "decoder":Lcom/bumptech/glide/load/ResourceDecoder;, "Lcom/bumptech/glide/load/ResourceDecoder<Ljava/io/InputStream;Lcom/bumptech/glide/load/resource/gif/GifDrawable;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->decoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 106
    return-object p0
.end method

.method public bridge synthetic diskCacheStrategy(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/engine/DiskCacheStrategy;

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->diskCacheStrategy(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public diskCacheStrategy(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .param p1, "strategy"    # Lcom/bumptech/glide/load/engine/DiskCacheStrategy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/engine/DiskCacheStrategy;",
            ")",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 376
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->diskCacheStrategy(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 377
    return-object p0
.end method

.method public bridge synthetic dontAnimate()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/GifRequestBuilder;->dontAnimate()Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public dontAnimate()Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 271
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0}, Lcom/bumptech/glide/GenericRequestBuilder;->dontAnimate()Lcom/bumptech/glide/GenericRequestBuilder;

    .line 272
    return-object p0
.end method

.method public bridge synthetic dontTransform()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/GifRequestBuilder;->dontTransform()Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public dontTransform()Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 403
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0}, Lcom/bumptech/glide/GenericRequestBuilder;->dontTransform()Lcom/bumptech/glide/GenericRequestBuilder;

    .line 404
    return-object p0
.end method

.method public bridge synthetic encoder(Lcom/bumptech/glide/load/ResourceEncoder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/ResourceEncoder;

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->encoder(Lcom/bumptech/glide/load/ResourceEncoder;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public encoder(Lcom/bumptech/glide/load/ResourceEncoder;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/ResourceEncoder<",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            ">;)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 125
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    .local p1, "encoder":Lcom/bumptech/glide/load/ResourceEncoder;, "Lcom/bumptech/glide/load/ResourceEncoder<Lcom/bumptech/glide/load/resource/gif/GifDrawable;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->encoder(Lcom/bumptech/glide/load/ResourceEncoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 126
    return-object p0
.end method

.method public bridge synthetic error(I)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->error(I)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic error(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Landroid/graphics/drawable/Drawable;

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->error(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public error(I)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .param p1, "resourceId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 339
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->error(I)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 340
    return-object p0
.end method

.method public error(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/drawable/Drawable;",
            ")",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 348
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->error(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 349
    return-object p0
.end method

.method public bridge synthetic fallback(I)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->fallback(I)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic fallback(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Landroid/graphics/drawable/Drawable;

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->fallback(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public fallback(I)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .param p1, "resourceId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 330
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->fallback(I)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 331
    return-object p0
.end method

.method public fallback(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/drawable/Drawable;",
            ")",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 324
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->fallback(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 325
    return-object p0
.end method

.method public bridge synthetic fitCenter()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/GifRequestBuilder;->fitCenter()Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public fitCenter()Lcom/bumptech/glide/GifRequestBuilder;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 163
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;

    iget-object v1, p0, Lcom/bumptech/glide/GifRequestBuilder;->glide:Lcom/bumptech/glide/Glide;

    invoke-virtual {v1}, Lcom/bumptech/glide/Glide;->getBitmapFitCenter()Lcom/bumptech/glide/load/resource/bitmap/FitCenter;

    move-result-object v1

    const/4 v2, 0x0

    aput-object v1, v0, v2

    invoke-virtual {p0, v0}, Lcom/bumptech/glide/GifRequestBuilder;->transformFrame([Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic listener(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/request/RequestListener;

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->listener(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public listener(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/request/RequestListener<",
            "-TModelType;",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            ">;)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 358
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    .local p1, "requestListener":Lcom/bumptech/glide/request/RequestListener;, "Lcom/bumptech/glide/request/RequestListener<-TModelType;Lcom/bumptech/glide/load/resource/gif/GifDrawable;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->listener(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 359
    return-object p0
.end method

.method public bridge synthetic load(Ljava/lang/Object;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->load(Ljava/lang/Object;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public load(Ljava/lang/Object;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TModelType;)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 415
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    .local p1, "model":Ljava/lang/Object;, "TModelType;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->load(Ljava/lang/Object;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 416
    return-object p0
.end method

.method public bridge synthetic override(II)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I
    .param p2, "x1"    # I

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1, p2}, Lcom/bumptech/glide/GifRequestBuilder;->override(II)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public override(II)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .param p1, "width"    # I
    .param p2, "height"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 385
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0, p1, p2}, Lcom/bumptech/glide/GenericRequestBuilder;->override(II)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 386
    return-object p0
.end method

.method public bridge synthetic placeholder(I)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->placeholder(I)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic placeholder(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Landroid/graphics/drawable/Drawable;

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->placeholder(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public placeholder(I)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .param p1, "resourceId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 309
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->placeholder(I)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 310
    return-object p0
.end method

.method public placeholder(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/drawable/Drawable;",
            ")",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 318
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->placeholder(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 319
    return-object p0
.end method

.method public bridge synthetic priority(Lcom/bumptech/glide/Priority;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/Priority;

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->priority(Lcom/bumptech/glide/Priority;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public priority(Lcom/bumptech/glide/Priority;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .param p1, "priority"    # Lcom/bumptech/glide/Priority;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/Priority;",
            ")",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 134
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->priority(Lcom/bumptech/glide/Priority;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 135
    return-object p0
.end method

.method public bridge synthetic signature(Lcom/bumptech/glide/load/Key;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/Key;

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->signature(Lcom/bumptech/glide/load/Key;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public signature(Lcom/bumptech/glide/load/Key;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .param p1, "signature"    # Lcom/bumptech/glide/load/Key;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/Key;",
            ")",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 409
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->signature(Lcom/bumptech/glide/load/Key;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 410
    return-object p0
.end method

.method public bridge synthetic sizeMultiplier(F)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # F

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->sizeMultiplier(F)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public sizeMultiplier(F)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .param p1, "sizeMultiplier"    # F
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(F)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 95
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->sizeMultiplier(F)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 96
    return-object p0
.end method

.method public bridge synthetic skipMemoryCache(Z)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Z

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->skipMemoryCache(Z)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public skipMemoryCache(Z)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .param p1, "skip"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 367
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->skipMemoryCache(Z)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 368
    return-object p0
.end method

.method public bridge synthetic sourceEncoder(Lcom/bumptech/glide/load/Encoder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/Encoder;

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->sourceEncoder(Lcom/bumptech/glide/load/Encoder;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public sourceEncoder(Lcom/bumptech/glide/load/Encoder;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/Encoder<",
            "Ljava/io/InputStream;",
            ">;)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 394
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    .local p1, "sourceEncoder":Lcom/bumptech/glide/load/Encoder;, "Lcom/bumptech/glide/load/Encoder<Ljava/io/InputStream;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->sourceEncoder(Lcom/bumptech/glide/load/Encoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 395
    return-object p0
.end method

.method public bridge synthetic thumbnail(F)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # F

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->thumbnail(F)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic thumbnail(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/GenericRequestBuilder;

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->thumbnail(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public thumbnail(F)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .param p1, "sizeMultiplier"    # F
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(F)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 86
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->thumbnail(F)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 87
    return-object p0
.end method

.method public thumbnail(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/GenericRequestBuilder<",
            "***",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            ">;)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 49
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    .local p1, "thumbnailRequest":Lcom/bumptech/glide/GenericRequestBuilder;, "Lcom/bumptech/glide/GenericRequestBuilder<***Lcom/bumptech/glide/load/resource/gif/GifDrawable;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->thumbnail(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 50
    return-object p0
.end method

.method public thumbnail(Lcom/bumptech/glide/GifRequestBuilder;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "*>;)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 77
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    .local p1, "thumbnailRequest":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<*>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->thumbnail(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 78
    return-object p0
.end method

.method public bridge synthetic transcoder(Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->transcoder(Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public transcoder(Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder<",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            ">;)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 224
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    .local p1, "transcoder":Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;, "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder<Lcom/bumptech/glide/load/resource/gif/GifDrawable;Lcom/bumptech/glide/load/resource/gif/GifDrawable;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->transcoder(Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 225
    return-object p0
.end method

.method public bridge synthetic transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # [Lcom/bumptech/glide/load/Transformation;

    .line 35
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public varargs transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/bumptech/glide/load/Transformation<",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            ">;)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 215
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    .local p1, "transformations":[Lcom/bumptech/glide/load/Transformation;, "[Lcom/bumptech/glide/load/Transformation<Lcom/bumptech/glide/load/resource/gif/GifDrawable;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 216
    return-object p0
.end method

.method public varargs transformFrame([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/bumptech/glide/load/Transformation<",
            "Landroid/graphics/Bitmap;",
            ">;)",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 193
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    .local p1, "bitmapTransformations":[Lcom/bumptech/glide/load/Transformation;, "[Lcom/bumptech/glide/load/Transformation<Landroid/graphics/Bitmap;>;"
    invoke-direct {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->toGifTransformations([Lcom/bumptech/glide/load/Transformation;)[Lcom/bumptech/glide/load/resource/gif/GifDrawableTransformation;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/bumptech/glide/GifRequestBuilder;->transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public varargs transformFrame([Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;)Lcom/bumptech/glide/GifRequestBuilder;
    .locals 1
    .param p1, "bitmapTransformations"    # [Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;",
            ")",
            "Lcom/bumptech/glide/GifRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 178
    .local p0, "this":Lcom/bumptech/glide/GifRequestBuilder;, "Lcom/bumptech/glide/GifRequestBuilder<TModelType;>;"
    invoke-direct {p0, p1}, Lcom/bumptech/glide/GifRequestBuilder;->toGifTransformations([Lcom/bumptech/glide/load/Transformation;)[Lcom/bumptech/glide/load/resource/gif/GifDrawableTransformation;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/bumptech/glide/GifRequestBuilder;->transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/GifRequestBuilder;

    move-result-object v0

    return-object v0
.end method
