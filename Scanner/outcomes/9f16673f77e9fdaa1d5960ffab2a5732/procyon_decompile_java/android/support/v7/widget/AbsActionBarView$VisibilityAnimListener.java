// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R$styleable;
import android.content.res.Configuration;
import android.view.View$MeasureSpec;
import android.view.ContextThemeWrapper;
import android.support.v7.appcompat.R$attr;
import android.util.TypedValue;
import android.util.AttributeSet;
import android.content.Context;
import android.view.ViewGroup;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListener;

public class AbsActionBarView$VisibilityAnimListener implements ViewPropertyAnimatorListener
{
    private boolean mCanceled;
    int mFinalVisibility;
    final /* synthetic */ AbsActionBarView this$0;
    
    protected AbsActionBarView$VisibilityAnimListener(final AbsActionBarView this$0) {
        this.this$0 = this$0;
        this.mCanceled = false;
    }
    
    public void onAnimationCancel(final View view) {
        this.mCanceled = true;
    }
    
    public void onAnimationEnd(final View view) {
        if (this.mCanceled) {
            return;
        }
        final AbsActionBarView this$0 = this.this$0;
        this$0.mVisibilityAnim = null;
        AbsActionBarView.access$101(this$0, this.mFinalVisibility);
    }
    
    public void onAnimationStart(final View view) {
        AbsActionBarView.access$001(this.this$0, 0);
        this.mCanceled = false;
    }
    
    public AbsActionBarView$VisibilityAnimListener withFinalVisibility(final ViewPropertyAnimatorCompat mVisibilityAnim, final int mFinalVisibility) {
        this.this$0.mVisibilityAnim = mVisibilityAnim;
        this.mFinalVisibility = mFinalVisibility;
        return this;
    }
}
