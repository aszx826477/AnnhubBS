// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.graphics.Rect;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.LinearLayout;

public class FitWindowsLinearLayout extends LinearLayout implements FitWindowsViewGroup
{
    private FitWindowsViewGroup$OnFitSystemWindowsListener mListener;
    
    public FitWindowsLinearLayout(final Context context) {
        super(context);
    }
    
    public FitWindowsLinearLayout(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    protected boolean fitSystemWindows(final Rect rect) {
        final FitWindowsViewGroup$OnFitSystemWindowsListener mListener = this.mListener;
        if (mListener != null) {
            mListener.onFitSystemWindows(rect);
        }
        return super.fitSystemWindows(rect);
    }
    
    public void setOnFitSystemWindowsListener(final FitWindowsViewGroup$OnFitSystemWindowsListener mListener) {
        this.mListener = mListener;
    }
}
