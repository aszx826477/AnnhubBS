// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.module;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import android.content.Context;

public interface GlideModule
{
    void applyOptions(final Context p0, final GlideBuilder p1);
    
    void registerComponents(final Context p0, final Glide p1);
}
