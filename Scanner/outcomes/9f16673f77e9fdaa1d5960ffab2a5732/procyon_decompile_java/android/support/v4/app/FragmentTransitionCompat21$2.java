// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.transition.Transition;
import android.view.View;
import java.util.ArrayList;
import android.transition.Transition$TransitionListener;

final class FragmentTransitionCompat21$2 implements Transition$TransitionListener
{
    final /* synthetic */ ArrayList val$exitingViews;
    final /* synthetic */ View val$fragmentView;
    
    FragmentTransitionCompat21$2(final View val$fragmentView, final ArrayList val$exitingViews) {
        this.val$fragmentView = val$fragmentView;
        this.val$exitingViews = val$exitingViews;
    }
    
    public void onTransitionCancel(final Transition transition) {
    }
    
    public void onTransitionEnd(final Transition transition) {
        transition.removeListener((Transition$TransitionListener)this);
        this.val$fragmentView.setVisibility(8);
        for (int size = this.val$exitingViews.size(), i = 0; i < size; ++i) {
            ((View)this.val$exitingViews.get(i)).setVisibility(0);
        }
    }
    
    public void onTransitionPause(final Transition transition) {
    }
    
    public void onTransitionResume(final Transition transition) {
    }
    
    public void onTransitionStart(final Transition transition) {
    }
}
