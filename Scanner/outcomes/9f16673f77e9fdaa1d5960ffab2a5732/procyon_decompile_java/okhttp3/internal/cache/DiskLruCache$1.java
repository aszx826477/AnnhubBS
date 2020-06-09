// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.cache;

import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import java.io.EOFException;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.internal.Util;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.LinkedHashMap;
import okio.BufferedSink;
import okhttp3.internal.io.FileSystem;
import java.util.concurrent.Executor;
import java.io.File;
import okio.Sink;
import java.util.regex.Pattern;
import java.io.Flushable;
import java.io.Closeable;
import okio.Okio;
import java.io.IOException;

class DiskLruCache$1 implements Runnable
{
    final /* synthetic */ DiskLruCache this$0;
    
    DiskLruCache$1(final DiskLruCache this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        final DiskLruCache this$0 = this.this$0;
        // monitorenter(this$0)
        try {
            final boolean access$000 = this.this$0.initialized;
            final boolean b = true;
            if (!access$000 | this.this$0.closed) {
                return;
            }
            try {
                final DiskLruCache this$2 = this.this$0;
                try {
                    this$2.trimToSize();
                }
                catch (IOException ex) {
                    this.this$0.mostRecentTrimFailed = b;
                }
            }
            catch (IOException ex2) {}
            try {
                final DiskLruCache this$3 = this.this$0;
                try {
                    Label_0125: {
                        if (!this$3.journalRebuildRequired()) {
                            break Label_0125;
                        }
                        final DiskLruCache this$4 = this.this$0;
                        try {
                            this$4.rebuildJournal();
                            this.this$0.redundantOpCount = 0;
                        }
                        catch (IOException ex3) {
                            this.this$0.mostRecentRebuildFailed = b;
                            this.this$0.journalWriter = Okio.buffer(DiskLruCache.NULL_SINK);
                        }
                    }
                }
                catch (IOException ex4) {}
                finally {
                }
                // monitorexit(this$0)
            }
            catch (IOException ex5) {}
        }
        finally {}
    }
}
