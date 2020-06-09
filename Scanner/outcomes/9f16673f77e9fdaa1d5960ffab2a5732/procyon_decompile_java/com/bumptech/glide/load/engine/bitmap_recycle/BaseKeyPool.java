// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.util.Util;
import java.util.Queue;

abstract class BaseKeyPool
{
    private static final int MAX_SIZE = 20;
    private final Queue keyPool;
    
    BaseKeyPool() {
        this.keyPool = Util.createQueue(20);
    }
    
    protected abstract Poolable create();
    
    protected Poolable get() {
        Poolable create = this.keyPool.poll();
        if (create == null) {
            create = this.create();
        }
        return create;
    }
    
    public void offer(final Poolable poolable) {
        if (this.keyPool.size() < 20) {
            this.keyPool.offer(poolable);
        }
    }
}
