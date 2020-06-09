// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.IOException;

class AsyncTimeout$1 implements Sink
{
    final /* synthetic */ AsyncTimeout this$0;
    final /* synthetic */ Sink val$sink;
    
    AsyncTimeout$1(final AsyncTimeout this$0, final Sink val$sink) {
        this.this$0 = this$0;
        this.val$sink = val$sink;
    }
    
    public void close() {
        this.this$0.enter();
        Label_0047: {
            Sink sink;
            try {
                final Sink val$sink;
                sink = (val$sink = this.val$sink);
                val$sink.close();
                final AsyncTimeout$1 asyncTimeout$1 = this;
                final AsyncTimeout asyncTimeout = asyncTimeout$1.this$0;
                final boolean b = true;
                asyncTimeout.exit(b);
                return;
            }
            catch (IOException ex2) {
                final IOException ex;
                throw this.this$0.exit(ex);
            }
            finally {
                break Label_0047;
            }
            try {
                final Sink val$sink = sink;
                val$sink.close();
                final AsyncTimeout$1 asyncTimeout$1 = this;
                final AsyncTimeout asyncTimeout = asyncTimeout$1.this$0;
                final boolean b = true;
                asyncTimeout.exit(b);
                return;
            }
            catch (IOException ex) {}
        }
        this.this$0.exit(false);
    }
    
    public void flush() {
        this.this$0.enter();
        Label_0047: {
            Sink sink;
            try {
                final Sink val$sink;
                sink = (val$sink = this.val$sink);
                val$sink.flush();
                final AsyncTimeout$1 asyncTimeout$1 = this;
                final AsyncTimeout asyncTimeout = asyncTimeout$1.this$0;
                final boolean b = true;
                asyncTimeout.exit(b);
                return;
            }
            catch (IOException ex2) {
                final IOException ex;
                throw this.this$0.exit(ex);
            }
            finally {
                break Label_0047;
            }
            try {
                final Sink val$sink = sink;
                val$sink.flush();
                final AsyncTimeout$1 asyncTimeout$1 = this;
                final AsyncTimeout asyncTimeout = asyncTimeout$1.this$0;
                final boolean b = true;
                asyncTimeout.exit(b);
                return;
            }
            catch (IOException ex) {}
        }
        this.this$0.exit(false);
    }
    
    public Timeout timeout() {
        return this.this$0;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AsyncTimeout.sink(");
        sb.append(this.val$sink);
        sb.append(")");
        return sb.toString();
    }
    
    public void write(final Buffer buffer, long n) {
        Util.checkOffsetAndCount(buffer.size, 0L, n);
        while (n > 0L) {
            long n2 = 0L;
            Segment segment = buffer.head;
            while (n2 < 65536L) {
                n2 += buffer.head.limit - buffer.head.pos;
                if (n2 >= n) {
                    n2 = n;
                    break;
                }
                segment = segment.next;
            }
            this.this$0.enter();
            try {
                try {
                    this.val$sink.write(buffer, n2);
                    n -= n2;
                    this.this$0.exit(true);
                }
                finally {}
            }
            catch (IOException ex) {
                throw this.this$0.exit(ex);
            }
            this.this$0.exit(false);
        }
    }
}
