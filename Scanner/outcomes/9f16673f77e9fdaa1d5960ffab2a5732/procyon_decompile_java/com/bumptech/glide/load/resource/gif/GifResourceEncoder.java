// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.gifencoder.AnimatedGifEncoder;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import android.util.Log;
import java.io.OutputStream;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.Transformation;
import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.ResourceEncoder;

public class GifResourceEncoder implements ResourceEncoder
{
    private static final GifResourceEncoder$Factory FACTORY;
    private static final String TAG = "GifEncoder";
    private final BitmapPool bitmapPool;
    private final GifResourceEncoder$Factory factory;
    private final GifDecoder$BitmapProvider provider;
    
    static {
        FACTORY = new GifResourceEncoder$Factory();
    }
    
    public GifResourceEncoder(final BitmapPool bitmapPool) {
        this(bitmapPool, GifResourceEncoder.FACTORY);
    }
    
    GifResourceEncoder(final BitmapPool bitmapPool, final GifResourceEncoder$Factory factory) {
        this.bitmapPool = bitmapPool;
        this.provider = new GifBitmapProvider(bitmapPool);
        this.factory = factory;
    }
    
    private GifDecoder decodeHeaders(final byte[] data) {
        final GifHeaderParser buildParser = this.factory.buildParser();
        buildParser.setData(data);
        final GifHeader header = buildParser.parseHeader();
        final GifDecoder buildDecoder = this.factory.buildDecoder(this.provider);
        buildDecoder.setData(header, data);
        buildDecoder.advance();
        return buildDecoder;
    }
    
    private Resource getTransformedFrame(final Bitmap bitmap, final Transformation transformation, final GifDrawable gifDrawable) {
        final Resource buildFrameResource = this.factory.buildFrameResource(bitmap, this.bitmapPool);
        final Resource transform = transformation.transform(buildFrameResource, gifDrawable.getIntrinsicWidth(), gifDrawable.getIntrinsicHeight());
        if (!buildFrameResource.equals(transform)) {
            buildFrameResource.recycle();
        }
        return transform;
    }
    
    private boolean writeDataDirect(final byte[] array, final OutputStream outputStream) {
        boolean b = true;
        try {
            outputStream.write(array);
        }
        catch (IOException ex) {
            if (Log.isLoggable("GifEncoder", 3)) {
                Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", (Throwable)ex);
            }
            b = false;
        }
        return b;
    }
    
    public boolean encode(final Resource resource, final OutputStream outputStream) {
        final long logTime = LogTime.getLogTime();
        final GifDrawable gifDrawable = (GifDrawable)resource.get();
        final Transformation frameTransformation = gifDrawable.getFrameTransformation();
        if (frameTransformation instanceof UnitTransformation) {
            return this.writeDataDirect(gifDrawable.getData(), outputStream);
        }
        final GifDecoder decodeHeaders = this.decodeHeaders(gifDrawable.getData());
        final AnimatedGifEncoder buildEncoder = this.factory.buildEncoder();
        if (!buildEncoder.start(outputStream)) {
            return false;
        }
        int i = 0;
        while (i < decodeHeaders.getFrameCount()) {
            final Resource transformedFrame = this.getTransformedFrame(decodeHeaders.getNextFrame(), frameTransformation, gifDrawable);
            try {
                if (!buildEncoder.addFrame((Bitmap)transformedFrame.get())) {
                    return false;
                }
                buildEncoder.setDelay(decodeHeaders.getDelay(decodeHeaders.getCurrentFrameIndex()));
                decodeHeaders.advance();
                transformedFrame.recycle();
                ++i;
                continue;
            }
            finally {
                transformedFrame.recycle();
            }
            break;
        }
        final boolean finish = buildEncoder.finish();
        if (Log.isLoggable("GifEncoder", 2)) {
            final String s = "GifEncoder";
            final StringBuilder sb = new StringBuilder();
            sb.append("Encoded gif with ");
            sb.append(decodeHeaders.getFrameCount());
            sb.append(" frames and ");
            sb.append(gifDrawable.getData().length);
            sb.append(" bytes in ");
            sb.append(LogTime.getElapsedMillis(logTime));
            sb.append(" ms");
            Log.v(s, sb.toString());
        }
        return finish;
    }
    
    public String getId() {
        return "";
    }
}
