.class public final Lcom/bumptech/glide/util/ByteArrayPool;
.super Ljava/lang/Object;
.source "ByteArrayPool.java"


# static fields
.field private static final BYTE_ARRAY_POOL:Lcom/bumptech/glide/util/ByteArrayPool;

.field private static final MAX_BYTE_ARRAY_COUNT:I = 0x20

.field private static final MAX_SIZE:I = 0x20c000

.field private static final TAG:Ljava/lang/String; = "ByteArrayPool"

.field private static final TEMP_BYTES_SIZE:I = 0x10000


# instance fields
.field private final tempQueue:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue<",
            "[B>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 19
    new-instance v0, Lcom/bumptech/glide/util/ByteArrayPool;

    invoke-direct {v0}, Lcom/bumptech/glide/util/ByteArrayPool;-><init>()V

    sput-object v0, Lcom/bumptech/glide/util/ByteArrayPool;->BYTE_ARRAY_POOL:Lcom/bumptech/glide/util/ByteArrayPool;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/bumptech/glide/util/Util;->createQueue(I)Ljava/util/Queue;

    move-result-object v0

    iput-object v0, p0, Lcom/bumptech/glide/util/ByteArrayPool;->tempQueue:Ljava/util/Queue;

    .line 28
    return-void
.end method

.method public static get()Lcom/bumptech/glide/util/ByteArrayPool;
    .locals 1

    .line 25
    sget-object v0, Lcom/bumptech/glide/util/ByteArrayPool;->BYTE_ARRAY_POOL:Lcom/bumptech/glide/util/ByteArrayPool;

    return-object v0
.end method


# virtual methods
.method public clear()V
    .locals 2

    .line 34
    iget-object v0, p0, Lcom/bumptech/glide/util/ByteArrayPool;->tempQueue:Ljava/util/Queue;

    monitor-enter v0

    .line 35
    :try_start_0
    iget-object v1, p0, Lcom/bumptech/glide/util/ByteArrayPool;->tempQueue:Ljava/util/Queue;

    invoke-interface {v1}, Ljava/util/Queue;->clear()V

    .line 36
    monitor-exit v0

    .line 37
    return-void

    .line 36
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public getBytes()[B
    .locals 3

    .line 45
    iget-object v0, p0, Lcom/bumptech/glide/util/ByteArrayPool;->tempQueue:Ljava/util/Queue;

    monitor-enter v0

    .line 46
    const/4 v1, 0x0

    :try_start_0
    iget-object v2, p0, Lcom/bumptech/glide/util/ByteArrayPool;->tempQueue:Ljava/util/Queue;

    invoke-interface {v2}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [B

    move-object v1, v2

    .line 47
    .local v1, "result":[B
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 48
    if-nez v1, :cond_1

    .line 49
    const/high16 v0, 0x10000

    new-array v1, v0, [B

    .line 50
    const-string v0, "ByteArrayPool"

    const/4 v2, 0x3

    invoke-static {v0, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 51
    const-string v0, "ByteArrayPool"

    const-string v2, "Created temp bytes"

    invoke-static {v0, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 50
    :cond_0
    goto :goto_0

    .line 48
    :cond_1
    nop

    .line 54
    :goto_0
    return-object v1

    .line 47
    .end local v1    # "result":[B
    :catchall_0
    move-exception v2

    .restart local v1    # "result":[B
    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2
.end method

.method public releaseBytes([B)Z
    .locals 4
    .param p1, "bytes"    # [B

    .line 64
    array-length v0, p1

    const/high16 v1, 0x10000

    if-eq v0, v1, :cond_0

    .line 65
    const/4 v0, 0x0

    return v0

    .line 68
    :cond_0
    const/4 v0, 0x0

    .line 69
    .local v0, "accepted":Z
    iget-object v1, p0, Lcom/bumptech/glide/util/ByteArrayPool;->tempQueue:Ljava/util/Queue;

    monitor-enter v1

    .line 70
    :try_start_0
    iget-object v2, p0, Lcom/bumptech/glide/util/ByteArrayPool;->tempQueue:Ljava/util/Queue;

    invoke-interface {v2}, Ljava/util/Queue;->size()I

    move-result v2

    const/16 v3, 0x20

    if-ge v2, v3, :cond_1

    .line 71
    const/4 v0, 0x1

    .line 72
    iget-object v2, p0, Lcom/bumptech/glide/util/ByteArrayPool;->tempQueue:Ljava/util/Queue;

    invoke-interface {v2, p1}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    goto :goto_0

    .line 70
    :cond_1
    nop

    .line 74
    :goto_0
    monitor-exit v1

    .line 75
    return v0

    .line 74
    :catchall_0
    move-exception v2

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method
