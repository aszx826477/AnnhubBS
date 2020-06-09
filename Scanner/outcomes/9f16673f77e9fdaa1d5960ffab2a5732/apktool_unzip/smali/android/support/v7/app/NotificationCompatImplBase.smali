.class Landroid/support/v7/app/NotificationCompatImplBase;
.super Ljava/lang/Object;
.source "NotificationCompatImplBase.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x9
.end annotation

.annotation build Landroid/support/annotation/RequiresApi;
    value = 0x9
.end annotation


# static fields
.field private static final MAX_ACTION_BUTTONS:I = 0x3

.field static final MAX_MEDIA_BUTTONS:I = 0x5

.field static final MAX_MEDIA_BUTTONS_IN_COMPACT:I = 0x3


# direct methods
.method constructor <init>()V
    .locals 0

    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static applyStandardTemplate(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;IILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJIIIZ)Landroid/widget/RemoteViews;
    .locals 22
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "contentTitle"    # Ljava/lang/CharSequence;
    .param p2, "contentText"    # Ljava/lang/CharSequence;
    .param p3, "contentInfo"    # Ljava/lang/CharSequence;
    .param p4, "number"    # I
    .param p5, "smallIcon"    # I
    .param p6, "largeIcon"    # Landroid/graphics/Bitmap;
    .param p7, "subText"    # Ljava/lang/CharSequence;
    .param p8, "useChronometer"    # Z
    .param p9, "when"    # J
    .param p11, "priority"    # I
    .param p12, "color"    # I
    .param p13, "resId"    # I
    .param p14, "fitIn1U"    # Z

    .line 280
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move-object/from16 v3, p3

    move/from16 v4, p4

    move/from16 v5, p5

    move-object/from16 v6, p6

    move-object/from16 v7, p7

    move-wide/from16 v8, p9

    move/from16 v10, p12

    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    .line 281
    .local v11, "res":Landroid/content/res/Resources;
    new-instance v12, Landroid/widget/RemoteViews;

    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v13

    move/from16 v14, p13

    invoke-direct {v12, v13, v14}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 282
    .local v12, "contentView":Landroid/widget/RemoteViews;
    const/4 v13, 0x0

    .line 283
    .local v13, "showLine3":Z
    const/4 v15, 0x0

    .line 285
    .local v15, "showLine2":Z
    move/from16 v16, v13

    .end local v13    # "showLine3":Z
    .local v16, "showLine3":Z
    const/4 v13, -0x1

    move/from16 v14, p11

    if-ge v14, v13, :cond_0

    const/16 v17, 0x1

    goto :goto_0

    :cond_0
    const/16 v17, 0x0

    :goto_0
    move/from16 v21, v17

    .line 286
    .local v21, "minPriority":Z
    sget v13, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v14, 0x10

    if-lt v13, v14, :cond_2

    sget v13, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v14, 0x15

    if-ge v13, v14, :cond_2

    .line 288
    if-eqz v21, :cond_1

    .line 289
    sget v13, Landroid/support/v7/appcompat/R$id;->notification_background:I

    const-string v14, "setBackgroundResource"

    move/from16 v19, v15

    .end local v15    # "showLine2":Z
    .local v19, "showLine2":Z
    sget v15, Landroid/support/v7/appcompat/R$drawable;->notification_bg_low:I

    invoke-virtual {v12, v13, v14, v15}, Landroid/widget/RemoteViews;->setInt(ILjava/lang/String;I)V

    .line 291
    sget v13, Landroid/support/v7/appcompat/R$id;->icon:I

    const-string v14, "setBackgroundResource"

    sget v15, Landroid/support/v7/appcompat/R$drawable;->notification_template_icon_low_bg:I

    invoke-virtual {v12, v13, v14, v15}, Landroid/widget/RemoteViews;->setInt(ILjava/lang/String;I)V

    goto :goto_1

    .line 294
    .end local v19    # "showLine2":Z
    .restart local v15    # "showLine2":Z
    :cond_1
    move/from16 v19, v15

    .end local v15    # "showLine2":Z
    .restart local v19    # "showLine2":Z
    sget v13, Landroid/support/v7/appcompat/R$id;->notification_background:I

    const-string v14, "setBackgroundResource"

    sget v15, Landroid/support/v7/appcompat/R$drawable;->notification_bg:I

    invoke-virtual {v12, v13, v14, v15}, Landroid/widget/RemoteViews;->setInt(ILjava/lang/String;I)V

    .line 296
    sget v13, Landroid/support/v7/appcompat/R$id;->icon:I

    const-string v14, "setBackgroundResource"

    sget v15, Landroid/support/v7/appcompat/R$drawable;->notification_template_icon_bg:I

    invoke-virtual {v12, v13, v14, v15}, Landroid/widget/RemoteViews;->setInt(ILjava/lang/String;I)V

    goto :goto_1

    .line 286
    .end local v19    # "showLine2":Z
    .restart local v15    # "showLine2":Z
    :cond_2
    move/from16 v19, v15

    .line 301
    .end local v15    # "showLine2":Z
    .restart local v19    # "showLine2":Z
    :goto_1
    const/16 v14, 0x8

    if-eqz v6, :cond_6

    .line 304
    sget v13, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v15, 0x10

    if-lt v13, v15, :cond_3

    .line 305
    sget v13, Landroid/support/v7/appcompat/R$id;->icon:I

    const/4 v15, 0x0

    invoke-virtual {v12, v13, v15}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 306
    sget v13, Landroid/support/v7/appcompat/R$id;->icon:I

    invoke-virtual {v12, v13, v6}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    goto :goto_2

    .line 308
    :cond_3
    sget v13, Landroid/support/v7/appcompat/R$id;->icon:I

    invoke-virtual {v12, v13, v14}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 310
    :goto_2
    if-eqz v5, :cond_5

    .line 311
    sget v13, Landroid/support/v7/appcompat/R$dimen;->notification_right_icon_size:I

    invoke-virtual {v11, v13}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v13

    .line 313
    .local v13, "backgroundSize":I
    sget v15, Landroid/support/v7/appcompat/R$dimen;->notification_small_icon_background_padding:I

    invoke-virtual {v11, v15}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v15

    mul-int/lit8 v15, v15, 0x2

    sub-int v15, v13, v15

    .line 315
    .local v15, "iconSize":I
    sget v14, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v8, 0x15

    if-lt v14, v8, :cond_4

    .line 316
    invoke-static {v0, v5, v13, v15, v10}, Landroid/support/v7/app/NotificationCompatImplBase;->createIconWithBackground(Landroid/content/Context;IIII)Landroid/graphics/Bitmap;

    move-result-object v8

    .line 321
    .local v8, "smallBit":Landroid/graphics/Bitmap;
    sget v9, Landroid/support/v7/appcompat/R$id;->right_icon:I

    invoke-virtual {v12, v9, v8}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 322
    .end local v8    # "smallBit":Landroid/graphics/Bitmap;
    goto :goto_3

    .line 323
    :cond_4
    sget v8, Landroid/support/v7/appcompat/R$id;->right_icon:I

    .line 324
    const/4 v9, -0x1

    invoke-static {v0, v5, v9}, Landroid/support/v7/app/NotificationCompatImplBase;->createColoredBitmap(Landroid/content/Context;II)Landroid/graphics/Bitmap;

    move-result-object v9

    .line 323
    invoke-virtual {v12, v8, v9}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 326
    :goto_3
    sget v8, Landroid/support/v7/appcompat/R$id;->right_icon:I

    const/4 v9, 0x0

    invoke-virtual {v12, v8, v9}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 327
    .end local v13    # "backgroundSize":I
    .end local v15    # "iconSize":I
    goto :goto_4

    .line 310
    :cond_5
    const/4 v9, 0x0

    goto :goto_4

    .line 328
    :cond_6
    const/4 v9, 0x0

    if-eqz v5, :cond_8

    .line 329
    sget v8, Landroid/support/v7/appcompat/R$id;->icon:I

    invoke-virtual {v12, v8, v9}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 330
    sget v8, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v9, 0x15

    if-lt v8, v9, :cond_7

    .line 331
    sget v8, Landroid/support/v7/appcompat/R$dimen;->notification_large_icon_width:I

    invoke-virtual {v11, v8}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v8

    sget v9, Landroid/support/v7/appcompat/R$dimen;->notification_big_circle_margin:I

    .line 333
    invoke-virtual {v11, v9}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v9

    sub-int/2addr v8, v9

    .line 334
    .local v8, "backgroundSize":I
    sget v9, Landroid/support/v7/appcompat/R$dimen;->notification_small_icon_size_as_large:I

    invoke-virtual {v11, v9}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v9

    .line 336
    .local v9, "iconSize":I
    invoke-static {v0, v5, v8, v9, v10}, Landroid/support/v7/app/NotificationCompatImplBase;->createIconWithBackground(Landroid/content/Context;IIII)Landroid/graphics/Bitmap;

    move-result-object v13

    .line 341
    .local v13, "smallBit":Landroid/graphics/Bitmap;
    sget v14, Landroid/support/v7/appcompat/R$id;->icon:I

    invoke-virtual {v12, v14, v13}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 342
    .end local v8    # "backgroundSize":I
    .end local v9    # "iconSize":I
    .end local v13    # "smallBit":Landroid/graphics/Bitmap;
    goto :goto_4

    .line 343
    :cond_7
    sget v8, Landroid/support/v7/appcompat/R$id;->icon:I

    .line 344
    const/4 v9, -0x1

    invoke-static {v0, v5, v9}, Landroid/support/v7/app/NotificationCompatImplBase;->createColoredBitmap(Landroid/content/Context;II)Landroid/graphics/Bitmap;

    move-result-object v9

    .line 343
    invoke-virtual {v12, v8, v9}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    goto :goto_4

    .line 328
    :cond_8
    nop

    .line 347
    :goto_4
    if-eqz v1, :cond_9

    .line 348
    sget v8, Landroid/support/v7/appcompat/R$id;->title:I

    invoke-virtual {v12, v8, v1}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    goto :goto_5

    .line 347
    :cond_9
    nop

    .line 350
    :goto_5
    if-eqz v2, :cond_a

    .line 351
    sget v8, Landroid/support/v7/appcompat/R$id;->text:I

    invoke-virtual {v12, v8, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 352
    const/4 v13, 0x1

    goto :goto_6

    .line 350
    :cond_a
    move/from16 v13, v16

    .line 355
    .end local v16    # "showLine3":Z
    .local v13, "showLine3":Z
    :goto_6
    sget v8, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v9, 0x15

    if-ge v8, v9, :cond_b

    if-eqz v6, :cond_b

    const/4 v8, 0x1

    goto :goto_7

    :cond_b
    const/4 v8, 0x0

    .line 356
    .local v8, "hasRightSide":Z
    :goto_7
    if-eqz v3, :cond_c

    .line 357
    sget v9, Landroid/support/v7/appcompat/R$id;->info:I

    invoke-virtual {v12, v9, v3}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 358
    sget v9, Landroid/support/v7/appcompat/R$id;->info:I

    const/4 v14, 0x0

    invoke-virtual {v12, v9, v14}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 359
    const/4 v13, 0x1

    .line 360
    const/4 v8, 0x1

    goto :goto_9

    .line 361
    :cond_c
    if-lez v4, :cond_e

    .line 362
    sget v9, Landroid/support/v7/appcompat/R$integer;->status_bar_notification_info_maxnum:I

    invoke-virtual {v11, v9}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v9

    .line 364
    .local v9, "tooBig":I
    if-le v4, v9, :cond_d

    .line 365
    sget v14, Landroid/support/v7/appcompat/R$id;->info:I

    sget v15, Landroid/support/v7/appcompat/R$string;->status_bar_notification_info_overflow:I

    invoke-virtual {v11, v15}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v12, v14, v15}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    goto :goto_8

    .line 368
    :cond_d
    invoke-static {}, Ljava/text/NumberFormat;->getIntegerInstance()Ljava/text/NumberFormat;

    move-result-object v14

    .line 369
    .local v14, "f":Ljava/text/NumberFormat;
    sget v15, Landroid/support/v7/appcompat/R$id;->info:I

    int-to-long v0, v4

    invoke-virtual {v14, v0, v1}, Ljava/text/NumberFormat;->format(J)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v12, v15, v0}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 371
    .end local v14    # "f":Ljava/text/NumberFormat;
    :goto_8
    sget v0, Landroid/support/v7/appcompat/R$id;->info:I

    const/4 v1, 0x0

    invoke-virtual {v12, v0, v1}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 372
    const/4 v13, 0x1

    .line 373
    const/4 v8, 0x1

    .line 374
    .end local v9    # "tooBig":I
    goto :goto_9

    .line 375
    :cond_e
    sget v0, Landroid/support/v7/appcompat/R$id;->info:I

    const/16 v1, 0x8

    invoke-virtual {v12, v0, v1}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 379
    :goto_9
    if-eqz v7, :cond_10

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_10

    .line 380
    sget v0, Landroid/support/v7/appcompat/R$id;->text:I

    invoke-virtual {v12, v0, v7}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 381
    if-eqz v2, :cond_f

    .line 382
    sget v0, Landroid/support/v7/appcompat/R$id;->text2:I

    invoke-virtual {v12, v0, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 383
    sget v0, Landroid/support/v7/appcompat/R$id;->text2:I

    const/4 v1, 0x0

    invoke-virtual {v12, v0, v1}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 384
    const/4 v15, 0x1

    move v0, v15

    const/16 v9, 0x8

    goto :goto_b

    .line 386
    :cond_f
    sget v0, Landroid/support/v7/appcompat/R$id;->text2:I

    const/16 v9, 0x8

    invoke-virtual {v12, v0, v9}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    goto :goto_a

    .line 379
    :cond_10
    const/16 v9, 0x8

    .line 391
    :goto_a
    move/from16 v0, v19

    .end local v19    # "showLine2":Z
    .local v0, "showLine2":Z
    :goto_b
    if-eqz v0, :cond_12

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v14, 0x10

    if-lt v1, v14, :cond_12

    .line 392
    if-eqz p14, :cond_11

    .line 394
    sget v1, Landroid/support/v7/appcompat/R$dimen;->notification_subtext_size:I

    invoke-virtual {v11, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    int-to-float v1, v1

    .line 396
    .local v1, "subTextSize":F
    sget v14, Landroid/support/v7/appcompat/R$id;->text:I

    const/4 v15, 0x0

    invoke-virtual {v12, v14, v15, v1}, Landroid/widget/RemoteViews;->setTextViewTextSize(IIF)V

    goto :goto_c

    .line 392
    .end local v1    # "subTextSize":F
    :cond_11
    nop

    .line 399
    :goto_c
    sget v16, Landroid/support/v7/appcompat/R$id;->line1:I

    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x0

    move-object v15, v12

    invoke-virtual/range {v15 .. v20}, Landroid/widget/RemoteViews;->setViewPadding(IIIII)V

    goto :goto_d

    .line 391
    :cond_12
    nop

    .line 402
    :goto_d
    const-wide/16 v14, 0x0

    move-wide/from16 v9, p9

    cmp-long v1, v9, v14

    if-eqz v1, :cond_14

    .line 403
    if-eqz p8, :cond_13

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v14, 0x10

    if-lt v1, v14, :cond_13

    .line 404
    sget v1, Landroid/support/v7/appcompat/R$id;->chronometer:I

    const/4 v14, 0x0

    invoke-virtual {v12, v1, v14}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 405
    sget v1, Landroid/support/v7/appcompat/R$id;->chronometer:I

    const-string v14, "setBase"

    .line 406
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v15

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v17

    sub-long v15, v15, v17

    add-long v2, v9, v15

    .line 405
    invoke-virtual {v12, v1, v14, v2, v3}, Landroid/widget/RemoteViews;->setLong(ILjava/lang/String;J)V

    .line 407
    sget v1, Landroid/support/v7/appcompat/R$id;->chronometer:I

    const-string v2, "setStarted"

    const/4 v3, 0x1

    invoke-virtual {v12, v1, v2, v3}, Landroid/widget/RemoteViews;->setBoolean(ILjava/lang/String;Z)V

    const/4 v14, 0x0

    goto :goto_e

    .line 403
    :cond_13
    nop

    .line 409
    sget v1, Landroid/support/v7/appcompat/R$id;->time:I

    const/4 v14, 0x0

    invoke-virtual {v12, v1, v14}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 410
    sget v1, Landroid/support/v7/appcompat/R$id;->time:I

    const-string v2, "setTime"

    invoke-virtual {v12, v1, v2, v9, v10}, Landroid/widget/RemoteViews;->setLong(ILjava/lang/String;J)V

    .line 412
    :goto_e
    const/4 v8, 0x1

    goto :goto_f

    .line 402
    :cond_14
    const/4 v14, 0x0

    .line 414
    :goto_f
    sget v1, Landroid/support/v7/appcompat/R$id;->right_side:I

    if-eqz v8, :cond_15

    const/4 v2, 0x0

    goto :goto_10

    :cond_15
    const/16 v2, 0x8

    :goto_10
    invoke-virtual {v12, v1, v2}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 415
    sget v1, Landroid/support/v7/appcompat/R$id;->line3:I

    if-eqz v13, :cond_16

    goto :goto_11

    :cond_16
    const/16 v14, 0x8

    :goto_11
    invoke-virtual {v12, v1, v14}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 416
    return-object v12
.end method

.method public static applyStandardTemplateWithActions(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;IILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJIIIZLjava/util/ArrayList;)Landroid/widget/RemoteViews;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "contentTitle"    # Ljava/lang/CharSequence;
    .param p2, "contentText"    # Ljava/lang/CharSequence;
    .param p3, "contentInfo"    # Ljava/lang/CharSequence;
    .param p4, "number"    # I
    .param p5, "smallIcon"    # I
    .param p6, "largeIcon"    # Landroid/graphics/Bitmap;
    .param p7, "subText"    # Ljava/lang/CharSequence;
    .param p8, "useChronometer"    # Z
    .param p9, "when"    # J
    .param p11, "priority"    # I
    .param p12, "color"    # I
    .param p13, "resId"    # I
    .param p14, "fitIn1U"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/CharSequence;",
            "Ljava/lang/CharSequence;",
            "Ljava/lang/CharSequence;",
            "II",
            "Landroid/graphics/Bitmap;",
            "Ljava/lang/CharSequence;",
            "ZJIIIZ",
            "Ljava/util/ArrayList<",
            "Landroid/support/v4/app/NotificationCompat$Action;",
            ">;)",
            "Landroid/widget/RemoteViews;"
        }
    .end annotation

    .line 207
    .local p15, "actions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/app/NotificationCompat$Action;>;"
    move-object/from16 v0, p15

    invoke-static/range {p0 .. p14}, Landroid/support/v7/app/NotificationCompatImplBase;->applyStandardTemplate(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;IILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJIIIZ)Landroid/widget/RemoteViews;

    move-result-object v1

    .line 210
    .local v1, "remoteViews":Landroid/widget/RemoteViews;
    sget v2, Landroid/support/v7/appcompat/R$id;->actions:I

    invoke-virtual {v1, v2}, Landroid/widget/RemoteViews;->removeAllViews(I)V

    .line 211
    const/4 v2, 0x0

    .line 212
    .local v2, "actionsVisible":Z
    if-eqz v0, :cond_3

    .line 213
    invoke-virtual/range {p15 .. p15}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 214
    .local v3, "N":I
    if-lez v3, :cond_2

    .line 215
    const/4 v2, 0x1

    .line 216
    const/4 v4, 0x3

    if-le v3, v4, :cond_0

    const/4 v3, 0x3

    nop

    .line 217
    :cond_0
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    if-ge v4, v3, :cond_1

    .line 218
    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/support/v4/app/NotificationCompat$Action;

    move-object v6, p0

    invoke-static {p0, v5}, Landroid/support/v7/app/NotificationCompatImplBase;->generateActionButton(Landroid/content/Context;Landroid/support/v4/app/NotificationCompat$Action;)Landroid/widget/RemoteViews;

    move-result-object v5

    .line 219
    .local v5, "button":Landroid/widget/RemoteViews;
    sget v7, Landroid/support/v7/appcompat/R$id;->actions:I

    invoke-virtual {v1, v7, v5}, Landroid/widget/RemoteViews;->addView(ILandroid/widget/RemoteViews;)V

    .line 217
    .end local v5    # "button":Landroid/widget/RemoteViews;
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    :cond_1
    move-object v6, p0

    goto :goto_1

    .line 214
    .end local v4    # "i":I
    :cond_2
    move-object v6, p0

    goto :goto_1

    .line 212
    .end local v3    # "N":I
    :cond_3
    move-object v6, p0

    .line 223
    :goto_1
    if-eqz v2, :cond_4

    const/4 v3, 0x0

    goto :goto_2

    :cond_4
    const/16 v3, 0x8

    .line 224
    .local v3, "actionVisibility":I
    :goto_2
    sget v4, Landroid/support/v7/appcompat/R$id;->actions:I

    invoke-virtual {v1, v4, v3}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 225
    sget v4, Landroid/support/v7/appcompat/R$id;->action_divider:I

    invoke-virtual {v1, v4, v3}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 226
    return-object v1
.end method

.method public static buildIntoRemoteViews(Landroid/content/Context;Landroid/widget/RemoteViews;Landroid/widget/RemoteViews;)V
    .locals 8
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "outerView"    # Landroid/widget/RemoteViews;
    .param p2, "innerView"    # Landroid/widget/RemoteViews;

    .line 437
    invoke-static {p1}, Landroid/support/v7/app/NotificationCompatImplBase;->hideNormalContent(Landroid/widget/RemoteViews;)V

    .line 438
    sget v0, Landroid/support/v7/appcompat/R$id;->notification_main_column:I

    invoke-virtual {p1, v0}, Landroid/widget/RemoteViews;->removeAllViews(I)V

    .line 439
    sget v0, Landroid/support/v7/appcompat/R$id;->notification_main_column:I

    invoke-virtual {p2}, Landroid/widget/RemoteViews;->clone()Landroid/widget/RemoteViews;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/widget/RemoteViews;->addView(ILandroid/widget/RemoteViews;)V

    .line 440
    sget v0, Landroid/support/v7/appcompat/R$id;->notification_main_column:I

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 441
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 443
    sget v3, Landroid/support/v7/appcompat/R$id;->notification_main_column_container:I

    const/4 v4, 0x0

    .line 444
    invoke-static {p0}, Landroid/support/v7/app/NotificationCompatImplBase;->calculateTopPadding(Landroid/content/Context;)I

    move-result v5

    const/4 v6, 0x0

    const/4 v7, 0x0

    .line 443
    move-object v2, p1

    invoke-virtual/range {v2 .. v7}, Landroid/widget/RemoteViews;->setViewPadding(IIIII)V

    goto :goto_0

    .line 441
    :cond_0
    nop

    .line 446
    :goto_0
    return-void
.end method

.method public static calculateTopPadding(Landroid/content/Context;)I
    .locals 6
    .param p0, "ctx"    # Landroid/content/Context;

    .line 455
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Landroid/support/v7/appcompat/R$dimen;->notification_top_pad:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .line 456
    .local v0, "padding":I
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Landroid/support/v7/appcompat/R$dimen;->notification_top_pad_large_text:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 458
    .local v1, "largePadding":I
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v2

    iget v2, v2, Landroid/content/res/Configuration;->fontScale:F

    .line 459
    .local v2, "fontScale":F
    const/high16 v3, 0x3f800000    # 1.0f

    const v4, 0x3fa66666    # 1.3f

    invoke-static {v2, v3, v4}, Landroid/support/v7/app/NotificationCompatImplBase;->constrain(FFF)F

    move-result v4

    sub-float/2addr v4, v3

    const v5, 0x3e999998    # 0.29999995f

    div-float/2addr v4, v5

    .line 463
    .local v4, "largeFactor":F
    sub-float/2addr v3, v4

    int-to-float v5, v0

    mul-float v3, v3, v5

    int-to-float v5, v1

    mul-float v5, v5, v4

    add-float/2addr v3, v5

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v3

    return v3
.end method

.method public static constrain(FFF)F
    .locals 1
    .param p0, "amount"    # F
    .param p1, "low"    # F
    .param p2, "high"    # F

    .line 467
    cmpg-float v0, p0, p1

    if-gez v0, :cond_0

    move v0, p1

    goto :goto_0

    :cond_0
    cmpl-float v0, p0, p2

    if-lez v0, :cond_1

    move v0, p2

    goto :goto_0

    :cond_1
    move v0, p0

    :goto_0
    return v0
.end method

.method private static createColoredBitmap(Landroid/content/Context;II)Landroid/graphics/Bitmap;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "iconId"    # I
    .param p2, "color"    # I

    .line 249
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Landroid/support/v7/app/NotificationCompatImplBase;->createColoredBitmap(Landroid/content/Context;III)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method private static createColoredBitmap(Landroid/content/Context;III)Landroid/graphics/Bitmap;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "iconId"    # I
    .param p2, "color"    # I
    .param p3, "size"    # I

    .line 253
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 254
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-nez p3, :cond_0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v1

    goto :goto_0

    :cond_0
    move v1, p3

    .line 255
    .local v1, "width":I
    :goto_0
    if-nez p3, :cond_1

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v2

    goto :goto_1

    :cond_1
    move v2, p3

    .line 256
    .local v2, "height":I
    :goto_1
    sget-object v3, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v1, v2, v3}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v3

    .line 257
    .local v3, "resultBitmap":Landroid/graphics/Bitmap;
    const/4 v4, 0x0

    invoke-virtual {v0, v4, v4, v1, v2}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 258
    if-eqz p2, :cond_2

    .line 259
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    new-instance v5, Landroid/graphics/PorterDuffColorFilter;

    sget-object v6, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v5, p2, v6}, Landroid/graphics/PorterDuffColorFilter;-><init>(ILandroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v4, v5}, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V

    goto :goto_2

    .line 258
    :cond_2
    nop

    .line 262
    :goto_2
    new-instance v4, Landroid/graphics/Canvas;

    invoke-direct {v4, v3}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 263
    .local v4, "canvas":Landroid/graphics/Canvas;
    invoke-virtual {v0, v4}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 264
    return-object v3
.end method

.method public static createIconWithBackground(Landroid/content/Context;IIII)Landroid/graphics/Bitmap;
    .locals 7
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "iconId"    # I
    .param p2, "size"    # I
    .param p3, "iconSize"    # I
    .param p4, "color"    # I

    .line 421
    sget v0, Landroid/support/v7/appcompat/R$drawable;->notification_icon_background:I

    if-nez p4, :cond_0

    const/4 v1, 0x0

    goto :goto_0

    :cond_0
    move v1, p4

    :goto_0
    invoke-static {p0, v0, v1, p2}, Landroid/support/v7/app/NotificationCompatImplBase;->createColoredBitmap(Landroid/content/Context;III)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 423
    .local v0, "coloredBitmap":Landroid/graphics/Bitmap;
    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 424
    .local v1, "canvas":Landroid/graphics/Canvas;
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v2}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 425
    .local v2, "icon":Landroid/graphics/drawable/Drawable;
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/graphics/drawable/Drawable;->setFilterBitmap(Z)V

    .line 426
    sub-int v3, p2, p3

    div-int/lit8 v3, v3, 0x2

    .line 427
    .local v3, "inset":I
    add-int v4, p3, v3

    add-int v5, p3, v3

    invoke-virtual {v2, v3, v3, v4, v5}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 428
    new-instance v4, Landroid/graphics/PorterDuffColorFilter;

    const/4 v5, -0x1

    sget-object v6, Landroid/graphics/PorterDuff$Mode;->SRC_ATOP:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v4, v5, v6}, Landroid/graphics/PorterDuffColorFilter;-><init>(ILandroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v2, v4}, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 429
    invoke-virtual {v2, v1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 430
    return-object v0
.end method

.method private static generateActionButton(Landroid/content/Context;Landroid/support/v4/app/NotificationCompat$Action;)Landroid/widget/RemoteViews;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "action"    # Landroid/support/v4/app/NotificationCompat$Action;

    .line 231
    iget-object v0, p1, Landroid/support/v4/app/NotificationCompat$Action;->actionIntent:Landroid/app/PendingIntent;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 232
    .local v0, "tombstone":Z
    :goto_0
    new-instance v1, Landroid/widget/RemoteViews;

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    if-eqz v0, :cond_1

    .line 233
    invoke-static {}, Landroid/support/v7/app/NotificationCompatImplBase;->getActionTombstoneLayoutResource()I

    move-result v3

    goto :goto_1

    .line 234
    :cond_1
    invoke-static {}, Landroid/support/v7/app/NotificationCompatImplBase;->getActionLayoutResource()I

    move-result v3

    :goto_1
    invoke-direct {v1, v2, v3}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 235
    .local v1, "button":Landroid/widget/RemoteViews;
    sget v2, Landroid/support/v7/appcompat/R$id;->action_image:I

    .line 236
    invoke-virtual {p1}, Landroid/support/v4/app/NotificationCompat$Action;->getIcon()I

    move-result v3

    .line 237
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Landroid/support/v7/appcompat/R$color;->notification_action_color_filter:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    .line 236
    invoke-static {p0, v3, v4}, Landroid/support/v7/app/NotificationCompatImplBase;->createColoredBitmap(Landroid/content/Context;II)Landroid/graphics/Bitmap;

    move-result-object v3

    .line 235
    invoke-virtual {v1, v2, v3}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 238
    sget v2, Landroid/support/v7/appcompat/R$id;->action_text:I

    iget-object v3, p1, Landroid/support/v4/app/NotificationCompat$Action;->title:Ljava/lang/CharSequence;

    invoke-virtual {v1, v2, v3}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 239
    if-nez v0, :cond_2

    .line 240
    sget v2, Landroid/support/v7/appcompat/R$id;->action_container:I

    iget-object v3, p1, Landroid/support/v4/app/NotificationCompat$Action;->actionIntent:Landroid/app/PendingIntent;

    invoke-virtual {v1, v2, v3}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    goto :goto_2

    .line 239
    :cond_2
    nop

    .line 242
    :goto_2
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xf

    if-lt v2, v3, :cond_3

    .line 243
    sget v2, Landroid/support/v7/appcompat/R$id;->action_container:I

    iget-object v3, p1, Landroid/support/v4/app/NotificationCompat$Action;->title:Ljava/lang/CharSequence;

    invoke-virtual {v1, v2, v3}, Landroid/widget/RemoteViews;->setContentDescription(ILjava/lang/CharSequence;)V

    goto :goto_3

    .line 242
    :cond_3
    nop

    .line 245
    :goto_3
    return-object v1
.end method

.method private static generateContentViewMedia(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJILjava/util/List;[IZLandroid/app/PendingIntent;Z)Landroid/widget/RemoteViews;
    .locals 17
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "contentTitle"    # Ljava/lang/CharSequence;
    .param p2, "contentText"    # Ljava/lang/CharSequence;
    .param p3, "contentInfo"    # Ljava/lang/CharSequence;
    .param p4, "number"    # I
    .param p5, "largeIcon"    # Landroid/graphics/Bitmap;
    .param p6, "subText"    # Ljava/lang/CharSequence;
    .param p7, "useChronometer"    # Z
    .param p8, "when"    # J
    .param p10, "priority"    # I
    .param p12, "actionsToShowInCompact"    # [I
    .param p13, "showCancelButton"    # Z
    .param p14, "cancelButtonIntent"    # Landroid/app/PendingIntent;
    .param p15, "isDecoratedCustomView"    # Z
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0xb
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Landroid/support/v4/app/NotificationCompatBase$Action;",
            ">(",
            "Landroid/content/Context;",
            "Ljava/lang/CharSequence;",
            "Ljava/lang/CharSequence;",
            "Ljava/lang/CharSequence;",
            "I",
            "Landroid/graphics/Bitmap;",
            "Ljava/lang/CharSequence;",
            "ZJI",
            "Ljava/util/List<",
            "TT;>;[IZ",
            "Landroid/app/PendingIntent;",
            "Z)",
            "Landroid/widget/RemoteViews;"
        }
    .end annotation

    .line 85
    .local p11, "actions":Ljava/util/List;, "Ljava/util/List<TT;>;"
    move-object/from16 v0, p12

    if-eqz p15, :cond_0

    sget v1, Landroid/support/v7/appcompat/R$layout;->notification_template_media_custom:I

    goto :goto_0

    :cond_0
    sget v1, Landroid/support/v7/appcompat/R$layout;->notification_template_media:I

    :goto_0
    move v15, v1

    const/16 v16, 0x1

    const/4 v7, 0x0

    const/4 v14, 0x0

    move-object/from16 v2, p0

    move-object/from16 v3, p1

    move-object/from16 v4, p2

    move-object/from16 v5, p3

    move/from16 v6, p4

    move-object/from16 v8, p5

    move-object/from16 v9, p6

    move/from16 v10, p7

    move-wide/from16 v11, p8

    move/from16 v13, p10

    invoke-static/range {v2 .. v16}, Landroid/support/v7/app/NotificationCompatImplBase;->applyStandardTemplate(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;IILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJIIIZ)Landroid/widget/RemoteViews;

    move-result-object v1

    .line 92
    .local v1, "view":Landroid/widget/RemoteViews;
    invoke-interface/range {p11 .. p11}, Ljava/util/List;->size()I

    move-result v2

    .line 93
    .local v2, "numActions":I
    const/4 v3, 0x0

    if-nez v0, :cond_1

    const/4 v4, 0x0

    goto :goto_1

    :cond_1
    array-length v4, v0

    const/4 v5, 0x3

    .line 95
    invoke-static {v4, v5}, Ljava/lang/Math;->min(II)I

    move-result v4

    :goto_1
    nop

    .line 96
    .local v4, "N":I
    sget v5, Landroid/support/v7/appcompat/R$id;->media_actions:I

    invoke-virtual {v1, v5}, Landroid/widget/RemoteViews;->removeAllViews(I)V

    .line 97
    if-lez v4, :cond_4

    .line 98
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_2
    if-ge v5, v4, :cond_3

    .line 99
    if-ge v5, v2, :cond_2

    .line 105
    aget v6, v0, v5

    move-object/from16 v7, p11

    invoke-interface {v7, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/support/v4/app/NotificationCompatBase$Action;

    .line 106
    .local v6, "action":Landroid/support/v4/app/NotificationCompatBase$Action;
    move-object/from16 v8, p0

    invoke-static {v8, v6}, Landroid/support/v7/app/NotificationCompatImplBase;->generateMediaActionButton(Landroid/content/Context;Landroid/support/v4/app/NotificationCompatBase$Action;)Landroid/widget/RemoteViews;

    move-result-object v9

    .line 107
    .local v9, "button":Landroid/widget/RemoteViews;
    sget v10, Landroid/support/v7/appcompat/R$id;->media_actions:I

    invoke-virtual {v1, v10, v9}, Landroid/widget/RemoteViews;->addView(ILandroid/widget/RemoteViews;)V

    .line 98
    .end local v6    # "action":Landroid/support/v4/app/NotificationCompatBase$Action;
    .end local v9    # "button":Landroid/widget/RemoteViews;
    add-int/lit8 v5, v5, 0x1

    goto :goto_2

    .line 100
    :cond_2
    move-object/from16 v8, p0

    move-object/from16 v7, p11

    new-instance v6, Ljava/lang/IllegalArgumentException;

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    .line 102
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v9, v3

    add-int/lit8 v3, v2, -0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    const/4 v10, 0x1

    aput-object v3, v9, v10

    .line 100
    const-string v3, "setShowActionsInCompactView: action %d out of bounds (max %d)"

    invoke-static {v3, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v6, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 98
    :cond_3
    move-object/from16 v8, p0

    move-object/from16 v7, p11

    goto :goto_3

    .line 97
    .end local v5    # "i":I
    :cond_4
    move-object/from16 v8, p0

    move-object/from16 v7, p11

    .line 110
    :goto_3
    const/16 v5, 0x8

    if-eqz p13, :cond_5

    .line 111
    sget v6, Landroid/support/v7/appcompat/R$id;->end_padder:I

    invoke-virtual {v1, v6, v5}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 112
    sget v5, Landroid/support/v7/appcompat/R$id;->cancel_action:I

    invoke-virtual {v1, v5, v3}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 113
    sget v3, Landroid/support/v7/appcompat/R$id;->cancel_action:I

    move-object/from16 v6, p14

    invoke-virtual {v1, v3, v6}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 114
    sget v3, Landroid/support/v7/appcompat/R$id;->cancel_action:I

    const-string v5, "setAlpha"

    .line 115
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    sget v10, Landroid/support/v7/appcompat/R$integer;->cancel_button_image_alpha:I

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v9

    .line 114
    invoke-virtual {v1, v3, v5, v9}, Landroid/widget/RemoteViews;->setInt(ILjava/lang/String;I)V

    goto :goto_4

    .line 117
    :cond_5
    move-object/from16 v6, p14

    sget v9, Landroid/support/v7/appcompat/R$id;->end_padder:I

    invoke-virtual {v1, v9, v3}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 118
    sget v3, Landroid/support/v7/appcompat/R$id;->cancel_action:I

    invoke-virtual {v1, v3, v5}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 120
    :goto_4
    return-object v1
.end method

.method private static generateMediaActionButton(Landroid/content/Context;Landroid/support/v4/app/NotificationCompatBase$Action;)Landroid/widget/RemoteViews;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "action"    # Landroid/support/v4/app/NotificationCompatBase$Action;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0xb
    .end annotation

    .line 175
    invoke-virtual {p1}, Landroid/support/v4/app/NotificationCompatBase$Action;->getActionIntent()Landroid/app/PendingIntent;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 176
    .local v0, "tombstone":Z
    :goto_0
    new-instance v1, Landroid/widget/RemoteViews;

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    sget v3, Landroid/support/v7/appcompat/R$layout;->notification_media_action:I

    invoke-direct {v1, v2, v3}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 178
    .local v1, "button":Landroid/widget/RemoteViews;
    sget v2, Landroid/support/v7/appcompat/R$id;->action0:I

    invoke-virtual {p1}, Landroid/support/v4/app/NotificationCompatBase$Action;->getIcon()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/widget/RemoteViews;->setImageViewResource(II)V

    .line 179
    if-nez v0, :cond_1

    .line 180
    sget v2, Landroid/support/v7/appcompat/R$id;->action0:I

    invoke-virtual {p1}, Landroid/support/v4/app/NotificationCompatBase$Action;->getActionIntent()Landroid/app/PendingIntent;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    goto :goto_1

    .line 179
    :cond_1
    nop

    .line 182
    :goto_1
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xf

    if-lt v2, v3, :cond_2

    .line 183
    sget v2, Landroid/support/v7/appcompat/R$id;->action0:I

    invoke-virtual {p1}, Landroid/support/v4/app/NotificationCompatBase$Action;->getTitle()Ljava/lang/CharSequence;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/widget/RemoteViews;->setContentDescription(ILjava/lang/CharSequence;)V

    goto :goto_2

    .line 182
    :cond_2
    nop

    .line 185
    :goto_2
    return-object v1
.end method

.method public static generateMediaBigView(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJIILjava/util/List;ZLandroid/app/PendingIntent;Z)Landroid/widget/RemoteViews;
    .locals 17
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "contentTitle"    # Ljava/lang/CharSequence;
    .param p2, "contentText"    # Ljava/lang/CharSequence;
    .param p3, "contentInfo"    # Ljava/lang/CharSequence;
    .param p4, "number"    # I
    .param p5, "largeIcon"    # Landroid/graphics/Bitmap;
    .param p6, "subText"    # Ljava/lang/CharSequence;
    .param p7, "useChronometer"    # Z
    .param p8, "when"    # J
    .param p10, "priority"    # I
    .param p11, "color"    # I
    .param p13, "showCancelButton"    # Z
    .param p14, "cancelButtonIntent"    # Landroid/app/PendingIntent;
    .param p15, "decoratedCustomView"    # Z
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0xb
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Landroid/support/v4/app/NotificationCompatBase$Action;",
            ">(",
            "Landroid/content/Context;",
            "Ljava/lang/CharSequence;",
            "Ljava/lang/CharSequence;",
            "Ljava/lang/CharSequence;",
            "I",
            "Landroid/graphics/Bitmap;",
            "Ljava/lang/CharSequence;",
            "ZJII",
            "Ljava/util/List<",
            "TT;>;Z",
            "Landroid/app/PendingIntent;",
            "Z)",
            "Landroid/widget/RemoteViews;"
        }
    .end annotation

    .line 147
    .local p12, "actions":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-interface/range {p12 .. p12}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x5

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 148
    .local v0, "actionCount":I
    nop

    .line 150
    move/from16 v1, p15

    invoke-static {v1, v0}, Landroid/support/v7/app/NotificationCompatImplBase;->getBigMediaLayoutResource(ZI)I

    move-result v15

    .line 148
    const/4 v7, 0x0

    const/16 v16, 0x0

    move-object/from16 v2, p0

    move-object/from16 v3, p1

    move-object/from16 v4, p2

    move-object/from16 v5, p3

    move/from16 v6, p4

    move-object/from16 v8, p5

    move-object/from16 v9, p6

    move/from16 v10, p7

    move-wide/from16 v11, p8

    move/from16 v13, p10

    move/from16 v14, p11

    invoke-static/range {v2 .. v16}, Landroid/support/v7/app/NotificationCompatImplBase;->applyStandardTemplate(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;IILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJIIIZ)Landroid/widget/RemoteViews;

    move-result-object v2

    .line 153
    .local v2, "big":Landroid/widget/RemoteViews;
    sget v3, Landroid/support/v7/appcompat/R$id;->media_actions:I

    invoke-virtual {v2, v3}, Landroid/widget/RemoteViews;->removeAllViews(I)V

    .line 154
    if-lez v0, :cond_1

    .line 155
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v0, :cond_0

    .line 156
    move-object/from16 v4, p12

    invoke-interface {v4, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/support/v4/app/NotificationCompatBase$Action;

    move-object/from16 v6, p0

    invoke-static {v6, v5}, Landroid/support/v7/app/NotificationCompatImplBase;->generateMediaActionButton(Landroid/content/Context;Landroid/support/v4/app/NotificationCompatBase$Action;)Landroid/widget/RemoteViews;

    move-result-object v5

    .line 157
    .local v5, "button":Landroid/widget/RemoteViews;
    sget v7, Landroid/support/v7/appcompat/R$id;->media_actions:I

    invoke-virtual {v2, v7, v5}, Landroid/widget/RemoteViews;->addView(ILandroid/widget/RemoteViews;)V

    .line 155
    .end local v5    # "button":Landroid/widget/RemoteViews;
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    :cond_0
    move-object/from16 v6, p0

    move-object/from16 v4, p12

    goto :goto_1

    .line 154
    .end local v3    # "i":I
    :cond_1
    move-object/from16 v6, p0

    move-object/from16 v4, p12

    .line 160
    :goto_1
    if-eqz p13, :cond_2

    .line 161
    sget v3, Landroid/support/v7/appcompat/R$id;->cancel_action:I

    const/4 v5, 0x0

    invoke-virtual {v2, v3, v5}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 162
    sget v3, Landroid/support/v7/appcompat/R$id;->cancel_action:I

    const-string v5, "setAlpha"

    .line 163
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Landroid/support/v7/appcompat/R$integer;->cancel_button_image_alpha:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v7

    .line 162
    invoke-virtual {v2, v3, v5, v7}, Landroid/widget/RemoteViews;->setInt(ILjava/lang/String;I)V

    .line 164
    sget v3, Landroid/support/v7/appcompat/R$id;->cancel_action:I

    move-object/from16 v5, p14

    invoke-virtual {v2, v3, v5}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    goto :goto_2

    .line 166
    :cond_2
    move-object/from16 v5, p14

    sget v3, Landroid/support/v7/appcompat/R$id;->cancel_action:I

    const/16 v7, 0x8

    invoke-virtual {v2, v3, v7}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 168
    :goto_2
    return-object v2
.end method

.method private static getActionLayoutResource()I
    .locals 1

    .line 268
    sget v0, Landroid/support/v7/appcompat/R$layout;->notification_action:I

    return v0
.end method

.method private static getActionTombstoneLayoutResource()I
    .locals 1

    .line 272
    sget v0, Landroid/support/v7/appcompat/R$layout;->notification_action_tombstone:I

    return v0
.end method

.method private static getBigMediaLayoutResource(ZI)I
    .locals 1
    .param p0, "decoratedCustomView"    # Z
    .param p1, "actionCount"    # I
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0xb
    .end annotation

    .line 191
    const/4 v0, 0x3

    if-gt p1, v0, :cond_1

    .line 192
    if-eqz p0, :cond_0

    sget v0, Landroid/support/v7/appcompat/R$layout;->notification_template_big_media_narrow_custom:I

    goto :goto_0

    :cond_0
    sget v0, Landroid/support/v7/appcompat/R$layout;->notification_template_big_media_narrow:I

    :goto_0
    return v0

    .line 196
    :cond_1
    if-eqz p0, :cond_2

    sget v0, Landroid/support/v7/appcompat/R$layout;->notification_template_big_media_custom:I

    goto :goto_1

    :cond_2
    sget v0, Landroid/support/v7/appcompat/R$layout;->notification_template_big_media:I

    :goto_1
    return v0
.end method

.method private static hideNormalContent(Landroid/widget/RemoteViews;)V
    .locals 2
    .param p0, "outerView"    # Landroid/widget/RemoteViews;

    .line 449
    sget v0, Landroid/support/v7/appcompat/R$id;->title:I

    const/16 v1, 0x8

    invoke-virtual {p0, v0, v1}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 450
    sget v0, Landroid/support/v7/appcompat/R$id;->text2:I

    invoke-virtual {p0, v0, v1}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 451
    sget v0, Landroid/support/v7/appcompat/R$id;->text:I

    invoke-virtual {p0, v0, v1}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 452
    return-void
.end method

.method public static overrideContentViewMedia(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJILjava/util/List;[IZLandroid/app/PendingIntent;Z)Landroid/widget/RemoteViews;
    .locals 3
    .param p0, "builder"    # Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "contentTitle"    # Ljava/lang/CharSequence;
    .param p3, "contentText"    # Ljava/lang/CharSequence;
    .param p4, "contentInfo"    # Ljava/lang/CharSequence;
    .param p5, "number"    # I
    .param p6, "largeIcon"    # Landroid/graphics/Bitmap;
    .param p7, "subText"    # Ljava/lang/CharSequence;
    .param p8, "useChronometer"    # Z
    .param p9, "when"    # J
    .param p11, "priority"    # I
    .param p13, "actionsToShowInCompact"    # [I
    .param p14, "showCancelButton"    # Z
    .param p15, "cancelButtonIntent"    # Landroid/app/PendingIntent;
    .param p16, "isDecoratedCustomView"    # Z
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0xb
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Landroid/support/v4/app/NotificationCompatBase$Action;",
            ">(",
            "Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;",
            "Landroid/content/Context;",
            "Ljava/lang/CharSequence;",
            "Ljava/lang/CharSequence;",
            "Ljava/lang/CharSequence;",
            "I",
            "Landroid/graphics/Bitmap;",
            "Ljava/lang/CharSequence;",
            "ZJI",
            "Ljava/util/List<",
            "TT;>;[IZ",
            "Landroid/app/PendingIntent;",
            "Z)",
            "Landroid/widget/RemoteViews;"
        }
    .end annotation

    .line 66
    .local p12, "actions":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-static/range {p1 .. p16}, Landroid/support/v7/app/NotificationCompatImplBase;->generateContentViewMedia(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJILjava/util/List;[IZLandroid/app/PendingIntent;Z)Landroid/widget/RemoteViews;

    move-result-object v0

    .line 70
    .local v0, "views":Landroid/widget/RemoteViews;
    invoke-interface {p0}, Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;->getBuilder()Landroid/app/Notification$Builder;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/app/Notification$Builder;->setContent(Landroid/widget/RemoteViews;)Landroid/app/Notification$Builder;

    .line 71
    if-eqz p14, :cond_0

    .line 72
    invoke-interface {p0}, Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;->getBuilder()Landroid/app/Notification$Builder;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/app/Notification$Builder;->setOngoing(Z)Landroid/app/Notification$Builder;

    goto :goto_0

    .line 71
    :cond_0
    nop

    .line 74
    :goto_0
    return-object v0
.end method

.method public static overrideMediaBigContentView(Landroid/app/Notification;Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJIILjava/util/List;ZLandroid/app/PendingIntent;Z)V
    .locals 2
    .param p0, "n"    # Landroid/app/Notification;
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "contentTitle"    # Ljava/lang/CharSequence;
    .param p3, "contentText"    # Ljava/lang/CharSequence;
    .param p4, "contentInfo"    # Ljava/lang/CharSequence;
    .param p5, "number"    # I
    .param p6, "largeIcon"    # Landroid/graphics/Bitmap;
    .param p7, "subText"    # Ljava/lang/CharSequence;
    .param p8, "useChronometer"    # Z
    .param p9, "when"    # J
    .param p11, "priority"    # I
    .param p12, "color"    # I
    .param p14, "showCancelButton"    # Z
    .param p15, "cancelButtonIntent"    # Landroid/app/PendingIntent;
    .param p16, "decoratedCustomView"    # Z
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0x10
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Landroid/support/v4/app/NotificationCompatBase$Action;",
            ">(",
            "Landroid/app/Notification;",
            "Landroid/content/Context;",
            "Ljava/lang/CharSequence;",
            "Ljava/lang/CharSequence;",
            "Ljava/lang/CharSequence;",
            "I",
            "Landroid/graphics/Bitmap;",
            "Ljava/lang/CharSequence;",
            "ZJII",
            "Ljava/util/List<",
            "TT;>;Z",
            "Landroid/app/PendingIntent;",
            "Z)V"
        }
    .end annotation

    .line 131
    .local p13, "actions":Ljava/util/List;, "Ljava/util/List<TT;>;"
    move-object v0, p0

    invoke-static/range {p1 .. p16}, Landroid/support/v7/app/NotificationCompatImplBase;->generateMediaBigView(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJIILjava/util/List;ZLandroid/app/PendingIntent;Z)Landroid/widget/RemoteViews;

    move-result-object v1

    iput-object v1, v0, Landroid/app/Notification;->bigContentView:Landroid/widget/RemoteViews;

    .line 134
    if-eqz p14, :cond_0

    .line 135
    iget v1, v0, Landroid/app/Notification;->flags:I

    or-int/lit8 v1, v1, 0x2

    iput v1, v0, Landroid/app/Notification;->flags:I

    goto :goto_0

    .line 134
    :cond_0
    nop

    .line 137
    :goto_0
    return-void
.end method
