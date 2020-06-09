// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.animation.Transformation;
import android.view.animation.Animation;

class SwipeRefreshLayout$8 extends Animation
{
    final /* synthetic */ SwipeRefreshLayout this$0;
    
    SwipeRefreshLayout$8(final SwipeRefreshLayout this$0) {
        this.this$0 = this$0;
    }
    
    public void applyTransformation(final float n, final Transformation transformation) {
        this.this$0.setAnimationProgress(this.this$0.mStartingScale + -this.this$0.mStartingScale * n);
        this.this$0.moveToStart(n);
    }
}
