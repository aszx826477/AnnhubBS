// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.support.v4.media.RatingCompat;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.app.BundleCompat;
import android.os.ResultReceiver;
import android.os.Bundle;

class MediaSessionCompat$Callback$StubApi21 implements MediaSessionCompatApi21$Callback
{
    final /* synthetic */ MediaSessionCompat$Callback this$0;
    
    MediaSessionCompat$Callback$StubApi21(final MediaSessionCompat$Callback this$0) {
        this.this$0 = this$0;
    }
    
    public void onCommand(final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
        if (s.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
            final MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = (MediaSessionCompat$MediaSessionImplApi21)this.this$0.mSessionImpl.get();
            if (mediaSessionCompat$MediaSessionImplApi21 != null) {
                final Bundle bundle2 = new Bundle();
                final IMediaSession extraBinder = mediaSessionCompat$MediaSessionImplApi21.getSessionToken().getExtraBinder();
                final String s2 = "android.support.v4.media.session.EXTRA_BINDER";
                IBinder binder;
                if (extraBinder == null) {
                    binder = null;
                }
                else {
                    binder = extraBinder.asBinder();
                }
                BundleCompat.putBinder(bundle2, s2, binder);
                resultReceiver.send(0, bundle2);
            }
        }
        else if (s.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
            bundle.setClassLoader(MediaDescriptionCompat.class.getClassLoader());
            this.this$0.onAddQueueItem((MediaDescriptionCompat)bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
        }
        else if (s.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
            bundle.setClassLoader(MediaDescriptionCompat.class.getClassLoader());
            this.this$0.onAddQueueItem((MediaDescriptionCompat)bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
        }
        else if (s.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
            bundle.setClassLoader(MediaDescriptionCompat.class.getClassLoader());
            this.this$0.onRemoveQueueItem((MediaDescriptionCompat)bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
        }
        else if (s.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
            this.this$0.onRemoveQueueItemAt(bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
        }
        else {
            this.this$0.onCommand(s, bundle, resultReceiver);
        }
    }
    
    public void onCustomAction(final String s, final Bundle bundle) {
        if (s.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
            this.this$0.onPlayFromUri((Uri)bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), (Bundle)bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
        }
        else if (s.equals("android.support.v4.media.session.action.PREPARE")) {
            this.this$0.onPrepare();
        }
        else if (s.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
            this.this$0.onPrepareFromMediaId(bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID"), bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
        }
        else if (s.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
            this.this$0.onPrepareFromSearch(bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY"), bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
        }
        else if (s.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
            this.this$0.onPrepareFromUri((Uri)bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
        }
        else if (s.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
            this.this$0.onSetCaptioningEnabled(bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED"));
        }
        else if (s.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
            this.this$0.onSetRepeatMode(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
        }
        else if (s.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE_ENABLED")) {
            this.this$0.onSetShuffleModeEnabled(bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE_ENABLED"));
        }
        else {
            this.this$0.onCustomAction(s, bundle);
        }
    }
    
    public void onFastForward() {
        this.this$0.onFastForward();
    }
    
    public boolean onMediaButtonEvent(final Intent intent) {
        return this.this$0.onMediaButtonEvent(intent);
    }
    
    public void onPause() {
        this.this$0.onPause();
    }
    
    public void onPlay() {
        this.this$0.onPlay();
    }
    
    public void onPlayFromMediaId(final String s, final Bundle bundle) {
        this.this$0.onPlayFromMediaId(s, bundle);
    }
    
    public void onPlayFromSearch(final String s, final Bundle bundle) {
        this.this$0.onPlayFromSearch(s, bundle);
    }
    
    public void onRewind() {
        this.this$0.onRewind();
    }
    
    public void onSeekTo(final long n) {
        this.this$0.onSeekTo(n);
    }
    
    public void onSetRating(final Object o) {
        this.this$0.onSetRating(RatingCompat.fromRating(o));
    }
    
    public void onSkipToNext() {
        this.this$0.onSkipToNext();
    }
    
    public void onSkipToPrevious() {
        this.this$0.onSkipToPrevious();
    }
    
    public void onSkipToQueueItem(final long n) {
        this.this$0.onSkipToQueueItem(n);
    }
    
    public void onStop() {
        this.this$0.onStop();
    }
}
