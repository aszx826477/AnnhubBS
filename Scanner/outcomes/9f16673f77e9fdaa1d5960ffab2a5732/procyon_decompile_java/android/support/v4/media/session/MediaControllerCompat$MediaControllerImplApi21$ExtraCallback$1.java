// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;

class MediaControllerCompat$MediaControllerImplApi21$ExtraCallback$1 implements Runnable
{
    final /* synthetic */ MediaControllerCompat$MediaControllerImplApi21$ExtraCallback this$1;
    final /* synthetic */ String val$event;
    final /* synthetic */ Bundle val$extras;
    
    MediaControllerCompat$MediaControllerImplApi21$ExtraCallback$1(final MediaControllerCompat$MediaControllerImplApi21$ExtraCallback this$1, final String val$event, final Bundle val$extras) {
        this.this$1 = this$1;
        this.val$event = val$event;
        this.val$extras = val$extras;
    }
    
    public void run() {
        this.this$1.mCallback.onSessionEvent(this.val$event, this.val$extras);
    }
}
