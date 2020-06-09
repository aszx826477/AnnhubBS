// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.disklrucache;

import java.util.ArrayList;
import java.util.Map;
import java.io.EOFException;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.Iterator;
import java.io.PrintStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.LinkedHashMap;
import java.io.Writer;
import java.util.concurrent.ThreadPoolExecutor;
import java.io.File;
import java.io.Closeable;
import java.util.concurrent.Callable;

class DiskLruCache$1 implements Callable
{
    final /* synthetic */ DiskLruCache this$0;
    
    DiskLruCache$1(final DiskLruCache this$0) {
        this.this$0 = this$0;
    }
    
    public Void call() {
        synchronized (this.this$0) {
            if (this.this$0.journalWriter == null) {
                return null;
            }
            this.this$0.trimToSize();
            if (this.this$0.journalRebuildRequired()) {
                this.this$0.rebuildJournal();
                this.this$0.redundantOpCount = 0;
            }
            return null;
        }
    }
}
