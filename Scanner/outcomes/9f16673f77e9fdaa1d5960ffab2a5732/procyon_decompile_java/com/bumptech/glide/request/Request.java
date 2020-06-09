// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request;

public interface Request
{
    void begin();
    
    void clear();
    
    boolean isCancelled();
    
    boolean isComplete();
    
    boolean isFailed();
    
    boolean isPaused();
    
    boolean isResourceSet();
    
    boolean isRunning();
    
    void pause();
    
    void recycle();
}
