// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.animation.TimeInterpolator;

class HoneycombMr1AnimatorCompatProvider implements AnimatorProvider
{
    private TimeInterpolator mDefaultInterpolator;
    
    public void clearInterpolator(final View view) {
        if (this.mDefaultInterpolator == null) {
            this.mDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.mDefaultInterpolator);
    }
    
    public ValueAnimatorCompat emptyValueAnimator() {
        final float[] array2;
        final float[] array = array2 = new float[2];
        array2[0] = 0.0f;
        array2[1] = 1.0f;
        return new HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat((Animator)ValueAnimator.ofFloat(array));
    }
}
