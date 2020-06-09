// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.support.v4.app.SupportActivity$ExtraData;

class MediaControllerCompat$MediaControllerExtraData extends SupportActivity$ExtraData
{
    private final MediaControllerCompat mMediaController;
    
    MediaControllerCompat$MediaControllerExtraData(final MediaControllerCompat mMediaController) {
        this.mMediaController = mMediaController;
    }
    
    MediaControllerCompat getMediaController() {
        return this.mMediaController;
    }
}
