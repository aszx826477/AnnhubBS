// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.resource.bytes.BytesResource;
import java.io.OutputStream;
import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import com.bumptech.glide.load.engine.Resource;
import android.graphics.Bitmap$CompressFormat;

public class BitmapBytesTranscoder implements ResourceTranscoder
{
    private final Bitmap$CompressFormat compressFormat;
    private final int quality;
    
    public BitmapBytesTranscoder() {
        this(Bitmap$CompressFormat.JPEG, 100);
    }
    
    public BitmapBytesTranscoder(final Bitmap$CompressFormat compressFormat, final int quality) {
        this.compressFormat = compressFormat;
        this.quality = quality;
    }
    
    public String getId() {
        return "BitmapBytesTranscoder.com.bumptech.glide.load.resource.transcode";
    }
    
    public Resource transcode(final Resource resource) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap)resource.get()).compress(this.compressFormat, this.quality, (OutputStream)byteArrayOutputStream);
        resource.recycle();
        return new BytesResource(byteArrayOutputStream.toByteArray());
    }
}
