.class Landroid/support/v4/view/ScaleGestureDetectorCompatKitKat;
.super Ljava/lang/Object;
.source "ScaleGestureDetectorCompatKitKat.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x13
.end annotation

.annotation build Landroid/support/annotation/RequiresApi;
    value = 0x13
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    return-void
.end method

.method public static isQuickScaleEnabled(Ljava/lang/Object;)Z
    .locals 1
    .param p0, "scaleGestureDetector"    # Ljava/lang/Object;

    .line 40
    move-object v0, p0

    check-cast v0, Landroid/view/ScaleGestureDetector;

    invoke-virtual {v0}, Landroid/view/ScaleGestureDetector;->isQuickScaleEnabled()Z

    move-result v0

    return v0
.end method

.method public static setQuickScaleEnabled(Ljava/lang/Object;Z)V
    .locals 1
    .param p0, "scaleGestureDetector"    # Ljava/lang/Object;
    .param p1, "enabled"    # Z

    .line 36
    move-object v0, p0

    check-cast v0, Landroid/view/ScaleGestureDetector;

    invoke-virtual {v0, p1}, Landroid/view/ScaleGestureDetector;->setQuickScaleEnabled(Z)V

    .line 37
    return-void
.end method
