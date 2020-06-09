// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.IOException;
import java.io.OutputStream;

class RealBufferedSink$1 extends OutputStream
{
    final /* synthetic */ RealBufferedSink this$0;
    
    RealBufferedSink$1(final RealBufferedSink this$0) {
        this.this$0 = this$0;
    }
    
    public void close() {
        this.this$0.close();
    }
    
    public void flush() {
        if (!this.this$0.closed) {
            this.this$0.flush();
        }
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.this$0);
        sb.append(".outputStream()");
        return sb.toString();
    }
    
    public void write(final int n) {
        if (!this.this$0.closed) {
            this.this$0.buffer.writeByte((int)(byte)n);
            this.this$0.emitCompleteSegments();
            return;
        }
        throw new IOException("closed");
    }
    
    public void write(final byte[] array, final int n, final int n2) {
        if (!this.this$0.closed) {
            this.this$0.buffer.write(array, n, n2);
            this.this$0.emitCompleteSegments();
            return;
        }
        throw new IOException("closed");
    }
}
