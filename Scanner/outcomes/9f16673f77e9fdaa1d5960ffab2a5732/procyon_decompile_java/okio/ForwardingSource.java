// 
// Decompiled by Procyon v0.5.30
// 

package okio;

public abstract class ForwardingSource implements Source
{
    private final Source delegate;
    
    public ForwardingSource(final Source delegate) {
        if (delegate != null) {
            this.delegate = delegate;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }
    
    public void close() {
        this.delegate.close();
    }
    
    public final Source delegate() {
        return this.delegate;
    }
    
    public long read(final Buffer buffer, final long n) {
        return this.delegate.read(buffer, n);
    }
    
    public Timeout timeout() {
        return this.delegate.timeout();
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append("(");
        sb.append(this.delegate.toString());
        sb.append(")");
        return sb.toString();
    }
}
