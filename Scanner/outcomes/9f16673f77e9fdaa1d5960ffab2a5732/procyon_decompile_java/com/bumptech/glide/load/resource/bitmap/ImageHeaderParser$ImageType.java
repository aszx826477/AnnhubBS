// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

public enum ImageHeaderParser$ImageType
{
    GIF("GIF", 0, (boolean)(n != 0)), 
    JPEG("JPEG", n, false), 
    PNG("PNG", n3, false), 
    PNG_A("PNG_A", n2, (boolean)(n != 0)), 
    UNKNOWN("UNKNOWN", n4, false);
    
    private final boolean hasAlpha;
    
    static {
        final int n = 1;
        final int n2 = 2;
        final int n3 = 3;
        final int n4 = 4;
        final ImageHeaderParser$ImageType[] $values = new ImageHeaderParser$ImageType[5];
        $values[0] = ImageHeaderParser$ImageType.GIF;
        $values[n] = ImageHeaderParser$ImageType.JPEG;
        $values[n2] = ImageHeaderParser$ImageType.PNG_A;
        $values[n3] = ImageHeaderParser$ImageType.PNG;
        $values[n4] = ImageHeaderParser$ImageType.UNKNOWN;
        $VALUES = $values;
    }
    
    private ImageHeaderParser$ImageType(final String s, final int n, final boolean hasAlpha) {
        this.hasAlpha = hasAlpha;
    }
    
    public boolean hasAlpha() {
        return this.hasAlpha;
    }
}
