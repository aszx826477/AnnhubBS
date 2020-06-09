// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import android.view.View;
import android.support.v7.view.CollapsibleActionView;
import android.widget.FrameLayout;

class MenuItemWrapperICS$CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView
{
    final android.view.CollapsibleActionView mWrappedView;
    
    MenuItemWrapperICS$CollapsibleActionViewWrapper(final View view) {
        super(view.getContext());
        this.mWrappedView = (android.view.CollapsibleActionView)view;
        this.addView(view);
    }
    
    View getWrappedView() {
        return (View)this.mWrappedView;
    }
    
    public void onActionViewCollapsed() {
        this.mWrappedView.onActionViewCollapsed();
    }
    
    public void onActionViewExpanded() {
        this.mWrappedView.onActionViewExpanded();
    }
}
