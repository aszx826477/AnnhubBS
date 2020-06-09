// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.provider;

import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.model.ModelLoader;

public interface LoadProvider extends DataLoadProvider
{
    ModelLoader getModelLoader();
    
    ResourceTranscoder getTranscoder();
}
