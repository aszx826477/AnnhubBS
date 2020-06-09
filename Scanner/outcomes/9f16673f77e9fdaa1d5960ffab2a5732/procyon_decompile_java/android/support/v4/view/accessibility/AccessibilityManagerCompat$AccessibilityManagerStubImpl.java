// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import java.util.Collections;
import java.util.List;
import android.view.accessibility.AccessibilityManager;

class AccessibilityManagerCompat$AccessibilityManagerStubImpl implements AccessibilityManagerCompat$AccessibilityManagerVersionImpl
{
    public boolean addAccessibilityStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityManagerCompat$AccessibilityStateChangeListener accessibilityManagerCompat$AccessibilityStateChangeListener) {
        return false;
    }
    
    public boolean addTouchExplorationStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityManagerCompat$TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener) {
        return false;
    }
    
    public List getEnabledAccessibilityServiceList(final AccessibilityManager accessibilityManager, final int n) {
        return Collections.emptyList();
    }
    
    public List getInstalledAccessibilityServiceList(final AccessibilityManager accessibilityManager) {
        return Collections.emptyList();
    }
    
    public boolean isTouchExplorationEnabled(final AccessibilityManager accessibilityManager) {
        return false;
    }
    
    public AccessibilityManagerCompatIcs$AccessibilityStateChangeListenerWrapper newAccessibilityStateChangeListener(final AccessibilityManagerCompat$AccessibilityStateChangeListener accessibilityManagerCompat$AccessibilityStateChangeListener) {
        return null;
    }
    
    public AccessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerWrapper newTouchExplorationStateChangeListener(final AccessibilityManagerCompat$TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener) {
        return null;
    }
    
    public boolean removeAccessibilityStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityManagerCompat$AccessibilityStateChangeListener accessibilityManagerCompat$AccessibilityStateChangeListener) {
        return false;
    }
    
    public boolean removeTouchExplorationStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityManagerCompat$TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener) {
        return false;
    }
}
