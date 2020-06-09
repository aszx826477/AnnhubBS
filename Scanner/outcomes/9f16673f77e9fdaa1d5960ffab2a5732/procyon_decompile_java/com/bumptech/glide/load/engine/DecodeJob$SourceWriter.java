// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import java.io.File;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.engine.cache.DiskCache$Writer;

class DecodeJob$SourceWriter implements DiskCache$Writer
{
    private final Object data;
    private final Encoder encoder;
    final /* synthetic */ DecodeJob this$0;
    
    public DecodeJob$SourceWriter(final DecodeJob this$0, final Encoder encoder, final Object data) {
        this.this$0 = this$0;
        this.encoder = encoder;
        this.data = data;
    }
    
    public boolean write(final File p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: iconst_0       
        //     1: istore_2       
        //     2: aconst_null    
        //     3: astore_3       
        //     4: aload_0        
        //     5: getfield        com/bumptech/glide/load/engine/DecodeJob$SourceWriter.this$0:Lcom/bumptech/glide/load/engine/DecodeJob;
        //     8: astore          4
        //    10: aload           4
        //    12: invokestatic    com/bumptech/glide/load/engine/DecodeJob.access$000:(Lcom/bumptech/glide/load/engine/DecodeJob;)Lcom/bumptech/glide/load/engine/DecodeJob$FileOpener;
        //    15: astore          4
        //    17: aload           4
        //    19: aload_1        
        //    20: invokevirtual   com/bumptech/glide/load/engine/DecodeJob$FileOpener.open:(Ljava/io/File;)Ljava/io/OutputStream;
        //    23: astore          4
        //    25: aload           4
        //    27: astore_3       
        //    28: aload_0        
        //    29: getfield        com/bumptech/glide/load/engine/DecodeJob$SourceWriter.encoder:Lcom/bumptech/glide/load/Encoder;
        //    32: astore          4
        //    34: aload_0        
        //    35: getfield        com/bumptech/glide/load/engine/DecodeJob$SourceWriter.data:Ljava/lang/Object;
        //    38: astore          5
        //    40: aload           4
        //    42: aload           5
        //    44: aload_3        
        //    45: invokeinterface com/bumptech/glide/load/Encoder.encode:(Ljava/lang/Object;Ljava/io/OutputStream;)Z
        //    50: istore          6
        //    52: iload           6
        //    54: istore_2       
        //    55: aload_3        
        //    56: ifnull          71
        //    59: aload_3        
        //    60: invokevirtual   java/io/OutputStream.close:()V
        //    63: goto            134
        //    66: astore          4
        //    68: goto            63
        //    71: goto            134
        //    74: astore          4
        //    76: goto            136
        //    79: astore          4
        //    81: ldc             "DecodeJob"
        //    83: astore          5
        //    85: iconst_3       
        //    86: istore          7
        //    88: aload           5
        //    90: iload           7
        //    92: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //    95: istore          8
        //    97: iload           8
        //    99: ifeq            123
        //   102: ldc             "DecodeJob"
        //   104: astore          5
        //   106: ldc             "Failed to find file to write to disk cache"
        //   108: astore          9
        //   110: aload           5
        //   112: aload           9
        //   114: aload           4
        //   116: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   119: pop            
        //   120: goto            123
        //   123: aload_3        
        //   124: ifnull          71
        //   127: aload_3        
        //   128: invokevirtual   java/io/OutputStream.close:()V
        //   131: goto            63
        //   134: iload_2        
        //   135: ireturn        
        //   136: aload_3        
        //   137: ifnull          152
        //   140: aload_3        
        //   141: invokevirtual   java/io/OutputStream.close:()V
        //   144: goto            152
        //   147: astore          5
        //   149: goto            152
        //   152: aload           4
        //   154: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  4      8      79     134    Ljava/io/FileNotFoundException;
        //  4      8      74     155    Any
        //  10     15     79     134    Ljava/io/FileNotFoundException;
        //  10     15     74     155    Any
        //  19     23     79     134    Ljava/io/FileNotFoundException;
        //  19     23     74     155    Any
        //  28     32     79     134    Ljava/io/FileNotFoundException;
        //  28     32     74     155    Any
        //  34     38     79     134    Ljava/io/FileNotFoundException;
        //  34     38     74     155    Any
        //  44     50     79     134    Ljava/io/FileNotFoundException;
        //  44     50     74     155    Any
        //  59     63     66     71     Ljava/io/IOException;
        //  90     95     74     155    Any
        //  114    120    74     155    Any
        //  127    131    66     71     Ljava/io/IOException;
        //  140    144    147    152    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0063:
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
}
