// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.util;

import java.util.Arrays;
import com.bumptech.glide.ListPreloader$PreloadSizeProvider;

public class FixedPreloadSizeProvider implements ListPreloader$PreloadSizeProvider
{
    private final int[] size;
    
    public FixedPreloadSizeProvider(final int n, final int n2) {
        this.size = new int[] { n, n2 };
    }
    
    public int[] getPreloadSize(final Object o, final int n, final int n2) {
        final int[] size = this.size;
        return Arrays.copyOf(size, size.length);
    }
}
