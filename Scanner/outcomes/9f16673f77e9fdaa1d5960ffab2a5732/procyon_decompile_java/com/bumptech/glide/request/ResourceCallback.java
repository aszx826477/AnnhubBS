// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request;

import com.bumptech.glide.load.engine.Resource;

public interface ResourceCallback
{
    void onException(final Exception p0);
    
    void onResourceReady(final Resource p0);
}
