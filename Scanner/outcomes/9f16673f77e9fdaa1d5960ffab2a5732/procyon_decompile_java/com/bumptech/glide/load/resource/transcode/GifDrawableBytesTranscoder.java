// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.resource.bytes.BytesResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.engine.Resource;

public class GifDrawableBytesTranscoder implements ResourceTranscoder
{
    public String getId() {
        return "GifDrawableBytesTranscoder.com.bumptech.glide.load.resource.transcode";
    }
    
    public Resource transcode(final Resource resource) {
        return new BytesResource(((GifDrawable)resource.get()).getData());
    }
}
