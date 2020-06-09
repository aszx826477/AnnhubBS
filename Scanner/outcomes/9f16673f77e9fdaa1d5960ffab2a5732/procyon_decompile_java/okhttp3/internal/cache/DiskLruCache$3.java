// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.cache;

import okio.Source;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import java.io.EOFException;
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
import okio.Sink;
import java.util.regex.Pattern;
import java.io.Flushable;
import java.io.Closeable;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

class DiskLruCache$3 implements Iterator
{
    final Iterator delegate;
    DiskLruCache$Snapshot nextSnapshot;
    DiskLruCache$Snapshot removeSnapshot;
    final /* synthetic */ DiskLruCache this$0;
    
    DiskLruCache$3(final DiskLruCache this$0) {
        this.this$0 = this$0;
        this.delegate = new ArrayList(this.this$0.lruEntries.values()).iterator();
    }
    
    public boolean hasNext() {
        final DiskLruCache$Snapshot nextSnapshot = this.nextSnapshot;
        final boolean b = true;
        if (nextSnapshot != null) {
            return b;
        }
        synchronized (this.this$0) {
            if (this.this$0.closed) {
                return false;
            }
            while (this.delegate.hasNext()) {
                final DiskLruCache$Snapshot snapshot = this.delegate.next().snapshot();
                if (snapshot == null) {
                    continue;
                }
                this.nextSnapshot = snapshot;
                return b;
            }
            return false;
        }
    }
    
    public DiskLruCache$Snapshot next() {
        if (this.hasNext()) {
            this.removeSnapshot = this.nextSnapshot;
            this.nextSnapshot = null;
            return this.removeSnapshot;
        }
        throw new NoSuchElementException();
    }
    
    public void remove() {
        final DiskLruCache$Snapshot removeSnapshot = this.removeSnapshot;
        if (removeSnapshot != null) {
            try {
                final DiskLruCache this$0 = this.this$0;
                try {
                    this$0.remove(removeSnapshot.key);
                }
                catch (IOException ex) {}
            }
            catch (IOException ex2) {}
            this.removeSnapshot = null;
            return;
        }
        throw new IllegalStateException("remove() before next()");
    }
}
