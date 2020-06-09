// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.cache;

import android.content.Context;

public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory
{
    public InternalCacheDiskCacheFactory(final Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }
    
    public InternalCacheDiskCacheFactory(final Context context, final int n) {
        this(context, "image_manager_disk_cache", n);
    }
    
    public InternalCacheDiskCacheFactory(final Context context, final String s, final int n) {
        super(new InternalCacheDiskCacheFactory$1(context, s), n);
    }
}
