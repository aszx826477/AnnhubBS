// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R$styleable;
import android.util.AttributeSet;
import android.content.Context;
import android.view.ViewGroup$MarginLayoutParams;

public class LinearLayoutCompat$LayoutParams extends ViewGroup$MarginLayoutParams
{
    public int gravity;
    public float weight;
    
    public LinearLayoutCompat$LayoutParams(final int n, final int n2) {
        super(n, n2);
        this.gravity = -1;
        this.weight = 0.0f;
    }
    
    public LinearLayoutCompat$LayoutParams(final int n, final int n2, final float weight) {
        super(n, n2);
        this.gravity = -1;
        this.weight = weight;
    }
    
    public LinearLayoutCompat$LayoutParams(final Context context, final AttributeSet set) {
        super(context, set);
        final int gravity = -1;
        this.gravity = gravity;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R$styleable.LinearLayoutCompat_Layout);
        this.weight = obtainStyledAttributes.getFloat(R$styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
        this.gravity = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_Layout_android_layout_gravity, gravity);
        obtainStyledAttributes.recycle();
    }
    
    public LinearLayoutCompat$LayoutParams(final LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams) {
        super((ViewGroup$MarginLayoutParams)linearLayoutCompat$LayoutParams);
        this.gravity = -1;
        this.weight = linearLayoutCompat$LayoutParams.weight;
        this.gravity = linearLayoutCompat$LayoutParams.gravity;
    }
    
    public LinearLayoutCompat$LayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.gravity = -1;
    }
    
    public LinearLayoutCompat$LayoutParams(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
        this.gravity = -1;
    }
}
