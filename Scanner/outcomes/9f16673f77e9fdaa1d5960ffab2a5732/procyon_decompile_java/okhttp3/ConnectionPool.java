// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okhttp3.internal.connection.StreamAllocation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.platform.Platform;
import java.lang.ref.Reference;
import okhttp3.internal.connection.RealConnection;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.internal.Util;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.RouteDatabase;
import java.util.Deque;
import java.util.concurrent.Executor;

public final class ConnectionPool
{
    private static final Executor executor;
    private final Runnable cleanupRunnable;
    boolean cleanupRunning;
    private final Deque connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    final RouteDatabase routeDatabase;
    
    static {
        executor = new ThreadPoolExecutor(0, -1 >>> 1, 60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), Util.threadFactory("OkHttp ConnectionPool", true));
    }
    
    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }
    
    public ConnectionPool(final int maxIdleConnections, final long n, final TimeUnit timeUnit) {
        this.cleanupRunnable = new ConnectionPool$1(this);
        this.connections = new ArrayDeque();
        this.routeDatabase = new RouteDatabase();
        this.maxIdleConnections = maxIdleConnections;
        this.keepAliveDurationNs = timeUnit.toNanos(n);
        if (n > 0L) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("keepAliveDuration <= 0: ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
    
    private int pruneAndGetAllocationCount(final RealConnection realConnection, final long n) {
        final List allocations = realConnection.allocations;
        int i = 0;
        while (i < allocations.size()) {
            if (allocations.get(i).get() != null) {
                ++i;
            }
            else {
                final Platform value = Platform.get();
                final int n2 = 5;
                final StringBuilder sb = new StringBuilder();
                sb.append("A connection to ");
                sb.append(realConnection.route().address().url());
                sb.append(" was leaked. Did you forget to close a response body?");
                value.log(n2, sb.toString(), null);
                allocations.remove(i);
                realConnection.noNewStreams = true;
                if (allocations.isEmpty()) {
                    realConnection.idleAtNanos = n - this.keepAliveDurationNs;
                    return 0;
                }
                continue;
            }
        }
        return allocations.size();
    }
    
    long cleanup(final long n) {
        int n2 = 0;
        int n3 = 0;
        RealConnection realConnection = null;
        long n4 = Long.MIN_VALUE;
        synchronized (this) {
            for (final RealConnection realConnection2 : this.connections) {
                if (this.pruneAndGetAllocationCount(realConnection2, n) > 0) {
                    ++n2;
                }
                else {
                    ++n3;
                    final long n5 = n - realConnection2.idleAtNanos;
                    if (n5 <= n4) {
                        continue;
                    }
                    n4 = n5;
                    realConnection = realConnection2;
                }
            }
            if (n4 >= this.keepAliveDurationNs || n3 > this.maxIdleConnections) {
                this.connections.remove(realConnection);
                // monitorexit(this)
                Util.closeQuietly(realConnection.socket());
                return 0L;
            }
            if (n3 > 0) {
                return this.keepAliveDurationNs - n4;
            }
            if (n2 > 0) {
                return this.keepAliveDurationNs;
            }
            this.cleanupRunning = false;
            return -1;
        }
    }
    
    boolean connectionBecameIdle(final RealConnection realConnection) {
        if (!realConnection.noNewStreams && this.maxIdleConnections != 0) {
            this.notifyAll();
            return false;
        }
        this.connections.remove(realConnection);
        return true;
    }
    
    public int connectionCount() {
        synchronized (this) {
            return this.connections.size();
        }
    }
    
    public void evictAll() {
        final ArrayList<RealConnection> list = new ArrayList<RealConnection>();
        synchronized (this) {
            final Iterator<RealConnection> iterator = (Iterator<RealConnection>)this.connections.iterator();
            while (iterator.hasNext()) {
                final RealConnection realConnection = iterator.next();
                if (realConnection.allocations.isEmpty()) {
                    realConnection.noNewStreams = true;
                    list.add(realConnection);
                    iterator.remove();
                }
            }
            // monitorexit(this)
            final Iterator<Object> iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                Util.closeQuietly(iterator2.next().socket());
            }
        }
    }
    
    RealConnection get(final Address address, final StreamAllocation streamAllocation) {
        for (final RealConnection realConnection : this.connections) {
            if (realConnection.allocations.size() < realConnection.allocationLimit && (address.equals(realConnection.route().address) && !realConnection.noNewStreams)) {
                streamAllocation.acquire(realConnection);
                return realConnection;
            }
        }
        return null;
    }
    
    public int idleConnectionCount() {
        // monitorenter(this)
        int n = 0;
        try {
            final Iterator<RealConnection> iterator = this.connections.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().allocations.isEmpty()) {
                    ++n;
                }
            }
            return n;
        }
        finally {
        }
        // monitorexit(this)
    }
    
    void put(final RealConnection realConnection) {
        if (!this.cleanupRunning) {
            this.cleanupRunning = true;
            ConnectionPool.executor.execute(this.cleanupRunnable);
        }
        this.connections.add(realConnection);
    }
}
