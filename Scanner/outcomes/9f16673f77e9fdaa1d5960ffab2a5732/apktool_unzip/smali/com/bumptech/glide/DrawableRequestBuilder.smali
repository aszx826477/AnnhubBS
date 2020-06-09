.class public Lcom/bumptech/glide/DrawableRequestBuilder;
.super Lcom/bumptech/glide/GenericRequestBuilder;
.source "DrawableRequestBuilder.java"

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
        "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
        "Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;",
        "Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;",
        ">;",
        "Lcom/bumptech/glide/BitmapOptions;",
        "Lcom/bumptech/glide/DrawableOptions;"
    }
.end annotation


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/Class;Lcom/bumptech/glide/provider/LoadProvider;Lcom/bumptech/glide/Glide;Lcom/bumptech/glide/manager/RequestTracker;Lcom/bumptech/glide/manager/Lifecycle;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p4, "glide"    # Lcom/bumptech/glide/Glide;
    .param p5, "requestTracker"    # Lcom/bumptech/glide/manager/RequestTracker;
    .param p6, "lifecycle"    # Lcom/bumptech/glide/manager/Lifecycle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/Class<",
            "TModelType;>;",
            "Lcom/bumptech/glide/provider/LoadProvider<",
            "TModelType;",
            "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
            "Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;",
            "Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;",
            ">;",
            "Lcom/bumptech/glide/Glide;",
            "Lcom/bumptech/glide/manager/RequestTracker;",
            "Lcom/bumptech/glide/manager/Lifecycle;",
            ")V"
        }
    .end annotation

    .line 48
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    .local p2, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TModelType;>;"
    .local p3, "loadProvider":Lcom/bumptech/glide/provider/LoadProvider;, "Lcom/bumptech/glide/provider/LoadProvider<TModelType;Lcom/bumptech/glide/load/model/ImageVideoWrapper;Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;>;"
    const-class v4, Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v5, p4

    move-object v6, p5

    move-object v7, p6

    invoke-direct/range {v0 .. v7}, Lcom/bumptech/glide/GenericRequestBuilder;-><init>(Landroid/content/Context;Ljava/lang/Class;Lcom/bumptech/glide/provider/LoadProvider;Ljava/lang/Class;Lcom/bumptech/glide/Glide;Lcom/bumptech/glide/manager/RequestTracker;Lcom/bumptech/glide/manager/Lifecycle;)V

    .line 50
    invoke-virtual {p0}, Lcom/bumptech/glide/DrawableRequestBuilder;->crossFade()Lcom/bumptech/glide/DrawableRequestBuilder;

    .line 51
    return-void
.end method


# virtual methods
.method public animate(I)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .param p1, "animationId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 299
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->animate(I)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 300
    return-object p0
.end method

.method public animate(Landroid/view/animation/Animation;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/animation/Animation;",
            ")",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 310
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->animate(Landroid/view/animation/Animation;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 311
    return-object p0
.end method

.method public animate(Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .param p1, "animator"    # Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;",
            ")",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 290
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->animate(Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 291
    return-object p0
.end method

.method public bridge synthetic animate(I)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->animate(I)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic animate(Landroid/view/animation/Animation;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Landroid/view/animation/Animation;

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->animate(Landroid/view/animation/Animation;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic animate(Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->animate(Lcom/bumptech/glide/request/animation/ViewPropertyAnimation$Animator;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method applyCenterCrop()V
    .locals 0

    .line 458
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/DrawableRequestBuilder;->centerCrop()Lcom/bumptech/glide/DrawableRequestBuilder;

    .line 459
    return-void
.end method

.method applyFitCenter()V
    .locals 0

    .line 453
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/DrawableRequestBuilder;->fitCenter()Lcom/bumptech/glide/DrawableRequestBuilder;

    .line 454
    return-void
.end method

.method public varargs bitmapTransform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/bumptech/glide/load/Transformation<",
            "Landroid/graphics/Bitmap;",
            ">;)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 209
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    .local p1, "bitmapTransformations":[Lcom/bumptech/glide/load/Transformation;, "[Lcom/bumptech/glide/load/Transformation<Landroid/graphics/Bitmap;>;"
    array-length v0, p1

    new-array v0, v0, [Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperTransformation;

    .line 211
    .local v0, "transformations":[Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperTransformation;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p1

    if-ge v1, v2, :cond_0

    .line 212
    new-instance v2, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperTransformation;

    iget-object v3, p0, Lcom/bumptech/glide/DrawableRequestBuilder;->glide:Lcom/bumptech/glide/Glide;

    invoke-virtual {v3}, Lcom/bumptech/glide/Glide;->getBitmapPool()Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    move-result-object v3

    aget-object v4, p1, v1

    invoke-direct {v2, v3, v4}, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperTransformation;-><init>(Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Lcom/bumptech/glide/load/Transformation;)V

    aput-object v2, v0, v1

    .line 211
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 214
    .end local v1    # "i":I
    :cond_0
    invoke-virtual {p0, v0}, Lcom/bumptech/glide/DrawableRequestBuilder;->transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v1

    return-object v1
.end method

.method public cacheDecoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Ljava/io/File;",
            "Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;",
            ">;)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 124
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    .local p1, "cacheDecoder":Lcom/bumptech/glide/load/ResourceDecoder;, "Lcom/bumptech/glide/load/ResourceDecoder<Ljava/io/File;Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->cacheDecoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 125
    return-object p0
.end method

.method public bridge synthetic cacheDecoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/ResourceDecoder;

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->cacheDecoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public centerCrop()Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 179
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/bumptech/glide/load/Transformation;

    iget-object v1, p0, Lcom/bumptech/glide/DrawableRequestBuilder;->glide:Lcom/bumptech/glide/Glide;

    invoke-virtual {v1}, Lcom/bumptech/glide/Glide;->getDrawableCenterCrop()Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperTransformation;

    move-result-object v1

    const/4 v2, 0x0

    aput-object v1, v0, v2

    invoke-virtual {p0, v0}, Lcom/bumptech/glide/DrawableRequestBuilder;->transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic centerCrop()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/DrawableRequestBuilder;->centerCrop()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public clone()Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 431
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0}, Lcom/bumptech/glide/GenericRequestBuilder;->clone()Lcom/bumptech/glide/GenericRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/bumptech/glide/DrawableRequestBuilder;

    return-object v0
.end method

.method public bridge synthetic clone()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/DrawableRequestBuilder;->clone()Lcom/bumptech/glide/DrawableRequestBuilder;

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

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/DrawableRequestBuilder;->clone()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public final crossFade()Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 246
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    new-instance v0, Lcom/bumptech/glide/request/animation/DrawableCrossFadeFactory;

    invoke-direct {v0}, Lcom/bumptech/glide/request/animation/DrawableCrossFadeFactory;-><init>()V

    invoke-super {p0, v0}, Lcom/bumptech/glide/GenericRequestBuilder;->animate(Lcom/bumptech/glide/request/animation/GlideAnimationFactory;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 247
    return-object p0
.end method

.method public crossFade(I)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 1
    .param p1, "duration"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 254
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    new-instance v0, Lcom/bumptech/glide/request/animation/DrawableCrossFadeFactory;

    invoke-direct {v0, p1}, Lcom/bumptech/glide/request/animation/DrawableCrossFadeFactory;-><init>(I)V

    invoke-super {p0, v0}, Lcom/bumptech/glide/GenericRequestBuilder;->animate(Lcom/bumptech/glide/request/animation/GlideAnimationFactory;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 255
    return-object p0
.end method

.method public crossFade(II)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 2
    .param p1, "animationId"    # I
    .param p2, "duration"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 271
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    new-instance v0, Lcom/bumptech/glide/request/animation/DrawableCrossFadeFactory;

    iget-object v1, p0, Lcom/bumptech/glide/DrawableRequestBuilder;->context:Landroid/content/Context;

    invoke-direct {v0, v1, p1, p2}, Lcom/bumptech/glide/request/animation/DrawableCrossFadeFactory;-><init>(Landroid/content/Context;II)V

    invoke-super {p0, v0}, Lcom/bumptech/glide/GenericRequestBuilder;->animate(Lcom/bumptech/glide/request/animation/GlideAnimationFactory;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 273
    return-object p0
.end method

.method public crossFade(Landroid/view/animation/Animation;I)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 1
    .param p1, "animation"    # Landroid/view/animation/Animation;
    .param p2, "duration"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/animation/Animation;",
            "I)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 263
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    new-instance v0, Lcom/bumptech/glide/request/animation/DrawableCrossFadeFactory;

    invoke-direct {v0, p1, p2}, Lcom/bumptech/glide/request/animation/DrawableCrossFadeFactory;-><init>(Landroid/view/animation/Animation;I)V

    invoke-super {p0, v0}, Lcom/bumptech/glide/GenericRequestBuilder;->animate(Lcom/bumptech/glide/request/animation/GlideAnimationFactory;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 264
    return-object p0
.end method

.method public bridge synthetic crossFade()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/DrawableRequestBuilder;->crossFade()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic crossFade(I)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->crossFade(I)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic crossFade(II)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I
    .param p2, "x1"    # I

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1, p2}, Lcom/bumptech/glide/DrawableRequestBuilder;->crossFade(II)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic crossFade(Landroid/view/animation/Animation;I)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Landroid/view/animation/Animation;
    .param p2, "x1"    # I

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1, p2}, Lcom/bumptech/glide/DrawableRequestBuilder;->crossFade(Landroid/view/animation/Animation;I)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public decoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
            "Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;",
            ">;)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 115
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    .local p1, "decoder":Lcom/bumptech/glide/load/ResourceDecoder;, "Lcom/bumptech/glide/load/ResourceDecoder<Lcom/bumptech/glide/load/model/ImageVideoWrapper;Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->decoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 116
    return-object p0
.end method

.method public bridge synthetic decoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/ResourceDecoder;

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->decoder(Lcom/bumptech/glide/load/ResourceDecoder;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public diskCacheStrategy(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .param p1, "strategy"    # Lcom/bumptech/glide/load/engine/DiskCacheStrategy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/engine/DiskCacheStrategy;",
            ")",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 377
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->diskCacheStrategy(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 378
    return-object p0
.end method

.method public bridge synthetic diskCacheStrategy(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/engine/DiskCacheStrategy;

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->diskCacheStrategy(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public dontAnimate()Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 281
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0}, Lcom/bumptech/glide/GenericRequestBuilder;->dontAnimate()Lcom/bumptech/glide/GenericRequestBuilder;

    .line 282
    return-object p0
.end method

.method public bridge synthetic dontAnimate()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/DrawableRequestBuilder;->dontAnimate()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public dontTransform()Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 413
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0}, Lcom/bumptech/glide/GenericRequestBuilder;->dontTransform()Lcom/bumptech/glide/GenericRequestBuilder;

    .line 414
    return-object p0
.end method

.method public bridge synthetic dontTransform()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/DrawableRequestBuilder;->dontTransform()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public encoder(Lcom/bumptech/glide/load/ResourceEncoder;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/ResourceEncoder<",
            "Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;",
            ">;)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 133
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    .local p1, "encoder":Lcom/bumptech/glide/load/ResourceEncoder;, "Lcom/bumptech/glide/load/ResourceEncoder<Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->encoder(Lcom/bumptech/glide/load/ResourceEncoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 134
    return-object p0
.end method

.method public bridge synthetic encoder(Lcom/bumptech/glide/load/ResourceEncoder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/ResourceEncoder;

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->encoder(Lcom/bumptech/glide/load/ResourceEncoder;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public error(I)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .param p1, "resourceId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 349
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->error(I)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 350
    return-object p0
.end method

.method public error(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/drawable/Drawable;",
            ")",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 358
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->error(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 359
    return-object p0
.end method

.method public bridge synthetic error(I)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->error(I)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic error(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Landroid/graphics/drawable/Drawable;

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->error(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public fallback(I)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .param p1, "resourceId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 340
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->fallback(I)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 341
    return-object p0
.end method

.method public fallback(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/drawable/Drawable;",
            ")",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 334
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->fallback(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 335
    return-object p0
.end method

.method public bridge synthetic fallback(I)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->fallback(I)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic fallback(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Landroid/graphics/drawable/Drawable;

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->fallback(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public fitCenter()Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 194
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/bumptech/glide/load/Transformation;

    iget-object v1, p0, Lcom/bumptech/glide/DrawableRequestBuilder;->glide:Lcom/bumptech/glide/Glide;

    invoke-virtual {v1}, Lcom/bumptech/glide/Glide;->getDrawableFitCenter()Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperTransformation;

    move-result-object v1

    const/4 v2, 0x0

    aput-object v1, v0, v2

    invoke-virtual {p0, v0}, Lcom/bumptech/glide/DrawableRequestBuilder;->transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic fitCenter()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0}, Lcom/bumptech/glide/DrawableRequestBuilder;->fitCenter()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
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
            "Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;",
            ">;"
        }
    .end annotation

    .line 448
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->into(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;

    move-result-object v0

    return-object v0
.end method

.method public listener(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/request/RequestListener<",
            "-TModelType;",
            "Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;",
            ">;)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 368
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    .local p1, "requestListener":Lcom/bumptech/glide/request/RequestListener;, "Lcom/bumptech/glide/request/RequestListener<-TModelType;Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->listener(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 369
    return-object p0
.end method

.method public bridge synthetic listener(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/request/RequestListener;

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->listener(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public load(Ljava/lang/Object;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TModelType;)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 425
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    .local p1, "model":Ljava/lang/Object;, "TModelType;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->load(Ljava/lang/Object;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 426
    return-object p0
.end method

.method public bridge synthetic load(Ljava/lang/Object;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->load(Ljava/lang/Object;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public override(II)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .param p1, "width"    # I
    .param p2, "height"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 395
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0, p1, p2}, Lcom/bumptech/glide/GenericRequestBuilder;->override(II)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 396
    return-object p0
.end method

.method public bridge synthetic override(II)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I
    .param p2, "x1"    # I

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1, p2}, Lcom/bumptech/glide/DrawableRequestBuilder;->override(II)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public placeholder(I)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .param p1, "resourceId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 319
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->placeholder(I)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 320
    return-object p0
.end method

.method public placeholder(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/drawable/Drawable;",
            ")",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 328
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->placeholder(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 329
    return-object p0
.end method

.method public bridge synthetic placeholder(I)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # I

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->placeholder(I)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic placeholder(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Landroid/graphics/drawable/Drawable;

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->placeholder(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public priority(Lcom/bumptech/glide/Priority;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .param p1, "priority"    # Lcom/bumptech/glide/Priority;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/Priority;",
            ")",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 142
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->priority(Lcom/bumptech/glide/Priority;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 143
    return-object p0
.end method

.method public bridge synthetic priority(Lcom/bumptech/glide/Priority;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/Priority;

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->priority(Lcom/bumptech/glide/Priority;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public signature(Lcom/bumptech/glide/load/Key;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .param p1, "signature"    # Lcom/bumptech/glide/load/Key;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/Key;",
            ")",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 419
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->signature(Lcom/bumptech/glide/load/Key;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 420
    return-object p0
.end method

.method public bridge synthetic signature(Lcom/bumptech/glide/load/Key;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/Key;

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->signature(Lcom/bumptech/glide/load/Key;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public sizeMultiplier(F)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .param p1, "sizeMultiplier"    # F
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(F)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 106
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->sizeMultiplier(F)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 107
    return-object p0
.end method

.method public bridge synthetic sizeMultiplier(F)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # F

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->sizeMultiplier(F)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public skipMemoryCache(Z)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .param p1, "skip"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 386
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->skipMemoryCache(Z)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 387
    return-object p0
.end method

.method public bridge synthetic skipMemoryCache(Z)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Z

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->skipMemoryCache(Z)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public sourceEncoder(Lcom/bumptech/glide/load/Encoder;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/Encoder<",
            "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
            ">;)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 404
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    .local p1, "sourceEncoder":Lcom/bumptech/glide/load/Encoder;, "Lcom/bumptech/glide/load/Encoder<Lcom/bumptech/glide/load/model/ImageVideoWrapper;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->sourceEncoder(Lcom/bumptech/glide/load/Encoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 405
    return-object p0
.end method

.method public bridge synthetic sourceEncoder(Lcom/bumptech/glide/load/Encoder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/Encoder;

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->sourceEncoder(Lcom/bumptech/glide/load/Encoder;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public thumbnail(F)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .param p1, "sizeMultiplier"    # F
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(F)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 97
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->thumbnail(F)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 98
    return-object p0
.end method

.method public thumbnail(Lcom/bumptech/glide/DrawableRequestBuilder;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "*>;)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 78
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    .local p1, "thumbnailRequest":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<*>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->thumbnail(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 79
    return-object p0
.end method

.method public thumbnail(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/GenericRequestBuilder<",
            "***",
            "Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;",
            ">;)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 88
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    .local p1, "thumbnailRequest":Lcom/bumptech/glide/GenericRequestBuilder;, "Lcom/bumptech/glide/GenericRequestBuilder<***Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->thumbnail(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 89
    return-object p0
.end method

.method public bridge synthetic thumbnail(F)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # F

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->thumbnail(F)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic thumbnail(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/GenericRequestBuilder;

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->thumbnail(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public transcoder(Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder<",
            "Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;",
            "Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;",
            ">;)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 238
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    .local p1, "transcoder":Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;, "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder<Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->transcoder(Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 239
    return-object p0
.end method

.method public bridge synthetic transcoder(Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->transcoder(Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public varargs transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/bumptech/glide/load/Transformation<",
            "Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;",
            ">;)",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 228
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    .local p1, "transformation":[Lcom/bumptech/glide/load/Transformation;, "[Lcom/bumptech/glide/load/Transformation<Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;>;"
    invoke-super {p0, p1}, Lcom/bumptech/glide/GenericRequestBuilder;->transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/GenericRequestBuilder;

    .line 229
    return-object p0
.end method

.method public varargs transform([Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;)Lcom/bumptech/glide/DrawableRequestBuilder;
    .locals 1
    .param p1, "transformations"    # [Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;",
            ")",
            "Lcom/bumptech/glide/DrawableRequestBuilder<",
            "TModelType;>;"
        }
    .end annotation

    .line 164
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->bitmapTransform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 1
    .param p1, "x0"    # [Lcom/bumptech/glide/load/Transformation;

    .line 41
    .local p0, "this":Lcom/bumptech/glide/DrawableRequestBuilder;, "Lcom/bumptech/glide/DrawableRequestBuilder<TModelType;>;"
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/DrawableRequestBuilder;->transform([Lcom/bumptech/glide/load/Transformation;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    return-object v0
.end method
