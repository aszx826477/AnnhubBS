// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.DiskCache$Factory;
import com.bumptech.glide.load.engine.cache.DiskCache;

class Engine$LazyDiskCacheProvider implements DecodeJob$DiskCacheProvider
{
    private volatile DiskCache diskCache;
    private final DiskCache$Factory factory;
    
    public Engine$LazyDiskCacheProvider(final DiskCache$Factory factory) {
        this.factory = factory;
    }
    
    public DiskCache getDiskCache() {
        if (this.diskCache == null) {
            synchronized (this) {
                if (this.diskCache == null) {
                    this.diskCache = this.factory.build();
                }
                if (this.diskCache == null) {
                    this.diskCache = new DiskCacheAdapter();
                }
            }
        }
        return this.diskCache;
    }
}
