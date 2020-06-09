// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.animation.Interpolator;
import android.view.View;

class ViewPropertyAnimatorCompat$JBMr2ViewPropertyAnimatorCompatImpl extends ViewPropertyAnimatorCompat$JBViewPropertyAnimatorCompatImpl
{
    public Interpolator getInterpolator(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view) {
        return ViewPropertyAnimatorCompatJellybeanMr2.getInterpolator(view);
    }
}
