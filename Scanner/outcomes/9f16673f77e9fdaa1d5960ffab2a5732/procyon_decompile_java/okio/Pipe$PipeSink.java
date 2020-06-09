// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.IOException;

final class Pipe$PipeSink implements Sink
{
    final /* synthetic */ Pipe this$0;
    final Timeout timeout;
    
    Pipe$PipeSink(final Pipe this$0) {
        this.this$0 = this$0;
        this.timeout = new Timeout();
    }
    
    public void close() {
        synchronized (this.this$0.buffer) {
            if (this.this$0.sinkClosed) {
                return;
            }
            final boolean sinkClosed = true;
            try {
                this.flush();
            }
            finally {
                this.this$0.sinkClosed = sinkClosed;
                this.this$0.buffer.notifyAll();
            }
        }
    }
    
    public void flush() {
        synchronized (this.this$0.buffer) {
            if (!this.this$0.sinkClosed) {
                while (this.this$0.buffer.size() > 0L) {
                    if (this.this$0.sourceClosed) {
                        throw new IOException("source is closed");
                    }
                    this.timeout.waitUntilNotified(this.this$0.buffer);
                }
                return;
            }
            throw new IllegalStateException("closed");
        }
    }
    
    public Timeout timeout() {
        return this.timeout;
    }
    
    public void write(final Buffer buffer, long n) {
        synchronized (this.this$0.buffer) {
            if (this.this$0.sinkClosed) {
                throw new IllegalStateException("closed");
            }
            while (true) {
                final long n2 = 0L;
                if (n <= n2) {
                    return;
                }
                if (this.this$0.sourceClosed) {
                    throw new IOException("source is closed");
                }
                final long n3 = this.this$0.maxBufferSize - this.this$0.buffer.size();
                if (n3 == n2) {
                    this.timeout.waitUntilNotified(this.this$0.buffer);
                }
                else {
                    final long min = Math.min(n3, n);
                    this.this$0.buffer.write(buffer, min);
                    n -= min;
                    this.this$0.buffer.notifyAll();
                }
            }
        }
    }
}
