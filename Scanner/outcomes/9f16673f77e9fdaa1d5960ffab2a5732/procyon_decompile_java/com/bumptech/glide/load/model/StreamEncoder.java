// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import java.io.IOException;
import android.util.Log;
import com.bumptech.glide.util.ByteArrayPool;
import java.io.OutputStream;
import java.io.InputStream;
import com.bumptech.glide.load.Encoder;

public class StreamEncoder implements Encoder
{
    private static final String TAG = "StreamEncoder";
    
    public boolean encode(final InputStream inputStream, final OutputStream outputStream) {
        final byte[] bytes = ByteArrayPool.get().getBytes();
        while (true) {
            try {
                try {
                    final int read = inputStream.read(bytes);
                    if (read != -1) {
                        outputStream.write(bytes, 0, read);
                        continue;
                    }
                    ByteArrayPool.get().releaseBytes(bytes);
                    return true;
                }
                finally {}
            }
            catch (IOException ex) {
                if (Log.isLoggable("StreamEncoder", 3)) {
                    Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", (Throwable)ex);
                }
                ByteArrayPool.get().releaseBytes(bytes);
                return false;
            }
            break;
        }
        ByteArrayPool.get().releaseBytes(bytes);
    }
    
    public String getId() {
        return "";
    }
}
