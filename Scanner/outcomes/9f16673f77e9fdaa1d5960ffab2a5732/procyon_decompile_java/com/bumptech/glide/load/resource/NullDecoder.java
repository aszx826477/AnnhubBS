// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.ResourceDecoder;

public class NullDecoder implements ResourceDecoder
{
    private static final NullDecoder NULL_DECODER;
    
    static {
        NULL_DECODER = new NullDecoder();
    }
    
    public static NullDecoder get() {
        return NullDecoder.NULL_DECODER;
    }
    
    public Resource decode(final Object o, final int n, final int n2) {
        return null;
    }
    
    public String getId() {
        return "";
    }
}
