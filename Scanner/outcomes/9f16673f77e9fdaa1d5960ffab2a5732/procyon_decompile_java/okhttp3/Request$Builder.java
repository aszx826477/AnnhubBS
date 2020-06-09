// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.util.List;
import java.net.URL;
import okhttp3.internal.http.HttpMethod;

public class Request$Builder
{
    private RequestBody body;
    private Headers$Builder headers;
    private String method;
    private Object tag;
    private HttpUrl url;
    
    public Request$Builder() {
        this.method = "GET";
        this.headers = new Headers$Builder();
    }
    
    private Request$Builder(final Request request) {
        this.url = request.url;
        this.method = request.method;
        this.body = request.body;
        this.tag = request.tag;
        this.headers = request.headers.newBuilder();
    }
    
    public Request$Builder addHeader(final String s, final String s2) {
        this.headers.add(s, s2);
        return this;
    }
    
    public Request build() {
        if (this.url != null) {
            return new Request(this, null);
        }
        throw new IllegalStateException("url == null");
    }
    
    public Request$Builder cacheControl(final CacheControl cacheControl) {
        final String string = cacheControl.toString();
        if (string.isEmpty()) {
            return this.removeHeader("Cache-Control");
        }
        return this.header("Cache-Control", string);
    }
    
    public Request$Builder delete() {
        return this.delete(RequestBody.create(null, new byte[0]));
    }
    
    public Request$Builder delete(final RequestBody requestBody) {
        return this.method("DELETE", requestBody);
    }
    
    public Request$Builder get() {
        return this.method("GET", null);
    }
    
    public Request$Builder head() {
        return this.method("HEAD", null);
    }
    
    public Request$Builder header(final String s, final String s2) {
        this.headers.set(s, s2);
        return this;
    }
    
    public Request$Builder headers(final Headers headers) {
        this.headers = headers.newBuilder();
        return this;
    }
    
    public Request$Builder method(final String method, final RequestBody body) {
        if (method == null) {
            throw new NullPointerException("method == null");
        }
        if (method.length() == 0) {
            throw new IllegalArgumentException("method.length() == 0");
        }
        if (body != null && !HttpMethod.permitsRequestBody(method)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("method ");
            sb.append(method);
            sb.append(" must not have a request body.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (body == null && HttpMethod.requiresRequestBody(method)) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("method ");
            sb2.append(method);
            sb2.append(" must have a request body.");
            throw new IllegalArgumentException(sb2.toString());
        }
        this.method = method;
        this.body = body;
        return this;
    }
    
    public Request$Builder patch(final RequestBody requestBody) {
        return this.method("PATCH", requestBody);
    }
    
    public Request$Builder post(final RequestBody requestBody) {
        return this.method("POST", requestBody);
    }
    
    public Request$Builder put(final RequestBody requestBody) {
        return this.method("PUT", requestBody);
    }
    
    public Request$Builder removeHeader(final String s) {
        this.headers.removeAll(s);
        return this;
    }
    
    public Request$Builder tag(final Object tag) {
        this.tag = tag;
        return this;
    }
    
    public Request$Builder url(String s) {
        if (s == null) {
            throw new NullPointerException("url == null");
        }
        if (s.regionMatches(true, 0, "ws:", 0, 3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("http:");
            sb.append(s.substring(3));
            s = sb.toString();
        }
        else if (s.regionMatches(true, 0, "wss:", 0, 4)) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("https:");
            sb2.append(s.substring(4));
            s = sb2.toString();
        }
        final HttpUrl parse = HttpUrl.parse(s);
        if (parse != null) {
            return this.url(parse);
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("unexpected url: ");
        sb3.append(s);
        throw new IllegalArgumentException(sb3.toString());
    }
    
    public Request$Builder url(final URL url) {
        if (url == null) {
            throw new NullPointerException("url == null");
        }
        final HttpUrl value = HttpUrl.get(url);
        if (value != null) {
            return this.url(value);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unexpected url: ");
        sb.append(url);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public Request$Builder url(final HttpUrl url) {
        if (url != null) {
            this.url = url;
            return this;
        }
        throw new NullPointerException("url == null");
    }
}
