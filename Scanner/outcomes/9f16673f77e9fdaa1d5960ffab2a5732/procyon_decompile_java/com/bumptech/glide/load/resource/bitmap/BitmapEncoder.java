// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.util.Util;
import android.util.Log;
import com.bumptech.glide.util.LogTime;
import java.io.OutputStream;
import com.bumptech.glide.load.engine.Resource;
import android.graphics.Bitmap;
import android.graphics.Bitmap$CompressFormat;
import com.bumptech.glide.load.ResourceEncoder;

public class BitmapEncoder implements ResourceEncoder
{
    private static final int DEFAULT_COMPRESSION_QUALITY = 90;
    private static final String TAG = "BitmapEncoder";
    private Bitmap$CompressFormat compressFormat;
    private int quality;
    
    public BitmapEncoder() {
        this(null, 90);
    }
    
    public BitmapEncoder(final Bitmap$CompressFormat compressFormat, final int quality) {
        this.compressFormat = compressFormat;
        this.quality = quality;
    }
    
    private Bitmap$CompressFormat getFormat(final Bitmap bitmap) {
        final Bitmap$CompressFormat compressFormat = this.compressFormat;
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap$CompressFormat.PNG;
        }
        return Bitmap$CompressFormat.JPEG;
    }
    
    public boolean encode(final Resource resource, final OutputStream outputStream) {
        final Bitmap bitmap = (Bitmap)resource.get();
        final long logTime = LogTime.getLogTime();
        final Bitmap$CompressFormat format = this.getFormat(bitmap);
        bitmap.compress(format, this.quality, outputStream);
        if (Log.isLoggable("BitmapEncoder", 2)) {
            final String s = "BitmapEncoder";
            final StringBuilder sb = new StringBuilder();
            sb.append("Compressed with type: ");
            sb.append(format);
            sb.append(" of size ");
            sb.append(Util.getBitmapByteSize(bitmap));
            sb.append(" in ");
            sb.append(LogTime.getElapsedMillis(logTime));
            Log.v(s, sb.toString());
        }
        return true;
    }
    
    public String getId() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }
}
