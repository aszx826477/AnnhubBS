.class public Lcom/bumptech/glide/BitmapTypeRequest;
.super Lcom/bumptech/glide/BitmapRequestBuilder;
.source "BitmapTypeRequest.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<ModelType:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/bumptech/glide/BitmapRequestBuilder<",
        "TModelType;",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field private final fileDescriptorModelLoader:Lcom/bumptech/glide/load/model/ModelLoader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "TModelType;",
            "Landroid/os/ParcelFileDescriptor;",
            ">;"
        }
    .end annotation
.end field

.field private final glide:Lcom/bumptech/glide/Glide;

.field private final optionsApplier:Lcom/bumptech/glide/RequestManager$OptionsApplier;

.field private final streamModelLoader:Lcom/bumptech/glide/load/model/ModelLoader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "TModelType;",
            "Ljava/io/InputStream;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/bumptech/glide/GenericRequestBuilder;Lcom/bumptech/glide/load/model/ModelLoader;Lcom/bumptech/glide/load/model/ModelLoader;Lcom/bumptech/glide/RequestManager$OptionsApplier;)V
    .locals 3
    .param p4, "optionsApplier"    # Lcom/bumptech/glide/RequestManager$OptionsApplier;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/GenericRequestBuilder<",
            "TModelType;***>;",
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "TModelType;",
            "Ljava/io/InputStream;",
            ">;",
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "TModelType;",
            "Landroid/os/ParcelFileDescriptor;",
            ">;",
            "Lcom/bumptech/glide/RequestManager$OptionsApplier;",
            ")V"
        }
    .end annotation

    .line 52
    .local p0, "this":Lcom/bumptech/glide/BitmapTypeRequest;, "Lcom/bumptech/glide/BitmapTypeRequest<TModelType;>;"
    .local p1, "other":Lcom/bumptech/glide/GenericRequestBuilder;, "Lcom/bumptech/glide/GenericRequestBuilder<TModelType;***>;"
    .local p2, "streamModelLoader":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<TModelType;Ljava/io/InputStream;>;"
    .local p3, "fileDescriptorModelLoader":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<TModelType;Landroid/os/ParcelFileDescriptor;>;"
    iget-object v0, p1, Lcom/bumptech/glide/GenericRequestBuilder;->glide:Lcom/bumptech/glide/Glide;

    const-class v1, Landroid/graphics/Bitmap;

    const/4 v2, 0x0

    invoke-static {v0, p2, p3, v1, v2}, Lcom/bumptech/glide/BitmapTypeRequest;->buildProvider(Lcom/bumptech/glide/Glide;Lcom/bumptech/glide/load/model/ModelLoader;Lcom/bumptech/glide/load/model/ModelLoader;Ljava/lang/Class;Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/provider/FixedLoadProvider;

    move-result-object v0

    const-class v1, Landroid/graphics/Bitmap;

    invoke-direct {p0, v0, v1, p1}, Lcom/bumptech/glide/BitmapRequestBuilder;-><init>(Lcom/bumptech/glide/provider/LoadProvider;Ljava/lang/Class;Lcom/bumptech/glide/GenericRequestBuilder;)V

    .line 54
    iput-object p2, p0, Lcom/bumptech/glide/BitmapTypeRequest;->streamModelLoader:Lcom/bumptech/glide/load/model/ModelLoader;

    .line 55
    iput-object p3, p0, Lcom/bumptech/glide/BitmapTypeRequest;->fileDescriptorModelLoader:Lcom/bumptech/glide/load/model/ModelLoader;

    .line 56
    iget-object v0, p1, Lcom/bumptech/glide/GenericRequestBuilder;->glide:Lcom/bumptech/glide/Glide;

    iput-object v0, p0, Lcom/bumptech/glide/BitmapTypeRequest;->glide:Lcom/bumptech/glide/Glide;

    .line 57
    iput-object p4, p0, Lcom/bumptech/glide/BitmapTypeRequest;->optionsApplier:Lcom/bumptech/glide/RequestManager$OptionsApplier;

    .line 58
    return-void
.end method

.method private static buildProvider(Lcom/bumptech/glide/Glide;Lcom/bumptech/glide/load/model/ModelLoader;Lcom/bumptech/glide/load/model/ModelLoader;Ljava/lang/Class;Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/provider/FixedLoadProvider;
    .locals 3
    .param p0, "glide"    # Lcom/bumptech/glide/Glide;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<A:",
            "Ljava/lang/Object;",
            "R:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/bumptech/glide/Glide;",
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "TA;",
            "Ljava/io/InputStream;",
            ">;",
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "TA;",
            "Landroid/os/ParcelFileDescriptor;",
            ">;",
            "Ljava/lang/Class<",
            "TR;>;",
            "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder<",
            "Landroid/graphics/Bitmap;",
            "TR;>;)",
            "Lcom/bumptech/glide/provider/FixedLoadProvider<",
            "TA;",
            "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
            "Landroid/graphics/Bitmap;",
            "TR;>;"
        }
    .end annotation

    .line 33
    .local p1, "streamModelLoader":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<TA;Ljava/io/InputStream;>;"
    .local p2, "fileDescriptorModelLoader":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<TA;Landroid/os/ParcelFileDescriptor;>;"
    .local p3, "transcodedClass":Ljava/lang/Class;, "Ljava/lang/Class<TR;>;"
    .local p4, "transcoder":Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;, "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder<Landroid/graphics/Bitmap;TR;>;"
    if-nez p1, :cond_0

    if-nez p2, :cond_0

    .line 34
    const/4 v0, 0x0

    return-object v0

    .line 33
    :cond_0
    nop

    .line 37
    if-nez p4, :cond_1

    .line 38
    const-class v0, Landroid/graphics/Bitmap;

    invoke-virtual {p0, v0, p3}, Lcom/bumptech/glide/Glide;->buildTranscoder(Ljava/lang/Class;Ljava/lang/Class;)Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;

    move-result-object p4

    goto :goto_0

    .line 37
    :cond_1
    nop

    .line 40
    :goto_0
    const-class v0, Lcom/bumptech/glide/load/model/ImageVideoWrapper;

    const-class v1, Landroid/graphics/Bitmap;

    invoke-virtual {p0, v0, v1}, Lcom/bumptech/glide/Glide;->buildDataProvider(Ljava/lang/Class;Ljava/lang/Class;)Lcom/bumptech/glide/provider/DataLoadProvider;

    move-result-object v0

    .line 42
    .local v0, "loadProvider":Lcom/bumptech/glide/provider/DataLoadProvider;, "Lcom/bumptech/glide/provider/DataLoadProvider<Lcom/bumptech/glide/load/model/ImageVideoWrapper;Landroid/graphics/Bitmap;>;"
    new-instance v1, Lcom/bumptech/glide/load/model/ImageVideoModelLoader;

    invoke-direct {v1, p1, p2}, Lcom/bumptech/glide/load/model/ImageVideoModelLoader;-><init>(Lcom/bumptech/glide/load/model/ModelLoader;Lcom/bumptech/glide/load/model/ModelLoader;)V

    .line 45
    .local v1, "modelLoader":Lcom/bumptech/glide/load/model/ImageVideoModelLoader;, "Lcom/bumptech/glide/load/model/ImageVideoModelLoader<TA;>;"
    new-instance v2, Lcom/bumptech/glide/provider/FixedLoadProvider;

    invoke-direct {v2, v1, p4, v0}, Lcom/bumptech/glide/provider/FixedLoadProvider;-><init>(Lcom/bumptech/glide/load/model/ModelLoader;Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;Lcom/bumptech/glide/provider/DataLoadProvider;)V

    return-object v2
.end method


# virtual methods
.method public toBytes()Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;[B>;"
        }
    .end annotation

    .line 84
    .local p0, "this":Lcom/bumptech/glide/BitmapTypeRequest;, "Lcom/bumptech/glide/BitmapTypeRequest<TModelType;>;"
    new-instance v0, Lcom/bumptech/glide/load/resource/transcode/BitmapBytesTranscoder;

    invoke-direct {v0}, Lcom/bumptech/glide/load/resource/transcode/BitmapBytesTranscoder;-><init>()V

    const-class v1, [B

    invoke-virtual {p0, v0, v1}, Lcom/bumptech/glide/BitmapTypeRequest;->transcode(Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;Ljava/lang/Class;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public toBytes(Landroid/graphics/Bitmap$CompressFormat;I)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 2
    .param p1, "compressFormat"    # Landroid/graphics/Bitmap$CompressFormat;
    .param p2, "quality"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/Bitmap$CompressFormat;",
            "I)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;[B>;"
        }
    .end annotation

    .line 99
    .local p0, "this":Lcom/bumptech/glide/BitmapTypeRequest;, "Lcom/bumptech/glide/BitmapTypeRequest<TModelType;>;"
    new-instance v0, Lcom/bumptech/glide/load/resource/transcode/BitmapBytesTranscoder;

    invoke-direct {v0, p1, p2}, Lcom/bumptech/glide/load/resource/transcode/BitmapBytesTranscoder;-><init>(Landroid/graphics/Bitmap$CompressFormat;I)V

    const-class v1, [B

    invoke-virtual {p0, v0, v1}, Lcom/bumptech/glide/BitmapTypeRequest;->transcode(Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;Ljava/lang/Class;)Lcom/bumptech/glide/BitmapRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public transcode(Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;Ljava/lang/Class;)Lcom/bumptech/glide/BitmapRequestBuilder;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<R:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder<",
            "Landroid/graphics/Bitmap;",
            "TR;>;",
            "Ljava/lang/Class<",
            "TR;>;)",
            "Lcom/bumptech/glide/BitmapRequestBuilder<",
            "TModelType;TR;>;"
        }
    .end annotation

    .line 70
    .local p0, "this":Lcom/bumptech/glide/BitmapTypeRequest;, "Lcom/bumptech/glide/BitmapTypeRequest<TModelType;>;"
    .local p1, "transcoder":Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;, "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder<Landroid/graphics/Bitmap;TR;>;"
    .local p2, "transcodeClass":Ljava/lang/Class;, "Ljava/lang/Class<TR;>;"
    iget-object v0, p0, Lcom/bumptech/glide/BitmapTypeRequest;->optionsApplier:Lcom/bumptech/glide/RequestManager$OptionsApplier;

    new-instance v1, Lcom/bumptech/glide/BitmapRequestBuilder;

    iget-object v2, p0, Lcom/bumptech/glide/BitmapTypeRequest;->glide:Lcom/bumptech/glide/Glide;

    iget-object v3, p0, Lcom/bumptech/glide/BitmapTypeRequest;->streamModelLoader:Lcom/bumptech/glide/load/model/ModelLoader;

    iget-object v4, p0, Lcom/bumptech/glide/BitmapTypeRequest;->fileDescriptorModelLoader:Lcom/bumptech/glide/load/model/ModelLoader;

    invoke-static {v2, v3, v4, p2, p1}, Lcom/bumptech/glide/BitmapTypeRequest;->buildProvider(Lcom/bumptech/glide/Glide;Lcom/bumptech/glide/load/model/ModelLoader;Lcom/bumptech/glide/load/model/ModelLoader;Ljava/lang/Class;Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/provider/FixedLoadProvider;

    move-result-object v2

    invoke-direct {v1, v2, p2, p0}, Lcom/bumptech/glide/BitmapRequestBuilder;-><init>(Lcom/bumptech/glide/provider/LoadProvider;Ljava/lang/Class;Lcom/bumptech/glide/GenericRequestBuilder;)V

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/RequestManager$OptionsApplier;->apply(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/GenericRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/bumptech/glide/BitmapRequestBuilder;

    return-object v0
.end method
