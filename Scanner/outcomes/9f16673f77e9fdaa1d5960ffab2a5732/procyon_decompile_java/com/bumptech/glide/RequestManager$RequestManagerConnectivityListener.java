// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.ConnectivityMonitor$ConnectivityListener;

class RequestManager$RequestManagerConnectivityListener implements ConnectivityMonitor$ConnectivityListener
{
    private final RequestTracker requestTracker;
    
    public RequestManager$RequestManagerConnectivityListener(final RequestTracker requestTracker) {
        this.requestTracker = requestTracker;
    }
    
    public void onConnectivityChanged(final boolean b) {
        if (b) {
            this.requestTracker.restartRequests();
        }
    }
}
