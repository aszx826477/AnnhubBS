// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gif;

import android.graphics.ColorFilter;
import android.os.Build$VERSION;
import android.graphics.drawable.Drawable$ConstantState;
import android.view.Gravity;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;

public class GifDrawable extends GlideDrawable implements GifFrameLoader$FrameCallback
{
    private boolean applyGravity;
    private final GifDecoder decoder;
    private final Rect destRect;
    private final GifFrameLoader frameLoader;
    private boolean isRecycled;
    private boolean isRunning;
    private boolean isStarted;
    private boolean isVisible;
    private int loopCount;
    private int maxLoopCount;
    private final Paint paint;
    private final GifDrawable$GifState state;
    
    public GifDrawable(final Context context, final GifDecoder$BitmapProvider gifDecoder$BitmapProvider, final BitmapPool bitmapPool, final Transformation transformation, final int n, final int n2, final GifHeader gifHeader, final byte[] array, final Bitmap bitmap) {
        this(new GifDrawable$GifState(gifHeader, array, context, transformation, n, n2, gifDecoder$BitmapProvider, bitmapPool, bitmap));
    }
    
    GifDrawable(final GifDecoder decoder, final GifFrameLoader frameLoader, final Bitmap firstFrame, final BitmapPool bitmapPool, final Paint paint) {
        this.destRect = new Rect();
        this.isVisible = true;
        this.maxLoopCount = -1;
        this.decoder = decoder;
        this.frameLoader = frameLoader;
        this.state = new GifDrawable$GifState(null);
        this.paint = paint;
        final GifDrawable$GifState state = this.state;
        state.bitmapPool = bitmapPool;
        state.firstFrame = firstFrame;
    }
    
    GifDrawable(final GifDrawable$GifState state) {
        this.destRect = new Rect();
        this.isVisible = true;
        this.maxLoopCount = -1;
        if (state != null) {
            this.state = state;
            this.decoder = new GifDecoder(state.bitmapProvider);
            this.paint = new Paint();
            this.decoder.setData(state.gifHeader, state.data);
            (this.frameLoader = new GifFrameLoader(state.context, this, this.decoder, state.targetWidth, state.targetHeight)).setFrameTransformation(state.frameTransformation);
            return;
        }
        throw new NullPointerException("GifState must not be null");
    }
    
    public GifDrawable(final GifDrawable gifDrawable, final Bitmap bitmap, final Transformation transformation) {
        this(new GifDrawable$GifState(gifDrawable.state.gifHeader, gifDrawable.state.data, gifDrawable.state.context, transformation, gifDrawable.state.targetWidth, gifDrawable.state.targetHeight, gifDrawable.state.bitmapProvider, gifDrawable.state.bitmapPool, bitmap));
    }
    
    private void reset() {
        this.frameLoader.clear();
        this.invalidateSelf();
    }
    
    private void resetLoopCount() {
        this.loopCount = 0;
    }
    
    private void startRunning() {
        final int frameCount = this.decoder.getFrameCount();
        final boolean isRunning = true;
        if (frameCount == (isRunning ? 1 : 0)) {
            this.invalidateSelf();
        }
        else if (!this.isRunning) {
            this.isRunning = isRunning;
            this.frameLoader.start();
            this.invalidateSelf();
        }
    }
    
    private void stopRunning() {
        this.isRunning = false;
        this.frameLoader.stop();
    }
    
    public void draw(final Canvas canvas) {
        if (this.isRecycled) {
            return;
        }
        if (this.applyGravity) {
            Gravity.apply(119, this.getIntrinsicWidth(), this.getIntrinsicHeight(), this.getBounds(), this.destRect);
            this.applyGravity = false;
        }
        final Bitmap currentFrame = this.frameLoader.getCurrentFrame();
        Bitmap firstFrame;
        if (currentFrame != null) {
            firstFrame = currentFrame;
        }
        else {
            firstFrame = this.state.firstFrame;
        }
        canvas.drawBitmap(firstFrame, (Rect)null, this.destRect, this.paint);
    }
    
    public Drawable$ConstantState getConstantState() {
        return this.state;
    }
    
    public byte[] getData() {
        return this.state.data;
    }
    
    public GifDecoder getDecoder() {
        return this.decoder;
    }
    
    public Bitmap getFirstFrame() {
        return this.state.firstFrame;
    }
    
    public int getFrameCount() {
        return this.decoder.getFrameCount();
    }
    
    public Transformation getFrameTransformation() {
        return this.state.frameTransformation;
    }
    
    public int getIntrinsicHeight() {
        return this.state.firstFrame.getHeight();
    }
    
    public int getIntrinsicWidth() {
        return this.state.firstFrame.getWidth();
    }
    
    public int getOpacity() {
        return -2;
    }
    
    public boolean isAnimated() {
        return true;
    }
    
    boolean isRecycled() {
        return this.isRecycled;
    }
    
    public boolean isRunning() {
        return this.isRunning;
    }
    
    protected void onBoundsChange(final Rect rect) {
        super.onBoundsChange(rect);
        this.applyGravity = true;
    }
    
    public void onFrameReady(final int n) {
        if (Build$VERSION.SDK_INT >= 11 && this.getCallback() == null) {
            this.stop();
            this.reset();
            return;
        }
        this.invalidateSelf();
        if (n == this.decoder.getFrameCount() - 1) {
            ++this.loopCount;
        }
        final int maxLoopCount = this.maxLoopCount;
        if (maxLoopCount != -1 && this.loopCount >= maxLoopCount) {
            this.stop();
        }
    }
    
    public void recycle() {
        this.isRecycled = true;
        this.state.bitmapPool.put(this.state.firstFrame);
        this.frameLoader.clear();
        this.frameLoader.stop();
    }
    
    public void setAlpha(final int alpha) {
        this.paint.setAlpha(alpha);
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }
    
    public void setFrameTransformation(final Transformation transformation, final Bitmap firstFrame) {
        if (firstFrame == null) {
            throw new NullPointerException("The first frame of the GIF must not be null");
        }
        if (transformation != null) {
            final GifDrawable$GifState state = this.state;
            state.frameTransformation = transformation;
            state.firstFrame = firstFrame;
            this.frameLoader.setFrameTransformation(transformation);
            return;
        }
        throw new NullPointerException("The frame transformation must not be null");
    }
    
    void setIsRunning(final boolean isRunning) {
        this.isRunning = isRunning;
    }
    
    public void setLoopCount(final int maxLoopCount) {
        if (maxLoopCount <= 0 && maxLoopCount != -1 && maxLoopCount != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (maxLoopCount == 0) {
            this.maxLoopCount = this.decoder.getLoopCount();
        }
        else {
            this.maxLoopCount = maxLoopCount;
        }
    }
    
    public boolean setVisible(final boolean isVisible, final boolean b) {
        if (!(this.isVisible = isVisible)) {
            this.stopRunning();
        }
        else if (this.isStarted) {
            this.startRunning();
        }
        return super.setVisible(isVisible, b);
    }
    
    public void start() {
        this.isStarted = true;
        this.resetLoopCount();
        if (this.isVisible) {
            this.startRunning();
        }
    }
    
    public void stop() {
        this.isStarted = false;
        this.stopRunning();
        if (Build$VERSION.SDK_INT < 11) {
            this.reset();
        }
    }
}
