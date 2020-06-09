// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.Bundle;
import android.net.Uri;

class MediaSessionCompatApi23$CallbackProxy extends MediaSessionCompatApi21$CallbackProxy
{
    public MediaSessionCompatApi23$CallbackProxy(final MediaSessionCompatApi23$Callback mediaSessionCompatApi23$Callback) {
        super(mediaSessionCompatApi23$Callback);
    }
    
    public void onPlayFromUri(final Uri uri, final Bundle bundle) {
        ((MediaSessionCompatApi23$Callback)this.mCallback).onPlayFromUri(uri, bundle);
    }
}
