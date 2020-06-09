// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import android.os.Build$VERSION;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.FifoPriorityThreadPoolExecutor;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.Engine;
import java.util.concurrent.ExecutorService;
import com.bumptech.glide.load.engine.cache.DiskCache$Factory;
import com.bumptech.glide.load.DecodeFormat;
import android.content.Context;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public class GlideBuilder
{
    private BitmapPool bitmapPool;
    private final Context context;
    private DecodeFormat decodeFormat;
    private DiskCache$Factory diskCacheFactory;
    private ExecutorService diskCacheService;
    private Engine engine;
    private MemoryCache memoryCache;
    private ExecutorService sourceService;
    
    public GlideBuilder(final Context context) {
        this.context = context.getApplicationContext();
    }
    
    Glide createGlide() {
        final ExecutorService sourceService = this.sourceService;
        final int n = 1;
        if (sourceService == null) {
            this.sourceService = new FifoPriorityThreadPoolExecutor(Math.max(n, Runtime.getRuntime().availableProcessors()));
        }
        if (this.diskCacheService == null) {
            this.diskCacheService = new FifoPriorityThreadPoolExecutor(n);
        }
        final MemorySizeCalculator memorySizeCalculator = new MemorySizeCalculator(this.context);
        if (this.bitmapPool == null) {
            if (Build$VERSION.SDK_INT >= 11) {
                this.bitmapPool = new LruBitmapPool(memorySizeCalculator.getBitmapPoolSize());
            }
            else {
                this.bitmapPool = new BitmapPoolAdapter();
            }
        }
        if (this.memoryCache == null) {
            this.memoryCache = new LruResourceCache(memorySizeCalculator.getMemoryCacheSize());
        }
        if (this.diskCacheFactory == null) {
            this.diskCacheFactory = new InternalCacheDiskCacheFactory(this.context);
        }
        if (this.engine == null) {
            this.engine = new Engine(this.memoryCache, this.diskCacheFactory, this.diskCacheService, this.sourceService);
        }
        if (this.decodeFormat == null) {
            this.decodeFormat = DecodeFormat.DEFAULT;
        }
        return new Glide(this.engine, this.memoryCache, this.bitmapPool, this.context, this.decodeFormat);
    }
    
    public GlideBuilder setBitmapPool(final BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
        return this;
    }
    
    public GlideBuilder setDecodeFormat(final DecodeFormat decodeFormat) {
        this.decodeFormat = decodeFormat;
        return this;
    }
    
    public GlideBuilder setDiskCache(final DiskCache$Factory diskCacheFactory) {
        this.diskCacheFactory = diskCacheFactory;
        return this;
    }
    
    public GlideBuilder setDiskCache(final DiskCache diskCache) {
        return this.setDiskCache(new GlideBuilder$1(this, diskCache));
    }
    
    public GlideBuilder setDiskCacheService(final ExecutorService diskCacheService) {
        this.diskCacheService = diskCacheService;
        return this;
    }
    
    GlideBuilder setEngine(final Engine engine) {
        this.engine = engine;
        return this;
    }
    
    public GlideBuilder setMemoryCache(final MemoryCache memoryCache) {
        this.memoryCache = memoryCache;
        return this;
    }
    
    public GlideBuilder setResizeService(final ExecutorService sourceService) {
        this.sourceService = sourceService;
        return this;
    }
}
