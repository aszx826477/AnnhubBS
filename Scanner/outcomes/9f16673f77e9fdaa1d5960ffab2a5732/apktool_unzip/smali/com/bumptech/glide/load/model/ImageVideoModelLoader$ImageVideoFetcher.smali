.class Lcom/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher;
.super Ljava/lang/Object;
.source "ImageVideoModelLoader.java"

# interfaces
.implements Lcom/bumptech/glide/load/data/DataFetcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bumptech/glide/load/model/ImageVideoModelLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ImageVideoFetcher"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/bumptech/glide/load/data/DataFetcher<",
        "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
        ">;"
    }
.end annotation


# instance fields
.field private final fileDescriptorFetcher:Lcom/bumptech/glide/load/data/DataFetcher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/load/data/DataFetcher<",
            "Landroid/os/ParcelFileDescriptor;",
            ">;"
        }
    .end annotation
.end field

.field private final streamFetcher:Lcom/bumptech/glide/load/data/DataFetcher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/load/data/DataFetcher<",
            "Ljava/io/InputStream;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/bumptech/glide/load/data/DataFetcher;Lcom/bumptech/glide/load/data/DataFetcher;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/data/DataFetcher<",
            "Ljava/io/InputStream;",
            ">;",
            "Lcom/bumptech/glide/load/data/DataFetcher<",
            "Landroid/os/ParcelFileDescriptor;",
            ">;)V"
        }
    .end annotation

    .line 58
    .local p1, "streamFetcher":Lcom/bumptech/glide/load/data/DataFetcher;, "Lcom/bumptech/glide/load/data/DataFetcher<Ljava/io/InputStream;>;"
    .local p2, "fileDescriptorFetcher":Lcom/bumptech/glide/load/data/DataFetcher;, "Lcom/bumptech/glide/load/data/DataFetcher<Landroid/os/ParcelFileDescriptor;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    iput-object p1, p0, Lcom/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher;->streamFetcher:Lcom/bumptech/glide/load/data/DataFetcher;

    .line 60
    iput-object p2, p0, Lcom/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher;->fileDescriptorFetcher:Lcom/bumptech/glide/load/data/DataFetcher;

    .line 61
    return-void
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .line 119
    iget-object v0, p0, Lcom/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher;->streamFetcher:Lcom/bumptech/glide/load/data/DataFetcher;

    if-eqz v0, :cond_0

    .line 120
    invoke-interface {v0}, Lcom/bumptech/glide/load/data/DataFetcher;->cancel()V

    goto :goto_0

    .line 119
    :cond_0
    nop

    .line 122
    :goto_0
    iget-object v0, p0, Lcom/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher;->fileDescriptorFetcher:Lcom/bumptech/glide/load/data/DataFetcher;

    if-eqz v0, :cond_1

    .line 123
    invoke-interface {v0}, Lcom/bumptech/glide/load/data/DataFetcher;->cancel()V

    goto :goto_1

    .line 122
    :cond_1
    nop

    .line 125
    :goto_1
    return-void
.end method

.method public cleanup()V
    .locals 1

    .line 99
    iget-object v0, p0, Lcom/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher;->streamFetcher:Lcom/bumptech/glide/load/data/DataFetcher;

    if-eqz v0, :cond_0

    .line 100
    invoke-interface {v0}, Lcom/bumptech/glide/load/data/DataFetcher;->cleanup()V

    goto :goto_0

    .line 99
    :cond_0
    nop

    .line 102
    :goto_0
    iget-object v0, p0, Lcom/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher;->fileDescriptorFetcher:Lcom/bumptech/glide/load/data/DataFetcher;

    if-eqz v0, :cond_1

    .line 103
    invoke-interface {v0}, Lcom/bumptech/glide/load/data/DataFetcher;->cleanup()V

    goto :goto_1

    .line 102
    :cond_1
    nop

    .line 105
    :goto_1
    return-void
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .line 110
    iget-object v0, p0, Lcom/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher;->streamFetcher:Lcom/bumptech/glide/load/data/DataFetcher;

    if-eqz v0, :cond_0

    .line 111
    invoke-interface {v0}, Lcom/bumptech/glide/load/data/DataFetcher;->getId()Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 113
    :cond_0
    iget-object v0, p0, Lcom/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher;->fileDescriptorFetcher:Lcom/bumptech/glide/load/data/DataFetcher;

    invoke-interface {v0}, Lcom/bumptech/glide/load/data/DataFetcher;->getId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public loadData(Lcom/bumptech/glide/Priority;)Lcom/bumptech/glide/load/model/ImageVideoWrapper;
    .locals 5
    .param p1, "priority"    # Lcom/bumptech/glide/Priority;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 67
    const/4 v0, 0x0

    .line 68
    .local v0, "is":Ljava/io/InputStream;
    iget-object v1, p0, Lcom/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher;->streamFetcher:Lcom/bumptech/glide/load/data/DataFetcher;

    const/4 v2, 0x2

    if-eqz v1, :cond_2

    .line 70
    nop

    :try_start_0
    invoke-interface {v1, p1}, Lcom/bumptech/glide/load/data/DataFetcher;->loadData(Lcom/bumptech/glide/Priority;)Ljava/lang/Object;

    move-result-object v1

    nop

    check-cast v1, Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    nop

    move-object v0, v1

    .line 78
    nop

    goto :goto_1

    .line 71
    :catch_0
    move-exception v1

    nop

    .line 72
    .local v1, "e":Ljava/lang/Exception;
    nop

    const-string v3, "IVML"

    invoke-static {v3, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 73
    nop

    const-string v3, "IVML"

    const-string v4, "Exception fetching input stream, trying ParcelFileDescriptor"

    invoke-static {v3, v4, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 72
    :cond_0
    nop

    .line 75
    :goto_0
    nop

    iget-object v3, p0, Lcom/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher;->fileDescriptorFetcher:Lcom/bumptech/glide/load/data/DataFetcher;

    if-eqz v3, :cond_1

    nop

    goto :goto_1

    .line 76
    :cond_1
    nop

    throw v1

    .line 68
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_2
    nop

    .line 80
    :goto_1
    nop

    const/4 v1, 0x0

    .line 81
    .local v1, "fileDescriptor":Landroid/os/ParcelFileDescriptor;
    nop

    iget-object v3, p0, Lcom/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher;->fileDescriptorFetcher:Lcom/bumptech/glide/load/data/DataFetcher;

    if-eqz v3, :cond_5

    .line 83
    nop

    nop

    :try_start_1
    invoke-interface {v3, p1}, Lcom/bumptech/glide/load/data/DataFetcher;->loadData(Lcom/bumptech/glide/Priority;)Ljava/lang/Object;

    move-result-object v3

    nop

    check-cast v3, Landroid/os/ParcelFileDescriptor;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    nop

    move-object v1, v3

    .line 91
    nop

    goto :goto_3

    .line 84
    :catch_1
    move-exception v3

    nop

    .line 85
    .local v3, "e":Ljava/lang/Exception;
    nop

    const-string v4, "IVML"

    invoke-static {v4, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 86
    nop

    const-string v2, "IVML"

    const-string v4, "Exception fetching ParcelFileDescriptor"

    invoke-static {v2, v4, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_2

    .line 85
    :cond_3
    nop

    .line 88
    :goto_2
    nop

    if-eqz v0, :cond_4

    nop

    goto :goto_3

    .line 89
    :cond_4
    nop

    throw v3

    .line 81
    .end local v3    # "e":Ljava/lang/Exception;
    :cond_5
    nop

    .line 93
    :goto_3
    nop

    new-instance v2, Lcom/bumptech/glide/load/model/ImageVideoWrapper;

    invoke-direct {v2, v0, v1}, Lcom/bumptech/glide/load/model/ImageVideoWrapper;-><init>(Ljava/io/InputStream;Landroid/os/ParcelFileDescriptor;)V

    return-object v2
.end method

.method public bridge synthetic loadData(Lcom/bumptech/glide/Priority;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lcom/bumptech/glide/Priority;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 53
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher;->loadData(Lcom/bumptech/glide/Priority;)Lcom/bumptech/glide/load/model/ImageVideoWrapper;

    move-result-object v0

    return-object v0
.end method
