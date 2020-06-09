// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.LruCache;

public class LruResourceCache extends LruCache implements MemoryCache
{
    private MemoryCache$ResourceRemovedListener listener;
    
    public LruResourceCache(final int n) {
        super(n);
    }
    
    protected int getSize(final Resource resource) {
        return resource.getSize();
    }
    
    protected void onItemEvicted(final Key key, final Resource resource) {
        final MemoryCache$ResourceRemovedListener listener = this.listener;
        if (listener != null) {
            listener.onResourceRemoved(resource);
        }
    }
    
    public void setResourceRemovedListener(final MemoryCache$ResourceRemovedListener listener) {
        this.listener = listener;
    }
    
    public void trimMemory(final int n) {
        if (n >= 60) {
            this.clearMemory();
        }
        else if (n >= 40) {
            this.trimToSize(this.getCurrentSize() / 2);
        }
    }
}
