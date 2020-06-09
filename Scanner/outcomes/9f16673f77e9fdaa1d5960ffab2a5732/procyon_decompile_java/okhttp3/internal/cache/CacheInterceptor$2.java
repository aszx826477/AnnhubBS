// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.cache;

import okio.Timeout;
import java.io.IOException;
import okio.Buffer;
import okhttp3.internal.Util;
import java.util.concurrent.TimeUnit;
import okio.BufferedSource;
import okio.BufferedSink;
import okio.Source;

class CacheInterceptor$2 implements Source
{
    boolean cacheRequestClosed;
    final /* synthetic */ CacheInterceptor this$0;
    final /* synthetic */ BufferedSink val$cacheBody;
    final /* synthetic */ CacheRequest val$cacheRequest;
    final /* synthetic */ BufferedSource val$source;
    
    CacheInterceptor$2(final CacheInterceptor this$0, final BufferedSource val$source, final CacheRequest val$cacheRequest, final BufferedSink val$cacheBody) {
        this.this$0 = this$0;
        this.val$source = val$source;
        this.val$cacheRequest = val$cacheRequest;
        this.val$cacheBody = val$cacheBody;
    }
    
    public void close() {
        if (!this.cacheRequestClosed) {
            if (!Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.cacheRequestClosed = true;
                this.val$cacheRequest.abort();
            }
        }
        this.val$source.close();
    }
    
    public long read(final Buffer buffer, final long n) {
        final boolean b = true;
        try {
            final long read = this.val$source.read(buffer, n);
            final long n2 = -1;
            if (read == n2) {
                if (!this.cacheRequestClosed) {
                    this.cacheRequestClosed = b;
                    this.val$cacheBody.close();
                }
                return n2;
            }
            buffer.copyTo(this.val$cacheBody.buffer(), buffer.size() - read, read);
            this.val$cacheBody.emitCompleteSegments();
            return read;
        }
        catch (IOException ex) {
            if (!this.cacheRequestClosed) {
                this.cacheRequestClosed = b;
                this.val$cacheRequest.abort();
            }
            throw ex;
        }
    }
    
    public Timeout timeout() {
        return this.val$source.timeout();
    }
}
