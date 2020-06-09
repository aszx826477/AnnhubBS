// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

class ViewParentCompat$ViewParentCompatLollipopImpl extends ViewParentCompat$ViewParentCompatKitKatImpl
{
    public boolean onNestedFling(final ViewParent viewParent, final View view, final float n, final float n2, final boolean b) {
        return ViewParentCompatLollipop.onNestedFling(viewParent, view, n, n2, b);
    }
    
    public boolean onNestedPreFling(final ViewParent viewParent, final View view, final float n, final float n2) {
        return ViewParentCompatLollipop.onNestedPreFling(viewParent, view, n, n2);
    }
    
    public void onNestedPreScroll(final ViewParent viewParent, final View view, final int n, final int n2, final int[] array) {
        ViewParentCompatLollipop.onNestedPreScroll(viewParent, view, n, n2, array);
    }
    
    public void onNestedScroll(final ViewParent viewParent, final View view, final int n, final int n2, final int n3, final int n4) {
        ViewParentCompatLollipop.onNestedScroll(viewParent, view, n, n2, n3, n4);
    }
    
    public void onNestedScrollAccepted(final ViewParent viewParent, final View view, final View view2, final int n) {
        ViewParentCompatLollipop.onNestedScrollAccepted(viewParent, view, view2, n);
    }
    
    public boolean onStartNestedScroll(final ViewParent viewParent, final View view, final View view2, final int n) {
        return ViewParentCompatLollipop.onStartNestedScroll(viewParent, view, view2, n);
    }
    
    public void onStopNestedScroll(final ViewParent viewParent, final View view) {
        ViewParentCompatLollipop.onStopNestedScroll(viewParent, view);
    }
}
