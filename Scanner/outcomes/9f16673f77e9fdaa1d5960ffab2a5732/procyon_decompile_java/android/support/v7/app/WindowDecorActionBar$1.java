// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;

class WindowDecorActionBar$1 extends ViewPropertyAnimatorListenerAdapter
{
    final /* synthetic */ WindowDecorActionBar this$0;
    
    WindowDecorActionBar$1(final WindowDecorActionBar this$0) {
        this.this$0 = this$0;
    }
    
    public void onAnimationEnd(final View view) {
        if (this.this$0.mContentAnimations && this.this$0.mContentView != null) {
            ViewCompat.setTranslationY(this.this$0.mContentView, 0.0f);
            ViewCompat.setTranslationY((View)this.this$0.mContainerView, 0.0f);
        }
        this.this$0.mContainerView.setVisibility(8);
        this.this$0.mContainerView.setTransitioning(false);
        final WindowDecorActionBar this$0 = this.this$0;
        this$0.mCurrentShowAnim = null;
        this$0.completeDeferredDestroyActionMode();
        if (this.this$0.mOverlayLayout != null) {
            ViewCompat.requestApplyInsets((View)this.this$0.mOverlayLayout);
        }
    }
}
