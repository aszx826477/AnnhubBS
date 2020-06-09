// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap$Config;

public final class PreFillType
{
    static final Bitmap$Config DEFAULT_CONFIG;
    private final Bitmap$Config config;
    private final int height;
    private final int weight;
    private final int width;
    
    static {
        DEFAULT_CONFIG = Bitmap$Config.RGB_565;
    }
    
    PreFillType(final int width, final int height, final Bitmap$Config config, final int weight) {
        if (config != null) {
            this.width = width;
            this.height = height;
            this.config = config;
            this.weight = weight;
            return;
        }
        throw new NullPointerException("Config must not be null");
    }
    
    public boolean equals(final Object o) {
        final boolean b = o instanceof PreFillType;
        boolean b2 = false;
        if (b) {
            final PreFillType preFillType = (PreFillType)o;
            if (this.height == preFillType.height && this.width == preFillType.width && this.weight == preFillType.weight && this.config == preFillType.config) {
                b2 = true;
            }
            return b2;
        }
        return false;
    }
    
    Bitmap$Config getConfig() {
        return this.config;
    }
    
    int getHeight() {
        return this.height;
    }
    
    int getWeight() {
        return this.weight;
    }
    
    int getWidth() {
        return this.width;
    }
    
    public int hashCode() {
        return ((this.width * 31 + this.height) * 31 + this.config.hashCode()) * 31 + this.weight;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PreFillSize{width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", config=");
        sb.append(this.config);
        sb.append(", weight=");
        sb.append(this.weight);
        sb.append('}');
        return sb.toString();
    }
}
