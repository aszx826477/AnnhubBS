// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okio.BufferedSink;
import okio.ByteString;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import java.io.File;

public abstract class RequestBody
{
    public static RequestBody create(final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody$3(mediaType, file);
        }
        throw new NullPointerException("content == null");
    }
    
    public static RequestBody create(MediaType parse, final String s) {
        Charset charset = Util.UTF_8;
        if (parse != null) {
            charset = parse.charset();
            if (charset == null) {
                charset = Util.UTF_8;
                final StringBuilder sb = new StringBuilder();
                sb.append(parse);
                sb.append("; charset=utf-8");
                parse = MediaType.parse(sb.toString());
            }
        }
        return create(parse, s.getBytes(charset));
    }
    
    public static RequestBody create(final MediaType mediaType, final ByteString byteString) {
        return new RequestBody$1(mediaType, byteString);
    }
    
    public static RequestBody create(final MediaType mediaType, final byte[] array) {
        return create(mediaType, array, 0, array.length);
    }
    
    public static RequestBody create(final MediaType mediaType, final byte[] array, final int n, final int n2) {
        if (array != null) {
            Util.checkOffsetAndCount(array.length, n, n2);
            return new RequestBody$2(mediaType, n2, array, n);
        }
        throw new NullPointerException("content == null");
    }
    
    public long contentLength() {
        return -1;
    }
    
    public abstract MediaType contentType();
    
    public abstract void writeTo(final BufferedSink p0);
}
