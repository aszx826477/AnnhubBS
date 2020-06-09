// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.transition.Transition;
import java.util.ArrayList;
import android.transition.Transition$TransitionListener;

final class FragmentTransitionCompat21$5 implements Transition$TransitionListener
{
    final /* synthetic */ Object val$enterTransition;
    final /* synthetic */ ArrayList val$enteringViews;
    final /* synthetic */ Object val$exitTransition;
    final /* synthetic */ ArrayList val$exitingViews;
    final /* synthetic */ Object val$sharedElementTransition;
    final /* synthetic */ ArrayList val$sharedElementsIn;
    
    FragmentTransitionCompat21$5(final Object val$enterTransition, final ArrayList val$enteringViews, final Object val$exitTransition, final ArrayList val$exitingViews, final Object val$sharedElementTransition, final ArrayList val$sharedElementsIn) {
        this.val$enterTransition = val$enterTransition;
        this.val$enteringViews = val$enteringViews;
        this.val$exitTransition = val$exitTransition;
        this.val$exitingViews = val$exitingViews;
        this.val$sharedElementTransition = val$sharedElementTransition;
        this.val$sharedElementsIn = val$sharedElementsIn;
    }
    
    public void onTransitionCancel(final Transition transition) {
    }
    
    public void onTransitionEnd(final Transition transition) {
    }
    
    public void onTransitionPause(final Transition transition) {
    }
    
    public void onTransitionResume(final Transition transition) {
    }
    
    public void onTransitionStart(final Transition transition) {
        final Object val$enterTransition = this.val$enterTransition;
        if (val$enterTransition != null) {
            FragmentTransitionCompat21.replaceTargets(val$enterTransition, this.val$enteringViews, null);
        }
        final Object val$exitTransition = this.val$exitTransition;
        if (val$exitTransition != null) {
            FragmentTransitionCompat21.replaceTargets(val$exitTransition, this.val$exitingViews, null);
        }
        final Object val$sharedElementTransition = this.val$sharedElementTransition;
        if (val$sharedElementTransition != null) {
            FragmentTransitionCompat21.replaceTargets(val$sharedElementTransition, this.val$sharedElementsIn, null);
        }
    }
}
