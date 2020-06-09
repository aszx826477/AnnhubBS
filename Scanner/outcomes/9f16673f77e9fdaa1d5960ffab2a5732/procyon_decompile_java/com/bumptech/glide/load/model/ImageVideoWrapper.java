// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import java.io.InputStream;
import android.os.ParcelFileDescriptor;

public class ImageVideoWrapper
{
    private final ParcelFileDescriptor fileDescriptor;
    private final InputStream streamData;
    
    public ImageVideoWrapper(final InputStream streamData, final ParcelFileDescriptor fileDescriptor) {
        this.streamData = streamData;
        this.fileDescriptor = fileDescriptor;
    }
    
    public ParcelFileDescriptor getFileDescriptor() {
        return this.fileDescriptor;
    }
    
    public InputStream getStream() {
        return this.streamData;
    }
}
