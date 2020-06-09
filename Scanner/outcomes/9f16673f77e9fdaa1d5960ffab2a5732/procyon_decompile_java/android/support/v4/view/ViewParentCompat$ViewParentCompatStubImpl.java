// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.ViewParent;

class ViewParentCompat$ViewParentCompatStubImpl implements ViewParentCompat$ViewParentCompatImpl
{
    public void notifySubtreeAccessibilityStateChanged(final ViewParent viewParent, final View view, final View view2, final int n) {
    }
    
    public boolean onNestedFling(final ViewParent viewParent, final View view, final float n, final float n2, final boolean b) {
        return viewParent instanceof NestedScrollingParent && ((NestedScrollingParent)viewParent).onNestedFling(view, n, n2, b);
    }
    
    public boolean onNestedPreFling(final ViewParent viewParent, final View view, final float n, final float n2) {
        return viewParent instanceof NestedScrollingParent && ((NestedScrollingParent)viewParent).onNestedPreFling(view, n, n2);
    }
    
    public void onNestedPreScroll(final ViewParent viewParent, final View view, final int n, final int n2, final int[] array) {
        if (viewParent instanceof NestedScrollingParent) {
            ((NestedScrollingParent)viewParent).onNestedPreScroll(view, n, n2, array);
        }
    }
    
    public void onNestedScroll(final ViewParent viewParent, final View view, final int n, final int n2, final int n3, final int n4) {
        if (viewParent instanceof NestedScrollingParent) {
            ((NestedScrollingParent)viewParent).onNestedScroll(view, n, n2, n3, n4);
        }
    }
    
    public void onNestedScrollAccepted(final ViewParent viewParent, final View view, final View view2, final int n) {
        if (viewParent instanceof NestedScrollingParent) {
            ((NestedScrollingParent)viewParent).onNestedScrollAccepted(view, view2, n);
        }
    }
    
    public boolean onStartNestedScroll(final ViewParent viewParent, final View view, final View view2, final int n) {
        return viewParent instanceof NestedScrollingParent && ((NestedScrollingParent)viewParent).onStartNestedScroll(view, view2, n);
    }
    
    public void onStopNestedScroll(final ViewParent viewParent, final View view) {
        if (viewParent instanceof NestedScrollingParent) {
            ((NestedScrollingParent)viewParent).onStopNestedScroll(view);
        }
    }
    
    public boolean requestSendAccessibilityEvent(final ViewParent viewParent, final View view, final AccessibilityEvent accessibilityEvent) {
        if (view == null) {
            return false;
        }
        ((AccessibilityManager)view.getContext().getSystemService("accessibility")).sendAccessibilityEvent(accessibilityEvent);
        return true;
    }
}
