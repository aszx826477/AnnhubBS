// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.IOException;
import java.io.InputStream;

class RealBufferedSource$1 extends InputStream
{
    final /* synthetic */ RealBufferedSource this$0;
    
    RealBufferedSource$1(final RealBufferedSource this$0) {
        this.this$0 = this$0;
    }
    
    public int available() {
        if (!this.this$0.closed) {
            return (int)Math.min(this.this$0.buffer.size, 2147483647L);
        }
        throw new IOException("closed");
    }
    
    public void close() {
        this.this$0.close();
    }
    
    public int read() {
        if (this.this$0.closed) {
            throw new IOException("closed");
        }
        if (this.this$0.buffer.size == 0L && this.this$0.source.read(this.this$0.buffer, 8192L) == -1) {
            return -1;
        }
        return this.this$0.buffer.readByte() & 0xFF;
    }
    
    public int read(final byte[] array, final int n, final int n2) {
        if (this.this$0.closed) {
            throw new IOException("closed");
        }
        Util.checkOffsetAndCount(array.length, n, n2);
        if (this.this$0.buffer.size == 0L && this.this$0.source.read(this.this$0.buffer, 8192L) == -1) {
            return -1;
        }
        return this.this$0.buffer.read(array, n, n2);
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.this$0);
        sb.append(".inputStream()");
        return sb.toString();
    }
}
