.class public abstract Lcom/bumptech/glide/load/data/LocalUriFetcher;
.super Ljava/lang/Object;
.source "LocalUriFetcher.java"

# interfaces
.implements Lcom/bumptech/glide/load/data/DataFetcher;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/bumptech/glide/load/data/DataFetcher<",
        "TT;>;"
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "LocalUriFetcher"


# instance fields
.field private final context:Landroid/content/Context;

.field private data:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field private final uri:Landroid/net/Uri;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/net/Uri;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;

    .line 36
    .local p0, "this":Lcom/bumptech/glide/load/data/LocalUriFetcher;, "Lcom/bumptech/glide/load/data/LocalUriFetcher<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/bumptech/glide/load/data/LocalUriFetcher;->context:Landroid/content/Context;

    .line 38
    iput-object p2, p0, Lcom/bumptech/glide/load/data/LocalUriFetcher;->uri:Landroid/net/Uri;

    .line 39
    return-void
.end method


# virtual methods
.method public cancel()V
    .locals 0

    .line 65
    .local p0, "this":Lcom/bumptech/glide/load/data/LocalUriFetcher;, "Lcom/bumptech/glide/load/data/LocalUriFetcher<TT;>;"
    return-void
.end method

.method public cleanup()V
    .locals 3

    .line 50
    .local p0, "this":Lcom/bumptech/glide/load/data/LocalUriFetcher;, "Lcom/bumptech/glide/load/data/LocalUriFetcher<TT;>;"
    iget-object v0, p0, Lcom/bumptech/glide/load/data/LocalUriFetcher;->data:Ljava/lang/Object;

    if-eqz v0, :cond_1

    .line 52
    nop

    :try_start_0
    invoke-virtual {p0, v0}, Lcom/bumptech/glide/load/data/LocalUriFetcher;->close(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 57
    nop

    goto :goto_0

    .line 53
    :catch_0
    move-exception v0

    nop

    .line 54
    .local v0, "e":Ljava/io/IOException;
    nop

    const-string v1, "LocalUriFetcher"

    const/4 v2, 0x2

    invoke-static {v1, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 55
    nop

    const-string v1, "LocalUriFetcher"

    const-string v2, "failed to close data"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 54
    :cond_0
    nop

    goto :goto_0

    .line 50
    .end local v0    # "e":Ljava/io/IOException;
    :cond_1
    nop

    .line 60
    :goto_0
    nop

    return-void
.end method

.method protected abstract close(Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .line 69
    .local p0, "this":Lcom/bumptech/glide/load/data/LocalUriFetcher;, "Lcom/bumptech/glide/load/data/LocalUriFetcher<TT;>;"
    iget-object v0, p0, Lcom/bumptech/glide/load/data/LocalUriFetcher;->uri:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final loadData(Lcom/bumptech/glide/Priority;)Ljava/lang/Object;
    .locals 2
    .param p1, "priority"    # Lcom/bumptech/glide/Priority;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/Priority;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 43
    .local p0, "this":Lcom/bumptech/glide/load/data/LocalUriFetcher;, "Lcom/bumptech/glide/load/data/LocalUriFetcher<TT;>;"
    iget-object v0, p0, Lcom/bumptech/glide/load/data/LocalUriFetcher;->context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 44
    .local v0, "contentResolver":Landroid/content/ContentResolver;
    iget-object v1, p0, Lcom/bumptech/glide/load/data/LocalUriFetcher;->uri:Landroid/net/Uri;

    invoke-virtual {p0, v1, v0}, Lcom/bumptech/glide/load/data/LocalUriFetcher;->loadResource(Landroid/net/Uri;Landroid/content/ContentResolver;)Ljava/lang/Object;

    move-result-object v1

    iput-object v1, p0, Lcom/bumptech/glide/load/data/LocalUriFetcher;->data:Ljava/lang/Object;

    .line 45
    iget-object v1, p0, Lcom/bumptech/glide/load/data/LocalUriFetcher;->data:Ljava/lang/Object;

    return-object v1
.end method

.method protected abstract loadResource(Landroid/net/Uri;Landroid/content/ContentResolver;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri;",
            "Landroid/content/ContentResolver;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;
        }
    .end annotation
.end method
