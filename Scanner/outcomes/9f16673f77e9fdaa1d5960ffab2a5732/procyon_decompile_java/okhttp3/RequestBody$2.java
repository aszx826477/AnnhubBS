// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okio.BufferedSink;

final class RequestBody$2 extends RequestBody
{
    final /* synthetic */ int val$byteCount;
    final /* synthetic */ byte[] val$content;
    final /* synthetic */ MediaType val$contentType;
    final /* synthetic */ int val$offset;
    
    RequestBody$2(final MediaType val$contentType, final int val$byteCount, final byte[] val$content, final int val$offset) {
        this.val$contentType = val$contentType;
        this.val$byteCount = val$byteCount;
        this.val$content = val$content;
        this.val$offset = val$offset;
    }
    
    public long contentLength() {
        return this.val$byteCount;
    }
    
    public MediaType contentType() {
        return this.val$contentType;
    }
    
    public void writeTo(final BufferedSink bufferedSink) {
        bufferedSink.write(this.val$content, this.val$offset, this.val$byteCount);
    }
}
