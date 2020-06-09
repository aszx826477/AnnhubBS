.class final Lokhttp3/internal/framed/Http2$FrameLogger;
.super Ljava/lang/Object;
.source "Http2.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lokhttp3/internal/framed/Http2;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "FrameLogger"
.end annotation


# static fields
.field private static final BINARY:[Ljava/lang/String;

.field private static final FLAGS:[Ljava/lang/String;

.field private static final TYPES:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 15

    .line 706
    const/16 v0, 0xa

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "DATA"

    const/4 v2, 0x0

    aput-object v1, v0, v2

    const-string v1, "HEADERS"

    const/4 v3, 0x1

    aput-object v1, v0, v3

    const-string v1, "PRIORITY"

    const/4 v4, 0x2

    aput-object v1, v0, v4

    const-string v1, "RST_STREAM"

    const/4 v4, 0x3

    aput-object v1, v0, v4

    const-string v1, "SETTINGS"

    const/4 v5, 0x4

    aput-object v1, v0, v5

    const-string v1, "PUSH_PROMISE"

    const/4 v6, 0x5

    aput-object v1, v0, v6

    const-string v1, "PING"

    const/4 v6, 0x6

    aput-object v1, v0, v6

    const-string v1, "GOAWAY"

    const/4 v6, 0x7

    aput-object v1, v0, v6

    const-string v1, "WINDOW_UPDATE"

    const/16 v6, 0x8

    aput-object v1, v0, v6

    const-string v1, "CONTINUATION"

    const/16 v7, 0x9

    aput-object v1, v0, v7

    sput-object v0, Lokhttp3/internal/framed/Http2$FrameLogger;->TYPES:[Ljava/lang/String;

    .line 723
    const/16 v0, 0x40

    new-array v0, v0, [Ljava/lang/String;

    sput-object v0, Lokhttp3/internal/framed/Http2$FrameLogger;->FLAGS:[Ljava/lang/String;

    .line 724
    const/16 v0, 0x100

    new-array v0, v0, [Ljava/lang/String;

    sput-object v0, Lokhttp3/internal/framed/Http2$FrameLogger;->BINARY:[Ljava/lang/String;

    .line 727
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    sget-object v1, Lokhttp3/internal/framed/Http2$FrameLogger;->BINARY:[Ljava/lang/String;

    array-length v7, v1

    const/16 v8, 0x20

    if-ge v0, v7, :cond_0

    .line 728
    const-string v7, "%8s"

    new-array v9, v3, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->toBinaryString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v2

    invoke-static {v7, v9}, Lokhttp3/internal/Util;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    const/16 v9, 0x30

    invoke-virtual {v7, v8, v9}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v1, v0

    .line 727
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 731
    .end local v0    # "i":I
    :cond_0
    sget-object v0, Lokhttp3/internal/framed/Http2$FrameLogger;->FLAGS:[Ljava/lang/String;

    const-string v1, ""

    aput-object v1, v0, v2

    .line 732
    const-string v1, "END_STREAM"

    aput-object v1, v0, v3

    .line 734
    new-array v1, v3, [I

    aput v3, v1, v2

    .line 736
    .local v1, "prefixFlags":[I
    const-string v3, "PADDED"

    aput-object v3, v0, v6

    .line 737
    array-length v0, v1

    const/4 v3, 0x0

    :goto_1
    if-ge v3, v0, :cond_1

    aget v7, v1, v3

    .line 738
    .local v7, "prefixFlag":I
    sget-object v9, Lokhttp3/internal/framed/Http2$FrameLogger;->FLAGS:[Ljava/lang/String;

    or-int/lit8 v10, v7, 0x8

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v12, Lokhttp3/internal/framed/Http2$FrameLogger;->FLAGS:[Ljava/lang/String;

    aget-object v12, v12, v7

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v12, "|PADDED"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    .line 737
    .end local v7    # "prefixFlag":I
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 741
    :cond_1
    sget-object v0, Lokhttp3/internal/framed/Http2$FrameLogger;->FLAGS:[Ljava/lang/String;

    const-string v3, "END_HEADERS"

    aput-object v3, v0, v5

    .line 742
    const-string v3, "PRIORITY"

    aput-object v3, v0, v8

    .line 743
    const/16 v3, 0x24

    const-string v5, "END_HEADERS|PRIORITY"

    aput-object v5, v0, v3

    .line 744
    new-array v0, v4, [I

    fill-array-data v0, :array_0

    .line 747
    .local v0, "frameFlags":[I
    array-length v3, v0

    const/4 v4, 0x0

    :goto_2
    if-ge v4, v3, :cond_3

    aget v5, v0, v4

    .line 748
    .local v5, "frameFlag":I
    array-length v7, v1

    const/4 v8, 0x0

    :goto_3
    if-ge v8, v7, :cond_2

    aget v9, v1, v8

    .line 749
    .local v9, "prefixFlag":I
    sget-object v10, Lokhttp3/internal/framed/Http2$FrameLogger;->FLAGS:[Ljava/lang/String;

    or-int v11, v9, v5

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v13, Lokhttp3/internal/framed/Http2$FrameLogger;->FLAGS:[Ljava/lang/String;

    aget-object v13, v13, v9

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v13, 0x7c

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    sget-object v14, Lokhttp3/internal/framed/Http2$FrameLogger;->FLAGS:[Ljava/lang/String;

    aget-object v14, v14, v5

    invoke-virtual {v12, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    .line 750
    sget-object v10, Lokhttp3/internal/framed/Http2$FrameLogger;->FLAGS:[Ljava/lang/String;

    or-int v11, v9, v5

    or-int/2addr v11, v6

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v14, Lokhttp3/internal/framed/Http2$FrameLogger;->FLAGS:[Ljava/lang/String;

    aget-object v14, v14, v9

    invoke-virtual {v12, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    sget-object v13, Lokhttp3/internal/framed/Http2$FrameLogger;->FLAGS:[Ljava/lang/String;

    aget-object v13, v13, v5

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v13, "|PADDED"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    .line 748
    .end local v9    # "prefixFlag":I
    add-int/lit8 v8, v8, 0x1

    goto :goto_3

    .line 747
    .end local v5    # "frameFlag":I
    :cond_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 755
    :cond_3
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_4
    sget-object v3, Lokhttp3/internal/framed/Http2$FrameLogger;->FLAGS:[Ljava/lang/String;

    array-length v4, v3

    if-ge v2, v4, :cond_5

    .line 756
    aget-object v4, v3, v2

    if-nez v4, :cond_4

    sget-object v4, Lokhttp3/internal/framed/Http2$FrameLogger;->BINARY:[Ljava/lang/String;

    aget-object v4, v4, v2

    aput-object v4, v3, v2

    nop

    .line 755
    :cond_4
    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    .line 758
    .end local v0    # "frameFlags":[I
    .end local v1    # "prefixFlags":[I
    .end local v2    # "i":I
    :cond_5
    return-void

    nop

    :array_0
    .array-data 4
        0x4
        0x20
        0x24
    .end array-data
.end method

.method constructor <init>()V
    .locals 0

    .line 669
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static formatFlags(BB)Ljava/lang/String;
    .locals 3
    .param p0, "type"    # B
    .param p1, "flags"    # B

    .line 684
    if-nez p1, :cond_0

    const-string v0, ""

    return-object v0

    .line 685
    :cond_0
    packed-switch p0, :pswitch_data_0

    .line 695
    :pswitch_0
    sget-object v0, Lokhttp3/internal/framed/Http2$FrameLogger;->FLAGS:[Ljava/lang/String;

    array-length v1, v0

    if-ge p1, v1, :cond_2

    aget-object v0, v0, p1

    goto :goto_1

    .line 688
    :pswitch_1
    const/4 v0, 0x1

    if-ne p1, v0, :cond_1

    const-string v0, "ACK"

    goto :goto_0

    :cond_1
    sget-object v0, Lokhttp3/internal/framed/Http2$FrameLogger;->BINARY:[Ljava/lang/String;

    aget-object v0, v0, p1

    :goto_0
    return-object v0

    .line 693
    :pswitch_2
    sget-object v0, Lokhttp3/internal/framed/Http2$FrameLogger;->BINARY:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0

    .line 695
    :cond_2
    sget-object v0, Lokhttp3/internal/framed/Http2$FrameLogger;->BINARY:[Ljava/lang/String;

    aget-object v0, v0, p1

    .line 697
    .local v0, "result":Ljava/lang/String;
    :goto_1
    const/4 v1, 0x5

    if-ne p0, v1, :cond_3

    and-int/lit8 v1, p1, 0x4

    if-eqz v1, :cond_3

    .line 698
    const-string v1, "HEADERS"

    const-string v2, "PUSH_PROMISE"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 697
    :cond_3
    nop

    .line 699
    if-nez p0, :cond_4

    and-int/lit8 v1, p1, 0x20

    if-eqz v1, :cond_4

    .line 700
    const-string v1, "PRIORITY"

    const-string v2, "COMPRESSED"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 699
    :cond_4
    nop

    .line 702
    return-object v0

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_2
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_2
    .end packed-switch
.end method

.method static formatHeader(ZIIBB)Ljava/lang/String;
    .locals 7
    .param p0, "inbound"    # Z
    .param p1, "streamId"    # I
    .param p2, "length"    # I
    .param p3, "type"    # B
    .param p4, "flags"    # B

    .line 672
    sget-object v0, Lokhttp3/internal/framed/Http2$FrameLogger;->TYPES:[Ljava/lang/String;

    array-length v1, v0

    const/4 v2, 0x0

    const/4 v3, 0x1

    if-ge p3, v1, :cond_0

    aget-object v0, v0, p3

    goto :goto_0

    :cond_0
    const-string v0, "0x%02x"

    new-array v1, v3, [Ljava/lang/Object;

    invoke-static {p3}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v4

    aput-object v4, v1, v2

    invoke-static {v0, v1}, Lokhttp3/internal/Util;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 673
    .local v0, "formattedType":Ljava/lang/String;
    :goto_0
    invoke-static {p3, p4}, Lokhttp3/internal/framed/Http2$FrameLogger;->formatFlags(BB)Ljava/lang/String;

    move-result-object v1

    .line 674
    .local v1, "formattedFlags":Ljava/lang/String;
    const-string v4, "%s 0x%08x %5d %-13s %s"

    const/4 v5, 0x5

    new-array v5, v5, [Ljava/lang/Object;

    if-eqz p0, :cond_1

    const-string v6, "<<"

    goto :goto_1

    :cond_1
    const-string v6, ">>"

    :goto_1
    aput-object v6, v5, v2

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v5, v3

    const/4 v2, 0x2

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v5, v2

    const/4 v2, 0x3

    aput-object v0, v5, v2

    const/4 v2, 0x4

    aput-object v1, v5, v2

    invoke-static {v4, v5}, Lokhttp3/internal/Util;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method
