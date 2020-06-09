// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import okhttp3.internal.NamedRunnable;

class FramedConnection$Reader$1 extends NamedRunnable
{
    final /* synthetic */ FramedConnection$Reader this$1;
    final /* synthetic */ FramedStream val$newStream;
    
    FramedConnection$Reader$1(final FramedConnection$Reader this$1, final String s, final Object[] array, final FramedStream val$newStream) {
        this.this$1 = this$1;
        this.val$newStream = val$newStream;
        super(s, array);
    }
    
    public void execute() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        okhttp3/internal/framed/FramedConnection$Reader$1.this$1:Lokhttp3/internal/framed/FramedConnection$Reader;
        //     4: astore_1       
        //     5: aload_1        
        //     6: getfield        okhttp3/internal/framed/FramedConnection$Reader.this$0:Lokhttp3/internal/framed/FramedConnection;
        //     9: astore_1       
        //    10: aload_1        
        //    11: invokestatic    okhttp3/internal/framed/FramedConnection.access$2000:(Lokhttp3/internal/framed/FramedConnection;)Lokhttp3/internal/framed/FramedConnection$Listener;
        //    14: astore_1       
        //    15: aload_0        
        //    16: getfield        okhttp3/internal/framed/FramedConnection$Reader$1.val$newStream:Lokhttp3/internal/framed/FramedStream;
        //    19: astore_2       
        //    20: aload_1        
        //    21: aload_2        
        //    22: invokevirtual   okhttp3/internal/framed/FramedConnection$Listener.onStream:(Lokhttp3/internal/framed/FramedStream;)V
        //    25: goto            108
        //    28: astore_1       
        //    29: invokestatic    okhttp3/internal/platform/Platform.get:()Lokhttp3/internal/platform/Platform;
        //    32: astore_2       
        //    33: iconst_4       
        //    34: istore_3       
        //    35: new             Ljava/lang/StringBuilder;
        //    38: astore          4
        //    40: aload           4
        //    42: invokespecial   java/lang/StringBuilder.<init>:()V
        //    45: aload           4
        //    47: ldc             "FramedConnection.Listener failure for "
        //    49: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    52: pop            
        //    53: aload_0        
        //    54: getfield        okhttp3/internal/framed/FramedConnection$Reader$1.this$1:Lokhttp3/internal/framed/FramedConnection$Reader;
        //    57: getfield        okhttp3/internal/framed/FramedConnection$Reader.this$0:Lokhttp3/internal/framed/FramedConnection;
        //    60: invokestatic    okhttp3/internal/framed/FramedConnection.access$1100:(Lokhttp3/internal/framed/FramedConnection;)Ljava/lang/String;
        //    63: astore          5
        //    65: aload           4
        //    67: aload           5
        //    69: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    72: pop            
        //    73: aload           4
        //    75: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    78: astore          4
        //    80: aload_2        
        //    81: iload_3        
        //    82: aload           4
        //    84: aload_1        
        //    85: invokevirtual   okhttp3/internal/platform/Platform.log:(ILjava/lang/String;Ljava/lang/Throwable;)V
        //    88: aload_0        
        //    89: getfield        okhttp3/internal/framed/FramedConnection$Reader$1.val$newStream:Lokhttp3/internal/framed/FramedStream;
        //    92: astore_2       
        //    93: getstatic       okhttp3/internal/framed/ErrorCode.PROTOCOL_ERROR:Lokhttp3/internal/framed/ErrorCode;
        //    96: astore          6
        //    98: aload_2        
        //    99: aload           6
        //   101: invokevirtual   okhttp3/internal/framed/FramedStream.close:(Lokhttp3/internal/framed/ErrorCode;)V
        //   104: goto            108
        //   107: astore_2       
        //   108: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      4      28     108    Ljava/io/IOException;
        //  5      9      28     108    Ljava/io/IOException;
        //  10     14     28     108    Ljava/io/IOException;
        //  15     19     28     108    Ljava/io/IOException;
        //  21     25     28     108    Ljava/io/IOException;
        //  88     92     107    108    Ljava/io/IOException;
        //  93     96     107    108    Ljava/io/IOException;
        //  99     104    107    108    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 57, Size: 57
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
}
