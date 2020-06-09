// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.cache;

import okhttp3.Response;
import okhttp3.Request;

public interface InternalCache
{
    Response get(final Request p0);
    
    CacheRequest put(final Response p0);
    
    void remove(final Request p0);
    
    void trackConditionalCacheHit();
    
    void trackResponse(final CacheStrategy p0);
    
    void update(final Response p0, final Response p1);
}
