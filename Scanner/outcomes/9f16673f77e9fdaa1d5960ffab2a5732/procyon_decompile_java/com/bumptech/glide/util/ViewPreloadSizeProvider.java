// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.util;

import java.util.Arrays;
import android.view.View;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.ListPreloader$PreloadSizeProvider;

public class ViewPreloadSizeProvider implements ListPreloader$PreloadSizeProvider, SizeReadyCallback
{
    private int[] size;
    private ViewPreloadSizeProvider$SizeViewTarget viewTarget;
    
    public ViewPreloadSizeProvider() {
    }
    
    public ViewPreloadSizeProvider(final View view) {
        this.setView(view);
    }
    
    public int[] getPreloadSize(final Object o, final int n, final int n2) {
        final int[] size = this.size;
        if (size == null) {
            return null;
        }
        return Arrays.copyOf(size, size.length);
    }
    
    public void onSizeReady(final int n, final int n2) {
        this.size = new int[] { n, n2 };
        this.viewTarget = null;
    }
    
    public void setView(final View view) {
        if (this.size == null && this.viewTarget == null) {
            this.viewTarget = new ViewPreloadSizeProvider$SizeViewTarget(view, this);
        }
    }
}
