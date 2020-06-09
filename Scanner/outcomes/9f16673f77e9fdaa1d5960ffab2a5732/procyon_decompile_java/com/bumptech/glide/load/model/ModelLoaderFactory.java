// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import android.content.Context;

public interface ModelLoaderFactory
{
    ModelLoader build(final Context p0, final GenericLoaderFactory p1);
    
    void teardown();
}
