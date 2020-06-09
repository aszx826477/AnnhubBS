// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import com.bumptech.glide.util.Util;
import android.graphics.Bitmap;
import java.util.TreeMap;
import java.util.NavigableMap;
import java.util.HashMap;
import java.util.Map;
import android.graphics.Bitmap$Config;

public class SizeConfigStrategy implements LruPoolStrategy
{
    private static final Bitmap$Config[] ALPHA_8_IN_CONFIGS;
    private static final Bitmap$Config[] ARGB_4444_IN_CONFIGS;
    private static final Bitmap$Config[] ARGB_8888_IN_CONFIGS;
    private static final int MAX_SIZE_MULTIPLE = 8;
    private static final Bitmap$Config[] RGB_565_IN_CONFIGS;
    private final GroupedLinkedMap groupedMap;
    private final SizeConfigStrategy$KeyPool keyPool;
    private final Map sortedSizes;
    
    static {
        final Bitmap$Config[] argb_8888_IN_CONFIGS = { Bitmap$Config.ARGB_8888, null };
        final int n = 1;
        argb_8888_IN_CONFIGS[n] = null;
        ARGB_8888_IN_CONFIGS = argb_8888_IN_CONFIGS;
        final Bitmap$Config[] rgb_565_IN_CONFIGS = new Bitmap$Config[n];
        rgb_565_IN_CONFIGS[0] = Bitmap$Config.RGB_565;
        RGB_565_IN_CONFIGS = rgb_565_IN_CONFIGS;
        final Bitmap$Config[] argb_4444_IN_CONFIGS = new Bitmap$Config[n];
        argb_4444_IN_CONFIGS[0] = Bitmap$Config.ARGB_4444;
        ARGB_4444_IN_CONFIGS = argb_4444_IN_CONFIGS;
        final Bitmap$Config[] alpha_8_IN_CONFIGS = new Bitmap$Config[n];
        alpha_8_IN_CONFIGS[0] = Bitmap$Config.ALPHA_8;
        ALPHA_8_IN_CONFIGS = alpha_8_IN_CONFIGS;
    }
    
    public SizeConfigStrategy() {
        this.keyPool = new SizeConfigStrategy$KeyPool();
        this.groupedMap = new GroupedLinkedMap();
        this.sortedSizes = new HashMap();
    }
    
    private void decrementBitmapOfSize(final Integer n, final Bitmap$Config bitmap$Config) {
        final NavigableMap sizesForConfig = this.getSizesForConfig(bitmap$Config);
        final Integer n2 = sizesForConfig.get(n);
        final int intValue = n2;
        final int n3 = 1;
        if (intValue == n3) {
            sizesForConfig.remove(n);
        }
        else {
            sizesForConfig.put(n, n2 - n3);
        }
    }
    
    private SizeConfigStrategy$Key findBestKey(final SizeConfigStrategy$Key sizeConfigStrategy$Key, final int n, final Bitmap$Config bitmap$Config) {
        SizeConfigStrategy$Key value = sizeConfigStrategy$Key;
        final Bitmap$Config[] inConfigs = getInConfigs(bitmap$Config);
        for (int length = inConfigs.length, i = 0; i < length; ++i) {
            final Bitmap$Config bitmap$Config2 = inConfigs[i];
            final Integer n2 = this.getSizesForConfig(bitmap$Config2).ceilingKey(n);
            if (n2 != null && n2 <= n * 8) {
                Label_0128: {
                    if (n2 == n) {
                        if (bitmap$Config2 == null) {
                            if (bitmap$Config != null) {
                                break Label_0128;
                            }
                        }
                        else if (!bitmap$Config2.equals((Object)bitmap$Config)) {
                            break Label_0128;
                        }
                        break;
                    }
                }
                this.keyPool.offer(sizeConfigStrategy$Key);
                value = this.keyPool.get(n2, bitmap$Config2);
                break;
            }
        }
        return value;
    }
    
    private static String getBitmapString(final int n, final Bitmap$Config bitmap$Config) {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(n);
        sb.append("](");
        sb.append(bitmap$Config);
        sb.append(")");
        return sb.toString();
    }
    
    private static Bitmap$Config[] getInConfigs(final Bitmap$Config bitmap$Config) {
        switch (SizeConfigStrategy$1.$SwitchMap$android$graphics$Bitmap$Config[bitmap$Config.ordinal()]) {
            default: {
                return new Bitmap$Config[] { bitmap$Config };
            }
            case 4: {
                return SizeConfigStrategy.ALPHA_8_IN_CONFIGS;
            }
            case 3: {
                return SizeConfigStrategy.ARGB_4444_IN_CONFIGS;
            }
            case 2: {
                return SizeConfigStrategy.RGB_565_IN_CONFIGS;
            }
            case 1: {
                return SizeConfigStrategy.ARGB_8888_IN_CONFIGS;
            }
        }
    }
    
    private NavigableMap getSizesForConfig(final Bitmap$Config bitmap$Config) {
        NavigableMap<?, ?> navigableMap = this.sortedSizes.get(bitmap$Config);
        if (navigableMap == null) {
            navigableMap = new TreeMap<Object, Object>();
            this.sortedSizes.put(bitmap$Config, navigableMap);
        }
        return navigableMap;
    }
    
    public Bitmap get(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        final int bitmapByteSize = Util.getBitmapByteSize(n, n2, bitmap$Config);
        final Bitmap bitmap = (Bitmap)this.groupedMap.get(this.findBestKey(this.keyPool.get(bitmapByteSize, bitmap$Config), bitmapByteSize, bitmap$Config));
        if (bitmap != null) {
            this.decrementBitmapOfSize(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
            Bitmap$Config bitmap$Config2;
            if (bitmap.getConfig() != null) {
                bitmap$Config2 = bitmap.getConfig();
            }
            else {
                bitmap$Config2 = Bitmap$Config.ARGB_8888;
            }
            bitmap.reconfigure(n, n2, bitmap$Config2);
        }
        return bitmap;
    }
    
    public int getSize(final Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }
    
    public String logBitmap(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        return getBitmapString(Util.getBitmapByteSize(n, n2, bitmap$Config), bitmap$Config);
    }
    
    public String logBitmap(final Bitmap bitmap) {
        return getBitmapString(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
    }
    
    public void put(final Bitmap bitmap) {
        final SizeConfigStrategy$Key value = this.keyPool.get(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
        this.groupedMap.put(value, bitmap);
        final NavigableMap sizesForConfig = this.getSizesForConfig(bitmap.getConfig());
        final Integer n = sizesForConfig.get(value.size);
        final Integer value2 = value.size;
        int n2 = 1;
        if (n != null) {
            n2 += n;
        }
        sizesForConfig.put(value2, n2);
    }
    
    public Bitmap removeLast() {
        final Bitmap bitmap = (Bitmap)this.groupedMap.removeLast();
        if (bitmap != null) {
            this.decrementBitmapOfSize(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
        }
        return bitmap;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.groupedMap);
        final StringBuilder append = sb.append(", sortedSizes=(");
        for (final Map.Entry<Object, V> entry : this.sortedSizes.entrySet()) {
            append.append(entry.getKey());
            append.append('[');
            append.append(entry.getValue());
            append.append("], ");
        }
        if (!this.sortedSizes.isEmpty()) {
            append.replace(append.length() - 2, append.length(), "");
        }
        append.append(")}");
        return append.toString();
    }
}
