// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.animation.Animator$AnimatorListener;
import android.view.View;

class ViewPropertyAnimatorCompatJB
{
    public static void setListener(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener((Animator$AnimatorListener)new ViewPropertyAnimatorCompatJB$1(viewPropertyAnimatorListener, view));
        }
        else {
            view.animate().setListener((Animator$AnimatorListener)null);
        }
    }
    
    public static void withEndAction(final View view, final Runnable runnable) {
        view.animate().withEndAction(runnable);
    }
    
    public static void withLayer(final View view) {
        view.animate().withLayer();
    }
    
    public static void withStartAction(final View view, final Runnable runnable) {
        view.animate().withStartAction(runnable);
    }
}
