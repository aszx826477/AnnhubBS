// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.util.zip.Deflater;

public final class DeflaterSink implements Sink
{
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;
    
    DeflaterSink(final BufferedSink sink, final Deflater deflater) {
        if (sink == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater != null) {
            this.sink = sink;
            this.deflater = deflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }
    
    public DeflaterSink(final Sink sink, final Deflater deflater) {
        this(Okio.buffer(sink), deflater);
    }
    
    private void deflate(final boolean b) {
        final Buffer buffer = this.sink.buffer();
        Segment writableSegment;
        while (true) {
            writableSegment = buffer.writableSegment(1);
            int n;
            if (b) {
                n = this.deflater.deflate(writableSegment.data, writableSegment.limit, 8192 - writableSegment.limit, 2);
            }
            else {
                n = this.deflater.deflate(writableSegment.data, writableSegment.limit, 8192 - writableSegment.limit);
            }
            if (n > 0) {
                writableSegment.limit += n;
                buffer.size += n;
                this.sink.emitCompleteSegments();
            }
            else {
                if (this.deflater.needsInput()) {
                    break;
                }
                continue;
            }
        }
        if (writableSegment.pos == writableSegment.limit) {
            buffer.head = writableSegment.pop();
            SegmentPool.recycle(writableSegment);
        }
    }
    
    public void close() {
        if (this.closed) {
            return;
        }
        Throwable t = null;
        try {
            this.finishDeflate();
        }
        finally {
            final Throwable t2;
            t = t2;
        }
        try {
            this.deflater.end();
        }
        finally {
            if (t == null) {
                final Throwable t3;
                t = t3;
            }
        }
        try {
            this.sink.close();
        }
        finally {
            if (t == null) {
                final Throwable t4;
                t = t4;
            }
        }
        this.closed = true;
        if (t != null) {
            Util.sneakyRethrow(t);
        }
    }
    
    void finishDeflate() {
        this.deflater.finish();
        this.deflate(false);
    }
    
    public void flush() {
        this.deflate(true);
        this.sink.flush();
    }
    
    public Timeout timeout() {
        return this.sink.timeout();
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("DeflaterSink(");
        sb.append(this.sink);
        sb.append(")");
        return sb.toString();
    }
    
    public void write(final Buffer buffer, long n) {
        Util.checkOffsetAndCount(buffer.size, 0L, n);
        while (n > 0L) {
            final Segment head = buffer.head;
            final int n2 = (int)Math.min(n, head.limit - head.pos);
            this.deflater.setInput(head.data, head.pos, n2);
            this.deflate(false);
            buffer.size -= n2;
            head.pos += n2;
            if (head.pos == head.limit) {
                buffer.head = head.pop();
                SegmentPool.recycle(head);
            }
            n -= n2;
        }
    }
}
