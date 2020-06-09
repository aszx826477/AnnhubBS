// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;

final class DiskCacheWriteLocker
{
    private final Map locks;
    private final DiskCacheWriteLocker$WriteLockPool writeLockPool;
    
    DiskCacheWriteLocker() {
        this.locks = new HashMap();
        this.writeLockPool = new DiskCacheWriteLocker$WriteLockPool(null);
    }
    
    void acquire(final Key key) {
        synchronized (this) {
            DiskCacheWriteLocker$WriteLock obtain;
            if ((obtain = this.locks.get(key)) == null) {
                obtain = this.writeLockPool.obtain();
                this.locks.put(key, obtain);
            }
            ++obtain.interestedThreads;
            // monitorexit(this)
            obtain.lock.lock();
        }
    }
    
    void release(final Key key) {
        synchronized (this) {
            final DiskCacheWriteLocker$WriteLock diskCacheWriteLocker$WriteLock2;
            final DiskCacheWriteLocker$WriteLock diskCacheWriteLocker$WriteLock = diskCacheWriteLocker$WriteLock2 = this.locks.get(key);
            if (diskCacheWriteLocker$WriteLock != null && diskCacheWriteLocker$WriteLock.interestedThreads > 0) {
                if (--diskCacheWriteLocker$WriteLock.interestedThreads == 0) {
                    final DiskCacheWriteLocker$WriteLock diskCacheWriteLocker$WriteLock3 = this.locks.remove(key);
                    if (!diskCacheWriteLocker$WriteLock3.equals(diskCacheWriteLocker$WriteLock2)) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Removed the wrong lock, expected to remove: ");
                        sb.append(diskCacheWriteLocker$WriteLock2);
                        sb.append(", but actually removed: ");
                        sb.append(diskCacheWriteLocker$WriteLock3);
                        sb.append(", key: ");
                        sb.append(key);
                        throw new IllegalStateException(sb.toString());
                    }
                    this.writeLockPool.offer(diskCacheWriteLocker$WriteLock3);
                }
                // monitorexit(this)
                diskCacheWriteLocker$WriteLock2.lock.unlock();
                return;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot release a lock that is not held, key: ");
            sb2.append(key);
            sb2.append(", interestedThreads: ");
            int interestedThreads;
            if (diskCacheWriteLocker$WriteLock2 == null) {
                interestedThreads = 0;
            }
            else {
                interestedThreads = diskCacheWriteLocker$WriteLock2.interestedThreads;
            }
            sb2.append(interestedThreads);
            throw new IllegalArgumentException(sb2.toString());
        }
    }
}
