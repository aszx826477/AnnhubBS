.class public Landroid/support/v4/media/TransportMediator;
.super Landroid/support/v4/media/TransportController;
.source "TransportMediator.java"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field public static final FLAG_KEY_MEDIA_FAST_FORWARD:I = 0x40
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final FLAG_KEY_MEDIA_NEXT:I = 0x80
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final FLAG_KEY_MEDIA_PAUSE:I = 0x10
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final FLAG_KEY_MEDIA_PLAY:I = 0x4
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final FLAG_KEY_MEDIA_PLAY_PAUSE:I = 0x8
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final FLAG_KEY_MEDIA_PREVIOUS:I = 0x1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final FLAG_KEY_MEDIA_REWIND:I = 0x2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final FLAG_KEY_MEDIA_STOP:I = 0x20
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEYCODE_MEDIA_PAUSE:I = 0x7f
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEYCODE_MEDIA_PLAY:I = 0x7e
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEYCODE_MEDIA_RECORD:I = 0x82
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field


# instance fields
.field final mAudioManager:Landroid/media/AudioManager;

.field final mCallbacks:Landroid/support/v4/media/TransportPerformer;

.field final mContext:Landroid/content/Context;

.field final mController:Landroid/support/v4/media/TransportMediatorJellybeanMR2;

.field final mDispatcherState:Ljava/lang/Object;

.field final mKeyEventCallback:Landroid/view/KeyEvent$Callback;

.field final mListeners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroid/support/v4/media/TransportStateListener;",
            ">;"
        }
    .end annotation
.end field

.field final mTransportKeyCallback:Landroid/support/v4/media/TransportMediatorCallback;

.field final mView:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Landroid/support/v4/media/TransportPerformer;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "callbacks"    # Landroid/support/v4/media/TransportPerformer;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 217
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p2}, Landroid/support/v4/media/TransportMediator;-><init>(Landroid/app/Activity;Landroid/view/View;Landroid/support/v4/media/TransportPerformer;)V

    .line 218
    return-void
.end method

.method private constructor <init>(Landroid/app/Activity;Landroid/view/View;Landroid/support/v4/media/TransportPerformer;)V
    .locals 5
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "view"    # Landroid/view/View;
    .param p3, "callbacks"    # Landroid/support/v4/media/TransportPerformer;

    .line 228
    invoke-direct {p0}, Landroid/support/v4/media/TransportController;-><init>()V

    .line 60
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v4/media/TransportMediator;->mListeners:Ljava/util/ArrayList;

    .line 62
    new-instance v0, Landroid/support/v4/media/TransportMediator$1;

    invoke-direct {v0, p0}, Landroid/support/v4/media/TransportMediator$1;-><init>(Landroid/support/v4/media/TransportMediator;)V

    iput-object v0, p0, Landroid/support/v4/media/TransportMediator;->mTransportKeyCallback:Landroid/support/v4/media/TransportMediatorCallback;

    .line 190
    new-instance v0, Landroid/support/v4/media/TransportMediator$2;

    invoke-direct {v0, p0}, Landroid/support/v4/media/TransportMediator$2;-><init>(Landroid/support/v4/media/TransportMediator;)V

    iput-object v0, p0, Landroid/support/v4/media/TransportMediator;->mKeyEventCallback:Landroid/view/KeyEvent$Callback;

    .line 229
    if-eqz p1, :cond_0

    move-object v0, p1

    goto :goto_0

    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    :goto_0
    iput-object v0, p0, Landroid/support/v4/media/TransportMediator;->mContext:Landroid/content/Context;

    .line 230
    iput-object p3, p0, Landroid/support/v4/media/TransportMediator;->mCallbacks:Landroid/support/v4/media/TransportPerformer;

    .line 231
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mContext:Landroid/content/Context;

    const-string v1, "audio"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    iput-object v0, p0, Landroid/support/v4/media/TransportMediator;->mAudioManager:Landroid/media/AudioManager;

    .line 232
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    goto :goto_1

    :cond_1
    move-object v0, p2

    :goto_1
    iput-object v0, p0, Landroid/support/v4/media/TransportMediator;->mView:Landroid/view/View;

    .line 233
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getKeyDispatcherState()Landroid/view/KeyEvent$DispatcherState;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/media/TransportMediator;->mDispatcherState:Ljava/lang/Object;

    .line 234
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x12

    if-lt v0, v1, :cond_2

    .line 235
    new-instance v0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;

    iget-object v1, p0, Landroid/support/v4/media/TransportMediator;->mContext:Landroid/content/Context;

    iget-object v2, p0, Landroid/support/v4/media/TransportMediator;->mAudioManager:Landroid/media/AudioManager;

    iget-object v3, p0, Landroid/support/v4/media/TransportMediator;->mView:Landroid/view/View;

    iget-object v4, p0, Landroid/support/v4/media/TransportMediator;->mTransportKeyCallback:Landroid/support/v4/media/TransportMediatorCallback;

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/support/v4/media/TransportMediatorJellybeanMR2;-><init>(Landroid/content/Context;Landroid/media/AudioManager;Landroid/view/View;Landroid/support/v4/media/TransportMediatorCallback;)V

    iput-object v0, p0, Landroid/support/v4/media/TransportMediator;->mController:Landroid/support/v4/media/TransportMediatorJellybeanMR2;

    goto :goto_2

    .line 238
    :cond_2
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/media/TransportMediator;->mController:Landroid/support/v4/media/TransportMediatorJellybeanMR2;

    .line 240
    :goto_2
    return-void
.end method

.method public constructor <init>(Landroid/view/View;Landroid/support/v4/media/TransportPerformer;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "callbacks"    # Landroid/support/v4/media/TransportPerformer;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 225
    const/4 v0, 0x0

    invoke-direct {p0, v0, p1, p2}, Landroid/support/v4/media/TransportMediator;-><init>(Landroid/app/Activity;Landroid/view/View;Landroid/support/v4/media/TransportPerformer;)V

    .line 226
    return-void
.end method

.method private getListeners()[Landroid/support/v4/media/TransportStateListener;
    .locals 2

    .line 303
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-gtz v0, :cond_0

    .line 304
    const/4 v0, 0x0

    return-object v0

    .line 306
    :cond_0
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    new-array v0, v0, [Landroid/support/v4/media/TransportStateListener;

    .line 307
    .local v0, "listeners":[Landroid/support/v4/media/TransportStateListener;
    iget-object v1, p0, Landroid/support/v4/media/TransportMediator;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 308
    return-object v0
.end method

.method static isMediaKey(I)Z
    .locals 1
    .param p0, "keyCode"    # I

    .line 172
    const/16 v0, 0x4f

    if-eq p0, v0, :cond_0

    const/16 v0, 0x82

    if-eq p0, v0, :cond_0

    packed-switch p0, :pswitch_data_0

    packed-switch p0, :pswitch_data_1

    .line 187
    const/4 v0, 0x0

    return v0

    .line 184
    :cond_0
    :pswitch_0
    const/4 v0, 0x1

    return v0

    :pswitch_data_0
    .packed-switch 0x55
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x7e
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method private pushControllerState()V
    .locals 5

    .line 330
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mController:Landroid/support/v4/media/TransportMediatorJellybeanMR2;

    if-eqz v0, :cond_0

    .line 331
    iget-object v1, p0, Landroid/support/v4/media/TransportMediator;->mCallbacks:Landroid/support/v4/media/TransportPerformer;

    invoke-virtual {v1}, Landroid/support/v4/media/TransportPerformer;->onIsPlaying()Z

    move-result v1

    iget-object v2, p0, Landroid/support/v4/media/TransportMediator;->mCallbacks:Landroid/support/v4/media/TransportPerformer;

    .line 332
    invoke-virtual {v2}, Landroid/support/v4/media/TransportPerformer;->onGetCurrentPosition()J

    move-result-wide v2

    iget-object v4, p0, Landroid/support/v4/media/TransportMediator;->mCallbacks:Landroid/support/v4/media/TransportPerformer;

    .line 333
    invoke-virtual {v4}, Landroid/support/v4/media/TransportPerformer;->onGetTransportControlFlags()I

    move-result v4

    .line 331
    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->refreshState(ZJI)V

    goto :goto_0

    .line 330
    :cond_0
    nop

    .line 335
    :goto_0
    return-void
.end method

.method private reportPlayingChanged()V
    .locals 4

    .line 312
    invoke-direct {p0}, Landroid/support/v4/media/TransportMediator;->getListeners()[Landroid/support/v4/media/TransportStateListener;

    move-result-object v0

    .line 313
    .local v0, "listeners":[Landroid/support/v4/media/TransportStateListener;
    if-eqz v0, :cond_1

    .line 314
    array-length v1, v0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_0

    aget-object v3, v0, v2

    .line 315
    .local v3, "listener":Landroid/support/v4/media/TransportStateListener;
    invoke-virtual {v3, p0}, Landroid/support/v4/media/TransportStateListener;->onPlayingChanged(Landroid/support/v4/media/TransportController;)V

    .line 314
    .end local v3    # "listener":Landroid/support/v4/media/TransportStateListener;
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_0
    goto :goto_1

    .line 313
    :cond_1
    nop

    .line 318
    :goto_1
    return-void
.end method

.method private reportTransportControlsChanged()V
    .locals 4

    .line 321
    invoke-direct {p0}, Landroid/support/v4/media/TransportMediator;->getListeners()[Landroid/support/v4/media/TransportStateListener;

    move-result-object v0

    .line 322
    .local v0, "listeners":[Landroid/support/v4/media/TransportStateListener;
    if-eqz v0, :cond_1

    .line 323
    array-length v1, v0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_0

    aget-object v3, v0, v2

    .line 324
    .local v3, "listener":Landroid/support/v4/media/TransportStateListener;
    invoke-virtual {v3, p0}, Landroid/support/v4/media/TransportStateListener;->onTransportControlsChanged(Landroid/support/v4/media/TransportController;)V

    .line 323
    .end local v3    # "listener":Landroid/support/v4/media/TransportStateListener;
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_0
    goto :goto_1

    .line 322
    :cond_1
    nop

    .line 327
    :goto_1
    return-void
.end method


# virtual methods
.method public destroy()V
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 486
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mController:Landroid/support/v4/media/TransportMediatorJellybeanMR2;

    invoke-virtual {v0}, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->destroy()V

    .line 487
    return-void
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/KeyEvent;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 275
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mKeyEventCallback:Landroid/view/KeyEvent$Callback;

    iget-object v1, p0, Landroid/support/v4/media/TransportMediator;->mDispatcherState:Ljava/lang/Object;

    check-cast v1, Landroid/view/KeyEvent$DispatcherState;

    invoke-virtual {p1, v0, v1, p0}, Landroid/view/KeyEvent;->dispatch(Landroid/view/KeyEvent$Callback;Landroid/view/KeyEvent$DispatcherState;Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public getBufferPercentage()I
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 454
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mCallbacks:Landroid/support/v4/media/TransportPerformer;

    invoke-virtual {v0}, Landroid/support/v4/media/TransportPerformer;->onGetBufferPercentage()I

    move-result v0

    return v0
.end method

.method public getCurrentPosition()J
    .locals 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 418
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mCallbacks:Landroid/support/v4/media/TransportPerformer;

    invoke-virtual {v0}, Landroid/support/v4/media/TransportPerformer;->onGetCurrentPosition()J

    move-result-wide v0

    return-wide v0
.end method

.method public getDuration()J
    .locals 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 406
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mCallbacks:Landroid/support/v4/media/TransportPerformer;

    invoke-virtual {v0}, Landroid/support/v4/media/TransportPerformer;->onGetDuration()J

    move-result-wide v0

    return-wide v0
.end method

.method public getRemoteControlClient()Ljava/lang/Object;
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 262
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mController:Landroid/support/v4/media/TransportMediatorJellybeanMR2;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->getRemoteControlClient()Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method public getTransportControlFlags()I
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 474
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mCallbacks:Landroid/support/v4/media/TransportPerformer;

    invoke-virtual {v0}, Landroid/support/v4/media/TransportPerformer;->onGetTransportControlFlags()I

    move-result v0

    return v0
.end method

.method public isPlaying()Z
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 441
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mCallbacks:Landroid/support/v4/media/TransportPerformer;

    invoke-virtual {v0}, Landroid/support/v4/media/TransportPerformer;->onIsPlaying()Z

    move-result v0

    return v0
.end method

.method public pausePlaying()V
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 373
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mController:Landroid/support/v4/media/TransportMediatorJellybeanMR2;

    if-eqz v0, :cond_0

    .line 374
    invoke-virtual {v0}, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->pausePlaying()V

    goto :goto_0

    .line 373
    :cond_0
    nop

    .line 376
    :goto_0
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mCallbacks:Landroid/support/v4/media/TransportPerformer;

    invoke-virtual {v0}, Landroid/support/v4/media/TransportPerformer;->onPause()V

    .line 377
    invoke-direct {p0}, Landroid/support/v4/media/TransportMediator;->pushControllerState()V

    .line 378
    invoke-direct {p0}, Landroid/support/v4/media/TransportMediator;->reportPlayingChanged()V

    .line 379
    return-void
.end method

.method public refreshState()V
    .locals 0
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 342
    invoke-direct {p0}, Landroid/support/v4/media/TransportMediator;->pushControllerState()V

    .line 343
    invoke-direct {p0}, Landroid/support/v4/media/TransportMediator;->reportPlayingChanged()V

    .line 344
    invoke-direct {p0}, Landroid/support/v4/media/TransportMediator;->reportTransportControlsChanged()V

    .line 345
    return-void
.end method

.method public registerStateListener(Landroid/support/v4/media/TransportStateListener;)V
    .locals 1
    .param p1, "listener"    # Landroid/support/v4/media/TransportStateListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 287
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 288
    return-void
.end method

.method public seekTo(J)V
    .locals 1
    .param p1, "pos"    # J
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 430
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mCallbacks:Landroid/support/v4/media/TransportPerformer;

    invoke-virtual {v0, p1, p2}, Landroid/support/v4/media/TransportPerformer;->onSeekTo(J)V

    .line 431
    return-void
.end method

.method public startPlaying()V
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 356
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mController:Landroid/support/v4/media/TransportMediatorJellybeanMR2;

    if-eqz v0, :cond_0

    .line 357
    invoke-virtual {v0}, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->startPlaying()V

    goto :goto_0

    .line 356
    :cond_0
    nop

    .line 359
    :goto_0
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mCallbacks:Landroid/support/v4/media/TransportPerformer;

    invoke-virtual {v0}, Landroid/support/v4/media/TransportPerformer;->onStart()V

    .line 360
    invoke-direct {p0}, Landroid/support/v4/media/TransportMediator;->pushControllerState()V

    .line 361
    invoke-direct {p0}, Landroid/support/v4/media/TransportMediator;->reportPlayingChanged()V

    .line 362
    return-void
.end method

.method public stopPlaying()V
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 390
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mController:Landroid/support/v4/media/TransportMediatorJellybeanMR2;

    if-eqz v0, :cond_0

    .line 391
    invoke-virtual {v0}, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->stopPlaying()V

    goto :goto_0

    .line 390
    :cond_0
    nop

    .line 393
    :goto_0
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mCallbacks:Landroid/support/v4/media/TransportPerformer;

    invoke-virtual {v0}, Landroid/support/v4/media/TransportPerformer;->onStop()V

    .line 394
    invoke-direct {p0}, Landroid/support/v4/media/TransportMediator;->pushControllerState()V

    .line 395
    invoke-direct {p0}, Landroid/support/v4/media/TransportMediator;->reportPlayingChanged()V

    .line 396
    return-void
.end method

.method public unregisterStateListener(Landroid/support/v4/media/TransportStateListener;)V
    .locals 1
    .param p1, "listener"    # Landroid/support/v4/media/TransportStateListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 299
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 300
    return-void
.end method
