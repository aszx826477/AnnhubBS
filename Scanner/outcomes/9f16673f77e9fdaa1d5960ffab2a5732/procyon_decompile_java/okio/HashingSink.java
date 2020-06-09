// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public final class HashingSink extends ForwardingSink
{
    private final MessageDigest messageDigest;
    
    private HashingSink(final Sink sink, final String s) {
        super(sink);
        try {
            this.messageDigest = MessageDigest.getInstance(s);
        }
        catch (NoSuchAlgorithmException ex) {
            throw new AssertionError();
        }
    }
    
    public static HashingSink md5(final Sink sink) {
        return new HashingSink(sink, "MD5");
    }
    
    public static HashingSink sha1(final Sink sink) {
        return new HashingSink(sink, "SHA-1");
    }
    
    public static HashingSink sha256(final Sink sink) {
        return new HashingSink(sink, "SHA-256");
    }
    
    public ByteString hash() {
        return ByteString.of(this.messageDigest.digest());
    }
    
    public void write(final Buffer buffer, final long n) {
        Util.checkOffsetAndCount(buffer.size, 0L, n);
        long n2 = 0L;
        int n3;
        for (Segment segment = buffer.head; n2 < n; n2 += n3, segment = segment.next) {
            n3 = (int)Math.min(n - n2, segment.limit - segment.pos);
            this.messageDigest.update(segment.data, segment.pos, n3);
        }
        super.write(buffer, n);
    }
}
