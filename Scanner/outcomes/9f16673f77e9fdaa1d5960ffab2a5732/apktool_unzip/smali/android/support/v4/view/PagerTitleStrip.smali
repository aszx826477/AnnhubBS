.class public Landroid/support/v4/view/PagerTitleStrip;
.super Landroid/view/ViewGroup;
.source "PagerTitleStrip.java"


# annotations
.annotation runtime Landroid/support/v4/view/ViewPager$DecorView;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v4/view/PagerTitleStrip$PageListener;,
        Landroid/support/v4/view/PagerTitleStrip$PagerTitleStripImplIcs;,
        Landroid/support/v4/view/PagerTitleStrip$PagerTitleStripImplBase;,
        Landroid/support/v4/view/PagerTitleStrip$PagerTitleStripImpl;
    }
.end annotation


# static fields
.field private static final ATTRS:[I

.field private static final IMPL:Landroid/support/v4/view/PagerTitleStrip$PagerTitleStripImpl;

.field private static final SIDE_ALPHA:F = 0.6f

.field private static final TAG:Ljava/lang/String; = "PagerTitleStrip"

.field private static final TEXT_ATTRS:[I

.field private static final TEXT_SPACING:I = 0x10


# instance fields
.field mCurrText:Landroid/widget/TextView;

.field private mGravity:I

.field private mLastKnownCurrentPage:I

.field mLastKnownPositionOffset:F

.field mNextText:Landroid/widget/TextView;

.field private mNonPrimaryAlpha:I

.field private final mPageListener:Landroid/support/v4/view/PagerTitleStrip$PageListener;

.field mPager:Landroid/support/v4/view/ViewPager;

.field mPrevText:Landroid/widget/TextView;

.field private mScaledTextSpacing:I

.field mTextColor:I

.field private mUpdatingPositions:Z

.field private mUpdatingText:Z

.field private mWatchingAdapter:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference<",
            "Landroid/support/v4/view/PagerAdapter;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 69
    const/4 v0, 0x4

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Landroid/support/v4/view/PagerTitleStrip;->ATTRS:[I

    .line 76
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, 0x101038c

    aput v2, v0, v1

    sput-object v0, Landroid/support/v4/view/PagerTitleStrip;->TEXT_ATTRS:[I

    .line 106
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_0

    .line 107
    new-instance v0, Landroid/support/v4/view/PagerTitleStrip$PagerTitleStripImplIcs;

    invoke-direct {v0}, Landroid/support/v4/view/PagerTitleStrip$PagerTitleStripImplIcs;-><init>()V

    sput-object v0, Landroid/support/v4/view/PagerTitleStrip;->IMPL:Landroid/support/v4/view/PagerTitleStrip$PagerTitleStripImpl;

    goto :goto_0

    .line 109
    :cond_0
    new-instance v0, Landroid/support/v4/view/PagerTitleStrip$PagerTitleStripImplBase;

    invoke-direct {v0}, Landroid/support/v4/view/PagerTitleStrip$PagerTitleStripImplBase;-><init>()V

    sput-object v0, Landroid/support/v4/view/PagerTitleStrip;->IMPL:Landroid/support/v4/view/PagerTitleStrip$PagerTitleStripImpl;

    .line 111
    :goto_0
    return-void

    nop

    :array_0
    .array-data 4
        0x1010034
        0x1010095
        0x1010098
        0x10100af
    .end array-data
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 118
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v4/view/PagerTitleStrip;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 119
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .line 122
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 57
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mLastKnownCurrentPage:I

    .line 58
    const/high16 v0, -0x40800000    # -1.0f

    iput v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mLastKnownPositionOffset:F

    .line 65
    new-instance v0, Landroid/support/v4/view/PagerTitleStrip$PageListener;

    invoke-direct {v0, p0}, Landroid/support/v4/view/PagerTitleStrip$PageListener;-><init>(Landroid/support/v4/view/PagerTitleStrip;)V

    iput-object v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mPageListener:Landroid/support/v4/view/PagerTitleStrip$PageListener;

    .line 124
    new-instance v0, Landroid/widget/TextView;

    invoke-direct {v0, p1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mPrevText:Landroid/widget/TextView;

    invoke-virtual {p0, v0}, Landroid/support/v4/view/PagerTitleStrip;->addView(Landroid/view/View;)V

    .line 125
    new-instance v0, Landroid/widget/TextView;

    invoke-direct {v0, p1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    invoke-virtual {p0, v0}, Landroid/support/v4/view/PagerTitleStrip;->addView(Landroid/view/View;)V

    .line 126
    new-instance v0, Landroid/widget/TextView;

    invoke-direct {v0, p1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mNextText:Landroid/widget/TextView;

    invoke-virtual {p0, v0}, Landroid/support/v4/view/PagerTitleStrip;->addView(Landroid/view/View;)V

    .line 128
    sget-object v0, Landroid/support/v4/view/PagerTitleStrip;->ATTRS:[I

    invoke-virtual {p1, p2, v0}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 129
    .local v0, "a":Landroid/content/res/TypedArray;
    const/4 v1, 0x0

    invoke-virtual {v0, v1, v1}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v2

    .line 130
    .local v2, "textAppearance":I
    if-eqz v2, :cond_0

    .line 131
    iget-object v3, p0, Landroid/support/v4/view/PagerTitleStrip;->mPrevText:Landroid/widget/TextView;

    invoke-static {v3, v2}, Landroid/support/v4/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView;I)V

    .line 132
    iget-object v3, p0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    invoke-static {v3, v2}, Landroid/support/v4/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView;I)V

    .line 133
    iget-object v3, p0, Landroid/support/v4/view/PagerTitleStrip;->mNextText:Landroid/widget/TextView;

    invoke-static {v3, v2}, Landroid/support/v4/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView;I)V

    goto :goto_0

    .line 130
    :cond_0
    nop

    .line 135
    :goto_0
    const/4 v3, 0x1

    invoke-virtual {v0, v3, v1}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v3

    .line 136
    .local v3, "textSize":I
    if-eqz v3, :cond_1

    .line 137
    int-to-float v4, v3

    invoke-virtual {p0, v1, v4}, Landroid/support/v4/view/PagerTitleStrip;->setTextSize(IF)V

    goto :goto_1

    .line 136
    :cond_1
    nop

    .line 139
    :goto_1
    const/4 v4, 0x2

    invoke-virtual {v0, v4}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 140
    invoke-virtual {v0, v4, v1}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v4

    .line 141
    .local v4, "textColor":I
    iget-object v5, p0, Landroid/support/v4/view/PagerTitleStrip;->mPrevText:Landroid/widget/TextView;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 142
    iget-object v5, p0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 143
    iget-object v5, p0, Landroid/support/v4/view/PagerTitleStrip;->mNextText:Landroid/widget/TextView;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_2

    .line 139
    .end local v4    # "textColor":I
    :cond_2
    nop

    .line 145
    :goto_2
    const/4 v4, 0x3

    const/16 v5, 0x50

    invoke-virtual {v0, v4, v5}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v4

    iput v4, p0, Landroid/support/v4/view/PagerTitleStrip;->mGravity:I

    .line 146
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 148
    iget-object v4, p0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getTextColors()Landroid/content/res/ColorStateList;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v4

    iput v4, p0, Landroid/support/v4/view/PagerTitleStrip;->mTextColor:I

    .line 149
    const v4, 0x3f19999a    # 0.6f

    invoke-virtual {p0, v4}, Landroid/support/v4/view/PagerTitleStrip;->setNonPrimaryAlpha(F)V

    .line 151
    iget-object v4, p0, Landroid/support/v4/view/PagerTitleStrip;->mPrevText:Landroid/widget/TextView;

    sget-object v5, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 152
    iget-object v4, p0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    sget-object v5, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 153
    iget-object v4, p0, Landroid/support/v4/view/PagerTitleStrip;->mNextText:Landroid/widget/TextView;

    sget-object v5, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 155
    const/4 v4, 0x0

    .line 156
    .local v4, "allCaps":Z
    if-eqz v2, :cond_3

    .line 157
    sget-object v5, Landroid/support/v4/view/PagerTitleStrip;->TEXT_ATTRS:[I

    invoke-virtual {p1, v2, v5}, Landroid/content/Context;->obtainStyledAttributes(I[I)Landroid/content/res/TypedArray;

    move-result-object v5

    .line 158
    .local v5, "ta":Landroid/content/res/TypedArray;
    invoke-virtual {v5, v1, v1}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v4

    .line 159
    invoke-virtual {v5}, Landroid/content/res/TypedArray;->recycle()V

    goto :goto_3

    .line 156
    .end local v5    # "ta":Landroid/content/res/TypedArray;
    :cond_3
    nop

    .line 162
    :goto_3
    if-eqz v4, :cond_4

    .line 163
    iget-object v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mPrevText:Landroid/widget/TextView;

    invoke-static {v1}, Landroid/support/v4/view/PagerTitleStrip;->setSingleLineAllCaps(Landroid/widget/TextView;)V

    .line 164
    iget-object v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    invoke-static {v1}, Landroid/support/v4/view/PagerTitleStrip;->setSingleLineAllCaps(Landroid/widget/TextView;)V

    .line 165
    iget-object v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mNextText:Landroid/widget/TextView;

    invoke-static {v1}, Landroid/support/v4/view/PagerTitleStrip;->setSingleLineAllCaps(Landroid/widget/TextView;)V

    goto :goto_4

    .line 167
    :cond_4
    iget-object v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mPrevText:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->setSingleLine()V

    .line 168
    iget-object v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->setSingleLine()V

    .line 169
    iget-object v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mNextText:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->setSingleLine()V

    .line 172
    :goto_4
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->density:F

    .line 173
    .local v1, "density":F
    const/high16 v5, 0x41800000    # 16.0f

    mul-float v5, v5, v1

    float-to-int v5, v5

    iput v5, p0, Landroid/support/v4/view/PagerTitleStrip;->mScaledTextSpacing:I

    .line 174
    return-void
.end method

.method private static setSingleLineAllCaps(Landroid/widget/TextView;)V
    .locals 1
    .param p0, "text"    # Landroid/widget/TextView;

    .line 114
    sget-object v0, Landroid/support/v4/view/PagerTitleStrip;->IMPL:Landroid/support/v4/view/PagerTitleStrip$PagerTitleStripImpl;

    invoke-interface {v0, p0}, Landroid/support/v4/view/PagerTitleStrip$PagerTitleStripImpl;->setSingleLineAllCaps(Landroid/widget/TextView;)V

    .line 115
    return-void
.end method


# virtual methods
.method getMinHeight()I
    .locals 2

    .line 472
    const/4 v0, 0x0

    .line 473
    .local v0, "minHeight":I
    invoke-virtual {p0}, Landroid/support/v4/view/PagerTitleStrip;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 474
    .local v1, "bg":Landroid/graphics/drawable/Drawable;
    if-eqz v1, :cond_0

    .line 475
    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    goto :goto_0

    .line 474
    :cond_0
    nop

    .line 477
    :goto_0
    return v0
.end method

.method public getTextSpacing()I
    .locals 1

    .line 190
    iget v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mScaledTextSpacing:I

    return v0
.end method

.method protected onAttachedToWindow()V
    .locals 4

    .line 248
    invoke-super {p0}, Landroid/view/ViewGroup;->onAttachedToWindow()V

    .line 250
    invoke-virtual {p0}, Landroid/support/v4/view/PagerTitleStrip;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 251
    .local v0, "parent":Landroid/view/ViewParent;
    instance-of v1, v0, Landroid/support/v4/view/ViewPager;

    if-eqz v1, :cond_1

    .line 256
    move-object v1, v0

    check-cast v1, Landroid/support/v4/view/ViewPager;

    .line 257
    .local v1, "pager":Landroid/support/v4/view/ViewPager;
    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v2

    .line 259
    .local v2, "adapter":Landroid/support/v4/view/PagerAdapter;
    iget-object v3, p0, Landroid/support/v4/view/PagerTitleStrip;->mPageListener:Landroid/support/v4/view/PagerTitleStrip$PageListener;

    invoke-virtual {v1, v3}, Landroid/support/v4/view/ViewPager;->setInternalPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    .line 260
    iget-object v3, p0, Landroid/support/v4/view/PagerTitleStrip;->mPageListener:Landroid/support/v4/view/PagerTitleStrip$PageListener;

    invoke-virtual {v1, v3}, Landroid/support/v4/view/ViewPager;->addOnAdapterChangeListener(Landroid/support/v4/view/ViewPager$OnAdapterChangeListener;)V

    .line 261
    iput-object v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mPager:Landroid/support/v4/view/ViewPager;

    .line 262
    iget-object v3, p0, Landroid/support/v4/view/PagerTitleStrip;->mWatchingAdapter:Ljava/lang/ref/WeakReference;

    if-eqz v3, :cond_0

    invoke-virtual {v3}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v4/view/PagerAdapter;

    goto :goto_0

    :cond_0
    const/4 v3, 0x0

    :goto_0
    invoke-virtual {p0, v3, v2}, Landroid/support/v4/view/PagerTitleStrip;->updateAdapter(Landroid/support/v4/view/PagerAdapter;Landroid/support/v4/view/PagerAdapter;)V

    .line 263
    return-void

    .line 252
    .end local v1    # "pager":Landroid/support/v4/view/ViewPager;
    .end local v2    # "adapter":Landroid/support/v4/view/PagerAdapter;
    :cond_1
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "PagerTitleStrip must be a direct child of a ViewPager."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method protected onDetachedFromWindow()V
    .locals 3

    .line 267
    invoke-super {p0}, Landroid/view/ViewGroup;->onDetachedFromWindow()V

    .line 268
    iget-object v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mPager:Landroid/support/v4/view/ViewPager;

    if-eqz v0, :cond_0

    .line 269
    invoke-virtual {v0}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/support/v4/view/PagerTitleStrip;->updateAdapter(Landroid/support/v4/view/PagerAdapter;Landroid/support/v4/view/PagerAdapter;)V

    .line 270
    iget-object v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setInternalPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    .line 271
    iget-object v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mPager:Landroid/support/v4/view/ViewPager;

    iget-object v2, p0, Landroid/support/v4/view/PagerTitleStrip;->mPageListener:Landroid/support/v4/view/PagerTitleStrip$PageListener;

    invoke-virtual {v0, v2}, Landroid/support/v4/view/ViewPager;->removeOnAdapterChangeListener(Landroid/support/v4/view/ViewPager$OnAdapterChangeListener;)V

    .line 272
    iput-object v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mPager:Landroid/support/v4/view/ViewPager;

    goto :goto_0

    .line 268
    :cond_0
    nop

    .line 274
    :goto_0
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 3
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .line 465
    iget-object v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mPager:Landroid/support/v4/view/ViewPager;

    if-eqz v0, :cond_1

    .line 466
    iget v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mLastKnownPositionOffset:F

    const/4 v1, 0x0

    cmpl-float v2, v0, v1

    if-ltz v2, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 467
    .local v0, "offset":F
    :goto_0
    iget v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mLastKnownCurrentPage:I

    const/4 v2, 0x1

    invoke-virtual {p0, v1, v0, v2}, Landroid/support/v4/view/PagerTitleStrip;->updateTextPositions(IFZ)V

    goto :goto_1

    .line 465
    .end local v0    # "offset":F
    :cond_1
    nop

    .line 469
    :goto_1
    return-void
.end method

.method protected onMeasure(II)V
    .locals 10
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .line 429
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v0

    .line 430
    .local v0, "widthMode":I
    const/high16 v1, 0x40000000    # 2.0f

    if-ne v0, v1, :cond_1

    .line 434
    invoke-virtual {p0}, Landroid/support/v4/view/PagerTitleStrip;->getPaddingTop()I

    move-result v2

    invoke-virtual {p0}, Landroid/support/v4/view/PagerTitleStrip;->getPaddingBottom()I

    move-result v3

    add-int/2addr v2, v3

    .line 435
    .local v2, "heightPadding":I
    const/4 v3, -0x2

    invoke-static {p2, v2, v3}, Landroid/support/v4/view/PagerTitleStrip;->getChildMeasureSpec(III)I

    move-result v4

    .line 438
    .local v4, "childHeightSpec":I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v5

    .line 439
    .local v5, "widthSize":I
    int-to-float v6, v5

    const v7, 0x3e4ccccd    # 0.2f

    mul-float v6, v6, v7

    float-to-int v6, v6

    .line 440
    .local v6, "widthPadding":I
    invoke-static {p1, v6, v3}, Landroid/support/v4/view/PagerTitleStrip;->getChildMeasureSpec(III)I

    move-result v3

    .line 443
    .local v3, "childWidthSpec":I
    iget-object v7, p0, Landroid/support/v4/view/PagerTitleStrip;->mPrevText:Landroid/widget/TextView;

    invoke-virtual {v7, v3, v4}, Landroid/widget/TextView;->measure(II)V

    .line 444
    iget-object v7, p0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    invoke-virtual {v7, v3, v4}, Landroid/widget/TextView;->measure(II)V

    .line 445
    iget-object v7, p0, Landroid/support/v4/view/PagerTitleStrip;->mNextText:Landroid/widget/TextView;

    invoke-virtual {v7, v3, v4}, Landroid/widget/TextView;->measure(II)V

    .line 448
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v7

    .line 449
    .local v7, "heightMode":I
    if-ne v7, v1, :cond_0

    .line 450
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v1

    goto :goto_0

    .line 452
    :cond_0
    iget-object v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getMeasuredHeight()I

    move-result v1

    .line 453
    .local v1, "textHeight":I
    invoke-virtual {p0}, Landroid/support/v4/view/PagerTitleStrip;->getMinHeight()I

    move-result v8

    .line 454
    .local v8, "minHeight":I
    add-int v9, v1, v2

    invoke-static {v8, v9}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 457
    .end local v8    # "minHeight":I
    .local v1, "height":I
    :goto_0
    iget-object v8, p0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    invoke-static {v8}, Landroid/support/v4/view/ViewCompat;->getMeasuredState(Landroid/view/View;)I

    move-result v8

    .line 458
    .local v8, "childState":I
    shl-int/lit8 v9, v8, 0x10

    invoke-static {v1, p2, v9}, Landroid/support/v4/view/ViewCompat;->resolveSizeAndState(III)I

    move-result v9

    .line 460
    .local v9, "measuredHeight":I
    invoke-virtual {p0, v5, v9}, Landroid/support/v4/view/PagerTitleStrip;->setMeasuredDimension(II)V

    .line 461
    return-void

    .line 431
    .end local v1    # "height":I
    .end local v2    # "heightPadding":I
    .end local v3    # "childWidthSpec":I
    .end local v4    # "childHeightSpec":I
    .end local v5    # "widthSize":I
    .end local v6    # "widthPadding":I
    .end local v7    # "heightMode":I
    .end local v8    # "childState":I
    .end local v9    # "measuredHeight":I
    :cond_1
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Must measure with an exact width"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public requestLayout()V
    .locals 1

    .line 317
    iget-boolean v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mUpdatingText:Z

    if-nez v0, :cond_0

    .line 318
    invoke-super {p0}, Landroid/view/ViewGroup;->requestLayout()V

    goto :goto_0

    .line 317
    :cond_0
    nop

    .line 320
    :goto_0
    return-void
.end method

.method public setGravity(I)V
    .locals 0
    .param p1, "gravity"    # I

    .line 242
    iput p1, p0, Landroid/support/v4/view/PagerTitleStrip;->mGravity:I

    .line 243
    invoke-virtual {p0}, Landroid/support/v4/view/PagerTitleStrip;->requestLayout()V

    .line 244
    return-void
.end method

.method public setNonPrimaryAlpha(F)V
    .locals 3
    .param p1, "alpha"    # F
        .annotation build Landroid/support/annotation/FloatRange;
            from = 0.0
            to = 1.0
        .end annotation
    .end param

    .line 199
    const/high16 v0, 0x437f0000    # 255.0f

    mul-float v0, v0, p1

    float-to-int v0, v0

    and-int/lit16 v0, v0, 0xff

    iput v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mNonPrimaryAlpha:I

    .line 200
    iget v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mNonPrimaryAlpha:I

    shl-int/lit8 v0, v0, 0x18

    iget v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mTextColor:I

    const v2, 0xffffff

    and-int/2addr v1, v2

    or-int/2addr v0, v1

    .line 201
    .local v0, "transparentColor":I
    iget-object v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mPrevText:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 202
    iget-object v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mNextText:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 203
    return-void
.end method

.method public setTextColor(I)V
    .locals 3
    .param p1, "color"    # I
        .annotation build Landroid/support/annotation/ColorInt;
        .end annotation
    .end param

    .line 212
    iput p1, p0, Landroid/support/v4/view/PagerTitleStrip;->mTextColor:I

    .line 213
    iget-object v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 214
    iget v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mNonPrimaryAlpha:I

    shl-int/lit8 v0, v0, 0x18

    iget v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mTextColor:I

    const v2, 0xffffff

    and-int/2addr v1, v2

    or-int/2addr v0, v1

    .line 215
    .local v0, "transparentColor":I
    iget-object v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mPrevText:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 216
    iget-object v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mNextText:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 217
    return-void
.end method

.method public setTextSize(IF)V
    .locals 1
    .param p1, "unit"    # I
    .param p2, "size"    # F

    .line 230
    iget-object v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mPrevText:Landroid/widget/TextView;

    invoke-virtual {v0, p1, p2}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 231
    iget-object v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    invoke-virtual {v0, p1, p2}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 232
    iget-object v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mNextText:Landroid/widget/TextView;

    invoke-virtual {v0, p1, p2}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 233
    return-void
.end method

.method public setTextSpacing(I)V
    .locals 0
    .param p1, "spacingPixels"    # I

    .line 182
    iput p1, p0, Landroid/support/v4/view/PagerTitleStrip;->mScaledTextSpacing:I

    .line 183
    invoke-virtual {p0}, Landroid/support/v4/view/PagerTitleStrip;->requestLayout()V

    .line 184
    return-void
.end method

.method updateAdapter(Landroid/support/v4/view/PagerAdapter;Landroid/support/v4/view/PagerAdapter;)V
    .locals 2
    .param p1, "oldAdapter"    # Landroid/support/v4/view/PagerAdapter;
    .param p2, "newAdapter"    # Landroid/support/v4/view/PagerAdapter;

    .line 323
    if-eqz p1, :cond_0

    .line 324
    iget-object v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mPageListener:Landroid/support/v4/view/PagerTitleStrip$PageListener;

    invoke-virtual {p1, v0}, Landroid/support/v4/view/PagerAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 325
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mWatchingAdapter:Ljava/lang/ref/WeakReference;

    goto :goto_0

    .line 323
    :cond_0
    nop

    .line 327
    :goto_0
    if-eqz p2, :cond_1

    .line 328
    iget-object v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mPageListener:Landroid/support/v4/view/PagerTitleStrip$PageListener;

    invoke-virtual {p2, v0}, Landroid/support/v4/view/PagerAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 329
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p2}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mWatchingAdapter:Ljava/lang/ref/WeakReference;

    goto :goto_1

    .line 327
    :cond_1
    nop

    .line 331
    :goto_1
    iget-object v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mPager:Landroid/support/v4/view/ViewPager;

    if-eqz v0, :cond_2

    .line 332
    const/4 v1, -0x1

    iput v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mLastKnownCurrentPage:I

    .line 333
    const/high16 v1, -0x40800000    # -1.0f

    iput v1, p0, Landroid/support/v4/view/PagerTitleStrip;->mLastKnownPositionOffset:F

    .line 334
    invoke-virtual {v0}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v0

    invoke-virtual {p0, v0, p2}, Landroid/support/v4/view/PagerTitleStrip;->updateText(ILandroid/support/v4/view/PagerAdapter;)V

    .line 335
    invoke-virtual {p0}, Landroid/support/v4/view/PagerTitleStrip;->requestLayout()V

    goto :goto_2

    .line 331
    :cond_2
    nop

    .line 337
    :goto_2
    return-void
.end method

.method updateText(ILandroid/support/v4/view/PagerAdapter;)V
    .locals 10
    .param p1, "currentItem"    # I
    .param p2, "adapter"    # Landroid/support/v4/view/PagerAdapter;

    .line 277
    const/4 v0, 0x0

    if-eqz p2, :cond_0

    invoke-virtual {p2}, Landroid/support/v4/view/PagerAdapter;->getCount()I

    move-result v1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    .line 278
    .local v1, "itemCount":I
    :goto_0
    const/4 v2, 0x1

    iput-boolean v2, p0, Landroid/support/v4/view/PagerTitleStrip;->mUpdatingText:Z

    .line 280
    const/4 v3, 0x0

    .line 281
    .local v3, "text":Ljava/lang/CharSequence;
    if-lt p1, v2, :cond_1

    if-eqz p2, :cond_1

    .line 282
    add-int/lit8 v2, p1, -0x1

    invoke-virtual {p2, v2}, Landroid/support/v4/view/PagerAdapter;->getPageTitle(I)Ljava/lang/CharSequence;

    move-result-object v3

    goto :goto_1

    .line 281
    :cond_1
    nop

    .line 284
    :goto_1
    iget-object v2, p0, Landroid/support/v4/view/PagerTitleStrip;->mPrevText:Landroid/widget/TextView;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 286
    iget-object v2, p0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    if-eqz p2, :cond_2

    if-ge p1, v1, :cond_2

    .line 287
    invoke-virtual {p2, p1}, Landroid/support/v4/view/PagerAdapter;->getPageTitle(I)Ljava/lang/CharSequence;

    move-result-object v4

    goto :goto_2

    .line 286
    :cond_2
    nop

    .line 287
    const/4 v4, 0x0

    .line 286
    :goto_2
    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 289
    const/4 v2, 0x0

    .line 290
    .end local v3    # "text":Ljava/lang/CharSequence;
    .local v2, "text":Ljava/lang/CharSequence;
    add-int/lit8 v3, p1, 0x1

    if-ge v3, v1, :cond_3

    if-eqz p2, :cond_3

    .line 291
    add-int/lit8 v3, p1, 0x1

    invoke-virtual {p2, v3}, Landroid/support/v4/view/PagerAdapter;->getPageTitle(I)Ljava/lang/CharSequence;

    move-result-object v2

    goto :goto_3

    .line 290
    :cond_3
    nop

    .line 293
    :goto_3
    iget-object v3, p0, Landroid/support/v4/view/PagerTitleStrip;->mNextText:Landroid/widget/TextView;

    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 296
    invoke-virtual {p0}, Landroid/support/v4/view/PagerTitleStrip;->getWidth()I

    move-result v3

    invoke-virtual {p0}, Landroid/support/v4/view/PagerTitleStrip;->getPaddingLeft()I

    move-result v4

    sub-int/2addr v3, v4

    invoke-virtual {p0}, Landroid/support/v4/view/PagerTitleStrip;->getPaddingRight()I

    move-result v4

    sub-int/2addr v3, v4

    .line 297
    .local v3, "width":I
    int-to-float v4, v3

    const v5, 0x3f4ccccd    # 0.8f

    mul-float v4, v4, v5

    float-to-int v4, v4

    invoke-static {v0, v4}, Ljava/lang/Math;->max(II)I

    move-result v4

    .line 298
    .local v4, "maxWidth":I
    const/high16 v5, -0x80000000

    invoke-static {v4, v5}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v6

    .line 299
    .local v6, "childWidthSpec":I
    invoke-virtual {p0}, Landroid/support/v4/view/PagerTitleStrip;->getHeight()I

    move-result v7

    invoke-virtual {p0}, Landroid/support/v4/view/PagerTitleStrip;->getPaddingTop()I

    move-result v8

    sub-int/2addr v7, v8

    invoke-virtual {p0}, Landroid/support/v4/view/PagerTitleStrip;->getPaddingBottom()I

    move-result v8

    sub-int/2addr v7, v8

    .line 300
    .local v7, "childHeight":I
    invoke-static {v0, v7}, Ljava/lang/Math;->max(II)I

    move-result v8

    .line 301
    .local v8, "maxHeight":I
    invoke-static {v8, v5}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v5

    .line 302
    .local v5, "childHeightSpec":I
    iget-object v9, p0, Landroid/support/v4/view/PagerTitleStrip;->mPrevText:Landroid/widget/TextView;

    invoke-virtual {v9, v6, v5}, Landroid/widget/TextView;->measure(II)V

    .line 303
    iget-object v9, p0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    invoke-virtual {v9, v6, v5}, Landroid/widget/TextView;->measure(II)V

    .line 304
    iget-object v9, p0, Landroid/support/v4/view/PagerTitleStrip;->mNextText:Landroid/widget/TextView;

    invoke-virtual {v9, v6, v5}, Landroid/widget/TextView;->measure(II)V

    .line 306
    iput p1, p0, Landroid/support/v4/view/PagerTitleStrip;->mLastKnownCurrentPage:I

    .line 308
    iget-boolean v9, p0, Landroid/support/v4/view/PagerTitleStrip;->mUpdatingPositions:Z

    if-nez v9, :cond_4

    .line 309
    iget v9, p0, Landroid/support/v4/view/PagerTitleStrip;->mLastKnownPositionOffset:F

    invoke-virtual {p0, p1, v9, v0}, Landroid/support/v4/view/PagerTitleStrip;->updateTextPositions(IFZ)V

    goto :goto_4

    .line 308
    :cond_4
    nop

    .line 312
    :goto_4
    iput-boolean v0, p0, Landroid/support/v4/view/PagerTitleStrip;->mUpdatingText:Z

    .line 313
    return-void
.end method

.method updateTextPositions(IFZ)V
    .locals 42
    .param p1, "position"    # I
    .param p2, "positionOffset"    # F
    .param p3, "force"    # Z

    .line 340
    move-object/from16 v0, p0

    move/from16 v1, p1

    move/from16 v2, p2

    iget v3, v0, Landroid/support/v4/view/PagerTitleStrip;->mLastKnownCurrentPage:I

    if-eq v1, v3, :cond_0

    .line 341
    iget-object v3, v0, Landroid/support/v4/view/PagerTitleStrip;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v3}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Landroid/support/v4/view/PagerTitleStrip;->updateText(ILandroid/support/v4/view/PagerAdapter;)V

    goto :goto_0

    .line 342
    :cond_0
    if-nez p3, :cond_1

    iget v3, v0, Landroid/support/v4/view/PagerTitleStrip;->mLastKnownPositionOffset:F

    cmpl-float v3, v2, v3

    if-nez v3, :cond_1

    .line 343
    return-void

    .line 342
    :cond_1
    nop

    .line 346
    :goto_0
    const/4 v3, 0x1

    iput-boolean v3, v0, Landroid/support/v4/view/PagerTitleStrip;->mUpdatingPositions:Z

    .line 348
    iget-object v3, v0, Landroid/support/v4/view/PagerTitleStrip;->mPrevText:Landroid/widget/TextView;

    invoke-virtual {v3}, Landroid/widget/TextView;->getMeasuredWidth()I

    move-result v3

    .line 349
    .local v3, "prevWidth":I
    iget-object v4, v0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getMeasuredWidth()I

    move-result v4

    .line 350
    .local v4, "currWidth":I
    iget-object v5, v0, Landroid/support/v4/view/PagerTitleStrip;->mNextText:Landroid/widget/TextView;

    invoke-virtual {v5}, Landroid/widget/TextView;->getMeasuredWidth()I

    move-result v5

    .line 351
    .local v5, "nextWidth":I
    div-int/lit8 v6, v4, 0x2

    .line 353
    .local v6, "halfCurrWidth":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/PagerTitleStrip;->getWidth()I

    move-result v7

    .line 354
    .local v7, "stripWidth":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/PagerTitleStrip;->getHeight()I

    move-result v8

    .line 355
    .local v8, "stripHeight":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/PagerTitleStrip;->getPaddingLeft()I

    move-result v9

    .line 356
    .local v9, "paddingLeft":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/PagerTitleStrip;->getPaddingRight()I

    move-result v10

    .line 357
    .local v10, "paddingRight":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/PagerTitleStrip;->getPaddingTop()I

    move-result v11

    .line 358
    .local v11, "paddingTop":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/PagerTitleStrip;->getPaddingBottom()I

    move-result v12

    .line 359
    .local v12, "paddingBottom":I
    add-int v13, v9, v6

    .line 360
    .local v13, "textPaddedLeft":I
    add-int v14, v10, v6

    .line 361
    .local v14, "textPaddedRight":I
    sub-int v15, v7, v13

    sub-int/2addr v15, v14

    .line 363
    .local v15, "contentWidth":I
    const/high16 v16, 0x3f000000    # 0.5f

    add-float v16, v2, v16

    .line 364
    .local v16, "currOffset":F
    const/high16 v17, 0x3f800000    # 1.0f

    cmpl-float v18, v16, v17

    if-lez v18, :cond_2

    .line 365
    sub-float v16, v16, v17

    goto :goto_1

    .line 364
    :cond_2
    nop

    .line 367
    :goto_1
    sub-int v17, v7, v14

    int-to-float v1, v15

    mul-float v1, v1, v16

    float-to-int v1, v1

    sub-int v17, v17, v1

    .line 368
    .local v17, "currCenter":I
    div-int/lit8 v1, v4, 0x2

    sub-int v1, v17, v1

    .line 369
    .local v1, "currLeft":I
    move/from16 v18, v6

    .end local v6    # "halfCurrWidth":I
    .local v18, "halfCurrWidth":I
    add-int v6, v1, v4

    .line 371
    .local v6, "currRight":I
    move/from16 v19, v4

    .end local v4    # "currWidth":I
    .local v19, "currWidth":I
    iget-object v4, v0, Landroid/support/v4/view/PagerTitleStrip;->mPrevText:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getBaseline()I

    move-result v4

    .line 372
    .local v4, "prevBaseline":I
    move/from16 v20, v13

    .end local v13    # "textPaddedLeft":I
    .local v20, "textPaddedLeft":I
    iget-object v13, v0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    invoke-virtual {v13}, Landroid/widget/TextView;->getBaseline()I

    move-result v13

    .line 373
    .local v13, "currBaseline":I
    move/from16 v21, v14

    .end local v14    # "textPaddedRight":I
    .local v21, "textPaddedRight":I
    iget-object v14, v0, Landroid/support/v4/view/PagerTitleStrip;->mNextText:Landroid/widget/TextView;

    invoke-virtual {v14}, Landroid/widget/TextView;->getBaseline()I

    move-result v14

    .line 374
    .local v14, "nextBaseline":I
    move/from16 v22, v15

    .end local v15    # "contentWidth":I
    .local v22, "contentWidth":I
    invoke-static {v4, v13}, Ljava/lang/Math;->max(II)I

    move-result v15

    invoke-static {v15, v14}, Ljava/lang/Math;->max(II)I

    move-result v15

    .line 375
    .local v15, "maxBaseline":I
    sub-int v23, v15, v4

    .line 376
    .local v23, "prevTopOffset":I
    sub-int v24, v15, v13

    .line 377
    .local v24, "currTopOffset":I
    sub-int v25, v15, v14

    .line 378
    .local v25, "nextTopOffset":I
    move/from16 v26, v4

    .end local v4    # "prevBaseline":I
    .local v26, "prevBaseline":I
    iget-object v4, v0, Landroid/support/v4/view/PagerTitleStrip;->mPrevText:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getMeasuredHeight()I

    move-result v4

    add-int v4, v23, v4

    .line 379
    .local v4, "alignedPrevHeight":I
    move/from16 v27, v13

    .end local v13    # "currBaseline":I
    .local v27, "currBaseline":I
    iget-object v13, v0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    invoke-virtual {v13}, Landroid/widget/TextView;->getMeasuredHeight()I

    move-result v13

    add-int v13, v24, v13

    .line 380
    .local v13, "alignedCurrHeight":I
    move/from16 v28, v14

    .end local v14    # "nextBaseline":I
    .local v28, "nextBaseline":I
    iget-object v14, v0, Landroid/support/v4/view/PagerTitleStrip;->mNextText:Landroid/widget/TextView;

    invoke-virtual {v14}, Landroid/widget/TextView;->getMeasuredHeight()I

    move-result v14

    add-int v14, v25, v14

    .line 381
    .local v14, "alignedNextHeight":I
    move/from16 v29, v15

    .end local v15    # "maxBaseline":I
    .local v29, "maxBaseline":I
    invoke-static {v4, v13}, Ljava/lang/Math;->max(II)I

    move-result v15

    invoke-static {v15, v14}, Ljava/lang/Math;->max(II)I

    move-result v15

    .line 384
    .local v15, "maxTextHeight":I
    move/from16 v30, v4

    .end local v4    # "alignedPrevHeight":I
    .local v30, "alignedPrevHeight":I
    iget v4, v0, Landroid/support/v4/view/PagerTitleStrip;->mGravity:I

    and-int/lit8 v4, v4, 0x70

    .line 389
    .local v4, "vgrav":I
    move/from16 v31, v13

    .end local v13    # "alignedCurrHeight":I
    .local v31, "alignedCurrHeight":I
    const/16 v13, 0x10

    move/from16 v32, v14

    .end local v14    # "alignedNextHeight":I
    .local v32, "alignedNextHeight":I
    const/4 v14, 0x0

    if-eq v4, v13, :cond_4

    const/16 v13, 0x50

    if-eq v4, v13, :cond_3

    .line 392
    add-int v13, v11, v23

    .line 393
    .local v13, "prevTop":I
    add-int v33, v11, v24

    .line 394
    .local v33, "currTop":I
    add-int v34, v11, v25

    .line 395
    .local v34, "nextTop":I
    move v14, v13

    move/from16 v13, v33

    move/from16 v41, v34

    move/from16 v34, v4

    move/from16 v4, v41

    goto :goto_2

    .line 389
    .end local v13    # "prevTop":I
    .end local v33    # "currTop":I
    .end local v34    # "nextTop":I
    :cond_3
    move v13, v14

    .local v13, "paddedHeight":I
    move/from16 v33, v14

    .local v33, "centeredTop":I
    move/from16 v34, v14

    .local v34, "prevTop":I
    move/from16 v35, v14

    .local v35, "currTop":I
    move/from16 v36, v14

    .line 404
    .local v36, "nextTop":I
    sub-int v37, v8, v12

    sub-int v37, v37, v15

    .line 405
    .local v37, "bottomGravTop":I
    add-int v34, v37, v23

    .line 406
    add-int v35, v37, v24

    .line 407
    add-int v36, v37, v25

    move/from16 v14, v34

    move/from16 v13, v35

    move/from16 v34, v4

    move/from16 v4, v36

    goto :goto_2

    .line 389
    .end local v13    # "paddedHeight":I
    .end local v33    # "centeredTop":I
    .end local v34    # "prevTop":I
    .end local v35    # "currTop":I
    .end local v36    # "nextTop":I
    .end local v37    # "bottomGravTop":I
    :cond_4
    move v13, v14

    .local v13, "prevTop":I
    move/from16 v33, v14

    .local v33, "currTop":I
    move/from16 v34, v14

    .line 397
    .local v34, "nextTop":I
    sub-int v35, v8, v11

    sub-int v35, v35, v12

    .line 398
    .local v35, "paddedHeight":I
    sub-int v36, v35, v15

    div-int/lit8 v36, v36, 0x2

    .line 399
    .local v36, "centeredTop":I
    add-int v13, v36, v23

    .line 400
    add-int v33, v36, v24

    .line 401
    add-int v34, v36, v25

    .line 402
    move v14, v13

    move/from16 v13, v33

    move/from16 v41, v34

    move/from16 v34, v4

    move/from16 v4, v41

    .line 411
    .end local v33    # "currTop":I
    .end local v35    # "paddedHeight":I
    .end local v36    # "centeredTop":I
    .local v4, "nextTop":I
    .local v13, "currTop":I
    .local v14, "prevTop":I
    .local v34, "vgrav":I
    :goto_2
    move/from16 v35, v8

    .end local v8    # "stripHeight":I
    .local v35, "stripHeight":I
    iget-object v8, v0, Landroid/support/v4/view/PagerTitleStrip;->mCurrText:Landroid/widget/TextView;

    .line 412
    invoke-virtual {v8}, Landroid/widget/TextView;->getMeasuredHeight()I

    move-result v36

    move/from16 v37, v11

    .end local v11    # "paddingTop":I
    .local v37, "paddingTop":I
    add-int v11, v13, v36

    .line 411
    invoke-virtual {v8, v1, v13, v6, v11}, Landroid/widget/TextView;->layout(IIII)V

    .line 414
    iget v8, v0, Landroid/support/v4/view/PagerTitleStrip;->mScaledTextSpacing:I

    sub-int v8, v1, v8

    sub-int/2addr v8, v3

    invoke-static {v9, v8}, Ljava/lang/Math;->min(II)I

    move-result v8

    .line 415
    .local v8, "prevLeft":I
    iget-object v11, v0, Landroid/support/v4/view/PagerTitleStrip;->mPrevText:Landroid/widget/TextView;

    move/from16 v36, v1

    .end local v1    # "currLeft":I
    .local v36, "currLeft":I
    add-int v1, v8, v3

    .line 416
    invoke-virtual {v11}, Landroid/widget/TextView;->getMeasuredHeight()I

    move-result v38

    move/from16 v39, v3

    .end local v3    # "prevWidth":I
    .local v39, "prevWidth":I
    add-int v3, v14, v38

    .line 415
    invoke-virtual {v11, v8, v14, v1, v3}, Landroid/widget/TextView;->layout(IIII)V

    .line 418
    sub-int v1, v7, v10

    sub-int/2addr v1, v5

    iget v3, v0, Landroid/support/v4/view/PagerTitleStrip;->mScaledTextSpacing:I

    add-int/2addr v3, v6

    invoke-static {v1, v3}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 420
    .local v1, "nextLeft":I
    iget-object v3, v0, Landroid/support/v4/view/PagerTitleStrip;->mNextText:Landroid/widget/TextView;

    add-int v11, v1, v5

    .line 421
    invoke-virtual {v3}, Landroid/widget/TextView;->getMeasuredHeight()I

    move-result v38

    move/from16 v40, v5

    .end local v5    # "nextWidth":I
    .local v40, "nextWidth":I
    add-int v5, v4, v38

    .line 420
    invoke-virtual {v3, v1, v4, v11, v5}, Landroid/widget/TextView;->layout(IIII)V

    .line 423
    iput v2, v0, Landroid/support/v4/view/PagerTitleStrip;->mLastKnownPositionOffset:F

    .line 424
    const/4 v3, 0x0

    iput-boolean v3, v0, Landroid/support/v4/view/PagerTitleStrip;->mUpdatingPositions:Z

    .line 425
    return-void
.end method
