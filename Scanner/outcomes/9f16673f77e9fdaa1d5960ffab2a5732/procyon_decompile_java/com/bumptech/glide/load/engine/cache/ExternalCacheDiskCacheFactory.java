// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.cache;

import android.content.Context;

public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory
{
    public ExternalCacheDiskCacheFactory(final Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }
    
    public ExternalCacheDiskCacheFactory(final Context context, final int n) {
        this(context, "image_manager_disk_cache", n);
    }
    
    public ExternalCacheDiskCacheFactory(final Context context, final String s, final int n) {
        super(new ExternalCacheDiskCacheFactory$1(context, s), n);
    }
}
