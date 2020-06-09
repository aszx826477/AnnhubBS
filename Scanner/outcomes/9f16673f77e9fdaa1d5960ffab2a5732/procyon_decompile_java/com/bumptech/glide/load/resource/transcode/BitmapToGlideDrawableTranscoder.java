// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.engine.Resource;
import android.content.Context;

public class BitmapToGlideDrawableTranscoder implements ResourceTranscoder
{
    private final GlideBitmapDrawableTranscoder glideBitmapDrawableTranscoder;
    
    public BitmapToGlideDrawableTranscoder(final Context context) {
        this(new GlideBitmapDrawableTranscoder(context));
    }
    
    public BitmapToGlideDrawableTranscoder(final GlideBitmapDrawableTranscoder glideBitmapDrawableTranscoder) {
        this.glideBitmapDrawableTranscoder = glideBitmapDrawableTranscoder;
    }
    
    public String getId() {
        return this.glideBitmapDrawableTranscoder.getId();
    }
    
    public Resource transcode(final Resource resource) {
        return this.glideBitmapDrawableTranscoder.transcode(resource);
    }
}
