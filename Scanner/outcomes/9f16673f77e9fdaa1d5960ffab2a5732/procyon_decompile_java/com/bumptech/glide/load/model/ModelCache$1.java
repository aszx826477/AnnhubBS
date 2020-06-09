// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;

class ModelCache$1 extends LruCache
{
    final /* synthetic */ ModelCache this$0;
    
    ModelCache$1(final ModelCache this$0, final int n) {
        this.this$0 = this$0;
        super(n);
    }
    
    protected void onItemEvicted(final ModelCache$ModelKey modelCache$ModelKey, final Object o) {
        modelCache$ModelKey.release();
    }
}
