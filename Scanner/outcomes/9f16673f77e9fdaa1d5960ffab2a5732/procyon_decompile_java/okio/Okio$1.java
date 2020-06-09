// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.OutputStream;

final class Okio$1 implements Sink
{
    final /* synthetic */ OutputStream val$out;
    final /* synthetic */ Timeout val$timeout;
    
    Okio$1(final Timeout val$timeout, final OutputStream val$out) {
        this.val$timeout = val$timeout;
        this.val$out = val$out;
    }
    
    public void close() {
        this.val$out.close();
    }
    
    public void flush() {
        this.val$out.flush();
    }
    
    public Timeout timeout() {
        return this.val$timeout;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("sink(");
        sb.append(this.val$out);
        sb.append(")");
        return sb.toString();
    }
    
    public void write(final Buffer buffer, long n) {
        Util.checkOffsetAndCount(buffer.size, 0L, n);
        while (n > 0L) {
            this.val$timeout.throwIfReached();
            final Segment head = buffer.head;
            final int n2 = (int)Math.min(n, head.limit - head.pos);
            this.val$out.write(head.data, head.pos, n2);
            head.pos += n2;
            n -= n2;
            buffer.size -= n2;
            if (head.pos == head.limit) {
                buffer.head = head.pop();
                SegmentPool.recycle(head);
            }
        }
    }
}
