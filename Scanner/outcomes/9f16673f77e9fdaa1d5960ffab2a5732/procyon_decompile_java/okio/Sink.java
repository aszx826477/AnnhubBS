// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.Flushable;
import java.io.Closeable;

public interface Sink extends Closeable, Flushable
{
    void close();
    
    void flush();
    
    Timeout timeout();
    
    void write(final Buffer p0, final long p1);
}
