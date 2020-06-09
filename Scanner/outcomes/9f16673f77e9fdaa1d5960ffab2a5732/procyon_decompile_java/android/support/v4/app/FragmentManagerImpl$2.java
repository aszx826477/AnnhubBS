// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.view.animation.Animation;
import android.view.View;

class FragmentManagerImpl$2 extends FragmentManagerImpl$AnimateOnHWLayerIfNeededListener
{
    final /* synthetic */ FragmentManagerImpl this$0;
    final /* synthetic */ Fragment val$fragment;
    
    FragmentManagerImpl$2(final FragmentManagerImpl this$0, final View view, final Animation animation, final Fragment val$fragment) {
        this.this$0 = this$0;
        this.val$fragment = val$fragment;
        super(view, animation);
    }
    
    public void onAnimationEnd(final Animation animation) {
        super.onAnimationEnd(animation);
        if (this.val$fragment.getAnimatingAway() != null) {
            this.val$fragment.setAnimatingAway(null);
            final FragmentManagerImpl this$0 = this.this$0;
            final Fragment val$fragment = this.val$fragment;
            this$0.moveToState(val$fragment, val$fragment.getStateAfterAnimating(), 0, 0, false);
        }
    }
}
