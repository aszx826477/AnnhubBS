// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

class ActivityCompat$SharedElementCallback23Impl$1 implements SharedElementCallback$OnSharedElementsReadyListener
{
    final /* synthetic */ ActivityCompat$SharedElementCallback23Impl this$0;
    final /* synthetic */ ActivityCompatApi23$OnSharedElementsReadyListenerBridge val$listener;
    
    ActivityCompat$SharedElementCallback23Impl$1(final ActivityCompat$SharedElementCallback23Impl this$0, final ActivityCompatApi23$OnSharedElementsReadyListenerBridge val$listener) {
        this.this$0 = this$0;
        this.val$listener = val$listener;
    }
    
    public void onSharedElementsReady() {
        this.val$listener.onSharedElementsReady();
    }
}
