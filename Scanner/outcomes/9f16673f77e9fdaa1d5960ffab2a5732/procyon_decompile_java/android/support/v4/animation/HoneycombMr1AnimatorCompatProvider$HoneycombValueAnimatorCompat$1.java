// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.animation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;

class HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat$1 implements ValueAnimator$AnimatorUpdateListener
{
    final /* synthetic */ HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat this$0;
    final /* synthetic */ AnimatorUpdateListenerCompat val$animatorUpdateListener;
    
    HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat$1(final HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat this$0, final AnimatorUpdateListenerCompat val$animatorUpdateListener) {
        this.this$0 = this$0;
        this.val$animatorUpdateListener = val$animatorUpdateListener;
    }
    
    public void onAnimationUpdate(final ValueAnimator valueAnimator) {
        this.val$animatorUpdateListener.onAnimationUpdate(this.this$0);
    }
}
