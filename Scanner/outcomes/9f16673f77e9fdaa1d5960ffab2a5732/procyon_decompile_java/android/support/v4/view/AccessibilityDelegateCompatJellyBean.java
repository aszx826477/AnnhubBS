// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.os.Bundle;
import android.view.View$AccessibilityDelegate;
import android.view.View;

class AccessibilityDelegateCompatJellyBean
{
    public static Object getAccessibilityNodeProvider(final Object o, final View view) {
        return ((View$AccessibilityDelegate)o).getAccessibilityNodeProvider(view);
    }
    
    public static Object newAccessibilityDelegateBridge(final AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean accessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean) {
        return new AccessibilityDelegateCompatJellyBean$1(accessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean);
    }
    
    public static boolean performAccessibilityAction(final Object o, final View view, final int n, final Bundle bundle) {
        return ((View$AccessibilityDelegate)o).performAccessibilityAction(view, n, bundle);
    }
}
