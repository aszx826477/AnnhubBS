// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.SharedElementCallback$OnSharedElementsReadyListener;

class ActivityCompatApi23$SharedElementCallbackImpl$1 implements ActivityCompatApi23$OnSharedElementsReadyListenerBridge
{
    final /* synthetic */ ActivityCompatApi23$SharedElementCallbackImpl this$0;
    final /* synthetic */ SharedElementCallback$OnSharedElementsReadyListener val$listener;
    
    ActivityCompatApi23$SharedElementCallbackImpl$1(final ActivityCompatApi23$SharedElementCallbackImpl this$0, final SharedElementCallback$OnSharedElementsReadyListener val$listener) {
        this.this$0 = this$0;
        this.val$listener = val$listener;
    }
    
    public void onSharedElementsReady() {
        this.val$listener.onSharedElementsReady();
    }
}
