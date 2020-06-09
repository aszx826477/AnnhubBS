// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;

class MediaControllerCompat$MediaControllerImplApi21$ExtraCallback$5 implements Runnable
{
    final /* synthetic */ MediaControllerCompat$MediaControllerImplApi21$ExtraCallback this$1;
    final /* synthetic */ boolean val$enabled;
    
    MediaControllerCompat$MediaControllerImplApi21$ExtraCallback$5(final MediaControllerCompat$MediaControllerImplApi21$ExtraCallback this$1, final boolean val$enabled) {
        this.this$1 = this$1;
        this.val$enabled = val$enabled;
    }
    
    public void run() {
        this.this$1.mCallback.onShuffleModeChanged(this.val$enabled);
    }
}
