// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

public class Pools$SynchronizedPool extends Pools$SimplePool
{
    private final Object mLock;
    
    public Pools$SynchronizedPool(final int n) {
        super(n);
        this.mLock = new Object();
    }
    
    public Object acquire() {
        synchronized (this.mLock) {
            return super.acquire();
        }
    }
    
    public boolean release(final Object o) {
        synchronized (this.mLock) {
            return super.release(o);
        }
    }
}
