// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.http;

import okhttp3.Response$Builder;
import okhttp3.ResponseBody;
import okhttp3.Response;
import okio.Sink;
import okhttp3.Request;

public interface HttpStream
{
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;
    
    void cancel();
    
    Sink createRequestBody(final Request p0, final long p1);
    
    void finishRequest();
    
    ResponseBody openResponseBody(final Response p0);
    
    Response$Builder readResponseHeaders();
    
    void writeRequestHeaders(final Request p0);
}
