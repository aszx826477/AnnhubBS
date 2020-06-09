// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v7.app.ActionBar$LayoutParams;

public class Toolbar$LayoutParams extends ActionBar$LayoutParams
{
    static final int CUSTOM = 0;
    static final int EXPANDED = 2;
    static final int SYSTEM = 1;
    int mViewType;
    
    public Toolbar$LayoutParams(final int n) {
        this(-2, -1, n);
    }
    
    public Toolbar$LayoutParams(final int n, final int n2) {
        super(n, n2);
        this.mViewType = 0;
        this.gravity = 8388627;
    }
    
    public Toolbar$LayoutParams(final int n, final int n2, final int gravity) {
        super(n, n2);
        this.mViewType = 0;
        this.gravity = gravity;
    }
    
    public Toolbar$LayoutParams(final Context context, final AttributeSet set) {
        super(context, set);
        this.mViewType = 0;
    }
    
    public Toolbar$LayoutParams(final ActionBar$LayoutParams actionBar$LayoutParams) {
        super(actionBar$LayoutParams);
        this.mViewType = 0;
    }
    
    public Toolbar$LayoutParams(final Toolbar$LayoutParams toolbar$LayoutParams) {
        super(toolbar$LayoutParams);
        this.mViewType = 0;
        this.mViewType = toolbar$LayoutParams.mViewType;
    }
    
    public Toolbar$LayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.mViewType = 0;
    }
    
    public Toolbar$LayoutParams(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super((ViewGroup$LayoutParams)viewGroup$MarginLayoutParams);
        this.mViewType = 0;
        this.copyMarginsFromCompat(viewGroup$MarginLayoutParams);
    }
    
    void copyMarginsFromCompat(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        this.leftMargin = viewGroup$MarginLayoutParams.leftMargin;
        this.topMargin = viewGroup$MarginLayoutParams.topMargin;
        this.rightMargin = viewGroup$MarginLayoutParams.rightMargin;
        this.bottomMargin = viewGroup$MarginLayoutParams.bottomMargin;
    }
}
