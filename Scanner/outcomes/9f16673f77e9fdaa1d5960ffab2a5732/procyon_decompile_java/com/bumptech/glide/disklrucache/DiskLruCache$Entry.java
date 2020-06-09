// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.disklrucache;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
import java.io.InputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.LinkedHashMap;
import java.io.Writer;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.Callable;
import java.io.Closeable;
import java.util.Arrays;
import java.io.IOException;
import java.io.File;

final class DiskLruCache$Entry
{
    File[] cleanFiles;
    private DiskLruCache$Editor currentEditor;
    File[] dirtyFiles;
    private final String key;
    private final long[] lengths;
    private boolean readable;
    private long sequenceNumber;
    final /* synthetic */ DiskLruCache this$0;
    
    private DiskLruCache$Entry(final DiskLruCache this$0, final String key) {
        this.this$0 = this$0;
        this.key = key;
        this.lengths = new long[this$0.valueCount];
        this.cleanFiles = new File[this$0.valueCount];
        this.dirtyFiles = new File[this$0.valueCount];
        final StringBuilder append = new StringBuilder(key).append('.');
        final int length = append.length();
        for (int i = 0; i < this$0.valueCount; ++i) {
            append.append(i);
            this.cleanFiles[i] = new File(this$0.directory, append.toString());
            append.append(".tmp");
            this.dirtyFiles[i] = new File(this$0.directory, append.toString());
            append.setLength(length);
        }
    }
    
    private IOException invalidLengths(final String[] array) {
        final StringBuilder sb = new StringBuilder();
        sb.append("unexpected journal line: ");
        sb.append(Arrays.toString(array));
        throw new IOException(sb.toString());
    }
    
    private void setLengths(final String[] array) {
        if (array.length == this.this$0.valueCount) {
            int n = 0;
            try {
                while (true) {
                    if (n >= array.length) {
                        return;
                    }
                    final long[] lengths = this.lengths;
                    final String s = array[n];
                    try {
                        lengths[n] = Long.parseLong(s);
                        ++n;
                        continue;
                    }
                    catch (NumberFormatException ex) {
                        throw this.invalidLengths(array);
                    }
                }
            }
            catch (NumberFormatException ex2) {}
        }
        throw this.invalidLengths(array);
    }
    
    public File getCleanFile(final int n) {
        return this.cleanFiles[n];
    }
    
    public File getDirtyFile(final int n) {
        return this.dirtyFiles[n];
    }
    
    public String getLengths() {
        final StringBuilder sb = new StringBuilder();
        final long[] lengths = this.lengths;
        for (int length = lengths.length, i = 0; i < length; ++i) {
            final long n = lengths[i];
            sb.append(' ');
            sb.append(n);
        }
        return sb.toString();
    }
}
