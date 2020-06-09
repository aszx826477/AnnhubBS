// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.FutureTarget;

interface DownloadOptions
{
    FutureTarget downloadOnly(final int p0, final int p1);
    
    Target downloadOnly(final Target p0);
}
