// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okio.BufferedSource;
import okio.Buffer;
import okhttp3.internal.http.HttpHeaders;
import java.util.Collections;
import java.util.List;
import java.io.Closeable;

public final class Response implements Closeable
{
    private final ResponseBody body;
    private volatile CacheControl cacheControl;
    private final Response cacheResponse;
    private final int code;
    private final Handshake handshake;
    private final Headers headers;
    private final String message;
    private final Response networkResponse;
    private final Response priorResponse;
    private final Protocol protocol;
    private final long receivedResponseAtMillis;
    private final Request request;
    private final long sentRequestAtMillis;
    
    private Response(final Response$Builder response$Builder) {
        this.request = response$Builder.request;
        this.protocol = response$Builder.protocol;
        this.code = response$Builder.code;
        this.message = response$Builder.message;
        this.handshake = response$Builder.handshake;
        this.headers = response$Builder.headers.build();
        this.body = response$Builder.body;
        this.networkResponse = response$Builder.networkResponse;
        this.cacheResponse = response$Builder.cacheResponse;
        this.priorResponse = response$Builder.priorResponse;
        this.sentRequestAtMillis = response$Builder.sentRequestAtMillis;
        this.receivedResponseAtMillis = response$Builder.receivedResponseAtMillis;
    }
    
    public ResponseBody body() {
        return this.body;
    }
    
    public CacheControl cacheControl() {
        final CacheControl cacheControl = this.cacheControl;
        CacheControl parse;
        if (cacheControl != null) {
            parse = cacheControl;
        }
        else {
            parse = CacheControl.parse(this.headers);
            this.cacheControl = parse;
        }
        return parse;
    }
    
    public Response cacheResponse() {
        return this.cacheResponse;
    }
    
    public List challenges() {
        final int code = this.code;
        String s;
        if (code == 401) {
            s = "WWW-Authenticate";
        }
        else {
            if (code != 407) {
                return Collections.emptyList();
            }
            s = "Proxy-Authenticate";
        }
        return HttpHeaders.parseChallenges(this.headers(), s);
    }
    
    public void close() {
        this.body.close();
    }
    
    public int code() {
        return this.code;
    }
    
    public Handshake handshake() {
        return this.handshake;
    }
    
    public String header(final String s) {
        return this.header(s, null);
    }
    
    public String header(final String s, final String s2) {
        final String value = this.headers.get(s);
        String s3;
        if (value != null) {
            s3 = value;
        }
        else {
            s3 = s2;
        }
        return s3;
    }
    
    public List headers(final String s) {
        return this.headers.values(s);
    }
    
    public Headers headers() {
        return this.headers;
    }
    
    public boolean isRedirect() {
        switch (this.code) {
            default: {
                return false;
            }
            case 300:
            case 301:
            case 302:
            case 303:
            case 307:
            case 308: {
                return true;
            }
        }
    }
    
    public boolean isSuccessful() {
        final int code = this.code;
        return code >= 200 && code < 300;
    }
    
    public String message() {
        return this.message;
    }
    
    public Response networkResponse() {
        return this.networkResponse;
    }
    
    public Response$Builder newBuilder() {
        return new Response$Builder(this, null);
    }
    
    public ResponseBody peekBody(final long n) {
        final BufferedSource source = this.body.source();
        source.request(n);
        final Buffer clone = source.buffer().clone();
        Buffer buffer;
        if (clone.size() > n) {
            buffer = new Buffer();
            buffer.write(clone, n);
            clone.clear();
        }
        else {
            buffer = clone;
        }
        return ResponseBody.create(this.body.contentType(), buffer.size(), buffer);
    }
    
    public Response priorResponse() {
        return this.priorResponse;
    }
    
    public Protocol protocol() {
        return this.protocol;
    }
    
    public long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }
    
    public Request request() {
        return this.request;
    }
    
    public long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Response{protocol=");
        sb.append(this.protocol);
        sb.append(", code=");
        sb.append(this.code);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", url=");
        sb.append(this.request.url());
        sb.append('}');
        return sb.toString();
    }
}
