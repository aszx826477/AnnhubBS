// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import java.io.File;
import com.bumptech.glide.load.Key;
import android.util.Log;
import com.bumptech.glide.load.engine.cache.DiskCache$Writer;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.Priority;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.load.data.DataFetcher;

class DecodeJob
{
    private static final DecodeJob$FileOpener DEFAULT_FILE_OPENER;
    private static final String TAG = "DecodeJob";
    private final DecodeJob$DiskCacheProvider diskCacheProvider;
    private final DiskCacheStrategy diskCacheStrategy;
    private final DataFetcher fetcher;
    private final DecodeJob$FileOpener fileOpener;
    private final int height;
    private volatile boolean isCancelled;
    private final DataLoadProvider loadProvider;
    private final Priority priority;
    private final EngineKey resultKey;
    private final ResourceTranscoder transcoder;
    private final Transformation transformation;
    private final int width;
    
    static {
        DEFAULT_FILE_OPENER = new DecodeJob$FileOpener();
    }
    
    public DecodeJob(final EngineKey engineKey, final int n, final int n2, final DataFetcher dataFetcher, final DataLoadProvider dataLoadProvider, final Transformation transformation, final ResourceTranscoder resourceTranscoder, final DecodeJob$DiskCacheProvider decodeJob$DiskCacheProvider, final DiskCacheStrategy diskCacheStrategy, final Priority priority) {
        this(engineKey, n, n2, dataFetcher, dataLoadProvider, transformation, resourceTranscoder, decodeJob$DiskCacheProvider, diskCacheStrategy, priority, DecodeJob.DEFAULT_FILE_OPENER);
    }
    
    DecodeJob(final EngineKey resultKey, final int width, final int height, final DataFetcher fetcher, final DataLoadProvider loadProvider, final Transformation transformation, final ResourceTranscoder transcoder, final DecodeJob$DiskCacheProvider diskCacheProvider, final DiskCacheStrategy diskCacheStrategy, final Priority priority, final DecodeJob$FileOpener fileOpener) {
        this.resultKey = resultKey;
        this.width = width;
        this.height = height;
        this.fetcher = fetcher;
        this.loadProvider = loadProvider;
        this.transformation = transformation;
        this.transcoder = transcoder;
        this.diskCacheProvider = diskCacheProvider;
        this.diskCacheStrategy = diskCacheStrategy;
        this.priority = priority;
        this.fileOpener = fileOpener;
    }
    
    private Resource cacheAndDecodeSourceData(final Object o) {
        final long logTime = LogTime.getLogTime();
        this.diskCacheProvider.getDiskCache().put(this.resultKey.getOriginalKey(), new DecodeJob$SourceWriter(this, this.loadProvider.getSourceEncoder(), o));
        final String s = "DecodeJob";
        final int n = 2;
        if (Log.isLoggable(s, n)) {
            this.logWithTimeAndKey("Wrote source to cache", logTime);
        }
        final long logTime2 = LogTime.getLogTime();
        final Resource loadFromCache = this.loadFromCache(this.resultKey.getOriginalKey());
        if (Log.isLoggable("DecodeJob", n) && loadFromCache != null) {
            this.logWithTimeAndKey("Decoded source from cache", logTime2);
        }
        return loadFromCache;
    }
    
    private Resource decodeFromSourceData(final Object o) {
        Resource cacheAndDecodeSourceData;
        if (this.diskCacheStrategy.cacheSource()) {
            cacheAndDecodeSourceData = this.cacheAndDecodeSourceData(o);
        }
        else {
            final long logTime = LogTime.getLogTime();
            final Resource decode = this.loadProvider.getSourceDecoder().decode(o, this.width, this.height);
            if (Log.isLoggable("DecodeJob", 2)) {
                this.logWithTimeAndKey("Decoded from source", logTime);
            }
            cacheAndDecodeSourceData = decode;
        }
        return cacheAndDecodeSourceData;
    }
    
    private Resource decodeSource() {
        try {
            final long logTime = LogTime.getLogTime();
            final Object loadData = this.fetcher.loadData(this.priority);
            if (Log.isLoggable("DecodeJob", 2)) {
                this.logWithTimeAndKey("Fetched data", logTime);
            }
            if (this.isCancelled) {
                return null;
            }
            return this.decodeFromSourceData(loadData);
        }
        finally {
            this.fetcher.cleanup();
        }
    }
    
    private Resource loadFromCache(final Key key) {
        final File value = this.diskCacheProvider.getDiskCache().get(key);
        if (value == null) {
            return null;
        }
        try {
            final Resource decode;
            if ((decode = this.loadProvider.getCacheDecoder().decode(value, this.width, this.height)) == null) {
                this.diskCacheProvider.getDiskCache().delete(key);
            }
            return decode;
        }
        finally {
            if (!false) {
                this.diskCacheProvider.getDiskCache().delete(key);
            }
        }
    }
    
    private void logWithTimeAndKey(final String s, final long n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(" in ");
        sb.append(LogTime.getElapsedMillis(n));
        sb.append(", key: ");
        sb.append(this.resultKey);
        Log.v("DecodeJob", sb.toString());
    }
    
    private Resource transcode(final Resource resource) {
        if (resource == null) {
            return null;
        }
        return this.transcoder.transcode(resource);
    }
    
    private Resource transform(final Resource resource) {
        if (resource == null) {
            return null;
        }
        final Resource transform = this.transformation.transform(resource, this.width, this.height);
        if (!resource.equals(transform)) {
            resource.recycle();
        }
        return transform;
    }
    
    private Resource transformEncodeAndTranscode(final Resource resource) {
        final long logTime = LogTime.getLogTime();
        final Resource transform = this.transform(resource);
        final String s = "DecodeJob";
        final int n = 2;
        if (Log.isLoggable(s, n)) {
            this.logWithTimeAndKey("Transformed resource from source", logTime);
        }
        this.writeTransformedToCache(transform);
        final long logTime2 = LogTime.getLogTime();
        final Resource transcode = this.transcode(transform);
        if (Log.isLoggable("DecodeJob", n)) {
            this.logWithTimeAndKey("Transcoded transformed from source", logTime2);
        }
        return transcode;
    }
    
    private void writeTransformedToCache(final Resource resource) {
        if (resource != null && this.diskCacheStrategy.cacheResult()) {
            final long logTime = LogTime.getLogTime();
            this.diskCacheProvider.getDiskCache().put(this.resultKey, new DecodeJob$SourceWriter(this, this.loadProvider.getEncoder(), resource));
            if (Log.isLoggable("DecodeJob", 2)) {
                this.logWithTimeAndKey("Wrote transformed from source to cache", logTime);
            }
        }
    }
    
    public void cancel() {
        this.isCancelled = true;
        this.fetcher.cancel();
    }
    
    public Resource decodeFromSource() {
        return this.transformEncodeAndTranscode(this.decodeSource());
    }
    
    public Resource decodeResultFromCache() {
        if (!this.diskCacheStrategy.cacheResult()) {
            return null;
        }
        final long logTime = LogTime.getLogTime();
        final Resource loadFromCache = this.loadFromCache(this.resultKey);
        final String s = "DecodeJob";
        final int n = 2;
        if (Log.isLoggable(s, n)) {
            this.logWithTimeAndKey("Decoded transformed from cache", logTime);
        }
        final long logTime2 = LogTime.getLogTime();
        final Resource transcode = this.transcode(loadFromCache);
        if (Log.isLoggable("DecodeJob", n)) {
            this.logWithTimeAndKey("Transcoded transformed from cache", logTime2);
        }
        return transcode;
    }
    
    public Resource decodeSourceFromCache() {
        if (!this.diskCacheStrategy.cacheSource()) {
            return null;
        }
        final long logTime = LogTime.getLogTime();
        final Resource loadFromCache = this.loadFromCache(this.resultKey.getOriginalKey());
        if (Log.isLoggable("DecodeJob", 2)) {
            this.logWithTimeAndKey("Decoded source from cache", logTime);
        }
        return this.transformEncodeAndTranscode(loadFromCache);
    }
}
