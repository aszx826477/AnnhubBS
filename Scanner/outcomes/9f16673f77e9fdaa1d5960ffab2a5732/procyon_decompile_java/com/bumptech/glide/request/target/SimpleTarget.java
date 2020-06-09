// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.target;

import com.bumptech.glide.util.Util;

public abstract class SimpleTarget extends BaseTarget
{
    private final int height;
    private final int width;
    
    public SimpleTarget() {
        final int n = -1 << -1;
        this(n, n);
    }
    
    public SimpleTarget(final int width, final int height) {
        this.width = width;
        this.height = height;
    }
    
    public final void getSize(final SizeReadyCallback sizeReadyCallback) {
        if (Util.isValidDimensions(this.width, this.height)) {
            sizeReadyCallback.onSizeReady(this.width, this.height);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        sb.append(this.width);
        sb.append(" and height: ");
        sb.append(this.height);
        sb.append(", either provide dimensions in the constructor");
        sb.append(" or call override()");
        throw new IllegalArgumentException(sb.toString());
    }
}
