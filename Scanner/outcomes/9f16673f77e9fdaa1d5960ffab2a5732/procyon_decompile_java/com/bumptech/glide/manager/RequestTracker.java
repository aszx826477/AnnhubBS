// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.manager;

import java.util.Iterator;
import java.util.Collection;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.request.Request;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;
import java.util.WeakHashMap;
import java.util.Set;
import java.util.List;

public class RequestTracker
{
    private boolean isPaused;
    private final List pendingRequests;
    private final Set requests;
    
    public RequestTracker() {
        this.requests = Collections.newSetFromMap(new WeakHashMap<Object, Boolean>());
        this.pendingRequests = new ArrayList();
    }
    
    void addRequest(final Request request) {
        this.requests.add(request);
    }
    
    public void clearRequests() {
        final Iterator<Request> iterator = Util.getSnapshot(this.requests).iterator();
        while (iterator.hasNext()) {
            iterator.next().clear();
        }
        this.pendingRequests.clear();
    }
    
    public boolean isPaused() {
        return this.isPaused;
    }
    
    public void pauseRequests() {
        this.isPaused = true;
        for (final Request request : Util.getSnapshot(this.requests)) {
            if (request.isRunning()) {
                request.pause();
                this.pendingRequests.add(request);
            }
        }
    }
    
    public void removeRequest(final Request request) {
        this.requests.remove(request);
        this.pendingRequests.remove(request);
    }
    
    public void restartRequests() {
        for (final Request request : Util.getSnapshot(this.requests)) {
            if (!request.isComplete() && !request.isCancelled()) {
                request.pause();
                if (!this.isPaused) {
                    request.begin();
                }
                else {
                    this.pendingRequests.add(request);
                }
            }
        }
    }
    
    public void resumeRequests() {
        this.isPaused = false;
        for (final Request request : Util.getSnapshot(this.requests)) {
            if (!request.isComplete() && !request.isCancelled() && !request.isRunning()) {
                request.begin();
            }
        }
        this.pendingRequests.clear();
    }
    
    public void runRequest(final Request request) {
        this.requests.add(request);
        if (!this.isPaused) {
            request.begin();
        }
        else {
            this.pendingRequests.add(request);
        }
    }
}
