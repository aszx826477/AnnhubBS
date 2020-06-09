// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource;

import java.io.OutputStream;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.ResourceEncoder;

public class NullResourceEncoder implements ResourceEncoder
{
    private static final NullResourceEncoder NULL_ENCODER;
    
    static {
        NULL_ENCODER = new NullResourceEncoder();
    }
    
    public static NullResourceEncoder get() {
        return NullResourceEncoder.NULL_ENCODER;
    }
    
    public boolean encode(final Resource resource, final OutputStream outputStream) {
        return false;
    }
    
    public String getId() {
        return "";
    }
}
