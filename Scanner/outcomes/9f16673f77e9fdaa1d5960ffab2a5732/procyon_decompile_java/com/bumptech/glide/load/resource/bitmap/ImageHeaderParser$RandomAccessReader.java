// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import java.nio.ByteOrder;
import java.nio.ByteBuffer;

class ImageHeaderParser$RandomAccessReader
{
    private final ByteBuffer data;
    
    public ImageHeaderParser$RandomAccessReader(final byte[] array) {
        (this.data = ByteBuffer.wrap(array)).order(ByteOrder.BIG_ENDIAN);
    }
    
    public short getInt16(final int n) {
        return this.data.getShort(n);
    }
    
    public int getInt32(final int n) {
        return this.data.getInt(n);
    }
    
    public int length() {
        return this.data.array().length;
    }
    
    public void order(final ByteOrder byteOrder) {
        this.data.order(byteOrder);
    }
}
