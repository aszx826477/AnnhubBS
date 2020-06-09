// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load;

import java.io.OutputStream;

public interface Encoder
{
    boolean encode(final Object p0, final OutputStream p1);
    
    String getId();
}
