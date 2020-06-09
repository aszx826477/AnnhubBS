// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.util;

import java.util.Map;
import java.util.LinkedHashMap;

public class LruCache
{
    private final LinkedHashMap cache;
    private int currentSize;
    private final int initialMaxSize;
    private int maxSize;
    
    public LruCache(final int n) {
        this.cache = new LinkedHashMap(100, 0.75f, true);
        this.currentSize = 0;
        this.initialMaxSize = n;
        this.maxSize = n;
    }
    
    private void evict() {
        this.trimToSize(this.maxSize);
    }
    
    public void clearMemory() {
        this.trimToSize(0);
    }
    
    public boolean contains(final Object o) {
        return this.cache.containsKey(o);
    }
    
    public Object get(final Object o) {
        return this.cache.get(o);
    }
    
    public int getCurrentSize() {
        return this.currentSize;
    }
    
    public int getMaxSize() {
        return this.maxSize;
    }
    
    protected int getSize(final Object o) {
        return 1;
    }
    
    protected void onItemEvicted(final Object o, final Object o2) {
    }
    
    public Object put(final Object o, final Object o2) {
        if (this.getSize(o2) >= this.maxSize) {
            this.onItemEvicted(o, o2);
            return null;
        }
        final Object put = this.cache.put(o, o2);
        if (o2 != null) {
            this.currentSize += this.getSize(o2);
        }
        if (put != null) {
            this.currentSize -= this.getSize(put);
        }
        this.evict();
        return put;
    }
    
    public Object remove(final Object o) {
        final Object remove = this.cache.remove(o);
        if (remove != null) {
            this.currentSize -= this.getSize(remove);
        }
        return remove;
    }
    
    public void setSizeMultiplier(final float n) {
        if (n >= 0.0f) {
            this.maxSize = Math.round(this.initialMaxSize * n);
            this.evict();
            return;
        }
        throw new IllegalArgumentException("Multiplier must be >= 0");
    }
    
    protected void trimToSize(final int n) {
        while (this.currentSize > n) {
            final Map.Entry<K, Object> entry = this.cache.entrySet().iterator().next();
            final Object value = entry.getValue();
            this.currentSize -= this.getSize(value);
            final K key = entry.getKey();
            this.cache.remove(key);
            this.onItemEvicted(key, value);
        }
    }
}
