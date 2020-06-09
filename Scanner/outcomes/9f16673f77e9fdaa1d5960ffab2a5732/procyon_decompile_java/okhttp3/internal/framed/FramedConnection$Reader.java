// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import okio.Buffer;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.internal.Util;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.net.Socket;
import java.util.Map;
import java.util.Set;
import java.io.Closeable;
import okhttp3.Protocol;
import java.util.concurrent.ExecutorService;
import java.util.List;
import okio.BufferedSource;
import okio.ByteString;
import okhttp3.internal.NamedRunnable;

class FramedConnection$Reader extends NamedRunnable implements FrameReader$Handler
{
    final FrameReader frameReader;
    final /* synthetic */ FramedConnection this$0;
    
    private FramedConnection$Reader(final FramedConnection this$0, final FrameReader frameReader) {
        this.this$0 = this$0;
        super("OkHttp %s", new Object[] { this$0.hostname });
        this.frameReader = frameReader;
    }
    
    private void applyAndAckSettings(final Settings settings) {
        FramedConnection.executor.execute(new FramedConnection$Reader$3(this, "OkHttp %s ACK Settings", new Object[] { this.this$0.hostname }, settings));
    }
    
    public void ackSettings() {
    }
    
    public void alternateService(final int n, final String s, final ByteString byteString, final String s2, final int n2, final long n3) {
    }
    
    public void data(final boolean b, final int n, final BufferedSource bufferedSource, final int n2) {
        if (this.this$0.pushedStream(n)) {
            this.this$0.pushDataLater(n, bufferedSource, n2, b);
            return;
        }
        final FramedStream stream = this.this$0.getStream(n);
        if (stream == null) {
            this.this$0.writeSynResetLater(n, ErrorCode.INVALID_STREAM);
            bufferedSource.skip(n2);
            return;
        }
        stream.receiveData(bufferedSource, n2);
        if (b) {
            stream.receiveFin();
        }
    }
    
    protected void execute() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: getstatic       okhttp3/internal/framed/ErrorCode.INTERNAL_ERROR:Lokhttp3/internal/framed/ErrorCode;
        //     3: astore_1       
        //     4: getstatic       okhttp3/internal/framed/ErrorCode.INTERNAL_ERROR:Lokhttp3/internal/framed/ErrorCode;
        //     7: astore_2       
        //     8: aload_0        
        //     9: getfield        okhttp3/internal/framed/FramedConnection$Reader.this$0:Lokhttp3/internal/framed/FramedConnection;
        //    12: astore_3       
        //    13: aload_3        
        //    14: getfield        okhttp3/internal/framed/FramedConnection.client:Z
        //    17: istore          4
        //    19: iload           4
        //    21: ifne            38
        //    24: aload_0        
        //    25: getfield        okhttp3/internal/framed/FramedConnection$Reader.frameReader:Lokhttp3/internal/framed/FrameReader;
        //    28: astore_3       
        //    29: aload_3        
        //    30: invokeinterface okhttp3/internal/framed/FrameReader.readConnectionPreface:()V
        //    35: goto            38
        //    38: aload_0        
        //    39: getfield        okhttp3/internal/framed/FramedConnection$Reader.frameReader:Lokhttp3/internal/framed/FrameReader;
        //    42: astore_3       
        //    43: aload_3        
        //    44: aload_0        
        //    45: invokeinterface okhttp3/internal/framed/FrameReader.nextFrame:(Lokhttp3/internal/framed/FrameReader$Handler;)Z
        //    50: istore          4
        //    52: iload           4
        //    54: ifeq            60
        //    57: goto            38
        //    60: getstatic       okhttp3/internal/framed/ErrorCode.NO_ERROR:Lokhttp3/internal/framed/ErrorCode;
        //    63: astore_3       
        //    64: aload_3        
        //    65: astore_1       
        //    66: getstatic       okhttp3/internal/framed/ErrorCode.CANCEL:Lokhttp3/internal/framed/ErrorCode;
        //    69: astore_3       
        //    70: aload_3        
        //    71: astore_2       
        //    72: aload_0        
        //    73: getfield        okhttp3/internal/framed/FramedConnection$Reader.this$0:Lokhttp3/internal/framed/FramedConnection;
        //    76: astore_3       
        //    77: aload_3        
        //    78: aload_1        
        //    79: aload_2        
        //    80: invokestatic    okhttp3/internal/framed/FramedConnection.access$1200:(Lokhttp3/internal/framed/FramedConnection;Lokhttp3/internal/framed/ErrorCode;Lokhttp3/internal/framed/ErrorCode;)V
        //    83: goto            123
        //    86: astore_3       
        //    87: goto            127
        //    90: astore_3       
        //    91: goto            135
        //    94: astore_3       
        //    95: getstatic       okhttp3/internal/framed/ErrorCode.PROTOCOL_ERROR:Lokhttp3/internal/framed/ErrorCode;
        //    98: astore          5
        //   100: aload           5
        //   102: astore_1       
        //   103: getstatic       okhttp3/internal/framed/ErrorCode.PROTOCOL_ERROR:Lokhttp3/internal/framed/ErrorCode;
        //   106: astore          5
        //   108: aload           5
        //   110: astore_2       
        //   111: aload_0        
        //   112: getfield        okhttp3/internal/framed/FramedConnection$Reader.this$0:Lokhttp3/internal/framed/FramedConnection;
        //   115: astore_3       
        //   116: aload_3        
        //   117: aload_1        
        //   118: aload           5
        //   120: invokestatic    okhttp3/internal/framed/FramedConnection.access$1200:(Lokhttp3/internal/framed/FramedConnection;Lokhttp3/internal/framed/ErrorCode;Lokhttp3/internal/framed/ErrorCode;)V
        //   123: goto            127
        //   126: astore_3       
        //   127: aload_0        
        //   128: getfield        okhttp3/internal/framed/FramedConnection$Reader.frameReader:Lokhttp3/internal/framed/FrameReader;
        //   131: invokestatic    okhttp3/internal/Util.closeQuietly:(Ljava/io/Closeable;)V
        //   134: return         
        //   135: aload_0        
        //   136: getfield        okhttp3/internal/framed/FramedConnection$Reader.this$0:Lokhttp3/internal/framed/FramedConnection;
        //   139: astore          5
        //   141: aload           5
        //   143: aload_1        
        //   144: aload_2        
        //   145: invokestatic    okhttp3/internal/framed/FramedConnection.access$1200:(Lokhttp3/internal/framed/FramedConnection;Lokhttp3/internal/framed/ErrorCode;Lokhttp3/internal/framed/ErrorCode;)V
        //   148: goto            153
        //   151: astore          5
        //   153: aload_0        
        //   154: getfield        okhttp3/internal/framed/FramedConnection$Reader.frameReader:Lokhttp3/internal/framed/FrameReader;
        //   157: invokestatic    okhttp3/internal/Util.closeQuietly:(Ljava/io/Closeable;)V
        //   160: aload_3        
        //   161: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  8      12     94     123    Ljava/io/IOException;
        //  8      12     90     162    Any
        //  13     17     94     123    Ljava/io/IOException;
        //  13     17     90     162    Any
        //  24     28     94     123    Ljava/io/IOException;
        //  24     28     90     162    Any
        //  29     35     94     123    Ljava/io/IOException;
        //  29     35     90     162    Any
        //  38     42     94     123    Ljava/io/IOException;
        //  38     42     90     162    Any
        //  44     50     94     123    Ljava/io/IOException;
        //  44     50     90     162    Any
        //  60     63     94     123    Ljava/io/IOException;
        //  60     63     90     162    Any
        //  66     69     94     123    Ljava/io/IOException;
        //  66     69     90     162    Any
        //  72     76     86     90     Ljava/io/IOException;
        //  79     83     86     90     Ljava/io/IOException;
        //  95     98     90     162    Any
        //  103    106    90     162    Any
        //  111    115    126    127    Ljava/io/IOException;
        //  118    123    126    127    Ljava/io/IOException;
        //  135    139    151    153    Ljava/io/IOException;
        //  144    148    151    153    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 84, Size: 84
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
    
    public void goAway(final int n, final ErrorCode errorCode, final ByteString byteString) {
        byteString.size();
        synchronized (this.this$0) {
            final FramedStream[] array = (FramedStream[])this.this$0.streams.values().toArray(new FramedStream[this.this$0.streams.size()]);
            this.this$0.shutdown = true;
            // monitorexit(this.this$0)
            for (int length = array.length, i = 0; i < length; ++i) {
                final FramedStream framedStream = array[i];
                if (framedStream.getId() > n && framedStream.isLocallyInitiated()) {
                    framedStream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    this.this$0.removeStream(framedStream.getId());
                }
            }
        }
    }
    
    public void headers(final boolean b, final boolean b2, final int n, final int n2, final List list, final HeadersMode headersMode) {
        if (this.this$0.pushedStream(n)) {
            this.this$0.pushHeadersLater(n, list, b2);
            return;
        }
        final FramedConnection this$0 = this.this$0;
        // monitorenter(this$0)
        try {
            if (this.this$0.shutdown) {
                // monitorexit(this$0)
                return;
            }
            final FramedStream stream = this.this$0.getStream(n);
            if (stream == null) {
                if (headersMode.failIfStreamAbsent()) {
                    this.this$0.writeSynResetLater(n, ErrorCode.INVALID_STREAM);
                    // monitorexit(this$0)
                    return;
                }
                if (n <= this.this$0.lastGoodStreamId) {
                    // monitorexit(this$0)
                    return;
                }
                final int n3 = n % 2;
                final int access$1800 = this.this$0.nextStreamId;
                final int n4 = 2;
                if (n3 == access$1800 % n4) {
                    // monitorexit(this$0)
                    return;
                }
                final FramedConnection this$2;
                final FramedStream framedStream = new FramedStream(n, this$2, b, b2, list);
                this$2 = this.this$0;
                this.this$0.lastGoodStreamId = n;
                this.this$0.streams.put(n, framedStream);
                final ExecutorService access$1801 = FramedConnection.executor;
                final String s = "OkHttp %s stream %d";
                final Object[] array = new Object[n4];
                array[0] = this.this$0.hostname;
                array[1] = n;
                access$1801.execute(new FramedConnection$Reader$1(this, s, array, framedStream));
            }
            // monitorexit(this$0)
            else {
                // monitorexit(this$0)
                if (headersMode.failIfStreamPresent()) {
                    stream.closeLater(ErrorCode.PROTOCOL_ERROR);
                    this.this$0.removeStream(n);
                    return;
                }
                stream.receiveHeaders(list, headersMode);
                if (b2) {
                    stream.receiveFin();
                }
            }
        }
        finally {
            try {
            }
            // monitorexit(this$0)
            finally {}
        }
    }
    
    public void ping(final boolean b, final int n, final int n2) {
        if (b) {
            final Ping access$2400 = this.this$0.removePing(n);
            if (access$2400 != null) {
                access$2400.receive();
            }
        }
        else {
            this.this$0.writePingLater(true, n, n2, null);
        }
    }
    
    public void priority(final int n, final int n2, final int n3, final boolean b) {
    }
    
    public void pushPromise(final int n, final int n2, final List list) {
        this.this$0.pushRequestLater(n2, list);
    }
    
    public void rstStream(final int n, final ErrorCode errorCode) {
        if (this.this$0.pushedStream(n)) {
            this.this$0.pushResetLater(n, errorCode);
            return;
        }
        final FramedStream removeStream = this.this$0.removeStream(n);
        if (removeStream != null) {
            removeStream.receiveRstStream(errorCode);
        }
    }
    
    public void settings(final boolean b, final Settings settings) {
        long n = 0L;
        FramedStream[] array = null;
        synchronized (this.this$0) {
            final Settings peerSettings = this.this$0.peerSettings;
            final int n2 = 65536;
            final int initialWindowSize = peerSettings.getInitialWindowSize(n2);
            if (b) {
                this.this$0.peerSettings.clear();
            }
            this.this$0.peerSettings.merge(settings);
            if (this.this$0.getProtocol() == Protocol.HTTP_2) {
                this.applyAndAckSettings(settings);
            }
            final int initialWindowSize2 = this.this$0.peerSettings.getInitialWindowSize(n2);
            final int n3 = -1;
            final int n4 = 1;
            if (initialWindowSize2 != n3 && initialWindowSize2 != initialWindowSize) {
                n = initialWindowSize2 - initialWindowSize;
                if (!this.this$0.receivedInitialPeerSettings) {
                    this.this$0.addBytesToWriteWindow(n);
                    this.this$0.receivedInitialPeerSettings = (n4 != 0);
                }
                if (!this.this$0.streams.isEmpty()) {
                    array = (FramedStream[])this.this$0.streams.values().toArray(new FramedStream[this.this$0.streams.size()]);
                }
            }
            final ExecutorService access$2100 = FramedConnection.executor;
            final String s = "OkHttp %s settings";
            final Object[] array2 = new Object[n4];
            final String access$2101 = this.this$0.hostname;
            int i = 0;
            array2[0] = access$2101;
            access$2100.execute(new FramedConnection$Reader$2(this, s, array2));
            // monitorexit(this.this$0)
            if (array != null && n != 0L) {
                while (i < array.length) {
                    final FramedStream framedStream = array[i];
                    // monitorenter(framedStream)
                    final FramedStream framedStream2 = framedStream;
                    try {
                        framedStream2.addBytesToWriteWindow(n);
                        // monitorexit(framedStream)
                        ++i;
                        continue;
                    }
                    finally {
                    }
                    // monitorexit(framedStream)
                    break;
                }
            }
        }
    }
    
    public void windowUpdate(final int n, final long n2) {
        if (n == 0) {
            synchronized (this.this$0) {
                final FramedConnection this$0 = this.this$0;
                this$0.bytesLeftInWriteWindow += n2;
                this.this$0.notifyAll();
                return;
            }
        }
        final FramedStream stream = this.this$0.getStream(n);
        if (stream != null) {
            // monitorenter(stream)
            final FramedStream framedStream = stream;
            try {
                framedStream.addBytesToWriteWindow(n2);
            }
            finally {
            }
            // monitorexit(stream)
        }
    }
}
