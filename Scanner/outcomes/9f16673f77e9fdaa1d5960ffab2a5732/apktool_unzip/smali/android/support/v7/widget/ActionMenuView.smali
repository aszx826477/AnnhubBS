.class public Landroid/support/v7/widget/ActionMenuView;
.super Landroid/support/v7/widget/LinearLayoutCompat;
.source "ActionMenuView.java"

# interfaces
.implements Landroid/support/v7/view/menu/MenuBuilder$ItemInvoker;
.implements Landroid/support/v7/view/menu/MenuView;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/widget/ActionMenuView$LayoutParams;,
        Landroid/support/v7/widget/ActionMenuView$ActionMenuChildView;,
        Landroid/support/v7/widget/ActionMenuView$ActionMenuPresenterCallback;,
        Landroid/support/v7/widget/ActionMenuView$MenuBuilderCallback;,
        Landroid/support/v7/widget/ActionMenuView$OnMenuItemClickListener;
    }
.end annotation


# static fields
.field static final GENERATED_ITEM_PADDING:I = 0x4

.field static final MIN_CELL_SIZE:I = 0x38

.field private static final TAG:Ljava/lang/String; = "ActionMenuView"


# instance fields
.field private mActionMenuPresenterCallback:Landroid/support/v7/view/menu/MenuPresenter$Callback;

.field private mFormatItems:Z

.field private mFormatItemsWidth:I

.field private mGeneratedItemPadding:I

.field private mMenu:Landroid/support/v7/view/menu/MenuBuilder;

.field mMenuBuilderCallback:Landroid/support/v7/view/menu/MenuBuilder$Callback;

.field private mMinCellSize:I

.field mOnMenuItemClickListener:Landroid/support/v7/widget/ActionMenuView$OnMenuItemClickListener;

.field private mPopupContext:Landroid/content/Context;

.field private mPopupTheme:I

.field private mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

.field private mReserveOverflow:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 75
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v7/widget/ActionMenuView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 76
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .line 79
    invoke-direct {p0, p1, p2}, Landroid/support/v7/widget/LinearLayoutCompat;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 80
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/ActionMenuView;->setBaselineAligned(Z)V

    .line 81
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->density:F

    .line 82
    .local v1, "density":F
    const/high16 v2, 0x42600000    # 56.0f

    mul-float v2, v2, v1

    float-to-int v2, v2

    iput v2, p0, Landroid/support/v7/widget/ActionMenuView;->mMinCellSize:I

    .line 83
    const/high16 v2, 0x40800000    # 4.0f

    mul-float v2, v2, v1

    float-to-int v2, v2

    iput v2, p0, Landroid/support/v7/widget/ActionMenuView;->mGeneratedItemPadding:I

    .line 84
    iput-object p1, p0, Landroid/support/v7/widget/ActionMenuView;->mPopupContext:Landroid/content/Context;

    .line 85
    iput v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPopupTheme:I

    .line 86
    return-void
.end method

.method static measureChildForCells(Landroid/view/View;IIII)I
    .locals 15
    .param p0, "child"    # Landroid/view/View;
    .param p1, "cellSize"    # I
    .param p2, "cellsRemaining"    # I
    .param p3, "parentHeightMeasureSpec"    # I
    .param p4, "parentHeightPadding"    # I

    .line 403
    move-object v0, p0

    move/from16 v1, p2

    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    .line 405
    .local v2, "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    invoke-static/range {p3 .. p3}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v3

    sub-int v3, v3, p4

    .line 407
    .local v3, "childHeightSize":I
    invoke-static/range {p3 .. p3}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v4

    .line 408
    .local v4, "childHeightMode":I
    invoke-static {v3, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v5

    .line 410
    .local v5, "childHeightSpec":I
    instance-of v6, v0, Landroid/support/v7/view/menu/ActionMenuItemView;

    if-eqz v6, :cond_0

    move-object v6, v0

    check-cast v6, Landroid/support/v7/view/menu/ActionMenuItemView;

    goto :goto_0

    :cond_0
    const/4 v6, 0x0

    .line 412
    .local v6, "itemView":Landroid/support/v7/view/menu/ActionMenuItemView;
    :goto_0
    const/4 v7, 0x0

    const/4 v8, 0x1

    if-eqz v6, :cond_1

    invoke-virtual {v6}, Landroid/support/v7/view/menu/ActionMenuItemView;->hasText()Z

    move-result v9

    if-eqz v9, :cond_1

    const/4 v9, 0x1

    goto :goto_1

    :cond_1
    const/4 v9, 0x0

    .line 414
    .local v9, "hasText":Z
    :goto_1
    const/4 v10, 0x0

    .line 415
    .local v10, "cellsUsed":I
    if-lez v1, :cond_5

    const/4 v11, 0x2

    if-eqz v9, :cond_2

    if-lt v1, v11, :cond_5

    .line 416
    :cond_2
    mul-int v12, p1, v1

    const/high16 v13, -0x80000000

    invoke-static {v12, v13}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v12

    .line 418
    .local v12, "childWidthSpec":I
    invoke-virtual {p0, v12, v5}, Landroid/view/View;->measure(II)V

    .line 420
    invoke-virtual {p0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v13

    .line 421
    .local v13, "measuredWidth":I
    div-int v10, v13, p1

    .line 422
    rem-int v14, v13, p1

    if-eqz v14, :cond_3

    add-int/lit8 v10, v10, 0x1

    nop

    .line 423
    :cond_3
    if-eqz v9, :cond_4

    if-ge v10, v11, :cond_4

    const/4 v10, 0x2

    goto :goto_2

    :cond_4
    goto :goto_2

    .line 415
    .end local v12    # "childWidthSpec":I
    .end local v13    # "measuredWidth":I
    :cond_5
    nop

    .line 426
    :goto_2
    iget-boolean v11, v2, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->isOverflowButton:Z

    if-nez v11, :cond_6

    if-eqz v9, :cond_6

    const/4 v7, 0x1

    nop

    .line 427
    .local v7, "expandable":Z
    :cond_6
    iput-boolean v7, v2, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->expandable:Z

    .line 429
    iput v10, v2, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    .line 430
    mul-int v8, v10, p1

    .line 431
    .local v8, "targetWidth":I
    const/high16 v11, 0x40000000    # 2.0f

    invoke-static {v8, v11}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v11

    invoke-virtual {p0, v11, v5}, Landroid/view/View;->measure(II)V

    .line 433
    return v10
.end method

.method private onMeasureExactFormat(II)V
    .locals 38
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .line 177
    move-object/from16 v0, p0

    invoke-static/range {p2 .. p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    .line 178
    .local v1, "heightMode":I
    invoke-static/range {p1 .. p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v2

    .line 179
    .local v2, "widthSize":I
    invoke-static/range {p2 .. p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v3

    .line 181
    .local v3, "heightSize":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/ActionMenuView;->getPaddingLeft()I

    move-result v4

    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/ActionMenuView;->getPaddingRight()I

    move-result v5

    add-int/2addr v4, v5

    .line 182
    .local v4, "widthPadding":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/ActionMenuView;->getPaddingTop()I

    move-result v5

    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/ActionMenuView;->getPaddingBottom()I

    move-result v6

    add-int/2addr v5, v6

    .line 184
    .local v5, "heightPadding":I
    const/4 v6, -0x2

    move/from16 v7, p2

    invoke-static {v7, v5, v6}, Landroid/support/v7/widget/ActionMenuView;->getChildMeasureSpec(III)I

    move-result v6

    .line 187
    .local v6, "itemHeightSpec":I
    sub-int/2addr v2, v4

    .line 190
    iget v8, v0, Landroid/support/v7/widget/ActionMenuView;->mMinCellSize:I

    div-int v9, v2, v8

    .line 191
    .local v9, "cellCount":I
    rem-int v10, v2, v8

    .line 193
    .local v10, "cellSizeRemaining":I
    const/4 v11, 0x0

    if-nez v9, :cond_0

    .line 195
    invoke-virtual {v0, v2, v11}, Landroid/support/v7/widget/ActionMenuView;->setMeasuredDimension(II)V

    .line 196
    return-void

    .line 199
    :cond_0
    div-int v12, v10, v9

    add-int/2addr v8, v12

    .line 201
    .local v8, "cellSize":I
    move v12, v9

    .line 202
    .local v12, "cellsRemaining":I
    const/4 v13, 0x0

    .line 203
    .local v13, "maxChildHeight":I
    const/4 v14, 0x0

    .line 204
    .local v14, "maxCellsUsed":I
    const/4 v15, 0x0

    .line 205
    .local v15, "expandableItemCount":I
    const/16 v16, 0x0

    .line 206
    .local v16, "visibleItemCount":I
    const/16 v17, 0x0

    .line 209
    .local v17, "hasOverflow":Z
    const-wide/16 v18, 0x0

    .line 211
    .local v18, "smallestItemsAt":J
    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/ActionMenuView;->getChildCount()I

    move-result v11

    .line 212
    .local v11, "childCount":I
    const/16 v21, 0x0

    move-wide/from16 v36, v18

    move/from16 v18, v3

    move v3, v13

    move/from16 v13, v16

    move/from16 v16, v15

    move v15, v14

    move v14, v12

    move/from16 v12, v21

    move-wide/from16 v21, v36

    .local v3, "maxChildHeight":I
    .local v12, "i":I
    .local v13, "visibleItemCount":I
    .local v14, "cellsRemaining":I
    .local v15, "maxCellsUsed":I
    .local v16, "expandableItemCount":I
    .local v18, "heightSize":I
    .local v21, "smallestItemsAt":J
    :goto_0
    move/from16 v19, v4

    .end local v4    # "widthPadding":I
    .local v19, "widthPadding":I
    if-ge v12, v11, :cond_8

    .line 213
    invoke-virtual {v0, v12}, Landroid/support/v7/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    .line 214
    .local v4, "child":Landroid/view/View;
    invoke-virtual {v4}, Landroid/view/View;->getVisibility()I

    move-result v7

    move/from16 v24, v9

    .end local v9    # "cellCount":I
    .local v24, "cellCount":I
    const/16 v9, 0x8

    if-ne v7, v9, :cond_1

    move/from16 v27, v5

    move/from16 v25, v10

    goto/16 :goto_4

    .line 216
    :cond_1
    instance-of v7, v4, Landroid/support/v7/view/menu/ActionMenuItemView;

    .line 217
    .local v7, "isGeneratedItem":Z
    add-int/lit8 v13, v13, 0x1

    .line 219
    if-eqz v7, :cond_2

    .line 222
    iget v9, v0, Landroid/support/v7/widget/ActionMenuView;->mGeneratedItemPadding:I

    move/from16 v25, v10

    const/4 v10, 0x0

    .end local v10    # "cellSizeRemaining":I
    .local v25, "cellSizeRemaining":I
    invoke-virtual {v4, v9, v10, v9, v10}, Landroid/view/View;->setPadding(IIII)V

    goto :goto_1

    .line 219
    .end local v25    # "cellSizeRemaining":I
    .restart local v10    # "cellSizeRemaining":I
    :cond_2
    move/from16 v25, v10

    const/4 v10, 0x0

    .line 225
    .end local v10    # "cellSizeRemaining":I
    .restart local v25    # "cellSizeRemaining":I
    :goto_1
    invoke-virtual {v4}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v9

    check-cast v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    .line 226
    .local v9, "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    iput-boolean v10, v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->expanded:Z

    .line 227
    iput v10, v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->extraPixels:I

    .line 228
    iput v10, v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    .line 229
    iput-boolean v10, v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->expandable:Z

    .line 230
    iput v10, v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->leftMargin:I

    .line 231
    iput v10, v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->rightMargin:I

    .line 232
    if-eqz v7, :cond_3

    move-object v10, v4

    check-cast v10, Landroid/support/v7/view/menu/ActionMenuItemView;

    invoke-virtual {v10}, Landroid/support/v7/view/menu/ActionMenuItemView;->hasText()Z

    move-result v10

    if-eqz v10, :cond_3

    const/4 v10, 0x1

    goto :goto_2

    :cond_3
    const/4 v10, 0x0

    :goto_2
    iput-boolean v10, v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->preventEdgeOffset:Z

    .line 235
    iget-boolean v10, v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->isOverflowButton:Z

    if-eqz v10, :cond_4

    const/4 v10, 0x1

    goto :goto_3

    :cond_4
    move v10, v14

    .line 237
    .local v10, "cellsAvailable":I
    :goto_3
    move/from16 v26, v7

    .end local v7    # "isGeneratedItem":Z
    .local v26, "isGeneratedItem":Z
    invoke-static {v4, v8, v10, v6, v5}, Landroid/support/v7/widget/ActionMenuView;->measureChildForCells(Landroid/view/View;IIII)I

    move-result v7

    .line 240
    .local v7, "cellsUsed":I
    invoke-static {v15, v7}, Ljava/lang/Math;->max(II)I

    move-result v15

    .line 241
    move/from16 v27, v5

    .end local v5    # "heightPadding":I
    .local v27, "heightPadding":I
    iget-boolean v5, v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->expandable:Z

    if-eqz v5, :cond_5

    add-int/lit8 v16, v16, 0x1

    nop

    .line 242
    :cond_5
    iget-boolean v5, v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->isOverflowButton:Z

    if-eqz v5, :cond_6

    const/16 v17, 0x1

    nop

    .line 244
    :cond_6
    sub-int/2addr v14, v7

    .line 245
    invoke-virtual {v4}, Landroid/view/View;->getMeasuredHeight()I

    move-result v5

    invoke-static {v3, v5}, Ljava/lang/Math;->max(II)I

    move-result v3

    .line 246
    const/4 v5, 0x1

    if-ne v7, v5, :cond_7

    shl-int/2addr v5, v12

    move/from16 v28, v3

    move-object/from16 v23, v4

    .end local v3    # "maxChildHeight":I
    .end local v4    # "child":Landroid/view/View;
    .local v23, "child":Landroid/view/View;
    .local v28, "maxChildHeight":I
    int-to-long v3, v5

    or-long v3, v21, v3

    move-wide/from16 v21, v3

    move/from16 v3, v28

    goto :goto_4

    .end local v23    # "child":Landroid/view/View;
    .end local v28    # "maxChildHeight":I
    .restart local v3    # "maxChildHeight":I
    .restart local v4    # "child":Landroid/view/View;
    :cond_7
    move/from16 v28, v3

    move-object/from16 v23, v4

    .line 212
    .end local v4    # "child":Landroid/view/View;
    .end local v7    # "cellsUsed":I
    .end local v9    # "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    .end local v10    # "cellsAvailable":I
    .end local v26    # "isGeneratedItem":Z
    :goto_4
    add-int/lit8 v12, v12, 0x1

    move/from16 v4, v19

    move/from16 v9, v24

    move/from16 v10, v25

    move/from16 v5, v27

    move/from16 v7, p2

    goto/16 :goto_0

    .end local v24    # "cellCount":I
    .end local v25    # "cellSizeRemaining":I
    .end local v27    # "heightPadding":I
    .restart local v5    # "heightPadding":I
    .local v9, "cellCount":I
    .local v10, "cellSizeRemaining":I
    :cond_8
    move/from16 v27, v5

    move/from16 v24, v9

    move/from16 v25, v10

    .line 251
    .end local v5    # "heightPadding":I
    .end local v9    # "cellCount":I
    .end local v10    # "cellSizeRemaining":I
    .end local v12    # "i":I
    .restart local v24    # "cellCount":I
    .restart local v25    # "cellSizeRemaining":I
    .restart local v27    # "heightPadding":I
    const/4 v4, 0x2

    if-eqz v17, :cond_9

    if-ne v13, v4, :cond_9

    const/4 v5, 0x1

    goto :goto_5

    :cond_9
    const/4 v5, 0x0

    .line 256
    .local v5, "centerSingleExpandedItem":Z
    :goto_5
    const/4 v7, 0x0

    .line 257
    .local v7, "needsExpansion":Z
    :goto_6
    if-lez v16, :cond_13

    if-lez v14, :cond_13

    .line 258
    const v12, 0x7fffffff

    .line 259
    .local v12, "minCells":I
    const-wide/16 v28, 0x0

    .line 260
    .local v28, "minCellsAt":J
    const/16 v26, 0x0

    .line 261
    .local v26, "minCellsItemCount":I
    const/16 v30, 0x0

    move v9, v12

    move/from16 v4, v26

    move/from16 v12, v30

    .end local v26    # "minCellsItemCount":I
    .local v4, "minCellsItemCount":I
    .local v9, "minCells":I
    .local v12, "i":I
    :goto_7
    if-ge v12, v11, :cond_d

    .line 262
    invoke-virtual {v0, v12}, Landroid/support/v7/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v10

    .line 263
    .local v10, "child":Landroid/view/View;
    invoke-virtual {v10}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v32

    move/from16 v33, v7

    .end local v7    # "needsExpansion":Z
    .local v33, "needsExpansion":Z
    move-object/from16 v7, v32

    check-cast v7, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    .line 266
    .local v7, "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    move-object/from16 v32, v10

    .end local v10    # "child":Landroid/view/View;
    .local v32, "child":Landroid/view/View;
    iget-boolean v10, v7, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->expandable:Z

    if-nez v10, :cond_a

    move/from16 v34, v11

    goto :goto_8

    .line 269
    :cond_a
    iget v10, v7, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    if-ge v10, v9, :cond_b

    .line 270
    iget v9, v7, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    .line 271
    move/from16 v23, v9

    const/4 v10, 0x1

    .end local v9    # "minCells":I
    .local v23, "minCells":I
    shl-int v9, v10, v12

    move/from16 v34, v11

    .end local v11    # "childCount":I
    .local v34, "childCount":I
    int-to-long v10, v9

    .line 272
    .end local v28    # "minCellsAt":J
    .local v10, "minCellsAt":J
    const/4 v4, 0x1

    move-wide/from16 v28, v10

    move/from16 v9, v23

    goto :goto_8

    .line 273
    .end local v10    # "minCellsAt":J
    .end local v23    # "minCells":I
    .end local v34    # "childCount":I
    .restart local v9    # "minCells":I
    .restart local v11    # "childCount":I
    .restart local v28    # "minCellsAt":J
    :cond_b
    move/from16 v34, v11

    .end local v11    # "childCount":I
    .restart local v34    # "childCount":I
    iget v10, v7, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    if-ne v10, v9, :cond_c

    .line 274
    const/4 v10, 0x1

    shl-int v11, v10, v12

    int-to-long v10, v11

    or-long v10, v28, v10

    .line 275
    .end local v28    # "minCellsAt":J
    .restart local v10    # "minCellsAt":J
    add-int/lit8 v4, v4, 0x1

    move-wide/from16 v28, v10

    goto :goto_8

    .line 273
    .end local v10    # "minCellsAt":J
    .restart local v28    # "minCellsAt":J
    :cond_c
    nop

    .line 261
    .end local v7    # "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    .end local v32    # "child":Landroid/view/View;
    :goto_8
    add-int/lit8 v12, v12, 0x1

    move/from16 v7, v33

    move/from16 v11, v34

    goto :goto_7

    .end local v33    # "needsExpansion":Z
    .end local v34    # "childCount":I
    .local v7, "needsExpansion":Z
    .restart local v11    # "childCount":I
    :cond_d
    move/from16 v33, v7

    move/from16 v34, v11

    .line 280
    .end local v7    # "needsExpansion":Z
    .end local v11    # "childCount":I
    .end local v12    # "i":I
    .restart local v33    # "needsExpansion":Z
    .restart local v34    # "childCount":I
    or-long v21, v21, v28

    .line 282
    if-le v4, v14, :cond_e

    move/from16 v35, v3

    move/from16 v10, v34

    move/from16 v34, v2

    goto/16 :goto_c

    .line 285
    :cond_e
    add-int/lit8 v9, v9, 0x1

    .line 287
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_9
    move/from16 v10, v34

    .end local v34    # "childCount":I
    .local v10, "childCount":I
    if-ge v7, v10, :cond_12

    .line 288
    invoke-virtual {v0, v7}, Landroid/support/v7/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v11

    .line 289
    .local v11, "child":Landroid/view/View;
    invoke-virtual {v11}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v12

    check-cast v12, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    .line 290
    .local v12, "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    move/from16 v32, v4

    const/16 v23, 0x1

    .end local v4    # "minCellsItemCount":I
    .local v32, "minCellsItemCount":I
    shl-int v4, v23, v7

    move/from16 v34, v2

    move/from16 v35, v3

    .end local v2    # "widthSize":I
    .end local v3    # "maxChildHeight":I
    .local v34, "widthSize":I
    .local v35, "maxChildHeight":I
    int-to-long v2, v4

    and-long v2, v28, v2

    const-wide/16 v30, 0x0

    cmp-long v4, v2, v30

    if-nez v4, :cond_10

    .line 292
    iget v2, v12, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    if-ne v2, v9, :cond_f

    shl-int v2, v23, v7

    int-to-long v2, v2

    or-long v21, v21, v2

    goto :goto_b

    :cond_f
    goto :goto_b

    .line 296
    :cond_10
    if-eqz v5, :cond_11

    iget-boolean v2, v12, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->preventEdgeOffset:Z

    if-eqz v2, :cond_11

    const/4 v2, 0x1

    if-ne v14, v2, :cond_11

    .line 298
    iget v2, v0, Landroid/support/v7/widget/ActionMenuView;->mGeneratedItemPadding:I

    add-int v3, v2, v8

    const/4 v4, 0x0

    invoke-virtual {v11, v3, v4, v2, v4}, Landroid/view/View;->setPadding(IIII)V

    goto :goto_a

    .line 296
    :cond_11
    nop

    .line 300
    :goto_a
    iget v2, v12, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    const/4 v3, 0x1

    add-int/2addr v2, v3

    iput v2, v12, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    .line 301
    iput-boolean v3, v12, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->expanded:Z

    .line 302
    add-int/lit8 v14, v14, -0x1

    .line 287
    .end local v11    # "child":Landroid/view/View;
    .end local v12    # "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    :goto_b
    add-int/lit8 v7, v7, 0x1

    move/from16 v4, v32

    move/from16 v2, v34

    move/from16 v3, v35

    move/from16 v34, v10

    goto :goto_9

    .end local v32    # "minCellsItemCount":I
    .end local v34    # "widthSize":I
    .end local v35    # "maxChildHeight":I
    .restart local v2    # "widthSize":I
    .restart local v3    # "maxChildHeight":I
    .restart local v4    # "minCellsItemCount":I
    :cond_12
    move/from16 v34, v2

    move/from16 v35, v3

    move/from16 v32, v4

    .line 305
    .end local v2    # "widthSize":I
    .end local v3    # "maxChildHeight":I
    .end local v4    # "minCellsItemCount":I
    .end local v7    # "i":I
    .restart local v32    # "minCellsItemCount":I
    .restart local v34    # "widthSize":I
    .restart local v35    # "maxChildHeight":I
    const/4 v7, 0x1

    .line 306
    .end local v9    # "minCells":I
    .end local v28    # "minCellsAt":J
    .end local v32    # "minCellsItemCount":I
    .end local v33    # "needsExpansion":Z
    .local v7, "needsExpansion":Z
    move v11, v10

    const/4 v4, 0x2

    goto/16 :goto_6

    .line 257
    .end local v10    # "childCount":I
    .end local v34    # "widthSize":I
    .end local v35    # "maxChildHeight":I
    .restart local v2    # "widthSize":I
    .restart local v3    # "maxChildHeight":I
    .local v11, "childCount":I
    :cond_13
    move/from16 v34, v2

    move/from16 v35, v3

    move/from16 v33, v7

    move v10, v11

    .line 311
    .end local v2    # "widthSize":I
    .end local v3    # "maxChildHeight":I
    .end local v7    # "needsExpansion":Z
    .end local v11    # "childCount":I
    .restart local v10    # "childCount":I
    .restart local v33    # "needsExpansion":Z
    .restart local v34    # "widthSize":I
    .restart local v35    # "maxChildHeight":I
    :goto_c
    if-nez v17, :cond_14

    const/4 v2, 0x1

    if-ne v13, v2, :cond_14

    const/4 v2, 0x1

    goto :goto_d

    :cond_14
    const/4 v2, 0x0

    .line 312
    .local v2, "singleItem":Z
    :goto_d
    if-lez v14, :cond_23

    const-wide/16 v3, 0x0

    cmp-long v7, v21, v3

    if-eqz v7, :cond_23

    add-int/lit8 v3, v13, -0x1

    if-lt v14, v3, :cond_15

    if-nez v2, :cond_15

    const/4 v3, 0x1

    if-le v15, v3, :cond_23

    .line 314
    :cond_15
    invoke-static/range {v21 .. v22}, Ljava/lang/Long;->bitCount(J)I

    move-result v3

    int-to-float v3, v3

    .line 316
    .local v3, "expandCount":F
    if-nez v2, :cond_1a

    .line 318
    const-wide/16 v11, 0x1

    and-long v11, v21, v11

    const/high16 v4, 0x3f000000    # 0.5f

    const-wide/16 v28, 0x0

    cmp-long v7, v11, v28

    if-eqz v7, :cond_17

    .line 319
    const/4 v7, 0x0

    invoke-virtual {v0, v7}, Landroid/support/v7/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v9

    invoke-virtual {v9}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v9

    check-cast v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    .line 320
    .local v9, "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    iget-boolean v11, v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->preventEdgeOffset:Z

    if-nez v11, :cond_16

    sub-float/2addr v3, v4

    goto :goto_e

    :cond_16
    goto :goto_e

    .line 318
    .end local v9    # "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    :cond_17
    const/4 v7, 0x0

    .line 322
    :goto_e
    add-int/lit8 v11, v10, -0x1

    const/4 v9, 0x1

    shl-int v11, v9, v11

    int-to-long v11, v11

    and-long v11, v21, v11

    const-wide/16 v28, 0x0

    cmp-long v9, v11, v28

    if-eqz v9, :cond_19

    .line 323
    add-int/lit8 v11, v10, -0x1

    invoke-virtual {v0, v11}, Landroid/support/v7/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v9

    invoke-virtual {v9}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v9

    check-cast v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    .line 324
    .restart local v9    # "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    iget-boolean v11, v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->preventEdgeOffset:Z

    if-nez v11, :cond_18

    sub-float/2addr v3, v4

    goto :goto_f

    :cond_18
    goto :goto_f

    .line 322
    .end local v9    # "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    :cond_19
    goto :goto_f

    .line 316
    :cond_1a
    const/4 v7, 0x0

    .line 328
    :goto_f
    const/4 v4, 0x0

    cmpl-float v4, v3, v4

    if-lez v4, :cond_1b

    mul-int v4, v14, v8

    int-to-float v4, v4

    div-float/2addr v4, v3

    float-to-int v11, v4

    move v7, v11

    nop

    :cond_1b
    move v4, v7

    .line 331
    .local v4, "extraPixels":I
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_10
    if-ge v7, v10, :cond_22

    .line 332
    const/4 v9, 0x1

    shl-int v11, v9, v7

    int-to-long v11, v11

    and-long v11, v21, v11

    const-wide/16 v28, 0x0

    cmp-long v9, v11, v28

    if-nez v9, :cond_1c

    const/16 v20, 0x2

    goto :goto_13

    .line 334
    :cond_1c
    invoke-virtual {v0, v7}, Landroid/support/v7/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v9

    .line 335
    .local v9, "child":Landroid/view/View;
    invoke-virtual {v9}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v11

    check-cast v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    .line 336
    .local v11, "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    instance-of v12, v9, Landroid/support/v7/view/menu/ActionMenuItemView;

    if-eqz v12, :cond_1e

    .line 338
    iput v4, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->extraPixels:I

    .line 339
    const/4 v12, 0x1

    iput-boolean v12, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->expanded:Z

    .line 340
    if-nez v7, :cond_1d

    iget-boolean v12, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->preventEdgeOffset:Z

    if-nez v12, :cond_1d

    .line 343
    neg-int v12, v4

    const/16 v20, 0x2

    div-int/lit8 v12, v12, 0x2

    iput v12, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->leftMargin:I

    goto :goto_11

    .line 340
    :cond_1d
    nop

    .line 345
    :goto_11
    const/16 v33, 0x1

    const/16 v20, 0x2

    goto :goto_13

    .line 346
    :cond_1e
    iget-boolean v12, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->isOverflowButton:Z

    if-eqz v12, :cond_1f

    .line 347
    iput v4, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->extraPixels:I

    .line 348
    const/4 v12, 0x1

    iput-boolean v12, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->expanded:Z

    .line 349
    neg-int v12, v4

    const/16 v20, 0x2

    div-int/lit8 v12, v12, 0x2

    iput v12, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->rightMargin:I

    .line 350
    const/16 v33, 0x1

    goto :goto_13

    .line 355
    :cond_1f
    const/16 v20, 0x2

    if-eqz v7, :cond_20

    .line 356
    div-int/lit8 v12, v4, 0x2

    iput v12, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->leftMargin:I

    goto :goto_12

    .line 355
    :cond_20
    nop

    .line 358
    :goto_12
    add-int/lit8 v12, v10, -0x1

    if-eq v7, v12, :cond_21

    .line 359
    div-int/lit8 v12, v4, 0x2

    iput v12, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->rightMargin:I

    goto :goto_13

    .line 358
    :cond_21
    nop

    .line 331
    .end local v9    # "child":Landroid/view/View;
    .end local v11    # "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    :goto_13
    add-int/lit8 v7, v7, 0x1

    goto :goto_10

    .line 364
    .end local v7    # "i":I
    :cond_22
    const/4 v14, 0x0

    goto :goto_14

    .line 312
    .end local v3    # "expandCount":F
    .end local v4    # "extraPixels":I
    :cond_23
    nop

    .line 368
    :goto_14
    const/high16 v3, 0x40000000    # 2.0f

    if-eqz v33, :cond_26

    .line 369
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_15
    if-ge v4, v10, :cond_25

    .line 370
    invoke-virtual {v0, v4}, Landroid/support/v7/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v7

    .line 371
    .local v7, "child":Landroid/view/View;
    invoke-virtual {v7}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v9

    check-cast v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    .line 373
    .local v9, "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    iget-boolean v11, v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->expanded:Z

    if-nez v11, :cond_24

    goto :goto_16

    .line 375
    :cond_24
    iget v11, v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->cellsUsed:I

    mul-int v11, v11, v8

    iget v12, v9, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->extraPixels:I

    add-int/2addr v11, v12

    .line 376
    .local v11, "width":I
    invoke-static {v11, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v12

    invoke-virtual {v7, v12, v6}, Landroid/view/View;->measure(II)V

    .line 369
    .end local v7    # "child":Landroid/view/View;
    .end local v9    # "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    .end local v11    # "width":I
    :goto_16
    add-int/lit8 v4, v4, 0x1

    goto :goto_15

    :cond_25
    goto :goto_17

    .line 368
    .end local v4    # "i":I
    :cond_26
    nop

    .line 381
    :goto_17
    if-eq v1, v3, :cond_27

    .line 382
    move/from16 v3, v35

    goto :goto_18

    .line 381
    :cond_27
    move/from16 v3, v18

    .line 385
    .end local v18    # "heightSize":I
    .local v3, "heightSize":I
    :goto_18
    move/from16 v4, v34

    .end local v34    # "widthSize":I
    .local v4, "widthSize":I
    invoke-virtual {v0, v4, v3}, Landroid/support/v7/widget/ActionMenuView;->setMeasuredDimension(II)V

    .line 386
    return-void
.end method


# virtual methods
.method protected checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z
    .locals 1
    .param p1, "p"    # Landroid/view/ViewGroup$LayoutParams;

    .line 609
    if-eqz p1, :cond_0

    instance-of v0, p1, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public dismissPopupMenus()V
    .locals 1

    .line 719
    iget-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    if-eqz v0, :cond_0

    .line 720
    invoke-virtual {v0}, Landroid/support/v7/widget/ActionMenuPresenter;->dismissPopupMenus()Z

    goto :goto_0

    .line 719
    :cond_0
    nop

    .line 722
    :goto_0
    return-void
.end method

.method public dispatchPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/accessibility/AccessibilityEvent;

    .line 745
    const/4 v0, 0x0

    return v0
.end method

.method protected generateDefaultLayoutParams()Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    .locals 2

    .line 582
    new-instance v0, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    const/4 v1, -0x2

    invoke-direct {v0, v1, v1}, Landroid/support/v7/widget/ActionMenuView$LayoutParams;-><init>(II)V

    .line 584
    .local v0, "params":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    const/16 v1, 0x10

    iput v1, v0, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->gravity:I

    .line 585
    return-object v0
.end method

.method protected bridge synthetic generateDefaultLayoutParams()Landroid/support/v7/widget/LinearLayoutCompat$LayoutParams;
    .locals 1

    .line 47
    invoke-virtual {p0}, Landroid/support/v7/widget/ActionMenuView;->generateDefaultLayoutParams()Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .locals 1

    .line 47
    invoke-virtual {p0}, Landroid/support/v7/widget/ActionMenuView;->generateDefaultLayoutParams()Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method public generateLayoutParams(Landroid/util/AttributeSet;)Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    .locals 2
    .param p1, "attrs"    # Landroid/util/AttributeSet;

    .line 590
    new-instance v0, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    invoke-virtual {p0}, Landroid/support/v7/widget/ActionMenuView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Landroid/support/v7/widget/ActionMenuView$LayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method protected generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    .locals 2
    .param p1, "p"    # Landroid/view/ViewGroup$LayoutParams;

    .line 595
    if-eqz p1, :cond_2

    .line 596
    instance-of v0, p1, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    if-eqz v0, :cond_0

    new-instance v0, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    move-object v1, p1

    check-cast v1, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    invoke-direct {v0, v1}, Landroid/support/v7/widget/ActionMenuView$LayoutParams;-><init>(Landroid/support/v7/widget/ActionMenuView$LayoutParams;)V

    goto :goto_0

    :cond_0
    new-instance v0, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    invoke-direct {v0, p1}, Landroid/support/v7/widget/ActionMenuView$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    .line 599
    .local v0, "result":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    :goto_0
    iget v1, v0, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->gravity:I

    if-gtz v1, :cond_1

    .line 600
    const/16 v1, 0x10

    iput v1, v0, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->gravity:I

    goto :goto_1

    .line 599
    :cond_1
    nop

    .line 602
    :goto_1
    return-object v0

    .line 604
    .end local v0    # "result":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    :cond_2
    invoke-virtual {p0}, Landroid/support/v7/widget/ActionMenuView;->generateDefaultLayoutParams()Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic generateLayoutParams(Landroid/util/AttributeSet;)Landroid/support/v7/widget/LinearLayoutCompat$LayoutParams;
    .locals 0

    .line 47
    invoke-virtual {p0, p1}, Landroid/support/v7/widget/ActionMenuView;->generateLayoutParams(Landroid/util/AttributeSet;)Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    move-result-object p1

    return-object p1
.end method

.method protected bridge synthetic generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/support/v7/widget/LinearLayoutCompat$LayoutParams;
    .locals 0

    .line 47
    invoke-virtual {p0, p1}, Landroid/support/v7/widget/ActionMenuView;->generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    move-result-object p1

    return-object p1
.end method

.method public bridge synthetic generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    .locals 0

    .line 47
    invoke-virtual {p0, p1}, Landroid/support/v7/widget/ActionMenuView;->generateLayoutParams(Landroid/util/AttributeSet;)Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    move-result-object p1

    return-object p1
.end method

.method protected bridge synthetic generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .locals 0

    .line 47
    invoke-virtual {p0, p1}, Landroid/support/v7/widget/ActionMenuView;->generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    move-result-object p1

    return-object p1
.end method

.method public generateOverflowButtonLayoutParams()Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    .locals 2
    .annotation build Landroid/support/annotation/RestrictTo;
        value = {
            .enum Landroid/support/annotation/RestrictTo$Scope;->LIBRARY_GROUP:Landroid/support/annotation/RestrictTo$Scope;
        }
    .end annotation

    .line 615
    invoke-virtual {p0}, Landroid/support/v7/widget/ActionMenuView;->generateDefaultLayoutParams()Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    move-result-object v0

    .line 616
    .local v0, "result":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    const/4 v1, 0x1

    iput-boolean v1, v0, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->isOverflowButton:Z

    .line 617
    return-object v0
.end method

.method public getMenu()Landroid/view/Menu;
    .locals 4

    .line 647
    iget-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mMenu:Landroid/support/v7/view/menu/MenuBuilder;

    if-nez v0, :cond_1

    .line 648
    invoke-virtual {p0}, Landroid/support/v7/widget/ActionMenuView;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 649
    .local v0, "context":Landroid/content/Context;
    new-instance v1, Landroid/support/v7/view/menu/MenuBuilder;

    invoke-direct {v1, v0}, Landroid/support/v7/view/menu/MenuBuilder;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Landroid/support/v7/widget/ActionMenuView;->mMenu:Landroid/support/v7/view/menu/MenuBuilder;

    .line 650
    iget-object v1, p0, Landroid/support/v7/widget/ActionMenuView;->mMenu:Landroid/support/v7/view/menu/MenuBuilder;

    new-instance v2, Landroid/support/v7/widget/ActionMenuView$MenuBuilderCallback;

    invoke-direct {v2, p0}, Landroid/support/v7/widget/ActionMenuView$MenuBuilderCallback;-><init>(Landroid/support/v7/widget/ActionMenuView;)V

    invoke-virtual {v1, v2}, Landroid/support/v7/view/menu/MenuBuilder;->setCallback(Landroid/support/v7/view/menu/MenuBuilder$Callback;)V

    .line 651
    new-instance v1, Landroid/support/v7/widget/ActionMenuPresenter;

    invoke-direct {v1, v0}, Landroid/support/v7/widget/ActionMenuPresenter;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    .line 652
    iget-object v1, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/ActionMenuPresenter;->setReserveOverflow(Z)V

    .line 653
    iget-object v1, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    iget-object v2, p0, Landroid/support/v7/widget/ActionMenuView;->mActionMenuPresenterCallback:Landroid/support/v7/view/menu/MenuPresenter$Callback;

    if-eqz v2, :cond_0

    goto :goto_0

    :cond_0
    new-instance v2, Landroid/support/v7/widget/ActionMenuView$ActionMenuPresenterCallback;

    invoke-direct {v2, p0}, Landroid/support/v7/widget/ActionMenuView$ActionMenuPresenterCallback;-><init>(Landroid/support/v7/widget/ActionMenuView;)V

    :goto_0
    invoke-virtual {v1, v2}, Landroid/support/v7/widget/ActionMenuPresenter;->setCallback(Landroid/support/v7/view/menu/MenuPresenter$Callback;)V

    .line 655
    iget-object v1, p0, Landroid/support/v7/widget/ActionMenuView;->mMenu:Landroid/support/v7/view/menu/MenuBuilder;

    iget-object v2, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    iget-object v3, p0, Landroid/support/v7/widget/ActionMenuView;->mPopupContext:Landroid/content/Context;

    invoke-virtual {v1, v2, v3}, Landroid/support/v7/view/menu/MenuBuilder;->addMenuPresenter(Landroid/support/v7/view/menu/MenuPresenter;Landroid/content/Context;)V

    .line 656
    iget-object v1, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    invoke-virtual {v1, p0}, Landroid/support/v7/widget/ActionMenuPresenter;->setMenuView(Landroid/support/v7/widget/ActionMenuView;)V

    goto :goto_1

    .line 647
    .end local v0    # "context":Landroid/content/Context;
    :cond_1
    nop

    .line 659
    :goto_1
    iget-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mMenu:Landroid/support/v7/view/menu/MenuBuilder;

    return-object v0
.end method

.method public getOverflowIcon()Landroid/graphics/drawable/Drawable;
    .locals 1
    .annotation build Landroid/support/annotation/Nullable;
    .end annotation

    .line 564
    invoke-virtual {p0}, Landroid/support/v7/widget/ActionMenuView;->getMenu()Landroid/view/Menu;

    .line 565
    iget-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionMenuPresenter;->getOverflowIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public getPopupTheme()I
    .locals 1

    .line 112
    iget v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPopupTheme:I

    return v0
.end method

.method public getWindowAnimations()I
    .locals 1
    .annotation build Landroid/support/annotation/RestrictTo;
        value = {
            .enum Landroid/support/annotation/RestrictTo$Scope;->LIBRARY_GROUP:Landroid/support/annotation/RestrictTo$Scope;
        }
    .end annotation

    .line 629
    const/4 v0, 0x0

    return v0
.end method

.method protected hasSupportDividerBeforeChildAt(I)Z
    .locals 4
    .param p1, "childIndex"    # I
    .annotation build Landroid/support/annotation/RestrictTo;
        value = {
            .enum Landroid/support/annotation/RestrictTo$Scope;->LIBRARY_GROUP:Landroid/support/annotation/RestrictTo$Scope;
        }
    .end annotation

    .line 729
    if-nez p1, :cond_0

    .line 730
    const/4 v0, 0x0

    return v0

    .line 732
    :cond_0
    add-int/lit8 v0, p1, -0x1

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 733
    .local v0, "childBefore":Landroid/view/View;
    invoke-virtual {p0, p1}, Landroid/support/v7/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 734
    .local v1, "child":Landroid/view/View;
    const/4 v2, 0x0

    .line 735
    .local v2, "result":Z
    invoke-virtual {p0}, Landroid/support/v7/widget/ActionMenuView;->getChildCount()I

    move-result v3

    if-ge p1, v3, :cond_1

    instance-of v3, v0, Landroid/support/v7/widget/ActionMenuView$ActionMenuChildView;

    if-eqz v3, :cond_1

    .line 736
    move-object v3, v0

    check-cast v3, Landroid/support/v7/widget/ActionMenuView$ActionMenuChildView;

    invoke-interface {v3}, Landroid/support/v7/widget/ActionMenuView$ActionMenuChildView;->needsDividerAfter()Z

    move-result v3

    or-int/2addr v2, v3

    goto :goto_0

    .line 735
    :cond_1
    nop

    .line 738
    :goto_0
    if-lez p1, :cond_2

    instance-of v3, v1, Landroid/support/v7/widget/ActionMenuView$ActionMenuChildView;

    if-eqz v3, :cond_2

    .line 739
    move-object v3, v1

    check-cast v3, Landroid/support/v7/widget/ActionMenuView$ActionMenuChildView;

    invoke-interface {v3}, Landroid/support/v7/widget/ActionMenuView$ActionMenuChildView;->needsDividerBefore()Z

    move-result v3

    or-int/2addr v2, v3

    goto :goto_1

    .line 738
    :cond_2
    nop

    .line 741
    :goto_1
    return v2
.end method

.method public hideOverflowMenu()Z
    .locals 1

    .line 696
    iget-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionMenuPresenter;->hideOverflowMenu()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public initialize(Landroid/support/v7/view/menu/MenuBuilder;)V
    .locals 0
    .param p1, "menu"    # Landroid/support/v7/view/menu/MenuBuilder;
    .annotation build Landroid/support/annotation/RestrictTo;
        value = {
            .enum Landroid/support/annotation/RestrictTo$Scope;->LIBRARY_GROUP:Landroid/support/annotation/RestrictTo$Scope;
        }
    .end annotation

    .line 635
    iput-object p1, p0, Landroid/support/v7/widget/ActionMenuView;->mMenu:Landroid/support/v7/view/menu/MenuBuilder;

    .line 636
    return-void
.end method

.method public invokeItem(Landroid/support/v7/view/menu/MenuItemImpl;)Z
    .locals 2
    .param p1, "item"    # Landroid/support/v7/view/menu/MenuItemImpl;
    .annotation build Landroid/support/annotation/RestrictTo;
        value = {
            .enum Landroid/support/annotation/RestrictTo$Scope;->LIBRARY_GROUP:Landroid/support/annotation/RestrictTo$Scope;
        }
    .end annotation

    .line 623
    iget-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mMenu:Landroid/support/v7/view/menu/MenuBuilder;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/support/v7/view/menu/MenuBuilder;->performItemAction(Landroid/view/MenuItem;I)Z

    move-result v0

    return v0
.end method

.method public isOverflowMenuShowPending()Z
    .locals 1
    .annotation build Landroid/support/annotation/RestrictTo;
        value = {
            .enum Landroid/support/annotation/RestrictTo$Scope;->LIBRARY_GROUP:Landroid/support/annotation/RestrictTo$Scope;
        }
    .end annotation

    .line 712
    iget-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionMenuPresenter;->isOverflowMenuShowPending()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public isOverflowMenuShowing()Z
    .locals 1

    .line 706
    iget-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionMenuPresenter;->isOverflowMenuShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public isOverflowReserved()Z
    .locals 1
    .annotation build Landroid/support/annotation/RestrictTo;
        value = {
            .enum Landroid/support/annotation/RestrictTo$Scope;->LIBRARY_GROUP:Landroid/support/annotation/RestrictTo$Scope;
        }
    .end annotation

    .line 571
    iget-boolean v0, p0, Landroid/support/v7/widget/ActionMenuView;->mReserveOverflow:Z

    return v0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 2
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .line 127
    invoke-super {p0, p1}, Landroid/support/v7/widget/LinearLayoutCompat;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 129
    iget-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    if-eqz v0, :cond_1

    .line 130
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ActionMenuPresenter;->updateMenuView(Z)V

    .line 132
    iget-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionMenuPresenter;->isOverflowMenuShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 133
    iget-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionMenuPresenter;->hideOverflowMenu()Z

    .line 134
    iget-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionMenuPresenter;->showOverflowMenu()Z

    goto :goto_0

    .line 132
    :cond_0
    goto :goto_0

    .line 129
    :cond_1
    nop

    .line 137
    :goto_0
    return-void
.end method

.method public onDetachedFromWindow()V
    .locals 0

    .line 543
    invoke-super {p0}, Landroid/support/v7/widget/LinearLayoutCompat;->onDetachedFromWindow()V

    .line 544
    invoke-virtual {p0}, Landroid/support/v7/widget/ActionMenuView;->dismissPopupMenus()V

    .line 545
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 21
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .line 438
    move-object/from16 v0, p0

    iget-boolean v1, v0, Landroid/support/v7/widget/ActionMenuView;->mFormatItems:Z

    if-nez v1, :cond_0

    .line 439
    invoke-super/range {p0 .. p5}, Landroid/support/v7/widget/LinearLayoutCompat;->onLayout(ZIIII)V

    .line 440
    return-void

    .line 443
    :cond_0
    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/ActionMenuView;->getChildCount()I

    move-result v1

    .line 444
    .local v1, "childCount":I
    sub-int v2, p5, p3

    div-int/lit8 v2, v2, 0x2

    .line 445
    .local v2, "midVertical":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/ActionMenuView;->getDividerWidth()I

    move-result v3

    .line 446
    .local v3, "dividerWidth":I
    const/4 v4, 0x0

    .line 447
    .local v4, "overflowWidth":I
    const/4 v5, 0x0

    .line 448
    .local v5, "nonOverflowWidth":I
    const/4 v6, 0x0

    .line 449
    .local v6, "nonOverflowCount":I
    sub-int v7, p4, p2

    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/ActionMenuView;->getPaddingRight()I

    move-result v8

    sub-int/2addr v7, v8

    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/ActionMenuView;->getPaddingLeft()I

    move-result v8

    sub-int/2addr v7, v8

    .line 450
    .local v7, "widthRemaining":I
    const/4 v8, 0x0

    .line 451
    .local v8, "hasOverflow":Z
    invoke-static/range {p0 .. p0}, Landroid/support/v7/widget/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result v9

    .line 452
    .local v9, "isLayoutRtl":Z
    const/4 v10, 0x0

    .local v10, "i":I
    :goto_0
    const/16 v11, 0x8

    if-ge v10, v1, :cond_6

    .line 453
    invoke-virtual {v0, v10}, Landroid/support/v7/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v12

    .line 454
    .local v12, "v":Landroid/view/View;
    invoke-virtual {v12}, Landroid/view/View;->getVisibility()I

    move-result v13

    if-ne v13, v11, :cond_1

    .line 455
    move/from16 v16, v2

    move/from16 v17, v9

    goto :goto_4

    .line 458
    :cond_1
    invoke-virtual {v12}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v11

    check-cast v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    .line 459
    .local v11, "p":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    iget-boolean v13, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->isOverflowButton:Z

    if-eqz v13, :cond_4

    .line 460
    invoke-virtual {v12}, Landroid/view/View;->getMeasuredWidth()I

    move-result v4

    .line 461
    invoke-virtual {v0, v10}, Landroid/support/v7/widget/ActionMenuView;->hasSupportDividerBeforeChildAt(I)Z

    move-result v13

    if-eqz v13, :cond_2

    .line 462
    add-int/2addr v4, v3

    goto :goto_1

    .line 461
    :cond_2
    nop

    .line 464
    :goto_1
    invoke-virtual {v12}, Landroid/view/View;->getMeasuredHeight()I

    move-result v13

    .line 467
    .local v13, "height":I
    if-eqz v9, :cond_3

    .line 468
    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/ActionMenuView;->getPaddingLeft()I

    move-result v14

    iget v15, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->leftMargin:I

    add-int/2addr v14, v15

    .line 469
    .local v14, "l":I
    add-int v15, v14, v4

    goto :goto_2

    .line 471
    .end local v14    # "l":I
    :cond_3
    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/ActionMenuView;->getWidth()I

    move-result v14

    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/ActionMenuView;->getPaddingRight()I

    move-result v15

    sub-int/2addr v14, v15

    iget v15, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->rightMargin:I

    sub-int v15, v14, v15

    .line 472
    .local v15, "r":I
    sub-int v14, v15, v4

    .line 474
    .restart local v14    # "l":I
    :goto_2
    div-int/lit8 v16, v13, 0x2

    move/from16 v17, v9

    .end local v9    # "isLayoutRtl":Z
    .local v17, "isLayoutRtl":Z
    sub-int v9, v2, v16

    .line 475
    .local v9, "t":I
    move/from16 v16, v2

    .end local v2    # "midVertical":I
    .local v16, "midVertical":I
    add-int v2, v9, v13

    .line 476
    .local v2, "b":I
    invoke-virtual {v12, v14, v9, v15, v2}, Landroid/view/View;->layout(IIII)V

    .line 478
    sub-int/2addr v7, v4

    .line 479
    const/4 v2, 0x1

    .line 480
    .end local v8    # "hasOverflow":Z
    .end local v9    # "t":I
    .end local v13    # "height":I
    .end local v14    # "l":I
    .end local v15    # "r":I
    .local v2, "hasOverflow":Z
    move v8, v2

    goto :goto_4

    .line 481
    .end local v16    # "midVertical":I
    .end local v17    # "isLayoutRtl":Z
    .local v2, "midVertical":I
    .restart local v8    # "hasOverflow":Z
    .local v9, "isLayoutRtl":Z
    :cond_4
    move/from16 v16, v2

    move/from16 v17, v9

    .end local v2    # "midVertical":I
    .end local v9    # "isLayoutRtl":Z
    .restart local v16    # "midVertical":I
    .restart local v17    # "isLayoutRtl":Z
    invoke-virtual {v12}, Landroid/view/View;->getMeasuredWidth()I

    move-result v2

    iget v9, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->leftMargin:I

    add-int/2addr v2, v9

    iget v9, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->rightMargin:I

    add-int/2addr v2, v9

    .line 482
    .local v2, "size":I
    add-int/2addr v5, v2

    .line 483
    sub-int/2addr v7, v2

    .line 484
    invoke-virtual {v0, v10}, Landroid/support/v7/widget/ActionMenuView;->hasSupportDividerBeforeChildAt(I)Z

    move-result v9

    if-eqz v9, :cond_5

    .line 485
    add-int/2addr v5, v3

    goto :goto_3

    .line 484
    :cond_5
    nop

    .line 487
    :goto_3
    add-int/lit8 v6, v6, 0x1

    .line 452
    .end local v2    # "size":I
    .end local v11    # "p":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    .end local v12    # "v":Landroid/view/View;
    :goto_4
    add-int/lit8 v10, v10, 0x1

    move/from16 v2, v16

    move/from16 v9, v17

    goto :goto_0

    .end local v16    # "midVertical":I
    .end local v17    # "isLayoutRtl":Z
    .local v2, "midVertical":I
    .restart local v9    # "isLayoutRtl":Z
    :cond_6
    move/from16 v16, v2

    move/from16 v17, v9

    .line 491
    .end local v2    # "midVertical":I
    .end local v9    # "isLayoutRtl":Z
    .end local v10    # "i":I
    .restart local v16    # "midVertical":I
    .restart local v17    # "isLayoutRtl":Z
    const/4 v2, 0x0

    const/4 v9, 0x1

    if-ne v1, v9, :cond_7

    if-nez v8, :cond_7

    .line 493
    invoke-virtual {v0, v2}, Landroid/support/v7/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 494
    .local v2, "v":Landroid/view/View;
    invoke-virtual {v2}, Landroid/view/View;->getMeasuredWidth()I

    move-result v9

    .line 495
    .local v9, "width":I
    invoke-virtual {v2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v10

    .line 496
    .local v10, "height":I
    sub-int v11, p4, p2

    div-int/lit8 v11, v11, 0x2

    .line 497
    .local v11, "midHorizontal":I
    div-int/lit8 v12, v9, 0x2

    sub-int v12, v11, v12

    .line 498
    .local v12, "l":I
    div-int/lit8 v13, v10, 0x2

    sub-int v13, v16, v13

    .line 499
    .local v13, "t":I
    add-int v14, v12, v9

    add-int v15, v13, v10

    invoke-virtual {v2, v12, v13, v14, v15}, Landroid/view/View;->layout(IIII)V

    .line 500
    return-void

    .line 491
    .end local v2    # "v":Landroid/view/View;
    .end local v9    # "width":I
    .end local v10    # "height":I
    .end local v11    # "midHorizontal":I
    .end local v12    # "l":I
    .end local v13    # "t":I
    :cond_7
    nop

    .line 503
    if-eqz v8, :cond_8

    const/4 v9, 0x0

    nop

    :cond_8
    sub-int v9, v6, v9

    .line 504
    .local v9, "spacerCount":I
    if-lez v9, :cond_9

    div-int v10, v7, v9

    goto :goto_5

    :cond_9
    const/4 v10, 0x0

    :goto_5
    invoke-static {v2, v10}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 506
    .local v2, "spacerSize":I
    if-eqz v17, :cond_d

    .line 507
    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/ActionMenuView;->getWidth()I

    move-result v10

    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/ActionMenuView;->getPaddingRight()I

    move-result v12

    sub-int/2addr v10, v12

    .line 508
    .local v10, "startRight":I
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_6
    if-ge v12, v1, :cond_c

    .line 509
    invoke-virtual {v0, v12}, Landroid/support/v7/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v13

    .line 510
    .local v13, "v":Landroid/view/View;
    invoke-virtual {v13}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v14

    check-cast v14, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    .line 511
    .local v14, "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    invoke-virtual {v13}, Landroid/view/View;->getVisibility()I

    move-result v15

    if-eq v15, v11, :cond_b

    iget-boolean v15, v14, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->isOverflowButton:Z

    if-eqz v15, :cond_a

    .line 512
    move/from16 v19, v3

    move/from16 v20, v4

    goto :goto_7

    .line 515
    :cond_a
    iget v15, v14, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->rightMargin:I

    sub-int/2addr v10, v15

    .line 516
    invoke-virtual {v13}, Landroid/view/View;->getMeasuredWidth()I

    move-result v15

    .line 517
    .local v15, "width":I
    invoke-virtual {v13}, Landroid/view/View;->getMeasuredHeight()I

    move-result v18

    .line 518
    .local v18, "height":I
    div-int/lit8 v19, v18, 0x2

    sub-int v11, v16, v19

    .line 519
    .local v11, "t":I
    move/from16 v19, v3

    .end local v3    # "dividerWidth":I
    .local v19, "dividerWidth":I
    sub-int v3, v10, v15

    move/from16 v20, v4

    .end local v4    # "overflowWidth":I
    .local v20, "overflowWidth":I
    add-int v4, v11, v18

    invoke-virtual {v13, v3, v11, v10, v4}, Landroid/view/View;->layout(IIII)V

    .line 520
    iget v3, v14, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->leftMargin:I

    add-int/2addr v3, v15

    add-int/2addr v3, v2

    sub-int/2addr v10, v3

    goto :goto_7

    .line 511
    .end local v11    # "t":I
    .end local v15    # "width":I
    .end local v18    # "height":I
    .end local v19    # "dividerWidth":I
    .end local v20    # "overflowWidth":I
    .restart local v3    # "dividerWidth":I
    .restart local v4    # "overflowWidth":I
    :cond_b
    move/from16 v19, v3

    move/from16 v20, v4

    .line 508
    .end local v3    # "dividerWidth":I
    .end local v4    # "overflowWidth":I
    .end local v13    # "v":Landroid/view/View;
    .end local v14    # "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    .restart local v19    # "dividerWidth":I
    .restart local v20    # "overflowWidth":I
    :goto_7
    add-int/lit8 v12, v12, 0x1

    move/from16 v3, v19

    move/from16 v4, v20

    const/16 v11, 0x8

    goto :goto_6

    .end local v19    # "dividerWidth":I
    .end local v20    # "overflowWidth":I
    .restart local v3    # "dividerWidth":I
    .restart local v4    # "overflowWidth":I
    :cond_c
    move/from16 v19, v3

    move/from16 v20, v4

    .line 522
    .end local v3    # "dividerWidth":I
    .end local v4    # "overflowWidth":I
    .end local v10    # "startRight":I
    .end local v12    # "i":I
    .restart local v19    # "dividerWidth":I
    .restart local v20    # "overflowWidth":I
    goto :goto_a

    .line 523
    .end local v19    # "dividerWidth":I
    .end local v20    # "overflowWidth":I
    .restart local v3    # "dividerWidth":I
    .restart local v4    # "overflowWidth":I
    :cond_d
    move/from16 v19, v3

    move/from16 v20, v4

    .end local v3    # "dividerWidth":I
    .end local v4    # "overflowWidth":I
    .restart local v19    # "dividerWidth":I
    .restart local v20    # "overflowWidth":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/ActionMenuView;->getPaddingLeft()I

    move-result v3

    .line 524
    .local v3, "startLeft":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_8
    if-ge v4, v1, :cond_10

    .line 525
    invoke-virtual {v0, v4}, Landroid/support/v7/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v10

    .line 526
    .local v10, "v":Landroid/view/View;
    invoke-virtual {v10}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v11

    check-cast v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    .line 527
    .local v11, "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    invoke-virtual {v10}, Landroid/view/View;->getVisibility()I

    move-result v12

    const/16 v13, 0x8

    if-eq v12, v13, :cond_f

    iget-boolean v12, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->isOverflowButton:Z

    if-eqz v12, :cond_e

    .line 528
    goto :goto_9

    .line 531
    :cond_e
    iget v12, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->leftMargin:I

    add-int/2addr v3, v12

    .line 532
    invoke-virtual {v10}, Landroid/view/View;->getMeasuredWidth()I

    move-result v12

    .line 533
    .local v12, "width":I
    invoke-virtual {v10}, Landroid/view/View;->getMeasuredHeight()I

    move-result v14

    .line 534
    .local v14, "height":I
    div-int/lit8 v15, v14, 0x2

    sub-int v15, v16, v15

    .line 535
    .local v15, "t":I
    add-int v13, v3, v12

    add-int v0, v15, v14

    invoke-virtual {v10, v3, v15, v13, v0}, Landroid/view/View;->layout(IIII)V

    .line 536
    iget v0, v11, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->rightMargin:I

    add-int/2addr v0, v12

    add-int/2addr v0, v2

    add-int/2addr v3, v0

    goto :goto_9

    .line 527
    .end local v12    # "width":I
    .end local v14    # "height":I
    .end local v15    # "t":I
    :cond_f
    nop

    .line 524
    .end local v10    # "v":Landroid/view/View;
    .end local v11    # "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    :goto_9
    add-int/lit8 v4, v4, 0x1

    move-object/from16 v0, p0

    goto :goto_8

    .line 539
    .end local v3    # "startLeft":I
    .end local v4    # "i":I
    :cond_10
    :goto_a
    return-void
.end method

.method protected onMeasure(II)V
    .locals 7
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .line 146
    iget-boolean v0, p0, Landroid/support/v7/widget/ActionMenuView;->mFormatItems:Z

    .line 147
    .local v0, "wasFormatted":Z
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    const/4 v2, 0x1

    const/4 v3, 0x0

    const/high16 v4, 0x40000000    # 2.0f

    if-ne v1, v4, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    iput-boolean v1, p0, Landroid/support/v7/widget/ActionMenuView;->mFormatItems:Z

    .line 149
    iget-boolean v1, p0, Landroid/support/v7/widget/ActionMenuView;->mFormatItems:Z

    if-eq v0, v1, :cond_1

    .line 150
    iput v3, p0, Landroid/support/v7/widget/ActionMenuView;->mFormatItemsWidth:I

    goto :goto_1

    .line 149
    :cond_1
    nop

    .line 155
    :goto_1
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v1

    .line 156
    .local v1, "widthSize":I
    iget-boolean v4, p0, Landroid/support/v7/widget/ActionMenuView;->mFormatItems:Z

    if-eqz v4, :cond_2

    iget-object v4, p0, Landroid/support/v7/widget/ActionMenuView;->mMenu:Landroid/support/v7/view/menu/MenuBuilder;

    if-eqz v4, :cond_2

    iget v5, p0, Landroid/support/v7/widget/ActionMenuView;->mFormatItemsWidth:I

    if-eq v1, v5, :cond_2

    .line 157
    iput v1, p0, Landroid/support/v7/widget/ActionMenuView;->mFormatItemsWidth:I

    .line 158
    invoke-virtual {v4, v2}, Landroid/support/v7/view/menu/MenuBuilder;->onItemsChanged(Z)V

    goto :goto_2

    .line 156
    :cond_2
    nop

    .line 161
    :goto_2
    invoke-virtual {p0}, Landroid/support/v7/widget/ActionMenuView;->getChildCount()I

    move-result v2

    .line 162
    .local v2, "childCount":I
    iget-boolean v4, p0, Landroid/support/v7/widget/ActionMenuView;->mFormatItems:Z

    if-eqz v4, :cond_3

    if-lez v2, :cond_3

    .line 163
    invoke-direct {p0, p1, p2}, Landroid/support/v7/widget/ActionMenuView;->onMeasureExactFormat(II)V

    goto :goto_4

    .line 162
    :cond_3
    nop

    .line 166
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_3
    if-ge v4, v2, :cond_4

    .line 167
    invoke-virtual {p0, v4}, Landroid/support/v7/widget/ActionMenuView;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    .line 168
    .local v5, "child":Landroid/view/View;
    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    check-cast v6, Landroid/support/v7/widget/ActionMenuView$LayoutParams;

    .line 169
    .local v6, "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    iput v3, v6, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->rightMargin:I

    iput v3, v6, Landroid/support/v7/widget/ActionMenuView$LayoutParams;->leftMargin:I

    .line 166
    .end local v5    # "child":Landroid/view/View;
    .end local v6    # "lp":Landroid/support/v7/widget/ActionMenuView$LayoutParams;
    add-int/lit8 v4, v4, 0x1

    goto :goto_3

    .line 171
    .end local v4    # "i":I
    :cond_4
    invoke-super {p0, p1, p2}, Landroid/support/v7/widget/LinearLayoutCompat;->onMeasure(II)V

    .line 173
    :goto_4
    return-void
.end method

.method public peekMenu()Landroid/support/v7/view/menu/MenuBuilder;
    .locals 1
    .annotation build Landroid/support/annotation/RestrictTo;
        value = {
            .enum Landroid/support/annotation/RestrictTo$Scope;->LIBRARY_GROUP:Landroid/support/annotation/RestrictTo$Scope;
        }
    .end annotation

    .line 678
    iget-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mMenu:Landroid/support/v7/view/menu/MenuBuilder;

    return-object v0
.end method

.method public setExpandedActionViewsExclusive(Z)V
    .locals 1
    .param p1, "exclusive"    # Z
    .annotation build Landroid/support/annotation/RestrictTo;
        value = {
            .enum Landroid/support/annotation/RestrictTo$Scope;->LIBRARY_GROUP:Landroid/support/annotation/RestrictTo$Scope;
        }
    .end annotation

    .line 751
    iget-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/ActionMenuPresenter;->setExpandedActionViewsExclusive(Z)V

    .line 752
    return-void
.end method

.method public setMenuCallbacks(Landroid/support/v7/view/menu/MenuPresenter$Callback;Landroid/support/v7/view/menu/MenuBuilder$Callback;)V
    .locals 0
    .param p1, "pcb"    # Landroid/support/v7/view/menu/MenuPresenter$Callback;
    .param p2, "mcb"    # Landroid/support/v7/view/menu/MenuBuilder$Callback;
    .annotation build Landroid/support/annotation/RestrictTo;
        value = {
            .enum Landroid/support/annotation/RestrictTo$Scope;->LIBRARY_GROUP:Landroid/support/annotation/RestrictTo$Scope;
        }
    .end annotation

    .line 668
    iput-object p1, p0, Landroid/support/v7/widget/ActionMenuView;->mActionMenuPresenterCallback:Landroid/support/v7/view/menu/MenuPresenter$Callback;

    .line 669
    iput-object p2, p0, Landroid/support/v7/widget/ActionMenuView;->mMenuBuilderCallback:Landroid/support/v7/view/menu/MenuBuilder$Callback;

    .line 670
    return-void
.end method

.method public setOnMenuItemClickListener(Landroid/support/v7/widget/ActionMenuView$OnMenuItemClickListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/support/v7/widget/ActionMenuView$OnMenuItemClickListener;

    .line 140
    iput-object p1, p0, Landroid/support/v7/widget/ActionMenuView;->mOnMenuItemClickListener:Landroid/support/v7/widget/ActionMenuView$OnMenuItemClickListener;

    .line 141
    return-void
.end method

.method public setOverflowIcon(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .line 553
    invoke-virtual {p0}, Landroid/support/v7/widget/ActionMenuView;->getMenu()Landroid/view/Menu;

    .line 554
    iget-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/ActionMenuPresenter;->setOverflowIcon(Landroid/graphics/drawable/Drawable;)V

    .line 555
    return-void
.end method

.method public setOverflowReserved(Z)V
    .locals 0
    .param p1, "reserveOverflow"    # Z
    .annotation build Landroid/support/annotation/RestrictTo;
        value = {
            .enum Landroid/support/annotation/RestrictTo$Scope;->LIBRARY_GROUP:Landroid/support/annotation/RestrictTo$Scope;
        }
    .end annotation

    .line 577
    iput-boolean p1, p0, Landroid/support/v7/widget/ActionMenuView;->mReserveOverflow:Z

    .line 578
    return-void
.end method

.method public setPopupTheme(I)V
    .locals 2
    .param p1, "resId"    # I
        .annotation build Landroid/support/annotation/StyleRes;
        .end annotation
    .end param

    .line 96
    iget v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPopupTheme:I

    if-eq v0, p1, :cond_1

    .line 97
    iput p1, p0, Landroid/support/v7/widget/ActionMenuView;->mPopupTheme:I

    .line 98
    if-nez p1, :cond_0

    .line 99
    invoke-virtual {p0}, Landroid/support/v7/widget/ActionMenuView;->getContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPopupContext:Landroid/content/Context;

    goto :goto_0

    .line 101
    :cond_0
    new-instance v0, Landroid/view/ContextThemeWrapper;

    invoke-virtual {p0}, Landroid/support/v7/widget/ActionMenuView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Landroid/view/ContextThemeWrapper;-><init>(Landroid/content/Context;I)V

    iput-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPopupContext:Landroid/content/Context;

    goto :goto_0

    .line 96
    :cond_1
    nop

    .line 104
    :goto_0
    return-void
.end method

.method public setPresenter(Landroid/support/v7/widget/ActionMenuPresenter;)V
    .locals 1
    .param p1, "presenter"    # Landroid/support/v7/widget/ActionMenuPresenter;
    .annotation build Landroid/support/annotation/RestrictTo;
        value = {
            .enum Landroid/support/annotation/RestrictTo$Scope;->LIBRARY_GROUP:Landroid/support/annotation/RestrictTo$Scope;
        }
    .end annotation

    .line 121
    iput-object p1, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    .line 122
    iget-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    invoke-virtual {v0, p0}, Landroid/support/v7/widget/ActionMenuPresenter;->setMenuView(Landroid/support/v7/widget/ActionMenuView;)V

    .line 123
    return-void
.end method

.method public showOverflowMenu()Z
    .locals 1

    .line 687
    iget-object v0, p0, Landroid/support/v7/widget/ActionMenuView;->mPresenter:Landroid/support/v7/widget/ActionMenuPresenter;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionMenuPresenter;->showOverflowMenu()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method
