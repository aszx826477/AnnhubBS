// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.Bundle;
import android.net.Uri;

class MediaSessionCompat$Callback$StubApi23 extends MediaSessionCompat$Callback$StubApi21 implements MediaSessionCompatApi23$Callback
{
    final /* synthetic */ MediaSessionCompat$Callback this$0;
    
    MediaSessionCompat$Callback$StubApi23(final MediaSessionCompat$Callback this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    public void onPlayFromUri(final Uri uri, final Bundle bundle) {
        this.this$0.onPlayFromUri(uri, bundle);
    }
}
