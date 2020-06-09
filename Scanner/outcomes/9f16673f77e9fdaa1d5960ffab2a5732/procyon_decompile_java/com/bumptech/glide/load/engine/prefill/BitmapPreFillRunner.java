// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.prefill;

import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import android.graphics.Bitmap;
import java.util.HashSet;
import android.os.Looper;
import java.util.concurrent.TimeUnit;
import java.util.Set;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import android.os.Handler;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

final class BitmapPreFillRunner implements Runnable
{
    static final int BACKOFF_RATIO = 4;
    private static final BitmapPreFillRunner$Clock DEFAULT_CLOCK;
    static final long INITIAL_BACKOFF_MS = 40L;
    static final long MAX_BACKOFF_MS = 0L;
    static final long MAX_DURATION_MS = 32L;
    private static final String TAG = "PreFillRunner";
    private final BitmapPool bitmapPool;
    private final BitmapPreFillRunner$Clock clock;
    private long currentDelay;
    private final Handler handler;
    private boolean isCancelled;
    private final MemoryCache memoryCache;
    private final Set seenTypes;
    private final PreFillQueue toPrefill;
    
    static {
        DEFAULT_CLOCK = new BitmapPreFillRunner$Clock();
    }
    
    public BitmapPreFillRunner(final BitmapPool bitmapPool, final MemoryCache memoryCache, final PreFillQueue preFillQueue) {
        this(bitmapPool, memoryCache, preFillQueue, BitmapPreFillRunner.DEFAULT_CLOCK, new Handler(Looper.getMainLooper()));
    }
    
    BitmapPreFillRunner(final BitmapPool bitmapPool, final MemoryCache memoryCache, final PreFillQueue toPrefill, final BitmapPreFillRunner$Clock clock, final Handler handler) {
        this.seenTypes = new HashSet();
        this.currentDelay = 40;
        this.bitmapPool = bitmapPool;
        this.memoryCache = memoryCache;
        this.toPrefill = toPrefill;
        this.clock = clock;
        this.handler = handler;
    }
    
    private void addToBitmapPool(final PreFillType preFillType, final Bitmap bitmap) {
        if (this.seenTypes.add(preFillType)) {
            final Bitmap value = this.bitmapPool.get(preFillType.getWidth(), preFillType.getHeight(), preFillType.getConfig());
            if (value != null) {
                this.bitmapPool.put(value);
            }
        }
        this.bitmapPool.put(bitmap);
    }
    
    private boolean allocate() {
        final long now = this.clock.now();
        while (!this.toPrefill.isEmpty() && !this.isGcDetected(now)) {
            final PreFillType remove = this.toPrefill.remove();
            final Bitmap bitmap = Bitmap.createBitmap(remove.getWidth(), remove.getHeight(), remove.getConfig());
            if (this.getFreeMemoryCacheBytes() >= Util.getBitmapByteSize(bitmap)) {
                this.memoryCache.put(new BitmapPreFillRunner$UniqueKey(null), BitmapResource.obtain(bitmap, this.bitmapPool));
            }
            else {
                this.addToBitmapPool(remove, bitmap);
            }
            if (Log.isLoggable("PreFillRunner", 3)) {
                final String s = "PreFillRunner";
                final StringBuilder sb = new StringBuilder();
                sb.append("allocated [");
                sb.append(remove.getWidth());
                sb.append("x");
                sb.append(remove.getHeight());
                sb.append("] ");
                sb.append(remove.getConfig());
                sb.append(" size: ");
                sb.append(Util.getBitmapByteSize(bitmap));
                Log.d(s, sb.toString());
            }
        }
        return !this.isCancelled && !this.toPrefill.isEmpty();
    }
    
    private int getFreeMemoryCacheBytes() {
        return this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize();
    }
    
    private long getNextDelay() {
        final long currentDelay = this.currentDelay;
        this.currentDelay = Math.min(this.currentDelay * 4, BitmapPreFillRunner.MAX_BACKOFF_MS);
        return currentDelay;
    }
    
    private boolean isGcDetected(final long n) {
        return this.clock.now() - n >= 32;
    }
    
    public void cancel() {
        this.isCancelled = true;
    }
    
    public void run() {
        if (this.allocate()) {
            this.handler.postDelayed((Runnable)this, this.getNextDelay());
        }
    }
}
