.class public Lcom/bumptech/glide/request/target/BitmapImageViewTarget;
.super Lcom/bumptech/glide/request/target/ImageViewTarget;
.source "BitmapImageViewTarget.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/bumptech/glide/request/target/ImageViewTarget<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Landroid/widget/ImageView;)V
    .locals 0
    .param p1, "view"    # Landroid/widget/ImageView;

    .line 14
    invoke-direct {p0, p1}, Lcom/bumptech/glide/request/target/ImageViewTarget;-><init>(Landroid/widget/ImageView;)V

    .line 15
    return-void
.end method


# virtual methods
.method protected setResource(Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "resource"    # Landroid/graphics/Bitmap;

    .line 25
    iget-object v0, p0, Lcom/bumptech/glide/request/target/BitmapImageViewTarget;->view:Landroid/view/View;

    check-cast v0, Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 26
    return-void
.end method

.method protected bridge synthetic setResource(Ljava/lang/Object;)V
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .line 12
    move-object v0, p1

    check-cast v0, Landroid/graphics/Bitmap;

    invoke-virtual {p0, v0}, Lcom/bumptech/glide/request/target/BitmapImageViewTarget;->setResource(Landroid/graphics/Bitmap;)V

    return-void
.end method
