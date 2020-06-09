.class public Lcom/bumptech/glide/load/model/StreamEncoder;
.super Ljava/lang/Object;
.source "StreamEncoder.java"

# interfaces
.implements Lcom/bumptech/glide/load/Encoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/bumptech/glide/load/Encoder<",
        "Ljava/io/InputStream;",
        ">;"
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "StreamEncoder"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public encode(Ljava/io/InputStream;Ljava/io/OutputStream;)Z
    .locals 5
    .param p1, "data"    # Ljava/io/InputStream;
    .param p2, "os"    # Ljava/io/OutputStream;

    .line 20
    invoke-static {}, Lcom/bumptech/glide/util/ByteArrayPool;->get()Lcom/bumptech/glide/util/ByteArrayPool;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bumptech/glide/util/ByteArrayPool;->getBytes()[B

    move-result-object v0

    .line 23
    .local v0, "buffer":[B
    :goto_0
    const/4 v1, 0x0

    :try_start_0
    invoke-virtual {p1, v0}, Ljava/io/InputStream;->read([B)I

    move-result v2

    move v3, v2

    .local v3, "read":I
    const/4 v4, -0x1

    if-eq v2, v4, :cond_0

    .line 24
    invoke-virtual {p2, v0, v1, v3}, Ljava/io/OutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 26
    :cond_0
    const/4 v1, 0x1

    .line 33
    invoke-static {}, Lcom/bumptech/glide/util/ByteArrayPool;->get()Lcom/bumptech/glide/util/ByteArrayPool;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/bumptech/glide/util/ByteArrayPool;->releaseBytes([B)Z

    return v1

    .end local v3    # "read":I
    :catchall_0
    move-exception v1

    goto :goto_2

    .line 27
    :catch_0
    move-exception v2

    .line 28
    .local v2, "e":Ljava/io/IOException;
    :try_start_1
    const-string v3, "StreamEncoder"

    const/4 v4, 0x3

    invoke-static {v3, v4}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 29
    const-string v3, "StreamEncoder"

    const-string v4, "Failed to encode data onto the OutputStream"

    invoke-static {v3, v4, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 28
    :cond_1
    nop

    .line 31
    :goto_1
    nop

    .line 33
    invoke-static {}, Lcom/bumptech/glide/util/ByteArrayPool;->get()Lcom/bumptech/glide/util/ByteArrayPool;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/bumptech/glide/util/ByteArrayPool;->releaseBytes([B)Z

    return v1

    .end local v2    # "e":Ljava/io/IOException;
    :goto_2
    invoke-static {}, Lcom/bumptech/glide/util/ByteArrayPool;->get()Lcom/bumptech/glide/util/ByteArrayPool;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/bumptech/glide/util/ByteArrayPool;->releaseBytes([B)Z

    throw v1

    return-void
.end method

.method public bridge synthetic encode(Ljava/lang/Object;Ljava/io/OutputStream;)Z
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/io/OutputStream;

    .line 15
    move-object v0, p1

    check-cast v0, Ljava/io/InputStream;

    invoke-virtual {p0, v0, p2}, Lcom/bumptech/glide/load/model/StreamEncoder;->encode(Ljava/io/InputStream;Ljava/io/OutputStream;)Z

    move-result v0

    return v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .line 39
    const-string v0, ""

    return-object v0
.end method
