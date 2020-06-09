// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request;

public class ThumbnailRequestCoordinator implements RequestCoordinator, Request
{
    private RequestCoordinator coordinator;
    private Request full;
    private Request thumb;
    
    public ThumbnailRequestCoordinator() {
        this(null);
    }
    
    public ThumbnailRequestCoordinator(final RequestCoordinator coordinator) {
        this.coordinator = coordinator;
    }
    
    private boolean parentCanNotifyStatusChanged() {
        final RequestCoordinator coordinator = this.coordinator;
        return coordinator == null || coordinator.canNotifyStatusChanged(this);
    }
    
    private boolean parentCanSetImage() {
        final RequestCoordinator coordinator = this.coordinator;
        return coordinator == null || coordinator.canSetImage(this);
    }
    
    private boolean parentIsAnyResourceSet() {
        final RequestCoordinator coordinator = this.coordinator;
        return coordinator != null && coordinator.isAnyResourceSet();
    }
    
    public void begin() {
        if (!this.thumb.isRunning()) {
            this.thumb.begin();
        }
        if (!this.full.isRunning()) {
            this.full.begin();
        }
    }
    
    public boolean canNotifyStatusChanged(final Request request) {
        return this.parentCanNotifyStatusChanged() && request.equals(this.full) && !this.isAnyResourceSet();
    }
    
    public boolean canSetImage(final Request request) {
        return this.parentCanSetImage() && (request.equals(this.full) || !this.full.isResourceSet());
    }
    
    public void clear() {
        this.thumb.clear();
        this.full.clear();
    }
    
    public boolean isAnyResourceSet() {
        return this.parentIsAnyResourceSet() || this.isResourceSet();
    }
    
    public boolean isCancelled() {
        return this.full.isCancelled();
    }
    
    public boolean isComplete() {
        return this.full.isComplete() || this.thumb.isComplete();
    }
    
    public boolean isFailed() {
        return this.full.isFailed();
    }
    
    public boolean isPaused() {
        return this.full.isPaused();
    }
    
    public boolean isResourceSet() {
        return this.full.isResourceSet() || this.thumb.isResourceSet();
    }
    
    public boolean isRunning() {
        return this.full.isRunning();
    }
    
    public void onRequestSuccess(final Request request) {
        if (request.equals(this.thumb)) {
            return;
        }
        final RequestCoordinator coordinator = this.coordinator;
        if (coordinator != null) {
            coordinator.onRequestSuccess(this);
        }
        if (!this.thumb.isComplete()) {
            this.thumb.clear();
        }
    }
    
    public void pause() {
        this.full.pause();
        this.thumb.pause();
    }
    
    public void recycle() {
        this.full.recycle();
        this.thumb.recycle();
    }
    
    public void setRequests(final Request full, final Request thumb) {
        this.full = full;
        this.thumb = thumb;
    }
}
