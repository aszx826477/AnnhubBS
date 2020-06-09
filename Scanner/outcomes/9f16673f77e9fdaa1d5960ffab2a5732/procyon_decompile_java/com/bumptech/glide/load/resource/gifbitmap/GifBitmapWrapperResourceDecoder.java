// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.util.ByteArrayPool;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.io.InputStream;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.ResourceDecoder;

public class GifBitmapWrapperResourceDecoder implements ResourceDecoder
{
    private static final GifBitmapWrapperResourceDecoder$ImageTypeParser DEFAULT_PARSER;
    private static final GifBitmapWrapperResourceDecoder$BufferedStreamFactory DEFAULT_STREAM_FACTORY;
    static final int MARK_LIMIT_BYTES = 2048;
    private final ResourceDecoder bitmapDecoder;
    private final BitmapPool bitmapPool;
    private final ResourceDecoder gifDecoder;
    private String id;
    private final GifBitmapWrapperResourceDecoder$ImageTypeParser parser;
    private final GifBitmapWrapperResourceDecoder$BufferedStreamFactory streamFactory;
    
    static {
        DEFAULT_PARSER = new GifBitmapWrapperResourceDecoder$ImageTypeParser();
        DEFAULT_STREAM_FACTORY = new GifBitmapWrapperResourceDecoder$BufferedStreamFactory();
    }
    
    public GifBitmapWrapperResourceDecoder(final ResourceDecoder resourceDecoder, final ResourceDecoder resourceDecoder2, final BitmapPool bitmapPool) {
        this(resourceDecoder, resourceDecoder2, bitmapPool, GifBitmapWrapperResourceDecoder.DEFAULT_PARSER, GifBitmapWrapperResourceDecoder.DEFAULT_STREAM_FACTORY);
    }
    
    GifBitmapWrapperResourceDecoder(final ResourceDecoder bitmapDecoder, final ResourceDecoder gifDecoder, final BitmapPool bitmapPool, final GifBitmapWrapperResourceDecoder$ImageTypeParser parser, final GifBitmapWrapperResourceDecoder$BufferedStreamFactory streamFactory) {
        this.bitmapDecoder = bitmapDecoder;
        this.gifDecoder = gifDecoder;
        this.bitmapPool = bitmapPool;
        this.parser = parser;
        this.streamFactory = streamFactory;
    }
    
    private GifBitmapWrapper decode(final ImageVideoWrapper imageVideoWrapper, final int n, final int n2, final byte[] array) {
        GifBitmapWrapper gifBitmapWrapper;
        if (imageVideoWrapper.getStream() != null) {
            gifBitmapWrapper = this.decodeStream(imageVideoWrapper, n, n2, array);
        }
        else {
            gifBitmapWrapper = this.decodeBitmapWrapper(imageVideoWrapper, n, n2);
        }
        return gifBitmapWrapper;
    }
    
    private GifBitmapWrapper decodeBitmapWrapper(final ImageVideoWrapper imageVideoWrapper, final int n, final int n2) {
        GifBitmapWrapper gifBitmapWrapper = null;
        final Resource decode = this.bitmapDecoder.decode(imageVideoWrapper, n, n2);
        if (decode != null) {
            gifBitmapWrapper = new GifBitmapWrapper(decode, null);
        }
        return gifBitmapWrapper;
    }
    
    private GifBitmapWrapper decodeGifWrapper(final InputStream inputStream, final int n, final int n2) {
        GifBitmapWrapper gifBitmapWrapper = null;
        final Resource decode = this.gifDecoder.decode(inputStream, n, n2);
        if (decode != null) {
            final GifDrawable gifDrawable = (GifDrawable)decode.get();
            if (gifDrawable.getFrameCount() > 1) {
                gifBitmapWrapper = new GifBitmapWrapper(null, decode);
            }
            else {
                gifBitmapWrapper = new GifBitmapWrapper(new BitmapResource(gifDrawable.getFirstFrame(), this.bitmapPool), null);
            }
        }
        return gifBitmapWrapper;
    }
    
    private GifBitmapWrapper decodeStream(final ImageVideoWrapper imageVideoWrapper, final int n, final int n2, final byte[] array) {
        final InputStream build = this.streamFactory.build(imageVideoWrapper.getStream(), array);
        build.mark(2048);
        final ImageHeaderParser$ImageType parse = this.parser.parse(build);
        build.reset();
        GifBitmapWrapper gifBitmapWrapper = null;
        if (parse == ImageHeaderParser$ImageType.GIF) {
            gifBitmapWrapper = this.decodeGifWrapper(build, n, n2);
        }
        if (gifBitmapWrapper == null) {
            gifBitmapWrapper = this.decodeBitmapWrapper(new ImageVideoWrapper(build, imageVideoWrapper.getFileDescriptor()), n, n2);
        }
        return gifBitmapWrapper;
    }
    
    public Resource decode(final ImageVideoWrapper imageVideoWrapper, final int n, final int n2) {
        final ByteArrayPool value = ByteArrayPool.get();
        final byte[] bytes = value.getBytes();
        try {
            final GifBitmapWrapper decode = this.decode(imageVideoWrapper, n, n2, bytes);
            value.releaseBytes(bytes);
            Resource resource;
            if (decode != null) {
                resource = new GifBitmapWrapperResource(decode);
            }
            else {
                resource = null;
            }
            return resource;
        }
        finally {
            value.releaseBytes(bytes);
        }
    }
    
    public String getId() {
        if (this.id == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.gifDecoder.getId());
            sb.append(this.bitmapDecoder.getId());
            this.id = sb.toString();
        }
        return this.id;
    }
}
