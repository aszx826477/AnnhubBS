// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.cache;

import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import java.io.IOException;
import java.io.EOFException;
import java.util.Iterator;
import okio.Okio;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
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
import okhttp3.internal.Util;
import okio.Source;
import java.io.Closeable;

public final class DiskLruCache$Snapshot implements Closeable
{
    private final String key;
    private final long[] lengths;
    private final long sequenceNumber;
    private final Source[] sources;
    final /* synthetic */ DiskLruCache this$0;
    
    private DiskLruCache$Snapshot(final DiskLruCache this$0, final String key, final long sequenceNumber, final Source[] sources, final long[] lengths) {
        this.this$0 = this$0;
        this.key = key;
        this.sequenceNumber = sequenceNumber;
        this.sources = sources;
        this.lengths = lengths;
    }
    
    public void close() {
        final Source[] sources = this.sources;
        for (int length = sources.length, i = 0; i < length; ++i) {
            Util.closeQuietly(sources[i]);
        }
    }
    
    public DiskLruCache$Editor edit() {
        return this.this$0.edit(this.key, this.sequenceNumber);
    }
    
    public long getLength(final int n) {
        return this.lengths[n];
    }
    
    public Source getSource(final int n) {
        return this.sources[n];
    }
    
    public String key() {
        return this.key;
    }
}
