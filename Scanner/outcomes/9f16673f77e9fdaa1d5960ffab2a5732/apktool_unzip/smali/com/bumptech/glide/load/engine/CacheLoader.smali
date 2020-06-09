.class Lcom/bumptech/glide/load/engine/CacheLoader;
.super Ljava/lang/Object;
.source "CacheLoader.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "CacheLoader"


# instance fields
.field private final diskCache:Lcom/bumptech/glide/load/engine/cache/DiskCache;


# direct methods
.method public constructor <init>(Lcom/bumptech/glide/load/engine/cache/DiskCache;)V
    .locals 0
    .param p1, "diskCache"    # Lcom/bumptech/glide/load/engine/cache/DiskCache;

    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/bumptech/glide/load/engine/CacheLoader;->diskCache:Lcom/bumptech/glide/load/engine/cache/DiskCache;

    .line 18
    return-void
.end method


# virtual methods
.method public load(Lcom/bumptech/glide/load/Key;Lcom/bumptech/glide/load/ResourceDecoder;II)Lcom/bumptech/glide/load/engine/Resource;
    .locals 6
    .param p1, "key"    # Lcom/bumptech/glide/load/Key;
    .param p3, "width"    # I
    .param p4, "height"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<Z:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/bumptech/glide/load/Key;",
            "Lcom/bumptech/glide/load/ResourceDecoder<",
            "Ljava/io/File;",
            "TZ;>;II)",
            "Lcom/bumptech/glide/load/engine/Resource<",
            "TZ;>;"
        }
    .end annotation

    .line 21
    .local p2, "decoder":Lcom/bumptech/glide/load/ResourceDecoder;, "Lcom/bumptech/glide/load/ResourceDecoder<Ljava/io/File;TZ;>;"
    iget-object v0, p0, Lcom/bumptech/glide/load/engine/CacheLoader;->diskCache:Lcom/bumptech/glide/load/engine/cache/DiskCache;

    invoke-interface {v0, p1}, Lcom/bumptech/glide/load/engine/cache/DiskCache;->get(Lcom/bumptech/glide/load/Key;)Ljava/io/File;

    move-result-object v0

    .line 22
    .local v0, "fromCache":Ljava/io/File;
    if-nez v0, :cond_0

    .line 23
    const/4 v1, 0x0

    return-object v1

    .line 26
    :cond_0
    const/4 v1, 0x0

    .line 28
    .local v1, "result":Lcom/bumptech/glide/load/engine/Resource;, "Lcom/bumptech/glide/load/engine/Resource<TZ;>;"
    const/4 v2, 0x3

    :try_start_0
    invoke-interface {p2, v0, p3, p4}, Lcom/bumptech/glide/load/ResourceDecoder;->decode(Ljava/lang/Object;II)Lcom/bumptech/glide/load/engine/Resource;

    move-result-object v3
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v1, v3

    .line 33
    goto :goto_0

    .line 29
    :catch_0
    move-exception v3

    .line 30
    .local v3, "e":Ljava/io/IOException;
    const-string v4, "CacheLoader"

    invoke-static {v4, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 31
    const-string v4, "CacheLoader"

    const-string v5, "Exception decoding image from cache"

    invoke-static {v4, v5, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 30
    :cond_1
    nop

    .line 34
    .end local v3    # "e":Ljava/io/IOException;
    :goto_0
    if-nez v1, :cond_3

    .line 35
    const-string v3, "CacheLoader"

    invoke-static {v3, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 36
    const-string v2, "CacheLoader"

    const-string v3, "Failed to decode image from cache or not present in cache"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 35
    :cond_2
    nop

    .line 38
    :goto_1
    iget-object v2, p0, Lcom/bumptech/glide/load/engine/CacheLoader;->diskCache:Lcom/bumptech/glide/load/engine/cache/DiskCache;

    invoke-interface {v2, p1}, Lcom/bumptech/glide/load/engine/cache/DiskCache;->delete(Lcom/bumptech/glide/load/Key;)V

    goto :goto_2

    .line 34
    :cond_3
    nop

    .line 40
    :goto_2
    return-object v1
.end method
