// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.View;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanImpl extends AccessibilityNodeInfoCompat$AccessibilityNodeInfoIcsImpl
{
    public void addChild(final Object o, final View view, final int n) {
        AccessibilityNodeInfoCompatJellyBean.addChild(o, view, n);
    }
    
    public Object findFocus(final Object o, final int n) {
        return AccessibilityNodeInfoCompatJellyBean.findFocus(o, n);
    }
    
    public Object focusSearch(final Object o, final int n) {
        return AccessibilityNodeInfoCompatJellyBean.focusSearch(o, n);
    }
    
    public int getMovementGranularities(final Object o) {
        return AccessibilityNodeInfoCompatJellyBean.getMovementGranularities(o);
    }
    
    public boolean isAccessibilityFocused(final Object o) {
        return AccessibilityNodeInfoCompatJellyBean.isAccessibilityFocused(o);
    }
    
    public boolean isVisibleToUser(final Object o) {
        return AccessibilityNodeInfoCompatJellyBean.isVisibleToUser(o);
    }
    
    public Object obtain(final View view, final int n) {
        return AccessibilityNodeInfoCompatJellyBean.obtain(view, n);
    }
    
    public boolean performAction(final Object o, final int n, final Bundle bundle) {
        return AccessibilityNodeInfoCompatJellyBean.performAction(o, n, bundle);
    }
    
    public void setAccessibilityFocused(final Object o, final boolean b) {
        AccessibilityNodeInfoCompatJellyBean.setAccesibilityFocused(o, b);
    }
    
    public void setMovementGranularities(final Object o, final int n) {
        AccessibilityNodeInfoCompatJellyBean.setMovementGranularities(o, n);
    }
    
    public void setParent(final Object o, final View view, final int n) {
        AccessibilityNodeInfoCompatJellyBean.setParent(o, view, n);
    }
    
    public void setSource(final Object o, final View view, final int n) {
        AccessibilityNodeInfoCompatJellyBean.setSource(o, view, n);
    }
    
    public void setVisibleToUser(final Object o, final boolean b) {
        AccessibilityNodeInfoCompatJellyBean.setVisibleToUser(o, b);
    }
}
