// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import okio.Okio;
import java.net.InetSocketAddress;
import okio.BufferedSink;
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

public final class FramedConnection implements Closeable
{
    private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final ExecutorService executor;
    long bytesLeftInWriteWindow;
    final boolean client;
    private final Set currentPushRequests;
    final FrameWriter frameWriter;
    private final String hostname;
    private int lastGoodStreamId;
    private final FramedConnection$Listener listener;
    private int nextPingId;
    private int nextStreamId;
    Settings okHttpSettings;
    final Settings peerSettings;
    private Map pings;
    final Protocol protocol;
    private final ExecutorService pushExecutor;
    private final PushObserver pushObserver;
    final FramedConnection$Reader readerRunnable;
    private boolean receivedInitialPeerSettings;
    private boolean shutdown;
    final Socket socket;
    private final Map streams;
    long unacknowledgedBytesRead;
    final Variant variant;
    
    static {
        executor = new ThreadPoolExecutor(0, -1 >>> 1, 60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), Util.threadFactory("OkHttp FramedConnection", true));
    }
    
    private FramedConnection(final FramedConnection$Builder framedConnection$Builder) {
        this.streams = new HashMap();
        this.unacknowledgedBytesRead = 0L;
        this.okHttpSettings = new Settings();
        this.peerSettings = new Settings();
        this.receivedInitialPeerSettings = false;
        this.currentPushRequests = new LinkedHashSet();
        this.protocol = framedConnection$Builder.protocol;
        this.pushObserver = framedConnection$Builder.pushObserver;
        this.client = framedConnection$Builder.client;
        this.listener = framedConnection$Builder.listener;
        final boolean access$200 = framedConnection$Builder.client;
        int nextPingId = 2;
        final int n = 1;
        int nextStreamId;
        if (access$200) {
            nextStreamId = 1;
        }
        else {
            nextStreamId = 2;
        }
        this.nextStreamId = nextStreamId;
        if (framedConnection$Builder.client && this.protocol == Protocol.HTTP_2) {
            this.nextStreamId += nextPingId;
        }
        if (framedConnection$Builder.client) {
            nextPingId = 1;
        }
        this.nextPingId = nextPingId;
        final boolean access$201 = framedConnection$Builder.client;
        final int n2 = 7;
        if (access$201) {
            this.okHttpSettings.set(n2, 0, 16777216);
        }
        this.hostname = framedConnection$Builder.hostname;
        if (this.protocol == Protocol.HTTP_2) {
            this.variant = new Http2();
            final boolean b = true;
            final long n3 = 60;
            final TimeUnit seconds = TimeUnit.SECONDS;
            final LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
            final Object[] array = new Object[n];
            array[0] = this.hostname;
            this.pushExecutor = new ThreadPoolExecutor(0, b ? 1 : 0, n3, seconds, linkedBlockingQueue, Util.threadFactory(Util.format("OkHttp %s Push Observer", array), n != 0));
            this.peerSettings.set(n2, 0, (char)(-1));
            this.peerSettings.set(5, 0, 16384);
        }
        else {
            if (this.protocol != Protocol.SPDY_3) {
                throw new AssertionError(this.protocol);
            }
            this.variant = new Spdy3();
            this.pushExecutor = null;
        }
        this.bytesLeftInWriteWindow = this.peerSettings.getInitialWindowSize(65536);
        this.socket = framedConnection$Builder.socket;
        this.frameWriter = this.variant.newWriter(framedConnection$Builder.sink, this.client);
        this.readerRunnable = new FramedConnection$Reader(this, this.variant.newReader(framedConnection$Builder.source, this.client), null);
    }
    
    private void close(final ErrorCode errorCode, final ErrorCode errorCode2) {
        IOException ex = null;
        try {
            this.shutdown(errorCode);
        }
        catch (IOException ex2) {
            ex = ex2;
        }
        FramedStream[] array = null;
        Ping[] array2 = null;
        synchronized (this) {
            if (!this.streams.isEmpty()) {
                array = (FramedStream[])this.streams.values().toArray(new FramedStream[this.streams.size()]);
                this.streams.clear();
            }
            if (this.pings != null) {
                array2 = (Ping[])this.pings.values().toArray(new Ping[this.pings.size()]);
                this.pings = null;
            }
            // monitorexit(this)
            int i = 0;
            if (array != null) {
                final int length = array.length;
                IOException ex3 = ex;
                for (int j = 0; j < length; ++j) {
                    final FramedStream framedStream = array[j];
                    try {
                        framedStream.close(errorCode2);
                    }
                    catch (IOException ex4) {
                        if (ex3 != null) {
                            ex3 = ex4;
                        }
                    }
                }
                ex = ex3;
            }
            if (array2 != null) {
                while (i < array2.length) {
                    array2[i].cancel();
                    ++i;
                }
            }
            Label_0343: {
                try {
                    final FrameWriter frameWriter = this.frameWriter;
                    try {
                        frameWriter.close();
                    }
                    catch (IOException ex5) {
                        if (ex != null) {
                            break Label_0343;
                        }
                        ex = ex5;
                    }
                }
                catch (IOException ex7) {}
                try {
                    final Socket socket = this.socket;
                    try {
                        socket.close();
                    }
                    catch (IOException ex6) {
                        ex = ex6;
                    }
                }
                catch (IOException ex8) {}
            }
            if (ex == null) {
                return;
            }
            throw ex;
        }
    }
    
    private FramedStream newStream(final int p0, final List p1, final boolean p2, final boolean p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: astore          5
        //     3: iload_1        
        //     4: istore          6
        //     6: iload_3        
        //     7: iconst_1       
        //     8: ixor           
        //     9: istore          7
        //    11: iload           4
        //    13: iconst_1       
        //    14: ixor           
        //    15: istore          8
        //    17: aload_0        
        //    18: getfield        okhttp3/internal/framed/FramedConnection.frameWriter:Lokhttp3/internal/framed/FrameWriter;
        //    21: astore          9
        //    23: aload           9
        //    25: monitorenter   
        //    26: aload_0        
        //    27: monitorenter   
        //    28: aload_0        
        //    29: getfield        okhttp3/internal/framed/FramedConnection.shutdown:Z
        //    32: istore          10
        //    34: iload           10
        //    36: ifne            308
        //    39: aload_0        
        //    40: getfield        okhttp3/internal/framed/FramedConnection.nextStreamId:I
        //    43: istore          10
        //    45: aload_0        
        //    46: getfield        okhttp3/internal/framed/FramedConnection.nextStreamId:I
        //    49: iconst_2       
        //    50: iadd           
        //    51: istore          11
        //    53: aload_0        
        //    54: iload           11
        //    56: putfield        okhttp3/internal/framed/FramedConnection.nextStreamId:I
        //    59: new             Lokhttp3/internal/framed/FramedStream;
        //    62: astore          12
        //    64: aload           12
        //    66: astore          13
        //    68: iload           10
        //    70: istore          14
        //    72: aload_0        
        //    73: astore          15
        //    75: aload_2        
        //    76: astore          16
        //    78: aload           12
        //    80: iload           10
        //    82: aload_0        
        //    83: iload           7
        //    85: iload           8
        //    87: aload_2        
        //    88: invokespecial   okhttp3/internal/framed/FramedStream.<init>:(ILokhttp3/internal/framed/FramedConnection;ZZLjava/util/List;)V
        //    91: iload_3        
        //    92: ifeq            144
        //    95: aload_0        
        //    96: getfield        okhttp3/internal/framed/FramedConnection.bytesLeftInWriteWindow:J
        //    99: lstore          17
        //   101: lconst_0       
        //   102: lstore          19
        //   104: lload           17
        //   106: lload           19
        //   108: lcmp           
        //   109: istore          21
        //   111: iload           21
        //   113: ifeq            144
        //   116: aload           12
        //   118: getfield        okhttp3/internal/framed/FramedStream.bytesLeftInWriteWindow:J
        //   121: lstore          17
        //   123: lload           17
        //   125: lload           19
        //   127: lcmp           
        //   128: istore          21
        //   130: iload           21
        //   132: ifne            138
        //   135: goto            144
        //   138: iconst_0       
        //   139: istore          14
        //   141: goto            147
        //   144: iconst_1       
        //   145: istore          14
        //   147: aload           13
        //   149: invokevirtual   okhttp3/internal/framed/FramedStream.isOpen:()Z
        //   152: istore          22
        //   154: iload           22
        //   156: ifeq            188
        //   159: aload           5
        //   161: getfield        okhttp3/internal/framed/FramedConnection.streams:Ljava/util/Map;
        //   164: astore          15
        //   166: iload           10
        //   168: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   171: astore          16
        //   173: aload           15
        //   175: aload           16
        //   177: aload           13
        //   179: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   184: pop            
        //   185: goto            188
        //   188: aload_0        
        //   189: monitorexit    
        //   190: iload           6
        //   192: ifne            223
        //   195: aload           5
        //   197: getfield        okhttp3/internal/framed/FramedConnection.frameWriter:Lokhttp3/internal/framed/FrameWriter;
        //   200: astore          12
        //   202: aload           12
        //   204: iload           7
        //   206: iload           8
        //   208: iload           10
        //   210: iload_1        
        //   211: aload_2        
        //   212: invokeinterface okhttp3/internal/framed/FrameWriter.synStream:(ZZIILjava/util/List;)V
        //   217: aload_2        
        //   218: astore          16
        //   220: goto            257
        //   223: aload           5
        //   225: getfield        okhttp3/internal/framed/FramedConnection.client:Z
        //   228: istore          22
        //   230: iload           22
        //   232: ifne            285
        //   235: aload           5
        //   237: getfield        okhttp3/internal/framed/FramedConnection.frameWriter:Lokhttp3/internal/framed/FrameWriter;
        //   240: astore          15
        //   242: aload_2        
        //   243: astore          16
        //   245: aload           15
        //   247: iload           6
        //   249: iload           10
        //   251: aload_2        
        //   252: invokeinterface okhttp3/internal/framed/FrameWriter.pushPromise:(IILjava/util/List;)V
        //   257: aload           9
        //   259: monitorexit    
        //   260: iload           14
        //   262: ifeq            282
        //   265: aload           5
        //   267: getfield        okhttp3/internal/framed/FramedConnection.frameWriter:Lokhttp3/internal/framed/FrameWriter;
        //   270: astore          15
        //   272: aload           15
        //   274: invokeinterface okhttp3/internal/framed/FrameWriter.flush:()V
        //   279: goto            282
        //   282: aload           13
        //   284: areturn        
        //   285: aload_2        
        //   286: astore          16
        //   288: new             Ljava/lang/IllegalArgumentException;
        //   291: astore          15
        //   293: ldc_w           "client streams shouldn't have associated stream IDs"
        //   296: astore          12
        //   298: aload           15
        //   300: aload           12
        //   302: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   305: aload           15
        //   307: athrow         
        //   308: aload_2        
        //   309: astore          16
        //   311: new             Ljava/io/IOException;
        //   314: astore          23
        //   316: ldc_w           "shutdown"
        //   319: astore          13
        //   321: aload           23
        //   323: aload           13
        //   325: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   328: aload           23
        //   330: athrow         
        //   331: astore          23
        //   333: aload_2        
        //   334: astore          16
        //   336: aload_0        
        //   337: monitorexit    
        //   338: aload           23
        //   340: athrow         
        //   341: astore          23
        //   343: goto            336
        //   346: astore          23
        //   348: aload_2        
        //   349: astore          16
        //   351: aload           9
        //   353: monitorexit    
        //   354: aload           23
        //   356: athrow         
        //   357: astore          23
        //   359: goto            351
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  26     28     346    351    Any
        //  28     32     331    336    Any
        //  39     43     331    336    Any
        //  45     49     331    336    Any
        //  54     59     331    336    Any
        //  59     62     331    336    Any
        //  87     91     331    336    Any
        //  95     99     331    336    Any
        //  116    121    331    336    Any
        //  147    152    331    336    Any
        //  159    164    331    336    Any
        //  166    171    331    336    Any
        //  177    185    331    336    Any
        //  188    190    331    336    Any
        //  195    200    346    351    Any
        //  211    217    346    351    Any
        //  223    228    346    351    Any
        //  235    240    346    351    Any
        //  251    257    357    362    Any
        //  257    260    357    362    Any
        //  288    291    357    362    Any
        //  300    305    357    362    Any
        //  305    308    357    362    Any
        //  311    314    341    346    Any
        //  323    328    341    346    Any
        //  328    331    341    346    Any
        //  336    338    341    346    Any
        //  338    341    357    362    Any
        //  351    354    357    362    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0257:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
    
    private void pushDataLater(final int n, final BufferedSource bufferedSource, final int n2, final boolean b) {
        final Buffer buffer = new Buffer();
        bufferedSource.require(n2);
        bufferedSource.read(buffer, n2);
        if (buffer.size() == n2) {
            this.pushExecutor.execute(new FramedConnection$6(this, "OkHttp %s Push Data[%s]", new Object[] { this.hostname, n }, n, buffer, n2, b));
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(buffer.size());
        sb.append(" != ");
        sb.append(n2);
        throw new IOException(sb.toString());
    }
    
    private void pushHeadersLater(final int n, final List list, final boolean b) {
        this.pushExecutor.execute(new FramedConnection$5(this, "OkHttp %s Push Headers[%s]", new Object[] { this.hostname, n }, n, list, b));
    }
    
    private void pushRequestLater(final int n, final List list) {
        synchronized (this) {
            if (this.currentPushRequests.contains(n)) {
                this.writeSynResetLater(n, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(n);
            // monitorexit(this)
            final ExecutorService pushExecutor = this.pushExecutor;
            final Object[] array;
            final FramedConnection$4 framedConnection$4 = new FramedConnection$4(this, "OkHttp %s Push Request[%s]", array, n, list);
            array = new Object[] { this.hostname, n };
            pushExecutor.execute(framedConnection$4);
        }
    }
    
    private void pushResetLater(final int n, final ErrorCode errorCode) {
        this.pushExecutor.execute(new FramedConnection$7(this, "OkHttp %s Push Reset[%s]", new Object[] { this.hostname, n }, n, errorCode));
    }
    
    private boolean pushedStream(final int n) {
        return this.protocol == Protocol.HTTP_2 && n != 0 && (n & 0x1) == 0x0;
    }
    
    private Ping removePing(final int n) {
        synchronized (this) {
            Ping ping;
            if (this.pings != null) {
                ping = this.pings.remove(n);
            }
            else {
                ping = null;
            }
            return ping;
        }
    }
    
    private void writePing(final boolean b, final int n, final int n2, final Ping ping) {
        final FrameWriter frameWriter = this.frameWriter;
        // monitorenter(frameWriter)
        Label_0019: {
            if (ping == null) {
                break Label_0019;
            }
            try {
                ping.send();
                this.frameWriter.ping(b, n, n2);
            }
            finally {
            }
            // monitorexit(frameWriter)
        }
    }
    
    private void writePingLater(final boolean b, final int n, final int n2, final Ping ping) {
        FramedConnection.executor.execute(new FramedConnection$3(this, "OkHttp %s ping %08x%08x", new Object[] { this.hostname, n, n2 }, b, n, n2, ping));
    }
    
    void addBytesToWriteWindow(final long n) {
        this.bytesLeftInWriteWindow += n;
        if (n > 0L) {
            this.notifyAll();
        }
    }
    
    public void close() {
        this.close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }
    
    public void flush() {
        this.frameWriter.flush();
    }
    
    public Protocol getProtocol() {
        return this.protocol;
    }
    
    FramedStream getStream(final int n) {
        synchronized (this) {
            return this.streams.get(n);
        }
    }
    
    public int maxConcurrentStreams() {
        synchronized (this) {
            return this.peerSettings.getMaxConcurrentStreams(-1 >>> 1);
        }
    }
    
    public FramedStream newStream(final List list, final boolean b, final boolean b2) {
        return this.newStream(0, list, b, b2);
    }
    
    public int openStreamCount() {
        synchronized (this) {
            return this.streams.size();
        }
    }
    
    public Ping ping() {
        final Ping ping = new Ping();
        synchronized (this) {
            if (!this.shutdown) {
                final int nextPingId = this.nextPingId;
                this.nextPingId += 2;
                if (this.pings == null) {
                    this.pings = new HashMap();
                }
                this.pings.put(nextPingId, ping);
                // monitorexit(this)
                this.writePing(false, nextPingId, 1330343787, ping);
                return ping;
            }
            throw new IOException("shutdown");
        }
    }
    
    public FramedStream pushStream(final int n, final List list, final boolean b) {
        if (this.client) {
            throw new IllegalStateException("Client cannot push requests.");
        }
        if (this.protocol == Protocol.HTTP_2) {
            return this.newStream(n, list, b, false);
        }
        throw new IllegalStateException("protocol != HTTP_2");
    }
    
    FramedStream removeStream(final int n) {
        synchronized (this) {
            final FramedStream framedStream = this.streams.remove(n);
            this.notifyAll();
            return framedStream;
        }
    }
    
    public void setSettings(final Settings settings) {
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.okHttpSettings.merge(settings);
                    this.frameWriter.settings(settings);
                    return;
                }
                throw new IOException("shutdown");
            }
        }
    }
    
    public void shutdown(final ErrorCode errorCode) {
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (this.shutdown) {
                    return;
                }
                this.shutdown = true;
                final int lastGoodStreamId = this.lastGoodStreamId;
                // monitorexit(this)
                this.frameWriter.goAway(lastGoodStreamId, errorCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }
    
    public void start() {
        this.start(true);
    }
    
    void start(final boolean b) {
        if (b) {
            this.frameWriter.connectionPreface();
            this.frameWriter.settings(this.okHttpSettings);
            final Settings okHttpSettings = this.okHttpSettings;
            final int n = 65536;
            final int initialWindowSize = okHttpSettings.getInitialWindowSize(n);
            if (initialWindowSize != n) {
                this.frameWriter.windowUpdate(0, initialWindowSize - n);
            }
        }
        new Thread(this.readerRunnable).start();
    }
    
    public void writeData(final int p0, final boolean p1, final Buffer p2, final long p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore          6
        //     3: lconst_0       
        //     4: lstore          7
        //     6: lload           4
        //     8: lload           7
        //    10: lcmp           
        //    11: istore          9
        //    13: iload           9
        //    15: ifne            32
        //    18: aload_0        
        //    19: getfield        okhttp3/internal/framed/FramedConnection.frameWriter:Lokhttp3/internal/framed/FrameWriter;
        //    22: iload_2        
        //    23: iload_1        
        //    24: aload_3        
        //    25: iconst_0       
        //    26: invokeinterface okhttp3/internal/framed/FrameWriter.data:(ZILokio/Buffer;I)V
        //    31: return         
        //    32: lload           4
        //    34: lload           7
        //    36: lcmp           
        //    37: istore          9
        //    39: iload           9
        //    41: ifle            273
        //    44: aload_0        
        //    45: monitorenter   
        //    46: aload_0        
        //    47: getfield        okhttp3/internal/framed/FramedConnection.bytesLeftInWriteWindow:J
        //    50: lstore          10
        //    52: lload           10
        //    54: lload           7
        //    56: lcmp           
        //    57: istore          12
        //    59: iload           12
        //    61: ifgt            119
        //    64: aload_0        
        //    65: getfield        okhttp3/internal/framed/FramedConnection.streams:Ljava/util/Map;
        //    68: astore          13
        //    70: iload_1        
        //    71: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    74: astore          14
        //    76: aload           13
        //    78: aload           14
        //    80: invokeinterface java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //    85: istore          9
        //    87: iload           9
        //    89: ifeq            99
        //    92: aload_0        
        //    93: invokevirtual   java/lang/Object.wait:()V
        //    96: goto            46
        //    99: new             Ljava/io/IOException;
        //   102: astore          6
        //   104: ldc_w           "stream closed"
        //   107: astore          15
        //   109: aload           6
        //   111: aload           15
        //   113: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   116: aload           6
        //   118: athrow         
        //   119: aload_0        
        //   120: getfield        okhttp3/internal/framed/FramedConnection.bytesLeftInWriteWindow:J
        //   123: lstore          10
        //   125: lload           4
        //   127: lload           10
        //   129: invokestatic    java/lang/Math.min:(JJ)J
        //   132: lstore          10
        //   134: lload           10
        //   136: l2i            
        //   137: istore          16
        //   139: aload_0        
        //   140: getfield        okhttp3/internal/framed/FramedConnection.frameWriter:Lokhttp3/internal/framed/FrameWriter;
        //   143: astore          13
        //   145: aload           13
        //   147: invokeinterface okhttp3/internal/framed/FrameWriter.maxDataLength:()I
        //   152: istore          9
        //   154: iload           16
        //   156: iload           9
        //   158: invokestatic    java/lang/Math.min:(II)I
        //   161: istore          9
        //   163: aload_0        
        //   164: getfield        okhttp3/internal/framed/FramedConnection.bytesLeftInWriteWindow:J
        //   167: lstore          17
        //   169: iload           9
        //   171: i2l            
        //   172: lstore          19
        //   174: lload           17
        //   176: lload           19
        //   178: lsub           
        //   179: lstore          17
        //   181: aload_0        
        //   182: lload           17
        //   184: putfield        okhttp3/internal/framed/FramedConnection.bytesLeftInWriteWindow:J
        //   187: aload_0        
        //   188: monitorexit    
        //   189: iload           9
        //   191: i2l            
        //   192: lstore          17
        //   194: lload           4
        //   196: lload           17
        //   198: lsub           
        //   199: lstore          4
        //   201: aload_0        
        //   202: getfield        okhttp3/internal/framed/FramedConnection.frameWriter:Lokhttp3/internal/framed/FrameWriter;
        //   205: astore          14
        //   207: iload_2        
        //   208: ifeq            229
        //   211: lload           4
        //   213: lload           7
        //   215: lcmp           
        //   216: istore          12
        //   218: iload           12
        //   220: ifne            229
        //   223: iconst_1       
        //   224: istore          12
        //   226: goto            232
        //   229: iconst_0       
        //   230: istore          12
        //   232: aload           14
        //   234: iload           12
        //   236: iload_1        
        //   237: aload_3        
        //   238: iload           9
        //   240: invokeinterface okhttp3/internal/framed/FrameWriter.data:(ZILokio/Buffer;I)V
        //   245: goto            32
        //   248: astore          6
        //   250: goto            268
        //   253: astore          6
        //   255: new             Ljava/io/InterruptedIOException;
        //   258: astore          15
        //   260: aload           15
        //   262: invokespecial   java/io/InterruptedIOException.<init>:()V
        //   265: aload           15
        //   267: athrow         
        //   268: aload_0        
        //   269: monitorexit    
        //   270: aload           6
        //   272: athrow         
        //   273: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  46     50     253    268    Ljava/lang/InterruptedException;
        //  46     50     248    273    Any
        //  64     68     253    268    Ljava/lang/InterruptedException;
        //  64     68     248    273    Any
        //  70     74     253    268    Ljava/lang/InterruptedException;
        //  70     74     248    273    Any
        //  78     85     253    268    Ljava/lang/InterruptedException;
        //  78     85     248    273    Any
        //  92     96     253    268    Ljava/lang/InterruptedException;
        //  92     96     248    273    Any
        //  99     102    253    268    Ljava/lang/InterruptedException;
        //  99     102    248    273    Any
        //  111    116    253    268    Ljava/lang/InterruptedException;
        //  111    116    248    273    Any
        //  116    119    253    268    Ljava/lang/InterruptedException;
        //  116    119    248    273    Any
        //  119    123    248    273    Any
        //  127    132    248    273    Any
        //  139    143    248    273    Any
        //  145    152    248    273    Any
        //  156    161    248    273    Any
        //  163    167    248    273    Any
        //  182    187    248    273    Any
        //  187    189    248    273    Any
        //  255    258    248    273    Any
        //  260    265    248    273    Any
        //  265    268    248    273    Any
        //  268    270    248    273    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0099:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
    
    void writeSynReply(final int n, final boolean b, final List list) {
        this.frameWriter.synReply(b, n, list);
    }
    
    void writeSynReset(final int n, final ErrorCode errorCode) {
        this.frameWriter.rstStream(n, errorCode);
    }
    
    void writeSynResetLater(final int n, final ErrorCode errorCode) {
        FramedConnection.executor.submit(new FramedConnection$1(this, "OkHttp %s stream %d", new Object[] { this.hostname, n }, n, errorCode));
    }
    
    void writeWindowUpdateLater(final int n, final long n2) {
        FramedConnection.executor.execute(new FramedConnection$2(this, "OkHttp Window Update %s stream %d", new Object[] { this.hostname, n }, n, n2));
    }
}
