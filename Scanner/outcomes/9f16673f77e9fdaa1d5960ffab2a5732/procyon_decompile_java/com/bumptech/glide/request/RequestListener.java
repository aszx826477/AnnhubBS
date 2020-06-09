// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request;

import com.bumptech.glide.request.target.Target;

public interface RequestListener
{
    boolean onException(final Exception p0, final Object p1, final Target p2, final boolean p3);
    
    boolean onResourceReady(final Object p0, final Object p1, final Target p2, final boolean p3, final boolean p4);
}
