// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.ViewGroup;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;

class AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl extends AccessibilityDelegateCompat$AccessibilityDelegateStubImpl
{
    public boolean dispatchPopulateAccessibilityEvent(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        return AccessibilityDelegateCompatIcs.dispatchPopulateAccessibilityEvent(o, view, accessibilityEvent);
    }
    
    public Object newAccessiblityDelegateBridge(final AccessibilityDelegateCompat accessibilityDelegateCompat) {
        return AccessibilityDelegateCompatIcs.newAccessibilityDelegateBridge(new AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl$1(this, accessibilityDelegateCompat));
    }
    
    public Object newAccessiblityDelegateDefaultImpl() {
        return AccessibilityDelegateCompatIcs.newAccessibilityDelegateDefaultImpl();
    }
    
    public void onInitializeAccessibilityEvent(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompatIcs.onInitializeAccessibilityEvent(o, view, accessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(final Object o, final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AccessibilityDelegateCompatIcs.onInitializeAccessibilityNodeInfo(o, view, accessibilityNodeInfoCompat.getInfo());
    }
    
    public void onPopulateAccessibilityEvent(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompatIcs.onPopulateAccessibilityEvent(o, view, accessibilityEvent);
    }
    
    public boolean onRequestSendAccessibilityEvent(final Object o, final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return AccessibilityDelegateCompatIcs.onRequestSendAccessibilityEvent(o, viewGroup, view, accessibilityEvent);
    }
    
    public void sendAccessibilityEvent(final Object o, final View view, final int n) {
        AccessibilityDelegateCompatIcs.sendAccessibilityEvent(o, view, n);
    }
    
    public void sendAccessibilityEventUnchecked(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompatIcs.sendAccessibilityEventUnchecked(o, view, accessibilityEvent);
    }
}
