// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import okhttp3.internal.Util;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.Iterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;

public final class Dispatcher
{
    private ExecutorService executorService;
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final Deque readyAsyncCalls;
    private final Deque runningAsyncCalls;
    private final Deque runningSyncCalls;
    
    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque();
        this.runningAsyncCalls = new ArrayDeque();
        this.runningSyncCalls = new ArrayDeque();
    }
    
    public Dispatcher(final ExecutorService executorService) {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque();
        this.runningAsyncCalls = new ArrayDeque();
        this.runningSyncCalls = new ArrayDeque();
        this.executorService = executorService;
    }
    
    private void finished(final Deque deque, final Object o, final boolean b) {
        synchronized (this) {
            if (deque.remove(o)) {
                if (b) {
                    this.promoteCalls();
                }
                final int runningCallsCount = this.runningCallsCount();
                final Runnable idleCallback = this.idleCallback;
                // monitorexit(this)
                if (runningCallsCount == 0 && idleCallback != null) {
                    idleCallback.run();
                }
                return;
            }
            throw new AssertionError((Object)"Call wasn't in-flight!");
        }
    }
    
    private void promoteCalls() {
        if (this.runningAsyncCalls.size() >= this.maxRequests) {
            return;
        }
        if (this.readyAsyncCalls.isEmpty()) {
            return;
        }
        final Iterator<RealCall$AsyncCall> iterator = (Iterator<RealCall$AsyncCall>)this.readyAsyncCalls.iterator();
        while (iterator.hasNext()) {
            final RealCall$AsyncCall realCall$AsyncCall = iterator.next();
            if (this.runningCallsForHost(realCall$AsyncCall) < this.maxRequestsPerHost) {
                iterator.remove();
                this.runningAsyncCalls.add(realCall$AsyncCall);
                this.executorService().execute(realCall$AsyncCall);
            }
            if (this.runningAsyncCalls.size() >= this.maxRequests) {
                return;
            }
        }
    }
    
    private int runningCallsForHost(final RealCall$AsyncCall realCall$AsyncCall) {
        int n = 0;
        final Iterator<RealCall$AsyncCall> iterator = this.runningAsyncCalls.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().host().equals(realCall$AsyncCall.host())) {
                ++n;
            }
        }
        return n;
    }
    
    public void cancelAll() {
        synchronized (this) {
            final Iterator<RealCall$AsyncCall> iterator = this.readyAsyncCalls.iterator();
            while (iterator.hasNext()) {
                iterator.next().get().cancel();
            }
            final Iterator<RealCall$AsyncCall> iterator2 = this.runningAsyncCalls.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().get().cancel();
            }
            final Iterator<RealCall> iterator3 = this.runningSyncCalls.iterator();
            while (iterator3.hasNext()) {
                iterator3.next().cancel();
            }
        }
    }
    
    void enqueue(final RealCall$AsyncCall realCall$AsyncCall) {
        synchronized (this) {
            if (this.runningAsyncCalls.size() < this.maxRequests && this.runningCallsForHost(realCall$AsyncCall) < this.maxRequestsPerHost) {
                this.runningAsyncCalls.add(realCall$AsyncCall);
                this.executorService().execute(realCall$AsyncCall);
            }
            else {
                this.readyAsyncCalls.add(realCall$AsyncCall);
            }
        }
    }
    
    void executed(final RealCall realCall) {
        synchronized (this) {
            this.runningSyncCalls.add(realCall);
        }
    }
    
    public ExecutorService executorService() {
        synchronized (this) {
            if (this.executorService == null) {
                final int n;
                final long n2;
                final TimeUnit seconds;
                final SynchronousQueue<Runnable> synchronousQueue;
                final ThreadFactory threadFactory;
                final ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, n, n2, seconds, synchronousQueue, threadFactory);
                n = -1 >>> 1;
                n2 = 60;
                seconds = TimeUnit.SECONDS;
                synchronousQueue = new SynchronousQueue<Runnable>();
                threadFactory = Util.threadFactory("OkHttp Dispatcher", false);
                this.executorService = executorService;
            }
            return this.executorService;
        }
    }
    
    void finished(final RealCall$AsyncCall realCall$AsyncCall) {
        this.finished(this.runningAsyncCalls, realCall$AsyncCall, true);
    }
    
    void finished(final RealCall realCall) {
        this.finished(this.runningSyncCalls, realCall, false);
    }
    
    public int getMaxRequests() {
        synchronized (this) {
            return this.maxRequests;
        }
    }
    
    public int getMaxRequestsPerHost() {
        synchronized (this) {
            return this.maxRequestsPerHost;
        }
    }
    
    public List queuedCalls() {
        synchronized (this) {
            final ArrayList<RealCall> list = new ArrayList<RealCall>();
            final Iterator<RealCall$AsyncCall> iterator = this.readyAsyncCalls.iterator();
            while (iterator.hasNext()) {
                list.add(iterator.next().get());
            }
            return Collections.unmodifiableList((List<?>)list);
        }
    }
    
    public int queuedCallsCount() {
        synchronized (this) {
            return this.readyAsyncCalls.size();
        }
    }
    
    public List runningCalls() {
        synchronized (this) {
            final ArrayList<RealCall> list = new ArrayList<RealCall>();
            list.addAll((Collection<?>)this.runningSyncCalls);
            final Iterator<RealCall$AsyncCall> iterator = (Iterator<RealCall$AsyncCall>)this.runningAsyncCalls.iterator();
            while (iterator.hasNext()) {
                list.add(iterator.next().get());
            }
            return Collections.unmodifiableList((List<?>)list);
        }
    }
    
    public int runningCallsCount() {
        synchronized (this) {
            return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
        }
    }
    
    public void setIdleCallback(final Runnable idleCallback) {
        synchronized (this) {
            this.idleCallback = idleCallback;
        }
    }
    
    public void setMaxRequests(final int maxRequests) {
        // monitorenter(this)
        Label_0025: {
            if (maxRequests >= 1) {
                Label_0076: {
                    try {
                        this.maxRequests = maxRequests;
                        this.promoteCalls();
                        // monitorexit(this)
                        return;
                    }
                    finally {
                        break Label_0076;
                    }
                    break Label_0025;
                }
            }
            // monitorexit(this)
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("max < 1: ");
        sb.append(maxRequests);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void setMaxRequestsPerHost(final int maxRequestsPerHost) {
        // monitorenter(this)
        Label_0025: {
            if (maxRequestsPerHost >= 1) {
                Label_0076: {
                    try {
                        this.maxRequestsPerHost = maxRequestsPerHost;
                        this.promoteCalls();
                        // monitorexit(this)
                        return;
                    }
                    finally {
                        break Label_0076;
                    }
                    break Label_0025;
                }
            }
            // monitorexit(this)
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("max < 1: ");
        sb.append(maxRequestsPerHost);
        throw new IllegalArgumentException(sb.toString());
    }
}
