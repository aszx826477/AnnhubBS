// 
// Decompiled by Procyon v0.5.30
// 

package okio;

public final class Pipe
{
    final Buffer buffer;
    final long maxBufferSize;
    private final Sink sink;
    boolean sinkClosed;
    private final Source source;
    boolean sourceClosed;
    
    public Pipe(final long maxBufferSize) {
        this.buffer = new Buffer();
        this.sink = new Pipe$PipeSink(this);
        this.source = new Pipe$PipeSource(this);
        if (maxBufferSize >= 1L) {
            this.maxBufferSize = maxBufferSize;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("maxBufferSize < 1: ");
        sb.append(maxBufferSize);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public Sink sink() {
        return this.sink;
    }
    
    public Source source() {
        return this.source;
    }
}
