.class Landroid/support/v4/view/WindowInsetsCompatApi20;
.super Ljava/lang/Object;
.source "WindowInsetsCompatApi20.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x14
.end annotation

.annotation build Landroid/support/annotation/RequiresApi;
    value = 0x14
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static consumeSystemWindowInsets(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "insets"    # Ljava/lang/Object;

    .line 27
    move-object v0, p0

    check-cast v0, Landroid/view/WindowInsets;

    invoke-virtual {v0}, Landroid/view/WindowInsets;->consumeSystemWindowInsets()Landroid/view/WindowInsets;

    move-result-object v0

    return-object v0
.end method

.method public static getSourceWindowInsets(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p0, "src"    # Ljava/lang/Object;

    .line 64
    new-instance v0, Landroid/view/WindowInsets;

    move-object v1, p0

    check-cast v1, Landroid/view/WindowInsets;

    invoke-direct {v0, v1}, Landroid/view/WindowInsets;-><init>(Landroid/view/WindowInsets;)V

    return-object v0
.end method

.method public static getSystemWindowInsetBottom(Ljava/lang/Object;)I
    .locals 1
    .param p0, "insets"    # Ljava/lang/Object;

    .line 31
    move-object v0, p0

    check-cast v0, Landroid/view/WindowInsets;

    invoke-virtual {v0}, Landroid/view/WindowInsets;->getSystemWindowInsetBottom()I

    move-result v0

    return v0
.end method

.method public static getSystemWindowInsetLeft(Ljava/lang/Object;)I
    .locals 1
    .param p0, "insets"    # Ljava/lang/Object;

    .line 35
    move-object v0, p0

    check-cast v0, Landroid/view/WindowInsets;

    invoke-virtual {v0}, Landroid/view/WindowInsets;->getSystemWindowInsetLeft()I

    move-result v0

    return v0
.end method

.method public static getSystemWindowInsetRight(Ljava/lang/Object;)I
    .locals 1
    .param p0, "insets"    # Ljava/lang/Object;

    .line 39
    move-object v0, p0

    check-cast v0, Landroid/view/WindowInsets;

    invoke-virtual {v0}, Landroid/view/WindowInsets;->getSystemWindowInsetRight()I

    move-result v0

    return v0
.end method

.method public static getSystemWindowInsetTop(Ljava/lang/Object;)I
    .locals 1
    .param p0, "insets"    # Ljava/lang/Object;

    .line 43
    move-object v0, p0

    check-cast v0, Landroid/view/WindowInsets;

    invoke-virtual {v0}, Landroid/view/WindowInsets;->getSystemWindowInsetTop()I

    move-result v0

    return v0
.end method

.method public static hasInsets(Ljava/lang/Object;)Z
    .locals 1
    .param p0, "insets"    # Ljava/lang/Object;

    .line 47
    move-object v0, p0

    check-cast v0, Landroid/view/WindowInsets;

    invoke-virtual {v0}, Landroid/view/WindowInsets;->hasInsets()Z

    move-result v0

    return v0
.end method

.method public static hasSystemWindowInsets(Ljava/lang/Object;)Z
    .locals 1
    .param p0, "insets"    # Ljava/lang/Object;

    .line 51
    move-object v0, p0

    check-cast v0, Landroid/view/WindowInsets;

    invoke-virtual {v0}, Landroid/view/WindowInsets;->hasSystemWindowInsets()Z

    move-result v0

    return v0
.end method

.method public static isRound(Ljava/lang/Object;)Z
    .locals 1
    .param p0, "insets"    # Ljava/lang/Object;

    .line 55
    move-object v0, p0

    check-cast v0, Landroid/view/WindowInsets;

    invoke-virtual {v0}, Landroid/view/WindowInsets;->isRound()Z

    move-result v0

    return v0
.end method

.method public static replaceSystemWindowInsets(Ljava/lang/Object;IIII)Ljava/lang/Object;
    .locals 1
    .param p0, "insets"    # Ljava/lang/Object;
    .param p1, "left"    # I
    .param p2, "top"    # I
    .param p3, "right"    # I
    .param p4, "bottom"    # I

    .line 60
    move-object v0, p0

    check-cast v0, Landroid/view/WindowInsets;

    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/view/WindowInsets;->replaceSystemWindowInsets(IIII)Landroid/view/WindowInsets;

    move-result-object v0

    return-object v0
.end method
