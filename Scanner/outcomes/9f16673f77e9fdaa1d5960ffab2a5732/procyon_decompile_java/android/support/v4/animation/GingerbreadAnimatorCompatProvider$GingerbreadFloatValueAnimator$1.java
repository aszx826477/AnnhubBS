// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.animation;

import java.util.ArrayList;
import android.view.View;
import java.util.List;

class GingerbreadAnimatorCompatProvider$GingerbreadFloatValueAnimator$1 implements Runnable
{
    final /* synthetic */ GingerbreadAnimatorCompatProvider$GingerbreadFloatValueAnimator this$0;
    
    GingerbreadAnimatorCompatProvider$GingerbreadFloatValueAnimator$1(final GingerbreadAnimatorCompatProvider$GingerbreadFloatValueAnimator this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        final float n = this.this$0.getTime() - this.this$0.mStartTime;
        final float n2 = 1.0f;
        float n3 = n * n2 / this.this$0.mDuration;
        if (n3 > n2 || this.this$0.mTarget.getParent() == null) {
            n3 = 1.0f;
        }
        this.this$0.mFraction = n3;
        this.this$0.notifyUpdateListeners();
        if (this.this$0.mFraction >= n2) {
            this.this$0.dispatchEnd();
        }
        else {
            this.this$0.mTarget.postDelayed(this.this$0.mLoopRunnable, (long)16);
        }
    }
}
