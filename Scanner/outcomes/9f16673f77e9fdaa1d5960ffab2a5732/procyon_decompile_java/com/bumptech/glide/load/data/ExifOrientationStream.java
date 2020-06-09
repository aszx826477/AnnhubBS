// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.data;

import java.io.InputStream;
import java.io.FilterInputStream;

public class ExifOrientationStream extends FilterInputStream
{
    private static final byte[] EXIF_SEGMENT;
    private static final int ORIENTATION_POSITION = 0;
    private static final int SEGMENT_LENGTH = 0;
    private static final int SEGMENT_START_POSITION = 2;
    private final byte orientation;
    private int position;
    
    static {
        final byte[] array;
        final byte[] exif_SEGMENT = array = new byte[29];
        array[0] = -1;
        array[1] = -31;
        array[2] = 0;
        array[3] = 28;
        array[4] = 69;
        array[5] = 120;
        array[6] = 105;
        array[7] = 102;
        array[9] = (array[8] = 0);
        array[11] = (array[10] = 77);
        array[12] = 0;
        array[14] = (array[13] = 0);
        array[16] = (array[15] = 0);
        array[17] = 8;
        array[18] = 0;
        array[20] = (array[19] = 1);
        array[21] = 18;
        array[22] = 0;
        array[23] = 2;
        array[24] = 0;
        array[26] = (array[25] = 0);
        array[27] = 1;
        array[28] = 0;
        EXIF_SEGMENT = exif_SEGMENT;
    }
    
    public ExifOrientationStream(final InputStream inputStream, final int n) {
        super(inputStream);
        if (n >= -1 && n <= 8) {
            this.orientation = (byte)n;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot add invalid orientation: ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void mark(final int n) {
        throw new UnsupportedOperationException();
    }
    
    public boolean markSupported() {
        return false;
    }
    
    public int read() {
        final int position = this.position;
        final int n = 2;
        int n2 = 0;
        Label_0063: {
            if (position >= n) {
                final int orientation_POSITION = ExifOrientationStream.ORIENTATION_POSITION;
                if (position <= orientation_POSITION) {
                    if (position == orientation_POSITION) {
                        n2 = this.orientation;
                        break Label_0063;
                    }
                    n2 = (ExifOrientationStream.EXIF_SEGMENT[position - n] & 0xFF);
                    break Label_0063;
                }
            }
            n2 = super.read();
        }
        if (n2 != -1) {
            ++this.position;
        }
        return n2;
    }
    
    public int read(final byte[] array, final int n, final int n2) {
        final int position = this.position;
        final int orientation_POSITION = ExifOrientationStream.ORIENTATION_POSITION;
        int n3;
        if (position > orientation_POSITION) {
            n3 = super.read(array, n, n2);
        }
        else if (position == orientation_POSITION) {
            array[n] = this.orientation;
            n3 = 1;
        }
        else {
            final int n4 = 2;
            if (position < n4) {
                n3 = super.read(array, n, n4 - position);
            }
            else {
                n3 = Math.min(orientation_POSITION - position, n2);
                System.arraycopy(ExifOrientationStream.EXIF_SEGMENT, this.position - n4, array, n, n3);
            }
        }
        if (n3 > 0) {
            this.position += n3;
        }
        return n3;
    }
    
    public void reset() {
        throw new UnsupportedOperationException();
    }
    
    public long skip(final long n) {
        final long skip = super.skip(n);
        if (skip > 0L) {
            this.position += (int)skip;
        }
        return skip;
    }
}
