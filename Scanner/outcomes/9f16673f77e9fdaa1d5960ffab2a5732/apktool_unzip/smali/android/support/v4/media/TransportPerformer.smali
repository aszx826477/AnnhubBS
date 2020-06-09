.class public abstract Landroid/support/v4/media/TransportPerformer;
.super Ljava/lang/Object;
.source "TransportPerformer.java"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field static final AUDIOFOCUS_GAIN:I = 0x1

.field static final AUDIOFOCUS_GAIN_TRANSIENT:I = 0x2

.field static final AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK:I = 0x3

.field static final AUDIOFOCUS_LOSS:I = -0x1

.field static final AUDIOFOCUS_LOSS_TRANSIENT:I = -0x2

.field static final AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:I = -0x3


# direct methods
.method public constructor <init>()V
    .locals 0
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    return-void
.end method


# virtual methods
.method public onAudioFocusChange(I)V
    .locals 12
    .param p1, "focusChange"    # I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 237
    const/4 v0, 0x0

    .line 238
    .local v0, "keyCode":I
    const/4 v1, -0x1

    if-eq p1, v1, :cond_0

    goto :goto_0

    .line 242
    :cond_0
    const/16 v0, 0x7f

    .line 245
    :goto_0
    if-eqz v0, :cond_1

    .line 246
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v9

    .line 247
    .local v9, "now":J
    new-instance v11, Landroid/view/KeyEvent;

    const/4 v6, 0x0

    const/4 v8, 0x0

    move-object v1, v11

    move-wide v2, v9

    move-wide v4, v9

    move v7, v0

    invoke-direct/range {v1 .. v8}, Landroid/view/KeyEvent;-><init>(JJIII)V

    invoke-virtual {p0, v0, v11}, Landroid/support/v4/media/TransportPerformer;->onMediaButtonDown(ILandroid/view/KeyEvent;)Z

    .line 248
    new-instance v11, Landroid/view/KeyEvent;

    const/4 v6, 0x1

    move-object v1, v11

    invoke-direct/range {v1 .. v8}, Landroid/view/KeyEvent;-><init>(JJIII)V

    invoke-virtual {p0, v0, v11}, Landroid/support/v4/media/TransportPerformer;->onMediaButtonUp(ILandroid/view/KeyEvent;)Z

    goto :goto_1

    .line 245
    .end local v9    # "now":J
    :cond_1
    nop

    .line 250
    :goto_1
    return-void
.end method

.method public onGetBufferPercentage()I
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 113
    const/16 v0, 0x64

    return v0
.end method

.method public abstract onGetCurrentPosition()J
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public abstract onGetDuration()J
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public onGetTransportControlFlags()I
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 138
    const/16 v0, 0x3c

    return v0
.end method

.method public abstract onIsPlaying()Z
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public onMediaButtonDown(ILandroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 170
    const/4 v0, 0x1

    sparse-switch p1, :sswitch_data_0

    goto :goto_0

    .line 175
    :sswitch_0
    invoke-virtual {p0}, Landroid/support/v4/media/TransportPerformer;->onPause()V

    .line 176
    return v0

    .line 172
    :sswitch_1
    invoke-virtual {p0}, Landroid/support/v4/media/TransportPerformer;->onStart()V

    .line 173
    return v0

    .line 178
    :sswitch_2
    invoke-virtual {p0}, Landroid/support/v4/media/TransportPerformer;->onStop()V

    .line 179
    return v0

    .line 182
    :sswitch_3
    invoke-virtual {p0}, Landroid/support/v4/media/TransportPerformer;->onIsPlaying()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 183
    invoke-virtual {p0}, Landroid/support/v4/media/TransportPerformer;->onPause()V

    goto :goto_0

    .line 185
    :cond_0
    invoke-virtual {p0}, Landroid/support/v4/media/TransportPerformer;->onStart()V

    .line 188
    :goto_0
    return v0

    nop

    :sswitch_data_0
    .sparse-switch
        0x4f -> :sswitch_3
        0x55 -> :sswitch_3
        0x56 -> :sswitch_2
        0x7e -> :sswitch_1
        0x7f -> :sswitch_0
    .end sparse-switch
.end method

.method public onMediaButtonUp(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 210
    const/4 v0, 0x1

    return v0
.end method

.method public abstract onPause()V
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public abstract onSeekTo(J)V
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public abstract onStart()V
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public abstract onStop()V
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method
