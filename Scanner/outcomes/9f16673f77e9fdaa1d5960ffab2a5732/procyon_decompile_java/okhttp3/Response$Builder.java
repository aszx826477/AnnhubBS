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

public class Response$Builder
{
    private ResponseBody body;
    private Response cacheResponse;
    private int code;
    private Handshake handshake;
    private Headers$Builder headers;
    private String message;
    private Response networkResponse;
    private Response priorResponse;
    private Protocol protocol;
    private long receivedResponseAtMillis;
    private Request request;
    private long sentRequestAtMillis;
    
    public Response$Builder() {
        this.code = -1;
        this.headers = new Headers$Builder();
    }
    
    private Response$Builder(final Response response) {
        this.code = -1;
        this.request = response.request;
        this.protocol = response.protocol;
        this.code = response.code;
        this.message = response.message;
        this.handshake = response.handshake;
        this.headers = response.headers.newBuilder();
        this.body = response.body;
        this.networkResponse = response.networkResponse;
        this.cacheResponse = response.cacheResponse;
        this.priorResponse = response.priorResponse;
        this.sentRequestAtMillis = response.sentRequestAtMillis;
        this.receivedResponseAtMillis = response.receivedResponseAtMillis;
    }
    
    private void checkPriorResponse(final Response response) {
        if (response.body == null) {
            return;
        }
        throw new IllegalArgumentException("priorResponse.body != null");
    }
    
    private void checkSupportResponse(final String s, final Response response) {
        if (response.body != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(".body != null");
            throw new IllegalArgumentException(sb.toString());
        }
        if (response.networkResponse != null) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append(".networkResponse != null");
            throw new IllegalArgumentException(sb2.toString());
        }
        if (response.cacheResponse != null) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(s);
            sb3.append(".cacheResponse != null");
            throw new IllegalArgumentException(sb3.toString());
        }
        if (response.priorResponse == null) {
            return;
        }
        final StringBuilder sb4 = new StringBuilder();
        sb4.append(s);
        sb4.append(".priorResponse != null");
        throw new IllegalArgumentException(sb4.toString());
    }
    
    public Response$Builder addHeader(final String s, final String s2) {
        this.headers.add(s, s2);
        return this;
    }
    
    public Response$Builder body(final ResponseBody body) {
        this.body = body;
        return this;
    }
    
    public Response build() {
        if (this.request == null) {
            throw new IllegalStateException("request == null");
        }
        if (this.protocol == null) {
            throw new IllegalStateException("protocol == null");
        }
        if (this.code >= 0) {
            return new Response(this, null);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("code < 0: ");
        sb.append(this.code);
        throw new IllegalStateException(sb.toString());
    }
    
    public Response$Builder cacheResponse(final Response cacheResponse) {
        if (cacheResponse != null) {
            this.checkSupportResponse("cacheResponse", cacheResponse);
        }
        this.cacheResponse = cacheResponse;
        return this;
    }
    
    public Response$Builder code(final int code) {
        this.code = code;
        return this;
    }
    
    public Response$Builder handshake(final Handshake handshake) {
        this.handshake = handshake;
        return this;
    }
    
    public Response$Builder header(final String s, final String s2) {
        this.headers.set(s, s2);
        return this;
    }
    
    public Response$Builder headers(final Headers headers) {
        this.headers = headers.newBuilder();
        return this;
    }
    
    public Response$Builder message(final String message) {
        this.message = message;
        return this;
    }
    
    public Response$Builder networkResponse(final Response networkResponse) {
        if (networkResponse != null) {
            this.checkSupportResponse("networkResponse", networkResponse);
        }
        this.networkResponse = networkResponse;
        return this;
    }
    
    public Response$Builder priorResponse(final Response priorResponse) {
        if (priorResponse != null) {
            this.checkPriorResponse(priorResponse);
        }
        this.priorResponse = priorResponse;
        return this;
    }
    
    public Response$Builder protocol(final Protocol protocol) {
        this.protocol = protocol;
        return this;
    }
    
    public Response$Builder receivedResponseAtMillis(final long receivedResponseAtMillis) {
        this.receivedResponseAtMillis = receivedResponseAtMillis;
        return this;
    }
    
    public Response$Builder removeHeader(final String s) {
        this.headers.removeAll(s);
        return this;
    }
    
    public Response$Builder request(final Request request) {
        this.request = request;
        return this;
    }
    
    public Response$Builder sentRequestAtMillis(final long sentRequestAtMillis) {
        this.sentRequestAtMillis = sentRequestAtMillis;
        return this;
    }
}
