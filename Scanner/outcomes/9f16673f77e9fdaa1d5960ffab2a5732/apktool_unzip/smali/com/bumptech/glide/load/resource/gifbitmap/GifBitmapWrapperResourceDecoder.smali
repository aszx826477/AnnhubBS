.class public Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;
.super Ljava/lang/Object;
.source "GifBitmapWrapperResourceDecoder.java"

# interfaces
.implements Lcom/bumptech/glide/load/ResourceDecoder;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$ImageTypeParser;,
        Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$BufferedStreamFactory;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/bumptech/glide/load/ResourceDecoder<",
        "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
        "Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;",
        ">;"
    }
.end annotation


# static fields
.field private static final DEFAULT_PARSER:Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$ImageTypeParser;

.field private static final DEFAULT_STREAM_FACTORY:Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$BufferedStreamFactory;

.field static final MARK_LIMIT_BYTES:I = 0x800


# instance fields
.field private final bitmapDecoder:Lcom/bumptech/glide/load/ResourceDecoder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field private final bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

.field private final gifDecoder:Lcom/bumptech/glide/load/ResourceDecoder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Ljava/io/InputStream;",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            ">;"
        }
    .end annotation
.end field

.field private id:Ljava/lang/String;

.field private final parser:Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$ImageTypeParser;

.field private final streamFactory:Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$BufferedStreamFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 23
    new-instance v0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$ImageTypeParser;

    invoke-direct {v0}, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$ImageTypeParser;-><init>()V

    sput-object v0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->DEFAULT_PARSER:Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$ImageTypeParser;

    .line 24
    new-instance v0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$BufferedStreamFactory;

    invoke-direct {v0}, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$BufferedStreamFactory;-><init>()V

    sput-object v0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->DEFAULT_STREAM_FACTORY:Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$BufferedStreamFactory;

    return-void
.end method

.method public constructor <init>(Lcom/bumptech/glide/load/ResourceDecoder;Lcom/bumptech/glide/load/ResourceDecoder;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;)V
    .locals 6
    .param p3, "bitmapPool"    # Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
            "Landroid/graphics/Bitmap;",
            ">;",
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Ljava/io/InputStream;",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            ">;",
            "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;",
            ")V"
        }
    .end annotation

    .line 38
    .local p1, "bitmapDecoder":Lcom/bumptech/glide/load/ResourceDecoder;, "Lcom/bumptech/glide/load/ResourceDecoder<Lcom/bumptech/glide/load/model/ImageVideoWrapper;Landroid/graphics/Bitmap;>;"
    .local p2, "gifDecoder":Lcom/bumptech/glide/load/ResourceDecoder;, "Lcom/bumptech/glide/load/ResourceDecoder<Ljava/io/InputStream;Lcom/bumptech/glide/load/resource/gif/GifDrawable;>;"
    sget-object v4, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->DEFAULT_PARSER:Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$ImageTypeParser;

    sget-object v5, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->DEFAULT_STREAM_FACTORY:Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$BufferedStreamFactory;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-direct/range {v0 .. v5}, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;-><init>(Lcom/bumptech/glide/load/ResourceDecoder;Lcom/bumptech/glide/load/ResourceDecoder;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$ImageTypeParser;Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$BufferedStreamFactory;)V

    .line 39
    return-void
.end method

.method constructor <init>(Lcom/bumptech/glide/load/ResourceDecoder;Lcom/bumptech/glide/load/ResourceDecoder;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$ImageTypeParser;Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$BufferedStreamFactory;)V
    .locals 0
    .param p3, "bitmapPool"    # Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;
    .param p4, "parser"    # Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$ImageTypeParser;
    .param p5, "streamFactory"    # Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$BufferedStreamFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
            "Landroid/graphics/Bitmap;",
            ">;",
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Ljava/io/InputStream;",
            "Lcom/bumptech/glide/load/resource/gif/GifDrawable;",
            ">;",
            "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;",
            "Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$ImageTypeParser;",
            "Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$BufferedStreamFactory;",
            ")V"
        }
    .end annotation

    .line 44
    .local p1, "bitmapDecoder":Lcom/bumptech/glide/load/ResourceDecoder;, "Lcom/bumptech/glide/load/ResourceDecoder<Lcom/bumptech/glide/load/model/ImageVideoWrapper;Landroid/graphics/Bitmap;>;"
    .local p2, "gifDecoder":Lcom/bumptech/glide/load/ResourceDecoder;, "Lcom/bumptech/glide/load/ResourceDecoder<Ljava/io/InputStream;Lcom/bumptech/glide/load/resource/gif/GifDrawable;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    iput-object p1, p0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->bitmapDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    .line 46
    iput-object p2, p0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->gifDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    .line 47
    iput-object p3, p0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    .line 48
    iput-object p4, p0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->parser:Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$ImageTypeParser;

    .line 49
    iput-object p5, p0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->streamFactory:Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$BufferedStreamFactory;

    .line 50
    return-void
.end method

.method private decode(Lcom/bumptech/glide/load/model/ImageVideoWrapper;II[B)Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;
    .locals 1
    .param p1, "source"    # Lcom/bumptech/glide/load/model/ImageVideoWrapper;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .param p4, "bytes"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 70
    invoke-virtual {p1}, Lcom/bumptech/glide/load/model/ImageVideoWrapper;->getStream()Ljava/io/InputStream;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 71
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->decodeStream(Lcom/bumptech/glide/load/model/ImageVideoWrapper;II[B)Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;

    move-result-object v0

    goto :goto_0

    .line 73
    :cond_0
    invoke-direct {p0, p1, p2, p3}, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->decodeBitmapWrapper(Lcom/bumptech/glide/load/model/ImageVideoWrapper;II)Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;

    move-result-object v0

    .line 75
    .local v0, "result":Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;
    :goto_0
    return-object v0
.end method

.method private decodeBitmapWrapper(Lcom/bumptech/glide/load/model/ImageVideoWrapper;II)Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;
    .locals 4
    .param p1, "toDecode"    # Lcom/bumptech/glide/load/model/ImageVideoWrapper;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 119
    const/4 v0, 0x0

    .line 121
    .local v0, "result":Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;
    iget-object v1, p0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->bitmapDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    invoke-interface {v1, p1, p2, p3}, Lcom/bumptech/glide/load/ResourceDecoder;->decode(Ljava/lang/Object;II)Lcom/bumptech/glide/load/engine/Resource;

    move-result-object v1

    .line 122
    .local v1, "bitmapResource":Lcom/bumptech/glide/load/engine/Resource;, "Lcom/bumptech/glide/load/engine/Resource<Landroid/graphics/Bitmap;>;"
    if-eqz v1, :cond_0

    .line 123
    new-instance v2, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;

    const/4 v3, 0x0

    invoke-direct {v2, v1, v3}, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;-><init>(Lcom/bumptech/glide/load/engine/Resource;Lcom/bumptech/glide/load/engine/Resource;)V

    move-object v0, v2

    goto :goto_0

    .line 122
    :cond_0
    nop

    .line 126
    :goto_0
    return-object v0
.end method

.method private decodeGifWrapper(Ljava/io/InputStream;II)Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;
    .locals 7
    .param p1, "bis"    # Ljava/io/InputStream;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 100
    const/4 v0, 0x0

    .line 101
    .local v0, "result":Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;
    iget-object v1, p0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->gifDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    invoke-interface {v1, p1, p2, p3}, Lcom/bumptech/glide/load/ResourceDecoder;->decode(Ljava/lang/Object;II)Lcom/bumptech/glide/load/engine/Resource;

    move-result-object v1

    .line 102
    .local v1, "gifResource":Lcom/bumptech/glide/load/engine/Resource;, "Lcom/bumptech/glide/load/engine/Resource<Lcom/bumptech/glide/load/resource/gif/GifDrawable;>;"
    if-eqz v1, :cond_1

    .line 103
    invoke-interface {v1}, Lcom/bumptech/glide/load/engine/Resource;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/bumptech/glide/load/resource/gif/GifDrawable;

    .line 108
    .local v2, "drawable":Lcom/bumptech/glide/load/resource/gif/GifDrawable;
    invoke-virtual {v2}, Lcom/bumptech/glide/load/resource/gif/GifDrawable;->getFrameCount()I

    move-result v3

    const/4 v4, 0x1

    const/4 v5, 0x0

    if-le v3, v4, :cond_0

    .line 109
    new-instance v3, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;

    invoke-direct {v3, v5, v1}, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;-><init>(Lcom/bumptech/glide/load/engine/Resource;Lcom/bumptech/glide/load/engine/Resource;)V

    move-object v0, v3

    goto :goto_0

    .line 111
    :cond_0
    new-instance v3, Lcom/bumptech/glide/load/resource/bitmap/BitmapResource;

    invoke-virtual {v2}, Lcom/bumptech/glide/load/resource/gif/GifDrawable;->getFirstFrame()Landroid/graphics/Bitmap;

    move-result-object v4

    iget-object v6, p0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    invoke-direct {v3, v4, v6}, Lcom/bumptech/glide/load/resource/bitmap/BitmapResource;-><init>(Landroid/graphics/Bitmap;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;)V

    .line 112
    .local v3, "bitmapResource":Lcom/bumptech/glide/load/engine/Resource;, "Lcom/bumptech/glide/load/engine/Resource<Landroid/graphics/Bitmap;>;"
    new-instance v4, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;

    invoke-direct {v4, v3, v5}, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;-><init>(Lcom/bumptech/glide/load/engine/Resource;Lcom/bumptech/glide/load/engine/Resource;)V

    move-object v0, v4

    goto :goto_0

    .line 102
    .end local v2    # "drawable":Lcom/bumptech/glide/load/resource/gif/GifDrawable;
    .end local v3    # "bitmapResource":Lcom/bumptech/glide/load/engine/Resource;, "Lcom/bumptech/glide/load/engine/Resource<Landroid/graphics/Bitmap;>;"
    :cond_1
    nop

    .line 115
    :goto_0
    return-object v0
.end method

.method private decodeStream(Lcom/bumptech/glide/load/model/ImageVideoWrapper;II[B)Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;
    .locals 5
    .param p1, "source"    # Lcom/bumptech/glide/load/model/ImageVideoWrapper;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .param p4, "bytes"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 80
    iget-object v0, p0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->streamFactory:Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$BufferedStreamFactory;

    invoke-virtual {p1}, Lcom/bumptech/glide/load/model/ImageVideoWrapper;->getStream()Ljava/io/InputStream;

    move-result-object v1

    invoke-virtual {v0, v1, p4}, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$BufferedStreamFactory;->build(Ljava/io/InputStream;[B)Ljava/io/InputStream;

    move-result-object v0

    .line 81
    .local v0, "bis":Ljava/io/InputStream;
    const/16 v1, 0x800

    invoke-virtual {v0, v1}, Ljava/io/InputStream;->mark(I)V

    .line 82
    iget-object v1, p0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->parser:Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$ImageTypeParser;

    invoke-virtual {v1, v0}, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder$ImageTypeParser;->parse(Ljava/io/InputStream;)Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser$ImageType;

    move-result-object v1

    .line 83
    .local v1, "type":Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser$ImageType;
    invoke-virtual {v0}, Ljava/io/InputStream;->reset()V

    .line 85
    const/4 v2, 0x0

    .line 86
    .local v2, "result":Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;
    sget-object v3, Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser$ImageType;->GIF:Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser$ImageType;

    if-ne v1, v3, :cond_0

    .line 87
    invoke-direct {p0, v0, p2, p3}, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->decodeGifWrapper(Ljava/io/InputStream;II)Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;

    move-result-object v2

    goto :goto_0

    .line 86
    :cond_0
    nop

    .line 90
    :goto_0
    if-nez v2, :cond_1

    .line 93
    new-instance v3, Lcom/bumptech/glide/load/model/ImageVideoWrapper;

    invoke-virtual {p1}, Lcom/bumptech/glide/load/model/ImageVideoWrapper;->getFileDescriptor()Landroid/os/ParcelFileDescriptor;

    move-result-object v4

    invoke-direct {v3, v0, v4}, Lcom/bumptech/glide/load/model/ImageVideoWrapper;-><init>(Ljava/io/InputStream;Landroid/os/ParcelFileDescriptor;)V

    .line 94
    .local v3, "forBitmapDecoder":Lcom/bumptech/glide/load/model/ImageVideoWrapper;
    invoke-direct {p0, v3, p2, p3}, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->decodeBitmapWrapper(Lcom/bumptech/glide/load/model/ImageVideoWrapper;II)Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;

    move-result-object v2

    goto :goto_1

    .line 90
    .end local v3    # "forBitmapDecoder":Lcom/bumptech/glide/load/model/ImageVideoWrapper;
    :cond_1
    nop

    .line 96
    :goto_1
    return-object v2
.end method


# virtual methods
.method public decode(Lcom/bumptech/glide/load/model/ImageVideoWrapper;II)Lcom/bumptech/glide/load/engine/Resource;
    .locals 4
    .param p1, "source"    # Lcom/bumptech/glide/load/model/ImageVideoWrapper;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/model/ImageVideoWrapper;",
            "II)",
            "Lcom/bumptech/glide/load/engine/Resource<",
            "Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 56
    invoke-static {}, Lcom/bumptech/glide/util/ByteArrayPool;->get()Lcom/bumptech/glide/util/ByteArrayPool;

    move-result-object v0

    .line 57
    .local v0, "pool":Lcom/bumptech/glide/util/ByteArrayPool;
    invoke-virtual {v0}, Lcom/bumptech/glide/util/ByteArrayPool;->getBytes()[B

    move-result-object v1

    .line 59
    .local v1, "tempBytes":[B
    const/4 v2, 0x0

    .line 61
    .local v2, "wrapper":Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;
    :try_start_0
    invoke-direct {p0, p1, p2, p3, v1}, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->decode(Lcom/bumptech/glide/load/model/ImageVideoWrapper;II[B)Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;

    move-result-object v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-object v2, v3

    .line 63
    invoke-virtual {v0, v1}, Lcom/bumptech/glide/util/ByteArrayPool;->releaseBytes([B)Z

    .line 64
    nop

    .line 65
    if-eqz v2, :cond_0

    new-instance v3, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResource;

    invoke-direct {v3, v2}, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResource;-><init>(Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper;)V

    goto :goto_0

    :cond_0
    const/4 v3, 0x0

    :goto_0
    return-object v3

    .line 63
    :catchall_0
    move-exception v3

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/util/ByteArrayPool;->releaseBytes([B)Z

    throw v3
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

    .line 22
    move-object v0, p1

    check-cast v0, Lcom/bumptech/glide/load/model/ImageVideoWrapper;

    invoke-virtual {p0, v0, p2, p3}, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->decode(Lcom/bumptech/glide/load/model/ImageVideoWrapper;II)Lcom/bumptech/glide/load/engine/Resource;

    move-result-object v0

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 2

    .line 131
    iget-object v0, p0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->id:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 132
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->gifDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    invoke-interface {v1}, Lcom/bumptech/glide/load/ResourceDecoder;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->bitmapDecoder:Lcom/bumptech/glide/load/ResourceDecoder;

    invoke-interface {v1}, Lcom/bumptech/glide/load/ResourceDecoder;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->id:Ljava/lang/String;

    goto :goto_0

    .line 131
    :cond_0
    nop

    .line 134
    :goto_0
    iget-object v0, p0, Lcom/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapperResourceDecoder;->id:Ljava/lang/String;

    return-object v0
.end method
