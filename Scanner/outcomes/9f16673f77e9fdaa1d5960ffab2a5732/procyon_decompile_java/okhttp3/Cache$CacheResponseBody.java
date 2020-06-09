// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okio.Source;
import okio.Okio;
import okhttp3.internal.cache.DiskLruCache$Snapshot;
import okio.BufferedSource;

class Cache$CacheResponseBody extends ResponseBody
{
    private final BufferedSource bodySource;
    private final String contentLength;
    private final String contentType;
    private final DiskLruCache$Snapshot snapshot;
    
    public Cache$CacheResponseBody(final DiskLruCache$Snapshot snapshot, final String contentType, final String contentLength) {
        this.snapshot = snapshot;
        this.contentType = contentType;
        this.contentLength = contentLength;
        this.bodySource = Okio.buffer(new Cache$CacheResponseBody$1(this, snapshot.getSource(1), snapshot));
    }
    
    public long contentLength() {
        long long1 = -1;
        try {
            if (this.contentLength == null) {
                return long1;
            }
            final String contentLength = this.contentLength;
            try {
                long1 = Long.parseLong(contentLength);
                return long1;
            }
            catch (NumberFormatException ex) {
                return long1;
            }
        }
        catch (NumberFormatException ex2) {}
    }
    
    public MediaType contentType() {
        final String contentType = this.contentType;
        MediaType parse;
        if (contentType != null) {
            parse = MediaType.parse(contentType);
        }
        else {
            parse = null;
        }
        return parse;
    }
    
    public BufferedSource source() {
        return this.bodySource;
    }
}
