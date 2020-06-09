// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.Resource;

public class SimpleResource implements Resource
{
    protected final Object data;
    
    public SimpleResource(final Object data) {
        if (data != null) {
            this.data = data;
            return;
        }
        throw new NullPointerException("Data must not be null");
    }
    
    public final Object get() {
        return this.data;
    }
    
    public final int getSize() {
        return 1;
    }
    
    public void recycle() {
    }
}
