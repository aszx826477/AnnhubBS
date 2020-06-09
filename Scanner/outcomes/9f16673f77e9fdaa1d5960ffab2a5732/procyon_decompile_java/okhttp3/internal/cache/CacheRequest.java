// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.cache;

import okio.Sink;

public interface CacheRequest
{
    void abort();
    
    Sink body();
}
