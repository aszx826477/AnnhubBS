// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

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
import okhttp3.internal.platform.Platform;
import java.io.IOException;
import okhttp3.internal.NamedRunnable;

final class RealCall$AsyncCall extends NamedRunnable
{
    private final Callback responseCallback;
    final /* synthetic */ RealCall this$0;
    
    private RealCall$AsyncCall(final RealCall this$0, final Callback responseCallback) {
        this.this$0 = this$0;
        super("OkHttp %s", new Object[] { this$0.redactedUrl().toString() });
        this.responseCallback = responseCallback;
    }
    
    protected void execute() {
        boolean b = false;
        Label_0198: {
            Response access$100 = null;
            Callback responseCallback2 = null;
            try {
                final RealCall this$0 = this.this$0;
                try {
                    access$100 = this$0.getResponseWithInterceptorChain();
                    try {
                        final RealCall this$2 = this.this$0;
                        try {
                            final RetryAndFollowUpInterceptor access$101 = this$2.retryAndFollowUpInterceptor;
                            try {
                                Label_0075: {
                                    if (!access$101.isCanceled()) {
                                        break Label_0075;
                                    }
                                    b = true;
                                    final Callback responseCallback = this.responseCallback;
                                    try {
                                        final RealCall this$3 = this.this$0;
                                        try {
                                            responseCallback.onFailure(this$3, new IOException("Canceled"));
                                            break Label_0198;
                                            b = true;
                                            responseCallback2 = this.responseCallback;
                                            final RealCall$AsyncCall realCall$AsyncCall = this;
                                            final RealCall realCall = realCall$AsyncCall.this$0;
                                            final Callback callback = responseCallback2;
                                            final RealCall realCall2 = realCall;
                                            final Response response = access$100;
                                            callback.onResponse(realCall2, response);
                                        }
                                        catch (IOException ex3) {
                                            final IOException ex2;
                                            final IOException ex = ex2;
                                            if (b) {
                                                final Platform value = Platform.get();
                                                final int n = 4;
                                                final StringBuilder sb = new StringBuilder();
                                                sb.append("Callback failure for ");
                                                sb.append(this.this$0.toLoggableString());
                                                value.log(n, sb.toString(), ex);
                                                break Label_0198;
                                            }
                                            this.responseCallback.onFailure(this.this$0, ex);
                                        }
                                    }
                                    catch (IOException ex4) {}
                                }
                            }
                            catch (IOException ex5) {}
                        }
                        catch (IOException ex6) {}
                    }
                    catch (IOException ex7) {}
                }
                catch (IOException ex8) {}
            }
            catch (IOException ex9) {}
            try {
                final RealCall$AsyncCall realCall$AsyncCall = this;
                final RealCall realCall = realCall$AsyncCall.this$0;
                final Callback callback = responseCallback2;
                final RealCall realCall2 = realCall;
                final Response response = access$100;
                callback.onResponse(realCall2, response);
            }
            catch (IOException ex2) {}
        }
        this.this$0.client.dispatcher().finished(this);
        return;
        this.this$0.client.dispatcher().finished(this);
    }
    
    RealCall get() {
        return this.this$0;
    }
    
    String host() {
        return this.this$0.originalRequest.url().host();
    }
    
    Request request() {
        return this.this$0.originalRequest;
    }
}
