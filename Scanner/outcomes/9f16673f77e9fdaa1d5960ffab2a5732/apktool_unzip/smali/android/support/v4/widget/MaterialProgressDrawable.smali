.class Landroid/support/v4/widget/MaterialProgressDrawable;
.super Landroid/graphics/drawable/Drawable;
.source "MaterialProgressDrawable.java"

# interfaces
.implements Landroid/graphics/drawable/Animatable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v4/widget/MaterialProgressDrawable$Ring;,
        Landroid/support/v4/widget/MaterialProgressDrawable$ProgressDrawableSize;
    }
.end annotation


# static fields
.field private static final ANIMATION_DURATION:I = 0x534

.field private static final ARROW_HEIGHT:I = 0x5

.field private static final ARROW_HEIGHT_LARGE:I = 0x6

.field private static final ARROW_OFFSET_ANGLE:F = 5.0f

.field private static final ARROW_WIDTH:I = 0xa

.field private static final ARROW_WIDTH_LARGE:I = 0xc

.field private static final CENTER_RADIUS:F = 8.75f

.field private static final CENTER_RADIUS_LARGE:F = 12.5f

.field private static final CIRCLE_DIAMETER:I = 0x28

.field private static final CIRCLE_DIAMETER_LARGE:I = 0x38

.field private static final COLORS:[I

.field private static final COLOR_START_DELAY_OFFSET:F = 0.75f

.field static final DEFAULT:I = 0x1

.field private static final END_TRIM_START_DELAY_OFFSET:F = 0.5f

.field private static final FULL_ROTATION:F = 1080.0f

.field static final LARGE:I = 0x0

.field private static final LINEAR_INTERPOLATOR:Landroid/view/animation/Interpolator;

.field static final MATERIAL_INTERPOLATOR:Landroid/view/animation/Interpolator;

.field private static final MAX_PROGRESS_ARC:F = 0.8f

.field private static final NUM_POINTS:F = 5.0f

.field private static final START_TRIM_DURATION_OFFSET:F = 0.5f

.field private static final STROKE_WIDTH:F = 2.5f

.field private static final STROKE_WIDTH_LARGE:F = 3.0f


# instance fields
.field private mAnimation:Landroid/view/animation/Animation;

.field private final mAnimators:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroid/view/animation/Animation;",
            ">;"
        }
    .end annotation
.end field

.field private final mCallback:Landroid/graphics/drawable/Drawable$Callback;

.field mFinishing:Z

.field private mHeight:D

.field private mParent:Landroid/view/View;

.field private mResources:Landroid/content/res/Resources;

.field private final mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

.field private mRotation:F

.field mRotationCount:F

.field private mWidth:D


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 50
    new-instance v0, Landroid/view/animation/LinearInterpolator;

    invoke-direct {v0}, Landroid/view/animation/LinearInterpolator;-><init>()V

    sput-object v0, Landroid/support/v4/widget/MaterialProgressDrawable;->LINEAR_INTERPOLATOR:Landroid/view/animation/Interpolator;

    .line 51
    new-instance v0, Landroid/support/v4/view/animation/FastOutSlowInInterpolator;

    invoke-direct {v0}, Landroid/support/v4/view/animation/FastOutSlowInInterpolator;-><init>()V

    sput-object v0, Landroid/support/v4/widget/MaterialProgressDrawable;->MATERIAL_INTERPOLATOR:Landroid/view/animation/Interpolator;

    .line 74
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    const/high16 v2, -0x1000000

    aput v2, v0, v1

    sput-object v0, Landroid/support/v4/widget/MaterialProgressDrawable;->COLORS:[I

    return-void
.end method

.method constructor <init>(Landroid/content/Context;Landroid/view/View;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "parent"    # Landroid/view/View;

    .line 118
    invoke-direct {p0}, Landroid/graphics/drawable/Drawable;-><init>()V

    .line 92
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mAnimators:Ljava/util/ArrayList;

    .line 449
    new-instance v0, Landroid/support/v4/widget/MaterialProgressDrawable$3;

    invoke-direct {v0, p0}, Landroid/support/v4/widget/MaterialProgressDrawable$3;-><init>(Landroid/support/v4/widget/MaterialProgressDrawable;)V

    iput-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mCallback:Landroid/graphics/drawable/Drawable$Callback;

    .line 119
    iput-object p2, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mParent:Landroid/view/View;

    .line 120
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mResources:Landroid/content/res/Resources;

    .line 122
    new-instance v0, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    iget-object v1, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mCallback:Landroid/graphics/drawable/Drawable$Callback;

    invoke-direct {v0, v1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;-><init>(Landroid/graphics/drawable/Drawable$Callback;)V

    iput-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    .line 123
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    sget-object v1, Landroid/support/v4/widget/MaterialProgressDrawable;->COLORS:[I

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setColors([I)V

    .line 125
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/support/v4/widget/MaterialProgressDrawable;->updateSizes(I)V

    .line 126
    invoke-direct {p0}, Landroid/support/v4/widget/MaterialProgressDrawable;->setupAnimators()V

    .line 127
    return-void
.end method

.method private evaluateColorChange(FII)I
    .locals 12
    .param p1, "fraction"    # F
    .param p2, "startValue"    # I
    .param p3, "endValue"    # I

    .line 309
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 310
    .local v0, "startInt":I
    shr-int/lit8 v1, v0, 0x18

    and-int/lit16 v1, v1, 0xff

    .line 311
    .local v1, "startA":I
    shr-int/lit8 v2, v0, 0x10

    and-int/lit16 v2, v2, 0xff

    .line 312
    .local v2, "startR":I
    shr-int/lit8 v3, v0, 0x8

    and-int/lit16 v3, v3, 0xff

    .line 313
    .local v3, "startG":I
    and-int/lit16 v4, v0, 0xff

    .line 315
    .local v4, "startB":I
    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    .line 316
    .local v5, "endInt":I
    shr-int/lit8 v6, v5, 0x18

    and-int/lit16 v6, v6, 0xff

    .line 317
    .local v6, "endA":I
    shr-int/lit8 v7, v5, 0x10

    and-int/lit16 v7, v7, 0xff

    .line 318
    .local v7, "endR":I
    shr-int/lit8 v8, v5, 0x8

    and-int/lit16 v8, v8, 0xff

    .line 319
    .local v8, "endG":I
    and-int/lit16 v9, v5, 0xff

    .line 321
    .local v9, "endB":I
    sub-int v10, v6, v1

    int-to-float v10, v10

    mul-float v10, v10, p1

    float-to-int v10, v10

    add-int/2addr v10, v1

    shl-int/lit8 v10, v10, 0x18

    sub-int v11, v7, v2

    int-to-float v11, v11

    mul-float v11, v11, p1

    float-to-int v11, v11

    add-int/2addr v11, v2

    shl-int/lit8 v11, v11, 0x10

    or-int/2addr v10, v11

    sub-int v11, v8, v3

    int-to-float v11, v11

    mul-float v11, v11, p1

    float-to-int v11, v11

    add-int/2addr v11, v3

    shl-int/lit8 v11, v11, 0x8

    or-int/2addr v10, v11

    sub-int v11, v9, v4

    int-to-float v11, v11

    mul-float v11, v11, p1

    float-to-int v11, v11

    add-int/2addr v11, v4

    or-int/2addr v10, v11

    return v10
.end method

.method private getRotation()F
    .locals 1

    .line 255
    iget v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRotation:F

    return v0
.end method

.method private setSizeParameters(DDDDFF)V
    .locals 9
    .param p1, "progressCircleWidth"    # D
    .param p3, "progressCircleHeight"    # D
    .param p5, "centerRadius"    # D
    .param p7, "strokeWidth"    # D
    .param p9, "arrowWidth"    # F
    .param p10, "arrowHeight"    # F

    .line 131
    move-object v0, p0

    iget-object v1, v0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    .line 132
    .local v1, "ring":Landroid/support/v4/widget/MaterialProgressDrawable$Ring;
    iget-object v2, v0, Landroid/support/v4/widget/MaterialProgressDrawable;->mResources:Landroid/content/res/Resources;

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    .line 133
    .local v2, "metrics":Landroid/util/DisplayMetrics;
    iget v3, v2, Landroid/util/DisplayMetrics;->density:F

    .line 135
    .local v3, "screenDensity":F
    float-to-double v4, v3

    invoke-static {v4, v5}, Ljava/lang/Double;->isNaN(D)Z

    mul-double v4, v4, p1

    iput-wide v4, v0, Landroid/support/v4/widget/MaterialProgressDrawable;->mWidth:D

    .line 136
    float-to-double v4, v3

    invoke-static {v4, v5}, Ljava/lang/Double;->isNaN(D)Z

    mul-double v4, v4, p3

    iput-wide v4, v0, Landroid/support/v4/widget/MaterialProgressDrawable;->mHeight:D

    .line 137
    move-wide/from16 v4, p7

    double-to-float v6, v4

    mul-float v6, v6, v3

    invoke-virtual {v1, v6}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setStrokeWidth(F)V

    .line 138
    float-to-double v6, v3

    invoke-static {v6, v7}, Ljava/lang/Double;->isNaN(D)Z

    mul-double v6, v6, p5

    invoke-virtual {v1, v6, v7}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setCenterRadius(D)V

    .line 139
    const/4 v6, 0x0

    invoke-virtual {v1, v6}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setColorIndex(I)V

    .line 140
    mul-float v6, p9, v3

    mul-float v7, p10, v3

    invoke-virtual {v1, v6, v7}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setArrowDimensions(FF)V

    .line 141
    iget-wide v6, v0, Landroid/support/v4/widget/MaterialProgressDrawable;->mWidth:D

    double-to-int v6, v6

    iget-wide v7, v0, Landroid/support/v4/widget/MaterialProgressDrawable;->mHeight:D

    double-to-int v7, v7

    invoke-virtual {v1, v6, v7}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setInsets(II)V

    .line 142
    return-void
.end method

.method private setupAnimators()V
    .locals 3

    .line 362
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    .line 363
    .local v0, "ring":Landroid/support/v4/widget/MaterialProgressDrawable$Ring;
    new-instance v1, Landroid/support/v4/widget/MaterialProgressDrawable$1;

    invoke-direct {v1, p0, v0}, Landroid/support/v4/widget/MaterialProgressDrawable$1;-><init>(Landroid/support/v4/widget/MaterialProgressDrawable;Landroid/support/v4/widget/MaterialProgressDrawable$Ring;)V

    .line 415
    .local v1, "animation":Landroid/view/animation/Animation;
    const/4 v2, -0x1

    invoke-virtual {v1, v2}, Landroid/view/animation/Animation;->setRepeatCount(I)V

    .line 416
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/view/animation/Animation;->setRepeatMode(I)V

    .line 417
    sget-object v2, Landroid/support/v4/widget/MaterialProgressDrawable;->LINEAR_INTERPOLATOR:Landroid/view/animation/Interpolator;

    invoke-virtual {v1, v2}, Landroid/view/animation/Animation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 418
    new-instance v2, Landroid/support/v4/widget/MaterialProgressDrawable$2;

    invoke-direct {v2, p0, v0}, Landroid/support/v4/widget/MaterialProgressDrawable$2;-><init>(Landroid/support/v4/widget/MaterialProgressDrawable;Landroid/support/v4/widget/MaterialProgressDrawable$Ring;)V

    invoke-virtual {v1, v2}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 446
    iput-object v1, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mAnimation:Landroid/view/animation/Animation;

    .line 447
    return-void
.end method


# virtual methods
.method applyFinishTranslation(FLandroid/support/v4/widget/MaterialProgressDrawable$Ring;)V
    .locals 5
    .param p1, "interpolatedTime"    # F
    .param p2, "ring"    # Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    .line 347
    invoke-virtual {p0, p1, p2}, Landroid/support/v4/widget/MaterialProgressDrawable;->updateRingColor(FLandroid/support/v4/widget/MaterialProgressDrawable$Ring;)V

    .line 348
    invoke-virtual {p2}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->getStartingRotation()F

    move-result v0

    const v1, 0x3f4ccccd    # 0.8f

    div-float/2addr v0, v1

    float-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    add-double/2addr v0, v2

    double-to-float v0, v0

    .line 350
    .local v0, "targetRotation":F
    invoke-virtual {p0, p2}, Landroid/support/v4/widget/MaterialProgressDrawable;->getMinProgressArc(Landroid/support/v4/widget/MaterialProgressDrawable$Ring;)F

    move-result v1

    .line 351
    .local v1, "minProgressArc":F
    invoke-virtual {p2}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->getStartingStartTrim()F

    move-result v2

    .line 352
    invoke-virtual {p2}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->getStartingEndTrim()F

    move-result v3

    sub-float/2addr v3, v1

    invoke-virtual {p2}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->getStartingStartTrim()F

    move-result v4

    sub-float/2addr v3, v4

    mul-float v3, v3, p1

    add-float/2addr v2, v3

    .line 354
    .local v2, "startTrim":F
    invoke-virtual {p2, v2}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setStartTrim(F)V

    .line 355
    invoke-virtual {p2}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->getStartingEndTrim()F

    move-result v3

    invoke-virtual {p2, v3}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setEndTrim(F)V

    .line 356
    invoke-virtual {p2}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->getStartingRotation()F

    move-result v3

    .line 357
    invoke-virtual {p2}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->getStartingRotation()F

    move-result v4

    sub-float v4, v0, v4

    mul-float v4, v4, p1

    add-float/2addr v3, v4

    .line 358
    .local v3, "rotation":F
    invoke-virtual {p2, v3}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setRotation(F)V

    .line 359
    return-void
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "c"    # Landroid/graphics/Canvas;

    .line 226
    invoke-virtual {p0}, Landroid/support/v4/widget/MaterialProgressDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v0

    .line 227
    .local v0, "bounds":Landroid/graphics/Rect;
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v1

    .line 228
    .local v1, "saveCount":I
    iget v2, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRotation:F

    invoke-virtual {v0}, Landroid/graphics/Rect;->exactCenterX()F

    move-result v3

    invoke-virtual {v0}, Landroid/graphics/Rect;->exactCenterY()F

    move-result v4

    invoke-virtual {p1, v2, v3, v4}, Landroid/graphics/Canvas;->rotate(FFF)V

    .line 229
    iget-object v2, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v2, p1, v0}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->draw(Landroid/graphics/Canvas;Landroid/graphics/Rect;)V

    .line 230
    invoke-virtual {p1, v1}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 231
    return-void
.end method

.method public getAlpha()I
    .locals 1

    .line 239
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v0}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->getAlpha()I

    move-result v0

    return v0
.end method

.method public getIntrinsicHeight()I
    .locals 2

    .line 216
    iget-wide v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mHeight:D

    double-to-int v0, v0

    return v0
.end method

.method public getIntrinsicWidth()I
    .locals 2

    .line 221
    iget-wide v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mWidth:D

    double-to-int v0, v0

    return v0
.end method

.method getMinProgressArc(Landroid/support/v4/widget/MaterialProgressDrawable$Ring;)F
    .locals 6
    .param p1, "ring"    # Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    .line 303
    nop

    .line 304
    invoke-virtual {p1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->getStrokeWidth()F

    move-result v0

    float-to-double v0, v0

    invoke-virtual {p1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->getCenterRadius()D

    move-result-wide v2

    const-wide v4, 0x401921fb54442d18L    # 6.283185307179586

    mul-double v2, v2, v4

    invoke-static {v0, v1}, Ljava/lang/Double;->isNaN(D)Z

    div-double/2addr v0, v2

    .line 303
    invoke-static {v0, v1}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide v0

    double-to-float v0, v0

    return v0
.end method

.method public getOpacity()I
    .locals 1

    .line 260
    const/4 v0, -0x3

    return v0
.end method

.method public isRunning()Z
    .locals 5

    .line 265
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mAnimators:Ljava/util/ArrayList;

    .line 266
    .local v0, "animators":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 267
    .local v1, "N":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_1

    .line 268
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/animation/Animation;

    .line 269
    .local v3, "animator":Landroid/view/animation/Animation;
    invoke-virtual {v3}, Landroid/view/animation/Animation;->hasStarted()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-virtual {v3}, Landroid/view/animation/Animation;->hasEnded()Z

    move-result v4

    if-nez v4, :cond_0

    .line 270
    const/4 v4, 0x1

    return v4

    .line 269
    :cond_0
    nop

    .line 267
    .end local v3    # "animator":Landroid/view/animation/Animation;
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 273
    .end local v2    # "i":I
    :cond_1
    const/4 v2, 0x0

    return v2
.end method

.method public setAlpha(I)V
    .locals 1
    .param p1, "alpha"    # I

    .line 235
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setAlpha(I)V

    .line 236
    return-void
.end method

.method public setArrowScale(F)V
    .locals 1
    .param p1, "scale"    # F

    .line 172
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setArrowScale(F)V

    .line 173
    return-void
.end method

.method public setBackgroundColor(I)V
    .locals 1
    .param p1, "color"    # I

    .line 199
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setBackgroundColor(I)V

    .line 200
    return-void
.end method

.method public setColorFilter(Landroid/graphics/ColorFilter;)V
    .locals 1
    .param p1, "colorFilter"    # Landroid/graphics/ColorFilter;

    .line 244
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 245
    return-void
.end method

.method public varargs setColorSchemeColors([I)V
    .locals 2
    .param p1, "colors"    # [I

    .line 210
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setColors([I)V

    .line 211
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setColorIndex(I)V

    .line 212
    return-void
.end method

.method public setProgressRotation(F)V
    .locals 1
    .param p1, "rotation"    # F

    .line 192
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setRotation(F)V

    .line 193
    return-void
.end method

.method setRotation(F)V
    .locals 0
    .param p1, "rotation"    # F

    .line 249
    iput p1, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRotation:F

    .line 250
    invoke-virtual {p0}, Landroid/support/v4/widget/MaterialProgressDrawable;->invalidateSelf()V

    .line 251
    return-void
.end method

.method public setStartEndTrim(FF)V
    .locals 1
    .param p1, "startAngle"    # F
    .param p2, "endAngle"    # F

    .line 182
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setStartTrim(F)V

    .line 183
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v0, p2}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setEndTrim(F)V

    .line 184
    return-void
.end method

.method public showArrow(Z)V
    .locals 1
    .param p1, "show"    # Z

    .line 165
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setShowArrow(Z)V

    .line 166
    return-void
.end method

.method public start()V
    .locals 3

    .line 278
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mAnimation:Landroid/view/animation/Animation;

    invoke-virtual {v0}, Landroid/view/animation/Animation;->reset()V

    .line 279
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v0}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->storeOriginals()V

    .line 281
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v0}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->getEndTrim()F

    move-result v0

    iget-object v1, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->getStartTrim()F

    move-result v1

    cmpl-float v0, v0, v1

    if-eqz v0, :cond_0

    .line 282
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mFinishing:Z

    .line 283
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mAnimation:Landroid/view/animation/Animation;

    const-wide/16 v1, 0x29a

    invoke-virtual {v0, v1, v2}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 284
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mParent:Landroid/view/View;

    iget-object v1, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mAnimation:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0

    .line 286
    :cond_0
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setColorIndex(I)V

    .line 287
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v0}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->resetOriginals()V

    .line 288
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mAnimation:Landroid/view/animation/Animation;

    const-wide/16 v1, 0x534

    invoke-virtual {v0, v1, v2}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 289
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mParent:Landroid/view/View;

    iget-object v1, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mAnimation:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 291
    :goto_0
    return-void
.end method

.method public stop()V
    .locals 2

    .line 295
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mParent:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->clearAnimation()V

    .line 296
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/support/v4/widget/MaterialProgressDrawable;->setRotation(F)V

    .line 297
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setShowArrow(Z)V

    .line 298
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setColorIndex(I)V

    .line 299
    iget-object v0, p0, Landroid/support/v4/widget/MaterialProgressDrawable;->mRing:Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    invoke-virtual {v0}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->resetOriginals()V

    .line 300
    return-void
.end method

.method updateRingColor(FLandroid/support/v4/widget/MaterialProgressDrawable$Ring;)V
    .locals 3
    .param p1, "interpolatedTime"    # F
    .param p2, "ring"    # Landroid/support/v4/widget/MaterialProgressDrawable$Ring;

    .line 333
    const/high16 v0, 0x3f400000    # 0.75f

    cmpl-float v1, p1, v0

    if-lez v1, :cond_0

    .line 337
    sub-float v0, p1, v0

    const/high16 v1, 0x3e800000    # 0.25f

    div-float/2addr v0, v1

    .line 338
    invoke-virtual {p2}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->getStartingColor()I

    move-result v1

    .line 339
    invoke-virtual {p2}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->getNextColor()I

    move-result v2

    .line 337
    invoke-direct {p0, v0, v1, v2}, Landroid/support/v4/widget/MaterialProgressDrawable;->evaluateColorChange(FII)I

    move-result v0

    invoke-virtual {p2, v0}, Landroid/support/v4/widget/MaterialProgressDrawable$Ring;->setColor(I)V

    goto :goto_0

    .line 333
    :cond_0
    nop

    .line 341
    :goto_0
    return-void
.end method

.method public updateSizes(I)V
    .locals 22
    .param p1, "size"    # I

    .line 152
    if-nez p1, :cond_0

    .line 153
    const-wide/high16 v1, 0x404c000000000000L    # 56.0

    const-wide/high16 v3, 0x404c000000000000L    # 56.0

    const-wide/high16 v5, 0x4029000000000000L    # 12.5

    const-wide/high16 v7, 0x4008000000000000L    # 3.0

    const/high16 v9, 0x41400000    # 12.0f

    const/high16 v10, 0x40c00000    # 6.0f

    move-object/from16 v0, p0

    invoke-direct/range {v0 .. v10}, Landroid/support/v4/widget/MaterialProgressDrawable;->setSizeParameters(DDDDFF)V

    goto :goto_0

    .line 156
    :cond_0
    const-wide/high16 v12, 0x4044000000000000L    # 40.0

    const-wide/high16 v14, 0x4044000000000000L    # 40.0

    const-wide v16, 0x4021800000000000L    # 8.75

    const-wide/high16 v18, 0x4004000000000000L    # 2.5

    const/high16 v20, 0x41200000    # 10.0f

    const/high16 v21, 0x40a00000    # 5.0f

    move-object/from16 v11, p0

    invoke-direct/range {v11 .. v21}, Landroid/support/v4/widget/MaterialProgressDrawable;->setSizeParameters(DDDDFF)V

    .line 159
    :goto_0
    return-void
.end method
