// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import com.bumptech.glide.Priority;
import java.io.IOException;
import android.util.Log;
import android.net.Uri;
import android.content.Context;

public abstract class LocalUriFetcher implements DataFetcher
{
    private static final String TAG = "LocalUriFetcher";
    private final Context context;
    private Object data;
    private final Uri uri;
    
    public LocalUriFetcher(final Context context, final Uri uri) {
        this.context = context.getApplicationContext();
        this.uri = uri;
    }
    
    public void cancel() {
    }
    
    public void cleanup() {
        final Object data = this.data;
        if (data != null) {
            try {
                this.close(data);
            }
            catch (IOException ex) {
                if (Log.isLoggable("LocalUriFetcher", 2)) {
                    Log.v("LocalUriFetcher", "failed to close data", (Throwable)ex);
                }
            }
        }
    }
    
    protected abstract void close(final Object p0);
    
    public String getId() {
        return this.uri.toString();
    }
    
    public final Object loadData(final Priority priority) {
        return this.data = this.loadResource(this.uri, this.context.getContentResolver());
    }
    
    protected abstract Object loadResource(final Uri p0, final ContentResolver p1);
}
