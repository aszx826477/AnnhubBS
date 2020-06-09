// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.request.target.PreloadTarget;
import com.bumptech.glide.manager.LifecycleListener;
import android.widget.ImageView;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.request.animation.ViewPropertyAnimationFactory;
import com.bumptech.glide.request.animation.ViewPropertyAnimation$Animator;
import android.view.animation.Animation;
import com.bumptech.glide.request.animation.ViewAnimationFactory;
import com.bumptech.glide.request.GenericRequest;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.request.animation.NoAnimation;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.provider.ChildLoadProvider;
import com.bumptech.glide.manager.Lifecycle;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import android.content.Context;
import com.bumptech.glide.request.animation.GlideAnimationFactory;

public class GenericRequestBuilder implements Cloneable
{
    private GlideAnimationFactory animationFactory;
    protected final Context context;
    private DiskCacheStrategy diskCacheStrategy;
    private int errorId;
    private Drawable errorPlaceholder;
    private Drawable fallbackDrawable;
    private int fallbackResource;
    protected final Glide glide;
    private boolean isCacheable;
    private boolean isModelSet;
    private boolean isThumbnailBuilt;
    private boolean isTransformationSet;
    protected final Lifecycle lifecycle;
    private ChildLoadProvider loadProvider;
    private Object model;
    protected final Class modelClass;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private int placeholderId;
    private Priority priority;
    private RequestListener requestListener;
    protected final RequestTracker requestTracker;
    private Key signature;
    private Float sizeMultiplier;
    private Float thumbSizeMultiplier;
    private GenericRequestBuilder thumbnailRequestBuilder;
    protected final Class transcodeClass;
    private Transformation transformation;
    
    GenericRequestBuilder(final Context context, final Class modelClass, final LoadProvider loadProvider, final Class transcodeClass, final Glide glide, final RequestTracker requestTracker, final Lifecycle lifecycle) {
        this.signature = EmptySignature.obtain();
        this.sizeMultiplier = 1.0f;
        ChildLoadProvider loadProvider2 = null;
        this.priority = null;
        this.isCacheable = true;
        this.animationFactory = NoAnimation.getFactory();
        final int n = -1;
        this.overrideHeight = n;
        this.overrideWidth = n;
        this.diskCacheStrategy = DiskCacheStrategy.RESULT;
        this.transformation = UnitTransformation.get();
        this.context = context;
        this.modelClass = modelClass;
        this.transcodeClass = transcodeClass;
        this.glide = glide;
        this.requestTracker = requestTracker;
        this.lifecycle = lifecycle;
        if (loadProvider != null) {
            loadProvider2 = new ChildLoadProvider(loadProvider);
        }
        this.loadProvider = loadProvider2;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        }
        if (modelClass != null && loadProvider == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }
    
    GenericRequestBuilder(final LoadProvider loadProvider, final Class clazz, final GenericRequestBuilder genericRequestBuilder) {
        this(genericRequestBuilder.context, genericRequestBuilder.modelClass, loadProvider, clazz, genericRequestBuilder.glide, genericRequestBuilder.requestTracker, genericRequestBuilder.lifecycle);
        this.model = genericRequestBuilder.model;
        this.isModelSet = genericRequestBuilder.isModelSet;
        this.signature = genericRequestBuilder.signature;
        this.diskCacheStrategy = genericRequestBuilder.diskCacheStrategy;
        this.isCacheable = genericRequestBuilder.isCacheable;
    }
    
    private Request buildRequest(final Target target) {
        if (this.priority == null) {
            this.priority = Priority.NORMAL;
        }
        return this.buildRequestRecursive(target, null);
    }
    
    private Request buildRequestRecursive(final Target target, final ThumbnailRequestCoordinator thumbnailRequestCoordinator) {
        final GenericRequestBuilder thumbnailRequestBuilder = this.thumbnailRequestBuilder;
        if (thumbnailRequestBuilder != null) {
            if (!this.isThumbnailBuilt) {
                if (thumbnailRequestBuilder.animationFactory.equals(NoAnimation.getFactory())) {
                    this.thumbnailRequestBuilder.animationFactory = this.animationFactory;
                }
                final GenericRequestBuilder thumbnailRequestBuilder2 = this.thumbnailRequestBuilder;
                if (thumbnailRequestBuilder2.priority == null) {
                    thumbnailRequestBuilder2.priority = this.getThumbnailPriority();
                }
                if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                    final GenericRequestBuilder thumbnailRequestBuilder3 = this.thumbnailRequestBuilder;
                    if (!Util.isValidDimensions(thumbnailRequestBuilder3.overrideWidth, thumbnailRequestBuilder3.overrideHeight)) {
                        this.thumbnailRequestBuilder.override(this.overrideWidth, this.overrideHeight);
                    }
                }
                final ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(thumbnailRequestCoordinator);
                final Request obtainRequest = this.obtainRequest(target, this.sizeMultiplier, this.priority, thumbnailRequestCoordinator2);
                this.isThumbnailBuilt = true;
                final Request buildRequestRecursive = this.thumbnailRequestBuilder.buildRequestRecursive(target, thumbnailRequestCoordinator2);
                this.isThumbnailBuilt = false;
                thumbnailRequestCoordinator2.setRequests(obtainRequest, buildRequestRecursive);
                return thumbnailRequestCoordinator2;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        else {
            if (this.thumbSizeMultiplier != null) {
                final ThumbnailRequestCoordinator thumbnailRequestCoordinator3 = new ThumbnailRequestCoordinator(thumbnailRequestCoordinator);
                thumbnailRequestCoordinator3.setRequests(this.obtainRequest(target, this.sizeMultiplier, this.priority, thumbnailRequestCoordinator3), this.obtainRequest(target, this.thumbSizeMultiplier, this.getThumbnailPriority(), thumbnailRequestCoordinator3));
                return thumbnailRequestCoordinator3;
            }
            return this.obtainRequest(target, this.sizeMultiplier, this.priority, thumbnailRequestCoordinator);
        }
    }
    
    private Priority getThumbnailPriority() {
        Priority priority;
        if (this.priority == Priority.LOW) {
            priority = Priority.NORMAL;
        }
        else if (this.priority == Priority.NORMAL) {
            priority = Priority.HIGH;
        }
        else {
            priority = Priority.IMMEDIATE;
        }
        return priority;
    }
    
    private Request obtainRequest(final Target target, final float n, final Priority priority, final RequestCoordinator requestCoordinator) {
        return GenericRequest.obtain(this.loadProvider, this.model, this.signature, this.context, priority, target, n, this.placeholderDrawable, this.placeholderId, this.errorPlaceholder, this.errorId, this.fallbackDrawable, this.fallbackResource, this.requestListener, requestCoordinator, this.glide.getEngine(), this.transformation, this.transcodeClass, this.isCacheable, this.animationFactory, this.overrideWidth, this.overrideHeight, this.diskCacheStrategy);
    }
    
    public GenericRequestBuilder animate(final int n) {
        return this.animate(new ViewAnimationFactory(this.context, n));
    }
    
    public GenericRequestBuilder animate(final Animation animation) {
        return this.animate(new ViewAnimationFactory(animation));
    }
    
    GenericRequestBuilder animate(final GlideAnimationFactory animationFactory) {
        if (animationFactory != null) {
            this.animationFactory = animationFactory;
            return this;
        }
        throw new NullPointerException("Animation factory must not be null!");
    }
    
    public GenericRequestBuilder animate(final ViewPropertyAnimation$Animator viewPropertyAnimation$Animator) {
        return this.animate(new ViewPropertyAnimationFactory(viewPropertyAnimation$Animator));
    }
    
    void applyCenterCrop() {
    }
    
    void applyFitCenter() {
    }
    
    public GenericRequestBuilder cacheDecoder(final ResourceDecoder cacheDecoder) {
        final ChildLoadProvider loadProvider = this.loadProvider;
        if (loadProvider != null) {
            loadProvider.setCacheDecoder(cacheDecoder);
        }
        return this;
    }
    
    public GenericRequestBuilder clone() {
        try {
            final Object clone = super.clone();
            try {
                final GenericRequestBuilder genericRequestBuilder = (GenericRequestBuilder)clone;
                try {
                    Label_0032: {
                        if (this.loadProvider == null) {
                            break Label_0032;
                        }
                        final ChildLoadProvider loadProvider = this.loadProvider;
                        try {
                            ChildLoadProvider clone2 = loadProvider.clone();
                            genericRequestBuilder.loadProvider = clone2;
                            return genericRequestBuilder;
                            clone2 = null;
                        }
                        catch (CloneNotSupportedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                catch (CloneNotSupportedException ex2) {}
            }
            catch (CloneNotSupportedException ex3) {}
        }
        catch (CloneNotSupportedException ex4) {}
    }
    
    public GenericRequestBuilder decoder(final ResourceDecoder sourceDecoder) {
        final ChildLoadProvider loadProvider = this.loadProvider;
        if (loadProvider != null) {
            loadProvider.setSourceDecoder(sourceDecoder);
        }
        return this;
    }
    
    public GenericRequestBuilder diskCacheStrategy(final DiskCacheStrategy diskCacheStrategy) {
        this.diskCacheStrategy = diskCacheStrategy;
        return this;
    }
    
    public GenericRequestBuilder dontAnimate() {
        return this.animate(NoAnimation.getFactory());
    }
    
    public GenericRequestBuilder dontTransform() {
        return this.transform(UnitTransformation.get());
    }
    
    public GenericRequestBuilder encoder(final ResourceEncoder encoder) {
        final ChildLoadProvider loadProvider = this.loadProvider;
        if (loadProvider != null) {
            loadProvider.setEncoder(encoder);
        }
        return this;
    }
    
    public GenericRequestBuilder error(final int errorId) {
        this.errorId = errorId;
        return this;
    }
    
    public GenericRequestBuilder error(final Drawable errorPlaceholder) {
        this.errorPlaceholder = errorPlaceholder;
        return this;
    }
    
    public GenericRequestBuilder fallback(final int fallbackResource) {
        this.fallbackResource = fallbackResource;
        return this;
    }
    
    public GenericRequestBuilder fallback(final Drawable fallbackDrawable) {
        this.fallbackDrawable = fallbackDrawable;
        return this;
    }
    
    public FutureTarget into(final int n, final int n2) {
        final RequestFutureTarget requestFutureTarget = new RequestFutureTarget(this.glide.getMainHandler(), n, n2);
        this.glide.getMainHandler().post((Runnable)new GenericRequestBuilder$1(this, requestFutureTarget));
        return requestFutureTarget;
    }
    
    public Target into(final ImageView imageView) {
        Util.assertMainThread();
        if (imageView != null) {
            if (!this.isTransformationSet && imageView.getScaleType() != null) {
                switch (GenericRequestBuilder$2.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()]) {
                    case 2:
                    case 3:
                    case 4: {
                        this.applyFitCenter();
                        break;
                    }
                    case 1: {
                        this.applyCenterCrop();
                        break;
                    }
                }
            }
            return this.into(this.glide.buildImageViewTarget(imageView, this.transcodeClass));
        }
        throw new IllegalArgumentException("You must pass in a non null View");
    }
    
    public Target into(final Target target) {
        Util.assertMainThread();
        if (target == null) {
            throw new IllegalArgumentException("You must pass in a non null Target");
        }
        if (this.isModelSet) {
            final Request request = target.getRequest();
            if (request != null) {
                request.clear();
                this.requestTracker.removeRequest(request);
                request.recycle();
            }
            final Request buildRequest = this.buildRequest(target);
            target.setRequest(buildRequest);
            this.lifecycle.addListener(target);
            this.requestTracker.runRequest(buildRequest);
            return target;
        }
        throw new IllegalArgumentException("You must first set a model (try #load())");
    }
    
    public GenericRequestBuilder listener(final RequestListener requestListener) {
        this.requestListener = requestListener;
        return this;
    }
    
    public GenericRequestBuilder load(final Object model) {
        this.model = model;
        this.isModelSet = true;
        return this;
    }
    
    public GenericRequestBuilder override(final int overrideWidth, final int overrideHeight) {
        if (Util.isValidDimensions(overrideWidth, overrideHeight)) {
            this.overrideWidth = overrideWidth;
            this.overrideHeight = overrideHeight;
            return this;
        }
        throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
    }
    
    public GenericRequestBuilder placeholder(final int placeholderId) {
        this.placeholderId = placeholderId;
        return this;
    }
    
    public GenericRequestBuilder placeholder(final Drawable placeholderDrawable) {
        this.placeholderDrawable = placeholderDrawable;
        return this;
    }
    
    public Target preload() {
        final int n = -1 << -1;
        return this.preload(n, n);
    }
    
    public Target preload(final int n, final int n2) {
        return this.into(PreloadTarget.obtain(n, n2));
    }
    
    public GenericRequestBuilder priority(final Priority priority) {
        this.priority = priority;
        return this;
    }
    
    public GenericRequestBuilder signature(final Key signature) {
        if (signature != null) {
            this.signature = signature;
            return this;
        }
        throw new NullPointerException("Signature must not be null");
    }
    
    public GenericRequestBuilder sizeMultiplier(final float n) {
        if (n >= 0.0f && n <= 1.0f) {
            this.sizeMultiplier = n;
            return this;
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }
    
    public GenericRequestBuilder skipMemoryCache(final boolean b) {
        this.isCacheable = (b ^ true);
        return this;
    }
    
    public GenericRequestBuilder sourceEncoder(final Encoder sourceEncoder) {
        final ChildLoadProvider loadProvider = this.loadProvider;
        if (loadProvider != null) {
            loadProvider.setSourceEncoder(sourceEncoder);
        }
        return this;
    }
    
    public GenericRequestBuilder thumbnail(final float n) {
        if (n >= 0.0f && n <= 1.0f) {
            this.thumbSizeMultiplier = n;
            return this;
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }
    
    public GenericRequestBuilder thumbnail(final GenericRequestBuilder thumbnailRequestBuilder) {
        if (!this.equals(thumbnailRequestBuilder)) {
            this.thumbnailRequestBuilder = thumbnailRequestBuilder;
            return this;
        }
        throw new IllegalArgumentException("You cannot set a request as a thumbnail for itself. Consider using clone() on the request you are passing to thumbnail()");
    }
    
    public GenericRequestBuilder transcoder(final ResourceTranscoder transcoder) {
        final ChildLoadProvider loadProvider = this.loadProvider;
        if (loadProvider != null) {
            loadProvider.setTranscoder(transcoder);
        }
        return this;
    }
    
    public GenericRequestBuilder transform(final Transformation... array) {
        final boolean isTransformationSet = true;
        this.isTransformationSet = isTransformationSet;
        if (array.length == (isTransformationSet ? 1 : 0)) {
            this.transformation = array[0];
        }
        else {
            this.transformation = new MultiTransformation(array);
        }
        return this;
    }
}
