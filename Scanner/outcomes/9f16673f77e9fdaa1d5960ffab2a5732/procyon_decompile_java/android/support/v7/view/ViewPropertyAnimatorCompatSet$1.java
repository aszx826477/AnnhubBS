// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view;

import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;

class ViewPropertyAnimatorCompatSet$1 extends ViewPropertyAnimatorListenerAdapter
{
    private int mProxyEndCount;
    private boolean mProxyStarted;
    final /* synthetic */ ViewPropertyAnimatorCompatSet this$0;
    
    ViewPropertyAnimatorCompatSet$1(final ViewPropertyAnimatorCompatSet this$0) {
        this.this$0 = this$0;
        this.mProxyStarted = false;
        this.mProxyEndCount = 0;
    }
    
    public void onAnimationEnd(final View view) {
        final int mProxyEndCount = this.mProxyEndCount + 1;
        this.mProxyEndCount = mProxyEndCount;
        if (mProxyEndCount == this.this$0.mAnimators.size()) {
            if (this.this$0.mListener != null) {
                this.this$0.mListener.onAnimationEnd(null);
            }
            this.onEnd();
        }
    }
    
    public void onAnimationStart(final View view) {
        if (this.mProxyStarted) {
            return;
        }
        this.mProxyStarted = true;
        if (this.this$0.mListener != null) {
            this.this$0.mListener.onAnimationStart(null);
        }
    }
    
    void onEnd() {
        this.mProxyEndCount = 0;
        this.mProxyStarted = false;
        this.this$0.onAnimationsEnded();
    }
}
