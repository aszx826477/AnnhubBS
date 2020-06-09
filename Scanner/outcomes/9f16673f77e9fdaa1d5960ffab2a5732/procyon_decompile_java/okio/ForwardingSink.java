// 
// Decompiled by Procyon v0.5.30
// 

package okio;

public abstract class ForwardingSink implements Sink
{
    private final Sink delegate;
    
    public ForwardingSink(final Sink delegate) {
        if (delegate != null) {
            this.delegate = delegate;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }
    
    public void close() {
        this.delegate.close();
    }
    
    public final Sink delegate() {
        return this.delegate;
    }
    
    public void flush() {
        this.delegate.flush();
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
    
    public void write(final Buffer buffer, final long n) {
        this.delegate.write(buffer, n);
    }
}
