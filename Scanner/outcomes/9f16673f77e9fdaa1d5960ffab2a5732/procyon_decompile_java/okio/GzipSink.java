// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.util.zip.Deflater;
import java.util.zip.CRC32;

public final class GzipSink implements Sink
{
    private boolean closed;
    private final CRC32 crc;
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final BufferedSink sink;
    
    public GzipSink(final Sink sink) {
        this.crc = new CRC32();
        if (sink != null) {
            this.deflater = new Deflater(-1, true);
            this.sink = Okio.buffer(sink);
            this.deflaterSink = new DeflaterSink(this.sink, this.deflater);
            this.writeHeader();
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }
    
    private void updateCrc(final Buffer buffer, long n) {
        int n2;
        for (Segment segment = buffer.head; n > 0L; n -= n2, segment = segment.next) {
            n2 = (int)Math.min(n, segment.limit - segment.pos);
            this.crc.update(segment.data, segment.pos, n2);
        }
    }
    
    private void writeFooter() {
        this.sink.writeIntLe((int)this.crc.getValue());
        this.sink.writeIntLe(this.deflater.getTotalIn());
    }
    
    private void writeHeader() {
        final Buffer buffer = this.sink.buffer();
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }
    
    public void close() {
        if (this.closed) {
            return;
        }
        Throwable t;
        try {
            this.deflaterSink.finishDeflate();
            this.writeFooter();
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
    
    public void flush() {
        this.deflaterSink.flush();
    }
    
    public Timeout timeout() {
        return this.sink.timeout();
    }
    
    public void write(final Buffer buffer, final long n) {
        final long n2 = 0L;
        if (n < n2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString());
        }
        if (n == n2) {
            return;
        }
        this.updateCrc(buffer, n);
        this.deflaterSink.write(buffer, n);
    }
}
