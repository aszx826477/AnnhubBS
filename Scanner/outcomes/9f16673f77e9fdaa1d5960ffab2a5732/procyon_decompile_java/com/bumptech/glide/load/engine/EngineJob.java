// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.util.Util;
import java.util.Iterator;
import java.util.HashSet;
import com.bumptech.glide.request.ResourceCallback;
import java.util.ArrayList;
import android.os.Handler$Callback;
import android.os.Looper;
import com.bumptech.glide.load.Key;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.List;
import android.os.Handler;

class EngineJob implements EngineRunnable$EngineRunnableManager
{
    private static final EngineJob$EngineResourceFactory DEFAULT_FACTORY;
    private static final Handler MAIN_THREAD_HANDLER;
    private static final int MSG_COMPLETE = 1;
    private static final int MSG_EXCEPTION = 2;
    private final List cbs;
    private final ExecutorService diskCacheService;
    private EngineResource engineResource;
    private final EngineJob$EngineResourceFactory engineResourceFactory;
    private EngineRunnable engineRunnable;
    private Exception exception;
    private volatile Future future;
    private boolean hasException;
    private boolean hasResource;
    private Set ignoredCallbacks;
    private final boolean isCacheable;
    private boolean isCancelled;
    private final Key key;
    private final EngineJobListener listener;
    private Resource resource;
    private final ExecutorService sourceService;
    
    static {
        DEFAULT_FACTORY = new EngineJob$EngineResourceFactory();
        MAIN_THREAD_HANDLER = new Handler(Looper.getMainLooper(), (Handler$Callback)new EngineJob$MainThreadCallback(null));
    }
    
    public EngineJob(final Key key, final ExecutorService executorService, final ExecutorService executorService2, final boolean b, final EngineJobListener engineJobListener) {
        this(key, executorService, executorService2, b, engineJobListener, EngineJob.DEFAULT_FACTORY);
    }
    
    public EngineJob(final Key key, final ExecutorService diskCacheService, final ExecutorService sourceService, final boolean isCacheable, final EngineJobListener listener, final EngineJob$EngineResourceFactory engineResourceFactory) {
        this.cbs = new ArrayList();
        this.key = key;
        this.diskCacheService = diskCacheService;
        this.sourceService = sourceService;
        this.isCacheable = isCacheable;
        this.listener = listener;
        this.engineResourceFactory = engineResourceFactory;
    }
    
    private void addIgnoredCallback(final ResourceCallback resourceCallback) {
        if (this.ignoredCallbacks == null) {
            this.ignoredCallbacks = new HashSet();
        }
        this.ignoredCallbacks.add(resourceCallback);
    }
    
    private void handleExceptionOnMainThread() {
        if (this.isCancelled) {
            return;
        }
        if (!this.cbs.isEmpty()) {
            this.hasException = true;
            this.listener.onEngineJobComplete(this.key, null);
            for (final ResourceCallback resourceCallback : this.cbs) {
                if (!this.isInIgnoredCallbacks(resourceCallback)) {
                    resourceCallback.onException(this.exception);
                }
            }
            return;
        }
        throw new IllegalStateException("Received an exception without any callbacks to notify");
    }
    
    private void handleResultOnMainThread() {
        if (this.isCancelled) {
            this.resource.recycle();
            return;
        }
        if (!this.cbs.isEmpty()) {
            this.engineResource = this.engineResourceFactory.build(this.resource, this.isCacheable);
            this.hasResource = true;
            this.engineResource.acquire();
            this.listener.onEngineJobComplete(this.key, this.engineResource);
            for (final ResourceCallback resourceCallback : this.cbs) {
                if (!this.isInIgnoredCallbacks(resourceCallback)) {
                    this.engineResource.acquire();
                    resourceCallback.onResourceReady(this.engineResource);
                }
            }
            this.engineResource.release();
            return;
        }
        throw new IllegalStateException("Received a resource without any callbacks to notify");
    }
    
    private boolean isInIgnoredCallbacks(final ResourceCallback resourceCallback) {
        final Set ignoredCallbacks = this.ignoredCallbacks;
        return ignoredCallbacks != null && ignoredCallbacks.contains(resourceCallback);
    }
    
    public void addCallback(final ResourceCallback resourceCallback) {
        Util.assertMainThread();
        if (this.hasResource) {
            resourceCallback.onResourceReady(this.engineResource);
        }
        else if (this.hasException) {
            resourceCallback.onException(this.exception);
        }
        else {
            this.cbs.add(resourceCallback);
        }
    }
    
    void cancel() {
        if (!this.hasException && !this.hasResource && !this.isCancelled) {
            this.engineRunnable.cancel();
            final Future future = this.future;
            final boolean isCancelled = true;
            if (future != null) {
                future.cancel(isCancelled);
            }
            this.isCancelled = isCancelled;
            this.listener.onEngineJobCancelled(this, this.key);
        }
    }
    
    boolean isCancelled() {
        return this.isCancelled;
    }
    
    public void onException(final Exception exception) {
        this.exception = exception;
        EngineJob.MAIN_THREAD_HANDLER.obtainMessage(2, (Object)this).sendToTarget();
    }
    
    public void onResourceReady(final Resource resource) {
        this.resource = resource;
        EngineJob.MAIN_THREAD_HANDLER.obtainMessage(1, (Object)this).sendToTarget();
    }
    
    public void removeCallback(final ResourceCallback resourceCallback) {
        Util.assertMainThread();
        if (!this.hasResource && !this.hasException) {
            this.cbs.remove(resourceCallback);
            if (this.cbs.isEmpty()) {
                this.cancel();
            }
        }
        else {
            this.addIgnoredCallback(resourceCallback);
        }
    }
    
    public void start(final EngineRunnable engineRunnable) {
        this.engineRunnable = engineRunnable;
        this.future = this.diskCacheService.submit(engineRunnable);
    }
    
    public void submitForSource(final EngineRunnable engineRunnable) {
        this.future = this.sourceService.submit(engineRunnable);
    }
}
