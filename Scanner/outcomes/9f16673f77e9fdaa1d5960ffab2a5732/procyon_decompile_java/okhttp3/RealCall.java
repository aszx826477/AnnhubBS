// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.io.IOException;
import okhttp3.internal.http.HttpStream;
import okhttp3.internal.connection.StreamAllocation;
import java.util.List;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.http.BridgeInterceptor;
import java.util.Collection;
import okhttp3.internal.http.CallServerInterceptor;
import java.util.ArrayList;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;

final class RealCall implements Call
{
    private final OkHttpClient client;
    private boolean executed;
    Request originalRequest;
    private final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    
    protected RealCall(final OkHttpClient client, final Request originalRequest) {
        this.client = client;
        this.originalRequest = originalRequest;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(client);
    }
    
    private Response getResponseWithInterceptorChain() {
        final ArrayList<CallServerInterceptor> list = new ArrayList<CallServerInterceptor>();
        list.addAll((Collection<?>)this.client.interceptors());
        list.add((CallServerInterceptor)this.retryAndFollowUpInterceptor);
        list.add((CallServerInterceptor)new BridgeInterceptor(this.client.cookieJar()));
        list.add((CallServerInterceptor)new CacheInterceptor(this.client.internalCache()));
        list.add((CallServerInterceptor)new ConnectInterceptor(this.client));
        if (!this.retryAndFollowUpInterceptor.isForWebSocket()) {
            list.addAll((Collection<?>)this.client.networkInterceptors());
        }
        list.add(new CallServerInterceptor(this.retryAndFollowUpInterceptor.isForWebSocket()));
        return new RealInterceptorChain(list, null, null, null, 0, this.originalRequest).proceed(this.originalRequest);
    }
    
    private String toLoggableString() {
        String s;
        if (this.retryAndFollowUpInterceptor.isCanceled()) {
            s = "canceled call";
        }
        else {
            s = "call";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(" to ");
        sb.append(this.redactedUrl());
        return sb.toString();
    }
    
    public void cancel() {
        this.retryAndFollowUpInterceptor.cancel();
    }
    
    public void enqueue(final Callback callback) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                // monitorexit(this)
                this.client.dispatcher().enqueue(new RealCall$AsyncCall(this, callback, null));
                return;
            }
            throw new IllegalStateException("Already Executed");
        }
    }
    
    public Response execute() {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                // monitorexit(this)
                try {
                    this.client.dispatcher().executed(this);
                    final Response responseWithInterceptorChain = this.getResponseWithInterceptorChain();
                    if (responseWithInterceptorChain != null) {
                        return responseWithInterceptorChain;
                    }
                    throw new IOException("Canceled");
                }
                finally {
                    this.client.dispatcher().finished(this);
                }
            }
            throw new IllegalStateException("Already Executed");
        }
    }
    
    public boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }
    
    public boolean isExecuted() {
        synchronized (this) {
            return this.executed;
        }
    }
    
    HttpUrl redactedUrl() {
        return this.originalRequest.url().resolve("/...");
    }
    
    public Request request() {
        return this.originalRequest;
    }
    
    void setForWebSocket() {
        synchronized (this) {
            if (!this.executed) {
                this.retryAndFollowUpInterceptor.setForWebSocket(true);
                return;
            }
            throw new IllegalStateException("Already Executed");
        }
    }
    
    StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }
}
