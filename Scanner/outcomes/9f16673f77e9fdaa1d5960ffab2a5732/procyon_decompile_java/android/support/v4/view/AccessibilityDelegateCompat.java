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
import android.os.Build$VERSION;

public class AccessibilityDelegateCompat
{
    private static final Object DEFAULT_DELEGATE;
    private static final AccessibilityDelegateCompat$AccessibilityDelegateImpl IMPL;
    final Object mBridge;
    
    static {
        if (Build$VERSION.SDK_INT >= 16) {
            IMPL = new AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl();
        }
        else if (Build$VERSION.SDK_INT >= 14) {
            IMPL = new AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl();
        }
        else {
            IMPL = new AccessibilityDelegateCompat$AccessibilityDelegateStubImpl();
        }
        DEFAULT_DELEGATE = AccessibilityDelegateCompat.IMPL.newAccessiblityDelegateDefaultImpl();
    }
    
    public AccessibilityDelegateCompat() {
        this.mBridge = AccessibilityDelegateCompat.IMPL.newAccessiblityDelegateBridge(this);
    }
    
    public boolean dispatchPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        return AccessibilityDelegateCompat.IMPL.dispatchPopulateAccessibilityEvent(AccessibilityDelegateCompat.DEFAULT_DELEGATE, view, accessibilityEvent);
    }
    
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(final View view) {
        return AccessibilityDelegateCompat.IMPL.getAccessibilityNodeProvider(AccessibilityDelegateCompat.DEFAULT_DELEGATE, view);
    }
    
    Object getBridge() {
        return this.mBridge;
    }
    
    public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat.IMPL.onInitializeAccessibilityEvent(AccessibilityDelegateCompat.DEFAULT_DELEGATE, view, accessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AccessibilityDelegateCompat.IMPL.onInitializeAccessibilityNodeInfo(AccessibilityDelegateCompat.DEFAULT_DELEGATE, view, accessibilityNodeInfoCompat);
    }
    
    public void onPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat.IMPL.onPopulateAccessibilityEvent(AccessibilityDelegateCompat.DEFAULT_DELEGATE, view, accessibilityEvent);
    }
    
    public boolean onRequestSendAccessibilityEvent(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return AccessibilityDelegateCompat.IMPL.onRequestSendAccessibilityEvent(AccessibilityDelegateCompat.DEFAULT_DELEGATE, viewGroup, view, accessibilityEvent);
    }
    
    public boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
        return AccessibilityDelegateCompat.IMPL.performAccessibilityAction(AccessibilityDelegateCompat.DEFAULT_DELEGATE, view, n, bundle);
    }
    
    public void sendAccessibilityEvent(final View view, final int n) {
        AccessibilityDelegateCompat.IMPL.sendAccessibilityEvent(AccessibilityDelegateCompat.DEFAULT_DELEGATE, view, n);
    }
    
    public void sendAccessibilityEventUnchecked(final View view, final AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat.IMPL.sendAccessibilityEventUnchecked(AccessibilityDelegateCompat.DEFAULT_DELEGATE, view, accessibilityEvent);
    }
}
