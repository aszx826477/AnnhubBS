// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.view.View;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi22Impl extends AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi21Impl
{
    public Object getTraversalAfter(final Object o) {
        return AccessibilityNodeInfoCompatApi22.getTraversalAfter(o);
    }
    
    public Object getTraversalBefore(final Object o) {
        return AccessibilityNodeInfoCompatApi22.getTraversalBefore(o);
    }
    
    public void setTraversalAfter(final Object o, final View view) {
        AccessibilityNodeInfoCompatApi22.setTraversalAfter(o, view);
    }
    
    public void setTraversalAfter(final Object o, final View view, final int n) {
        AccessibilityNodeInfoCompatApi22.setTraversalAfter(o, view, n);
    }
    
    public void setTraversalBefore(final Object o, final View view) {
        AccessibilityNodeInfoCompatApi22.setTraversalBefore(o, view);
    }
    
    public void setTraversalBefore(final Object o, final View view, final int n) {
        AccessibilityNodeInfoCompatApi22.setTraversalBefore(o, view, n);
    }
}
