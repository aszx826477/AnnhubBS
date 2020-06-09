// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.nio.charset.Charset;
import java.io.InputStream;

public interface BufferedSource extends Source
{
    Buffer buffer();
    
    boolean exhausted();
    
    long indexOf(final byte p0);
    
    long indexOf(final byte p0, final long p1);
    
    long indexOf(final ByteString p0);
    
    long indexOf(final ByteString p0, final long p1);
    
    long indexOfElement(final ByteString p0);
    
    long indexOfElement(final ByteString p0, final long p1);
    
    InputStream inputStream();
    
    boolean rangeEquals(final long p0, final ByteString p1);
    
    boolean rangeEquals(final long p0, final ByteString p1, final int p2, final int p3);
    
    int read(final byte[] p0);
    
    int read(final byte[] p0, final int p1, final int p2);
    
    long readAll(final Sink p0);
    
    byte readByte();
    
    byte[] readByteArray();
    
    byte[] readByteArray(final long p0);
    
    ByteString readByteString();
    
    ByteString readByteString(final long p0);
    
    long readDecimalLong();
    
    void readFully(final Buffer p0, final long p1);
    
    void readFully(final byte[] p0);
    
    long readHexadecimalUnsignedLong();
    
    int readInt();
    
    int readIntLe();
    
    long readLong();
    
    long readLongLe();
    
    short readShort();
    
    short readShortLe();
    
    String readString(final long p0, final Charset p1);
    
    String readString(final Charset p0);
    
    String readUtf8();
    
    String readUtf8(final long p0);
    
    int readUtf8CodePoint();
    
    String readUtf8Line();
    
    String readUtf8LineStrict();
    
    boolean request(final long p0);
    
    void require(final long p0);
    
    int select(final Options p0);
    
    void skip(final long p0);
}
