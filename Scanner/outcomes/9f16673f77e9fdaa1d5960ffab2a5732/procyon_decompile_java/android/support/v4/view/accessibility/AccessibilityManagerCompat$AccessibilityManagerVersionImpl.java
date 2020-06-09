// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import java.util.List;
import android.view.accessibility.AccessibilityManager;

interface AccessibilityManagerCompat$AccessibilityManagerVersionImpl
{
    boolean addAccessibilityStateChangeListener(final AccessibilityManager p0, final AccessibilityManagerCompat$AccessibilityStateChangeListener p1);
    
    boolean addTouchExplorationStateChangeListener(final AccessibilityManager p0, final AccessibilityManagerCompat$TouchExplorationStateChangeListener p1);
    
    List getEnabledAccessibilityServiceList(final AccessibilityManager p0, final int p1);
    
    List getInstalledAccessibilityServiceList(final AccessibilityManager p0);
    
    boolean isTouchExplorationEnabled(final AccessibilityManager p0);
    
    AccessibilityManagerCompatIcs$AccessibilityStateChangeListenerWrapper newAccessibilityStateChangeListener(final AccessibilityManagerCompat$AccessibilityStateChangeListener p0);
    
    AccessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerWrapper newTouchExplorationStateChangeListener(final AccessibilityManagerCompat$TouchExplorationStateChangeListener p0);
    
    boolean removeAccessibilityStateChangeListener(final AccessibilityManager p0, final AccessibilityManagerCompat$AccessibilityStateChangeListener p1);
    
    boolean removeTouchExplorationStateChangeListener(final AccessibilityManager p0, final AccessibilityManagerCompat$TouchExplorationStateChangeListener p1);
}
