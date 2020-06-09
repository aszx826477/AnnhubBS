// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;

public class ModelCache
{
    private static final int DEFAULT_SIZE = 250;
    private final LruCache cache;
    
    public ModelCache() {
        this(250);
    }
    
    public ModelCache(final int n) {
        this.cache = new ModelCache$1(this, n);
    }
    
    public Object get(final Object o, final int n, final int n2) {
        final ModelCache$ModelKey value = ModelCache$ModelKey.get(o, n, n2);
        final Object value2 = this.cache.get(value);
        value.release();
        return value2;
    }
    
    public void put(final Object o, final int n, final int n2, final Object o2) {
        this.cache.put(ModelCache$ModelKey.get(o, n, n2), o2);
    }
}
