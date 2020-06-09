// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.Iterator;
import com.bumptech.glide.util.Util;
import android.graphics.Bitmap;
import java.util.TreeMap;
import java.util.NavigableMap;
import java.util.HashMap;
import java.util.Map;
import android.graphics.Bitmap$Config;

final class SizeConfigStrategy$Key implements Poolable
{
    private Bitmap$Config config;
    private final SizeConfigStrategy$KeyPool pool;
    private int size;
    
    public SizeConfigStrategy$Key(final SizeConfigStrategy$KeyPool pool) {
        this.pool = pool;
    }
    
    SizeConfigStrategy$Key(final SizeConfigStrategy$KeyPool sizeConfigStrategy$KeyPool, final int n, final Bitmap$Config bitmap$Config) {
        this(sizeConfigStrategy$KeyPool);
        this.init(n, bitmap$Config);
    }
    
    public boolean equals(final Object o) {
        final boolean b = o instanceof SizeConfigStrategy$Key;
        boolean b2 = false;
        if (b) {
            final SizeConfigStrategy$Key sizeConfigStrategy$Key = (SizeConfigStrategy$Key)o;
            if (this.size == sizeConfigStrategy$Key.size) {
                final Bitmap$Config config = this.config;
                if (config == null) {
                    if (sizeConfigStrategy$Key.config != null) {
                        return b2;
                    }
                }
                else if (!config.equals((Object)sizeConfigStrategy$Key.config)) {
                    return b2;
                }
                b2 = true;
            }
            return b2;
        }
        return false;
    }
    
    public int hashCode() {
        final int n = this.size * 31;
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
    
    public void init(final int size, final Bitmap$Config config) {
        this.size = size;
        this.config = config;
    }
    
    public void offer() {
        this.pool.offer(this);
    }
    
    public String toString() {
        return getBitmapString(this.size, this.config);
    }
}
