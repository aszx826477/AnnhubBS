// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.Inflater;
import java.util.zip.CRC32;

public final class GzipSource implements Source
{
    private static final byte FCOMMENT = 4;
    private static final byte FEXTRA = 2;
    private static final byte FHCRC = 1;
    private static final byte FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;
    private final CRC32 crc;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private int section;
    private final BufferedSource source;
    
    public GzipSource(final Source source) {
        this.section = 0;
        this.crc = new CRC32();
        if (source != null) {
            this.inflater = new Inflater(true);
            this.source = Okio.buffer(source);
            this.inflaterSource = new InflaterSource(this.source, this.inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }
    
    private void checkEqual(final String s, final int n, final int n2) {
        if (n2 == n) {
            return;
        }
        throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", s, n2, n));
    }
    
    private void consumeHeader() {
        this.source.require(10);
        final byte byte1 = this.source.buffer().getByte(3);
        final int n = byte1 >> 1;
        final boolean b = true;
        final boolean b2;
        if (b2 = ((n & (b ? 1 : 0)) == (b ? 1 : 0))) {
            this.updateCrc(this.source.buffer(), 0L, 10);
        }
        this.checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8);
        if ((byte1 >> 2 & (b ? 1 : 0)) == (b ? 1 : 0)) {
            this.source.require(2);
            if (b2) {
                this.updateCrc(this.source.buffer(), 0L, 2);
            }
            final short shortLe = this.source.buffer().readShortLe();
            this.source.require(shortLe);
            if (b2) {
                this.updateCrc(this.source.buffer(), 0L, shortLe);
            }
            this.source.skip(shortLe);
        }
        final int n2 = byte1 >> 3 & (b ? 1 : 0);
        final long n3 = -1;
        final long n4 = 1L;
        if (n2 == (b ? 1 : 0)) {
            final long index = this.source.indexOf((byte)0);
            if (index == n3) {
                throw new EOFException();
            }
            if (b2) {
                this.updateCrc(this.source.buffer(), 0L, index + n4);
            }
            this.source.skip(index + n4);
        }
        if ((byte1 >> 4 & (b ? 1 : 0)) == (b ? 1 : 0)) {
            final long index2 = this.source.indexOf((byte)0);
            if (index2 == n3) {
                throw new EOFException();
            }
            if (b2) {
                this.updateCrc(this.source.buffer(), 0L, index2 + n4);
            }
            this.source.skip(n4 + index2);
        }
        if (b2) {
            this.checkEqual("FHCRC", this.source.readShortLe(), (short)this.crc.getValue());
            this.crc.reset();
        }
    }
    
    private void consumeTrailer() {
        this.checkEqual("CRC", this.source.readIntLe(), (int)this.crc.getValue());
        this.checkEqual("ISIZE", this.source.readIntLe(), this.inflater.getTotalOut());
    }
    
    private void updateCrc(final Buffer buffer, long n, long n2) {
        Segment segment;
        for (segment = buffer.head; n >= segment.limit - segment.pos; n -= segment.limit - segment.pos, segment = segment.next) {}
        while (n2 > 0L) {
            final int n3 = (int)(segment.pos + n);
            final int n4 = (int)Math.min(segment.limit - n3, n2);
            this.crc.update(segment.data, n3, n4);
            n2 -= n4;
            n = 0L;
            segment = segment.next;
        }
    }
    
    public void close() {
        this.inflaterSource.close();
    }
    
    public long read(final Buffer buffer, final long n) {
        final long n2 = 0L;
        if (n < n2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString());
        }
        if (n == n2) {
            return n2;
        }
        final int section = this.section;
        final boolean section2 = true;
        if (section == 0) {
            this.consumeHeader();
            this.section = (section2 ? 1 : 0);
        }
        final int section3 = this.section;
        final long n3 = -1;
        final int section4 = 2;
        if (section3 == (section2 ? 1 : 0)) {
            final long size = buffer.size;
            final long read = this.inflaterSource.read(buffer, n);
            if (read != n3) {
                this.updateCrc(buffer, size, read);
                return read;
            }
            this.section = section4;
        }
        if (this.section == section4) {
            this.consumeTrailer();
            this.section = 3;
            if (!this.source.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return n3;
    }
    
    public Timeout timeout() {
        return this.source.timeout();
    }
}
