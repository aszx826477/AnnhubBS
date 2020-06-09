// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okio.Buffer;
import okio.BufferedSink;
import okhttp3.internal.Util;
import java.util.List;
import okio.ByteString;

public final class MultipartBody extends RequestBody
{
    public static final MediaType ALTERNATIVE;
    private static final byte[] COLONSPACE;
    private static final byte[] CRLF;
    private static final byte[] DASHDASH;
    public static final MediaType DIGEST;
    public static final MediaType FORM;
    public static final MediaType MIXED;
    public static final MediaType PARALLEL;
    private final ByteString boundary;
    private long contentLength;
    private final MediaType contentType;
    private final MediaType originalType;
    private final List parts;
    
    static {
        MIXED = MediaType.parse("multipart/mixed");
        ALTERNATIVE = MediaType.parse("multipart/alternative");
        DIGEST = MediaType.parse("multipart/digest");
        PARALLEL = MediaType.parse("multipart/parallel");
        FORM = MediaType.parse("multipart/form-data");
        final int n = 2;
        final byte[] array;
        final byte[] colonspace = array = new byte[n];
        array[0] = 58;
        array[1] = 32;
        COLONSPACE = colonspace;
        final byte[] array2;
        final byte[] crlf = array2 = new byte[n];
        array2[0] = 13;
        array2[1] = 10;
        CRLF = crlf;
        final byte[] array3;
        final byte[] dashdash = array3 = new byte[n];
        array3[1] = (array3[0] = 45);
        DASHDASH = dashdash;
    }
    
    MultipartBody(final ByteString boundary, final MediaType originalType, final List list) {
        this.contentLength = -1;
        this.boundary = boundary;
        this.originalType = originalType;
        final StringBuilder sb = new StringBuilder();
        sb.append(originalType);
        sb.append("; boundary=");
        sb.append(boundary.utf8());
        this.contentType = MediaType.parse(sb.toString());
        this.parts = Util.immutableList(list);
    }
    
    static StringBuilder appendQuotedString(final StringBuilder sb, final String s) {
        final char c = '\"';
        sb.append(c);
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 != '\n') {
                if (char1 != '\r') {
                    if (char1 != c) {
                        sb.append(char1);
                    }
                    else {
                        sb.append("%22");
                    }
                }
                else {
                    sb.append("%0D");
                }
            }
            else {
                sb.append("%0A");
            }
        }
        sb.append(c);
        return sb;
    }
    
    private long writeOrCountBytes(final BufferedSink bufferedSink, final boolean b) {
        long n = 0L;
        Buffer buffer = null;
        BufferedSink bufferedSink2;
        if (b) {
            bufferedSink2 = (buffer = new Buffer());
        }
        else {
            bufferedSink2 = bufferedSink;
        }
        for (int i = 0; i < this.parts.size(); ++i) {
            final MultipartBody$Part multipartBody$Part = this.parts.get(i);
            final Headers access$000 = multipartBody$Part.headers;
            final RequestBody access$2 = multipartBody$Part.body;
            bufferedSink2.write(MultipartBody.DASHDASH);
            bufferedSink2.write(this.boundary);
            bufferedSink2.write(MultipartBody.CRLF);
            if (access$000 != null) {
                for (int j = 0; j < access$000.size(); ++j) {
                    bufferedSink2.writeUtf8(access$000.name(j)).write(MultipartBody.COLONSPACE).writeUtf8(access$000.value(j)).write(MultipartBody.CRLF);
                }
            }
            final MediaType contentType = access$2.contentType();
            if (contentType != null) {
                bufferedSink2.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(MultipartBody.CRLF);
            }
            final long contentLength = access$2.contentLength();
            final long n2 = -1;
            if (contentLength != n2) {
                bufferedSink2.writeUtf8("Content-Length: ").writeDecimalLong(contentLength).write(MultipartBody.CRLF);
            }
            else if (b) {
                buffer.clear();
                return n2;
            }
            bufferedSink2.write(MultipartBody.CRLF);
            if (b) {
                n += contentLength;
            }
            else {
                access$2.writeTo(bufferedSink2);
            }
            bufferedSink2.write(MultipartBody.CRLF);
        }
        bufferedSink2.write(MultipartBody.DASHDASH);
        bufferedSink2.write(this.boundary);
        bufferedSink2.write(MultipartBody.DASHDASH);
        bufferedSink2.write(MultipartBody.CRLF);
        if (b) {
            n += buffer.size();
            buffer.clear();
        }
        return n;
    }
    
    public String boundary() {
        return this.boundary.utf8();
    }
    
    public long contentLength() {
        final long contentLength = this.contentLength;
        if (contentLength != -1) {
            return contentLength;
        }
        return this.contentLength = this.writeOrCountBytes(null, true);
    }
    
    public MediaType contentType() {
        return this.contentType;
    }
    
    public MultipartBody$Part part(final int n) {
        return this.parts.get(n);
    }
    
    public List parts() {
        return this.parts;
    }
    
    public int size() {
        return this.parts.size();
    }
    
    public MediaType type() {
        return this.originalType;
    }
    
    public void writeTo(final BufferedSink bufferedSink) {
        this.writeOrCountBytes(bufferedSink, false);
    }
}
