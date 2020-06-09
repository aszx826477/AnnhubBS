.class public Landroid/support/v7/app/AlertController$RecycleListView;
.super Landroid/widget/ListView;
.source "AlertController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/app/AlertController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RecycleListView"
.end annotation


# instance fields
.field private final mPaddingBottomNoButtons:I

.field private final mPaddingTopNoTitle:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 821
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v7/app/AlertController$RecycleListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 822
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .line 825
    invoke-direct {p0, p1, p2}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 827
    sget-object v0, Landroid/support/v7/appcompat/R$styleable;->RecycleListView:[I

    invoke-virtual {p1, p2, v0}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 829
    .local v0, "ta":Landroid/content/res/TypedArray;
    sget v1, Landroid/support/v7/appcompat/R$styleable;->RecycleListView_paddingBottomNoButtons:I

    const/4 v2, -0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result v1

    iput v1, p0, Landroid/support/v7/app/AlertController$RecycleListView;->mPaddingBottomNoButtons:I

    .line 831
    sget v1, Landroid/support/v7/appcompat/R$styleable;->RecycleListView_paddingTopNoTitle:I

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result v1

    iput v1, p0, Landroid/support/v7/app/AlertController$RecycleListView;->mPaddingTopNoTitle:I

    .line 833
    return-void
.end method


# virtual methods
.method public setHasDecor(ZZ)V
    .locals 4
    .param p1, "hasTitle"    # Z
    .param p2, "hasButtons"    # Z

    .line 836
    if-eqz p2, :cond_1

    if-nez p1, :cond_0

    goto :goto_0

    :cond_0
    goto :goto_3

    .line 837
    :cond_1
    :goto_0
    invoke-virtual {p0}, Landroid/support/v7/app/AlertController$RecycleListView;->getPaddingLeft()I

    move-result v0

    .line 838
    .local v0, "paddingLeft":I
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Landroid/support/v7/app/AlertController$RecycleListView;->getPaddingTop()I

    move-result v1

    goto :goto_1

    :cond_2
    iget v1, p0, Landroid/support/v7/app/AlertController$RecycleListView;->mPaddingTopNoTitle:I

    .line 839
    .local v1, "paddingTop":I
    :goto_1
    invoke-virtual {p0}, Landroid/support/v7/app/AlertController$RecycleListView;->getPaddingRight()I

    move-result v2

    .line 840
    .local v2, "paddingRight":I
    if-eqz p2, :cond_3

    invoke-virtual {p0}, Landroid/support/v7/app/AlertController$RecycleListView;->getPaddingBottom()I

    move-result v3

    goto :goto_2

    :cond_3
    iget v3, p0, Landroid/support/v7/app/AlertController$RecycleListView;->mPaddingBottomNoButtons:I

    .line 841
    .local v3, "paddingBottom":I
    :goto_2
    invoke-virtual {p0, v0, v1, v2, v3}, Landroid/support/v7/app/AlertController$RecycleListView;->setPadding(IIII)V

    .line 843
    .end local v0    # "paddingLeft":I
    .end local v1    # "paddingTop":I
    .end local v2    # "paddingRight":I
    .end local v3    # "paddingBottom":I
    :goto_3
    return-void
.end method
