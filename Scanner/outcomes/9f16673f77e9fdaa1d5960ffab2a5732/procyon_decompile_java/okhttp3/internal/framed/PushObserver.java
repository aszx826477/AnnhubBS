// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.util.List;
import okio.BufferedSource;

public interface PushObserver
{
    public static final PushObserver CANCEL = new PushObserver$1();
    
    boolean onData(final int p0, final BufferedSource p1, final int p2, final boolean p3);
    
    boolean onHeaders(final int p0, final List p1, final boolean p2);
    
    boolean onRequest(final int p0, final List p1);
    
    void onReset(final int p0, final ErrorCode p1);
}
