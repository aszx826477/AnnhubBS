// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.nio.charset.Charset;

final class Util
{
    public static final Charset UTF_8;
    
    static {
        UTF_8 = Charset.forName("UTF-8");
    }
    
    public static boolean arrayRangeEquals(final byte[] array, final int n, final byte[] array2, final int n2, final int n3) {
        for (int i = 0; i < n3; ++i) {
            if (array[i + n] != array2[i + n2]) {
                return false;
            }
        }
        return true;
    }
    
    public static void checkOffsetAndCount(final long n, final long n2, final long n3) {
        if ((n2 | n3) >= 0L && n2 <= n && n - n2 >= n3) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", n, n2, n3));
    }
    
    public static int reverseBytesInt(final int n) {
        return (0xFF000000 & n) >>> 24 | (0xFF0000 & n) >>> 8 | (0xFF00 & n) << 8 | (n & 0xFF) << 24;
    }
    
    public static long reverseBytesLong(final long n) {
        final long n2 = 0xFF00000000000000L & n;
        final int n3 = 56;
        final long n4 = n2 >>> n3;
        final long n5 = 0xFF000000000000L & n;
        final int n6 = 40;
        final long n7 = n4 | n5 >>> n6;
        final long n8 = 0xFF0000000000L & n;
        final int n9 = 24;
        final long n10 = n7 | n8 >>> n9;
        final long n11 = 0xFF00000000L & n;
        final int n12 = 8;
        return n10 | n11 >>> n12 | (0xFF000000L & n) << n12 | (0xFF0000L & n) << n9 | (0xFF00L & n) << n6 | (0xFFL & n) << n3;
    }
    
    public static short reverseBytesShort(final short n) {
        final int n2 = (char)(-1) & n;
        return (short)((0xFF00 & n2) >>> 8 | (n2 & 0xFF) << 8);
    }
    
    public static void sneakyRethrow(final Throwable t) {
        sneakyThrow2(t);
    }
    
    private static void sneakyThrow2(final Throwable t) {
        throw t;
    }
}
