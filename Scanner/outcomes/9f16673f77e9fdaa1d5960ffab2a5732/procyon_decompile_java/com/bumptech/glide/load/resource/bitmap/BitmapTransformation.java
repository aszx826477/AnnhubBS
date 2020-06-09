// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.util.Util;
import com.bumptech.glide.load.engine.Resource;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import android.content.Context;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.Transformation;

public abstract class BitmapTransformation implements Transformation
{
    private BitmapPool bitmapPool;
    
    public BitmapTransformation(final Context context) {
        this(Glide.get(context).getBitmapPool());
    }
    
    public BitmapTransformation(final BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }
    
    protected abstract Bitmap transform(final BitmapPool p0, final Bitmap p1, final int p2, final int p3);
    
    public final Resource transform(final Resource resource, final int n, final int n2) {
        if (Util.isValidDimensions(n, n2)) {
            final Bitmap bitmap = (Bitmap)resource.get();
            final int n3 = -1 << -1;
            int width;
            if (n == n3) {
                width = bitmap.getWidth();
            }
            else {
                width = n;
            }
            int height;
            if (n2 == n3) {
                height = bitmap.getHeight();
            }
            else {
                height = n2;
            }
            final Bitmap transform = this.transform(this.bitmapPool, bitmap, width, height);
            Resource obtain;
            if (bitmap.equals(transform)) {
                obtain = resource;
            }
            else {
                obtain = BitmapResource.obtain(transform, this.bitmapPool);
            }
            return obtain;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot apply transformation on width: ");
        sb.append(n);
        sb.append(" or height: ");
        sb.append(n2);
        sb.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
        throw new IllegalArgumentException(sb.toString());
    }
}
