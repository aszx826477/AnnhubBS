.class public Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;
.super Ljava/lang/Object;
.source "AnimatedGifEncoder.java"


# static fields
.field private static final MIN_TRANSPARENT_PERCENTAGE:D = 4.0

.field private static final TAG:Ljava/lang/String; = "AnimatedGifEncoder"


# instance fields
.field private closeStream:Z

.field private colorDepth:I

.field private colorTab:[B

.field private delay:I

.field private dispose:I

.field private firstFrame:Z

.field private hasTransparentPixels:Z

.field private height:I

.field private image:Landroid/graphics/Bitmap;

.field private indexedPixels:[B

.field private out:Ljava/io/OutputStream;

.field private palSize:I

.field private pixels:[B

.field private repeat:I

.field private sample:I

.field private sizeSet:Z

.field private started:Z

.field private transIndex:I

.field private transparent:Ljava/lang/Integer;

.field private usedEntry:[Z

.field private width:I


# direct methods
.method public constructor <init>()V
    .locals 3

    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->transparent:Ljava/lang/Integer;

    .line 52
    const/4 v0, -0x1

    iput v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->repeat:I

    .line 54
    const/4 v1, 0x0

    iput v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->delay:I

    .line 56
    iput-boolean v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->started:Z

    .line 70
    const/16 v2, 0x100

    new-array v2, v2, [Z

    iput-object v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->usedEntry:[Z

    .line 72
    const/4 v2, 0x7

    iput v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->palSize:I

    .line 74
    iput v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->dispose:I

    .line 76
    iput-boolean v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->closeStream:Z

    .line 78
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->firstFrame:Z

    .line 80
    iput-boolean v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->sizeSet:Z

    .line 82
    const/16 v0, 0xa

    iput v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->sample:I

    return-void
.end method

.method private analyzePixels()V
    .locals 10

    .line 311
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->pixels:[B

    array-length v1, v0

    .line 312
    .local v1, "len":I
    div-int/lit8 v2, v1, 0x3

    .line 313
    .local v2, "nPix":I
    new-array v3, v2, [B

    iput-object v3, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->indexedPixels:[B

    .line 314
    new-instance v3, Lcom/bumptech/glide/gifencoder/NeuQuant;

    iget v4, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->sample:I

    invoke-direct {v3, v0, v1, v4}, Lcom/bumptech/glide/gifencoder/NeuQuant;-><init>([BII)V

    move-object v0, v3

    .line 316
    .local v0, "nq":Lcom/bumptech/glide/gifencoder/NeuQuant;
    invoke-virtual {v0}, Lcom/bumptech/glide/gifencoder/NeuQuant;->process()[B

    move-result-object v3

    iput-object v3, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->colorTab:[B

    .line 318
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    iget-object v4, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->colorTab:[B

    array-length v5, v4

    const/4 v6, 0x0

    if-ge v3, v5, :cond_0

    .line 319
    aget-byte v5, v4, v3

    .line 320
    .local v5, "temp":B
    add-int/lit8 v7, v3, 0x2

    aget-byte v7, v4, v7

    aput-byte v7, v4, v3

    .line 321
    add-int/lit8 v7, v3, 0x2

    aput-byte v5, v4, v7

    .line 322
    iget-object v4, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->usedEntry:[Z

    div-int/lit8 v7, v3, 0x3

    aput-boolean v6, v4, v7

    .line 318
    .end local v5    # "temp":B
    add-int/lit8 v3, v3, 0x3

    goto :goto_0

    .line 325
    .end local v3    # "i":I
    :cond_0
    const/4 v3, 0x0

    .line 326
    .local v3, "k":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_1
    if-ge v4, v2, :cond_1

    .line 327
    iget-object v5, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->pixels:[B

    add-int/lit8 v7, v3, 0x1

    .end local v3    # "k":I
    .local v7, "k":I
    aget-byte v3, v5, v3

    and-int/lit16 v3, v3, 0xff

    add-int/lit8 v8, v7, 0x1

    .end local v7    # "k":I
    .local v8, "k":I
    aget-byte v7, v5, v7

    and-int/lit16 v7, v7, 0xff

    add-int/lit8 v9, v8, 0x1

    .end local v8    # "k":I
    .local v9, "k":I
    aget-byte v5, v5, v8

    and-int/lit16 v5, v5, 0xff

    invoke-virtual {v0, v3, v7, v5}, Lcom/bumptech/glide/gifencoder/NeuQuant;->map(III)I

    move-result v3

    .line 328
    .local v3, "index":I
    iget-object v5, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->usedEntry:[Z

    const/4 v7, 0x1

    aput-boolean v7, v5, v3

    .line 329
    iget-object v5, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->indexedPixels:[B

    int-to-byte v7, v3

    aput-byte v7, v5, v4

    .line 326
    .end local v3    # "index":I
    add-int/lit8 v4, v4, 0x1

    move v3, v9

    goto :goto_1

    .line 331
    .end local v4    # "i":I
    .end local v9    # "k":I
    .local v3, "k":I
    :cond_1
    const/4 v4, 0x0

    iput-object v4, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->pixels:[B

    .line 332
    const/16 v4, 0x8

    iput v4, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->colorDepth:I

    .line 333
    const/4 v4, 0x7

    iput v4, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->palSize:I

    .line 335
    iget-object v4, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->transparent:Ljava/lang/Integer;

    if-eqz v4, :cond_2

    .line 336
    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-direct {p0, v4}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->findClosest(I)I

    move-result v4

    iput v4, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->transIndex:I

    goto :goto_2

    .line 337
    :cond_2
    iget-boolean v4, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->hasTransparentPixels:Z

    if-eqz v4, :cond_3

    .line 338
    invoke-direct {p0, v6}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->findClosest(I)I

    move-result v4

    iput v4, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->transIndex:I

    goto :goto_2

    .line 337
    :cond_3
    nop

    .line 340
    :goto_2
    return-void
.end method

.method private findClosest(I)I
    .locals 13
    .param p1, "color"    # I

    .line 347
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->colorTab:[B

    if-nez v0, :cond_0

    .line 348
    const/4 v0, -0x1

    return v0

    .line 349
    :cond_0
    invoke-static {p1}, Landroid/graphics/Color;->red(I)I

    move-result v0

    .line 350
    .local v0, "r":I
    invoke-static {p1}, Landroid/graphics/Color;->green(I)I

    move-result v1

    .line 351
    .local v1, "g":I
    invoke-static {p1}, Landroid/graphics/Color;->blue(I)I

    move-result v2

    .line 352
    .local v2, "b":I
    const/4 v3, 0x0

    .line 353
    .local v3, "minpos":I
    const/high16 v4, 0x1000000

    .line 354
    .local v4, "dmin":I
    iget-object v5, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->colorTab:[B

    array-length v5, v5

    .line 355
    .local v5, "len":I
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_0
    if-ge v6, v5, :cond_2

    .line 356
    iget-object v7, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->colorTab:[B

    add-int/lit8 v8, v6, 0x1

    .end local v6    # "i":I
    .local v8, "i":I
    aget-byte v6, v7, v6

    and-int/lit16 v6, v6, 0xff

    sub-int v6, v0, v6

    .line 357
    .local v6, "dr":I
    add-int/lit8 v9, v8, 0x1

    .end local v8    # "i":I
    .local v9, "i":I
    aget-byte v8, v7, v8

    and-int/lit16 v8, v8, 0xff

    sub-int v8, v1, v8

    .line 358
    .local v8, "dg":I
    aget-byte v7, v7, v9

    and-int/lit16 v7, v7, 0xff

    sub-int v7, v2, v7

    .line 359
    .local v7, "db":I
    mul-int v10, v6, v6

    mul-int v11, v8, v8

    add-int/2addr v10, v11

    mul-int v11, v7, v7

    add-int/2addr v10, v11

    .line 360
    .local v10, "d":I
    div-int/lit8 v11, v9, 0x3

    .line 361
    .local v11, "index":I
    iget-object v12, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->usedEntry:[Z

    aget-boolean v12, v12, v11

    if-eqz v12, :cond_1

    if-ge v10, v4, :cond_1

    .line 362
    move v4, v10

    .line 363
    move v3, v11

    goto :goto_1

    .line 361
    :cond_1
    nop

    .line 365
    :goto_1
    nop

    .end local v6    # "dr":I
    .end local v7    # "db":I
    .end local v8    # "dg":I
    .end local v10    # "d":I
    .end local v11    # "index":I
    add-int/lit8 v6, v9, 0x1

    .line 366
    .end local v9    # "i":I
    .local v6, "i":I
    goto :goto_0

    .line 355
    :cond_2
    nop

    .line 367
    .end local v6    # "i":I
    return v3
.end method

.method private getImagePixels()V
    .locals 14

    .line 374
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->image:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    .line 375
    .local v0, "w":I
    iget-object v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->image:Landroid/graphics/Bitmap;

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v9

    .line 377
    .local v9, "h":I
    iget v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->width:I

    if-ne v0, v1, :cond_1

    iget v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->height:I

    if-eq v9, v1, :cond_0

    goto :goto_0

    :cond_0
    goto :goto_1

    .line 379
    :cond_1
    :goto_0
    iget v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->width:I

    iget v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->height:I

    sget-object v3, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v1, v2, v3}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 380
    .local v1, "temp":Landroid/graphics/Bitmap;
    new-instance v2, Landroid/graphics/Canvas;

    invoke-direct {v2, v1}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 381
    .local v2, "canvas":Landroid/graphics/Canvas;
    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v2, v1, v4, v4, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 382
    iput-object v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->image:Landroid/graphics/Bitmap;

    .line 384
    .end local v1    # "temp":Landroid/graphics/Bitmap;
    .end local v2    # "canvas":Landroid/graphics/Canvas;
    :goto_1
    mul-int v1, v0, v9

    new-array v10, v1, [I

    .line 385
    .local v10, "pixelsInt":[I
    iget-object v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->image:Landroid/graphics/Bitmap;

    const/4 v3, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v2, v10

    move v4, v0

    move v7, v0

    move v8, v9

    invoke-virtual/range {v1 .. v8}, Landroid/graphics/Bitmap;->getPixels([IIIIIII)V

    .line 388
    array-length v1, v10

    const/4 v2, 0x3

    mul-int/lit8 v1, v1, 0x3

    new-array v1, v1, [B

    iput-object v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->pixels:[B

    .line 390
    const/4 v1, 0x0

    .line 391
    .local v1, "pixelsIndex":I
    iput-boolean v3, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->hasTransparentPixels:Z

    .line 392
    const/4 v4, 0x0

    .line 393
    .local v4, "totalTransparentPixels":I
    move-object v5, v10

    .local v5, "arr$":[I
    array-length v6, v5

    .local v6, "len$":I
    const/4 v7, 0x0

    .local v7, "i$":I
    :goto_2
    if-ge v7, v6, :cond_3

    aget v8, v5, v7

    .line 394
    .local v8, "pixel":I
    if-nez v8, :cond_2

    .line 395
    add-int/lit8 v4, v4, 0x1

    goto :goto_3

    .line 394
    :cond_2
    nop

    .line 397
    :goto_3
    iget-object v11, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->pixels:[B

    add-int/lit8 v12, v1, 0x1

    .end local v1    # "pixelsIndex":I
    .local v12, "pixelsIndex":I
    and-int/lit16 v13, v8, 0xff

    int-to-byte v13, v13

    aput-byte v13, v11, v1

    .line 398
    add-int/lit8 v1, v12, 0x1

    .end local v12    # "pixelsIndex":I
    .restart local v1    # "pixelsIndex":I
    shr-int/lit8 v13, v8, 0x8

    and-int/lit16 v13, v13, 0xff

    int-to-byte v13, v13

    aput-byte v13, v11, v12

    .line 399
    add-int/lit8 v12, v1, 0x1

    .end local v1    # "pixelsIndex":I
    .restart local v12    # "pixelsIndex":I
    shr-int/lit8 v13, v8, 0x10

    and-int/lit16 v13, v13, 0xff

    int-to-byte v13, v13

    aput-byte v13, v11, v1

    .line 393
    .end local v8    # "pixel":I
    add-int/lit8 v7, v7, 0x1

    move v1, v12

    goto :goto_2

    .line 402
    .end local v5    # "arr$":[I
    .end local v6    # "len$":I
    .end local v7    # "i$":I
    .end local v12    # "pixelsIndex":I
    .restart local v1    # "pixelsIndex":I
    :cond_3
    mul-int/lit8 v5, v4, 0x64

    int-to-double v5, v5

    array-length v7, v10

    int-to-double v7, v7

    invoke-static {v5, v6}, Ljava/lang/Double;->isNaN(D)Z

    invoke-static {v7, v8}, Ljava/lang/Double;->isNaN(D)Z

    div-double/2addr v5, v7

    .line 405
    .local v5, "transparentPercentage":D
    const-wide/high16 v7, 0x4010000000000000L    # 4.0

    cmpl-double v11, v5, v7

    if-lez v11, :cond_4

    const/4 v3, 0x1

    nop

    :cond_4
    iput-boolean v3, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->hasTransparentPixels:Z

    .line 406
    const-string v3, "AnimatedGifEncoder"

    invoke-static {v3, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 407
    const-string v2, "AnimatedGifEncoder"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "got pixels for frame with "

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v5, v6}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v7, "% transparent pixels"

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_4

    .line 406
    :cond_5
    nop

    .line 409
    :goto_4
    return-void
.end method

.method private writeGraphicCtrlExt()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 415
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    const/16 v1, 0x21

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write(I)V

    .line 416
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    const/16 v1, 0xf9

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write(I)V

    .line 417
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write(I)V

    .line 419
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->transparent:Ljava/lang/Integer;

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->hasTransparentPixels:Z

    if-nez v0, :cond_0

    .line 420
    const/4 v0, 0x0

    .line 421
    .local v0, "transp":I
    const/4 v1, 0x0

    goto :goto_0

    .line 419
    .end local v0    # "transp":I
    :cond_0
    nop

    .line 423
    const/4 v0, 0x1

    .line 424
    .restart local v0    # "transp":I
    const/4 v1, 0x2

    .line 426
    .local v1, "disp":I
    :goto_0
    iget v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->dispose:I

    if-ltz v2, :cond_1

    .line 427
    and-int/lit8 v1, v2, 0x7

    goto :goto_1

    .line 426
    :cond_1
    nop

    .line 429
    :goto_1
    shl-int/lit8 v1, v1, 0x2

    .line 432
    iget-object v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    or-int/lit8 v3, v1, 0x0

    const/4 v4, 0x0

    or-int/2addr v3, v4

    or-int/2addr v3, v0

    invoke-virtual {v2, v3}, Ljava/io/OutputStream;->write(I)V

    .line 437
    iget v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->delay:I

    invoke-direct {p0, v2}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->writeShort(I)V

    .line 438
    iget-object v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    iget v3, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->transIndex:I

    invoke-virtual {v2, v3}, Ljava/io/OutputStream;->write(I)V

    .line 439
    iget-object v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    invoke-virtual {v2, v4}, Ljava/io/OutputStream;->write(I)V

    .line 440
    return-void
.end method

.method private writeImageDesc()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 446
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    const/16 v1, 0x2c

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write(I)V

    .line 447
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->writeShort(I)V

    .line 448
    invoke-direct {p0, v0}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->writeShort(I)V

    .line 449
    iget v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->width:I

    invoke-direct {p0, v1}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->writeShort(I)V

    .line 450
    iget v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->height:I

    invoke-direct {p0, v1}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->writeShort(I)V

    .line 452
    iget-boolean v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->firstFrame:Z

    if-eqz v1, :cond_0

    .line 454
    iget-object v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    invoke-virtual {v1, v0}, Ljava/io/OutputStream;->write(I)V

    goto :goto_0

    .line 457
    :cond_0
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    iget v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->palSize:I

    or-int/lit16 v1, v1, 0x80

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write(I)V

    .line 463
    :goto_0
    return-void
.end method

.method private writeLSD()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 470
    iget v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->width:I

    invoke-direct {p0, v0}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->writeShort(I)V

    .line 471
    iget v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->height:I

    invoke-direct {p0, v0}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->writeShort(I)V

    .line 473
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    iget v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->palSize:I

    or-int/lit16 v1, v1, 0xf0

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write(I)V

    .line 478
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write(I)V

    .line 479
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write(I)V

    .line 480
    return-void
.end method

.method private writeNetscapeExt()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 486
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    const/16 v1, 0x21

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write(I)V

    .line 487
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    const/16 v1, 0xff

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write(I)V

    .line 488
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    const/16 v1, 0xb

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write(I)V

    .line 489
    const-string v0, "NETSCAPE2.0"

    invoke-direct {p0, v0}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->writeString(Ljava/lang/String;)V

    .line 490
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write(I)V

    .line 491
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write(I)V

    .line 492
    iget v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->repeat:I

    invoke-direct {p0, v0}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->writeShort(I)V

    .line 493
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write(I)V

    .line 494
    return-void
.end method

.method private writePalette()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 500
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    iget-object v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->colorTab:[B

    array-length v2, v1

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v3, v2}, Ljava/io/OutputStream;->write([BII)V

    .line 501
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->colorTab:[B

    array-length v0, v0

    rsub-int v0, v0, 0x300

    .line 502
    .local v0, "n":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 503
    iget-object v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    invoke-virtual {v2, v3}, Ljava/io/OutputStream;->write(I)V

    .line 502
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 505
    .end local v1    # "i":I
    :cond_0
    return-void
.end method

.method private writePixels()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 511
    new-instance v0, Lcom/bumptech/glide/gifencoder/LZWEncoder;

    iget v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->width:I

    iget v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->height:I

    iget-object v3, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->indexedPixels:[B

    iget v4, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->colorDepth:I

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/bumptech/glide/gifencoder/LZWEncoder;-><init>(II[BI)V

    .line 512
    .local v0, "encoder":Lcom/bumptech/glide/gifencoder/LZWEncoder;
    iget-object v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->encode(Ljava/io/OutputStream;)V

    .line 513
    return-void
.end method

.method private writeShort(I)V
    .locals 2
    .param p1, "value"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 519
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    and-int/lit16 v1, p1, 0xff

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write(I)V

    .line 520
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    shr-int/lit8 v1, p1, 0x8

    and-int/lit16 v1, v1, 0xff

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write(I)V

    .line 521
    return-void
.end method

.method private writeString(Ljava/lang/String;)V
    .locals 3
    .param p1, "s"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 527
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 528
    iget-object v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    invoke-virtual {p1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    int-to-byte v2, v2

    invoke-virtual {v1, v2}, Ljava/io/OutputStream;->write(I)V

    .line 527
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 530
    .end local v0    # "i":I
    :cond_0
    return-void
.end method


# virtual methods
.method public addFrame(Landroid/graphics/Bitmap;)Z
    .locals 4
    .param p1, "im"    # Landroid/graphics/Bitmap;

    .line 151
    const/4 v0, 0x0

    if-eqz p1, :cond_5

    iget-boolean v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->started:Z

    if-nez v1, :cond_0

    goto :goto_4

    .line 154
    :cond_0
    const/4 v1, 0x1

    .line 156
    .local v1, "ok":Z
    :try_start_0
    iget-boolean v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->sizeSet:Z

    if-nez v2, :cond_1

    .line 158
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    invoke-virtual {p0, v2, v3}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->setSize(II)V

    goto :goto_0

    .line 156
    :cond_1
    nop

    .line 160
    :goto_0
    iput-object p1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->image:Landroid/graphics/Bitmap;

    .line 161
    invoke-direct {p0}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->getImagePixels()V

    .line 162
    invoke-direct {p0}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->analyzePixels()V

    .line 163
    iget-boolean v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->firstFrame:Z

    if-eqz v2, :cond_3

    .line 164
    invoke-direct {p0}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->writeLSD()V

    .line 165
    invoke-direct {p0}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->writePalette()V

    .line 166
    iget v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->repeat:I

    if-ltz v2, :cond_2

    .line 168
    invoke-direct {p0}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->writeNetscapeExt()V

    goto :goto_1

    .line 166
    :cond_2
    goto :goto_1

    .line 163
    :cond_3
    nop

    .line 171
    :goto_1
    invoke-direct {p0}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->writeGraphicCtrlExt()V

    .line 172
    invoke-direct {p0}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->writeImageDesc()V

    .line 173
    iget-boolean v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->firstFrame:Z

    if-nez v2, :cond_4

    .line 174
    invoke-direct {p0}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->writePalette()V

    goto :goto_2

    .line 173
    :cond_4
    nop

    .line 176
    :goto_2
    invoke-direct {p0}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->writePixels()V

    .line 177
    iput-boolean v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->firstFrame:Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 180
    goto :goto_3

    .line 178
    :catch_0
    move-exception v0

    .line 179
    .local v0, "e":Ljava/io/IOException;
    const/4 v1, 0x0

    .line 182
    .end local v0    # "e":Ljava/io/IOException;
    :goto_3
    return v1

    .line 151
    .end local v1    # "ok":Z
    :cond_5
    :goto_4
    nop

    .line 152
    return v0
.end method

.method public finish()Z
    .locals 4

    .line 190
    iget-boolean v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->started:Z

    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 191
    return v1

    .line 192
    :cond_0
    const/4 v0, 0x1

    .line 193
    .local v0, "ok":Z
    iput-boolean v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->started:Z

    .line 195
    :try_start_0
    iget-object v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    const/16 v3, 0x3b

    invoke-virtual {v2, v3}, Ljava/io/OutputStream;->write(I)V

    .line 196
    iget-object v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    invoke-virtual {v2}, Ljava/io/OutputStream;->flush()V

    .line 197
    iget-boolean v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->closeStream:Z

    if-eqz v2, :cond_1

    .line 198
    iget-object v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    invoke-virtual {v2}, Ljava/io/OutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 197
    :cond_1
    nop

    .line 202
    :goto_0
    goto :goto_1

    .line 200
    :catch_0
    move-exception v2

    .line 201
    .local v2, "e":Ljava/io/IOException;
    const/4 v0, 0x0

    .line 205
    .end local v2    # "e":Ljava/io/IOException;
    :goto_1
    iput v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->transIndex:I

    .line 206
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    .line 207
    iput-object v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->image:Landroid/graphics/Bitmap;

    .line 208
    iput-object v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->pixels:[B

    .line 209
    iput-object v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->indexedPixels:[B

    .line 210
    iput-object v2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->colorTab:[B

    .line 211
    iput-boolean v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->closeStream:Z

    .line 212
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->firstFrame:Z

    .line 214
    return v0
.end method

.method public setDelay(I)V
    .locals 2
    .param p1, "ms"    # I

    .line 94
    int-to-float v0, p1

    const/high16 v1, 0x41200000    # 10.0f

    div-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    iput v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->delay:I

    .line 95
    return-void
.end method

.method public setDispose(I)V
    .locals 0
    .param p1, "code"    # I

    .line 106
    if-ltz p1, :cond_0

    .line 107
    iput p1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->dispose:I

    goto :goto_0

    .line 106
    :cond_0
    nop

    .line 109
    :goto_0
    return-void
.end method

.method public setFrameRate(F)V
    .locals 1
    .param p1, "fps"    # F

    .line 225
    const/4 v0, 0x0

    cmpl-float v0, p1, v0

    if-eqz v0, :cond_0

    .line 226
    const/high16 v0, 0x42c80000    # 100.0f

    div-float/2addr v0, p1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    iput v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->delay:I

    goto :goto_0

    .line 225
    :cond_0
    nop

    .line 228
    :goto_0
    return-void
.end method

.method public setQuality(I)V
    .locals 1
    .param p1, "quality"    # I

    .line 240
    const/4 v0, 0x1

    if-ge p1, v0, :cond_0

    .line 241
    const/4 p1, 0x1

    goto :goto_0

    .line 240
    :cond_0
    nop

    .line 242
    :goto_0
    iput p1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->sample:I

    .line 243
    return-void
.end method

.method public setRepeat(I)V
    .locals 0
    .param p1, "iter"    # I

    .line 120
    if-ltz p1, :cond_0

    .line 121
    iput p1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->repeat:I

    goto :goto_0

    .line 120
    :cond_0
    nop

    .line 123
    :goto_0
    return-void
.end method

.method public setSize(II)V
    .locals 2
    .param p1, "w"    # I
    .param p2, "h"    # I

    .line 255
    iget-boolean v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->started:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->firstFrame:Z

    if-nez v0, :cond_0

    .line 256
    return-void

    .line 255
    :cond_0
    nop

    .line 257
    iput p1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->width:I

    .line 258
    iput p2, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->height:I

    .line 259
    iget v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->width:I

    const/4 v1, 0x1

    if-ge v0, v1, :cond_1

    .line 260
    const/16 v0, 0x140

    iput v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->width:I

    goto :goto_0

    .line 259
    :cond_1
    nop

    .line 261
    :goto_0
    iget v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->height:I

    if-ge v0, v1, :cond_2

    .line 262
    const/16 v0, 0xf0

    iput v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->height:I

    goto :goto_1

    .line 261
    :cond_2
    nop

    .line 263
    :goto_1
    iput-boolean v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->sizeSet:Z

    .line 264
    return-void
.end method

.method public setTransparent(I)V
    .locals 1
    .param p1, "color"    # I

    .line 136
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->transparent:Ljava/lang/Integer;

    .line 137
    return-void
.end method

.method public start(Ljava/io/OutputStream;)Z
    .locals 2
    .param p1, "os"    # Ljava/io/OutputStream;

    .line 275
    const/4 v0, 0x0

    if-nez p1, :cond_0

    .line 276
    return v0

    .line 277
    :cond_0
    const/4 v1, 0x1

    .line 278
    .local v1, "ok":Z
    iput-boolean v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->closeStream:Z

    .line 279
    iput-object p1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    .line 281
    :try_start_0
    const-string v0, "GIF89a"

    invoke-direct {p0, v0}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->writeString(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 284
    goto :goto_0

    .line 282
    :catch_0
    move-exception v0

    .line 283
    .local v0, "e":Ljava/io/IOException;
    const/4 v1, 0x0

    .line 285
    .end local v0    # "e":Ljava/io/IOException;
    :goto_0
    iput-boolean v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->started:Z

    return v1
.end method

.method public start(Ljava/lang/String;)Z
    .locals 3
    .param p1, "file"    # Ljava/lang/String;

    .line 296
    const/4 v0, 0x1

    .line 298
    .local v0, "ok":Z
    :try_start_0
    new-instance v1, Ljava/io/BufferedOutputStream;

    new-instance v2, Ljava/io/FileOutputStream;

    invoke-direct {v2, p1}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    invoke-direct {v1, v2}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V

    iput-object v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    .line 299
    iget-object v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->out:Ljava/io/OutputStream;

    invoke-virtual {p0, v1}, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->start(Ljava/io/OutputStream;)Z

    move-result v1

    move v0, v1

    .line 300
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->closeStream:Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 303
    goto :goto_0

    .line 301
    :catch_0
    move-exception v1

    .line 302
    .local v1, "e":Ljava/io/IOException;
    const/4 v0, 0x0

    .line 304
    .end local v1    # "e":Ljava/io/IOException;
    :goto_0
    iput-boolean v0, p0, Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;->started:Z

    return v0
.end method
