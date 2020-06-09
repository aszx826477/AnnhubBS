// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.InterruptedIOException;
import java.io.IOException;

public class AsyncTimeout extends Timeout
{
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;
    
    static AsyncTimeout awaitTimeout() {
        synchronized (AsyncTimeout.class) {
            final AsyncTimeout next = AsyncTimeout.head.next;
            if (next == null) {
                AsyncTimeout.class.wait();
                return null;
            }
            final long remainingNanos = next.remainingNanos(System.nanoTime());
            if (remainingNanos > 0L) {
                final long n = 1000000L;
                final long n2 = remainingNanos / n;
                Long.signum(n2);
                AsyncTimeout.class.wait(n2, (int)(remainingNanos - n * n2));
                return null;
            }
            AsyncTimeout.head.next = next.next;
            next.next = null;
            return next;
        }
    }
    
    private static boolean cancelScheduledTimeout(final AsyncTimeout asyncTimeout) {
        synchronized (AsyncTimeout.class) {
            for (AsyncTimeout asyncTimeout2 = AsyncTimeout.head; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.next) {
                if (asyncTimeout2.next == asyncTimeout) {
                    asyncTimeout2.next = asyncTimeout.next;
                    asyncTimeout.next = null;
                    return false;
                }
            }
            return true;
        }
    }
    
    private long remainingNanos(final long n) {
        return this.timeoutAt - n;
    }
    
    private static void scheduleTimeout(final AsyncTimeout next, final long n, final boolean b) {
        synchronized (AsyncTimeout.class) {
            if (AsyncTimeout.head == null) {
                AsyncTimeout.head = new AsyncTimeout();
                new AsyncTimeout$Watchdog().start();
            }
            final long nanoTime = System.nanoTime();
            final long n2 = 0L;
            if (n != n2 && b) {
                next.timeoutAt = Math.min(n, next.deadlineNanoTime() - nanoTime) + nanoTime;
            }
            else if (n != n2) {
                next.timeoutAt = nanoTime + n;
            }
            else {
                if (!b) {
                    throw new AssertionError();
                }
                next.timeoutAt = next.deadlineNanoTime();
            }
            long remainingNanos;
            AsyncTimeout asyncTimeout;
            for (remainingNanos = next.remainingNanos(nanoTime), asyncTimeout = AsyncTimeout.head; asyncTimeout.next != null && remainingNanos >= asyncTimeout.next.remainingNanos(nanoTime); asyncTimeout = asyncTimeout.next) {}
            next.next = asyncTimeout.next;
            asyncTimeout.next = next;
            if (asyncTimeout == AsyncTimeout.head) {
                AsyncTimeout.class.notify();
            }
        }
    }
    
    public final void enter() {
        if (this.inQueue) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        final long timeoutNanos = this.timeoutNanos();
        final boolean hasDeadline = this.hasDeadline();
        if (timeoutNanos == 0L && !hasDeadline) {
            return;
        }
        this.inQueue = true;
        scheduleTimeout(this, timeoutNanos, hasDeadline);
    }
    
    final IOException exit(final IOException ex) {
        if (!this.exit()) {
            return ex;
        }
        return this.newTimeoutException(ex);
    }
    
    final void exit(final boolean b) {
        if (this.exit() && b) {
            throw this.newTimeoutException(null);
        }
    }
    
    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }
    
    protected IOException newTimeoutException(final IOException ex) {
        final InterruptedIOException ex2 = new InterruptedIOException("timeout");
        if (ex != null) {
            ex2.initCause(ex);
        }
        return ex2;
    }
    
    public final Sink sink(final Sink sink) {
        return new AsyncTimeout$1(this, sink);
    }
    
    public final Source source(final Source source) {
        return new AsyncTimeout$2(this, source);
    }
    
    protected void timedOut() {
    }
}
