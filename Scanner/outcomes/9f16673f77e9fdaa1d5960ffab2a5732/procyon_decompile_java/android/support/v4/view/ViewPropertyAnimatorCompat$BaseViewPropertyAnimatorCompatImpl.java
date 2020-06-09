// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.animation.Interpolator;
import android.view.View;
import java.util.WeakHashMap;

class ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl implements ViewPropertyAnimatorCompat$ViewPropertyAnimatorCompatImpl
{
    WeakHashMap mStarterMap;
    
    ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl() {
        this.mStarterMap = null;
    }
    
    private void postStartMessage(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view) {
        Runnable runnable = null;
        final WeakHashMap mStarterMap = this.mStarterMap;
        if (mStarterMap != null) {
            runnable = mStarterMap.get(view);
        }
        if (runnable == null) {
            runnable = new ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl$Starter(this, viewPropertyAnimatorCompat, view);
            if (this.mStarterMap == null) {
                this.mStarterMap = new WeakHashMap();
            }
            this.mStarterMap.put(view, runnable);
        }
        view.removeCallbacks(runnable);
        view.post(runnable);
    }
    
    private void removeStartMessage(final View view) {
        final WeakHashMap mStarterMap = this.mStarterMap;
        if (mStarterMap != null) {
            final Runnable runnable = mStarterMap.get(view);
            if (runnable != null) {
                view.removeCallbacks(runnable);
            }
        }
    }
    
    public void alpha(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void alphaBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void cancel(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public long getDuration(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view) {
        return 0L;
    }
    
    public Interpolator getInterpolator(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view) {
        return null;
    }
    
    public long getStartDelay(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view) {
        return 0L;
    }
    
    public void rotation(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void rotationBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void rotationX(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void rotationXBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void rotationY(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void rotationYBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void scaleX(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void scaleXBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void scaleY(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void scaleYBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void setDuration(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final long n) {
    }
    
    public void setInterpolator(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final Interpolator interpolator) {
    }
    
    public void setListener(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        view.setTag(2113929216, (Object)viewPropertyAnimatorListener);
    }
    
    public void setStartDelay(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final long n) {
    }
    
    public void setUpdateListener(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
    }
    
    public void start(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view) {
        this.removeStartMessage(view);
        this.startAnimation(viewPropertyAnimatorCompat, view);
    }
    
    void startAnimation(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view) {
        final Object tag = view.getTag(2113929216);
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
        if (tag instanceof ViewPropertyAnimatorListener) {
            viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)tag;
        }
        final Runnable mStartAction = viewPropertyAnimatorCompat.mStartAction;
        final Runnable mEndAction = viewPropertyAnimatorCompat.mEndAction;
        viewPropertyAnimatorCompat.mStartAction = null;
        viewPropertyAnimatorCompat.mEndAction = null;
        if (mStartAction != null) {
            mStartAction.run();
        }
        if (viewPropertyAnimatorListener != null) {
            viewPropertyAnimatorListener.onAnimationStart(view);
            viewPropertyAnimatorListener.onAnimationEnd(view);
        }
        if (mEndAction != null) {
            mEndAction.run();
        }
        final WeakHashMap mStarterMap = this.mStarterMap;
        if (mStarterMap != null) {
            mStarterMap.remove(view);
        }
    }
    
    public void translationX(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void translationXBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void translationY(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void translationYBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void translationZ(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
    }
    
    public void translationZBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
    }
    
    public void withEndAction(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final Runnable mEndAction) {
        viewPropertyAnimatorCompat.mEndAction = mEndAction;
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void withLayer(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view) {
    }
    
    public void withStartAction(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final Runnable mStartAction) {
        viewPropertyAnimatorCompat.mStartAction = mStartAction;
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void x(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void xBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void y(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void yBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
        this.postStartMessage(viewPropertyAnimatorCompat, view);
    }
    
    public void z(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
    }
    
    public void zBy(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final float n) {
    }
}
