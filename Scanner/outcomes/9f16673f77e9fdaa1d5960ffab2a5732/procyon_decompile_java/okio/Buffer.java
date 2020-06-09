// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.nio.charset.Charset;
import java.io.OutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public final class Buffer implements BufferedSource, BufferedSink, Cloneable
{
    private static final byte[] DIGITS;
    static final int REPLACEMENT_CHARACTER = 65533;
    Segment head;
    long size;
    
    static {
        final byte[] array;
        final byte[] digits = array = new byte[16];
        array[0] = 48;
        array[1] = 49;
        array[2] = 50;
        array[3] = 51;
        array[4] = 52;
        array[5] = 53;
        array[6] = 54;
        array[7] = 55;
        array[8] = 56;
        array[9] = 57;
        array[10] = 97;
        array[11] = 98;
        array[12] = 99;
        array[13] = 100;
        array[14] = 101;
        array[15] = 102;
        DIGITS = digits;
    }
    
    private ByteString digest(final String s) {
        try {
            final MessageDigest instance = MessageDigest.getInstance(s);
            try {
                final Segment head = this.head;
                try {
                    final byte[] data = head.data;
                    try {
                        final Segment head2 = this.head;
                        try {
                            final int pos = head2.pos;
                            try {
                                final Segment head3 = this.head;
                                try {
                                    final int limit = head3.limit;
                                    try {
                                        final Segment head4 = this.head;
                                        try {
                                            instance.update(data, pos, limit - head4.pos);
                                            final Segment head5 = this.head;
                                            try {
                                                Segment segment = head5.next;
                                                try {
                                                    while (true) {
                                                        Label_0145: {
                                                            if (segment == this.head) {
                                                                break Label_0145;
                                                            }
                                                            final byte[] data2 = segment.data;
                                                            try {
                                                                final int pos2 = segment.pos;
                                                                try {
                                                                    final int limit2 = segment.limit;
                                                                    try {
                                                                        instance.update(data2, pos2, limit2 - segment.pos);
                                                                        segment = segment.next;
                                                                        continue;
                                                                        final byte[] digest = instance.digest();
                                                                        try {
                                                                            return ByteString.of(digest);
                                                                        }
                                                                        catch (NoSuchAlgorithmException ex) {
                                                                            throw new AssertionError();
                                                                        }
                                                                    }
                                                                    catch (NoSuchAlgorithmException ex2) {}
                                                                }
                                                                catch (NoSuchAlgorithmException ex3) {}
                                                            }
                                                            catch (NoSuchAlgorithmException ex4) {}
                                                        }
                                                    }
                                                }
                                                catch (NoSuchAlgorithmException ex5) {}
                                            }
                                            catch (NoSuchAlgorithmException ex6) {}
                                        }
                                        catch (NoSuchAlgorithmException ex7) {}
                                    }
                                    catch (NoSuchAlgorithmException ex8) {}
                                }
                                catch (NoSuchAlgorithmException ex9) {}
                            }
                            catch (NoSuchAlgorithmException ex10) {}
                        }
                        catch (NoSuchAlgorithmException ex11) {}
                    }
                    catch (NoSuchAlgorithmException ex12) {}
                }
                catch (NoSuchAlgorithmException ex13) {}
            }
            catch (NoSuchAlgorithmException ex14) {}
        }
        catch (NoSuchAlgorithmException ex15) {}
    }
    
    private boolean rangeEquals(Segment next, int pos, final ByteString byteString, final int n, final int n2) {
        int n3 = next.limit;
        byte[] array = next.data;
        for (int i = n; i < n2; ++i) {
            if (pos == n3) {
                next = next.next;
                array = next.data;
                pos = next.pos;
                n3 = next.limit;
            }
            if (array[pos] != byteString.getByte(i)) {
                return false;
            }
            ++pos;
        }
        return true;
    }
    
    private void readFrom(final InputStream inputStream, long n, final boolean b) {
        if (inputStream != null) {
            while (n > 0L || b) {
                final Segment writableSegment = this.writableSegment(1);
                final int read = inputStream.read(writableSegment.data, writableSegment.limit, (int)Math.min(n, 8192 - writableSegment.limit));
                if (read == -1) {
                    if (b) {
                        return;
                    }
                    throw new EOFException();
                }
                else {
                    writableSegment.limit += read;
                    this.size += read;
                    n -= read;
                }
            }
            return;
        }
        throw new IllegalArgumentException("in == null");
    }
    
    public Buffer buffer() {
        return this;
    }
    
    public void clear() {
        try {
            this.skip(this.size);
        }
        catch (EOFException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public Buffer clone() {
        final Buffer buffer = new Buffer();
        if (this.size == 0L) {
            return buffer;
        }
        buffer.head = new Segment(this.head);
        final Segment head = buffer.head;
        head.prev = head;
        head.next = head;
        for (Segment segment = this.head.next; segment != this.head; segment = segment.next) {
            buffer.head.prev.push(new Segment(segment));
        }
        buffer.size = this.size;
        return buffer;
    }
    
    public void close() {
    }
    
    public long completeSegmentByteCount() {
        long size = this.size;
        final long n = 0L;
        if (size == n) {
            return n;
        }
        final Segment prev = this.head.prev;
        if (prev.limit < 8192 && prev.owner) {
            size -= prev.limit - prev.pos;
        }
        return size;
    }
    
    public Buffer copyTo(final OutputStream outputStream) {
        return this.copyTo(outputStream, 0L, this.size);
    }
    
    public Buffer copyTo(final OutputStream outputStream, long n, long n2) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, n, n2);
        final long n3 = 0L;
        if (n2 == n3) {
            return this;
        }
        Segment segment;
        for (segment = this.head; n >= segment.limit - segment.pos; n -= segment.limit - segment.pos, segment = segment.next) {}
        while (n2 > n3) {
            final int n4 = (int)(segment.pos + n);
            final int n5 = (int)Math.min(segment.limit - n4, n2);
            outputStream.write(segment.data, n4, n5);
            n2 -= n5;
            n = 0L;
            segment = segment.next;
        }
        return this;
    }
    
    public Buffer copyTo(final Buffer buffer, long n, long n2) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, n, n2);
        final long n3 = 0L;
        if (n2 == n3) {
            return this;
        }
        buffer.size += n2;
        Segment segment;
        for (segment = this.head; n >= segment.limit - segment.pos; n -= segment.limit - segment.pos, segment = segment.next) {}
        while (n2 > n3) {
            final Segment head = new Segment(segment);
            head.pos += (int)n;
            head.limit = Math.min(head.pos + (int)n2, head.limit);
            final Segment head2 = buffer.head;
            if (head2 == null) {
                head.prev = head;
                head.next = head;
                buffer.head = head;
            }
            else {
                head2.prev.push(head);
            }
            n2 -= head.limit - head.pos;
            n = 0L;
            segment = segment.next;
        }
        return this;
    }
    
    public BufferedSink emit() {
        return this;
    }
    
    public Buffer emitCompleteSegments() {
        return this;
    }
    
    public boolean equals(final Object o) {
        final boolean b = true;
        if (this == o) {
            return b;
        }
        if (!(o instanceof Buffer)) {
            return false;
        }
        final Buffer buffer = (Buffer)o;
        final long size = this.size;
        if (size != buffer.size) {
            return false;
        }
        if (size == 0L) {
            return b;
        }
        Segment segment = this.head;
        Segment segment2 = buffer.head;
        int n = segment.pos;
        int n2 = segment2.pos;
        long n4;
        for (long n3 = 0L; n3 < this.size; n3 += n4) {
            n4 = Math.min(segment.limit - n, segment2.limit - n2);
            int n6;
            int n7;
            for (int n5 = 0; n5 < n4; ++n5, n = n6, n2 = n7) {
                final byte[] data = segment.data;
                n6 = n + 1;
                final byte b2 = data[n];
                final byte[] data2 = segment2.data;
                n7 = n2 + 1;
                if (b2 != data2[n2]) {
                    return false;
                }
            }
            if (n == segment.limit) {
                segment = segment.next;
                n = segment.pos;
            }
            if (n2 == segment2.limit) {
                segment2 = segment2.next;
                n2 = segment2.pos;
            }
        }
        return b;
    }
    
    public boolean exhausted() {
        return this.size == 0L;
    }
    
    public void flush() {
    }
    
    public byte getByte(long n) {
        Util.checkOffsetAndCount(this.size, n, 1L);
        Segment segment = this.head;
        while (true) {
            final int n2 = segment.limit - segment.pos;
            if (n < n2) {
                break;
            }
            n -= n2;
            segment = segment.next;
        }
        return segment.data[segment.pos + (int)n];
    }
    
    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int n = 1;
        do {
            for (int i = segment.pos; i < segment.limit; ++i) {
                n = n * 31 + segment.data[i];
            }
            segment = segment.next;
        } while (segment != this.head);
        return n;
    }
    
    public long indexOf(final byte b) {
        return this.indexOf(b, 0L);
    }
    
    public long indexOf(final byte b, long n) {
        if (n < 0L) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.head;
        final long n2 = -1;
        if (segment == null) {
            return n2;
        }
        long size;
        if (this.size - n < n) {
            for (size = this.size; size > n; size -= segment.limit - segment.pos) {
                segment = segment.prev;
            }
        }
        else {
            size = 0L;
            while (true) {
                final long n3 = segment.limit - segment.pos + size;
                if (n3 >= n) {
                    break;
                }
                segment = segment.next;
                size = n3;
            }
        }
        while (size < this.size) {
            final byte[] data = segment.data;
            for (int i = (int)(segment.pos + n - size); i < segment.limit; ++i) {
                if (data[i] == b) {
                    return i - segment.pos + size;
                }
            }
            size = (n = size + (segment.limit - segment.pos));
            segment = segment.next;
        }
        return n2;
    }
    
    public long indexOf(final ByteString byteString) {
        return this.indexOf(byteString, 0L);
    }
    
    public long indexOf(final ByteString byteString, final long n) {
        if (byteString.size() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        if (n < 0L) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.head;
        final long n2 = -1;
        if (segment == null) {
            return n2;
        }
        long size;
        if (this.size - n < n) {
            for (size = this.size; size > n; size -= segment.limit - segment.pos) {
                segment = segment.prev;
            }
        }
        else {
            size = 0L;
            while (true) {
                final long n3 = segment.limit - segment.pos + size;
                if (n3 >= n) {
                    break;
                }
                segment = segment.next;
                size = n3;
            }
        }
        final byte byte1 = byteString.getByte(0);
        final int size2 = byteString.size();
        final long n4 = 1L + (this.size - size2);
        long n5 = n;
        Segment next = segment;
        long n14;
        for (long n6 = size; n6 < n4; n6 = (n5 = n6 + (next.limit - next.pos)), next = next.next, n14 = -1) {
            byte[] data = next.data;
            int n10;
            int n12;
            byte[] array;
            Segment segment2;
            long n13;
            for (int n7 = (int)Math.min(next.limit, next.pos + n4 - n6), i = (int)(next.pos + n5 - n6); i < n7; i = n10 + 1, next = segment2, n7 = n12, data = array, n13 = -1) {
                if (data[i] == byte1) {
                    final int n8 = i + 1;
                    final int n9 = 1;
                    n10 = i;
                    final int n11 = n8;
                    n12 = n7;
                    array = data;
                    segment2 = next;
                    if (this.rangeEquals(next, n11, byteString, n9, size2)) {
                        return n10 - next.pos + n6;
                    }
                }
                else {
                    n10 = i;
                    n12 = n7;
                    array = data;
                    segment2 = next;
                }
            }
        }
        return -1;
    }
    
    public long indexOfElement(final ByteString byteString) {
        return this.indexOfElement(byteString, 0L);
    }
    
    public long indexOfElement(final ByteString byteString, final long n) {
        Buffer buffer = this;
        if (n < 0L) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.head;
        final long n2 = -1;
        if (segment == null) {
            return n2;
        }
        long size;
        if (this.size - n < n) {
            for (size = this.size; size > n; size -= segment.limit - segment.pos) {
                segment = segment.prev;
            }
        }
        else {
            size = 0L;
            while (true) {
                final long n3 = segment.limit - segment.pos + size;
                if (n3 >= n) {
                    break;
                }
                segment = segment.next;
                size = n3;
            }
        }
        final int size2 = byteString.size();
        final int n4 = 2;
        int i = 0;
        if (size2 == n4) {
            final byte byte1 = byteString.getByte(0);
            final byte byte2 = byteString.getByte(1);
            long n5 = n;
            while (size < buffer.size) {
                final byte[] data = segment.data;
                for (int j = (int)(segment.pos + n5 - size); j < segment.limit; ++j) {
                    final byte b = data[j];
                    if (b == byte1 || b == byte2) {
                        return j - segment.pos + size;
                    }
                }
                size = (n5 = size + (segment.limit - segment.pos));
                segment = segment.next;
            }
        }
        else {
            final byte[] internalArray = byteString.internalArray();
            long n6 = n;
            while (size < buffer.size) {
                final byte[] data2 = segment.data;
                long n8;
                for (int k = (int)(segment.pos + n6 - size); k < segment.limit; ++k, n8 = -1, i = 0) {
                    final byte b2 = data2[k];
                    while (i < internalArray.length) {
                        if (b2 == internalArray[i]) {
                            return k - segment.pos + size;
                        }
                        ++i;
                        final long n7 = -1;
                    }
                }
                size = (n6 = size + (segment.limit - segment.pos));
                segment = segment.next;
                buffer = this;
                final long n9 = -1;
                i = 0;
            }
        }
        return -1;
    }
    
    public InputStream inputStream() {
        return new Buffer$2(this);
    }
    
    public ByteString md5() {
        return this.digest("MD5");
    }
    
    public OutputStream outputStream() {
        return new Buffer$1(this);
    }
    
    public boolean rangeEquals(final long n, final ByteString byteString) {
        return this.rangeEquals(n, byteString, 0, byteString.size());
    }
    
    public boolean rangeEquals(final long n, final ByteString byteString, final int n2, final int n3) {
        if (n >= 0L && n2 >= 0 && n3 >= 0 && this.size - n >= n3 && byteString.size() - n2 >= n3) {
            for (int i = 0; i < n3; ++i) {
                if (this.getByte(i + n) != byteString.getByte(n2 + i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public int read(final byte[] array) {
        return this.read(array, 0, array.length);
    }
    
    public int read(final byte[] array, final int n, final int n2) {
        Util.checkOffsetAndCount(array.length, n, n2);
        final Segment head = this.head;
        if (head == null) {
            return -1;
        }
        final int min = Math.min(n2, head.limit - head.pos);
        System.arraycopy(head.data, head.pos, array, n, min);
        head.pos += min;
        this.size -= min;
        if (head.pos == head.limit) {
            this.head = head.pop();
            SegmentPool.recycle(head);
        }
        return min;
    }
    
    public long read(final Buffer buffer, long size) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        final long n = 0L;
        if (size < n) {
            final StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        final long size2 = this.size;
        if (size2 == n) {
            return -1;
        }
        if (size > size2) {
            size = this.size;
        }
        buffer.write(this, size);
        return size;
    }
    
    public long readAll(final Sink sink) {
        final long size = this.size;
        if (size > 0L) {
            sink.write(this, size);
        }
        return size;
    }
    
    public byte readByte() {
        if (this.size != 0L) {
            final Segment head = this.head;
            final int pos = head.pos;
            final int limit = head.limit;
            final byte[] data = head.data;
            final int pos2 = pos + 1;
            final byte b = data[pos];
            --this.size;
            if (pos2 == limit) {
                this.head = head.pop();
                SegmentPool.recycle(head);
            }
            else {
                head.pos = pos2;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }
    
    public byte[] readByteArray() {
        try {
            return this.readByteArray(this.size);
        }
        catch (EOFException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public byte[] readByteArray(final long n) {
        Util.checkOffsetAndCount(this.size, 0L, n);
        if (n <= 2147483647L) {
            final byte[] array = new byte[(int)n];
            this.readFully(array);
            return array;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("byteCount > Integer.MAX_VALUE: ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public ByteString readByteString() {
        return new ByteString(this.readByteArray());
    }
    
    public ByteString readByteString(final long n) {
        return new ByteString(this.readByteArray(n));
    }
    
    public long readDecimalLong() {
        if (this.size != 0L) {
            long n = 0L;
            int n2 = 0;
            boolean b = false;
            int n3 = 0;
            float n4 = 0.0f;
            long n5 = -922337203685477580L;
            double n6 = -8.390303882365713E246;
            long n7 = -7;
            byte b2 = 0;
        Label_0244:
            while (true) {
                final Segment head = this.head;
                byte[] data = head.data;
                while (true) {
                    long n10;
                    double n11;
                    int n12;
                    float n13;
                    byte[] array;
                    for (int i = head.pos, limit = head.limit; i < limit; ++i, ++n2, n5 = n10, n6 = n11, n3 = n12, n4 = n13, data = array) {
                        b2 = data[i];
                        if (b2 >= 48 && b2 <= 57) {
                            final byte b3 = (byte)(48 - b2);
                            if (n < n5) {
                                final int n8 = n3;
                                final float n9 = n4;
                                break Label_0244;
                            }
                            int n8;
                            float n9;
                            if (n == n5) {
                                n10 = n5;
                                n11 = n6;
                                n8 = n3;
                                n9 = n4;
                                if (b3 < n7) {
                                    break Label_0244;
                                }
                            }
                            else {
                                n10 = n5;
                                n11 = n6;
                                n8 = n3;
                                n9 = n4;
                            }
                            n = n * 10 + b3;
                            n12 = n8;
                            n13 = n9;
                            array = data;
                        }
                        else {
                            n12 = n3;
                            n13 = n4;
                            n10 = n5;
                            n11 = n6;
                            array = data;
                            if (b2 == 45 && n2 == 0) {
                                b = true;
                                --n7;
                            }
                            else {
                                if (n2 == 0) {
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("Expected leading [0-9] or '-' character but was 0x");
                                    sb.append(Integer.toHexString(b2));
                                    throw new NumberFormatException(sb.toString());
                                }
                                n3 = 1;
                                n4 = Float.MIN_VALUE;
                                if (i == limit) {
                                    this.head = head.pop();
                                    SegmentPool.recycle(head);
                                }
                                else {
                                    head.pos = i;
                                }
                                if (n3 == 0 && this.head != null) {
                                    n5 = n10;
                                    n6 = n11;
                                    continue Label_0244;
                                }
                                this.size -= n2;
                                long n14;
                                if (b) {
                                    n14 = n;
                                }
                                else {
                                    n14 = -n;
                                }
                                return n14;
                            }
                        }
                    }
                    n10 = n5;
                    n11 = n6;
                    continue;
                }
            }
            final Buffer writeByte = new Buffer().writeDecimalLong(n).writeByte((int)b2);
            if (!b) {
                writeByte.readByte();
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Number too large: ");
            sb2.append(writeByte.readUtf8());
            throw new NumberFormatException(sb2.toString());
        }
        throw new IllegalStateException("size == 0");
    }
    
    public Buffer readFrom(final InputStream inputStream) {
        this.readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }
    
    public Buffer readFrom(final InputStream inputStream, final long n) {
        if (n >= 0L) {
            this.readFrom(inputStream, n, false);
            return this;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("byteCount < 0: ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void readFully(final Buffer buffer, final long n) {
        final long size = this.size;
        if (size >= n) {
            buffer.write(this, n);
            return;
        }
        buffer.write(this, size);
        throw new EOFException();
    }
    
    public void readFully(final byte[] array) {
        int read;
        for (int i = 0; i < array.length; i += read) {
            read = this.read(array, i, array.length - i);
            if (read == -1) {
                throw new EOFException();
            }
        }
    }
    
    public long readHexadecimalUnsignedLong() {
        final long size = this.size;
        final long n = 0L;
        if (size == n) {
            throw new IllegalStateException("size == 0");
        }
        long n2 = 0L;
        int n3 = 0;
        boolean b = false;
        while (true) {
            final Segment head = this.head;
            final byte[] data = head.data;
            int i;
            int limit;
            for (i = head.pos, limit = head.limit; i < limit; ++i, ++n3) {
                final byte b2 = data[i];
                byte b3;
                if (b2 >= 48 && b2 <= 57) {
                    b3 = (byte)(b2 - 48);
                }
                else if (b2 >= 97 && b2 <= 102) {
                    b3 = (byte)(b2 - 97 + 10);
                }
                else if (b2 >= 65 && b2 <= 70) {
                    b3 = (byte)(b2 - 65 + 10);
                }
                else {
                    if (n3 != 0) {
                        b = true;
                        break;
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Expected leading [0-9a-fA-F] character but was 0x");
                    sb.append(Integer.toHexString(b2));
                    throw new NumberFormatException(sb.toString());
                }
                if ((0xF000000000000000L & n2) != n) {
                    final Buffer writeByte = new Buffer().writeHexadecimalUnsignedLong(n2).writeByte((int)b2);
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Number too large: ");
                    sb2.append(writeByte.readUtf8());
                    throw new NumberFormatException(sb2.toString());
                }
                n2 = (n2 << 4 | b3);
            }
            if (i == limit) {
                this.head = head.pop();
                SegmentPool.recycle(head);
            }
            else {
                head.pos = i;
            }
            if (!b && this.head != null) {
                continue;
            }
            this.size -= n3;
            return n2;
        }
    }
    
    public int readInt() {
        final long size = this.size;
        final long n = 4;
        if (size < n) {
            final StringBuilder sb = new StringBuilder();
            sb.append("size < 4: ");
            sb.append(this.size);
            throw new IllegalStateException(sb.toString());
        }
        final Segment head = this.head;
        final int pos = head.pos;
        final int limit = head.limit;
        if (limit - pos < 4) {
            return (this.readByte() & 0xFF) << 24 | (this.readByte() & 0xFF) << 16 | (this.readByte() & 0xFF) << 8 | (this.readByte() & 0xFF);
        }
        final byte[] data = head.data;
        final int n2 = pos + 1;
        final int n3 = (data[pos] & 0xFF) << 24;
        final int n4 = n2 + 1;
        final int n5 = n3 | (data[n2] & 0xFF) << 16;
        final int n6 = n4 + 1;
        final int n7 = n5 | (data[n4] & 0xFF) << 8;
        final int pos2 = n6 + 1;
        final int n8 = n7 | (data[n6] & 0xFF);
        this.size -= n;
        if (pos2 == limit) {
            this.head = head.pop();
            SegmentPool.recycle(head);
        }
        else {
            head.pos = pos2;
        }
        return n8;
    }
    
    public int readIntLe() {
        return Util.reverseBytesInt(this.readInt());
    }
    
    public long readLong() {
        final long size = this.size;
        final long n = 8;
        if (size < n) {
            final StringBuilder sb = new StringBuilder();
            sb.append("size < 8: ");
            sb.append(this.size);
            throw new IllegalStateException(sb.toString());
        }
        final Segment head = this.head;
        final int pos = head.pos;
        final int limit = head.limit;
        final int n2 = limit - pos;
        final int n3 = 32;
        final int n4 = 8;
        if (n2 < n4) {
            final long n5 = this.readInt();
            final long n6 = 4294967295L;
            return (n5 & n6) << n3 | (this.readInt() & n6);
        }
        final byte[] data = head.data;
        final int n7 = pos + 1;
        final long n8 = data[pos];
        final long n9 = 255L;
        final long n10 = (n8 & n9) << 56;
        final int n11 = n7 + 1;
        final long n12 = n10 | (data[n7] & n9) << 48;
        final int n13 = n11 + 1;
        final long n14 = n12 | (data[n11] & n9) << 40;
        final int n15 = n13 + 1;
        final long n16 = n14 | (data[n13] & n9) << n3;
        final int n17 = n15 + 1;
        final long n18 = n16 | (data[n15] & n9) << 24;
        final int n19 = n17 + 1;
        final long n20 = n18 | (data[n17] & n9) << 16;
        final int n21 = n19 + 1;
        final long n22 = (data[n19] & n9) << n4 | n20;
        final int pos2 = n21 + 1;
        final long n23 = n22 | (data[n21] & n9);
        this.size -= n;
        if (pos2 == limit) {
            this.head = head.pop();
            SegmentPool.recycle(head);
        }
        else {
            head.pos = pos2;
        }
        return n23;
    }
    
    public long readLongLe() {
        return Util.reverseBytesLong(this.readLong());
    }
    
    public short readShort() {
        final long size = this.size;
        final long n = 2;
        if (size < n) {
            final StringBuilder sb = new StringBuilder();
            sb.append("size < 2: ");
            sb.append(this.size);
            throw new IllegalStateException(sb.toString());
        }
        final Segment head = this.head;
        final int pos = head.pos;
        final int limit = head.limit;
        if (limit - pos < 2) {
            return (short)((this.readByte() & 0xFF) << 8 | (this.readByte() & 0xFF));
        }
        final byte[] data = head.data;
        final int n2 = pos + 1;
        final int n3 = (data[pos] & 0xFF) << 8;
        final int pos2 = n2 + 1;
        final int n4 = n3 | (data[n2] & 0xFF);
        this.size -= n;
        if (pos2 == limit) {
            this.head = head.pop();
            SegmentPool.recycle(head);
        }
        else {
            head.pos = pos2;
        }
        return (short)n4;
    }
    
    public short readShortLe() {
        return Util.reverseBytesShort(this.readShort());
    }
    
    public String readString(final long n, final Charset charset) {
        Util.checkOffsetAndCount(this.size, 0L, n);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (n > 2147483647L) {
            final StringBuilder sb = new StringBuilder();
            sb.append("byteCount > Integer.MAX_VALUE: ");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString());
        }
        if (n == 0L) {
            return "";
        }
        final Segment head = this.head;
        if (head.pos + n > head.limit) {
            return new String(this.readByteArray(n), charset);
        }
        final String s = new String(head.data, head.pos, (int)n, charset);
        head.pos += (int)n;
        this.size -= n;
        if (head.pos == head.limit) {
            this.head = head.pop();
            SegmentPool.recycle(head);
        }
        return s;
    }
    
    public String readString(final Charset charset) {
        try {
            return this.readString(this.size, charset);
        }
        catch (EOFException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public String readUtf8() {
        try {
            final long size = this.size;
            try {
                return this.readString(size, Util.UTF_8);
            }
            catch (EOFException ex) {
                throw new AssertionError((Object)ex);
            }
        }
        catch (EOFException ex2) {}
    }
    
    public String readUtf8(final long n) {
        return this.readString(n, Util.UTF_8);
    }
    
    public int readUtf8CodePoint() {
        final long size = this.size;
        final long n = 0L;
        if (size == n) {
            throw new EOFException();
        }
        final byte byte1 = this.getByte(n);
        final int n2 = byte1 & 0x80;
        final char c = (char)(-3);
        int n3;
        int n4;
        int n5;
        if (n2 == 0) {
            n3 = (byte1 & 0x7F);
            n4 = 1;
            n5 = 0;
        }
        else if ((byte1 & 0xE0) == 0xC0) {
            n3 = (byte1 & 0x1F);
            n4 = 2;
            n5 = 128;
        }
        else if ((byte1 & 0xF0) == 0xE0) {
            n3 = (byte1 & 0xF);
            n4 = 3;
            n5 = 2048;
        }
        else {
            if ((byte1 & 0xF8) != 0xF0) {
                this.skip(1L);
                return c;
            }
            n3 = (byte1 & 0x7);
            n4 = 4;
            n5 = 65536;
        }
        if (this.size < n4) {
            final StringBuilder sb = new StringBuilder();
            sb.append("size < ");
            sb.append(n4);
            sb.append(": ");
            sb.append(this.size);
            sb.append(" (to read code point prefixed 0x");
            sb.append(Integer.toHexString(byte1));
            sb.append(")");
            throw new EOFException(sb.toString());
        }
        for (int i = 1; i < n4; ++i) {
            final byte byte2 = this.getByte(i);
            if ((byte2 & 0xC0) != 0x80) {
                this.skip(i);
                return c;
            }
            n3 = (n3 << 6 | (byte2 & 0x3F));
        }
        this.skip(n4);
        if (n3 > 1114111) {
            return c;
        }
        if (n3 >= 55296 && n3 <= 57343) {
            return c;
        }
        if (n3 < n5) {
            return c;
        }
        return n3;
    }
    
    public String readUtf8Line() {
        final long index = this.indexOf((byte)10);
        if (index == -1) {
            final long size = this.size;
            String utf8;
            if (size != 0L) {
                utf8 = this.readUtf8(size);
            }
            else {
                utf8 = null;
            }
            return utf8;
        }
        return this.readUtf8Line(index);
    }
    
    String readUtf8Line(final long n) {
        final long n2 = 1L;
        if (n > 0L && this.getByte(n - n2) == 13) {
            final String utf8 = this.readUtf8(n - n2);
            this.skip(2);
            return utf8;
        }
        final String utf9 = this.readUtf8(n);
        this.skip(n2);
        return utf9;
    }
    
    public String readUtf8LineStrict() {
        final long index = this.indexOf((byte)10);
        if (index != -1) {
            return this.readUtf8Line(index);
        }
        final Buffer buffer = new Buffer();
        this.copyTo(buffer, 0L, Math.min(32, this.size));
        final StringBuilder sb = new StringBuilder();
        sb.append("\\n not found: size=");
        sb.append(this.size());
        sb.append(" content=");
        sb.append(buffer.readByteString().hex());
        sb.append("\u2026");
        throw new EOFException(sb.toString());
    }
    
    public boolean request(final long n) {
        return this.size >= n;
    }
    
    public void require(final long n) {
        if (this.size >= n) {
            return;
        }
        throw new EOFException();
    }
    
    List segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        final ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(this.head.limit - this.head.pos);
        for (Segment segment = this.head.next; segment != this.head; segment = segment.next) {
            list.add(segment.limit - segment.pos);
        }
        return list;
    }
    
    public int select(final Options options) {
        final Segment head = this.head;
        if (head == null) {
            return options.indexOf(ByteString.EMPTY);
        }
        final ByteString[] byteStrings = options.byteStrings;
        for (int length = byteStrings.length, i = 0; i < length; ++i) {
            final ByteString byteString = byteStrings[i];
            if (this.size >= byteString.size() && this.rangeEquals(head, head.pos, byteString, 0, byteString.size())) {
                try {
                    this.skip(byteString.size());
                    return i;
                }
                catch (EOFException ex) {
                    throw new AssertionError((Object)ex);
                }
            }
        }
        return -1;
    }
    
    int selectPrefix(final Options options) {
        final Segment head = this.head;
        final ByteString[] byteStrings = options.byteStrings;
        for (int length = byteStrings.length, i = 0; i < length; ++i) {
            final ByteString byteString = byteStrings[i];
            final int n = (int)Math.min(this.size, byteString.size());
            if (n == 0 || this.rangeEquals(head, head.pos, byteString, 0, n)) {
                return i;
            }
        }
        return -1;
    }
    
    public ByteString sha1() {
        return this.digest("SHA-1");
    }
    
    public ByteString sha256() {
        return this.digest("SHA-256");
    }
    
    public long size() {
        return this.size;
    }
    
    public void skip(long n) {
        while (n > 0L) {
            final Segment head = this.head;
            if (head == null) {
                throw new EOFException();
            }
            final int n2 = (int)Math.min(n, head.limit - this.head.pos);
            this.size -= n2;
            n -= n2;
            final Segment head2 = this.head;
            head2.pos += n2;
            if (this.head.pos != this.head.limit) {
                continue;
            }
            final Segment head3 = this.head;
            this.head = head3.pop();
            SegmentPool.recycle(head3);
        }
    }
    
    public ByteString snapshot() {
        final long size = this.size;
        if (size <= 2147483647L) {
            return this.snapshot((int)size);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("size > Integer.MAX_VALUE: ");
        sb.append(this.size);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public ByteString snapshot(final int n) {
        if (n == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, n);
    }
    
    public Timeout timeout() {
        return Timeout.NONE;
    }
    
    public String toString() {
        return this.snapshot().toString();
    }
    
    Segment writableSegment(final int n) {
        if (n >= 1) {
            final int n2 = 8192;
            if (n <= n2) {
                final Segment head = this.head;
                if (head == null) {
                    this.head = SegmentPool.take();
                    final Segment head2 = this.head;
                    head2.prev = head2;
                    return head2.next = head2;
                }
                Segment segment = head.prev;
                if (segment.limit + n > n2 || segment.owner) {
                    segment = segment.push(SegmentPool.take());
                }
                return segment;
            }
        }
        throw new IllegalArgumentException();
    }
    
    public Buffer write(final ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }
    
    public Buffer write(final byte[] array) {
        if (array != null) {
            return this.write(array, 0, array.length);
        }
        throw new IllegalArgumentException("source == null");
    }
    
    public Buffer write(final byte[] array, int i, final int n) {
        if (array != null) {
            Util.checkOffsetAndCount(array.length, i, n);
            Segment writableSegment;
            int min;
            for (int n2 = i + n; i < n2; i += min, writableSegment.limit += min) {
                writableSegment = this.writableSegment(1);
                min = Math.min(n2 - i, 8192 - writableSegment.limit);
                System.arraycopy(array, i, writableSegment.data, writableSegment.limit, min);
            }
            this.size += n;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }
    
    public BufferedSink write(final Source source, long n) {
        while (n > 0L) {
            final long read = source.read(this, n);
            if (read == -1) {
                throw new EOFException();
            }
            n -= read;
        }
        return this;
    }
    
    public void write(final Buffer buffer, long n) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer != this) {
            Util.checkOffsetAndCount(buffer.size, 0L, n);
            while (n > 0L) {
                if (n < buffer.head.limit - buffer.head.pos) {
                    final Segment head = this.head;
                    Segment prev;
                    if (head != null) {
                        prev = head.prev;
                    }
                    else {
                        prev = null;
                    }
                    if (prev != null && prev.owner) {
                        final long n2 = prev.limit + n;
                        int pos;
                        if (prev.shared) {
                            pos = 0;
                        }
                        else {
                            pos = prev.pos;
                        }
                        if (n2 - pos <= 8192L) {
                            buffer.head.writeTo(prev, (int)n);
                            buffer.size -= n;
                            this.size += n;
                            return;
                        }
                    }
                    buffer.head = buffer.head.split((int)n);
                }
                final Segment head2 = buffer.head;
                final long n3 = head2.limit - head2.pos;
                buffer.head = head2.pop();
                final Segment head3 = this.head;
                if (head3 == null) {
                    this.head = head2;
                    final Segment head4 = this.head;
                    head4.prev = head4;
                    head4.next = head4;
                }
                else {
                    head3.prev.push(head2).compact();
                }
                buffer.size -= n3;
                this.size += n3;
                n -= n3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }
    
    public long writeAll(final Source source) {
        if (source != null) {
            long n = 0L;
            while (true) {
                final long read = source.read(this, 8192L);
                if (read == -1) {
                    break;
                }
                n += read;
            }
            return n;
        }
        throw new IllegalArgumentException("source == null");
    }
    
    public Buffer writeByte(final int n) {
        final Segment writableSegment = this.writableSegment(1);
        writableSegment.data[writableSegment.limit++] = (byte)n;
        ++this.size;
        return this;
    }
    
    public Buffer writeDecimalLong(long n) {
        final long n2 = 0L;
        if (n == n2) {
            return this.writeByte(48);
        }
        boolean b = false;
        if (n < n2) {
            n = -n;
            if (n < n2) {
                return this.writeUtf8("-9223372036854775808");
            }
            b = true;
        }
        final long n3 = 100000000L;
        final long n4 = 10;
        int n5;
        if (n < n3) {
            if (n < 10000L) {
                if (n < 100) {
                    if (n < n4) {
                        n5 = 1;
                    }
                    else {
                        n5 = 2;
                    }
                }
                else if (n < 1000L) {
                    n5 = 3;
                }
                else {
                    n5 = 4;
                }
            }
            else if (n < 1000000L) {
                if (n < 100000L) {
                    n5 = 5;
                }
                else {
                    n5 = 6;
                }
            }
            else if (n < 10000000L) {
                n5 = 7;
            }
            else {
                n5 = 8;
            }
        }
        else if (n < 1000000000000L) {
            if (n < 10000000000L) {
                if (n < 1000000000L) {
                    n5 = 9;
                }
                else {
                    n5 = 10;
                }
            }
            else if (n < 100000000000L) {
                n5 = 11;
            }
            else {
                n5 = 12;
            }
        }
        else if (n < 1000000000000000L) {
            if (n < 10000000000000L) {
                n5 = 13;
            }
            else if (n < 100000000000000L) {
                n5 = 14;
            }
            else {
                n5 = 15;
            }
        }
        else if (n < 100000000000000000L) {
            if (n < 10000000000000000L) {
                n5 = 16;
            }
            else {
                n5 = 17;
            }
        }
        else if (n < 1000000000000000000L) {
            n5 = 18;
        }
        else {
            n5 = 19;
        }
        if (b) {
            ++n5;
        }
        final Segment writableSegment = this.writableSegment(n5);
        final byte[] data = writableSegment.data;
        int n6 = writableSegment.limit + n5;
        while (n != n2) {
            final int n7 = (int)(n % n4);
            --n6;
            data[n6] = Buffer.DIGITS[n7];
            n /= n4;
        }
        if (b) {
            data[n6 - 1] = 45;
        }
        writableSegment.limit += n5;
        this.size += n5;
        return this;
    }
    
    public Buffer writeHexadecimalUnsignedLong(long n) {
        if (n == 0L) {
            return this.writeByte(48);
        }
        final int numberOfTrailingZeros = Long.numberOfTrailingZeros(Long.highestOneBit(n));
        final int n2 = 4;
        final int n3 = numberOfTrailingZeros / n2 + 1;
        final Segment writableSegment = this.writableSegment(n3);
        final byte[] data = writableSegment.data;
        for (int i = writableSegment.limit + n3 - 1; i >= writableSegment.limit; --i) {
            data[i] = Buffer.DIGITS[(int)(0xF & n)];
            n >>>= n2;
        }
        writableSegment.limit += n3;
        this.size += n3;
        return this;
    }
    
    public Buffer writeInt(final int n) {
        final Segment writableSegment = this.writableSegment(4);
        final byte[] data = writableSegment.data;
        final int limit = writableSegment.limit;
        final int n2 = limit + 1;
        data[limit] = (byte)(n >>> 24 & 0xFF);
        final int n3 = n2 + 1;
        data[n2] = (byte)(n >>> 16 & 0xFF);
        final int n4 = n3 + 1;
        data[n3] = (byte)(n >>> 8 & 0xFF);
        final int limit2 = n4 + 1;
        data[n4] = (byte)(n & 0xFF);
        writableSegment.limit = limit2;
        this.size += 4;
        return this;
    }
    
    public Buffer writeIntLe(final int n) {
        return this.writeInt(Util.reverseBytesInt(n));
    }
    
    public Buffer writeLong(final long n) {
        final int n2 = 8;
        final Segment writableSegment = this.writableSegment(n2);
        final byte[] data = writableSegment.data;
        final int limit = writableSegment.limit;
        final int n3 = limit + 1;
        final long n4 = n >>> 56;
        final long n5 = 255L;
        data[limit] = (byte)(n4 & n5);
        final int n6 = n3 + 1;
        data[n3] = (byte)(n >>> 48 & n5);
        final int n7 = n6 + 1;
        data[n6] = (byte)(n >>> 40 & n5);
        final int n8 = n7 + 1;
        data[n7] = (byte)(n >>> 32 & n5);
        final int n9 = n8 + 1;
        data[n8] = (byte)(n >>> 24 & n5);
        final int n10 = n9 + 1;
        data[n9] = (byte)(n >>> 16 & n5);
        final int n11 = n10 + 1;
        data[n10] = (byte)(n >>> n2 & n5);
        final int limit2 = n11 + 1;
        data[n11] = (byte)(n & n5);
        writableSegment.limit = limit2;
        this.size += 8;
        return this;
    }
    
    public Buffer writeLongLe(final long n) {
        return this.writeLong(Util.reverseBytesLong(n));
    }
    
    public Buffer writeShort(final int n) {
        final Segment writableSegment = this.writableSegment(2);
        final byte[] data = writableSegment.data;
        final int limit = writableSegment.limit;
        final int n2 = limit + 1;
        data[limit] = (byte)(n >>> 8 & 0xFF);
        final int limit2 = n2 + 1;
        data[n2] = (byte)(n & 0xFF);
        writableSegment.limit = limit2;
        this.size += 2;
        return this;
    }
    
    public Buffer writeShortLe(final int n) {
        return this.writeShort((int)Util.reverseBytesShort((short)n));
    }
    
    public Buffer writeString(final String s, final int n, final int n2, final Charset charset) {
        if (s == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (n < 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("beginIndex < 0: ");
            sb.append(n);
            throw new IllegalAccessError(sb.toString());
        }
        if (n2 < n) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("endIndex < beginIndex: ");
            sb2.append(n2);
            sb2.append(" < ");
            sb2.append(n);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (n2 > s.length()) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("endIndex > string.length: ");
            sb3.append(n2);
            sb3.append(" > ");
            sb3.append(s.length());
            throw new IllegalArgumentException(sb3.toString());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(Util.UTF_8)) {
            return this.writeUtf8(s);
        }
        final byte[] bytes = s.substring(n, n2).getBytes(charset);
        return this.write(bytes, 0, bytes.length);
    }
    
    public Buffer writeString(final String s, final Charset charset) {
        return this.writeString(s, 0, s.length(), charset);
    }
    
    public Buffer writeTo(final OutputStream outputStream) {
        return this.writeTo(outputStream, this.size);
    }
    
    public Buffer writeTo(final OutputStream outputStream, long n) {
        if (outputStream != null) {
            Util.checkOffsetAndCount(this.size, 0L, n);
            Segment head = this.head;
            while (n > 0L) {
                final int n2 = (int)Math.min(n, head.limit - head.pos);
                outputStream.write(head.data, head.pos, n2);
                head.pos += n2;
                this.size -= n2;
                n -= n2;
                if (head.pos == head.limit) {
                    final Segment segment = head;
                    head = (this.head = head.pop());
                    SegmentPool.recycle(segment);
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }
    
    public Buffer writeUtf8(final String s) {
        return this.writeUtf8(s, 0, s.length());
    }
    
    public Buffer writeUtf8(final String s, final int n, final int n2) {
        if (s == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (n < 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("beginIndex < 0: ");
            sb.append(n);
            throw new IllegalAccessError(sb.toString());
        }
        if (n2 < n) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("endIndex < beginIndex: ");
            sb2.append(n2);
            sb2.append(" < ");
            sb2.append(n);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (n2 <= s.length()) {
            int i = n;
            while (i < n2) {
                final char char1 = s.charAt(i);
                final char c = '\u0080';
                if (char1 < c) {
                    final Segment writableSegment = this.writableSegment(1);
                    final byte[] data = writableSegment.data;
                    final int n3 = writableSegment.limit - i;
                    final int min = Math.min(n2, 8192 - n3);
                    int j = i + 1;
                    data[i + n3] = (byte)char1;
                    while (j < min) {
                        final char char2 = s.charAt(j);
                        if (char2 >= c) {
                            break;
                        }
                        final int n4 = j + 1;
                        data[j + n3] = (byte)char2;
                        j = n4;
                    }
                    final int n5 = j + n3 - writableSegment.limit;
                    writableSegment.limit += n5;
                    this.size += n5;
                    i = j;
                }
                else if (char1 < '\u0800') {
                    this.writeByte(char1 >> 6 | '\u00c0');
                    this.writeByte(c | (char1 & '?'));
                    ++i;
                }
                else {
                    final char c2 = '\ud800';
                    final char c3 = '?';
                    if (char1 >= c2) {
                        final char c4 = '\udfff';
                        if (char1 <= c4) {
                            char char3;
                            if (i + 1 < n2) {
                                char3 = s.charAt(i + 1);
                            }
                            else {
                                char3 = '\0';
                            }
                            if (char1 <= '\udbff' && char3 >= '\udc00' && char3 <= c4) {
                                final int n6 = ((0xFFFF27FF & char1) << 10 | (0xFFFF23FF & char3)) + 65536;
                                this.writeByte(n6 >> 18 | 0xF0);
                                this.writeByte((n6 >> 12 & c3) | c);
                                this.writeByte((n6 >> 6 & c3) | c);
                                this.writeByte(c | (n6 & 0x3F));
                                i += 2;
                                continue;
                            }
                            this.writeByte((int)c3);
                            ++i;
                            continue;
                        }
                    }
                    this.writeByte(char1 >> 12 | '\u00e0');
                    this.writeByte((char1 >> 6 & c3) | c);
                    this.writeByte(c | (char1 & '?'));
                    ++i;
                }
            }
            return this;
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("endIndex > string.length: ");
        sb3.append(n2);
        sb3.append(" > ");
        sb3.append(s.length());
        throw new IllegalArgumentException(sb3.toString());
    }
    
    public Buffer writeUtf8CodePoint(final int n) {
        final int n2 = 128;
        if (n < n2) {
            this.writeByte(n);
        }
        else if (n < 2048) {
            this.writeByte(n >> 6 | 0xC0);
            this.writeByte(n2 | (n & 0x3F));
        }
        else if (n < 65536) {
            if (n >= 55296 && n <= 57343) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unexpected code point: ");
                sb.append(Integer.toHexString(n));
                throw new IllegalArgumentException(sb.toString());
            }
            this.writeByte(n >> 12 | 0xE0);
            this.writeByte((n >> 6 & 0x3F) | n2);
            this.writeByte(n2 | (n & 0x3F));
        }
        else {
            if (n > 1114111) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected code point: ");
                sb2.append(Integer.toHexString(n));
                throw new IllegalArgumentException(sb2.toString());
            }
            this.writeByte(n >> 18 | 0xF0);
            this.writeByte((n >> 12 & 0x3F) | n2);
            this.writeByte((n >> 6 & 0x3F) | n2);
            this.writeByte(n2 | (n & 0x3F));
        }
        return this;
    }
}
