// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider;
import com.bumptech.glide.util.Util;
import java.util.Queue;

class GifResourceDecoder$GifDecoderPool
{
    private final Queue pool;
    
    GifResourceDecoder$GifDecoderPool() {
        this.pool = Util.createQueue(0);
    }
    
    public GifDecoder obtain(final GifDecoder$BitmapProvider gifDecoder$BitmapProvider) {
        synchronized (this) {
            GifDecoder gifDecoder = this.pool.poll();
            if (gifDecoder == null) {
                gifDecoder = new GifDecoder(gifDecoder$BitmapProvider);
            }
            return gifDecoder;
        }
    }
    
    public void release(final GifDecoder gifDecoder) {
        synchronized (this) {
            gifDecoder.clear();
            this.pool.offer(gifDecoder);
        }
    }
}
