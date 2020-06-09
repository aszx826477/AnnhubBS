// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.concurrent.ExecutorService;

class Engine$EngineJobFactory
{
    private final ExecutorService diskCacheService;
    private final EngineJobListener listener;
    private final ExecutorService sourceService;
    
    public Engine$EngineJobFactory(final ExecutorService diskCacheService, final ExecutorService sourceService, final EngineJobListener listener) {
        this.diskCacheService = diskCacheService;
        this.sourceService = sourceService;
        this.listener = listener;
    }
    
    public EngineJob build(final Key key, final boolean b) {
        return new EngineJob(key, this.diskCacheService, this.sourceService, b, this.listener);
    }
}
