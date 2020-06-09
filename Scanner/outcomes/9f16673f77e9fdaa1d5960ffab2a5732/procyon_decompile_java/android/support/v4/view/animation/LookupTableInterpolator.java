// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator implements Interpolator
{
    private final float mStepSize;
    private final float[] mValues;
    
    public LookupTableInterpolator(final float[] mValues) {
        this.mValues = mValues;
        this.mStepSize = 1.0f / (this.mValues.length - 1);
    }
    
    public float getInterpolation(final float n) {
        final float n2 = 1.0f;
        if (n >= n2) {
            return n2;
        }
        if (n <= 0.0f) {
            return 0.0f;
        }
        final float[] mValues = this.mValues;
        final int min = Math.min((int)((mValues.length - 1) * n), mValues.length - 2);
        final float n3 = min;
        final float mStepSize = this.mStepSize;
        final float n4 = (n - n3 * mStepSize) / mStepSize;
        final float[] mValues2 = this.mValues;
        return mValues2[min] + (mValues2[min + 1] - mValues2[min]) * n4;
    }
}
