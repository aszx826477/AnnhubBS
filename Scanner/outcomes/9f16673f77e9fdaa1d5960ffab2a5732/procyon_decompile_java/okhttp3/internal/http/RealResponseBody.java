// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.http;

import okhttp3.MediaType;
import okio.BufferedSource;
import okhttp3.Headers;
import okhttp3.ResponseBody;

public final class RealResponseBody extends ResponseBody
{
    private final Headers headers;
    private final BufferedSource source;
    
    public RealResponseBody(final Headers headers, final BufferedSource source) {
        this.headers = headers;
        this.source = source;
    }
    
    public long contentLength() {
        return HttpHeaders.contentLength(this.headers);
    }
    
    public MediaType contentType() {
        final String value = this.headers.get("Content-Type");
        MediaType parse;
        if (value != null) {
            parse = MediaType.parse(value);
        }
        else {
            parse = null;
        }
        return parse;
    }
    
    public BufferedSource source() {
        return this.source;
    }
}
