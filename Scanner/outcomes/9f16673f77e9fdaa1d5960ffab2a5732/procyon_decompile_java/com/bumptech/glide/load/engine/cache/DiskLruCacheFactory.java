// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.cache;

import java.io.File;

public class DiskLruCacheFactory implements DiskCache$Factory
{
    private final DiskLruCacheFactory$CacheDirectoryGetter cacheDirectoryGetter;
    private final int diskCacheSize;
    
    public DiskLruCacheFactory(final DiskLruCacheFactory$CacheDirectoryGetter cacheDirectoryGetter, final int diskCacheSize) {
        this.diskCacheSize = diskCacheSize;
        this.cacheDirectoryGetter = cacheDirectoryGetter;
    }
    
    public DiskLruCacheFactory(final String s, final int n) {
        this(new DiskLruCacheFactory$1(s), n);
    }
    
    public DiskLruCacheFactory(final String s, final String s2, final int n) {
        this(new DiskLruCacheFactory$2(s, s2), n);
    }
    
    public DiskCache build() {
        final File cacheDirectory = this.cacheDirectoryGetter.getCacheDirectory();
        if (cacheDirectory == null) {
            return null;
        }
        if (!cacheDirectory.mkdirs() && (!cacheDirectory.exists() || !cacheDirectory.isDirectory())) {
            return null;
        }
        return DiskLruCacheWrapper.get(cacheDirectory, this.diskCacheSize);
    }
}
