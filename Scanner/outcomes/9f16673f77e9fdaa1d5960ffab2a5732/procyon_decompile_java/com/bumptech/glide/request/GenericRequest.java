// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request;

import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.provider.DataLoadProvider;
import java.io.Serializable;
import com.bumptech.glide.util.LogTime;
import android.util.Log;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.Engine$LoadStatus;
import com.bumptech.glide.provider.LoadProvider;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import android.content.Context;
import com.bumptech.glide.request.animation.GlideAnimationFactory;
import java.util.Queue;
import com.bumptech.glide.request.target.SizeReadyCallback;

public final class GenericRequest implements Request, SizeReadyCallback, ResourceCallback
{
    private static final Queue REQUEST_POOL;
    private static final String TAG = "GenericRequest";
    private static final double TO_MEGABYTE = 9.5367431640625E-7;
    private GlideAnimationFactory animationFactory;
    private Context context;
    private DiskCacheStrategy diskCacheStrategy;
    private Engine engine;
    private Drawable errorDrawable;
    private int errorResourceId;
    private Drawable fallbackDrawable;
    private int fallbackResourceId;
    private boolean isMemoryCacheable;
    private LoadProvider loadProvider;
    private Engine$LoadStatus loadStatus;
    private boolean loadedFromMemoryCache;
    private Object model;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private int placeholderResourceId;
    private Priority priority;
    private RequestCoordinator requestCoordinator;
    private RequestListener requestListener;
    private Resource resource;
    private Key signature;
    private float sizeMultiplier;
    private long startTime;
    private GenericRequest$Status status;
    private final String tag;
    private Target target;
    private Class transcodeClass;
    private Transformation transformation;
    
    static {
        REQUEST_POOL = Util.createQueue(0);
    }
    
    private GenericRequest() {
        this.tag = String.valueOf(this.hashCode());
    }
    
    private boolean canNotifyStatusChanged() {
        final RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }
    
    private boolean canSetResource() {
        final RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }
    
    private static void check(final String s, final Object o, final String s2) {
        if (o == null) {
            final StringBuilder sb = new StringBuilder(s);
            sb.append(" must not be null");
            if (s2 != null) {
                sb.append(", ");
                sb.append(s2);
            }
            throw new NullPointerException(sb.toString());
        }
    }
    
    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null && this.errorResourceId > 0) {
            this.errorDrawable = this.context.getResources().getDrawable(this.errorResourceId);
        }
        return this.errorDrawable;
    }
    
    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null && this.fallbackResourceId > 0) {
            this.fallbackDrawable = this.context.getResources().getDrawable(this.fallbackResourceId);
        }
        return this.fallbackDrawable;
    }
    
    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null && this.placeholderResourceId > 0) {
            this.placeholderDrawable = this.context.getResources().getDrawable(this.placeholderResourceId);
        }
        return this.placeholderDrawable;
    }
    
    private void init(final LoadProvider loadProvider, final Object model, final Key signature, final Context context, final Priority priority, final Target target, final float sizeMultiplier, final Drawable placeholderDrawable, final int placeholderResourceId, final Drawable errorDrawable, final int errorResourceId, final Drawable fallbackDrawable, final int fallbackResourceId, final RequestListener requestListener, final RequestCoordinator requestCoordinator, final Engine engine, final Transformation transformation, final Class transcodeClass, final boolean isMemoryCacheable, final GlideAnimationFactory animationFactory, final int overrideWidth, final int overrideHeight, final DiskCacheStrategy diskCacheStrategy) {
        this.loadProvider = loadProvider;
        this.model = model;
        this.signature = signature;
        this.fallbackDrawable = fallbackDrawable;
        this.fallbackResourceId = fallbackResourceId;
        this.context = context.getApplicationContext();
        this.priority = priority;
        this.target = target;
        this.sizeMultiplier = sizeMultiplier;
        this.placeholderDrawable = placeholderDrawable;
        this.placeholderResourceId = placeholderResourceId;
        this.errorDrawable = errorDrawable;
        this.errorResourceId = errorResourceId;
        this.requestListener = requestListener;
        this.requestCoordinator = requestCoordinator;
        this.engine = engine;
        this.transformation = transformation;
        this.transcodeClass = transcodeClass;
        this.isMemoryCacheable = isMemoryCacheable;
        this.animationFactory = animationFactory;
        this.overrideWidth = overrideWidth;
        this.overrideHeight = overrideHeight;
        this.diskCacheStrategy = diskCacheStrategy;
        this.status = GenericRequest$Status.PENDING;
        if (model != null) {
            check("ModelLoader", loadProvider.getModelLoader(), "try .using(ModelLoader)");
            check("Transcoder", loadProvider.getTranscoder(), "try .as*(Class).transcode(ResourceTranscoder)");
            check("Transformation", transformation, "try .transform(UnitTransformation.get())");
            if (diskCacheStrategy.cacheSource()) {
                check("SourceEncoder", loadProvider.getSourceEncoder(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            }
            else {
                check("SourceDecoder", loadProvider.getSourceDecoder(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (diskCacheStrategy.cacheSource() || diskCacheStrategy.cacheResult()) {
                check("CacheDecoder", loadProvider.getCacheDecoder(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (diskCacheStrategy.cacheResult()) {
                check("Encoder", loadProvider.getEncoder(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }
    
    private boolean isFirstReadyResource() {
        final RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || !requestCoordinator.isAnyResourceSet();
    }
    
    private void logV(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(" this: ");
        sb.append(this.tag);
        Log.v("GenericRequest", sb.toString());
    }
    
    private void notifyLoadSuccess() {
        final RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
    }
    
    public static GenericRequest obtain(final LoadProvider loadProvider, final Object o, final Key key, final Context context, final Priority priority, final Target target, final float n, final Drawable drawable, final int n2, final Drawable drawable2, final int n3, final Drawable drawable3, final int n4, final RequestListener requestListener, final RequestCoordinator requestCoordinator, final Engine engine, final Transformation transformation, final Class clazz, final boolean b, final GlideAnimationFactory glideAnimationFactory, final int n5, final int n6, final DiskCacheStrategy diskCacheStrategy) {
        GenericRequest genericRequest = GenericRequest.REQUEST_POOL.poll();
        if (genericRequest == null) {
            genericRequest = new GenericRequest();
        }
        genericRequest.init(loadProvider, o, key, context, priority, target, n, drawable, n2, drawable2, n3, drawable3, n4, requestListener, requestCoordinator, engine, transformation, clazz, b, glideAnimationFactory, n5, n6, diskCacheStrategy);
        return genericRequest;
    }
    
    private void onResourceReady(final Resource resource, final Object o) {
        final boolean firstReadyResource = this.isFirstReadyResource();
        this.status = GenericRequest$Status.COMPLETE;
        this.resource = resource;
        final RequestListener requestListener = this.requestListener;
        if (requestListener == null || requestListener.onResourceReady(o, this.model, this.target, this.loadedFromMemoryCache, firstReadyResource)) {
            this.target.onResourceReady(o, this.animationFactory.build(this.loadedFromMemoryCache, firstReadyResource));
        }
        this.notifyLoadSuccess();
        if (Log.isLoggable("GenericRequest", 2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Resource ready in ");
            sb.append(LogTime.getElapsedMillis(this.startTime));
            sb.append(" size: ");
            final double n = resource.getSize();
            final double n2 = 9.5367431640625E-7;
            Double.isNaN(n);
            sb.append(n * n2);
            sb.append(" fromCache: ");
            sb.append(this.loadedFromMemoryCache);
            this.logV(sb.toString());
        }
    }
    
    private void releaseResource(final Resource resource) {
        this.engine.release(resource);
        this.resource = null;
    }
    
    private void setErrorPlaceholder(final Exception ex) {
        if (!this.canNotifyStatusChanged()) {
            return;
        }
        Drawable drawable;
        if (this.model == null) {
            drawable = this.getFallbackDrawable();
        }
        else {
            drawable = null;
        }
        if (drawable == null) {
            drawable = this.getErrorDrawable();
        }
        if (drawable == null) {
            drawable = this.getPlaceholderDrawable();
        }
        this.target.onLoadFailed(ex, drawable);
    }
    
    public void begin() {
        this.startTime = LogTime.getLogTime();
        if (this.model == null) {
            this.onException(null);
            return;
        }
        this.status = GenericRequest$Status.WAITING_FOR_SIZE;
        if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
            this.onSizeReady(this.overrideWidth, this.overrideHeight);
        }
        else {
            this.target.getSize(this);
        }
        if (!this.isComplete() && !this.isFailed() && this.canNotifyStatusChanged()) {
            this.target.onLoadStarted(this.getPlaceholderDrawable());
        }
        if (Log.isLoggable("GenericRequest", 2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("finished run method in ");
            sb.append(LogTime.getElapsedMillis(this.startTime));
            this.logV(sb.toString());
        }
    }
    
    void cancel() {
        this.status = GenericRequest$Status.CANCELLED;
        final Engine$LoadStatus loadStatus = this.loadStatus;
        if (loadStatus != null) {
            loadStatus.cancel();
            this.loadStatus = null;
        }
    }
    
    public void clear() {
        Util.assertMainThread();
        if (this.status == GenericRequest$Status.CLEARED) {
            return;
        }
        this.cancel();
        final Resource resource = this.resource;
        if (resource != null) {
            this.releaseResource(resource);
        }
        if (this.canNotifyStatusChanged()) {
            this.target.onLoadCleared(this.getPlaceholderDrawable());
        }
        this.status = GenericRequest$Status.CLEARED;
    }
    
    public boolean isCancelled() {
        return this.status == GenericRequest$Status.CANCELLED || this.status == GenericRequest$Status.CLEARED;
    }
    
    public boolean isComplete() {
        return this.status == GenericRequest$Status.COMPLETE;
    }
    
    public boolean isFailed() {
        return this.status == GenericRequest$Status.FAILED;
    }
    
    public boolean isPaused() {
        return this.status == GenericRequest$Status.PAUSED;
    }
    
    public boolean isResourceSet() {
        return this.isComplete();
    }
    
    public boolean isRunning() {
        return this.status == GenericRequest$Status.RUNNING || this.status == GenericRequest$Status.WAITING_FOR_SIZE;
    }
    
    public void onException(final Exception errorPlaceholder) {
        if (Log.isLoggable("GenericRequest", 3)) {
            Log.d("GenericRequest", "load failed", (Throwable)errorPlaceholder);
        }
        this.status = GenericRequest$Status.FAILED;
        final RequestListener requestListener = this.requestListener;
        if (requestListener == null || requestListener.onException(errorPlaceholder, this.model, this.target, this.isFirstReadyResource())) {
            this.setErrorPlaceholder(errorPlaceholder);
        }
    }
    
    public void onResourceReady(final Resource resource) {
        if (resource == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Expected to receive a Resource<R> with an object of ");
            sb.append(this.transcodeClass);
            sb.append(" inside, but instead got null.");
            this.onException(new Exception(sb.toString()));
            return;
        }
        final Object value = resource.get();
        if (value == null || this.transcodeClass.isAssignableFrom(value.getClass())) {
            this.releaseResource(resource);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Expected to receive an object of ");
            sb2.append(this.transcodeClass);
            sb2.append(" but instead got ");
            Serializable class1;
            if (value != null) {
                class1 = value.getClass();
            }
            else {
                class1 = "";
            }
            sb2.append(class1);
            sb2.append("{");
            sb2.append(value);
            sb2.append("}");
            sb2.append(" inside Resource{");
            sb2.append(resource);
            sb2.append("}.");
            String s;
            if (value != null) {
                s = "";
            }
            else {
                s = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
            }
            sb2.append(s);
            this.onException(new Exception(sb2.toString()));
            return;
        }
        if (!this.canSetResource()) {
            this.releaseResource(resource);
            this.status = GenericRequest$Status.COMPLETE;
            return;
        }
        this.onResourceReady(resource, value);
    }
    
    public void onSizeReady(final int n, final int n2) {
        final String s = "GenericRequest";
        final int n3 = 2;
        if (Log.isLoggable(s, n3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Got onSizeReady in ");
            sb.append(LogTime.getElapsedMillis(this.startTime));
            this.logV(sb.toString());
        }
        if (this.status != GenericRequest$Status.WAITING_FOR_SIZE) {
            return;
        }
        this.status = GenericRequest$Status.RUNNING;
        final int round = Math.round(this.sizeMultiplier * n);
        final int round2 = Math.round(this.sizeMultiplier * n2);
        final DataFetcher resourceFetcher = this.loadProvider.getModelLoader().getResourceFetcher(this.model, round, round2);
        if (resourceFetcher == null) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to load model: '");
            sb2.append(this.model);
            sb2.append("'");
            this.onException(new Exception(sb2.toString()));
            return;
        }
        final ResourceTranscoder transcoder = this.loadProvider.getTranscoder();
        if (Log.isLoggable("GenericRequest", n3)) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("finished setup for calling load in ");
            sb3.append(LogTime.getElapsedMillis(this.startTime));
            this.logV(sb3.toString());
        }
        this.loadedFromMemoryCache = true;
        this.loadStatus = this.engine.load(this.signature, round, round2, resourceFetcher, this.loadProvider, this.transformation, transcoder, this.priority, this.isMemoryCacheable, this.diskCacheStrategy, this);
        this.loadedFromMemoryCache = (this.resource != null);
        if (Log.isLoggable("GenericRequest", n3)) {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("finished onSizeReady in ");
            sb4.append(LogTime.getElapsedMillis(this.startTime));
            this.logV(sb4.toString());
        }
    }
    
    public void pause() {
        this.clear();
        this.status = GenericRequest$Status.PAUSED;
    }
    
    public void recycle() {
        this.loadProvider = null;
        this.model = null;
        this.context = null;
        this.target = null;
        this.placeholderDrawable = null;
        this.errorDrawable = null;
        this.fallbackDrawable = null;
        this.requestListener = null;
        this.requestCoordinator = null;
        this.transformation = null;
        this.animationFactory = null;
        this.loadedFromMemoryCache = false;
        this.loadStatus = null;
        GenericRequest.REQUEST_POOL.offer(this);
    }
}
