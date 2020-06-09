// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.lang.ref.WeakReference;
import java.lang.ref.ReferenceQueue;
import java.util.Map;
import android.os.MessageQueue$IdleHandler;

class Engine$RefQueueIdleHandler implements MessageQueue$IdleHandler
{
    private final Map activeResources;
    private final ReferenceQueue queue;
    
    public Engine$RefQueueIdleHandler(final Map activeResources, final ReferenceQueue queue) {
        this.activeResources = activeResources;
        this.queue = queue;
    }
    
    public boolean queueIdle() {
        final Engine$ResourceWeakReference engine$ResourceWeakReference = (Engine$ResourceWeakReference)this.queue.poll();
        if (engine$ResourceWeakReference != null) {
            this.activeResources.remove(engine$ResourceWeakReference.key);
        }
        return true;
    }
}
