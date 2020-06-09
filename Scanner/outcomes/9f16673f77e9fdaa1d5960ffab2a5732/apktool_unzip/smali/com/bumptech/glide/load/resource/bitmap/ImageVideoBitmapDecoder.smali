.class public Lcom/bumptech/glide/load/resource/bitmap/ImageVideoBitmapDecoder;
.super Ljava/lang/Object;
.source "ImageVideoBitmapDecoder.java"

# interfaces
.implements Lcom/bumptech/glide/load/ResourceDecoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/bumptech/glide/load/ResourceDecoder<",
        "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "ImageVideoDecoder"


# instance fields
.field private final fileDescriptorDecoder:Lcom/bumptech/glide/load/ResourceDecoder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Landroid/os/ParcelFileDescriptor;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field private final streamDecoder:Lcom/bumptech/glide/load/ResourceDecoder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Ljava/io/InputStream;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/bumptech/glide/load/ResourceDecoder;Lcom/bumptech/glide/load/ResourceDecoder;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Ljava/io/InputStream;",
            "Landroid/graphics/Bitmap;",
            ">;",
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Landroid/os/ParcelFileDescriptor;",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .line 26
    .local p1, "streamDecoder":Lcom/bumptech/glide/load/ResourceDecoder;, "Lcom/bumptech/glide/load/ResourceDecoder<Ljava/io/InputStream;Landroid/graphics/Bitmap;>;"
    .local p2, "fileDescriptorDecoder":Lcom/bumptech/glide/load/ResourceDecoder;, "Lcom/bumptech/glide/load/ResourceDecoder<Landroid/os/ParcelFileDescriptor;Landroid/graphics/Bitmap;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/bumptech/glide/load/resource/bitmap/ImageVideoBitmapDecoder;->streamDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    .line 28
    iput-object p2, p0, Lcom/bumptech/glide/load/resource/bitmap/ImageVideoBitmapDecoder;->fileDescriptorDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    .line 29
    return-void
.end method


# virtual methods
.method public decode(Lcom/bumptech/glide/load/model/ImageVideoWrapper;II)Lcom/bumptech/glide/load/engine/Resource;
    .locals 5
    .param p1, "source"    # Lcom/bumptech/glide/load/model/ImageVideoWrapper;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
            "II)",
            "Lcom/bumptech/glide/load/engine/Resource<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 35
    const/4 v0, 0x0

    .line 36
    .local v0, "result":Lcom/bumptech/glide/load/engine/Resource;, "Lcom/bumptech/glide/load/engine/Resource<Landroid/graphics/Bitmap;>;"
    invoke-virtual {p1}, Lcom/bumptech/glide/load/model/ImageVideoWrapper;->getStream()Ljava/io/InputStream;

    move-result-object v1

    .line 37
    .local v1, "is":Ljava/io/InputStream;
    if-eqz v1, :cond_1

    .line 39
    :try_start_0
    iget-object v2, p0, Lcom/bumptech/glide/load/resource/bitmap/ImageVideoBitmapDecoder;->streamDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    invoke-interface {v2, v1, p2, p3}, Lcom/bumptech/glide/load/ResourceDecoder;->decode(Ljava/lang/Object;II)Lcom/bumptech/glide/load/engine/Resource;

    move-result-object v2
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v0, v2

    .line 44
    goto :goto_0

    .line 40
    :catch_0
    move-exception v2

    .line 41
    .local v2, "e":Ljava/io/IOException;
    const-string v3, "ImageVideoDecoder"

    const/4 v4, 0x2

    invoke-static {v3, v4}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 42
    const-string v3, "ImageVideoDecoder"

    const-string v4, "Failed to load image from stream, trying FileDescriptor"

    invoke-static {v3, v4, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 41
    :cond_0
    goto :goto_0

    .line 37
    .end local v2    # "e":Ljava/io/IOException;
    :cond_1
    nop

    .line 47
    :goto_0
    if-nez v0, :cond_3

    .line 48
    invoke-virtual {p1}, Lcom/bumptech/glide/load/model/ImageVideoWrapper;->getFileDescriptor()Landroid/os/ParcelFileDescriptor;

    move-result-object v2

    .line 49
    .local v2, "fileDescriptor":Landroid/os/ParcelFileDescriptor;
    if-eqz v2, :cond_2

    .line 50
    iget-object v3, p0, Lcom/bumptech/glide/load/resource/bitmap/ImageVideoBitmapDecoder;->fileDescriptorDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    invoke-interface {v3, v2, p2, p3}, Lcom/bumptech/glide/load/ResourceDecoder;->decode(Ljava/lang/Object;II)Lcom/bumptech/glide/load/engine/Resource;

    move-result-object v0

    goto :goto_1

    .line 49
    :cond_2
    goto :goto_1

    .line 47
    .end local v2    # "fileDescriptor":Landroid/os/ParcelFileDescriptor;
    :cond_3
    nop

    .line 53
    :goto_1
    return-object v0
.end method

.method public bridge synthetic decode(Ljava/lang/Object;II)Lcom/bumptech/glide/load/engine/Resource;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # I
    .param p3, "x2"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 20
    move-object v0, p1

    check-cast v0, Lcom/bumptech/glide/load/model/ImageVideoWrapper;

    invoke-virtual {p0, v0, p2, p3}, Lcom/bumptech/glide/load/resource/bitmap/ImageVideoBitmapDecoder;->decode(Lcom/bumptech/glide/load/model/ImageVideoWrapper;II)Lcom/bumptech/glide/load/engine/Resource;

    move-result-object v0

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .line 58
    const-string v0, "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap"

    return-object v0
.end method
