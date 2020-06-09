// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.data;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import com.bumptech.glide.Priority;

public class ByteArrayFetcher implements DataFetcher
{
    private final byte[] bytes;
    private final String id;
    
    public ByteArrayFetcher(final byte[] bytes, final String id) {
        this.bytes = bytes;
        this.id = id;
    }
    
    public void cancel() {
    }
    
    public void cleanup() {
    }
    
    public String getId() {
        return this.id;
    }
    
    public InputStream loadData(final Priority priority) {
        return new ByteArrayInputStream(this.bytes);
    }
}
