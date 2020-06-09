// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.animation.ValueAnimator$AnimatorUpdateListener;

final class ViewPropertyAnimatorCompatKK$1 implements ValueAnimator$AnimatorUpdateListener
{
    final /* synthetic */ ViewPropertyAnimatorUpdateListener val$listener;
    final /* synthetic */ View val$view;
    
    ViewPropertyAnimatorCompatKK$1(final ViewPropertyAnimatorUpdateListener val$listener, final View val$view) {
        this.val$listener = val$listener;
        this.val$view = val$view;
    }
    
    public void onAnimationUpdate(final ValueAnimator valueAnimator) {
        this.val$listener.onAnimationUpdate(this.val$view);
    }
}
