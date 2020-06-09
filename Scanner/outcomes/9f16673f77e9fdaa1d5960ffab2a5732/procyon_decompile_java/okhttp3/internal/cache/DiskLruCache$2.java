// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.cache;

import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import java.io.EOFException;
import java.util.Iterator;
import okio.Okio;
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
import java.util.regex.Pattern;
import java.io.Flushable;
import java.io.Closeable;
import java.io.IOException;
import okio.Sink;

class DiskLruCache$2 extends FaultHidingSink
{
    final /* synthetic */ DiskLruCache this$0;
    
    DiskLruCache$2(final DiskLruCache this$0, final Sink sink) {
        this.this$0 = this$0;
        super(sink);
    }
    
    protected void onException(final IOException ex) {
        this.this$0.hasJournalErrors = true;
    }
}
