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
import okhttp3.internal.cache.DiskLruCache$Editor;
import okio.Sink;
import okhttp3.internal.cache.CacheRequest;

final class Cache$CacheRequestImpl implements CacheRequest
{
    private Sink body;
    private Sink cacheOut;
    private boolean done;
    private final DiskLruCache$Editor editor;
    final /* synthetic */ Cache this$0;
    
    public Cache$CacheRequestImpl(final Cache this$0, final DiskLruCache$Editor editor) {
        this.this$0 = this$0;
        this.editor = editor;
        this.cacheOut = editor.newSink(1);
        this.body = new Cache$CacheRequestImpl$1(this, this.cacheOut, this$0, editor);
    }
    
    public void abort() {
        Object o = this.this$0;
        synchronized (o) {
            if (this.done) {
                return;
            }
            this.done = true;
            this.this$0.writeAbortCount++;
            // monitorexit(o)
            o = this.cacheOut;
            Util.closeQuietly((Closeable)o);
            try {
                o = this.editor;
                try {
                    ((DiskLruCache$Editor)o).abort();
                }
                catch (IOException ex) {}
            }
            catch (IOException ex2) {}
        }
    }
    
    public Sink body() {
        return this.body;
    }
}
