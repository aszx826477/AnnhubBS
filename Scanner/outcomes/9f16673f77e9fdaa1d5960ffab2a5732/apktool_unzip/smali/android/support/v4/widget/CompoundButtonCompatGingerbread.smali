.class Landroid/support/v4/widget/CompoundButtonCompatGingerbread;
.super Ljava/lang/Object;
.source "CompoundButtonCompatGingerbread.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x9
.end annotation

.annotation build Landroid/support/annotation/RequiresApi;
    value = 0x9
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "CompoundButtonCompatGingerbread"

.field private static sButtonDrawableField:Ljava/lang/reflect/Field;

.field private static sButtonDrawableFieldFetched:Z


# direct methods
.method constructor <init>()V
    .locals 0

    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static getButtonDrawable(Landroid/widget/CompoundButton;)Landroid/graphics/drawable/Drawable;
    .locals 4
    .param p0, "button"    # Landroid/widget/CompoundButton;

    .line 65
    sget-boolean v0, Landroid/support/v4/widget/CompoundButtonCompatGingerbread;->sButtonDrawableFieldFetched:Z

    if-nez v0, :cond_0

    .line 67
    const/4 v0, 0x1

    :try_start_0
    const-class v1, Landroid/widget/CompoundButton;

    const-string v2, "mButtonDrawable"

    invoke-virtual {v1, v2}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    sput-object v1, Landroid/support/v4/widget/CompoundButtonCompatGingerbread;->sButtonDrawableField:Ljava/lang/reflect/Field;

    .line 68
    sget-object v1, Landroid/support/v4/widget/CompoundButtonCompatGingerbread;->sButtonDrawableField:Ljava/lang/reflect/Field;

    invoke-virtual {v1, v0}, Ljava/lang/reflect/Field;->setAccessible(Z)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_0

    .line 71
    goto :goto_0

    .line 69
    :catch_0
    move-exception v1

    .line 70
    .local v1, "e":Ljava/lang/NoSuchFieldException;
    const-string v2, "CompoundButtonCompatGingerbread"

    const-string v3, "Failed to retrieve mButtonDrawable field"

    invoke-static {v2, v3, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 72
    .end local v1    # "e":Ljava/lang/NoSuchFieldException;
    :goto_0
    sput-boolean v0, Landroid/support/v4/widget/CompoundButtonCompatGingerbread;->sButtonDrawableFieldFetched:Z

    goto :goto_1

    .line 65
    :cond_0
    nop

    .line 75
    :goto_1
    sget-object v0, Landroid/support/v4/widget/CompoundButtonCompatGingerbread;->sButtonDrawableField:Ljava/lang/reflect/Field;

    const/4 v1, 0x0

    if-eqz v0, :cond_1

    .line 77
    nop

    :try_start_1
    invoke-virtual {v0, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    nop

    check-cast v0, Landroid/graphics/drawable/Drawable;
    :try_end_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_1

    nop

    return-object v0

    .line 78
    :catch_1
    move-exception v0

    nop

    .line 79
    .local v0, "e":Ljava/lang/IllegalAccessException;
    nop

    const-string v2, "CompoundButtonCompatGingerbread"

    const-string v3, "Failed to get button drawable via reflection"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 80
    nop

    sput-object v1, Landroid/support/v4/widget/CompoundButtonCompatGingerbread;->sButtonDrawableField:Ljava/lang/reflect/Field;

    goto :goto_2

    .line 75
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :cond_1
    nop

    .line 83
    :goto_2
    nop

    return-object v1
.end method

.method static getButtonTintList(Landroid/widget/CompoundButton;)Landroid/content/res/ColorStateList;
    .locals 1
    .param p0, "button"    # Landroid/widget/CompoundButton;

    .line 45
    instance-of v0, p0, Landroid/support/v4/widget/TintableCompoundButton;

    if-eqz v0, :cond_0

    .line 46
    move-object v0, p0

    check-cast v0, Landroid/support/v4/widget/TintableCompoundButton;

    invoke-interface {v0}, Landroid/support/v4/widget/TintableCompoundButton;->getSupportButtonTintList()Landroid/content/res/ColorStateList;

    move-result-object v0

    return-object v0

    .line 48
    :cond_0
    const/4 v0, 0x0

    return-object v0
.end method

.method static getButtonTintMode(Landroid/widget/CompoundButton;)Landroid/graphics/PorterDuff$Mode;
    .locals 1
    .param p0, "button"    # Landroid/widget/CompoundButton;

    .line 58
    instance-of v0, p0, Landroid/support/v4/widget/TintableCompoundButton;

    if-eqz v0, :cond_0

    .line 59
    move-object v0, p0

    check-cast v0, Landroid/support/v4/widget/TintableCompoundButton;

    invoke-interface {v0}, Landroid/support/v4/widget/TintableCompoundButton;->getSupportButtonTintMode()Landroid/graphics/PorterDuff$Mode;

    move-result-object v0

    return-object v0

    .line 61
    :cond_0
    const/4 v0, 0x0

    return-object v0
.end method

.method static setButtonTintList(Landroid/widget/CompoundButton;Landroid/content/res/ColorStateList;)V
    .locals 1
    .param p0, "button"    # Landroid/widget/CompoundButton;
    .param p1, "tint"    # Landroid/content/res/ColorStateList;

    .line 39
    instance-of v0, p0, Landroid/support/v4/widget/TintableCompoundButton;

    if-eqz v0, :cond_0

    .line 40
    move-object v0, p0

    check-cast v0, Landroid/support/v4/widget/TintableCompoundButton;

    invoke-interface {v0, p1}, Landroid/support/v4/widget/TintableCompoundButton;->setSupportButtonTintList(Landroid/content/res/ColorStateList;)V

    goto :goto_0

    .line 39
    :cond_0
    nop

    .line 42
    :goto_0
    return-void
.end method

.method static setButtonTintMode(Landroid/widget/CompoundButton;Landroid/graphics/PorterDuff$Mode;)V
    .locals 1
    .param p0, "button"    # Landroid/widget/CompoundButton;
    .param p1, "tintMode"    # Landroid/graphics/PorterDuff$Mode;

    .line 52
    instance-of v0, p0, Landroid/support/v4/widget/TintableCompoundButton;

    if-eqz v0, :cond_0

    .line 53
    move-object v0, p0

    check-cast v0, Landroid/support/v4/widget/TintableCompoundButton;

    invoke-interface {v0, p1}, Landroid/support/v4/widget/TintableCompoundButton;->setSupportButtonTintMode(Landroid/graphics/PorterDuff$Mode;)V

    goto :goto_0

    .line 52
    :cond_0
    nop

    .line 55
    :goto_0
    return-void
.end method
