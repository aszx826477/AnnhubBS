// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

class MediaControllerCompat$TransportControlsApi24 extends MediaControllerCompat$TransportControlsApi23
{
    public MediaControllerCompat$TransportControlsApi24(final Object o) {
        super(o);
    }
    
    public void prepare() {
        MediaControllerCompatApi24$TransportControls.prepare(this.mControlsObj);
    }
    
    public void prepareFromMediaId(final String s, final Bundle bundle) {
        MediaControllerCompatApi24$TransportControls.prepareFromMediaId(this.mControlsObj, s, bundle);
    }
    
    public void prepareFromSearch(final String s, final Bundle bundle) {
        MediaControllerCompatApi24$TransportControls.prepareFromSearch(this.mControlsObj, s, bundle);
    }
    
    public void prepareFromUri(final Uri uri, final Bundle bundle) {
        MediaControllerCompatApi24$TransportControls.prepareFromUri(this.mControlsObj, uri, bundle);
    }
}
