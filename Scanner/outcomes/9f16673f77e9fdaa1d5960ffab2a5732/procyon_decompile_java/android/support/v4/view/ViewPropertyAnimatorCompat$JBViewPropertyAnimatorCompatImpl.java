// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;

class ViewPropertyAnimatorCompat$JBViewPropertyAnimatorCompatImpl extends ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl
{
    public void setListener(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        ViewPropertyAnimatorCompatJB.setListener(view, viewPropertyAnimatorListener);
    }
    
    public void withEndAction(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final Runnable runnable) {
        ViewPropertyAnimatorCompatJB.withEndAction(view, runnable);
    }
    
    public void withLayer(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view) {
        ViewPropertyAnimatorCompatJB.withLayer(view);
    }
    
    public void withStartAction(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final Runnable runnable) {
        ViewPropertyAnimatorCompatJB.withStartAction(view, runnable);
    }
}
