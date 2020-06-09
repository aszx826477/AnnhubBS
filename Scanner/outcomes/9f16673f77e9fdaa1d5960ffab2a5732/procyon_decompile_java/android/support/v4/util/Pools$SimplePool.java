// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

public class Pools$SimplePool implements Pools$Pool
{
    private final Object[] mPool;
    private int mPoolSize;
    
    public Pools$SimplePool(final int n) {
        if (n > 0) {
            this.mPool = new Object[n];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }
    
    private boolean isInPool(final Object o) {
        for (int i = 0; i < this.mPoolSize; ++i) {
            if (this.mPool[i] == o) {
                return true;
            }
        }
        return false;
    }
    
    public Object acquire() {
        final int mPoolSize = this.mPoolSize;
        if (mPoolSize > 0) {
            final int n = mPoolSize - 1;
            final Object[] mPool = this.mPool;
            final Object o = mPool[n];
            mPool[n] = null;
            this.mPoolSize = mPoolSize - 1;
            return o;
        }
        return null;
    }
    
    public boolean release(final Object o) {
        if (this.isInPool(o)) {
            throw new IllegalStateException("Already in the pool!");
        }
        final int mPoolSize = this.mPoolSize;
        final Object[] mPool = this.mPool;
        if (mPoolSize < mPool.length) {
            mPool[mPoolSize] = o;
            final int n = 1;
            this.mPoolSize = mPoolSize + n;
            return n != 0;
        }
        return false;
    }
}
