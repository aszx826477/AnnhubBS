// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public final class HashingSource extends ForwardingSource
{
    private final MessageDigest messageDigest;
    
    private HashingSource(final Source source, final String s) {
        super(source);
        try {
            this.messageDigest = MessageDigest.getInstance(s);
        }
        catch (NoSuchAlgorithmException ex) {
            throw new AssertionError();
        }
    }
    
    public static HashingSource md5(final Source source) {
        return new HashingSource(source, "MD5");
    }
    
    public static HashingSource sha1(final Source source) {
        return new HashingSource(source, "SHA-1");
    }
    
    public static HashingSource sha256(final Source source) {
        return new HashingSource(source, "SHA-256");
    }
    
    public ByteString hash() {
        return ByteString.of(this.messageDigest.digest());
    }
    
    public long read(final Buffer buffer, final long n) {
        final long read = super.read(buffer, n);
        if (read != -1) {
            long n2;
            long size;
            Segment segment;
            for (n2 = buffer.size - read, size = buffer.size, segment = buffer.head; size > n2; size -= segment.limit - segment.pos) {
                segment = segment.prev;
            }
            while (size < buffer.size) {
                final int n3 = (int)(segment.pos + n2 - size);
                this.messageDigest.update(segment.data, n3, segment.limit - n3);
                size = (n2 = size + (segment.limit - segment.pos));
                segment = segment.next;
            }
        }
        return read;
    }
}
