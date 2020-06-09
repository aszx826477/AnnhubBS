// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.util.SparseArray;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import android.widget.FrameLayout;

class NoSaveStateFrameLayout extends FrameLayout
{
    public NoSaveStateFrameLayout(final Context context) {
        super(context);
    }
    
    static ViewGroup wrap(final View view) {
        final NoSaveStateFrameLayout noSaveStateFrameLayout = new NoSaveStateFrameLayout(view.getContext());
        final ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            noSaveStateFrameLayout.setLayoutParams(layoutParams);
        }
        final int n = -1;
        view.setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(n, n));
        noSaveStateFrameLayout.addView(view);
        return (ViewGroup)noSaveStateFrameLayout;
    }
    
    protected void dispatchRestoreInstanceState(final SparseArray sparseArray) {
        this.dispatchThawSelfOnly(sparseArray);
    }
    
    protected void dispatchSaveInstanceState(final SparseArray sparseArray) {
        this.dispatchFreezeSelfOnly(sparseArray);
    }
}
