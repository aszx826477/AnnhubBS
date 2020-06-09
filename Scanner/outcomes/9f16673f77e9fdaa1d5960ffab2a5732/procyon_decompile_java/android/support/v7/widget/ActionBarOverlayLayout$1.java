// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;

class ActionBarOverlayLayout$1 extends ViewPropertyAnimatorListenerAdapter
{
    final /* synthetic */ ActionBarOverlayLayout this$0;
    
    ActionBarOverlayLayout$1(final ActionBarOverlayLayout this$0) {
        this.this$0 = this$0;
    }
    
    public void onAnimationCancel(final View view) {
        final ActionBarOverlayLayout this$0 = this.this$0;
        this$0.mCurrentActionBarTopAnimator = null;
        this$0.mAnimatingForFling = false;
    }
    
    public void onAnimationEnd(final View view) {
        final ActionBarOverlayLayout this$0 = this.this$0;
        this$0.mCurrentActionBarTopAnimator = null;
        this$0.mAnimatingForFling = false;
    }
}
