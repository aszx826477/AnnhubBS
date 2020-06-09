.class public Lcom/bumptech/glide/load/data/ExifOrientationStream;
.super Ljava/io/FilterInputStream;
.source "ExifOrientationStream.java"


# static fields
.field private static final EXIF_SEGMENT:[B

.field private static final ORIENTATION_POSITION:I

.field private static final SEGMENT_LENGTH:I

.field private static final SEGMENT_START_POSITION:I = 0x2


# instance fields
.field private final orientation:B

.field private position:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 17
    const/16 v0, 0x1d

    new-array v0, v0, [B

    fill-array-data v0, :array_0

    sput-object v0, Lcom/bumptech/glide/load/data/ExifOrientationStream;->EXIF_SEGMENT:[B

    .line 60
    sget-object v0, Lcom/bumptech/glide/load/data/ExifOrientationStream;->EXIF_SEGMENT:[B

    array-length v0, v0

    sput v0, Lcom/bumptech/glide/load/data/ExifOrientationStream;->SEGMENT_LENGTH:I

    .line 61
    sget v0, Lcom/bumptech/glide/load/data/ExifOrientationStream;->SEGMENT_LENGTH:I

    add-int/lit8 v0, v0, 0x2

    sput v0, Lcom/bumptech/glide/load/data/ExifOrientationStream;->ORIENTATION_POSITION:I

    return-void

    nop

    :array_0
    .array-data 1
        -0x1t
        -0x1ft
        0x0t
        0x1ct
        0x45t
        0x78t
        0x69t
        0x66t
        0x0t
        0x0t
        0x4dt
        0x4dt
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x8t
        0x0t
        0x1t
        0x1t
        0x12t
        0x0t
        0x2t
        0x0t
        0x0t
        0x0t
        0x1t
        0x0t
    .end array-data
.end method

.method public constructor <init>(Ljava/io/InputStream;I)V
    .locals 3
    .param p1, "in"    # Ljava/io/InputStream;
    .param p2, "orientation"    # I

    .line 66
    invoke-direct {p0, p1}, Ljava/io/FilterInputStream;-><init>(Ljava/io/InputStream;)V

    .line 67
    const/4 v0, -0x1

    if-lt p2, v0, :cond_0

    const/16 v0, 0x8

    if-gt p2, v0, :cond_0

    .line 70
    int-to-byte v0, p2

    iput-byte v0, p0, Lcom/bumptech/glide/load/data/ExifOrientationStream;->orientation:B

    .line 71
    return-void

    .line 67
    :cond_0
    nop

    .line 68
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Cannot add invalid orientation: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public mark(I)V
    .locals 1
    .param p1, "readlimit"    # I

    .line 80
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public markSupported()Z
    .locals 1

    .line 75
    const/4 v0, 0x0

    return v0
.end method

.method public read()I
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 86
    iget v0, p0, Lcom/bumptech/glide/load/data/ExifOrientationStream;->position:I

    const/4 v1, 0x2

    if-lt v0, v1, :cond_2

    sget v2, Lcom/bumptech/glide/load/data/ExifOrientationStream;->ORIENTATION_POSITION:I

    if-le v0, v2, :cond_0

    goto :goto_0

    .line 88
    :cond_0
    if-ne v0, v2, :cond_1

    .line 89
    iget-byte v0, p0, Lcom/bumptech/glide/load/data/ExifOrientationStream;->orientation:B

    goto :goto_1

    .line 91
    :cond_1
    sget-object v2, Lcom/bumptech/glide/load/data/ExifOrientationStream;->EXIF_SEGMENT:[B

    sub-int/2addr v0, v1

    aget-byte v0, v2, v0

    and-int/lit16 v0, v0, 0xff

    goto :goto_1

    .line 86
    :cond_2
    :goto_0
    nop

    .line 87
    invoke-super {p0}, Ljava/io/FilterInputStream;->read()I

    move-result v0

    .line 93
    .local v0, "result":I
    :goto_1
    const/4 v1, -0x1

    if-eq v0, v1, :cond_3

    .line 94
    iget v1, p0, Lcom/bumptech/glide/load/data/ExifOrientationStream;->position:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/bumptech/glide/load/data/ExifOrientationStream;->position:I

    goto :goto_2

    .line 93
    :cond_3
    nop

    .line 96
    :goto_2
    return v0
.end method

.method public read([BII)I
    .locals 4
    .param p1, "buffer"    # [B
    .param p2, "byteOffset"    # I
    .param p3, "byteCount"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 102
    iget v0, p0, Lcom/bumptech/glide/load/data/ExifOrientationStream;->position:I

    sget v1, Lcom/bumptech/glide/load/data/ExifOrientationStream;->ORIENTATION_POSITION:I

    if-le v0, v1, :cond_0

    .line 103
    invoke-super {p0, p1, p2, p3}, Ljava/io/FilterInputStream;->read([BII)I

    move-result v0

    goto :goto_0

    .line 104
    :cond_0
    if-ne v0, v1, :cond_1

    .line 105
    iget-byte v0, p0, Lcom/bumptech/glide/load/data/ExifOrientationStream;->orientation:B

    aput-byte v0, p1, p2

    .line 106
    const/4 v0, 0x1

    goto :goto_0

    .line 107
    :cond_1
    const/4 v2, 0x2

    if-ge v0, v2, :cond_2

    .line 108
    sub-int/2addr v2, v0

    invoke-super {p0, p1, p2, v2}, Ljava/io/FilterInputStream;->read([BII)I

    move-result v0

    goto :goto_0

    .line 110
    :cond_2
    sub-int/2addr v1, v0

    invoke-static {v1, p3}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 111
    .local v0, "read":I
    sget-object v1, Lcom/bumptech/glide/load/data/ExifOrientationStream;->EXIF_SEGMENT:[B

    iget v3, p0, Lcom/bumptech/glide/load/data/ExifOrientationStream;->position:I

    sub-int/2addr v3, v2

    invoke-static {v1, v3, p1, p2, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 114
    :goto_0
    if-lez v0, :cond_3

    .line 115
    iget v1, p0, Lcom/bumptech/glide/load/data/ExifOrientationStream;->position:I

    add-int/2addr v1, v0

    iput v1, p0, Lcom/bumptech/glide/load/data/ExifOrientationStream;->position:I

    goto :goto_1

    .line 114
    :cond_3
    nop

    .line 117
    :goto_1
    return v0
.end method

.method public reset()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 131
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public skip(J)J
    .locals 5
    .param p1, "byteCount"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 122
    invoke-super {p0, p1, p2}, Ljava/io/FilterInputStream;->skip(J)J

    move-result-wide v0

    .line 123
    .local v0, "skipped":J
    const-wide/16 v2, 0x0

    cmp-long v4, v0, v2

    if-lez v4, :cond_0

    .line 124
    iget v2, p0, Lcom/bumptech/glide/load/data/ExifOrientationStream;->position:I

    int-to-long v2, v2

    add-long/2addr v2, v0

    long-to-int v3, v2

    iput v3, p0, Lcom/bumptech/glide/load/data/ExifOrientationStream;->position:I

    goto :goto_0

    .line 123
    :cond_0
    nop

    .line 126
    :goto_0
    return-wide v0
.end method
