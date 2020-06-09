.class final Lokhttp3/internal/framed/Hpack$Reader;
.super Ljava/lang/Object;
.source "Hpack.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lokhttp3/internal/framed/Hpack;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "Reader"
.end annotation


# instance fields
.field dynamicTable:[Lokhttp3/internal/framed/Header;

.field dynamicTableByteCount:I

.field headerCount:I

.field private final headerList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lokhttp3/internal/framed/Header;",
            ">;"
        }
    .end annotation
.end field

.field private final headerTableSizeSetting:I

.field private maxDynamicTableByteCount:I

.field nextHeaderIndex:I

.field private final source:Lokio/BufferedSource;


# direct methods
.method constructor <init>(IILokio/Source;)V
    .locals 1
    .param p1, "headerTableSizeSetting"    # I
    .param p2, "maxDynamicTableByteCount"    # I
    .param p3, "source"    # Lokio/Source;

    .line 134
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 117
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerList:Ljava/util/List;

    .line 124
    const/16 v0, 0x8

    new-array v0, v0, [Lokhttp3/internal/framed/Header;

    iput-object v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTable:[Lokhttp3/internal/framed/Header;

    .line 126
    iget-object v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTable:[Lokhttp3/internal/framed/Header;

    array-length v0, v0

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->nextHeaderIndex:I

    .line 127
    const/4 v0, 0x0

    iput v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerCount:I

    .line 128
    iput v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTableByteCount:I

    .line 135
    iput p1, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerTableSizeSetting:I

    .line 136
    iput p2, p0, Lokhttp3/internal/framed/Hpack$Reader;->maxDynamicTableByteCount:I

    .line 137
    invoke-static {p3}, Lokio/Okio;->buffer(Lokio/Source;)Lokio/BufferedSource;

    move-result-object v0

    iput-object v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->source:Lokio/BufferedSource;

    .line 138
    return-void
.end method

.method constructor <init>(ILokio/Source;)V
    .locals 0
    .param p1, "headerTableSizeSetting"    # I
    .param p2, "source"    # Lokio/Source;

    .line 131
    invoke-direct {p0, p1, p1, p2}, Lokhttp3/internal/framed/Hpack$Reader;-><init>(IILokio/Source;)V

    .line 132
    return-void
.end method

.method private adjustDynamicTableByteCount()V
    .locals 2

    .line 145
    iget v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->maxDynamicTableByteCount:I

    iget v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTableByteCount:I

    if-ge v0, v1, :cond_1

    .line 146
    if-nez v0, :cond_0

    .line 147
    invoke-direct {p0}, Lokhttp3/internal/framed/Hpack$Reader;->clearDynamicTable()V

    goto :goto_0

    .line 149
    :cond_0
    sub-int/2addr v1, v0

    invoke-direct {p0, v1}, Lokhttp3/internal/framed/Hpack$Reader;->evictToRecoverBytes(I)I

    goto :goto_0

    .line 145
    :cond_1
    nop

    .line 152
    :goto_0
    return-void
.end method

.method private clearDynamicTable()V
    .locals 2

    .line 155
    iget-object v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 156
    iget-object v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTable:[Lokhttp3/internal/framed/Header;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Ljava/util/Arrays;->fill([Ljava/lang/Object;Ljava/lang/Object;)V

    .line 157
    iget-object v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTable:[Lokhttp3/internal/framed/Header;

    array-length v0, v0

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->nextHeaderIndex:I

    .line 158
    const/4 v0, 0x0

    iput v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerCount:I

    .line 159
    iput v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTableByteCount:I

    .line 160
    return-void
.end method

.method private dynamicTableIndex(I)I
    .locals 1
    .param p1, "index"    # I

    .line 234
    iget v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->nextHeaderIndex:I

    add-int/lit8 v0, v0, 0x1

    add-int/2addr v0, p1

    return v0
.end method

.method private evictToRecoverBytes(I)I
    .locals 5
    .param p1, "bytesToRecover"    # I

    .line 164
    const/4 v0, 0x0

    .line 165
    .local v0, "entriesToEvict":I
    if-lez p1, :cond_1

    .line 167
    iget-object v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTable:[Lokhttp3/internal/framed/Header;

    array-length v1, v1

    add-int/lit8 v1, v1, -0x1

    .local v1, "j":I
    :goto_0
    iget v2, p0, Lokhttp3/internal/framed/Hpack$Reader;->nextHeaderIndex:I

    if-lt v1, v2, :cond_0

    if-lez p1, :cond_0

    .line 168
    iget-object v2, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTable:[Lokhttp3/internal/framed/Header;

    aget-object v2, v2, v1

    iget v2, v2, Lokhttp3/internal/framed/Header;->hpackSize:I

    sub-int/2addr p1, v2

    .line 169
    iget v2, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTableByteCount:I

    iget-object v3, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTable:[Lokhttp3/internal/framed/Header;

    aget-object v3, v3, v1

    iget v3, v3, Lokhttp3/internal/framed/Header;->hpackSize:I

    sub-int/2addr v2, v3

    iput v2, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTableByteCount:I

    .line 170
    iget v2, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerCount:I

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerCount:I

    .line 171
    add-int/lit8 v0, v0, 0x1

    .line 167
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 173
    .end local v1    # "j":I
    :cond_0
    iget-object v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTable:[Lokhttp3/internal/framed/Header;

    iget v2, p0, Lokhttp3/internal/framed/Hpack$Reader;->nextHeaderIndex:I

    add-int/lit8 v3, v2, 0x1

    add-int/lit8 v2, v2, 0x1

    add-int/2addr v2, v0

    iget v4, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerCount:I

    invoke-static {v1, v3, v1, v2, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 175
    iget v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->nextHeaderIndex:I

    add-int/2addr v1, v0

    iput v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->nextHeaderIndex:I

    goto :goto_1

    .line 165
    :cond_1
    nop

    .line 177
    :goto_1
    return v0
.end method

.method private getName(I)Lokio/ByteString;
    .locals 2
    .param p1, "index"    # I

    .line 263
    invoke-direct {p0, p1}, Lokhttp3/internal/framed/Hpack$Reader;->isStaticHeader(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 264
    invoke-static {}, Lokhttp3/internal/framed/Hpack;->access$000()[Lokhttp3/internal/framed/Header;

    move-result-object v0

    aget-object v0, v0, p1

    iget-object v0, v0, Lokhttp3/internal/framed/Header;->name:Lokio/ByteString;

    return-object v0

    .line 266
    :cond_0
    iget-object v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTable:[Lokhttp3/internal/framed/Header;

    invoke-static {}, Lokhttp3/internal/framed/Hpack;->access$000()[Lokhttp3/internal/framed/Header;

    move-result-object v1

    array-length v1, v1

    sub-int v1, p1, v1

    invoke-direct {p0, v1}, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTableIndex(I)I

    move-result v1

    aget-object v0, v0, v1

    iget-object v0, v0, Lokhttp3/internal/framed/Header;->name:Lokio/ByteString;

    return-object v0
.end method

.method private insertIntoDynamicTable(ILokhttp3/internal/framed/Header;)V
    .locals 8
    .param p1, "index"    # I
    .param p2, "entry"    # Lokhttp3/internal/framed/Header;

    .line 276
    iget-object v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerList:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 278
    iget v0, p2, Lokhttp3/internal/framed/Header;->hpackSize:I

    .line 279
    .local v0, "delta":I
    const/4 v1, -0x1

    if-eq p1, v1, :cond_0

    .line 280
    iget-object v2, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTable:[Lokhttp3/internal/framed/Header;

    invoke-direct {p0, p1}, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTableIndex(I)I

    move-result v3

    aget-object v2, v2, v3

    iget v2, v2, Lokhttp3/internal/framed/Header;->hpackSize:I

    sub-int/2addr v0, v2

    goto :goto_0

    .line 279
    :cond_0
    nop

    .line 284
    :goto_0
    iget v2, p0, Lokhttp3/internal/framed/Hpack$Reader;->maxDynamicTableByteCount:I

    if-le v0, v2, :cond_1

    .line 285
    invoke-direct {p0}, Lokhttp3/internal/framed/Hpack$Reader;->clearDynamicTable()V

    .line 286
    return-void

    .line 290
    :cond_1
    iget v3, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTableByteCount:I

    add-int/2addr v3, v0

    sub-int/2addr v3, v2

    .line 291
    .local v3, "bytesToRecover":I
    invoke-direct {p0, v3}, Lokhttp3/internal/framed/Hpack$Reader;->evictToRecoverBytes(I)I

    move-result v2

    .line 293
    .local v2, "entriesEvicted":I
    if-ne p1, v1, :cond_3

    .line 294
    iget v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerCount:I

    add-int/lit8 v1, v1, 0x1

    iget-object v4, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTable:[Lokhttp3/internal/framed/Header;

    array-length v5, v4

    if-le v1, v5, :cond_2

    .line 295
    array-length v1, v4

    mul-int/lit8 v1, v1, 0x2

    new-array v1, v1, [Lokhttp3/internal/framed/Header;

    .line 296
    .local v1, "doubled":[Lokhttp3/internal/framed/Header;
    const/4 v5, 0x0

    array-length v6, v4

    array-length v7, v4

    invoke-static {v4, v5, v1, v6, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 297
    iget-object v4, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTable:[Lokhttp3/internal/framed/Header;

    array-length v4, v4

    add-int/lit8 v4, v4, -0x1

    iput v4, p0, Lokhttp3/internal/framed/Hpack$Reader;->nextHeaderIndex:I

    .line 298
    iput-object v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTable:[Lokhttp3/internal/framed/Header;

    goto :goto_1

    .line 294
    .end local v1    # "doubled":[Lokhttp3/internal/framed/Header;
    :cond_2
    nop

    .line 300
    :goto_1
    iget v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->nextHeaderIndex:I

    add-int/lit8 v4, v1, -0x1

    iput v4, p0, Lokhttp3/internal/framed/Hpack$Reader;->nextHeaderIndex:I

    move p1, v1

    .line 301
    iget-object v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTable:[Lokhttp3/internal/framed/Header;

    aput-object p2, v1, p1

    .line 302
    iget v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerCount:I

    goto :goto_2

    .line 304
    :cond_3
    invoke-direct {p0, p1}, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTableIndex(I)I

    move-result v1

    add-int/2addr v1, v2

    add-int/2addr p1, v1

    .line 305
    iget-object v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTable:[Lokhttp3/internal/framed/Header;

    aput-object p2, v1, p1

    .line 307
    :goto_2
    iget v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTableByteCount:I

    add-int/2addr v1, v0

    iput v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTableByteCount:I

    .line 308
    return-void
.end method

.method private isStaticHeader(I)Z
    .locals 2
    .param p1, "index"    # I

    .line 271
    const/4 v0, 0x1

    if-ltz p1, :cond_0

    invoke-static {}, Lokhttp3/internal/framed/Hpack;->access$000()[Lokhttp3/internal/framed/Header;

    move-result-object v1

    array-length v1, v1

    sub-int/2addr v1, v0

    if-gt p1, v1, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private readByte()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 311
    iget-object v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->source:Lokio/BufferedSource;

    invoke-interface {v0}, Lokio/BufferedSource;->readByte()B

    move-result v0

    and-int/lit16 v0, v0, 0xff

    return v0
.end method

.method private readIndexedHeader(I)V
    .locals 4
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 220
    invoke-direct {p0, p1}, Lokhttp3/internal/framed/Hpack$Reader;->isStaticHeader(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 221
    invoke-static {}, Lokhttp3/internal/framed/Hpack;->access$000()[Lokhttp3/internal/framed/Header;

    move-result-object v0

    aget-object v0, v0, p1

    .line 222
    .local v0, "staticEntry":Lokhttp3/internal/framed/Header;
    iget-object v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerList:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 223
    .end local v0    # "staticEntry":Lokhttp3/internal/framed/Header;
    goto :goto_0

    .line 224
    :cond_0
    invoke-static {}, Lokhttp3/internal/framed/Hpack;->access$000()[Lokhttp3/internal/framed/Header;

    move-result-object v0

    array-length v0, v0

    sub-int v0, p1, v0

    invoke-direct {p0, v0}, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTableIndex(I)I

    move-result v0

    .line 225
    .local v0, "dynamicTableIndex":I
    if-ltz v0, :cond_1

    iget-object v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->dynamicTable:[Lokhttp3/internal/framed/Header;

    array-length v2, v1

    add-int/lit8 v2, v2, -0x1

    if-gt v0, v2, :cond_1

    .line 228
    iget-object v2, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerList:Ljava/util/List;

    aget-object v1, v1, v0

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 230
    .end local v0    # "dynamicTableIndex":I
    :goto_0
    return-void

    .line 225
    .restart local v0    # "dynamicTableIndex":I
    :cond_1
    nop

    .line 226
    new-instance v1, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Header index too large "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v3, p1, 0x1

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private readLiteralHeaderWithIncrementalIndexingIndexedName(I)V
    .locals 4
    .param p1, "nameIndex"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 251
    invoke-direct {p0, p1}, Lokhttp3/internal/framed/Hpack$Reader;->getName(I)Lokio/ByteString;

    move-result-object v0

    .line 252
    .local v0, "name":Lokio/ByteString;
    invoke-virtual {p0}, Lokhttp3/internal/framed/Hpack$Reader;->readByteString()Lokio/ByteString;

    move-result-object v1

    .line 253
    .local v1, "value":Lokio/ByteString;
    new-instance v2, Lokhttp3/internal/framed/Header;

    invoke-direct {v2, v0, v1}, Lokhttp3/internal/framed/Header;-><init>(Lokio/ByteString;Lokio/ByteString;)V

    const/4 v3, -0x1

    invoke-direct {p0, v3, v2}, Lokhttp3/internal/framed/Hpack$Reader;->insertIntoDynamicTable(ILokhttp3/internal/framed/Header;)V

    .line 254
    return-void
.end method

.method private readLiteralHeaderWithIncrementalIndexingNewName()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 257
    invoke-virtual {p0}, Lokhttp3/internal/framed/Hpack$Reader;->readByteString()Lokio/ByteString;

    move-result-object v0

    invoke-static {v0}, Lokhttp3/internal/framed/Hpack;->access$100(Lokio/ByteString;)Lokio/ByteString;

    move-result-object v0

    .line 258
    .local v0, "name":Lokio/ByteString;
    invoke-virtual {p0}, Lokhttp3/internal/framed/Hpack$Reader;->readByteString()Lokio/ByteString;

    move-result-object v1

    .line 259
    .local v1, "value":Lokio/ByteString;
    new-instance v2, Lokhttp3/internal/framed/Header;

    invoke-direct {v2, v0, v1}, Lokhttp3/internal/framed/Header;-><init>(Lokio/ByteString;Lokio/ByteString;)V

    const/4 v3, -0x1

    invoke-direct {p0, v3, v2}, Lokhttp3/internal/framed/Hpack$Reader;->insertIntoDynamicTable(ILokhttp3/internal/framed/Header;)V

    .line 260
    return-void
.end method

.method private readLiteralHeaderWithoutIndexingIndexedName(I)V
    .locals 4
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 238
    invoke-direct {p0, p1}, Lokhttp3/internal/framed/Hpack$Reader;->getName(I)Lokio/ByteString;

    move-result-object v0

    .line 239
    .local v0, "name":Lokio/ByteString;
    invoke-virtual {p0}, Lokhttp3/internal/framed/Hpack$Reader;->readByteString()Lokio/ByteString;

    move-result-object v1

    .line 240
    .local v1, "value":Lokio/ByteString;
    iget-object v2, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerList:Ljava/util/List;

    new-instance v3, Lokhttp3/internal/framed/Header;

    invoke-direct {v3, v0, v1}, Lokhttp3/internal/framed/Header;-><init>(Lokio/ByteString;Lokio/ByteString;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 241
    return-void
.end method

.method private readLiteralHeaderWithoutIndexingNewName()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 244
    invoke-virtual {p0}, Lokhttp3/internal/framed/Hpack$Reader;->readByteString()Lokio/ByteString;

    move-result-object v0

    invoke-static {v0}, Lokhttp3/internal/framed/Hpack;->access$100(Lokio/ByteString;)Lokio/ByteString;

    move-result-object v0

    .line 245
    .local v0, "name":Lokio/ByteString;
    invoke-virtual {p0}, Lokhttp3/internal/framed/Hpack$Reader;->readByteString()Lokio/ByteString;

    move-result-object v1

    .line 246
    .local v1, "value":Lokio/ByteString;
    iget-object v2, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerList:Ljava/util/List;

    new-instance v3, Lokhttp3/internal/framed/Header;

    invoke-direct {v3, v0, v1}, Lokhttp3/internal/framed/Header;-><init>(Lokio/ByteString;Lokio/ByteString;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 247
    return-void
.end method


# virtual methods
.method public getAndResetHeaderList()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lokhttp3/internal/framed/Header;",
            ">;"
        }
    .end annotation

    .line 214
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerList:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 215
    .local v0, "result":Ljava/util/List;, "Ljava/util/List<Lokhttp3/internal/framed/Header;>;"
    iget-object v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerList:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 216
    return-object v0
.end method

.method maxDynamicTableByteCount()I
    .locals 1

    .line 141
    iget v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->maxDynamicTableByteCount:I

    return v0
.end method

.method readByteString()Lokio/ByteString;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 338
    invoke-direct {p0}, Lokhttp3/internal/framed/Hpack$Reader;->readByte()I

    move-result v0

    .line 339
    .local v0, "firstByte":I
    and-int/lit16 v1, v0, 0x80

    const/16 v2, 0x80

    if-ne v1, v2, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    .line 340
    .local v1, "huffmanDecode":Z
    :goto_0
    const/16 v2, 0x7f

    invoke-virtual {p0, v0, v2}, Lokhttp3/internal/framed/Hpack$Reader;->readInt(II)I

    move-result v2

    .line 342
    .local v2, "length":I
    if-eqz v1, :cond_1

    .line 343
    invoke-static {}, Lokhttp3/internal/framed/Huffman;->get()Lokhttp3/internal/framed/Huffman;

    move-result-object v3

    iget-object v4, p0, Lokhttp3/internal/framed/Hpack$Reader;->source:Lokio/BufferedSource;

    int-to-long v5, v2

    invoke-interface {v4, v5, v6}, Lokio/BufferedSource;->readByteArray(J)[B

    move-result-object v4

    invoke-virtual {v3, v4}, Lokhttp3/internal/framed/Huffman;->decode([B)[B

    move-result-object v3

    invoke-static {v3}, Lokio/ByteString;->of([B)Lokio/ByteString;

    move-result-object v3

    return-object v3

    .line 345
    :cond_1
    iget-object v3, p0, Lokhttp3/internal/framed/Hpack$Reader;->source:Lokio/BufferedSource;

    int-to-long v4, v2

    invoke-interface {v3, v4, v5}, Lokio/BufferedSource;->readByteString(J)Lokio/ByteString;

    move-result-object v3

    return-object v3
.end method

.method readHeaders()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 185
    :goto_0
    iget-object v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->source:Lokio/BufferedSource;

    invoke-interface {v0}, Lokio/BufferedSource;->exhausted()Z

    move-result v0

    if-nez v0, :cond_8

    .line 186
    iget-object v0, p0, Lokhttp3/internal/framed/Hpack$Reader;->source:Lokio/BufferedSource;

    invoke-interface {v0}, Lokio/BufferedSource;->readByte()B

    move-result v0

    and-int/lit16 v0, v0, 0xff

    .line 187
    .local v0, "b":I
    const/16 v1, 0x80

    if-eq v0, v1, :cond_7

    .line 189
    and-int/lit16 v2, v0, 0x80

    if-ne v2, v1, :cond_0

    .line 190
    const/16 v1, 0x7f

    invoke-virtual {p0, v0, v1}, Lokhttp3/internal/framed/Hpack$Reader;->readInt(II)I

    move-result v1

    .line 191
    .local v1, "index":I
    add-int/lit8 v2, v1, -0x1

    invoke-direct {p0, v2}, Lokhttp3/internal/framed/Hpack$Reader;->readIndexedHeader(I)V

    .line 192
    .end local v1    # "index":I
    goto :goto_2

    :cond_0
    const/16 v1, 0x40

    if-ne v0, v1, :cond_1

    .line 193
    invoke-direct {p0}, Lokhttp3/internal/framed/Hpack$Reader;->readLiteralHeaderWithIncrementalIndexingNewName()V

    goto :goto_2

    .line 194
    :cond_1
    and-int/lit8 v2, v0, 0x40

    if-ne v2, v1, :cond_2

    .line 195
    const/16 v1, 0x3f

    invoke-virtual {p0, v0, v1}, Lokhttp3/internal/framed/Hpack$Reader;->readInt(II)I

    move-result v1

    .line 196
    .restart local v1    # "index":I
    add-int/lit8 v2, v1, -0x1

    invoke-direct {p0, v2}, Lokhttp3/internal/framed/Hpack$Reader;->readLiteralHeaderWithIncrementalIndexingIndexedName(I)V

    .line 197
    .end local v1    # "index":I
    goto :goto_2

    :cond_2
    and-int/lit8 v1, v0, 0x20

    const/16 v2, 0x20

    if-ne v1, v2, :cond_4

    .line 198
    const/16 v1, 0x1f

    invoke-virtual {p0, v0, v1}, Lokhttp3/internal/framed/Hpack$Reader;->readInt(II)I

    move-result v1

    iput v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->maxDynamicTableByteCount:I

    .line 199
    iget v1, p0, Lokhttp3/internal/framed/Hpack$Reader;->maxDynamicTableByteCount:I

    if-ltz v1, :cond_3

    iget v2, p0, Lokhttp3/internal/framed/Hpack$Reader;->headerTableSizeSetting:I

    if-gt v1, v2, :cond_3

    .line 203
    invoke-direct {p0}, Lokhttp3/internal/framed/Hpack$Reader;->adjustDynamicTableByteCount()V

    goto :goto_2

    .line 199
    :cond_3
    nop

    .line 201
    new-instance v1, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Invalid dynamic table size update "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v3, p0, Lokhttp3/internal/framed/Hpack$Reader;->maxDynamicTableByteCount:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 204
    :cond_4
    const/16 v1, 0x10

    if-eq v0, v1, :cond_6

    if-nez v0, :cond_5

    goto :goto_1

    .line 207
    :cond_5
    const/16 v1, 0xf

    invoke-virtual {p0, v0, v1}, Lokhttp3/internal/framed/Hpack$Reader;->readInt(II)I

    move-result v1

    .line 208
    .restart local v1    # "index":I
    add-int/lit8 v2, v1, -0x1

    invoke-direct {p0, v2}, Lokhttp3/internal/framed/Hpack$Reader;->readLiteralHeaderWithoutIndexingIndexedName(I)V

    goto :goto_2

    .line 204
    .end local v1    # "index":I
    :cond_6
    :goto_1
    nop

    .line 205
    invoke-direct {p0}, Lokhttp3/internal/framed/Hpack$Reader;->readLiteralHeaderWithoutIndexingNewName()V

    .line 210
    .end local v0    # "b":I
    :goto_2
    goto/16 :goto_0

    .line 188
    .restart local v0    # "b":I
    :cond_7
    new-instance v1, Ljava/io/IOException;

    const-string v2, "index == 0"

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 211
    .end local v0    # "b":I
    :cond_8
    return-void
.end method

.method readInt(II)I
    .locals 5
    .param p1, "firstByte"    # I
    .param p2, "prefixMask"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 315
    and-int v0, p1, p2

    .line 316
    .local v0, "prefix":I
    if-ge v0, p2, :cond_0

    .line 317
    return v0

    .line 321
    :cond_0
    move v1, p2

    .line 322
    .local v1, "result":I
    const/4 v2, 0x0

    .line 324
    .local v2, "shift":I
    :goto_0
    invoke-direct {p0}, Lokhttp3/internal/framed/Hpack$Reader;->readByte()I

    move-result v3

    .line 325
    .local v3, "b":I
    and-int/lit16 v4, v3, 0x80

    if-eqz v4, :cond_1

    .line 326
    and-int/lit8 v4, v3, 0x7f

    shl-int/2addr v4, v2

    add-int/2addr v1, v4

    .line 327
    add-int/lit8 v2, v2, 0x7

    .line 332
    .end local v3    # "b":I
    goto :goto_0

    .line 329
    .restart local v3    # "b":I
    :cond_1
    shl-int v4, v3, v2

    add-int/2addr v1, v4

    .line 330
    nop

    .line 333
    .end local v3    # "b":I
    return v1
.end method
