// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gifbitmap;

import java.io.OutputStream;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.ResourceEncoder;

public class GifBitmapWrapperResourceEncoder implements ResourceEncoder
{
    private final ResourceEncoder bitmapEncoder;
    private final ResourceEncoder gifEncoder;
    private String id;
    
    public GifBitmapWrapperResourceEncoder(final ResourceEncoder bitmapEncoder, final ResourceEncoder gifEncoder) {
        this.bitmapEncoder = bitmapEncoder;
        this.gifEncoder = gifEncoder;
    }
    
    public boolean encode(final Resource resource, final OutputStream outputStream) {
        final GifBitmapWrapper gifBitmapWrapper = (GifBitmapWrapper)resource.get();
        final Resource bitmapResource = gifBitmapWrapper.getBitmapResource();
        if (bitmapResource != null) {
            return this.bitmapEncoder.encode(bitmapResource, outputStream);
        }
        return this.gifEncoder.encode(gifBitmapWrapper.getGifResource(), outputStream);
    }
    
    public String getId() {
        if (this.id == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.bitmapEncoder.getId());
            sb.append(this.gifEncoder.getId());
            this.id = sb.toString();
        }
        return this.id;
    }
}
