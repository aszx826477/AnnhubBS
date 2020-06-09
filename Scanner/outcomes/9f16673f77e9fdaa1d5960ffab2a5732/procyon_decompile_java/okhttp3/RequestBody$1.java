// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okio.BufferedSink;
import okio.ByteString;

final class RequestBody$1 extends RequestBody
{
    final /* synthetic */ ByteString val$content;
    final /* synthetic */ MediaType val$contentType;
    
    RequestBody$1(final MediaType val$contentType, final ByteString val$content) {
        this.val$contentType = val$contentType;
        this.val$content = val$content;
    }
    
    public long contentLength() {
        return this.val$content.size();
    }
    
    public MediaType contentType() {
        return this.val$contentType;
    }
    
    public void writeTo(final BufferedSink bufferedSink) {
        bufferedSink.write(this.val$content);
    }
}
