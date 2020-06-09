.class public final Lokio/HashingSource;
.super Lokio/ForwardingSource;
.source "HashingSource.java"


# instance fields
.field private final messageDigest:Ljava/security/MessageDigest;


# direct methods
.method private constructor <init>(Lokio/Source;Ljava/lang/String;)V
    .locals 2
    .param p1, "source"    # Lokio/Source;
    .param p2, "algorithm"    # Ljava/lang/String;

    .line 57
    invoke-direct {p0, p1}, Lokio/ForwardingSource;-><init>(Lokio/Source;)V

    .line 59
    :try_start_0
    invoke-static {p2}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    iput-object v0, p0, Lokio/HashingSource;->messageDigest:Ljava/security/MessageDigest;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    .line 62
    nop

    .line 63
    return-void

    .line 60
    :catch_0
    move-exception v0

    .line 61
    .local v0, "e":Ljava/security/NoSuchAlgorithmException;
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1}, Ljava/lang/AssertionError;-><init>()V

    throw v1
.end method

.method public static md5(Lokio/Source;)Lokio/HashingSource;
    .locals 2
    .param p0, "source"    # Lokio/Source;

    .line 43
    new-instance v0, Lokio/HashingSource;

    const-string v1, "MD5"

    invoke-direct {v0, p0, v1}, Lokio/HashingSource;-><init>(Lokio/Source;Ljava/lang/String;)V

    return-object v0
.end method

.method public static sha1(Lokio/Source;)Lokio/HashingSource;
    .locals 2
    .param p0, "source"    # Lokio/Source;

    .line 48
    new-instance v0, Lokio/HashingSource;

    const-string v1, "SHA-1"

    invoke-direct {v0, p0, v1}, Lokio/HashingSource;-><init>(Lokio/Source;Ljava/lang/String;)V

    return-object v0
.end method

.method public static sha256(Lokio/Source;)Lokio/HashingSource;
    .locals 2
    .param p0, "source"    # Lokio/Source;

    .line 53
    new-instance v0, Lokio/HashingSource;

    const-string v1, "SHA-256"

    invoke-direct {v0, p0, v1}, Lokio/HashingSource;-><init>(Lokio/Source;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public hash()Lokio/ByteString;
    .locals 2

    .line 99
    iget-object v0, p0, Lokio/HashingSource;->messageDigest:Ljava/security/MessageDigest;

    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v0

    .line 100
    .local v0, "result":[B
    invoke-static {v0}, Lokio/ByteString;->of([B)Lokio/ByteString;

    move-result-object v1

    return-object v1
.end method

.method public read(Lokio/Buffer;J)J
    .locals 11
    .param p1, "sink"    # Lokio/Buffer;
    .param p2, "byteCount"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 66
    invoke-super {p0, p1, p2, p3}, Lokio/ForwardingSource;->read(Lokio/Buffer;J)J

    move-result-wide v0

    .line 68
    .local v0, "result":J
    const-wide/16 v2, -0x1

    cmp-long v4, v0, v2

    if-eqz v4, :cond_2

    .line 69
    iget-wide v2, p1, Lokio/Buffer;->size:J

    sub-long/2addr v2, v0

    .line 72
    .local v2, "start":J
    iget-wide v4, p1, Lokio/Buffer;->size:J

    .line 73
    .local v4, "offset":J
    iget-object v6, p1, Lokio/Buffer;->head:Lokio/Segment;

    .line 74
    .local v6, "s":Lokio/Segment;
    :goto_0
    cmp-long v7, v4, v2

    if-lez v7, :cond_0

    .line 75
    iget-object v6, v6, Lokio/Segment;->prev:Lokio/Segment;

    .line 76
    iget v7, v6, Lokio/Segment;->limit:I

    iget v8, v6, Lokio/Segment;->pos:I

    sub-int/2addr v7, v8

    int-to-long v7, v7

    sub-long/2addr v4, v7

    goto :goto_0

    .line 74
    :cond_0
    nop

    .line 80
    :goto_1
    iget-wide v7, p1, Lokio/Buffer;->size:J

    cmp-long v9, v4, v7

    if-gez v9, :cond_1

    .line 81
    iget v7, v6, Lokio/Segment;->pos:I

    int-to-long v7, v7

    add-long/2addr v7, v2

    sub-long/2addr v7, v4

    long-to-int v8, v7

    .line 82
    .local v8, "pos":I
    iget-object v7, p0, Lokio/HashingSource;->messageDigest:Ljava/security/MessageDigest;

    iget-object v9, v6, Lokio/Segment;->data:[B

    iget v10, v6, Lokio/Segment;->limit:I

    sub-int/2addr v10, v8

    invoke-virtual {v7, v9, v8, v10}, Ljava/security/MessageDigest;->update([BII)V

    .line 83
    iget v7, v6, Lokio/Segment;->limit:I

    iget v9, v6, Lokio/Segment;->pos:I

    sub-int/2addr v7, v9

    int-to-long v9, v7

    add-long/2addr v4, v9

    .line 84
    move-wide v2, v4

    .line 85
    iget-object v6, v6, Lokio/Segment;->next:Lokio/Segment;

    .line 86
    .end local v8    # "pos":I
    goto :goto_1

    .line 80
    :cond_1
    goto :goto_2

    .line 68
    .end local v2    # "start":J
    .end local v4    # "offset":J
    .end local v6    # "s":Lokio/Segment;
    :cond_2
    nop

    .line 89
    :goto_2
    return-wide v0
.end method
