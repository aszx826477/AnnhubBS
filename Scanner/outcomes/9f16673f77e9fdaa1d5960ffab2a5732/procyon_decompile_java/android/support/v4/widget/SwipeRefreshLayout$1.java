// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;

class SwipeRefreshLayout$1 implements Animation$AnimationListener
{
    final /* synthetic */ SwipeRefreshLayout this$0;
    
    SwipeRefreshLayout$1(final SwipeRefreshLayout this$0) {
        this.this$0 = this$0;
    }
    
    public void onAnimationEnd(final Animation animation) {
        if (this.this$0.mRefreshing) {
            this.this$0.mProgress.setAlpha(255);
            this.this$0.mProgress.start();
            if (this.this$0.mNotify) {
                if (this.this$0.mListener != null) {
                    this.this$0.mListener.onRefresh();
                }
            }
            final SwipeRefreshLayout this$0 = this.this$0;
            this$0.mCurrentTargetOffsetTop = this$0.mCircleView.getTop();
        }
        else {
            this.this$0.reset();
        }
    }
    
    public void onAnimationRepeat(final Animation animation) {
    }
    
    public void onAnimationStart(final Animation animation) {
    }
}
