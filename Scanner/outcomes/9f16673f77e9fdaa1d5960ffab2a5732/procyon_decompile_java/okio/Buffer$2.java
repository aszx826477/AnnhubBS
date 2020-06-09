// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.InputStream;

class Buffer$2 extends InputStream
{
    final /* synthetic */ Buffer this$0;
    
    Buffer$2(final Buffer this$0) {
        this.this$0 = this$0;
    }
    
    public int available() {
        return (int)Math.min(this.this$0.size, 2147483647L);
    }
    
    public void close() {
    }
    
    public int read() {
        if (this.this$0.size > 0L) {
            return this.this$0.readByte() & 0xFF;
        }
        return -1;
    }
    
    public int read(final byte[] array, final int n, final int n2) {
        return this.this$0.read(array, n, n2);
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.this$0);
        sb.append(".inputStream()");
        return sb.toString();
    }
}
