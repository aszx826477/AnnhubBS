// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal;

import okhttp3.internal.cache.InternalCache;
import okhttp3.OkHttpClient$Builder;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.HttpUrl;
import okhttp3.Address;
import okhttp3.internal.connection.RealConnection;
import okhttp3.ConnectionPool;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.Call;
import javax.net.ssl.SSLSocket;
import okhttp3.ConnectionSpec;
import okhttp3.Headers$Builder;
import okhttp3.OkHttpClient;

public abstract class Internal
{
    public static Internal instance;
    
    public static void initializeInstanceForTests() {
        new OkHttpClient();
    }
    
    public abstract void addLenient(final Headers$Builder p0, final String p1);
    
    public abstract void addLenient(final Headers$Builder p0, final String p1, final String p2);
    
    public abstract void apply(final ConnectionSpec p0, final SSLSocket p1, final boolean p2);
    
    public abstract StreamAllocation callEngineGetStreamAllocation(final Call p0);
    
    public abstract boolean connectionBecameIdle(final ConnectionPool p0, final RealConnection p1);
    
    public abstract RealConnection get(final ConnectionPool p0, final Address p1, final StreamAllocation p2);
    
    public abstract HttpUrl getHttpUrlChecked(final String p0);
    
    public abstract void put(final ConnectionPool p0, final RealConnection p1);
    
    public abstract RouteDatabase routeDatabase(final ConnectionPool p0);
    
    public abstract void setCache(final OkHttpClient$Builder p0, final InternalCache p1);
    
    public abstract void setCallWebSocket(final Call p0);
}
