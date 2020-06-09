// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.View;

class ScrollingTabContainerView$1 implements Runnable
{
    final /* synthetic */ ScrollingTabContainerView this$0;
    final /* synthetic */ View val$tabView;
    
    ScrollingTabContainerView$1(final ScrollingTabContainerView this$0, final View val$tabView) {
        this.this$0 = this$0;
        this.val$tabView = val$tabView;
    }
    
    public void run() {
        this.this$0.smoothScrollTo(this.val$tabView.getLeft() - (this.this$0.getWidth() - this.val$tabView.getWidth()) / 2, 0);
        this.this$0.mTabSelector = null;
    }
}
