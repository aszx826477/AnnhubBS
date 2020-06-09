// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.view.ViewTreeObserver$OnWindowAttachListener;

class TransportMediatorJellybeanMR2$1 implements ViewTreeObserver$OnWindowAttachListener
{
    final /* synthetic */ TransportMediatorJellybeanMR2 this$0;
    
    TransportMediatorJellybeanMR2$1(final TransportMediatorJellybeanMR2 this$0) {
        this.this$0 = this$0;
    }
    
    public void onWindowAttached() {
        this.this$0.windowAttached();
    }
    
    public void onWindowDetached() {
        this.this$0.windowDetached();
    }
}
