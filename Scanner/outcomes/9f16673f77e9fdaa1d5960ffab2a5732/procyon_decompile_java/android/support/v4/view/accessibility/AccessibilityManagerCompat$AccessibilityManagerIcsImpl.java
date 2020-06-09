// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import java.util.List;
import android.view.accessibility.AccessibilityManager;

class AccessibilityManagerCompat$AccessibilityManagerIcsImpl extends AccessibilityManagerCompat$AccessibilityManagerStubImpl
{
    public boolean addAccessibilityStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityManagerCompat$AccessibilityStateChangeListener accessibilityManagerCompat$AccessibilityStateChangeListener) {
        return AccessibilityManagerCompatIcs.addAccessibilityStateChangeListener(accessibilityManager, this.newAccessibilityStateChangeListener(accessibilityManagerCompat$AccessibilityStateChangeListener));
    }
    
    public List getEnabledAccessibilityServiceList(final AccessibilityManager accessibilityManager, final int n) {
        return AccessibilityManagerCompatIcs.getEnabledAccessibilityServiceList(accessibilityManager, n);
    }
    
    public List getInstalledAccessibilityServiceList(final AccessibilityManager accessibilityManager) {
        return AccessibilityManagerCompatIcs.getInstalledAccessibilityServiceList(accessibilityManager);
    }
    
    public boolean isTouchExplorationEnabled(final AccessibilityManager accessibilityManager) {
        return AccessibilityManagerCompatIcs.isTouchExplorationEnabled(accessibilityManager);
    }
    
    public AccessibilityManagerCompatIcs$AccessibilityStateChangeListenerWrapper newAccessibilityStateChangeListener(final AccessibilityManagerCompat$AccessibilityStateChangeListener accessibilityManagerCompat$AccessibilityStateChangeListener) {
        return new AccessibilityManagerCompatIcs$AccessibilityStateChangeListenerWrapper(accessibilityManagerCompat$AccessibilityStateChangeListener, new AccessibilityManagerCompat$AccessibilityManagerIcsImpl$1(this, accessibilityManagerCompat$AccessibilityStateChangeListener));
    }
    
    public boolean removeAccessibilityStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityManagerCompat$AccessibilityStateChangeListener accessibilityManagerCompat$AccessibilityStateChangeListener) {
        return AccessibilityManagerCompatIcs.removeAccessibilityStateChangeListener(accessibilityManager, this.newAccessibilityStateChangeListener(accessibilityManagerCompat$AccessibilityStateChangeListener));
    }
}
