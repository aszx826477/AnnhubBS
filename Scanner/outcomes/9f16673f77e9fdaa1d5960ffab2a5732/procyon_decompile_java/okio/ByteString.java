// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.OutputStream;
import java.util.Arrays;
import java.nio.ByteBuffer;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.io.Serializable;

public class ByteString implements Serializable, Comparable
{
    public static final ByteString EMPTY;
    static final char[] HEX_DIGITS;
    private static final long serialVersionUID = 1L;
    final byte[] data;
    transient int hashCode;
    transient String utf8;
    
    static {
        final char[] array;
        final char[] hex_DIGITS = array = new char[16];
        array[0] = '0';
        array[1] = '1';
        array[2] = '2';
        array[3] = '3';
        array[4] = '4';
        array[5] = '5';
        array[6] = '6';
        array[7] = '7';
        array[8] = '8';
        array[9] = '9';
        array[10] = 'a';
        array[11] = 'b';
        array[12] = 'c';
        array[13] = 'd';
        array[14] = 'e';
        array[15] = 'f';
        HEX_DIGITS = hex_DIGITS;
        EMPTY = of(new byte[0]);
    }
    
    ByteString(final byte[] data) {
        this.data = data;
    }
    
    static int codePointIndexToCharIndex(final String s, final int n) {
        int i = 0;
        int n2 = 0;
        while (i < s.length()) {
            if (n2 == n) {
                return i;
            }
            final int codePoint = s.codePointAt(i);
            if ((Character.isISOControl(codePoint) && codePoint != '\n' && codePoint != '\r') || codePoint == (char)(-3)) {
                return -1;
            }
            ++n2;
            i += Character.charCount(codePoint);
        }
        return s.length();
    }
    
    public static ByteString decodeBase64(final String s) {
        if (s != null) {
            final byte[] decode = Base64.decode(s);
            ByteString byteString;
            if (decode != null) {
                byteString = new ByteString(decode);
            }
            else {
                byteString = null;
            }
            return byteString;
        }
        throw new IllegalArgumentException("base64 == null");
    }
    
    public static ByteString decodeHex(final String s) {
        if (s == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (s.length() % 2 == 0) {
            final byte[] array = new byte[s.length() / 2];
            for (int i = 0; i < array.length; ++i) {
                array[i] = (byte)((decodeHexDigit(s.charAt(i * 2)) << 4) + decodeHexDigit(s.charAt(i * 2 + 1)));
            }
            return of(array);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unexpected hex string: ");
        sb.append(s);
        throw new IllegalArgumentException(sb.toString());
    }
    
    private static int decodeHexDigit(final char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'a' && c <= 'f') {
            return c - 97 + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return c - 65 + 10;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unexpected hex digit: ");
        sb.append(c);
        throw new IllegalArgumentException(sb.toString());
    }
    
    private ByteString digest(final String s) {
        try {
            final MessageDigest instance = MessageDigest.getInstance(s);
            try {
                final byte[] digest = instance.digest(this.data);
                try {
                    return of(digest);
                }
                catch (NoSuchAlgorithmException ex) {
                    throw new AssertionError((Object)ex);
                }
            }
            catch (NoSuchAlgorithmException ex2) {}
        }
        catch (NoSuchAlgorithmException ex3) {}
    }
    
    public static ByteString encodeUtf8(final String utf8) {
        if (utf8 != null) {
            final ByteString byteString = new ByteString(utf8.getBytes(Util.UTF_8));
            byteString.utf8 = utf8;
            return byteString;
        }
        throw new IllegalArgumentException("s == null");
    }
    
    public static ByteString of(final byte... array) {
        if (array != null) {
            return new ByteString(array.clone());
        }
        throw new IllegalArgumentException("data == null");
    }
    
    public static ByteString of(final byte[] array, final int n, final int n2) {
        if (array != null) {
            Util.checkOffsetAndCount(array.length, n, n2);
            final byte[] array2 = new byte[n2];
            System.arraycopy(array, n, array2, 0, n2);
            return new ByteString(array2);
        }
        throw new IllegalArgumentException("data == null");
    }
    
    public static ByteString read(final InputStream inputStream, final int n) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (n >= 0) {
            final byte[] array = new byte[n];
            int read;
            for (int i = 0; i < n; i += read) {
                read = inputStream.read(array, i, n - i);
                if (read == -1) {
                    throw new EOFException();
                }
            }
            return new ByteString(array);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("byteCount < 0: ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        final ByteString read = read(objectInputStream, objectInputStream.readInt());
        final Class<ByteString> clazz = ByteString.class;
        final String s = "data";
        final Class<ByteString> clazz2 = clazz;
        try {
            final Field declaredField = clazz2.getDeclaredField(s);
            declaredField.setAccessible(true);
            declaredField.set(this, read.data);
        }
        catch (IllegalAccessException ex) {
            throw new AssertionError();
        }
        catch (NoSuchFieldException ex2) {
            throw new AssertionError();
        }
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }
    
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }
    
    public String base64() {
        return Base64.encode(this.data);
    }
    
    public String base64Url() {
        return Base64.encodeUrl(this.data);
    }
    
    public int compareTo(final ByteString byteString) {
        final int size = this.size();
        final int size2 = byteString.size();
        int n = 0;
        final int min = Math.min(size, size2);
        while (true) {
            int n2 = -1;
            if (n < min) {
                final int n3 = this.getByte(n) & 0xFF;
                final int n4 = byteString.getByte(n) & 0xFF;
                if (n3 != n4) {
                    if (n3 >= n4) {
                        n2 = 1;
                    }
                    return n2;
                }
                ++n;
            }
            else {
                if (size == size2) {
                    return 0;
                }
                if (size >= size2) {
                    n2 = 1;
                }
                return n2;
            }
        }
    }
    
    public final boolean endsWith(final ByteString byteString) {
        return this.rangeEquals(this.size() - byteString.size(), byteString, 0, byteString.size());
    }
    
    public final boolean endsWith(final byte[] array) {
        return this.rangeEquals(this.size() - array.length, array, 0, array.length);
    }
    
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return b;
        }
        if (o instanceof ByteString) {
            final int size = ((ByteString)o).size();
            final byte[] data = this.data;
            if (size == data.length) {
                if (((ByteString)o).rangeEquals(0, data, 0, data.length)) {
                    return b;
                }
            }
        }
        b = false;
        return b;
    }
    
    public byte getByte(final int n) {
        return this.data[n];
    }
    
    public int hashCode() {
        final int hashCode = this.hashCode;
        int hashCode2;
        if (hashCode != 0) {
            hashCode2 = hashCode;
        }
        else {
            hashCode2 = Arrays.hashCode(this.data);
            this.hashCode = hashCode2;
        }
        return hashCode2;
    }
    
    public String hex() {
        final byte[] data = this.data;
        final char[] array = new char[data.length * 2];
        int n = 0;
        for (int length = data.length, i = 0; i < length; ++i) {
            final byte b = data[i];
            final int n2 = n + 1;
            final char[] hex_DIGITS = ByteString.HEX_DIGITS;
            array[n] = hex_DIGITS[b >> 4 & 0xF];
            n = n2 + 1;
            array[n2] = hex_DIGITS[b & 0xF];
        }
        return new String(array);
    }
    
    public final int indexOf(final ByteString byteString) {
        return this.indexOf(byteString.internalArray(), 0);
    }
    
    public final int indexOf(final ByteString byteString, final int n) {
        return this.indexOf(byteString.internalArray(), n);
    }
    
    public final int indexOf(final byte[] array) {
        return this.indexOf(array, 0);
    }
    
    public int indexOf(final byte[] array, int n) {
        int i;
        for (n = (i = Math.max(n, 0)); i <= this.data.length - array.length; ++i) {
            if (Util.arrayRangeEquals(this.data, i, array, 0, array.length)) {
                return i;
            }
        }
        return -1;
    }
    
    byte[] internalArray() {
        return this.data;
    }
    
    public final int lastIndexOf(final ByteString byteString) {
        return this.lastIndexOf(byteString.internalArray(), this.size());
    }
    
    public final int lastIndexOf(final ByteString byteString, final int n) {
        return this.lastIndexOf(byteString.internalArray(), n);
    }
    
    public final int lastIndexOf(final byte[] array) {
        return this.lastIndexOf(array, this.size());
    }
    
    public int lastIndexOf(final byte[] array, int n) {
        int i;
        for (n = (i = Math.min(n, this.data.length - array.length)); i >= 0; --i) {
            if (Util.arrayRangeEquals(this.data, i, array, 0, array.length)) {
                return i;
            }
        }
        return -1;
    }
    
    public ByteString md5() {
        return this.digest("MD5");
    }
    
    public boolean rangeEquals(final int n, final ByteString byteString, final int n2, final int n3) {
        return byteString.rangeEquals(n2, this.data, n, n3);
    }
    
    public boolean rangeEquals(final int n, final byte[] array, final int n2, final int n3) {
        if (n >= 0) {
            final byte[] data = this.data;
            if (n <= data.length - n3 && n2 >= 0 && n2 <= array.length - n3) {
                if (Util.arrayRangeEquals(data, n, array, n2, n3)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public ByteString sha1() {
        return this.digest("SHA-1");
    }
    
    public ByteString sha256() {
        return this.digest("SHA-256");
    }
    
    public int size() {
        return this.data.length;
    }
    
    public final boolean startsWith(final ByteString byteString) {
        return this.rangeEquals(0, byteString, 0, byteString.size());
    }
    
    public final boolean startsWith(final byte[] array) {
        return this.rangeEquals(0, array, 0, array.length);
    }
    
    public ByteString substring(final int n) {
        return this.substring(n, this.data.length);
    }
    
    public ByteString substring(final int n, final int n2) {
        if (n < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        final byte[] data = this.data;
        if (n2 > data.length) {
            final StringBuilder sb = new StringBuilder();
            sb.append("endIndex > length(");
            sb.append(this.data.length);
            sb.append(")");
            throw new IllegalArgumentException(sb.toString());
        }
        final int n3 = n2 - n;
        if (n3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (n == 0 && n2 == data.length) {
            return this;
        }
        final byte[] array = new byte[n3];
        System.arraycopy(this.data, n, array, 0, n3);
        return new ByteString(array);
    }
    
    public ByteString toAsciiLowercase() {
        int n = 0;
        while (true) {
            final byte[] data = this.data;
            if (n >= data.length) {
                return this;
            }
            final byte b = data[n];
            final byte b2 = 65;
            if (b >= b2) {
                final byte b3 = 90;
                if (b <= b3) {
                    final byte[] array = data.clone();
                    int i = n + 1;
                    array[n] = (byte)(b + 32);
                    while (i < array.length) {
                        final byte b4 = array[i];
                        if (b4 >= b2) {
                            if (b4 <= b3) {
                                array[i] = (byte)(b4 + 32);
                            }
                        }
                        ++i;
                    }
                    return new ByteString(array);
                }
            }
            ++n;
        }
    }
    
    public ByteString toAsciiUppercase() {
        int n = 0;
        while (true) {
            final byte[] data = this.data;
            if (n >= data.length) {
                return this;
            }
            final byte b = data[n];
            final byte b2 = 97;
            if (b >= b2) {
                final byte b3 = 122;
                if (b <= b3) {
                    final byte[] array = data.clone();
                    int i = n + 1;
                    array[n] = (byte)(b - 32);
                    while (i < array.length) {
                        final byte b4 = array[i];
                        if (b4 >= b2) {
                            if (b4 <= b3) {
                                array[i] = (byte)(b4 - 32);
                            }
                        }
                        ++i;
                    }
                    return new ByteString(array);
                }
            }
            ++n;
        }
    }
    
    public byte[] toByteArray() {
        return this.data.clone();
    }
    
    public String toString() {
        if (this.data.length == 0) {
            return "[size=0]";
        }
        final String utf8 = this.utf8();
        final int n = 64;
        final int codePointIndexToCharIndex = codePointIndexToCharIndex(utf8, n);
        if (codePointIndexToCharIndex == -1) {
            String s;
            if (this.data.length <= n) {
                final StringBuilder sb = new StringBuilder();
                sb.append("[hex=");
                sb.append(this.hex());
                sb.append("]");
                s = sb.toString();
            }
            else {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("[size=");
                sb2.append(this.data.length);
                sb2.append(" hex=");
                sb2.append(this.substring(0, n).hex());
                sb2.append("\u2026]");
                s = sb2.toString();
            }
            return s;
        }
        final String replace = utf8.substring(0, codePointIndexToCharIndex).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        StringBuilder sb3;
        String s2;
        if (codePointIndexToCharIndex < utf8.length()) {
            sb3 = new StringBuilder();
            sb3.append("[size=");
            sb3.append(this.data.length);
            sb3.append(" text=");
            sb3.append(replace);
            s2 = "\u2026]";
        }
        else {
            sb3 = new StringBuilder();
            sb3.append("[text=");
            sb3.append(replace);
            s2 = "]";
        }
        sb3.append(s2);
        return sb3.toString();
    }
    
    public String utf8() {
        final String utf8 = this.utf8;
        String utf9;
        if (utf8 != null) {
            utf9 = utf8;
        }
        else {
            utf9 = new String(this.data, Util.UTF_8);
            this.utf8 = utf9;
        }
        return utf9;
    }
    
    public void write(final OutputStream outputStream) {
        if (outputStream != null) {
            outputStream.write(this.data);
            return;
        }
        throw new IllegalArgumentException("out == null");
    }
    
    void write(final Buffer buffer) {
        final byte[] data = this.data;
        buffer.write(data, 0, data.length);
    }
}
