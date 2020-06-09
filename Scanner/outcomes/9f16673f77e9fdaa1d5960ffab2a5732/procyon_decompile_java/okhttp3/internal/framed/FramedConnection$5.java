// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import okio.Buffer;
import okio.BufferedSource;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.internal.Util;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.net.Socket;
import okhttp3.Protocol;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import okhttp3.internal.NamedRunnable;

class FramedConnection$5 extends NamedRunnable
{
    final /* synthetic */ FramedConnection this$0;
    final /* synthetic */ boolean val$inFinished;
    final /* synthetic */ List val$requestHeaders;
    final /* synthetic */ int val$streamId;
    
    FramedConnection$5(final FramedConnection this$0, final String s, final Object[] array, final int val$streamId, final List val$requestHeaders, final boolean val$inFinished) {
        this.this$0 = this$0;
        this.val$streamId = val$streamId;
        this.val$requestHeaders = val$requestHeaders;
        this.val$inFinished = val$inFinished;
        super(s, array);
    }
    
    public void execute() {
        final boolean onHeaders = this.this$0.pushObserver.onHeaders(this.val$streamId, this.val$requestHeaders, this.val$inFinished);
        while (true) {
            if (onHeaders) {
                Label_0148: {
                    Object o = null;
                    try {
                        final FramedConnection this$0 = this.this$0;
                        try {
                            o = this$0.frameWriter;
                            try {
                                final int val$streamId = this.val$streamId;
                                try {
                                    ((FrameWriter)o).rstStream(val$streamId, ErrorCode.CANCEL);
                                    if (!onHeaders && !this.val$inFinished) {
                                        break Label_0148;
                                    }
                                    o = this.this$0;
                                }
                                catch (IOException ex) {}
                            }
                            catch (IOException ex2) {}
                        }
                        catch (IOException ex3) {}
                    }
                    catch (IOException ex4) {}
                    synchronized (o) {
                        this.this$0.currentPushRequests.remove(this.val$streamId);
                    }
                }
                return;
            }
            continue;
        }
    }
}
