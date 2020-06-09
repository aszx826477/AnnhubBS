// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.target.Target;
import android.os.SystemClock;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.resource.NullEncoder;
import android.graphics.Bitmap;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import android.os.Handler$Callback;
import android.os.Looper;
import com.bumptech.glide.Glide;
import android.content.Context;
import com.bumptech.glide.GenericRequestBuilder;
import android.os.Handler;
import com.bumptech.glide.gifdecoder.GifDecoder;

class GifFrameLoader
{
    private final GifFrameLoader$FrameCallback callback;
    private GifFrameLoader$DelayTarget current;
    private final GifDecoder gifDecoder;
    private final Handler handler;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private GenericRequestBuilder requestBuilder;
    
    public GifFrameLoader(final Context context, final GifFrameLoader$FrameCallback gifFrameLoader$FrameCallback, final GifDecoder gifDecoder, final int n, final int n2) {
        this(gifFrameLoader$FrameCallback, gifDecoder, null, getRequestBuilder(context, gifDecoder, n, n2, Glide.get(context).getBitmapPool()));
    }
    
    GifFrameLoader(final GifFrameLoader$FrameCallback callback, final GifDecoder gifDecoder, Handler handler, final GenericRequestBuilder requestBuilder) {
        this.isRunning = false;
        this.isLoadPending = false;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper(), (Handler$Callback)new GifFrameLoader$FrameLoaderCallback(this, null));
        }
        this.callback = callback;
        this.gifDecoder = gifDecoder;
        this.handler = handler;
        this.requestBuilder = requestBuilder;
    }
    
    private static GenericRequestBuilder getRequestBuilder(final Context context, final GifDecoder gifDecoder, final int n, final int n2, final BitmapPool bitmapPool) {
        return Glide.with(context).using(new GifFrameModelLoader(), GifDecoder.class).load(gifDecoder).as(Bitmap.class).sourceEncoder(NullEncoder.get()).decoder(new GifFrameResourceDecoder(bitmapPool)).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).override(n, n2);
    }
    
    private void loadNextFrame() {
        if (this.isRunning && !this.isLoadPending) {
            this.isLoadPending = true;
            this.gifDecoder.advance();
            this.requestBuilder.signature(new GifFrameLoader$FrameSignature()).into(new GifFrameLoader$DelayTarget(this.handler, this.gifDecoder.getCurrentFrameIndex(), SystemClock.uptimeMillis() + this.gifDecoder.getNextDelay()));
        }
    }
    
    public void clear() {
        this.stop();
        final GifFrameLoader$DelayTarget current = this.current;
        if (current != null) {
            Glide.clear(current);
            this.current = null;
        }
        this.isCleared = true;
    }
    
    public Bitmap getCurrentFrame() {
        final GifFrameLoader$DelayTarget current = this.current;
        Bitmap resource;
        if (current != null) {
            resource = current.getResource();
        }
        else {
            resource = null;
        }
        return resource;
    }
    
    void onFrameReady(final GifFrameLoader$DelayTarget current) {
        final boolean isCleared = this.isCleared;
        final int n = 2;
        if (isCleared) {
            this.handler.obtainMessage(n, (Object)current).sendToTarget();
            return;
        }
        final GifFrameLoader$DelayTarget current2 = this.current;
        this.current = current;
        this.callback.onFrameReady(current.index);
        if (current2 != null) {
            this.handler.obtainMessage(n, (Object)current2).sendToTarget();
        }
        this.isLoadPending = false;
        this.loadNextFrame();
    }
    
    public void setFrameTransformation(final Transformation transformation) {
        if (transformation != null) {
            this.requestBuilder = this.requestBuilder.transform(transformation);
            return;
        }
        throw new NullPointerException("Transformation must not be null");
    }
    
    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.isCleared = false;
        this.loadNextFrame();
    }
    
    public void stop() {
        this.isRunning = false;
    }
}
