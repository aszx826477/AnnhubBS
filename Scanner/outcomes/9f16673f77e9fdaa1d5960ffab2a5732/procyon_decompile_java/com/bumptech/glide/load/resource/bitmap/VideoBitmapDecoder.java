// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import android.media.MediaMetadataRetriever;
import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import android.os.ParcelFileDescriptor;

public class VideoBitmapDecoder implements BitmapDecoder
{
    private static final VideoBitmapDecoder$MediaMetadataRetrieverFactory DEFAULT_FACTORY;
    private static final int NO_FRAME = 255;
    private VideoBitmapDecoder$MediaMetadataRetrieverFactory factory;
    private int frame;
    
    static {
        DEFAULT_FACTORY = new VideoBitmapDecoder$MediaMetadataRetrieverFactory();
    }
    
    public VideoBitmapDecoder() {
        this(VideoBitmapDecoder.DEFAULT_FACTORY, -1);
    }
    
    public VideoBitmapDecoder(final int n) {
        this(VideoBitmapDecoder.DEFAULT_FACTORY, checkValidFrame(n));
    }
    
    VideoBitmapDecoder(final VideoBitmapDecoder$MediaMetadataRetrieverFactory videoBitmapDecoder$MediaMetadataRetrieverFactory) {
        this(videoBitmapDecoder$MediaMetadataRetrieverFactory, -1);
    }
    
    VideoBitmapDecoder(final VideoBitmapDecoder$MediaMetadataRetrieverFactory factory, final int frame) {
        this.factory = factory;
        this.frame = frame;
    }
    
    private static int checkValidFrame(final int n) {
        if (n >= 0) {
            return n;
        }
        throw new IllegalArgumentException("Requested frame must be non-negative");
    }
    
    public Bitmap decode(final ParcelFileDescriptor parcelFileDescriptor, final BitmapPool bitmapPool, final int n, final int n2, final DecodeFormat decodeFormat) {
        final MediaMetadataRetriever build = this.factory.build();
        build.setDataSource(parcelFileDescriptor.getFileDescriptor());
        final int frame = this.frame;
        Bitmap bitmap;
        if (frame >= 0) {
            bitmap = build.getFrameAtTime((long)frame);
        }
        else {
            bitmap = build.getFrameAtTime();
        }
        build.release();
        parcelFileDescriptor.close();
        return bitmap;
    }
    
    public String getId() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
