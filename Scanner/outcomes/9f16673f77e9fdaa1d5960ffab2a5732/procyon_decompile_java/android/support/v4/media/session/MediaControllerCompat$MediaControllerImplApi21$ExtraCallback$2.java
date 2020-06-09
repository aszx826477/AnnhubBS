// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;

class MediaControllerCompat$MediaControllerImplApi21$ExtraCallback$2 implements Runnable
{
    final /* synthetic */ MediaControllerCompat$MediaControllerImplApi21$ExtraCallback this$1;
    final /* synthetic */ PlaybackStateCompat val$state;
    
    MediaControllerCompat$MediaControllerImplApi21$ExtraCallback$2(final MediaControllerCompat$MediaControllerImplApi21$ExtraCallback this$1, final PlaybackStateCompat val$state) {
        this.this$1 = this$1;
        this.val$state = val$state;
    }
    
    public void run() {
        this.this$1.mCallback.onPlaybackStateChanged(this.val$state);
    }
}
