// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.cache;

import java.io.File;
import android.content.Context;

class ExternalCacheDiskCacheFactory$1 implements DiskLruCacheFactory$CacheDirectoryGetter
{
    final /* synthetic */ Context val$context;
    final /* synthetic */ String val$diskCacheName;
    
    ExternalCacheDiskCacheFactory$1(final Context val$context, final String val$diskCacheName) {
        this.val$context = val$context;
        this.val$diskCacheName = val$diskCacheName;
    }
    
    public File getCacheDirectory() {
        final File externalCacheDir = this.val$context.getExternalCacheDir();
        if (externalCacheDir == null) {
            return null;
        }
        final String val$diskCacheName = this.val$diskCacheName;
        if (val$diskCacheName != null) {
            return new File(externalCacheDir, val$diskCacheName);
        }
        return externalCacheDir;
    }
}
