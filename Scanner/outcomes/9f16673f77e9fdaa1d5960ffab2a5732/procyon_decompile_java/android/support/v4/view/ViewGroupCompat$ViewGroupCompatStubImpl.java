// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.ViewGroup;

class ViewGroupCompat$ViewGroupCompatStubImpl implements ViewGroupCompat$ViewGroupCompatImpl
{
    public int getLayoutMode(final ViewGroup viewGroup) {
        return 0;
    }
    
    public int getNestedScrollAxes(final ViewGroup viewGroup) {
        if (viewGroup instanceof NestedScrollingParent) {
            return ((NestedScrollingParent)viewGroup).getNestedScrollAxes();
        }
        return 0;
    }
    
    public boolean isTransitionGroup(final ViewGroup viewGroup) {
        return false;
    }
    
    public boolean onRequestSendAccessibilityEvent(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return true;
    }
    
    public void setLayoutMode(final ViewGroup viewGroup, final int n) {
    }
    
    public void setMotionEventSplittingEnabled(final ViewGroup viewGroup, final boolean b) {
    }
    
    public void setTransitionGroup(final ViewGroup viewGroup, final boolean b) {
    }
}
