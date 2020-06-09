// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.view.ViewGroup$LayoutParams;

public class ViewPager$LayoutParams extends ViewGroup$LayoutParams
{
    int childIndex;
    public int gravity;
    public boolean isDecor;
    boolean needsMeasure;
    int position;
    float widthFactor;
    
    public ViewPager$LayoutParams() {
        final int n = -1;
        super(n, n);
        this.widthFactor = 0.0f;
    }
    
    public ViewPager$LayoutParams(final Context context, final AttributeSet set) {
        super(context, set);
        this.widthFactor = 0.0f;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, ViewPager.LAYOUT_ATTRS);
        this.gravity = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
