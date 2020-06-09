// 
// Decompiled by Procyon v0.5.30
// 

package okio;

final class Pipe$PipeSource implements Source
{
    final /* synthetic */ Pipe this$0;
    final Timeout timeout;
    
    Pipe$PipeSource(final Pipe this$0) {
        this.this$0 = this$0;
        this.timeout = new Timeout();
    }
    
    public void close() {
        synchronized (this.this$0.buffer) {
            this.this$0.sourceClosed = true;
            this.this$0.buffer.notifyAll();
        }
    }
    
    public long read(final Buffer buffer, final long n) {
        synchronized (this.this$0.buffer) {
            if (!this.this$0.sourceClosed) {
                while (this.this$0.buffer.size() == 0L) {
                    if (this.this$0.sinkClosed) {
                        return -1;
                    }
                    this.timeout.waitUntilNotified(this.this$0.buffer);
                }
                final long read = this.this$0.buffer.read(buffer, n);
                this.this$0.buffer.notifyAll();
                return read;
            }
            throw new IllegalStateException("closed");
        }
    }
    
    public Timeout timeout() {
        return this.timeout;
    }
}
