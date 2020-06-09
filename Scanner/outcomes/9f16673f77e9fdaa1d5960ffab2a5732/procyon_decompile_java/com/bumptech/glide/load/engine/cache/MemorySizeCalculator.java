// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.cache;

import android.text.format.Formatter;
import android.os.Build$VERSION;
import android.util.Log;
import android.app.ActivityManager;
import android.content.Context;

public class MemorySizeCalculator
{
    static final int BITMAP_POOL_TARGET_SCREENS = 4;
    static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
    static final float MAX_SIZE_MULTIPLIER = 0.4f;
    static final int MEMORY_CACHE_TARGET_SCREENS = 2;
    private static final String TAG = "MemorySizeCalculator";
    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;
    
    public MemorySizeCalculator(final Context context) {
        this(context, (ActivityManager)context.getSystemService("activity"), new MemorySizeCalculator$DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics()));
    }
    
    MemorySizeCalculator(final Context context, final ActivityManager activityManager, final MemorySizeCalculator$ScreenDimensions memorySizeCalculator$ScreenDimensions) {
        this.context = context;
        final int maxSize = getMaxSize(activityManager);
        final int n = memorySizeCalculator$ScreenDimensions.getWidthPixels() * memorySizeCalculator$ScreenDimensions.getHeightPixels() * 4;
        final int bitmapPoolSize = n * 4;
        final int memoryCacheSize = n * 2;
        if (memoryCacheSize + bitmapPoolSize <= maxSize) {
            this.memoryCacheSize = memoryCacheSize;
            this.bitmapPoolSize = bitmapPoolSize;
        }
        else {
            final int round = Math.round(maxSize / 6.0f);
            this.memoryCacheSize = round * 2;
            this.bitmapPoolSize = round * 4;
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            final String s = "MemorySizeCalculator";
            final StringBuilder sb = new StringBuilder();
            sb.append("Calculated memory cache size: ");
            sb.append(this.toMb(this.memoryCacheSize));
            sb.append(" pool size: ");
            sb.append(this.toMb(this.bitmapPoolSize));
            sb.append(" memory class limited? ");
            sb.append(memoryCacheSize + bitmapPoolSize > maxSize);
            sb.append(" max size: ");
            sb.append(this.toMb(maxSize));
            sb.append(" memoryClass: ");
            sb.append(activityManager.getMemoryClass());
            sb.append(" isLowMemoryDevice: ");
            sb.append(isLowMemoryDevice(activityManager));
            Log.d(s, sb.toString());
        }
    }
    
    private static int getMaxSize(final ActivityManager activityManager) {
        final int n = activityManager.getMemoryClass() * 1024 * 1024;
        final boolean lowMemoryDevice = isLowMemoryDevice(activityManager);
        final float n2 = n;
        float n3;
        if (lowMemoryDevice) {
            n3 = 0.33f;
        }
        else {
            n3 = 0.4f;
        }
        return Math.round(n2 * n3);
    }
    
    private static boolean isLowMemoryDevice(final ActivityManager activityManager) {
        if (Build$VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return Build$VERSION.SDK_INT < 11;
    }
    
    private String toMb(final int n) {
        return Formatter.formatFileSize(this.context, (long)n);
    }
    
    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }
    
    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }
}
