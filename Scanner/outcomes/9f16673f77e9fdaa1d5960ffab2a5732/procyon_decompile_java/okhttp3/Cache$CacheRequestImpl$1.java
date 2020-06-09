// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.util.Iterator;
import okhttp3.internal.cache.DiskLruCache$Snapshot;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.cache.CacheStrategy;
import okio.BufferedSource;
import okhttp3.internal.io.FileSystem;
import java.io.File;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.cache.DiskLruCache;
import java.io.Flushable;
import java.io.IOException;
import java.io.Closeable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okio.Sink;
import okhttp3.internal.cache.DiskLruCache$Editor;
import okio.ForwardingSink;

class Cache$CacheRequestImpl$1 extends ForwardingSink
{
    final /* synthetic */ Cache$CacheRequestImpl this$1;
    final /* synthetic */ DiskLruCache$Editor val$editor;
    final /* synthetic */ Cache val$this$0;
    
    Cache$CacheRequestImpl$1(final Cache$CacheRequestImpl this$1, final Sink sink, final Cache val$this$0, final DiskLruCache$Editor val$editor) {
        this.this$1 = this$1;
        this.val$this$0 = val$this$0;
        this.val$editor = val$editor;
        super(sink);
    }
    
    public void close() {
        synchronized (this.this$1.this$0) {
            if (this.this$1.done) {
                return;
            }
            this.this$1.done = true;
            this.this$1.this$0.writeSuccessCount++;
            // monitorexit(this.this$1.this$0)
            super.close();
            this.val$editor.commit();
        }
    }
}
