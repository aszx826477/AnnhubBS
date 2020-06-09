// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.Resource;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.Glide;
import android.content.Context;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.ResourceDecoder;

public class FileDescriptorBitmapDecoder implements ResourceDecoder
{
    private final VideoBitmapDecoder bitmapDecoder;
    private final BitmapPool bitmapPool;
    private DecodeFormat decodeFormat;
    
    public FileDescriptorBitmapDecoder(final Context context) {
        this(Glide.get(context).getBitmapPool(), DecodeFormat.DEFAULT);
    }
    
    public FileDescriptorBitmapDecoder(final Context context, final DecodeFormat decodeFormat) {
        this(Glide.get(context).getBitmapPool(), decodeFormat);
    }
    
    public FileDescriptorBitmapDecoder(final BitmapPool bitmapPool, final DecodeFormat decodeFormat) {
        this(new VideoBitmapDecoder(), bitmapPool, decodeFormat);
    }
    
    public FileDescriptorBitmapDecoder(final VideoBitmapDecoder bitmapDecoder, final BitmapPool bitmapPool, final DecodeFormat decodeFormat) {
        this.bitmapDecoder = bitmapDecoder;
        this.bitmapPool = bitmapPool;
        this.decodeFormat = decodeFormat;
    }
    
    public Resource decode(final ParcelFileDescriptor parcelFileDescriptor, final int n, final int n2) {
        return BitmapResource.obtain(this.bitmapDecoder.decode(parcelFileDescriptor, this.bitmapPool, n, n2, this.decodeFormat), this.bitmapPool);
    }
    
    public String getId() {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }
}
