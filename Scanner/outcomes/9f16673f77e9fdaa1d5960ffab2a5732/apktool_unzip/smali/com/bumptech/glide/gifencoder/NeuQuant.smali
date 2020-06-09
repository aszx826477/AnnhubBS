.class Lcom/bumptech/glide/gifencoder/NeuQuant;
.super Ljava/lang/Object;
.source "NeuQuant.java"


# static fields
.field protected static final alphabiasshift:I = 0xa

.field protected static final alpharadbias:I = 0x40000

.field protected static final alpharadbshift:I = 0x12

.field protected static final beta:I = 0x40

.field protected static final betagamma:I = 0x10000

.field protected static final betashift:I = 0xa

.field protected static final gamma:I = 0x400

.field protected static final gammashift:I = 0xa

.field protected static final initalpha:I = 0x400

.field protected static final initrad:I = 0x20

.field protected static final initradius:I = 0x800

.field protected static final intbias:I = 0x10000

.field protected static final intbiasshift:I = 0x10

.field protected static final maxnetpos:I = 0xff

.field protected static final minpicturebytes:I = 0x5e5

.field protected static final ncycles:I = 0x64

.field protected static final netbiasshift:I = 0x4

.field protected static final netsize:I = 0x100

.field protected static final prime1:I = 0x1f3

.field protected static final prime2:I = 0x1eb

.field protected static final prime3:I = 0x1e7

.field protected static final prime4:I = 0x1f7

.field protected static final radbias:I = 0x100

.field protected static final radbiasshift:I = 0x8

.field protected static final radiusbias:I = 0x40

.field protected static final radiusbiasshift:I = 0x6

.field protected static final radiusdec:I = 0x1e


# instance fields
.field protected alphadec:I

.field protected bias:[I

.field protected freq:[I

.field protected lengthcount:I

.field protected netindex:[I

.field protected network:[[I

.field protected radpower:[I

.field protected samplefac:I

.field protected thepicture:[B


# direct methods
.method public constructor <init>([BII)V
    .locals 5
    .param p1, "thepic"    # [B
    .param p2, "len"    # I
    .param p3, "sample"    # I

    .line 140
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 123
    const/16 v0, 0x100

    new-array v1, v0, [I

    iput-object v1, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->netindex:[I

    .line 127
    new-array v1, v0, [I

    iput-object v1, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->bias:[I

    .line 130
    new-array v1, v0, [I

    iput-object v1, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->freq:[I

    .line 132
    const/16 v1, 0x20

    new-array v1, v1, [I

    iput-object v1, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->radpower:[I

    .line 145
    iput-object p1, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->thepicture:[B

    .line 146
    iput p2, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->lengthcount:I

    .line 147
    iput p3, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->samplefac:I

    .line 149
    new-array v1, v0, [[I

    iput-object v1, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->network:[[I

    .line 150
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 151
    iget-object v2, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->network:[[I

    const/4 v3, 0x4

    new-array v3, v3, [I

    aput-object v3, v2, v1

    .line 152
    aget-object v2, v2, v1

    .line 153
    .local v2, "p":[I
    const/4 v3, 0x2

    shl-int/lit8 v4, v1, 0xc

    div-int/2addr v4, v0

    aput v4, v2, v3

    const/4 v3, 0x1

    aput v4, v2, v3

    const/4 v3, 0x0

    aput v4, v2, v3

    .line 154
    iget-object v4, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->freq:[I

    aput v0, v4, v1

    .line 155
    iget-object v4, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->bias:[I

    aput v3, v4, v1

    .line 150
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 157
    .end local v2    # "p":[I
    :cond_0
    return-void
.end method


# virtual methods
.method protected alterneigh(IIIII)V
    .locals 14
    .param p1, "rad"    # I
    .param p2, "i"    # I
    .param p3, "b"    # I
    .param p4, "g"    # I
    .param p5, "r"    # I

    .line 411
    move-object v1, p0

    sub-int v0, p2, p1

    .line 412
    .local v0, "lo":I
    const/4 v2, -0x1

    if-ge v0, v2, :cond_0

    .line 413
    const/4 v0, -0x1

    move v2, v0

    goto :goto_0

    .line 412
    :cond_0
    move v2, v0

    .line 414
    .end local v0    # "lo":I
    .local v2, "lo":I
    :goto_0
    add-int v0, p2, p1

    .line 415
    .local v0, "hi":I
    const/16 v3, 0x100

    if-le v0, v3, :cond_1

    .line 416
    const/16 v0, 0x100

    move v3, v0

    goto :goto_1

    .line 415
    :cond_1
    move v3, v0

    .line 418
    .end local v0    # "hi":I
    .local v3, "hi":I
    :goto_1
    add-int/lit8 v0, p2, 0x1

    .line 419
    .local v0, "j":I
    add-int/lit8 v4, p2, -0x1

    .line 420
    .local v4, "k":I
    const/4 v5, 0x1

    .line 421
    .local v5, "m":I
    :goto_2
    if-lt v0, v3, :cond_3

    if-le v4, v2, :cond_2

    goto :goto_3

    .line 442
    :cond_2
    return-void

    .line 421
    :cond_3
    :goto_3
    nop

    .line 422
    iget-object v6, v1, Lcom/bumptech/glide/gifencoder/NeuQuant;->radpower:[I

    add-int/lit8 v7, v5, 0x1

    .end local v5    # "m":I
    .local v7, "m":I
    aget v5, v6, v5

    .line 423
    .local v5, "a":I
    const/4 v6, 0x2

    const/4 v8, 0x0

    const/high16 v9, 0x40000

    const/4 v10, 0x1

    if-ge v0, v3, :cond_4

    .line 424
    iget-object v11, v1, Lcom/bumptech/glide/gifencoder/NeuQuant;->network:[[I

    add-int/lit8 v12, v0, 0x1

    .end local v0    # "j":I
    .local v12, "j":I
    aget-object v11, v11, v0

    .line 426
    .local v11, "p":[I
    :try_start_0
    aget v0, v11, v8

    aget v13, v11, v8

    sub-int v13, v13, p3

    mul-int v13, v13, v5

    div-int/2addr v13, v9

    sub-int/2addr v0, v13

    aput v0, v11, v8

    .line 427
    aget v0, v11, v10

    aget v13, v11, v10

    sub-int v13, v13, p4

    mul-int v13, v13, v5

    div-int/2addr v13, v9

    sub-int/2addr v0, v13

    aput v0, v11, v10

    .line 428
    aget v0, v11, v6

    aget v13, v11, v6

    sub-int v13, v13, p5

    mul-int v13, v13, v5

    div-int/2addr v13, v9

    sub-int/2addr v0, v13

    aput v0, v11, v6
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 430
    goto :goto_4

    .line 429
    :catch_0
    move-exception v0

    goto :goto_4

    .line 423
    .end local v11    # "p":[I
    .end local v12    # "j":I
    .restart local v0    # "j":I
    :cond_4
    move v12, v0

    .line 432
    .end local v0    # "j":I
    .restart local v12    # "j":I
    :goto_4
    if-le v4, v2, :cond_5

    .line 433
    iget-object v0, v1, Lcom/bumptech/glide/gifencoder/NeuQuant;->network:[[I

    add-int/lit8 v11, v4, -0x1

    .end local v4    # "k":I
    .local v11, "k":I
    aget-object v4, v0, v4

    .line 435
    .local v4, "p":[I
    :try_start_1
    aget v0, v4, v8

    aget v13, v4, v8

    sub-int v13, v13, p3

    mul-int v13, v13, v5

    div-int/2addr v13, v9

    sub-int/2addr v0, v13

    aput v0, v4, v8

    .line 436
    aget v0, v4, v10

    aget v8, v4, v10

    sub-int v8, v8, p4

    mul-int v8, v8, v5

    div-int/2addr v8, v9

    sub-int/2addr v0, v8

    aput v0, v4, v10

    .line 437
    aget v0, v4, v6

    aget v8, v4, v6

    sub-int v8, v8, p5

    mul-int v8, v8, v5

    div-int/2addr v8, v9

    sub-int/2addr v0, v8

    aput v0, v4, v6
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_5

    .line 438
    :catch_1
    move-exception v0

    .line 439
    :goto_5
    nop

    .line 421
    .end local v4    # "p":[I
    .end local v5    # "a":I
    move v5, v7

    move v4, v11

    move v0, v12

    goto :goto_2

    .line 432
    .end local v11    # "k":I
    .local v4, "k":I
    .restart local v5    # "a":I
    :cond_5
    move v5, v7

    move v0, v12

    goto :goto_2
.end method

.method protected altersingle(IIIII)V
    .locals 4
    .param p1, "alpha"    # I
    .param p2, "i"    # I
    .param p3, "b"    # I
    .param p4, "g"    # I
    .param p5, "r"    # I

    .line 451
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->network:[[I

    aget-object v0, v0, p2

    .line 452
    .local v0, "n":[I
    const/4 v1, 0x0

    aget v2, v0, v1

    aget v3, v0, v1

    sub-int/2addr v3, p3

    mul-int v3, v3, p1

    div-int/lit16 v3, v3, 0x400

    sub-int/2addr v2, v3

    aput v2, v0, v1

    .line 453
    const/4 v1, 0x1

    aget v2, v0, v1

    aget v3, v0, v1

    sub-int/2addr v3, p4

    mul-int v3, v3, p1

    div-int/lit16 v3, v3, 0x400

    sub-int/2addr v2, v3

    aput v2, v0, v1

    .line 454
    const/4 v1, 0x2

    aget v2, v0, v1

    aget v3, v0, v1

    sub-int/2addr v3, p5

    mul-int v3, v3, p1

    div-int/lit16 v3, v3, 0x400

    sub-int/2addr v2, v3

    aput v2, v0, v1

    .line 455
    return-void
.end method

.method public colorMap()[B
    .locals 10

    .line 160
    const/16 v0, 0x300

    new-array v0, v0, [B

    .line 161
    .local v0, "map":[B
    const/16 v1, 0x100

    new-array v2, v1, [I

    .line 162
    .local v2, "index":[I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v1, :cond_0

    .line 163
    iget-object v4, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->network:[[I

    aget-object v4, v4, v3

    const/4 v5, 0x3

    aget v4, v4, v5

    aput v3, v2, v4

    .line 162
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 164
    .end local v3    # "i":I
    :cond_0
    const/4 v3, 0x0

    .line 165
    .local v3, "k":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_1
    if-ge v4, v1, :cond_1

    .line 166
    aget v5, v2, v4

    .line 167
    .local v5, "j":I
    add-int/lit8 v6, v3, 0x1

    .end local v3    # "k":I
    .local v6, "k":I
    iget-object v7, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->network:[[I

    aget-object v8, v7, v5

    const/4 v9, 0x0

    aget v8, v8, v9

    int-to-byte v8, v8

    aput-byte v8, v0, v3

    .line 168
    add-int/lit8 v3, v6, 0x1

    .end local v6    # "k":I
    .restart local v3    # "k":I
    aget-object v8, v7, v5

    const/4 v9, 0x1

    aget v8, v8, v9

    int-to-byte v8, v8

    aput-byte v8, v0, v6

    .line 169
    add-int/lit8 v6, v3, 0x1

    .end local v3    # "k":I
    .restart local v6    # "k":I
    aget-object v7, v7, v5

    const/4 v8, 0x2

    aget v7, v7, v8

    int-to-byte v7, v7

    aput-byte v7, v0, v3

    .line 165
    .end local v5    # "j":I
    add-int/lit8 v4, v4, 0x1

    move v3, v6

    goto :goto_1

    .line 171
    .end local v4    # "i":I
    .end local v6    # "k":I
    .restart local v3    # "k":I
    :cond_1
    return-object v0
.end method

.method protected contest(III)I
    .locals 14
    .param p1, "b"    # I
    .param p2, "g"    # I
    .param p3, "r"    # I

    .line 471
    move-object v0, p0

    const v1, 0x7fffffff

    .line 472
    .local v1, "bestd":I
    move v2, v1

    .line 473
    .local v2, "bestbiasd":I
    const/4 v3, -0x1

    .line 474
    .local v3, "bestpos":I
    move v4, v3

    .line 476
    .local v4, "bestbiaspos":I
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_0
    const/16 v6, 0x100

    if-ge v5, v6, :cond_5

    .line 477
    iget-object v6, v0, Lcom/bumptech/glide/gifencoder/NeuQuant;->network:[[I

    aget-object v6, v6, v5

    .line 478
    .local v6, "n":[I
    const/4 v7, 0x0

    aget v7, v6, v7

    sub-int/2addr v7, p1

    .line 479
    .local v7, "dist":I
    if-gez v7, :cond_0

    .line 480
    neg-int v7, v7

    goto :goto_1

    .line 479
    :cond_0
    nop

    .line 481
    :goto_1
    const/4 v8, 0x1

    aget v8, v6, v8

    sub-int v8, v8, p2

    .line 482
    .local v8, "a":I
    if-gez v8, :cond_1

    .line 483
    neg-int v8, v8

    goto :goto_2

    .line 482
    :cond_1
    nop

    .line 484
    :goto_2
    add-int/2addr v7, v8

    .line 485
    const/4 v9, 0x2

    aget v9, v6, v9

    sub-int v9, v9, p3

    .line 486
    .end local v8    # "a":I
    .local v9, "a":I
    if-gez v9, :cond_2

    .line 487
    neg-int v9, v9

    goto :goto_3

    .line 486
    :cond_2
    nop

    .line 488
    :goto_3
    add-int/2addr v7, v9

    .line 489
    if-ge v7, v1, :cond_3

    .line 490
    move v1, v7

    .line 491
    move v3, v5

    goto :goto_4

    .line 489
    :cond_3
    nop

    .line 493
    :goto_4
    iget-object v8, v0, Lcom/bumptech/glide/gifencoder/NeuQuant;->bias:[I

    aget v8, v8, v5

    shr-int/lit8 v8, v8, 0xc

    sub-int v8, v7, v8

    .line 494
    .local v8, "biasdist":I
    if-ge v8, v2, :cond_4

    .line 495
    move v2, v8

    .line 496
    move v4, v5

    goto :goto_5

    .line 494
    :cond_4
    nop

    .line 498
    :goto_5
    iget-object v10, v0, Lcom/bumptech/glide/gifencoder/NeuQuant;->freq:[I

    aget v11, v10, v5

    shr-int/lit8 v11, v11, 0xa

    .line 499
    .local v11, "betafreq":I
    aget v12, v10, v5

    sub-int/2addr v12, v11

    aput v12, v10, v5

    .line 500
    iget-object v10, v0, Lcom/bumptech/glide/gifencoder/NeuQuant;->bias:[I

    aget v12, v10, v5

    shl-int/lit8 v13, v11, 0xa

    add-int/2addr v12, v13

    aput v12, v10, v5

    .line 476
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 502
    .end local v6    # "n":[I
    .end local v7    # "dist":I
    .end local v8    # "biasdist":I
    .end local v9    # "a":I
    .end local v11    # "betafreq":I
    :cond_5
    iget-object v6, v0, Lcom/bumptech/glide/gifencoder/NeuQuant;->freq:[I

    aget v7, v6, v3

    add-int/lit8 v7, v7, 0x40

    aput v7, v6, v3

    .line 503
    iget-object v6, v0, Lcom/bumptech/glide/gifencoder/NeuQuant;->bias:[I

    aget v7, v6, v3

    const/high16 v8, 0x10000

    sub-int/2addr v7, v8

    aput v7, v6, v3

    .line 504
    return v4
.end method

.method public inxbuild()V
    .locals 11

    .line 186
    const/4 v0, 0x0

    .line 187
    .local v0, "previouscol":I
    const/4 v1, 0x0

    .line 188
    .local v1, "startpos":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    const/16 v3, 0x100

    const/4 v4, 0x1

    if-ge v2, v3, :cond_5

    .line 189
    iget-object v5, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->network:[[I

    aget-object v5, v5, v2

    .line 190
    .local v5, "p":[I
    move v6, v2

    .line 191
    .local v6, "smallpos":I
    aget v7, v5, v4

    .line 193
    .local v7, "smallval":I
    add-int/lit8 v8, v2, 0x1

    .local v8, "j":I
    :goto_1
    if-ge v8, v3, :cond_1

    .line 194
    iget-object v9, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->network:[[I

    aget-object v9, v9, v8

    .line 195
    .local v9, "q":[I
    aget v10, v9, v4

    if-ge v10, v7, :cond_0

    .line 196
    move v6, v8

    .line 197
    aget v7, v9, v4

    goto :goto_2

    .line 195
    :cond_0
    nop

    .line 193
    :goto_2
    add-int/lit8 v8, v8, 0x1

    goto :goto_1

    .line 200
    .end local v9    # "q":[I
    :cond_1
    iget-object v3, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->network:[[I

    aget-object v3, v3, v6

    .line 202
    .local v3, "q":[I
    if-eq v2, v6, :cond_2

    .line 203
    const/4 v9, 0x0

    aget v8, v3, v9

    .line 204
    aget v10, v5, v9

    aput v10, v3, v9

    .line 205
    aput v8, v5, v9

    .line 206
    aget v8, v3, v4

    .line 207
    aget v9, v5, v4

    aput v9, v3, v4

    .line 208
    aput v8, v5, v4

    .line 209
    const/4 v9, 0x2

    aget v8, v3, v9

    .line 210
    aget v10, v5, v9

    aput v10, v3, v9

    .line 211
    aput v8, v5, v9

    .line 212
    const/4 v9, 0x3

    aget v8, v3, v9

    .line 213
    aget v10, v5, v9

    aput v10, v3, v9

    .line 214
    aput v8, v5, v9

    goto :goto_3

    .line 202
    :cond_2
    nop

    .line 217
    :goto_3
    if-eq v7, v0, :cond_4

    .line 218
    iget-object v9, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->netindex:[I

    add-int v10, v1, v2

    shr-int/lit8 v4, v10, 0x1

    aput v4, v9, v0

    .line 219
    add-int/lit8 v4, v0, 0x1

    move v8, v4

    :goto_4
    if-ge v8, v7, :cond_3

    .line 220
    iget-object v4, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->netindex:[I

    aput v2, v4, v8

    .line 219
    add-int/lit8 v8, v8, 0x1

    goto :goto_4

    .line 221
    :cond_3
    move v0, v7

    .line 222
    move v1, v2

    goto :goto_5

    .line 217
    :cond_4
    nop

    .line 188
    :goto_5
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 225
    .end local v3    # "q":[I
    .end local v5    # "p":[I
    .end local v6    # "smallpos":I
    .end local v7    # "smallval":I
    .end local v8    # "j":I
    :cond_5
    iget-object v5, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->netindex:[I

    add-int/lit16 v6, v1, 0xff

    shr-int/lit8 v4, v6, 0x1

    aput v4, v5, v0

    .line 226
    add-int/lit8 v4, v0, 0x1

    .local v4, "j":I
    :goto_6
    if-ge v4, v3, :cond_6

    .line 227
    iget-object v5, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->netindex:[I

    const/16 v6, 0xff

    aput v6, v5, v4

    .line 226
    add-int/lit8 v4, v4, 0x1

    goto :goto_6

    .line 228
    :cond_6
    return-void
.end method

.method public learn()V
    .locals 22

    .line 240
    move-object/from16 v6, p0

    iget v0, v6, Lcom/bumptech/glide/gifencoder/NeuQuant;->lengthcount:I

    const/16 v1, 0x5e5

    const/4 v7, 0x1

    if-ge v0, v1, :cond_0

    .line 241
    iput v7, v6, Lcom/bumptech/glide/gifencoder/NeuQuant;->samplefac:I

    goto :goto_0

    .line 240
    :cond_0
    nop

    .line 242
    :goto_0
    iget v0, v6, Lcom/bumptech/glide/gifencoder/NeuQuant;->samplefac:I

    add-int/lit8 v2, v0, -0x1

    div-int/lit8 v2, v2, 0x3

    add-int/lit8 v2, v2, 0x1e

    iput v2, v6, Lcom/bumptech/glide/gifencoder/NeuQuant;->alphadec:I

    .line 243
    iget-object v8, v6, Lcom/bumptech/glide/gifencoder/NeuQuant;->thepicture:[B

    .line 244
    .local v8, "p":[B
    const/4 v2, 0x0

    .line 245
    .local v2, "pix":I
    iget v9, v6, Lcom/bumptech/glide/gifencoder/NeuQuant;->lengthcount:I

    .line 246
    .local v9, "lim":I
    iget v3, v6, Lcom/bumptech/glide/gifencoder/NeuQuant;->lengthcount:I

    mul-int/lit8 v0, v0, 0x3

    div-int v10, v3, v0

    .line 247
    .local v10, "samplepixels":I
    div-int/lit8 v0, v10, 0x64

    .line 248
    .local v0, "delta":I
    const/16 v3, 0x400

    .line 249
    .local v3, "alpha":I
    const/16 v4, 0x800

    .line 251
    .local v4, "radius":I
    shr-int/lit8 v5, v4, 0x6

    .line 252
    .local v5, "rad":I
    if-gt v5, v7, :cond_1

    .line 253
    const/4 v5, 0x0

    goto :goto_1

    .line 252
    :cond_1
    nop

    .line 254
    :goto_1
    const/4 v11, 0x0

    .local v11, "i":I
    :goto_2
    if-ge v11, v5, :cond_2

    .line 255
    iget-object v12, v6, Lcom/bumptech/glide/gifencoder/NeuQuant;->radpower:[I

    mul-int v13, v5, v5

    mul-int v14, v11, v11

    sub-int/2addr v13, v14

    mul-int/lit16 v13, v13, 0x100

    mul-int v14, v5, v5

    div-int/2addr v13, v14

    mul-int v13, v13, v3

    aput v13, v12, v11

    .line 254
    add-int/lit8 v11, v11, 0x1

    goto :goto_2

    .line 259
    :cond_2
    iget v12, v6, Lcom/bumptech/glide/gifencoder/NeuQuant;->lengthcount:I

    if-ge v12, v1, :cond_3

    .line 260
    const/4 v1, 0x3

    move v12, v1

    goto :goto_3

    .line 261
    :cond_3
    rem-int/lit16 v1, v12, 0x1f3

    if-eqz v1, :cond_4

    .line 262
    const/16 v1, 0x5d9

    move v12, v1

    goto :goto_3

    .line 264
    :cond_4
    rem-int/lit16 v1, v12, 0x1eb

    if-eqz v1, :cond_5

    .line 265
    const/16 v1, 0x5c1

    move v12, v1

    goto :goto_3

    .line 267
    :cond_5
    rem-int/lit16 v12, v12, 0x1e7

    if-eqz v12, :cond_6

    .line 268
    const/16 v1, 0x5b5

    move v12, v1

    goto :goto_3

    .line 270
    :cond_6
    const/16 v1, 0x5e5

    move v12, v1

    .line 274
    .local v12, "step":I
    :goto_3
    const/4 v1, 0x0

    move/from16 v16, v0

    move v11, v1

    move/from16 v17, v2

    move v15, v3

    move v13, v4

    move v14, v5

    .line 275
    .end local v0    # "delta":I
    .end local v2    # "pix":I
    .end local v3    # "alpha":I
    .end local v4    # "radius":I
    .end local v5    # "rad":I
    .local v13, "radius":I
    .local v14, "rad":I
    .local v15, "alpha":I
    .local v16, "delta":I
    .local v17, "pix":I
    :goto_4
    if-ge v11, v10, :cond_d

    .line 276
    add-int/lit8 v0, v17, 0x0

    aget-byte v0, v8, v0

    and-int/lit16 v0, v0, 0xff

    shl-int/lit8 v5, v0, 0x4

    .line 277
    .local v5, "b":I
    add-int/lit8 v0, v17, 0x1

    aget-byte v0, v8, v0

    and-int/lit16 v0, v0, 0xff

    shl-int/lit8 v4, v0, 0x4

    .line 278
    .local v4, "g":I
    add-int/lit8 v0, v17, 0x2

    aget-byte v0, v8, v0

    and-int/lit16 v0, v0, 0xff

    shl-int/lit8 v3, v0, 0x4

    .line 279
    .local v3, "r":I
    invoke-virtual {v6, v5, v4, v3}, Lcom/bumptech/glide/gifencoder/NeuQuant;->contest(III)I

    move-result v18

    .line 281
    .local v18, "j":I
    move-object/from16 v0, p0

    move v1, v15

    move/from16 v2, v18

    move/from16 v19, v3

    .end local v3    # "r":I
    .local v19, "r":I
    move v3, v5

    move/from16 v20, v4

    .end local v4    # "g":I
    .local v20, "g":I
    move/from16 v21, v5

    .end local v5    # "b":I
    .local v21, "b":I
    move/from16 v5, v19

    invoke-virtual/range {v0 .. v5}, Lcom/bumptech/glide/gifencoder/NeuQuant;->altersingle(IIIII)V

    .line 282
    if-eqz v14, :cond_7

    .line 283
    move-object/from16 v0, p0

    move v1, v14

    move/from16 v2, v18

    move/from16 v3, v21

    move/from16 v4, v20

    move/from16 v5, v19

    invoke-virtual/range {v0 .. v5}, Lcom/bumptech/glide/gifencoder/NeuQuant;->alterneigh(IIIII)V

    goto :goto_5

    .line 282
    :cond_7
    nop

    .line 285
    :goto_5
    add-int v0, v17, v12

    .line 286
    .end local v17    # "pix":I
    .local v0, "pix":I
    if-lt v0, v9, :cond_8

    .line 287
    iget v1, v6, Lcom/bumptech/glide/gifencoder/NeuQuant;->lengthcount:I

    sub-int/2addr v0, v1

    move/from16 v17, v0

    goto :goto_6

    .line 286
    :cond_8
    move/from16 v17, v0

    .line 289
    .end local v0    # "pix":I
    .restart local v17    # "pix":I
    :goto_6
    add-int/lit8 v11, v11, 0x1

    .line 290
    if-nez v16, :cond_9

    .line 291
    const/4 v0, 0x1

    move/from16 v16, v0

    goto :goto_7

    .line 290
    :cond_9
    nop

    .line 292
    :goto_7
    rem-int v0, v11, v16

    if-nez v0, :cond_c

    .line 293
    iget v0, v6, Lcom/bumptech/glide/gifencoder/NeuQuant;->alphadec:I

    div-int v0, v15, v0

    sub-int/2addr v15, v0

    .line 294
    div-int/lit8 v0, v13, 0x1e

    sub-int/2addr v13, v0

    .line 295
    shr-int/lit8 v0, v13, 0x6

    .line 296
    .end local v14    # "rad":I
    .local v0, "rad":I
    if-gt v0, v7, :cond_a

    .line 297
    const/4 v0, 0x0

    move v14, v0

    goto :goto_8

    .line 296
    :cond_a
    move v14, v0

    .line 298
    .end local v0    # "rad":I
    .restart local v14    # "rad":I
    :goto_8
    const/4 v0, 0x0

    .end local v18    # "j":I
    .local v0, "j":I
    :goto_9
    if-ge v0, v14, :cond_b

    .line 299
    iget-object v1, v6, Lcom/bumptech/glide/gifencoder/NeuQuant;->radpower:[I

    mul-int v2, v14, v14

    mul-int v3, v0, v0

    sub-int/2addr v2, v3

    mul-int/lit16 v2, v2, 0x100

    mul-int v3, v14, v14

    div-int/2addr v2, v3

    mul-int v2, v2, v15

    aput v2, v1, v0

    .line 298
    add-int/lit8 v0, v0, 0x1

    goto :goto_9

    :cond_b
    goto/16 :goto_4

    .line 292
    .end local v0    # "j":I
    .restart local v18    # "j":I
    :cond_c
    goto/16 :goto_4

    .line 304
    .end local v18    # "j":I
    .end local v19    # "r":I
    .end local v20    # "g":I
    .end local v21    # "b":I
    :cond_d
    return-void
.end method

.method public map(III)I
    .locals 12
    .param p1, "b"    # I
    .param p2, "g"    # I
    .param p3, "r"    # I

    .line 317
    const/16 v0, 0x3e8

    .line 318
    .local v0, "bestd":I
    const/4 v1, -0x1

    .line 319
    .local v1, "best":I
    iget-object v2, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->netindex:[I

    aget v2, v2, p2

    .line 320
    .local v2, "i":I
    add-int/lit8 v3, v2, -0x1

    .line 322
    .local v3, "j":I
    :goto_0
    const/16 v4, 0x100

    if-lt v2, v4, :cond_1

    if-ltz v3, :cond_0

    goto :goto_1

    .line 374
    :cond_0
    return v1

    .line 322
    :cond_1
    :goto_1
    nop

    .line 323
    const/4 v5, 0x3

    const/4 v6, 0x2

    const/4 v7, 0x0

    const/4 v8, 0x1

    if-ge v2, v4, :cond_8

    .line 324
    iget-object v4, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->network:[[I

    aget-object v4, v4, v2

    .line 325
    .local v4, "p":[I
    aget v9, v4, v8

    sub-int/2addr v9, p2

    .line 326
    .local v9, "dist":I
    if-lt v9, v0, :cond_2

    .line 327
    const/16 v2, 0x100

    goto :goto_5

    .line 329
    :cond_2
    add-int/lit8 v2, v2, 0x1

    .line 330
    if-gez v9, :cond_3

    .line 331
    neg-int v9, v9

    goto :goto_2

    .line 330
    :cond_3
    nop

    .line 332
    :goto_2
    aget v10, v4, v7

    sub-int/2addr v10, p1

    .line 333
    .local v10, "a":I
    if-gez v10, :cond_4

    .line 334
    neg-int v10, v10

    goto :goto_3

    .line 333
    :cond_4
    nop

    .line 335
    :goto_3
    add-int/2addr v9, v10

    .line 336
    if-ge v9, v0, :cond_7

    .line 337
    aget v11, v4, v6

    sub-int/2addr v11, p3

    .line 338
    .end local v10    # "a":I
    .local v11, "a":I
    if-gez v11, :cond_5

    .line 339
    neg-int v11, v11

    goto :goto_4

    .line 338
    :cond_5
    nop

    .line 340
    :goto_4
    add-int/2addr v9, v11

    .line 341
    if-ge v9, v0, :cond_6

    .line 342
    move v0, v9

    .line 343
    aget v1, v4, v5

    goto :goto_5

    .line 341
    :cond_6
    goto :goto_5

    .line 336
    .end local v11    # "a":I
    .restart local v10    # "a":I
    :cond_7
    goto :goto_5

    .line 323
    .end local v4    # "p":[I
    .end local v9    # "dist":I
    .end local v10    # "a":I
    :cond_8
    nop

    .line 348
    :goto_5
    if-ltz v3, :cond_f

    .line 349
    iget-object v4, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->network:[[I

    aget-object v4, v4, v3

    .line 350
    .restart local v4    # "p":[I
    aget v8, v4, v8

    sub-int v8, p2, v8

    .line 351
    .local v8, "dist":I
    if-lt v8, v0, :cond_9

    .line 352
    const/4 v3, -0x1

    goto :goto_0

    .line 354
    :cond_9
    add-int/lit8 v3, v3, -0x1

    .line 355
    if-gez v8, :cond_a

    .line 356
    neg-int v8, v8

    goto :goto_6

    .line 355
    :cond_a
    nop

    .line 357
    :goto_6
    aget v7, v4, v7

    sub-int/2addr v7, p1

    .line 358
    .local v7, "a":I
    if-gez v7, :cond_b

    .line 359
    neg-int v7, v7

    goto :goto_7

    .line 358
    :cond_b
    nop

    .line 360
    :goto_7
    add-int/2addr v8, v7

    .line 361
    if-ge v8, v0, :cond_e

    .line 362
    aget v6, v4, v6

    sub-int/2addr v6, p3

    .line 363
    .end local v7    # "a":I
    .local v6, "a":I
    if-gez v6, :cond_c

    .line 364
    neg-int v6, v6

    goto :goto_8

    .line 363
    :cond_c
    nop

    .line 365
    :goto_8
    add-int/2addr v8, v6

    .line 366
    if-ge v8, v0, :cond_d

    .line 367
    move v0, v8

    .line 368
    aget v1, v4, v5

    goto :goto_0

    .line 366
    :cond_d
    goto :goto_0

    .line 361
    .end local v6    # "a":I
    .restart local v7    # "a":I
    :cond_e
    goto :goto_0

    .line 348
    .end local v4    # "p":[I
    .end local v7    # "a":I
    .end local v8    # "dist":I
    :cond_f
    goto :goto_0
.end method

.method public process()[B
    .locals 1

    .line 378
    invoke-virtual {p0}, Lcom/bumptech/glide/gifencoder/NeuQuant;->learn()V

    .line 379
    invoke-virtual {p0}, Lcom/bumptech/glide/gifencoder/NeuQuant;->unbiasnet()V

    .line 380
    invoke-virtual {p0}, Lcom/bumptech/glide/gifencoder/NeuQuant;->inxbuild()V

    .line 381
    invoke-virtual {p0}, Lcom/bumptech/glide/gifencoder/NeuQuant;->colorMap()[B

    move-result-object v0

    return-object v0
.end method

.method public unbiasnet()V
    .locals 5

    .line 393
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    const/16 v1, 0x100

    if-ge v0, v1, :cond_0

    .line 394
    iget-object v1, p0, Lcom/bumptech/glide/gifencoder/NeuQuant;->network:[[I

    aget-object v2, v1, v0

    const/4 v3, 0x0

    aget v4, v2, v3

    shr-int/lit8 v4, v4, 0x4

    aput v4, v2, v3

    .line 395
    aget-object v2, v1, v0

    const/4 v3, 0x1

    aget v4, v2, v3

    shr-int/lit8 v4, v4, 0x4

    aput v4, v2, v3

    .line 396
    aget-object v2, v1, v0

    const/4 v3, 0x2

    aget v4, v2, v3

    shr-int/lit8 v4, v4, 0x4

    aput v4, v2, v3

    .line 397
    aget-object v1, v1, v0

    const/4 v2, 0x3

    aput v0, v1, v2

    .line 393
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 399
    :cond_0
    return-void
.end method
