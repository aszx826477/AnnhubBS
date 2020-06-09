// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gifbitmap;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.engine.Resource;
import java.io.InputStream;
import com.bumptech.glide.load.ResourceDecoder;

public class GifBitmapWrapperStreamResourceDecoder implements ResourceDecoder
{
    private final ResourceDecoder gifBitmapDecoder;
    
    public GifBitmapWrapperStreamResourceDecoder(final ResourceDecoder gifBitmapDecoder) {
        this.gifBitmapDecoder = gifBitmapDecoder;
    }
    
    public Resource decode(final InputStream inputStream, final int n, final int n2) {
        return this.gifBitmapDecoder.decode(new ImageVideoWrapper(inputStream, null), n, n2);
    }
    
    public String getId() {
        return this.gifBitmapDecoder.getId();
    }
}
