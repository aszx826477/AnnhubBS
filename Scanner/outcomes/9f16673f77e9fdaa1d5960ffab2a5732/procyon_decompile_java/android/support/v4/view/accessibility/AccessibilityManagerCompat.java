// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import java.util.List;
import android.view.accessibility.AccessibilityManager;
import android.os.Build$VERSION;

public final class AccessibilityManagerCompat
{
    private static final AccessibilityManagerCompat$AccessibilityManagerVersionImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 19) {
            IMPL = new AccessibilityManagerCompat$AccessibilityManagerKitKatImpl();
        }
        else if (Build$VERSION.SDK_INT >= 14) {
            IMPL = new AccessibilityManagerCompat$AccessibilityManagerIcsImpl();
        }
        else {
            IMPL = new AccessibilityManagerCompat$AccessibilityManagerStubImpl();
        }
    }
    
    public static boolean addAccessibilityStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityManagerCompat$AccessibilityStateChangeListener accessibilityManagerCompat$AccessibilityStateChangeListener) {
        return AccessibilityManagerCompat.IMPL.addAccessibilityStateChangeListener(accessibilityManager, accessibilityManagerCompat$AccessibilityStateChangeListener);
    }
    
    public static boolean addTouchExplorationStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityManagerCompat$TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener) {
        return AccessibilityManagerCompat.IMPL.addTouchExplorationStateChangeListener(accessibilityManager, accessibilityManagerCompat$TouchExplorationStateChangeListener);
    }
    
    public static List getEnabledAccessibilityServiceList(final AccessibilityManager accessibilityManager, final int n) {
        return AccessibilityManagerCompat.IMPL.getEnabledAccessibilityServiceList(accessibilityManager, n);
    }
    
    public static List getInstalledAccessibilityServiceList(final AccessibilityManager accessibilityManager) {
        return AccessibilityManagerCompat.IMPL.getInstalledAccessibilityServiceList(accessibilityManager);
    }
    
    public static boolean isTouchExplorationEnabled(final AccessibilityManager accessibilityManager) {
        return AccessibilityManagerCompat.IMPL.isTouchExplorationEnabled(accessibilityManager);
    }
    
    public static boolean removeAccessibilityStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityManagerCompat$AccessibilityStateChangeListener accessibilityManagerCompat$AccessibilityStateChangeListener) {
        return AccessibilityManagerCompat.IMPL.removeAccessibilityStateChangeListener(accessibilityManager, accessibilityManagerCompat$AccessibilityStateChangeListener);
    }
    
    public static boolean removeTouchExplorationStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityManagerCompat$TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener) {
        return AccessibilityManagerCompat.IMPL.removeTouchExplorationStateChangeListener(accessibilityManager, accessibilityManagerCompat$TouchExplorationStateChangeListener);
    }
}
