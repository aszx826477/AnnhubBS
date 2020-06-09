// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.nio.charset.Charset;
import java.io.OutputStream;

public interface BufferedSink extends Sink
{
    Buffer buffer();
    
    BufferedSink emit();
    
    BufferedSink emitCompleteSegments();
    
    void flush();
    
    OutputStream outputStream();
    
    BufferedSink write(final ByteString p0);
    
    BufferedSink write(final Source p0, final long p1);
    
    BufferedSink write(final byte[] p0);
    
    BufferedSink write(final byte[] p0, final int p1, final int p2);
    
    long writeAll(final Source p0);
    
    BufferedSink writeByte(final int p0);
    
    BufferedSink writeDecimalLong(final long p0);
    
    BufferedSink writeHexadecimalUnsignedLong(final long p0);
    
    BufferedSink writeInt(final int p0);
    
    BufferedSink writeIntLe(final int p0);
    
    BufferedSink writeLong(final long p0);
    
    BufferedSink writeLongLe(final long p0);
    
    BufferedSink writeShort(final int p0);
    
    BufferedSink writeShortLe(final int p0);
    
    BufferedSink writeString(final String p0, final int p1, final int p2, final Charset p3);
    
    BufferedSink writeString(final String p0, final Charset p1);
    
    BufferedSink writeUtf8(final String p0);
    
    BufferedSink writeUtf8(final String p0, final int p1, final int p2);
    
    BufferedSink writeUtf8CodePoint(final int p0);
}
