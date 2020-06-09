// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.engine.Resource;
import java.io.InputStream;
import com.bumptech.glide.load.ResourceDecoder;

class StreamFileDataLoadProvider$ErrorSourceDecoder implements ResourceDecoder
{
    public Resource decode(final InputStream inputStream, final int n, final int n2) {
        throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
    }
    
    public String getId() {
        return "";
    }
}
