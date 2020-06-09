// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;

class MediaControllerCompat$MediaControllerImplApi21$ExtraCallback$4 implements Runnable
{
    final /* synthetic */ MediaControllerCompat$MediaControllerImplApi21$ExtraCallback this$1;
    final /* synthetic */ int val$repeatMode;
    
    MediaControllerCompat$MediaControllerImplApi21$ExtraCallback$4(final MediaControllerCompat$MediaControllerImplApi21$ExtraCallback this$1, final int val$repeatMode) {
        this.this$1 = this$1;
        this.val$repeatMode = val$repeatMode;
    }
    
    public void run() {
        this.this$1.mCallback.onRepeatModeChanged(this.val$repeatMode);
    }
}
