// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.Glide;
import android.content.Context;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.ResourceDecoder;

public class GifResourceDecoder implements ResourceDecoder
{
    private static final GifResourceDecoder$GifDecoderPool DECODER_POOL;
    private static final GifResourceDecoder$GifHeaderParserPool PARSER_POOL;
    private static final String TAG = "GifResourceDecoder";
    private final BitmapPool bitmapPool;
    private final Context context;
    private final GifResourceDecoder$GifDecoderPool decoderPool;
    private final GifResourceDecoder$GifHeaderParserPool parserPool;
    private final GifBitmapProvider provider;
    
    static {
        PARSER_POOL = new GifResourceDecoder$GifHeaderParserPool();
        DECODER_POOL = new GifResourceDecoder$GifDecoderPool();
    }
    
    public GifResourceDecoder(final Context context) {
        this(context, Glide.get(context).getBitmapPool());
    }
    
    public GifResourceDecoder(final Context context, final BitmapPool bitmapPool) {
        this(context, bitmapPool, GifResourceDecoder.PARSER_POOL, GifResourceDecoder.DECODER_POOL);
    }
    
    GifResourceDecoder(final Context context, final BitmapPool bitmapPool, final GifResourceDecoder$GifHeaderParserPool parserPool, final GifResourceDecoder$GifDecoderPool decoderPool) {
        this.context = context;
        this.bitmapPool = bitmapPool;
        this.decoderPool = decoderPool;
        this.provider = new GifBitmapProvider(bitmapPool);
        this.parserPool = parserPool;
    }
    
    private GifDrawableResource decode(final byte[] array, final int n, final int n2, final GifHeaderParser gifHeaderParser, final GifDecoder gifDecoder) {
        final GifHeader header = gifHeaderParser.parseHeader();
        if (header.getNumFrames() <= 0 || header.getStatus() != 0) {
            return null;
        }
        final Bitmap decodeFirstFrame = this.decodeFirstFrame(gifDecoder, header, array);
        if (decodeFirstFrame == null) {
            return null;
        }
        return new GifDrawableResource(new GifDrawable(this.context, this.provider, this.bitmapPool, UnitTransformation.get(), n, n2, header, array, decodeFirstFrame));
    }
    
    private Bitmap decodeFirstFrame(final GifDecoder gifDecoder, final GifHeader gifHeader, final byte[] array) {
        gifDecoder.setData(gifHeader, array);
        gifDecoder.advance();
        return gifDecoder.getNextFrame();
    }
    
    private static byte[] inputStreamToBytes(final InputStream inputStream) {
        final int n = 16384;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n);
        try {
            final byte[] array = new byte[n];
            int read;
            while ((read = inputStream.read(array)) != -1) {
                byteArrayOutputStream.write(array, 0, read);
            }
            byteArrayOutputStream.flush();
        }
        catch (IOException ex) {
            Log.w("GifResourceDecoder", "Error reading data from stream", (Throwable)ex);
        }
        return byteArrayOutputStream.toByteArray();
    }
    
    public GifDrawableResource decode(final InputStream inputStream, final int n, final int n2) {
        final byte[] inputStreamToBytes = inputStreamToBytes(inputStream);
        final GifHeaderParser obtain = this.parserPool.obtain(inputStreamToBytes);
        final GifDecoder obtain2 = this.decoderPool.obtain(this.provider);
        final byte[] array = inputStreamToBytes;
        final GifHeaderParser gifHeaderParser = obtain;
        try {
            return this.decode(array, n, n2, gifHeaderParser, obtain2);
        }
        finally {
            this.parserPool.release(obtain);
            this.decoderPool.release(obtain2);
        }
    }
    
    public String getId() {
        return "";
    }
}
