// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import java.io.InputStream;
import com.bumptech.glide.provider.FixedLoadProvider;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.model.ModelLoader;

public class GifTypeRequest extends GifRequestBuilder
{
    private final RequestManager$OptionsApplier optionsApplier;
    private final ModelLoader streamModelLoader;
    
    GifTypeRequest(final GenericRequestBuilder genericRequestBuilder, final ModelLoader streamModelLoader, final RequestManager$OptionsApplier optionsApplier) {
        super(buildProvider(genericRequestBuilder.glide, streamModelLoader, GifDrawable.class, null), GifDrawable.class, genericRequestBuilder);
        this.streamModelLoader = streamModelLoader;
        this.optionsApplier = optionsApplier;
        this.crossFade();
    }
    
    private static FixedLoadProvider buildProvider(final Glide glide, final ModelLoader modelLoader, final Class clazz, ResourceTranscoder buildTranscoder) {
        if (modelLoader == null) {
            return null;
        }
        if (buildTranscoder == null) {
            buildTranscoder = glide.buildTranscoder(GifDrawable.class, clazz);
        }
        return new FixedLoadProvider(modelLoader, buildTranscoder, glide.buildDataProvider(InputStream.class, GifDrawable.class));
    }
    
    public GenericRequestBuilder toBytes() {
        return this.transcode(new GifDrawableBytesTranscoder(), byte[].class);
    }
    
    public GenericRequestBuilder transcode(final ResourceTranscoder resourceTranscoder, final Class clazz) {
        return this.optionsApplier.apply(new GenericRequestBuilder(buildProvider(this.glide, this.streamModelLoader, clazz, resourceTranscoder), clazz, this));
    }
}
