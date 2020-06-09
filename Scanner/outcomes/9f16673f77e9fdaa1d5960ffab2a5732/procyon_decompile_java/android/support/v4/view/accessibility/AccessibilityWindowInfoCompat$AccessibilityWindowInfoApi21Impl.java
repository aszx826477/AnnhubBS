// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.graphics.Rect;

class AccessibilityWindowInfoCompat$AccessibilityWindowInfoApi21Impl extends AccessibilityWindowInfoCompat$AccessibilityWindowInfoStubImpl
{
    public void getBoundsInScreen(final Object o, final Rect rect) {
        AccessibilityWindowInfoCompatApi21.getBoundsInScreen(o, rect);
    }
    
    public Object getChild(final Object o, final int n) {
        return AccessibilityWindowInfoCompatApi21.getChild(o, n);
    }
    
    public int getChildCount(final Object o) {
        return AccessibilityWindowInfoCompatApi21.getChildCount(o);
    }
    
    public int getId(final Object o) {
        return AccessibilityWindowInfoCompatApi21.getId(o);
    }
    
    public int getLayer(final Object o) {
        return AccessibilityWindowInfoCompatApi21.getLayer(o);
    }
    
    public Object getParent(final Object o) {
        return AccessibilityWindowInfoCompatApi21.getParent(o);
    }
    
    public Object getRoot(final Object o) {
        return AccessibilityWindowInfoCompatApi21.getRoot(o);
    }
    
    public int getType(final Object o) {
        return AccessibilityWindowInfoCompatApi21.getType(o);
    }
    
    public boolean isAccessibilityFocused(final Object o) {
        return AccessibilityWindowInfoCompatApi21.isAccessibilityFocused(o);
    }
    
    public boolean isActive(final Object o) {
        return AccessibilityWindowInfoCompatApi21.isActive(o);
    }
    
    public boolean isFocused(final Object o) {
        return AccessibilityWindowInfoCompatApi21.isFocused(o);
    }
    
    public Object obtain() {
        return AccessibilityWindowInfoCompatApi21.obtain();
    }
    
    public Object obtain(final Object o) {
        return AccessibilityWindowInfoCompatApi21.obtain(o);
    }
    
    public void recycle(final Object o) {
        AccessibilityWindowInfoCompatApi21.recycle(o);
    }
}
