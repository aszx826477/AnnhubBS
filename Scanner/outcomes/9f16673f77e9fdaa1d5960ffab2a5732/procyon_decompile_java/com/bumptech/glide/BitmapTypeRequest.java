// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import android.graphics.Bitmap$CompressFormat;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.model.ImageVideoModelLoader;
import com.bumptech.glide.provider.FixedLoadProvider;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import android.graphics.Bitmap;
import com.bumptech.glide.load.model.ModelLoader;

public class BitmapTypeRequest extends BitmapRequestBuilder
{
    private final ModelLoader fileDescriptorModelLoader;
    private final Glide glide;
    private final RequestManager$OptionsApplier optionsApplier;
    private final ModelLoader streamModelLoader;
    
    BitmapTypeRequest(final GenericRequestBuilder genericRequestBuilder, final ModelLoader streamModelLoader, final ModelLoader fileDescriptorModelLoader, final RequestManager$OptionsApplier optionsApplier) {
        super(buildProvider(genericRequestBuilder.glide, streamModelLoader, fileDescriptorModelLoader, Bitmap.class, null), Bitmap.class, genericRequestBuilder);
        this.streamModelLoader = streamModelLoader;
        this.fileDescriptorModelLoader = fileDescriptorModelLoader;
        this.glide = genericRequestBuilder.glide;
        this.optionsApplier = optionsApplier;
    }
    
    private static FixedLoadProvider buildProvider(final Glide glide, final ModelLoader modelLoader, final ModelLoader modelLoader2, final Class clazz, ResourceTranscoder buildTranscoder) {
        if (modelLoader == null && modelLoader2 == null) {
            return null;
        }
        if (buildTranscoder == null) {
            buildTranscoder = glide.buildTranscoder(Bitmap.class, clazz);
        }
        return new FixedLoadProvider(new ImageVideoModelLoader(modelLoader, modelLoader2), buildTranscoder, glide.buildDataProvider(ImageVideoWrapper.class, Bitmap.class));
    }
    
    public BitmapRequestBuilder toBytes() {
        return this.transcode(new BitmapBytesTranscoder(), byte[].class);
    }
    
    public BitmapRequestBuilder toBytes(final Bitmap$CompressFormat bitmap$CompressFormat, final int n) {
        return this.transcode(new BitmapBytesTranscoder(bitmap$CompressFormat, n), byte[].class);
    }
    
    public BitmapRequestBuilder transcode(final ResourceTranscoder resourceTranscoder, final Class clazz) {
        return (BitmapRequestBuilder)this.optionsApplier.apply(new BitmapRequestBuilder(buildProvider(this.glide, this.streamModelLoader, this.fileDescriptorModelLoader, clazz, resourceTranscoder), clazz, this));
    }
}
