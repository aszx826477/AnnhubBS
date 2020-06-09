// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.support.v4.media.RatingCompat;
import android.os.Parcelable;
import android.net.Uri;
import android.os.Bundle;

class MediaControllerCompat$TransportControlsApi21 extends MediaControllerCompat$TransportControls
{
    protected final Object mControlsObj;
    
    public MediaControllerCompat$TransportControlsApi21(final Object mControlsObj) {
        this.mControlsObj = mControlsObj;
    }
    
    public void fastForward() {
        MediaControllerCompatApi21$TransportControls.fastForward(this.mControlsObj);
    }
    
    public void pause() {
        MediaControllerCompatApi21$TransportControls.pause(this.mControlsObj);
    }
    
    public void play() {
        MediaControllerCompatApi21$TransportControls.play(this.mControlsObj);
    }
    
    public void playFromMediaId(final String s, final Bundle bundle) {
        MediaControllerCompatApi21$TransportControls.playFromMediaId(this.mControlsObj, s, bundle);
    }
    
    public void playFromSearch(final String s, final Bundle bundle) {
        MediaControllerCompatApi21$TransportControls.playFromSearch(this.mControlsObj, s, bundle);
    }
    
    public void playFromUri(final Uri uri, final Bundle bundle) {
        if (uri != null && !Uri.EMPTY.equals((Object)uri)) {
            final Bundle bundle2 = new Bundle();
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", (Parcelable)uri);
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS", (Parcelable)bundle);
            this.sendCustomAction("android.support.v4.media.session.action.PLAY_FROM_URI", bundle2);
            return;
        }
        throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
    }
    
    public void prepare() {
        this.sendCustomAction("android.support.v4.media.session.action.PREPARE", null);
    }
    
    public void prepareFromMediaId(final String s, final Bundle bundle) {
        final Bundle bundle2 = new Bundle();
        bundle2.putString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID", s);
        bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
        this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID", bundle2);
    }
    
    public void prepareFromSearch(final String s, final Bundle bundle) {
        final Bundle bundle2 = new Bundle();
        bundle2.putString("android.support.v4.media.session.action.ARGUMENT_QUERY", s);
        bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
        this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_SEARCH", bundle2);
    }
    
    public void prepareFromUri(final Uri uri, final Bundle bundle) {
        final Bundle bundle2 = new Bundle();
        bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", (Parcelable)uri);
        bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
        this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_URI", bundle2);
    }
    
    public void rewind() {
        MediaControllerCompatApi21$TransportControls.rewind(this.mControlsObj);
    }
    
    public void seekTo(final long n) {
        MediaControllerCompatApi21$TransportControls.seekTo(this.mControlsObj, n);
    }
    
    public void sendCustomAction(final PlaybackStateCompat$CustomAction playbackStateCompat$CustomAction, final Bundle bundle) {
        MediaControllerCompatApi21$TransportControls.sendCustomAction(this.mControlsObj, playbackStateCompat$CustomAction.getAction(), bundle);
    }
    
    public void sendCustomAction(final String s, final Bundle bundle) {
        MediaControllerCompatApi21$TransportControls.sendCustomAction(this.mControlsObj, s, bundle);
    }
    
    public void setCaptioningEnabled(final boolean b) {
        final Bundle bundle = new Bundle();
        bundle.putBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED", b);
        this.sendCustomAction("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED", bundle);
    }
    
    public void setRating(final RatingCompat ratingCompat) {
        final Object mControlsObj = this.mControlsObj;
        Object rating;
        if (ratingCompat != null) {
            rating = ratingCompat.getRating();
        }
        else {
            rating = null;
        }
        MediaControllerCompatApi21$TransportControls.setRating(mControlsObj, rating);
    }
    
    public void setRepeatMode(final int n) {
        final Bundle bundle = new Bundle();
        bundle.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", n);
        this.sendCustomAction("android.support.v4.media.session.action.SET_REPEAT_MODE", bundle);
    }
    
    public void setShuffleModeEnabled(final boolean b) {
        final Bundle bundle = new Bundle();
        bundle.putBoolean("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE_ENABLED", b);
        this.sendCustomAction("android.support.v4.media.session.action.SET_SHUFFLE_MODE_ENABLED", bundle);
    }
    
    public void skipToNext() {
        MediaControllerCompatApi21$TransportControls.skipToNext(this.mControlsObj);
    }
    
    public void skipToPrevious() {
        MediaControllerCompatApi21$TransportControls.skipToPrevious(this.mControlsObj);
    }
    
    public void skipToQueueItem(final long n) {
        MediaControllerCompatApi21$TransportControls.skipToQueueItem(this.mControlsObj, n);
    }
    
    public void stop() {
        MediaControllerCompatApi21$TransportControls.stop(this.mControlsObj);
    }
}
