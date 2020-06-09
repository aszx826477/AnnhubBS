// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.engine.Resource;

public interface ResourceTranscoder
{
    String getId();
    
    Resource transcode(final Resource p0);
}
