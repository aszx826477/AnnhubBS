// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request;

class RequestFutureTarget$Waiter
{
    public void notifyAll(final Object o) {
        o.notifyAll();
    }
    
    public void waitForTimeout(final Object o, final long n) {
        o.wait(n);
    }
}
