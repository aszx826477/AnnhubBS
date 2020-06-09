.class public Landroid/support/v4/widget/ImageViewCompat;
.super Ljava/lang/Object;
.source "ImageViewCompat.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v4/widget/ImageViewCompat$LollipopViewCompatImpl;,
        Landroid/support/v4/widget/ImageViewCompat$BaseViewCompatImpl;,
        Landroid/support/v4/widget/ImageViewCompat$ImageViewCompatImpl;
    }
.end annotation


# static fields
.field static final IMPL:Landroid/support/v4/widget/ImageViewCompat$ImageViewCompatImpl;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 84
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 85
    new-instance v0, Landroid/support/v4/widget/ImageViewCompat$LollipopViewCompatImpl;

    invoke-direct {v0}, Landroid/support/v4/widget/ImageViewCompat$LollipopViewCompatImpl;-><init>()V

    sput-object v0, Landroid/support/v4/widget/ImageViewCompat;->IMPL:Landroid/support/v4/widget/ImageViewCompat$ImageViewCompatImpl;

    goto :goto_0

    .line 87
    :cond_0
    new-instance v0, Landroid/support/v4/widget/ImageViewCompat$BaseViewCompatImpl;

    invoke-direct {v0}, Landroid/support/v4/widget/ImageViewCompat$BaseViewCompatImpl;-><init>()V

    sput-object v0, Landroid/support/v4/widget/ImageViewCompat;->IMPL:Landroid/support/v4/widget/ImageViewCompat$ImageViewCompatImpl;

    .line 89
    :goto_0
    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 121
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getImageTintList(Landroid/widget/ImageView;)Landroid/content/res/ColorStateList;
    .locals 1
    .param p0, "view"    # Landroid/widget/ImageView;

    .line 95
    sget-object v0, Landroid/support/v4/widget/ImageViewCompat;->IMPL:Landroid/support/v4/widget/ImageViewCompat$ImageViewCompatImpl;

    invoke-interface {v0, p0}, Landroid/support/v4/widget/ImageViewCompat$ImageViewCompatImpl;->getImageTintList(Landroid/widget/ImageView;)Landroid/content/res/ColorStateList;

    move-result-object v0

    return-object v0
.end method

.method public static getImageTintMode(Landroid/widget/ImageView;)Landroid/graphics/PorterDuff$Mode;
    .locals 1
    .param p0, "view"    # Landroid/widget/ImageView;

    .line 109
    sget-object v0, Landroid/support/v4/widget/ImageViewCompat;->IMPL:Landroid/support/v4/widget/ImageViewCompat$ImageViewCompatImpl;

    invoke-interface {v0, p0}, Landroid/support/v4/widget/ImageViewCompat$ImageViewCompatImpl;->getImageTintMode(Landroid/widget/ImageView;)Landroid/graphics/PorterDuff$Mode;

    move-result-object v0

    return-object v0
.end method

.method public static setImageTintList(Landroid/widget/ImageView;Landroid/content/res/ColorStateList;)V
    .locals 1
    .param p0, "view"    # Landroid/widget/ImageView;
    .param p1, "tintList"    # Landroid/content/res/ColorStateList;

    .line 102
    sget-object v0, Landroid/support/v4/widget/ImageViewCompat;->IMPL:Landroid/support/v4/widget/ImageViewCompat$ImageViewCompatImpl;

    invoke-interface {v0, p0, p1}, Landroid/support/v4/widget/ImageViewCompat$ImageViewCompatImpl;->setImageTintList(Landroid/widget/ImageView;Landroid/content/res/ColorStateList;)V

    .line 103
    return-void
.end method

.method public static setImageTintMode(Landroid/widget/ImageView;Landroid/graphics/PorterDuff$Mode;)V
    .locals 1
    .param p0, "view"    # Landroid/widget/ImageView;
    .param p1, "mode"    # Landroid/graphics/PorterDuff$Mode;

    .line 118
    sget-object v0, Landroid/support/v4/widget/ImageViewCompat;->IMPL:Landroid/support/v4/widget/ImageViewCompat$ImageViewCompatImpl;

    invoke-interface {v0, p0, p1}, Landroid/support/v4/widget/ImageViewCompat$ImageViewCompatImpl;->setImageTintMode(Landroid/widget/ImageView;Landroid/graphics/PorterDuff$Mode;)V

    .line 119
    return-void
.end method
