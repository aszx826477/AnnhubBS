// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.widget.AbsListView;
import android.view.View;
import android.widget.AbsListView$OnScrollListener;

class AlertController$4 implements AbsListView$OnScrollListener
{
    final /* synthetic */ AlertController this$0;
    final /* synthetic */ View val$bottom;
    final /* synthetic */ View val$top;
    
    AlertController$4(final AlertController this$0, final View val$top, final View val$bottom) {
        this.this$0 = this$0;
        this.val$top = val$top;
        this.val$bottom = val$bottom;
    }
    
    public void onScroll(final AbsListView absListView, final int n, final int n2, final int n3) {
        AlertController.manageScrollIndicators((View)absListView, this.val$top, this.val$bottom);
    }
    
    public void onScrollStateChanged(final AbsListView absListView, final int n) {
    }
}
