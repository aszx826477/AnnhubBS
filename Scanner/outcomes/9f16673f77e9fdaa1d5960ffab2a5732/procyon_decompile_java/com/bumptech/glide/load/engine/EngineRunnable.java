// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.executor.Prioritized;

class EngineRunnable implements Runnable, Prioritized
{
    private static final String TAG = "EngineRunnable";
    private final DecodeJob decodeJob;
    private volatile boolean isCancelled;
    private final EngineRunnable$EngineRunnableManager manager;
    private final Priority priority;
    private EngineRunnable$Stage stage;
    
    public EngineRunnable(final EngineRunnable$EngineRunnableManager manager, final DecodeJob decodeJob, final Priority priority) {
        this.manager = manager;
        this.decodeJob = decodeJob;
        this.stage = EngineRunnable$Stage.CACHE;
        this.priority = priority;
    }
    
    private Resource decode() {
        if (this.isDecodingFromCache()) {
            return this.decodeFromCache();
        }
        return this.decodeFromSource();
    }
    
    private Resource decodeFromCache() {
        Resource resource = null;
        try {
            final DecodeJob decodeJob = this.decodeJob;
            try {
                resource = decodeJob.decodeResultFromCache();
            }
            catch (Exception ex) {
                if (Log.isLoggable("EngineRunnable", 3)) {
                    final String s = "EngineRunnable";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Exception decoding result from cache: ");
                    sb.append(ex);
                    Log.d(s, sb.toString());
                }
            }
        }
        catch (Exception ex2) {}
        if (resource == null) {
            resource = this.decodeJob.decodeSourceFromCache();
        }
        return resource;
    }
    
    private Resource decodeFromSource() {
        return this.decodeJob.decodeFromSource();
    }
    
    private boolean isDecodingFromCache() {
        return this.stage == EngineRunnable$Stage.CACHE;
    }
    
    private void onLoadComplete(final Resource resource) {
        this.manager.onResourceReady(resource);
    }
    
    private void onLoadFailed(final Exception ex) {
        if (this.isDecodingFromCache()) {
            this.stage = EngineRunnable$Stage.SOURCE;
            this.manager.submitForSource(this);
        }
        else {
            this.manager.onException(ex);
        }
    }
    
    public void cancel() {
        this.isCancelled = true;
        this.decodeJob.cancel();
    }
    
    public int getPriority() {
        return this.priority.ordinal();
    }
    
    public void run() {
        if (this.isCancelled) {
            return;
        }
        Exception ex = null;
        Resource decode = null;
        try {
            decode = this.decode();
        }
        catch (Exception ex2) {
            if (Log.isLoggable("EngineRunnable", 2)) {
                Log.v("EngineRunnable", "Exception decoding", (Throwable)ex2);
            }
            ex = ex2;
        }
        if (this.isCancelled) {
            if (decode != null) {
                decode.recycle();
            }
            return;
        }
        if (decode == null) {
            this.onLoadFailed(ex);
        }
        else {
            this.onLoadComplete(decode);
        }
    }
}
