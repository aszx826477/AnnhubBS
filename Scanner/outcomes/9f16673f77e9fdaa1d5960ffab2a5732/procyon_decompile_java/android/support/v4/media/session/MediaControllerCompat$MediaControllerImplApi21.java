// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.IBinder$DeathRecipient;
import android.app.PendingIntent;
import android.os.Build$VERSION;
import android.support.v4.media.MediaMetadataCompat;
import android.view.KeyEvent;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.os.ResultReceiver;
import android.os.Bundle;
import android.os.Handler;
import java.util.Iterator;
import android.util.Log;
import android.os.RemoteException;
import java.util.ArrayList;
import android.content.Context;
import java.util.List;
import java.util.HashMap;

class MediaControllerCompat$MediaControllerImplApi21 implements MediaControllerCompat$MediaControllerImpl
{
    private HashMap mCallbackMap;
    protected final Object mControllerObj;
    private IMediaSession mExtraBinder;
    private List mPendingCallbacks;
    
    public MediaControllerCompat$MediaControllerImplApi21(final Context context, final MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.mCallbackMap = new HashMap();
        this.mPendingCallbacks = new ArrayList();
        this.mControllerObj = MediaControllerCompatApi21.fromToken(context, mediaSessionCompat$Token.getToken());
        if (this.mControllerObj != null) {
            this.mExtraBinder = mediaSessionCompat$Token.getExtraBinder();
            if (this.mExtraBinder == null) {
                this.requestExtraBinder();
            }
            return;
        }
        throw new RemoteException();
    }
    
    public MediaControllerCompat$MediaControllerImplApi21(final Context context, final MediaSessionCompat mediaSessionCompat) {
        this.mCallbackMap = new HashMap();
        this.mPendingCallbacks = new ArrayList();
        this.mControllerObj = MediaControllerCompatApi21.fromToken(context, mediaSessionCompat.getSessionToken().getToken());
        this.mExtraBinder = mediaSessionCompat.getSessionToken().getExtraBinder();
        if (this.mExtraBinder == null) {
            this.requestExtraBinder();
        }
    }
    
    private void processPendingCallbacks() {
        if (this.mExtraBinder == null) {
            return;
        }
        synchronized (this.mPendingCallbacks) {
            for (final MediaControllerCompat$Callback mediaControllerCompat$Callback : this.mPendingCallbacks) {
                final MediaControllerCompat$MediaControllerImplApi21$ExtraCallback mediaControllerCompat$MediaControllerImplApi21$ExtraCallback = new MediaControllerCompat$MediaControllerImplApi21$ExtraCallback(this, mediaControllerCompat$Callback);
                this.mCallbackMap.put(mediaControllerCompat$Callback, mediaControllerCompat$MediaControllerImplApi21$ExtraCallback);
                mediaControllerCompat$Callback.mHasExtraCallback = true;
                try {
                    this.mExtraBinder.registerCallbackListener(mediaControllerCompat$MediaControllerImplApi21$ExtraCallback);
                    continue;
                }
                catch (RemoteException ex) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", (Throwable)ex);
                }
                break;
            }
            this.mPendingCallbacks.clear();
        }
    }
    
    private void requestExtraBinder() {
        this.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver(this, new Handler()));
    }
    
    public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        if ((0x4 & this.getFlags()) != 0x0L) {
            final Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", (Parcelable)mediaDescriptionCompat);
            this.sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM", bundle, null);
            return;
        }
        throw new UnsupportedOperationException("This session doesn't support queue management operations");
    }
    
    public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat, final int n) {
        if ((0x4 & this.getFlags()) != 0x0L) {
            final Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", (Parcelable)mediaDescriptionCompat);
            bundle.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", n);
            this.sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT", bundle, null);
            return;
        }
        throw new UnsupportedOperationException("This session doesn't support queue management operations");
    }
    
    public void adjustVolume(final int n, final int n2) {
        MediaControllerCompatApi21.adjustVolume(this.mControllerObj, n, n2);
    }
    
    public boolean dispatchMediaButtonEvent(final KeyEvent keyEvent) {
        return MediaControllerCompatApi21.dispatchMediaButtonEvent(this.mControllerObj, keyEvent);
    }
    
    public Bundle getExtras() {
        return MediaControllerCompatApi21.getExtras(this.mControllerObj);
    }
    
    public long getFlags() {
        return MediaControllerCompatApi21.getFlags(this.mControllerObj);
    }
    
    public Object getMediaController() {
        return this.mControllerObj;
    }
    
    public MediaMetadataCompat getMetadata() {
        final Object metadata = MediaControllerCompatApi21.getMetadata(this.mControllerObj);
        MediaMetadataCompat fromMediaMetadata;
        if (metadata != null) {
            fromMediaMetadata = MediaMetadataCompat.fromMediaMetadata(metadata);
        }
        else {
            fromMediaMetadata = null;
        }
        return fromMediaMetadata;
    }
    
    public String getPackageName() {
        return MediaControllerCompatApi21.getPackageName(this.mControllerObj);
    }
    
    public MediaControllerCompat$PlaybackInfo getPlaybackInfo() {
        final Object playbackInfo = MediaControllerCompatApi21.getPlaybackInfo(this.mControllerObj);
        MediaControllerCompat$PlaybackInfo mediaControllerCompat$PlaybackInfo;
        if (playbackInfo != null) {
            mediaControllerCompat$PlaybackInfo = new MediaControllerCompat$PlaybackInfo(MediaControllerCompatApi21$PlaybackInfo.getPlaybackType(playbackInfo), MediaControllerCompatApi21$PlaybackInfo.getLegacyAudioStream(playbackInfo), MediaControllerCompatApi21$PlaybackInfo.getVolumeControl(playbackInfo), MediaControllerCompatApi21$PlaybackInfo.getMaxVolume(playbackInfo), MediaControllerCompatApi21$PlaybackInfo.getCurrentVolume(playbackInfo));
        }
        else {
            mediaControllerCompat$PlaybackInfo = null;
        }
        return mediaControllerCompat$PlaybackInfo;
    }
    
    public PlaybackStateCompat getPlaybackState() {
        final IMediaSession mExtraBinder = this.mExtraBinder;
        if (mExtraBinder != null) {
            try {
                return mExtraBinder.getPlaybackState();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", (Throwable)ex);
            }
        }
        final Object playbackState = MediaControllerCompatApi21.getPlaybackState(this.mControllerObj);
        PlaybackStateCompat fromPlaybackState;
        if (playbackState != null) {
            fromPlaybackState = PlaybackStateCompat.fromPlaybackState(playbackState);
        }
        else {
            fromPlaybackState = null;
        }
        return fromPlaybackState;
    }
    
    public List getQueue() {
        final List queue = MediaControllerCompatApi21.getQueue(this.mControllerObj);
        List fromQueueItemList;
        if (queue != null) {
            fromQueueItemList = MediaSessionCompat$QueueItem.fromQueueItemList(queue);
        }
        else {
            fromQueueItemList = null;
        }
        return fromQueueItemList;
    }
    
    public CharSequence getQueueTitle() {
        return MediaControllerCompatApi21.getQueueTitle(this.mControllerObj);
    }
    
    public int getRatingType() {
        if (Build$VERSION.SDK_INT < 22) {
            final IMediaSession mExtraBinder = this.mExtraBinder;
            if (mExtraBinder != null) {
                try {
                    return mExtraBinder.getRatingType();
                }
                catch (RemoteException ex) {
                    Log.e("MediaControllerCompat", "Dead object in getRatingType.", (Throwable)ex);
                }
            }
        }
        return MediaControllerCompatApi21.getRatingType(this.mControllerObj);
    }
    
    public int getRepeatMode() {
        final IMediaSession mExtraBinder = this.mExtraBinder;
        if (mExtraBinder != null) {
            try {
                return mExtraBinder.getRepeatMode();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", (Throwable)ex);
            }
        }
        return 0;
    }
    
    public PendingIntent getSessionActivity() {
        return MediaControllerCompatApi21.getSessionActivity(this.mControllerObj);
    }
    
    public MediaControllerCompat$TransportControls getTransportControls() {
        final Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
        MediaControllerCompat$TransportControls mediaControllerCompat$TransportControls;
        if (transportControls != null) {
            mediaControllerCompat$TransportControls = new MediaControllerCompat$TransportControlsApi21(transportControls);
        }
        else {
            mediaControllerCompat$TransportControls = null;
        }
        return mediaControllerCompat$TransportControls;
    }
    
    public boolean isCaptioningEnabled() {
        final IMediaSession mExtraBinder = this.mExtraBinder;
        if (mExtraBinder != null) {
            try {
                return mExtraBinder.isCaptioningEnabled();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", (Throwable)ex);
            }
        }
        return false;
    }
    
    public boolean isShuffleModeEnabled() {
        final IMediaSession mExtraBinder = this.mExtraBinder;
        if (mExtraBinder != null) {
            try {
                return mExtraBinder.isShuffleModeEnabled();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in isShuffleModeEnabled.", (Throwable)ex);
            }
        }
        return false;
    }
    
    public final void registerCallback(final MediaControllerCompat$Callback mediaControllerCompat$Callback, final Handler handler) {
        MediaControllerCompatApi21.registerCallback(this.mControllerObj, mediaControllerCompat$Callback.mCallbackObj, handler);
        if (this.mExtraBinder != null) {
            mediaControllerCompat$Callback.setHandler(handler);
            final MediaControllerCompat$MediaControllerImplApi21$ExtraCallback mediaControllerCompat$MediaControllerImplApi21$ExtraCallback = new MediaControllerCompat$MediaControllerImplApi21$ExtraCallback(this, mediaControllerCompat$Callback);
            this.mCallbackMap.put(mediaControllerCompat$Callback, mediaControllerCompat$MediaControllerImplApi21$ExtraCallback);
            mediaControllerCompat$Callback.mHasExtraCallback = true;
            try {
                this.mExtraBinder.registerCallbackListener(mediaControllerCompat$MediaControllerImplApi21$ExtraCallback);
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", (Throwable)ex);
            }
            return;
        }
        mediaControllerCompat$Callback.setHandler(handler);
        synchronized (this.mPendingCallbacks) {
            this.mPendingCallbacks.add(mediaControllerCompat$Callback);
        }
    }
    
    public void removeQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        if ((0x4 & this.getFlags()) != 0x0L) {
            final Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", (Parcelable)mediaDescriptionCompat);
            this.sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM", bundle, null);
            return;
        }
        throw new UnsupportedOperationException("This session doesn't support queue management operations");
    }
    
    public void removeQueueItemAt(final int n) {
        if ((0x4 & this.getFlags()) != 0x0L) {
            final Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", n);
            this.sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT", bundle, null);
            return;
        }
        throw new UnsupportedOperationException("This session doesn't support queue management operations");
    }
    
    public void sendCommand(final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
        MediaControllerCompatApi21.sendCommand(this.mControllerObj, s, bundle, resultReceiver);
    }
    
    public void setVolumeTo(final int n, final int n2) {
        MediaControllerCompatApi21.setVolumeTo(this.mControllerObj, n, n2);
    }
    
    public final void unregisterCallback(final MediaControllerCompat$Callback mediaControllerCompat$Callback) {
        MediaControllerCompatApi21.unregisterCallback(this.mControllerObj, mediaControllerCompat$Callback.mCallbackObj);
        if (this.mExtraBinder != null) {
            try {
                final MediaControllerCompat$MediaControllerImplApi21$ExtraCallback remove = this.mCallbackMap.remove(mediaControllerCompat$Callback);
                try {
                    final MediaControllerCompat$MediaControllerImplApi21$ExtraCallback mediaControllerCompat$MediaControllerImplApi21$ExtraCallback = remove;
                    if (mediaControllerCompat$MediaControllerImplApi21$ExtraCallback != null) {
                        this.mExtraBinder.unregisterCallbackListener(mediaControllerCompat$MediaControllerImplApi21$ExtraCallback);
                    }
                }
                catch (RemoteException mediaControllerCompat$MediaControllerImplApi21$ExtraCallback) {
                    Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", (Throwable)mediaControllerCompat$MediaControllerImplApi21$ExtraCallback);
                }
            }
            catch (RemoteException ex) {}
            return;
        }
        synchronized (this.mPendingCallbacks) {
            this.mPendingCallbacks.remove(mediaControllerCompat$Callback);
        }
    }
}
