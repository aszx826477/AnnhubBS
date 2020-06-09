.class Landroid/support/v4/view/KeyEventCompat$BaseKeyEventVersionImpl;
.super Ljava/lang/Object;
.source "KeyEventCompat.java"

# interfaces
.implements Landroid/support/v4/view/KeyEventCompat$KeyEventVersionImpl;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/view/KeyEventCompat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "BaseKeyEventVersionImpl"
.end annotation


# static fields
.field private static final META_ALL_MASK:I = 0xf7

.field private static final META_MODIFIER_MASK:I = 0xf7


# direct methods
.method constructor <init>()V
    .locals 0

    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static metaStateFilterDirectionalModifiers(IIIII)I
    .locals 5
    .param p0, "metaState"    # I
    .param p1, "modifiers"    # I
    .param p2, "basic"    # I
    .param p3, "left"    # I
    .param p4, "right"    # I

    .line 51
    and-int v0, p1, p2

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 52
    .local v0, "wantBasic":Z
    :goto_0
    or-int v3, p3, p4

    .line 53
    .local v3, "directional":I
    and-int v4, p1, v3

    if-eqz v4, :cond_1

    goto :goto_1

    :cond_1
    const/4 v1, 0x0

    .line 55
    .local v1, "wantLeftOrRight":Z
    :goto_1
    if-eqz v0, :cond_3

    .line 56
    if-nez v1, :cond_2

    .line 59
    xor-int/lit8 v2, v3, -0x1

    and-int/2addr v2, p0

    return v2

    .line 57
    :cond_2
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v4, "bad arguments"

    invoke-direct {v2, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 60
    :cond_3
    if-eqz v1, :cond_4

    .line 61
    xor-int/lit8 v2, p2, -0x1

    and-int/2addr v2, p0

    return v2

    .line 63
    :cond_4
    return p0
.end method


# virtual methods
.method public isCtrlPressed(Landroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/KeyEvent;

    .line 95
    const/4 v0, 0x0

    return v0
.end method

.method public metaStateHasModifiers(II)Z
    .locals 4
    .param p1, "metaState"    # I
    .param p2, "modifiers"    # I

    .line 80
    invoke-virtual {p0, p1}, Landroid/support/v4/view/KeyEventCompat$BaseKeyEventVersionImpl;->normalizeMetaState(I)I

    move-result v0

    and-int/lit16 p1, v0, 0xf7

    .line 81
    const/4 v0, 0x1

    const/16 v1, 0x40

    const/16 v2, 0x80

    invoke-static {p1, p2, v0, v1, v2}, Landroid/support/v4/view/KeyEventCompat$BaseKeyEventVersionImpl;->metaStateFilterDirectionalModifiers(IIIII)I

    move-result p1

    .line 83
    const/4 v1, 0x2

    const/16 v2, 0x10

    const/16 v3, 0x20

    invoke-static {p1, p2, v1, v2, v3}, Landroid/support/v4/view/KeyEventCompat$BaseKeyEventVersionImpl;->metaStateFilterDirectionalModifiers(IIIII)I

    move-result p1

    .line 85
    if-ne p1, p2, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public metaStateHasNoModifiers(I)Z
    .locals 1
    .param p1, "metaState"    # I

    .line 90
    invoke-virtual {p0, p1}, Landroid/support/v4/view/KeyEventCompat$BaseKeyEventVersionImpl;->normalizeMetaState(I)I

    move-result v0

    and-int/lit16 v0, v0, 0xf7

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public normalizeMetaState(I)I
    .locals 1
    .param p1, "metaState"    # I

    .line 69
    and-int/lit16 v0, p1, 0xc0

    if-eqz v0, :cond_0

    .line 70
    or-int/lit8 p1, p1, 0x1

    goto :goto_0

    .line 69
    :cond_0
    nop

    .line 72
    :goto_0
    and-int/lit8 v0, p1, 0x30

    if-eqz v0, :cond_1

    .line 73
    or-int/lit8 p1, p1, 0x2

    goto :goto_1

    .line 72
    :cond_1
    nop

    .line 75
    :goto_1
    and-int/lit16 v0, p1, 0xf7

    return v0
.end method
