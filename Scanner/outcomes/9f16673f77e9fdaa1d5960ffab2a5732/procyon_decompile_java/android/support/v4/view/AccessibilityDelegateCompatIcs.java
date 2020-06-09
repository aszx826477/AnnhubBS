// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.View$AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;

class AccessibilityDelegateCompatIcs
{
    public static boolean dispatchPopulateAccessibilityEvent(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        return ((View$AccessibilityDelegate)o).dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }
    
    public static Object newAccessibilityDelegateBridge(final AccessibilityDelegateCompatIcs$AccessibilityDelegateBridge accessibilityDelegateCompatIcs$AccessibilityDelegateBridge) {
        return new AccessibilityDelegateCompatIcs$1(accessibilityDelegateCompatIcs$AccessibilityDelegateBridge);
    }
    
    public static Object newAccessibilityDelegateDefaultImpl() {
        return new View$AccessibilityDelegate();
    }
    
    public static void onInitializeAccessibilityEvent(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        ((View$AccessibilityDelegate)o).onInitializeAccessibilityEvent(view, accessibilityEvent);
    }
    
    public static void onInitializeAccessibilityNodeInfo(final Object o, final View view, final Object o2) {
        ((View$AccessibilityDelegate)o).onInitializeAccessibilityNodeInfo(view, (AccessibilityNodeInfo)o2);
    }
    
    public static void onPopulateAccessibilityEvent(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        ((View$AccessibilityDelegate)o).onPopulateAccessibilityEvent(view, accessibilityEvent);
    }
    
    public static boolean onRequestSendAccessibilityEvent(final Object o, final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return ((View$AccessibilityDelegate)o).onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }
    
    public static void sendAccessibilityEvent(final Object o, final View view, final int n) {
        ((View$AccessibilityDelegate)o).sendAccessibilityEvent(view, n);
    }
    
    public static void sendAccessibilityEventUnchecked(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        ((View$AccessibilityDelegate)o).sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
