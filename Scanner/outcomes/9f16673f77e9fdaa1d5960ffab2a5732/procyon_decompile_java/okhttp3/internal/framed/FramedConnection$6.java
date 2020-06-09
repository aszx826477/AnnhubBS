// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.util.List;
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
import okio.BufferedSource;
import okio.Buffer;
import okhttp3.internal.NamedRunnable;

class FramedConnection$6 extends NamedRunnable
{
    final /* synthetic */ FramedConnection this$0;
    final /* synthetic */ Buffer val$buffer;
    final /* synthetic */ int val$byteCount;
    final /* synthetic */ boolean val$inFinished;
    final /* synthetic */ int val$streamId;
    
    FramedConnection$6(final FramedConnection this$0, final String s, final Object[] array, final int val$streamId, final Buffer val$buffer, final int val$byteCount, final boolean val$inFinished) {
        this.this$0 = this$0;
        this.val$streamId = val$streamId;
        this.val$buffer = val$buffer;
        this.val$byteCount = val$byteCount;
        this.val$inFinished = val$inFinished;
        super(s, array);
    }
    
    public void execute() {
        try {
            final FramedConnection this$0 = this.this$0;
            try {
                final PushObserver access$2700 = this$0.pushObserver;
                try {
                    final int val$streamId = this.val$streamId;
                    try {
                        final Buffer val$buffer = this.val$buffer;
                        try {
                            final int val$byteCount = this.val$byteCount;
                            try {
                                final boolean onData = access$2700.onData(val$streamId, val$buffer, val$byteCount, this.val$inFinished);
                                Label_0086: {
                                    if (!onData) {
                                        break Label_0086;
                                    }
                                    final FramedConnection this$2 = this.this$0;
                                    try {
                                        Object o = this$2.frameWriter;
                                        try {
                                            final int val$streamId2 = this.val$streamId;
                                            try {
                                                ((FrameWriter)o).rstStream(val$streamId2, ErrorCode.CANCEL);
                                                Label_0150: {
                                                    if (!onData && !this.val$inFinished) {
                                                        break Label_0150;
                                                    }
                                                    o = this.this$0;
                                                    try {
                                                        synchronized (o) {
                                                            this.this$0.currentPushRequests.remove(this.val$streamId);
                                                        }
                                                    }
                                                    catch (IOException ex) {}
                                                }
                                            }
                                            catch (IOException ex2) {}
                                        }
                                        catch (IOException ex3) {}
                                    }
                                    catch (IOException ex4) {}
                                }
                            }
                            catch (IOException ex5) {}
                        }
                        catch (IOException ex6) {}
                    }
                    catch (IOException ex7) {}
                }
                catch (IOException ex8) {}
            }
            catch (IOException ex9) {}
        }
        catch (IOException ex10) {}
    }
}
