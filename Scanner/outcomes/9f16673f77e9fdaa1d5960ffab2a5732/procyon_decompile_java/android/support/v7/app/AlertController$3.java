// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.view.View;

class AlertController$3 implements Runnable
{
    final /* synthetic */ AlertController this$0;
    final /* synthetic */ View val$bottom;
    final /* synthetic */ View val$top;
    
    AlertController$3(final AlertController this$0, final View val$top, final View val$bottom) {
        this.this$0 = this$0;
        this.val$top = val$top;
        this.val$bottom = val$bottom;
    }
    
    public void run() {
        AlertController.manageScrollIndicators((View)this.this$0.mScrollView, this.val$top, this.val$bottom);
    }
}
