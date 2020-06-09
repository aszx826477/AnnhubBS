// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import okio.Buffer;
import java.io.IOException;
import java.util.List;
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
import okhttp3.internal.NamedRunnable;

class FramedConnection$7 extends NamedRunnable
{
    final /* synthetic */ FramedConnection this$0;
    final /* synthetic */ ErrorCode val$errorCode;
    final /* synthetic */ int val$streamId;
    
    FramedConnection$7(final FramedConnection this$0, final String s, final Object[] array, final int val$streamId, final ErrorCode val$errorCode) {
        this.this$0 = this$0;
        this.val$streamId = val$streamId;
        this.val$errorCode = val$errorCode;
        super(s, array);
    }
    
    public void execute() {
        this.this$0.pushObserver.onReset(this.val$streamId, this.val$errorCode);
        synchronized (this.this$0) {
            this.this$0.currentPushRequests.remove(this.val$streamId);
        }
    }
}
