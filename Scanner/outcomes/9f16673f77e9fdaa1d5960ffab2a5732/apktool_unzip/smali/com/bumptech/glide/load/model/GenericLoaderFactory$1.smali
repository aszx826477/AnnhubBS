.class final Lcom/bumptech/glide/load/model/GenericLoaderFactory$1;
.super Ljava/lang/Object;
.source "GenericLoaderFactory.java"

# interfaces
.implements Lcom/bumptech/glide/load/model/ModelLoader;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bumptech/glide/load/model/GenericLoaderFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getResourceFetcher(Ljava/lang/Object;II)Lcom/bumptech/glide/load/data/DataFetcher;
    .locals 2
    .param p1, "model"    # Ljava/lang/Object;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .line 25
    new-instance v0, Ljava/lang/NoSuchMethodError;

    const-string v1, "This should never be called!"

    invoke-direct {v0, v1}, Ljava/lang/NoSuchMethodError;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .line 30
    const-string v0, "NULL_MODEL_LOADER"

    return-object v0
.end method
