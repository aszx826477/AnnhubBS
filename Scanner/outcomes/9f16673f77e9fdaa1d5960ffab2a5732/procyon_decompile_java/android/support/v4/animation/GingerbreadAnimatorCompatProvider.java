// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.animation;

import android.view.View;

class GingerbreadAnimatorCompatProvider implements AnimatorProvider
{
    public void clearInterpolator(final View view) {
    }
    
    public ValueAnimatorCompat emptyValueAnimator() {
        return new GingerbreadAnimatorCompatProvider$GingerbreadFloatValueAnimator();
    }
}
