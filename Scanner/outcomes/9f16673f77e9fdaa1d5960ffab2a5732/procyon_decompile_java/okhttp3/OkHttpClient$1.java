// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Internal;

final class OkHttpClient$1 extends Internal
{
    public void addLenient(final Headers$Builder headers$Builder, final String s) {
        headers$Builder.addLenient(s);
    }
    
    public void addLenient(final Headers$Builder headers$Builder, final String s, final String s2) {
        headers$Builder.addLenient(s, s2);
    }
    
    public void apply(final ConnectionSpec connectionSpec, final SSLSocket sslSocket, final boolean b) {
        connectionSpec.apply(sslSocket, b);
    }
    
    public StreamAllocation callEngineGetStreamAllocation(final Call call) {
        return ((RealCall)call).streamAllocation();
    }
    
    public boolean connectionBecameIdle(final ConnectionPool connectionPool, final RealConnection realConnection) {
        return connectionPool.connectionBecameIdle(realConnection);
    }
    
    public RealConnection get(final ConnectionPool connectionPool, final Address address, final StreamAllocation streamAllocation) {
        return connectionPool.get(address, streamAllocation);
    }
    
    public HttpUrl getHttpUrlChecked(final String s) {
        return HttpUrl.getChecked(s);
    }
    
    public void put(final ConnectionPool connectionPool, final RealConnection realConnection) {
        connectionPool.put(realConnection);
    }
    
    public RouteDatabase routeDatabase(final ConnectionPool connectionPool) {
        return connectionPool.routeDatabase;
    }
    
    public void setCache(final OkHttpClient$Builder okHttpClient$Builder, final InternalCache internalCache) {
        okHttpClient$Builder.setInternalCache(internalCache);
    }
    
    public void setCallWebSocket(final Call call) {
        ((RealCall)call).setForWebSocket();
    }
}
