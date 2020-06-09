// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCache$Factory;

class GlideBuilder$1 implements DiskCache$Factory
{
    final /* synthetic */ GlideBuilder this$0;
    final /* synthetic */ DiskCache val$diskCache;
    
    GlideBuilder$1(final GlideBuilder this$0, final DiskCache val$diskCache) {
        this.this$0 = this$0;
        this.val$diskCache = val$diskCache;
    }
    
    public DiskCache build() {
        return this.val$diskCache;
    }
}
