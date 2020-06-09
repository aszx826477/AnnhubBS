// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.util.Util;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;

class AttributeStrategy$Key implements Poolable
{
    private Bitmap$Config config;
    private int height;
    private final AttributeStrategy$KeyPool pool;
    private int width;
    
    public AttributeStrategy$Key(final AttributeStrategy$KeyPool pool) {
        this.pool = pool;
    }
    
    public boolean equals(final Object o) {
        final boolean b = o instanceof AttributeStrategy$Key;
        boolean b2 = false;
        if (b) {
            final AttributeStrategy$Key attributeStrategy$Key = (AttributeStrategy$Key)o;
            if (this.width == attributeStrategy$Key.width && this.height == attributeStrategy$Key.height && this.config == attributeStrategy$Key.config) {
                b2 = true;
            }
            return b2;
        }
        return false;
    }
    
    public int hashCode() {
        final int n = (this.width * 31 + this.height) * 31;
        final Bitmap$Config config = this.config;
        int hashCode;
        if (config != null) {
            hashCode = config.hashCode();
        }
        else {
            hashCode = 0;
        }
        return n + hashCode;
    }
    
    public void init(final int width, final int height, final Bitmap$Config config) {
        this.width = width;
        this.height = height;
        this.config = config;
    }
    
    public void offer() {
        this.pool.offer(this);
    }
    
    public String toString() {
        return getBitmapString(this.width, this.height, this.config);
    }
}
