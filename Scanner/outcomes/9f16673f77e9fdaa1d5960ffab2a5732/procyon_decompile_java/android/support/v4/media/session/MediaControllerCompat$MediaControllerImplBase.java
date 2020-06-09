// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.Build$VERSION;
import android.os.ResultReceiver;
import android.os.IBinder$DeathRecipient;
import android.os.Handler;
import android.app.PendingIntent;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;
import android.view.KeyEvent;
import android.os.RemoteException;
import android.util.Log;
import android.support.v4.media.MediaDescriptionCompat;
import android.os.IBinder;

class MediaControllerCompat$MediaControllerImplBase implements MediaControllerCompat$MediaControllerImpl
{
    private IMediaSession mBinder;
    private MediaControllerCompat$TransportControls mTransportControls;
    
    public MediaControllerCompat$MediaControllerImplBase(final MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.mBinder = IMediaSession$Stub.asInterface((IBinder)mediaSessionCompat$Token.getToken());
    }
    
    public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                if ((0x4 & mBinder.getFlags()) != 0x0L) {
                    this.mBinder.addQueueItem(mediaDescriptionCompat);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in addQueueItem.", (Throwable)ex);
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat, final int n) {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                if ((0x4 & mBinder.getFlags()) != 0x0L) {
                    this.mBinder.addQueueItemAt(mediaDescriptionCompat, n);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in addQueueItemAt.", (Throwable)ex);
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public void adjustVolume(final int n, final int n2) {
        try {
            this.mBinder.adjustVolume(n, n2, null);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in adjustVolume.", (Throwable)ex);
        }
    }
    
    public boolean dispatchMediaButtonEvent(final KeyEvent keyEvent) {
        if (keyEvent != null) {
            try {
                this.mBinder.sendMediaButton(keyEvent);
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", (Throwable)ex);
            }
            return false;
        }
        throw new IllegalArgumentException("event may not be null.");
    }
    
    public Bundle getExtras() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                return mBinder.getExtras();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getExtras.", (Throwable)ex);
                return null;
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public long getFlags() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                return mBinder.getFlags();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getFlags.", (Throwable)ex);
                return 0L;
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public Object getMediaController() {
        return null;
    }
    
    public MediaMetadataCompat getMetadata() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                return mBinder.getMetadata();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getMetadata.", (Throwable)ex);
                return null;
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public String getPackageName() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                return mBinder.getPackageName();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getPackageName.", (Throwable)ex);
                return null;
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public MediaControllerCompat$PlaybackInfo getPlaybackInfo() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                final ParcelableVolumeInfo volumeAttributes = mBinder.getVolumeAttributes();
                try {
                    try {
                        final int volumeType = volumeAttributes.volumeType;
                        try {
                            final int audioStream = volumeAttributes.audioStream;
                            try {
                                final int controlType = volumeAttributes.controlType;
                                try {
                                    final int maxVolume = volumeAttributes.maxVolume;
                                    try {
                                        return new MediaControllerCompat$PlaybackInfo(volumeType, audioStream, controlType, maxVolume, volumeAttributes.currentVolume);
                                    }
                                    catch (RemoteException ex) {
                                        Log.e("MediaControllerCompat", "Dead object in getPlaybackInfo.", (Throwable)ex);
                                        return null;
                                    }
                                }
                                catch (RemoteException ex2) {}
                            }
                            catch (RemoteException ex3) {}
                        }
                        catch (RemoteException ex4) {}
                    }
                    catch (RemoteException ex5) {}
                }
                catch (RemoteException ex6) {}
            }
            catch (RemoteException ex7) {}
        }
        catch (RemoteException ex8) {}
    }
    
    public PlaybackStateCompat getPlaybackState() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                return mBinder.getPlaybackState();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", (Throwable)ex);
                return null;
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public List getQueue() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                return mBinder.getQueue();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getQueue.", (Throwable)ex);
                return null;
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public CharSequence getQueueTitle() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                return mBinder.getQueueTitle();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getQueueTitle.", (Throwable)ex);
                return null;
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public int getRatingType() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                return mBinder.getRatingType();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getRatingType.", (Throwable)ex);
                return 0;
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public int getRepeatMode() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                return mBinder.getRepeatMode();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", (Throwable)ex);
                return 0;
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public PendingIntent getSessionActivity() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                return mBinder.getLaunchPendingIntent();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getSessionActivity.", (Throwable)ex);
                return null;
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public MediaControllerCompat$TransportControls getTransportControls() {
        if (this.mTransportControls == null) {
            this.mTransportControls = new MediaControllerCompat$TransportControlsBase(this.mBinder);
        }
        return this.mTransportControls;
    }
    
    public boolean isCaptioningEnabled() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                return mBinder.isCaptioningEnabled();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", (Throwable)ex);
                return false;
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public boolean isShuffleModeEnabled() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                return mBinder.isShuffleModeEnabled();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in isShuffleModeEnabled.", (Throwable)ex);
                return false;
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public void registerCallback(final MediaControllerCompat$Callback mediaControllerCompat$Callback, final Handler handler) {
        if (mediaControllerCompat$Callback != null) {
            try {
                final IMediaSession mBinder = this.mBinder;
                try {
                    mBinder.asBinder().linkToDeath((IBinder$DeathRecipient)mediaControllerCompat$Callback, 0);
                    final IMediaSession mBinder2 = this.mBinder;
                    try {
                        final Object access$000 = mediaControllerCompat$Callback.mCallbackObj;
                        try {
                            mBinder2.registerCallbackListener((IMediaControllerCallback)access$000);
                            try {
                                mediaControllerCompat$Callback.setHandler(handler);
                                mediaControllerCompat$Callback.mRegistered = true;
                            }
                            catch (RemoteException ex) {
                                Log.e("MediaControllerCompat", "Dead object in registerCallback.", (Throwable)ex);
                                mediaControllerCompat$Callback.onSessionDestroyed();
                            }
                        }
                        catch (RemoteException ex2) {}
                    }
                    catch (RemoteException ex3) {}
                }
                catch (RemoteException ex4) {}
            }
            catch (RemoteException ex5) {}
            return;
        }
        throw new IllegalArgumentException("callback may not be null.");
    }
    
    public void removeQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                if ((0x4 & mBinder.getFlags()) != 0x0L) {
                    this.mBinder.removeQueueItem(mediaDescriptionCompat);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in removeQueueItem.", (Throwable)ex);
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public void removeQueueItemAt(final int n) {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                if ((0x4 & mBinder.getFlags()) != 0x0L) {
                    this.mBinder.removeQueueItemAt(n);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in removeQueueItemAt.", (Throwable)ex);
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public void sendCommand(final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                mBinder.sendCommand(s, bundle, new MediaSessionCompat$ResultReceiverWrapper(resultReceiver));
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in sendCommand.", (Throwable)ex);
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public void setVolumeTo(final int n, final int n2) {
        try {
            this.mBinder.setVolumeTo(n, n2, null);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in setVolumeTo.", (Throwable)ex);
        }
    }
    
    public void unregisterCallback(final MediaControllerCompat$Callback mediaControllerCompat$Callback) {
        if (mediaControllerCompat$Callback != null) {
            try {
                final IMediaSession mBinder = this.mBinder;
                try {
                    final Object access$000 = mediaControllerCompat$Callback.mCallbackObj;
                    try {
                        mBinder.unregisterCallbackListener((IMediaControllerCallback)access$000);
                        final IMediaSession mBinder2 = this.mBinder;
                        try {
                            mBinder2.asBinder().unlinkToDeath((IBinder$DeathRecipient)mediaControllerCompat$Callback, 0);
                            try {
                                mediaControllerCompat$Callback.mRegistered = false;
                            }
                            catch (RemoteException ex) {
                                Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", (Throwable)ex);
                            }
                        }
                        catch (RemoteException ex2) {}
                    }
                    catch (RemoteException ex3) {}
                }
                catch (RemoteException ex4) {}
            }
            catch (RemoteException ex5) {}
            return;
        }
        throw new IllegalArgumentException("callback may not be null.");
    }
}
