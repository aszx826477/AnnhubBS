// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Build$VERSION;
import android.view.ViewGroup;
import java.util.Map;
import java.util.List;
import android.util.SparseArray;
import android.support.v4.view.ViewCompat;
import java.util.Collection;
import java.util.ArrayList;
import android.view.View;
import android.support.v4.util.ArrayMap;
import android.graphics.Rect;

final class FragmentTransition$4 implements Runnable
{
    final /* synthetic */ Object val$enterTransition;
    final /* synthetic */ Object val$finalSharedElementTransition;
    final /* synthetic */ FragmentTransition$FragmentContainerTransition val$fragments;
    final /* synthetic */ Rect val$inEpicenter;
    final /* synthetic */ Fragment val$inFragment;
    final /* synthetic */ boolean val$inIsPop;
    final /* synthetic */ ArrayMap val$nameOverrides;
    final /* synthetic */ View val$nonExistentView;
    final /* synthetic */ Fragment val$outFragment;
    final /* synthetic */ ArrayList val$sharedElementsIn;
    final /* synthetic */ ArrayList val$sharedElementsOut;
    
    FragmentTransition$4(final ArrayMap val$nameOverrides, final Object val$finalSharedElementTransition, final FragmentTransition$FragmentContainerTransition val$fragments, final ArrayList val$sharedElementsIn, final View val$nonExistentView, final Fragment val$inFragment, final Fragment val$outFragment, final boolean val$inIsPop, final ArrayList val$sharedElementsOut, final Object val$enterTransition, final Rect val$inEpicenter) {
        this.val$nameOverrides = val$nameOverrides;
        this.val$finalSharedElementTransition = val$finalSharedElementTransition;
        this.val$fragments = val$fragments;
        this.val$sharedElementsIn = val$sharedElementsIn;
        this.val$nonExistentView = val$nonExistentView;
        this.val$inFragment = val$inFragment;
        this.val$outFragment = val$outFragment;
        this.val$inIsPop = val$inIsPop;
        this.val$sharedElementsOut = val$sharedElementsOut;
        this.val$enterTransition = val$enterTransition;
        this.val$inEpicenter = val$inEpicenter;
    }
    
    public void run() {
        final ArrayMap access$300 = captureInSharedElements(this.val$nameOverrides, this.val$finalSharedElementTransition, this.val$fragments);
        if (access$300 != null) {
            this.val$sharedElementsIn.addAll(access$300.values());
            this.val$sharedElementsIn.add(this.val$nonExistentView);
        }
        callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, access$300, false);
        final Object val$finalSharedElementTransition = this.val$finalSharedElementTransition;
        if (val$finalSharedElementTransition != null) {
            FragmentTransitionCompat21.swapSharedElementTargets(val$finalSharedElementTransition, this.val$sharedElementsOut, this.val$sharedElementsIn);
            final View access$301 = getInEpicenterView(access$300, this.val$fragments, this.val$enterTransition, this.val$inIsPop);
            if (access$301 != null) {
                FragmentTransitionCompat21.getBoundsOnScreen(access$301, this.val$inEpicenter);
            }
        }
    }
}
