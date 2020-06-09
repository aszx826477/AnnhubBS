// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityManager;

class AccessibilityManagerCompat$AccessibilityManagerKitKatImpl extends AccessibilityManagerCompat$AccessibilityManagerIcsImpl
{
    public boolean addTouchExplorationStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityManagerCompat$TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener) {
        return AccessibilityManagerCompatKitKat.addTouchExplorationStateChangeListener(accessibilityManager, this.newTouchExplorationStateChangeListener(accessibilityManagerCompat$TouchExplorationStateChangeListener));
    }
    
    public AccessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerWrapper newTouchExplorationStateChangeListener(final AccessibilityManagerCompat$TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener) {
        return new AccessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerWrapper(accessibilityManagerCompat$TouchExplorationStateChangeListener, new AccessibilityManagerCompat$AccessibilityManagerKitKatImpl$1(this, accessibilityManagerCompat$TouchExplorationStateChangeListener));
    }
    
    public boolean removeTouchExplorationStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityManagerCompat$TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener) {
        return AccessibilityManagerCompatKitKat.removeTouchExplorationStateChangeListener(accessibilityManager, this.newTouchExplorationStateChangeListener(accessibilityManagerCompat$TouchExplorationStateChangeListener));
    }
}
