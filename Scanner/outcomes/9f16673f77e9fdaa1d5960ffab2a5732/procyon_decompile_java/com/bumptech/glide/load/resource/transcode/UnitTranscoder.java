// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.engine.Resource;

public class UnitTranscoder implements ResourceTranscoder
{
    private static final UnitTranscoder UNIT_TRANSCODER;
    
    static {
        UNIT_TRANSCODER = new UnitTranscoder();
    }
    
    public static ResourceTranscoder get() {
        return UnitTranscoder.UNIT_TRANSCODER;
    }
    
    public String getId() {
        return "";
    }
    
    public Resource transcode(final Resource resource) {
        return resource;
    }
}
