.class Lokhttp3/internal/framed/NameValueBlockReader;
.super Ljava/lang/Object;
.source "NameValueBlockReader.java"


# instance fields
.field private compressedLimit:I

.field private final inflaterSource:Lokio/InflaterSource;

.field private final source:Lokio/BufferedSource;


# direct methods
.method public constructor <init>(Lokio/BufferedSource;)V
    .locals 3
    .param p1, "source"    # Lokio/BufferedSource;

    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    new-instance v0, Lokhttp3/internal/framed/NameValueBlockReader$1;

    invoke-direct {v0, p0, p1}, Lokhttp3/internal/framed/NameValueBlockReader$1;-><init>(Lokhttp3/internal/framed/NameValueBlockReader;Lokio/Source;)V

    .line 64
    .local v0, "throttleSource":Lokio/Source;
    new-instance v1, Lokhttp3/internal/framed/NameValueBlockReader$2;

    invoke-direct {v1, p0}, Lokhttp3/internal/framed/NameValueBlockReader$2;-><init>(Lokhttp3/internal/framed/NameValueBlockReader;)V

    .line 76
    .local v1, "inflater":Ljava/util/zip/Inflater;
    new-instance v2, Lokio/InflaterSource;

    invoke-direct {v2, v0, v1}, Lokio/InflaterSource;-><init>(Lokio/Source;Ljava/util/zip/Inflater;)V

    iput-object v2, p0, Lokhttp3/internal/framed/NameValueBlockReader;->inflaterSource:Lokio/InflaterSource;

    .line 77
    iget-object v2, p0, Lokhttp3/internal/framed/NameValueBlockReader;->inflaterSource:Lokio/InflaterSource;

    invoke-static {v2}, Lokio/Okio;->buffer(Lokio/Source;)Lokio/BufferedSource;

    move-result-object v2

    iput-object v2, p0, Lokhttp3/internal/framed/NameValueBlockReader;->source:Lokio/BufferedSource;

    .line 78
    return-void
.end method

.method static synthetic access$000(Lokhttp3/internal/framed/NameValueBlockReader;)I
    .locals 1
    .param p0, "x0"    # Lokhttp3/internal/framed/NameValueBlockReader;

    .line 36
    iget v0, p0, Lokhttp3/internal/framed/NameValueBlockReader;->compressedLimit:I

    return v0
.end method

.method static synthetic access$002(Lokhttp3/internal/framed/NameValueBlockReader;I)I
    .locals 0
    .param p0, "x0"    # Lokhttp3/internal/framed/NameValueBlockReader;
    .param p1, "x1"    # I

    .line 36
    iput p1, p0, Lokhttp3/internal/framed/NameValueBlockReader;->compressedLimit:I

    return p1
.end method

.method private doneReading()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 108
    iget v0, p0, Lokhttp3/internal/framed/NameValueBlockReader;->compressedLimit:I

    if-lez v0, :cond_1

    .line 109
    iget-object v0, p0, Lokhttp3/internal/framed/NameValueBlockReader;->inflaterSource:Lokio/InflaterSource;

    invoke-virtual {v0}, Lokio/InflaterSource;->refill()Z

    .line 110
    iget v0, p0, Lokhttp3/internal/framed/NameValueBlockReader;->compressedLimit:I

    if-nez v0, :cond_0

    goto :goto_0

    :cond_0
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "compressedLimit > 0: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v2, p0, Lokhttp3/internal/framed/NameValueBlockReader;->compressedLimit:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 108
    :cond_1
    nop

    .line 112
    :goto_0
    return-void
.end method

.method private readByteString()Lokio/ByteString;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 100
    iget-object v0, p0, Lokhttp3/internal/framed/NameValueBlockReader;->source:Lokio/BufferedSource;

    invoke-interface {v0}, Lokio/BufferedSource;->readInt()I

    move-result v0

    .line 101
    .local v0, "length":I
    iget-object v1, p0, Lokhttp3/internal/framed/NameValueBlockReader;->source:Lokio/BufferedSource;

    int-to-long v2, v0

    invoke-interface {v1, v2, v3}, Lokio/BufferedSource;->readByteString(J)Lokio/ByteString;

    move-result-object v1

    return-object v1
.end method


# virtual methods
.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 115
    iget-object v0, p0, Lokhttp3/internal/framed/NameValueBlockReader;->source:Lokio/BufferedSource;

    invoke-interface {v0}, Lokio/BufferedSource;->close()V

    .line 116
    return-void
.end method

.method public readNameValueBlock(I)Ljava/util/List;
    .locals 7
    .param p1, "length"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List<",
            "Lokhttp3/internal/framed/Header;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 81
    iget v0, p0, Lokhttp3/internal/framed/NameValueBlockReader;->compressedLimit:I

    add-int/2addr v0, p1

    iput v0, p0, Lokhttp3/internal/framed/NameValueBlockReader;->compressedLimit:I

    .line 83
    iget-object v0, p0, Lokhttp3/internal/framed/NameValueBlockReader;->source:Lokio/BufferedSource;

    invoke-interface {v0}, Lokio/BufferedSource;->readInt()I

    move-result v0

    .line 84
    .local v0, "numberOfPairs":I
    if-ltz v0, :cond_3

    .line 85
    const/16 v1, 0x400

    if-gt v0, v1, :cond_2

    .line 87
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 88
    .local v1, "entries":Ljava/util/List;, "Ljava/util/List<Lokhttp3/internal/framed/Header;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v0, :cond_1

    .line 89
    invoke-direct {p0}, Lokhttp3/internal/framed/NameValueBlockReader;->readByteString()Lokio/ByteString;

    move-result-object v3

    invoke-virtual {v3}, Lokio/ByteString;->toAsciiLowercase()Lokio/ByteString;

    move-result-object v3

    .line 90
    .local v3, "name":Lokio/ByteString;
    invoke-direct {p0}, Lokhttp3/internal/framed/NameValueBlockReader;->readByteString()Lokio/ByteString;

    move-result-object v4

    .line 91
    .local v4, "values":Lokio/ByteString;
    invoke-virtual {v3}, Lokio/ByteString;->size()I

    move-result v5

    if-eqz v5, :cond_0

    .line 92
    new-instance v5, Lokhttp3/internal/framed/Header;

    invoke-direct {v5, v3, v4}, Lokhttp3/internal/framed/Header;-><init>(Lokio/ByteString;Lokio/ByteString;)V

    invoke-interface {v1, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 88
    .end local v3    # "name":Lokio/ByteString;
    .end local v4    # "values":Lokio/ByteString;
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 91
    .restart local v3    # "name":Lokio/ByteString;
    .restart local v4    # "values":Lokio/ByteString;
    :cond_0
    new-instance v5, Ljava/io/IOException;

    const-string v6, "name.size == 0"

    invoke-direct {v5, v6}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 88
    .end local v3    # "name":Lokio/ByteString;
    .end local v4    # "values":Lokio/ByteString;
    :cond_1
    nop

    .line 95
    .end local v2    # "i":I
    invoke-direct {p0}, Lokhttp3/internal/framed/NameValueBlockReader;->doneReading()V

    .line 96
    return-object v1

    .line 85
    .end local v1    # "entries":Ljava/util/List;, "Ljava/util/List<Lokhttp3/internal/framed/Header;>;"
    :cond_2
    new-instance v1, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "numberOfPairs > 1024: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 84
    :cond_3
    new-instance v1, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "numberOfPairs < 0: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    return-void
.end method
