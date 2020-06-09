// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.media.RemoteControlClient$OnGetPlaybackPositionListener;

class TransportMediatorJellybeanMR2$5 implements RemoteControlClient$OnGetPlaybackPositionListener
{
    final /* synthetic */ TransportMediatorJellybeanMR2 this$0;
    
    TransportMediatorJellybeanMR2$5(final TransportMediatorJellybeanMR2 this$0) {
        this.this$0 = this$0;
    }
    
    public long onGetPlaybackPosition() {
        return this.this$0.mTransportCallback.getPlaybackPosition();
    }
}
