// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener;
import android.view.accessibility.AccessibilityManager;

class AccessibilityManagerCompatKitKat
{
    public static boolean addTouchExplorationStateChangeListener(final AccessibilityManager accessibilityManager, final Object o) {
        return accessibilityManager.addTouchExplorationStateChangeListener((AccessibilityManager$TouchExplorationStateChangeListener)o);
    }
    
    public static Object newTouchExplorationStateChangeListener(final AccessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerBridge accessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerBridge) {
        return new AccessibilityManagerCompatKitKat$1(accessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerBridge);
    }
    
    public static boolean removeTouchExplorationStateChangeListener(final AccessibilityManager accessibilityManager, final Object o) {
        return accessibilityManager.removeTouchExplorationStateChangeListener((AccessibilityManager$TouchExplorationStateChangeListener)o);
    }
}
