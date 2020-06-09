// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

class SlidingPaneLayout$SlidingPanelLayoutImplBase implements SlidingPaneLayout$SlidingPanelLayoutImpl
{
    public void invalidateChildRegion(final SlidingPaneLayout slidingPaneLayout, final View view) {
        ViewCompat.postInvalidateOnAnimation((View)slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }
}
