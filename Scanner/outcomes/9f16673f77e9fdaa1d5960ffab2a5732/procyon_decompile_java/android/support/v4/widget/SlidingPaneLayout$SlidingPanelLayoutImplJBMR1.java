// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

class SlidingPaneLayout$SlidingPanelLayoutImplJBMR1 extends SlidingPaneLayout$SlidingPanelLayoutImplBase
{
    public void invalidateChildRegion(final SlidingPaneLayout slidingPaneLayout, final View view) {
        ViewCompat.setLayerPaint(view, ((SlidingPaneLayout$LayoutParams)view.getLayoutParams()).dimPaint);
    }
}
