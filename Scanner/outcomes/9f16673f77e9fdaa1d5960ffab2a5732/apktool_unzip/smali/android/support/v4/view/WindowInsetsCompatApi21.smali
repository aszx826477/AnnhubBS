.class Landroid/support/v4/view/WindowInsetsCompatApi21;
.super Ljava/lang/Object;
.source "WindowInsetsCompatApi21.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x15
.end annotation

.annotation build Landroid/support/annotation/RequiresApi;
    value = 0x15
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static consumeStableInsets(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "insets"    # Ljava/lang/Object;

    .line 28
    move-object v0, p0

    check-cast v0, Landroid/view/WindowInsets;

    invoke-virtual {v0}, Landroid/view/WindowInsets;->consumeStableInsets()Landroid/view/WindowInsets;

    move-result-object v0

    return-object v0
.end method

.method public static getStableInsetBottom(Ljava/lang/Object;)I
    .locals 1
    .param p0, "insets"    # Ljava/lang/Object;

    .line 32
    move-object v0, p0

    check-cast v0, Landroid/view/WindowInsets;

    invoke-virtual {v0}, Landroid/view/WindowInsets;->getStableInsetBottom()I

    move-result v0

    return v0
.end method

.method public static getStableInsetLeft(Ljava/lang/Object;)I
    .locals 1
    .param p0, "insets"    # Ljava/lang/Object;

    .line 36
    move-object v0, p0

    check-cast v0, Landroid/view/WindowInsets;

    invoke-virtual {v0}, Landroid/view/WindowInsets;->getStableInsetLeft()I

    move-result v0

    return v0
.end method

.method public static getStableInsetRight(Ljava/lang/Object;)I
    .locals 1
    .param p0, "insets"    # Ljava/lang/Object;

    .line 40
    move-object v0, p0

    check-cast v0, Landroid/view/WindowInsets;

    invoke-virtual {v0}, Landroid/view/WindowInsets;->getStableInsetRight()I

    move-result v0

    return v0
.end method

.method public static getStableInsetTop(Ljava/lang/Object;)I
    .locals 1
    .param p0, "insets"    # Ljava/lang/Object;

    .line 44
    move-object v0, p0

    check-cast v0, Landroid/view/WindowInsets;

    invoke-virtual {v0}, Landroid/view/WindowInsets;->getStableInsetTop()I

    move-result v0

    return v0
.end method

.method public static hasStableInsets(Ljava/lang/Object;)Z
    .locals 1
    .param p0, "insets"    # Ljava/lang/Object;

    .line 48
    move-object v0, p0

    check-cast v0, Landroid/view/WindowInsets;

    invoke-virtual {v0}, Landroid/view/WindowInsets;->hasStableInsets()Z

    move-result v0

    return v0
.end method

.method public static isConsumed(Ljava/lang/Object;)Z
    .locals 1
    .param p0, "insets"    # Ljava/lang/Object;

    .line 52
    move-object v0, p0

    check-cast v0, Landroid/view/WindowInsets;

    invoke-virtual {v0}, Landroid/view/WindowInsets;->isConsumed()Z

    move-result v0

    return v0
.end method

.method public static replaceSystemWindowInsets(Ljava/lang/Object;Landroid/graphics/Rect;)Ljava/lang/Object;
    .locals 1
    .param p0, "insets"    # Ljava/lang/Object;
    .param p1, "systemWindowInsets"    # Landroid/graphics/Rect;

    .line 56
    move-object v0, p0

    check-cast v0, Landroid/view/WindowInsets;

    invoke-virtual {v0, p1}, Landroid/view/WindowInsets;->replaceSystemWindowInsets(Landroid/graphics/Rect;)Landroid/view/WindowInsets;

    move-result-object v0

    return-object v0
.end method
