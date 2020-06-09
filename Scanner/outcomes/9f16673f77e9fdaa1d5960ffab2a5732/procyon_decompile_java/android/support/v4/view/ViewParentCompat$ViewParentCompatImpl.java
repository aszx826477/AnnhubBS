// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.ViewParent;

interface ViewParentCompat$ViewParentCompatImpl
{
    void notifySubtreeAccessibilityStateChanged(final ViewParent p0, final View p1, final View p2, final int p3);
    
    boolean onNestedFling(final ViewParent p0, final View p1, final float p2, final float p3, final boolean p4);
    
    boolean onNestedPreFling(final ViewParent p0, final View p1, final float p2, final float p3);
    
    void onNestedPreScroll(final ViewParent p0, final View p1, final int p2, final int p3, final int[] p4);
    
    void onNestedScroll(final ViewParent p0, final View p1, final int p2, final int p3, final int p4, final int p5);
    
    void onNestedScrollAccepted(final ViewParent p0, final View p1, final View p2, final int p3);
    
    boolean onStartNestedScroll(final ViewParent p0, final View p1, final View p2, final int p3);
    
    void onStopNestedScroll(final ViewParent p0, final View p1);
    
    boolean requestSendAccessibilityEvent(final ViewParent p0, final View p1, final AccessibilityEvent p2);
}
