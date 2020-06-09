// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.File;
import com.bumptech.glide.provider.FixedLoadProvider;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import android.content.Context;
import com.bumptech.glide.load.model.ModelLoader;

public class GenericTranscodeRequest extends GenericRequestBuilder implements DownloadOptions
{
    private final Class dataClass;
    private final ModelLoader modelLoader;
    private final RequestManager$OptionsApplier optionsApplier;
    private final Class resourceClass;
    
    GenericTranscodeRequest(final Context context, final Glide glide, final Class clazz, final ModelLoader modelLoader, final Class dataClass, final Class resourceClass, final RequestTracker requestTracker, final Lifecycle lifecycle, final RequestManager$OptionsApplier optionsApplier) {
        super(context, clazz, build(glide, modelLoader, dataClass, resourceClass, UnitTranscoder.get()), resourceClass, glide, requestTracker, lifecycle);
        this.modelLoader = modelLoader;
        this.dataClass = dataClass;
        this.resourceClass = resourceClass;
        this.optionsApplier = optionsApplier;
    }
    
    GenericTranscodeRequest(final Class clazz, final GenericRequestBuilder genericRequestBuilder, final ModelLoader modelLoader, final Class dataClass, final Class resourceClass, final RequestManager$OptionsApplier optionsApplier) {
        super(build(genericRequestBuilder.glide, modelLoader, dataClass, resourceClass, UnitTranscoder.get()), clazz, genericRequestBuilder);
        this.modelLoader = modelLoader;
        this.dataClass = dataClass;
        this.resourceClass = resourceClass;
        this.optionsApplier = optionsApplier;
    }
    
    private static LoadProvider build(final Glide glide, final ModelLoader modelLoader, final Class clazz, final Class clazz2, final ResourceTranscoder resourceTranscoder) {
        return new FixedLoadProvider(modelLoader, resourceTranscoder, glide.buildDataProvider(clazz, clazz2));
    }
    
    private GenericRequestBuilder getDownloadOnlyRequest() {
        return this.optionsApplier.apply(new GenericRequestBuilder(new FixedLoadProvider(this.modelLoader, UnitTranscoder.get(), this.glide.buildDataProvider(this.dataClass, File.class)), File.class, this)).priority(Priority.LOW).diskCacheStrategy(DiskCacheStrategy.SOURCE).skipMemoryCache(true);
    }
    
    public FutureTarget downloadOnly(final int n, final int n2) {
        return this.getDownloadOnlyRequest().into(n, n2);
    }
    
    public Target downloadOnly(final Target target) {
        return this.getDownloadOnlyRequest().into(target);
    }
    
    public GenericRequestBuilder transcode(final ResourceTranscoder resourceTranscoder, final Class clazz) {
        return this.optionsApplier.apply(new GenericRequestBuilder(build(this.glide, this.modelLoader, this.dataClass, this.resourceClass, resourceTranscoder), clazz, this));
    }
}
