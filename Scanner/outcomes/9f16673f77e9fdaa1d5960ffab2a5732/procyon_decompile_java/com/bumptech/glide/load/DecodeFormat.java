// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load;

public enum DecodeFormat
{
    ALWAYS_ARGB_8888("ALWAYS_ARGB_8888", 0);
    
    public static final DecodeFormat DEFAULT;
    
    PREFER_ARGB_8888("PREFER_ARGB_8888", n), 
    PREFER_RGB_565("PREFER_RGB_565", n2);
    
    static {
        final int n = 1;
        final int n2 = 2;
        final DecodeFormat[] $values = { DecodeFormat.ALWAYS_ARGB_8888, null, null };
        $values[n] = DecodeFormat.PREFER_ARGB_8888;
        final DecodeFormat prefer_RGB_565 = DecodeFormat.PREFER_RGB_565;
        $values[n2] = prefer_RGB_565;
        $VALUES = $values;
        DEFAULT = prefer_RGB_565;
    }
    
    private DecodeFormat(final String s, final int n) {
    }
}
