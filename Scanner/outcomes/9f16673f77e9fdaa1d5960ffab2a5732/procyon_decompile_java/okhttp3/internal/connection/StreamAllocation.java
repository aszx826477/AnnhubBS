// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.connection;

import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.StreamResetException;
import okio.BufferedSink;
import okio.BufferedSource;
import okhttp3.internal.http.Http1xStream;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http.Http2xStream;
import okhttp3.OkHttpClient;
import java.lang.ref.WeakReference;
import java.lang.ref.Reference;
import java.util.List;
import java.io.IOException;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpStream;
import okhttp3.Route;
import okhttp3.ConnectionPool;
import okhttp3.Address;

public final class StreamAllocation
{
    public final Address address;
    private boolean canceled;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    private int refusedStreamCount;
    private boolean released;
    private Route route;
    private final RouteSelector routeSelector;
    private HttpStream stream;
    
    public StreamAllocation(final ConnectionPool connectionPool, final Address address) {
        this.connectionPool = connectionPool;
        this.address = address;
        this.routeSelector = new RouteSelector(address, this.routeDatabase());
    }
    
    private void deallocate(final boolean b, final boolean b2, final boolean b3) {
        RealConnection connection = null;
        final ConnectionPool connectionPool = this.connectionPool;
        // monitorenter(connectionPool)
        Label_0032: {
            if (!b3) {
                break Label_0032;
            }
            try {
                this.stream = null;
                break Label_0032;
            }
            finally {
                // monitorexit(connectionPool)
                boolean b4 = false;
                Label_0119_Outer:Block_10_Outer:
                while (true) {
                Block_4:
                    while (true) {
                        Block_9: {
                        Block_6_Outer:
                            while (true) {
                                Label_0079: {
                                    while (true) {
                                        Label_0225: {
                                            Block_11: {
                                                while (true) {
                                                    Block_5: {
                                                        break Block_5;
                                                        this.release(this.connection);
                                                        break Block_9;
                                                        this.connection.noNewStreams = b4;
                                                        break Label_0079;
                                                        connection = this.connection;
                                                        break Label_0225;
                                                        break Block_11;
                                                        b4 = true;
                                                        break Block_4;
                                                    }
                                                    continue Block_10_Outer;
                                                }
                                                Label_0222: {
                                                    break Label_0225;
                                                }
                                            }
                                            Util.closeQuietly(connection.socket());
                                            return;
                                        }
                                        this.connection = null;
                                        Label_0233: {
                                            continue;
                                        }
                                    }
                                }
                                continue Block_6_Outer;
                            }
                            Label_0259: {
                                return;
                            }
                        }
                        this.connection.idleAtNanos = System.nanoTime();
                        continue;
                    }
                    this.released = b4;
                    continue Label_0119_Outer;
                }
            }
            // iftrue(Label_0236:, this.connection == null)
            // iftrue(Label_0225:, !this.connection.allocations.isEmpty())
            // monitorexit(connectionPool)
            // iftrue(Label_0259:, connection == null)
            // iftrue(Label_0048:, !b2)
            // iftrue(Label_0079:, !b)
            // iftrue(Label_0233:, this.stream != null || !this.released && !this.connection.noNewStreams)
            // iftrue(Label_0222:, !Internal.instance.connectionBecameIdle(this.connectionPool, this.connection))
        }
    }
    
    private RealConnection findConnection(final int n, final int n2, final int n3, final boolean b) {
        Object o = this.connectionPool;
        synchronized (o) {
            if (this.released) {
                throw new IllegalStateException("released");
            }
            if (this.stream == null) {
                if (!this.canceled) {
                    final RealConnection connection = this.connection;
                    if (connection != null && !connection.noNewStreams) {
                        return connection;
                    }
                    final RealConnection value = Internal.instance.get(this.connectionPool, this.address, this);
                    if (value != null) {
                        return this.connection = value;
                    }
                    final Route route = this.route;
                    // monitorexit(o)
                    if (route == null) {
                        o = this.routeSelector.next();
                        synchronized (this.connectionPool) {
                            this.route = (Route)o;
                            this.refusedStreamCount = 0;
                        }
                        // monitorexit(this.connectionPool)
                    }
                    o = new RealConnection(route);
                    this.acquire((RealConnection)o);
                    Object o2 = this.connectionPool;
                    synchronized (o2) {
                        Internal.instance.put(this.connectionPool, (RealConnection)o);
                        this.connection = (RealConnection)o;
                        if (!this.canceled) {
                            // monitorexit(o2)
                            final List connectionSpecs = this.address.connectionSpecs();
                            o2 = o;
                            ((RealConnection)o).connect(n, n2, n3, connectionSpecs, b);
                            final RouteDatabase routeDatabase = this.routeDatabase();
                            o2 = ((RealConnection)o).route();
                            routeDatabase.connected((Route)o);
                            return (RealConnection)o;
                        }
                        throw new IOException("Canceled");
                    }
                }
                throw new IOException("Canceled");
            }
            throw new IllegalStateException("stream != null");
        }
    }
    
    private RealConnection findHealthyConnection(final int n, final int n2, final int n3, final boolean b, final boolean b2) {
        while (true) {
            final RealConnection connection = this.findConnection(n, n2, n3, b);
            synchronized (this.connectionPool) {
                if (connection.successCount == 0) {
                    return connection;
                }
                // monitorexit(this.connectionPool)
                if (connection.isHealthy(b2)) {
                    return connection;
                }
                this.noNewStreams();
            }
        }
    }
    
    private void release(final RealConnection realConnection) {
        for (int i = 0; i < realConnection.allocations.size(); ++i) {
            if (((Reference<Object>)realConnection.allocations.get(i)).get() == this) {
                realConnection.allocations.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }
    
    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }
    
    public void acquire(final RealConnection realConnection) {
        realConnection.allocations.add(new WeakReference<StreamAllocation>(this));
    }
    
    public void cancel() {
        final ConnectionPool connectionPool = this.connectionPool;
        // monitorenter(connectionPool)
        final boolean canceled = true;
        try {
            this.canceled = canceled;
            final HttpStream stream = this.stream;
            final RealConnection connection = this.connection;
            // monitorexit(connectionPool)
            if (stream != null) {
                stream.cancel();
            }
            else if (connection != null) {
                connection.cancel();
            }
        }
        finally {
        }
        // monitorexit(connectionPool)
    }
    
    public RealConnection connection() {
        synchronized (this) {
            return this.connection;
        }
    }
    
    public boolean hasMoreRoutes() {
        return this.route != null || this.routeSelector.hasNext();
    }
    
    public HttpStream newStream(final OkHttpClient okHttpClient, final boolean b) {
        final int connectTimeoutMillis = okHttpClient.connectTimeoutMillis();
        final int timeoutMillis = okHttpClient.readTimeoutMillis();
        final int writeTimeoutMillis = okHttpClient.writeTimeoutMillis();
        final boolean retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure();
        final int n = connectTimeoutMillis;
        final int n2 = timeoutMillis;
        final int n3 = writeTimeoutMillis;
        final boolean b2 = retryOnConnectionFailure;
        try {
            final RealConnection healthyConnection = this.findHealthyConnection(n, n2, n3, b2, b);
            try {
                Label_0076: {
                    if (healthyConnection.framedConnection == null) {
                        break Label_0076;
                    }
                    HttpStream stream = new(okhttp3.internal.http.Http2xStream.class);
                    try {
                        stream = new Http2xStream(okHttpClient, this, healthyConnection.framedConnection);
                        Label_0192: {
                            break Label_0192;
                            healthyConnection.socket().setSoTimeout(timeoutMillis);
                            final BufferedSource source = healthyConnection.source;
                            try {
                                source.timeout().timeout(timeoutMillis, TimeUnit.MILLISECONDS);
                                final BufferedSink sink = healthyConnection.sink;
                                try {
                                    sink.timeout().timeout(writeTimeoutMillis, TimeUnit.MILLISECONDS);
                                    try {
                                        final BufferedSource source2 = healthyConnection.source;
                                        try {
                                            stream = new Http1xStream(okHttpClient, this, source2, healthyConnection.sink);
                                            final ConnectionPool connectionPool = this.connectionPool;
                                            try {
                                                synchronized (connectionPool) {
                                                    return this.stream = stream;
                                                }
                                            }
                                            catch (IOException ex) {
                                                throw new RouteException(ex);
                                            }
                                        }
                                        catch (IOException ex2) {}
                                    }
                                    catch (IOException ex3) {}
                                }
                                catch (IOException ex4) {}
                            }
                            catch (IOException ex5) {}
                        }
                    }
                    catch (IOException ex6) {}
                }
            }
            catch (IOException ex7) {}
        }
        catch (IOException ex8) {}
    }
    
    public void noNewStreams() {
        this.deallocate(true, false, false);
    }
    
    public void release() {
        this.deallocate(false, true, false);
    }
    
    public HttpStream stream() {
        synchronized (this.connectionPool) {
            return this.stream;
        }
    }
    
    public void streamFailed(final IOException ex) {
        boolean b = false;
        final ConnectionPool connectionPool = this.connectionPool;
        // monitorenter(connectionPool)
        final boolean b2 = ex instanceof StreamResetException;
        final int n = 1;
        Label_0117: {
            if (!b2) {
                break Label_0117;
            }
            try {
                final StreamResetException ex2 = (StreamResetException)ex;
                if (ex2.errorCode == ErrorCode.REFUSED_STREAM) {
                    this.refusedStreamCount += n;
                }
                if (ex2.errorCode != ErrorCode.REFUSED_STREAM || this.refusedStreamCount > n) {
                    b = true;
                    this.route = null;
                }
                Block_10_Outer:Block_7_Outer:
                while (true) {
                    this.deallocate(b, false, n != 0);
                    return;
                    Label_0204: {
                        while (true) {
                            while (true) {
                                this.routeSelector.connectFailed(this.route, ex);
                                break Label_0204;
                                b = true;
                                continue Block_7_Outer;
                            }
                            continue;
                        }
                    }
                    this.route = null;
                    continue Block_10_Outer;
                }
            }
            // monitorexit(connectionPool)
            // iftrue(Label_0114:, this.connection.successCount != 0)
            // iftrue(Label_0204:, this.route == null || ex == null)
            // iftrue(Label_0114:, this.connection == null || this.connection.isMultiplexed())
            finally {
            }
            // monitorexit(connectionPool)
        }
    }
    
    public void streamFinished(final boolean b, final HttpStream httpStream) {
        final ConnectionPool connectionPool = this.connectionPool;
        // monitorenter(connectionPool)
        Label_0067: {
            if (httpStream == null) {
                break Label_0067;
            }
            try {
                if (httpStream == this.stream) {
                    final int n = 1;
                    if (!b) {
                        final RealConnection connection = this.connection;
                        connection.successCount += n;
                    }
                    // monitorexit(connectionPool)
                    this.deallocate(b, false, n != 0);
                    return;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("expected ");
                sb.append(this.stream);
                sb.append(" but was ");
                sb.append(httpStream);
                throw new IllegalStateException(sb.toString());
            }
            finally {
            }
            // monitorexit(connectionPool)
        }
    }
    
    public String toString() {
        return this.address.toString();
    }
}
