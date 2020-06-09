// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import java.io.File;
import java.io.IOException;
import android.util.Log;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;

class CacheLoader
{
    private static final String TAG = "CacheLoader";
    private final DiskCache diskCache;
    
    public CacheLoader(final DiskCache diskCache) {
        this.diskCache = diskCache;
    }
    
    public Resource load(final Key key, final ResourceDecoder resourceDecoder, final int n, final int n2) {
        final File value = this.diskCache.get(key);
        if (value == null) {
            return null;
        }
        Resource decode = null;
        final int n3 = 3;
        final File file = value;
        try {
            decode = resourceDecoder.decode(file, n, n2);
        }
        catch (IOException ex) {
            if (Log.isLoggable("CacheLoader", n3)) {
                Log.d("CacheLoader", "Exception decoding image from cache", (Throwable)ex);
            }
        }
        if (decode == null) {
            if (Log.isLoggable("CacheLoader", n3)) {
                Log.d("CacheLoader", "Failed to decode image from cache or not present in cache");
            }
            this.diskCache.delete(key);
        }
        return decode;
    }
}
