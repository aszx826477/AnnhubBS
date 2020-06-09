.class public Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPoolAdapter;
.super Ljava/lang/Object;
.source "BitmapPoolAdapter.java"

# interfaces
.implements Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public clearMemory()V
    .locals 0

    .line 38
    return-void
.end method

.method public get(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    .locals 1
    .param p1, "width"    # I
    .param p2, "height"    # I
    .param p3, "config"    # Landroid/graphics/Bitmap$Config;

    .line 27
    const/4 v0, 0x0

    return-object v0
.end method

.method public getDirty(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    .locals 1
    .param p1, "width"    # I
    .param p2, "height"    # I
    .param p3, "config"    # Landroid/graphics/Bitmap$Config;

    .line 32
    const/4 v0, 0x0

    return-object v0
.end method

.method public getMaxSize()I
    .locals 1

    .line 12
    const/4 v0, 0x0

    return v0
.end method

.method public put(Landroid/graphics/Bitmap;)Z
    .locals 1
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .line 22
    const/4 v0, 0x0

    return v0
.end method

.method public setSizeMultiplier(F)V
    .locals 0
    .param p1, "sizeMultiplier"    # F

    .line 18
    return-void
.end method

.method public trimMemory(I)V
    .locals 0
    .param p1, "level"    # I

    .line 43
    return-void
.end method
