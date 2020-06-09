// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.cache;

import java.util.ArrayDeque;
import java.util.Queue;

class DiskCacheWriteLocker$WriteLockPool
{
    private static final int MAX_POOL_SIZE = 10;
    private final Queue pool;
    
    private DiskCacheWriteLocker$WriteLockPool() {
        this.pool = new ArrayDeque();
    }
    
    DiskCacheWriteLocker$WriteLock obtain() {
        Object pool = this.pool;
        // monitorenter(pool)
        try {
            DiskCacheWriteLocker$WriteLock diskCacheWriteLocker$WriteLock = this.pool.poll();
            try {
                // monitorexit(pool)
                if (diskCacheWriteLocker$WriteLock == null) {
                    pool = (diskCacheWriteLocker$WriteLock = new DiskCacheWriteLocker$WriteLock(null));
                }
                return diskCacheWriteLocker$WriteLock;
            }
            finally {}
        }
        finally {}
    }
    // monitorexit(pool)
    
    void offer(final DiskCacheWriteLocker$WriteLock diskCacheWriteLocker$WriteLock) {
        synchronized (this.pool) {
            if (this.pool.size() < 10) {
                this.pool.offer(diskCacheWriteLocker$WriteLock);
            }
        }
    }
}
