.class public Landroid/support/v4/widget/SlidingPaneLayout;
.super Landroid/view/ViewGroup;
.source "SlidingPaneLayout.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v4/widget/SlidingPaneLayout$DisableLayerRunnable;,
        Landroid/support/v4/widget/SlidingPaneLayout$AccessibilityDelegate;,
        Landroid/support/v4/widget/SlidingPaneLayout$SlidingPanelLayoutImplJBMR1;,
        Landroid/support/v4/widget/SlidingPaneLayout$SlidingPanelLayoutImplJB;,
        Landroid/support/v4/widget/SlidingPaneLayout$SlidingPanelLayoutImplBase;,
        Landroid/support/v4/widget/SlidingPaneLayout$SlidingPanelLayoutImpl;,
        Landroid/support/v4/widget/SlidingPaneLayout$SavedState;,
        Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;,
        Landroid/support/v4/widget/SlidingPaneLayout$DragHelperCallback;,
        Landroid/support/v4/widget/SlidingPaneLayout$SimplePanelSlideListener;,
        Landroid/support/v4/widget/SlidingPaneLayout$PanelSlideListener;
    }
.end annotation


# static fields
.field private static final DEFAULT_FADE_COLOR:I = -0x33333334

.field private static final DEFAULT_OVERHANG_SIZE:I = 0x20

.field static final IMPL:Landroid/support/v4/widget/SlidingPaneLayout$SlidingPanelLayoutImpl;

.field private static final MIN_FLING_VELOCITY:I = 0x190

.field private static final TAG:Ljava/lang/String; = "SlidingPaneLayout"


# instance fields
.field private mCanSlide:Z

.field private mCoveredFadeColor:I

.field final mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

.field private mFirstLayout:Z

.field private mInitialMotionX:F

.field private mInitialMotionY:F

.field mIsUnableToDrag:Z

.field private final mOverhangSize:I

.field private mPanelSlideListener:Landroid/support/v4/widget/SlidingPaneLayout$PanelSlideListener;

.field private mParallaxBy:I

.field private mParallaxOffset:F

.field final mPostedRunnables:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroid/support/v4/widget/SlidingPaneLayout$DisableLayerRunnable;",
            ">;"
        }
    .end annotation
.end field

.field mPreservedOpenState:Z

.field private mShadowDrawableLeft:Landroid/graphics/drawable/Drawable;

.field private mShadowDrawableRight:Landroid/graphics/drawable/Drawable;

.field mSlideOffset:F

.field mSlideRange:I

.field mSlideableView:Landroid/view/View;

.field private mSliderFadeColor:I

.field private final mTmpRect:Landroid/graphics/Rect;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 203
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 204
    .local v0, "deviceVersion":I
    const/16 v1, 0x11

    if-lt v0, v1, :cond_0

    .line 205
    new-instance v1, Landroid/support/v4/widget/SlidingPaneLayout$SlidingPanelLayoutImplJBMR1;

    invoke-direct {v1}, Landroid/support/v4/widget/SlidingPaneLayout$SlidingPanelLayoutImplJBMR1;-><init>()V

    sput-object v1, Landroid/support/v4/widget/SlidingPaneLayout;->IMPL:Landroid/support/v4/widget/SlidingPaneLayout$SlidingPanelLayoutImpl;

    goto :goto_0

    .line 206
    :cond_0
    const/16 v1, 0x10

    if-lt v0, v1, :cond_1

    .line 207
    new-instance v1, Landroid/support/v4/widget/SlidingPaneLayout$SlidingPanelLayoutImplJB;

    invoke-direct {v1}, Landroid/support/v4/widget/SlidingPaneLayout$SlidingPanelLayoutImplJB;-><init>()V

    sput-object v1, Landroid/support/v4/widget/SlidingPaneLayout;->IMPL:Landroid/support/v4/widget/SlidingPaneLayout$SlidingPanelLayoutImpl;

    goto :goto_0

    .line 209
    :cond_1
    new-instance v1, Landroid/support/v4/widget/SlidingPaneLayout$SlidingPanelLayoutImplBase;

    invoke-direct {v1}, Landroid/support/v4/widget/SlidingPaneLayout$SlidingPanelLayoutImplBase;-><init>()V

    sput-object v1, Landroid/support/v4/widget/SlidingPaneLayout;->IMPL:Landroid/support/v4/widget/SlidingPaneLayout$SlidingPanelLayoutImpl;

    .line 211
    .end local v0    # "deviceVersion":I
    :goto_0
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 255
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v4/widget/SlidingPaneLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 256
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .line 259
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroid/support/v4/widget/SlidingPaneLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 260
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .line 263
    invoke-direct {p0, p1, p2, p3}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 113
    const v0, -0x33333334

    iput v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSliderFadeColor:I

    .line 193
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mFirstLayout:Z

    .line 195
    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    iput-object v1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mTmpRect:Landroid/graphics/Rect;

    .line 197
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mPostedRunnables:Ljava/util/ArrayList;

    .line 265
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->density:F

    .line 266
    .local v1, "density":F
    const/high16 v2, 0x42000000    # 32.0f

    mul-float v2, v2, v1

    const/high16 v3, 0x3f000000    # 0.5f

    add-float/2addr v2, v3

    float-to-int v2, v2

    iput v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mOverhangSize:I

    .line 268
    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v2

    .line 270
    .local v2, "viewConfig":Landroid/view/ViewConfiguration;
    const/4 v4, 0x0

    invoke-virtual {p0, v4}, Landroid/support/v4/widget/SlidingPaneLayout;->setWillNotDraw(Z)V

    .line 272
    new-instance v4, Landroid/support/v4/widget/SlidingPaneLayout$AccessibilityDelegate;

    invoke-direct {v4, p0}, Landroid/support/v4/widget/SlidingPaneLayout$AccessibilityDelegate;-><init>(Landroid/support/v4/widget/SlidingPaneLayout;)V

    invoke-static {p0, v4}, Landroid/support/v4/view/ViewCompat;->setAccessibilityDelegate(Landroid/view/View;Landroid/support/v4/view/AccessibilityDelegateCompat;)V

    .line 273
    invoke-static {p0, v0}, Landroid/support/v4/view/ViewCompat;->setImportantForAccessibility(Landroid/view/View;I)V

    .line 275
    new-instance v0, Landroid/support/v4/widget/SlidingPaneLayout$DragHelperCallback;

    invoke-direct {v0, p0}, Landroid/support/v4/widget/SlidingPaneLayout$DragHelperCallback;-><init>(Landroid/support/v4/widget/SlidingPaneLayout;)V

    invoke-static {p0, v3, v0}, Landroid/support/v4/widget/ViewDragHelper;->create(Landroid/view/ViewGroup;FLandroid/support/v4/widget/ViewDragHelper$Callback;)Landroid/support/v4/widget/ViewDragHelper;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    .line 276
    iget-object v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    const/high16 v3, 0x43c80000    # 400.0f

    mul-float v3, v3, v1

    invoke-virtual {v0, v3}, Landroid/support/v4/widget/ViewDragHelper;->setMinVelocity(F)V

    .line 277
    return-void
.end method

.method private closePane(Landroid/view/View;I)Z
    .locals 2
    .param p1, "pane"    # Landroid/view/View;
    .param p2, "initialVelocity"    # I

    .line 869
    iget-boolean v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mFirstLayout:Z

    const/4 v1, 0x0

    if-nez v0, :cond_1

    const/4 v0, 0x0

    invoke-virtual {p0, v0, p2}, Landroid/support/v4/widget/SlidingPaneLayout;->smoothSlideTo(FI)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    .line 873
    :cond_0
    return v1

    .line 869
    :cond_1
    :goto_0
    nop

    .line 870
    iput-boolean v1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mPreservedOpenState:Z

    .line 871
    const/4 v0, 0x1

    return v0
.end method

.method private dimChildView(Landroid/view/View;FI)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;
    .param p2, "mag"    # F
    .param p3, "fadeColor"    # I

    .line 978
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;

    .line 980
    .local v0, "lp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    const/4 v1, 0x0

    cmpl-float v1, p2, v1

    if-lez v1, :cond_2

    if-eqz p3, :cond_2

    .line 981
    const/high16 v1, -0x1000000

    and-int/2addr v1, p3

    ushr-int/lit8 v1, v1, 0x18

    .line 982
    .local v1, "baseAlpha":I
    int-to-float v2, v1

    mul-float v2, v2, p2

    float-to-int v2, v2

    .line 983
    .local v2, "imag":I
    shl-int/lit8 v3, v2, 0x18

    const v4, 0xffffff

    and-int/2addr v4, p3

    or-int/2addr v3, v4

    .line 984
    .local v3, "color":I
    iget-object v4, v0, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->dimPaint:Landroid/graphics/Paint;

    if-nez v4, :cond_0

    .line 985
    new-instance v4, Landroid/graphics/Paint;

    invoke-direct {v4}, Landroid/graphics/Paint;-><init>()V

    iput-object v4, v0, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->dimPaint:Landroid/graphics/Paint;

    goto :goto_0

    .line 984
    :cond_0
    nop

    .line 987
    :goto_0
    iget-object v4, v0, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->dimPaint:Landroid/graphics/Paint;

    new-instance v5, Landroid/graphics/PorterDuffColorFilter;

    sget-object v6, Landroid/graphics/PorterDuff$Mode;->SRC_OVER:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v5, v3, v6}, Landroid/graphics/PorterDuffColorFilter;-><init>(ILandroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v4, v5}, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;

    .line 988
    invoke-static {p1}, Landroid/support/v4/view/ViewCompat;->getLayerType(Landroid/view/View;)I

    move-result v4

    const/4 v5, 0x2

    if-eq v4, v5, :cond_1

    .line 989
    iget-object v4, v0, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->dimPaint:Landroid/graphics/Paint;

    invoke-static {p1, v5, v4}, Landroid/support/v4/view/ViewCompat;->setLayerType(Landroid/view/View;ILandroid/graphics/Paint;)V

    goto :goto_1

    .line 988
    :cond_1
    nop

    .line 991
    :goto_1
    invoke-virtual {p0, p1}, Landroid/support/v4/widget/SlidingPaneLayout;->invalidateChildRegion(Landroid/view/View;)V

    .end local v1    # "baseAlpha":I
    .end local v2    # "imag":I
    .end local v3    # "color":I
    goto :goto_3

    .line 980
    :cond_2
    nop

    .line 992
    invoke-static {p1}, Landroid/support/v4/view/ViewCompat;->getLayerType(Landroid/view/View;)I

    move-result v1

    if-eqz v1, :cond_4

    .line 993
    iget-object v1, v0, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->dimPaint:Landroid/graphics/Paint;

    if-eqz v1, :cond_3

    .line 994
    iget-object v1, v0, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->dimPaint:Landroid/graphics/Paint;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;

    goto :goto_2

    .line 993
    :cond_3
    nop

    .line 996
    :goto_2
    new-instance v1, Landroid/support/v4/widget/SlidingPaneLayout$DisableLayerRunnable;

    invoke-direct {v1, p0, p1}, Landroid/support/v4/widget/SlidingPaneLayout$DisableLayerRunnable;-><init>(Landroid/support/v4/widget/SlidingPaneLayout;Landroid/view/View;)V

    .line 997
    .local v1, "dlr":Landroid/support/v4/widget/SlidingPaneLayout$DisableLayerRunnable;
    iget-object v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mPostedRunnables:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 998
    invoke-static {p0, v1}, Landroid/support/v4/view/ViewCompat;->postOnAnimation(Landroid/view/View;Ljava/lang/Runnable;)V

    goto :goto_4

    .line 992
    .end local v1    # "dlr":Landroid/support/v4/widget/SlidingPaneLayout$DisableLayerRunnable;
    :cond_4
    :goto_3
    nop

    .line 1000
    :goto_4
    return-void
.end method

.method private openPane(Landroid/view/View;I)Z
    .locals 1
    .param p1, "pane"    # Landroid/view/View;
    .param p2, "initialVelocity"    # I

    .line 877
    iget-boolean v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mFirstLayout:Z

    if-nez v0, :cond_1

    const/high16 v0, 0x3f800000    # 1.0f

    invoke-virtual {p0, v0, p2}, Landroid/support/v4/widget/SlidingPaneLayout;->smoothSlideTo(FI)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    .line 881
    :cond_0
    const/4 v0, 0x0

    return v0

    .line 877
    :cond_1
    :goto_0
    nop

    .line 878
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mPreservedOpenState:Z

    .line 879
    return v0
.end method

.method private parallaxOtherViews(F)V
    .locals 11
    .param p1, "slideOffset"    # F

    .line 1198
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->isLayoutRtlSupport()Z

    move-result v0

    .line 1199
    .local v0, "isLayoutRtl":Z
    iget-object v1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;

    .line 1200
    .local v1, "slideLp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    iget-boolean v2, v1, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->dimWhenOffset:Z

    if-eqz v2, :cond_1

    if-eqz v0, :cond_0

    iget v2, v1, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->rightMargin:I

    goto :goto_0

    :cond_0
    iget v2, v1, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->leftMargin:I

    :goto_0
    if-gtz v2, :cond_1

    const/4 v2, 0x1

    goto :goto_1

    :cond_1
    const/4 v2, 0x0

    .line 1202
    .local v2, "dimViews":Z
    :goto_1
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getChildCount()I

    move-result v3

    .line 1203
    .local v3, "childCount":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_2
    if-ge v4, v3, :cond_6

    .line 1204
    invoke-virtual {p0, v4}, Landroid/support/v4/widget/SlidingPaneLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    .line 1205
    .local v5, "v":Landroid/view/View;
    iget-object v6, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    if-ne v5, v6, :cond_2

    goto :goto_5

    .line 1207
    :cond_2
    iget v6, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mParallaxOffset:F

    const/high16 v7, 0x3f800000    # 1.0f

    sub-float v6, v7, v6

    iget v8, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mParallaxBy:I

    int-to-float v9, v8

    mul-float v6, v6, v9

    float-to-int v6, v6

    .line 1208
    .local v6, "oldOffset":I
    iput p1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mParallaxOffset:F

    .line 1209
    sub-float v9, v7, p1

    int-to-float v8, v8

    mul-float v9, v9, v8

    float-to-int v8, v9

    .line 1210
    .local v8, "newOffset":I
    sub-int v9, v6, v8

    .line 1212
    .local v9, "dx":I
    if-eqz v0, :cond_3

    neg-int v10, v9

    goto :goto_3

    :cond_3
    move v10, v9

    :goto_3
    invoke-virtual {v5, v10}, Landroid/view/View;->offsetLeftAndRight(I)V

    .line 1214
    if-eqz v2, :cond_5

    .line 1215
    if-eqz v0, :cond_4

    iget v10, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mParallaxOffset:F

    sub-float/2addr v10, v7

    goto :goto_4

    :cond_4
    iget v10, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mParallaxOffset:F

    sub-float v10, v7, v10

    :goto_4
    iget v7, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mCoveredFadeColor:I

    invoke-direct {p0, v5, v10, v7}, Landroid/support/v4/widget/SlidingPaneLayout;->dimChildView(Landroid/view/View;FI)V

    goto :goto_5

    .line 1214
    :cond_5
    nop

    .line 1203
    .end local v5    # "v":Landroid/view/View;
    .end local v6    # "oldOffset":I
    .end local v8    # "newOffset":I
    .end local v9    # "dx":I
    :goto_5
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 1219
    .end local v4    # "i":I
    :cond_6
    return-void
.end method

.method private static viewIsOpaque(Landroid/view/View;)Z
    .locals 5
    .param p0, "v"    # Landroid/view/View;

    .line 415
    invoke-virtual {p0}, Landroid/view/View;->isOpaque()Z

    move-result v0

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    .line 416
    return v1

    .line 422
    :cond_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x12

    const/4 v3, 0x0

    if-lt v0, v2, :cond_1

    .line 423
    return v3

    .line 426
    :cond_1
    invoke-virtual {p0}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 427
    .local v0, "bg":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_3

    .line 428
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getOpacity()I

    move-result v2

    const/4 v4, -0x1

    if-ne v2, v4, :cond_2

    goto :goto_0

    :cond_2
    const/4 v1, 0x0

    :goto_0
    return v1

    .line 430
    :cond_3
    return v3
.end method


# virtual methods
.method protected canScroll(Landroid/view/View;ZIII)Z
    .locals 14
    .param p1, "v"    # Landroid/view/View;
    .param p2, "checkV"    # Z
    .param p3, "dx"    # I
    .param p4, "x"    # I
    .param p5, "y"    # I

    .line 1233
    move-object v0, p1

    instance-of v1, v0, Landroid/view/ViewGroup;

    const/4 v2, 0x1

    if-eqz v1, :cond_4

    .line 1234
    move-object v1, v0

    check-cast v1, Landroid/view/ViewGroup;

    .line 1235
    .local v1, "group":Landroid/view/ViewGroup;
    invoke-virtual {p1}, Landroid/view/View;->getScrollX()I

    move-result v3

    .line 1236
    .local v3, "scrollX":I
    invoke-virtual {p1}, Landroid/view/View;->getScrollY()I

    move-result v4

    .line 1237
    .local v4, "scrollY":I
    invoke-virtual {v1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v5

    .line 1239
    .local v5, "count":I
    add-int/lit8 v6, v5, -0x1

    .local v6, "i":I
    :goto_0
    if-ltz v6, :cond_3

    .line 1242
    invoke-virtual {v1, v6}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v13

    .line 1243
    .local v13, "child":Landroid/view/View;
    add-int v7, p4, v3

    invoke-virtual {v13}, Landroid/view/View;->getLeft()I

    move-result v8

    if-lt v7, v8, :cond_2

    add-int v7, p4, v3

    invoke-virtual {v13}, Landroid/view/View;->getRight()I

    move-result v8

    if-ge v7, v8, :cond_2

    add-int v7, p5, v4

    .line 1244
    invoke-virtual {v13}, Landroid/view/View;->getTop()I

    move-result v8

    if-lt v7, v8, :cond_1

    add-int v7, p5, v4

    invoke-virtual {v13}, Landroid/view/View;->getBottom()I

    move-result v8

    if-ge v7, v8, :cond_1

    const/4 v9, 0x1

    add-int v7, p4, v3

    .line 1245
    invoke-virtual {v13}, Landroid/view/View;->getLeft()I

    move-result v8

    sub-int v11, v7, v8

    add-int v7, p5, v4

    .line 1246
    invoke-virtual {v13}, Landroid/view/View;->getTop()I

    move-result v8

    sub-int v12, v7, v8

    .line 1245
    move-object v7, p0

    move-object v8, v13

    move/from16 v10, p3

    invoke-virtual/range {v7 .. v12}, Landroid/support/v4/widget/SlidingPaneLayout;->canScroll(Landroid/view/View;ZIII)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 1247
    return v2

    .line 1245
    :cond_0
    goto :goto_1

    .line 1244
    :cond_1
    goto :goto_1

    .line 1243
    :cond_2
    nop

    .line 1239
    .end local v13    # "child":Landroid/view/View;
    :goto_1
    add-int/lit8 v6, v6, -0x1

    goto :goto_0

    :cond_3
    goto :goto_2

    .line 1233
    .end local v1    # "group":Landroid/view/ViewGroup;
    .end local v3    # "scrollX":I
    .end local v4    # "scrollY":I
    .end local v5    # "count":I
    .end local v6    # "i":I
    :cond_4
    nop

    .line 1252
    :goto_2
    if-eqz p2, :cond_6

    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->isLayoutRtlSupport()Z

    move-result v1

    if-eqz v1, :cond_5

    move/from16 v1, p3

    move v3, v1

    goto :goto_3

    :cond_5
    move/from16 v1, p3

    neg-int v3, v1

    :goto_3
    invoke-static {p1, v3}, Landroid/support/v4/view/ViewCompat;->canScrollHorizontally(Landroid/view/View;I)Z

    move-result v3

    if-eqz v3, :cond_7

    goto :goto_4

    :cond_6
    move/from16 v1, p3

    :cond_7
    const/4 v2, 0x0

    :goto_4
    return v2
.end method

.method public canSlide()Z
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 936
    iget-boolean v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mCanSlide:Z

    return v0
.end method

.method protected checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z
    .locals 1
    .param p1, "p"    # Landroid/view/ViewGroup$LayoutParams;

    .line 1277
    instance-of v0, p1, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;

    if-eqz v0, :cond_0

    invoke-super {p0, p1}, Landroid/view/ViewGroup;->checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public closePane()Z
    .locals 2

    .line 917
    iget-object v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Landroid/support/v4/widget/SlidingPaneLayout;->closePane(Landroid/view/View;I)Z

    move-result v0

    return v0
.end method

.method public computeScroll()V
    .locals 2

    .line 1086
    iget-object v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/ViewDragHelper;->continueSettling(Z)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1087
    iget-boolean v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mCanSlide:Z

    if-nez v0, :cond_0

    .line 1088
    iget-object v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v0}, Landroid/support/v4/widget/ViewDragHelper;->abort()V

    .line 1089
    return-void

    .line 1092
    :cond_0
    invoke-static {p0}, Landroid/support/v4/view/ViewCompat;->postInvalidateOnAnimation(Landroid/view/View;)V

    goto :goto_0

    .line 1086
    :cond_1
    nop

    .line 1094
    :goto_0
    return-void
.end method

.method dispatchOnPanelClosed(Landroid/view/View;)V
    .locals 1
    .param p1, "panel"    # Landroid/view/View;

    .line 353
    iget-object v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mPanelSlideListener:Landroid/support/v4/widget/SlidingPaneLayout$PanelSlideListener;

    if-eqz v0, :cond_0

    .line 354
    invoke-interface {v0, p1}, Landroid/support/v4/widget/SlidingPaneLayout$PanelSlideListener;->onPanelClosed(Landroid/view/View;)V

    goto :goto_0

    .line 353
    :cond_0
    nop

    .line 356
    :goto_0
    const/16 v0, 0x20

    invoke-virtual {p0, v0}, Landroid/support/v4/widget/SlidingPaneLayout;->sendAccessibilityEvent(I)V

    .line 357
    return-void
.end method

.method dispatchOnPanelOpened(Landroid/view/View;)V
    .locals 1
    .param p1, "panel"    # Landroid/view/View;

    .line 346
    iget-object v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mPanelSlideListener:Landroid/support/v4/widget/SlidingPaneLayout$PanelSlideListener;

    if-eqz v0, :cond_0

    .line 347
    invoke-interface {v0, p1}, Landroid/support/v4/widget/SlidingPaneLayout$PanelSlideListener;->onPanelOpened(Landroid/view/View;)V

    goto :goto_0

    .line 346
    :cond_0
    nop

    .line 349
    :goto_0
    const/16 v0, 0x20

    invoke-virtual {p0, v0}, Landroid/support/v4/widget/SlidingPaneLayout;->sendAccessibilityEvent(I)V

    .line 350
    return-void
.end method

.method dispatchOnPanelSlide(Landroid/view/View;)V
    .locals 2
    .param p1, "panel"    # Landroid/view/View;

    .line 340
    iget-object v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mPanelSlideListener:Landroid/support/v4/widget/SlidingPaneLayout$PanelSlideListener;

    if-eqz v0, :cond_0

    .line 341
    iget v1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideOffset:F

    invoke-interface {v0, p1, v1}, Landroid/support/v4/widget/SlidingPaneLayout$PanelSlideListener;->onPanelSlide(Landroid/view/View;F)V

    goto :goto_0

    .line 340
    :cond_0
    nop

    .line 343
    :goto_0
    return-void
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .locals 8
    .param p1, "c"    # Landroid/graphics/Canvas;

    .line 1164
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->draw(Landroid/graphics/Canvas;)V

    .line 1165
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->isLayoutRtlSupport()Z

    move-result v0

    .line 1167
    .local v0, "isLayoutRtl":Z
    if-eqz v0, :cond_0

    .line 1168
    iget-object v1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mShadowDrawableRight:Landroid/graphics/drawable/Drawable;

    goto :goto_0

    .line 1170
    :cond_0
    iget-object v1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mShadowDrawableLeft:Landroid/graphics/drawable/Drawable;

    .line 1173
    .local v1, "shadowDrawable":Landroid/graphics/drawable/Drawable;
    :goto_0
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getChildCount()I

    move-result v2

    const/4 v3, 0x1

    if-le v2, v3, :cond_1

    invoke-virtual {p0, v3}, Landroid/support/v4/widget/SlidingPaneLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    goto :goto_1

    :cond_1
    const/4 v2, 0x0

    .line 1174
    .local v2, "shadowView":Landroid/view/View;
    :goto_1
    if-eqz v2, :cond_4

    if-nez v1, :cond_2

    goto :goto_3

    .line 1179
    :cond_2
    invoke-virtual {v2}, Landroid/view/View;->getTop()I

    move-result v3

    .line 1180
    .local v3, "top":I
    invoke-virtual {v2}, Landroid/view/View;->getBottom()I

    move-result v4

    .line 1182
    .local v4, "bottom":I
    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v5

    .line 1185
    .local v5, "shadowWidth":I
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->isLayoutRtlSupport()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 1186
    invoke-virtual {v2}, Landroid/view/View;->getRight()I

    move-result v6

    .line 1187
    .local v6, "left":I
    add-int v7, v6, v5

    goto :goto_2

    .line 1189
    .end local v6    # "left":I
    :cond_3
    invoke-virtual {v2}, Landroid/view/View;->getLeft()I

    move-result v7

    .line 1190
    .local v7, "right":I
    sub-int v6, v7, v5

    .line 1193
    .restart local v6    # "left":I
    :goto_2
    invoke-virtual {v1, v6, v3, v7, v4}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 1194
    invoke-virtual {v1, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 1195
    return-void

    .line 1174
    .end local v3    # "top":I
    .end local v4    # "bottom":I
    .end local v5    # "shadowWidth":I
    .end local v6    # "left":I
    .end local v7    # "right":I
    :cond_4
    :goto_3
    nop

    .line 1176
    return-void
.end method

.method protected drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z
    .locals 6
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "child"    # Landroid/view/View;
    .param p3, "drawingTime"    # J

    .line 1004
    invoke-virtual {p2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;

    .line 1006
    .local v0, "lp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    const/4 v1, 0x2

    invoke-virtual {p1, v1}, Landroid/graphics/Canvas;->save(I)I

    move-result v1

    .line 1008
    .local v1, "save":I
    iget-boolean v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mCanSlide:Z

    if-eqz v2, :cond_1

    iget-boolean v2, v0, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->slideable:Z

    if-nez v2, :cond_1

    iget-object v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    if-eqz v2, :cond_1

    .line 1010
    iget-object v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mTmpRect:Landroid/graphics/Rect;

    invoke-virtual {p1, v2}, Landroid/graphics/Canvas;->getClipBounds(Landroid/graphics/Rect;)Z

    .line 1011
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->isLayoutRtlSupport()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1012
    iget-object v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mTmpRect:Landroid/graphics/Rect;

    iget v3, v2, Landroid/graphics/Rect;->left:I

    iget-object v4, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getRight()I

    move-result v4

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v3

    iput v3, v2, Landroid/graphics/Rect;->left:I

    goto :goto_0

    .line 1014
    :cond_0
    iget-object v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mTmpRect:Landroid/graphics/Rect;

    iget v3, v2, Landroid/graphics/Rect;->right:I

    iget-object v4, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getLeft()I

    move-result v4

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v3

    iput v3, v2, Landroid/graphics/Rect;->right:I

    .line 1016
    :goto_0
    iget-object v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mTmpRect:Landroid/graphics/Rect;

    invoke-virtual {p1, v2}, Landroid/graphics/Canvas;->clipRect(Landroid/graphics/Rect;)Z

    goto :goto_1

    .line 1008
    :cond_1
    nop

    .line 1019
    :goto_1
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xb

    if-lt v2, v3, :cond_2

    .line 1020
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/ViewGroup;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    move-result v2

    goto :goto_5

    .line 1022
    :cond_2
    iget-boolean v2, v0, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->dimWhenOffset:Z

    if-eqz v2, :cond_5

    iget v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideOffset:F

    const/4 v3, 0x0

    cmpl-float v2, v2, v3

    if-lez v2, :cond_5

    .line 1023
    invoke-virtual {p2}, Landroid/view/View;->isDrawingCacheEnabled()Z

    move-result v2

    if-nez v2, :cond_3

    .line 1024
    const/4 v2, 0x1

    invoke-virtual {p2, v2}, Landroid/view/View;->setDrawingCacheEnabled(Z)V

    goto :goto_2

    .line 1023
    :cond_3
    nop

    .line 1026
    :goto_2
    invoke-virtual {p2}, Landroid/view/View;->getDrawingCache()Landroid/graphics/Bitmap;

    move-result-object v2

    .line 1027
    .local v2, "cache":Landroid/graphics/Bitmap;
    if-eqz v2, :cond_4

    .line 1028
    invoke-virtual {p2}, Landroid/view/View;->getLeft()I

    move-result v3

    int-to-float v3, v3

    invoke-virtual {p2}, Landroid/view/View;->getTop()I

    move-result v4

    int-to-float v4, v4

    iget-object v5, v0, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->dimPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 1029
    const/4 v3, 0x0

    move v2, v3

    goto :goto_3

    .line 1031
    :cond_4
    const-string v3, "SlidingPaneLayout"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "drawChild: child view "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v5, " returned null drawing cache"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1032
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/ViewGroup;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    move-result v2

    .line 1034
    .local v2, "result":Z
    :goto_3
    goto :goto_5

    .line 1022
    .end local v2    # "result":Z
    :cond_5
    nop

    .line 1035
    invoke-virtual {p2}, Landroid/view/View;->isDrawingCacheEnabled()Z

    move-result v2

    if-eqz v2, :cond_6

    .line 1036
    const/4 v2, 0x0

    invoke-virtual {p2, v2}, Landroid/view/View;->setDrawingCacheEnabled(Z)V

    goto :goto_4

    .line 1035
    :cond_6
    nop

    .line 1038
    :goto_4
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/ViewGroup;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    move-result v2

    .line 1042
    .restart local v2    # "result":Z
    :goto_5
    invoke-virtual {p1, v1}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 1044
    return v2
.end method

.method protected generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .locals 1

    .line 1265
    new-instance v0, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;

    invoke-direct {v0}, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;-><init>()V

    return-object v0
.end method

.method public generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    .locals 2
    .param p1, "attrs"    # Landroid/util/AttributeSet;

    .line 1282
    new-instance v0, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;

    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method protected generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .locals 2
    .param p1, "p"    # Landroid/view/ViewGroup$LayoutParams;

    .line 1270
    instance-of v0, p1, Landroid/view/ViewGroup$MarginLayoutParams;

    if-eqz v0, :cond_0

    new-instance v0, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;

    move-object v1, p1

    check-cast v1, Landroid/view/ViewGroup$MarginLayoutParams;

    invoke-direct {v0, v1}, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V

    goto :goto_0

    :cond_0
    new-instance v0, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;

    invoke-direct {v0, p1}, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    :goto_0
    return-object v0
.end method

.method public getCoveredFadeColor()I
    .locals 1
    .annotation build Landroid/support/annotation/ColorInt;
    .end annotation

    .line 332
    iget v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mCoveredFadeColor:I

    return v0
.end method

.method public getParallaxDistance()I
    .locals 1

    .line 297
    iget v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mParallaxBy:I

    return v0
.end method

.method public getSliderFadeColor()I
    .locals 1
    .annotation build Landroid/support/annotation/ColorInt;
    .end annotation

    .line 314
    iget v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSliderFadeColor:I

    return v0
.end method

.method invalidateChildRegion(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .line 1048
    sget-object v0, Landroid/support/v4/widget/SlidingPaneLayout;->IMPL:Landroid/support/v4/widget/SlidingPaneLayout$SlidingPanelLayoutImpl;

    invoke-interface {v0, p0, p1}, Landroid/support/v4/widget/SlidingPaneLayout$SlidingPanelLayoutImpl;->invalidateChildRegion(Landroid/support/v4/widget/SlidingPaneLayout;Landroid/view/View;)V

    .line 1049
    return-void
.end method

.method isDimmed(Landroid/view/View;)Z
    .locals 4
    .param p1, "child"    # Landroid/view/View;

    .line 1256
    const/4 v0, 0x0

    if-nez p1, :cond_0

    .line 1257
    return v0

    .line 1259
    :cond_0
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;

    .line 1260
    .local v1, "lp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    iget-boolean v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mCanSlide:Z

    if-eqz v2, :cond_1

    iget-boolean v2, v1, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->dimWhenOffset:Z

    if-eqz v2, :cond_1

    iget v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideOffset:F

    const/4 v3, 0x0

    cmpl-float v2, v2, v3

    if-lez v2, :cond_1

    const/4 v0, 0x1

    nop

    :cond_1
    return v0
.end method

.method isLayoutRtlSupport()Z
    .locals 2

    .line 1665
    invoke-static {p0}, Landroid/support/v4/view/ViewCompat;->getLayoutDirection(Landroid/view/View;)I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    return v1
.end method

.method public isOpen()Z
    .locals 2

    .line 927
    iget-boolean v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mCanSlide:Z

    if-eqz v0, :cond_1

    iget v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideOffset:F

    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method

.method public isSlideable()Z
    .locals 1

    .line 946
    iget-boolean v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mCanSlide:Z

    return v0
.end method

.method protected onAttachedToWindow()V
    .locals 1

    .line 435
    invoke-super {p0}, Landroid/view/ViewGroup;->onAttachedToWindow()V

    .line 436
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mFirstLayout:Z

    .line 437
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 3

    .line 441
    invoke-super {p0}, Landroid/view/ViewGroup;->onDetachedFromWindow()V

    .line 442
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mFirstLayout:Z

    .line 444
    const/4 v0, 0x0

    .local v0, "i":I
    iget-object v1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mPostedRunnables:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    .local v1, "count":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 445
    iget-object v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mPostedRunnables:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v4/widget/SlidingPaneLayout$DisableLayerRunnable;

    .line 446
    .local v2, "dlr":Landroid/support/v4/widget/SlidingPaneLayout$DisableLayerRunnable;
    invoke-virtual {v2}, Landroid/support/v4/widget/SlidingPaneLayout$DisableLayerRunnable;->run()V

    .line 444
    .end local v2    # "dlr":Landroid/support/v4/widget/SlidingPaneLayout$DisableLayerRunnable;
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 448
    .end local v0    # "i":I
    .end local v1    # "count":I
    :cond_0
    iget-object v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mPostedRunnables:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 449
    return-void
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 10
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .line 769
    invoke-static {p1}, Landroid/support/v4/view/MotionEventCompat;->getActionMasked(Landroid/view/MotionEvent;)I

    move-result v0

    .line 772
    .local v0, "action":I
    iget-boolean v1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mCanSlide:Z

    const/4 v2, 0x1

    if-nez v1, :cond_1

    if-nez v0, :cond_1

    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getChildCount()I

    move-result v1

    if-le v1, v2, :cond_1

    .line 774
    invoke-virtual {p0, v2}, Landroid/support/v4/widget/SlidingPaneLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 775
    .local v1, "secondChild":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 776
    iget-object v3, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    .line 777
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v4

    float-to-int v4, v4

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v5

    float-to-int v5, v5

    .line 776
    invoke-virtual {v3, v1, v4, v5}, Landroid/support/v4/widget/ViewDragHelper;->isViewUnder(Landroid/view/View;II)Z

    move-result v3

    xor-int/2addr v3, v2

    iput-boolean v3, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mPreservedOpenState:Z

    goto :goto_0

    .line 775
    :cond_0
    goto :goto_0

    .line 772
    .end local v1    # "secondChild":Landroid/view/View;
    :cond_1
    nop

    .line 781
    :goto_0
    iget-boolean v1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mCanSlide:Z

    if-eqz v1, :cond_c

    iget-boolean v1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mIsUnableToDrag:Z

    if-eqz v1, :cond_2

    if-eqz v0, :cond_2

    goto/16 :goto_4

    .line 786
    :cond_2
    const/4 v1, 0x3

    const/4 v3, 0x0

    if-eq v0, v1, :cond_b

    if-ne v0, v2, :cond_3

    goto/16 :goto_3

    .line 791
    :cond_3
    const/4 v1, 0x0

    .line 793
    .local v1, "interceptTap":Z
    if-eqz v0, :cond_6

    const/4 v4, 0x2

    if-eq v0, v4, :cond_4

    goto :goto_1

    .line 809
    :cond_4
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v4

    .line 810
    .local v4, "x":F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v5

    .line 811
    .local v5, "y":F
    iget v6, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mInitialMotionX:F

    sub-float v6, v4, v6

    invoke-static {v6}, Ljava/lang/Math;->abs(F)F

    move-result v6

    .line 812
    .local v6, "adx":F
    iget v7, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mInitialMotionY:F

    sub-float v7, v5, v7

    invoke-static {v7}, Ljava/lang/Math;->abs(F)F

    move-result v7

    .line 813
    .local v7, "ady":F
    iget-object v8, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v8}, Landroid/support/v4/widget/ViewDragHelper;->getTouchSlop()I

    move-result v8

    .line 814
    .local v8, "slop":I
    int-to-float v9, v8

    cmpl-float v9, v6, v9

    if-lez v9, :cond_5

    cmpl-float v9, v7, v6

    if-lez v9, :cond_5

    .line 815
    iget-object v9, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v9}, Landroid/support/v4/widget/ViewDragHelper;->cancel()V

    .line 816
    iput-boolean v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mIsUnableToDrag:Z

    .line 817
    return v3

    .line 814
    :cond_5
    goto :goto_1

    .line 795
    .end local v4    # "x":F
    .end local v5    # "y":F
    .end local v6    # "adx":F
    .end local v7    # "ady":F
    .end local v8    # "slop":I
    :cond_6
    iput-boolean v3, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mIsUnableToDrag:Z

    .line 796
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v4

    .line 797
    .restart local v4    # "x":F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v5

    .line 798
    .restart local v5    # "y":F
    iput v4, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mInitialMotionX:F

    .line 799
    iput v5, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mInitialMotionY:F

    .line 801
    iget-object v6, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    iget-object v7, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    float-to-int v8, v4

    float-to-int v9, v5

    invoke-virtual {v6, v7, v8, v9}, Landroid/support/v4/widget/ViewDragHelper;->isViewUnder(Landroid/view/View;II)Z

    move-result v6

    if-eqz v6, :cond_8

    iget-object v6, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    .line 802
    invoke-virtual {p0, v6}, Landroid/support/v4/widget/SlidingPaneLayout;->isDimmed(Landroid/view/View;)Z

    move-result v6

    if-eqz v6, :cond_7

    .line 803
    const/4 v1, 0x1

    goto :goto_1

    .line 802
    :cond_7
    goto :goto_1

    .line 801
    :cond_8
    nop

    .line 822
    .end local v4    # "x":F
    .end local v5    # "y":F
    :goto_1
    iget-object v4, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v4, p1}, Landroid/support/v4/widget/ViewDragHelper;->shouldInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v4

    .line 824
    .local v4, "interceptForDrag":Z
    if-nez v4, :cond_a

    if-eqz v1, :cond_9

    goto :goto_2

    :cond_9
    const/4 v2, 0x0

    nop

    :cond_a
    :goto_2
    return v2

    .line 786
    .end local v1    # "interceptTap":Z
    .end local v4    # "interceptForDrag":Z
    :cond_b
    :goto_3
    nop

    .line 787
    iget-object v1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v1}, Landroid/support/v4/widget/ViewDragHelper;->cancel()V

    .line 788
    return v3

    .line 781
    :cond_c
    :goto_4
    nop

    .line 782
    iget-object v1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v1}, Landroid/support/v4/widget/ViewDragHelper;->cancel()V

    .line 783
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v1

    return v1
.end method

.method protected onLayout(ZIIII)V
    .locals 21
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .line 665
    move-object/from16 v0, p0

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->isLayoutRtlSupport()Z

    move-result v1

    .line 666
    .local v1, "isLayoutRtl":Z
    const/4 v2, 0x1

    if-eqz v1, :cond_0

    .line 667
    iget-object v3, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    const/4 v4, 0x2

    invoke-virtual {v3, v4}, Landroid/support/v4/widget/ViewDragHelper;->setEdgeTrackingEnabled(I)V

    goto :goto_0

    .line 669
    :cond_0
    iget-object v3, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v3, v2}, Landroid/support/v4/widget/ViewDragHelper;->setEdgeTrackingEnabled(I)V

    .line 671
    :goto_0
    sub-int v3, p4, p2

    .line 672
    .local v3, "width":I
    if-eqz v1, :cond_1

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingRight()I

    move-result v4

    goto :goto_1

    :cond_1
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingLeft()I

    move-result v4

    .line 673
    .local v4, "paddingStart":I
    :goto_1
    if-eqz v1, :cond_2

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingLeft()I

    move-result v5

    goto :goto_2

    :cond_2
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingRight()I

    move-result v5

    .line 674
    .local v5, "paddingEnd":I
    :goto_2
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingTop()I

    move-result v6

    .line 676
    .local v6, "paddingTop":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getChildCount()I

    move-result v7

    .line 677
    .local v7, "childCount":I
    move v8, v4

    .line 678
    .local v8, "xStart":I
    move v9, v8

    .line 680
    .local v9, "nextXStart":I
    iget-boolean v10, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mFirstLayout:Z

    if-eqz v10, :cond_4

    .line 681
    iget-boolean v10, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mCanSlide:Z

    if-eqz v10, :cond_3

    iget-boolean v10, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mPreservedOpenState:Z

    if-eqz v10, :cond_3

    const/high16 v10, 0x3f800000    # 1.0f

    goto :goto_3

    :cond_3
    const/4 v10, 0x0

    :goto_3
    iput v10, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideOffset:F

    goto :goto_4

    .line 680
    :cond_4
    nop

    .line 684
    :goto_4
    const/4 v10, 0x0

    .local v10, "i":I
    :goto_5
    if-ge v10, v7, :cond_b

    .line 685
    invoke-virtual {v0, v10}, Landroid/support/v4/widget/SlidingPaneLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v14

    .line 687
    .local v14, "child":Landroid/view/View;
    invoke-virtual {v14}, Landroid/view/View;->getVisibility()I

    move-result v15

    const/16 v2, 0x8

    if-ne v15, v2, :cond_5

    .line 688
    move/from16 v20, v4

    const/high16 v11, 0x3f800000    # 1.0f

    goto/16 :goto_a

    .line 691
    :cond_5
    invoke-virtual {v14}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;

    .line 693
    .local v2, "lp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    invoke-virtual {v14}, Landroid/view/View;->getMeasuredWidth()I

    move-result v15

    .line 694
    .local v15, "childWidth":I
    const/16 v16, 0x0

    .line 696
    .local v16, "offset":I
    iget-boolean v13, v2, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->slideable:Z

    if-eqz v13, :cond_8

    .line 697
    iget v13, v2, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->leftMargin:I

    iget v12, v2, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->rightMargin:I

    add-int/2addr v13, v12

    .line 698
    .local v13, "margin":I
    sub-int v12, v3, v5

    iget v11, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mOverhangSize:I

    sub-int/2addr v12, v11

    invoke-static {v9, v12}, Ljava/lang/Math;->min(II)I

    move-result v11

    sub-int/2addr v11, v8

    sub-int/2addr v11, v13

    .line 700
    .local v11, "range":I
    iput v11, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideRange:I

    .line 701
    if-eqz v1, :cond_6

    iget v12, v2, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->rightMargin:I

    goto :goto_6

    :cond_6
    iget v12, v2, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->leftMargin:I

    .line 702
    .local v12, "lpMargin":I
    :goto_6
    add-int v18, v8, v12

    add-int v18, v18, v11

    div-int/lit8 v19, v15, 0x2

    move/from16 v20, v4

    .end local v4    # "paddingStart":I
    .local v20, "paddingStart":I
    add-int v4, v18, v19

    move/from16 v18, v13

    .end local v13    # "margin":I
    .local v18, "margin":I
    sub-int v13, v3, v5

    if-le v4, v13, :cond_7

    const/4 v4, 0x1

    goto :goto_7

    :cond_7
    const/4 v4, 0x0

    :goto_7
    iput-boolean v4, v2, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->dimWhenOffset:Z

    .line 703
    int-to-float v4, v11

    iget v13, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideOffset:F

    mul-float v4, v4, v13

    float-to-int v4, v4

    .line 704
    .local v4, "pos":I
    add-int v13, v4, v12

    add-int/2addr v8, v13

    .line 705
    int-to-float v13, v4

    move-object/from16 v19, v2

    .end local v2    # "lp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    .local v19, "lp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    iget v2, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideRange:I

    int-to-float v2, v2

    div-float/2addr v13, v2

    iput v13, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideOffset:F

    .line 706
    .end local v4    # "pos":I
    .end local v11    # "range":I
    .end local v12    # "lpMargin":I
    .end local v18    # "margin":I
    const/high16 v11, 0x3f800000    # 1.0f

    goto :goto_8

    .end local v19    # "lp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    .end local v20    # "paddingStart":I
    .restart local v2    # "lp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    .local v4, "paddingStart":I
    :cond_8
    move-object/from16 v19, v2

    move/from16 v20, v4

    .end local v2    # "lp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    .end local v4    # "paddingStart":I
    .restart local v19    # "lp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    .restart local v20    # "paddingStart":I
    iget-boolean v2, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mCanSlide:Z

    if-eqz v2, :cond_9

    iget v2, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mParallaxBy:I

    if-eqz v2, :cond_9

    .line 707
    iget v4, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideOffset:F

    const/high16 v11, 0x3f800000    # 1.0f

    sub-float v4, v11, v4

    int-to-float v2, v2

    mul-float v4, v4, v2

    float-to-int v2, v4

    .line 708
    .end local v16    # "offset":I
    .local v2, "offset":I
    move v8, v9

    move/from16 v16, v2

    goto :goto_8

    .line 706
    .end local v2    # "offset":I
    .restart local v16    # "offset":I
    :cond_9
    const/high16 v11, 0x3f800000    # 1.0f

    .line 710
    move v8, v9

    .line 715
    :goto_8
    if-eqz v1, :cond_a

    .line 716
    sub-int v2, v3, v8

    add-int v2, v2, v16

    .line 717
    .local v2, "childRight":I
    sub-int v4, v2, v15

    goto :goto_9

    .line 719
    .end local v2    # "childRight":I
    :cond_a
    sub-int v4, v8, v16

    .line 720
    .local v4, "childLeft":I
    add-int v2, v4, v15

    .line 723
    .restart local v2    # "childRight":I
    :goto_9
    move v12, v6

    .line 724
    .local v12, "childTop":I
    invoke-virtual {v14}, Landroid/view/View;->getMeasuredHeight()I

    move-result v13

    add-int/2addr v13, v12

    .line 725
    .local v13, "childBottom":I
    invoke-virtual {v14, v4, v6, v2, v13}, Landroid/view/View;->layout(IIII)V

    .line 727
    invoke-virtual {v14}, Landroid/view/View;->getWidth()I

    move-result v17

    add-int v9, v9, v17

    .line 684
    .end local v2    # "childRight":I
    .end local v4    # "childLeft":I
    .end local v12    # "childTop":I
    .end local v13    # "childBottom":I
    .end local v14    # "child":Landroid/view/View;
    .end local v15    # "childWidth":I
    .end local v16    # "offset":I
    .end local v19    # "lp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    :goto_a
    add-int/lit8 v10, v10, 0x1

    move/from16 v4, v20

    const/4 v2, 0x1

    goto/16 :goto_5

    .end local v20    # "paddingStart":I
    .local v4, "paddingStart":I
    :cond_b
    move/from16 v20, v4

    .line 730
    .end local v4    # "paddingStart":I
    .end local v10    # "i":I
    .restart local v20    # "paddingStart":I
    iget-boolean v2, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mFirstLayout:Z

    if-eqz v2, :cond_10

    .line 731
    iget-boolean v2, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mCanSlide:Z

    if-eqz v2, :cond_e

    .line 732
    iget v2, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mParallaxBy:I

    if-eqz v2, :cond_c

    .line 733
    iget v2, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideOffset:F

    invoke-direct {v0, v2}, Landroid/support/v4/widget/SlidingPaneLayout;->parallaxOtherViews(F)V

    goto :goto_b

    .line 732
    :cond_c
    nop

    .line 735
    :goto_b
    iget-object v2, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;

    iget-boolean v2, v2, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->dimWhenOffset:Z

    if-eqz v2, :cond_d

    .line 736
    iget-object v2, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    iget v4, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideOffset:F

    iget v10, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mSliderFadeColor:I

    invoke-direct {v0, v2, v4, v10}, Landroid/support/v4/widget/SlidingPaneLayout;->dimChildView(Landroid/view/View;FI)V

    goto :goto_d

    .line 735
    :cond_d
    goto :goto_d

    .line 740
    :cond_e
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_c
    if-ge v2, v7, :cond_f

    .line 741
    invoke-virtual {v0, v2}, Landroid/support/v4/widget/SlidingPaneLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    iget v10, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mSliderFadeColor:I

    const/4 v11, 0x0

    invoke-direct {v0, v4, v11, v10}, Landroid/support/v4/widget/SlidingPaneLayout;->dimChildView(Landroid/view/View;FI)V

    .line 740
    add-int/lit8 v2, v2, 0x1

    goto :goto_c

    .line 744
    .end local v2    # "i":I
    :cond_f
    :goto_d
    iget-object v2, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/support/v4/widget/SlidingPaneLayout;->updateObscuredViewsVisibility(Landroid/view/View;)V

    goto :goto_e

    .line 730
    :cond_10
    nop

    .line 747
    :goto_e
    const/4 v2, 0x0

    iput-boolean v2, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mFirstLayout:Z

    .line 748
    return-void
.end method

.method protected onMeasure(II)V
    .locals 29
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .line 453
    move-object/from16 v0, p0

    invoke-static/range {p1 .. p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    .line 454
    .local v1, "widthMode":I
    invoke-static/range {p1 .. p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v2

    .line 455
    .local v2, "widthSize":I
    invoke-static/range {p2 .. p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v3

    .line 456
    .local v3, "heightMode":I
    invoke-static/range {p2 .. p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v4

    .line 458
    .local v4, "heightSize":I
    const/high16 v5, -0x80000000

    const/high16 v6, 0x40000000    # 2.0f

    if-eq v1, v6, :cond_3

    .line 459
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->isInEditMode()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 464
    if-ne v1, v5, :cond_0

    .line 465
    const/high16 v1, 0x40000000    # 2.0f

    goto :goto_0

    .line 466
    :cond_0
    if-nez v1, :cond_1

    .line 467
    const/high16 v1, 0x40000000    # 2.0f

    .line 468
    const/16 v2, 0x12c

    goto :goto_0

    .line 466
    :cond_1
    goto :goto_0

    .line 471
    :cond_2
    new-instance v5, Ljava/lang/IllegalStateException;

    const-string v6, "Width must have an exact value or MATCH_PARENT"

    invoke-direct {v5, v6}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 473
    :cond_3
    if-nez v3, :cond_6

    .line 474
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->isInEditMode()Z

    move-result v7

    if-eqz v7, :cond_5

    .line 478
    if-nez v3, :cond_4

    .line 479
    const/high16 v3, -0x80000000

    .line 480
    const/16 v4, 0x12c

    goto :goto_0

    .line 478
    :cond_4
    goto :goto_0

    .line 483
    :cond_5
    new-instance v5, Ljava/lang/IllegalStateException;

    const-string v6, "Height must not be UNSPECIFIED"

    invoke-direct {v5, v6}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 473
    :cond_6
    nop

    .line 487
    :goto_0
    const/4 v7, 0x0

    .line 488
    .local v7, "layoutHeight":I
    const/4 v8, -0x1

    .line 489
    .local v8, "maxLayoutHeight":I
    if-eq v3, v5, :cond_8

    if-eq v3, v6, :cond_7

    goto :goto_1

    .line 491
    :cond_7
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingTop()I

    move-result v9

    sub-int v9, v4, v9

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingBottom()I

    move-result v10

    sub-int/2addr v9, v10

    move v8, v9

    move v7, v9

    .line 492
    goto :goto_1

    .line 494
    :cond_8
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingTop()I

    move-result v9

    sub-int v9, v4, v9

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingBottom()I

    move-result v10

    sub-int v8, v9, v10

    .line 498
    :goto_1
    const/4 v9, 0x0

    .line 499
    .local v9, "weightSum":F
    const/4 v10, 0x0

    .line 500
    .local v10, "canSlide":Z
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingLeft()I

    move-result v11

    sub-int v11, v2, v11

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingRight()I

    move-result v12

    sub-int/2addr v11, v12

    .line 501
    .local v11, "widthAvailable":I
    move v12, v11

    .line 502
    .local v12, "widthRemaining":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getChildCount()I

    move-result v13

    .line 504
    .local v13, "childCount":I
    const/4 v14, 0x2

    if-le v13, v14, :cond_9

    .line 505
    const-string v14, "SlidingPaneLayout"

    const-string v15, "onMeasure: More than two child views are not supported."

    invoke-static {v14, v15}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2

    .line 504
    :cond_9
    nop

    .line 509
    :goto_2
    const/4 v14, 0x0

    iput-object v14, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    .line 513
    const/4 v14, 0x0

    .local v14, "i":I
    :goto_3
    const/16 v15, 0x8

    const/16 v17, 0x1

    const/16 v19, 0x0

    if-ge v14, v13, :cond_14

    .line 514
    invoke-virtual {v0, v14}, Landroid/support/v4/widget/SlidingPaneLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v6

    .line 515
    .local v6, "child":Landroid/view/View;
    invoke-virtual {v6}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v21

    move-object/from16 v5, v21

    check-cast v5, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;

    .line 517
    .local v5, "lp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    move/from16 v21, v1

    .end local v1    # "widthMode":I
    .local v21, "widthMode":I
    invoke-virtual {v6}, Landroid/view/View;->getVisibility()I

    move-result v1

    if-ne v1, v15, :cond_a

    .line 518
    const/4 v1, 0x0

    iput-boolean v1, v5, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->dimWhenOffset:Z

    .line 519
    move/from16 v22, v4

    goto/16 :goto_a

    .line 522
    :cond_a
    iget v1, v5, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->weight:F

    cmpl-float v1, v1, v19

    if-lez v1, :cond_c

    .line 523
    iget v1, v5, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->weight:F

    add-float/2addr v9, v1

    .line 527
    iget v1, v5, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->width:I

    if-nez v1, :cond_b

    move/from16 v22, v4

    goto/16 :goto_a

    :cond_b
    goto :goto_4

    .line 522
    :cond_c
    nop

    .line 531
    :goto_4
    iget v1, v5, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->leftMargin:I

    iget v15, v5, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->rightMargin:I

    add-int/2addr v1, v15

    .line 532
    .local v1, "horizontalMargin":I
    iget v15, v5, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->width:I

    move/from16 v22, v4

    const/4 v4, -0x2

    .end local v4    # "heightSize":I
    .local v22, "heightSize":I
    if-ne v15, v4, :cond_d

    .line 533
    sub-int v4, v11, v1

    const/high16 v15, -0x80000000

    invoke-static {v4, v15}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v4

    goto :goto_5

    .line 535
    :cond_d
    iget v4, v5, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->width:I

    const/4 v15, -0x1

    if-ne v4, v15, :cond_e

    .line 536
    sub-int v4, v11, v1

    const/high16 v15, 0x40000000    # 2.0f

    invoke-static {v4, v15}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v4

    goto :goto_5

    .line 539
    :cond_e
    const/high16 v15, 0x40000000    # 2.0f

    iget v4, v5, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->width:I

    invoke-static {v4, v15}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v4

    .line 543
    .local v4, "childWidthSpec":I
    :goto_5
    iget v15, v5, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->height:I

    move/from16 v19, v1

    const/4 v1, -0x2

    .end local v1    # "horizontalMargin":I
    .local v19, "horizontalMargin":I
    if-ne v15, v1, :cond_f

    .line 544
    const/high16 v1, -0x80000000

    invoke-static {v8, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v15

    goto :goto_6

    .line 545
    :cond_f
    iget v1, v5, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->height:I

    const/4 v15, -0x1

    if-ne v1, v15, :cond_10

    .line 546
    const/high16 v1, 0x40000000    # 2.0f

    invoke-static {v8, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v15

    goto :goto_6

    .line 548
    :cond_10
    const/high16 v1, 0x40000000    # 2.0f

    iget v15, v5, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->height:I

    invoke-static {v15, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v15

    .line 551
    .local v15, "childHeightSpec":I
    :goto_6
    invoke-virtual {v6, v4, v15}, Landroid/view/View;->measure(II)V

    .line 552
    invoke-virtual {v6}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    .line 553
    .local v1, "childWidth":I
    move/from16 v18, v4

    .end local v4    # "childWidthSpec":I
    .local v18, "childWidthSpec":I
    invoke-virtual {v6}, Landroid/view/View;->getMeasuredHeight()I

    move-result v4

    .line 555
    .local v4, "childHeight":I
    move/from16 v20, v9

    const/high16 v9, -0x80000000

    .end local v9    # "weightSum":F
    .local v20, "weightSum":F
    if-ne v3, v9, :cond_11

    if-le v4, v7, :cond_11

    .line 556
    invoke-static {v4, v8}, Ljava/lang/Math;->min(II)I

    move-result v7

    goto :goto_7

    .line 555
    :cond_11
    nop

    .line 559
    :goto_7
    sub-int/2addr v12, v1

    .line 560
    if-gez v12, :cond_12

    const/4 v9, 0x1

    goto :goto_8

    :cond_12
    const/4 v9, 0x0

    :goto_8
    iput-boolean v9, v5, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->slideable:Z

    or-int/2addr v9, v10

    .line 561
    .end local v10    # "canSlide":Z
    .local v9, "canSlide":Z
    iget-boolean v10, v5, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->slideable:Z

    if-eqz v10, :cond_13

    .line 562
    iput-object v6, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    goto :goto_9

    .line 561
    :cond_13
    nop

    .line 513
    .end local v1    # "childWidth":I
    .end local v4    # "childHeight":I
    .end local v5    # "lp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    .end local v6    # "child":Landroid/view/View;
    .end local v15    # "childHeightSpec":I
    .end local v18    # "childWidthSpec":I
    .end local v19    # "horizontalMargin":I
    :goto_9
    move v10, v9

    move/from16 v9, v20

    .end local v20    # "weightSum":F
    .local v9, "weightSum":F
    .restart local v10    # "canSlide":Z
    :goto_a
    add-int/lit8 v14, v14, 0x1

    move/from16 v1, v21

    move/from16 v4, v22

    const/high16 v5, -0x80000000

    const/high16 v6, 0x40000000    # 2.0f

    goto/16 :goto_3

    .end local v21    # "widthMode":I
    .end local v22    # "heightSize":I
    .local v1, "widthMode":I
    .local v4, "heightSize":I
    :cond_14
    move/from16 v21, v1

    move/from16 v22, v4

    .line 567
    .end local v1    # "widthMode":I
    .end local v4    # "heightSize":I
    .end local v14    # "i":I
    .restart local v21    # "widthMode":I
    .restart local v22    # "heightSize":I
    if-nez v10, :cond_16

    cmpl-float v1, v9, v19

    if-lez v1, :cond_15

    goto :goto_b

    :cond_15
    move/from16 v24, v3

    move/from16 v28, v8

    move/from16 v25, v13

    goto/16 :goto_14

    .line 568
    :cond_16
    :goto_b
    iget v1, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mOverhangSize:I

    sub-int v1, v11, v1

    .line 570
    .local v1, "fixedPanelWidthLimit":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_c
    if-ge v4, v13, :cond_28

    .line 571
    invoke-virtual {v0, v4}, Landroid/support/v4/widget/SlidingPaneLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    .line 573
    .local v5, "child":Landroid/view/View;
    invoke-virtual {v5}, Landroid/view/View;->getVisibility()I

    move-result v6

    if-ne v6, v15, :cond_17

    .line 574
    move/from16 v27, v1

    move/from16 v24, v3

    move/from16 v28, v8

    move/from16 v25, v13

    const/high16 v1, 0x40000000    # 2.0f

    goto/16 :goto_13

    .line 577
    :cond_17
    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    check-cast v6, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;

    .line 579
    .local v6, "lp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    invoke-virtual {v5}, Landroid/view/View;->getVisibility()I

    move-result v14

    if-ne v14, v15, :cond_18

    .line 580
    move/from16 v27, v1

    move/from16 v24, v3

    move/from16 v28, v8

    move/from16 v25, v13

    const/high16 v1, 0x40000000    # 2.0f

    goto/16 :goto_13

    .line 583
    :cond_18
    iget v14, v6, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->width:I

    if-nez v14, :cond_19

    iget v14, v6, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->weight:F

    cmpl-float v14, v14, v19

    if-lez v14, :cond_19

    const/4 v14, 0x1

    goto :goto_d

    :cond_19
    const/4 v14, 0x0

    .line 584
    .local v14, "skippedFirstPass":Z
    :goto_d
    if-eqz v14, :cond_1a

    const/16 v23, 0x0

    goto :goto_e

    :cond_1a
    invoke-virtual {v5}, Landroid/view/View;->getMeasuredWidth()I

    move-result v23

    :goto_e
    move/from16 v24, v23

    .line 585
    .local v24, "measuredWidth":I
    if-eqz v10, :cond_21

    iget-object v15, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    if-eq v5, v15, :cond_21

    .line 586
    iget v15, v6, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->width:I

    if-gez v15, :cond_20

    move/from16 v15, v24

    .end local v24    # "measuredWidth":I
    .local v15, "measuredWidth":I
    if-gt v15, v1, :cond_1c

    move/from16 v24, v3

    .end local v3    # "heightMode":I
    .local v24, "heightMode":I
    iget v3, v6, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->weight:F

    cmpl-float v3, v3, v19

    if-lez v3, :cond_1b

    goto :goto_f

    :cond_1b
    move/from16 v27, v1

    move/from16 v28, v8

    move/from16 v25, v13

    const/high16 v1, 0x40000000    # 2.0f

    goto/16 :goto_13

    .end local v24    # "heightMode":I
    .restart local v3    # "heightMode":I
    :cond_1c
    move/from16 v24, v3

    .line 590
    .end local v3    # "heightMode":I
    .restart local v24    # "heightMode":I
    :goto_f
    if-eqz v14, :cond_1f

    .line 593
    iget v3, v6, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->height:I

    move/from16 v25, v13

    const/4 v13, -0x2

    .end local v13    # "childCount":I
    .local v25, "childCount":I
    if-ne v3, v13, :cond_1d

    .line 594
    const/high16 v3, -0x80000000

    invoke-static {v8, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v13

    const/high16 v3, 0x40000000    # 2.0f

    goto :goto_10

    .line 596
    :cond_1d
    iget v3, v6, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->height:I

    const/4 v13, -0x1

    if-ne v3, v13, :cond_1e

    .line 597
    const/high16 v3, 0x40000000    # 2.0f

    invoke-static {v8, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v13

    goto :goto_10

    .line 600
    :cond_1e
    const/high16 v3, 0x40000000    # 2.0f

    iget v13, v6, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->height:I

    invoke-static {v13, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v13

    goto :goto_10

    .line 604
    .end local v25    # "childCount":I
    .restart local v13    # "childCount":I
    :cond_1f
    move/from16 v25, v13

    const/high16 v3, 0x40000000    # 2.0f

    .line 605
    .end local v13    # "childCount":I
    .restart local v25    # "childCount":I
    invoke-virtual {v5}, Landroid/view/View;->getMeasuredHeight()I

    move-result v13

    .line 604
    invoke-static {v13, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v13

    .line 607
    .local v13, "childHeightSpec":I
    :goto_10
    move/from16 v26, v14

    .end local v14    # "skippedFirstPass":Z
    .local v26, "skippedFirstPass":Z
    invoke-static {v1, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v14

    .line 609
    .local v14, "childWidthSpec":I
    invoke-virtual {v5, v14, v13}, Landroid/view/View;->measure(II)V

    .line 610
    .end local v13    # "childHeightSpec":I
    .end local v14    # "childWidthSpec":I
    move/from16 v27, v1

    move/from16 v28, v8

    const/high16 v1, 0x40000000    # 2.0f

    goto/16 :goto_13

    .line 586
    .end local v15    # "measuredWidth":I
    .end local v25    # "childCount":I
    .end local v26    # "skippedFirstPass":Z
    .restart local v3    # "heightMode":I
    .local v13, "childCount":I
    .local v14, "skippedFirstPass":Z
    .local v24, "measuredWidth":I
    :cond_20
    move/from16 v25, v13

    move/from16 v26, v14

    move/from16 v15, v24

    move/from16 v24, v3

    .end local v3    # "heightMode":I
    .end local v13    # "childCount":I
    .end local v14    # "skippedFirstPass":Z
    .restart local v15    # "measuredWidth":I
    .local v24, "heightMode":I
    .restart local v25    # "childCount":I
    .restart local v26    # "skippedFirstPass":Z
    move/from16 v27, v1

    move/from16 v28, v8

    const/high16 v1, 0x40000000    # 2.0f

    goto/16 :goto_13

    .line 585
    .end local v15    # "measuredWidth":I
    .end local v25    # "childCount":I
    .end local v26    # "skippedFirstPass":Z
    .restart local v3    # "heightMode":I
    .restart local v13    # "childCount":I
    .restart local v14    # "skippedFirstPass":Z
    .local v24, "measuredWidth":I
    :cond_21
    move/from16 v25, v13

    move/from16 v26, v14

    move/from16 v15, v24

    move/from16 v24, v3

    .line 611
    .end local v3    # "heightMode":I
    .end local v13    # "childCount":I
    .end local v14    # "skippedFirstPass":Z
    .restart local v15    # "measuredWidth":I
    .local v24, "heightMode":I
    .restart local v25    # "childCount":I
    .restart local v26    # "skippedFirstPass":Z
    iget v3, v6, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->weight:F

    cmpl-float v3, v3, v19

    if-lez v3, :cond_27

    .line 613
    iget v3, v6, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->width:I

    if-nez v3, :cond_24

    .line 615
    iget v3, v6, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->height:I

    const/4 v13, -0x2

    if-ne v3, v13, :cond_22

    .line 616
    const/high16 v3, -0x80000000

    invoke-static {v8, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v14

    move v3, v14

    const/high16 v14, 0x40000000    # 2.0f

    goto :goto_11

    .line 618
    :cond_22
    const/high16 v3, -0x80000000

    iget v14, v6, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->height:I

    const/4 v3, -0x1

    if-ne v14, v3, :cond_23

    .line 619
    const/high16 v14, 0x40000000    # 2.0f

    invoke-static {v8, v14}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v16

    move/from16 v3, v16

    goto :goto_11

    .line 622
    :cond_23
    const/high16 v14, 0x40000000    # 2.0f

    iget v3, v6, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->height:I

    invoke-static {v3, v14}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v3

    goto :goto_11

    .line 626
    :cond_24
    const/4 v13, -0x2

    const/high16 v14, 0x40000000    # 2.0f

    .line 627
    invoke-virtual {v5}, Landroid/view/View;->getMeasuredHeight()I

    move-result v3

    .line 626
    invoke-static {v3, v14}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v3

    .line 630
    .local v3, "childHeightSpec":I
    :goto_11
    if-eqz v10, :cond_26

    .line 632
    iget v13, v6, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->leftMargin:I

    iget v14, v6, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->rightMargin:I

    add-int/2addr v13, v14

    .line 633
    .local v13, "horizontalMargin":I
    sub-int v14, v11, v13

    .line 634
    .local v14, "newWidth":I
    move/from16 v27, v1

    move/from16 v28, v8

    const/high16 v1, 0x40000000    # 2.0f

    .end local v1    # "fixedPanelWidthLimit":I
    .end local v8    # "maxLayoutHeight":I
    .local v27, "fixedPanelWidthLimit":I
    .local v28, "maxLayoutHeight":I
    invoke-static {v14, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v8

    .line 636
    .local v8, "childWidthSpec":I
    if-eq v15, v14, :cond_25

    .line 637
    invoke-virtual {v5, v8, v3}, Landroid/view/View;->measure(II)V

    goto :goto_12

    .line 636
    :cond_25
    nop

    .line 639
    .end local v8    # "childWidthSpec":I
    .end local v13    # "horizontalMargin":I
    .end local v14    # "newWidth":I
    :goto_12
    const/high16 v1, 0x40000000    # 2.0f

    goto :goto_13

    .line 641
    .end local v27    # "fixedPanelWidthLimit":I
    .end local v28    # "maxLayoutHeight":I
    .restart local v1    # "fixedPanelWidthLimit":I
    .local v8, "maxLayoutHeight":I
    :cond_26
    move/from16 v27, v1

    move/from16 v28, v8

    .end local v1    # "fixedPanelWidthLimit":I
    .end local v8    # "maxLayoutHeight":I
    .restart local v27    # "fixedPanelWidthLimit":I
    .restart local v28    # "maxLayoutHeight":I
    const/4 v1, 0x0

    invoke-static {v1, v12}, Ljava/lang/Math;->max(II)I

    move-result v8

    .line 642
    .local v8, "widthToDistribute":I
    iget v13, v6, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->weight:F

    int-to-float v14, v8

    mul-float v13, v13, v14

    div-float/2addr v13, v9

    float-to-int v13, v13

    .line 643
    .local v13, "addedWidth":I
    add-int v14, v15, v13

    const/high16 v1, 0x40000000    # 2.0f

    invoke-static {v14, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v14

    .line 645
    .local v14, "childWidthSpec":I
    invoke-virtual {v5, v14, v3}, Landroid/view/View;->measure(II)V

    goto :goto_13

    .line 611
    .end local v3    # "childHeightSpec":I
    .end local v13    # "addedWidth":I
    .end local v14    # "childWidthSpec":I
    .end local v27    # "fixedPanelWidthLimit":I
    .end local v28    # "maxLayoutHeight":I
    .restart local v1    # "fixedPanelWidthLimit":I
    .local v8, "maxLayoutHeight":I
    :cond_27
    move/from16 v27, v1

    move/from16 v28, v8

    const/high16 v1, 0x40000000    # 2.0f

    .line 570
    .end local v1    # "fixedPanelWidthLimit":I
    .end local v5    # "child":Landroid/view/View;
    .end local v6    # "lp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    .end local v8    # "maxLayoutHeight":I
    .end local v15    # "measuredWidth":I
    .end local v26    # "skippedFirstPass":Z
    .restart local v27    # "fixedPanelWidthLimit":I
    .restart local v28    # "maxLayoutHeight":I
    :goto_13
    add-int/lit8 v4, v4, 0x1

    move/from16 v3, v24

    move/from16 v13, v25

    move/from16 v1, v27

    move/from16 v8, v28

    const/16 v15, 0x8

    goto/16 :goto_c

    .end local v24    # "heightMode":I
    .end local v25    # "childCount":I
    .end local v27    # "fixedPanelWidthLimit":I
    .end local v28    # "maxLayoutHeight":I
    .restart local v1    # "fixedPanelWidthLimit":I
    .local v3, "heightMode":I
    .restart local v8    # "maxLayoutHeight":I
    .local v13, "childCount":I
    :cond_28
    move/from16 v27, v1

    move/from16 v24, v3

    move/from16 v28, v8

    move/from16 v25, v13

    .line 651
    .end local v1    # "fixedPanelWidthLimit":I
    .end local v3    # "heightMode":I
    .end local v4    # "i":I
    .end local v8    # "maxLayoutHeight":I
    .end local v13    # "childCount":I
    .restart local v24    # "heightMode":I
    .restart local v25    # "childCount":I
    .restart local v28    # "maxLayoutHeight":I
    :goto_14
    move v1, v2

    .line 652
    .local v1, "measuredWidth":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingTop()I

    move-result v3

    add-int/2addr v3, v7

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingBottom()I

    move-result v4

    add-int/2addr v3, v4

    .line 654
    .local v3, "measuredHeight":I
    invoke-virtual {v0, v1, v3}, Landroid/support/v4/widget/SlidingPaneLayout;->setMeasuredDimension(II)V

    .line 655
    iput-boolean v10, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mCanSlide:Z

    .line 657
    iget-object v4, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v4}, Landroid/support/v4/widget/ViewDragHelper;->getViewDragState()I

    move-result v4

    if-eqz v4, :cond_29

    if-nez v10, :cond_29

    .line 659
    iget-object v4, v0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v4}, Landroid/support/v4/widget/ViewDragHelper;->abort()V

    goto :goto_15

    .line 657
    :cond_29
    nop

    .line 661
    :goto_15
    return-void
.end method

.method onPanelDragged(I)V
    .locals 10
    .param p1, "newLeft"    # I

    .line 950
    iget-object v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    if-nez v0, :cond_0

    .line 952
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideOffset:F

    .line 953
    return-void

    .line 955
    :cond_0
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->isLayoutRtlSupport()Z

    move-result v0

    .line 956
    .local v0, "isLayoutRtl":Z
    iget-object v1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;

    .line 958
    .local v1, "lp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    iget-object v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getWidth()I

    move-result v2

    .line 959
    .local v2, "childWidth":I
    if-eqz v0, :cond_1

    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getWidth()I

    move-result v3

    sub-int/2addr v3, p1

    sub-int/2addr v3, v2

    goto :goto_0

    :cond_1
    move v3, p1

    .line 961
    .local v3, "newStart":I
    :goto_0
    if-eqz v0, :cond_2

    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingRight()I

    move-result v4

    goto :goto_1

    :cond_2
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingLeft()I

    move-result v4

    .line 962
    .local v4, "paddingStart":I
    :goto_1
    if-eqz v0, :cond_3

    iget v5, v1, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->rightMargin:I

    goto :goto_2

    :cond_3
    iget v5, v1, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->leftMargin:I

    .line 963
    .local v5, "lpMargin":I
    :goto_2
    add-int v6, v4, v5

    .line 965
    .local v6, "startBound":I
    sub-int v7, v3, v6

    int-to-float v7, v7

    iget v8, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideRange:I

    int-to-float v8, v8

    div-float/2addr v7, v8

    iput v7, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideOffset:F

    .line 967
    iget v7, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mParallaxBy:I

    if-eqz v7, :cond_4

    .line 968
    iget v7, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideOffset:F

    invoke-direct {p0, v7}, Landroid/support/v4/widget/SlidingPaneLayout;->parallaxOtherViews(F)V

    goto :goto_3

    .line 967
    :cond_4
    nop

    .line 971
    :goto_3
    iget-boolean v7, v1, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->dimWhenOffset:Z

    if-eqz v7, :cond_5

    .line 972
    iget-object v7, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    iget v8, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideOffset:F

    iget v9, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSliderFadeColor:I

    invoke-direct {p0, v7, v8, v9}, Landroid/support/v4/widget/SlidingPaneLayout;->dimChildView(Landroid/view/View;FI)V

    goto :goto_4

    .line 971
    :cond_5
    nop

    .line 974
    :goto_4
    iget-object v7, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {p0, v7}, Landroid/support/v4/widget/SlidingPaneLayout;->dispatchOnPanelSlide(Landroid/view/View;)V

    .line 975
    return-void
.end method

.method protected onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 2
    .param p1, "state"    # Landroid/os/Parcelable;

    .line 1297
    instance-of v0, p1, Landroid/support/v4/widget/SlidingPaneLayout$SavedState;

    if-nez v0, :cond_0

    .line 1298
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 1299
    return-void

    .line 1302
    :cond_0
    move-object v0, p1

    check-cast v0, Landroid/support/v4/widget/SlidingPaneLayout$SavedState;

    .line 1303
    .local v0, "ss":Landroid/support/v4/widget/SlidingPaneLayout$SavedState;
    invoke-virtual {v0}, Landroid/support/v4/widget/SlidingPaneLayout$SavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v1

    invoke-super {p0, v1}, Landroid/view/ViewGroup;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 1305
    iget-boolean v1, v0, Landroid/support/v4/widget/SlidingPaneLayout$SavedState;->isOpen:Z

    if-eqz v1, :cond_1

    .line 1306
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->openPane()Z

    goto :goto_0

    .line 1308
    :cond_1
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->closePane()Z

    .line 1310
    :goto_0
    iget-boolean v1, v0, Landroid/support/v4/widget/SlidingPaneLayout$SavedState;->isOpen:Z

    iput-boolean v1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mPreservedOpenState:Z

    .line 1311
    return-void
.end method

.method protected onSaveInstanceState()Landroid/os/Parcelable;
    .locals 3

    .line 1287
    invoke-super {p0}, Landroid/view/ViewGroup;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v0

    .line 1289
    .local v0, "superState":Landroid/os/Parcelable;
    new-instance v1, Landroid/support/v4/widget/SlidingPaneLayout$SavedState;

    invoke-direct {v1, v0}, Landroid/support/v4/widget/SlidingPaneLayout$SavedState;-><init>(Landroid/os/Parcelable;)V

    .line 1290
    .local v1, "ss":Landroid/support/v4/widget/SlidingPaneLayout$SavedState;
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->isSlideable()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->isOpen()Z

    move-result v2

    goto :goto_0

    :cond_0
    iget-boolean v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mPreservedOpenState:Z

    :goto_0
    iput-boolean v2, v1, Landroid/support/v4/widget/SlidingPaneLayout$SavedState;->isOpen:Z

    .line 1292
    return-object v1
.end method

.method protected onSizeChanged(IIII)V
    .locals 1
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .line 752
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/ViewGroup;->onSizeChanged(IIII)V

    .line 754
    if-eq p1, p3, :cond_0

    .line 755
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mFirstLayout:Z

    goto :goto_0

    .line 754
    :cond_0
    nop

    .line 757
    :goto_0
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 11
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .line 829
    iget-boolean v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mCanSlide:Z

    if-nez v0, :cond_0

    .line 830
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0

    .line 833
    :cond_0
    iget-object v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/ViewDragHelper;->processTouchEvent(Landroid/view/MotionEvent;)V

    .line 835
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 836
    .local v0, "action":I
    const/4 v1, 0x1

    .line 838
    .local v1, "wantTouchEvents":Z
    and-int/lit16 v2, v0, 0xff

    packed-switch v2, :pswitch_data_0

    goto :goto_0

    .line 848
    :pswitch_0
    iget-object v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {p0, v2}, Landroid/support/v4/widget/SlidingPaneLayout;->isDimmed(Landroid/view/View;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 849
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    .line 850
    .local v2, "x":F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    .line 851
    .local v3, "y":F
    iget v4, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mInitialMotionX:F

    sub-float v4, v2, v4

    .line 852
    .local v4, "dx":F
    iget v5, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mInitialMotionY:F

    sub-float v5, v3, v5

    .line 853
    .local v5, "dy":F
    iget-object v6, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v6}, Landroid/support/v4/widget/ViewDragHelper;->getTouchSlop()I

    move-result v6

    .line 854
    .local v6, "slop":I
    mul-float v7, v4, v4

    mul-float v8, v5, v5

    add-float/2addr v7, v8

    mul-int v8, v6, v6

    int-to-float v8, v8

    cmpg-float v7, v7, v8

    if-gez v7, :cond_2

    iget-object v7, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    iget-object v8, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    float-to-int v9, v2

    float-to-int v10, v3

    .line 855
    invoke-virtual {v7, v8, v9, v10}, Landroid/support/v4/widget/ViewDragHelper;->isViewUnder(Landroid/view/View;II)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 857
    iget-object v7, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    const/4 v8, 0x0

    invoke-direct {p0, v7, v8}, Landroid/support/v4/widget/SlidingPaneLayout;->closePane(Landroid/view/View;I)Z

    .line 858
    goto :goto_0

    .line 855
    :cond_1
    goto :goto_0

    .line 854
    :cond_2
    goto :goto_0

    .line 848
    .end local v2    # "x":F
    .end local v3    # "y":F
    .end local v4    # "dx":F
    .end local v5    # "dy":F
    .end local v6    # "slop":I
    :cond_3
    goto :goto_0

    .line 840
    :pswitch_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    .line 841
    .restart local v2    # "x":F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    .line 842
    .restart local v3    # "y":F
    iput v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mInitialMotionX:F

    .line 843
    iput v3, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mInitialMotionY:F

    .line 844
    nop

    .line 865
    .end local v2    # "x":F
    .end local v3    # "y":F
    :goto_0
    return v1

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public openPane()Z
    .locals 2

    .line 899
    iget-object v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Landroid/support/v4/widget/SlidingPaneLayout;->openPane(Landroid/view/View;I)Z

    move-result v0

    return v0
.end method

.method public requestChildFocus(Landroid/view/View;Landroid/view/View;)V
    .locals 1
    .param p1, "child"    # Landroid/view/View;
    .param p2, "focused"    # Landroid/view/View;

    .line 761
    invoke-super {p0, p1, p2}, Landroid/view/ViewGroup;->requestChildFocus(Landroid/view/View;Landroid/view/View;)V

    .line 762
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->isInTouchMode()Z

    move-result v0

    if-nez v0, :cond_1

    iget-boolean v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mCanSlide:Z

    if-nez v0, :cond_1

    .line 763
    iget-object v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    if-ne p1, v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    iput-boolean v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mPreservedOpenState:Z

    goto :goto_1

    .line 762
    :cond_1
    nop

    .line 765
    :goto_1
    return-void
.end method

.method setAllChildrenVisible()V
    .locals 5

    .line 406
    const/4 v0, 0x0

    .local v0, "i":I
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getChildCount()I

    move-result v1

    .local v1, "childCount":I
    :goto_0
    if-ge v0, v1, :cond_1

    .line 407
    invoke-virtual {p0, v0}, Landroid/support/v4/widget/SlidingPaneLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 408
    .local v2, "child":Landroid/view/View;
    invoke-virtual {v2}, Landroid/view/View;->getVisibility()I

    move-result v3

    const/4 v4, 0x4

    if-ne v3, v4, :cond_0

    .line 409
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1

    .line 408
    :cond_0
    nop

    .line 406
    .end local v2    # "child":Landroid/view/View;
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 412
    .end local v0    # "i":I
    .end local v1    # "childCount":I
    :cond_1
    return-void
.end method

.method public setCoveredFadeColor(I)V
    .locals 0
    .param p1, "color"    # I
        .annotation build Landroid/support/annotation/ColorInt;
        .end annotation
    .end param

    .line 324
    iput p1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mCoveredFadeColor:I

    .line 325
    return-void
.end method

.method public setPanelSlideListener(Landroid/support/v4/widget/SlidingPaneLayout$PanelSlideListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/support/v4/widget/SlidingPaneLayout$PanelSlideListener;

    .line 336
    iput-object p1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mPanelSlideListener:Landroid/support/v4/widget/SlidingPaneLayout$PanelSlideListener;

    .line 337
    return-void
.end method

.method public setParallaxDistance(I)V
    .locals 0
    .param p1, "parallaxBy"    # I

    .line 287
    iput p1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mParallaxBy:I

    .line 288
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->requestLayout()V

    .line 289
    return-void
.end method

.method public setShadowDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "d"    # Landroid/graphics/drawable/Drawable;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 1105
    invoke-virtual {p0, p1}, Landroid/support/v4/widget/SlidingPaneLayout;->setShadowDrawableLeft(Landroid/graphics/drawable/Drawable;)V

    .line 1106
    return-void
.end method

.method public setShadowDrawableLeft(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "d"    # Landroid/graphics/drawable/Drawable;

    .line 1115
    iput-object p1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mShadowDrawableLeft:Landroid/graphics/drawable/Drawable;

    .line 1116
    return-void
.end method

.method public setShadowDrawableRight(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "d"    # Landroid/graphics/drawable/Drawable;

    .line 1125
    iput-object p1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mShadowDrawableRight:Landroid/graphics/drawable/Drawable;

    .line 1126
    return-void
.end method

.method public setShadowResource(I)V
    .locals 1
    .param p1, "resId"    # I
        .annotation build Landroid/support/annotation/DrawableRes;
        .end annotation
    .end param
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 1139
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/support/v4/widget/SlidingPaneLayout;->setShadowDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1140
    return-void
.end method

.method public setShadowResourceLeft(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 1149
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, Landroid/support/v4/content/ContextCompat;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/support/v4/widget/SlidingPaneLayout;->setShadowDrawableLeft(Landroid/graphics/drawable/Drawable;)V

    .line 1150
    return-void
.end method

.method public setShadowResourceRight(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 1159
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, Landroid/support/v4/content/ContextCompat;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/support/v4/widget/SlidingPaneLayout;->setShadowDrawableRight(Landroid/graphics/drawable/Drawable;)V

    .line 1160
    return-void
.end method

.method public setSliderFadeColor(I)V
    .locals 0
    .param p1, "color"    # I
        .annotation build Landroid/support/annotation/ColorInt;
        .end annotation
    .end param

    .line 306
    iput p1, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSliderFadeColor:I

    .line 307
    return-void
.end method

.method public smoothSlideClosed()V
    .locals 0
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 907
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->closePane()Z

    .line 908
    return-void
.end method

.method public smoothSlideOpen()V
    .locals 0
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 889
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->openPane()Z

    .line 890
    return-void
.end method

.method smoothSlideTo(FI)Z
    .locals 8
    .param p1, "slideOffset"    # F
    .param p2, "velocity"    # I

    .line 1058
    iget-boolean v0, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mCanSlide:Z

    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 1060
    return v1

    .line 1063
    :cond_0
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->isLayoutRtlSupport()Z

    move-result v0

    .line 1064
    .local v0, "isLayoutRtl":Z
    iget-object v2, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;

    .line 1067
    .local v2, "lp":Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;
    if-eqz v0, :cond_1

    .line 1068
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingRight()I

    move-result v3

    iget v4, v2, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->rightMargin:I

    add-int/2addr v3, v4

    .line 1069
    .local v3, "startBound":I
    iget-object v4, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getWidth()I

    move-result v4

    .line 1070
    .local v4, "childWidth":I
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getWidth()I

    move-result v5

    int-to-float v5, v5

    int-to-float v6, v3

    iget v7, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideRange:I

    int-to-float v7, v7

    mul-float v7, v7, p1

    add-float/2addr v6, v7

    int-to-float v7, v4

    add-float/2addr v6, v7

    sub-float/2addr v5, v6

    float-to-int v3, v5

    .line 1071
    .end local v4    # "childWidth":I
    .local v3, "x":I
    goto :goto_0

    .line 1072
    .end local v3    # "x":I
    :cond_1
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingLeft()I

    move-result v3

    iget v4, v2, Landroid/support/v4/widget/SlidingPaneLayout$LayoutParams;->leftMargin:I

    add-int/2addr v3, v4

    .line 1073
    .local v3, "startBound":I
    int-to-float v4, v3

    iget v5, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideRange:I

    int-to-float v5, v5

    mul-float v5, v5, p1

    add-float/2addr v4, v5

    float-to-int v3, v4

    .line 1076
    .local v3, "x":I
    :goto_0
    iget-object v4, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    iget-object v5, p0, Landroid/support/v4/widget/SlidingPaneLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getTop()I

    move-result v6

    invoke-virtual {v4, v5, v3, v6}, Landroid/support/v4/widget/ViewDragHelper;->smoothSlideViewTo(Landroid/view/View;II)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 1077
    invoke-virtual {p0}, Landroid/support/v4/widget/SlidingPaneLayout;->setAllChildrenVisible()V

    .line 1078
    invoke-static {p0}, Landroid/support/v4/view/ViewCompat;->postInvalidateOnAnimation(Landroid/view/View;)V

    .line 1079
    const/4 v1, 0x1

    return v1

    .line 1081
    :cond_2
    return v1
.end method

.method updateObscuredViewsVisibility(Landroid/view/View;)V
    .locals 19
    .param p1, "panel"    # Landroid/view/View;

    .line 360
    move-object/from16 v0, p1

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->isLayoutRtlSupport()Z

    move-result v1

    .line 361
    .local v1, "isLayoutRtl":Z
    if-eqz v1, :cond_0

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getWidth()I

    move-result v2

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingRight()I

    move-result v3

    sub-int/2addr v2, v3

    goto :goto_0

    :cond_0
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingLeft()I

    move-result v2

    .line 362
    .local v2, "startBound":I
    :goto_0
    if-eqz v1, :cond_1

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingLeft()I

    move-result v3

    goto :goto_1

    :cond_1
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getWidth()I

    move-result v3

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingRight()I

    move-result v4

    sub-int/2addr v3, v4

    .line 363
    .local v3, "endBound":I
    :goto_1
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingTop()I

    move-result v4

    .line 364
    .local v4, "topBound":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getHeight()I

    move-result v5

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getPaddingBottom()I

    move-result v6

    sub-int/2addr v5, v6

    .line 369
    .local v5, "bottomBound":I
    if-eqz v0, :cond_2

    invoke-static/range {p1 .. p1}, Landroid/support/v4/widget/SlidingPaneLayout;->viewIsOpaque(Landroid/view/View;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 370
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getLeft()I

    move-result v6

    .line 371
    .local v6, "left":I
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getRight()I

    move-result v7

    .line 372
    .local v7, "right":I
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getTop()I

    move-result v8

    .line 373
    .local v8, "top":I
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getBottom()I

    move-result v9

    goto :goto_2

    .line 369
    .end local v6    # "left":I
    .end local v7    # "right":I
    .end local v8    # "top":I
    :cond_2
    nop

    .line 375
    const/4 v6, 0x0

    move v9, v6

    .local v9, "bottom":I
    move v8, v6

    .restart local v8    # "top":I
    move v7, v6

    .line 378
    .restart local v6    # "left":I
    .restart local v7    # "right":I
    :goto_2
    const/4 v10, 0x0

    .local v10, "i":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/widget/SlidingPaneLayout;->getChildCount()I

    move-result v11

    .local v11, "childCount":I
    :goto_3
    if-ge v10, v11, :cond_8

    .line 379
    move-object/from16 v12, p0

    invoke-virtual {v12, v10}, Landroid/support/v4/widget/SlidingPaneLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v13

    .line 381
    .local v13, "child":Landroid/view/View;
    if-ne v13, v0, :cond_3

    .line 383
    move/from16 v16, v1

    goto/16 :goto_8

    .line 384
    :cond_3
    invoke-virtual {v13}, Landroid/view/View;->getVisibility()I

    move-result v14

    const/16 v15, 0x8

    if-ne v14, v15, :cond_4

    .line 385
    move/from16 v16, v1

    goto :goto_7

    .line 388
    :cond_4
    if-eqz v1, :cond_5

    move v14, v3

    goto :goto_4

    :cond_5
    move v14, v2

    .line 389
    :goto_4
    invoke-virtual {v13}, Landroid/view/View;->getLeft()I

    move-result v15

    .line 388
    invoke-static {v14, v15}, Ljava/lang/Math;->max(II)I

    move-result v14

    .line 390
    .local v14, "clampedChildLeft":I
    invoke-virtual {v13}, Landroid/view/View;->getTop()I

    move-result v15

    invoke-static {v4, v15}, Ljava/lang/Math;->max(II)I

    move-result v15

    .line 391
    .local v15, "clampedChildTop":I
    if-eqz v1, :cond_6

    move v0, v2

    goto :goto_5

    :cond_6
    move v0, v3

    .line 392
    :goto_5
    move/from16 v16, v1

    .end local v1    # "isLayoutRtl":Z
    .local v16, "isLayoutRtl":Z
    invoke-virtual {v13}, Landroid/view/View;->getRight()I

    move-result v1

    .line 391
    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 393
    .local v0, "clampedChildRight":I
    invoke-virtual {v13}, Landroid/view/View;->getBottom()I

    move-result v1

    invoke-static {v5, v1}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 395
    .local v1, "clampedChildBottom":I
    if-lt v14, v6, :cond_7

    if-lt v15, v8, :cond_7

    if-gt v0, v7, :cond_7

    if-gt v1, v9, :cond_7

    .line 397
    const/16 v17, 0x4

    move/from16 v18, v0

    move/from16 v0, v17

    goto :goto_6

    .line 395
    :cond_7
    nop

    .line 399
    const/16 v17, 0x0

    move/from16 v18, v0

    move/from16 v0, v17

    .line 401
    .local v0, "vis":I
    .local v18, "clampedChildRight":I
    :goto_6
    invoke-virtual {v13, v0}, Landroid/view/View;->setVisibility(I)V

    .line 378
    .end local v0    # "vis":I
    .end local v1    # "clampedChildBottom":I
    .end local v13    # "child":Landroid/view/View;
    .end local v14    # "clampedChildLeft":I
    .end local v15    # "clampedChildTop":I
    .end local v18    # "clampedChildRight":I
    :goto_7
    add-int/lit8 v10, v10, 0x1

    move/from16 v1, v16

    move-object/from16 v0, p1

    goto :goto_3

    .end local v16    # "isLayoutRtl":Z
    .local v1, "isLayoutRtl":Z
    :cond_8
    move-object/from16 v12, p0

    move/from16 v16, v1

    .line 403
    .end local v1    # "isLayoutRtl":Z
    .end local v10    # "i":I
    .end local v11    # "childCount":I
    .restart local v16    # "isLayoutRtl":Z
    :goto_8
    return-void
.end method
