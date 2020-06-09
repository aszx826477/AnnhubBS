// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.IOException;

class AsyncTimeout$2 implements Source
{
    final /* synthetic */ AsyncTimeout this$0;
    final /* synthetic */ Source val$source;
    
    AsyncTimeout$2(final AsyncTimeout this$0, final Source val$source) {
        this.this$0 = this$0;
        this.val$source = val$source;
    }
    
    public void close() {
        Label_0038: {
            Source source;
            try {
                final Source val$source;
                source = (val$source = this.val$source);
                val$source.close();
                final AsyncTimeout$2 asyncTimeout$2 = this;
                final AsyncTimeout asyncTimeout = asyncTimeout$2.this$0;
                final boolean b = true;
                asyncTimeout.exit(b);
                return;
            }
            catch (IOException ex2) {
                final IOException ex;
                throw this.this$0.exit(ex);
            }
            finally {
                break Label_0038;
            }
            try {
                final Source val$source = source;
                val$source.close();
                final AsyncTimeout$2 asyncTimeout$2 = this;
                final AsyncTimeout asyncTimeout = asyncTimeout$2.this$0;
                final boolean b = true;
                asyncTimeout.exit(b);
                return;
            }
            catch (IOException ex) {}
        }
        this.this$0.exit(false);
    }
    
    public long read(final Buffer buffer, final long n) {
        this.this$0.enter();
        try {
            try {
                final long read = this.val$source.read(buffer, n);
                this.this$0.exit(true);
                return read;
            }
            finally {}
        }
        catch (IOException ex) {
            throw this.this$0.exit(ex);
        }
        this.this$0.exit(false);
    }
    
    public Timeout timeout() {
        return this.this$0;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AsyncTimeout.source(");
        sb.append(this.val$source);
        sb.append(")");
        return sb.toString();
    }
}
