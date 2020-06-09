// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Paint;
import android.view.ViewGroup$MarginLayoutParams;

public class SlidingPaneLayout$LayoutParams extends ViewGroup$MarginLayoutParams
{
    private static final int[] ATTRS;
    Paint dimPaint;
    boolean dimWhenOffset;
    boolean slideable;
    public float weight;
    
    static {
        ATTRS = new int[] { 16843137 };
    }
    
    public SlidingPaneLayout$LayoutParams() {
        final int n = -1;
        super(n, n);
        this.weight = 0.0f;
    }
    
    public SlidingPaneLayout$LayoutParams(final int n, final int n2) {
        super(n, n2);
        this.weight = 0.0f;
    }
    
    public SlidingPaneLayout$LayoutParams(final Context context, final AttributeSet set) {
        super(context, set);
        this.weight = 0.0f;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, SlidingPaneLayout$LayoutParams.ATTRS);
        this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
        obtainStyledAttributes.recycle();
    }
    
    public SlidingPaneLayout$LayoutParams(final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams) {
        super((ViewGroup$MarginLayoutParams)slidingPaneLayout$LayoutParams);
        this.weight = 0.0f;
        this.weight = slidingPaneLayout$LayoutParams.weight;
    }
    
    public SlidingPaneLayout$LayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.weight = 0.0f;
    }
    
    public SlidingPaneLayout$LayoutParams(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
        this.weight = 0.0f;
    }
}
