.class abstract Lokhttp3/internal/http/Http1xStream$AbstractSource;
.super Ljava/lang/Object;
.source "Http1xStream.java"

# interfaces
.implements Lokio/Source;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lokhttp3/internal/http/Http1xStream;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "AbstractSource"
.end annotation


# instance fields
.field protected closed:Z

.field final synthetic this$0:Lokhttp3/internal/http/Http1xStream;

.field protected final timeout:Lokio/ForwardingTimeout;


# direct methods
.method private constructor <init>(Lokhttp3/internal/http/Http1xStream;)V
    .locals 1

    .line 336
    iput-object p1, p0, Lokhttp3/internal/http/Http1xStream$AbstractSource;->this$0:Lokhttp3/internal/http/Http1xStream;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 337
    new-instance p1, Lokio/ForwardingTimeout;

    iget-object v0, p0, Lokhttp3/internal/http/Http1xStream$AbstractSource;->this$0:Lokhttp3/internal/http/Http1xStream;

    invoke-static {v0}, Lokhttp3/internal/http/Http1xStream;->access$600(Lokhttp3/internal/http/Http1xStream;)Lokio/BufferedSource;

    move-result-object v0

    invoke-interface {v0}, Lokio/BufferedSource;->timeout()Lokio/Timeout;

    move-result-object v0

    invoke-direct {p1, v0}, Lokio/ForwardingTimeout;-><init>(Lokio/Timeout;)V

    iput-object p1, p0, Lokhttp3/internal/http/Http1xStream$AbstractSource;->timeout:Lokio/ForwardingTimeout;

    return-void
.end method

.method synthetic constructor <init>(Lokhttp3/internal/http/Http1xStream;Lokhttp3/internal/http/Http1xStream$1;)V
    .locals 0
    .param p1, "x0"    # Lokhttp3/internal/http/Http1xStream;
    .param p2, "x1"    # Lokhttp3/internal/http/Http1xStream$1;

    .line 336
    invoke-direct {p0, p1}, Lokhttp3/internal/http/Http1xStream$AbstractSource;-><init>(Lokhttp3/internal/http/Http1xStream;)V

    return-void
.end method


# virtual methods
.method protected final endOfInput(Z)V
    .locals 3
    .param p1, "reuseConnection"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 349
    iget-object v0, p0, Lokhttp3/internal/http/Http1xStream$AbstractSource;->this$0:Lokhttp3/internal/http/Http1xStream;

    invoke-static {v0}, Lokhttp3/internal/http/Http1xStream;->access$500(Lokhttp3/internal/http/Http1xStream;)I

    move-result v0

    const/4 v1, 0x6

    if-ne v0, v1, :cond_0

    return-void

    .line 350
    :cond_0
    iget-object v0, p0, Lokhttp3/internal/http/Http1xStream$AbstractSource;->this$0:Lokhttp3/internal/http/Http1xStream;

    invoke-static {v0}, Lokhttp3/internal/http/Http1xStream;->access$500(Lokhttp3/internal/http/Http1xStream;)I

    move-result v0

    const/4 v2, 0x5

    if-ne v0, v2, :cond_2

    .line 352
    iget-object v0, p0, Lokhttp3/internal/http/Http1xStream$AbstractSource;->this$0:Lokhttp3/internal/http/Http1xStream;

    iget-object v2, p0, Lokhttp3/internal/http/Http1xStream$AbstractSource;->timeout:Lokio/ForwardingTimeout;

    invoke-static {v0, v2}, Lokhttp3/internal/http/Http1xStream;->access$400(Lokhttp3/internal/http/Http1xStream;Lokio/ForwardingTimeout;)V

    .line 354
    iget-object v0, p0, Lokhttp3/internal/http/Http1xStream$AbstractSource;->this$0:Lokhttp3/internal/http/Http1xStream;

    invoke-static {v0, v1}, Lokhttp3/internal/http/Http1xStream;->access$502(Lokhttp3/internal/http/Http1xStream;I)I

    .line 355
    iget-object v0, p0, Lokhttp3/internal/http/Http1xStream$AbstractSource;->this$0:Lokhttp3/internal/http/Http1xStream;

    invoke-static {v0}, Lokhttp3/internal/http/Http1xStream;->access$700(Lokhttp3/internal/http/Http1xStream;)Lokhttp3/internal/connection/StreamAllocation;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 356
    iget-object v0, p0, Lokhttp3/internal/http/Http1xStream$AbstractSource;->this$0:Lokhttp3/internal/http/Http1xStream;

    invoke-static {v0}, Lokhttp3/internal/http/Http1xStream;->access$700(Lokhttp3/internal/http/Http1xStream;)Lokhttp3/internal/connection/StreamAllocation;

    move-result-object v0

    xor-int/lit8 v1, p1, 0x1

    iget-object v2, p0, Lokhttp3/internal/http/Http1xStream$AbstractSource;->this$0:Lokhttp3/internal/http/Http1xStream;

    invoke-virtual {v0, v1, v2}, Lokhttp3/internal/connection/StreamAllocation;->streamFinished(ZLokhttp3/internal/http/HttpStream;)V

    goto :goto_0

    .line 355
    :cond_1
    nop

    .line 358
    :goto_0
    return-void

    .line 350
    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "state: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Lokhttp3/internal/http/Http1xStream$AbstractSource;->this$0:Lokhttp3/internal/http/Http1xStream;

    invoke-static {v2}, Lokhttp3/internal/http/Http1xStream;->access$500(Lokhttp3/internal/http/Http1xStream;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public timeout()Lokio/Timeout;
    .locals 1

    .line 341
    iget-object v0, p0, Lokhttp3/internal/http/Http1xStream$AbstractSource;->timeout:Lokio/ForwardingTimeout;

    return-object v0
.end method
