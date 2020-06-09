// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import java.lang.ref.ReferenceQueue;
import com.bumptech.glide.load.Key;
import java.lang.ref.WeakReference;

class Engine$ResourceWeakReference extends WeakReference
{
    private final Key key;
    
    public Engine$ResourceWeakReference(final Key key, final EngineResource engineResource, final ReferenceQueue referenceQueue) {
        super(engineResource, referenceQueue);
        this.key = key;
    }
}
