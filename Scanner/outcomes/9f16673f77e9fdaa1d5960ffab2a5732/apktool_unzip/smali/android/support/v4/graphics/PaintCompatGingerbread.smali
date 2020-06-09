.class Landroid/support/v4/graphics/PaintCompatGingerbread;
.super Ljava/lang/Object;
.source "PaintCompatGingerbread.java"


# annotations
.annotation build Landroid/support/annotation/RequiresApi;
    value = 0x9
.end annotation


# static fields
.field private static final TOFU_STRING:Ljava/lang/String; = "\udb3f\udffd"

.field private static final sRectThreadLocal:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal<",
            "Landroid/support/v4/util/Pair<",
            "Landroid/graphics/Rect;",
            "Landroid/graphics/Rect;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 30
    new-instance v0, Ljava/lang/ThreadLocal;

    invoke-direct {v0}, Ljava/lang/ThreadLocal;-><init>()V

    sput-object v0, Landroid/support/v4/graphics/PaintCompatGingerbread;->sRectThreadLocal:Ljava/lang/ThreadLocal;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static hasGlyph(Landroid/graphics/Paint;Ljava/lang/String;)Z
    .locals 9
    .param p0, "paint"    # Landroid/graphics/Paint;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p1, "string"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .line 33
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    .line 35
    .local v0, "length":I
    const/4 v1, 0x1

    const/4 v2, 0x0

    if-ne v0, v1, :cond_0

    invoke-virtual {p1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v3

    invoke-static {v3}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 37
    return v1

    .line 35
    :cond_0
    nop

    .line 40
    const-string v3, "\udb3f\udffd"

    invoke-virtual {p0, v3}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v3

    .line 41
    .local v3, "missingGlyphWidth":F
    invoke-virtual {p0, p1}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v4

    .line 43
    .local v4, "width":F
    const/4 v5, 0x0

    cmpl-float v5, v4, v5

    if-nez v5, :cond_1

    .line 45
    return v2

    .line 48
    :cond_1
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v5

    invoke-virtual {p1, v2, v5}, Ljava/lang/String;->codePointCount(II)I

    move-result v5

    if-le v5, v1, :cond_5

    .line 51
    const/high16 v5, 0x40000000    # 2.0f

    mul-float v5, v5, v3

    cmpl-float v5, v4, v5

    if-lez v5, :cond_2

    .line 52
    return v2

    .line 65
    :cond_2
    const/4 v5, 0x0

    .line 66
    .local v5, "sumWidth":F
    const/4 v6, 0x0

    .line 67
    .local v6, "i":I
    :goto_0
    if-ge v6, v0, :cond_3

    .line 68
    invoke-virtual {p1, v6}, Ljava/lang/String;->codePointAt(I)I

    move-result v7

    invoke-static {v7}, Ljava/lang/Character;->charCount(I)I

    move-result v7

    .line 69
    .local v7, "charCount":I
    add-int v8, v6, v7

    invoke-virtual {p0, p1, v6, v8}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;II)F

    move-result v8

    add-float/2addr v5, v8

    .line 70
    add-int/2addr v6, v7

    .line 71
    .end local v7    # "charCount":I
    goto :goto_0

    .line 72
    :cond_3
    cmpl-float v7, v4, v5

    if-ltz v7, :cond_4

    .line 73
    return v2

    .line 72
    :cond_4
    goto :goto_1

    .line 48
    .end local v5    # "sumWidth":F
    .end local v6    # "i":I
    :cond_5
    nop

    .line 77
    :goto_1
    cmpl-float v5, v4, v3

    if-eqz v5, :cond_6

    .line 79
    return v1

    .line 84
    :cond_6
    invoke-static {}, Landroid/support/v4/graphics/PaintCompatGingerbread;->obtainEmptyRects()Landroid/support/v4/util/Pair;

    move-result-object v5

    .line 85
    .local v5, "rects":Landroid/support/v4/util/Pair;, "Landroid/support/v4/util/Pair<Landroid/graphics/Rect;Landroid/graphics/Rect;>;"
    const-string v6, "\udb3f\udffd"

    const-string v7, "\udb3f\udffd"

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    iget-object v8, v5, Landroid/support/v4/util/Pair;->first:Ljava/lang/Object;

    check-cast v8, Landroid/graphics/Rect;

    invoke-virtual {p0, v6, v2, v7, v8}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    .line 86
    iget-object v6, v5, Landroid/support/v4/util/Pair;->second:Ljava/lang/Object;

    check-cast v6, Landroid/graphics/Rect;

    invoke-virtual {p0, p1, v2, v0, v6}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    .line 87
    iget-object v2, v5, Landroid/support/v4/util/Pair;->first:Ljava/lang/Object;

    check-cast v2, Landroid/graphics/Rect;

    iget-object v6, v5, Landroid/support/v4/util/Pair;->second:Ljava/lang/Object;

    invoke-virtual {v2, v6}, Landroid/graphics/Rect;->equals(Ljava/lang/Object;)Z

    move-result v2

    xor-int/2addr v1, v2

    return v1
.end method

.method private static obtainEmptyRects()Landroid/support/v4/util/Pair;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroid/support/v4/util/Pair<",
            "Landroid/graphics/Rect;",
            "Landroid/graphics/Rect;",
            ">;"
        }
    .end annotation

    .line 91
    sget-object v0, Landroid/support/v4/graphics/PaintCompatGingerbread;->sRectThreadLocal:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/util/Pair;

    .line 92
    .local v0, "rects":Landroid/support/v4/util/Pair;, "Landroid/support/v4/util/Pair<Landroid/graphics/Rect;Landroid/graphics/Rect;>;"
    if-nez v0, :cond_0

    .line 93
    new-instance v1, Landroid/support/v4/util/Pair;

    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2}, Landroid/graphics/Rect;-><init>()V

    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    invoke-direct {v1, v2, v3}, Landroid/support/v4/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    move-object v0, v1

    .line 94
    sget-object v1, Landroid/support/v4/graphics/PaintCompatGingerbread;->sRectThreadLocal:Ljava/lang/ThreadLocal;

    invoke-virtual {v1, v0}, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V

    goto :goto_0

    .line 96
    :cond_0
    iget-object v1, v0, Landroid/support/v4/util/Pair;->first:Ljava/lang/Object;

    check-cast v1, Landroid/graphics/Rect;

    invoke-virtual {v1}, Landroid/graphics/Rect;->setEmpty()V

    .line 97
    iget-object v1, v0, Landroid/support/v4/util/Pair;->second:Ljava/lang/Object;

    check-cast v1, Landroid/graphics/Rect;

    invoke-virtual {v1}, Landroid/graphics/Rect;->setEmpty()V

    .line 99
    :goto_0
    return-object v0
.end method
