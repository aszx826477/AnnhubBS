// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.util.Iterator;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache$Snapshot;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okio.BufferedSource;
import java.io.IOException;
import okhttp3.internal.cache.DiskLruCache$Editor;
import okhttp3.internal.io.FileSystem;
import java.io.File;
import okhttp3.internal.cache.DiskLruCache;
import java.io.Flushable;
import java.io.Closeable;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.InternalCache;

class Cache$1 implements InternalCache
{
    final /* synthetic */ Cache this$0;
    
    Cache$1(final Cache this$0) {
        this.this$0 = this$0;
    }
    
    public Response get(final Request request) {
        return this.this$0.get(request);
    }
    
    public CacheRequest put(final Response response) {
        return this.this$0.put(response);
    }
    
    public void remove(final Request request) {
        this.this$0.remove(request);
    }
    
    public void trackConditionalCacheHit() {
        this.this$0.trackConditionalCacheHit();
    }
    
    public void trackResponse(final CacheStrategy cacheStrategy) {
        this.this$0.trackResponse(cacheStrategy);
    }
    
    public void update(final Response response, final Response response2) {
        this.this$0.update(response, response2);
    }
}
