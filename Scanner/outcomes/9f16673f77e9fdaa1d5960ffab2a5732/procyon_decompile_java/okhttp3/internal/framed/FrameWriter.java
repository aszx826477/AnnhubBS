// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.util.List;
import okio.Buffer;
import java.io.Closeable;

public interface FrameWriter extends Closeable
{
    void applyAndAckSettings(final Settings p0);
    
    void connectionPreface();
    
    void data(final boolean p0, final int p1, final Buffer p2, final int p3);
    
    void flush();
    
    void goAway(final int p0, final ErrorCode p1, final byte[] p2);
    
    void headers(final int p0, final List p1);
    
    int maxDataLength();
    
    void ping(final boolean p0, final int p1, final int p2);
    
    void pushPromise(final int p0, final int p1, final List p2);
    
    void rstStream(final int p0, final ErrorCode p1);
    
    void settings(final Settings p0);
    
    void synReply(final boolean p0, final int p1, final List p2);
    
    void synStream(final boolean p0, final boolean p1, final int p2, final int p3, final List p4);
    
    void windowUpdate(final int p0, final long p1);
}
