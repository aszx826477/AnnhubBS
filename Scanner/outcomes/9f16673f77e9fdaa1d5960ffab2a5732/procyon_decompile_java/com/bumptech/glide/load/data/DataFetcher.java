// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;

public interface DataFetcher
{
    void cancel();
    
    void cleanup();
    
    String getId();
    
    Object loadData(final Priority p0);
}
