// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import android.os.Looper;
import com.bumptech.glide.load.Key;

class EngineResource implements Resource
{
    private int acquired;
    private final boolean isCacheable;
    private boolean isRecycled;
    private Key key;
    private EngineResource$ResourceListener listener;
    private final Resource resource;
    
    EngineResource(final Resource resource, final boolean isCacheable) {
        if (resource != null) {
            this.resource = resource;
            this.isCacheable = isCacheable;
            return;
        }
        throw new NullPointerException("Wrapped resource must not be null");
    }
    
    void acquire() {
        if (this.isRecycled) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            ++this.acquired;
            return;
        }
        throw new IllegalThreadStateException("Must call acquire on the main thread");
    }
    
    public Object get() {
        return this.resource.get();
    }
    
    public int getSize() {
        return this.resource.getSize();
    }
    
    boolean isCacheable() {
        return this.isCacheable;
    }
    
    public void recycle() {
        if (this.acquired > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (!this.isRecycled) {
            this.isRecycled = true;
            this.resource.recycle();
            return;
        }
        throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
    }
    
    void release() {
        if (this.acquired <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            if (--this.acquired == 0) {
                this.listener.onResourceReleased(this.key, this);
            }
            return;
        }
        throw new IllegalThreadStateException("Must call release on the main thread");
    }
    
    void setResourceListener(final Key key, final EngineResource$ResourceListener listener) {
        this.key = key;
        this.listener = listener;
    }
}
