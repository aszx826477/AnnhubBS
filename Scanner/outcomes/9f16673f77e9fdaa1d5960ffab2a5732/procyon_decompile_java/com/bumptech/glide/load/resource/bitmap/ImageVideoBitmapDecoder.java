// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.IOException;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.ResourceDecoder;

public class ImageVideoBitmapDecoder implements ResourceDecoder
{
    private static final String TAG = "ImageVideoDecoder";
    private final ResourceDecoder fileDescriptorDecoder;
    private final ResourceDecoder streamDecoder;
    
    public ImageVideoBitmapDecoder(final ResourceDecoder streamDecoder, final ResourceDecoder fileDescriptorDecoder) {
        this.streamDecoder = streamDecoder;
        this.fileDescriptorDecoder = fileDescriptorDecoder;
    }
    
    public Resource decode(final ImageVideoWrapper imageVideoWrapper, final int n, final int n2) {
        Resource resource = null;
        final InputStream stream = imageVideoWrapper.getStream();
        if (stream != null) {
            try {
                resource = this.streamDecoder.decode(stream, n, n2);
            }
            catch (IOException ex) {
                if (Log.isLoggable("ImageVideoDecoder", 2)) {
                    Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", (Throwable)ex);
                }
            }
        }
        if (resource == null) {
            final ParcelFileDescriptor fileDescriptor = imageVideoWrapper.getFileDescriptor();
            if (fileDescriptor != null) {
                resource = this.fileDescriptorDecoder.decode(fileDescriptor, n, n2);
            }
        }
        return resource;
    }
    
    public String getId() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
