// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import okio.Buffer;
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
import java.io.IOException;
import okhttp3.internal.NamedRunnable;

class FramedConnection$3 extends NamedRunnable
{
    final /* synthetic */ FramedConnection this$0;
    final /* synthetic */ int val$payload1;
    final /* synthetic */ int val$payload2;
    final /* synthetic */ Ping val$ping;
    final /* synthetic */ boolean val$reply;
    
    FramedConnection$3(final FramedConnection this$0, final String s, final Object[] array, final boolean val$reply, final int val$payload1, final int val$payload2, final Ping val$ping) {
        this.this$0 = this$0;
        this.val$reply = val$reply;
        this.val$payload1 = val$payload1;
        this.val$payload2 = val$payload2;
        this.val$ping = val$ping;
        super(s, array);
    }
    
    public void execute() {
        try {
            final FramedConnection this$0 = this.this$0;
            try {
                final boolean val$reply = this.val$reply;
                try {
                    final int val$payload1 = this.val$payload1;
                    try {
                        final int val$payload2 = this.val$payload2;
                        try {
                            this$0.writePing(val$reply, val$payload1, val$payload2, this.val$ping);
                        }
                        catch (IOException ex) {}
                    }
                    catch (IOException ex2) {}
                }
                catch (IOException ex3) {}
            }
            catch (IOException ex4) {}
        }
        catch (IOException ex5) {}
    }
}
