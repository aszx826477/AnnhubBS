// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.CountDownLatch;

public final class Ping
{
    private final CountDownLatch latch;
    private long received;
    private long sent;
    
    Ping() {
        this.latch = new CountDownLatch(1);
        final long n = -1;
        this.sent = n;
        this.received = n;
    }
    
    void cancel() {
        final long received = this.received;
        final long n = -1;
        if (received == n) {
            final long sent = this.sent;
            if (sent != n) {
                this.received = sent - 1L;
                this.latch.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
    
    void receive() {
        final long received = this.received;
        final long n = -1;
        if (received == n && this.sent != n) {
            this.received = System.nanoTime();
            this.latch.countDown();
            return;
        }
        throw new IllegalStateException();
    }
    
    public long roundTripTime() {
        this.latch.await();
        return this.received - this.sent;
    }
    
    public long roundTripTime(final long n, final TimeUnit timeUnit) {
        if (this.latch.await(n, timeUnit)) {
            return this.received - this.sent;
        }
        return -2;
    }
    
    void send() {
        if (this.sent == -1) {
            this.sent = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }
}
