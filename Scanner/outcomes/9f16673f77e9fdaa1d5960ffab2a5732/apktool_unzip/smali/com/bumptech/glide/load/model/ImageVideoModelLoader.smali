.class public Lcom/bumptech/glide/load/model/ImageVideoModelLoader;
.super Ljava/lang/Object;
.source "ImageVideoModelLoader.java"

# interfaces
.implements Lcom/bumptech/glide/load/model/ModelLoader;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<A:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/bumptech/glide/load/model/ModelLoader<",
        "TA;",
        "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
        ">;"
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "IVML"


# instance fields
.field private final fileDescriptorLoader:Lcom/bumptech/glide/load/model/ModelLoader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "TA;",
            "Landroid/os/ParcelFileDescriptor;",
            ">;"
        }
    .end annotation
.end field

.field private final streamLoader:Lcom/bumptech/glide/load/model/ModelLoader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "TA;",
            "Ljava/io/InputStream;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/bumptech/glide/load/model/ModelLoader;Lcom/bumptech/glide/load/model/ModelLoader;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "TA;",
            "Ljava/io/InputStream;",
            ">;",
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "TA;",
            "Landroid/os/ParcelFileDescriptor;",
            ">;)V"
        }
    .end annotation

    .line 27
    .local p0, "this":Lcom/bumptech/glide/load/model/ImageVideoModelLoader;, "Lcom/bumptech/glide/load/model/ImageVideoModelLoader<TA;>;"
    .local p1, "streamLoader":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<TA;Ljava/io/InputStream;>;"
    .local p2, "fileDescriptorLoader":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<TA;Landroid/os/ParcelFileDescriptor;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    if-nez p1, :cond_1

    if-eqz p2, :cond_0

    goto :goto_0

    .line 29
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "At least one of streamLoader and fileDescriptorLoader must be non null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 28
    :cond_1
    :goto_0
    nop

    .line 31
    iput-object p1, p0, Lcom/bumptech/glide/load/model/ImageVideoModelLoader;->streamLoader:Lcom/bumptech/glide/load/model/ModelLoader;

    .line 32
    iput-object p2, p0, Lcom/bumptech/glide/load/model/ImageVideoModelLoader;->fileDescriptorLoader:Lcom/bumptech/glide/load/model/ModelLoader;

    .line 33
    return-void
.end method


# virtual methods
.method public getResourceFetcher(Ljava/lang/Object;II)Lcom/bumptech/glide/load/data/DataFetcher;
    .locals 3
    .param p2, "width"    # I
    .param p3, "height"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TA;II)",
            "Lcom/bumptech/glide/load/data/DataFetcher<",
            "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
            ">;"
        }
    .end annotation

    .line 37
    .local p0, "this":Lcom/bumptech/glide/load/model/ImageVideoModelLoader;, "Lcom/bumptech/glide/load/model/ImageVideoModelLoader<TA;>;"
    .local p1, "model":Ljava/lang/Object;, "TA;"
    const/4 v0, 0x0

    .line 38
    .local v0, "streamFetcher":Lcom/bumptech/glide/load/data/DataFetcher;, "Lcom/bumptech/glide/load/data/DataFetcher<Ljava/io/InputStream;>;"
    iget-object v1, p0, Lcom/bumptech/glide/load/model/ImageVideoModelLoader;->streamLoader:Lcom/bumptech/glide/load/model/ModelLoader;

    if-eqz v1, :cond_0

    .line 39
    invoke-interface {v1, p1, p2, p3}, Lcom/bumptech/glide/load/model/ModelLoader;->getResourceFetcher(Ljava/lang/Object;II)Lcom/bumptech/glide/load/data/DataFetcher;

    move-result-object v0

    goto :goto_0

    .line 38
    :cond_0
    nop

    .line 41
    :goto_0
    const/4 v1, 0x0

    .line 42
    .local v1, "fileDescriptorFetcher":Lcom/bumptech/glide/load/data/DataFetcher;, "Lcom/bumptech/glide/load/data/DataFetcher<Landroid/os/ParcelFileDescriptor;>;"
    iget-object v2, p0, Lcom/bumptech/glide/load/model/ImageVideoModelLoader;->fileDescriptorLoader:Lcom/bumptech/glide/load/model/ModelLoader;

    if-eqz v2, :cond_1

    .line 43
    invoke-interface {v2, p1, p2, p3}, Lcom/bumptech/glide/load/model/ModelLoader;->getResourceFetcher(Ljava/lang/Object;II)Lcom/bumptech/glide/load/data/DataFetcher;

    move-result-object v1

    goto :goto_1

    .line 42
    :cond_1
    nop

    .line 46
    :goto_1
    if-nez v0, :cond_3

    if-eqz v1, :cond_2

    goto :goto_2

    .line 49
    :cond_2
    const/4 v2, 0x0

    return-object v2

    .line 46
    :cond_3
    :goto_2
    nop

    .line 47
    new-instance v2, Lcom/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher;

    invoke-direct {v2, v0, v1}, Lcom/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher;-><init>(Lcom/bumptech/glide/load/data/DataFetcher;Lcom/bumptech/glide/load/data/DataFetcher;)V

    return-object v2
.end method
