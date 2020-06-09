// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.animation.Interpolator;
import android.view.View;
import java.util.WeakHashMap;

class ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl extends ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl
{
    WeakHashMap mLayerMap;
    
    ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl() {
        this.mLayerMap = null;
    }
    
    public void alpha(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.alpha(view, n);
    }
    
    public void alphaBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.alphaBy(view, n);
    }
    
    public void cancel(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view) {
        ViewPropertyAnimatorCompatICS.cancel(view);
    }
    
    public long getDuration(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view) {
        return ViewPropertyAnimatorCompatICS.getDuration(view);
    }
    
    public long getStartDelay(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view) {
        return ViewPropertyAnimatorCompatICS.getStartDelay(view);
    }
    
    public void rotation(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.rotation(view, n);
    }
    
    public void rotationBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.rotationBy(view, n);
    }
    
    public void rotationX(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.rotationX(view, n);
    }
    
    public void rotationXBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.rotationXBy(view, n);
    }
    
    public void rotationY(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.rotationY(view, n);
    }
    
    public void rotationYBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.rotationYBy(view, n);
    }
    
    public void scaleX(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.scaleX(view, n);
    }
    
    public void scaleXBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.scaleXBy(view, n);
    }
    
    public void scaleY(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.scaleY(view, n);
    }
    
    public void scaleYBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.scaleYBy(view, n);
    }
    
    public void setDuration(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final long n) {
        ViewPropertyAnimatorCompatICS.setDuration(view, n);
    }
    
    public void setInterpolator(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final Interpolator interpolator) {
        ViewPropertyAnimatorCompatICS.setInterpolator(view, interpolator);
    }
    
    public void setListener(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        view.setTag(2113929216, (Object)viewPropertyAnimatorListener);
        ViewPropertyAnimatorCompatICS.setListener(view, new ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener(viewPropertyAnimatorCompat));
    }
    
    public void setStartDelay(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final long n) {
        ViewPropertyAnimatorCompatICS.setStartDelay(view, n);
    }
    
    public void start(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view) {
        ViewPropertyAnimatorCompatICS.start(view);
    }
    
    public void translationX(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.translationX(view, n);
    }
    
    public void translationXBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.translationXBy(view, n);
    }
    
    public void translationY(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.translationY(view, n);
    }
    
    public void translationYBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.translationYBy(view, n);
    }
    
    public void withEndAction(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final Runnable mEndAction) {
        ViewPropertyAnimatorCompatICS.setListener(view, new ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener(viewPropertyAnimatorCompat));
        viewPropertyAnimatorCompat.mEndAction = mEndAction;
    }
    
    public void withLayer(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view) {
        viewPropertyAnimatorCompat.mOldLayerType = ViewCompat.getLayerType(view);
        ViewPropertyAnimatorCompatICS.setListener(view, new ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener(viewPropertyAnimatorCompat));
    }
    
    public void withStartAction(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final Runnable mStartAction) {
        ViewPropertyAnimatorCompatICS.setListener(view, new ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener(viewPropertyAnimatorCompat));
        viewPropertyAnimatorCompat.mStartAction = mStartAction;
    }
    
    public void x(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.x(view, n);
    }
    
    public void xBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.xBy(view, n);
    }
    
    public void y(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.y(view, n);
    }
    
    public void yBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        ViewPropertyAnimatorCompatICS.yBy(view, n);
    }
}
