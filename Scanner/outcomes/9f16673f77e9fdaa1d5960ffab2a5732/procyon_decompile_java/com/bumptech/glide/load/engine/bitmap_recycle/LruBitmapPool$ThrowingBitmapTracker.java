// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class LruBitmapPool$ThrowingBitmapTracker implements LruBitmapPool$BitmapTracker
{
    private final Set bitmaps;
    
    private LruBitmapPool$ThrowingBitmapTracker() {
        this.bitmaps = Collections.synchronizedSet(new HashSet<Object>());
    }
    
    public void add(final Bitmap bitmap) {
        if (!this.bitmaps.contains(bitmap)) {
            this.bitmaps.add(bitmap);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Can't add already added bitmap: ");
        sb.append(bitmap);
        sb.append(" [");
        sb.append(bitmap.getWidth());
        sb.append("x");
        sb.append(bitmap.getHeight());
        sb.append("]");
        throw new IllegalStateException(sb.toString());
    }
    
    public void remove(final Bitmap bitmap) {
        if (this.bitmaps.contains(bitmap)) {
            this.bitmaps.remove(bitmap);
            return;
        }
        throw new IllegalStateException("Cannot remove bitmap not in tracker");
    }
}
