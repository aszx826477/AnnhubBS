// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.app.PendingIntent;
import android.support.v4.media.MediaMetadataCompat;
import java.util.List;
import android.view.KeyEvent;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.os.Bundle;
import android.net.Uri;
import android.support.v4.media.MediaDescriptionCompat;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public abstract class IMediaSession$Stub extends Binder implements IMediaSession
{
    private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaSession";
    static final int TRANSACTION_addQueueItem = 41;
    static final int TRANSACTION_addQueueItemAt = 42;
    static final int TRANSACTION_adjustVolume = 11;
    static final int TRANSACTION_fastForward = 22;
    static final int TRANSACTION_getExtras = 31;
    static final int TRANSACTION_getFlags = 9;
    static final int TRANSACTION_getLaunchPendingIntent = 8;
    static final int TRANSACTION_getMetadata = 27;
    static final int TRANSACTION_getPackageName = 6;
    static final int TRANSACTION_getPlaybackState = 28;
    static final int TRANSACTION_getQueue = 29;
    static final int TRANSACTION_getQueueTitle = 30;
    static final int TRANSACTION_getRatingType = 32;
    static final int TRANSACTION_getRepeatMode = 37;
    static final int TRANSACTION_getTag = 7;
    static final int TRANSACTION_getVolumeAttributes = 10;
    static final int TRANSACTION_isCaptioningEnabled = 45;
    static final int TRANSACTION_isShuffleModeEnabled = 38;
    static final int TRANSACTION_isTransportControlEnabled = 5;
    static final int TRANSACTION_next = 20;
    static final int TRANSACTION_pause = 18;
    static final int TRANSACTION_play = 13;
    static final int TRANSACTION_playFromMediaId = 14;
    static final int TRANSACTION_playFromSearch = 15;
    static final int TRANSACTION_playFromUri = 16;
    static final int TRANSACTION_prepare = 33;
    static final int TRANSACTION_prepareFromMediaId = 34;
    static final int TRANSACTION_prepareFromSearch = 35;
    static final int TRANSACTION_prepareFromUri = 36;
    static final int TRANSACTION_previous = 21;
    static final int TRANSACTION_rate = 25;
    static final int TRANSACTION_registerCallbackListener = 3;
    static final int TRANSACTION_removeQueueItem = 43;
    static final int TRANSACTION_removeQueueItemAt = 44;
    static final int TRANSACTION_rewind = 23;
    static final int TRANSACTION_seekTo = 24;
    static final int TRANSACTION_sendCommand = 1;
    static final int TRANSACTION_sendCustomAction = 26;
    static final int TRANSACTION_sendMediaButton = 2;
    static final int TRANSACTION_setCaptioningEnabled = 46;
    static final int TRANSACTION_setRepeatMode = 39;
    static final int TRANSACTION_setShuffleModeEnabled = 40;
    static final int TRANSACTION_setVolumeTo = 12;
    static final int TRANSACTION_skipToQueueItem = 17;
    static final int TRANSACTION_stop = 19;
    static final int TRANSACTION_unregisterCallbackListener = 4;
    
    public IMediaSession$Stub() {
        this.attachInterface((IInterface)this, "android.support.v4.media.session.IMediaSession");
    }
    
    public static IMediaSession asInterface(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
        if (queryLocalInterface != null && queryLocalInterface instanceof IMediaSession) {
            return (IMediaSession)queryLocalInterface;
        }
        return new IMediaSession$Stub$Proxy(binder);
    }
    
    public IBinder asBinder() {
        return (IBinder)this;
    }
    
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) {
        final int n3 = 1598968902;
        final int n4 = 1;
        if (n == n3) {
            parcel2.writeString("android.support.v4.media.session.IMediaSession");
            return n4 != 0;
        }
        boolean b = false;
        switch (n) {
            default: {
                return super.onTransact(n, parcel, parcel2, n2);
            }
            case 46: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                if (parcel.readInt() != 0) {
                    b = true;
                }
                this.setCaptioningEnabled(b);
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 45: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final int captioningEnabled = this.isCaptioningEnabled() ? 1 : 0;
                parcel2.writeNoException();
                parcel2.writeInt(captioningEnabled);
                return n4 != 0;
            }
            case 44: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                this.removeQueueItemAt(parcel.readInt());
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 43: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                MediaDescriptionCompat mediaDescriptionCompat;
                if (parcel.readInt() != 0) {
                    mediaDescriptionCompat = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                }
                else {
                    mediaDescriptionCompat = null;
                }
                this.removeQueueItem(mediaDescriptionCompat);
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 42: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                MediaDescriptionCompat mediaDescriptionCompat2;
                if (parcel.readInt() != 0) {
                    mediaDescriptionCompat2 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                }
                else {
                    mediaDescriptionCompat2 = null;
                }
                this.addQueueItemAt(mediaDescriptionCompat2, parcel.readInt());
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 41: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                MediaDescriptionCompat mediaDescriptionCompat3;
                if (parcel.readInt() != 0) {
                    mediaDescriptionCompat3 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                }
                else {
                    mediaDescriptionCompat3 = null;
                }
                this.addQueueItem(mediaDescriptionCompat3);
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 40: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                if (parcel.readInt() != 0) {
                    b = true;
                }
                this.setShuffleModeEnabled(b);
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 39: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                this.setRepeatMode(parcel.readInt());
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 38: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final int shuffleModeEnabled = this.isShuffleModeEnabled() ? 1 : 0;
                parcel2.writeNoException();
                parcel2.writeInt(shuffleModeEnabled);
                return n4 != 0;
            }
            case 37: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final int repeatMode = this.getRepeatMode();
                parcel2.writeNoException();
                parcel2.writeInt(repeatMode);
                return n4 != 0;
            }
            case 36: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                Uri uri;
                if (parcel.readInt() != 0) {
                    uri = (Uri)Uri.CREATOR.createFromParcel(parcel);
                }
                else {
                    uri = null;
                }
                Bundle bundle;
                if (parcel.readInt() != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                else {
                    bundle = null;
                }
                this.prepareFromUri(uri, bundle);
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 35: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final String string = parcel.readString();
                Bundle bundle2;
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                else {
                    bundle2 = null;
                }
                this.prepareFromSearch(string, bundle2);
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 34: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final String string2 = parcel.readString();
                Bundle bundle3;
                if (parcel.readInt() != 0) {
                    bundle3 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                else {
                    bundle3 = null;
                }
                this.prepareFromMediaId(string2, bundle3);
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 33: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                this.prepare();
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 32: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final int ratingType = this.getRatingType();
                parcel2.writeNoException();
                parcel2.writeInt(ratingType);
                return n4 != 0;
            }
            case 31: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final Bundle extras = this.getExtras();
                parcel2.writeNoException();
                if (extras != null) {
                    parcel2.writeInt(n4);
                    extras.writeToParcel(parcel2, n4);
                }
                else {
                    parcel2.writeInt(0);
                }
                return n4 != 0;
            }
            case 30: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final CharSequence queueTitle = this.getQueueTitle();
                parcel2.writeNoException();
                if (queueTitle != null) {
                    parcel2.writeInt(n4);
                    TextUtils.writeToParcel(queueTitle, parcel2, n4);
                }
                else {
                    parcel2.writeInt(0);
                }
                return n4 != 0;
            }
            case 29: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final List queue = this.getQueue();
                parcel2.writeNoException();
                parcel2.writeTypedList(queue);
                return n4 != 0;
            }
            case 28: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final PlaybackStateCompat playbackState = this.getPlaybackState();
                parcel2.writeNoException();
                if (playbackState != null) {
                    parcel2.writeInt(n4);
                    playbackState.writeToParcel(parcel2, n4);
                }
                else {
                    parcel2.writeInt(0);
                }
                return n4 != 0;
            }
            case 27: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final MediaMetadataCompat metadata = this.getMetadata();
                parcel2.writeNoException();
                if (metadata != null) {
                    parcel2.writeInt(n4);
                    metadata.writeToParcel(parcel2, n4);
                }
                else {
                    parcel2.writeInt(0);
                }
                return n4 != 0;
            }
            case 26: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final String string3 = parcel.readString();
                Bundle bundle4;
                if (parcel.readInt() != 0) {
                    bundle4 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                else {
                    bundle4 = null;
                }
                this.sendCustomAction(string3, bundle4);
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 25: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                RatingCompat ratingCompat;
                if (parcel.readInt() != 0) {
                    ratingCompat = (RatingCompat)RatingCompat.CREATOR.createFromParcel(parcel);
                }
                else {
                    ratingCompat = null;
                }
                this.rate(ratingCompat);
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 24: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                this.seekTo(parcel.readLong());
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 23: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                this.rewind();
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 22: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                this.fastForward();
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 21: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                this.previous();
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 20: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                this.next();
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 19: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                this.stop();
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 18: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                this.pause();
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 17: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                this.skipToQueueItem(parcel.readLong());
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 16: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                Uri uri2;
                if (parcel.readInt() != 0) {
                    uri2 = (Uri)Uri.CREATOR.createFromParcel(parcel);
                }
                else {
                    uri2 = null;
                }
                Bundle bundle5;
                if (parcel.readInt() != 0) {
                    bundle5 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                else {
                    bundle5 = null;
                }
                this.playFromUri(uri2, bundle5);
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 15: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final String string4 = parcel.readString();
                Bundle bundle6;
                if (parcel.readInt() != 0) {
                    bundle6 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                else {
                    bundle6 = null;
                }
                this.playFromSearch(string4, bundle6);
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 14: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final String string5 = parcel.readString();
                Bundle bundle7;
                if (parcel.readInt() != 0) {
                    bundle7 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                else {
                    bundle7 = null;
                }
                this.playFromMediaId(string5, bundle7);
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 13: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                this.play();
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 12: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                this.setVolumeTo(parcel.readInt(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 11: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                this.adjustVolume(parcel.readInt(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 10: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final ParcelableVolumeInfo volumeAttributes = this.getVolumeAttributes();
                parcel2.writeNoException();
                if (volumeAttributes != null) {
                    parcel2.writeInt(n4);
                    volumeAttributes.writeToParcel(parcel2, n4);
                }
                else {
                    parcel2.writeInt(0);
                }
                return n4 != 0;
            }
            case 9: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final long flags = this.getFlags();
                parcel2.writeNoException();
                parcel2.writeLong(flags);
                return n4 != 0;
            }
            case 8: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final PendingIntent launchPendingIntent = this.getLaunchPendingIntent();
                parcel2.writeNoException();
                if (launchPendingIntent != null) {
                    parcel2.writeInt(n4);
                    launchPendingIntent.writeToParcel(parcel2, n4);
                }
                else {
                    parcel2.writeInt(0);
                }
                return n4 != 0;
            }
            case 7: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final String tag = this.getTag();
                parcel2.writeNoException();
                parcel2.writeString(tag);
                return n4 != 0;
            }
            case 6: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final String packageName = this.getPackageName();
                parcel2.writeNoException();
                parcel2.writeString(packageName);
                return n4 != 0;
            }
            case 5: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final int transportControlEnabled = this.isTransportControlEnabled() ? 1 : 0;
                parcel2.writeNoException();
                parcel2.writeInt(transportControlEnabled);
                return n4 != 0;
            }
            case 4: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                this.unregisterCallbackListener(IMediaControllerCallback$Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 3: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                this.registerCallbackListener(IMediaControllerCallback$Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return n4 != 0;
            }
            case 2: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                KeyEvent keyEvent;
                if (parcel.readInt() != 0) {
                    keyEvent = (KeyEvent)KeyEvent.CREATOR.createFromParcel(parcel);
                }
                else {
                    keyEvent = null;
                }
                final int sendMediaButton = this.sendMediaButton(keyEvent) ? 1 : 0;
                parcel2.writeNoException();
                parcel2.writeInt(sendMediaButton);
                return n4 != 0;
            }
            case 1: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                final String string6 = parcel.readString();
                Bundle bundle8;
                if (parcel.readInt() != 0) {
                    bundle8 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                else {
                    bundle8 = null;
                }
                MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper;
                if (parcel.readInt() != 0) {
                    mediaSessionCompat$ResultReceiverWrapper = (MediaSessionCompat$ResultReceiverWrapper)MediaSessionCompat$ResultReceiverWrapper.CREATOR.createFromParcel(parcel);
                }
                else {
                    mediaSessionCompat$ResultReceiverWrapper = null;
                }
                this.sendCommand(string6, bundle8, mediaSessionCompat$ResultReceiverWrapper);
                parcel2.writeNoException();
                return n4 != 0;
            }
        }
    }
}
