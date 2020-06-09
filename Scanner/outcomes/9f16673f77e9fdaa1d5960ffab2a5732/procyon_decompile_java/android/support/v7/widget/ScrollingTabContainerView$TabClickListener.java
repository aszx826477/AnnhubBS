// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.View;
import android.view.View$OnClickListener;

class ScrollingTabContainerView$TabClickListener implements View$OnClickListener
{
    final /* synthetic */ ScrollingTabContainerView this$0;
    
    ScrollingTabContainerView$TabClickListener(final ScrollingTabContainerView this$0) {
        this.this$0 = this$0;
    }
    
    public void onClick(final View view) {
        ((ScrollingTabContainerView$TabView)view).getTab().select();
        for (int childCount = this.this$0.mTabLayout.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.this$0.mTabLayout.getChildAt(i);
            child.setSelected(child == view);
        }
    }
}
