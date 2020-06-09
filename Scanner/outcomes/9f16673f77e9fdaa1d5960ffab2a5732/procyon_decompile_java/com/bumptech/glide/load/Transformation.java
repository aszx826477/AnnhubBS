// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;

public interface Transformation
{
    String getId();
    
    Resource transform(final Resource p0, final int p1, final int p2);
}
