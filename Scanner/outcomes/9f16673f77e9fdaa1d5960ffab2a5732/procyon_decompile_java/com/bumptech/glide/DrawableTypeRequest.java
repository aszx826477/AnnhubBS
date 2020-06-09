// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.FutureTarget;
import java.io.InputStream;
import java.io.File;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.model.ImageVideoModelLoader;
import com.bumptech.glide.provider.FixedLoadProvider;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import android.content.Context;
import com.bumptech.glide.load.model.ModelLoader;

public class DrawableTypeRequest extends DrawableRequestBuilder implements DownloadOptions
{
    private final ModelLoader fileDescriptorModelLoader;
    private final RequestManager$OptionsApplier optionsApplier;
    private final ModelLoader streamModelLoader;
    
    DrawableTypeRequest(final Class clazz, final ModelLoader streamModelLoader, final ModelLoader fileDescriptorModelLoader, final Context context, final Glide glide, final RequestTracker requestTracker, final Lifecycle lifecycle, final RequestManager$OptionsApplier optionsApplier) {
        super(context, clazz, buildProvider(glide, streamModelLoader, fileDescriptorModelLoader, GifBitmapWrapper.class, GlideDrawable.class, null), glide, requestTracker, lifecycle);
        this.streamModelLoader = streamModelLoader;
        this.fileDescriptorModelLoader = fileDescriptorModelLoader;
        this.optionsApplier = optionsApplier;
    }
    
    private static FixedLoadProvider buildProvider(final Glide glide, final ModelLoader modelLoader, final ModelLoader modelLoader2, final Class clazz, final Class clazz2, ResourceTranscoder buildTranscoder) {
        if (modelLoader == null && modelLoader2 == null) {
            return null;
        }
        if (buildTranscoder == null) {
            buildTranscoder = glide.buildTranscoder(clazz, clazz2);
        }
        return new FixedLoadProvider(new ImageVideoModelLoader(modelLoader, modelLoader2), buildTranscoder, glide.buildDataProvider(ImageVideoWrapper.class, clazz));
    }
    
    private GenericTranscodeRequest getDownloadOnlyRequest() {
        final RequestManager$OptionsApplier optionsApplier = this.optionsApplier;
        return (GenericTranscodeRequest)optionsApplier.apply(new GenericTranscodeRequest(File.class, this, this.streamModelLoader, InputStream.class, File.class, optionsApplier));
    }
    
    public BitmapTypeRequest asBitmap() {
        final RequestManager$OptionsApplier optionsApplier = this.optionsApplier;
        return (BitmapTypeRequest)optionsApplier.apply(new BitmapTypeRequest(this, this.streamModelLoader, this.fileDescriptorModelLoader, optionsApplier));
    }
    
    public GifTypeRequest asGif() {
        final RequestManager$OptionsApplier optionsApplier = this.optionsApplier;
        return (GifTypeRequest)optionsApplier.apply(new GifTypeRequest(this, this.streamModelLoader, optionsApplier));
    }
    
    public FutureTarget downloadOnly(final int n, final int n2) {
        return this.getDownloadOnlyRequest().downloadOnly(n, n2);
    }
    
    public Target downloadOnly(final Target target) {
        return this.getDownloadOnlyRequest().downloadOnly(target);
    }
}
