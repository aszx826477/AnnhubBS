// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.util.Util;
import java.util.Queue;

class GifResourceDecoder$GifHeaderParserPool
{
    private final Queue pool;
    
    GifResourceDecoder$GifHeaderParserPool() {
        this.pool = Util.createQueue(0);
    }
    
    public GifHeaderParser obtain(final byte[] data) {
        synchronized (this) {
            GifHeaderParser gifHeaderParser = this.pool.poll();
            if (gifHeaderParser == null) {
                gifHeaderParser = new GifHeaderParser();
            }
            return gifHeaderParser.setData(data);
        }
    }
    
    public void release(final GifHeaderParser gifHeaderParser) {
        synchronized (this) {
            gifHeaderParser.clear();
            this.pool.offer(gifHeaderParser);
        }
    }
}
