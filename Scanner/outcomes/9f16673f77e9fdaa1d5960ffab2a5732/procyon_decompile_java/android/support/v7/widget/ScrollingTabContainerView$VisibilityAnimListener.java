// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListener;

public class ScrollingTabContainerView$VisibilityAnimListener implements ViewPropertyAnimatorListener
{
    private boolean mCanceled;
    private int mFinalVisibility;
    final /* synthetic */ ScrollingTabContainerView this$0;
    
    protected ScrollingTabContainerView$VisibilityAnimListener(final ScrollingTabContainerView this$0) {
        this.this$0 = this$0;
        this.mCanceled = false;
    }
    
    public void onAnimationCancel(final View view) {
        this.mCanceled = true;
    }
    
    public void onAnimationEnd(final View view) {
        if (this.mCanceled) {
            return;
        }
        final ScrollingTabContainerView this$0 = this.this$0;
        this$0.mVisibilityAnim = null;
        this$0.setVisibility(this.mFinalVisibility);
    }
    
    public void onAnimationStart(final View view) {
        this.this$0.setVisibility(0);
        this.mCanceled = false;
    }
    
    public ScrollingTabContainerView$VisibilityAnimListener withFinalVisibility(final ViewPropertyAnimatorCompat mVisibilityAnim, final int mFinalVisibility) {
        this.mFinalVisibility = mFinalVisibility;
        this.this$0.mVisibilityAnim = mVisibilityAnim;
        return this;
    }
}
