// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.request.ResourceCallback;

public class Engine$LoadStatus
{
    private final ResourceCallback cb;
    private final EngineJob engineJob;
    
    public Engine$LoadStatus(final ResourceCallback cb, final EngineJob engineJob) {
        this.cb = cb;
        this.engineJob = engineJob;
    }
    
    public void cancel() {
        this.engineJob.removeCallback(this.cb);
    }
}
