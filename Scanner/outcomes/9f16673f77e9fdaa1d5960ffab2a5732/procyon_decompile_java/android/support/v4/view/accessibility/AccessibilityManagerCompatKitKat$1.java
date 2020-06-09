// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener;

final class AccessibilityManagerCompatKitKat$1 implements AccessibilityManager$TouchExplorationStateChangeListener
{
    final /* synthetic */ AccessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerBridge val$bridge;
    
    AccessibilityManagerCompatKitKat$1(final AccessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerBridge val$bridge) {
        this.val$bridge = val$bridge;
    }
    
    public void onTouchExplorationStateChanged(final boolean b) {
        this.val$bridge.onTouchExplorationStateChanged(b);
    }
}
