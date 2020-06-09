// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

class MediaSessionCompat$Callback$StubApi24 extends MediaSessionCompat$Callback$StubApi23 implements MediaSessionCompatApi24$Callback
{
    final /* synthetic */ MediaSessionCompat$Callback this$0;
    
    MediaSessionCompat$Callback$StubApi24(final MediaSessionCompat$Callback this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    public void onPrepare() {
        this.this$0.onPrepare();
    }
    
    public void onPrepareFromMediaId(final String s, final Bundle bundle) {
        this.this$0.onPrepareFromMediaId(s, bundle);
    }
    
    public void onPrepareFromSearch(final String s, final Bundle bundle) {
        this.this$0.onPrepareFromSearch(s, bundle);
    }
    
    public void onPrepareFromUri(final Uri uri, final Bundle bundle) {
        this.this$0.onPrepareFromUri(uri, bundle);
    }
}
