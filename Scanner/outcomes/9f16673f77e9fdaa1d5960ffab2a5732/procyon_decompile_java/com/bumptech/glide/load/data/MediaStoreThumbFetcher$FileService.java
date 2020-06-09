// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.data;

import java.io.File;

class MediaStoreThumbFetcher$FileService
{
    public boolean exists(final File file) {
        return file.exists();
    }
    
    public File get(final String s) {
        return new File(s);
    }
    
    public long length(final File file) {
        return file.length();
    }
}
