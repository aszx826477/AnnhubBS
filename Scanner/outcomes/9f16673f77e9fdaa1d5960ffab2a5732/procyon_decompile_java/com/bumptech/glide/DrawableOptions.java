// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import android.view.animation.Animation;

interface DrawableOptions
{
    GenericRequestBuilder crossFade();
    
    GenericRequestBuilder crossFade(final int p0);
    
    GenericRequestBuilder crossFade(final int p0, final int p1);
    
    GenericRequestBuilder crossFade(final Animation p0, final int p1);
}
