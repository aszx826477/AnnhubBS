// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.engine.Resource;
import java.io.File;
import com.bumptech.glide.load.ResourceDecoder;

public class FileDecoder implements ResourceDecoder
{
    public Resource decode(final File file, final int n, final int n2) {
        return new FileResource(file);
    }
    
    public String getId() {
        return "";
    }
}
