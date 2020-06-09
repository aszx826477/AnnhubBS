// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.Build$VERSION;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;

class MediaControllerCompat$Callback$StubApi21 implements MediaControllerCompatApi21$Callback
{
    final /* synthetic */ MediaControllerCompat$Callback this$0;
    
    MediaControllerCompat$Callback$StubApi21(final MediaControllerCompat$Callback this$0) {
        this.this$0 = this$0;
    }
    
    public void onAudioInfoChanged(final int n, final int n2, final int n3, final int n4, final int n5) {
        this.this$0.onAudioInfoChanged(new MediaControllerCompat$PlaybackInfo(n, n2, n3, n4, n5));
    }
    
    public void onExtrasChanged(final Bundle bundle) {
        this.this$0.onExtrasChanged(bundle);
    }
    
    public void onMetadataChanged(final Object o) {
        this.this$0.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(o));
    }
    
    public void onPlaybackStateChanged(final Object o) {
        if (!this.this$0.mHasExtraCallback) {
            this.this$0.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(o));
        }
    }
    
    public void onQueueChanged(final List list) {
        this.this$0.onQueueChanged(MediaSessionCompat$QueueItem.fromQueueItemList(list));
    }
    
    public void onQueueTitleChanged(final CharSequence charSequence) {
        this.this$0.onQueueTitleChanged(charSequence);
    }
    
    public void onSessionDestroyed() {
        this.this$0.onSessionDestroyed();
    }
    
    public void onSessionEvent(final String s, final Bundle bundle) {
        if (!this.this$0.mHasExtraCallback || Build$VERSION.SDK_INT >= 23) {
            this.this$0.onSessionEvent(s, bundle);
        }
    }
}
