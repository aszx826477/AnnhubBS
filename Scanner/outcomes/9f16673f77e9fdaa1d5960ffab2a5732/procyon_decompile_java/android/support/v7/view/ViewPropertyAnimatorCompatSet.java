// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view;

import java.util.Iterator;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.animation.Interpolator;
import java.util.ArrayList;

public class ViewPropertyAnimatorCompatSet
{
    final ArrayList mAnimators;
    private long mDuration;
    private Interpolator mInterpolator;
    private boolean mIsStarted;
    ViewPropertyAnimatorListener mListener;
    private final ViewPropertyAnimatorListenerAdapter mProxyListener;
    
    public ViewPropertyAnimatorCompatSet() {
        this.mDuration = -1;
        this.mProxyListener = new ViewPropertyAnimatorCompatSet$1(this);
        this.mAnimators = new ArrayList();
    }
    
    public void cancel() {
        if (!this.mIsStarted) {
            return;
        }
        final Iterator<ViewPropertyAnimatorCompat> iterator = this.mAnimators.iterator();
        while (iterator.hasNext()) {
            iterator.next().cancel();
        }
        this.mIsStarted = false;
    }
    
    void onAnimationsEnded() {
        this.mIsStarted = false;
    }
    
    public ViewPropertyAnimatorCompatSet play(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.mIsStarted) {
            this.mAnimators.add(viewPropertyAnimatorCompat);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompatSet playSequentially(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.mAnimators.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.mAnimators.add(viewPropertyAnimatorCompat2);
        return this;
    }
    
    public ViewPropertyAnimatorCompatSet setDuration(final long mDuration) {
        if (!this.mIsStarted) {
            this.mDuration = mDuration;
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompatSet setInterpolator(final Interpolator mInterpolator) {
        if (!this.mIsStarted) {
            this.mInterpolator = mInterpolator;
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompatSet setListener(final ViewPropertyAnimatorListener mListener) {
        if (!this.mIsStarted) {
            this.mListener = mListener;
        }
        return this;
    }
    
    public void start() {
        if (this.mIsStarted) {
            return;
        }
        for (final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat : this.mAnimators) {
            final long mDuration = this.mDuration;
            if (mDuration >= 0L) {
                viewPropertyAnimatorCompat.setDuration(mDuration);
            }
            final Interpolator mInterpolator = this.mInterpolator;
            if (mInterpolator != null) {
                viewPropertyAnimatorCompat.setInterpolator(mInterpolator);
            }
            if (this.mListener != null) {
                viewPropertyAnimatorCompat.setListener(this.mProxyListener);
            }
            viewPropertyAnimatorCompat.start();
        }
        this.mIsStarted = true;
    }
}
