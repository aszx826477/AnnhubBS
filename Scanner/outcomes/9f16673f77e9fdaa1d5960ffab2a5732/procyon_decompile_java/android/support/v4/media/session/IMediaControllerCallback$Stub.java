// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.support.v4.media.MediaMetadataCompat;
import java.util.List;
import android.text.TextUtils;
import android.os.Bundle;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public abstract class IMediaControllerCallback$Stub extends Binder implements IMediaControllerCallback
{
    private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaControllerCallback";
    static final int TRANSACTION_onCaptioningEnabledChanged = 11;
    static final int TRANSACTION_onEvent = 1;
    static final int TRANSACTION_onExtrasChanged = 7;
    static final int TRANSACTION_onMetadataChanged = 4;
    static final int TRANSACTION_onPlaybackStateChanged = 3;
    static final int TRANSACTION_onQueueChanged = 5;
    static final int TRANSACTION_onQueueTitleChanged = 6;
    static final int TRANSACTION_onRepeatModeChanged = 9;
    static final int TRANSACTION_onSessionDestroyed = 2;
    static final int TRANSACTION_onShuffleModeChanged = 10;
    static final int TRANSACTION_onVolumeInfoChanged = 8;
    
    public IMediaControllerCallback$Stub() {
        this.attachInterface((IInterface)this, "android.support.v4.media.session.IMediaControllerCallback");
    }
    
    public static IMediaControllerCallback asInterface(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
        if (queryLocalInterface != null && queryLocalInterface instanceof IMediaControllerCallback) {
            return (IMediaControllerCallback)queryLocalInterface;
        }
        return new IMediaControllerCallback$Stub$Proxy(binder);
    }
    
    public IBinder asBinder() {
        return (IBinder)this;
    }
    
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) {
        final int n3 = 1598968902;
        final boolean b = true;
        if (n == n3) {
            parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return b;
        }
        boolean b2 = false;
        switch (n) {
            default: {
                return super.onTransact(n, parcel, parcel2, n2);
            }
            case 11: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                if (parcel.readInt() != 0) {
                    b2 = true;
                }
                this.onCaptioningEnabledChanged(b2);
                return b;
            }
            case 10: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                if (parcel.readInt() != 0) {
                    b2 = true;
                }
                this.onShuffleModeChanged(b2);
                return b;
            }
            case 9: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                this.onRepeatModeChanged(parcel.readInt());
                return b;
            }
            case 8: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                ParcelableVolumeInfo parcelableVolumeInfo;
                if (parcel.readInt() != 0) {
                    parcelableVolumeInfo = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(parcel);
                }
                else {
                    parcelableVolumeInfo = null;
                }
                this.onVolumeInfoChanged(parcelableVolumeInfo);
                return b;
            }
            case 7: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                Bundle bundle;
                if (parcel.readInt() != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                else {
                    bundle = null;
                }
                this.onExtrasChanged(bundle);
                return b;
            }
            case 6: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                CharSequence charSequence;
                if (parcel.readInt() != 0) {
                    charSequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                }
                else {
                    charSequence = null;
                }
                this.onQueueTitleChanged(charSequence);
                return b;
            }
            case 5: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                this.onQueueChanged(parcel.createTypedArrayList(MediaSessionCompat$QueueItem.CREATOR));
                return b;
            }
            case 4: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                MediaMetadataCompat mediaMetadataCompat;
                if (parcel.readInt() != 0) {
                    mediaMetadataCompat = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(parcel);
                }
                else {
                    mediaMetadataCompat = null;
                }
                this.onMetadataChanged(mediaMetadataCompat);
                return b;
            }
            case 3: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                PlaybackStateCompat playbackStateCompat;
                if (parcel.readInt() != 0) {
                    playbackStateCompat = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(parcel);
                }
                else {
                    playbackStateCompat = null;
                }
                this.onPlaybackStateChanged(playbackStateCompat);
                return b;
            }
            case 2: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                this.onSessionDestroyed();
                return b;
            }
            case 1: {
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                final String string = parcel.readString();
                Bundle bundle2;
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                else {
                    bundle2 = null;
                }
                this.onEvent(string, bundle2);
                return b;
            }
        }
    }
}
