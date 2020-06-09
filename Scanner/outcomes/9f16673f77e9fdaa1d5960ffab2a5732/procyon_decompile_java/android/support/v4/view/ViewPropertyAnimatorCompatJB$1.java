// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.animation.Animator;
import android.view.View;
import android.animation.AnimatorListenerAdapter;

final class ViewPropertyAnimatorCompatJB$1 extends AnimatorListenerAdapter
{
    final /* synthetic */ ViewPropertyAnimatorListener val$listener;
    final /* synthetic */ View val$view;
    
    ViewPropertyAnimatorCompatJB$1(final ViewPropertyAnimatorListener val$listener, final View val$view) {
        this.val$listener = val$listener;
        this.val$view = val$view;
    }
    
    public void onAnimationCancel(final Animator animator) {
        this.val$listener.onAnimationCancel(this.val$view);
    }
    
    public void onAnimationEnd(final Animator animator) {
        this.val$listener.onAnimationEnd(this.val$view);
    }
    
    public void onAnimationStart(final Animator animator) {
        this.val$listener.onAnimationStart(this.val$view);
    }
}
