// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.util.concurrent.TimeUnit;

public class ForwardingTimeout extends Timeout
{
    private Timeout delegate;
    
    public ForwardingTimeout(final Timeout delegate) {
        if (delegate != null) {
            this.delegate = delegate;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }
    
    public Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }
    
    public Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }
    
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }
    
    public Timeout deadlineNanoTime(final long n) {
        return this.delegate.deadlineNanoTime(n);
    }
    
    public final Timeout delegate() {
        return this.delegate;
    }
    
    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }
    
    public final ForwardingTimeout setDelegate(final Timeout delegate) {
        if (delegate != null) {
            this.delegate = delegate;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }
    
    public void throwIfReached() {
        this.delegate.throwIfReached();
    }
    
    public Timeout timeout(final long n, final TimeUnit timeUnit) {
        return this.delegate.timeout(n, timeUnit);
    }
    
    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }
}
