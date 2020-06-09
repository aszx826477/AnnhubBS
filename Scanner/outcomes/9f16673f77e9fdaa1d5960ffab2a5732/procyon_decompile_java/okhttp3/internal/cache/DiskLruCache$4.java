// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.cache;

import okio.Buffer;
import okio.Timeout;
import okio.Sink;

final class DiskLruCache$4 implements Sink
{
    public void close() {
    }
    
    public void flush() {
    }
    
    public Timeout timeout() {
        return Timeout.NONE;
    }
    
    public void write(final Buffer buffer, final long n) {
        buffer.skip(n);
    }
}
