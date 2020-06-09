// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.os.Bundle;
import android.view.ViewGroup;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;

class AccessibilityDelegateCompat$AccessibilityDelegateStubImpl implements AccessibilityDelegateCompat$AccessibilityDelegateImpl
{
    public boolean dispatchPopulateAccessibilityEvent(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        return false;
    }
    
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(final Object o, final View view) {
        return null;
    }
    
    public Object newAccessiblityDelegateBridge(final AccessibilityDelegateCompat accessibilityDelegateCompat) {
        return null;
    }
    
    public Object newAccessiblityDelegateDefaultImpl() {
        return null;
    }
    
    public void onInitializeAccessibilityEvent(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
    }
    
    public void onInitializeAccessibilityNodeInfo(final Object o, final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }
    
    public void onPopulateAccessibilityEvent(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
    }
    
    public boolean onRequestSendAccessibilityEvent(final Object o, final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return true;
    }
    
    public boolean performAccessibilityAction(final Object o, final View view, final int n, final Bundle bundle) {
        return false;
    }
    
    public void sendAccessibilityEvent(final Object o, final View view, final int n) {
    }
    
    public void sendAccessibilityEventUnchecked(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
    }
}
