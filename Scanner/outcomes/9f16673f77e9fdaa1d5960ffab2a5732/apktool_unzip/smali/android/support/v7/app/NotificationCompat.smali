.class public Landroid/support/v7/app/NotificationCompat;
.super Landroid/support/v4/app/NotificationCompat;
.source "NotificationCompat.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/app/NotificationCompat$DecoratedMediaCustomViewStyle;,
        Landroid/support/v7/app/NotificationCompat$DecoratedCustomViewStyle;,
        Landroid/support/v7/app/NotificationCompat$MediaStyle;,
        Landroid/support/v7/app/NotificationCompat$Api24Extender;,
        Landroid/support/v7/app/NotificationCompat$LollipopExtender;,
        Landroid/support/v7/app/NotificationCompat$JellybeanExtender;,
        Landroid/support/v7/app/NotificationCompat$IceCreamSandwichExtender;,
        Landroid/support/v7/app/NotificationCompat$Builder;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53
    invoke-direct {p0}, Landroid/support/v4/app/NotificationCompat;-><init>()V

    .line 708
    return-void
.end method

.method static synthetic access$000(Landroid/support/v4/app/NotificationCompat$MessagingStyle;)Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;
    .locals 1
    .param p0, "x0"    # Landroid/support/v4/app/NotificationCompat$MessagingStyle;

    .line 53
    invoke-static {p0}, Landroid/support/v7/app/NotificationCompat;->findLatestIncomingMessage(Landroid/support/v4/app/NotificationCompat$MessagingStyle;)Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Landroid/support/v4/app/NotificationCompat$Builder;Landroid/support/v4/app/NotificationCompat$MessagingStyle;Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;)Ljava/lang/CharSequence;
    .locals 1
    .param p0, "x0"    # Landroid/support/v4/app/NotificationCompat$Builder;
    .param p1, "x1"    # Landroid/support/v4/app/NotificationCompat$MessagingStyle;
    .param p2, "x2"    # Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;

    .line 53
    invoke-static {p0, p1, p2}, Landroid/support/v7/app/NotificationCompat;->makeMessageLine(Landroid/support/v4/app/NotificationCompat$Builder;Landroid/support/v4/app/NotificationCompat$MessagingStyle;Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$300(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/support/v4/app/NotificationCompat$Builder;)Landroid/widget/RemoteViews;
    .locals 1
    .param p0, "x0"    # Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;
    .param p1, "x1"    # Landroid/support/v4/app/NotificationCompat$Builder;

    .line 53
    invoke-static {p0, p1}, Landroid/support/v7/app/NotificationCompat;->addStyleGetContentViewIcs(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/support/v4/app/NotificationCompat$Builder;)Landroid/widget/RemoteViews;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/support/v4/app/NotificationCompat$Builder;)Landroid/widget/RemoteViews;
    .locals 1
    .param p0, "x0"    # Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;
    .param p1, "x1"    # Landroid/support/v4/app/NotificationCompat$Builder;

    .line 53
    invoke-static {p0, p1}, Landroid/support/v7/app/NotificationCompat;->addStyleGetContentViewJellybean(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/support/v4/app/NotificationCompat$Builder;)Landroid/widget/RemoteViews;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$500(Landroid/app/Notification;Landroid/support/v4/app/NotificationCompat$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroid/app/Notification;
    .param p1, "x1"    # Landroid/support/v4/app/NotificationCompat$Builder;

    .line 53
    invoke-static {p0, p1}, Landroid/support/v7/app/NotificationCompat;->addBigStyleToBuilderJellybean(Landroid/app/Notification;Landroid/support/v4/app/NotificationCompat$Builder;)V

    return-void
.end method

.method static synthetic access$600(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/support/v4/app/NotificationCompat$Builder;)Landroid/widget/RemoteViews;
    .locals 1
    .param p0, "x0"    # Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;
    .param p1, "x1"    # Landroid/support/v4/app/NotificationCompat$Builder;

    .line 53
    invoke-static {p0, p1}, Landroid/support/v7/app/NotificationCompat;->addStyleGetContentViewLollipop(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/support/v4/app/NotificationCompat$Builder;)Landroid/widget/RemoteViews;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$700(Landroid/app/Notification;Landroid/support/v4/app/NotificationCompat$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroid/app/Notification;
    .param p1, "x1"    # Landroid/support/v4/app/NotificationCompat$Builder;

    .line 53
    invoke-static {p0, p1}, Landroid/support/v7/app/NotificationCompat;->addBigStyleToBuilderLollipop(Landroid/app/Notification;Landroid/support/v4/app/NotificationCompat$Builder;)V

    return-void
.end method

.method static synthetic access$800(Landroid/app/Notification;Landroid/support/v4/app/NotificationCompat$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroid/app/Notification;
    .param p1, "x1"    # Landroid/support/v4/app/NotificationCompat$Builder;

    .line 53
    invoke-static {p0, p1}, Landroid/support/v7/app/NotificationCompat;->addHeadsUpToBuilderLollipop(Landroid/app/Notification;Landroid/support/v4/app/NotificationCompat$Builder;)V

    return-void
.end method

.method static synthetic access$900(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/support/v4/app/NotificationCompat$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;
    .param p1, "x1"    # Landroid/support/v4/app/NotificationCompat$Builder;

    .line 53
    invoke-static {p0, p1}, Landroid/support/v7/app/NotificationCompat;->addStyleToBuilderApi24(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/support/v4/app/NotificationCompat$Builder;)V

    return-void
.end method

.method private static addBigStyleToBuilderJellybean(Landroid/app/Notification;Landroid/support/v4/app/NotificationCompat$Builder;)V
    .locals 21
    .param p0, "n"    # Landroid/app/Notification;
    .param p1, "b"    # Landroid/support/v4/app/NotificationCompat$Builder;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0x10
    .end annotation

    .line 257
    move-object/from16 v0, p1

    iget-object v1, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    instance-of v1, v1, Landroid/support/v7/app/NotificationCompat$MediaStyle;

    if-eqz v1, :cond_3

    .line 258
    iget-object v1, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    check-cast v1, Landroid/support/v7/app/NotificationCompat$MediaStyle;

    .line 259
    .local v1, "mediaStyle":Landroid/support/v7/app/NotificationCompat$MediaStyle;
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getBigContentView()Landroid/widget/RemoteViews;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 260
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getBigContentView()Landroid/widget/RemoteViews;

    move-result-object v2

    goto :goto_0

    .line 261
    :cond_0
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getContentView()Landroid/widget/RemoteViews;

    move-result-object v2

    :goto_0
    nop

    .line 262
    .local v2, "innerView":Landroid/widget/RemoteViews;
    iget-object v3, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    instance-of v3, v3, Landroid/support/v7/app/NotificationCompat$DecoratedMediaCustomViewStyle;

    if-eqz v3, :cond_1

    if-eqz v2, :cond_1

    const/4 v3, 0x1

    goto :goto_1

    :cond_1
    const/4 v3, 0x0

    .local v3, "isDecorated":Z
    :goto_1
    move/from16 v20, v3

    .line 264
    iget-object v5, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    iget-object v6, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContentTitle:Ljava/lang/CharSequence;

    iget-object v7, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContentText:Ljava/lang/CharSequence;

    iget-object v8, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContentInfo:Ljava/lang/CharSequence;

    iget v9, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mNumber:I

    iget-object v10, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mLargeIcon:Landroid/graphics/Bitmap;

    iget-object v11, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mSubText:Ljava/lang/CharSequence;

    iget-boolean v12, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mUseChronometer:Z

    .line 266
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getWhenIfShowing()J

    move-result-wide v13

    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getPriority()I

    move-result v15

    const/16 v16, 0x0

    iget-object v4, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mActions:Ljava/util/ArrayList;

    move-object/from16 v17, v4

    iget-boolean v4, v1, Landroid/support/v7/app/NotificationCompat$MediaStyle;->mShowCancelButton:Z

    move/from16 v18, v4

    iget-object v4, v1, Landroid/support/v7/app/NotificationCompat$MediaStyle;->mCancelButtonIntent:Landroid/app/PendingIntent;

    move-object/from16 v19, v4

    .line 264
    move-object/from16 v4, p0

    invoke-static/range {v4 .. v20}, Landroid/support/v7/app/NotificationCompatImplBase;->overrideMediaBigContentView(Landroid/app/Notification;Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJIILjava/util/List;ZLandroid/app/PendingIntent;Z)V

    .line 269
    if-eqz v3, :cond_2

    .line 270
    iget-object v4, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    move-object/from16 v5, p0

    iget-object v6, v5, Landroid/app/Notification;->bigContentView:Landroid/widget/RemoteViews;

    invoke-static {v4, v6, v2}, Landroid/support/v7/app/NotificationCompatImplBase;->buildIntoRemoteViews(Landroid/content/Context;Landroid/widget/RemoteViews;Landroid/widget/RemoteViews;)V

    goto :goto_2

    .line 269
    :cond_2
    move-object/from16 v5, p0

    goto :goto_2

    .line 273
    .end local v1    # "mediaStyle":Landroid/support/v7/app/NotificationCompat$MediaStyle;
    .end local v2    # "innerView":Landroid/widget/RemoteViews;
    .end local v3    # "isDecorated":Z
    :cond_3
    move-object/from16 v5, p0

    iget-object v1, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    instance-of v1, v1, Landroid/support/v7/app/NotificationCompat$DecoratedCustomViewStyle;

    if-eqz v1, :cond_4

    .line 274
    invoke-static/range {p0 .. p1}, Landroid/support/v7/app/NotificationCompat;->addDecoratedBigStyleToBuilderJellybean(Landroid/app/Notification;Landroid/support/v4/app/NotificationCompat$Builder;)V

    goto :goto_3

    .line 273
    :cond_4
    :goto_2
    nop

    .line 276
    :goto_3
    return-void
.end method

.method private static addBigStyleToBuilderLollipop(Landroid/app/Notification;Landroid/support/v4/app/NotificationCompat$Builder;)V
    .locals 18
    .param p0, "n"    # Landroid/app/Notification;
    .param p1, "b"    # Landroid/support/v4/app/NotificationCompat$Builder;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x15
    .end annotation

    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0x15
    .end annotation

    .line 336
    move-object/from16 v0, p0

    move-object/from16 v15, p1

    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getBigContentView()Landroid/widget/RemoteViews;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 337
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getBigContentView()Landroid/widget/RemoteViews;

    move-result-object v1

    goto :goto_0

    .line 338
    :cond_0
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getContentView()Landroid/widget/RemoteViews;

    move-result-object v1

    :goto_0
    move-object v14, v1

    .line 339
    .local v14, "innerView":Landroid/widget/RemoteViews;
    iget-object v1, v15, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    instance-of v1, v1, Landroid/support/v7/app/NotificationCompat$DecoratedMediaCustomViewStyle;

    if-eqz v1, :cond_1

    if-eqz v14, :cond_1

    .line 340
    iget-object v1, v15, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    iget-object v2, v15, Landroid/support/v4/app/NotificationCompat$Builder;->mContentTitle:Ljava/lang/CharSequence;

    iget-object v3, v15, Landroid/support/v4/app/NotificationCompat$Builder;->mContentText:Ljava/lang/CharSequence;

    iget-object v4, v15, Landroid/support/v4/app/NotificationCompat$Builder;->mContentInfo:Ljava/lang/CharSequence;

    iget v5, v15, Landroid/support/v4/app/NotificationCompat$Builder;->mNumber:I

    iget-object v6, v15, Landroid/support/v4/app/NotificationCompat$Builder;->mLargeIcon:Landroid/graphics/Bitmap;

    iget-object v7, v15, Landroid/support/v4/app/NotificationCompat$Builder;->mSubText:Ljava/lang/CharSequence;

    iget-boolean v8, v15, Landroid/support/v4/app/NotificationCompat$Builder;->mUseChronometer:Z

    .line 342
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getWhenIfShowing()J

    move-result-wide v9

    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getPriority()I

    move-result v11

    const/4 v12, 0x0

    iget-object v13, v15, Landroid/support/v4/app/NotificationCompat$Builder;->mActions:Ljava/util/ArrayList;

    const/16 v16, 0x0

    move-object/from16 v17, v14

    .end local v14    # "innerView":Landroid/widget/RemoteViews;
    .local v17, "innerView":Landroid/widget/RemoteViews;
    move/from16 v14, v16

    const/16 v16, 0x0

    move-object/from16 v15, v16

    const/16 v16, 0x1

    .line 340
    move-object/from16 v0, p0

    invoke-static/range {v0 .. v16}, Landroid/support/v7/app/NotificationCompatImplBase;->overrideMediaBigContentView(Landroid/app/Notification;Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJIILjava/util/List;ZLandroid/app/PendingIntent;Z)V

    .line 345
    move-object/from16 v0, p1

    iget-object v1, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    move-object/from16 v2, p0

    iget-object v3, v2, Landroid/app/Notification;->bigContentView:Landroid/widget/RemoteViews;

    move-object/from16 v4, v17

    .end local v17    # "innerView":Landroid/widget/RemoteViews;
    .local v4, "innerView":Landroid/widget/RemoteViews;
    invoke-static {v1, v3, v4}, Landroid/support/v7/app/NotificationCompatImplBase;->buildIntoRemoteViews(Landroid/content/Context;Landroid/widget/RemoteViews;Landroid/widget/RemoteViews;)V

    .line 347
    iget-object v1, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    iget-object v3, v2, Landroid/app/Notification;->bigContentView:Landroid/widget/RemoteViews;

    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getColor()I

    move-result v5

    invoke-static {v1, v3, v5}, Landroid/support/v7/app/NotificationCompat;->setBackgroundColor(Landroid/content/Context;Landroid/widget/RemoteViews;I)V

    goto :goto_1

    .line 339
    .end local v4    # "innerView":Landroid/widget/RemoteViews;
    .restart local v14    # "innerView":Landroid/widget/RemoteViews;
    :cond_1
    move-object v2, v0

    move-object v4, v14

    move-object v0, v15

    .line 348
    .end local v14    # "innerView":Landroid/widget/RemoteViews;
    .restart local v4    # "innerView":Landroid/widget/RemoteViews;
    iget-object v1, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    instance-of v1, v1, Landroid/support/v7/app/NotificationCompat$DecoratedCustomViewStyle;

    if-eqz v1, :cond_2

    .line 349
    invoke-static/range {p0 .. p1}, Landroid/support/v7/app/NotificationCompat;->addDecoratedBigStyleToBuilderJellybean(Landroid/app/Notification;Landroid/support/v4/app/NotificationCompat$Builder;)V

    goto :goto_1

    .line 348
    :cond_2
    nop

    .line 351
    :goto_1
    return-void
.end method

.method private static addDecoratedBigStyleToBuilderJellybean(Landroid/app/Notification;Landroid/support/v4/app/NotificationCompat$Builder;)V
    .locals 21
    .param p0, "n"    # Landroid/app/Notification;
    .param p1, "b"    # Landroid/support/v4/app/NotificationCompat$Builder;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0x10
    .end annotation

    .line 298
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getBigContentView()Landroid/widget/RemoteViews;

    move-result-object v2

    .line 299
    .local v2, "bigContentView":Landroid/widget/RemoteViews;
    if-eqz v2, :cond_0

    move-object v3, v2

    goto :goto_0

    :cond_0
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getContentView()Landroid/widget/RemoteViews;

    move-result-object v3

    .line 300
    .local v3, "innerView":Landroid/widget/RemoteViews;
    :goto_0
    if-nez v3, :cond_1

    .line 302
    return-void

    .line 304
    :cond_1
    iget-object v4, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    iget-object v5, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mContentTitle:Ljava/lang/CharSequence;

    iget-object v6, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mContentText:Ljava/lang/CharSequence;

    iget-object v7, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mContentInfo:Ljava/lang/CharSequence;

    iget v8, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mNumber:I

    iget v9, v0, Landroid/app/Notification;->icon:I

    iget-object v10, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mLargeIcon:Landroid/graphics/Bitmap;

    iget-object v11, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mSubText:Ljava/lang/CharSequence;

    iget-boolean v12, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mUseChronometer:Z

    .line 306
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getWhenIfShowing()J

    move-result-wide v13

    .line 307
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getPriority()I

    move-result v15

    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getColor()I

    move-result v16

    sget v17, Landroid/support/v7/appcompat/R$layout;->notification_template_custom_big:I

    const/16 v18, 0x0

    move-object/from16 v20, v2

    .end local v2    # "bigContentView":Landroid/widget/RemoteViews;
    .local v20, "bigContentView":Landroid/widget/RemoteViews;
    iget-object v2, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mActions:Ljava/util/ArrayList;

    .line 304
    move-object/from16 v19, v2

    invoke-static/range {v4 .. v19}, Landroid/support/v7/app/NotificationCompatImplBase;->applyStandardTemplateWithActions(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;IILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJIIIZLjava/util/ArrayList;)Landroid/widget/RemoteViews;

    move-result-object v2

    .line 309
    .local v2, "remoteViews":Landroid/widget/RemoteViews;
    iget-object v4, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    invoke-static {v4, v2, v3}, Landroid/support/v7/app/NotificationCompatImplBase;->buildIntoRemoteViews(Landroid/content/Context;Landroid/widget/RemoteViews;Landroid/widget/RemoteViews;)V

    .line 310
    iput-object v2, v0, Landroid/app/Notification;->bigContentView:Landroid/widget/RemoteViews;

    .line 311
    return-void
.end method

.method private static addDecoratedHeadsUpToBuilderLollipop(Landroid/app/Notification;Landroid/support/v4/app/NotificationCompat$Builder;)V
    .locals 21
    .param p0, "n"    # Landroid/app/Notification;
    .param p1, "b"    # Landroid/support/v4/app/NotificationCompat$Builder;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x15
    .end annotation

    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0x15
    .end annotation

    .line 317
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getHeadsUpContentView()Landroid/widget/RemoteViews;

    move-result-object v2

    .line 318
    .local v2, "headsUp":Landroid/widget/RemoteViews;
    if-eqz v2, :cond_0

    move-object v3, v2

    goto :goto_0

    :cond_0
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getContentView()Landroid/widget/RemoteViews;

    move-result-object v3

    .line 319
    .local v3, "innerView":Landroid/widget/RemoteViews;
    :goto_0
    if-nez v2, :cond_1

    .line 321
    return-void

    .line 323
    :cond_1
    iget-object v4, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    iget-object v5, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mContentTitle:Ljava/lang/CharSequence;

    iget-object v6, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mContentText:Ljava/lang/CharSequence;

    iget-object v7, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mContentInfo:Ljava/lang/CharSequence;

    iget v8, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mNumber:I

    iget v9, v0, Landroid/app/Notification;->icon:I

    iget-object v10, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mLargeIcon:Landroid/graphics/Bitmap;

    iget-object v11, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mSubText:Ljava/lang/CharSequence;

    iget-boolean v12, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mUseChronometer:Z

    .line 325
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getWhenIfShowing()J

    move-result-wide v13

    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getPriority()I

    move-result v15

    .line 326
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getColor()I

    move-result v16

    sget v17, Landroid/support/v7/appcompat/R$layout;->notification_template_custom_big:I

    const/16 v18, 0x0

    move-object/from16 v20, v2

    .end local v2    # "headsUp":Landroid/widget/RemoteViews;
    .local v20, "headsUp":Landroid/widget/RemoteViews;
    iget-object v2, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mActions:Ljava/util/ArrayList;

    .line 323
    move-object/from16 v19, v2

    invoke-static/range {v4 .. v19}, Landroid/support/v7/app/NotificationCompatImplBase;->applyStandardTemplateWithActions(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;IILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJIIIZLjava/util/ArrayList;)Landroid/widget/RemoteViews;

    move-result-object v2

    .line 328
    .local v2, "remoteViews":Landroid/widget/RemoteViews;
    iget-object v4, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    invoke-static {v4, v2, v3}, Landroid/support/v7/app/NotificationCompatImplBase;->buildIntoRemoteViews(Landroid/content/Context;Landroid/widget/RemoteViews;Landroid/widget/RemoteViews;)V

    .line 329
    iput-object v2, v0, Landroid/app/Notification;->headsUpContentView:Landroid/widget/RemoteViews;

    .line 330
    return-void
.end method

.method private static addHeadsUpToBuilderLollipop(Landroid/app/Notification;Landroid/support/v4/app/NotificationCompat$Builder;)V
    .locals 20
    .param p0, "n"    # Landroid/app/Notification;
    .param p1, "b"    # Landroid/support/v4/app/NotificationCompat$Builder;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x15
    .end annotation

    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0x15
    .end annotation

    .line 365
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getHeadsUpContentView()Landroid/widget/RemoteViews;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 366
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getHeadsUpContentView()Landroid/widget/RemoteViews;

    move-result-object v2

    goto :goto_0

    .line 367
    :cond_0
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getContentView()Landroid/widget/RemoteViews;

    move-result-object v2

    :goto_0
    nop

    .line 368
    .local v2, "innerView":Landroid/widget/RemoteViews;
    iget-object v3, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    instance-of v3, v3, Landroid/support/v7/app/NotificationCompat$DecoratedMediaCustomViewStyle;

    if-eqz v3, :cond_1

    if-eqz v2, :cond_1

    .line 369
    iget-object v4, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    iget-object v5, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mContentTitle:Ljava/lang/CharSequence;

    iget-object v6, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mContentText:Ljava/lang/CharSequence;

    iget-object v7, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mContentInfo:Ljava/lang/CharSequence;

    iget v8, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mNumber:I

    iget-object v9, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mLargeIcon:Landroid/graphics/Bitmap;

    iget-object v10, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mSubText:Ljava/lang/CharSequence;

    iget-boolean v11, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mUseChronometer:Z

    .line 371
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getWhenIfShowing()J

    move-result-wide v12

    .line 372
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getPriority()I

    move-result v14

    const/4 v15, 0x0

    iget-object v3, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mActions:Ljava/util/ArrayList;

    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x1

    .line 369
    move-object/from16 v16, v3

    invoke-static/range {v4 .. v19}, Landroid/support/v7/app/NotificationCompatImplBase;->generateMediaBigView(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJIILjava/util/List;ZLandroid/app/PendingIntent;Z)Landroid/widget/RemoteViews;

    move-result-object v3

    iput-object v3, v0, Landroid/app/Notification;->headsUpContentView:Landroid/widget/RemoteViews;

    .line 374
    iget-object v3, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    iget-object v4, v0, Landroid/app/Notification;->headsUpContentView:Landroid/widget/RemoteViews;

    invoke-static {v3, v4, v2}, Landroid/support/v7/app/NotificationCompatImplBase;->buildIntoRemoteViews(Landroid/content/Context;Landroid/widget/RemoteViews;Landroid/widget/RemoteViews;)V

    .line 376
    iget-object v3, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    iget-object v4, v0, Landroid/app/Notification;->headsUpContentView:Landroid/widget/RemoteViews;

    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getColor()I

    move-result v5

    invoke-static {v3, v4, v5}, Landroid/support/v7/app/NotificationCompat;->setBackgroundColor(Landroid/content/Context;Landroid/widget/RemoteViews;I)V

    goto :goto_1

    .line 368
    :cond_1
    nop

    .line 377
    iget-object v3, v1, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    instance-of v3, v3, Landroid/support/v7/app/NotificationCompat$DecoratedCustomViewStyle;

    if-eqz v3, :cond_2

    .line 378
    invoke-static/range {p0 .. p1}, Landroid/support/v7/app/NotificationCompat;->addDecoratedHeadsUpToBuilderLollipop(Landroid/app/Notification;Landroid/support/v4/app/NotificationCompat$Builder;)V

    goto :goto_1

    .line 377
    :cond_2
    nop

    .line 380
    :goto_1
    return-void
.end method

.method private static addMessagingFallBackStyle(Landroid/support/v4/app/NotificationCompat$MessagingStyle;Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/support/v4/app/NotificationCompat$Builder;)V
    .locals 9
    .param p0, "style"    # Landroid/support/v4/app/NotificationCompat$MessagingStyle;
    .param p1, "builder"    # Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;
    .param p2, "b"    # Landroid/support/v4/app/NotificationCompat$Builder;

    .line 201
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 202
    .local v0, "completeMessage":Landroid/text/SpannableStringBuilder;
    invoke-virtual {p0}, Landroid/support/v4/app/NotificationCompat$MessagingStyle;->getMessages()Ljava/util/List;

    move-result-object v1

    .line 203
    .local v1, "messages":Ljava/util/List;, "Ljava/util/List<Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;>;"
    invoke-virtual {p0}, Landroid/support/v4/app/NotificationCompat$MessagingStyle;->getConversationTitle()Ljava/lang/CharSequence;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x1

    if-nez v2, :cond_1

    .line 204
    invoke-virtual {p0}, Landroid/support/v4/app/NotificationCompat$MessagingStyle;->getMessages()Ljava/util/List;

    move-result-object v2

    invoke-static {v2}, Landroid/support/v7/app/NotificationCompat;->hasMessagesWithoutSender(Ljava/util/List;)Z

    move-result v2

    if-eqz v2, :cond_0

    goto :goto_0

    :cond_0
    const/4 v2, 0x0

    goto :goto_1

    .line 203
    :cond_1
    nop

    .line 204
    :goto_0
    const/4 v2, 0x1

    .line 205
    .local v2, "showNames":Z
    :goto_1
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v5

    sub-int/2addr v5, v4

    .local v5, "i":I
    :goto_2
    if-ltz v5, :cond_4

    .line 206
    invoke-interface {v1, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;

    .line 208
    .local v6, "m":Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;
    if-eqz v2, :cond_2

    invoke-static {p2, p0, v6}, Landroid/support/v7/app/NotificationCompat;->makeMessageLine(Landroid/support/v4/app/NotificationCompat$Builder;Landroid/support/v4/app/NotificationCompat$MessagingStyle;Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;)Ljava/lang/CharSequence;

    move-result-object v7

    goto :goto_3

    :cond_2
    invoke-virtual {v6}, Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;->getText()Ljava/lang/CharSequence;

    move-result-object v7

    .line 209
    .local v7, "line":Ljava/lang/CharSequence;
    :goto_3
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v8

    sub-int/2addr v8, v4

    if-eq v5, v8, :cond_3

    .line 210
    const-string v8, "\n"

    invoke-virtual {v0, v3, v8}, Landroid/text/SpannableStringBuilder;->insert(ILjava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    goto :goto_4

    .line 209
    :cond_3
    nop

    .line 212
    :goto_4
    invoke-virtual {v0, v3, v7}, Landroid/text/SpannableStringBuilder;->insert(ILjava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 205
    .end local v6    # "m":Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;
    .end local v7    # "line":Ljava/lang/CharSequence;
    add-int/lit8 v5, v5, -0x1

    goto :goto_2

    .line 214
    .end local v5    # "i":I
    :cond_4
    invoke-static {p1, v0}, Landroid/support/v7/app/NotificationCompatImplJellybean;->addBigTextStyle(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Ljava/lang/CharSequence;)V

    .line 215
    return-void
.end method

.method private static addStyleGetContentViewIcs(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/support/v4/app/NotificationCompat$Builder;)Landroid/widget/RemoteViews;
    .locals 20
    .param p0, "builder"    # Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;
    .param p1, "b"    # Landroid/support/v4/app/NotificationCompat$Builder;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0xe
    .end annotation

    .line 233
    move-object/from16 v0, p1

    iget-object v1, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    instance-of v1, v1, Landroid/support/v7/app/NotificationCompat$MediaStyle;

    if-eqz v1, :cond_3

    .line 234
    iget-object v1, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    check-cast v1, Landroid/support/v7/app/NotificationCompat$MediaStyle;

    .line 235
    .local v1, "mediaStyle":Landroid/support/v7/app/NotificationCompat$MediaStyle;
    iget-object v2, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    instance-of v2, v2, Landroid/support/v7/app/NotificationCompat$DecoratedMediaCustomViewStyle;

    if-eqz v2, :cond_1

    .line 236
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getContentView()Landroid/widget/RemoteViews;

    move-result-object v2

    if-eqz v2, :cond_0

    const/4 v2, 0x1

    goto :goto_1

    :cond_0
    goto :goto_0

    .line 235
    :cond_1
    nop

    .line 236
    :goto_0
    const/4 v2, 0x0

    .local v2, "isDecorated":Z
    :goto_1
    move/from16 v19, v2

    .line 237
    iget-object v4, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    iget-object v5, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContentTitle:Ljava/lang/CharSequence;

    iget-object v6, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContentText:Ljava/lang/CharSequence;

    iget-object v7, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContentInfo:Ljava/lang/CharSequence;

    iget v8, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mNumber:I

    iget-object v9, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mLargeIcon:Landroid/graphics/Bitmap;

    iget-object v10, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mSubText:Ljava/lang/CharSequence;

    iget-boolean v11, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mUseChronometer:Z

    .line 239
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getWhenIfShowing()J

    move-result-wide v12

    .line 240
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getPriority()I

    move-result v14

    iget-object v15, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mActions:Ljava/util/ArrayList;

    iget-object v3, v1, Landroid/support/v7/app/NotificationCompat$MediaStyle;->mActionsToShowInCompact:[I

    move-object/from16 v16, v3

    iget-boolean v3, v1, Landroid/support/v7/app/NotificationCompat$MediaStyle;->mShowCancelButton:Z

    move/from16 v17, v3

    iget-object v3, v1, Landroid/support/v7/app/NotificationCompat$MediaStyle;->mCancelButtonIntent:Landroid/app/PendingIntent;

    move-object/from16 v18, v3

    .line 237
    move-object/from16 v3, p0

    invoke-static/range {v3 .. v19}, Landroid/support/v7/app/NotificationCompatImplBase;->overrideContentViewMedia(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJILjava/util/List;[IZLandroid/app/PendingIntent;Z)Landroid/widget/RemoteViews;

    move-result-object v3

    .line 242
    .local v3, "contentViewMedia":Landroid/widget/RemoteViews;
    if-eqz v2, :cond_2

    .line 243
    iget-object v4, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    .line 244
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getContentView()Landroid/widget/RemoteViews;

    move-result-object v5

    .line 243
    invoke-static {v4, v3, v5}, Landroid/support/v7/app/NotificationCompatImplBase;->buildIntoRemoteViews(Landroid/content/Context;Landroid/widget/RemoteViews;Landroid/widget/RemoteViews;)V

    .line 245
    return-object v3

    .line 242
    :cond_2
    nop

    .end local v1    # "mediaStyle":Landroid/support/v7/app/NotificationCompat$MediaStyle;
    .end local v2    # "isDecorated":Z
    .end local v3    # "contentViewMedia":Landroid/widget/RemoteViews;
    goto :goto_2

    .line 247
    :cond_3
    iget-object v1, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    instance-of v1, v1, Landroid/support/v7/app/NotificationCompat$DecoratedCustomViewStyle;

    if-eqz v1, :cond_4

    .line 248
    invoke-static/range {p1 .. p1}, Landroid/support/v7/app/NotificationCompat;->getDecoratedContentView(Landroid/support/v4/app/NotificationCompat$Builder;)Landroid/widget/RemoteViews;

    move-result-object v1

    return-object v1

    .line 247
    :cond_4
    :goto_2
    nop

    .line 250
    const/4 v1, 0x0

    return-object v1
.end method

.method private static addStyleGetContentViewJellybean(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/support/v4/app/NotificationCompat$Builder;)Landroid/widget/RemoteViews;
    .locals 1
    .param p0, "builder"    # Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;
    .param p1, "b"    # Landroid/support/v4/app/NotificationCompat$Builder;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0x10
    .end annotation

    .line 145
    iget-object v0, p1, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    instance-of v0, v0, Landroid/support/v4/app/NotificationCompat$MessagingStyle;

    if-eqz v0, :cond_0

    .line 146
    iget-object v0, p1, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    check-cast v0, Landroid/support/v4/app/NotificationCompat$MessagingStyle;

    invoke-static {v0, p0, p1}, Landroid/support/v7/app/NotificationCompat;->addMessagingFallBackStyle(Landroid/support/v4/app/NotificationCompat$MessagingStyle;Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/support/v4/app/NotificationCompat$Builder;)V

    goto :goto_0

    .line 145
    :cond_0
    nop

    .line 148
    :goto_0
    invoke-static {p0, p1}, Landroid/support/v7/app/NotificationCompat;->addStyleGetContentViewIcs(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/support/v4/app/NotificationCompat$Builder;)Landroid/widget/RemoteViews;

    move-result-object v0

    return-object v0
.end method

.method private static addStyleGetContentViewLollipop(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/support/v4/app/NotificationCompat$Builder;)Landroid/widget/RemoteViews;
    .locals 23
    .param p0, "builder"    # Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;
    .param p1, "b"    # Landroid/support/v4/app/NotificationCompat$Builder;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x15
    .end annotation

    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0x15
    .end annotation

    .line 105
    move-object/from16 v0, p1

    iget-object v1, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    instance-of v1, v1, Landroid/support/v7/app/NotificationCompat$MediaStyle;

    if-eqz v1, :cond_8

    .line 106
    iget-object v1, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    check-cast v1, Landroid/support/v7/app/NotificationCompat$MediaStyle;

    .line 107
    .local v1, "mediaStyle":Landroid/support/v7/app/NotificationCompat$MediaStyle;
    iget-object v2, v1, Landroid/support/v7/app/NotificationCompat$MediaStyle;->mActionsToShowInCompact:[I

    iget-object v3, v1, Landroid/support/v7/app/NotificationCompat$MediaStyle;->mToken:Landroid/support/v4/media/session/MediaSessionCompat$Token;

    const/4 v4, 0x0

    if-eqz v3, :cond_0

    iget-object v3, v1, Landroid/support/v7/app/NotificationCompat$MediaStyle;->mToken:Landroid/support/v4/media/session/MediaSessionCompat$Token;

    .line 109
    invoke-virtual {v3}, Landroid/support/v4/media/session/MediaSessionCompat$Token;->getToken()Ljava/lang/Object;

    move-result-object v3

    goto :goto_0

    :cond_0
    move-object v3, v4

    .line 107
    :goto_0
    move-object/from16 v5, p0

    invoke-static {v5, v2, v3}, Landroid/support/v7/app/NotificationCompatImpl21;->addMediaStyle(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;[ILjava/lang/Object;)V

    .line 111
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getContentView()Landroid/widget/RemoteViews;

    move-result-object v2

    const/4 v3, 0x1

    const/4 v6, 0x0

    if-eqz v2, :cond_1

    const/4 v2, 0x1

    goto :goto_1

    :cond_1
    const/4 v2, 0x0

    .line 115
    .local v2, "hasContentView":Z
    :goto_1
    sget v7, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v8, 0x15

    if-lt v7, v8, :cond_2

    sget v7, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v8, 0x17

    if-gt v7, v8, :cond_2

    const/4 v7, 0x1

    goto :goto_2

    :cond_2
    const/4 v7, 0x0

    :goto_2
    move/from16 v22, v7

    .line 117
    .local v22, "isMorL":Z
    if-nez v2, :cond_5

    if-eqz v22, :cond_4

    .line 118
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getBigContentView()Landroid/widget/RemoteViews;

    move-result-object v7

    if-eqz v7, :cond_3

    goto :goto_4

    :cond_3
    goto :goto_3

    .line 117
    :cond_4
    nop

    .line 118
    :goto_3
    const/4 v3, 0x0

    goto :goto_5

    .line 117
    :cond_5
    nop

    .line 118
    :goto_4
    nop

    .line 119
    .local v3, "createCustomContent":Z
    :goto_5
    iget-object v6, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    instance-of v6, v6, Landroid/support/v7/app/NotificationCompat$DecoratedMediaCustomViewStyle;

    if-eqz v6, :cond_7

    if-eqz v3, :cond_7

    .line 120
    iget-object v6, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    iget-object v7, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContentTitle:Ljava/lang/CharSequence;

    iget-object v8, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContentText:Ljava/lang/CharSequence;

    iget-object v9, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContentInfo:Ljava/lang/CharSequence;

    iget v10, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mNumber:I

    iget-object v11, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mLargeIcon:Landroid/graphics/Bitmap;

    iget-object v12, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mSubText:Ljava/lang/CharSequence;

    iget-boolean v13, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mUseChronometer:Z

    .line 123
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getWhenIfShowing()J

    move-result-wide v14

    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getPriority()I

    move-result v16

    iget-object v4, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mActions:Ljava/util/ArrayList;

    move-object/from16 v17, v4

    iget-object v4, v1, Landroid/support/v7/app/NotificationCompat$MediaStyle;->mActionsToShowInCompact:[I

    move-object/from16 v18, v4

    const/16 v19, 0x0

    const/16 v20, 0x0

    .line 120
    move-object/from16 v5, p0

    move/from16 v21, v2

    invoke-static/range {v5 .. v21}, Landroid/support/v7/app/NotificationCompatImplBase;->overrideContentViewMedia(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJILjava/util/List;[IZLandroid/app/PendingIntent;Z)Landroid/widget/RemoteViews;

    move-result-object v4

    .line 126
    .local v4, "contentViewMedia":Landroid/widget/RemoteViews;
    if-eqz v2, :cond_6

    .line 127
    iget-object v5, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    .line 128
    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getContentView()Landroid/widget/RemoteViews;

    move-result-object v6

    .line 127
    invoke-static {v5, v4, v6}, Landroid/support/v7/app/NotificationCompatImplBase;->buildIntoRemoteViews(Landroid/content/Context;Landroid/widget/RemoteViews;Landroid/widget/RemoteViews;)V

    goto :goto_6

    .line 126
    :cond_6
    nop

    .line 130
    :goto_6
    iget-object v5, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    invoke-virtual/range {p1 .. p1}, Landroid/support/v4/app/NotificationCompat$Builder;->getColor()I

    move-result v6

    invoke-static {v5, v4, v6}, Landroid/support/v7/app/NotificationCompat;->setBackgroundColor(Landroid/content/Context;Landroid/widget/RemoteViews;I)V

    .line 131
    return-object v4

    .line 119
    .end local v4    # "contentViewMedia":Landroid/widget/RemoteViews;
    :cond_7
    nop

    .line 133
    return-object v4

    .line 134
    .end local v1    # "mediaStyle":Landroid/support/v7/app/NotificationCompat$MediaStyle;
    .end local v2    # "hasContentView":Z
    .end local v3    # "createCustomContent":Z
    .end local v22    # "isMorL":Z
    :cond_8
    iget-object v1, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    instance-of v1, v1, Landroid/support/v7/app/NotificationCompat$DecoratedCustomViewStyle;

    if-eqz v1, :cond_9

    .line 135
    invoke-static/range {p1 .. p1}, Landroid/support/v7/app/NotificationCompat;->getDecoratedContentView(Landroid/support/v4/app/NotificationCompat$Builder;)Landroid/widget/RemoteViews;

    move-result-object v1

    return-object v1

    .line 137
    :cond_9
    invoke-static/range {p0 .. p1}, Landroid/support/v7/app/NotificationCompat;->addStyleGetContentViewJellybean(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/support/v4/app/NotificationCompat$Builder;)Landroid/widget/RemoteViews;

    move-result-object v1

    return-object v1
.end method

.method private static addStyleToBuilderApi24(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/support/v4/app/NotificationCompat$Builder;)V
    .locals 1
    .param p0, "builder"    # Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;
    .param p1, "b"    # Landroid/support/v4/app/NotificationCompat$Builder;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x18
    .end annotation

    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0x18
    .end annotation

    .line 91
    iget-object v0, p1, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    instance-of v0, v0, Landroid/support/v7/app/NotificationCompat$DecoratedCustomViewStyle;

    if-eqz v0, :cond_0

    .line 92
    invoke-static {p0}, Landroid/support/v7/app/NotificationCompatImpl24;->addDecoratedCustomViewStyle(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;)V

    goto :goto_0

    .line 93
    :cond_0
    iget-object v0, p1, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    instance-of v0, v0, Landroid/support/v7/app/NotificationCompat$DecoratedMediaCustomViewStyle;

    if-eqz v0, :cond_1

    .line 94
    invoke-static {p0}, Landroid/support/v7/app/NotificationCompatImpl24;->addDecoratedMediaCustomViewStyle(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;)V

    goto :goto_0

    .line 95
    :cond_1
    iget-object v0, p1, Landroid/support/v4/app/NotificationCompat$Builder;->mStyle:Landroid/support/v4/app/NotificationCompat$Style;

    instance-of v0, v0, Landroid/support/v4/app/NotificationCompat$MessagingStyle;

    if-nez v0, :cond_2

    .line 96
    invoke-static {p0, p1}, Landroid/support/v7/app/NotificationCompat;->addStyleGetContentViewLollipop(Landroid/support/v4/app/NotificationBuilderWithBuilderAccessor;Landroid/support/v4/app/NotificationCompat$Builder;)Landroid/widget/RemoteViews;

    goto :goto_0

    .line 95
    :cond_2
    nop

    .line 98
    :goto_0
    return-void
.end method

.method private static findLatestIncomingMessage(Landroid/support/v4/app/NotificationCompat$MessagingStyle;)Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;
    .locals 4
    .param p0, "style"    # Landroid/support/v4/app/NotificationCompat$MessagingStyle;

    .line 152
    invoke-virtual {p0}, Landroid/support/v4/app/NotificationCompat$MessagingStyle;->getMessages()Ljava/util/List;

    move-result-object v0

    .line 153
    .local v0, "messages":Ljava/util/List;, "Ljava/util/List<Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    .local v1, "i":I
    :goto_0
    if-ltz v1, :cond_1

    .line 154
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;

    .line 156
    .local v2, "m":Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;
    invoke-virtual {v2}, Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;->getSender()Ljava/lang/CharSequence;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 157
    return-object v2

    .line 156
    :cond_0
    nop

    .line 153
    .end local v2    # "m":Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 160
    .end local v1    # "i":I
    :cond_1
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_2

    .line 162
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;

    return-object v1

    .line 164
    :cond_2
    const/4 v1, 0x0

    return-object v1
.end method

.method private static getDecoratedContentView(Landroid/support/v4/app/NotificationCompat$Builder;)Landroid/widget/RemoteViews;
    .locals 18
    .param p0, "b"    # Landroid/support/v4/app/NotificationCompat$Builder;

    .line 280
    move-object/from16 v0, p0

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/app/NotificationCompat$Builder;->getContentView()Landroid/widget/RemoteViews;

    move-result-object v1

    if-nez v1, :cond_0

    .line 282
    const/4 v1, 0x0

    return-object v1

    .line 284
    :cond_0
    iget-object v2, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    iget-object v3, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContentTitle:Ljava/lang/CharSequence;

    iget-object v4, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContentText:Ljava/lang/CharSequence;

    iget-object v5, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContentInfo:Ljava/lang/CharSequence;

    iget v6, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mNumber:I

    iget-object v1, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mNotification:Landroid/app/Notification;

    iget v7, v1, Landroid/app/Notification;->icon:I

    iget-object v8, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mLargeIcon:Landroid/graphics/Bitmap;

    iget-object v9, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mSubText:Ljava/lang/CharSequence;

    iget-boolean v10, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mUseChronometer:Z

    .line 287
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/app/NotificationCompat$Builder;->getWhenIfShowing()J

    move-result-wide v11

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/app/NotificationCompat$Builder;->getPriority()I

    move-result v13

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/app/NotificationCompat$Builder;->getColor()I

    move-result v14

    sget v15, Landroid/support/v7/appcompat/R$layout;->notification_template_custom_big:I

    const/16 v16, 0x0

    const/16 v17, 0x0

    .line 284
    invoke-static/range {v2 .. v17}, Landroid/support/v7/app/NotificationCompatImplBase;->applyStandardTemplateWithActions(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;IILandroid/graphics/Bitmap;Ljava/lang/CharSequence;ZJIIIZLjava/util/ArrayList;)Landroid/widget/RemoteViews;

    move-result-object v1

    .line 289
    .local v1, "remoteViews":Landroid/widget/RemoteViews;
    iget-object v2, v0, Landroid/support/v4/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    .line 290
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/app/NotificationCompat$Builder;->getContentView()Landroid/widget/RemoteViews;

    move-result-object v3

    .line 289
    invoke-static {v2, v1, v3}, Landroid/support/v7/app/NotificationCompatImplBase;->buildIntoRemoteViews(Landroid/content/Context;Landroid/widget/RemoteViews;Landroid/widget/RemoteViews;)V

    .line 291
    return-object v1
.end method

.method public static getMediaSession(Landroid/app/Notification;)Landroid/support/v4/media/session/MediaSessionCompat$Token;
    .locals 4
    .param p0, "notification"    # Landroid/app/Notification;

    .line 64
    invoke-static {p0}, Landroid/support/v7/app/NotificationCompat;->getExtras(Landroid/app/Notification;)Landroid/os/Bundle;

    move-result-object v0

    .line 65
    .local v0, "extras":Landroid/os/Bundle;
    if-eqz v0, :cond_3

    .line 66
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x15

    if-lt v1, v2, :cond_1

    .line 67
    const-string v1, "android.mediaSession"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    .line 68
    .local v1, "tokenInner":Ljava/lang/Object;
    if-eqz v1, :cond_0

    .line 69
    invoke-static {v1}, Landroid/support/v4/media/session/MediaSessionCompat$Token;->fromToken(Ljava/lang/Object;)Landroid/support/v4/media/session/MediaSessionCompat$Token;

    move-result-object v2

    return-object v2

    .line 68
    :cond_0
    nop

    .line 71
    .end local v1    # "tokenInner":Ljava/lang/Object;
    goto :goto_0

    .line 72
    :cond_1
    const-string v1, "android.mediaSession"

    invoke-static {v0, v1}, Landroid/support/v4/app/BundleCompat;->getBinder(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v1

    .line 73
    .local v1, "tokenInner":Landroid/os/IBinder;
    if-eqz v1, :cond_2

    .line 74
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v2

    .line 75
    .local v2, "p":Landroid/os/Parcel;
    invoke-virtual {v2, v1}, Landroid/os/Parcel;->writeStrongBinder(Landroid/os/IBinder;)V

    .line 76
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/os/Parcel;->setDataPosition(I)V

    .line 77
    sget-object v3, Landroid/support/v4/media/session/MediaSessionCompat$Token;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 78
    invoke-interface {v3, v2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v4/media/session/MediaSessionCompat$Token;

    .line 79
    .local v3, "token":Landroid/support/v4/media/session/MediaSessionCompat$Token;
    invoke-virtual {v2}, Landroid/os/Parcel;->recycle()V

    .line 80
    return-object v3

    .line 73
    .end local v2    # "p":Landroid/os/Parcel;
    .end local v3    # "token":Landroid/support/v4/media/session/MediaSessionCompat$Token;
    :cond_2
    goto :goto_0

    .line 65
    .end local v1    # "tokenInner":Landroid/os/IBinder;
    :cond_3
    nop

    .line 84
    :goto_0
    const/4 v1, 0x0

    return-object v1
.end method

.method private static hasMessagesWithoutSender(Ljava/util/List;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;",
            ">;)Z"
        }
    .end annotation

    .line 219
    .local p0, "messages":Ljava/util/List;, "Ljava/util/List<Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;>;"
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    sub-int/2addr v0, v1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_1

    .line 220
    invoke-interface {p0, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;

    .line 221
    .local v2, "m":Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;
    invoke-virtual {v2}, Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;->getSender()Ljava/lang/CharSequence;

    move-result-object v3

    if-nez v3, :cond_0

    .line 222
    return v1

    .line 221
    :cond_0
    nop

    .line 219
    .end local v2    # "m":Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 225
    .end local v0    # "i":I
    :cond_1
    const/4 v0, 0x0

    return v0
.end method

.method private static makeFontColorSpan(I)Landroid/text/style/TextAppearanceSpan;
    .locals 7
    .param p0, "color"    # I

    .line 195
    new-instance v6, Landroid/text/style/TextAppearanceSpan;

    invoke-static {p0}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v4

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v5, 0x0

    move-object v0, v6

    invoke-direct/range {v0 .. v5}, Landroid/text/style/TextAppearanceSpan;-><init>(Ljava/lang/String;IILandroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;)V

    return-object v6
.end method

.method private static makeMessageLine(Landroid/support/v4/app/NotificationCompat$Builder;Landroid/support/v4/app/NotificationCompat$MessagingStyle;Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;)Ljava/lang/CharSequence;
    .locals 10
    .param p0, "b"    # Landroid/support/v4/app/NotificationCompat$Builder;
    .param p1, "style"    # Landroid/support/v4/app/NotificationCompat$MessagingStyle;
    .param p2, "m"    # Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;

    .line 170
    invoke-static {}, Landroid/support/v4/text/BidiFormatter;->getInstance()Landroid/support/v4/text/BidiFormatter;

    move-result-object v0

    .line 171
    .local v0, "bidi":Landroid/support/v4/text/BidiFormatter;
    new-instance v1, Landroid/text/SpannableStringBuilder;

    invoke-direct {v1}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 172
    .local v1, "sb":Landroid/text/SpannableStringBuilder;
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x15

    if-lt v2, v3, :cond_0

    const/4 v2, 0x1

    goto :goto_0

    :cond_0
    const/4 v2, 0x0

    .line 173
    .local v2, "afterLollipop":Z
    :goto_0
    if-nez v2, :cond_2

    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xa

    if-gt v3, v4, :cond_1

    goto :goto_1

    :cond_1
    const/4 v3, -0x1

    goto :goto_2

    :cond_2
    :goto_1
    const/high16 v3, -0x1000000

    .line 175
    .local v3, "color":I
    :goto_2
    invoke-virtual {p2}, Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;->getSender()Ljava/lang/CharSequence;

    move-result-object v4

    .line 176
    .local v4, "replyName":Ljava/lang/CharSequence;
    invoke-virtual {p2}, Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;->getSender()Ljava/lang/CharSequence;

    move-result-object v5

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 177
    invoke-virtual {p1}, Landroid/support/v4/app/NotificationCompat$MessagingStyle;->getUserDisplayName()Ljava/lang/CharSequence;

    move-result-object v5

    if-nez v5, :cond_3

    const-string v5, ""

    goto :goto_3

    .line 178
    :cond_3
    invoke-virtual {p1}, Landroid/support/v4/app/NotificationCompat$MessagingStyle;->getUserDisplayName()Ljava/lang/CharSequence;

    move-result-object v5

    :goto_3
    move-object v4, v5

    .line 179
    if-eqz v2, :cond_4

    invoke-virtual {p0}, Landroid/support/v4/app/NotificationCompat$Builder;->getColor()I

    move-result v5

    if-eqz v5, :cond_4

    .line 180
    invoke-virtual {p0}, Landroid/support/v4/app/NotificationCompat$Builder;->getColor()I

    move-result v5

    goto :goto_4

    .line 179
    :cond_4
    nop

    .line 180
    move v5, v3

    :goto_4
    move v3, v5

    goto :goto_5

    .line 176
    :cond_5
    nop

    .line 183
    :goto_5
    invoke-virtual {v0, v4}, Landroid/support/v4/text/BidiFormatter;->unicodeWrap(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v5

    .line 184
    .local v5, "senderText":Ljava/lang/CharSequence;
    invoke-virtual {v1, v5}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 185
    invoke-static {v3}, Landroid/support/v7/app/NotificationCompat;->makeFontColorSpan(I)Landroid/text/style/TextAppearanceSpan;

    move-result-object v6

    .line 186
    invoke-virtual {v1}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v7

    invoke-interface {v5}, Ljava/lang/CharSequence;->length()I

    move-result v8

    sub-int/2addr v7, v8

    .line 187
    invoke-virtual {v1}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v8

    const/16 v9, 0x21

    .line 185
    invoke-virtual {v1, v6, v7, v8, v9}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 189
    invoke-virtual {p2}, Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;->getText()Ljava/lang/CharSequence;

    move-result-object v6

    if-nez v6, :cond_6

    const-string v6, ""

    goto :goto_6

    :cond_6
    invoke-virtual {p2}, Landroid/support/v4/app/NotificationCompat$MessagingStyle$Message;->getText()Ljava/lang/CharSequence;

    move-result-object v6

    .line 190
    .local v6, "text":Ljava/lang/CharSequence;
    :goto_6
    const-string v7, "  "

    invoke-virtual {v1, v7}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    move-result-object v7

    invoke-virtual {v0, v6}, Landroid/support/v4/text/BidiFormatter;->unicodeWrap(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 191
    return-object v1
.end method

.method private static setBackgroundColor(Landroid/content/Context;Landroid/widget/RemoteViews;I)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "views"    # Landroid/widget/RemoteViews;
    .param p2, "color"    # I

    .line 354
    if-nez p2, :cond_0

    .line 355
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Landroid/support/v7/appcompat/R$color;->notification_material_background_media_default_color:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result p2

    goto :goto_0

    .line 354
    :cond_0
    nop

    .line 358
    :goto_0
    sget v0, Landroid/support/v7/appcompat/R$id;->status_bar_latest_event_content:I

    const-string v1, "setBackgroundColor"

    invoke-virtual {p1, v0, v1, p2}, Landroid/widget/RemoteViews;->setInt(ILjava/lang/String;I)V

    .line 359
    return-void
.end method
