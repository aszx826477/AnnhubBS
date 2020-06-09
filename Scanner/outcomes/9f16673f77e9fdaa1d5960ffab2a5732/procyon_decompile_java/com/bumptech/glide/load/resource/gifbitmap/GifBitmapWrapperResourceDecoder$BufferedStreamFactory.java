// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;

class GifBitmapWrapperResourceDecoder$BufferedStreamFactory
{
    public InputStream build(final InputStream inputStream, final byte[] array) {
        return new RecyclableBufferedInputStream(inputStream, array);
    }
}
