// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;

class ViewCompat$MarshmallowViewCompatImpl extends ViewCompat$LollipopViewCompatImpl
{
    public int getScrollIndicators(final View view) {
        return ViewCompatMarshmallow.getScrollIndicators(view);
    }
    
    public void offsetLeftAndRight(final View view, final int n) {
        ViewCompatMarshmallow.offsetLeftAndRight(view, n);
    }
    
    public void offsetTopAndBottom(final View view, final int n) {
        ViewCompatMarshmallow.offsetTopAndBottom(view, n);
    }
    
    public void setScrollIndicators(final View view, final int n) {
        ViewCompatMarshmallow.setScrollIndicators(view, n);
    }
    
    public void setScrollIndicators(final View view, final int n, final int n2) {
        ViewCompatMarshmallow.setScrollIndicators(view, n, n2);
    }
}
