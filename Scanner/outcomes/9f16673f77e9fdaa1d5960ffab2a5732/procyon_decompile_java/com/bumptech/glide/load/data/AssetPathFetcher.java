// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import java.io.IOException;
import android.util.Log;
import android.content.res.AssetManager;

public abstract class AssetPathFetcher implements DataFetcher
{
    private static final String TAG = "AssetUriFetcher";
    private final AssetManager assetManager;
    private final String assetPath;
    private Object data;
    
    public AssetPathFetcher(final AssetManager assetManager, final String assetPath) {
        this.assetManager = assetManager;
        this.assetPath = assetPath;
    }
    
    public void cancel() {
    }
    
    public void cleanup() {
        final Object data = this.data;
        if (data == null) {
            return;
        }
        try {
            this.close(data);
        }
        catch (IOException ex) {
            if (Log.isLoggable("AssetUriFetcher", 2)) {
                Log.v("AssetUriFetcher", "Failed to close data", (Throwable)ex);
            }
        }
    }
    
    protected abstract void close(final Object p0);
    
    public String getId() {
        return this.assetPath;
    }
    
    public Object loadData(final Priority priority) {
        return this.data = this.loadResource(this.assetManager, this.assetPath);
    }
    
    protected abstract Object loadResource(final AssetManager p0, final String p1);
}
