// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.net.SocketTimeoutException;
import java.io.IOException;
import okio.AsyncTimeout;

class FramedStream$StreamTimeout extends AsyncTimeout
{
    final /* synthetic */ FramedStream this$0;
    
    FramedStream$StreamTimeout(final FramedStream this$0) {
        this.this$0 = this$0;
    }
    
    public void exitAndThrowIfTimedOut() {
        if (!this.exit()) {
            return;
        }
        throw this.newTimeoutException(null);
    }
    
    protected IOException newTimeoutException(final IOException ex) {
        final SocketTimeoutException ex2 = new SocketTimeoutException("timeout");
        if (ex != null) {
            ex2.initCause(ex);
        }
        return ex2;
    }
    
    protected void timedOut() {
        this.this$0.closeLater(ErrorCode.CANCEL);
    }
}
