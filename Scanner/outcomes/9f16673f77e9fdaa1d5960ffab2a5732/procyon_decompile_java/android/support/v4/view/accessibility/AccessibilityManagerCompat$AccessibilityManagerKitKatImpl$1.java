// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

class AccessibilityManagerCompat$AccessibilityManagerKitKatImpl$1 implements AccessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerBridge
{
    final /* synthetic */ AccessibilityManagerCompat$AccessibilityManagerKitKatImpl this$0;
    final /* synthetic */ AccessibilityManagerCompat$TouchExplorationStateChangeListener val$listener;
    
    AccessibilityManagerCompat$AccessibilityManagerKitKatImpl$1(final AccessibilityManagerCompat$AccessibilityManagerKitKatImpl this$0, final AccessibilityManagerCompat$TouchExplorationStateChangeListener val$listener) {
        this.this$0 = this$0;
        this.val$listener = val$listener;
    }
    
    public void onTouchExplorationStateChanged(final boolean b) {
        this.val$listener.onTouchExplorationStateChanged(b);
    }
}
