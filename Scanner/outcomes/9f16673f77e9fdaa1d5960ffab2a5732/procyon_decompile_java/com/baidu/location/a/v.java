// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import com.baidu.location.b.h;
import com.baidu.location.b.e;
import com.baidu.location.b.b;
import com.baidu.location.Jni;
import com.baidu.location.d.j;
import com.baidu.location.b.a;
import java.io.RandomAccessFile;
import java.util.List;
import com.baidu.location.d.i;
import com.baidu.location.b.g;
import android.location.Location;
import java.io.File;
import java.util.ArrayList;

public class v
{
    private static v A;
    private static ArrayList b;
    private static ArrayList c;
    private static ArrayList d;
    private static String e;
    private static final String f;
    private static final String g;
    private static final String h;
    private static final String i;
    private static File j;
    private static int k;
    private static int l;
    private static int m;
    private static int n;
    private static double o;
    private static double p;
    private static double q;
    private static double r;
    private static int s;
    private static int t;
    private static int u;
    private static Location v;
    private static Location w;
    private static Location x;
    private static g y;
    private int B;
    long a;
    private v$a z;
    
    static {
        com.baidu.location.a.v.b = new ArrayList();
        com.baidu.location.a.v.c = new ArrayList();
        com.baidu.location.a.v.d = new ArrayList();
        final StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.location.d.i.a);
        sb.append("/yo.dat");
        com.baidu.location.a.v.e = sb.toString();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(com.baidu.location.d.i.a);
        sb2.append("/yoh.dat");
        f = sb2.toString();
        final StringBuilder sb3 = new StringBuilder();
        sb3.append(com.baidu.location.d.i.a);
        sb3.append("/yom.dat");
        g = sb3.toString();
        final StringBuilder sb4 = new StringBuilder();
        sb4.append(com.baidu.location.d.i.a);
        sb4.append("/yol.dat");
        h = sb4.toString();
        final StringBuilder sb5 = new StringBuilder();
        sb5.append(com.baidu.location.d.i.a);
        sb5.append("/yor.dat");
        i = sb5.toString();
        com.baidu.location.a.v.j = null;
        com.baidu.location.a.v.l = (com.baidu.location.a.v.k = 8);
        com.baidu.location.a.v.m = 16;
        com.baidu.location.a.v.n = 1024;
        com.baidu.location.a.v.o = 0.0;
        com.baidu.location.a.v.p = 0.1;
        com.baidu.location.a.v.q = 30.0;
        com.baidu.location.a.v.r = 100.0;
        com.baidu.location.a.v.s = 0;
        com.baidu.location.a.v.t = 64;
        com.baidu.location.a.v.u = 128;
        com.baidu.location.a.v.v = null;
        com.baidu.location.a.v.w = null;
        com.baidu.location.a.v.x = null;
        com.baidu.location.a.v.y = null;
        com.baidu.location.a.v.A = null;
    }
    
    private v() {
        this.z = null;
        this.B = 0;
        this.a = 0L;
        this.z = new v$a(this);
        this.B = 0;
    }
    
    private static int a(final List p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: astore_2       
        //     2: iload_1        
        //     3: istore_3       
        //     4: ldc             Lcom/baidu/location/a/v;.class
        //     6: astore          4
        //     8: aload           4
        //    10: monitorenter   
        //    11: aload_0        
        //    12: ifnull          514
        //    15: sipush          256
        //    18: istore          5
        //    20: iload_1        
        //    21: iload           5
        //    23: if_icmpgt       514
        //    26: iload_1        
        //    27: ifge            33
        //    30: goto            514
        //    33: getstatic       com/baidu/location/a/v.j:Ljava/io/File;
        //    36: astore          6
        //    38: aload           6
        //    40: ifnonnull       97
        //    43: new             Ljava/io/File;
        //    46: astore          6
        //    48: getstatic       com/baidu/location/a/v.e:Ljava/lang/String;
        //    51: astore          7
        //    53: aload           6
        //    55: aload           7
        //    57: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //    60: aload           6
        //    62: putstatic       com/baidu/location/a/v.j:Ljava/io/File;
        //    65: getstatic       com/baidu/location/a/v.j:Ljava/io/File;
        //    68: astore          6
        //    70: aload           6
        //    72: invokevirtual   java/io/File.exists:()Z
        //    75: istore          5
        //    77: iload           5
        //    79: ifne            97
        //    82: iconst_0       
        //    83: istore          8
        //    85: aconst_null    
        //    86: astore_2       
        //    87: aconst_null    
        //    88: putstatic       com/baidu/location/a/v.j:Ljava/io/File;
        //    91: aload           4
        //    93: monitorexit    
        //    94: bipush          -2
        //    96: ireturn        
        //    97: new             Ljava/io/RandomAccessFile;
        //   100: astore          6
        //   102: getstatic       com/baidu/location/a/v.j:Ljava/io/File;
        //   105: astore          7
        //   107: ldc             "rw"
        //   109: astore          9
        //   111: aload           6
        //   113: aload           7
        //   115: aload           9
        //   117: invokespecial   java/io/RandomAccessFile.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   120: aload           6
        //   122: invokevirtual   java/io/RandomAccessFile.length:()J
        //   125: lstore          10
        //   127: lconst_1       
        //   128: lstore          12
        //   130: lload           10
        //   132: lload           12
        //   134: lcmp           
        //   135: istore          14
        //   137: iload           14
        //   139: ifge            153
        //   142: aload           6
        //   144: invokevirtual   java/io/RandomAccessFile.close:()V
        //   147: aload           4
        //   149: monitorexit    
        //   150: bipush          -3
        //   152: ireturn        
        //   153: iload_3        
        //   154: i2l            
        //   155: lstore          10
        //   157: aload           6
        //   159: lload           10
        //   161: invokevirtual   java/io/RandomAccessFile.seek:(J)V
        //   164: aload           6
        //   166: invokevirtual   java/io/RandomAccessFile.readInt:()I
        //   169: istore_3       
        //   170: aload           6
        //   172: invokevirtual   java/io/RandomAccessFile.readInt:()I
        //   175: istore          15
        //   177: aload           6
        //   179: invokevirtual   java/io/RandomAccessFile.readInt:()I
        //   182: istore          16
        //   184: aload           6
        //   186: invokevirtual   java/io/RandomAccessFile.readInt:()I
        //   189: istore          17
        //   191: aload           6
        //   193: invokevirtual   java/io/RandomAccessFile.readLong:()J
        //   196: lstore          18
        //   198: iload_3        
        //   199: istore          20
        //   201: iload           15
        //   203: istore          21
        //   205: iload           16
        //   207: istore          14
        //   209: iload           17
        //   211: istore          22
        //   213: lload           18
        //   215: lstore          23
        //   217: iload_3        
        //   218: iload           15
        //   220: iload           16
        //   222: iload           17
        //   224: lload           18
        //   226: invokestatic    com/baidu/location/a/v.a:(IIIIJ)Z
        //   229: istore          20
        //   231: iload           20
        //   233: ifeq            483
        //   236: iconst_1       
        //   237: istore          20
        //   239: iload           15
        //   241: iload           20
        //   243: if_icmpge       249
        //   246: goto            483
        //   249: getstatic       com/baidu/location/a/v.n:I
        //   252: istore          21
        //   254: iload           21
        //   256: newarray        B
        //   258: astore          25
        //   260: getstatic       com/baidu/location/a/v.k:I
        //   263: istore          14
        //   265: iload           14
        //   267: ifle            419
        //   270: iload           15
        //   272: ifle            419
        //   275: iload_3        
        //   276: iload           15
        //   278: iadd           
        //   279: iload           20
        //   281: isub           
        //   282: istore          22
        //   284: iload           22
        //   286: iload           16
        //   288: irem           
        //   289: iload           17
        //   291: imul           
        //   292: istore          22
        //   294: iload           22
        //   296: i2l            
        //   297: lstore          26
        //   299: aload           25
        //   301: astore          28
        //   303: lload           23
        //   305: lstore          12
        //   307: lload           26
        //   309: lload           23
        //   311: ladd           
        //   312: lstore          26
        //   314: aload           6
        //   316: lload           26
        //   318: invokevirtual   java/io/RandomAccessFile.seek:(J)V
        //   321: aload           6
        //   323: invokevirtual   java/io/RandomAccessFile.readInt:()I
        //   326: istore          22
        //   328: iload           22
        //   330: ifle            393
        //   333: iload           22
        //   335: iload           17
        //   337: if_icmpge       393
        //   340: aload           6
        //   342: aload           25
        //   344: iconst_0       
        //   345: iload           22
        //   347: invokevirtual   java/io/RandomAccessFile.read:([BII)I
        //   350: pop            
        //   351: iload           22
        //   353: iconst_m1      
        //   354: iadd           
        //   355: istore          22
        //   357: aload           25
        //   359: iload           22
        //   361: baload         
        //   362: istore          29
        //   364: iload           29
        //   366: ifne            393
        //   369: new             Ljava/lang/String;
        //   372: astore          30
        //   374: aload           30
        //   376: aload           25
        //   378: iconst_0       
        //   379: iload           22
        //   381: invokespecial   java/lang/String.<init>:([BII)V
        //   384: aload_2        
        //   385: aload           30
        //   387: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   392: pop            
        //   393: iload           14
        //   395: iconst_m1      
        //   396: iadd           
        //   397: istore          14
        //   399: iload           15
        //   401: iconst_m1      
        //   402: iadd           
        //   403: istore          15
        //   405: lload           12
        //   407: lstore          23
        //   409: aload           28
        //   411: astore          25
        //   413: iconst_1       
        //   414: istore          20
        //   416: goto            265
        //   419: lload           23
        //   421: lstore          12
        //   423: aload           6
        //   425: lload           10
        //   427: invokevirtual   java/io/RandomAccessFile.seek:(J)V
        //   430: aload           6
        //   432: iload_3        
        //   433: invokevirtual   java/io/RandomAccessFile.writeInt:(I)V
        //   436: aload           6
        //   438: iload           15
        //   440: invokevirtual   java/io/RandomAccessFile.writeInt:(I)V
        //   443: aload           6
        //   445: iload           16
        //   447: invokevirtual   java/io/RandomAccessFile.writeInt:(I)V
        //   450: aload           6
        //   452: iload           17
        //   454: invokevirtual   java/io/RandomAccessFile.writeInt:(I)V
        //   457: aload           6
        //   459: lload           23
        //   461: invokevirtual   java/io/RandomAccessFile.writeLong:(J)V
        //   464: aload           6
        //   466: invokevirtual   java/io/RandomAccessFile.close:()V
        //   469: getstatic       com/baidu/location/a/v.k:I
        //   472: iload           14
        //   474: isub           
        //   475: istore          8
        //   477: aload           4
        //   479: monitorexit    
        //   480: iload           8
        //   482: ireturn        
        //   483: aload           6
        //   485: invokevirtual   java/io/RandomAccessFile.close:()V
        //   488: aload           4
        //   490: monitorexit    
        //   491: bipush          -4
        //   493: ireturn        
        //   494: astore_2       
        //   495: goto            509
        //   498: astore_2       
        //   499: aload_2        
        //   500: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   503: aload           4
        //   505: monitorexit    
        //   506: bipush          -5
        //   508: ireturn        
        //   509: aload           4
        //   511: monitorexit    
        //   512: aload_2        
        //   513: athrow         
        //   514: aload           4
        //   516: monitorexit    
        //   517: iconst_m1      
        //   518: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  33     36     498    509    Ljava/lang/Exception;
        //  33     36     494    498    Any
        //  43     46     498    509    Ljava/lang/Exception;
        //  43     46     494    498    Any
        //  48     51     498    509    Ljava/lang/Exception;
        //  48     51     494    498    Any
        //  55     60     498    509    Ljava/lang/Exception;
        //  55     60     494    498    Any
        //  60     65     498    509    Ljava/lang/Exception;
        //  60     65     494    498    Any
        //  65     68     498    509    Ljava/lang/Exception;
        //  65     68     494    498    Any
        //  70     75     498    509    Ljava/lang/Exception;
        //  70     75     494    498    Any
        //  87     91     498    509    Ljava/lang/Exception;
        //  87     91     494    498    Any
        //  97     100    498    509    Ljava/lang/Exception;
        //  97     100    494    498    Any
        //  102    105    498    509    Ljava/lang/Exception;
        //  102    105    494    498    Any
        //  115    120    498    509    Ljava/lang/Exception;
        //  115    120    494    498    Any
        //  120    125    498    509    Ljava/lang/Exception;
        //  120    125    494    498    Any
        //  142    147    498    509    Ljava/lang/Exception;
        //  142    147    494    498    Any
        //  159    164    498    509    Ljava/lang/Exception;
        //  159    164    494    498    Any
        //  164    169    498    509    Ljava/lang/Exception;
        //  164    169    494    498    Any
        //  170    175    498    509    Ljava/lang/Exception;
        //  170    175    494    498    Any
        //  177    182    498    509    Ljava/lang/Exception;
        //  177    182    494    498    Any
        //  184    189    498    509    Ljava/lang/Exception;
        //  184    189    494    498    Any
        //  191    196    498    509    Ljava/lang/Exception;
        //  191    196    494    498    Any
        //  224    229    498    509    Ljava/lang/Exception;
        //  224    229    494    498    Any
        //  249    252    498    509    Ljava/lang/Exception;
        //  249    252    494    498    Any
        //  254    258    498    509    Ljava/lang/Exception;
        //  254    258    494    498    Any
        //  260    263    498    509    Ljava/lang/Exception;
        //  260    263    494    498    Any
        //  286    289    498    509    Ljava/lang/Exception;
        //  286    289    494    498    Any
        //  316    321    498    509    Ljava/lang/Exception;
        //  316    321    494    498    Any
        //  321    326    498    509    Ljava/lang/Exception;
        //  321    326    494    498    Any
        //  345    351    498    509    Ljava/lang/Exception;
        //  345    351    494    498    Any
        //  359    362    498    509    Ljava/lang/Exception;
        //  359    362    494    498    Any
        //  369    372    498    509    Ljava/lang/Exception;
        //  369    372    494    498    Any
        //  379    384    498    509    Ljava/lang/Exception;
        //  379    384    494    498    Any
        //  385    393    498    509    Ljava/lang/Exception;
        //  385    393    494    498    Any
        //  425    430    498    509    Ljava/lang/Exception;
        //  425    430    494    498    Any
        //  432    436    498    509    Ljava/lang/Exception;
        //  432    436    494    498    Any
        //  438    443    498    509    Ljava/lang/Exception;
        //  438    443    494    498    Any
        //  445    450    498    509    Ljava/lang/Exception;
        //  445    450    494    498    Any
        //  452    457    498    509    Ljava/lang/Exception;
        //  452    457    494    498    Any
        //  459    464    498    509    Ljava/lang/Exception;
        //  459    464    494    498    Any
        //  464    469    498    509    Ljava/lang/Exception;
        //  464    469    494    498    Any
        //  469    472    498    509    Ljava/lang/Exception;
        //  469    472    494    498    Any
        //  483    488    498    509    Ljava/lang/Exception;
        //  483    488    494    498    Any
        //  499    503    494    498    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0483:
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
    
    public static v a() {
        synchronized (v.class) {
            if (com.baidu.location.a.v.A == null) {
                com.baidu.location.a.v.A = new v();
            }
            return com.baidu.location.a.v.A;
        }
    }
    
    public static String a(final int n) {
        final int n2 = 1;
        String s = null;
        String s2;
        ArrayList list;
        if (n == n2) {
            s2 = com.baidu.location.a.v.f;
            list = com.baidu.location.a.v.b;
        }
        else if (n == 2) {
            s2 = com.baidu.location.a.v.g;
            list = com.baidu.location.a.v.c;
        }
        else {
            if (n == 3) {
                s2 = com.baidu.location.a.v.h;
            }
            else {
                if (n != 4) {
                    return null;
                }
                s2 = com.baidu.location.a.v.i;
            }
            list = com.baidu.location.a.v.d;
        }
        if (list == null) {
            return null;
        }
        if (list.size() < n2) {
            a(s2, list);
        }
        synchronized (v.class) {
            final int size = list.size();
            if (size > 0) {
                final int n3 = size - n2;
                final ArrayList list2 = list;
                try {
                    final Object value = list2.get(n3);
                    try {
                        final String s3 = (String)value;
                        final ArrayList list3 = list;
                        try {
                            list3.remove(n3);
                            s = s3;
                        }
                        catch (Exception s) {}
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {}
            }
            return s;
        }
        return null;
    }
    
    public static void a(int n, final boolean b) {
        final int n2 = 4;
        final int n3 = 1;
        String s = null;
        ArrayList list = null;
        Label_0102: {
            Label_0019: {
                if (n != n3) {
                    Label_0048: {
                        if (n != 2) {
                            if (n == 3) {
                                s = com.baidu.location.a.v.h;
                                if (b) {
                                    break Label_0048;
                                }
                            }
                            else {
                                if (n != n2) {
                                    return;
                                }
                                s = com.baidu.location.a.v.i;
                                if (!b) {
                                    return;
                                }
                            }
                            list = com.baidu.location.a.v.d;
                            break Label_0102;
                        }
                        s = com.baidu.location.a.v.g;
                        if (b) {
                            break Label_0019;
                        }
                    }
                    list = com.baidu.location.a.v.c;
                    break Label_0102;
                }
                s = com.baidu.location.a.v.f;
                if (b) {
                    return;
                }
            }
            list = com.baidu.location.a.v.b;
        }
        final File file = new File(s);
        if (!file.exists()) {
            a(s);
        }
        try {
            final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(4);
            final int int1 = randomAccessFile.readInt();
            try {
                final int int2 = randomAccessFile.readInt();
                try {
                    int int3 = randomAccessFile.readInt();
                    try {
                        int int4 = randomAccessFile.readInt();
                        try {
                            int int5 = randomAccessFile.readInt();
                            try {
                                int size = list.size();
                                try {
                                    while (true) {
                                        final int l = com.baidu.location.a.v.l;
                                        boolean b2 = false;
                                        Label_0507: {
                                            if (size <= l) {
                                                break Label_0507;
                                            }
                                            if (b) {
                                                ++int5;
                                            }
                                            Label_0360: {
                                                if (int3 >= int1) {
                                                    break Label_0360;
                                                }
                                                randomAccessFile.seek(int2 * int3 + 128);
                                                try {
                                                    final StringBuilder sb = new StringBuilder();
                                                    final ArrayList list2 = list;
                                                    try {
                                                        final Object value = list2.get(0);
                                                        try {
                                                            sb.append((String)value);
                                                            final StringBuilder sb2 = sb;
                                                            try {
                                                                sb2.append('\0');
                                                                final String string = sb.toString();
                                                                try {
                                                                    final byte[] bytes = string.getBytes();
                                                                    try {
                                                                        randomAccessFile.writeInt(bytes.length);
                                                                        randomAccessFile.write(bytes, 0, bytes.length);
                                                                        final ArrayList list3 = list;
                                                                        try {
                                                                            list3.remove(0);
                                                                            ++int3;
                                                                            Label_0495: {
                                                                                break Label_0495;
                                                                                randomAccessFile.seek(int4 * int2 + 128);
                                                                                try {
                                                                                    final StringBuilder sb3 = new StringBuilder();
                                                                                    final ArrayList list4 = list;
                                                                                    try {
                                                                                        final Object value2 = list4.get(0);
                                                                                        try {
                                                                                            sb3.append((String)value2);
                                                                                            final StringBuilder sb4 = sb3;
                                                                                            try {
                                                                                                sb4.append('\0');
                                                                                                final String string2 = sb3.toString();
                                                                                                try {
                                                                                                    final byte[] bytes2 = string2.getBytes();
                                                                                                    try {
                                                                                                        randomAccessFile.writeInt(bytes2.length);
                                                                                                        randomAccessFile.write(bytes2, 0, bytes2.length);
                                                                                                        final ArrayList list5 = list;
                                                                                                        try {
                                                                                                            list5.remove(0);
                                                                                                            ++int4;
                                                                                                            if (int4 > int3) {
                                                                                                                int4 = 0;
                                                                                                            }
                                                                                                            --size;
                                                                                                            continue;
                                                                                                            Label_0504: {
                                                                                                                b2 = true;
                                                                                                            }
                                                                                                            randomAccessFile.seek(12);
                                                                                                            final RandomAccessFile randomAccessFile2 = randomAccessFile;
                                                                                                            try {
                                                                                                                randomAccessFile2.writeInt(int3);
                                                                                                                final RandomAccessFile randomAccessFile3 = randomAccessFile;
                                                                                                                try {
                                                                                                                    randomAccessFile3.writeInt(int4);
                                                                                                                    final RandomAccessFile randomAccessFile4 = randomAccessFile;
                                                                                                                    try {
                                                                                                                        randomAccessFile4.writeInt(int5);
                                                                                                                        randomAccessFile.close();
                                                                                                                        if (b2 && n < n2) {
                                                                                                                            n += n3;
                                                                                                                            a(n, n3 != 0);
                                                                                                                        }
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    catch (Exception ex) {}
                                                                                                                }
                                                                                                                catch (Exception ex2) {}
                                                                                                            }
                                                                                                            catch (Exception ex3) {}
                                                                                                        }
                                                                                                        catch (Exception ex4) {}
                                                                                                    }
                                                                                                    catch (Exception ex5) {}
                                                                                                }
                                                                                                catch (Exception ex6) {}
                                                                                            }
                                                                                            catch (Exception ex7) {}
                                                                                        }
                                                                                        catch (Exception ex8) {}
                                                                                    }
                                                                                    catch (Exception ex9) {}
                                                                                }
                                                                                catch (Exception ex10) {}
                                                                            }
                                                                        }
                                                                        // iftrue(Label_0504:, !b)
                                                                        catch (Exception ex11) {}
                                                                    }
                                                                    catch (Exception ex12) {}
                                                                }
                                                                catch (Exception ex13) {}
                                                            }
                                                            catch (Exception ex14) {}
                                                        }
                                                        catch (Exception ex15) {}
                                                    }
                                                    catch (Exception ex16) {}
                                                }
                                                catch (Exception ex17) {}
                                            }
                                        }
                                    }
                                }
                                catch (Exception ex18) {}
                            }
                            catch (Exception ex19) {}
                        }
                        catch (Exception ex20) {}
                    }
                    catch (Exception ex21) {}
                }
                catch (Exception ex22) {}
            }
            catch (Exception ex23) {}
        }
        catch (Exception ex24) {}
    }
    
    public static void a(final a a, g y, final Location v, String s) {
        final int u = com.baidu.location.d.j.u;
        final int n = 3;
        if (u == n && !a(v, y) && !a(v, false)) {
            return;
        }
        if (a != null) {
            if (!a.c()) {
                if (a != null && a.a()) {
                    if (!a(v, y)) {
                        y = null;
                    }
                    final String a2 = com.baidu.location.d.j.a(a, y, v, s, 1);
                    if (a2 != null) {
                        c(Jni.encode(a2));
                        v.w = v;
                        v.v = v;
                        if (y != null) {
                            v.y = y;
                        }
                    }
                    return;
                }
                if (y != null && y.k() && a(v, y)) {
                    Label_0314: {
                        StringBuilder sb;
                        String s2;
                        if (!a(v) && !com.baidu.location.b.b.a().d()) {
                            sb = new StringBuilder();
                            s2 = "&cfr=1";
                        }
                        else if (!a(v) && com.baidu.location.b.b.a().d()) {
                            sb = new StringBuilder();
                            s2 = "&cfr=3";
                        }
                        else {
                            if (!com.baidu.location.b.b.a().d()) {
                                break Label_0314;
                            }
                            sb = new StringBuilder();
                            s2 = "&cfr=2";
                        }
                        sb.append(s2);
                        sb.append(s);
                        s = sb.toString();
                    }
                    final String a3 = com.baidu.location.d.j.a(a, y, v, s, 2);
                    if (a3 != null) {
                        d(Jni.encode(a3));
                        v.x = v;
                        v.v = v;
                        if (y != null) {
                            v.y = y;
                        }
                    }
                    return;
                }
                Label_0505: {
                    StringBuilder sb2;
                    String s3;
                    if (!a(v) && !com.baidu.location.b.b.a().d()) {
                        sb2 = new StringBuilder();
                        s3 = "&cfr=1";
                    }
                    else if (!a(v) && com.baidu.location.b.b.a().d()) {
                        sb2 = new StringBuilder();
                        s3 = "&cfr=3";
                    }
                    else {
                        if (!com.baidu.location.b.b.a().d()) {
                            break Label_0505;
                        }
                        sb2 = new StringBuilder();
                        s3 = "&cfr=2";
                    }
                    sb2.append(s3);
                    sb2.append(s);
                    s = sb2.toString();
                }
                if (!a(v, y)) {
                    y = null;
                }
                if (a != null || y != null) {
                    final String a4 = com.baidu.location.d.j.a(a, y, v, s, n);
                    if (a4 != null) {
                        e(Jni.encode(a4));
                        v.v = v;
                        if (y != null) {
                            v.y = y;
                        }
                    }
                }
            }
        }
    }
    
    public static void a(final String s) {
        try {
            File file = new File(s);
            if (!file.exists()) {
                try {
                    final File file2 = new File(com.baidu.location.d.i.a);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    if (!file.createNewFile()) {
                        file = null;
                    }
                    final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(0L);
                    randomAccessFile.writeInt(32);
                    randomAccessFile.writeInt(2048);
                    randomAccessFile.writeInt(1040);
                    randomAccessFile.writeInt(0);
                    final RandomAccessFile randomAccessFile2 = randomAccessFile;
                    try {
                        randomAccessFile2.writeInt(0);
                        final RandomAccessFile randomAccessFile3 = randomAccessFile;
                        try {
                            randomAccessFile3.writeInt(0);
                            randomAccessFile.close();
                        }
                        catch (Exception ex) {}
                    }
                    catch (Exception ex2) {}
                }
                catch (Exception ex3) {}
            }
        }
        catch (Exception ex4) {}
    }
    
    private static boolean a(int n, int n2, final int n3, final int n4, final long n5) {
        if (n >= 0) {
            if (n < n3) {
                if (n2 >= 0) {
                    if (n2 <= n3) {
                        if (n3 >= 0) {
                            n = 1024;
                            if (n3 <= n) {
                                n2 = 128;
                                if (n4 >= n2) {
                                    if (n4 <= n) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static boolean a(final Location w) {
        boolean b = false;
        if (w == null) {
            return false;
        }
        final Location w2 = com.baidu.location.a.v.w;
        final boolean b2 = true;
        if (w2 != null && com.baidu.location.a.v.v != null) {
            final double n = w.distanceTo(w2);
            final double n2 = com.baidu.location.d.j.R;
            Double.isNaN(n2);
            Double.isNaN(n);
            final double n3 = n2 * n;
            Double.isNaN(n);
            final double n4 = n3 * n;
            final double n5 = com.baidu.location.d.j.S;
            Double.isNaN(n5);
            Double.isNaN(n);
            final double n6 = n4 + n5 * n;
            final double n7 = com.baidu.location.d.j.T;
            Double.isNaN(n7);
            if (w.distanceTo(com.baidu.location.a.v.v) > n6 + n7) {
                b = true;
            }
            return b;
        }
        com.baidu.location.a.v.w = w;
        return b2;
    }
    
    private static boolean a(final Location x, final g g) {
        boolean b = false;
        if (x != null && g != null && g.a != null) {
            if (!g.a.isEmpty()) {
                if (g.b(com.baidu.location.a.v.y)) {
                    return false;
                }
                final Location x2 = com.baidu.location.a.v.x;
                b = true;
                if (x2 == null) {
                    com.baidu.location.a.v.x = x;
                }
            }
        }
        return b;
    }
    
    public static boolean a(final Location location, final boolean b) {
        return com.baidu.location.b.e.a(com.baidu.location.a.v.v, location, b);
    }
    
    public static boolean a(final String s, final List list) {
        final File file = new File(s);
        if (!file.exists()) {
            return false;
        }
        boolean b = false;
        try {
            final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(8);
            final int int1 = randomAccessFile.readInt();
            try {
                int int2 = randomAccessFile.readInt();
                try {
                    int int3 = randomAccessFile.readInt();
                    try {
                        final int n = com.baidu.location.a.v.n;
                        try {
                            final byte[] array = new byte[n];
                            try {
                                int n2 = com.baidu.location.a.v.l + 1;
                                b = false;
                                while (true) {
                                    Label_0225: {
                                        if (n2 <= 0 || int2 <= 0) {
                                            break Label_0225;
                                        }
                                        if (int2 < int3) {
                                            int3 = 0;
                                        }
                                        final long n3 = (int2 - 1) * int1 + 128;
                                        final RandomAccessFile randomAccessFile2 = randomAccessFile;
                                        try {
                                            randomAccessFile2.seek(n3);
                                            final int int4 = randomAccessFile.readInt();
                                            if (int4 > 0 && int4 < int1) {
                                                randomAccessFile.read(array, 0, int4);
                                                final int n4 = int4 - 1;
                                                if (array[n4] == 0) {
                                                    list.add(0, new String(array, 0, n4));
                                                    b = true;
                                                }
                                            }
                                            --n2;
                                            --int2;
                                            continue;
                                            randomAccessFile.seek(12);
                                            final RandomAccessFile randomAccessFile3 = randomAccessFile;
                                            try {
                                                randomAccessFile3.writeInt(int2);
                                                final RandomAccessFile randomAccessFile4 = randomAccessFile;
                                                try {
                                                    randomAccessFile4.writeInt(int3);
                                                    randomAccessFile.close();
                                                    return b;
                                                }
                                                catch (Exception ex) {}
                                            }
                                            catch (Exception ex2) {}
                                        }
                                        catch (Exception ex3) {}
                                    }
                                }
                            }
                            catch (Exception ex4) {
                                b = false;
                            }
                        }
                        catch (Exception ex5) {}
                    }
                    catch (Exception ex6) {}
                }
                catch (Exception ex7) {}
            }
            catch (Exception ex8) {}
        }
        catch (Exception ex9) {}
        return b;
    }
    
    public static String b() {
        return d();
    }
    
    public static void b(final String s) {
        final Class<v> clazz = v.class;
        // monitorenter(clazz)
        final String s2 = "err!";
        try {
            if (s.contains(s2)) {
                return;
            }
            final int p = com.baidu.location.d.j.p;
            ArrayList list;
            if (p == 1) {
                list = com.baidu.location.a.v.b;
            }
            else if (p == 2) {
                list = com.baidu.location.a.v.c;
            }
            else {
                if (p != 3) {
                    return;
                }
                list = com.baidu.location.a.v.d;
            }
            if (list == null) {
                return;
            }
            if (list.size() <= com.baidu.location.a.v.m) {
                list.add(s);
            }
            if (list.size() >= com.baidu.location.a.v.m) {
                a(p, false);
            }
            while (list.size() > com.baidu.location.a.v.m) {
                list.remove(0);
            }
        }
        finally {
        }
        // monitorexit(clazz)
    }
    
    private static void c(final String s) {
        b(s);
    }
    
    public static String d() {
        int i = 1;
        String a = null;
        while (i < 5) {
            a = a(i);
            if (a != null) {
                return a;
            }
            ++i;
        }
        a(com.baidu.location.a.v.d, com.baidu.location.a.v.t);
        if (com.baidu.location.a.v.d.size() > 0) {
            a = com.baidu.location.a.v.d.get(0);
            com.baidu.location.a.v.d.remove(0);
        }
        if (a != null) {
            return a;
        }
        a(com.baidu.location.a.v.d, com.baidu.location.a.v.s);
        if (com.baidu.location.a.v.d.size() > 0) {
            a = com.baidu.location.a.v.d.get(0);
            com.baidu.location.a.v.d.remove(0);
        }
        if (a != null) {
            return a;
        }
        a(com.baidu.location.a.v.d, com.baidu.location.a.v.u);
        if (com.baidu.location.a.v.d.size() > 0) {
            a = com.baidu.location.a.v.d.get(0);
            com.baidu.location.a.v.d.remove(0);
        }
        return a;
    }
    
    private static void d(final String s) {
        b(s);
    }
    
    public static void e() {
        com.baidu.location.a.v.l = 0;
        a(1, false);
        a(2, false);
        a(3, false);
        com.baidu.location.a.v.l = 8;
    }
    
    private static void e(final String s) {
        b(s);
    }
    
    public static String f() {
        final File file = new File(com.baidu.location.a.v.g);
        final boolean exists = file.exists();
        final long n = 20;
        String s = null;
        if (exists) {
            try {
                final RandomAccessFile randomAccessFile2;
                final RandomAccessFile randomAccessFile = randomAccessFile2 = new RandomAccessFile(file, "rw");
                try {
                    randomAccessFile2.seek(n);
                    final int int1 = randomAccessFile.readInt();
                    Label_0127: {
                        if (int1 <= 128) {
                            break Label_0127;
                        }
                        try {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("&p1=");
                            final StringBuilder sb2 = sb;
                            try {
                                sb2.append(int1);
                                final String string = sb.toString();
                                final RandomAccessFile randomAccessFile3 = randomAccessFile;
                                try {
                                    randomAccessFile3.seek(n);
                                    final RandomAccessFile randomAccessFile4 = randomAccessFile;
                                    try {
                                        randomAccessFile4.writeInt(0);
                                        randomAccessFile.close();
                                        return string;
                                    }
                                    catch (Exception ex) {
                                        s = string;
                                    }
                                }
                                catch (Exception ex2) {}
                                randomAccessFile.close();
                            }
                            catch (Exception ex3) {}
                        }
                        catch (Exception ex4) {}
                    }
                }
                catch (Exception ex5) {}
            }
            catch (Exception ex6) {}
        }
        final File file2 = new File(com.baidu.location.a.v.h);
        if (file2.exists()) {
            try {
                final RandomAccessFile randomAccessFile6;
                final RandomAccessFile randomAccessFile5 = randomAccessFile6 = new RandomAccessFile(file2, "rw");
                try {
                    randomAccessFile6.seek(n);
                    final int int2 = randomAccessFile5.readInt();
                    Label_0255: {
                        if (int2 <= 256) {
                            break Label_0255;
                        }
                        try {
                            final StringBuilder sb3 = new StringBuilder();
                            sb3.append("&p2=");
                            final StringBuilder sb4 = sb3;
                            try {
                                sb4.append(int2);
                                final String string2 = sb3.toString();
                                final RandomAccessFile randomAccessFile7 = randomAccessFile5;
                                try {
                                    randomAccessFile7.seek(n);
                                    final RandomAccessFile randomAccessFile8 = randomAccessFile5;
                                    try {
                                        randomAccessFile8.writeInt(0);
                                        randomAccessFile5.close();
                                        return string2;
                                    }
                                    catch (Exception ex7) {
                                        s = string2;
                                    }
                                }
                                catch (Exception ex8) {}
                                randomAccessFile5.close();
                            }
                            catch (Exception ex9) {}
                        }
                        catch (Exception ex10) {}
                    }
                }
                catch (Exception ex11) {}
            }
            catch (Exception ex12) {}
        }
        final File file3 = new File(com.baidu.location.a.v.i);
        if (file3.exists()) {
            try {
                final RandomAccessFile randomAccessFile10;
                final RandomAccessFile randomAccessFile9 = randomAccessFile10 = new RandomAccessFile(file3, "rw");
                try {
                    randomAccessFile10.seek(n);
                    final int int3 = randomAccessFile9.readInt();
                    Label_0383: {
                        if (int3 <= 512) {
                            break Label_0383;
                        }
                        try {
                            final StringBuilder sb5 = new StringBuilder();
                            sb5.append("&p3=");
                            final StringBuilder sb6 = sb5;
                            try {
                                sb6.append(int3);
                                final String string3 = sb5.toString();
                                final RandomAccessFile randomAccessFile11 = randomAccessFile9;
                                try {
                                    randomAccessFile11.seek(n);
                                    final RandomAccessFile randomAccessFile12 = randomAccessFile9;
                                    try {
                                        randomAccessFile12.writeInt(0);
                                        randomAccessFile9.close();
                                        return string3;
                                    }
                                    catch (Exception ex13) {
                                        s = string3;
                                    }
                                }
                                catch (Exception ex14) {}
                                randomAccessFile9.close();
                            }
                            catch (Exception ex15) {}
                        }
                        catch (Exception ex16) {}
                    }
                }
                catch (Exception ex17) {}
            }
            catch (Exception ex18) {}
        }
        return s;
    }
    
    public void c() {
        if (!com.baidu.location.b.h.i()) {
            return;
        }
        this.z.b();
    }
}
