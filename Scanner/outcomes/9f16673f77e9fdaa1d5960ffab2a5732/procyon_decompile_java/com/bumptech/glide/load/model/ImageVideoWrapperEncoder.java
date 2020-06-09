// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import java.io.OutputStream;
import com.bumptech.glide.load.Encoder;

public class ImageVideoWrapperEncoder implements Encoder
{
    private final Encoder fileDescriptorEncoder;
    private String id;
    private final Encoder streamEncoder;
    
    public ImageVideoWrapperEncoder(final Encoder streamEncoder, final Encoder fileDescriptorEncoder) {
        this.streamEncoder = streamEncoder;
        this.fileDescriptorEncoder = fileDescriptorEncoder;
    }
    
    public boolean encode(final ImageVideoWrapper imageVideoWrapper, final OutputStream outputStream) {
        if (imageVideoWrapper.getStream() != null) {
            return this.streamEncoder.encode(imageVideoWrapper.getStream(), outputStream);
        }
        return this.fileDescriptorEncoder.encode(imageVideoWrapper.getFileDescriptor(), outputStream);
    }
    
    public String getId() {
        if (this.id == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.streamEncoder.getId());
            sb.append(this.fileDescriptorEncoder.getId());
            this.id = sb.toString();
        }
        return this.id;
    }
}
