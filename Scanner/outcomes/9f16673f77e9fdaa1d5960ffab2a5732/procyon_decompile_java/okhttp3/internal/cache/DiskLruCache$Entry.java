// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.cache;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
import okhttp3.internal.io.FileSystem;
import java.util.concurrent.Executor;
import okio.Sink;
import java.util.regex.Pattern;
import java.io.Flushable;
import java.io.Closeable;
import okio.BufferedSink;
import java.util.Arrays;
import java.io.IOException;
import java.io.File;

final class DiskLruCache$Entry
{
    private final File[] cleanFiles;
    private DiskLruCache$Editor currentEditor;
    private final File[] dirtyFiles;
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
    
    DiskLruCache$Snapshot snapshot() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        okhttp3/internal/cache/DiskLruCache$Entry.this$0:Lokhttp3/internal/cache/DiskLruCache;
        //     4: astore_1       
        //     5: aload_1        
        //     6: invokestatic    java/lang/Thread.holdsLock:(Ljava/lang/Object;)Z
        //     9: istore_2       
        //    10: iload_2        
        //    11: ifeq            246
        //    14: aload_0        
        //    15: getfield        okhttp3/internal/cache/DiskLruCache$Entry.this$0:Lokhttp3/internal/cache/DiskLruCache;
        //    18: invokestatic    okhttp3/internal/cache/DiskLruCache.access$2600:(Lokhttp3/internal/cache/DiskLruCache;)I
        //    21: istore_2       
        //    22: iload_2        
        //    23: anewarray       Lokio/Source;
        //    26: astore_1       
        //    27: aload_0        
        //    28: getfield        okhttp3/internal/cache/DiskLruCache$Entry.lengths:[J
        //    31: invokevirtual   [J.clone:()Ljava/lang/Object;
        //    34: astore_3       
        //    35: aload_3        
        //    36: astore          4
        //    38: aload_3        
        //    39: checkcast       [J
        //    42: astore          4
        //    44: iconst_0       
        //    45: istore          5
        //    47: aconst_null    
        //    48: astore_3       
        //    49: aload_0        
        //    50: getfield        okhttp3/internal/cache/DiskLruCache$Entry.this$0:Lokhttp3/internal/cache/DiskLruCache;
        //    53: astore          6
        //    55: aload           6
        //    57: invokestatic    okhttp3/internal/cache/DiskLruCache.access$2600:(Lokhttp3/internal/cache/DiskLruCache;)I
        //    60: istore          7
        //    62: iload           5
        //    64: iload           7
        //    66: if_icmpge       121
        //    69: aload_0        
        //    70: getfield        okhttp3/internal/cache/DiskLruCache$Entry.this$0:Lokhttp3/internal/cache/DiskLruCache;
        //    73: astore          6
        //    75: aload           6
        //    77: invokestatic    okhttp3/internal/cache/DiskLruCache.access$2700:(Lokhttp3/internal/cache/DiskLruCache;)Lokhttp3/internal/io/FileSystem;
        //    80: astore          6
        //    82: aload_0        
        //    83: getfield        okhttp3/internal/cache/DiskLruCache$Entry.cleanFiles:[Ljava/io/File;
        //    86: astore          8
        //    88: aload           8
        //    90: iload           5
        //    92: aaload         
        //    93: astore          8
        //    95: aload           6
        //    97: aload           8
        //    99: invokeinterface okhttp3/internal/io/FileSystem.source:(Ljava/io/File;)Lokio/Source;
        //   104: astore          6
        //   106: aload_1        
        //   107: iload           5
        //   109: aload           6
        //   111: aastore        
        //   112: iload           5
        //   114: iconst_1       
        //   115: iadd           
        //   116: istore          5
        //   118: goto            49
        //   121: new             Lokhttp3/internal/cache/DiskLruCache$Snapshot;
        //   124: astore          9
        //   126: aload_0        
        //   127: getfield        okhttp3/internal/cache/DiskLruCache$Entry.this$0:Lokhttp3/internal/cache/DiskLruCache;
        //   130: astore          6
        //   132: aload_0        
        //   133: getfield        okhttp3/internal/cache/DiskLruCache$Entry.key:Ljava/lang/String;
        //   136: astore          8
        //   138: aload_0        
        //   139: getfield        okhttp3/internal/cache/DiskLruCache$Entry.sequenceNumber:J
        //   142: lstore          10
        //   144: aload           9
        //   146: astore_3       
        //   147: aload           9
        //   149: aload           6
        //   151: aload           8
        //   153: lload           10
        //   155: aload_1        
        //   156: aload           4
        //   158: aconst_null    
        //   159: invokespecial   okhttp3/internal/cache/DiskLruCache$Snapshot.<init>:(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;J[Lokio/Source;[JLokhttp3/internal/cache/DiskLruCache$1;)V
        //   162: aload           9
        //   164: areturn        
        //   165: astore_3       
        //   166: iconst_0       
        //   167: istore          7
        //   169: aconst_null    
        //   170: astore          6
        //   172: aload_0        
        //   173: getfield        okhttp3/internal/cache/DiskLruCache$Entry.this$0:Lokhttp3/internal/cache/DiskLruCache;
        //   176: astore          8
        //   178: aload           8
        //   180: invokestatic    okhttp3/internal/cache/DiskLruCache.access$2600:(Lokhttp3/internal/cache/DiskLruCache;)I
        //   183: istore          12
        //   185: iload           7
        //   187: iload           12
        //   189: if_icmpge       226
        //   192: aload_1        
        //   193: iload           7
        //   195: aaload         
        //   196: astore          8
        //   198: aload           8
        //   200: ifnull          223
        //   203: aload_1        
        //   204: iload           7
        //   206: aaload         
        //   207: astore          8
        //   209: aload           8
        //   211: invokestatic    okhttp3/internal/Util.closeQuietly:(Ljava/io/Closeable;)V
        //   214: iload           7
        //   216: iconst_1       
        //   217: iadd           
        //   218: istore          7
        //   220: goto            172
        //   223: goto            226
        //   226: aload_0        
        //   227: getfield        okhttp3/internal/cache/DiskLruCache$Entry.this$0:Lokhttp3/internal/cache/DiskLruCache;
        //   230: astore          6
        //   232: aload           6
        //   234: aload_0        
        //   235: invokestatic    okhttp3/internal/cache/DiskLruCache.access$3100:(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$Entry;)Z
        //   238: pop            
        //   239: goto            244
        //   242: astore          6
        //   244: aconst_null    
        //   245: areturn        
        //   246: new             Ljava/lang/AssertionError;
        //   249: astore_1       
        //   250: aload_1        
        //   251: invokespecial   java/lang/AssertionError.<init>:()V
        //   254: aload_1        
        //   255: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  49     53     165    246    Ljava/io/FileNotFoundException;
        //  55     60     165    246    Ljava/io/FileNotFoundException;
        //  69     73     165    246    Ljava/io/FileNotFoundException;
        //  75     80     165    246    Ljava/io/FileNotFoundException;
        //  82     86     165    246    Ljava/io/FileNotFoundException;
        //  90     93     165    246    Ljava/io/FileNotFoundException;
        //  97     104    165    246    Ljava/io/FileNotFoundException;
        //  109    112    165    246    Ljava/io/FileNotFoundException;
        //  121    124    165    246    Ljava/io/FileNotFoundException;
        //  126    130    165    246    Ljava/io/FileNotFoundException;
        //  132    136    165    246    Ljava/io/FileNotFoundException;
        //  138    142    165    246    Ljava/io/FileNotFoundException;
        //  158    162    165    246    Ljava/io/FileNotFoundException;
        //  226    230    242    244    Ljava/io/IOException;
        //  234    239    242    244    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 135, Size: 135
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:657)
        //     at java.util.ArrayList.get(ArrayList.java:433)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3303)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3551)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:317)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:238)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:138)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    void writeLengths(final BufferedSink bufferedSink) {
        final long[] lengths = this.lengths;
        for (int length = lengths.length, i = 0; i < length; ++i) {
            bufferedSink.writeByte(32).writeDecimalLong(lengths[i]);
        }
    }
}
