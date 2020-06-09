// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.util.ArrayList;
import java.util.List;
import okio.ByteString;
import java.io.IOException;
import okio.Okio;
import java.util.zip.Inflater;
import okio.BufferedSource;
import okio.InflaterSource;
import okio.Buffer;
import okio.Source;
import okio.ForwardingSource;

class NameValueBlockReader$1 extends ForwardingSource
{
    final /* synthetic */ NameValueBlockReader this$0;
    
    NameValueBlockReader$1(final NameValueBlockReader this$0, final Source source) {
        this.this$0 = this$0;
        super(source);
    }
    
    public long read(final Buffer buffer, final long n) {
        final int access$000 = this.this$0.compressedLimit;
        final long n2 = -1;
        if (access$000 == 0) {
            return n2;
        }
        final long read = super.read(buffer, Math.min(n, this.this$0.compressedLimit));
        if (read == n2) {
            return n2;
        }
        final NameValueBlockReader this$0 = this.this$0;
        this$0.compressedLimit -= read;
        return read;
    }
}
