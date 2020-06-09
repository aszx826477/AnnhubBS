// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import java.util.NoSuchElementException;
import java.io.EOFException;
import com.google.gson.internal.Streams;
import java.io.StringReader;
import java.io.Reader;
import com.google.gson.stream.JsonReader;
import java.util.Iterator;

public final class JsonStreamParser implements Iterator
{
    private final Object lock;
    private final JsonReader parser;
    
    public JsonStreamParser(final Reader reader) {
        (this.parser = new JsonReader(reader)).setLenient(true);
        this.lock = new Object();
    }
    
    public JsonStreamParser(final String s) {
        this(new StringReader(s));
    }
    
    public boolean hasNext() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/google/gson/JsonStreamParser.lock:Ljava/lang/Object;
        //     4: astore_1       
        //     5: aload_1        
        //     6: monitorenter   
        //     7: aload_0        
        //     8: getfield        com/google/gson/JsonStreamParser.parser:Lcom/google/gson/stream/JsonReader;
        //    11: astore_2       
        //    12: aload_2        
        //    13: invokevirtual   com/google/gson/stream/JsonReader.peek:()Lcom/google/gson/stream/JsonToken;
        //    16: astore_2       
        //    17: getstatic       com/google/gson/stream/JsonToken.END_DOCUMENT:Lcom/google/gson/stream/JsonToken;
        //    20: astore_3       
        //    21: aload_2        
        //    22: aload_3        
        //    23: if_acmpeq       32
        //    26: iconst_1       
        //    27: istore          4
        //    29: goto            37
        //    32: iconst_0       
        //    33: istore          4
        //    35: aconst_null    
        //    36: astore_2       
        //    37: aload_1        
        //    38: monitorexit    
        //    39: iload           4
        //    41: ireturn        
        //    42: astore_2       
        //    43: goto            70
        //    46: astore_2       
        //    47: new             Lcom/google/gson/JsonIOException;
        //    50: astore_3       
        //    51: aload_3        
        //    52: aload_2        
        //    53: invokespecial   com/google/gson/JsonIOException.<init>:(Ljava/lang/Throwable;)V
        //    56: aload_3        
        //    57: athrow         
        //    58: astore_2       
        //    59: new             Lcom/google/gson/JsonSyntaxException;
        //    62: astore_3       
        //    63: aload_3        
        //    64: aload_2        
        //    65: invokespecial   com/google/gson/JsonSyntaxException.<init>:(Ljava/lang/Throwable;)V
        //    68: aload_3        
        //    69: athrow         
        //    70: aload_1        
        //    71: monitorexit    
        //    72: aload_2        
        //    73: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                           
        //  -----  -----  -----  -----  -----------------------------------------------
        //  7      11     58     70     Lcom/google/gson/stream/MalformedJsonException;
        //  7      11     46     58     Ljava/io/IOException;
        //  7      11     42     74     Any
        //  12     16     58     70     Lcom/google/gson/stream/MalformedJsonException;
        //  12     16     46     58     Ljava/io/IOException;
        //  12     16     42     74     Any
        //  17     20     58     70     Lcom/google/gson/stream/MalformedJsonException;
        //  17     20     46     58     Ljava/io/IOException;
        //  17     20     42     74     Any
        //  37     39     42     74     Any
        //  47     50     42     74     Any
        //  52     56     42     74     Any
        //  56     58     42     74     Any
        //  59     62     42     74     Any
        //  64     68     42     74     Any
        //  68     70     42     74     Any
        //  70     72     42     74     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0032:
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
    
    public JsonElement next() {
        if (this.hasNext()) {
            try {
                final JsonReader parser = this.parser;
                try {
                    return Streams.parse(parser);
                }
                catch (JsonParseException ex) {
                    RuntimeException ex2;
                    if (ex.getCause() instanceof EOFException) {
                        ex2 = new NoSuchElementException();
                    }
                    else {
                        ex2 = ex;
                    }
                    throw ex2;
                }
                catch (OutOfMemoryError outOfMemoryError) {
                    throw new JsonParseException("Failed parsing JSON source to Json", outOfMemoryError);
                }
                catch (StackOverflowError stackOverflowError) {
                    throw new JsonParseException("Failed parsing JSON source to Json", stackOverflowError);
                }
            }
            catch (JsonParseException ex3) {}
            catch (OutOfMemoryError outOfMemoryError2) {}
            catch (StackOverflowError stackOverflowError2) {}
        }
        throw new NoSuchElementException();
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
