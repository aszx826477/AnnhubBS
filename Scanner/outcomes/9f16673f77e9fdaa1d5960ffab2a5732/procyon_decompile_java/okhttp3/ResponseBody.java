// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import okio.Buffer;
import okio.BufferedSource;
import okhttp3.internal.Util;
import java.nio.charset.Charset;
import java.io.Reader;
import java.io.Closeable;

public abstract class ResponseBody implements Closeable
{
    private Reader reader;
    
    private Charset charset() {
        final MediaType contentType = this.contentType();
        Charset charset;
        if (contentType != null) {
            charset = contentType.charset(Util.UTF_8);
        }
        else {
            charset = Util.UTF_8;
        }
        return charset;
    }
    
    public static ResponseBody create(final MediaType mediaType, final long n, final BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new ResponseBody$1(mediaType, n, bufferedSource);
        }
        throw new NullPointerException("source == null");
    }
    
    public static ResponseBody create(MediaType parse, final String s) {
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
        final Buffer writeString = new Buffer().writeString(s, charset);
        return create(parse, writeString.size(), writeString);
    }
    
    public static ResponseBody create(final MediaType mediaType, final byte[] array) {
        return create(mediaType, array.length, new Buffer().write(array));
    }
    
    public final InputStream byteStream() {
        return this.source().inputStream();
    }
    
    public final byte[] bytes() {
        final long contentLength = this.contentLength();
        if (contentLength <= 2147483647L) {
            final BufferedSource source = this.source();
            try {
                final byte[] byteArray = source.readByteArray();
                Util.closeQuietly(source);
                if (contentLength != -1 && contentLength != byteArray.length) {
                    throw new IOException("Content-Length and stream length disagree");
                }
                return byteArray;
            }
            finally {
                Util.closeQuietly(source);
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot buffer entire body for content length: ");
        sb.append(contentLength);
        throw new IOException(sb.toString());
    }
    
    public final Reader charStream() {
        final Reader reader = this.reader;
        Reader reader2;
        if (reader != null) {
            reader2 = reader;
        }
        else {
            reader2 = new InputStreamReader(this.byteStream(), this.charset());
            this.reader = reader2;
        }
        return reader2;
    }
    
    public void close() {
        Util.closeQuietly(this.source());
    }
    
    public abstract long contentLength();
    
    public abstract MediaType contentType();
    
    public abstract BufferedSource source();
    
    public final String string() {
        return new String(this.bytes(), this.charset().name());
    }
}
