.class public abstract Landroid/support/v4/media/session/IMediaSession$Stub;
.super Landroid/os/Binder;
.source "IMediaSession.java"

# interfaces
.implements Landroid/support/v4/media/session/IMediaSession;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/media/session/IMediaSession;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v4/media/session/IMediaSession$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.support.v4.media.session.IMediaSession"

.field static final TRANSACTION_addQueueItem:I = 0x29

.field static final TRANSACTION_addQueueItemAt:I = 0x2a

.field static final TRANSACTION_adjustVolume:I = 0xb

.field static final TRANSACTION_fastForward:I = 0x16

.field static final TRANSACTION_getExtras:I = 0x1f

.field static final TRANSACTION_getFlags:I = 0x9

.field static final TRANSACTION_getLaunchPendingIntent:I = 0x8

.field static final TRANSACTION_getMetadata:I = 0x1b

.field static final TRANSACTION_getPackageName:I = 0x6

.field static final TRANSACTION_getPlaybackState:I = 0x1c

.field static final TRANSACTION_getQueue:I = 0x1d

.field static final TRANSACTION_getQueueTitle:I = 0x1e

.field static final TRANSACTION_getRatingType:I = 0x20

.field static final TRANSACTION_getRepeatMode:I = 0x25

.field static final TRANSACTION_getTag:I = 0x7

.field static final TRANSACTION_getVolumeAttributes:I = 0xa

.field static final TRANSACTION_isCaptioningEnabled:I = 0x2d

.field static final TRANSACTION_isShuffleModeEnabled:I = 0x26

.field static final TRANSACTION_isTransportControlEnabled:I = 0x5

.field static final TRANSACTION_next:I = 0x14

.field static final TRANSACTION_pause:I = 0x12

.field static final TRANSACTION_play:I = 0xd

.field static final TRANSACTION_playFromMediaId:I = 0xe

.field static final TRANSACTION_playFromSearch:I = 0xf

.field static final TRANSACTION_playFromUri:I = 0x10

.field static final TRANSACTION_prepare:I = 0x21

.field static final TRANSACTION_prepareFromMediaId:I = 0x22

.field static final TRANSACTION_prepareFromSearch:I = 0x23

.field static final TRANSACTION_prepareFromUri:I = 0x24

.field static final TRANSACTION_previous:I = 0x15

.field static final TRANSACTION_rate:I = 0x19

.field static final TRANSACTION_registerCallbackListener:I = 0x3

.field static final TRANSACTION_removeQueueItem:I = 0x2b

.field static final TRANSACTION_removeQueueItemAt:I = 0x2c

.field static final TRANSACTION_rewind:I = 0x17

.field static final TRANSACTION_seekTo:I = 0x18

.field static final TRANSACTION_sendCommand:I = 0x1

.field static final TRANSACTION_sendCustomAction:I = 0x1a

.field static final TRANSACTION_sendMediaButton:I = 0x2

.field static final TRANSACTION_setCaptioningEnabled:I = 0x2e

.field static final TRANSACTION_setRepeatMode:I = 0x27

.field static final TRANSACTION_setShuffleModeEnabled:I = 0x28

.field static final TRANSACTION_setVolumeTo:I = 0xc

.field static final TRANSACTION_skipToQueueItem:I = 0x11

.field static final TRANSACTION_stop:I = 0x13

.field static final TRANSACTION_unregisterCallbackListener:I = 0x4


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 18
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 19
    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p0, p0, v0}, Landroid/support/v4/media/session/IMediaSession$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 20
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/support/v4/media/session/IMediaSession;
    .locals 2
    .param p0, "obj"    # Landroid/os/IBinder;

    .line 27
    if-nez p0, :cond_0

    .line 28
    const/4 v0, 0x0

    return-object v0

    .line 30
    :cond_0
    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-interface {p0, v0}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 31
    .local v0, "iin":Landroid/os/IInterface;
    if-eqz v0, :cond_1

    instance-of v1, v0, Landroid/support/v4/media/session/IMediaSession;

    if-eqz v1, :cond_1

    .line 32
    move-object v1, v0

    check-cast v1, Landroid/support/v4/media/session/IMediaSession;

    return-object v1

    .line 31
    :cond_1
    nop

    .line 34
    new-instance v1, Landroid/support/v4/media/session/IMediaSession$Stub$Proxy;

    invoke-direct {v1, p0}, Landroid/support/v4/media/session/IMediaSession$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    return-object v1
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .locals 0

    .line 38
    return-object p0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .locals 4
    .param p1, "code"    # I
    .param p2, "data"    # Landroid/os/Parcel;
    .param p3, "reply"    # Landroid/os/Parcel;
    .param p4, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .line 42
    const v0, 0x5f4e5446

    const/4 v1, 0x1

    if-eq p1, v0, :cond_18

    const/4 v0, 0x0

    packed-switch p1, :pswitch_data_0

    .line 578
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v0

    return v0

    .line 536
    :pswitch_0
    const-string v2, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 538
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_0

    const/4 v0, 0x1

    nop

    .line 539
    .local v0, "_arg0":Z
    :cond_0
    invoke-virtual {p0, v0}, Landroid/support/v4/media/session/IMediaSession$Stub;->setCaptioningEnabled(Z)V

    .line 540
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 541
    return v1

    .line 265
    .end local v0    # "_arg0":Z
    :pswitch_1
    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 266
    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->isCaptioningEnabled()Z

    move-result v0

    .line 267
    .local v0, "_result":Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 268
    nop

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 269
    nop

    return v1

    .line 333
    .end local v0    # "_result":Z
    :pswitch_2
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 335
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 336
    .local v0, "_arg0":I
    nop

    invoke-virtual {p0, v0}, Landroid/support/v4/media/session/IMediaSession$Stub;->removeQueueItemAt(I)V

    .line 337
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 338
    nop

    return v1

    .line 319
    .end local v0    # "_arg0":I
    :pswitch_3
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 321
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_1

    .line 322
    nop

    sget-object v0, Landroid/support/v4/media/MediaDescriptionCompat;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/media/MediaDescriptionCompat;

    goto :goto_0

    .line 325
    :cond_1
    nop

    const/4 v0, 0x0

    .line 327
    .local v0, "_arg0":Landroid/support/v4/media/MediaDescriptionCompat;
    :goto_0
    nop

    invoke-virtual {p0, v0}, Landroid/support/v4/media/session/IMediaSession$Stub;->removeQueueItem(Landroid/support/v4/media/MediaDescriptionCompat;)V

    .line 328
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 329
    nop

    return v1

    .line 303
    .end local v0    # "_arg0":Landroid/support/v4/media/MediaDescriptionCompat;
    :pswitch_4
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 305
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_2

    .line 306
    nop

    sget-object v0, Landroid/support/v4/media/MediaDescriptionCompat;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/media/MediaDescriptionCompat;

    goto :goto_1

    .line 309
    :cond_2
    nop

    const/4 v0, 0x0

    .line 312
    .restart local v0    # "_arg0":Landroid/support/v4/media/MediaDescriptionCompat;
    :goto_1
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 313
    .local v2, "_arg1":I
    nop

    invoke-virtual {p0, v0, v2}, Landroid/support/v4/media/session/IMediaSession$Stub;->addQueueItemAt(Landroid/support/v4/media/MediaDescriptionCompat;I)V

    .line 314
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 315
    nop

    return v1

    .line 289
    .end local v0    # "_arg0":Landroid/support/v4/media/MediaDescriptionCompat;
    .end local v2    # "_arg1":I
    :pswitch_5
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 291
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_3

    .line 292
    nop

    sget-object v0, Landroid/support/v4/media/MediaDescriptionCompat;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/media/MediaDescriptionCompat;

    goto :goto_2

    .line 295
    :cond_3
    nop

    const/4 v0, 0x0

    .line 297
    .restart local v0    # "_arg0":Landroid/support/v4/media/MediaDescriptionCompat;
    :goto_2
    nop

    invoke-virtual {p0, v0}, Landroid/support/v4/media/session/IMediaSession$Stub;->addQueueItem(Landroid/support/v4/media/MediaDescriptionCompat;)V

    .line 298
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 299
    nop

    return v1

    .line 554
    .end local v0    # "_arg0":Landroid/support/v4/media/MediaDescriptionCompat;
    :pswitch_6
    nop

    const-string v2, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 556
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_4

    nop

    const/4 v0, 0x1

    goto :goto_3

    :cond_4
    nop

    :goto_3
    nop

    .line 557
    .local v0, "_arg0":Z
    nop

    invoke-virtual {p0, v0}, Landroid/support/v4/media/session/IMediaSession$Stub;->setShuffleModeEnabled(Z)V

    .line 558
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 559
    nop

    return v1

    .line 545
    .end local v0    # "_arg0":Z
    :pswitch_7
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 547
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 548
    .local v0, "_arg0":I
    nop

    invoke-virtual {p0, v0}, Landroid/support/v4/media/session/IMediaSession$Stub;->setRepeatMode(I)V

    .line 549
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 550
    nop

    return v1

    .line 281
    .end local v0    # "_arg0":I
    :pswitch_8
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 282
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->isShuffleModeEnabled()Z

    move-result v0

    .line 283
    .local v0, "_result":Z
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 284
    nop

    nop

    nop

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 285
    nop

    return v1

    .line 273
    .end local v0    # "_result":Z
    :pswitch_9
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 274
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->getRepeatMode()I

    move-result v0

    .line 275
    .local v0, "_result":I
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 276
    nop

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 277
    nop

    return v1

    .line 381
    .end local v0    # "_result":I
    :pswitch_a
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 383
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_5

    .line 384
    nop

    sget-object v0, Landroid/net/Uri;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    goto :goto_4

    .line 387
    :cond_5
    nop

    const/4 v0, 0x0

    .line 390
    .local v0, "_arg0":Landroid/net/Uri;
    :goto_4
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_6

    .line 391
    nop

    sget-object v2, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v2, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Bundle;

    goto :goto_5

    .line 394
    :cond_6
    nop

    const/4 v2, 0x0

    .line 396
    .local v2, "_arg1":Landroid/os/Bundle;
    :goto_5
    nop

    invoke-virtual {p0, v0, v2}, Landroid/support/v4/media/session/IMediaSession$Stub;->prepareFromUri(Landroid/net/Uri;Landroid/os/Bundle;)V

    .line 397
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 398
    nop

    return v1

    .line 365
    .end local v0    # "_arg0":Landroid/net/Uri;
    .end local v2    # "_arg1":Landroid/os/Bundle;
    :pswitch_b
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 367
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 369
    .local v0, "_arg0":Ljava/lang/String;
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_7

    .line 370
    nop

    sget-object v2, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v2, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Bundle;

    goto :goto_6

    .line 373
    :cond_7
    nop

    const/4 v2, 0x0

    .line 375
    .restart local v2    # "_arg1":Landroid/os/Bundle;
    :goto_6
    nop

    invoke-virtual {p0, v0, v2}, Landroid/support/v4/media/session/IMediaSession$Stub;->prepareFromSearch(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 376
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 377
    nop

    return v1

    .line 349
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v2    # "_arg1":Landroid/os/Bundle;
    :pswitch_c
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 351
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 353
    .restart local v0    # "_arg0":Ljava/lang/String;
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_8

    .line 354
    nop

    sget-object v2, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v2, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Bundle;

    goto :goto_7

    .line 357
    :cond_8
    nop

    const/4 v2, 0x0

    .line 359
    .restart local v2    # "_arg1":Landroid/os/Bundle;
    :goto_7
    nop

    invoke-virtual {p0, v0, v2}, Landroid/support/v4/media/session/IMediaSession$Stub;->prepareFromMediaId(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 360
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 361
    nop

    return v1

    .line 342
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v2    # "_arg1":Landroid/os/Bundle;
    :pswitch_d
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 343
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->prepare()V

    .line 344
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 345
    nop

    return v1

    .line 257
    :pswitch_e
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 258
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->getRatingType()I

    move-result v0

    .line 259
    .local v0, "_result":I
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 260
    nop

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 261
    nop

    return v1

    .line 243
    .end local v0    # "_result":I
    :pswitch_f
    nop

    const-string v2, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 244
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    .line 245
    .local v2, "_result":Landroid/os/Bundle;
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 246
    nop

    if-eqz v2, :cond_9

    .line 247
    nop

    invoke-virtual {p3, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 248
    nop

    invoke-virtual {v2, p3, v1}, Landroid/os/Bundle;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_8

    .line 251
    :cond_9
    nop

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 253
    :goto_8
    nop

    return v1

    .line 229
    .end local v2    # "_result":Landroid/os/Bundle;
    :pswitch_10
    nop

    const-string v2, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 230
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->getQueueTitle()Ljava/lang/CharSequence;

    move-result-object v2

    .line 231
    .local v2, "_result":Ljava/lang/CharSequence;
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 232
    nop

    if-eqz v2, :cond_a

    .line 233
    nop

    invoke-virtual {p3, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 234
    nop

    invoke-static {v2, p3, v1}, Landroid/text/TextUtils;->writeToParcel(Ljava/lang/CharSequence;Landroid/os/Parcel;I)V

    goto :goto_9

    .line 237
    :cond_a
    nop

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 239
    :goto_9
    nop

    return v1

    .line 221
    .end local v2    # "_result":Ljava/lang/CharSequence;
    :pswitch_11
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 222
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->getQueue()Ljava/util/List;

    move-result-object v0

    .line 223
    .local v0, "_result":Ljava/util/List;, "Ljava/util/List<Landroid/support/v4/media/session/MediaSessionCompat$QueueItem;>;"
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 224
    nop

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeTypedList(Ljava/util/List;)V

    .line 225
    nop

    return v1

    .line 207
    .end local v0    # "_result":Ljava/util/List;, "Ljava/util/List<Landroid/support/v4/media/session/MediaSessionCompat$QueueItem;>;"
    :pswitch_12
    nop

    const-string v2, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 208
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->getPlaybackState()Landroid/support/v4/media/session/PlaybackStateCompat;

    move-result-object v2

    .line 209
    .local v2, "_result":Landroid/support/v4/media/session/PlaybackStateCompat;
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 210
    nop

    if-eqz v2, :cond_b

    .line 211
    nop

    invoke-virtual {p3, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 212
    nop

    invoke-virtual {v2, p3, v1}, Landroid/support/v4/media/session/PlaybackStateCompat;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_a

    .line 215
    :cond_b
    nop

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 217
    :goto_a
    nop

    return v1

    .line 193
    .end local v2    # "_result":Landroid/support/v4/media/session/PlaybackStateCompat;
    :pswitch_13
    nop

    const-string v2, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 194
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->getMetadata()Landroid/support/v4/media/MediaMetadataCompat;

    move-result-object v2

    .line 195
    .local v2, "_result":Landroid/support/v4/media/MediaMetadataCompat;
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 196
    nop

    if-eqz v2, :cond_c

    .line 197
    nop

    invoke-virtual {p3, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 198
    nop

    invoke-virtual {v2, p3, v1}, Landroid/support/v4/media/MediaMetadataCompat;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_b

    .line 201
    :cond_c
    nop

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 203
    :goto_b
    nop

    return v1

    .line 563
    .end local v2    # "_result":Landroid/support/v4/media/MediaMetadataCompat;
    :pswitch_14
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 565
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 567
    .local v0, "_arg0":Ljava/lang/String;
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_d

    .line 568
    nop

    sget-object v2, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v2, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Bundle;

    goto :goto_c

    .line 571
    :cond_d
    nop

    const/4 v2, 0x0

    .line 573
    .local v2, "_arg1":Landroid/os/Bundle;
    :goto_c
    nop

    invoke-virtual {p0, v0, v2}, Landroid/support/v4/media/session/IMediaSession$Stub;->sendCustomAction(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 574
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 575
    nop

    return v1

    .line 522
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v2    # "_arg1":Landroid/os/Bundle;
    :pswitch_15
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 524
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_e

    .line 525
    nop

    sget-object v0, Landroid/support/v4/media/RatingCompat;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/media/RatingCompat;

    goto :goto_d

    .line 528
    :cond_e
    nop

    const/4 v0, 0x0

    .line 530
    .local v0, "_arg0":Landroid/support/v4/media/RatingCompat;
    :goto_d
    nop

    invoke-virtual {p0, v0}, Landroid/support/v4/media/session/IMediaSession$Stub;->rate(Landroid/support/v4/media/RatingCompat;)V

    .line 531
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 532
    nop

    return v1

    .line 513
    .end local v0    # "_arg0":Landroid/support/v4/media/RatingCompat;
    :pswitch_16
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 515
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v2

    .line 516
    .local v2, "_arg0":J
    nop

    invoke-virtual {p0, v2, v3}, Landroid/support/v4/media/session/IMediaSession$Stub;->seekTo(J)V

    .line 517
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 518
    nop

    return v1

    .line 506
    .end local v2    # "_arg0":J
    :pswitch_17
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 507
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->rewind()V

    .line 508
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 509
    nop

    return v1

    .line 499
    :pswitch_18
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 500
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->fastForward()V

    .line 501
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 502
    nop

    return v1

    .line 492
    :pswitch_19
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 493
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->previous()V

    .line 494
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 495
    nop

    return v1

    .line 485
    :pswitch_1a
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 486
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->next()V

    .line 487
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 488
    nop

    return v1

    .line 478
    :pswitch_1b
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 479
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->stop()V

    .line 480
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 481
    nop

    return v1

    .line 471
    :pswitch_1c
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 472
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->pause()V

    .line 473
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 474
    nop

    return v1

    .line 462
    :pswitch_1d
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 464
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v2

    .line 465
    .restart local v2    # "_arg0":J
    nop

    invoke-virtual {p0, v2, v3}, Landroid/support/v4/media/session/IMediaSession$Stub;->skipToQueueItem(J)V

    .line 466
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 467
    nop

    return v1

    .line 441
    .end local v2    # "_arg0":J
    :pswitch_1e
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 443
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_f

    .line 444
    nop

    sget-object v0, Landroid/net/Uri;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    goto :goto_e

    .line 447
    :cond_f
    nop

    const/4 v0, 0x0

    .line 450
    .local v0, "_arg0":Landroid/net/Uri;
    :goto_e
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_10

    .line 451
    nop

    sget-object v2, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v2, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Bundle;

    goto :goto_f

    .line 454
    :cond_10
    nop

    const/4 v2, 0x0

    .line 456
    .local v2, "_arg1":Landroid/os/Bundle;
    :goto_f
    nop

    invoke-virtual {p0, v0, v2}, Landroid/support/v4/media/session/IMediaSession$Stub;->playFromUri(Landroid/net/Uri;Landroid/os/Bundle;)V

    .line 457
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 458
    nop

    return v1

    .line 425
    .end local v0    # "_arg0":Landroid/net/Uri;
    .end local v2    # "_arg1":Landroid/os/Bundle;
    :pswitch_1f
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 427
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 429
    .local v0, "_arg0":Ljava/lang/String;
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_11

    .line 430
    nop

    sget-object v2, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v2, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Bundle;

    goto :goto_10

    .line 433
    :cond_11
    nop

    const/4 v2, 0x0

    .line 435
    .restart local v2    # "_arg1":Landroid/os/Bundle;
    :goto_10
    nop

    invoke-virtual {p0, v0, v2}, Landroid/support/v4/media/session/IMediaSession$Stub;->playFromSearch(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 436
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 437
    nop

    return v1

    .line 409
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v2    # "_arg1":Landroid/os/Bundle;
    :pswitch_20
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 411
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 413
    .restart local v0    # "_arg0":Ljava/lang/String;
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_12

    .line 414
    nop

    sget-object v2, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v2, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Bundle;

    goto :goto_11

    .line 417
    :cond_12
    nop

    const/4 v2, 0x0

    .line 419
    .restart local v2    # "_arg1":Landroid/os/Bundle;
    :goto_11
    nop

    invoke-virtual {p0, v0, v2}, Landroid/support/v4/media/session/IMediaSession$Stub;->playFromMediaId(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 420
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 421
    nop

    return v1

    .line 402
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v2    # "_arg1":Landroid/os/Bundle;
    :pswitch_21
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 403
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->play()V

    .line 404
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 405
    nop

    return v1

    .line 180
    :pswitch_22
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 182
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 184
    .local v0, "_arg0":I
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 186
    .local v2, "_arg1":I
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 187
    .local v3, "_arg2":Ljava/lang/String;
    nop

    invoke-virtual {p0, v0, v2, v3}, Landroid/support/v4/media/session/IMediaSession$Stub;->setVolumeTo(IILjava/lang/String;)V

    .line 188
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 189
    nop

    return v1

    .line 167
    .end local v0    # "_arg0":I
    .end local v2    # "_arg1":I
    .end local v3    # "_arg2":Ljava/lang/String;
    :pswitch_23
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 169
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 171
    .restart local v0    # "_arg0":I
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 173
    .restart local v2    # "_arg1":I
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 174
    .restart local v3    # "_arg2":Ljava/lang/String;
    nop

    invoke-virtual {p0, v0, v2, v3}, Landroid/support/v4/media/session/IMediaSession$Stub;->adjustVolume(IILjava/lang/String;)V

    .line 175
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 176
    nop

    return v1

    .line 153
    .end local v0    # "_arg0":I
    .end local v2    # "_arg1":I
    .end local v3    # "_arg2":Ljava/lang/String;
    :pswitch_24
    nop

    const-string v2, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 154
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->getVolumeAttributes()Landroid/support/v4/media/session/ParcelableVolumeInfo;

    move-result-object v2

    .line 155
    .local v2, "_result":Landroid/support/v4/media/session/ParcelableVolumeInfo;
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 156
    nop

    if-eqz v2, :cond_13

    .line 157
    nop

    invoke-virtual {p3, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 158
    nop

    invoke-virtual {v2, p3, v1}, Landroid/support/v4/media/session/ParcelableVolumeInfo;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_12

    .line 161
    :cond_13
    nop

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 163
    :goto_12
    nop

    return v1

    .line 145
    .end local v2    # "_result":Landroid/support/v4/media/session/ParcelableVolumeInfo;
    :pswitch_25
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 146
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->getFlags()J

    move-result-wide v2

    .line 147
    .local v2, "_result":J
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 148
    nop

    invoke-virtual {p3, v2, v3}, Landroid/os/Parcel;->writeLong(J)V

    .line 149
    nop

    return v1

    .line 131
    .end local v2    # "_result":J
    :pswitch_26
    nop

    const-string v2, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 132
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->getLaunchPendingIntent()Landroid/app/PendingIntent;

    move-result-object v2

    .line 133
    .local v2, "_result":Landroid/app/PendingIntent;
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 134
    nop

    if-eqz v2, :cond_14

    .line 135
    nop

    invoke-virtual {p3, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 136
    nop

    invoke-virtual {v2, p3, v1}, Landroid/app/PendingIntent;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_13

    .line 139
    :cond_14
    nop

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 141
    :goto_13
    nop

    return v1

    .line 123
    .end local v2    # "_result":Landroid/app/PendingIntent;
    :pswitch_27
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 124
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->getTag()Ljava/lang/String;

    move-result-object v0

    .line 125
    .local v0, "_result":Ljava/lang/String;
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 126
    nop

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 127
    nop

    return v1

    .line 115
    .end local v0    # "_result":Ljava/lang/String;
    :pswitch_28
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 116
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->getPackageName()Ljava/lang/String;

    move-result-object v0

    .line 117
    .restart local v0    # "_result":Ljava/lang/String;
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 118
    nop

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 119
    nop

    return v1

    .line 107
    .end local v0    # "_result":Ljava/lang/String;
    :pswitch_29
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 108
    nop

    invoke-virtual {p0}, Landroid/support/v4/media/session/IMediaSession$Stub;->isTransportControlEnabled()Z

    move-result v0

    .line 109
    .local v0, "_result":Z
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 110
    nop

    nop

    nop

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 111
    nop

    return v1

    .line 98
    .end local v0    # "_result":Z
    :pswitch_2a
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 100
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Landroid/support/v4/media/session/IMediaControllerCallback$Stub;->asInterface(Landroid/os/IBinder;)Landroid/support/v4/media/session/IMediaControllerCallback;

    move-result-object v0

    .line 101
    .local v0, "_arg0":Landroid/support/v4/media/session/IMediaControllerCallback;
    nop

    invoke-virtual {p0, v0}, Landroid/support/v4/media/session/IMediaSession$Stub;->unregisterCallbackListener(Landroid/support/v4/media/session/IMediaControllerCallback;)V

    .line 102
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 103
    nop

    return v1

    .line 89
    .end local v0    # "_arg0":Landroid/support/v4/media/session/IMediaControllerCallback;
    :pswitch_2b
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 91
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Landroid/support/v4/media/session/IMediaControllerCallback$Stub;->asInterface(Landroid/os/IBinder;)Landroid/support/v4/media/session/IMediaControllerCallback;

    move-result-object v0

    .line 92
    .restart local v0    # "_arg0":Landroid/support/v4/media/session/IMediaControllerCallback;
    nop

    invoke-virtual {p0, v0}, Landroid/support/v4/media/session/IMediaSession$Stub;->registerCallbackListener(Landroid/support/v4/media/session/IMediaControllerCallback;)V

    .line 93
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 94
    nop

    return v1

    .line 74
    .end local v0    # "_arg0":Landroid/support/v4/media/session/IMediaControllerCallback;
    :pswitch_2c
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 76
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_15

    .line 77
    nop

    sget-object v0, Landroid/view/KeyEvent;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/KeyEvent;

    goto :goto_14

    .line 80
    :cond_15
    nop

    const/4 v0, 0x0

    .line 82
    .local v0, "_arg0":Landroid/view/KeyEvent;
    :goto_14
    nop

    invoke-virtual {p0, v0}, Landroid/support/v4/media/session/IMediaSession$Stub;->sendMediaButton(Landroid/view/KeyEvent;)Z

    move-result v2

    .line 83
    .local v2, "_result":Z
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 84
    nop

    nop

    nop

    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 85
    nop

    return v1

    .line 51
    .end local v0    # "_arg0":Landroid/view/KeyEvent;
    .end local v2    # "_result":Z
    :pswitch_2d
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 53
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 55
    .local v0, "_arg0":Ljava/lang/String;
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_16

    .line 56
    nop

    sget-object v2, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v2, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Bundle;

    goto :goto_15

    .line 59
    :cond_16
    nop

    const/4 v2, 0x0

    .line 62
    .local v2, "_arg1":Landroid/os/Bundle;
    :goto_15
    nop

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    if-eqz v3, :cond_17

    .line 63
    nop

    sget-object v3, Landroid/support/v4/media/session/MediaSessionCompat$ResultReceiverWrapper;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v3, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v4/media/session/MediaSessionCompat$ResultReceiverWrapper;

    goto :goto_16

    .line 66
    :cond_17
    nop

    const/4 v3, 0x0

    .line 68
    .local v3, "_arg2":Landroid/support/v4/media/session/MediaSessionCompat$ResultReceiverWrapper;
    :goto_16
    nop

    invoke-virtual {p0, v0, v2, v3}, Landroid/support/v4/media/session/IMediaSession$Stub;->sendCommand(Ljava/lang/String;Landroid/os/Bundle;Landroid/support/v4/media/session/MediaSessionCompat$ResultReceiverWrapper;)V

    .line 69
    nop

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 70
    nop

    return v1

    .line 46
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v2    # "_arg1":Landroid/os/Bundle;
    .end local v3    # "_arg2":Landroid/support/v4/media/session/MediaSessionCompat$ResultReceiverWrapper;
    :cond_18
    nop

    const-string v0, "android.support.v4.media.session.IMediaSession"

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 47
    nop

    return v1

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2d
        :pswitch_2c
        :pswitch_2b
        :pswitch_2a
        :pswitch_29
        :pswitch_28
        :pswitch_27
        :pswitch_26
        :pswitch_25
        :pswitch_24
        :pswitch_23
        :pswitch_22
        :pswitch_21
        :pswitch_20
        :pswitch_1f
        :pswitch_1e
        :pswitch_1d
        :pswitch_1c
        :pswitch_1b
        :pswitch_1a
        :pswitch_19
        :pswitch_18
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
