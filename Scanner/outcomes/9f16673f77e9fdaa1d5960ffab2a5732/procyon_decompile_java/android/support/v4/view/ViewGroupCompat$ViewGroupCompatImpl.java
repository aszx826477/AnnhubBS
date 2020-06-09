// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.ViewGroup;

interface ViewGroupCompat$ViewGroupCompatImpl
{
    int getLayoutMode(final ViewGroup p0);
    
    int getNestedScrollAxes(final ViewGroup p0);
    
    boolean isTransitionGroup(final ViewGroup p0);
    
    boolean onRequestSendAccessibilityEvent(final ViewGroup p0, final View p1, final AccessibilityEvent p2);
    
    void setLayoutMode(final ViewGroup p0, final int p1);
    
    void setMotionEventSplittingEnabled(final ViewGroup p0, final boolean p1);
    
    void setTransitionGroup(final ViewGroup p0, final boolean p1);
}
