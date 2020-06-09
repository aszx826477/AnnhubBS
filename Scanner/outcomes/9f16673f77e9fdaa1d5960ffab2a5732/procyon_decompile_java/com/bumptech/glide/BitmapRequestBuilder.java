// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoBitmapDecoder;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.animation.ViewPropertyAnimation$Animator;
import android.view.animation.Animation;
import com.bumptech.glide.load.resource.bitmap.ImageVideoBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.FileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public class BitmapRequestBuilder extends GenericRequestBuilder implements BitmapOptions
{
    private final BitmapPool bitmapPool;
    private DecodeFormat decodeFormat;
    private Downsampler downsampler;
    private ResourceDecoder imageDecoder;
    private ResourceDecoder videoDecoder;
    
    BitmapRequestBuilder(final LoadProvider loadProvider, final Class clazz, final GenericRequestBuilder genericRequestBuilder) {
        super(loadProvider, clazz, genericRequestBuilder);
        this.downsampler = Downsampler.AT_LEAST;
        this.bitmapPool = genericRequestBuilder.glide.getBitmapPool();
        this.decodeFormat = genericRequestBuilder.glide.getDecodeFormat();
        this.imageDecoder = new StreamBitmapDecoder(this.bitmapPool, this.decodeFormat);
        this.videoDecoder = new FileDescriptorBitmapDecoder(this.bitmapPool, this.decodeFormat);
    }
    
    private BitmapRequestBuilder downsample(final Downsampler downsampler) {
        this.downsampler = downsampler;
        this.imageDecoder = new StreamBitmapDecoder(downsampler, this.bitmapPool, this.decodeFormat);
        super.decoder(new ImageVideoBitmapDecoder(this.imageDecoder, this.videoDecoder));
        return this;
    }
    
    public BitmapRequestBuilder animate(final int n) {
        super.animate(n);
        return this;
    }
    
    public BitmapRequestBuilder animate(final Animation animation) {
        super.animate(animation);
        return this;
    }
    
    public BitmapRequestBuilder animate(final ViewPropertyAnimation$Animator viewPropertyAnimation$Animator) {
        super.animate(viewPropertyAnimation$Animator);
        return this;
    }
    
    void applyCenterCrop() {
        this.centerCrop();
    }
    
    void applyFitCenter() {
        this.fitCenter();
    }
    
    public BitmapRequestBuilder approximate() {
        return this.downsample(Downsampler.AT_LEAST);
    }
    
    public BitmapRequestBuilder asIs() {
        return this.downsample(Downsampler.NONE);
    }
    
    public BitmapRequestBuilder atMost() {
        return this.downsample(Downsampler.AT_MOST);
    }
    
    public BitmapRequestBuilder cacheDecoder(final ResourceDecoder resourceDecoder) {
        super.cacheDecoder(resourceDecoder);
        return this;
    }
    
    public BitmapRequestBuilder centerCrop() {
        return this.transform(this.glide.getBitmapCenterCrop());
    }
    
    public BitmapRequestBuilder clone() {
        return (BitmapRequestBuilder)super.clone();
    }
    
    public BitmapRequestBuilder decoder(final ResourceDecoder resourceDecoder) {
        super.decoder(resourceDecoder);
        return this;
    }
    
    public BitmapRequestBuilder diskCacheStrategy(final DiskCacheStrategy diskCacheStrategy) {
        super.diskCacheStrategy(diskCacheStrategy);
        return this;
    }
    
    public BitmapRequestBuilder dontAnimate() {
        super.dontAnimate();
        return this;
    }
    
    public BitmapRequestBuilder dontTransform() {
        super.dontTransform();
        return this;
    }
    
    public BitmapRequestBuilder encoder(final ResourceEncoder resourceEncoder) {
        super.encoder(resourceEncoder);
        return this;
    }
    
    public BitmapRequestBuilder error(final int n) {
        super.error(n);
        return this;
    }
    
    public BitmapRequestBuilder error(final Drawable drawable) {
        super.error(drawable);
        return this;
    }
    
    public BitmapRequestBuilder fallback(final int n) {
        super.fallback(n);
        return this;
    }
    
    public BitmapRequestBuilder fallback(final Drawable drawable) {
        super.fallback(drawable);
        return this;
    }
    
    public BitmapRequestBuilder fitCenter() {
        return this.transform(this.glide.getBitmapFitCenter());
    }
    
    public BitmapRequestBuilder format(final DecodeFormat decodeFormat) {
        this.decodeFormat = decodeFormat;
        this.imageDecoder = new StreamBitmapDecoder(this.downsampler, this.bitmapPool, decodeFormat);
        this.videoDecoder = new FileDescriptorBitmapDecoder(new VideoBitmapDecoder(), this.bitmapPool, decodeFormat);
        super.cacheDecoder(new FileToStreamDecoder(new StreamBitmapDecoder(this.downsampler, this.bitmapPool, decodeFormat)));
        super.decoder(new ImageVideoBitmapDecoder(this.imageDecoder, this.videoDecoder));
        return this;
    }
    
    public BitmapRequestBuilder imageDecoder(final ResourceDecoder imageDecoder) {
        this.imageDecoder = imageDecoder;
        super.decoder(new ImageVideoBitmapDecoder(imageDecoder, this.videoDecoder));
        return this;
    }
    
    public Target into(final ImageView imageView) {
        return super.into(imageView);
    }
    
    public BitmapRequestBuilder listener(final RequestListener requestListener) {
        super.listener(requestListener);
        return this;
    }
    
    public BitmapRequestBuilder load(final Object o) {
        super.load(o);
        return this;
    }
    
    public BitmapRequestBuilder override(final int n, final int n2) {
        super.override(n, n2);
        return this;
    }
    
    public BitmapRequestBuilder placeholder(final int n) {
        super.placeholder(n);
        return this;
    }
    
    public BitmapRequestBuilder placeholder(final Drawable drawable) {
        super.placeholder(drawable);
        return this;
    }
    
    public BitmapRequestBuilder priority(final Priority priority) {
        super.priority(priority);
        return this;
    }
    
    public BitmapRequestBuilder signature(final Key key) {
        super.signature(key);
        return this;
    }
    
    public BitmapRequestBuilder sizeMultiplier(final float n) {
        super.sizeMultiplier(n);
        return this;
    }
    
    public BitmapRequestBuilder skipMemoryCache(final boolean b) {
        super.skipMemoryCache(b);
        return this;
    }
    
    public BitmapRequestBuilder sourceEncoder(final Encoder encoder) {
        super.sourceEncoder(encoder);
        return this;
    }
    
    public BitmapRequestBuilder thumbnail(final float n) {
        super.thumbnail(n);
        return this;
    }
    
    public BitmapRequestBuilder thumbnail(final BitmapRequestBuilder bitmapRequestBuilder) {
        super.thumbnail(bitmapRequestBuilder);
        return this;
    }
    
    public BitmapRequestBuilder thumbnail(final GenericRequestBuilder genericRequestBuilder) {
        super.thumbnail(genericRequestBuilder);
        return this;
    }
    
    public BitmapRequestBuilder transcoder(final ResourceTranscoder resourceTranscoder) {
        super.transcoder(resourceTranscoder);
        return this;
    }
    
    public BitmapRequestBuilder transform(final Transformation... array) {
        super.transform(array);
        return this;
    }
    
    public BitmapRequestBuilder transform(final BitmapTransformation... array) {
        super.transform((Transformation[])array);
        return this;
    }
    
    public BitmapRequestBuilder videoDecoder(final ResourceDecoder videoDecoder) {
        this.videoDecoder = videoDecoder;
        super.decoder(new ImageVideoBitmapDecoder(this.imageDecoder, videoDecoder));
        return this;
    }
}
