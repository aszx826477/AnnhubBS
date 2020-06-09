// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.ViewGroup$MarginLayoutParams;

class MarginLayoutParamsCompat$MarginLayoutParamsCompatImplBase implements MarginLayoutParamsCompat$MarginLayoutParamsCompatImpl
{
    public int getLayoutDirection(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        return 0;
    }
    
    public int getMarginEnd(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        return viewGroup$MarginLayoutParams.rightMargin;
    }
    
    public int getMarginStart(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        return viewGroup$MarginLayoutParams.leftMargin;
    }
    
    public boolean isMarginRelative(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        return false;
    }
    
    public void resolveLayoutDirection(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, final int n) {
    }
    
    public void setLayoutDirection(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, final int n) {
    }
    
    public void setMarginEnd(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, final int rightMargin) {
        viewGroup$MarginLayoutParams.rightMargin = rightMargin;
    }
    
    public void setMarginStart(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, final int leftMargin) {
        viewGroup$MarginLayoutParams.leftMargin = leftMargin;
    }
}
