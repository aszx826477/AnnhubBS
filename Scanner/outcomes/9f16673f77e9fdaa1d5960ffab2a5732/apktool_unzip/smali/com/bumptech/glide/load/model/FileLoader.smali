.class public Lcom/bumptech/glide/load/model/FileLoader;
.super Ljava/lang/Object;
.source "FileLoader.java"

# interfaces
.implements Lcom/bumptech/glide/load/model/ModelLoader;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/bumptech/glide/load/model/ModelLoader<",
        "Ljava/io/File;",
        "TT;>;"
    }
.end annotation


# instance fields
.field private final uriLoader:Lcom/bumptech/glide/load/model/ModelLoader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "Landroid/net/Uri;",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/bumptech/glide/load/model/ModelLoader;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "Landroid/net/Uri;",
            "TT;>;)V"
        }
    .end annotation

    .line 19
    .local p0, "this":Lcom/bumptech/glide/load/model/FileLoader;, "Lcom/bumptech/glide/load/model/FileLoader<TT;>;"
    .local p1, "uriLoader":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<Landroid/net/Uri;TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/bumptech/glide/load/model/FileLoader;->uriLoader:Lcom/bumptech/glide/load/model/ModelLoader;

    .line 21
    return-void
.end method


# virtual methods
.method public getResourceFetcher(Ljava/io/File;II)Lcom/bumptech/glide/load/data/DataFetcher;
    .locals 2
    .param p1, "model"    # Ljava/io/File;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "II)",
            "Lcom/bumptech/glide/load/data/DataFetcher<",
            "TT;>;"
        }
    .end annotation

    .line 25
    .local p0, "this":Lcom/bumptech/glide/load/model/FileLoader;, "Lcom/bumptech/glide/load/model/FileLoader<TT;>;"
    iget-object v0, p0, Lcom/bumptech/glide/load/model/FileLoader;->uriLoader:Lcom/bumptech/glide/load/model/ModelLoader;

    invoke-static {p1}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v1

    invoke-interface {v0, v1, p2, p3}, Lcom/bumptech/glide/load/model/ModelLoader;->getResourceFetcher(Ljava/lang/Object;II)Lcom/bumptech/glide/load/data/DataFetcher;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getResourceFetcher(Ljava/lang/Object;II)Lcom/bumptech/glide/load/data/DataFetcher;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # I
    .param p3, "x2"    # I

    .line 15
    .local p0, "this":Lcom/bumptech/glide/load/model/FileLoader;, "Lcom/bumptech/glide/load/model/FileLoader<TT;>;"
    move-object v0, p1

    check-cast v0, Ljava/io/File;

    invoke-virtual {p0, v0, p2, p3}, Lcom/bumptech/glide/load/model/FileLoader;->getResourceFetcher(Ljava/io/File;II)Lcom/bumptech/glide/load/data/DataFetcher;

    move-result-object v0

    return-object v0
.end method
