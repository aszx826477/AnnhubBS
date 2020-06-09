// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap$Config;
import com.bumptech.glide.util.Util;
import android.graphics.Bitmap;
import java.util.TreeMap;

final class SizeStrategy$Key implements Poolable
{
    private final SizeStrategy$KeyPool pool;
    private int size;
    
    SizeStrategy$Key(final SizeStrategy$KeyPool pool) {
        this.pool = pool;
    }
    
    public boolean equals(final Object o) {
        final boolean b = o instanceof SizeStrategy$Key;
        boolean b2 = false;
        if (b) {
            if (this.size == ((SizeStrategy$Key)o).size) {
                b2 = true;
            }
            return b2;
        }
        return false;
    }
    
    public int hashCode() {
        return this.size;
    }
    
    public void init(final int size) {
        this.size = size;
    }
    
    public void offer() {
        this.pool.offer(this);
    }
    
    public String toString() {
        return getBitmapString(this.size);
    }
}
