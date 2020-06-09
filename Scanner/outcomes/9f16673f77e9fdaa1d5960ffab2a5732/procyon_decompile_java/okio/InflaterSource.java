// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.EOFException;
import java.util.zip.DataFormatException;
import java.io.IOException;
import java.util.zip.Inflater;

public final class InflaterSource implements Source
{
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;
    
    InflaterSource(final BufferedSource source, final Inflater inflater) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.source = source;
            this.inflater = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }
    
    public InflaterSource(final Source source, final Inflater inflater) {
        this(Okio.buffer(source), inflater);
    }
    
    private void releaseInflatedBytes() {
        final int bufferBytesHeldByInflater = this.bufferBytesHeldByInflater;
        if (bufferBytesHeldByInflater == 0) {
            return;
        }
        final int n = bufferBytesHeldByInflater - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= n;
        this.source.skip(n);
    }
    
    public void close() {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }
    
    public long read(final Buffer buffer, final long n) {
        final long n2 = 0L;
        if (n >= n2) {
            if (!this.closed) {
                if (n == n2) {
                    return n2;
                }
                while (true) {
                    final boolean refill = this.refill();
                    final int n3 = 1;
                    try {
                        final Segment writableSegment = buffer.writableSegment(n3);
                        try {
                            final Inflater inflater = this.inflater;
                            try {
                                final byte[] data = writableSegment.data;
                                try {
                                    final int limit = writableSegment.limit;
                                    try {
                                        final int inflate = inflater.inflate(data, limit, 8192 - writableSegment.limit);
                                        if (inflate > 0) {
                                            writableSegment.limit += inflate;
                                            buffer.size += inflate;
                                            return inflate;
                                        }
                                        final Inflater inflater2 = this.inflater;
                                        try {
                                            Label_0220: {
                                                if (inflater2.finished()) {
                                                    break Label_0220;
                                                }
                                                final Inflater inflater3 = this.inflater;
                                                try {
                                                    if (inflater3.needsDictionary()) {
                                                        this.releaseInflatedBytes();
                                                        final int pos = writableSegment.pos;
                                                        try {
                                                            if (pos == writableSegment.limit) {
                                                                buffer.head = writableSegment.pop();
                                                                SegmentPool.recycle(writableSegment);
                                                            }
                                                            return -1;
                                                        }
                                                        catch (DataFormatException ex) {
                                                            throw new IOException(ex);
                                                        }
                                                    }
                                                    else {
                                                        if (!refill) {
                                                            continue;
                                                        }
                                                        throw new EOFException("source exhausted prematurely");
                                                    }
                                                }
                                                catch (DataFormatException ex2) {}
                                            }
                                        }
                                        catch (DataFormatException ex3) {}
                                    }
                                    catch (DataFormatException ex4) {}
                                }
                                catch (DataFormatException ex5) {}
                            }
                            catch (DataFormatException ex6) {}
                        }
                        catch (DataFormatException ex7) {}
                    }
                    catch (DataFormatException ex8) {}
                    break;
                }
            }
            throw new IllegalStateException("closed");
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("byteCount < 0: ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public boolean refill() {
        if (!this.inflater.needsInput()) {
            return false;
        }
        this.releaseInflatedBytes();
        if (this.inflater.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.source.exhausted()) {
            return true;
        }
        final Segment head = this.source.buffer().head;
        this.bufferBytesHeldByInflater = head.limit - head.pos;
        this.inflater.setInput(head.data, head.pos, this.bufferBytesHeldByInflater);
        return false;
    }
    
    public Timeout timeout() {
        return this.source.timeout();
    }
}
