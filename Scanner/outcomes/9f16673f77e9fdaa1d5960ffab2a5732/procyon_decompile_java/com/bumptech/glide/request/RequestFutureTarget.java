// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request;

import com.bumptech.glide.request.animation.GlideAnimation;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.SizeReadyCallback;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CancellationException;
import com.bumptech.glide.util.Util;
import android.os.Handler;

public class RequestFutureTarget implements FutureTarget, Runnable
{
    private static final RequestFutureTarget$Waiter DEFAULT_WAITER;
    private final boolean assertBackgroundThread;
    private Exception exception;
    private boolean exceptionReceived;
    private final int height;
    private boolean isCancelled;
    private final Handler mainHandler;
    private Request request;
    private Object resource;
    private boolean resultReceived;
    private final RequestFutureTarget$Waiter waiter;
    private final int width;
    
    static {
        DEFAULT_WAITER = new RequestFutureTarget$Waiter();
    }
    
    public RequestFutureTarget(final Handler handler, final int n, final int n2) {
        this(handler, n, n2, true, RequestFutureTarget.DEFAULT_WAITER);
    }
    
    RequestFutureTarget(final Handler mainHandler, final int width, final int height, final boolean assertBackgroundThread, final RequestFutureTarget$Waiter waiter) {
        this.mainHandler = mainHandler;
        this.width = width;
        this.height = height;
        this.assertBackgroundThread = assertBackgroundThread;
        this.waiter = waiter;
    }
    
    private Object doGet(final Long n) {
        synchronized (this) {
            if (this.assertBackgroundThread) {
                Util.assertBackgroundThread();
            }
            if (this.isCancelled) {
                throw new CancellationException();
            }
            if (this.exceptionReceived) {
                throw new ExecutionException(this.exception);
            }
            if (this.resultReceived) {
                return this.resource;
            }
            final long n2 = 0L;
            if (n == null) {
                this.waiter.waitForTimeout(this, n2);
            }
            else if (n > n2) {
                this.waiter.waitForTimeout(this, n);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.exceptionReceived) {
                throw new ExecutionException(this.exception);
            }
            if (this.isCancelled) {
                throw new CancellationException();
            }
            if (this.resultReceived) {
                return this.resource;
            }
            throw new TimeoutException();
        }
    }
    
    public boolean cancel(final boolean b) {
        synchronized (this) {
            final boolean isCancelled = this.isCancelled;
            final boolean isCancelled2 = true;
            if (isCancelled) {
                return isCancelled2;
            }
            final boolean b2 = this.isDone() ^ isCancelled2;
            if (b2) {
                this.isCancelled = isCancelled2;
                if (b) {
                    this.clear();
                }
                this.waiter.notifyAll(this);
            }
            return b2;
        }
    }
    
    public void clear() {
        this.mainHandler.post((Runnable)this);
    }
    
    public Object get() {
        try {
            return this.doGet(null);
        }
        catch (TimeoutException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public Object get(final long n, final TimeUnit timeUnit) {
        return this.doGet(timeUnit.toMillis(n));
    }
    
    public Request getRequest() {
        return this.request;
    }
    
    public void getSize(final SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }
    
    public boolean isCancelled() {
        synchronized (this) {
            return this.isCancelled;
        }
    }
    
    public boolean isDone() {
        synchronized (this) {
            return this.isCancelled || this.resultReceived;
        }
    }
    
    public void onDestroy() {
    }
    
    public void onLoadCleared(final Drawable drawable) {
    }
    
    public void onLoadFailed(final Exception exception, final Drawable drawable) {
        // monitorenter(this)
        final boolean exceptionReceived = true;
        try {
            this.exceptionReceived = exceptionReceived;
            this.exception = exception;
            this.waiter.notifyAll(this);
        }
        finally {
        }
        // monitorexit(this)
    }
    
    public void onLoadStarted(final Drawable drawable) {
    }
    
    public void onResourceReady(final Object resource, final GlideAnimation glideAnimation) {
        // monitorenter(this)
        final boolean resultReceived = true;
        try {
            this.resultReceived = resultReceived;
            this.resource = resource;
            this.waiter.notifyAll(this);
        }
        finally {
        }
        // monitorexit(this)
    }
    
    public void onStart() {
    }
    
    public void onStop() {
    }
    
    public void run() {
        final Request request = this.request;
        if (request != null) {
            request.clear();
            this.cancel(false);
        }
    }
    
    public void setRequest(final Request request) {
        this.request = request;
    }
}
