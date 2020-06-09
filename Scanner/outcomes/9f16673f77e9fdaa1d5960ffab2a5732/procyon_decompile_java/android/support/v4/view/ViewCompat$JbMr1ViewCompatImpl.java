// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.graphics.Paint;
import android.view.Display;
import android.view.View;

class ViewCompat$JbMr1ViewCompatImpl extends ViewCompat$JBViewCompatImpl
{
    public Display getDisplay(final View view) {
        return ViewCompatJellybeanMr1.getDisplay(view);
    }
    
    public int getLabelFor(final View view) {
        return ViewCompatJellybeanMr1.getLabelFor(view);
    }
    
    public int getLayoutDirection(final View view) {
        return ViewCompatJellybeanMr1.getLayoutDirection(view);
    }
    
    public int getPaddingEnd(final View view) {
        return ViewCompatJellybeanMr1.getPaddingEnd(view);
    }
    
    public int getPaddingStart(final View view) {
        return ViewCompatJellybeanMr1.getPaddingStart(view);
    }
    
    public int getWindowSystemUiVisibility(final View view) {
        return ViewCompatJellybeanMr1.getWindowSystemUiVisibility(view);
    }
    
    public boolean isPaddingRelative(final View view) {
        return ViewCompatJellybeanMr1.isPaddingRelative(view);
    }
    
    public void setLabelFor(final View view, final int n) {
        ViewCompatJellybeanMr1.setLabelFor(view, n);
    }
    
    public void setLayerPaint(final View view, final Paint paint) {
        ViewCompatJellybeanMr1.setLayerPaint(view, paint);
    }
    
    public void setLayoutDirection(final View view, final int n) {
        ViewCompatJellybeanMr1.setLayoutDirection(view, n);
    }
    
    public void setPaddingRelative(final View view, final int n, final int n2, final int n3, final int n4) {
        ViewCompatJellybeanMr1.setPaddingRelative(view, n, n2, n3, n4);
    }
}
