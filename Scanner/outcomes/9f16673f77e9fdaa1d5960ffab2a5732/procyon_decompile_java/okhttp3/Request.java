// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.net.URL;
import okhttp3.internal.http.HttpMethod;
import java.util.List;

public final class Request
{
    private final RequestBody body;
    private volatile CacheControl cacheControl;
    private final Headers headers;
    private final String method;
    private final Object tag;
    private final HttpUrl url;
    
    private Request(final Request$Builder request$Builder) {
        this.url = request$Builder.url;
        this.method = request$Builder.method;
        this.headers = request$Builder.headers.build();
        this.body = request$Builder.body;
        Object access$400;
        if (request$Builder.tag != null) {
            access$400 = request$Builder.tag;
        }
        else {
            access$400 = this;
        }
        this.tag = access$400;
    }
    
    public RequestBody body() {
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
    
    public String header(final String s) {
        return this.headers.get(s);
    }
    
    public List headers(final String s) {
        return this.headers.values(s);
    }
    
    public Headers headers() {
        return this.headers;
    }
    
    public boolean isHttps() {
        return this.url.isHttps();
    }
    
    public String method() {
        return this.method;
    }
    
    public Request$Builder newBuilder() {
        return new Request$Builder(this, null);
    }
    
    public Object tag() {
        return this.tag;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        sb.append(", tag=");
        Object tag = this.tag;
        if (tag == this) {
            tag = null;
        }
        sb.append(tag);
        sb.append('}');
        return sb.toString();
    }
    
    public HttpUrl url() {
        return this.url;
    }
}
