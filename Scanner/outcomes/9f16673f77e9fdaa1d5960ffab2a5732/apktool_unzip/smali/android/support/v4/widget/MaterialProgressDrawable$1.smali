.class Landroid/support/v4/widget/MaterialProgressDrawable$1;
.super Landroid/view/animation/Animation;
.source "MaterialProgressDrawable.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v4/widget/MaterialProgressDrawable;->setupAnimators()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/support/v4/widget/MaterialProgressDrawable;

.field final synthetic val$ring:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;


# direct methods
.method constructor <init>(Landroid/support/v4/widget/MaterialProgressDrawable;Landroid/support/v4/widget/MaterialProgressDrawable$Ring;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v4/widget/MaterialProgressDrawable;

    .line 363
    iput-object p1, p0, Landroid/support/v4/widget/MaterialProgressDrawable$1;->this$0:Landroid/support/v4/widget/MaterialProgressDrawable;

    iput-object p2, p0, Landroid/support/v4/widget/MaterialProgressDrawable$1;->val$ring:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-direct {p0}, Landroid/view/animation/Animation;-><init>()V

    return-void
.end method


# virtual methods
.method public applyTransformation(FLandroid/view/animation/Transformation;)V
    .locals 9
    .param p1, "interpolatedTime"    # F
    .param p2, "t"    # Landroid/view/animation/Transformation;

    .line 366
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable$1;->this$0:Landroid/support/v4/widget/MaterialProgressDrawable;

    iget-boolean v0, v0, Landroid/support/v4/widget/MaterialProgressDrawable;->mFinishing:Z

    if-eqz v0, :cond_0

    .line 367
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable$1;->this$0:Landroid/support/v4/widget/MaterialProgressDrawable;

    iget-object v1, p0, Landroid/support/v4/widget/MaterialProgressDrawable$1;->val$ring:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v0, p1, v1}, Landroid/support/v4/widget/MaterialProgressDrawable;->applyFinishTranslation(FLandroid/support/v4/widget/MaterialProgressDrawable$Ring;)V

    goto :goto_2

    .line 371
    :cond_0
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable$1;->this$0:Landroid/support/v4/widget/MaterialProgressDrawable;

    iget-object v1, p0, Landroid/support/v4/widget/MaterialProgressDrawable$1;->val$ring:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/MaterialProgressDrawable;->getMinProgressArc(Landroid/support/v4/widget/MaterialProgressDrawable$Ring;)F

    move-result v0

    .line 372
    .local v0, "minProgressArc":F
    iget-object v1, p0, Landroid/support/v4/widget/MaterialProgressDrawable$1;->val$ring:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->getStartingEndTrim()F

    move-result v1

    .line 373
    .local v1, "startingEndTrim":F
    iget-object v2, p0, Landroid/support/v4/widget/MaterialProgressDrawable$1;->val$ring:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v2}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->getStartingStartTrim()F

    move-result v2

    .line 374
    .local v2, "startingTrim":F
    iget-object v3, p0, Landroid/support/v4/widget/MaterialProgressDrawable$1;->val$ring:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v3}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->getStartingRotation()F

    move-result v3

    .line 376
    .local v3, "startingRotation":F
    iget-object v4, p0, Landroid/support/v4/widget/MaterialProgressDrawable$1;->this$0:Landroid/support/v4/widget/MaterialProgressDrawable;

    iget-object v5, p0, Landroid/support/v4/widget/MaterialProgressDrawable$1;->val$ring:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v4, p1, v5}, Landroid/support/v4/widget/MaterialProgressDrawable;->updateRingColor(FLandroid/support/v4/widget/MaterialProgressDrawable$Ring;)V

    .line 380
    const v4, 0x3f4ccccd    # 0.8f

    const/high16 v5, 0x3f000000    # 0.5f

    cmpg-float v6, p1, v5

    if-gtz v6, :cond_1

    .line 384
    div-float v6, p1, v5

    .line 386
    .local v6, "scaledTime":F
    sub-float v7, v4, v0

    sget-object v8, Landroid/support/v4/widget/MaterialProgressDrawable;->MATERIAL_INTERPOLATOR:Landroid/view/animation/Interpolator;

    .line 388
    invoke-interface {v8, v6}, Landroid/view/animation/Interpolator;->getInterpolation(F)F

    move-result v8

    mul-float v7, v7, v8

    add-float/2addr v7, v2

    .line 389
    .local v7, "startTrim":F
    iget-object v8, p0, Landroid/support/v4/widget/MaterialProgressDrawable$1;->val$ring:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v8, v7}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setStartTrim(F)V

    goto :goto_0

    .line 380
    .end local v6    # "scaledTime":F
    .end local v7    # "startTrim":F
    :cond_1
    nop

    .line 394
    :goto_0
    cmpl-float v6, p1, v5

    if-lez v6, :cond_2

    .line 398
    sub-float/2addr v4, v0

    .line 399
    .local v4, "minArc":F
    sub-float v6, p1, v5

    div-float/2addr v6, v5

    .line 401
    .restart local v6    # "scaledTime":F
    sget-object v5, Landroid/support/v4/widget/MaterialProgressDrawable;->MATERIAL_INTERPOLATOR:Landroid/view/animation/Interpolator;

    .line 402
    invoke-interface {v5, v6}, Landroid/view/animation/Interpolator;->getInterpolation(F)F

    move-result v5

    mul-float v5, v5, v4

    add-float/2addr v5, v1

    .line 403
    .local v5, "endTrim":F
    iget-object v7, p0, Landroid/support/v4/widget/MaterialProgressDrawable$1;->val$ring:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v7, v5}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setEndTrim(F)V

    goto :goto_1

    .line 394
    .end local v4    # "minArc":F
    .end local v5    # "endTrim":F
    .end local v6    # "scaledTime":F
    :cond_2
    nop

    .line 406
    :goto_1
    const/high16 v4, 0x3e800000    # 0.25f

    mul-float v4, v4, p1

    add-float/2addr v4, v3

    .line 407
    .local v4, "rotation":F
    iget-object v5, p0, Landroid/support/v4/widget/MaterialProgressDrawable$1;->val$ring:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v5, v4}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setRotation(F)V

    .line 409
    const/high16 v5, 0x43580000    # 216.0f

    mul-float v5, v5, p1

    const/high16 v6, 0x44870000    # 1080.0f

    iget-object v7, p0, Landroid/support/v4/widget/MaterialProgressDrawable$1;->this$0:Landroid/support/v4/widget/MaterialProgressDrawable;

    iget v7, v7, Landroid/support/v4/widget/MaterialProgressDrawable;->mRotationCount:F

    const/high16 v8, 0x40a00000    # 5.0f

    div-float/2addr v7, v8

    mul-float v7, v7, v6

    add-float/2addr v5, v7

    .line 411
    .local v5, "groupRotation":F
    iget-object v6, p0, Landroid/support/v4/widget/MaterialProgressDrawable$1;->this$0:Landroid/support/v4/widget/MaterialProgressDrawable;

    invoke-virtual {v6, v5}, Landroid/support/v4/widget/MaterialProgressDrawable;->setRotation(F)V

    .line 413
    .end local v0    # "minProgressArc":F
    .end local v1    # "startingEndTrim":F
    .end local v2    # "startingTrim":F
    .end local v3    # "startingRotation":F
    .end local v4    # "rotation":F
    .end local v5    # "groupRotation":F
    :goto_2
    return-void
.end method
