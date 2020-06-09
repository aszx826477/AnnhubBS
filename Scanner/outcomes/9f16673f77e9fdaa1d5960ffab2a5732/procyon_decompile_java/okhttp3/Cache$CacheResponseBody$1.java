// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okio.Source;
import okhttp3.internal.cache.DiskLruCache$Snapshot;
import okio.ForwardingSource;

class Cache$CacheResponseBody$1 extends ForwardingSource
{
    final /* synthetic */ Cache$CacheResponseBody this$0;
    final /* synthetic */ DiskLruCache$Snapshot val$snapshot;
    
    Cache$CacheResponseBody$1(final Cache$CacheResponseBody this$0, final Source source, final DiskLruCache$Snapshot val$snapshot) {
        this.this$0 = this$0;
        this.val$snapshot = val$snapshot;
        super(source);
    }
    
    public void close() {
        this.val$snapshot.close();
        super.close();
    }
}
