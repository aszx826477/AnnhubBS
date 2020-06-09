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
import java.util.Iterator;
import java.io.PrintStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.LinkedHashMap;
import java.io.Writer;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.Callable;
import java.io.Closeable;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;

public final class DiskLruCache$Value
{
    private final File[] files;
    private final String key;
    private final long[] lengths;
    private final long sequenceNumber;
    final /* synthetic */ DiskLruCache this$0;
    
    private DiskLruCache$Value(final DiskLruCache this$0, final String key, final long sequenceNumber, final File[] files, final long[] lengths) {
        this.this$0 = this$0;
        this.key = key;
        this.sequenceNumber = sequenceNumber;
        this.files = files;
        this.lengths = lengths;
    }
    
    public DiskLruCache$Editor edit() {
        return this.this$0.edit(this.key, this.sequenceNumber);
    }
    
    public File getFile(final int n) {
        return this.files[n];
    }
    
    public long getLength(final int n) {
        return this.lengths[n];
    }
    
    public String getString(final int n) {
        return inputStreamToString(new FileInputStream(this.files[n]));
    }
}
