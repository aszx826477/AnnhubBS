// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.os.Build$VERSION;
import android.graphics.Paint;
import android.view.View;

class ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener implements ViewPropertyAnimatorListener
{
    boolean mAnimEndCalled;
    ViewPropertyAnimatorCompat mVpa;
    
    ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener(final ViewPropertyAnimatorCompat mVpa) {
        this.mVpa = mVpa;
    }
    
    public void onAnimationCancel(final View view) {
        final Object tag = view.getTag(2113929216);
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
        if (tag instanceof ViewPropertyAnimatorListener) {
            viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)tag;
        }
        if (viewPropertyAnimatorListener != null) {
            viewPropertyAnimatorListener.onAnimationCancel(view);
        }
    }
    
    public void onAnimationEnd(final View view) {
        if (this.mVpa.mOldLayerType >= 0) {
            ViewCompat.setLayerType(view, this.mVpa.mOldLayerType, null);
            this.mVpa.mOldLayerType = -1;
        }
        if (Build$VERSION.SDK_INT >= 16 || this.mAnimEndCalled) {
            if (this.mVpa.mEndAction != null) {
                final Runnable mEndAction = this.mVpa.mEndAction;
                this.mVpa.mEndAction = null;
                mEndAction.run();
            }
            final Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
            if (tag instanceof ViewPropertyAnimatorListener) {
                viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)tag;
            }
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationEnd(view);
            }
            this.mAnimEndCalled = true;
        }
    }
    
    public void onAnimationStart(final View view) {
        this.mAnimEndCalled = false;
        if (this.mVpa.mOldLayerType >= 0) {
            ViewCompat.setLayerType(view, 2, null);
        }
        if (this.mVpa.mStartAction != null) {
            final Runnable mStartAction = this.mVpa.mStartAction;
            this.mVpa.mStartAction = null;
            mStartAction.run();
        }
        final Object tag = view.getTag(2113929216);
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
        if (tag instanceof ViewPropertyAnimatorListener) {
            viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)tag;
        }
        if (viewPropertyAnimatorListener != null) {
            viewPropertyAnimatorListener.onAnimationStart(view);
        }
    }
}
