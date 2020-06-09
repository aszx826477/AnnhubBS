// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.util;

import java.io.InputStream;
import java.io.FilterInputStream;

public class MarkEnforcingInputStream extends FilterInputStream
{
    private static final int END_OF_STREAM = 255;
    private static final int UNSET = Integer.MIN_VALUE;
    private int availableBytes;
    
    public MarkEnforcingInputStream(final InputStream inputStream) {
        super(inputStream);
        this.availableBytes = -1 << -1;
    }
    
    private long getBytesToRead(final long n) {
        final int availableBytes = this.availableBytes;
        if (availableBytes == 0) {
            return -1;
        }
        if (availableBytes != -1 << -1 && n > availableBytes) {
            return availableBytes;
        }
        return n;
    }
    
    private void updateAvailableBytesAfterRead(final long n) {
        final int availableBytes = this.availableBytes;
        if (availableBytes != -1 << -1 && n != -1) {
            this.availableBytes = (int)(availableBytes - n);
        }
    }
    
    public int available() {
        final int availableBytes = this.availableBytes;
        int n;
        if (availableBytes == -1 << -1) {
            n = super.available();
        }
        else {
            n = Math.min(availableBytes, super.available());
        }
        return n;
    }
    
    public void mark(final int availableBytes) {
        super.mark(availableBytes);
        this.availableBytes = availableBytes;
    }
    
    public int read() {
        final long n = 1L;
        if (this.getBytesToRead(n) == -1) {
            return -1;
        }
        final int read = super.read();
        this.updateAvailableBytesAfterRead(n);
        return read;
    }
    
    public int read(final byte[] array, final int n, final int n2) {
        final int n3 = (int)this.getBytesToRead(n2);
        final int n4 = -1;
        if (n3 == n4) {
            return n4;
        }
        final int read = super.read(array, n, n3);
        this.updateAvailableBytesAfterRead(read);
        return read;
    }
    
    public void reset() {
        super.reset();
        this.availableBytes = -1 << -1;
    }
    
    public long skip(final long n) {
        final long bytesToRead = this.getBytesToRead(n);
        final long n2 = -1;
        if (bytesToRead == n2) {
            return n2;
        }
        final long skip = super.skip(bytesToRead);
        this.updateAvailableBytesAfterRead(skip);
        return skip;
    }
}
