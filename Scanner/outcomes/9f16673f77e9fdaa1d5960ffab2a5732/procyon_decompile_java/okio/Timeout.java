// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class Timeout
{
    public static final Timeout NONE;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;
    
    static {
        NONE = new Timeout$1();
    }
    
    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }
    
    public Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }
    
    public final Timeout deadline(final long n, final TimeUnit timeUnit) {
        if (n <= 0L) {
            final StringBuilder sb = new StringBuilder();
            sb.append("duration <= 0: ");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString());
        }
        if (timeUnit != null) {
            return this.deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(n));
        }
        throw new IllegalArgumentException("unit == null");
    }
    
    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }
    
    public Timeout deadlineNanoTime(final long deadlineNanoTime) {
        this.hasDeadline = true;
        this.deadlineNanoTime = deadlineNanoTime;
        return this;
    }
    
    public boolean hasDeadline() {
        return this.hasDeadline;
    }
    
    public void throwIfReached() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0L) {
            throw new InterruptedIOException("deadline reached");
        }
    }
    
    public Timeout timeout(final long n, final TimeUnit timeUnit) {
        if (n < 0L) {
            final StringBuilder sb = new StringBuilder();
            sb.append("timeout < 0: ");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString());
        }
        if (timeUnit != null) {
            this.timeoutNanos = timeUnit.toNanos(n);
            return this;
        }
        throw new IllegalArgumentException("unit == null");
    }
    
    public long timeoutNanos() {
        return this.timeoutNanos;
    }
    
    public final void waitUntilNotified(final Object o) {
        try {
            final boolean hasDeadline = this.hasDeadline();
            try {
                final long timeoutNanos = this.timeoutNanos();
                final long n = 0L;
                if (!hasDeadline && timeoutNanos == n) {
                    o.wait();
                    return;
                }
                final long nanoTime = System.nanoTime();
                long min;
                if (hasDeadline && timeoutNanos != n) {
                    min = Math.min(timeoutNanos, this.deadlineNanoTime() - nanoTime);
                }
                else if (hasDeadline) {
                    min = this.deadlineNanoTime() - nanoTime;
                }
                else {
                    min = timeoutNanos;
                }
                long n2 = 0L;
                if (min > n) {
                    final long n3 = 1000000L;
                    final int n4 = (int)(min / n3);
                    Long.signum(n4);
                    o.wait(n4, (int)(min - n3 * n4));
                    n2 = System.nanoTime() - nanoTime;
                }
                if (n2 < min) {
                    return;
                }
                throw new InterruptedIOException("timeout");
            }
            catch (InterruptedException ex) {
                throw new InterruptedIOException("interrupted");
            }
        }
        catch (InterruptedException ex2) {}
    }
}
