// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.ViewGroup$LayoutParams;
import android.util.AttributeSet;
import android.content.Context;

public class ActionMenuView$LayoutParams extends LinearLayoutCompat$LayoutParams
{
    public int cellsUsed;
    public boolean expandable;
    boolean expanded;
    public int extraPixels;
    public boolean isOverflowButton;
    public boolean preventEdgeOffset;
    
    public ActionMenuView$LayoutParams(final int n, final int n2) {
        super(n, n2);
        this.isOverflowButton = false;
    }
    
    ActionMenuView$LayoutParams(final int n, final int n2, final boolean isOverflowButton) {
        super(n, n2);
        this.isOverflowButton = isOverflowButton;
    }
    
    public ActionMenuView$LayoutParams(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public ActionMenuView$LayoutParams(final ActionMenuView$LayoutParams actionMenuView$LayoutParams) {
        super((ViewGroup$LayoutParams)actionMenuView$LayoutParams);
        this.isOverflowButton = actionMenuView$LayoutParams.isOverflowButton;
    }
    
    public ActionMenuView$LayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
    }
}
