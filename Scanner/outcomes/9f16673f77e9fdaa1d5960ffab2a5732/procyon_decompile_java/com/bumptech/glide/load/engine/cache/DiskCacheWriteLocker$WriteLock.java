// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.cache;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

class DiskCacheWriteLocker$WriteLock
{
    int interestedThreads;
    final Lock lock;
    
    private DiskCacheWriteLocker$WriteLock() {
        this.lock = new ReentrantLock();
    }
}
