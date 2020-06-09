// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

class MediaSessionCompatApi24$CallbackProxy extends MediaSessionCompatApi23$CallbackProxy
{
    public MediaSessionCompatApi24$CallbackProxy(final MediaSessionCompatApi24$Callback mediaSessionCompatApi24$Callback) {
        super(mediaSessionCompatApi24$Callback);
    }
    
    public void onPrepare() {
        ((MediaSessionCompatApi24$Callback)this.mCallback).onPrepare();
    }
    
    public void onPrepareFromMediaId(final String s, final Bundle bundle) {
        ((MediaSessionCompatApi24$Callback)this.mCallback).onPrepareFromMediaId(s, bundle);
    }
    
    public void onPrepareFromSearch(final String s, final Bundle bundle) {
        ((MediaSessionCompatApi24$Callback)this.mCallback).onPrepareFromSearch(s, bundle);
    }
    
    public void onPrepareFromUri(final Uri uri, final Bundle bundle) {
        ((MediaSessionCompatApi24$Callback)this.mCallback).onPrepareFromUri(uri, bundle);
    }
}
