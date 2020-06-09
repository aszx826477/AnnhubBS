// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource;

import java.io.OutputStream;
import com.bumptech.glide.load.Encoder;

public class NullEncoder implements Encoder
{
    private static final NullEncoder NULL_ENCODER;
    
    static {
        NULL_ENCODER = new NullEncoder();
    }
    
    public static Encoder get() {
        return NullEncoder.NULL_ENCODER;
    }
    
    public boolean encode(final Object o, final OutputStream outputStream) {
        return false;
    }
    
    public String getId() {
        return "";
    }
}
