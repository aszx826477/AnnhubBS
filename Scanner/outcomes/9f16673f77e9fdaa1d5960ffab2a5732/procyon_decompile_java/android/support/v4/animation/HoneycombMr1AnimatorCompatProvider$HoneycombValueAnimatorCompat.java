// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.animation;

import android.view.View;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.animation.Animator$AnimatorListener;
import android.animation.Animator;

class HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat implements ValueAnimatorCompat
{
    final Animator mWrapped;
    
    public HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat(final Animator mWrapped) {
        this.mWrapped = mWrapped;
    }
    
    public void addListener(final AnimatorListenerCompat animatorListenerCompat) {
        this.mWrapped.addListener((Animator$AnimatorListener)new HoneycombMr1AnimatorCompatProvider$AnimatorListenerCompatWrapper(animatorListenerCompat, this));
    }
    
    public void addUpdateListener(final AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
        final Animator mWrapped = this.mWrapped;
        if (mWrapped instanceof ValueAnimator) {
            ((ValueAnimator)mWrapped).addUpdateListener((ValueAnimator$AnimatorUpdateListener)new HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat$1(this, animatorUpdateListenerCompat));
        }
    }
    
    public void cancel() {
        this.mWrapped.cancel();
    }
    
    public float getAnimatedFraction() {
        return ((ValueAnimator)this.mWrapped).getAnimatedFraction();
    }
    
    public void setDuration(final long duration) {
        this.mWrapped.setDuration(duration);
    }
    
    public void setTarget(final View target) {
        this.mWrapped.setTarget((Object)target);
    }
    
    public void start() {
        this.mWrapped.start();
    }
}
