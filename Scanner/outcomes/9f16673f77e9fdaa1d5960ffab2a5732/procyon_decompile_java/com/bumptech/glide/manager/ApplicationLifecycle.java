// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.manager;

class ApplicationLifecycle implements Lifecycle
{
    public void addListener(final LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }
}
