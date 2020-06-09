// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.util.List;
import okio.BufferedSource;

final class PushObserver$1 implements PushObserver
{
    public boolean onData(final int n, final BufferedSource bufferedSource, final int n2, final boolean b) {
        bufferedSource.skip(n2);
        return true;
    }
    
    public boolean onHeaders(final int n, final List list, final boolean b) {
        return true;
    }
    
    public boolean onRequest(final int n, final List list) {
        return true;
    }
    
    public void onReset(final int n, final ErrorCode errorCode) {
    }
}
