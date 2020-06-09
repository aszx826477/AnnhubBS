// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.Key;

public class MemoryCacheAdapter implements MemoryCache
{
    private MemoryCache$ResourceRemovedListener listener;
    
    public void clearMemory() {
    }
    
    public int getCurrentSize() {
        return 0;
    }
    
    public int getMaxSize() {
        return 0;
    }
    
    public Resource put(final Key key, final Resource resource) {
        this.listener.onResourceRemoved(resource);
        return null;
    }
    
    public Resource remove(final Key key) {
        return null;
    }
    
    public void setResourceRemovedListener(final MemoryCache$ResourceRemovedListener listener) {
        this.listener = listener;
    }
    
    public void setSizeMultiplier(final float n) {
    }
    
    public void trimMemory(final int n) {
    }
}
