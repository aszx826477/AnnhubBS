// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.transition.Transition;
import android.graphics.Rect;
import android.transition.Transition$EpicenterCallback;

final class FragmentTransitionCompat21$1 extends Transition$EpicenterCallback
{
    final /* synthetic */ Rect val$epicenter;
    
    FragmentTransitionCompat21$1(final Rect val$epicenter) {
        this.val$epicenter = val$epicenter;
    }
    
    public Rect onGetEpicenter(final Transition transition) {
        return this.val$epicenter;
    }
}
