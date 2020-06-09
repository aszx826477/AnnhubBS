// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.InputStream;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.data.DataFetcher;

class ImageVideoModelLoader$ImageVideoFetcher implements DataFetcher
{
    private final DataFetcher fileDescriptorFetcher;
    private final DataFetcher streamFetcher;
    
    public ImageVideoModelLoader$ImageVideoFetcher(final DataFetcher streamFetcher, final DataFetcher fileDescriptorFetcher) {
        this.streamFetcher = streamFetcher;
        this.fileDescriptorFetcher = fileDescriptorFetcher;
    }
    
    public void cancel() {
        final DataFetcher streamFetcher = this.streamFetcher;
        if (streamFetcher != null) {
            streamFetcher.cancel();
        }
        final DataFetcher fileDescriptorFetcher = this.fileDescriptorFetcher;
        if (fileDescriptorFetcher != null) {
            fileDescriptorFetcher.cancel();
        }
    }
    
    public void cleanup() {
        final DataFetcher streamFetcher = this.streamFetcher;
        if (streamFetcher != null) {
            streamFetcher.cleanup();
        }
        final DataFetcher fileDescriptorFetcher = this.fileDescriptorFetcher;
        if (fileDescriptorFetcher != null) {
            fileDescriptorFetcher.cleanup();
        }
    }
    
    public String getId() {
        final DataFetcher streamFetcher = this.streamFetcher;
        if (streamFetcher != null) {
            return streamFetcher.getId();
        }
        return this.fileDescriptorFetcher.getId();
    }
    
    public ImageVideoWrapper loadData(final Priority priority) {
        InputStream inputStream = null;
        final DataFetcher streamFetcher = this.streamFetcher;
        final int n = 2;
        Label_0087: {
            if (streamFetcher != null) {
                final DataFetcher dataFetcher = streamFetcher;
                try {
                    final Object loadData = dataFetcher.loadData(priority);
                    try {
                        inputStream = (InputStream)loadData;
                    }
                    catch (Exception ex) {
                        if (Log.isLoggable("IVML", n)) {
                            Log.v("IVML", "Exception fetching input stream, trying ParcelFileDescriptor", (Throwable)ex);
                        }
                        if (this.fileDescriptorFetcher != null) {
                            break Label_0087;
                        }
                        throw ex;
                    }
                }
                catch (Exception ex3) {}
            }
        }
        ParcelFileDescriptor parcelFileDescriptor = null;
        final DataFetcher fileDescriptorFetcher = this.fileDescriptorFetcher;
        if (fileDescriptorFetcher != null) {
            final DataFetcher dataFetcher2 = fileDescriptorFetcher;
            try {
                final Object loadData2 = dataFetcher2.loadData(priority);
                try {
                    parcelFileDescriptor = (ParcelFileDescriptor)loadData2;
                }
                catch (Exception ex2) {
                    if (Log.isLoggable("IVML", n)) {
                        Log.v("IVML", "Exception fetching ParcelFileDescriptor", (Throwable)ex2);
                    }
                    if (inputStream != null) {
                        return new ImageVideoWrapper(inputStream, parcelFileDescriptor);
                    }
                    throw ex2;
                }
            }
            catch (Exception ex4) {}
        }
        return new ImageVideoWrapper(inputStream, parcelFileDescriptor);
    }
}
