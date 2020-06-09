.class Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailStreamOpenerFactory;
.super Ljava/lang/Object;
.source "MediaStoreThumbFetcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ThumbnailStreamOpenerFactory"
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .line 250
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public build(Landroid/net/Uri;II)Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailStreamOpener;
    .locals 2
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .line 253
    invoke-static {p1}, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher;->access$000(Landroid/net/Uri;)Z

    move-result v0

    if-eqz v0, :cond_2

    const/16 v0, 0x200

    if-gt p2, v0, :cond_2

    const/16 v0, 0x180

    if-le p3, v0, :cond_0

    goto :goto_0

    .line 255
    :cond_0
    invoke-static {p1}, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher;->access$100(Landroid/net/Uri;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 256
    new-instance v0, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailStreamOpener;

    new-instance v1, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$VideoThumbnailQuery;

    invoke-direct {v1}, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$VideoThumbnailQuery;-><init>()V

    invoke-direct {v0, v1}, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailStreamOpener;-><init>(Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailQuery;)V

    return-object v0

    .line 258
    :cond_1
    new-instance v0, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailStreamOpener;

    new-instance v1, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ImageThumbnailQuery;

    invoke-direct {v1}, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ImageThumbnailQuery;-><init>()V

    invoke-direct {v0, v1}, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailStreamOpener;-><init>(Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailQuery;)V

    return-object v0

    .line 253
    :cond_2
    :goto_0
    nop

    .line 254
    const/4 v0, 0x0

    return-object v0
.end method
