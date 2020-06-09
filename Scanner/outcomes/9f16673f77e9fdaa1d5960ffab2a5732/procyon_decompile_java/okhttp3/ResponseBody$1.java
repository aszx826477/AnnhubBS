// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okio.BufferedSource;

final class ResponseBody$1 extends ResponseBody
{
    final /* synthetic */ BufferedSource val$content;
    final /* synthetic */ long val$contentLength;
    final /* synthetic */ MediaType val$contentType;
    
    ResponseBody$1(final MediaType val$contentType, final long val$contentLength, final BufferedSource val$content) {
        this.val$contentType = val$contentType;
        this.val$contentLength = val$contentLength;
        this.val$content = val$content;
    }
    
    public long contentLength() {
        return this.val$contentLength;
    }
    
    public MediaType contentType() {
        return this.val$contentType;
    }
    
    public BufferedSource source() {
        return this.val$content;
    }
}
