// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.cache;

import android.util.DisplayMetrics;

class MemorySizeCalculator$DisplayMetricsScreenDimensions implements MemorySizeCalculator$ScreenDimensions
{
    private final DisplayMetrics displayMetrics;
    
    public MemorySizeCalculator$DisplayMetricsScreenDimensions(final DisplayMetrics displayMetrics) {
        this.displayMetrics = displayMetrics;
    }
    
    public int getHeightPixels() {
        return this.displayMetrics.heightPixels;
    }
    
    public int getWidthPixels() {
        return this.displayMetrics.widthPixels;
    }
}
