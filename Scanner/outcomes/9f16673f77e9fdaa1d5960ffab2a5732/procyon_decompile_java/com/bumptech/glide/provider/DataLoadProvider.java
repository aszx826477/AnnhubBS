// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.ResourceDecoder;

public interface DataLoadProvider
{
    ResourceDecoder getCacheDecoder();
    
    ResourceEncoder getEncoder();
    
    ResourceDecoder getSourceDecoder();
    
    Encoder getSourceEncoder();
}
