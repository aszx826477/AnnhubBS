// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.text.TextUtils;
import android.os.ResultReceiver;
import android.os.Handler;
import android.app.PendingIntent;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;
import android.view.KeyEvent;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.app.SupportActivity$ExtraData;
import android.os.RemoteException;
import android.util.Log;
import android.support.v4.app.SupportActivity;
import android.app.Activity;
import android.os.Build$VERSION;
import android.content.Context;

public final class MediaControllerCompat
{
    static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
    static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
    static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";
    static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
    static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
    static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
    static final String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
    static final String TAG = "MediaControllerCompat";
    private final MediaControllerCompat$MediaControllerImpl mImpl;
    private final MediaSessionCompat$Token mToken;
    
    public MediaControllerCompat(final Context context, final MediaSessionCompat$Token mToken) {
        if (mToken != null) {
            this.mToken = mToken;
            if (Build$VERSION.SDK_INT >= 24) {
                this.mImpl = new MediaControllerCompat$MediaControllerImplApi24(context, mToken);
            }
            else if (Build$VERSION.SDK_INT >= 23) {
                this.mImpl = new MediaControllerCompat$MediaControllerImplApi23(context, mToken);
            }
            else if (Build$VERSION.SDK_INT >= 21) {
                this.mImpl = new MediaControllerCompat$MediaControllerImplApi21(context, mToken);
            }
            else {
                this.mImpl = new MediaControllerCompat$MediaControllerImplBase(this.mToken);
            }
            return;
        }
        throw new IllegalArgumentException("sessionToken must not be null");
    }
    
    public MediaControllerCompat(final Context context, final MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat != null) {
            this.mToken = mediaSessionCompat.getSessionToken();
            if (Build$VERSION.SDK_INT >= 24) {
                this.mImpl = new MediaControllerCompat$MediaControllerImplApi24(context, mediaSessionCompat);
            }
            else if (Build$VERSION.SDK_INT >= 23) {
                this.mImpl = new MediaControllerCompat$MediaControllerImplApi23(context, mediaSessionCompat);
            }
            else if (Build$VERSION.SDK_INT >= 21) {
                this.mImpl = new MediaControllerCompat$MediaControllerImplApi21(context, mediaSessionCompat);
            }
            else {
                this.mImpl = new MediaControllerCompat$MediaControllerImplBase(this.mToken);
            }
            return;
        }
        throw new IllegalArgumentException("session must not be null");
    }
    
    public static MediaControllerCompat getMediaController(final Activity activity) {
        final boolean b = activity instanceof SupportActivity;
        MediaControllerCompat mediaController = null;
        if (b) {
            final MediaControllerCompat$MediaControllerExtraData mediaControllerCompat$MediaControllerExtraData = (MediaControllerCompat$MediaControllerExtraData)((SupportActivity)activity).getExtraData(MediaControllerCompat$MediaControllerExtraData.class);
            if (mediaControllerCompat$MediaControllerExtraData != null) {
                mediaController = mediaControllerCompat$MediaControllerExtraData.getMediaController();
            }
            return mediaController;
        }
        if (Build$VERSION.SDK_INT >= 21) {
            final Object mediaController2 = MediaControllerCompatApi21.getMediaController(activity);
            if (mediaController2 == null) {
                return null;
            }
            final Object sessionToken = MediaControllerCompatApi21.getSessionToken(mediaController2);
            try {
                try {
                    return new MediaControllerCompat((Context)activity, MediaSessionCompat$Token.fromToken(sessionToken));
                }
                catch (RemoteException ex) {
                    Log.e("MediaControllerCompat", "Dead object in getMediaController.", (Throwable)ex);
                }
            }
            catch (RemoteException ex2) {}
        }
        return null;
    }
    
    public static void setMediaController(final Activity activity, final MediaControllerCompat mediaControllerCompat) {
        if (activity instanceof SupportActivity) {
            ((SupportActivity)activity).putExtraData(new MediaControllerCompat$MediaControllerExtraData(mediaControllerCompat));
        }
        if (Build$VERSION.SDK_INT >= 21) {
            Object fromToken = null;
            if (mediaControllerCompat != null) {
                fromToken = MediaControllerCompatApi21.fromToken((Context)activity, mediaControllerCompat.getSessionToken().getToken());
            }
            MediaControllerCompatApi21.setMediaController(activity, fromToken);
        }
    }
    
    public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        this.mImpl.addQueueItem(mediaDescriptionCompat);
    }
    
    public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat, final int n) {
        this.mImpl.addQueueItem(mediaDescriptionCompat, n);
    }
    
    public void adjustVolume(final int n, final int n2) {
        this.mImpl.adjustVolume(n, n2);
    }
    
    public boolean dispatchMediaButtonEvent(final KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.mImpl.dispatchMediaButtonEvent(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }
    
    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }
    
    public long getFlags() {
        return this.mImpl.getFlags();
    }
    
    public Object getMediaController() {
        return this.mImpl.getMediaController();
    }
    
    public MediaMetadataCompat getMetadata() {
        return this.mImpl.getMetadata();
    }
    
    public String getPackageName() {
        return this.mImpl.getPackageName();
    }
    
    public MediaControllerCompat$PlaybackInfo getPlaybackInfo() {
        return this.mImpl.getPlaybackInfo();
    }
    
    public PlaybackStateCompat getPlaybackState() {
        return this.mImpl.getPlaybackState();
    }
    
    public List getQueue() {
        return this.mImpl.getQueue();
    }
    
    public CharSequence getQueueTitle() {
        return this.mImpl.getQueueTitle();
    }
    
    public int getRatingType() {
        return this.mImpl.getRatingType();
    }
    
    public int getRepeatMode() {
        return this.mImpl.getRepeatMode();
    }
    
    public PendingIntent getSessionActivity() {
        return this.mImpl.getSessionActivity();
    }
    
    public MediaSessionCompat$Token getSessionToken() {
        return this.mToken;
    }
    
    public MediaControllerCompat$TransportControls getTransportControls() {
        return this.mImpl.getTransportControls();
    }
    
    public boolean isCaptioningEnabled() {
        return this.mImpl.isCaptioningEnabled();
    }
    
    public boolean isShuffleModeEnabled() {
        return this.mImpl.isShuffleModeEnabled();
    }
    
    public void registerCallback(final MediaControllerCompat$Callback mediaControllerCompat$Callback) {
        this.registerCallback(mediaControllerCompat$Callback, null);
    }
    
    public void registerCallback(final MediaControllerCompat$Callback mediaControllerCompat$Callback, Handler handler) {
        if (mediaControllerCompat$Callback != null) {
            if (handler == null) {
                handler = new Handler();
            }
            this.mImpl.registerCallback(mediaControllerCompat$Callback, handler);
            return;
        }
        throw new IllegalArgumentException("callback cannot be null");
    }
    
    public void removeQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        this.mImpl.removeQueueItem(mediaDescriptionCompat);
    }
    
    public void removeQueueItemAt(final int n) {
        this.mImpl.removeQueueItemAt(n);
    }
    
    public void sendCommand(final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            this.mImpl.sendCommand(s, bundle, resultReceiver);
            return;
        }
        throw new IllegalArgumentException("command cannot be null or empty");
    }
    
    public void setVolumeTo(final int n, final int n2) {
        this.mImpl.setVolumeTo(n, n2);
    }
    
    public void unregisterCallback(final MediaControllerCompat$Callback mediaControllerCompat$Callback) {
        if (mediaControllerCompat$Callback != null) {
            this.mImpl.unregisterCallback(mediaControllerCompat$Callback);
            return;
        }
        throw new IllegalArgumentException("callback cannot be null");
    }
}
