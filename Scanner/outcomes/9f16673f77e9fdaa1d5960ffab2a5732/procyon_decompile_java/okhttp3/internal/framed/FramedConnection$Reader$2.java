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

class FramedConnection$Reader$2 extends NamedRunnable
{
    final /* synthetic */ FramedConnection$Reader this$1;
    
    FramedConnection$Reader$2(final FramedConnection$Reader this$1, final String s, final Object... array) {
        this.this$1 = this$1;
        super(s, array);
    }
    
    public void execute() {
        this.this$1.this$0.listener.onSettings(this.this$1.this$0);
    }
}
