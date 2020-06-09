// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.util.Util;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.load.data.DataFetcher;
import android.util.Log;
import com.bumptech.glide.util.LogTime;
import java.lang.ref.WeakReference;
import android.os.MessageQueue$IdleHandler;
import android.os.Looper;
import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import com.bumptech.glide.load.engine.cache.DiskCache$Factory;
import java.lang.ref.ReferenceQueue;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import java.util.Map;
import com.bumptech.glide.load.engine.cache.MemoryCache$ResourceRemovedListener;

public class Engine implements EngineJobListener, MemoryCache$ResourceRemovedListener, EngineResource$ResourceListener
{
    private static final String TAG = "Engine";
    private final Map activeResources;
    private final MemoryCache cache;
    private final Engine$LazyDiskCacheProvider diskCacheProvider;
    private final Engine$EngineJobFactory engineJobFactory;
    private final Map jobs;
    private final EngineKeyFactory keyFactory;
    private final ResourceRecycler resourceRecycler;
    private ReferenceQueue resourceReferenceQueue;
    
    public Engine(final MemoryCache memoryCache, final DiskCache$Factory diskCache$Factory, final ExecutorService executorService, final ExecutorService executorService2) {
        this(memoryCache, diskCache$Factory, executorService, executorService2, null, null, null, null, null);
    }
    
    Engine(final MemoryCache cache, final DiskCache$Factory diskCache$Factory, final ExecutorService executorService, final ExecutorService executorService2, Map jobs, EngineKeyFactory keyFactory, Map activeResources, Engine$EngineJobFactory engineJobFactory, ResourceRecycler resourceRecycler) {
        this.cache = cache;
        this.diskCacheProvider = new Engine$LazyDiskCacheProvider(diskCache$Factory);
        if (activeResources == null) {
            activeResources = new HashMap();
        }
        this.activeResources = activeResources;
        if (keyFactory == null) {
            keyFactory = new EngineKeyFactory();
        }
        this.keyFactory = keyFactory;
        if (jobs == null) {
            jobs = new HashMap();
        }
        this.jobs = jobs;
        if (engineJobFactory == null) {
            engineJobFactory = new Engine$EngineJobFactory(executorService, executorService2, this);
        }
        this.engineJobFactory = engineJobFactory;
        if (resourceRecycler == null) {
            resourceRecycler = new ResourceRecycler();
        }
        this.resourceRecycler = resourceRecycler;
        cache.setResourceRemovedListener(this);
    }
    
    private EngineResource getEngineResourceFromCache(final Key key) {
        final Resource remove = this.cache.remove(key);
        EngineResource engineResource;
        if (remove == null) {
            engineResource = null;
        }
        else if (remove instanceof EngineResource) {
            engineResource = (EngineResource)remove;
        }
        else {
            engineResource = new EngineResource(remove, true);
        }
        return engineResource;
    }
    
    private ReferenceQueue getReferenceQueue() {
        if (this.resourceReferenceQueue == null) {
            this.resourceReferenceQueue = new ReferenceQueue();
            Looper.myQueue().addIdleHandler((MessageQueue$IdleHandler)new Engine$RefQueueIdleHandler(this.activeResources, this.resourceReferenceQueue));
        }
        return this.resourceReferenceQueue;
    }
    
    private EngineResource loadFromActiveResources(final Key key, final boolean b) {
        if (!b) {
            return null;
        }
        EngineResource engineResource = null;
        final WeakReference<Object> weakReference = this.activeResources.get(key);
        if (weakReference != null) {
            engineResource = weakReference.get();
            if (engineResource != null) {
                engineResource.acquire();
            }
            else {
                this.activeResources.remove(key);
            }
        }
        return engineResource;
    }
    
    private EngineResource loadFromCache(final Key key, final boolean b) {
        if (!b) {
            return null;
        }
        final EngineResource engineResourceFromCache = this.getEngineResourceFromCache(key);
        if (engineResourceFromCache != null) {
            engineResourceFromCache.acquire();
            this.activeResources.put(key, new Engine$ResourceWeakReference(key, engineResourceFromCache, this.getReferenceQueue()));
        }
        return engineResourceFromCache;
    }
    
    private static void logWithTimeAndKey(final String s, final long n, final Key key) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(" in ");
        sb.append(LogTime.getElapsedMillis(n));
        sb.append("ms, key: ");
        sb.append(key);
        Log.v("Engine", sb.toString());
    }
    
    public void clearDiskCache() {
        this.diskCacheProvider.getDiskCache().clear();
    }
    
    public Engine$LoadStatus load(final Key key, final int n, final int n2, final DataFetcher dataFetcher, final DataLoadProvider dataLoadProvider, final Transformation transformation, final ResourceTranscoder resourceTranscoder, final Priority priority, final boolean b, final DiskCacheStrategy diskCacheStrategy, final ResourceCallback resourceCallback) {
        Util.assertMainThread();
        final long logTime = LogTime.getLogTime();
        final EngineKey buildKey = this.keyFactory.buildKey(dataFetcher.getId(), key, n, n2, dataLoadProvider.getCacheDecoder(), dataLoadProvider.getSourceDecoder(), transformation, dataLoadProvider.getEncoder(), resourceTranscoder, dataLoadProvider.getSourceEncoder());
        final EngineResource loadFromCache = this.loadFromCache(buildKey, b);
        final int n3 = 2;
        if (loadFromCache != null) {
            resourceCallback.onResourceReady(loadFromCache);
            if (Log.isLoggable("Engine", n3)) {
                logWithTimeAndKey("Loaded resource from cache", logTime, buildKey);
            }
            return null;
        }
        final EngineResource loadFromActiveResources = this.loadFromActiveResources(buildKey, b);
        if (loadFromActiveResources != null) {
            resourceCallback.onResourceReady(loadFromActiveResources);
            if (Log.isLoggable("Engine", n3)) {
                logWithTimeAndKey("Loaded resource from active resources", logTime, buildKey);
            }
            return null;
        }
        final EngineJob engineJob = this.jobs.get(buildKey);
        if (engineJob != null) {
            engineJob.addCallback(resourceCallback);
            if (Log.isLoggable("Engine", n3)) {
                logWithTimeAndKey("Added to existing load", logTime, buildKey);
            }
            return new Engine$LoadStatus(resourceCallback, engineJob);
        }
        final EngineJob build = this.engineJobFactory.build(buildKey, b);
        final EngineRunnable engineRunnable = new EngineRunnable(build, new DecodeJob(buildKey, n, n2, dataFetcher, dataLoadProvider, transformation, resourceTranscoder, this.diskCacheProvider, diskCacheStrategy, priority), priority);
        this.jobs.put(buildKey, build);
        build.addCallback(resourceCallback);
        build.start(engineRunnable);
        if (Log.isLoggable("Engine", n3)) {
            logWithTimeAndKey("Started new load", logTime, buildKey);
        }
        return new Engine$LoadStatus(resourceCallback, build);
    }
    
    public void onEngineJobCancelled(final EngineJob engineJob, final Key key) {
        Util.assertMainThread();
        if (engineJob.equals(this.jobs.get(key))) {
            this.jobs.remove(key);
        }
    }
    
    public void onEngineJobComplete(final Key key, final EngineResource engineResource) {
        Util.assertMainThread();
        if (engineResource != null) {
            engineResource.setResourceListener(key, this);
            if (engineResource.isCacheable()) {
                this.activeResources.put(key, new Engine$ResourceWeakReference(key, engineResource, this.getReferenceQueue()));
            }
        }
        this.jobs.remove(key);
    }
    
    public void onResourceReleased(final Key key, final EngineResource engineResource) {
        Util.assertMainThread();
        this.activeResources.remove(key);
        if (engineResource.isCacheable()) {
            this.cache.put(key, engineResource);
        }
        else {
            this.resourceRecycler.recycle(engineResource);
        }
    }
    
    public void onResourceRemoved(final Resource resource) {
        Util.assertMainThread();
        this.resourceRecycler.recycle(resource);
    }
    
    public void release(final Resource resource) {
        Util.assertMainThread();
        if (resource instanceof EngineResource) {
            ((EngineResource)resource).release();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }
}
