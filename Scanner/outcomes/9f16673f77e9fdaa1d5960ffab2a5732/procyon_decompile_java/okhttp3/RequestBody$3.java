// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.io.Closeable;
import okhttp3.internal.Util;
import okio.Source;
import okio.Okio;
import okio.BufferedSink;
import java.io.File;

final class RequestBody$3 extends RequestBody
{
    final /* synthetic */ MediaType val$contentType;
    final /* synthetic */ File val$file;
    
    RequestBody$3(final MediaType val$contentType, final File val$file) {
        this.val$contentType = val$contentType;
        this.val$file = val$file;
    }
    
    public long contentLength() {
        return this.val$file.length();
    }
    
    public MediaType contentType() {
        return this.val$contentType;
    }
    
    public void writeTo(final BufferedSink bufferedSink) {
        Closeable source = null;
        try {
            bufferedSink.writeAll((Source)(source = Okio.source(this.val$file)));
        }
        finally {
            Util.closeQuietly(source);
        }
    }
}
