// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal;

import java.util.concurrent.ThreadFactory;
import java.io.InterruptedIOException;
import okio.Buffer;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import okio.ByteString;
import java.security.MessageDigest;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import java.util.Locale;
import java.net.IDN;
import java.util.concurrent.TimeUnit;
import okio.Source;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.Closeable;
import java.util.regex.Pattern;
import java.nio.charset.Charset;
import java.util.TimeZone;

public final class Util
{
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final String[] EMPTY_STRING_ARRAY;
    public static final TimeZone UTC;
    public static final Charset UTF_8;
    private static final Pattern VERIFY_AS_IP_ADDRESS;
    
    static {
        EMPTY_BYTE_ARRAY = new byte[0];
        EMPTY_STRING_ARRAY = new String[0];
        UTF_8 = Charset.forName("UTF-8");
        UTC = TimeZone.getTimeZone("GMT");
        VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }
    
    public static void checkOffsetAndCount(final long n, final long n2, final long n3) {
        if ((n2 | n3) >= 0L && n2 <= n && n - n2 >= n3) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    public static void closeAll(final Closeable closeable, final Closeable closeable2) {
        Throwable t = null;
        try {
            closeable.close();
        }
        finally {
            final Throwable t2;
            t = t2;
        }
        try {
            closeable2.close();
        }
        finally {
            if (t == null) {
                final Throwable t3;
                t = t3;
            }
        }
        if (t == null) {
            return;
        }
        if (t instanceof IOException) {
            throw (IOException)t;
        }
        if (t instanceof RuntimeException) {
            throw (RuntimeException)t;
        }
        if (t instanceof Error) {
            throw (Error)t;
        }
        throw new AssertionError((Object)t);
    }
    
    public static void closeQuietly(final Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (Exception ex2) {}
            catch (RuntimeException ex) {
                throw ex;
            }
        }
    }
    
    public static void closeQuietly(final ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            }
            catch (Exception ex2) {}
            catch (RuntimeException ex) {
                throw ex;
            }
        }
    }
    
    public static void closeQuietly(final Socket socket) {
        if (socket != null) {
            while (true) {
                try {
                    socket.close();
                }
                catch (Exception ex2) {}
                catch (RuntimeException ex) {
                    throw ex;
                }
                catch (AssertionError assertionError) {
                    if (isAndroidGetsocknameError(assertionError)) {
                        continue;
                    }
                    throw assertionError;
                }
                break;
            }
        }
    }
    
    public static String[] concat(final String[] array, final String s) {
        final String[] array2 = new String[array.length + 1];
        System.arraycopy(array, 0, array2, 0, array.length);
        array2[array2.length - 1] = s;
        return array2;
    }
    
    private static boolean containsInvalidHostnameAsciiCodes(final String s) {
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            final char c = '\u001f';
            final boolean b = true;
            if (char1 <= c || char1 >= '\u007f') {
                return b;
            }
            if (" #%/:?@[\\]".indexOf(char1) != -1) {
                return b;
            }
        }
        return false;
    }
    
    public static int delimiterOffset(final String s, final int n, final int n2, final char c) {
        for (int i = n; i < n2; ++i) {
            if (s.charAt(i) == c) {
                return i;
            }
        }
        return n2;
    }
    
    public static int delimiterOffset(final String s, final int n, final int n2, final String s2) {
        for (int i = n; i < n2; ++i) {
            if (s2.indexOf(s.charAt(i)) != -1) {
                return i;
            }
        }
        return n2;
    }
    
    public static boolean discard(final Source source, final int n, final TimeUnit timeUnit) {
        try {
            return skipAll(source, n, timeUnit);
        }
        catch (IOException ex) {
            return false;
        }
    }
    
    public static String domainToAscii(final String s) {
        try {
            final String ascii = IDN.toASCII(s);
            try {
                final String lowerCase = ascii.toLowerCase(Locale.US);
                try {
                    if (lowerCase.isEmpty()) {
                        return null;
                    }
                    if (containsInvalidHostnameAsciiCodes(lowerCase)) {
                        return null;
                    }
                    return lowerCase;
                }
                catch (IllegalArgumentException ex) {
                    return null;
                }
            }
            catch (IllegalArgumentException ex2) {}
        }
        catch (IllegalArgumentException ex3) {}
    }
    
    public static boolean equal(final Object o, final Object o2) {
        return o == o2 || (o != null && o.equals(o2));
    }
    
    public static String format(final String s, final Object... array) {
        return String.format(Locale.US, s, array);
    }
    
    public static String hostHeader(final HttpUrl httpUrl, final boolean b) {
        String s;
        if (httpUrl.host().contains(":")) {
            final StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(httpUrl.host());
            sb.append("]");
            s = sb.toString();
        }
        else {
            s = httpUrl.host();
        }
        String string;
        if (!b && httpUrl.port() == HttpUrl.defaultPort(httpUrl.scheme())) {
            string = s;
        }
        else {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append(":");
            sb2.append(httpUrl.port());
            string = sb2.toString();
        }
        return string;
    }
    
    public static List immutableList(final List list) {
        return Collections.unmodifiableList((List<?>)new ArrayList<Object>(list));
    }
    
    public static List immutableList(final Object... array) {
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])array.clone()));
    }
    
    public static int indexOf(final Object[] array, final Object o) {
        for (int i = 0; i < array.length; ++i) {
            if (equal(array[i], o)) {
                return i;
            }
        }
        return -1;
    }
    
    private static List intersect(final Object[] array, final Object[] array2) {
        final ArrayList<Object> list = new ArrayList<Object>();
        for (int length = array.length, i = 0; i < length; ++i) {
            final Object o = array[i];
            for (int length2 = array2.length, j = 0; j < length2; ++j) {
                final Object o2 = array2[j];
                if (o.equals(o2)) {
                    list.add(o2);
                    break;
                }
            }
        }
        return list;
    }
    
    public static Object[] intersect(final Class clazz, final Object[] array, final Object[] array2) {
        final List intersect = intersect(array, array2);
        return intersect.toArray((Object[])Array.newInstance(clazz, intersect.size()));
    }
    
    public static boolean isAndroidGetsocknameError(final AssertionError assertionError) {
        return assertionError.getCause() != null && assertionError.getMessage() != null && assertionError.getMessage().contains("getsockname failed");
    }
    
    public static String md5Hex(final String s) {
        Object instance = "MD5";
        try {
            instance = MessageDigest.getInstance((String)instance);
            final byte[] digest = ((MessageDigest)instance).digest(s.getBytes("UTF-8"));
            try {
                final ByteString of = ByteString.of(digest);
                try {
                    return of.hex();
                }
                catch (UnsupportedEncodingException instance) {}
                catch (NoSuchAlgorithmException ex) {}
            }
            catch (UnsupportedEncodingException ex2) {}
            catch (NoSuchAlgorithmException ex3) {}
        }
        catch (UnsupportedEncodingException ex4) {}
        catch (NoSuchAlgorithmException ex5) {}
        throw new AssertionError(instance);
    }
    
    public static ByteString sha1(final ByteString byteString) {
        final String s = "SHA-1";
        try {
            final MessageDigest instance = MessageDigest.getInstance(s);
            try {
                final byte[] digest = instance.digest(byteString.toByteArray());
                try {
                    return ByteString.of(digest);
                }
                catch (NoSuchAlgorithmException ex) {
                    throw new AssertionError((Object)ex);
                }
            }
            catch (NoSuchAlgorithmException ex2) {}
        }
        catch (NoSuchAlgorithmException ex3) {}
    }
    
    public static ByteString sha256(final ByteString byteString) {
        final String s = "SHA-256";
        try {
            final MessageDigest instance = MessageDigest.getInstance(s);
            try {
                final byte[] digest = instance.digest(byteString.toByteArray());
                try {
                    return ByteString.of(digest);
                }
                catch (NoSuchAlgorithmException ex) {
                    throw new AssertionError((Object)ex);
                }
            }
            catch (NoSuchAlgorithmException ex2) {}
        }
        catch (NoSuchAlgorithmException ex3) {}
    }
    
    public static String shaBase64(final String s) {
        Object instance = "SHA-1";
        try {
            instance = MessageDigest.getInstance((String)instance);
            final byte[] digest = ((MessageDigest)instance).digest(s.getBytes("UTF-8"));
            try {
                final ByteString of = ByteString.of(digest);
                try {
                    return of.base64();
                }
                catch (UnsupportedEncodingException instance) {}
                catch (NoSuchAlgorithmException ex) {}
            }
            catch (UnsupportedEncodingException ex2) {}
            catch (NoSuchAlgorithmException ex3) {}
        }
        catch (UnsupportedEncodingException ex4) {}
        catch (NoSuchAlgorithmException ex5) {}
        throw new AssertionError(instance);
    }
    
    public static boolean skipAll(final Source source, final int n, final TimeUnit timeUnit) {
        final long nanoTime = System.nanoTime();
        final boolean hasDeadline = source.timeout().hasDeadline();
        final long n2 = Long.MAX_VALUE;
        long n3;
        if (hasDeadline) {
            n3 = source.timeout().deadlineNanoTime() - nanoTime;
        }
        else {
            n3 = n2;
        }
        source.timeout().deadlineNanoTime(Math.min(n3, timeUnit.toNanos(n)) + nanoTime);
        try {
            try {
                final Buffer buffer = new Buffer();
                while (source.read(buffer, 8192L) != -1) {
                    buffer.clear();
                }
                return true;
            }
            catch (InterruptedIOException ex) {
                return false;
            }
        }
        catch (InterruptedIOException ex2) {}
    }
    
    public static int skipLeadingAsciiWhitespace(final String s, final int n, final int n2) {
        int i = n;
        while (i < n2) {
            switch (s.charAt(i)) {
                default: {
                    return i;
                }
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ': {
                    ++i;
                    continue;
                }
            }
        }
        return n2;
    }
    
    public static int skipTrailingAsciiWhitespace(final String s, final int n, final int n2) {
        int i = n2 - 1;
        while (i >= n) {
            switch (s.charAt(i)) {
                default: {
                    return i + 1;
                }
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ': {
                    --i;
                    continue;
                }
            }
        }
        return n;
    }
    
    public static ThreadFactory threadFactory(final String s, final boolean b) {
        return new Util$1(s, b);
    }
    
    public static String toHumanReadableAscii(final String s) {
        int codePoint;
        for (int i = 0, length = s.length(); i < length; i += Character.charCount(codePoint)) {
            codePoint = s.codePointAt(i);
            final int n = 127;
            final int n2 = 31;
            if (codePoint <= n2 || codePoint >= n) {
                final Buffer buffer = new Buffer();
                buffer.writeUtf8(s, 0, i);
                int codePoint2;
                for (int j = i; j < length; j += Character.charCount(codePoint2)) {
                    codePoint2 = s.codePointAt(j);
                    int n3;
                    if (codePoint2 > n2 && codePoint2 < n) {
                        n3 = codePoint2;
                    }
                    else {
                        n3 = 63;
                    }
                    buffer.writeUtf8CodePoint(n3);
                }
                return buffer.readUtf8();
            }
        }
        return s;
    }
    
    public static String trimSubstring(final String s, final int n, final int n2) {
        final int skipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(s, n, n2);
        return s.substring(skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace(s, skipLeadingAsciiWhitespace, n2));
    }
    
    public static boolean verifyAsIpAddress(final String s) {
        return Util.VERIFY_AS_IP_ADDRESS.matcher(s).matches();
    }
}
