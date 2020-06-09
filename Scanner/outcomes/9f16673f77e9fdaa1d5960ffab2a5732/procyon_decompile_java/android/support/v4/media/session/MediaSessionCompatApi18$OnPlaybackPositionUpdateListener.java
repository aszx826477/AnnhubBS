// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.media.RemoteControlClient$OnPlaybackPositionUpdateListener;

class MediaSessionCompatApi18$OnPlaybackPositionUpdateListener implements RemoteControlClient$OnPlaybackPositionUpdateListener
{
    protected final MediaSessionCompatApi18$Callback mCallback;
    
    public MediaSessionCompatApi18$OnPlaybackPositionUpdateListener(final MediaSessionCompatApi18$Callback mCallback) {
        this.mCallback = mCallback;
    }
    
    public void onPlaybackPositionUpdate(final long n) {
        this.mCallback.onSeekTo(n);
    }
}
