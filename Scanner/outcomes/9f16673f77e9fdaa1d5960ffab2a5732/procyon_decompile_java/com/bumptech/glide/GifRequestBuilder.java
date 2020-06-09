// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.request.RequestListener;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimationFactory;
import com.bumptech.glide.request.animation.DrawableCrossFadeFactory;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.request.animation.ViewPropertyAnimation$Animator;
import android.view.animation.Animation;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.provider.LoadProvider;

public class GifRequestBuilder extends GenericRequestBuilder implements BitmapOptions, DrawableOptions
{
    GifRequestBuilder(final LoadProvider loadProvider, final Class clazz, final GenericRequestBuilder genericRequestBuilder) {
        super(loadProvider, clazz, genericRequestBuilder);
    }
    
    private GifDrawableTransformation[] toGifTransformations(final Transformation[] array) {
        final GifDrawableTransformation[] array2 = new GifDrawableTransformation[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = new GifDrawableTransformation(array[i], this.glide.getBitmapPool());
        }
        return array2;
    }
    
    public GifRequestBuilder animate(final int n) {
        super.animate(n);
        return this;
    }
    
    public GifRequestBuilder animate(final Animation animation) {
        super.animate(animation);
        return this;
    }
    
    public GifRequestBuilder animate(final ViewPropertyAnimation$Animator viewPropertyAnimation$Animator) {
        super.animate(viewPropertyAnimation$Animator);
        return this;
    }
    
    void applyCenterCrop() {
        this.centerCrop();
    }
    
    void applyFitCenter() {
        this.fitCenter();
    }
    
    public GifRequestBuilder cacheDecoder(final ResourceDecoder resourceDecoder) {
        super.cacheDecoder(resourceDecoder);
        return this;
    }
    
    public GifRequestBuilder centerCrop() {
        return this.transformFrame(this.glide.getBitmapCenterCrop());
    }
    
    public GifRequestBuilder clone() {
        return (GifRequestBuilder)super.clone();
    }
    
    public GifRequestBuilder crossFade() {
        super.animate(new DrawableCrossFadeFactory());
        return this;
    }
    
    public GifRequestBuilder crossFade(final int n) {
        super.animate(new DrawableCrossFadeFactory(n));
        return this;
    }
    
    public GifRequestBuilder crossFade(final int n, final int n2) {
        super.animate(new DrawableCrossFadeFactory(this.context, n, n2));
        return this;
    }
    
    public GifRequestBuilder crossFade(final Animation animation, final int n) {
        super.animate(new DrawableCrossFadeFactory(animation, n));
        return this;
    }
    
    public GifRequestBuilder decoder(final ResourceDecoder resourceDecoder) {
        super.decoder(resourceDecoder);
        return this;
    }
    
    public GifRequestBuilder diskCacheStrategy(final DiskCacheStrategy diskCacheStrategy) {
        super.diskCacheStrategy(diskCacheStrategy);
        return this;
    }
    
    public GifRequestBuilder dontAnimate() {
        super.dontAnimate();
        return this;
    }
    
    public GifRequestBuilder dontTransform() {
        super.dontTransform();
        return this;
    }
    
    public GifRequestBuilder encoder(final ResourceEncoder resourceEncoder) {
        super.encoder(resourceEncoder);
        return this;
    }
    
    public GifRequestBuilder error(final int n) {
        super.error(n);
        return this;
    }
    
    public GifRequestBuilder error(final Drawable drawable) {
        super.error(drawable);
        return this;
    }
    
    public GifRequestBuilder fallback(final int n) {
        super.fallback(n);
        return this;
    }
    
    public GifRequestBuilder fallback(final Drawable drawable) {
        super.fallback(drawable);
        return this;
    }
    
    public GifRequestBuilder fitCenter() {
        return this.transformFrame(this.glide.getBitmapFitCenter());
    }
    
    public GifRequestBuilder listener(final RequestListener requestListener) {
        super.listener(requestListener);
        return this;
    }
    
    public GifRequestBuilder load(final Object o) {
        super.load(o);
        return this;
    }
    
    public GifRequestBuilder override(final int n, final int n2) {
        super.override(n, n2);
        return this;
    }
    
    public GifRequestBuilder placeholder(final int n) {
        super.placeholder(n);
        return this;
    }
    
    public GifRequestBuilder placeholder(final Drawable drawable) {
        super.placeholder(drawable);
        return this;
    }
    
    public GifRequestBuilder priority(final Priority priority) {
        super.priority(priority);
        return this;
    }
    
    public GifRequestBuilder signature(final Key key) {
        super.signature(key);
        return this;
    }
    
    public GifRequestBuilder sizeMultiplier(final float n) {
        super.sizeMultiplier(n);
        return this;
    }
    
    public GifRequestBuilder skipMemoryCache(final boolean b) {
        super.skipMemoryCache(b);
        return this;
    }
    
    public GifRequestBuilder sourceEncoder(final Encoder encoder) {
        super.sourceEncoder(encoder);
        return this;
    }
    
    public GifRequestBuilder thumbnail(final float n) {
        super.thumbnail(n);
        return this;
    }
    
    public GifRequestBuilder thumbnail(final GenericRequestBuilder genericRequestBuilder) {
        super.thumbnail(genericRequestBuilder);
        return this;
    }
    
    public GifRequestBuilder thumbnail(final GifRequestBuilder gifRequestBuilder) {
        super.thumbnail(gifRequestBuilder);
        return this;
    }
    
    public GifRequestBuilder transcoder(final ResourceTranscoder resourceTranscoder) {
        super.transcoder(resourceTranscoder);
        return this;
    }
    
    public GifRequestBuilder transform(final Transformation... array) {
        super.transform(array);
        return this;
    }
    
    public GifRequestBuilder transformFrame(final Transformation... array) {
        return this.transform((Transformation[])this.toGifTransformations(array));
    }
    
    public GifRequestBuilder transformFrame(final BitmapTransformation... array) {
        return this.transform((Transformation[])this.toGifTransformations(array));
    }
}
