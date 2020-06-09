.class Landroid/support/v4/graphics/drawable/DrawableCompatBase;
.super Ljava/lang/Object;
.source "DrawableCompatBase.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x9
.end annotation

.annotation build Landroid/support/annotation/RequiresApi;
    value = 0x9
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static inflate(Landroid/graphics/drawable/Drawable;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)V
    .locals 0
    .param p0, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p1, "res"    # Landroid/content/res/Resources;
    .param p2, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p3, "attrs"    # Landroid/util/AttributeSet;
    .param p4, "t"    # Landroid/content/res/Resources$Theme;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/xmlpull/v1/XmlPullParserException;
        }
    .end annotation

    .line 68
    invoke-virtual {p0, p1, p2, p3}, Landroid/graphics/drawable/Drawable;->inflate(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)V

    .line 69
    return-void
.end method

.method public static setTint(Landroid/graphics/drawable/Drawable;I)V
    .locals 1
    .param p0, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p1, "tint"    # I

    .line 41
    instance-of v0, p0, Landroid/support/v4/graphics/drawable/TintAwareDrawable;

    if-eqz v0, :cond_0

    .line 42
    move-object v0, p0

    check-cast v0, Landroid/support/v4/graphics/drawable/TintAwareDrawable;

    invoke-interface {v0, p1}, Landroid/support/v4/graphics/drawable/TintAwareDrawable;->setTint(I)V

    goto :goto_0

    .line 41
    :cond_0
    nop

    .line 44
    :goto_0
    return-void
.end method

.method public static setTintList(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V
    .locals 1
    .param p0, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p1, "tint"    # Landroid/content/res/ColorStateList;

    .line 47
    instance-of v0, p0, Landroid/support/v4/graphics/drawable/TintAwareDrawable;

    if-eqz v0, :cond_0

    .line 48
    move-object v0, p0

    check-cast v0, Landroid/support/v4/graphics/drawable/TintAwareDrawable;

    invoke-interface {v0, p1}, Landroid/support/v4/graphics/drawable/TintAwareDrawable;->setTintList(Landroid/content/res/ColorStateList;)V

    goto :goto_0

    .line 47
    :cond_0
    nop

    .line 50
    :goto_0
    return-void
.end method

.method public static setTintMode(Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V
    .locals 1
    .param p0, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p1, "tintMode"    # Landroid/graphics/PorterDuff$Mode;

    .line 53
    instance-of v0, p0, Landroid/support/v4/graphics/drawable/TintAwareDrawable;

    if-eqz v0, :cond_0

    .line 54
    move-object v0, p0

    check-cast v0, Landroid/support/v4/graphics/drawable/TintAwareDrawable;

    invoke-interface {v0, p1}, Landroid/support/v4/graphics/drawable/TintAwareDrawable;->setTintMode(Landroid/graphics/PorterDuff$Mode;)V

    goto :goto_0

    .line 53
    :cond_0
    nop

    .line 56
    :goto_0
    return-void
.end method

.method public static wrapForTinting(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p0, "drawable"    # Landroid/graphics/drawable/Drawable;

    .line 59
    instance-of v0, p0, Landroid/support/v4/graphics/drawable/TintAwareDrawable;

    if-nez v0, :cond_0

    .line 60
    new-instance v0, Landroid/support/v4/graphics/drawable/DrawableWrapperGingerbread;

    invoke-direct {v0, p0}, Landroid/support/v4/graphics/drawable/DrawableWrapperGingerbread;-><init>(Landroid/graphics/drawable/Drawable;)V

    return-object v0

    .line 62
    :cond_0
    return-object p0
.end method
