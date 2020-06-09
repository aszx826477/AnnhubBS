// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

final class SegmentedByteString extends ByteString
{
    final transient int[] directory;
    final transient byte[][] segments;
    
    SegmentedByteString(final Buffer buffer, final int n) {
        super(null);
        Util.checkOffsetAndCount(buffer.size, 0L, n);
        int i = 0;
        int n2 = 0;
        for (Segment segment = buffer.head; i < n; i += segment.limit - segment.pos, ++n2, segment = segment.next) {
            if (segment.limit == segment.pos) {
                throw new AssertionError((Object)"s.limit == s.pos");
            }
        }
        this.segments = new byte[n2][];
        this.directory = new int[n2 * 2];
        int j = 0;
        int n3 = 0;
        Segment segment2 = buffer.head;
        while (j < n) {
            this.segments[n3] = segment2.data;
            j += segment2.limit - segment2.pos;
            if (j > n) {
                j = n;
            }
            final int[] directory = this.directory;
            directory[n3] = j;
            directory[this.segments.length + n3] = segment2.pos;
            segment2.shared = true;
            ++n3;
            segment2 = segment2.next;
        }
    }
    
    private int segment(final int n) {
        final int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, n + 1);
        int n2;
        if (binarySearch >= 0) {
            n2 = binarySearch;
        }
        else {
            n2 = ~binarySearch;
        }
        return n2;
    }
    
    private ByteString toByteString() {
        return new ByteString(this.toByteArray());
    }
    
    private Object writeReplace() {
        return this.toByteString();
    }
    
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.toByteArray()).asReadOnlyBuffer();
    }
    
    public String base64() {
        return this.toByteString().base64();
    }
    
    public String base64Url() {
        return this.toByteString().base64Url();
    }
    
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return b;
        }
        if (o instanceof ByteString) {
            if (((ByteString)o).size() == this.size()) {
                if (this.rangeEquals(0, (ByteString)o, 0, this.size())) {
                    return b;
                }
            }
        }
        b = false;
        return b;
    }
    
    public byte getByte(final int n) {
        Util.checkOffsetAndCount(this.directory[this.segments.length - 1], n, 1L);
        final int segment = this.segment(n);
        int n2;
        if (segment == 0) {
            n2 = 0;
        }
        else {
            n2 = this.directory[segment - 1];
        }
        final int[] directory = this.directory;
        final byte[][] segments = this.segments;
        return segments[segment][n - n2 + directory[segments.length + segment]];
    }
    
    public int hashCode() {
        final int hashCode = this.hashCode;
        if (hashCode != 0) {
            return hashCode;
        }
        int hashCode2 = 1;
        int n = 0;
        for (int i = 0, length = this.segments.length; i < length; ++i) {
            final byte[] array = this.segments[i];
            final int[] directory = this.directory;
            final int n2 = directory[length + i];
            final int n3 = directory[i];
            for (int n4 = n3 - n, j = n2; j < n2 + n4; ++j) {
                hashCode2 = hashCode2 * 31 + array[j];
            }
            n = n3;
        }
        return this.hashCode = hashCode2;
    }
    
    public String hex() {
        return this.toByteString().hex();
    }
    
    public int indexOf(final byte[] array, final int n) {
        return this.toByteString().indexOf(array, n);
    }
    
    byte[] internalArray() {
        return this.toByteArray();
    }
    
    public int lastIndexOf(final byte[] array, final int n) {
        return this.toByteString().lastIndexOf(array, n);
    }
    
    public ByteString md5() {
        return this.toByteString().md5();
    }
    
    public boolean rangeEquals(int n, final ByteString byteString, int n2, int i) {
        if (n >= 0 && n <= this.size() - i) {
            int min;
            for (int segment = this.segment(n); i > 0; i -= min, ++segment) {
                int n3;
                if (segment == 0) {
                    n3 = 0;
                }
                else {
                    n3 = this.directory[segment - 1];
                }
                min = Math.min(i, n3 + (this.directory[segment] - n3) - n);
                final int[] directory = this.directory;
                final byte[][] segments = this.segments;
                if (!byteString.rangeEquals(n2, segments[segment], n - n3 + directory[segments.length + segment], min)) {
                    return false;
                }
                n += min;
                n2 += min;
            }
            return true;
        }
        return false;
    }
    
    public boolean rangeEquals(int n, final byte[] array, int n2, int i) {
        if (n >= 0 && n <= this.size() - i && n2 >= 0 && n2 <= array.length - i) {
            int min;
            for (int segment = this.segment(n); i > 0; i -= min, ++segment) {
                int n3;
                if (segment == 0) {
                    n3 = 0;
                }
                else {
                    n3 = this.directory[segment - 1];
                }
                min = Math.min(i, n3 + (this.directory[segment] - n3) - n);
                final int[] directory = this.directory;
                final byte[][] segments = this.segments;
                if (!Util.arrayRangeEquals(segments[segment], n - n3 + directory[segments.length + segment], array, n2, min)) {
                    return false;
                }
                n += min;
                n2 += min;
            }
            return true;
        }
        return false;
    }
    
    public ByteString sha256() {
        return this.toByteString().sha256();
    }
    
    public int size() {
        return this.directory[this.segments.length - 1];
    }
    
    public ByteString substring(final int n) {
        return this.toByteString().substring(n);
    }
    
    public ByteString substring(final int n, final int n2) {
        return this.toByteString().substring(n, n2);
    }
    
    public ByteString toAsciiLowercase() {
        return this.toByteString().toAsciiLowercase();
    }
    
    public ByteString toAsciiUppercase() {
        return this.toByteString().toAsciiUppercase();
    }
    
    public byte[] toByteArray() {
        final int[] directory = this.directory;
        final byte[][] segments = this.segments;
        final byte[] array = new byte[directory[segments.length - 1]];
        int n = 0;
        for (int i = 0, length = segments.length; i < length; ++i) {
            final int[] directory2 = this.directory;
            final int n2 = directory2[length + i];
            final int n3 = directory2[i];
            System.arraycopy(this.segments[i], n2, array, n, n3 - n);
            n = n3;
        }
        return array;
    }
    
    public String toString() {
        return this.toByteString().toString();
    }
    
    public String utf8() {
        return this.toByteString().utf8();
    }
    
    public void write(final OutputStream outputStream) {
        if (outputStream != null) {
            int n = 0;
            for (int i = 0, length = this.segments.length; i < length; ++i) {
                final int[] directory = this.directory;
                final int n2 = directory[length + i];
                final int n3 = directory[i];
                outputStream.write(this.segments[i], n2, n3 - n);
                n = n3;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }
    
    void write(final Buffer buffer) {
        int n = 0;
        for (int i = 0, length = this.segments.length; i < length; ++i) {
            final int[] directory = this.directory;
            final int n2 = directory[length + i];
            final int n3 = directory[i];
            final Segment head = new Segment(this.segments[i], n2, n2 + n3 - n);
            if (buffer.head == null) {
                head.prev = head;
                head.next = head;
                buffer.head = head;
            }
            else {
                buffer.head.prev.push(head);
            }
            n = n3;
        }
        buffer.size += n;
    }
}
