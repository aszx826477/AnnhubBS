// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.ResourceDecoder;

public class EmptyDataLoadProvider implements DataLoadProvider
{
    private static final DataLoadProvider EMPTY_DATA_LOAD_PROVIDER;
    
    static {
        EMPTY_DATA_LOAD_PROVIDER = new EmptyDataLoadProvider();
    }
    
    public static DataLoadProvider get() {
        return EmptyDataLoadProvider.EMPTY_DATA_LOAD_PROVIDER;
    }
    
    public ResourceDecoder getCacheDecoder() {
        return null;
    }
    
    public ResourceEncoder getEncoder() {
        return null;
    }
    
    public ResourceDecoder getSourceDecoder() {
        return null;
    }
    
    public Encoder getSourceEncoder() {
        return null;
    }
}
