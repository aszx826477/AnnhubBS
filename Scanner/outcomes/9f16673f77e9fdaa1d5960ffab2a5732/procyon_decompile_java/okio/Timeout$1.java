// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.util.concurrent.TimeUnit;

final class Timeout$1 extends Timeout
{
    public Timeout deadlineNanoTime(final long n) {
        return this;
    }
    
    public void throwIfReached() {
    }
    
    public Timeout timeout(final long n, final TimeUnit timeUnit) {
        return this;
    }
}
