.class public Lcom/bumptech/glide/GifTypeRequest;
.super Lcom/bumptech/glide/GifRequestBuilder;
.source "GifTypeRequest.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<ModelType:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/bumptech/glide/GifRequestBuilder<",
        "TModelType;>;"
    }
.end annotation


# instance fields
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
.method constructor <init>(Lcom/bumptech/glide/GenericRequestBuilder;Lcom/bumptech/glide/load/model/ModelLoader;Lcom/bumptech/glide/RequestManager$OptionsApplier;)V
    .locals 3
    .param p3, "optionsApplier"    # Lcom/bumptech/glide/RequestManager$OptionsApplier;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/GenericRequestBuilder<",
            "TModelType;***>;",
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "TModelType;",
            "Ljava/io/InputStream;",
            ">;",
            "Lcom/bumptech/glide/RequestManager$OptionsApplier;",
            ")V"
        }
    .end annotation

    .line 41
    .local p0, "this":Lcom/bumptech/glide/GifTypeRequest;, "Lcom/bumptech/glide/GifTypeRequest<TModelType;>;"
    .local p1, "other":Lcom/bumptech/glide/GenericRequestBuilder;, "Lcom/bumptech/glide/GenericRequestBuilder<TModelType;***>;"
    .local p2, "streamModelLoader":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<TModelType;Ljava/io/InputStream;>;"
    iget-object v0, p1, Lcom/bumptech/glide/GenericRequestBuilder;->glide:Lcom/bumptech/glide/Glide;

    const-class v1, Lcom/bumptech/glide/load/resource/gif/GifDrawable;

    const/4 v2, 0x0

    invoke-static {v0, p2, v1, v2}, Lcom/bumptech/glide/GifTypeRequest;->buildProvider(Lcom/bumptech/glide/Glide;Lcom/bumptech/glide/load/model/ModelLoader;Ljava/lang/Class;Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/provider/FixedLoadProvider;

    move-result-object v0

    const-class v1, Lcom/bumptech/glide/load/resource/gif/GifDrawable;

    invoke-direct {p0, v0, v1, p1}, Lcom/bumptech/glide/GifRequestBuilder;-><init>(Lcom/bumptech/glide/provider/LoadProvider;Ljava/lang/Class;Lcom/bumptech/glide/GenericRequestBuilder;)V

    .line 42
    iput-object p2, p0, Lcom/bumptech/glide/GifTypeRequest;->streamModelLoader:Lcom/bumptech/glide/load/model/ModelLoader;

    .line 43
    iput-object p3, p0, Lcom/bumptech/glide/GifTypeRequest;->optionsApplier:Lcom/bumptech/glide/RequestManager$OptionsApplier;

    .line 46
    invoke-virtual {p0}, Lcom/bumptech/glide/GifTypeRequest;->crossFade()Lcom/bumptech/glide/GifRequestBuilder;

    .line 47
    return-void
.end method

.method private static buildProvider(Lcom/bumptech/glide/Glide;Lcom/bumptech/glide/load/model/ModelLoader;Ljava/lang/Class;Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/provider/FixedLoadProvider;
    .locals 2
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
            "Ljava/lang/Class<",
            "TR;>;",
            "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder<",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            "TR;>;)",
            "Lcom/bumptech/glide/provider/FixedLoadProvider<",
            "TA;",
            "Ljava/io/InputStream;",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            "TR;>;"
        }
    .end annotation

    .line 27
    .local p1, "streamModelLoader":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<TA;Ljava/io/InputStream;>;"
    .local p2, "transcodeClass":Ljava/lang/Class;, "Ljava/lang/Class<TR;>;"
    .local p3, "transcoder":Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;, "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder<Lcom/bumptech/glide/load/resource/gif/GifDrawable;TR;>;"
    if-nez p1, :cond_0

    .line 28
    const/4 v0, 0x0

    return-object v0

    .line 31
    :cond_0
    if-nez p3, :cond_1

    .line 32
    const-class v0, Lcom/bumptech/glide/load/resource/gif/GifDrawable;

    invoke-virtual {p0, v0, p2}, Lcom/bumptech/glide/Glide;->buildTranscoder(Ljava/lang/Class;Ljava/lang/Class;)Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;

    move-result-object p3

    goto :goto_0

    .line 31
    :cond_1
    nop

    .line 34
    :goto_0
    const-class v0, Ljava/io/InputStream;

    const-class v1, Lcom/bumptech/glide/load/resource/gif/GifDrawable;

    invoke-virtual {p0, v0, v1}, Lcom/bumptech/glide/Glide;->buildDataProvider(Ljava/lang/Class;Ljava/lang/Class;)Lcom/bumptech/glide/provider/DataLoadProvider;

    move-result-object v0

    .line 36
    .local v0, "dataLoadProvider":Lcom/bumptech/glide/provider/DataLoadProvider;, "Lcom/bumptech/glide/provider/DataLoadProvider<Ljava/io/InputStream;Lcom/bumptech/glide/load/resource/gif/GifDrawable;>;"
    new-instance v1, Lcom/bumptech/glide/provider/FixedLoadProvider;

    invoke-direct {v1, p1, p3, v0}, Lcom/bumptech/glide/provider/FixedLoadProvider;-><init>(Lcom/bumptech/glide/load/model/ModelLoader;Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;Lcom/bumptech/glide/provider/DataLoadProvider;)V

    return-object v1
.end method


# virtual methods
.method public toBytes()Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/bumptech/glide/GenericRequestBuilder<",
            "TModelType;",
            "Ljava/io/InputStream;",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            "[B>;"
        }
    .end annotation

    .line 79
    .local p0, "this":Lcom/bumptech/glide/GifTypeRequest;, "Lcom/bumptech/glide/GifTypeRequest<TModelType;>;"
    new-instance v0, Lcom/bumptech/glide/load/resource/transcode/GifDrawableBytesTranscoder;

    invoke-direct {v0}, Lcom/bumptech/glide/load/resource/transcode/GifDrawableBytesTranscoder;-><init>()V

    const-class v1, [B

    invoke-virtual {p0, v0, v1}, Lcom/bumptech/glide/GifTypeRequest;->transcode(Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;Ljava/lang/Class;)Lcom/bumptech/glide/GenericRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public transcode(Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;Ljava/lang/Class;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<R:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder<",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            "TR;>;",
            "Ljava/lang/Class<",
            "TR;>;)",
            "Lcom/bumptech/glide/GenericRequestBuilder<",
            "TModelType;",
            "Ljava/io/InputStream;",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            "TR;>;"
        }
    .end annotation

    .line 63
    .local p0, "this":Lcom/bumptech/glide/GifTypeRequest;, "Lcom/bumptech/glide/GifTypeRequest<TModelType;>;"
    .local p1, "transcoder":Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;, "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder<Lcom/bumptech/glide/load/resource/gif/GifDrawable;TR;>;"
    .local p2, "transcodeClass":Ljava/lang/Class;, "Ljava/lang/Class<TR;>;"
    iget-object v0, p0, Lcom/bumptech/glide/GifTypeRequest;->glide:Lcom/bumptech/glide/Glide;

    iget-object v1, p0, Lcom/bumptech/glide/GifTypeRequest;->streamModelLoader:Lcom/bumptech/glide/load/model/ModelLoader;

    invoke-static {v0, v1, p2, p1}, Lcom/bumptech/glide/GifTypeRequest;->buildProvider(Lcom/bumptech/glide/Glide;Lcom/bumptech/glide/load/model/ModelLoader;Ljava/lang/Class;Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)Lcom/bumptech/glide/provider/FixedLoadProvider;

    move-result-object v0

    .line 65
    .local v0, "provider":Lcom/bumptech/glide/provider/FixedLoadProvider;, "Lcom/bumptech/glide/provider/FixedLoadProvider<TModelType;Ljava/io/InputStream;Lcom/bumptech/glide/load/resource/gif/GifDrawable;TR;>;"
    iget-object v1, p0, Lcom/bumptech/glide/GifTypeRequest;->optionsApplier:Lcom/bumptech/glide/RequestManager$OptionsApplier;

    new-instance v2, Lcom/bumptech/glide/GenericRequestBuilder;

    invoke-direct {v2, v0, p2, p0}, Lcom/bumptech/glide/GenericRequestBuilder;-><init>(Lcom/bumptech/glide/provider/LoadProvider;Ljava/lang/Class;Lcom/bumptech/glide/GenericRequestBuilder;)V

    invoke-virtual {v1, v2}, Lcom/bumptech/glide/RequestManager$OptionsApplier;->apply(Lcom/bumptech/glide/GenericRequestBuilder;)Lcom/bumptech/glide/GenericRequestBuilder;

    move-result-object v1

    return-object v1
.end method
