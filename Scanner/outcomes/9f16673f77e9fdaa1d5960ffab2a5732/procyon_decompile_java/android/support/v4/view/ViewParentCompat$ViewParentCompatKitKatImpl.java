// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

class ViewParentCompat$ViewParentCompatKitKatImpl extends ViewParentCompat$ViewParentCompatICSImpl
{
    public void notifySubtreeAccessibilityStateChanged(final ViewParent viewParent, final View view, final View view2, final int n) {
        ViewParentCompatKitKat.notifySubtreeAccessibilityStateChanged(viewParent, view, view2, n);
    }
}
