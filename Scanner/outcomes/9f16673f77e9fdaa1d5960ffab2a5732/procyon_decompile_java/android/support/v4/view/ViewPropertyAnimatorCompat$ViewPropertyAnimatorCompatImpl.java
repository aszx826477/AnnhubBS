// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.animation.Interpolator;
import android.view.View;

interface ViewPropertyAnimatorCompat$ViewPropertyAnimatorCompatImpl
{
    void alpha(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void alphaBy(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void cancel(final ViewPropertyAnimatorCompat p0, final View p1);
    
    long getDuration(final ViewPropertyAnimatorCompat p0, final View p1);
    
    Interpolator getInterpolator(final ViewPropertyAnimatorCompat p0, final View p1);
    
    long getStartDelay(final ViewPropertyAnimatorCompat p0, final View p1);
    
    void rotation(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void rotationBy(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void rotationX(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void rotationXBy(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void rotationY(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void rotationYBy(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void scaleX(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void scaleXBy(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void scaleY(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void scaleYBy(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void setDuration(final ViewPropertyAnimatorCompat p0, final View p1, final long p2);
    
    void setInterpolator(final ViewPropertyAnimatorCompat p0, final View p1, final Interpolator p2);
    
    void setListener(final ViewPropertyAnimatorCompat p0, final View p1, final ViewPropertyAnimatorListener p2);
    
    void setStartDelay(final ViewPropertyAnimatorCompat p0, final View p1, final long p2);
    
    void setUpdateListener(final ViewPropertyAnimatorCompat p0, final View p1, final ViewPropertyAnimatorUpdateListener p2);
    
    void start(final ViewPropertyAnimatorCompat p0, final View p1);
    
    void translationX(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void translationXBy(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void translationY(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void translationYBy(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void translationZ(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void translationZBy(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void withEndAction(final ViewPropertyAnimatorCompat p0, final View p1, final Runnable p2);
    
    void withLayer(final ViewPropertyAnimatorCompat p0, final View p1);
    
    void withStartAction(final ViewPropertyAnimatorCompat p0, final View p1, final Runnable p2);
    
    void x(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void xBy(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void y(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void yBy(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void z(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
    
    void zBy(final ViewPropertyAnimatorCompat p0, final View p1, final float p2);
}
