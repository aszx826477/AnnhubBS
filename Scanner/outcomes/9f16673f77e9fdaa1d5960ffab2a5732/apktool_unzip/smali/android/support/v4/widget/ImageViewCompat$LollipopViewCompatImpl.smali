.class Landroid/support/v4/widget/ImageViewCompat$LollipopViewCompatImpl;
.super Landroid/support/v4/widget/ImageViewCompat$BaseViewCompatImpl;
.source "ImageViewCompat.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/widget/ImageViewCompat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "LollipopViewCompatImpl"
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .line 60
    invoke-direct {p0}, Landroid/support/v4/widget/ImageViewCompat$BaseViewCompatImpl;-><init>()V

    return-void
.end method


# virtual methods
.method public getImageTintList(Landroid/widget/ImageView;)Landroid/content/res/ColorStateList;
    .locals 1
    .param p1, "view"    # Landroid/widget/ImageView;

    .line 63
    invoke-static {p1}, Landroid/support/v4/widget/ImageViewCompatLollipop;->getImageTintList(Landroid/widget/ImageView;)Landroid/content/res/ColorStateList;

    move-result-object v0

    return-object v0
.end method

.method public getImageTintMode(Landroid/widget/ImageView;)Landroid/graphics/PorterDuff$Mode;
    .locals 1
    .param p1, "view"    # Landroid/widget/ImageView;

    .line 78
    invoke-static {p1}, Landroid/support/v4/widget/ImageViewCompatLollipop;->getImageTintMode(Landroid/widget/ImageView;)Landroid/graphics/PorterDuff$Mode;

    move-result-object v0

    return-object v0
.end method

.method public setImageTintList(Landroid/widget/ImageView;Landroid/content/res/ColorStateList;)V
    .locals 0
    .param p1, "view"    # Landroid/widget/ImageView;
    .param p2, "tintList"    # Landroid/content/res/ColorStateList;

    .line 68
    invoke-static {p1, p2}, Landroid/support/v4/widget/ImageViewCompatLollipop;->setImageTintList(Landroid/widget/ImageView;Landroid/content/res/ColorStateList;)V

    .line 69
    return-void
.end method

.method public setImageTintMode(Landroid/widget/ImageView;Landroid/graphics/PorterDuff$Mode;)V
    .locals 0
    .param p1, "view"    # Landroid/widget/ImageView;
    .param p2, "mode"    # Landroid/graphics/PorterDuff$Mode;

    .line 73
    invoke-static {p1, p2}, Landroid/support/v4/widget/ImageViewCompatLollipop;->setImageTintMode(Landroid/widget/ImageView;Landroid/graphics/PorterDuff$Mode;)V

    .line 74
    return-void
.end method
