.class Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailStreamOpener;
.super Ljava/lang/Object;
.source "MediaStoreThumbFetcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ThumbnailStreamOpener"
.end annotation


# static fields
.field private static final DEFAULT_SERVICE:Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$FileService;


# instance fields
.field private query:Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailQuery;

.field private final service:Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$FileService;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 142
    new-instance v0, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$FileService;

    invoke-direct {v0}, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$FileService;-><init>()V

    sput-object v0, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailStreamOpener;->DEFAULT_SERVICE:Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$FileService;

    return-void
.end method

.method public constructor <init>(Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$FileService;Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailQuery;)V
    .locals 0
    .param p1, "service"    # Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$FileService;
    .param p2, "query"    # Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailQuery;

    .line 150
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 151
    iput-object p1, p0, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailStreamOpener;->service:Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$FileService;

    .line 152
    iput-object p2, p0, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailStreamOpener;->query:Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailQuery;

    .line 153
    return-void
.end method

.method public constructor <init>(Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailQuery;)V
    .locals 1
    .param p1, "query"    # Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailQuery;

    .line 147
    sget-object v0, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailStreamOpener;->DEFAULT_SERVICE:Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$FileService;

    invoke-direct {p0, v0, p1}, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailStreamOpener;-><init>(Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$FileService;Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailQuery;)V

    .line 148
    return-void
.end method

.method private parseThumbUri(Landroid/database/Cursor;)Landroid/net/Uri;
    .locals 8
    .param p1, "cursor"    # Landroid/database/Cursor;

    .line 198
    const/4 v0, 0x0

    .line 199
    .local v0, "result":Landroid/net/Uri;
    const/4 v1, 0x0

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 200
    .local v1, "path":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 201
    iget-object v2, p0, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailStreamOpener;->service:Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$FileService;

    invoke-virtual {v2, v1}, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$FileService;->get(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 202
    .local v2, "file":Ljava/io/File;
    iget-object v3, p0, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailStreamOpener;->service:Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$FileService;

    invoke-virtual {v3, v2}, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$FileService;->exists(Ljava/io/File;)Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailStreamOpener;->service:Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$FileService;

    invoke-virtual {v3, v2}, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$FileService;->length(Ljava/io/File;)J

    move-result-wide v3

    const-wide/16 v5, 0x0

    cmp-long v7, v3, v5

    if-lez v7, :cond_0

    .line 203
    invoke-static {v2}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v0

    goto :goto_0

    .line 202
    :cond_0
    goto :goto_0

    .line 200
    .end local v2    # "file":Ljava/io/File;
    :cond_1
    nop

    .line 206
    :goto_0
    return-object v0
.end method


# virtual methods
.method public getOrientation(Landroid/content/Context;Landroid/net/Uri;)I
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;

    .line 156
    const/4 v0, -0x1

    .line 157
    .local v0, "orientation":I
    const/4 v1, 0x0

    .line 159
    .local v1, "is":Ljava/io/InputStream;
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v2, p2}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v2

    move-object v1, v2

    .line 160
    new-instance v2, Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser;

    invoke-direct {v2, v1}, Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser;-><init>(Ljava/io/InputStream;)V

    invoke-virtual {v2}, Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser;->getOrientation()I

    move-result v2
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move v0, v2

    .line 166
    if-eqz v1, :cond_0

    .line 168
    :try_start_1
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 171
    :goto_0
    goto :goto_2

    .line 169
    :catch_0
    move-exception v2

    goto :goto_0

    .line 166
    :cond_0
    goto :goto_2

    :catchall_0
    move-exception v2

    goto :goto_3

    .line 161
    :catch_1
    move-exception v2

    .line 162
    .local v2, "e":Ljava/io/IOException;
    :try_start_2
    const-string v3, "MediaStoreThumbFetcher"

    const/4 v4, 0x3

    invoke-static {v3, v4}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 163
    const-string v3, "MediaStoreThumbFetcher"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Failed to open uri: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 162
    :cond_1
    nop

    .line 166
    .end local v2    # "e":Ljava/io/IOException;
    :goto_1
    if-eqz v1, :cond_0

    .line 168
    :try_start_3
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    goto :goto_0

    .line 174
    :goto_2
    return v0

    .line 166
    :goto_3
    if-eqz v1, :cond_2

    .line 168
    :try_start_4
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    .line 171
    goto :goto_4

    .line 169
    :catch_2
    move-exception v3

    goto :goto_4

    .line 166
    :cond_2
    nop

    .line 171
    :goto_4
    throw v2

    return-void
.end method

.method public open(Landroid/content/Context;Landroid/net/Uri;)Ljava/io/InputStream;
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;
        }
    .end annotation

    .line 178
    const/4 v0, 0x0

    .line 179
    .local v0, "thumbnailUri":Landroid/net/Uri;
    const/4 v1, 0x0

    .line 181
    .local v1, "inputStream":Ljava/io/InputStream;
    iget-object v2, p0, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailStreamOpener;->query:Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailQuery;

    invoke-interface {v2, p1, p2}, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailQuery;->queryPath(Landroid/content/Context;Landroid/net/Uri;)Landroid/database/Cursor;

    move-result-object v2

    .line 183
    .local v2, "cursor":Landroid/database/Cursor;
    if-eqz v2, :cond_1

    :try_start_0
    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 184
    invoke-direct {p0, v2}, Lcom/bumptech/glide/load/data/MediaStoreThumbFetcher$ThumbnailStreamOpener;->parseThumbUri(Landroid/database/Cursor;)Landroid/net/Uri;

    move-result-object v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-object v0, v3

    goto :goto_1

    .line 187
    :catchall_0
    move-exception v3

    if-eqz v2, :cond_0

    .line 188
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 187
    :cond_0
    nop

    .line 188
    :goto_0
    throw v3

    .line 183
    :cond_1
    nop

    .line 187
    :goto_1
    if-eqz v2, :cond_2

    .line 188
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_2

    .line 187
    :cond_2
    nop

    .line 191
    :goto_2
    if-eqz v0, :cond_3

    .line 192
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    invoke-virtual {v3, v0}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v1

    goto :goto_3

    .line 191
    :cond_3
    nop

    .line 194
    :goto_3
    return-object v1
.end method
