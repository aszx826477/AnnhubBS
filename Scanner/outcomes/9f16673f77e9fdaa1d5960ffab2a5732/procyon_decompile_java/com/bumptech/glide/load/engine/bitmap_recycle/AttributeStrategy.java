// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.util.Util;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;

class AttributeStrategy implements LruPoolStrategy
{
    private final GroupedLinkedMap groupedMap;
    private final AttributeStrategy$KeyPool keyPool;
    
    AttributeStrategy() {
        this.keyPool = new AttributeStrategy$KeyPool();
        this.groupedMap = new GroupedLinkedMap();
    }
    
    private static String getBitmapString(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(n);
        sb.append("x");
        sb.append(n2);
        sb.append("], ");
        sb.append(bitmap$Config);
        return sb.toString();
    }
    
    private static String getBitmapString(final Bitmap bitmap) {
        return getBitmapString(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }
    
    public Bitmap get(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        return (Bitmap)this.groupedMap.get(this.keyPool.get(n, n2, bitmap$Config));
    }
    
    public int getSize(final Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }
    
    public String logBitmap(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        return getBitmapString(n, n2, bitmap$Config);
    }
    
    public String logBitmap(final Bitmap bitmap) {
        return getBitmapString(bitmap);
    }
    
    public void put(final Bitmap bitmap) {
        this.groupedMap.put(this.keyPool.get(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }
    
    public Bitmap removeLast() {
        return (Bitmap)this.groupedMap.removeLast();
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AttributeStrategy:\n  ");
        sb.append(this.groupedMap);
        return sb.toString();
    }
}
