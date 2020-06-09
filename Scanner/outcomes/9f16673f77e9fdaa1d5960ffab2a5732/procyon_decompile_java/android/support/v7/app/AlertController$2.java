// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.support.v4.widget.NestedScrollView$OnScrollChangeListener;

class AlertController$2 implements NestedScrollView$OnScrollChangeListener
{
    final /* synthetic */ AlertController this$0;
    final /* synthetic */ View val$bottom;
    final /* synthetic */ View val$top;
    
    AlertController$2(final AlertController this$0, final View val$top, final View val$bottom) {
        this.this$0 = this$0;
        this.val$top = val$top;
        this.val$bottom = val$bottom;
    }
    
    public void onScrollChange(final NestedScrollView nestedScrollView, final int n, final int n2, final int n3, final int n4) {
        AlertController.manageScrollIndicators((View)nestedScrollView, this.val$top, this.val$bottom);
    }
}
