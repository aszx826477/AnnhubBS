// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.content.Context;

class MediaControllerCompat$MediaControllerImplApi24 extends MediaControllerCompat$MediaControllerImplApi23
{
    public MediaControllerCompat$MediaControllerImplApi24(final Context context, final MediaSessionCompat$Token mediaSessionCompat$Token) {
        super(context, mediaSessionCompat$Token);
    }
    
    public MediaControllerCompat$MediaControllerImplApi24(final Context context, final MediaSessionCompat mediaSessionCompat) {
        super(context, mediaSessionCompat);
    }
    
    public MediaControllerCompat$TransportControls getTransportControls() {
        final Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
        MediaControllerCompat$TransportControls mediaControllerCompat$TransportControls;
        if (transportControls != null) {
            mediaControllerCompat$TransportControls = new MediaControllerCompat$TransportControlsApi24(transportControls);
        }
        else {
            mediaControllerCompat$TransportControls = null;
        }
        return mediaControllerCompat$TransportControls;
    }
}
