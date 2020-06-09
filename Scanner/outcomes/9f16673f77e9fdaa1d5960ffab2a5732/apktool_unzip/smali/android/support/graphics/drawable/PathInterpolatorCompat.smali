.class public Landroid/support/graphics/drawable/PathInterpolatorCompat;
.super Ljava/lang/Object;
.source "PathInterpolatorCompat.java"

# interfaces
.implements Landroid/view/animation/Interpolator;


# annotations
.annotation build Landroid/support/annotation/RestrictTo;
    value = {
        .enum Landroid/support/annotation/RestrictTo$Scope;->LIBRARY_GROUP:Landroid/support/annotation/RestrictTo$Scope;
    }
.end annotation


# static fields
.field public static final EPSILON:D = 1.0E-5

.field public static final MAX_NUM_POINTS:I = 0xbb8

.field private static final PRECISION:F = 0.002f


# instance fields
.field private mX:[F

.field private mY:[F


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;Lorg/xmlpull/v1/XmlPullParser;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "parser"    # Lorg/xmlpull/v1/XmlPullParser;

    .line 65
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v1

    invoke-direct {p0, v0, v1, p2, p3}, Landroid/support/graphics/drawable/PathInterpolatorCompat;-><init>(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;Lorg/xmlpull/v1/XmlPullParser;)V

    .line 66
    return-void
.end method

.method public constructor <init>(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;Lorg/xmlpull/v1/XmlPullParser;)V
    .locals 1
    .param p1, "res"    # Landroid/content/res/Resources;
    .param p2, "theme"    # Landroid/content/res/Resources$Theme;
    .param p3, "attrs"    # Landroid/util/AttributeSet;
    .param p4, "parser"    # Lorg/xmlpull/v1/XmlPullParser;

    .line 69
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 70
    sget-object v0, Landroid/support/graphics/drawable/AndroidResources;->STYLEABLE_PATH_INTERPOLATOR:[I

    invoke-static {p1, p2, p3, v0}, Landroid/support/graphics/drawable/TypedArrayUtils;->obtainAttributes(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 72
    .local v0, "a":Landroid/content/res/TypedArray;
    invoke-direct {p0, v0, p4}, Landroid/support/graphics/drawable/PathInterpolatorCompat;->parseInterpolatorFromTypeArray(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;)V

    .line 73
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 74
    return-void
.end method

.method private initCubic(FFFF)V
    .locals 8
    .param p1, "x1"    # F
    .param p2, "y1"    # F
    .param p3, "x2"    # F
    .param p4, "y2"    # F

    .line 127
    new-instance v0, Landroid/graphics/Path;

    invoke-direct {v0}, Landroid/graphics/Path;-><init>()V

    .line 128
    .local v0, "path":Landroid/graphics/Path;
    const/4 v1, 0x0

    invoke-virtual {v0, v1, v1}, Landroid/graphics/Path;->moveTo(FF)V

    .line 129
    const/high16 v6, 0x3f800000    # 1.0f

    const/high16 v7, 0x3f800000    # 1.0f

    move-object v1, v0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-virtual/range {v1 .. v7}, Landroid/graphics/Path;->cubicTo(FFFFFF)V

    .line 130
    invoke-direct {p0, v0}, Landroid/support/graphics/drawable/PathInterpolatorCompat;->initPath(Landroid/graphics/Path;)V

    .line 131
    return-void
.end method

.method private initPath(Landroid/graphics/Path;)V
    .locals 12
    .param p1, "path"    # Landroid/graphics/Path;

    .line 134
    new-instance v0, Landroid/graphics/PathMeasure;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Landroid/graphics/PathMeasure;-><init>(Landroid/graphics/Path;Z)V

    .line 136
    .local v0, "pathMeasure":Landroid/graphics/PathMeasure;
    invoke-virtual {v0}, Landroid/graphics/PathMeasure;->getLength()F

    move-result v2

    .line 137
    .local v2, "pathLength":F
    const v3, 0x3b03126f    # 0.002f

    div-float v3, v2, v3

    float-to-int v3, v3

    const/4 v4, 0x1

    add-int/2addr v3, v4

    const/16 v5, 0xbb8

    invoke-static {v5, v3}, Ljava/lang/Math;->min(II)I

    move-result v3

    .line 139
    .local v3, "numPoints":I
    if-lez v3, :cond_6

    .line 143
    new-array v5, v3, [F

    iput-object v5, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mX:[F

    .line 144
    new-array v5, v3, [F

    iput-object v5, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mY:[F

    .line 146
    const/4 v5, 0x2

    new-array v5, v5, [F

    .line 147
    .local v5, "position":[F
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_0
    if-ge v6, v3, :cond_0

    .line 148
    int-to-float v7, v6

    mul-float v7, v7, v2

    add-int/lit8 v8, v3, -0x1

    int-to-float v8, v8

    div-float/2addr v7, v8

    .line 149
    .local v7, "distance":F
    const/4 v8, 0x0

    invoke-virtual {v0, v7, v5, v8}, Landroid/graphics/PathMeasure;->getPosTan(F[F[F)Z

    .line 151
    iget-object v8, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mX:[F

    aget v9, v5, v1

    aput v9, v8, v6

    .line 152
    iget-object v8, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mY:[F

    aget v9, v5, v4

    aput v9, v8, v6

    .line 147
    .end local v7    # "distance":F
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 155
    .end local v6    # "i":I
    :cond_0
    iget-object v4, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mX:[F

    aget v4, v4, v1

    invoke-static {v4}, Ljava/lang/Math;->abs(F)F

    move-result v4

    float-to-double v6, v4

    const-wide v8, 0x3ee4f8b588e368f1L    # 1.0E-5

    cmpl-double v4, v6, v8

    if-gtz v4, :cond_5

    iget-object v4, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mY:[F

    aget v4, v4, v1

    invoke-static {v4}, Ljava/lang/Math;->abs(F)F

    move-result v4

    float-to-double v6, v4

    cmpl-double v4, v6, v8

    if-gtz v4, :cond_5

    iget-object v4, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mX:[F

    add-int/lit8 v6, v3, -0x1

    aget v4, v4, v6

    const/high16 v6, 0x3f800000    # 1.0f

    sub-float/2addr v4, v6

    invoke-static {v4}, Ljava/lang/Math;->abs(F)F

    move-result v4

    float-to-double v10, v4

    cmpl-double v4, v10, v8

    if-gtz v4, :cond_5

    iget-object v4, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mY:[F

    add-int/lit8 v7, v3, -0x1

    aget v4, v4, v7

    sub-float/2addr v4, v6

    .line 156
    invoke-static {v4}, Ljava/lang/Math;->abs(F)F

    move-result v4

    float-to-double v6, v4

    cmpl-double v4, v6, v8

    if-gtz v4, :cond_4

    .line 163
    const/4 v1, 0x0

    .line 164
    .local v1, "prevX":F
    const/4 v4, 0x0

    .line 165
    .local v4, "componentIndex":I
    const/4 v6, 0x0

    .restart local v6    # "i":I
    :goto_1
    if-ge v6, v3, :cond_2

    .line 166
    iget-object v7, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mX:[F

    add-int/lit8 v8, v4, 0x1

    .end local v4    # "componentIndex":I
    .local v8, "componentIndex":I
    aget v4, v7, v4

    .line 167
    .local v4, "x":F
    cmpg-float v9, v4, v1

    if-ltz v9, :cond_1

    .line 170
    aput v4, v7, v6

    .line 171
    move v1, v4

    .line 165
    .end local v4    # "x":F
    add-int/lit8 v6, v6, 0x1

    move v4, v8

    goto :goto_1

    .line 168
    .restart local v4    # "x":F
    :cond_1
    new-instance v7, Ljava/lang/IllegalArgumentException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "The Path cannot loop back on itself, x :"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v9, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v7, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 165
    .end local v8    # "componentIndex":I
    .local v4, "componentIndex":I
    :cond_2
    nop

    .line 174
    .end local v6    # "i":I
    invoke-virtual {v0}, Landroid/graphics/PathMeasure;->nextContour()Z

    move-result v6

    if-nez v6, :cond_3

    .line 178
    return-void

    .line 175
    :cond_3
    new-instance v6, Ljava/lang/IllegalArgumentException;

    const-string v7, "The Path should be continuous, can\'t have 2+ contours"

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 156
    .end local v1    # "prevX":F
    .end local v4    # "componentIndex":I
    :cond_4
    goto :goto_2

    .line 155
    :cond_5
    nop

    .line 157
    :goto_2
    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "The Path must start at (0,0) and end at (1,1) start: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v7, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mX:[F

    aget v7, v7, v1

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v7, ","

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v7, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mY:[F

    aget v1, v7, v1

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v1, " end:"

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mX:[F

    add-int/lit8 v7, v3, -0x1

    aget v1, v1, v7

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v1, ","

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mY:[F

    add-int/lit8 v7, v3, -0x1

    aget v1, v1, v7

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v4, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 140
    .end local v5    # "position":[F
    :cond_6
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "The Path has a invalid length "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    return-void
.end method

.method private initQuad(FF)V
    .locals 2
    .param p1, "controlX"    # F
    .param p2, "controlY"    # F

    .line 120
    new-instance v0, Landroid/graphics/Path;

    invoke-direct {v0}, Landroid/graphics/Path;-><init>()V

    .line 121
    .local v0, "path":Landroid/graphics/Path;
    const/4 v1, 0x0

    invoke-virtual {v0, v1, v1}, Landroid/graphics/Path;->moveTo(FF)V

    .line 122
    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, p1, p2, v1, v1}, Landroid/graphics/Path;->quadTo(FFFF)V

    .line 123
    invoke-direct {p0, v0}, Landroid/support/graphics/drawable/PathInterpolatorCompat;->initPath(Landroid/graphics/Path;)V

    .line 124
    return-void
.end method

.method private parseInterpolatorFromTypeArray(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;)V
    .locals 8
    .param p1, "a"    # Landroid/content/res/TypedArray;
    .param p2, "parser"    # Lorg/xmlpull/v1/XmlPullParser;

    .line 79
    const-string v0, "pathData"

    invoke-static {p2, v0}, Landroid/support/graphics/drawable/TypedArrayUtils;->hasAttribute(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 80
    const-string v0, "pathData"

    const/4 v1, 0x4

    invoke-static {p1, p2, v0, v1}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedString(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    .line 82
    .local v0, "pathData":Ljava/lang/String;
    invoke-static {v0}, Landroid/support/graphics/drawable/PathParser;->createPathFromPathData(Ljava/lang/String;)Landroid/graphics/Path;

    move-result-object v1

    .line 83
    .local v1, "path":Landroid/graphics/Path;
    if-eqz v1, :cond_0

    .line 87
    invoke-direct {p0, v1}, Landroid/support/graphics/drawable/PathInterpolatorCompat;->initPath(Landroid/graphics/Path;)V

    .line 88
    .end local v0    # "pathData":Ljava/lang/String;
    .end local v1    # "path":Landroid/graphics/Path;
    goto :goto_0

    .line 84
    .restart local v0    # "pathData":Ljava/lang/String;
    .restart local v1    # "path":Landroid/graphics/Path;
    :cond_0
    new-instance v2, Landroid/view/InflateException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "The path is null, which is created from "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 89
    .end local v0    # "pathData":Ljava/lang/String;
    .end local v1    # "path":Landroid/graphics/Path;
    :cond_1
    const-string v0, "controlX1"

    invoke-static {p2, v0}, Landroid/support/graphics/drawable/TypedArrayUtils;->hasAttribute(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 91
    const-string v0, "controlY1"

    invoke-static {p2, v0}, Landroid/support/graphics/drawable/TypedArrayUtils;->hasAttribute(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 94
    const-string v0, "controlX1"

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-static {p1, p2, v0, v1, v2}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedFloat(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v0

    .line 96
    .local v0, "x1":F
    const-string v1, "controlY1"

    const/4 v3, 0x1

    invoke-static {p1, p2, v1, v3, v2}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedFloat(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v1

    .line 99
    .local v1, "y1":F
    const-string v3, "controlX2"

    invoke-static {p2, v3}, Landroid/support/graphics/drawable/TypedArrayUtils;->hasAttribute(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Z

    move-result v3

    .line 100
    .local v3, "hasX2":Z
    const-string v4, "controlY2"

    invoke-static {p2, v4}, Landroid/support/graphics/drawable/TypedArrayUtils;->hasAttribute(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Z

    move-result v4

    .line 102
    .local v4, "hasY2":Z
    if-ne v3, v4, :cond_3

    .line 107
    if-nez v3, :cond_2

    .line 108
    invoke-direct {p0, v0, v1}, Landroid/support/graphics/drawable/PathInterpolatorCompat;->initQuad(FF)V

    goto :goto_0

    .line 110
    :cond_2
    const-string v5, "controlX2"

    const/4 v6, 0x2

    invoke-static {p1, p2, v5, v6, v2}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedFloat(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v5

    .line 112
    .local v5, "x2":F
    const-string v6, "controlY2"

    const/4 v7, 0x3

    invoke-static {p1, p2, v6, v7, v2}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedFloat(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v2

    .line 114
    .local v2, "y2":F
    invoke-direct {p0, v0, v1, v5, v2}, Landroid/support/graphics/drawable/PathInterpolatorCompat;->initCubic(FFFF)V

    .line 117
    .end local v0    # "x1":F
    .end local v1    # "y1":F
    .end local v2    # "y2":F
    .end local v3    # "hasX2":Z
    .end local v4    # "hasY2":Z
    .end local v5    # "x2":F
    :goto_0
    return-void

    .line 103
    .restart local v0    # "x1":F
    .restart local v1    # "y1":F
    .restart local v3    # "hasX2":Z
    .restart local v4    # "hasY2":Z
    :cond_3
    new-instance v2, Landroid/view/InflateException;

    const-string v5, "pathInterpolator requires both controlX2 and controlY2 for cubic Beziers."

    invoke-direct {v2, v5}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 92
    .end local v0    # "x1":F
    .end local v1    # "y1":F
    .end local v3    # "hasX2":Z
    .end local v4    # "hasY2":Z
    :cond_4
    new-instance v0, Landroid/view/InflateException;

    const-string v1, "pathInterpolator requires the controlY1 attribute"

    invoke-direct {v0, v1}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 90
    :cond_5
    new-instance v0, Landroid/view/InflateException;

    const-string v1, "pathInterpolator requires the controlX1 attribute"

    invoke-direct {v0, v1}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public getInterpolation(F)F
    .locals 8
    .param p1, "t"    # F

    .line 192
    const/4 v0, 0x0

    cmpg-float v1, p1, v0

    if-gtz v1, :cond_0

    .line 193
    return v0

    .line 194
    :cond_0
    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v2, p1, v1

    if-ltz v2, :cond_1

    .line 195
    return v1

    .line 198
    :cond_1
    const/4 v1, 0x0

    .line 199
    .local v1, "startIndex":I
    iget-object v2, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mX:[F

    array-length v2, v2

    const/4 v3, 0x1

    sub-int/2addr v2, v3

    .line 201
    .local v2, "endIndex":I
    :goto_0
    sub-int v4, v2, v1

    if-le v4, v3, :cond_3

    .line 202
    add-int v4, v1, v2

    div-int/lit8 v4, v4, 0x2

    .line 203
    .local v4, "midIndex":I
    iget-object v5, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mX:[F

    aget v5, v5, v4

    cmpg-float v5, p1, v5

    if-gez v5, :cond_2

    .line 204
    move v2, v4

    goto :goto_1

    .line 206
    :cond_2
    move v1, v4

    .line 208
    .end local v4    # "midIndex":I
    :goto_1
    goto :goto_0

    .line 210
    :cond_3
    iget-object v3, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mX:[F

    aget v4, v3, v2

    aget v5, v3, v1

    sub-float/2addr v4, v5

    .line 211
    .local v4, "xRange":F
    cmpl-float v0, v4, v0

    if-nez v0, :cond_4

    .line 212
    iget-object v0, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mY:[F

    aget v0, v0, v1

    return v0

    .line 215
    :cond_4
    aget v0, v3, v1

    sub-float v0, p1, v0

    .line 216
    .local v0, "tInRange":F
    div-float v3, v0, v4

    .line 218
    .local v3, "fraction":F
    iget-object v5, p0, Landroid/support/graphics/drawable/PathInterpolatorCompat;->mY:[F

    aget v6, v5, v1

    .line 219
    .local v6, "startY":F
    aget v5, v5, v2

    .line 220
    .local v5, "endY":F
    sub-float v7, v5, v6

    mul-float v7, v7, v3

    add-float/2addr v7, v6

    return v7
.end method
