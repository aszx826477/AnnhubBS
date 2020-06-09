// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.media.Rating;
import android.content.Intent;
import android.os.ResultReceiver;
import android.os.Bundle;
import android.media.session.MediaSession$Callback;

class MediaSessionCompatApi21$CallbackProxy extends MediaSession$Callback
{
    protected final MediaSessionCompatApi21$Callback mCallback;
    
    public MediaSessionCompatApi21$CallbackProxy(final MediaSessionCompatApi21$Callback mCallback) {
        this.mCallback = mCallback;
    }
    
    public void onCommand(final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
        this.mCallback.onCommand(s, bundle, resultReceiver);
    }
    
    public void onCustomAction(final String s, final Bundle bundle) {
        this.mCallback.onCustomAction(s, bundle);
    }
    
    public void onFastForward() {
        this.mCallback.onFastForward();
    }
    
    public boolean onMediaButtonEvent(final Intent intent) {
        return this.mCallback.onMediaButtonEvent(intent) || super.onMediaButtonEvent(intent);
    }
    
    public void onPause() {
        this.mCallback.onPause();
    }
    
    public void onPlay() {
        this.mCallback.onPlay();
    }
    
    public void onPlayFromMediaId(final String s, final Bundle bundle) {
        this.mCallback.onPlayFromMediaId(s, bundle);
    }
    
    public void onPlayFromSearch(final String s, final Bundle bundle) {
        this.mCallback.onPlayFromSearch(s, bundle);
    }
    
    public void onRewind() {
        this.mCallback.onRewind();
    }
    
    public void onSeekTo(final long n) {
        this.mCallback.onSeekTo(n);
    }
    
    public void onSetRating(final Rating rating) {
        this.mCallback.onSetRating(rating);
    }
    
    public void onSkipToNext() {
        this.mCallback.onSkipToNext();
    }
    
    public void onSkipToPrevious() {
        this.mCallback.onSkipToPrevious();
    }
    
    public void onSkipToQueueItem(final long n) {
        this.mCallback.onSkipToQueueItem(n);
    }
    
    public void onStop() {
        this.mCallback.onStop();
    }
}
