// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap$Config;

public class PreFillType$Builder
{
    private Bitmap$Config config;
    private final int height;
    private int weight;
    private final int width;
    
    public PreFillType$Builder(final int n) {
        this(n, n);
    }
    
    public PreFillType$Builder(final int width, final int height) {
        this.weight = 1;
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be > 0");
        }
        if (height > 0) {
            this.width = width;
            this.height = height;
            return;
        }
        throw new IllegalArgumentException("Height must be > 0");
    }
    
    PreFillType build() {
        return new PreFillType(this.width, this.height, this.config, this.weight);
    }
    
    Bitmap$Config getConfig() {
        return this.config;
    }
    
    public PreFillType$Builder setConfig(final Bitmap$Config config) {
        this.config = config;
        return this;
    }
    
    public PreFillType$Builder setWeight(final int weight) {
        if (weight > 0) {
            this.weight = weight;
            return this;
        }
        throw new IllegalArgumentException("Weight must be > 0");
    }
}
