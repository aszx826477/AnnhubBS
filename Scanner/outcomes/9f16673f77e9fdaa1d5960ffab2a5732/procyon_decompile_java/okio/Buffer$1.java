// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.OutputStream;

class Buffer$1 extends OutputStream
{
    final /* synthetic */ Buffer this$0;
    
    Buffer$1(final Buffer this$0) {
        this.this$0 = this$0;
    }
    
    public void close() {
    }
    
    public void flush() {
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.this$0);
        sb.append(".outputStream()");
        return sb.toString();
    }
    
    public void write(final int n) {
        this.this$0.writeByte((int)(byte)n);
    }
    
    public void write(final byte[] array, final int n, final int n2) {
        this.this$0.write(array, n, n2);
    }
}
