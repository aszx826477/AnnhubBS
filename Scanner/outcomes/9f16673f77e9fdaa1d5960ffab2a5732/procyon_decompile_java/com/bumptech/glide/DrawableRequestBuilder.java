// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimationFactory;
import com.bumptech.glide.request.animation.DrawableCrossFadeFactory;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.animation.ViewPropertyAnimation$Animator;
import android.view.animation.Animation;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.LoadProvider;
import android.content.Context;

public class DrawableRequestBuilder extends GenericRequestBuilder implements BitmapOptions, DrawableOptions
{
    DrawableRequestBuilder(final Context context, final Class clazz, final LoadProvider loadProvider, final Glide glide, final RequestTracker requestTracker, final Lifecycle lifecycle) {
        super(context, clazz, loadProvider, GlideDrawable.class, glide, requestTracker, lifecycle);
        this.crossFade();
    }
    
    public DrawableRequestBuilder animate(final int n) {
        super.animate(n);
        return this;
    }
    
    public DrawableRequestBuilder animate(final Animation animation) {
        super.animate(animation);
        return this;
    }
    
    public DrawableRequestBuilder animate(final ViewPropertyAnimation$Animator viewPropertyAnimation$Animator) {
        super.animate(viewPropertyAnimation$Animator);
        return this;
    }
    
    void applyCenterCrop() {
        this.centerCrop();
    }
    
    void applyFitCenter() {
        this.fitCenter();
    }
    
    public DrawableRequestBuilder bitmapTransform(final Transformation... array) {
        final GifBitmapWrapperTransformation[] array2 = new GifBitmapWrapperTransformation[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = new GifBitmapWrapperTransformation(this.glide.getBitmapPool(), array[i]);
        }
        return this.transform((Transformation[])array2);
    }
    
    public DrawableRequestBuilder cacheDecoder(final ResourceDecoder resourceDecoder) {
        super.cacheDecoder(resourceDecoder);
        return this;
    }
    
    public DrawableRequestBuilder centerCrop() {
        return this.transform(new Transformation[] { this.glide.getDrawableCenterCrop() });
    }
    
    public DrawableRequestBuilder clone() {
        return (DrawableRequestBuilder)super.clone();
    }
    
    public final DrawableRequestBuilder crossFade() {
        super.animate(new DrawableCrossFadeFactory());
        return this;
    }
    
    public DrawableRequestBuilder crossFade(final int n) {
        super.animate(new DrawableCrossFadeFactory(n));
        return this;
    }
    
    public DrawableRequestBuilder crossFade(final int n, final int n2) {
        super.animate(new DrawableCrossFadeFactory(this.context, n, n2));
        return this;
    }
    
    public DrawableRequestBuilder crossFade(final Animation animation, final int n) {
        super.animate(new DrawableCrossFadeFactory(animation, n));
        return this;
    }
    
    public DrawableRequestBuilder decoder(final ResourceDecoder resourceDecoder) {
        super.decoder(resourceDecoder);
        return this;
    }
    
    public DrawableRequestBuilder diskCacheStrategy(final DiskCacheStrategy diskCacheStrategy) {
        super.diskCacheStrategy(diskCacheStrategy);
        return this;
    }
    
    public DrawableRequestBuilder dontAnimate() {
        super.dontAnimate();
        return this;
    }
    
    public DrawableRequestBuilder dontTransform() {
        super.dontTransform();
        return this;
    }
    
    public DrawableRequestBuilder encoder(final ResourceEncoder resourceEncoder) {
        super.encoder(resourceEncoder);
        return this;
    }
    
    public DrawableRequestBuilder error(final int n) {
        super.error(n);
        return this;
    }
    
    public DrawableRequestBuilder error(final Drawable drawable) {
        super.error(drawable);
        return this;
    }
    
    public DrawableRequestBuilder fallback(final int n) {
        super.fallback(n);
        return this;
    }
    
    public DrawableRequestBuilder fallback(final Drawable drawable) {
        super.fallback(drawable);
        return this;
    }
    
    public DrawableRequestBuilder fitCenter() {
        return this.transform(new Transformation[] { this.glide.getDrawableFitCenter() });
    }
    
    public Target into(final ImageView imageView) {
        return super.into(imageView);
    }
    
    public DrawableRequestBuilder listener(final RequestListener requestListener) {
        super.listener(requestListener);
        return this;
    }
    
    public DrawableRequestBuilder load(final Object o) {
        super.load(o);
        return this;
    }
    
    public DrawableRequestBuilder override(final int n, final int n2) {
        super.override(n, n2);
        return this;
    }
    
    public DrawableRequestBuilder placeholder(final int n) {
        super.placeholder(n);
        return this;
    }
    
    public DrawableRequestBuilder placeholder(final Drawable drawable) {
        super.placeholder(drawable);
        return this;
    }
    
    public DrawableRequestBuilder priority(final Priority priority) {
        super.priority(priority);
        return this;
    }
    
    public DrawableRequestBuilder signature(final Key key) {
        super.signature(key);
        return this;
    }
    
    public DrawableRequestBuilder sizeMultiplier(final float n) {
        super.sizeMultiplier(n);
        return this;
    }
    
    public DrawableRequestBuilder skipMemoryCache(final boolean b) {
        super.skipMemoryCache(b);
        return this;
    }
    
    public DrawableRequestBuilder sourceEncoder(final Encoder encoder) {
        super.sourceEncoder(encoder);
        return this;
    }
    
    public DrawableRequestBuilder thumbnail(final float n) {
        super.thumbnail(n);
        return this;
    }
    
    public DrawableRequestBuilder thumbnail(final DrawableRequestBuilder drawableRequestBuilder) {
        super.thumbnail(drawableRequestBuilder);
        return this;
    }
    
    public DrawableRequestBuilder thumbnail(final GenericRequestBuilder genericRequestBuilder) {
        super.thumbnail(genericRequestBuilder);
        return this;
    }
    
    public DrawableRequestBuilder transcoder(final ResourceTranscoder resourceTranscoder) {
        super.transcoder(resourceTranscoder);
        return this;
    }
    
    public DrawableRequestBuilder transform(final Transformation... array) {
        super.transform(array);
        return this;
    }
    
    public DrawableRequestBuilder transform(final BitmapTransformation... array) {
        return this.bitmapTransform((Transformation[])array);
    }
}
