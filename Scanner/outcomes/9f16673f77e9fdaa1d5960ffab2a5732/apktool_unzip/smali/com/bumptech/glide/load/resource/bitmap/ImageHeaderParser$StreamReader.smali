.class Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser$StreamReader;
.super Ljava/lang/Object;
.source "ImageHeaderParser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "StreamReader"
.end annotation


# instance fields
.field private final is:Ljava/io/InputStream;


# direct methods
.method public constructor <init>(Ljava/io/InputStream;)V
    .locals 0
    .param p1, "is"    # Ljava/io/InputStream;

    .line 329
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 330
    iput-object p1, p0, Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser$StreamReader;->is:Ljava/io/InputStream;

    .line 331
    return-void
.end method


# virtual methods
.method public getByte()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 377
    iget-object v0, p0, Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser$StreamReader;->is:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->read()I

    move-result v0

    return v0
.end method

.method public getUInt16()I
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 334
    iget-object v0, p0, Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser$StreamReader;->is:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->read()I

    move-result v0

    shl-int/lit8 v0, v0, 0x8

    const v1, 0xff00

    and-int/2addr v0, v1

    iget-object v1, p0, Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser$StreamReader;->is:Ljava/io/InputStream;

    invoke-virtual {v1}, Ljava/io/InputStream;->read()I

    move-result v1

    and-int/lit16 v1, v1, 0xff

    or-int/2addr v0, v1

    return v0
.end method

.method public getUInt8()S
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 338
    iget-object v0, p0, Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser$StreamReader;->is:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->read()I

    move-result v0

    and-int/lit16 v0, v0, 0xff

    int-to-short v0, v0

    return v0
.end method

.method public read([B)I
    .locals 4
    .param p1, "buffer"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 368
    array-length v0, p1

    .line 370
    .local v0, "toRead":I
    :goto_0
    if-lez v0, :cond_0

    iget-object v1, p0, Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser$StreamReader;->is:Ljava/io/InputStream;

    array-length v2, p1

    sub-int/2addr v2, v0

    invoke-virtual {v1, p1, v2, v0}, Ljava/io/InputStream;->read([BII)I

    move-result v1

    move v2, v1

    .local v2, "read":I
    const/4 v3, -0x1

    if-eq v1, v3, :cond_0

    .line 371
    sub-int/2addr v0, v2

    goto :goto_0

    .line 370
    .end local v2    # "read":I
    :cond_0
    nop

    .line 373
    array-length v1, p1

    sub-int/2addr v1, v0

    return v1
.end method

.method public skip(J)J
    .locals 9
    .param p1, "total"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 342
    const-wide/16 v0, 0x0

    cmp-long v2, p1, v0

    if-gez v2, :cond_0

    .line 343
    return-wide v0

    .line 346
    :cond_0
    move-wide v2, p1

    .line 347
    .local v2, "toSkip":J
    :goto_0
    cmp-long v4, v2, v0

    if-lez v4, :cond_3

    .line 348
    iget-object v4, p0, Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser$StreamReader;->is:Ljava/io/InputStream;

    invoke-virtual {v4, v2, v3}, Ljava/io/InputStream;->skip(J)J

    move-result-wide v4

    .line 349
    .local v4, "skipped":J
    cmp-long v6, v4, v0

    if-lez v6, :cond_1

    .line 350
    sub-long/2addr v2, v4

    goto :goto_1

    .line 356
    :cond_1
    iget-object v6, p0, Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser$StreamReader;->is:Ljava/io/InputStream;

    invoke-virtual {v6}, Ljava/io/InputStream;->read()I

    move-result v6

    .line 357
    .local v6, "testEofByte":I
    const/4 v7, -0x1

    if-ne v6, v7, :cond_2

    .line 358
    goto :goto_2

    .line 360
    :cond_2
    const-wide/16 v7, 0x1

    sub-long/2addr v2, v7

    .line 363
    .end local v4    # "skipped":J
    .end local v6    # "testEofByte":I
    :goto_1
    goto :goto_0

    .line 347
    :cond_3
    nop

    .line 364
    :goto_2
    sub-long v0, p1, v2

    return-wide v0
.end method
