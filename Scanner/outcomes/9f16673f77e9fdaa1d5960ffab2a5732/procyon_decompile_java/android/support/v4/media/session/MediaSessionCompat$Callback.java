// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.support.v4.media.RatingCompat;
import android.net.Uri;
import android.content.Intent;
import android.os.ResultReceiver;
import android.os.Bundle;
import android.support.v4.media.MediaDescriptionCompat;
import android.os.Build$VERSION;
import java.lang.ref.WeakReference;

public abstract class MediaSessionCompat$Callback
{
    final Object mCallbackObj;
    WeakReference mSessionImpl;
    
    public MediaSessionCompat$Callback() {
        if (Build$VERSION.SDK_INT >= 24) {
            this.mCallbackObj = MediaSessionCompatApi24.createCallback(new MediaSessionCompat$Callback$StubApi24(this));
        }
        else if (Build$VERSION.SDK_INT >= 23) {
            this.mCallbackObj = MediaSessionCompatApi23.createCallback(new MediaSessionCompat$Callback$StubApi23(this));
        }
        else if (Build$VERSION.SDK_INT >= 21) {
            this.mCallbackObj = MediaSessionCompatApi21.createCallback(new MediaSessionCompat$Callback$StubApi21(this));
        }
        else {
            this.mCallbackObj = null;
        }
    }
    
    public void onAddQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
    }
    
    public void onAddQueueItem(final MediaDescriptionCompat mediaDescriptionCompat, final int n) {
    }
    
    public void onCommand(final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
    }
    
    public void onCustomAction(final String s, final Bundle bundle) {
    }
    
    public void onFastForward() {
    }
    
    public boolean onMediaButtonEvent(final Intent intent) {
        return false;
    }
    
    public void onPause() {
    }
    
    public void onPlay() {
    }
    
    public void onPlayFromMediaId(final String s, final Bundle bundle) {
    }
    
    public void onPlayFromSearch(final String s, final Bundle bundle) {
    }
    
    public void onPlayFromUri(final Uri uri, final Bundle bundle) {
    }
    
    public void onPrepare() {
    }
    
    public void onPrepareFromMediaId(final String s, final Bundle bundle) {
    }
    
    public void onPrepareFromSearch(final String s, final Bundle bundle) {
    }
    
    public void onPrepareFromUri(final Uri uri, final Bundle bundle) {
    }
    
    public void onRemoveQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
    }
    
    public void onRemoveQueueItemAt(final int n) {
    }
    
    public void onRewind() {
    }
    
    public void onSeekTo(final long n) {
    }
    
    public void onSetCaptioningEnabled(final boolean b) {
    }
    
    public void onSetRating(final RatingCompat ratingCompat) {
    }
    
    public void onSetRepeatMode(final int n) {
    }
    
    public void onSetShuffleModeEnabled(final boolean b) {
    }
    
    public void onSkipToNext() {
    }
    
    public void onSkipToPrevious() {
    }
    
    public void onSkipToQueueItem(final long n) {
    }
    
    public void onStop() {
    }
}
