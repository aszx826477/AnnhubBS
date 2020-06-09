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
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.graphics.Rect;

final class FragmentTransition$3 implements Runnable
{
    final /* synthetic */ Rect val$epicenter;
    final /* synthetic */ View val$epicenterView;
    final /* synthetic */ Fragment val$inFragment;
    final /* synthetic */ boolean val$inIsPop;
    final /* synthetic */ ArrayMap val$inSharedElements;
    final /* synthetic */ Fragment val$outFragment;
    
    FragmentTransition$3(final Fragment val$inFragment, final Fragment val$outFragment, final boolean val$inIsPop, final ArrayMap val$inSharedElements, final View val$epicenterView, final Rect val$epicenter) {
        this.val$inFragment = val$inFragment;
        this.val$outFragment = val$outFragment;
        this.val$inIsPop = val$inIsPop;
        this.val$inSharedElements = val$inSharedElements;
        this.val$epicenterView = val$epicenterView;
        this.val$epicenter = val$epicenter;
    }
    
    public void run() {
        callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, this.val$inSharedElements, false);
        final View val$epicenterView = this.val$epicenterView;
        if (val$epicenterView != null) {
            FragmentTransitionCompat21.getBoundsOnScreen(val$epicenterView, this.val$epicenter);
        }
    }
}
