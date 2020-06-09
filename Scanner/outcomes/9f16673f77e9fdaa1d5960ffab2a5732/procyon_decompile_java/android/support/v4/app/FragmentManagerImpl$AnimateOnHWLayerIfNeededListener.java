// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.graphics.Paint;
import android.support.v4.os.BuildCompat;
import android.support.v4.view.ViewCompat;
import android.view.animation.Animation;
import android.view.View;
import android.view.animation.Animation$AnimationListener;

class FragmentManagerImpl$AnimateOnHWLayerIfNeededListener implements Animation$AnimationListener
{
    private Animation$AnimationListener mOriginalListener;
    private boolean mShouldRunOnHWLayer;
    View mView;
    
    public FragmentManagerImpl$AnimateOnHWLayerIfNeededListener(final View mView, final Animation animation) {
        if (mView != null && animation != null) {
            this.mView = mView;
        }
    }
    
    public FragmentManagerImpl$AnimateOnHWLayerIfNeededListener(final View mView, final Animation animation, final Animation$AnimationListener mOriginalListener) {
        if (mView != null && animation != null) {
            this.mOriginalListener = mOriginalListener;
            this.mView = mView;
            this.mShouldRunOnHWLayer = true;
        }
    }
    
    public void onAnimationEnd(final Animation animation) {
        final View mView = this.mView;
        if (mView != null && this.mShouldRunOnHWLayer) {
            if (!ViewCompat.isAttachedToWindow(mView) && !BuildCompat.isAtLeastN()) {
                ViewCompat.setLayerType(this.mView, 0, null);
            }
            else {
                this.mView.post((Runnable)new FragmentManagerImpl$AnimateOnHWLayerIfNeededListener$1(this));
            }
        }
        final Animation$AnimationListener mOriginalListener = this.mOriginalListener;
        if (mOriginalListener != null) {
            mOriginalListener.onAnimationEnd(animation);
        }
    }
    
    public void onAnimationRepeat(final Animation animation) {
        final Animation$AnimationListener mOriginalListener = this.mOriginalListener;
        if (mOriginalListener != null) {
            mOriginalListener.onAnimationRepeat(animation);
        }
    }
    
    public void onAnimationStart(final Animation animation) {
        final Animation$AnimationListener mOriginalListener = this.mOriginalListener;
        if (mOriginalListener != null) {
            mOriginalListener.onAnimationStart(animation);
        }
    }
}
