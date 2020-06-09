// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.animation.Transformation;
import android.view.animation.Animation;

class SwipeRefreshLayout$6 extends Animation
{
    final /* synthetic */ SwipeRefreshLayout this$0;
    
    SwipeRefreshLayout$6(final SwipeRefreshLayout this$0) {
        this.this$0 = this$0;
    }
    
    public void applyTransformation(final float n, final Transformation transformation) {
        int mSpinnerOffsetEnd;
        if (!this.this$0.mUsingCustomStart) {
            mSpinnerOffsetEnd = this.this$0.mSpinnerOffsetEnd - Math.abs(this.this$0.mOriginalOffsetTop);
        }
        else {
            mSpinnerOffsetEnd = this.this$0.mSpinnerOffsetEnd;
        }
        this.this$0.setTargetOffsetTopAndBottom(this.this$0.mFrom + (int)((mSpinnerOffsetEnd - this.this$0.mFrom) * n) - this.this$0.mCircleView.getTop(), false);
        this.this$0.mProgress.setArrowScale(1.0f - n);
    }
}
