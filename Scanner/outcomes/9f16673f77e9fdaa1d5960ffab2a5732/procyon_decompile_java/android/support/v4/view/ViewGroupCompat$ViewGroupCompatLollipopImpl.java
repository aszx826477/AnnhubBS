// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.ViewGroup;

class ViewGroupCompat$ViewGroupCompatLollipopImpl extends ViewGroupCompat$ViewGroupCompatJellybeanMR2Impl
{
    public int getNestedScrollAxes(final ViewGroup viewGroup) {
        return ViewGroupCompatLollipop.getNestedScrollAxes(viewGroup);
    }
    
    public boolean isTransitionGroup(final ViewGroup viewGroup) {
        return ViewGroupCompatLollipop.isTransitionGroup(viewGroup);
    }
    
    public void setTransitionGroup(final ViewGroup viewGroup, final boolean b) {
        ViewGroupCompatLollipop.setTransitionGroup(viewGroup, b);
    }
}
