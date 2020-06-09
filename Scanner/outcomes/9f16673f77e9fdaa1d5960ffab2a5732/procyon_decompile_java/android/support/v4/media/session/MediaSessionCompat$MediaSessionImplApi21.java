// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import android.support.v4.media.VolumeProviderCompat;
import android.app.PendingIntent;
import java.lang.ref.WeakReference;
import android.os.Handler;
import android.os.RemoteException;
import android.os.Bundle;
import android.os.Build$VERSION;
import android.content.Context;
import android.support.v4.media.MediaMetadataCompat;
import android.os.RemoteCallbackList;

class MediaSessionCompat$MediaSessionImplApi21 implements MediaSessionCompat$MediaSessionImpl
{
    boolean mCaptioningEnabled;
    private boolean mDestroyed;
    private final RemoteCallbackList mExtraControllerCallbacks;
    private MediaMetadataCompat mMetadata;
    private PlaybackStateCompat mPlaybackState;
    int mRatingType;
    int mRepeatMode;
    private final Object mSessionObj;
    boolean mShuffleModeEnabled;
    private final MediaSessionCompat$Token mToken;
    
    public MediaSessionCompat$MediaSessionImplApi21(final Context context, final String s) {
        this.mDestroyed = false;
        this.mExtraControllerCallbacks = new RemoteCallbackList();
        this.mSessionObj = MediaSessionCompatApi21.createSession(context, s);
        this.mToken = new MediaSessionCompat$Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj), new MediaSessionCompat$MediaSessionImplApi21$ExtraSession(this));
    }
    
    public MediaSessionCompat$MediaSessionImplApi21(final Object o) {
        this.mDestroyed = false;
        this.mExtraControllerCallbacks = new RemoteCallbackList();
        this.mSessionObj = MediaSessionCompatApi21.verifySession(o);
        this.mToken = new MediaSessionCompat$Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj), new MediaSessionCompat$MediaSessionImplApi21$ExtraSession(this));
    }
    
    public String getCallingPackage() {
        if (Build$VERSION.SDK_INT < 24) {
            return null;
        }
        return MediaSessionCompatApi24.getCallingPackage(this.mSessionObj);
    }
    
    public Object getMediaSession() {
        return this.mSessionObj;
    }
    
    public Object getRemoteControlClient() {
        return null;
    }
    
    public MediaSessionCompat$Token getSessionToken() {
        return this.mToken;
    }
    
    public boolean isActive() {
        return MediaSessionCompatApi21.isActive(this.mSessionObj);
    }
    
    public void release() {
        this.mDestroyed = true;
        MediaSessionCompatApi21.release(this.mSessionObj);
    }
    
    public void sendSessionEvent(final String s, final Bundle bundle) {
        if (Build$VERSION.SDK_INT < 23) {
            for (int i = this.mExtraControllerCallbacks.beginBroadcast() - 1; i >= 0; --i) {
                final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(i);
                try {
                    mediaControllerCallback.onEvent(s, bundle);
                }
                catch (RemoteException ex) {}
            }
            this.mExtraControllerCallbacks.finishBroadcast();
        }
        MediaSessionCompatApi21.sendSessionEvent(this.mSessionObj, s, bundle);
    }
    
    public void setActive(final boolean b) {
        MediaSessionCompatApi21.setActive(this.mSessionObj, b);
    }
    
    public void setCallback(final MediaSessionCompat$Callback mediaSessionCompat$Callback, final Handler handler) {
        final Object mSessionObj = this.mSessionObj;
        Object mCallbackObj;
        if (mediaSessionCompat$Callback == null) {
            mCallbackObj = null;
        }
        else {
            mCallbackObj = mediaSessionCompat$Callback.mCallbackObj;
        }
        MediaSessionCompatApi21.setCallback(mSessionObj, mCallbackObj, handler);
        if (mediaSessionCompat$Callback != null) {
            mediaSessionCompat$Callback.mSessionImpl = new WeakReference((T)this);
        }
    }
    
    public void setCaptioningEnabled(final boolean mCaptioningEnabled) {
        if (this.mCaptioningEnabled != mCaptioningEnabled) {
            this.mCaptioningEnabled = mCaptioningEnabled;
            for (int i = this.mExtraControllerCallbacks.beginBroadcast() - 1; i >= 0; --i) {
                final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(i);
                try {
                    mediaControllerCallback.onCaptioningEnabledChanged(mCaptioningEnabled);
                }
                catch (RemoteException ex) {}
            }
            this.mExtraControllerCallbacks.finishBroadcast();
        }
    }
    
    public void setExtras(final Bundle bundle) {
        MediaSessionCompatApi21.setExtras(this.mSessionObj, bundle);
    }
    
    public void setFlags(final int n) {
        MediaSessionCompatApi21.setFlags(this.mSessionObj, n);
    }
    
    public void setMediaButtonReceiver(final PendingIntent pendingIntent) {
        MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, pendingIntent);
    }
    
    public void setMetadata(final MediaMetadataCompat mMetadata) {
        this.mMetadata = mMetadata;
        final Object mSessionObj = this.mSessionObj;
        Object mediaMetadata;
        if (mMetadata == null) {
            mediaMetadata = null;
        }
        else {
            mediaMetadata = mMetadata.getMediaMetadata();
        }
        MediaSessionCompatApi21.setMetadata(mSessionObj, mediaMetadata);
    }
    
    public void setPlaybackState(final PlaybackStateCompat mPlaybackState) {
        this.mPlaybackState = mPlaybackState;
        for (int i = this.mExtraControllerCallbacks.beginBroadcast() - 1; i >= 0; --i) {
            final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(i);
            try {
                mediaControllerCallback.onPlaybackStateChanged(mPlaybackState);
            }
            catch (RemoteException ex) {}
        }
        this.mExtraControllerCallbacks.finishBroadcast();
        final Object mSessionObj = this.mSessionObj;
        Object playbackState;
        if (mPlaybackState == null) {
            playbackState = null;
        }
        else {
            playbackState = mPlaybackState.getPlaybackState();
        }
        MediaSessionCompatApi21.setPlaybackState(mSessionObj, playbackState);
    }
    
    public void setPlaybackToLocal(final int n) {
        MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, n);
    }
    
    public void setPlaybackToRemote(final VolumeProviderCompat volumeProviderCompat) {
        MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, volumeProviderCompat.getVolumeProvider());
    }
    
    public void setQueue(final List list) {
        List<Object> list2 = null;
        if (list != null) {
            list2 = new ArrayList<Object>();
            final Iterator<MediaSessionCompat$QueueItem> iterator = list.iterator();
            while (iterator.hasNext()) {
                list2.add(iterator.next().getQueueItem());
            }
        }
        MediaSessionCompatApi21.setQueue(this.mSessionObj, list2);
    }
    
    public void setQueueTitle(final CharSequence charSequence) {
        MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, charSequence);
    }
    
    public void setRatingType(final int mRatingType) {
        if (Build$VERSION.SDK_INT < 22) {
            this.mRatingType = mRatingType;
        }
        else {
            MediaSessionCompatApi22.setRatingType(this.mSessionObj, mRatingType);
        }
    }
    
    public void setRepeatMode(final int mRepeatMode) {
        if (this.mRepeatMode != mRepeatMode) {
            this.mRepeatMode = mRepeatMode;
            for (int i = this.mExtraControllerCallbacks.beginBroadcast() - 1; i >= 0; --i) {
                final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(i);
                try {
                    mediaControllerCallback.onRepeatModeChanged(mRepeatMode);
                }
                catch (RemoteException ex) {}
            }
            this.mExtraControllerCallbacks.finishBroadcast();
        }
    }
    
    public void setSessionActivity(final PendingIntent pendingIntent) {
        MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, pendingIntent);
    }
    
    public void setShuffleModeEnabled(final boolean mShuffleModeEnabled) {
        if (this.mShuffleModeEnabled != mShuffleModeEnabled) {
            this.mShuffleModeEnabled = mShuffleModeEnabled;
            for (int i = this.mExtraControllerCallbacks.beginBroadcast() - 1; i >= 0; --i) {
                final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(i);
                try {
                    mediaControllerCallback.onShuffleModeChanged(mShuffleModeEnabled);
                }
                catch (RemoteException ex) {}
            }
            this.mExtraControllerCallbacks.finishBroadcast();
        }
    }
}
