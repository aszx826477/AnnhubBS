// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.Bundle;
import android.net.Uri;

class MediaControllerCompat$TransportControlsApi23 extends MediaControllerCompat$TransportControlsApi21
{
    public MediaControllerCompat$TransportControlsApi23(final Object o) {
        super(o);
    }
    
    public void playFromUri(final Uri uri, final Bundle bundle) {
        MediaControllerCompatApi23$TransportControls.playFromUri(this.mControlsObj, uri, bundle);
    }
}
