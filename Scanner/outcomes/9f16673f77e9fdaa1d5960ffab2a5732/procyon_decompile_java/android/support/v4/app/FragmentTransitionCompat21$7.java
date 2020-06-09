// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.view.View;
import java.util.ArrayList;
import java.util.Map;

final class FragmentTransitionCompat21$7 implements Runnable
{
    final /* synthetic */ Map val$nameOverrides;
    final /* synthetic */ ArrayList val$sharedElementsIn;
    
    FragmentTransitionCompat21$7(final ArrayList val$sharedElementsIn, final Map val$nameOverrides) {
        this.val$sharedElementsIn = val$sharedElementsIn;
        this.val$nameOverrides = val$nameOverrides;
    }
    
    public void run() {
        for (int size = this.val$sharedElementsIn.size(), i = 0; i < size; ++i) {
            final View view = this.val$sharedElementsIn.get(i);
            view.setTransitionName((String)this.val$nameOverrides.get(view.getTransitionName()));
        }
    }
}
