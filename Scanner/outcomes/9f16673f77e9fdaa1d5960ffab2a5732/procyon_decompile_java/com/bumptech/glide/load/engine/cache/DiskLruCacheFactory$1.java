// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.cache;

import java.io.File;

class DiskLruCacheFactory$1 implements DiskLruCacheFactory$CacheDirectoryGetter
{
    final /* synthetic */ String val$diskCacheFolder;
    
    DiskLruCacheFactory$1(final String val$diskCacheFolder) {
        this.val$diskCacheFolder = val$diskCacheFolder;
    }
    
    public File getCacheDirectory() {
        return new File(this.val$diskCacheFolder);
    }
}
