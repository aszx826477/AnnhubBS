// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.cache;

import okio.Buffer;
import okio.BufferedSource;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

final class CacheInterceptor$1 extends ResponseBody
{
    public long contentLength() {
        return 0L;
    }
    
    public MediaType contentType() {
        return null;
    }
    
    public BufferedSource source() {
        return new Buffer();
    }
}
