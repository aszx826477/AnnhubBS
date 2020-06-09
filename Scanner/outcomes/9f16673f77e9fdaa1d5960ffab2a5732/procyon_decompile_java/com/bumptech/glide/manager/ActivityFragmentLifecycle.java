// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.manager;

import java.util.Iterator;
import java.util.Collection;
import com.bumptech.glide.util.Util;
import java.util.Map;
import java.util.Collections;
import java.util.WeakHashMap;
import java.util.Set;

class ActivityFragmentLifecycle implements Lifecycle
{
    private boolean isDestroyed;
    private boolean isStarted;
    private final Set lifecycleListeners;
    
    ActivityFragmentLifecycle() {
        this.lifecycleListeners = Collections.newSetFromMap(new WeakHashMap<Object, Boolean>());
    }
    
    public void addListener(final LifecycleListener lifecycleListener) {
        this.lifecycleListeners.add(lifecycleListener);
        if (this.isDestroyed) {
            lifecycleListener.onDestroy();
        }
        else if (this.isStarted) {
            lifecycleListener.onStart();
        }
        else {
            lifecycleListener.onStop();
        }
    }
    
    void onDestroy() {
        this.isDestroyed = true;
        final Iterator<LifecycleListener> iterator = Util.getSnapshot(this.lifecycleListeners).iterator();
        while (iterator.hasNext()) {
            iterator.next().onDestroy();
        }
    }
    
    void onStart() {
        this.isStarted = true;
        final Iterator<LifecycleListener> iterator = Util.getSnapshot(this.lifecycleListeners).iterator();
        while (iterator.hasNext()) {
            iterator.next().onStart();
        }
    }
    
    void onStop() {
        this.isStarted = false;
        final Iterator<LifecycleListener> iterator = Util.getSnapshot(this.lifecycleListeners).iterator();
        while (iterator.hasNext()) {
            iterator.next().onStop();
        }
    }
}
