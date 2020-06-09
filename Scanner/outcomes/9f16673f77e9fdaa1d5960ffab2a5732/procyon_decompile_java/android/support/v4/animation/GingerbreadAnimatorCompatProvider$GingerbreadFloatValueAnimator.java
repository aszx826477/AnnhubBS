// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.animation;

import java.util.ArrayList;
import android.view.View;
import java.util.List;

class GingerbreadAnimatorCompatProvider$GingerbreadFloatValueAnimator implements ValueAnimatorCompat
{
    private long mDuration;
    private boolean mEnded;
    private float mFraction;
    List mListeners;
    private Runnable mLoopRunnable;
    private long mStartTime;
    private boolean mStarted;
    View mTarget;
    List mUpdateListeners;
    
    public GingerbreadAnimatorCompatProvider$GingerbreadFloatValueAnimator() {
        this.mListeners = new ArrayList();
        this.mUpdateListeners = new ArrayList();
        this.mDuration = 200L;
        this.mFraction = 0.0f;
        this.mStarted = false;
        this.mEnded = false;
        this.mLoopRunnable = new GingerbreadAnimatorCompatProvider$GingerbreadFloatValueAnimator$1(this);
    }
    
    private void dispatchCancel() {
        for (int i = this.mListeners.size() - 1; i >= 0; --i) {
            ((AnimatorListenerCompat)this.mListeners.get(i)).onAnimationCancel(this);
        }
    }
    
    private void dispatchEnd() {
        for (int i = this.mListeners.size() - 1; i >= 0; --i) {
            ((AnimatorListenerCompat)this.mListeners.get(i)).onAnimationEnd(this);
        }
    }
    
    private void dispatchStart() {
        for (int i = this.mListeners.size() - 1; i >= 0; --i) {
            ((AnimatorListenerCompat)this.mListeners.get(i)).onAnimationStart(this);
        }
    }
    
    private long getTime() {
        return this.mTarget.getDrawingTime();
    }
    
    private void notifyUpdateListeners() {
        for (int i = this.mUpdateListeners.size() - 1; i >= 0; --i) {
            ((AnimatorUpdateListenerCompat)this.mUpdateListeners.get(i)).onAnimationUpdate(this);
        }
    }
    
    public void addListener(final AnimatorListenerCompat animatorListenerCompat) {
        this.mListeners.add(animatorListenerCompat);
    }
    
    public void addUpdateListener(final AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
        this.mUpdateListeners.add(animatorUpdateListenerCompat);
    }
    
    public void cancel() {
        if (this.mEnded) {
            return;
        }
        this.mEnded = true;
        if (this.mStarted) {
            this.dispatchCancel();
        }
        this.dispatchEnd();
    }
    
    public float getAnimatedFraction() {
        return this.mFraction;
    }
    
    public void setDuration(final long mDuration) {
        if (!this.mStarted) {
            this.mDuration = mDuration;
        }
    }
    
    public void setTarget(final View mTarget) {
        this.mTarget = mTarget;
    }
    
    public void start() {
        if (this.mStarted) {
            return;
        }
        this.mStarted = true;
        this.dispatchStart();
        this.mFraction = 0.0f;
        this.mStartTime = this.getTime();
        this.mTarget.postDelayed(this.mLoopRunnable, (long)16);
    }
}
