// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$ImageType;
import java.io.InputStream;

class GifBitmapWrapperResourceDecoder$ImageTypeParser
{
    public ImageHeaderParser$ImageType parse(final InputStream inputStream) {
        return new ImageHeaderParser(inputStream).getType();
    }
}
