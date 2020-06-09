// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import java.io.InputStream;

class ImageHeaderParser$StreamReader
{
    private final InputStream is;
    
    public ImageHeaderParser$StreamReader(final InputStream is) {
        this.is = is;
    }
    
    public int getByte() {
        return this.is.read();
    }
    
    public int getUInt16() {
        return (this.is.read() << 8 & 0xFF00) | (this.is.read() & 0xFF);
    }
    
    public short getUInt8() {
        return (short)(this.is.read() & 0xFF);
    }
    
    public int read(final byte[] array) {
        int i;
        int read;
        for (i = array.length; i > 0; i -= read) {
            read = this.is.read(array, array.length - i, i);
            if (read == -1) {
                break;
            }
        }
        return array.length - i;
    }
    
    public long skip(final long n) {
        final long n2 = 0L;
        if (n < n2) {
            return n2;
        }
        long n3 = n;
        while (n3 > n2) {
            final long skip = this.is.skip(n3);
            if (skip > n2) {
                n3 -= skip;
            }
            else {
                if (this.is.read() == -1) {
                    break;
                }
                --n3;
            }
        }
        return n - n3;
    }
}
