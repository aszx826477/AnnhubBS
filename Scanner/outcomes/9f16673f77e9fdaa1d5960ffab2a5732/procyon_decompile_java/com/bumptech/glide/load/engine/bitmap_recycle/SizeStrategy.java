// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap$Config;
import com.bumptech.glide.util.Util;
import android.graphics.Bitmap;
import java.util.TreeMap;

class SizeStrategy implements LruPoolStrategy
{
    private static final int MAX_SIZE_MULTIPLE = 8;
    private final GroupedLinkedMap groupedMap;
    private final SizeStrategy$KeyPool keyPool;
    private final TreeMap sortedSizes;
    
    SizeStrategy() {
        this.keyPool = new SizeStrategy$KeyPool();
        this.groupedMap = new GroupedLinkedMap();
        this.sortedSizes = new PrettyPrintTreeMap();
    }
    
    private void decrementBitmapOfSize(final Integer n) {
        final Integer n2 = this.sortedSizes.get(n);
        final int intValue = n2;
        final int n3 = 1;
        if (intValue == n3) {
            this.sortedSizes.remove(n);
        }
        else {
            this.sortedSizes.put(n, n2 - n3);
        }
    }
    
    private static String getBitmapString(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(n);
        sb.append("]");
        return sb.toString();
    }
    
    private static String getBitmapString(final Bitmap bitmap) {
        return getBitmapString(Util.getBitmapByteSize(bitmap));
    }
    
    public Bitmap get(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        final int bitmapByteSize = Util.getBitmapByteSize(n, n2, bitmap$Config);
        SizeStrategy$Key sizeStrategy$Key = this.keyPool.get(bitmapByteSize);
        final Integer n3 = this.sortedSizes.ceilingKey(bitmapByteSize);
        if (n3 != null && n3 != bitmapByteSize && n3 <= bitmapByteSize * 8) {
            this.keyPool.offer(sizeStrategy$Key);
            sizeStrategy$Key = this.keyPool.get(n3);
        }
        final Bitmap bitmap = (Bitmap)this.groupedMap.get(sizeStrategy$Key);
        if (bitmap != null) {
            bitmap.reconfigure(n, n2, bitmap$Config);
            this.decrementBitmapOfSize(n3);
        }
        return bitmap;
    }
    
    public int getSize(final Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }
    
    public String logBitmap(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        return getBitmapString(Util.getBitmapByteSize(n, n2, bitmap$Config));
    }
    
    public String logBitmap(final Bitmap bitmap) {
        return getBitmapString(bitmap);
    }
    
    public void put(final Bitmap bitmap) {
        final SizeStrategy$Key value = this.keyPool.get(Util.getBitmapByteSize(bitmap));
        this.groupedMap.put(value, bitmap);
        final Integer n = this.sortedSizes.get(value.size);
        final TreeMap sortedSizes = this.sortedSizes;
        final Integer value2 = value.size;
        int n2 = 1;
        if (n != null) {
            n2 += n;
        }
        sortedSizes.put(value2, n2);
    }
    
    public Bitmap removeLast() {
        final Bitmap bitmap = (Bitmap)this.groupedMap.removeLast();
        if (bitmap != null) {
            this.decrementBitmapOfSize(Util.getBitmapByteSize(bitmap));
        }
        return bitmap;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SizeStrategy:\n  ");
        sb.append(this.groupedMap);
        sb.append("\n");
        sb.append("  SortedSizes");
        sb.append(this.sortedSizes);
        return sb.toString();
    }
}
