// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.view.View;

class SlidingPaneLayout$DisableLayerRunnable implements Runnable
{
    final View mChildView;
    final /* synthetic */ SlidingPaneLayout this$0;
    
    SlidingPaneLayout$DisableLayerRunnable(final SlidingPaneLayout this$0, final View mChildView) {
        this.this$0 = this$0;
        this.mChildView = mChildView;
    }
    
    public void run() {
        if (this.mChildView.getParent() == this.this$0) {
            ViewCompat.setLayerType(this.mChildView, 0, null);
            this.this$0.invalidateChildRegion(this.mChildView);
        }
        this.this$0.mPostedRunnables.remove(this);
    }
}
