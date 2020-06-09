// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import com.bumptech.glide.util.Util;
import java.util.Queue;

final class ModelCache$ModelKey
{
    private static final Queue KEY_QUEUE;
    private int height;
    private Object model;
    private int width;
    
    static {
        KEY_QUEUE = Util.createQueue(0);
    }
    
    static ModelCache$ModelKey get(final Object o, final int n, final int n2) {
        ModelCache$ModelKey modelCache$ModelKey = ModelCache$ModelKey.KEY_QUEUE.poll();
        if (modelCache$ModelKey == null) {
            modelCache$ModelKey = new ModelCache$ModelKey();
        }
        modelCache$ModelKey.init(o, n, n2);
        return modelCache$ModelKey;
    }
    
    private void init(final Object model, final int width, final int height) {
        this.model = model;
        this.width = width;
        this.height = height;
    }
    
    public boolean equals(final Object o) {
        final boolean b = o instanceof ModelCache$ModelKey;
        boolean b2 = false;
        if (b) {
            final ModelCache$ModelKey modelCache$ModelKey = (ModelCache$ModelKey)o;
            if (this.width == modelCache$ModelKey.width && this.height == modelCache$ModelKey.height && this.model.equals(modelCache$ModelKey.model)) {
                b2 = true;
            }
            return b2;
        }
        return false;
    }
    
    public int hashCode() {
        return (this.height * 31 + this.width) * 31 + this.model.hashCode();
    }
    
    public void release() {
        ModelCache$ModelKey.KEY_QUEUE.offer(this);
    }
}
