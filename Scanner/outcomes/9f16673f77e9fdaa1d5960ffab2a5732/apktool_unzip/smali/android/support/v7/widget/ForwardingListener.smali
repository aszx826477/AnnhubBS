.class public abstract Landroid/support/v7/widget/ForwardingListener;
.super Ljava/lang/Object;
.source "ForwardingListener.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation build Landroid/support/annotation/RestrictTo;
    value = {
        .enum Landroid/support/annotation/RestrictTo$Scope;->LIBRARY_GROUP:Landroid/support/annotation/RestrictTo$Scope;
    }
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/widget/ForwardingListener$TriggerLongPress;,
        Landroid/support/v7/widget/ForwardingListener$DisallowIntercept;
    }
.end annotation


# instance fields
.field private mActivePointerId:I

.field private mDisallowIntercept:Ljava/lang/Runnable;

.field private mForwarding:Z

.field private final mLongPressTimeout:I

.field private final mScaledTouchSlop:F

.field final mSrc:Landroid/view/View;

.field private final mTapTimeout:I

.field private final mTmpLocation:[I

.field private mTriggerLongPress:Ljava/lang/Runnable;


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 3
    .param p1, "src"    # Landroid/view/View;

    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    const/4 v0, 0x2

    new-array v1, v0, [I

    iput-object v1, p0, Landroid/support/v7/widget/ForwardingListener;->mTmpLocation:[I

    .line 74
    iput-object p1, p0, Landroid/support/v7/widget/ForwardingListener;->mSrc:Landroid/view/View;

    .line 75
    const/4 v1, 0x1

    invoke-virtual {p1, v1}, Landroid/view/View;->setLongClickable(Z)V

    .line 77
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xc

    if-lt v1, v2, :cond_0

    .line 78
    invoke-direct {p0, p1}, Landroid/support/v7/widget/ForwardingListener;->addDetachListenerApi12(Landroid/view/View;)V

    goto :goto_0

    .line 80
    :cond_0
    invoke-direct {p0, p1}, Landroid/support/v7/widget/ForwardingListener;->addDetachListenerBase(Landroid/view/View;)V

    .line 83
    :goto_0
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v1

    int-to-float v1, v1

    iput v1, p0, Landroid/support/v7/widget/ForwardingListener;->mScaledTouchSlop:F

    .line 84
    invoke-static {}, Landroid/view/ViewConfiguration;->getTapTimeout()I

    move-result v1

    iput v1, p0, Landroid/support/v7/widget/ForwardingListener;->mTapTimeout:I

    .line 87
    iget v1, p0, Landroid/support/v7/widget/ForwardingListener;->mTapTimeout:I

    invoke-static {}, Landroid/view/ViewConfiguration;->getLongPressTimeout()I

    move-result v2

    add-int/2addr v1, v2

    div-int/2addr v1, v0

    iput v1, p0, Landroid/support/v7/widget/ForwardingListener;->mLongPressTimeout:I

    .line 88
    return-void
.end method

.method static synthetic access$000(Landroid/support/v7/widget/ForwardingListener;)V
    .locals 0
    .param p0, "x0"    # Landroid/support/v7/widget/ForwardingListener;

    .line 42
    invoke-direct {p0}, Landroid/support/v7/widget/ForwardingListener;->onDetachedFromWindow()V

    return-void
.end method

.method private addDetachListenerApi12(Landroid/view/View;)V
    .locals 1
    .param p1, "src"    # Landroid/view/View;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xc
    .end annotation

    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0xc
    .end annotation

    .line 93
    new-instance v0, Landroid/support/v7/widget/ForwardingListener$1;

    invoke-direct {v0, p0}, Landroid/support/v7/widget/ForwardingListener$1;-><init>(Landroid/support/v7/widget/ForwardingListener;)V

    invoke-virtual {p1, v0}, Landroid/view/View;->addOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V

    .line 102
    return-void
.end method

.method private addDetachListenerBase(Landroid/view/View;)V
    .locals 2
    .param p1, "src"    # Landroid/view/View;

    .line 105
    invoke-virtual {p1}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    new-instance v1, Landroid/support/v7/widget/ForwardingListener$2;

    invoke-direct {v1, p0}, Landroid/support/v7/widget/ForwardingListener$2;-><init>(Landroid/support/v7/widget/ForwardingListener;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 117
    return-void
.end method

.method private clearCallbacks()V
    .locals 2

    .line 250
    iget-object v0, p0, Landroid/support/v7/widget/ForwardingListener;->mTriggerLongPress:Ljava/lang/Runnable;

    if-eqz v0, :cond_0

    .line 251
    iget-object v1, p0, Landroid/support/v7/widget/ForwardingListener;->mSrc:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z

    goto :goto_0

    .line 250
    :cond_0
    nop

    .line 254
    :goto_0
    iget-object v0, p0, Landroid/support/v7/widget/ForwardingListener;->mDisallowIntercept:Ljava/lang/Runnable;

    if-eqz v0, :cond_1

    .line 255
    iget-object v1, p0, Landroid/support/v7/widget/ForwardingListener;->mSrc:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z

    goto :goto_1

    .line 254
    :cond_1
    nop

    .line 257
    :goto_1
    return-void
.end method

.method private onDetachedFromWindow()V
    .locals 2

    .line 155
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/widget/ForwardingListener;->mForwarding:Z

    .line 156
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v7/widget/ForwardingListener;->mActivePointerId:I

    .line 158
    iget-object v0, p0, Landroid/support/v7/widget/ForwardingListener;->mDisallowIntercept:Ljava/lang/Runnable;

    if-eqz v0, :cond_0

    .line 159
    iget-object v1, p0, Landroid/support/v7/widget/ForwardingListener;->mSrc:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z

    goto :goto_0

    .line 158
    :cond_0
    nop

    .line 161
    :goto_0
    return-void
.end method

.method private onTouchForwarded(Landroid/view/MotionEvent;)Z
    .locals 9
    .param p1, "srcEvent"    # Landroid/view/MotionEvent;

    .line 293
    iget-object v0, p0, Landroid/support/v7/widget/ForwardingListener;->mSrc:Landroid/view/View;

    .line 294
    .local v0, "src":Landroid/view/View;
    invoke-virtual {p0}, Landroid/support/v7/widget/ForwardingListener;->getPopup()Landroid/support/v7/view/menu/ShowableListMenu;

    move-result-object v1

    .line 295
    .local v1, "popup":Landroid/support/v7/view/menu/ShowableListMenu;
    const/4 v2, 0x0

    if-eqz v1, :cond_5

    invoke-interface {v1}, Landroid/support/v7/view/menu/ShowableListMenu;->isShowing()Z

    move-result v3

    if-nez v3, :cond_0

    goto :goto_2

    .line 299
    :cond_0
    invoke-interface {v1}, Landroid/support/v7/view/menu/ShowableListMenu;->getListView()Landroid/widget/ListView;

    move-result-object v3

    check-cast v3, Landroid/support/v7/widget/DropDownListView;

    .line 300
    .local v3, "dst":Landroid/support/v7/widget/DropDownListView;
    if-eqz v3, :cond_4

    invoke-virtual {v3}, Landroid/support/v7/widget/DropDownListView;->isShown()Z

    move-result v4

    if-nez v4, :cond_1

    goto :goto_1

    .line 305
    :cond_1
    invoke-static {p1}, Landroid/view/MotionEvent;->obtainNoHistory(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v4

    .line 306
    .local v4, "dstEvent":Landroid/view/MotionEvent;
    invoke-direct {p0, v0, v4}, Landroid/support/v7/widget/ForwardingListener;->toGlobalMotionEvent(Landroid/view/View;Landroid/view/MotionEvent;)Z

    .line 307
    invoke-direct {p0, v3, v4}, Landroid/support/v7/widget/ForwardingListener;->toLocalMotionEvent(Landroid/view/View;Landroid/view/MotionEvent;)Z

    .line 310
    iget v5, p0, Landroid/support/v7/widget/ForwardingListener;->mActivePointerId:I

    invoke-virtual {v3, v4, v5}, Landroid/support/v7/widget/DropDownListView;->onForwardedEvent(Landroid/view/MotionEvent;I)Z

    move-result v5

    .line 311
    .local v5, "handled":Z
    invoke-virtual {v4}, Landroid/view/MotionEvent;->recycle()V

    .line 314
    invoke-static {p1}, Landroid/support/v4/view/MotionEventCompat;->getActionMasked(Landroid/view/MotionEvent;)I

    move-result v6

    .line 315
    .local v6, "action":I
    const/4 v7, 0x1

    if-eq v6, v7, :cond_2

    const/4 v8, 0x3

    if-eq v6, v8, :cond_2

    const/4 v8, 0x1

    goto :goto_0

    :cond_2
    const/4 v8, 0x0

    .line 318
    .local v8, "keepForwarding":Z
    :goto_0
    if-eqz v5, :cond_3

    if-eqz v8, :cond_3

    const/4 v2, 0x1

    nop

    :cond_3
    return v2

    .line 300
    .end local v4    # "dstEvent":Landroid/view/MotionEvent;
    .end local v5    # "handled":Z
    .end local v6    # "action":I
    .end local v8    # "keepForwarding":Z
    :cond_4
    :goto_1
    nop

    .line 301
    return v2

    .line 295
    .end local v3    # "dst":Landroid/support/v7/widget/DropDownListView;
    :cond_5
    :goto_2
    nop

    .line 296
    return v2
.end method

.method private onTouchObserved(Landroid/view/MotionEvent;)Z
    .locals 7
    .param p1, "srcEvent"    # Landroid/view/MotionEvent;

    .line 204
    iget-object v0, p0, Landroid/support/v7/widget/ForwardingListener;->mSrc:Landroid/view/View;

    .line 205
    .local v0, "src":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->isEnabled()Z

    move-result v1

    const/4 v2, 0x0

    if-nez v1, :cond_0

    .line 206
    return v2

    .line 209
    :cond_0
    invoke-static {p1}, Landroid/support/v4/view/MotionEventCompat;->getActionMasked(Landroid/view/MotionEvent;)I

    move-result v1

    .line 210
    .local v1, "actionMasked":I
    packed-switch v1, :pswitch_data_0

    goto :goto_2

    .line 225
    :pswitch_0
    iget v3, p0, Landroid/support/v7/widget/ForwardingListener;->mActivePointerId:I

    invoke-virtual {p1, v3}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v3

    .line 226
    .local v3, "activePointerIndex":I
    if-ltz v3, :cond_2

    .line 227
    invoke-virtual {p1, v3}, Landroid/view/MotionEvent;->getX(I)F

    move-result v4

    .line 228
    .local v4, "x":F
    invoke-virtual {p1, v3}, Landroid/view/MotionEvent;->getY(I)F

    move-result v5

    .line 231
    .local v5, "y":F
    iget v6, p0, Landroid/support/v7/widget/ForwardingListener;->mScaledTouchSlop:F

    invoke-static {v0, v4, v5, v6}, Landroid/support/v7/widget/ForwardingListener;->pointInView(Landroid/view/View;FFF)Z

    move-result v6

    if-nez v6, :cond_1

    .line 232
    invoke-direct {p0}, Landroid/support/v7/widget/ForwardingListener;->clearCallbacks()V

    .line 235
    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    const/4 v6, 0x1

    invoke-interface {v2, v6}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 236
    return v6

    .line 231
    :cond_1
    nop

    .line 238
    .end local v4    # "x":F
    .end local v5    # "y":F
    goto :goto_2

    .line 226
    :cond_2
    goto :goto_2

    .line 242
    .end local v3    # "activePointerIndex":I
    :pswitch_1
    invoke-direct {p0}, Landroid/support/v7/widget/ForwardingListener;->clearCallbacks()V

    goto :goto_2

    .line 212
    :pswitch_2
    invoke-virtual {p1, v2}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v3

    iput v3, p0, Landroid/support/v7/widget/ForwardingListener;->mActivePointerId:I

    .line 214
    iget-object v3, p0, Landroid/support/v7/widget/ForwardingListener;->mDisallowIntercept:Ljava/lang/Runnable;

    if-nez v3, :cond_3

    .line 215
    new-instance v3, Landroid/support/v7/widget/ForwardingListener$DisallowIntercept;

    invoke-direct {v3, p0}, Landroid/support/v7/widget/ForwardingListener$DisallowIntercept;-><init>(Landroid/support/v7/widget/ForwardingListener;)V

    iput-object v3, p0, Landroid/support/v7/widget/ForwardingListener;->mDisallowIntercept:Ljava/lang/Runnable;

    goto :goto_0

    .line 214
    :cond_3
    nop

    .line 217
    :goto_0
    iget-object v3, p0, Landroid/support/v7/widget/ForwardingListener;->mDisallowIntercept:Ljava/lang/Runnable;

    iget v4, p0, Landroid/support/v7/widget/ForwardingListener;->mTapTimeout:I

    int-to-long v4, v4

    invoke-virtual {v0, v3, v4, v5}, Landroid/view/View;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 219
    iget-object v3, p0, Landroid/support/v7/widget/ForwardingListener;->mTriggerLongPress:Ljava/lang/Runnable;

    if-nez v3, :cond_4

    .line 220
    new-instance v3, Landroid/support/v7/widget/ForwardingListener$TriggerLongPress;

    invoke-direct {v3, p0}, Landroid/support/v7/widget/ForwardingListener$TriggerLongPress;-><init>(Landroid/support/v7/widget/ForwardingListener;)V

    iput-object v3, p0, Landroid/support/v7/widget/ForwardingListener;->mTriggerLongPress:Ljava/lang/Runnable;

    goto :goto_1

    .line 219
    :cond_4
    nop

    .line 222
    :goto_1
    iget-object v3, p0, Landroid/support/v7/widget/ForwardingListener;->mTriggerLongPress:Ljava/lang/Runnable;

    iget v4, p0, Landroid/support/v7/widget/ForwardingListener;->mLongPressTimeout:I

    int-to-long v4, v4

    invoke-virtual {v0, v3, v4, v5}, Landroid/view/View;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 223
    nop

    .line 246
    :goto_2
    return v2

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private static pointInView(Landroid/view/View;FFF)Z
    .locals 2
    .param p0, "view"    # Landroid/view/View;
    .param p1, "localX"    # F
    .param p2, "localY"    # F
    .param p3, "slop"    # F

    .line 322
    neg-float v0, p3

    cmpl-float v0, p1, v0

    if-ltz v0, :cond_2

    neg-float v0, p3

    cmpl-float v0, p2, v0

    if-ltz v0, :cond_2

    .line 323
    invoke-virtual {p0}, Landroid/view/View;->getRight()I

    move-result v0

    invoke-virtual {p0}, Landroid/view/View;->getLeft()I

    move-result v1

    sub-int/2addr v0, v1

    int-to-float v0, v0

    add-float/2addr v0, p3

    cmpg-float v0, p1, v0

    if-gez v0, :cond_1

    .line 324
    invoke-virtual {p0}, Landroid/view/View;->getBottom()I

    move-result v0

    invoke-virtual {p0}, Landroid/view/View;->getTop()I

    move-result v1

    sub-int/2addr v0, v1

    int-to-float v0, v0

    add-float/2addr v0, p3

    cmpg-float v0, p2, v0

    if-gez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_1

    :cond_0
    goto :goto_0

    .line 323
    :cond_1
    goto :goto_0

    .line 322
    :cond_2
    nop

    .line 324
    :goto_0
    const/4 v0, 0x0

    :goto_1
    return v0
.end method

.method private toGlobalMotionEvent(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "view"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .line 343
    iget-object v0, p0, Landroid/support/v7/widget/ForwardingListener;->mTmpLocation:[I

    .line 344
    .local v0, "loc":[I
    invoke-virtual {p1, v0}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 345
    const/4 v1, 0x0

    aget v1, v0, v1

    int-to-float v1, v1

    const/4 v2, 0x1

    aget v3, v0, v2

    int-to-float v3, v3

    invoke-virtual {p2, v1, v3}, Landroid/view/MotionEvent;->offsetLocation(FF)V

    .line 346
    return v2
.end method

.method private toLocalMotionEvent(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "view"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .line 332
    iget-object v0, p0, Landroid/support/v7/widget/ForwardingListener;->mTmpLocation:[I

    .line 333
    .local v0, "loc":[I
    invoke-virtual {p1, v0}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 334
    const/4 v1, 0x0

    aget v1, v0, v1

    neg-int v1, v1

    int-to-float v1, v1

    const/4 v2, 0x1

    aget v3, v0, v2

    neg-int v3, v3

    int-to-float v3, v3

    invoke-virtual {p2, v1, v3}, Landroid/view/MotionEvent;->offsetLocation(FF)V

    .line 335
    return v2
.end method


# virtual methods
.method public abstract getPopup()Landroid/support/v7/view/menu/ShowableListMenu;
.end method

.method protected onForwardingStarted()Z
    .locals 2

    .line 173
    invoke-virtual {p0}, Landroid/support/v7/widget/ForwardingListener;->getPopup()Landroid/support/v7/view/menu/ShowableListMenu;

    move-result-object v0

    .line 174
    .local v0, "popup":Landroid/support/v7/view/menu/ShowableListMenu;
    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/support/v7/view/menu/ShowableListMenu;->isShowing()Z

    move-result v1

    if-nez v1, :cond_0

    .line 175
    invoke-interface {v0}, Landroid/support/v7/view/menu/ShowableListMenu;->show()V

    goto :goto_0

    .line 174
    :cond_0
    nop

    .line 177
    :goto_0
    const/4 v1, 0x1

    return v1
.end method

.method protected onForwardingStopped()Z
    .locals 2

    .line 190
    invoke-virtual {p0}, Landroid/support/v7/widget/ForwardingListener;->getPopup()Landroid/support/v7/view/menu/ShowableListMenu;

    move-result-object v0

    .line 191
    .local v0, "popup":Landroid/support/v7/view/menu/ShowableListMenu;
    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/support/v7/view/menu/ShowableListMenu;->isShowing()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 192
    invoke-interface {v0}, Landroid/support/v7/view/menu/ShowableListMenu;->dismiss()V

    goto :goto_0

    .line 191
    :cond_0
    nop

    .line 194
    :goto_0
    const/4 v1, 0x1

    return v1
.end method

.method onLongPress()V
    .locals 13

    .line 260
    invoke-direct {p0}, Landroid/support/v7/widget/ForwardingListener;->clearCallbacks()V

    .line 262
    iget-object v0, p0, Landroid/support/v7/widget/ForwardingListener;->mSrc:Landroid/view/View;

    .line 263
    .local v0, "src":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-virtual {v0}, Landroid/view/View;->isLongClickable()Z

    move-result v1

    if-eqz v1, :cond_0

    goto :goto_0

    .line 269
    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/widget/ForwardingListener;->onForwardingStarted()Z

    move-result v1

    if-nez v1, :cond_1

    .line 270
    return-void

    .line 274
    :cond_1
    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    const/4 v2, 0x1

    invoke-interface {v1, v2}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 277
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v11

    .line 278
    .local v11, "now":J
    const/4 v7, 0x3

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    move-wide v3, v11

    move-wide v5, v11

    invoke-static/range {v3 .. v10}, Landroid/view/MotionEvent;->obtain(JJIFFI)Landroid/view/MotionEvent;

    move-result-object v1

    .line 279
    .local v1, "e":Landroid/view/MotionEvent;
    invoke-virtual {v0, v1}, Landroid/view/View;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 280
    invoke-virtual {v1}, Landroid/view/MotionEvent;->recycle()V

    .line 282
    iput-boolean v2, p0, Landroid/support/v7/widget/ForwardingListener;->mForwarding:Z

    .line 283
    return-void

    .line 263
    .end local v1    # "e":Landroid/view/MotionEvent;
    .end local v11    # "now":J
    :cond_2
    :goto_0
    nop

    .line 266
    return-void
.end method

.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 16
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .line 133
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    iget-boolean v2, v0, Landroid/support/v7/widget/ForwardingListener;->mForwarding:Z

    .line 135
    .local v2, "wasForwarding":Z
    const/4 v3, 0x1

    const/4 v4, 0x0

    if-eqz v2, :cond_2

    .line 136
    invoke-direct {v0, v1}, Landroid/support/v7/widget/ForwardingListener;->onTouchForwarded(Landroid/view/MotionEvent;)Z

    move-result v5

    if-nez v5, :cond_1

    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/ForwardingListener;->onForwardingStopped()Z

    move-result v5

    if-nez v5, :cond_0

    goto :goto_0

    :cond_0
    const/4 v5, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v5, 0x1

    :goto_1
    goto :goto_3

    .line 138
    :cond_2
    invoke-direct {v0, v1}, Landroid/support/v7/widget/ForwardingListener;->onTouchObserved(Landroid/view/MotionEvent;)Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/ForwardingListener;->onForwardingStarted()Z

    move-result v5

    if-eqz v5, :cond_3

    const/4 v5, 0x1

    goto :goto_2

    :cond_3
    const/4 v5, 0x0

    .line 140
    .local v5, "forwarding":Z
    :goto_2
    if-eqz v5, :cond_4

    .line 142
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v14

    .line 143
    .local v14, "now":J
    const/4 v10, 0x3

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    move-wide v6, v14

    move-wide v8, v14

    invoke-static/range {v6 .. v13}, Landroid/view/MotionEvent;->obtain(JJIFFI)Landroid/view/MotionEvent;

    move-result-object v6

    .line 145
    .local v6, "e":Landroid/view/MotionEvent;
    iget-object v7, v0, Landroid/support/v7/widget/ForwardingListener;->mSrc:Landroid/view/View;

    invoke-virtual {v7, v6}, Landroid/view/View;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 146
    invoke-virtual {v6}, Landroid/view/MotionEvent;->recycle()V

    goto :goto_3

    .line 140
    .end local v6    # "e":Landroid/view/MotionEvent;
    .end local v14    # "now":J
    :cond_4
    nop

    .line 150
    :goto_3
    iput-boolean v5, v0, Landroid/support/v7/widget/ForwardingListener;->mForwarding:Z

    .line 151
    if-nez v5, :cond_6

    if-eqz v2, :cond_5

    goto :goto_4

    :cond_5
    const/4 v3, 0x0

    nop

    :cond_6
    :goto_4
    return v3
.end method
