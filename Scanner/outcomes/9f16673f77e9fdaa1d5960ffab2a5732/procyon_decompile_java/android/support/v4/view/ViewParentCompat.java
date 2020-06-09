// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.ViewParent;
import android.os.Build$VERSION;

public final class ViewParentCompat
{
    static final ViewParentCompat$ViewParentCompatImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 21) {
            IMPL = new ViewParentCompat$ViewParentCompatLollipopImpl();
        }
        else if (sdk_INT >= 19) {
            IMPL = new ViewParentCompat$ViewParentCompatKitKatImpl();
        }
        else if (sdk_INT >= 14) {
            IMPL = new ViewParentCompat$ViewParentCompatICSImpl();
        }
        else {
            IMPL = new ViewParentCompat$ViewParentCompatStubImpl();
        }
    }
    
    public static void notifySubtreeAccessibilityStateChanged(final ViewParent viewParent, final View view, final View view2, final int n) {
        ViewParentCompat.IMPL.notifySubtreeAccessibilityStateChanged(viewParent, view, view2, n);
    }
    
    public static boolean onNestedFling(final ViewParent viewParent, final View view, final float n, final float n2, final boolean b) {
        return ViewParentCompat.IMPL.onNestedFling(viewParent, view, n, n2, b);
    }
    
    public static boolean onNestedPreFling(final ViewParent viewParent, final View view, final float n, final float n2) {
        return ViewParentCompat.IMPL.onNestedPreFling(viewParent, view, n, n2);
    }
    
    public static void onNestedPreScroll(final ViewParent viewParent, final View view, final int n, final int n2, final int[] array) {
        ViewParentCompat.IMPL.onNestedPreScroll(viewParent, view, n, n2, array);
    }
    
    public static void onNestedScroll(final ViewParent viewParent, final View view, final int n, final int n2, final int n3, final int n4) {
        ViewParentCompat.IMPL.onNestedScroll(viewParent, view, n, n2, n3, n4);
    }
    
    public static void onNestedScrollAccepted(final ViewParent viewParent, final View view, final View view2, final int n) {
        ViewParentCompat.IMPL.onNestedScrollAccepted(viewParent, view, view2, n);
    }
    
    public static boolean onStartNestedScroll(final ViewParent viewParent, final View view, final View view2, final int n) {
        return ViewParentCompat.IMPL.onStartNestedScroll(viewParent, view, view2, n);
    }
    
    public static void onStopNestedScroll(final ViewParent viewParent, final View view) {
        ViewParentCompat.IMPL.onStopNestedScroll(viewParent, view);
    }
    
    public static boolean requestSendAccessibilityEvent(final ViewParent viewParent, final View view, final AccessibilityEvent accessibilityEvent) {
        return ViewParentCompat.IMPL.requestSendAccessibilityEvent(viewParent, view, accessibilityEvent);
    }
}
