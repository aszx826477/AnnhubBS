// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okhttp3.internal.Util;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.DiskLruCache$Editor;
import okhttp3.internal.io.FileSystem;
import java.io.File;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.cache.DiskLruCache;
import java.io.Flushable;
import java.io.Closeable;
import java.util.NoSuchElementException;
import okio.BufferedSource;
import okio.Source;
import java.io.IOException;
import okio.Okio;
import okhttp3.internal.cache.DiskLruCache$Snapshot;
import java.util.Iterator;

class Cache$2 implements Iterator
{
    boolean canRemove;
    final Iterator delegate;
    String nextUrl;
    final /* synthetic */ Cache this$0;
    
    Cache$2(final Cache this$0) {
        this.this$0 = this$0;
        this.delegate = this.this$0.cache.snapshots();
    }
    
    public boolean hasNext() {
        final String nextUrl = this.nextUrl;
        final boolean b = true;
        if (nextUrl != null) {
            return b;
        }
        this.canRemove = false;
        while (this.delegate.hasNext()) {
            final DiskLruCache$Snapshot diskLruCache$Snapshot = this.delegate.next();
            try {
                final Source source = diskLruCache$Snapshot.getSource(0);
                try {
                    final BufferedSource buffer = Okio.buffer(source);
                    try {
                        this.nextUrl = buffer.readUtf8LineStrict();
                        return b;
                    }
                    catch (IOException ex) {}
                }
                catch (IOException ex2) {}
            }
            catch (IOException ex3) {}
            break;
        }
        return false;
    }
    
    public String next() {
        if (this.hasNext()) {
            final String nextUrl = this.nextUrl;
            this.nextUrl = null;
            this.canRemove = true;
            return nextUrl;
        }
        throw new NoSuchElementException();
    }
    
    public void remove() {
        if (this.canRemove) {
            this.delegate.remove();
            return;
        }
        throw new IllegalStateException("remove() before next()");
    }
}
