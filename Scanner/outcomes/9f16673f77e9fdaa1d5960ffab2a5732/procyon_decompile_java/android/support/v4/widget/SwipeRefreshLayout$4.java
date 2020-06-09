// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.animation.Transformation;
import android.view.animation.Animation;

class SwipeRefreshLayout$4 extends Animation
{
    final /* synthetic */ SwipeRefreshLayout this$0;
    final /* synthetic */ int val$endingAlpha;
    final /* synthetic */ int val$startingAlpha;
    
    SwipeRefreshLayout$4(final SwipeRefreshLayout this$0, final int val$startingAlpha, final int val$endingAlpha) {
        this.this$0 = this$0;
        this.val$startingAlpha = val$startingAlpha;
        this.val$endingAlpha = val$endingAlpha;
    }
    
    public void applyTransformation(final float n, final Transformation transformation) {
        final MaterialProgressDrawable mProgress = this.this$0.mProgress;
        final int val$startingAlpha = this.val$startingAlpha;
        mProgress.setAlpha((int)(val$startingAlpha + (this.val$endingAlpha - val$startingAlpha) * n));
    }
}
