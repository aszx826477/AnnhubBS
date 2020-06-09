// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawableResource;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.Glide;
import android.content.Context;
import android.content.res.Resources;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public class GlideBitmapDrawableTranscoder implements ResourceTranscoder
{
    private final BitmapPool bitmapPool;
    private final Resources resources;
    
    public GlideBitmapDrawableTranscoder(final Context context) {
        this(context.getResources(), Glide.get(context).getBitmapPool());
    }
    
    public GlideBitmapDrawableTranscoder(final Resources resources, final BitmapPool bitmapPool) {
        this.resources = resources;
        this.bitmapPool = bitmapPool;
    }
    
    public String getId() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
    
    public Resource transcode(final Resource resource) {
        return new GlideBitmapDrawableResource(new GlideBitmapDrawable(this.resources, (Bitmap)resource.get()), this.bitmapPool);
    }
}
