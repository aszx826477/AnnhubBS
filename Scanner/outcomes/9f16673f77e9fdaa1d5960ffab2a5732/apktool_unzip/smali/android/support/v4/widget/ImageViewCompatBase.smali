.class Landroid/support/v4/widget/ImageViewCompatBase;
.super Ljava/lang/Object;
.source "ImageViewCompatBase.java"


# direct methods
.method constructor <init>()V
    .locals 0

    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static getImageTintList(Landroid/widget/ImageView;)Landroid/content/res/ColorStateList;
    .locals 1
    .param p0, "view"    # Landroid/widget/ImageView;

    .line 25
    instance-of v0, p0, Landroid/support/v4/widget/TintableImageSourceView;

    if-eqz v0, :cond_0

    move-object v0, p0

    check-cast v0, Landroid/support/v4/widget/TintableImageSourceView;

    .line 26
    invoke-interface {v0}, Landroid/support/v4/widget/TintableImageSourceView;->getSupportImageTintList()Landroid/content/res/ColorStateList;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method static getImageTintMode(Landroid/widget/ImageView;)Landroid/graphics/PorterDuff$Mode;
    .locals 1
    .param p0, "view"    # Landroid/widget/ImageView;

    .line 37
    instance-of v0, p0, Landroid/support/v4/widget/TintableImageSourceView;

    if-eqz v0, :cond_0

    move-object v0, p0

    check-cast v0, Landroid/support/v4/widget/TintableImageSourceView;

    .line 38
    invoke-interface {v0}, Landroid/support/v4/widget/TintableImageSourceView;->getSupportImageTintMode()Landroid/graphics/PorterDuff$Mode;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method static setImageTintList(Landroid/widget/ImageView;Landroid/content/res/ColorStateList;)V
    .locals 1
    .param p0, "view"    # Landroid/widget/ImageView;
    .param p1, "tintList"    # Landroid/content/res/ColorStateList;

    .line 31
    instance-of v0, p0, Landroid/support/v4/widget/TintableImageSourceView;

    if-eqz v0, :cond_0

    .line 32
    move-object v0, p0

    check-cast v0, Landroid/support/v4/widget/TintableImageSourceView;

    invoke-interface {v0, p1}, Landroid/support/v4/widget/TintableImageSourceView;->setSupportImageTintList(Landroid/content/res/ColorStateList;)V

    goto :goto_0

    .line 31
    :cond_0
    nop

    .line 34
    :goto_0
    return-void
.end method

.method static setImageTintMode(Landroid/widget/ImageView;Landroid/graphics/PorterDuff$Mode;)V
    .locals 1
    .param p0, "view"    # Landroid/widget/ImageView;
    .param p1, "mode"    # Landroid/graphics/PorterDuff$Mode;

    .line 43
    instance-of v0, p0, Landroid/support/v4/widget/TintableImageSourceView;

    if-eqz v0, :cond_0

    .line 44
    move-object v0, p0

    check-cast v0, Landroid/support/v4/widget/TintableImageSourceView;

    invoke-interface {v0, p1}, Landroid/support/v4/widget/TintableImageSourceView;->setSupportImageTintMode(Landroid/graphics/PorterDuff$Mode;)V

    goto :goto_0

    .line 43
    :cond_0
    nop

    .line 46
    :goto_0
    return-void
.end method
