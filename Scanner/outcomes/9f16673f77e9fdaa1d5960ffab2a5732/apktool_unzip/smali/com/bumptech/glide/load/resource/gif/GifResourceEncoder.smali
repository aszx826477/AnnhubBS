.class public Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder;
.super Ljava/lang/Object;
.source "GifResourceEncoder.java"

# interfaces
.implements Lcom/bumptech/glide/load/ResourceEncoder;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/bumptech/glide/load/ResourceEncoder<",
        "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
        ">;"
    }
.end annotation


# static fields
.field private static final FACTORY:Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;

.field private static final TAG:Ljava/lang/String; = "GifEncoder"


# instance fields
.field private final bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

.field private final factory:Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;

.field private final provider:Lcom/bumptech/glide/gifdecoder/GifDecoder$BitmapProvider;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 26
    new-instance v0, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;

    invoke-direct {v0}, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;-><init>()V

    sput-object v0, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder;->FACTORY:Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;

    return-void
.end method

.method public constructor <init>(Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;)V
    .locals 1
    .param p1, "bitmapPool"    # Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    .line 33
    sget-object v0, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder;->FACTORY:Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;

    invoke-direct {p0, p1, v0}, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder;-><init>(Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;)V

    .line 34
    return-void
.end method

.method constructor <init>(Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;)V
    .locals 1
    .param p1, "bitmapPool"    # Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;
    .param p2, "factory"    # Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    iput-object p1, p0, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder;->bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    .line 39
    new-instance v0, Lcom/bumptech/glide/load/resource/gif/GifBitmapProvider;

    invoke-direct {v0, p1}, Lcom/bumptech/glide/load/resource/gif/GifBitmapProvider;-><init>(Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;)V

    iput-object v0, p0, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder;->provider:Lcom/bumptech/glide/gifdecoder/GifDecoder$BitmapProvider;

    .line 40
    iput-object p2, p0, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder;->factory:Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;

    .line 41
    return-void
.end method

.method private decodeHeaders([B)Lcom/bumptech/glide/gifdecoder/GifDecoder;
    .locals 4
    .param p1, "data"    # [B

    .line 101
    iget-object v0, p0, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder;->factory:Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;

    invoke-virtual {v0}, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;->buildParser()Lcom/bumptech/glide/gifdecoder/GifHeaderParser;

    move-result-object v0

    .line 102
    .local v0, "parser":Lcom/bumptech/glide/gifdecoder/GifHeaderParser;
    invoke-virtual {v0, p1}, Lcom/bumptech/glide/gifdecoder/GifHeaderParser;->setData([B)Lcom/bumptech/glide/gifdecoder/GifHeaderParser;

    .line 103
    invoke-virtual {v0}, Lcom/bumptech/glide/gifdecoder/GifHeaderParser;->parseHeader()Lcom/bumptech/glide/gifdecoder/GifHeader;

    move-result-object v1

    .line 105
    .local v1, "header":Lcom/bumptech/glide/gifdecoder/GifHeader;
    iget-object v2, p0, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder;->factory:Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;

    iget-object v3, p0, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder;->provider:Lcom/bumptech/glide/gifdecoder/GifDecoder$BitmapProvider;

    invoke-virtual {v2, v3}, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;->buildDecoder(Lcom/bumptech/glide/gifdecoder/GifDecoder$BitmapProvider;)Lcom/bumptech/glide/gifdecoder/GifDecoder;

    move-result-object v2

    .line 106
    .local v2, "decoder":Lcom/bumptech/glide/gifdecoder/GifDecoder;
    invoke-virtual {v2, v1, p1}, Lcom/bumptech/glide/gifdecoder/GifDecoder;->setData(Lcom/bumptech/glide/gifdecoder/GifHeader;[B)V

    .line 107
    invoke-virtual {v2}, Lcom/bumptech/glide/gifdecoder/GifDecoder;->advance()V

    .line 109
    return-object v2
.end method

.method private getTransformedFrame(Landroid/graphics/Bitmap;Lcom/bumptech/glide/load/Transformation;Lcom/bumptech/glide/load/resource/gif/GifDrawable;)Lcom/bumptech/glide/load/engine/Resource;
    .locals 3
    .param p1, "currentFrame"    # Landroid/graphics/Bitmap;
    .param p3, "drawable"    # Lcom/bumptech/glide/load/resource/gif/GifDrawable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/Bitmap;",
            "Lcom/bumptech/glide/load/Transformation<",
            "Landroid/graphics/Bitmap;",
            ">;",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            ")",
            "Lcom/bumptech/glide/load/engine/Resource<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .line 115
    .local p2, "transformation":Lcom/bumptech/glide/load/Transformation;, "Lcom/bumptech/glide/load/Transformation<Landroid/graphics/Bitmap;>;"
    iget-object v0, p0, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder;->factory:Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;

    iget-object v1, p0, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder;->bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    invoke-virtual {v0, p1, v1}, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;->buildFrameResource(Landroid/graphics/Bitmap;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;)Lcom/bumptech/glide/load/engine/Resource;

    move-result-object v0

    .line 116
    .local v0, "bitmapResource":Lcom/bumptech/glide/load/engine/Resource;, "Lcom/bumptech/glide/load/engine/Resource<Landroid/graphics/Bitmap;>;"
    invoke-virtual {p3}, Lcom/bumptech/glide/load/resource/gif/GifDrawable;->getIntrinsicWidth()I

    move-result v1

    invoke-virtual {p3}, Lcom/bumptech/glide/load/resource/gif/GifDrawable;->getIntrinsicHeight()I

    move-result v2

    invoke-interface {p2, v0, v1, v2}, Lcom/bumptech/glide/load/Transformation;->transform(Lcom/bumptech/glide/load/engine/Resource;II)Lcom/bumptech/glide/load/engine/Resource;

    move-result-object v1

    .line 118
    .local v1, "transformedResource":Lcom/bumptech/glide/load/engine/Resource;, "Lcom/bumptech/glide/load/engine/Resource<Landroid/graphics/Bitmap;>;"
    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 119
    invoke-interface {v0}, Lcom/bumptech/glide/load/engine/Resource;->recycle()V

    goto :goto_0

    .line 118
    :cond_0
    nop

    .line 121
    :goto_0
    return-object v1
.end method

.method private writeDataDirect([BLjava/io/OutputStream;)Z
    .locals 4
    .param p1, "data"    # [B
    .param p2, "os"    # Ljava/io/OutputStream;

    .line 88
    const/4 v0, 0x1

    .line 90
    .local v0, "success":Z
    :try_start_0
    invoke-virtual {p2, p1}, Ljava/io/OutputStream;->write([B)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 96
    goto :goto_1

    .line 91
    :catch_0
    move-exception v1

    .line 92
    .local v1, "e":Ljava/io/IOException;
    const-string v2, "GifEncoder"

    const/4 v3, 0x3

    invoke-static {v2, v3}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 93
    const-string v2, "GifEncoder"

    const-string v3, "Failed to write data to output stream in GifResourceEncoder"

    invoke-static {v2, v3, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 92
    :cond_0
    nop

    .line 95
    :goto_0
    const/4 v0, 0x0

    .line 97
    .end local v1    # "e":Ljava/io/IOException;
    :goto_1
    return v0
.end method


# virtual methods
.method public encode(Lcom/bumptech/glide/load/engine/Resource;Ljava/io/OutputStream;)Z
    .locals 12
    .param p2, "os"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/engine/Resource<",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            ">;",
            "Ljava/io/OutputStream;",
            ")Z"
        }
    .end annotation

    .line 45
    .local p1, "resource":Lcom/bumptech/glide/load/engine/Resource;, "Lcom/bumptech/glide/load/engine/Resource<Lcom/bumptech/glide/load/resource/gif/GifDrawable;>;"
    invoke-static {}, Lcom/bumptech/glide/util/LogTime;->getLogTime()J

    move-result-wide v0

    .line 47
    .local v0, "startTime":J
    invoke-interface {p1}, Lcom/bumptech/glide/load/engine/Resource;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/bumptech/glide/load/resource/gif/GifDrawable;

    .line 48
    .local v2, "drawable":Lcom/bumptech/glide/load/resource/gif/GifDrawable;
    invoke-virtual {v2}, Lcom/bumptech/glide/load/resource/gif/GifDrawable;->getFrameTransformation()Lcom/bumptech/glide/load/Transformation;

    move-result-object v3

    .line 49
    .local v3, "transformation":Lcom/bumptech/glide/load/Transformation;, "Lcom/bumptech/glide/load/Transformation<Landroid/graphics/Bitmap;>;"
    instance-of v4, v3, Lcom/bumptech/glide/load/resource/UnitTransformation;

    if-eqz v4, :cond_0

    .line 50
    invoke-virtual {v2}, Lcom/bumptech/glide/load/resource/gif/GifDrawable;->getData()[B

    move-result-object v4

    invoke-direct {p0, v4, p2}, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder;->writeDataDirect([BLjava/io/OutputStream;)Z

    move-result v4

    return v4

    .line 53
    :cond_0
    invoke-virtual {v2}, Lcom/bumptech/glide/load/resource/gif/GifDrawable;->getData()[B

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder;->decodeHeaders([B)Lcom/bumptech/glide/gifdecoder/GifDecoder;

    move-result-object v4

    .line 55
    .local v4, "decoder":Lcom/bumptech/glide/gifdecoder/GifDecoder;
    iget-object v5, p0, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder;->factory:Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;

    invoke-virtual {v5}, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;->buildEncoder()Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;

    move-result-object v5

    .line 56
    .local v5, "encoder":Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;
    invoke-virtual {v5, p2}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->start(Ljava/io/OutputStream;)Z

    move-result v6

    const/4 v7, 0x0

    if-nez v6, :cond_1

    .line 57
    return v7

    .line 60
    :cond_1
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_0
    invoke-virtual {v4}, Lcom/bumptech/glide/gifdecoder/GifDecoder;->getFrameCount()I

    move-result v8

    if-ge v6, v8, :cond_3

    .line 61
    invoke-virtual {v4}, Lcom/bumptech/glide/gifdecoder/GifDecoder;->getNextFrame()Landroid/graphics/Bitmap;

    move-result-object v8

    .line 62
    .local v8, "currentFrame":Landroid/graphics/Bitmap;
    invoke-direct {p0, v8, v3, v2}, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder;->getTransformedFrame(Landroid/graphics/Bitmap;Lcom/bumptech/glide/load/Transformation;Lcom/bumptech/glide/load/resource/gif/GifDrawable;)Lcom/bumptech/glide/load/engine/Resource;

    move-result-object v9

    .line 64
    .local v9, "transformedResource":Lcom/bumptech/glide/load/engine/Resource;, "Lcom/bumptech/glide/load/engine/Resource<Landroid/graphics/Bitmap;>;"
    :try_start_0
    invoke-interface {v9}, Lcom/bumptech/glide/load/engine/Resource;->get()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/graphics/Bitmap;

    invoke-virtual {v5, v10}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->addFrame(Landroid/graphics/Bitmap;)Z

    move-result v10
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v10, :cond_2

    .line 65
    nop

    .line 73
    invoke-interface {v9}, Lcom/bumptech/glide/load/engine/Resource;->recycle()V

    return v7

    .line 67
    :cond_2
    :try_start_1
    invoke-virtual {v4}, Lcom/bumptech/glide/gifdecoder/GifDecoder;->getCurrentFrameIndex()I

    move-result v10

    .line 68
    .local v10, "currentFrameIndex":I
    invoke-virtual {v4, v10}, Lcom/bumptech/glide/gifdecoder/GifDecoder;->getDelay(I)I

    move-result v11

    .line 69
    .local v11, "delay":I
    invoke-virtual {v5, v11}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->setDelay(I)V

    .line 71
    invoke-virtual {v4}, Lcom/bumptech/glide/gifdecoder/GifDecoder;->advance()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 73
    .end local v10    # "currentFrameIndex":I
    .end local v11    # "delay":I
    invoke-interface {v9}, Lcom/bumptech/glide/load/engine/Resource;->recycle()V

    .line 74
    nop

    .line 60
    .end local v8    # "currentFrame":Landroid/graphics/Bitmap;
    .end local v9    # "transformedResource":Lcom/bumptech/glide/load/engine/Resource;, "Lcom/bumptech/glide/load/engine/Resource<Landroid/graphics/Bitmap;>;"
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 73
    .restart local v8    # "currentFrame":Landroid/graphics/Bitmap;
    .restart local v9    # "transformedResource":Lcom/bumptech/glide/load/engine/Resource;, "Lcom/bumptech/glide/load/engine/Resource<Landroid/graphics/Bitmap;>;"
    :catchall_0
    move-exception v7

    invoke-interface {v9}, Lcom/bumptech/glide/load/engine/Resource;->recycle()V

    throw v7

    .line 60
    .end local v8    # "currentFrame":Landroid/graphics/Bitmap;
    .end local v9    # "transformedResource":Lcom/bumptech/glide/load/engine/Resource;, "Lcom/bumptech/glide/load/engine/Resource<Landroid/graphics/Bitmap;>;"
    :cond_3
    nop

    .line 77
    .end local v6    # "i":I
    invoke-virtual {v5}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->finish()Z

    move-result v6

    .line 79
    .local v6, "result":Z
    const-string v7, "GifEncoder"

    const/4 v8, 0x2

    invoke-static {v7, v8}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 80
    const-string v7, "GifEncoder"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Encoded gif with "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Lcom/bumptech/glide/gifdecoder/GifDecoder;->getFrameCount()I

    move-result v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v9, " frames and "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Lcom/bumptech/glide/load/resource/gif/GifDrawable;->getData()[B

    move-result-object v9

    array-length v9, v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v9, " bytes in "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {v0, v1}, Lcom/bumptech/glide/util/LogTime;->getElapsedMillis(J)D

    move-result-wide v9

    invoke-virtual {v8, v9, v10}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v9, " ms"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 79
    :cond_4
    nop

    .line 84
    :goto_1
    return v6
.end method

.method public bridge synthetic encode(Ljava/lang/Object;Ljava/io/OutputStream;)Z
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/io/OutputStream;

    .line 25
    move-object v0, p1

    check-cast v0, Lcom/bumptech/glide/load/engine/Resource;

    invoke-virtual {p0, v0, p2}, Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder;->encode(Lcom/bumptech/glide/load/engine/Resource;Ljava/io/OutputStream;)Z

    move-result v0

    return v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .line 126
    const-string v0, ""

    return-object v0
.end method
