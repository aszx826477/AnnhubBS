// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import java.util.Collections;
import android.os.Build$VERSION;
import java.util.Collection;
import java.util.Arrays;
import java.util.HashSet;
import android.util.Log;
import java.util.Set;
import android.graphics.Bitmap$Config;

public class LruBitmapPool implements BitmapPool
{
    private static final Bitmap$Config DEFAULT_CONFIG;
    private static final String TAG = "LruBitmapPool";
    private final Set allowedConfigs;
    private int currentSize;
    private int evictions;
    private int hits;
    private final int initialMaxSize;
    private int maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final LruBitmapPool$BitmapTracker tracker;
    
    static {
        DEFAULT_CONFIG = Bitmap$Config.ARGB_8888;
    }
    
    public LruBitmapPool(final int n) {
        this(n, getDefaultStrategy(), getDefaultAllowedConfigs());
    }
    
    LruBitmapPool(final int n, final LruPoolStrategy strategy, final Set allowedConfigs) {
        this.initialMaxSize = n;
        this.maxSize = n;
        this.strategy = strategy;
        this.allowedConfigs = allowedConfigs;
        this.tracker = new LruBitmapPool$NullBitmapTracker(null);
    }
    
    public LruBitmapPool(final int n, final Set set) {
        this(n, getDefaultStrategy(), set);
    }
    
    private void dump() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            this.dumpUnchecked();
        }
    }
    
    private void dumpUnchecked() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Hits=");
        sb.append(this.hits);
        sb.append(", misses=");
        sb.append(this.misses);
        sb.append(", puts=");
        sb.append(this.puts);
        sb.append(", evictions=");
        sb.append(this.evictions);
        sb.append(", currentSize=");
        sb.append(this.currentSize);
        sb.append(", maxSize=");
        sb.append(this.maxSize);
        sb.append("\nStrategy=");
        sb.append(this.strategy);
        Log.v("LruBitmapPool", sb.toString());
    }
    
    private void evict() {
        this.trimToSize(this.maxSize);
    }
    
    private static Set getDefaultAllowedConfigs() {
        final HashSet<Object> set = new HashSet<Object>();
        set.addAll(Arrays.asList(Bitmap$Config.values()));
        if (Build$VERSION.SDK_INT >= 19) {
            set.add(null);
        }
        return Collections.unmodifiableSet((Set<?>)set);
    }
    
    private static LruPoolStrategy getDefaultStrategy() {
        LruPoolStrategy lruPoolStrategy;
        if (Build$VERSION.SDK_INT >= 19) {
            lruPoolStrategy = new SizeConfigStrategy();
        }
        else {
            lruPoolStrategy = new AttributeStrategy();
        }
        return lruPoolStrategy;
    }
    
    private void trimToSize(final int n) {
        synchronized (this) {
            while (this.currentSize > n) {
                final Bitmap removeLast = this.strategy.removeLast();
                if (removeLast == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        this.dumpUnchecked();
                    }
                    this.currentSize = 0;
                    return;
                }
                this.tracker.remove(removeLast);
                this.currentSize -= this.strategy.getSize(removeLast);
                removeLast.recycle();
                ++this.evictions;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    final String s = "LruBitmapPool";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Evicting bitmap=");
                    sb.append(this.strategy.logBitmap(removeLast));
                    Log.d(s, sb.toString());
                }
                this.dump();
            }
        }
    }
    
    public void clearMemory() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        this.trimToSize(0);
    }
    
    public Bitmap get(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        synchronized (this) {
            final Bitmap dirty = this.getDirty(n, n2, bitmap$Config);
            if (dirty != null) {
                dirty.eraseColor(0);
            }
            return dirty;
        }
    }
    
    public Bitmap getDirty(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        synchronized (this) {
            final LruPoolStrategy strategy = this.strategy;
            Bitmap$Config default_CONFIG;
            if (bitmap$Config != null) {
                default_CONFIG = bitmap$Config;
            }
            else {
                default_CONFIG = LruBitmapPool.DEFAULT_CONFIG;
            }
            final Bitmap value = strategy.get(n, n2, default_CONFIG);
            final int hasAlpha = 1;
            if (value == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    final String s = "LruBitmapPool";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Missing bitmap=");
                    sb.append(this.strategy.logBitmap(n, n2, bitmap$Config));
                    Log.d(s, sb.toString());
                }
                this.misses += hasAlpha;
            }
            else {
                this.hits += hasAlpha;
                this.currentSize -= this.strategy.getSize(value);
                this.tracker.remove(value);
                if (Build$VERSION.SDK_INT >= 12) {
                    value.setHasAlpha((boolean)(hasAlpha != 0));
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                final String s2 = "LruBitmapPool";
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Get bitmap=");
                sb2.append(this.strategy.logBitmap(n, n2, bitmap$Config));
                Log.v(s2, sb2.toString());
            }
            this.dump();
            return value;
        }
    }
    
    public int getMaxSize() {
        return this.maxSize;
    }
    
    public boolean put(final Bitmap bitmap) {
        // monitorenter(this)
        if (bitmap != null) {
            Label_0429: {
                try {
                    final boolean mutable = bitmap.isMutable();
                    final int n = 2;
                    if (mutable && this.strategy.getSize(bitmap) <= this.maxSize && this.allowedConfigs.contains(bitmap.getConfig())) {
                        final int size = this.strategy.getSize(bitmap);
                        this.strategy.put(bitmap);
                        this.tracker.add(bitmap);
                        final int puts = this.puts;
                        final int n2 = 1;
                        this.puts = puts + n2;
                        this.currentSize += size;
                        if (Log.isLoggable("LruBitmapPool", n)) {
                            final String s = "LruBitmapPool";
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Put bitmap in pool=");
                            sb.append(this.strategy.logBitmap(bitmap));
                            Log.v(s, sb.toString());
                        }
                        this.dump();
                        this.evict();
                        // monitorexit(this)
                        return n2 != 0;
                    }
                    if (Log.isLoggable("LruBitmapPool", n)) {
                        final String s2 = "LruBitmapPool";
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Reject bitmap from pool, bitmap: ");
                        sb2.append(this.strategy.logBitmap(bitmap));
                        sb2.append(", is mutable: ");
                        sb2.append(bitmap.isMutable());
                        sb2.append(", is allowed config: ");
                        sb2.append(this.allowedConfigs.contains(bitmap.getConfig()));
                        Log.v(s2, sb2.toString());
                    }
                    // monitorexit(this)
                    return false;
                }
                finally {
                    break Label_0429;
                }
                throw new NullPointerException("Bitmap must not be null");
            }
        }
        // monitorexit(this)
        throw new NullPointerException("Bitmap must not be null");
    }
    
    public void setSizeMultiplier(final float n) {
        synchronized (this) {
            this.maxSize = Math.round(this.initialMaxSize * n);
            this.evict();
        }
    }
    
    public void trimMemory(final int n) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            final String s = "LruBitmapPool";
            final StringBuilder sb = new StringBuilder();
            sb.append("trimMemory, level=");
            sb.append(n);
            Log.d(s, sb.toString());
        }
        if (n >= 60) {
            this.clearMemory();
        }
        else if (n >= 40) {
            this.trimToSize(this.maxSize / 2);
        }
    }
}
