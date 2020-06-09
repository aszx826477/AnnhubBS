.class Lokhttp3/internal/http/Http1xStream$FixedLengthSource;
.super Lokhttp3/internal/http/Http1xStream$AbstractSource;
.source "Http1xStream.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lokhttp3/internal/http/Http1xStream;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FixedLengthSource"
.end annotation


# instance fields
.field private bytesRemaining:J

.field final synthetic this$0:Lokhttp3/internal/http/Http1xStream;


# direct methods
.method public constructor <init>(Lokhttp3/internal/http/Http1xStream;J)V
    .locals 4
    .param p2, "length"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 365
    iput-object p1, p0, Lokhttp3/internal/http/Http1xStream$FixedLengthSource;->this$0:Lokhttp3/internal/http/Http1xStream;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lokhttp3/internal/http/Http1xStream$AbstractSource;-><init>(Lokhttp3/internal/http/Http1xStream;Lokhttp3/internal/http/Http1xStream$1;)V

    .line 366
    iput-wide p2, p0, Lokhttp3/internal/http/Http1xStream$FixedLengthSource;->bytesRemaining:J

    .line 367
    iget-wide v0, p0, Lokhttp3/internal/http/Http1xStream$FixedLengthSource;->bytesRemaining:J

    const-wide/16 v2, 0x0

    cmp-long p1, v0, v2

    if-nez p1, :cond_0

    .line 368
    const/4 p1, 0x1

    invoke-virtual {p0, p1}, Lokhttp3/internal/http/Http1xStream$FixedLengthSource;->endOfInput(Z)V

    goto :goto_0

    .line 367
    :cond_0
    nop

    .line 370
    :goto_0
    return-void
.end method


# virtual methods
.method public close()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 391
    iget-boolean v0, p0, Lokhttp3/internal/http/Http1xStream$FixedLengthSource;->closed:Z

    if-eqz v0, :cond_0

    return-void

    .line 393
    :cond_0
    iget-wide v0, p0, Lokhttp3/internal/http/Http1xStream$FixedLengthSource;->bytesRemaining:J

    const-wide/16 v2, 0x0

    cmp-long v4, v0, v2

    if-eqz v4, :cond_1

    const/16 v0, 0x64

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-static {p0, v0, v1}, Lokhttp3/internal/Util;->discard(Lokio/Source;ILjava/util/concurrent/TimeUnit;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 394
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lokhttp3/internal/http/Http1xStream$FixedLengthSource;->endOfInput(Z)V

    goto :goto_0

    .line 393
    :cond_1
    nop

    .line 397
    :goto_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lokhttp3/internal/http/Http1xStream$FixedLengthSource;->closed:Z

    .line 398
    return-void
.end method

.method public read(Lokio/Buffer;J)J
    .locals 8
    .param p1, "sink"    # Lokio/Buffer;
    .param p2, "byteCount"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 373
    const-wide/16 v0, 0x0

    cmp-long v2, p2, v0

    if-ltz v2, :cond_4

    .line 374
    iget-boolean v2, p0, Lokhttp3/internal/http/Http1xStream$FixedLengthSource;->closed:Z

    if-nez v2, :cond_3

    .line 375
    iget-wide v2, p0, Lokhttp3/internal/http/Http1xStream$FixedLengthSource;->bytesRemaining:J

    const-wide/16 v4, -0x1

    cmp-long v6, v2, v0

    if-nez v6, :cond_0

    return-wide v4

    .line 377
    :cond_0
    iget-object v2, p0, Lokhttp3/internal/http/Http1xStream$FixedLengthSource;->this$0:Lokhttp3/internal/http/Http1xStream;

    invoke-static {v2}, Lokhttp3/internal/http/Http1xStream;->access$600(Lokhttp3/internal/http/Http1xStream;)Lokio/BufferedSource;

    move-result-object v2

    iget-wide v6, p0, Lokhttp3/internal/http/Http1xStream$FixedLengthSource;->bytesRemaining:J

    invoke-static {v6, v7, p2, p3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v6

    invoke-interface {v2, p1, v6, v7}, Lokio/BufferedSource;->read(Lokio/Buffer;J)J

    move-result-wide v2

    .line 378
    .local v2, "read":J
    cmp-long v6, v2, v4

    if-eqz v6, :cond_2

    .line 383
    iget-wide v4, p0, Lokhttp3/internal/http/Http1xStream$FixedLengthSource;->bytesRemaining:J

    sub-long/2addr v4, v2

    iput-wide v4, p0, Lokhttp3/internal/http/Http1xStream$FixedLengthSource;->bytesRemaining:J

    .line 384
    iget-wide v4, p0, Lokhttp3/internal/http/Http1xStream$FixedLengthSource;->bytesRemaining:J

    cmp-long v6, v4, v0

    if-nez v6, :cond_1

    .line 385
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lokhttp3/internal/http/Http1xStream$FixedLengthSource;->endOfInput(Z)V

    goto :goto_0

    .line 384
    :cond_1
    nop

    .line 387
    :goto_0
    return-wide v2

    .line 379
    :cond_2
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lokhttp3/internal/http/Http1xStream$FixedLengthSource;->endOfInput(Z)V

    .line 380
    new-instance v0, Ljava/net/ProtocolException;

    const-string v1, "unexpected end of stream"

    invoke-direct {v0, v1}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 374
    .end local v2    # "read":J
    :cond_3
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "closed"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 373
    :cond_4
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "byteCount < 0: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
