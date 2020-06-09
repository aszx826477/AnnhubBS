// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.media.RemoteControlClient$OnPlaybackPositionUpdateListener;

class TransportMediatorJellybeanMR2$6 implements RemoteControlClient$OnPlaybackPositionUpdateListener
{
    final /* synthetic */ TransportMediatorJellybeanMR2 this$0;
    
    TransportMediatorJellybeanMR2$6(final TransportMediatorJellybeanMR2 this$0) {
        this.this$0 = this$0;
    }
    
    public void onPlaybackPositionUpdate(final long n) {
        this.this$0.mTransportCallback.playbackPositionUpdate(n);
    }
}
