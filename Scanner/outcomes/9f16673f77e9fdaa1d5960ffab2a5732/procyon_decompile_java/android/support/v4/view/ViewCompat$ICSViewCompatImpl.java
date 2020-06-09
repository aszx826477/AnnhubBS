// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.accessibility.AccessibilityEvent;
import java.util.WeakHashMap;
import android.view.View;
import java.lang.reflect.Field;

class ViewCompat$ICSViewCompatImpl extends ViewCompat$HCViewCompatImpl
{
    static boolean accessibilityDelegateCheckFailed;
    static Field mAccessibilityDelegateField;
    
    static {
        ViewCompat$ICSViewCompatImpl.accessibilityDelegateCheckFailed = false;
    }
    
    public ViewPropertyAnimatorCompat animate(final View view) {
        if (this.mViewPropertyAnimatorCompatMap == null) {
            this.mViewPropertyAnimatorCompatMap = new WeakHashMap();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mViewPropertyAnimatorCompatMap.get(view);
        if (viewPropertyAnimatorCompat == null) {
            viewPropertyAnimatorCompat = new ViewPropertyAnimatorCompat(view);
            this.mViewPropertyAnimatorCompatMap.put(view, viewPropertyAnimatorCompat);
        }
        return viewPropertyAnimatorCompat;
    }
    
    public boolean canScrollHorizontally(final View view, final int n) {
        return ViewCompatICS.canScrollHorizontally(view, n);
    }
    
    public boolean canScrollVertically(final View view, final int n) {
        return ViewCompatICS.canScrollVertically(view, n);
    }
    
    public boolean hasAccessibilityDelegate(final View view) {
        final boolean accessibilityDelegateCheckFailed = ViewCompat$ICSViewCompatImpl.accessibilityDelegateCheckFailed;
        boolean b = false;
        if (accessibilityDelegateCheckFailed) {
            return false;
        }
        final Field mAccessibilityDelegateField = ViewCompat$ICSViewCompatImpl.mAccessibilityDelegateField;
        final boolean accessibilityDelegateCheckFailed2 = true;
        if (mAccessibilityDelegateField == null) {
            final Class<View> clazz = View.class;
            final String s = "mAccessibilityDelegate";
            final Class<View> clazz2 = clazz;
            try {
                (ViewCompat$ICSViewCompatImpl.mAccessibilityDelegateField = clazz2.getDeclaredField(s)).setAccessible(accessibilityDelegateCheckFailed2);
            }
            finally {
                ViewCompat$ICSViewCompatImpl.accessibilityDelegateCheckFailed = accessibilityDelegateCheckFailed2;
                return false;
            }
        }
        try {
            if (ViewCompat$ICSViewCompatImpl.mAccessibilityDelegateField.get(view) != null) {
                b = true;
            }
            return b;
        }
        finally {
            ViewCompat$ICSViewCompatImpl.accessibilityDelegateCheckFailed = accessibilityDelegateCheckFailed2;
            return false;
        }
    }
    
    public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        ViewCompatICS.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewCompatICS.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.getInfo());
    }
    
    public void onPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        ViewCompatICS.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }
    
    public void setAccessibilityDelegate(final View view, final AccessibilityDelegateCompat accessibilityDelegateCompat) {
        Object bridge;
        if (accessibilityDelegateCompat == null) {
            bridge = null;
        }
        else {
            bridge = accessibilityDelegateCompat.getBridge();
        }
        ViewCompatICS.setAccessibilityDelegate(view, bridge);
    }
    
    public void setFitsSystemWindows(final View view, final boolean b) {
        ViewCompatICS.setFitsSystemWindows(view, b);
    }
}
