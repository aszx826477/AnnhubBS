.class public Lokhttp3/Response$Builder;
.super Ljava/lang/Object;
.source "Response.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lokhttp3/Response;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private body:Lokhttp3/ResponseBody;

.field private cacheResponse:Lokhttp3/Response;

.field private code:I

.field private handshake:Lokhttp3/Handshake;

.field private headers:Lokhttp3/Headers$Builder;

.field private message:Ljava/lang/String;

.field private networkResponse:Lokhttp3/Response;

.field private priorResponse:Lokhttp3/Response;

.field private protocol:Lokhttp3/Protocol;

.field private receivedResponseAtMillis:J

.field private request:Lokhttp3/Request;

.field private sentRequestAtMillis:J


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 298
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 287
    const/4 v0, -0x1

    iput v0, p0, Lokhttp3/Response$Builder;->code:I

    .line 299
    new-instance v0, Lokhttp3/Headers$Builder;

    invoke-direct {v0}, Lokhttp3/Headers$Builder;-><init>()V

    iput-object v0, p0, Lokhttp3/Response$Builder;->headers:Lokhttp3/Headers$Builder;

    .line 300
    return-void
.end method

.method private constructor <init>(Lokhttp3/Response;)V
    .locals 2
    .param p1, "response"    # Lokhttp3/Response;

    .line 302
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 287
    const/4 v0, -0x1

    iput v0, p0, Lokhttp3/Response$Builder;->code:I

    .line 303
    invoke-static {p1}, Lokhttp3/Response;->access$1300(Lokhttp3/Response;)Lokhttp3/Request;

    move-result-object v0

    iput-object v0, p0, Lokhttp3/Response$Builder;->request:Lokhttp3/Request;

    .line 304
    invoke-static {p1}, Lokhttp3/Response;->access$1400(Lokhttp3/Response;)Lokhttp3/Protocol;

    move-result-object v0

    iput-object v0, p0, Lokhttp3/Response$Builder;->protocol:Lokhttp3/Protocol;

    .line 305
    invoke-static {p1}, Lokhttp3/Response;->access$1500(Lokhttp3/Response;)I

    move-result v0

    iput v0, p0, Lokhttp3/Response$Builder;->code:I

    .line 306
    invoke-static {p1}, Lokhttp3/Response;->access$1600(Lokhttp3/Response;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lokhttp3/Response$Builder;->message:Ljava/lang/String;

    .line 307
    invoke-static {p1}, Lokhttp3/Response;->access$1700(Lokhttp3/Response;)Lokhttp3/Handshake;

    move-result-object v0

    iput-object v0, p0, Lokhttp3/Response$Builder;->handshake:Lokhttp3/Handshake;

    .line 308
    invoke-static {p1}, Lokhttp3/Response;->access$1800(Lokhttp3/Response;)Lokhttp3/Headers;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/Headers;->newBuilder()Lokhttp3/Headers$Builder;

    move-result-object v0

    iput-object v0, p0, Lokhttp3/Response$Builder;->headers:Lokhttp3/Headers$Builder;

    .line 309
    invoke-static {p1}, Lokhttp3/Response;->access$1900(Lokhttp3/Response;)Lokhttp3/ResponseBody;

    move-result-object v0

    iput-object v0, p0, Lokhttp3/Response$Builder;->body:Lokhttp3/ResponseBody;

    .line 310
    invoke-static {p1}, Lokhttp3/Response;->access$2000(Lokhttp3/Response;)Lokhttp3/Response;

    move-result-object v0

    iput-object v0, p0, Lokhttp3/Response$Builder;->networkResponse:Lokhttp3/Response;

    .line 311
    invoke-static {p1}, Lokhttp3/Response;->access$2100(Lokhttp3/Response;)Lokhttp3/Response;

    move-result-object v0

    iput-object v0, p0, Lokhttp3/Response$Builder;->cacheResponse:Lokhttp3/Response;

    .line 312
    invoke-static {p1}, Lokhttp3/Response;->access$2200(Lokhttp3/Response;)Lokhttp3/Response;

    move-result-object v0

    iput-object v0, p0, Lokhttp3/Response$Builder;->priorResponse:Lokhttp3/Response;

    .line 313
    invoke-static {p1}, Lokhttp3/Response;->access$2300(Lokhttp3/Response;)J

    move-result-wide v0

    iput-wide v0, p0, Lokhttp3/Response$Builder;->sentRequestAtMillis:J

    .line 314
    invoke-static {p1}, Lokhttp3/Response;->access$2400(Lokhttp3/Response;)J

    move-result-wide v0

    iput-wide v0, p0, Lokhttp3/Response$Builder;->receivedResponseAtMillis:J

    .line 315
    return-void
.end method

.method synthetic constructor <init>(Lokhttp3/Response;Lokhttp3/Response$1;)V
    .locals 0
    .param p1, "x0"    # Lokhttp3/Response;
    .param p2, "x1"    # Lokhttp3/Response$1;

    .line 284
    invoke-direct {p0, p1}, Lokhttp3/Response$Builder;-><init>(Lokhttp3/Response;)V

    return-void
.end method

.method static synthetic access$000(Lokhttp3/Response$Builder;)Lokhttp3/Request;
    .locals 1
    .param p0, "x0"    # Lokhttp3/Response$Builder;

    .line 284
    iget-object v0, p0, Lokhttp3/Response$Builder;->request:Lokhttp3/Request;

    return-object v0
.end method

.method static synthetic access$100(Lokhttp3/Response$Builder;)Lokhttp3/Protocol;
    .locals 1
    .param p0, "x0"    # Lokhttp3/Response$Builder;

    .line 284
    iget-object v0, p0, Lokhttp3/Response$Builder;->protocol:Lokhttp3/Protocol;

    return-object v0
.end method

.method static synthetic access$1000(Lokhttp3/Response$Builder;)J
    .locals 2
    .param p0, "x0"    # Lokhttp3/Response$Builder;

    .line 284
    iget-wide v0, p0, Lokhttp3/Response$Builder;->sentRequestAtMillis:J

    return-wide v0
.end method

.method static synthetic access$1100(Lokhttp3/Response$Builder;)J
    .locals 2
    .param p0, "x0"    # Lokhttp3/Response$Builder;

    .line 284
    iget-wide v0, p0, Lokhttp3/Response$Builder;->receivedResponseAtMillis:J

    return-wide v0
.end method

.method static synthetic access$200(Lokhttp3/Response$Builder;)I
    .locals 1
    .param p0, "x0"    # Lokhttp3/Response$Builder;

    .line 284
    iget v0, p0, Lokhttp3/Response$Builder;->code:I

    return v0
.end method

.method static synthetic access$300(Lokhttp3/Response$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lokhttp3/Response$Builder;

    .line 284
    iget-object v0, p0, Lokhttp3/Response$Builder;->message:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Lokhttp3/Response$Builder;)Lokhttp3/Handshake;
    .locals 1
    .param p0, "x0"    # Lokhttp3/Response$Builder;

    .line 284
    iget-object v0, p0, Lokhttp3/Response$Builder;->handshake:Lokhttp3/Handshake;

    return-object v0
.end method

.method static synthetic access$500(Lokhttp3/Response$Builder;)Lokhttp3/Headers$Builder;
    .locals 1
    .param p0, "x0"    # Lokhttp3/Response$Builder;

    .line 284
    iget-object v0, p0, Lokhttp3/Response$Builder;->headers:Lokhttp3/Headers$Builder;

    return-object v0
.end method

.method static synthetic access$600(Lokhttp3/Response$Builder;)Lokhttp3/ResponseBody;
    .locals 1
    .param p0, "x0"    # Lokhttp3/Response$Builder;

    .line 284
    iget-object v0, p0, Lokhttp3/Response$Builder;->body:Lokhttp3/ResponseBody;

    return-object v0
.end method

.method static synthetic access$700(Lokhttp3/Response$Builder;)Lokhttp3/Response;
    .locals 1
    .param p0, "x0"    # Lokhttp3/Response$Builder;

    .line 284
    iget-object v0, p0, Lokhttp3/Response$Builder;->networkResponse:Lokhttp3/Response;

    return-object v0
.end method

.method static synthetic access$800(Lokhttp3/Response$Builder;)Lokhttp3/Response;
    .locals 1
    .param p0, "x0"    # Lokhttp3/Response$Builder;

    .line 284
    iget-object v0, p0, Lokhttp3/Response$Builder;->cacheResponse:Lokhttp3/Response;

    return-object v0
.end method

.method static synthetic access$900(Lokhttp3/Response$Builder;)Lokhttp3/Response;
    .locals 1
    .param p0, "x0"    # Lokhttp3/Response$Builder;

    .line 284
    iget-object v0, p0, Lokhttp3/Response$Builder;->priorResponse:Lokhttp3/Response;

    return-object v0
.end method

.method private checkPriorResponse(Lokhttp3/Response;)V
    .locals 2
    .param p1, "response"    # Lokhttp3/Response;

    .line 407
    invoke-static {p1}, Lokhttp3/Response;->access$1900(Lokhttp3/Response;)Lokhttp3/ResponseBody;

    move-result-object v0

    if-nez v0, :cond_0

    .line 410
    return-void

    .line 408
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "priorResponse.body != null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private checkSupportResponse(Ljava/lang/String;Lokhttp3/Response;)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "response"    # Lokhttp3/Response;

    .line 389
    invoke-static {p2}, Lokhttp3/Response;->access$1900(Lokhttp3/Response;)Lokhttp3/ResponseBody;

    move-result-object v0

    if-nez v0, :cond_3

    .line 391
    invoke-static {p2}, Lokhttp3/Response;->access$2000(Lokhttp3/Response;)Lokhttp3/Response;

    move-result-object v0

    if-nez v0, :cond_2

    .line 393
    invoke-static {p2}, Lokhttp3/Response;->access$2100(Lokhttp3/Response;)Lokhttp3/Response;

    move-result-object v0

    if-nez v0, :cond_1

    .line 395
    invoke-static {p2}, Lokhttp3/Response;->access$2200(Lokhttp3/Response;)Lokhttp3/Response;

    move-result-object v0

    if-nez v0, :cond_0

    .line 398
    return-void

    .line 396
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, ".priorResponse != null"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 394
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, ".cacheResponse != null"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 392
    :cond_2
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, ".networkResponse != null"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 390
    :cond_3
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, ".body != null"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public addHeader(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Response$Builder;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .line 356
    iget-object v0, p0, Lokhttp3/Response$Builder;->headers:Lokhttp3/Headers$Builder;

    invoke-virtual {v0, p1, p2}, Lokhttp3/Headers$Builder;->add(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Headers$Builder;

    .line 357
    return-object p0
.end method

.method public body(Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;
    .locals 0
    .param p1, "body"    # Lokhttp3/ResponseBody;

    .line 372
    iput-object p1, p0, Lokhttp3/Response$Builder;->body:Lokhttp3/ResponseBody;

    .line 373
    return-object p0
.end method

.method public build()Lokhttp3/Response;
    .locals 3

    .line 423
    iget-object v0, p0, Lokhttp3/Response$Builder;->request:Lokhttp3/Request;

    if-eqz v0, :cond_2

    .line 424
    iget-object v0, p0, Lokhttp3/Response$Builder;->protocol:Lokhttp3/Protocol;

    if-eqz v0, :cond_1

    .line 425
    iget v0, p0, Lokhttp3/Response$Builder;->code:I

    if-ltz v0, :cond_0

    .line 426
    new-instance v0, Lokhttp3/Response;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lokhttp3/Response;-><init>(Lokhttp3/Response$Builder;Lokhttp3/Response$1;)V

    return-object v0

    .line 425
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "code < 0: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v2, p0, Lokhttp3/Response$Builder;->code:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 424
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "protocol == null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 423
    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "request == null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public cacheResponse(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    .locals 1
    .param p1, "cacheResponse"    # Lokhttp3/Response;

    .line 383
    if-eqz p1, :cond_0

    const-string v0, "cacheResponse"

    invoke-direct {p0, v0, p1}, Lokhttp3/Response$Builder;->checkSupportResponse(Ljava/lang/String;Lokhttp3/Response;)V

    nop

    .line 384
    :cond_0
    iput-object p1, p0, Lokhttp3/Response$Builder;->cacheResponse:Lokhttp3/Response;

    .line 385
    return-object p0
.end method

.method public code(I)Lokhttp3/Response$Builder;
    .locals 0
    .param p1, "code"    # I

    .line 328
    iput p1, p0, Lokhttp3/Response$Builder;->code:I

    .line 329
    return-object p0
.end method

.method public handshake(Lokhttp3/Handshake;)Lokhttp3/Response$Builder;
    .locals 0
    .param p1, "handshake"    # Lokhttp3/Handshake;

    .line 338
    iput-object p1, p0, Lokhttp3/Response$Builder;->handshake:Lokhttp3/Handshake;

    .line 339
    return-object p0
.end method

.method public header(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Response$Builder;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .line 347
    iget-object v0, p0, Lokhttp3/Response$Builder;->headers:Lokhttp3/Headers$Builder;

    invoke-virtual {v0, p1, p2}, Lokhttp3/Headers$Builder;->set(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Headers$Builder;

    .line 348
    return-object p0
.end method

.method public headers(Lokhttp3/Headers;)Lokhttp3/Response$Builder;
    .locals 1
    .param p1, "headers"    # Lokhttp3/Headers;

    .line 367
    invoke-virtual {p1}, Lokhttp3/Headers;->newBuilder()Lokhttp3/Headers$Builder;

    move-result-object v0

    iput-object v0, p0, Lokhttp3/Response$Builder;->headers:Lokhttp3/Headers$Builder;

    .line 368
    return-object p0
.end method

.method public message(Ljava/lang/String;)Lokhttp3/Response$Builder;
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .line 333
    iput-object p1, p0, Lokhttp3/Response$Builder;->message:Ljava/lang/String;

    .line 334
    return-object p0
.end method

.method public networkResponse(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    .locals 1
    .param p1, "networkResponse"    # Lokhttp3/Response;

    .line 377
    if-eqz p1, :cond_0

    const-string v0, "networkResponse"

    invoke-direct {p0, v0, p1}, Lokhttp3/Response$Builder;->checkSupportResponse(Ljava/lang/String;Lokhttp3/Response;)V

    nop

    .line 378
    :cond_0
    iput-object p1, p0, Lokhttp3/Response$Builder;->networkResponse:Lokhttp3/Response;

    .line 379
    return-object p0
.end method

.method public priorResponse(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    .locals 0
    .param p1, "priorResponse"    # Lokhttp3/Response;

    .line 401
    if-eqz p1, :cond_0

    invoke-direct {p0, p1}, Lokhttp3/Response$Builder;->checkPriorResponse(Lokhttp3/Response;)V

    nop

    .line 402
    :cond_0
    iput-object p1, p0, Lokhttp3/Response$Builder;->priorResponse:Lokhttp3/Response;

    .line 403
    return-object p0
.end method

.method public protocol(Lokhttp3/Protocol;)Lokhttp3/Response$Builder;
    .locals 0
    .param p1, "protocol"    # Lokhttp3/Protocol;

    .line 323
    iput-object p1, p0, Lokhttp3/Response$Builder;->protocol:Lokhttp3/Protocol;

    .line 324
    return-object p0
.end method

.method public receivedResponseAtMillis(J)Lokhttp3/Response$Builder;
    .locals 0
    .param p1, "receivedResponseAtMillis"    # J

    .line 418
    iput-wide p1, p0, Lokhttp3/Response$Builder;->receivedResponseAtMillis:J

    .line 419
    return-object p0
.end method

.method public removeHeader(Ljava/lang/String;)Lokhttp3/Response$Builder;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .line 361
    iget-object v0, p0, Lokhttp3/Response$Builder;->headers:Lokhttp3/Headers$Builder;

    invoke-virtual {v0, p1}, Lokhttp3/Headers$Builder;->removeAll(Ljava/lang/String;)Lokhttp3/Headers$Builder;

    .line 362
    return-object p0
.end method

.method public request(Lokhttp3/Request;)Lokhttp3/Response$Builder;
    .locals 0
    .param p1, "request"    # Lokhttp3/Request;

    .line 318
    iput-object p1, p0, Lokhttp3/Response$Builder;->request:Lokhttp3/Request;

    .line 319
    return-object p0
.end method

.method public sentRequestAtMillis(J)Lokhttp3/Response$Builder;
    .locals 0
    .param p1, "sentRequestAtMillis"    # J

    .line 413
    iput-wide p1, p0, Lokhttp3/Response$Builder;->sentRequestAtMillis:J

    .line 414
    return-object p0
.end method
