// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.view.KeyEvent;
import android.support.v4.media.RatingCompat;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.media.MediaDescriptionCompat;
import android.os.IBinder;

class IMediaSession$Stub$Proxy implements IMediaSession
{
    private IBinder mRemote;
    
    IMediaSession$Stub$Proxy(final IBinder mRemote) {
        this.mRemote = mRemote;
    }
    
    public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            if (mediaDescriptionCompat != null) {
                obtain.writeInt(1);
                mediaDescriptionCompat.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            this.mRemote.transact(41, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void addQueueItemAt(final MediaDescriptionCompat mediaDescriptionCompat, final int n) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            if (mediaDescriptionCompat != null) {
                obtain.writeInt(1);
                mediaDescriptionCompat.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            obtain.writeInt(n);
            this.mRemote.transact(42, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void adjustVolume(final int n, final int n2, final String s) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s2 = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s2);
            obtain.writeInt(n);
            obtain.writeInt(n2);
            obtain.writeString(s);
            this.mRemote.transact(11, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public IBinder asBinder() {
        return this.mRemote;
    }
    
    public void fastForward() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(22, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public Bundle getExtras() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(31, obtain, obtain2, 0);
            obtain2.readException();
            Bundle bundle;
            if (obtain2.readInt() != 0) {
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(obtain2);
            }
            else {
                bundle = null;
            }
            return bundle;
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public long getFlags() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readLong();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public String getInterfaceDescriptor() {
        return "android.support.v4.media.session.IMediaSession";
    }
    
    public PendingIntent getLaunchPendingIntent() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            PendingIntent pendingIntent;
            if (obtain2.readInt() != 0) {
                pendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(obtain2);
            }
            else {
                pendingIntent = null;
            }
            return pendingIntent;
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public MediaMetadataCompat getMetadata() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(27, obtain, obtain2, 0);
            obtain2.readException();
            MediaMetadataCompat mediaMetadataCompat;
            if (obtain2.readInt() != 0) {
                mediaMetadataCompat = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(obtain2);
            }
            else {
                mediaMetadataCompat = null;
            }
            return mediaMetadataCompat;
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public String getPackageName() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public PlaybackStateCompat getPlaybackState() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(28, obtain, obtain2, 0);
            obtain2.readException();
            PlaybackStateCompat playbackStateCompat;
            if (obtain2.readInt() != 0) {
                playbackStateCompat = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(obtain2);
            }
            else {
                playbackStateCompat = null;
            }
            return playbackStateCompat;
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public List getQueue() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(29, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.createTypedArrayList(MediaSessionCompat$QueueItem.CREATOR);
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public CharSequence getQueueTitle() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(30, obtain, obtain2, 0);
            obtain2.readException();
            CharSequence charSequence;
            if (obtain2.readInt() != 0) {
                charSequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(obtain2);
            }
            else {
                charSequence = null;
            }
            return charSequence;
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public int getRatingType() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(32, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public int getRepeatMode() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(37, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public String getTag() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public ParcelableVolumeInfo getVolumeAttributes() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(10, obtain, obtain2, 0);
            obtain2.readException();
            ParcelableVolumeInfo parcelableVolumeInfo;
            if (obtain2.readInt() != 0) {
                parcelableVolumeInfo = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(obtain2);
            }
            else {
                parcelableVolumeInfo = null;
            }
            return parcelableVolumeInfo;
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public boolean isCaptioningEnabled() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        boolean b = false;
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(45, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                b = true;
            }
            return b;
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public boolean isShuffleModeEnabled() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        boolean b = false;
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(38, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                b = true;
            }
            return b;
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public boolean isTransportControlEnabled() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        boolean b = false;
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                b = true;
            }
            return b;
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void next() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(20, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void pause() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(18, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void play() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(13, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void playFromMediaId(final String s, final Bundle bundle) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s2 = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s2);
            obtain.writeString(s);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            this.mRemote.transact(14, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void playFromSearch(final String s, final Bundle bundle) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s2 = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s2);
            obtain.writeString(s);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            this.mRemote.transact(15, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void playFromUri(final Uri uri, final Bundle bundle) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            final int n = 1;
            if (uri != null) {
                obtain.writeInt(n);
                uri.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            if (bundle != null) {
                obtain.writeInt(n);
                bundle.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            this.mRemote.transact(16, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void prepare() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(33, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void prepareFromMediaId(final String s, final Bundle bundle) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s2 = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s2);
            obtain.writeString(s);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            this.mRemote.transact(34, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void prepareFromSearch(final String s, final Bundle bundle) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s2 = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s2);
            obtain.writeString(s);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            this.mRemote.transact(35, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void prepareFromUri(final Uri uri, final Bundle bundle) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            final int n = 1;
            if (uri != null) {
                obtain.writeInt(n);
                uri.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            if (bundle != null) {
                obtain.writeInt(n);
                bundle.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            this.mRemote.transact(36, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void previous() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(21, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void rate(final RatingCompat ratingCompat) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            if (ratingCompat != null) {
                obtain.writeInt(1);
                ratingCompat.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            this.mRemote.transact(25, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void registerCallbackListener(final IMediaControllerCallback mediaControllerCallback) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            IBinder binder;
            if (mediaControllerCallback != null) {
                binder = mediaControllerCallback.asBinder();
            }
            else {
                binder = null;
            }
            obtain.writeStrongBinder(binder);
            this.mRemote.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void removeQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            if (mediaDescriptionCompat != null) {
                obtain.writeInt(1);
                mediaDescriptionCompat.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            this.mRemote.transact(43, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void removeQueueItemAt(final int n) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            obtain.writeInt(n);
            this.mRemote.transact(44, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void rewind() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(23, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void seekTo(final long n) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            obtain.writeLong(n);
            this.mRemote.transact(24, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void sendCommand(final String s, final Bundle bundle, final MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s2 = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s2);
            obtain.writeString(s);
            final int n = 1;
            if (bundle != null) {
                obtain.writeInt(n);
                bundle.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            if (mediaSessionCompat$ResultReceiverWrapper != null) {
                obtain.writeInt(n);
                mediaSessionCompat$ResultReceiverWrapper.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            this.mRemote.transact(n, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void sendCustomAction(final String s, final Bundle bundle) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s2 = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s2);
            obtain.writeString(s);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            this.mRemote.transact(26, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public boolean sendMediaButton(final KeyEvent keyEvent) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        boolean b = false;
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            final int n = 1;
            if (keyEvent != null) {
                obtain.writeInt(n);
                keyEvent.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            this.mRemote.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                b = true;
            }
            return b;
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void setCaptioningEnabled(final boolean b) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            int n;
            if (b) {
                n = 1;
            }
            else {
                n = 0;
            }
            obtain.writeInt(n);
            this.mRemote.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void setRepeatMode(final int n) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            obtain.writeInt(n);
            this.mRemote.transact(39, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void setShuffleModeEnabled(final boolean b) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            int n;
            if (b) {
                n = 1;
            }
            else {
                n = 0;
            }
            obtain.writeInt(n);
            this.mRemote.transact(40, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void setVolumeTo(final int n, final int n2, final String s) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s2 = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s2);
            obtain.writeInt(n);
            obtain.writeInt(n2);
            obtain.writeString(s);
            this.mRemote.transact(12, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void skipToQueueItem(final long n) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            obtain.writeLong(n);
            this.mRemote.transact(17, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void stop() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            this.mRemote.transact(19, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public void unregisterCallbackListener(final IMediaControllerCallback mediaControllerCallback) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        final String s = "android.support.v4.media.session.IMediaSession";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            IBinder binder;
            if (mediaControllerCallback != null) {
                binder = mediaControllerCallback.asBinder();
            }
            else {
                binder = null;
            }
            obtain.writeStrongBinder(binder);
            this.mRemote.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
