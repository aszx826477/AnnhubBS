// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.media.AudioManager$OnAudioFocusChangeListener;

class TransportMediatorJellybeanMR2$4 implements AudioManager$OnAudioFocusChangeListener
{
    final /* synthetic */ TransportMediatorJellybeanMR2 this$0;
    
    TransportMediatorJellybeanMR2$4(final TransportMediatorJellybeanMR2 this$0) {
        this.this$0 = this$0;
    }
    
    public void onAudioFocusChange(final int n) {
        this.this$0.mTransportCallback.handleAudioFocusChange(n);
    }
}
