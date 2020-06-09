// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.connection;

import okhttp3.Request;
import okhttp3.Connection;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.Response;
import okhttp3.Interceptor$Chain;
import okhttp3.OkHttpClient;
import okhttp3.Interceptor;

public final class ConnectInterceptor implements Interceptor
{
    public final OkHttpClient client;
    
    public ConnectInterceptor(final OkHttpClient client) {
        this.client = client;
    }
    
    public Response intercept(final Interceptor$Chain interceptor$Chain) {
        final RealInterceptorChain realInterceptorChain = (RealInterceptorChain)interceptor$Chain;
        final Request request = realInterceptorChain.request();
        final StreamAllocation streamAllocation = realInterceptorChain.streamAllocation();
        return realInterceptorChain.proceed(request, streamAllocation, streamAllocation.newStream(this.client, request.method().equals("GET") ^ true), streamAllocation.connection());
    }
}
