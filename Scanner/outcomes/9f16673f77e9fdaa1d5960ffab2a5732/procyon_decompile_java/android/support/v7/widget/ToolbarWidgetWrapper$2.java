// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;

class ToolbarWidgetWrapper$2 extends ViewPropertyAnimatorListenerAdapter
{
    private boolean mCanceled;
    final /* synthetic */ ToolbarWidgetWrapper this$0;
    final /* synthetic */ int val$visibility;
    
    ToolbarWidgetWrapper$2(final ToolbarWidgetWrapper this$0, final int val$visibility) {
        this.this$0 = this$0;
        this.val$visibility = val$visibility;
        this.mCanceled = false;
    }
    
    public void onAnimationCancel(final View view) {
        this.mCanceled = true;
    }
    
    public void onAnimationEnd(final View view) {
        if (!this.mCanceled) {
            this.this$0.mToolbar.setVisibility(this.val$visibility);
        }
    }
    
    public void onAnimationStart(final View view) {
        this.this$0.mToolbar.setVisibility(0);
    }
}
