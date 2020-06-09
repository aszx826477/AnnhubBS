// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import java.util.List;
import android.support.v4.media.VolumeProviderCompat;
import android.os.Handler;
import java.util.Iterator;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.media.MediaMetadataCompat;
import android.util.TypedValue;
import android.content.Intent;
import android.util.Log;
import android.text.TextUtils;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.Build$VERSION;
import android.content.Context;
import java.util.ArrayList;

public class MediaSessionCompat
{
    static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    static final String ACTION_ARGUMENT_SHUFFLE_MODE_ENABLED = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE_ENABLED";
    static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    static final String ACTION_SET_SHUFFLE_MODE_ENABLED = "android.support.v4.media.session.action.SET_SHUFFLE_MODE_ENABLED";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    static final String EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    private static final int MAX_BITMAP_SIZE_IN_DP = 320;
    static final String TAG = "MediaSessionCompat";
    static int sMaxBitmapSize;
    private final ArrayList mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionCompat$MediaSessionImpl mImpl;
    
    private MediaSessionCompat(final Context context, final MediaSessionCompat$MediaSessionImpl mImpl) {
        this.mActiveListeners = new ArrayList();
        this.mImpl = mImpl;
        if (Build$VERSION.SDK_INT >= 21) {
            this.setCallback(new MediaSessionCompat$2(this));
        }
        this.mController = new MediaControllerCompat(context, this);
    }
    
    public MediaSessionCompat(final Context context, final String s) {
        this(context, s, null, null);
    }
    
    public MediaSessionCompat(final Context context, final String s, ComponentName mediaButtonReceiverComponent, PendingIntent broadcast) {
        this.mActiveListeners = new ArrayList();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if (!TextUtils.isEmpty((CharSequence)s)) {
            if (mediaButtonReceiverComponent == null) {
                mediaButtonReceiverComponent = MediaButtonReceiver.getMediaButtonReceiverComponent(context);
                if (mediaButtonReceiverComponent == null) {
                    Log.w("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
                }
            }
            if (mediaButtonReceiverComponent != null && broadcast == null) {
                final Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.setComponent(mediaButtonReceiverComponent);
                broadcast = PendingIntent.getBroadcast(context, 0, intent, 0);
            }
            if (Build$VERSION.SDK_INT >= 21) {
                (this.mImpl = new MediaSessionCompat$MediaSessionImplApi21(context, s)).setMediaButtonReceiver(broadcast);
                this.setCallback(new MediaSessionCompat$1(this));
            }
            else {
                this.mImpl = new MediaSessionCompat$MediaSessionImplBase(context, s, mediaButtonReceiverComponent, broadcast);
            }
            this.mController = new MediaControllerCompat(context, this);
            if (MediaSessionCompat.sMaxBitmapSize == 0) {
                MediaSessionCompat.sMaxBitmapSize = (int)TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics());
            }
            return;
        }
        throw new IllegalArgumentException("tag must not be null or empty");
    }
    
    public static MediaSessionCompat fromMediaSession(final Context context, final Object o) {
        if (context != null && o != null && Build$VERSION.SDK_INT >= 21) {
            return new MediaSessionCompat(context, new MediaSessionCompat$MediaSessionImplApi21(o));
        }
        return null;
    }
    
    private static PlaybackStateCompat getStateWithUpdatedPosition(final PlaybackStateCompat playbackStateCompat, final MediaMetadataCompat mediaMetadataCompat) {
        if (playbackStateCompat != null && playbackStateCompat.getPosition() != -1) {
            if (playbackStateCompat.getState() != 3) {
                if (playbackStateCompat.getState() != 4) {
                    if (playbackStateCompat.getState() != 5) {
                        return playbackStateCompat;
                    }
                }
            }
            final long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
            final long n = 0L;
            if (lastPositionUpdateTime > n) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                final long n2 = (long)(playbackStateCompat.getPlaybackSpeed() * (elapsedRealtime - lastPositionUpdateTime)) + playbackStateCompat.getPosition();
                final long n3 = -1;
                long long1;
                if (mediaMetadataCompat != null && mediaMetadataCompat.containsKey("android.media.metadata.DURATION")) {
                    long1 = mediaMetadataCompat.getLong("android.media.metadata.DURATION");
                }
                else {
                    long1 = n3;
                }
                long n4;
                if (long1 >= n && n2 > long1) {
                    n4 = long1;
                }
                else if (n2 < n) {
                    n4 = 0L;
                }
                else {
                    n4 = n2;
                }
                return new PlaybackStateCompat$Builder(playbackStateCompat).setState(playbackStateCompat.getState(), n4, playbackStateCompat.getPlaybackSpeed(), elapsedRealtime).build();
            }
            return playbackStateCompat;
        }
        return playbackStateCompat;
    }
    
    public static MediaSessionCompat obtain(final Context context, final Object o) {
        return fromMediaSession(context, o);
    }
    
    public void addOnActiveChangeListener(final MediaSessionCompat$OnActiveChangeListener mediaSessionCompat$OnActiveChangeListener) {
        if (mediaSessionCompat$OnActiveChangeListener != null) {
            this.mActiveListeners.add(mediaSessionCompat$OnActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }
    
    public String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }
    
    public MediaControllerCompat getController() {
        return this.mController;
    }
    
    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }
    
    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }
    
    public MediaSessionCompat$Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }
    
    public boolean isActive() {
        return this.mImpl.isActive();
    }
    
    public void release() {
        this.mImpl.release();
    }
    
    public void removeOnActiveChangeListener(final MediaSessionCompat$OnActiveChangeListener mediaSessionCompat$OnActiveChangeListener) {
        if (mediaSessionCompat$OnActiveChangeListener != null) {
            this.mActiveListeners.remove(mediaSessionCompat$OnActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }
    
    public void sendSessionEvent(final String s, final Bundle bundle) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            this.mImpl.sendSessionEvent(s, bundle);
            return;
        }
        throw new IllegalArgumentException("event cannot be null or empty");
    }
    
    public void setActive(final boolean active) {
        this.mImpl.setActive(active);
        final Iterator<MediaSessionCompat$OnActiveChangeListener> iterator = this.mActiveListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().onActiveChanged();
        }
    }
    
    public void setCallback(final MediaSessionCompat$Callback mediaSessionCompat$Callback) {
        this.setCallback(mediaSessionCompat$Callback, null);
    }
    
    public void setCallback(final MediaSessionCompat$Callback mediaSessionCompat$Callback, final Handler handler) {
        final MediaSessionCompat$MediaSessionImpl mImpl = this.mImpl;
        Handler handler2;
        if (handler != null) {
            handler2 = handler;
        }
        else {
            handler2 = new Handler();
        }
        mImpl.setCallback(mediaSessionCompat$Callback, handler2);
    }
    
    public void setCaptioningEnabled(final boolean captioningEnabled) {
        this.mImpl.setCaptioningEnabled(captioningEnabled);
    }
    
    public void setExtras(final Bundle extras) {
        this.mImpl.setExtras(extras);
    }
    
    public void setFlags(final int flags) {
        this.mImpl.setFlags(flags);
    }
    
    public void setMediaButtonReceiver(final PendingIntent mediaButtonReceiver) {
        this.mImpl.setMediaButtonReceiver(mediaButtonReceiver);
    }
    
    public void setMetadata(final MediaMetadataCompat metadata) {
        this.mImpl.setMetadata(metadata);
    }
    
    public void setPlaybackState(final PlaybackStateCompat playbackState) {
        this.mImpl.setPlaybackState(playbackState);
    }
    
    public void setPlaybackToLocal(final int playbackToLocal) {
        this.mImpl.setPlaybackToLocal(playbackToLocal);
    }
    
    public void setPlaybackToRemote(final VolumeProviderCompat playbackToRemote) {
        if (playbackToRemote != null) {
            this.mImpl.setPlaybackToRemote(playbackToRemote);
            return;
        }
        throw new IllegalArgumentException("volumeProvider may not be null!");
    }
    
    public void setQueue(final List queue) {
        this.mImpl.setQueue(queue);
    }
    
    public void setQueueTitle(final CharSequence queueTitle) {
        this.mImpl.setQueueTitle(queueTitle);
    }
    
    public void setRatingType(final int ratingType) {
        this.mImpl.setRatingType(ratingType);
    }
    
    public void setRepeatMode(final int repeatMode) {
        this.mImpl.setRepeatMode(repeatMode);
    }
    
    public void setSessionActivity(final PendingIntent sessionActivity) {
        this.mImpl.setSessionActivity(sessionActivity);
    }
    
    public void setShuffleModeEnabled(final boolean shuffleModeEnabled) {
        this.mImpl.setShuffleModeEnabled(shuffleModeEnabled);
    }
}
