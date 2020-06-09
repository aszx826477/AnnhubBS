.class public final Lcom/baidu/android/bbalbs/common/a/b;
.super Ljava/lang/Object;


# static fields
.field private static final a:[B


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/16 v0, 0x40

    new-array v0, v0, [B

    fill-array-data v0, :array_0

    sput-object v0, Lcom/baidu/android/bbalbs/common/a/b;->a:[B

    return-void

    :array_0
    .array-data 1
        0x41t
        0x42t
        0x43t
        0x44t
        0x45t
        0x46t
        0x47t
        0x48t
        0x49t
        0x4at
        0x4bt
        0x4ct
        0x4dt
        0x4et
        0x4ft
        0x50t
        0x51t
        0x52t
        0x53t
        0x54t
        0x55t
        0x56t
        0x57t
        0x58t
        0x59t
        0x5at
        0x61t
        0x62t
        0x63t
        0x64t
        0x65t
        0x66t
        0x67t
        0x68t
        0x69t
        0x6at
        0x6bt
        0x6ct
        0x6dt
        0x6et
        0x6ft
        0x70t
        0x71t
        0x72t
        0x73t
        0x74t
        0x75t
        0x76t
        0x77t
        0x78t
        0x79t
        0x7at
        0x30t
        0x31t
        0x32t
        0x33t
        0x34t
        0x35t
        0x36t
        0x37t
        0x38t
        0x39t
        0x2bt
        0x2ft
    .end array-data
.end method

.method public static a([BLjava/lang/String;)Ljava/lang/String;
    .locals 11
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    array-length v0, p0

    mul-int/lit8 v0, v0, 0x4

    div-int/lit8 v0, v0, 0x3

    div-int/lit8 v1, v0, 0x4c

    add-int/lit8 v1, v1, 0x3

    add-int/2addr v0, v1

    new-array v0, v0, [B

    array-length v1, p0

    array-length v2, p0

    rem-int/lit8 v2, v2, 0x3

    sub-int/2addr v1, v2

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    :goto_0
    if-ge v3, v1, :cond_1

    add-int/lit8 v6, v4, 0x1

    sget-object v7, Lcom/baidu/android/bbalbs/common/a/b;->a:[B

    aget-byte v8, p0, v3

    and-int/lit16 v8, v8, 0xff

    shr-int/lit8 v8, v8, 0x2

    aget-byte v8, v7, v8

    aput-byte v8, v0, v4

    add-int/lit8 v4, v6, 0x1

    aget-byte v8, p0, v3

    and-int/lit8 v8, v8, 0x3

    shl-int/lit8 v8, v8, 0x4

    add-int/lit8 v9, v3, 0x1

    aget-byte v10, p0, v9

    and-int/lit16 v10, v10, 0xff

    shr-int/lit8 v10, v10, 0x4

    or-int/2addr v8, v10

    aget-byte v8, v7, v8

    aput-byte v8, v0, v6

    add-int/lit8 v6, v4, 0x1

    aget-byte v8, p0, v9

    and-int/lit8 v8, v8, 0xf

    shl-int/lit8 v8, v8, 0x2

    add-int/lit8 v9, v3, 0x2

    aget-byte v10, p0, v9

    and-int/lit16 v10, v10, 0xff

    shr-int/lit8 v10, v10, 0x6

    or-int/2addr v8, v10

    aget-byte v8, v7, v8

    aput-byte v8, v0, v4

    add-int/lit8 v4, v6, 0x1

    aget-byte v8, p0, v9

    and-int/lit8 v8, v8, 0x3f

    aget-byte v7, v7, v8

    aput-byte v7, v0, v6

    sub-int v6, v4, v5

    rem-int/lit8 v6, v6, 0x4c

    if-nez v6, :cond_0

    if-eqz v4, :cond_0

    add-int/lit8 v6, v4, 0x1

    const/16 v7, 0xa

    aput-byte v7, v0, v4

    add-int/lit8 v5, v5, 0x1

    move v4, v6

    :cond_0
    add-int/lit8 v3, v3, 0x3

    goto :goto_0

    :cond_1
    array-length v3, p0

    rem-int/lit8 v3, v3, 0x3

    const/16 v5, 0x3d

    packed-switch v3, :pswitch_data_0

    goto :goto_1

    :pswitch_0
    add-int/lit8 v3, v4, 0x1

    sget-object v6, Lcom/baidu/android/bbalbs/common/a/b;->a:[B

    aget-byte v7, p0, v1

    and-int/lit16 v7, v7, 0xff

    shr-int/lit8 v7, v7, 0x2

    aget-byte v7, v6, v7

    aput-byte v7, v0, v4

    add-int/lit8 v4, v3, 0x1

    aget-byte v7, p0, v1

    and-int/lit8 v7, v7, 0x3

    shl-int/lit8 v7, v7, 0x4

    add-int/lit8 v1, v1, 0x1

    aget-byte v8, p0, v1

    and-int/lit16 v8, v8, 0xff

    shr-int/lit8 v8, v8, 0x4

    or-int/2addr v7, v8

    aget-byte v7, v6, v7

    aput-byte v7, v0, v3

    add-int/lit8 v3, v4, 0x1

    aget-byte p0, p0, v1

    and-int/lit8 p0, p0, 0xf

    shl-int/lit8 p0, p0, 0x2

    aget-byte p0, v6, p0

    aput-byte p0, v0, v4

    add-int/lit8 v4, v3, 0x1

    aput-byte v5, v0, v3

    goto :goto_1

    :pswitch_1
    add-int/lit8 v3, v4, 0x1

    sget-object v6, Lcom/baidu/android/bbalbs/common/a/b;->a:[B

    aget-byte v7, p0, v1

    and-int/lit16 v7, v7, 0xff

    shr-int/lit8 v7, v7, 0x2

    aget-byte v7, v6, v7

    aput-byte v7, v0, v4

    add-int/lit8 v4, v3, 0x1

    aget-byte p0, p0, v1

    and-int/lit8 p0, p0, 0x3

    shl-int/lit8 p0, p0, 0x4

    aget-byte p0, v6, p0

    aput-byte p0, v0, v3

    add-int/lit8 p0, v4, 0x1

    aput-byte v5, v0, v4

    add-int/lit8 v4, p0, 0x1

    aput-byte v5, v0, p0

    :goto_1
    new-instance p0, Ljava/lang/String;

    invoke-direct {p0, v0, v2, v4, p1}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V

    return-object p0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public static a([B)[B
    .locals 1

    array-length v0, p0

    invoke-static {p0, v0}, Lcom/baidu/android/bbalbs/common/a/b;->a([BI)[B

    move-result-object p0

    return-object p0
.end method

.method public static a([BI)[B
    .locals 16

    div-int/lit8 v0, p1, 0x4

    const/4 v1, 0x3

    mul-int/lit8 v0, v0, 0x3

    const/4 v2, 0x0

    if-nez v0, :cond_0

    new-array v0, v2, [B

    return-object v0

    :cond_0
    new-array v0, v0, [B

    move/from16 v3, p1

    const/4 v4, 0x0

    :goto_0
    add-int/lit8 v5, v3, -0x1

    aget-byte v5, p0, v5

    const/16 v6, 0xa

    if-eq v5, v6, :cond_e

    const/16 v7, 0xd

    if-eq v5, v7, :cond_e

    const/16 v8, 0x20

    if-eq v5, v8, :cond_e

    const/16 v9, 0x9

    if-ne v5, v9, :cond_1

    goto/16 :goto_6

    :cond_1
    const/16 v10, 0x3d

    if-ne v5, v10, :cond_2

    add-int/lit8 v4, v4, 0x1

    goto/16 :goto_6

    :cond_2
    const/4 v5, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    :goto_1
    const v13, 0xff00

    const/high16 v14, 0xff0000

    if-ge v5, v3, :cond_b

    aget-byte v15, p0, v5

    if-eq v15, v6, :cond_a

    if-eq v15, v7, :cond_a

    if-eq v15, v8, :cond_a

    if-ne v15, v9, :cond_3

    goto :goto_4

    :cond_3
    const/16 v6, 0x41

    if-lt v15, v6, :cond_4

    const/16 v6, 0x5a

    if-gt v15, v6, :cond_4

    add-int/lit8 v15, v15, -0x41

    goto :goto_2

    :cond_4
    const/16 v6, 0x61

    if-lt v15, v6, :cond_5

    const/16 v6, 0x7a

    if-gt v15, v6, :cond_5

    add-int/lit8 v15, v15, -0x47

    goto :goto_2

    :cond_5
    const/16 v6, 0x30

    if-lt v15, v6, :cond_6

    const/16 v6, 0x39

    if-gt v15, v6, :cond_6

    add-int/lit8 v15, v15, 0x4

    goto :goto_2

    :cond_6
    const/16 v6, 0x2b

    if-ne v15, v6, :cond_7

    const/16 v15, 0x3e

    goto :goto_2

    :cond_7
    const/16 v6, 0x2f

    if-ne v15, v6, :cond_9

    const/16 v15, 0x3f

    :goto_2
    shl-int/lit8 v6, v10, 0x6

    int-to-byte v10, v15

    or-int/2addr v6, v10

    rem-int/lit8 v10, v12, 0x4

    if-ne v10, v1, :cond_8

    add-int/lit8 v10, v11, 0x1

    and-int/2addr v14, v6

    shr-int/lit8 v14, v14, 0x10

    int-to-byte v14, v14

    aput-byte v14, v0, v11

    add-int/lit8 v11, v10, 0x1

    and-int/2addr v13, v6

    shr-int/lit8 v13, v13, 0x8

    int-to-byte v13, v13

    aput-byte v13, v0, v10

    add-int/lit8 v10, v11, 0x1

    and-int/lit16 v13, v6, 0xff

    int-to-byte v13, v13

    aput-byte v13, v0, v11

    goto :goto_3

    :cond_8
    move v10, v11

    :goto_3
    add-int/lit8 v12, v12, 0x1

    move v11, v10

    move v10, v6

    goto :goto_4

    :cond_9
    const/4 v0, 0x0

    return-object v0

    :cond_a
    :goto_4
    add-int/lit8 v5, v5, 0x1

    const/16 v6, 0xa

    goto :goto_1

    :cond_b
    if-lez v4, :cond_d

    mul-int/lit8 v1, v4, 0x6

    shl-int v1, v10, v1

    add-int/lit8 v3, v11, 0x1

    and-int v5, v1, v14

    shr-int/lit8 v5, v5, 0x10

    int-to-byte v5, v5

    aput-byte v5, v0, v11

    const/4 v5, 0x1

    if-ne v4, v5, :cond_c

    add-int/lit8 v11, v3, 0x1

    and-int/2addr v1, v13

    shr-int/lit8 v1, v1, 0x8

    int-to-byte v1, v1

    aput-byte v1, v0, v3

    goto :goto_5

    :cond_c
    move v11, v3

    :cond_d
    :goto_5
    new-array v1, v11, [B

    invoke-static {v0, v2, v1, v2, v11}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v1

    :cond_e
    :goto_6
    add-int/lit8 v3, v3, -0x1

    goto/16 :goto_0
.end method
