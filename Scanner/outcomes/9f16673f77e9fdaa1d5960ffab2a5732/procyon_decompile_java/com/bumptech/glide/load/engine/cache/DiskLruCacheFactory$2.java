// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.cache;

import java.io.File;

class DiskLruCacheFactory$2 implements DiskLruCacheFactory$CacheDirectoryGetter
{
    final /* synthetic */ String val$diskCacheFolder;
    final /* synthetic */ String val$diskCacheName;
    
    DiskLruCacheFactory$2(final String val$diskCacheFolder, final String val$diskCacheName) {
        this.val$diskCacheFolder = val$diskCacheFolder;
        this.val$diskCacheName = val$diskCacheName;
    }
    
    public File getCacheDirectory() {
        return new File(this.val$diskCacheFolder, this.val$diskCacheName);
    }
}
