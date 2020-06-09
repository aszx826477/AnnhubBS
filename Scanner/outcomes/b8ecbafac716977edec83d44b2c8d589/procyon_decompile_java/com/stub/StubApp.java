// 
// Decompiled by Procyon v0.5.30
// 

package com.stub;

import com.qihoo.util.Configuration;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.content.res.Resources;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.File;
import android.os.Build$VERSION;
import android.location.Location;
import android.location.LocationManager;
import java.io.InputStream;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import java.util.Enumeration;
import dalvik.system.DexFile;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import android.content.Context;
import android.app.Application;

public final class StubApp extends Application
{
    private static boolean loadDexToC;
    private static boolean loadFromLib;
    private static boolean needX86Bridge;
    public static String strEntryApplication;
    private static Application \u1d62\u02cb;
    private static Application \u1d62\u02ce;
    private static String \u1d62\u02cf;
    private static Context \u1d62\u02d1;
    private static String \u1d62\u05d9;
    private static String \u1d62\u0640;
    private static String \u1d62\u0674;
    private static String \u1d62\u1427;
    private static String \u1d62\u1d35;
    private static Map \u1d62\u1d4e;
    
    static {
        StubApp.\u1d62\u02cb = null;
        StubApp.strEntryApplication = "com.qihoo360.crypt.entryRunApplication";
        StubApp.\u1d62\u02ce = null;
        StubApp.\u1d62\u02cf = "libjiagu";
        StubApp.loadFromLib = false;
        StubApp.needX86Bridge = false;
        StubApp.loadDexToC = false;
        StubApp.\u1d62\u05d9 = null;
        StubApp.\u1d62\u0640 = null;
        StubApp.\u1d62\u0674 = null;
        StubApp.\u1d62\u1427 = null;
        StubApp.\u1d62\u1d35 = null;
        StubApp.\u1d62\u1d4e = new ConcurrentHashMap();
    }
    
    public static Context getAppContext() {
        return StubApp.\u1d62\u02d1;
    }
    
    public static String getDir() {
        return StubApp.\u1d62\u1427;
    }
    
    public static Context getOrigApplicationContext(Context \u1d62\u02ce) {
        if (\u1d62\u02ce == StubApp.\u1d62\u02cb) {
            \u1d62\u02ce = (Context)StubApp.\u1d62\u02ce;
        }
        return \u1d62\u02ce;
    }
    
    public static String getSoPath1() {
        return StubApp.\u1d62\u0640;
    }
    
    public static String getSoPath2() {
        return StubApp.\u1d62\u0674;
    }
    
    public static String getString2(final int n) {
        String interface14 = StubApp.\u1d62\u1d4e.get(n);
        if (interface14 == null) {
            interface14 = interface14(n);
            StubApp.\u1d62\u1d4e.put(n, interface14);
        }
        return interface14;
    }
    
    public static String getString2(final String s) {
        try {
            final int int1 = Integer.parseInt(s);
            try {
                return getString2(int1);
            }
            catch (NumberFormatException ex) {
                ex.printStackTrace();
                final String string2 = null;
            }
        }
        catch (NumberFormatException ex2) {}
    }
    
    public static native void interface11(final int p0);
    
    public static native Enumeration interface12(final DexFile p0);
    
    public static native long interface13(final int p0, final long p1, final long p2, final long p3, final int p4, final int p5, final long p6);
    
    public static native String interface14(final int p0);
    
    public static native AssetFileDescriptor interface17(final AssetManager p0, final String p1);
    
    public static native InputStream interface18(final Class p0, final String p1);
    
    public static native InputStream interface19(final ClassLoader p0, final String p1);
    
    public static native void interface20();
    
    public static native void interface5(final Application p0);
    
    public static native String interface6(final String p0);
    
    public static native boolean interface7(final Application p0, final Context p1);
    
    public static native boolean interface8(final Application p0, final Context p1);
    
    public static boolean isX86Arch() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: iconst_0       
        //     1: istore_0       
        //     2: aconst_null    
        //     3: astore_1       
        //     4: iconst_1       
        //     5: istore_2       
        //     6: getstatic       android/os/Build.SUPPORTED_32_BIT_ABIS:[Ljava/lang/String;
        //     9: astore_3       
        //    10: aload_3        
        //    11: arraylength    
        //    12: istore          4
        //    14: iconst_0       
        //    15: istore          5
        //    17: aconst_null    
        //    18: astore          6
        //    20: iload           5
        //    22: iload           4
        //    24: if_icmpge       62
        //    27: aload_3        
        //    28: iload           5
        //    30: aaload         
        //    31: astore          7
        //    33: ldc             "x86"
        //    35: astore          8
        //    37: aload           7
        //    39: aload           8
        //    41: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //    44: istore          9
        //    46: iload           9
        //    48: ifeq            53
        //    51: iload_2        
        //    52: ireturn        
        //    53: iload           5
        //    55: iconst_1       
        //    56: iadd           
        //    57: istore          5
        //    59: goto            20
        //    62: getstatic       android/os/Build.CPU_ABI:Ljava/lang/String;
        //    65: astore          6
        //    67: ldc             "x86"
        //    69: astore_3       
        //    70: aload           6
        //    72: aload_3        
        //    73: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //    76: istore          5
        //    78: iload           5
        //    80: ifne            51
        //    83: getstatic       android/os/Build.CPU_ABI2:Ljava/lang/String;
        //    86: astore          6
        //    88: ldc             "x86"
        //    90: astore_3       
        //    91: aload           6
        //    93: aload_3        
        //    94: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //    97: istore          5
        //    99: iload           5
        //   101: ifne            51
        //   104: new             Ljava/io/RandomAccessFile;
        //   107: astore          6
        //   109: ldc             "/system/build.prop"
        //   111: astore_3       
        //   112: ldc             "r"
        //   114: astore          10
        //   116: aload           6
        //   118: aload_3        
        //   119: aload           10
        //   121: invokespecial   java/io/RandomAccessFile.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //   124: aload           6
        //   126: invokevirtual   java/io/RandomAccessFile.readLine:()Ljava/lang/String;
        //   129: astore_3       
        //   130: aload_3        
        //   131: ifnull          189
        //   134: ldc             "ro.product.cpu.abi"
        //   136: astore          10
        //   138: aload_3        
        //   139: aload           10
        //   141: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   144: istore          4
        //   146: iload           4
        //   148: ifeq            180
        //   151: ldc             "x86"
        //   153: astore          10
        //   155: aload_3        
        //   156: aload           10
        //   158: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   161: istore          11
        //   163: iload           11
        //   165: ifeq            180
        //   168: aload           6
        //   170: invokevirtual   java/io/RandomAccessFile.close:()V
        //   173: goto            51
        //   176: pop            
        //   177: goto            51
        //   180: aload           6
        //   182: invokevirtual   java/io/RandomAccessFile.readLine:()Ljava/lang/String;
        //   185: astore_3       
        //   186: goto            130
        //   189: aload           6
        //   191: invokevirtual   java/io/RandomAccessFile.close:()V
        //   194: iconst_0       
        //   195: istore_2       
        //   196: aconst_null    
        //   197: astore          12
        //   199: goto            51
        //   202: astore          6
        //   204: iconst_0       
        //   205: istore          5
        //   207: aconst_null    
        //   208: astore          6
        //   210: aload           6
        //   212: ifnull          194
        //   215: aload           6
        //   217: invokevirtual   java/io/RandomAccessFile.close:()V
        //   220: goto            194
        //   223: astore          12
        //   225: goto            194
        //   228: astore          6
        //   230: iconst_0       
        //   231: istore          5
        //   233: aconst_null    
        //   234: astore          6
        //   236: aload           6
        //   238: ifnull          194
        //   241: aload           6
        //   243: invokevirtual   java/io/RandomAccessFile.close:()V
        //   246: goto            194
        //   249: astore          12
        //   251: goto            194
        //   254: astore          6
        //   256: aload           6
        //   258: astore_3       
        //   259: iconst_0       
        //   260: istore          4
        //   262: aconst_null    
        //   263: astore          10
        //   265: aload           10
        //   267: ifnull          275
        //   270: aload           10
        //   272: invokevirtual   java/io/RandomAccessFile.close:()V
        //   275: aload_3        
        //   276: athrow         
        //   277: astore          6
        //   279: getstatic       android/os/Build.CPU_ABI:Ljava/lang/String;
        //   282: astore          6
        //   284: ldc             "x86"
        //   286: astore_3       
        //   287: aload           6
        //   289: aload_3        
        //   290: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   293: istore          5
        //   295: iload           5
        //   297: ifne            51
        //   300: getstatic       android/os/Build.CPU_ABI2:Ljava/lang/String;
        //   303: astore          6
        //   305: ldc             "x86"
        //   307: astore_3       
        //   308: aload           6
        //   310: aload_3        
        //   311: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   314: istore          5
        //   316: iload           5
        //   318: ifne            51
        //   321: new             Ljava/io/RandomAccessFile;
        //   324: astore          6
        //   326: ldc             "/system/build.prop"
        //   328: astore_3       
        //   329: ldc             "r"
        //   331: astore          10
        //   333: aload           6
        //   335: aload_3        
        //   336: aload           10
        //   338: invokespecial   java/io/RandomAccessFile.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //   341: aload           6
        //   343: invokevirtual   java/io/RandomAccessFile.readLine:()Ljava/lang/String;
        //   346: astore_1       
        //   347: aload_1        
        //   348: ifnull          400
        //   351: ldc             "ro.product.cpu.abi"
        //   353: astore_3       
        //   354: aload_1        
        //   355: aload_3        
        //   356: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   359: istore          11
        //   361: iload           11
        //   363: ifeq            391
        //   366: ldc             "x86"
        //   368: astore_3       
        //   369: aload_1        
        //   370: aload_3        
        //   371: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   374: istore_0       
        //   375: iload_0        
        //   376: ifeq            391
        //   379: aload           6
        //   381: invokevirtual   java/io/RandomAccessFile.close:()V
        //   384: goto            51
        //   387: pop            
        //   388: goto            51
        //   391: aload           6
        //   393: invokevirtual   java/io/RandomAccessFile.readLine:()Ljava/lang/String;
        //   396: astore_1       
        //   397: goto            347
        //   400: aload           6
        //   402: invokevirtual   java/io/RandomAccessFile.close:()V
        //   405: goto            194
        //   408: astore          12
        //   410: goto            194
        //   413: astore          12
        //   415: aload_1        
        //   416: ifnull          194
        //   419: aload_1        
        //   420: invokevirtual   java/io/RandomAccessFile.close:()V
        //   423: goto            194
        //   426: astore          12
        //   428: goto            194
        //   431: astore          12
        //   433: iconst_0       
        //   434: istore          5
        //   436: aconst_null    
        //   437: astore          6
        //   439: aload           6
        //   441: ifnull          194
        //   444: aload           6
        //   446: invokevirtual   java/io/RandomAccessFile.close:()V
        //   449: goto            194
        //   452: astore          12
        //   454: goto            194
        //   457: astore          12
        //   459: iconst_0       
        //   460: istore          5
        //   462: aconst_null    
        //   463: astore          6
        //   465: aload           6
        //   467: ifnull          475
        //   470: aload           6
        //   472: invokevirtual   java/io/RandomAccessFile.close:()V
        //   475: aload           12
        //   477: athrow         
        //   478: astore          12
        //   480: goto            194
        //   483: astore          6
        //   485: goto            275
        //   488: pop            
        //   489: goto            475
        //   492: astore          12
        //   494: goto            465
        //   497: astore          12
        //   499: goto            439
        //   502: astore          12
        //   504: aload           6
        //   506: astore_1       
        //   507: goto            415
        //   510: astore_3       
        //   511: aload           6
        //   513: astore          10
        //   515: goto            265
        //   518: astore_3       
        //   519: goto            236
        //   522: astore_3       
        //   523: goto            210
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  6      9      277    510    Ljava/lang/NoSuchFieldError;
        //  10     12     277    510    Ljava/lang/NoSuchFieldError;
        //  28     31     277    510    Ljava/lang/NoSuchFieldError;
        //  39     44     277    510    Ljava/lang/NoSuchFieldError;
        //  62     65     277    510    Ljava/lang/NoSuchFieldError;
        //  72     76     277    510    Ljava/lang/NoSuchFieldError;
        //  83     86     277    510    Ljava/lang/NoSuchFieldError;
        //  93     97     277    510    Ljava/lang/NoSuchFieldError;
        //  104    107    202    210    Ljava/io/FileNotFoundException;
        //  104    107    228    236    Ljava/io/IOException;
        //  104    107    254    265    Any
        //  119    124    202    210    Ljava/io/FileNotFoundException;
        //  119    124    228    236    Ljava/io/IOException;
        //  119    124    254    265    Any
        //  124    129    522    526    Ljava/io/FileNotFoundException;
        //  124    129    518    522    Ljava/io/IOException;
        //  124    129    510    518    Any
        //  139    144    522    526    Ljava/io/FileNotFoundException;
        //  139    144    518    522    Ljava/io/IOException;
        //  139    144    510    518    Any
        //  156    161    522    526    Ljava/io/FileNotFoundException;
        //  156    161    518    522    Ljava/io/IOException;
        //  156    161    510    518    Any
        //  168    173    176    180    Ljava/lang/Exception;
        //  168    173    277    510    Ljava/lang/NoSuchFieldError;
        //  180    185    522    526    Ljava/io/FileNotFoundException;
        //  180    185    518    522    Ljava/io/IOException;
        //  180    185    510    518    Any
        //  189    194    478    483    Ljava/lang/Exception;
        //  189    194    277    510    Ljava/lang/NoSuchFieldError;
        //  215    220    223    228    Ljava/lang/Exception;
        //  215    220    277    510    Ljava/lang/NoSuchFieldError;
        //  241    246    249    254    Ljava/lang/Exception;
        //  241    246    277    510    Ljava/lang/NoSuchFieldError;
        //  270    275    483    488    Ljava/lang/Exception;
        //  270    275    277    510    Ljava/lang/NoSuchFieldError;
        //  275    277    277    510    Ljava/lang/NoSuchFieldError;
        //  321    324    413    415    Ljava/io/FileNotFoundException;
        //  321    324    431    439    Ljava/io/IOException;
        //  321    324    457    465    Any
        //  336    341    413    415    Ljava/io/FileNotFoundException;
        //  336    341    431    439    Ljava/io/IOException;
        //  336    341    457    465    Any
        //  341    346    502    510    Ljava/io/FileNotFoundException;
        //  341    346    497    502    Ljava/io/IOException;
        //  341    346    492    497    Any
        //  355    359    502    510    Ljava/io/FileNotFoundException;
        //  355    359    497    502    Ljava/io/IOException;
        //  355    359    492    497    Any
        //  370    374    502    510    Ljava/io/FileNotFoundException;
        //  370    374    497    502    Ljava/io/IOException;
        //  370    374    492    497    Any
        //  379    384    387    391    Ljava/lang/Exception;
        //  391    396    502    510    Ljava/io/FileNotFoundException;
        //  391    396    497    502    Ljava/io/IOException;
        //  391    396    492    497    Any
        //  400    405    408    413    Ljava/lang/Exception;
        //  419    423    426    431    Ljava/lang/Exception;
        //  444    449    452    457    Ljava/lang/Exception;
        //  470    475    488    492    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 260, Size: 260
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
    
    public static native Location mark(final LocationManager p0, final String p1);
    
    public static native void mark();
    
    public static native void mark(final Location p0);
    
    public static native boolean n01031(final Object p0);
    
    public static native void n0103210(final Object p0, final long p1, final boolean p2);
    
    public static native Object n01033(final Object p0);
    
    public static native Object n010333(final Object p0, final Object p1);
    
    public static native void n0110();
    
    public static native int n0111();
    
    public static native void n01110(final int p0);
    
    public static native int n01111(final int p0);
    
    public static native int n011111(final int p0, final int p1);
    
    public static native int n0111111(final int p0, final byte p1, final short p2);
    
    public static native Object n011111113(final boolean p0, final int p1, final int p2, final byte p3, final byte p4);
    
    public static native Object n011113(final byte p0, final byte p1);
    
    public static native boolean n0111131331(final boolean p0, final boolean p1, final Object p2, final boolean p3, final Object p4, final Object p5);
    
    public static native boolean n01111313331(final boolean p0, final boolean p1, final Object p2, final boolean p3, final Object p4, final Object p5, final Object p6);
    
    public static native Object n01113(final int p0);
    
    public static native Object n011133(final int p0, final Object p1);
    
    public static native long n0112();
    
    public static native void n01120(final long p0);
    
    public static native boolean n01121(final long p0);
    
    public static native int n011211(final long p0, final int p1);
    
    public static native long n01122(final long p0);
    
    public static native long n011222(final long p0, final long p1);
    
    public static native void n0112220(final long p0, final long p1, final long p2);
    
    public static native Object n01123(final long p0);
    
    public static native Object n01123313(final long p0, final Object p1, final Object p2, final int p3);
    
    public static native Object n0112333(final long p0, final Object p1, final Object p2);
    
    public static native boolean n011233331(final long p0, final Object p1, final Object p2, final Object p3, final Object p4);
    
    public static native Object n0113();
    
    public static native void n01130(final Object p0);
    
    public static native boolean n01131(final Object p0);
    
    public static native void n011310(final Object p0, final int p1);
    
    public static native int n011311(final Object p0, final int p1);
    
    public static native int n0113111(final Object p0, final int p1, final int p2);
    
    public static native int n01131111(final Object p0, final int p1, final int p2, final boolean p3);
    
    public static native Object n01131113(final Object p0, final int p1, final int p2, final boolean p3);
    
    public static native long n0113112(final Object p0, final int p1, final int p2);
    
    public static native Object n0113113(final Object p0, final int p1, final int p2);
    
    public static native int n01131131(final Object p0, final int p1, final int p2, final Object p3);
    
    public static native boolean n011311311(final Object p0, final int p1, final int p2, final Object p3, final int p4);
    
    public static native Object n011311311113(final Object p0, final int p1, final int p2, final Object p3, final boolean p4, final boolean p5, final boolean p6, final boolean p7);
    
    public static native Object n011313(final Object p0, final int p1);
    
    public static native void n0113130(final Object p0, final int p1, final Object p2);
    
    public static native boolean n0113131(final Object p0, final int p1, final Object p2);
    
    public static native boolean n011313111(final Object p0, final int p1, final Object p2, final int p3, final int p4);
    
    public static native void n01131330(final Object p0, final int p1, final Object p2, final Object p3);
    
    public static native long n01132(final Object p0);
    
    public static native void n011320(final Object p0, final long p1);
    
    public static native long n011322(final Object p0, final long p1);
    
    public static native int n0113231(final Object p0, final long p1, final Object p2);
    
    public static native void n01132320(final Object p0, final long p1, final Object p2, final long p3);
    
    public static native Object n0113233(final Object p0, final long p1, final Object p2);
    
    public static native Object n011323313(final Object p0, final long p1, final Object p2, final Object p3, final int p4);
    
    public static native Object n01132333(final Object p0, final long p1, final Object p2, final Object p3);
    
    public static native Object n01133(final Object p0);
    
    public static native void n011330(final Object p0, final Object p1);
    
    public static native int n011331(final Object p0, final Object p1);
    
    public static native void n0113310(final Object p0, final Object p1, final int p2);
    
    public static native void n01133110(final Object p0, final Object p1, final boolean p2, final int p3);
    
    public static native void n011331110(final Object p0, final Object p1, final int p2, final int p3, final boolean p4);
    
    public static native Object n0113311113(final Object p0, final Object p1, final boolean p2, final boolean p3, final boolean p4, final boolean p5);
    
    public static native Object n011331113(final Object p0, final Object p1, final int p2, final int p3, final int p4);
    
    public static native Object n011331123(final Object p0, final Object p1, final int p2, final int p3, final long p4);
    
    public static native Object n01133113(final Object p0, final Object p1, final int p2, final int p3);
    
    public static native void n0113311311110(final Object p0, final Object p1, final int p2, final int p3, final Object p4, final boolean p5, final boolean p6, final boolean p7, final boolean p8);
    
    public static native Object n011331133(final Object p0, final Object p1, final int p2, final int p3, final Object p4);
    
    public static native Object n0113313(final Object p0, final Object p1, final int p2);
    
    public static native void n01133130(final Object p0, final Object p1, final boolean p2, final Object p3);
    
    public static native Object n0113313113(final Object p0, final Object p1, final int p2, final Object p3, final int p4, final int p5);
    
    public static native void n011331330(final Object p0, final Object p1, final boolean p2, final Object p3, final Object p4);
    
    public static native void n0113320(final Object p0, final Object p1, final long p2);
    
    public static native Object n011333(final Object p0, final Object p1);
    
    public static native void n0113330(final Object p0, final Object p1, final Object p2);
    
    public static native boolean n0113331(final Object p0, final Object p1, final Object p2);
    
    public static native void n01133310(final Object p0, final Object p1, final Object p2, final boolean p3);
    
    public static native Object n01133323(final Object p0, final Object p1, final Object p2, final long p3);
    
    public static native Object n0113333(final Object p0, final Object p1, final Object p2);
    
    public static native void n01133330(final Object p0, final Object p1, final Object p2, final Object p3);
    
    public static native boolean n01133331(final Object p0, final Object p1, final Object p2, final Object p3);
    
    public static native Object n01133333(final Object p0, final Object p1, final Object p2, final Object p3);
    
    public static native Object n011333333(final Object p0, final Object p1, final Object p2, final Object p3, final Object p4);
    
    private static Application \u1d62\u02cb(final Context context) {
        try {
            Label_0045: {
                if (StubApp.\u1d62\u02ce != null) {
                    break Label_0045;
                }
                final ClassLoader classLoader = context.getClassLoader();
                if (classLoader == null) {
                    break Label_0045;
                }
                final Class<?> loadClass = classLoader.loadClass(StubApp.strEntryApplication);
                if (loadClass == null) {
                    break Label_0045;
                }
                final Object instance = loadClass.newInstance();
                try {
                    final Application \u1d62\u02ce = (Application)instance;
                    try {
                        StubApp.\u1d62\u02ce = \u1d62\u02ce;
                        return StubApp.\u1d62\u02ce;
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {}
            }
        }
        catch (Exception ex3) {}
    }
    
    private static String \u1d62\u02cb(final String s, final boolean b, final boolean b2) {
        String s2 = StubApp.\u1d62\u02cf;
        if (Build$VERSION.SDK_INT < 23) {
            s2 += s.hashCode();
        }
        String s3;
        if (b && !b2) {
            s3 = s2 + "_64.so";
        }
        else {
            s3 = s2 + ".so";
        }
        return s3;
    }
    
    private static boolean \u1d62\u02cb(final Context context, final String s, final String s2, final String s3) {
        boolean b = true;
        final String string = s2 + "/" + s3;
        final File file = new File(s2);
        if (!file.exists()) {
            file.mkdir();
        }
        while (true) {
            while (true) {
                Label_0283: {
                    InputStream open2 = null;
                    FileOutputStream fileOutputStream = null;
                    Label_0270: {
                        try {
                            final File file2 = new File(string);
                            Label_0189: {
                                if (!file2.exists()) {
                                    break Label_0189;
                                }
                                final Resources resources = context.getResources();
                                try {
                                    final InputStream open = resources.getAssets().open(s);
                                    try {
                                        final FileInputStream fileInputStream = new FileInputStream(file2);
                                        final BufferedInputStream bufferedInputStream = new BufferedInputStream(open);
                                        final BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream);
                                        final BufferedInputStream bufferedInputStream3 = bufferedInputStream;
                                        try {
                                            if (\u1d62\u02cb(bufferedInputStream3, bufferedInputStream2)) {
                                                final int n = b ? 1 : 0;
                                                open.close();
                                                fileInputStream.close();
                                                bufferedInputStream.close();
                                                bufferedInputStream2.close();
                                                if (n == 0) {
                                                    final Resources resources2 = context.getResources();
                                                    try {
                                                        open2 = resources2.getAssets().open(s);
                                                        try {
                                                            fileOutputStream = new FileOutputStream(string);
                                                            final byte[] array = new byte[7168];
                                                            while (true) {
                                                                final int read = open2.read(array);
                                                                if (read <= 0) {
                                                                    break Label_0270;
                                                                }
                                                                fileOutputStream.write(array, 0, read);
                                                            }
                                                        }
                                                        catch (Exception ex) {
                                                            b = false;
                                                        }
                                                    }
                                                    catch (Exception ex2) {}
                                                }
                                                return b;
                                            }
                                            break Label_0283;
                                        }
                                        catch (Exception ex3) {}
                                    }
                                    catch (Exception ex4) {}
                                }
                                catch (Exception ex5) {}
                            }
                        }
                        catch (Exception ex6) {}
                    }
                    fileOutputStream.close();
                    open2.close();
                    return b;
                }
                final int n = 0;
                continue;
            }
        }
    }
    
    private static boolean \u1d62\u02cb(final BufferedInputStream bufferedInputStream, final BufferedInputStream bufferedInputStream2) {
        boolean b = false;
        try {
            final int available = bufferedInputStream.available();
            try {
                final int available2 = bufferedInputStream2.available();
                if (available != available2) {
                    return b;
                }
                final byte[] array = new byte[available];
                try {
                    final byte[] array2 = new byte[available2];
                    bufferedInputStream.read(array);
                    try {
                        bufferedInputStream2.read(array2);
                        for (int i = 0; i < available; ++i) {
                            if (array[i] != array2[i]) {
                                return b;
                            }
                        }
                        b = true;
                        return b;
                    }
                    catch (IOException ex) {
                        return b;
                    }
                    catch (FileNotFoundException ex2) {
                        return b;
                    }
                }
                catch (IOException ex3) {}
                catch (FileNotFoundException ex4) {}
            }
            catch (IOException ex5) {}
            catch (FileNotFoundException ex6) {}
        }
        catch (IOException ex7) {}
        catch (FileNotFoundException ex8) {}
    }
    
    protected final void attachBaseContext(final Context p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: iconst_1       
        //     1: istore_2       
        //     2: iconst_0       
        //     3: istore_3       
        //     4: aconst_null    
        //     5: astore          4
        //     7: aload_0        
        //     8: aload_1        
        //     9: invokespecial   android/app/Application.attachBaseContext:(Landroid/content/Context;)V
        //    12: aload_1        
        //    13: putstatic       com/stub/StubApp.\u1d62\u02d1:Landroid/content/Context;
        //    16: getstatic       com/stub/StubApp.\u1d62\u02cb:Landroid/app/Application;
        //    19: astore          5
        //    21: aload           5
        //    23: ifnonnull       30
        //    26: aload_0        
        //    27: putstatic       com/stub/StubApp.\u1d62\u02cb:Landroid/app/Application;
        //    30: getstatic       com/stub/StubApp.\u1d62\u02ce:Landroid/app/Application;
        //    33: astore          5
        //    35: aload           5
        //    37: ifnonnull       297
        //    40: invokestatic    com/stub/StubApp.isX86Arch:()Z
        //    43: istore          6
        //    45: iload           6
        //    47: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //    50: astore          7
        //    52: iconst_0       
        //    53: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //    56: astore          5
        //    58: iconst_0       
        //    59: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //    62: astore          8
        //    64: getstatic       android/os/Build.CPU_ABI:Ljava/lang/String;
        //    67: astore          9
        //    69: ldc_w           "64"
        //    72: astore          10
        //    74: aload           9
        //    76: aload           10
        //    78: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //    81: istore          11
        //    83: iload           11
        //    85: ifne            112
        //    88: getstatic       android/os/Build.CPU_ABI2:Ljava/lang/String;
        //    91: astore          9
        //    93: ldc_w           "64"
        //    96: astore          10
        //    98: aload           9
        //   100: aload           10
        //   102: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   105: istore          11
        //   107: iload           11
        //   109: ifeq            118
        //   112: iload_2        
        //   113: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //   116: astore          5
        //   118: getstatic       android/os/Build.CPU_ABI:Ljava/lang/String;
        //   121: astore          9
        //   123: ldc_w           "mips"
        //   126: astore          10
        //   128: aload           9
        //   130: aload           10
        //   132: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   135: istore          11
        //   137: iload           11
        //   139: ifne            166
        //   142: getstatic       android/os/Build.CPU_ABI2:Ljava/lang/String;
        //   145: astore          9
        //   147: ldc_w           "mips"
        //   150: astore          10
        //   152: aload           9
        //   154: aload           10
        //   156: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   159: istore          11
        //   161: iload           11
        //   163: ifeq            172
        //   166: iload_2        
        //   167: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //   170: astore          8
        //   172: aload           7
        //   174: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   177: istore          11
        //   179: iload           11
        //   181: ifeq            204
        //   184: getstatic       com/stub/StubApp.needX86Bridge:Z
        //   187: istore          11
        //   189: iload           11
        //   191: ifeq            204
        //   194: ldc_w           "X86Bridge"
        //   197: astore          9
        //   199: aload           9
        //   201: invokestatic    java/lang/System.loadLibrary:(Ljava/lang/String;)V
        //   204: getstatic       com/stub/StubApp.loadFromLib:Z
        //   207: istore          11
        //   209: iload           11
        //   211: ifeq            453
        //   214: aload           7
        //   216: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   219: istore          11
        //   221: iload           11
        //   223: ifeq            440
        //   226: getstatic       com/stub/StubApp.needX86Bridge:Z
        //   229: istore          11
        //   231: iload           11
        //   233: ifne            440
        //   236: ldc_w           "jiagu_x86"
        //   239: astore          9
        //   241: aload           9
        //   243: invokestatic    java/lang/System.loadLibrary:(Ljava/lang/String;)V
        //   246: aload           7
        //   248: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   251: istore          11
        //   253: aload           5
        //   255: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   258: istore          12
        //   260: aload           8
        //   262: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   265: istore          13
        //   267: getstatic       com/stub/StubApp.loadDexToC:Z
        //   270: istore          6
        //   272: iload           6
        //   274: ifeq            297
        //   277: getstatic       com/stub/StubApp.loadFromLib:Z
        //   280: istore          6
        //   282: iload           6
        //   284: ifeq            1147
        //   287: ldc_w           "jgdtc"
        //   290: astore          5
        //   292: aload           5
        //   294: invokestatic    java/lang/System.loadLibrary:(Ljava/lang/String;)V
        //   297: getstatic       com/stub/StubApp.\u1d62\u02cb:Landroid/app/Application;
        //   300: invokestatic    com/stub/StubApp.interface5:(Landroid/app/Application;)V
        //   303: getstatic       com/stub/StubApp.\u1d62\u02ce:Landroid/app/Application;
        //   306: astore          5
        //   308: aload           5
        //   310: ifnonnull       439
        //   313: aload_1        
        //   314: invokestatic    com/stub/StubApp.\u1d62\u02cb:(Landroid/content/Context;)Landroid/app/Application;
        //   317: putstatic       com/stub/StubApp.\u1d62\u02ce:Landroid/app/Application;
        //   320: getstatic       com/stub/StubApp.\u1d62\u02ce:Landroid/app/Application;
        //   323: astore          5
        //   325: aload           5
        //   327: ifnull          1609
        //   330: ldc             Landroid/app/Application;.class
        //   332: astore          5
        //   334: ldc_w           "attach"
        //   337: astore          8
        //   339: iconst_1       
        //   340: istore          11
        //   342: iload           11
        //   344: anewarray       Ljava/lang/Class;
        //   347: astore          9
        //   349: iconst_0       
        //   350: istore          12
        //   352: aconst_null    
        //   353: astore          7
        //   355: ldc             Landroid/content/Context;.class
        //   357: astore          10
        //   359: aload           9
        //   361: iconst_0       
        //   362: aload           10
        //   364: aastore        
        //   365: aload           5
        //   367: aload           8
        //   369: aload           9
        //   371: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   374: astore          5
        //   376: aload           5
        //   378: ifnull          427
        //   381: iconst_1       
        //   382: istore          13
        //   384: aload           5
        //   386: iload           13
        //   388: invokevirtual   java/lang/reflect/Method.setAccessible:(Z)V
        //   391: getstatic       com/stub/StubApp.\u1d62\u02ce:Landroid/app/Application;
        //   394: astore          8
        //   396: iconst_1       
        //   397: istore          11
        //   399: iload           11
        //   401: anewarray       Ljava/lang/Object;
        //   404: astore          9
        //   406: iconst_0       
        //   407: istore          12
        //   409: aconst_null    
        //   410: astore          7
        //   412: aload           9
        //   414: iconst_0       
        //   415: aload_1        
        //   416: aastore        
        //   417: aload           5
        //   419: aload           8
        //   421: aload           9
        //   423: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   426: pop            
        //   427: getstatic       com/stub/StubApp.\u1d62\u02ce:Landroid/app/Application;
        //   430: astore          5
        //   432: aload           5
        //   434: aload_1        
        //   435: invokestatic    com/stub/StubApp.interface8:(Landroid/app/Application;Landroid/content/Context;)Z
        //   438: pop            
        //   439: return         
        //   440: ldc_w           "jiagu"
        //   443: astore          9
        //   445: aload           9
        //   447: invokestatic    java/lang/System.loadLibrary:(Ljava/lang/String;)V
        //   450: goto            246
        //   453: aload_1        
        //   454: invokevirtual   android/content/Context.getFilesDir:()Ljava/io/File;
        //   457: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
        //   460: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //   463: astore          9
        //   465: aload_1        
        //   466: invokevirtual   android/content/Context.getFilesDir:()Ljava/io/File;
        //   469: astore          10
        //   471: aload           10
        //   473: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
        //   476: astore          10
        //   478: aload           10
        //   480: invokevirtual   java/io/File.getCanonicalPath:()Ljava/lang/String;
        //   483: astore          9
        //   485: new             Ljava/lang/StringBuilder;
        //   488: astore          10
        //   490: aload           10
        //   492: invokespecial   java/lang/StringBuilder.<init>:()V
        //   495: aload           10
        //   497: aload           9
        //   499: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   502: ldc_w           "/.jiagu"
        //   505: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   508: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   511: astore          10
        //   513: aload           5
        //   515: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   518: istore          11
        //   520: aload           8
        //   522: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   525: istore          14
        //   527: aload           10
        //   529: iload           11
        //   531: iload           14
        //   533: invokestatic    com/stub/StubApp.\u1d62\u02cb:(Ljava/lang/String;ZZ)Ljava/lang/String;
        //   536: putstatic       com/stub/StubApp.\u1d62\u1d35:Ljava/lang/String;
        //   539: aload           10
        //   541: iconst_0       
        //   542: iconst_0       
        //   543: invokestatic    com/stub/StubApp.\u1d62\u02cb:(Ljava/lang/String;ZZ)Ljava/lang/String;
        //   546: putstatic       com/stub/StubApp.\u1d62\u05d9:Ljava/lang/String;
        //   549: new             Ljava/lang/StringBuilder;
        //   552: astore          9
        //   554: aload           9
        //   556: invokespecial   java/lang/StringBuilder.<init>:()V
        //   559: aload           9
        //   561: aload           10
        //   563: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   566: astore          9
        //   568: getstatic       java/io/File.separator:Ljava/lang/String;
        //   571: astore          15
        //   573: aload           9
        //   575: aload           15
        //   577: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   580: astore          9
        //   582: getstatic       com/stub/StubApp.\u1d62\u05d9:Ljava/lang/String;
        //   585: astore          15
        //   587: aload           9
        //   589: aload           15
        //   591: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   594: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   597: putstatic       com/stub/StubApp.\u1d62\u0640:Ljava/lang/String;
        //   600: new             Ljava/lang/StringBuilder;
        //   603: astore          9
        //   605: aload           9
        //   607: invokespecial   java/lang/StringBuilder.<init>:()V
        //   610: aload           9
        //   612: aload           10
        //   614: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   617: astore          9
        //   619: getstatic       java/io/File.separator:Ljava/lang/String;
        //   622: astore          15
        //   624: aload           9
        //   626: aload           15
        //   628: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   631: astore          9
        //   633: getstatic       com/stub/StubApp.\u1d62\u1d35:Ljava/lang/String;
        //   636: astore          15
        //   638: aload           9
        //   640: aload           15
        //   642: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   645: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   648: astore          9
        //   650: aload           9
        //   652: putstatic       com/stub/StubApp.\u1d62\u0674:Ljava/lang/String;
        //   655: aload           10
        //   657: putstatic       com/stub/StubApp.\u1d62\u1427:Ljava/lang/String;
        //   660: aload           8
        //   662: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   665: istore          11
        //   667: iload           11
        //   669: ifeq            871
        //   672: new             Ljava/lang/StringBuilder;
        //   675: astore          9
        //   677: aload           9
        //   679: invokespecial   java/lang/StringBuilder.<init>:()V
        //   682: getstatic       com/stub/StubApp.\u1d62\u02cf:Ljava/lang/String;
        //   685: astore          15
        //   687: aload           9
        //   689: aload           15
        //   691: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   694: ldc_w           "_mips.so"
        //   697: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   700: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   703: astore          9
        //   705: getstatic       com/stub/StubApp.\u1d62\u05d9:Ljava/lang/String;
        //   708: astore          15
        //   710: aload_1        
        //   711: aload           9
        //   713: aload           10
        //   715: aload           15
        //   717: invokestatic    com/stub/StubApp.\u1d62\u02cb:(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
        //   720: pop            
        //   721: aload           5
        //   723: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   726: istore          11
        //   728: iload           11
        //   730: ifeq            1098
        //   733: aload           8
        //   735: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   738: istore          11
        //   740: iload           11
        //   742: ifne            1098
        //   745: aload           7
        //   747: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   750: istore          11
        //   752: iload           11
        //   754: ifeq            996
        //   757: getstatic       com/stub/StubApp.needX86Bridge:Z
        //   760: istore          11
        //   762: iload           11
        //   764: ifne            996
        //   767: new             Ljava/lang/StringBuilder;
        //   770: astore          9
        //   772: aload           9
        //   774: invokespecial   java/lang/StringBuilder.<init>:()V
        //   777: getstatic       com/stub/StubApp.\u1d62\u02cf:Ljava/lang/String;
        //   780: astore          15
        //   782: aload           9
        //   784: aload           15
        //   786: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   789: ldc_w           "_x64.so"
        //   792: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   795: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   798: astore          9
        //   800: getstatic       com/stub/StubApp.\u1d62\u1d35:Ljava/lang/String;
        //   803: astore          15
        //   805: aload_1        
        //   806: aload           9
        //   808: aload           10
        //   810: aload           15
        //   812: invokestatic    com/stub/StubApp.\u1d62\u02cb:(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
        //   815: istore          11
        //   817: iload           11
        //   819: ifeq            1049
        //   822: new             Ljava/lang/StringBuilder;
        //   825: astore          9
        //   827: aload           9
        //   829: invokespecial   java/lang/StringBuilder.<init>:()V
        //   832: aload           9
        //   834: aload           10
        //   836: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   839: ldc             "/"
        //   841: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   844: astore          9
        //   846: getstatic       com/stub/StubApp.\u1d62\u1d35:Ljava/lang/String;
        //   849: astore          10
        //   851: aload           9
        //   853: aload           10
        //   855: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   858: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   861: astore          9
        //   863: aload           9
        //   865: invokestatic    java/lang/System.load:(Ljava/lang/String;)V
        //   868: goto            246
        //   871: aload           7
        //   873: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   876: istore          11
        //   878: iload           11
        //   880: ifeq            945
        //   883: getstatic       com/stub/StubApp.needX86Bridge:Z
        //   886: istore          11
        //   888: iload           11
        //   890: ifne            945
        //   893: new             Ljava/lang/StringBuilder;
        //   896: astore          9
        //   898: aload           9
        //   900: invokespecial   java/lang/StringBuilder.<init>:()V
        //   903: getstatic       com/stub/StubApp.\u1d62\u02cf:Ljava/lang/String;
        //   906: astore          15
        //   908: aload           9
        //   910: aload           15
        //   912: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   915: ldc_w           "_x86.so"
        //   918: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   921: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   924: astore          9
        //   926: getstatic       com/stub/StubApp.\u1d62\u05d9:Ljava/lang/String;
        //   929: astore          15
        //   931: aload_1        
        //   932: aload           9
        //   934: aload           10
        //   936: aload           15
        //   938: invokestatic    com/stub/StubApp.\u1d62\u02cb:(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
        //   941: pop            
        //   942: goto            721
        //   945: new             Ljava/lang/StringBuilder;
        //   948: astore          9
        //   950: aload           9
        //   952: invokespecial   java/lang/StringBuilder.<init>:()V
        //   955: getstatic       com/stub/StubApp.\u1d62\u02cf:Ljava/lang/String;
        //   958: astore          15
        //   960: aload           9
        //   962: aload           15
        //   964: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   967: ldc             ".so"
        //   969: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   972: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   975: astore          9
        //   977: getstatic       com/stub/StubApp.\u1d62\u05d9:Ljava/lang/String;
        //   980: astore          15
        //   982: aload_1        
        //   983: aload           9
        //   985: aload           10
        //   987: aload           15
        //   989: invokestatic    com/stub/StubApp.\u1d62\u02cb:(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
        //   992: pop            
        //   993: goto            721
        //   996: new             Ljava/lang/StringBuilder;
        //   999: astore          9
        //  1001: aload           9
        //  1003: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1006: getstatic       com/stub/StubApp.\u1d62\u02cf:Ljava/lang/String;
        //  1009: astore          15
        //  1011: aload           9
        //  1013: aload           15
        //  1015: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1018: ldc_w           "_a64.so"
        //  1021: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1024: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1027: astore          9
        //  1029: getstatic       com/stub/StubApp.\u1d62\u1d35:Ljava/lang/String;
        //  1032: astore          15
        //  1034: aload_1        
        //  1035: aload           9
        //  1037: aload           10
        //  1039: aload           15
        //  1041: invokestatic    com/stub/StubApp.\u1d62\u02cb:(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
        //  1044: istore          11
        //  1046: goto            817
        //  1049: new             Ljava/lang/StringBuilder;
        //  1052: astore          9
        //  1054: aload           9
        //  1056: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1059: aload           9
        //  1061: aload           10
        //  1063: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1066: ldc             "/"
        //  1068: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1071: astore          9
        //  1073: getstatic       com/stub/StubApp.\u1d62\u05d9:Ljava/lang/String;
        //  1076: astore          10
        //  1078: aload           9
        //  1080: aload           10
        //  1082: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1085: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1088: astore          9
        //  1090: aload           9
        //  1092: invokestatic    java/lang/System.load:(Ljava/lang/String;)V
        //  1095: goto            246
        //  1098: new             Ljava/lang/StringBuilder;
        //  1101: astore          9
        //  1103: aload           9
        //  1105: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1108: aload           9
        //  1110: aload           10
        //  1112: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1115: ldc             "/"
        //  1117: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1120: astore          9
        //  1122: getstatic       com/stub/StubApp.\u1d62\u05d9:Ljava/lang/String;
        //  1125: astore          10
        //  1127: aload           9
        //  1129: aload           10
        //  1131: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1134: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1137: astore          9
        //  1139: aload           9
        //  1141: invokestatic    java/lang/System.load:(Ljava/lang/String;)V
        //  1144: goto            246
        //  1147: getstatic       com/stub/StubApp.\u1d62\u02d1:Landroid/content/Context;
        //  1150: invokevirtual   android/content/Context.getFilesDir:()Ljava/io/File;
        //  1153: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
        //  1156: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //  1159: astore          5
        //  1161: getstatic       com/stub/StubApp.\u1d62\u02d1:Landroid/content/Context;
        //  1164: astore          10
        //  1166: aload           10
        //  1168: invokevirtual   android/content/Context.getFilesDir:()Ljava/io/File;
        //  1171: astore          10
        //  1173: aload           10
        //  1175: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
        //  1178: astore          10
        //  1180: aload           10
        //  1182: invokevirtual   java/io/File.getCanonicalPath:()Ljava/lang/String;
        //  1185: astore          5
        //  1187: new             Ljava/lang/StringBuilder;
        //  1190: astore          10
        //  1192: aload           10
        //  1194: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1197: aload           10
        //  1199: aload           5
        //  1201: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1204: astore          5
        //  1206: getstatic       java/io/File.separator:Ljava/lang/String;
        //  1209: astore          10
        //  1211: aload           5
        //  1213: aload           10
        //  1215: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1218: ldc_w           ".jiagu"
        //  1221: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1224: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1227: astore          10
        //  1229: ldc_w           "libjgdtc"
        //  1232: astore          5
        //  1234: getstatic       android/os/Build$VERSION.SDK_INT:I
        //  1237: istore          14
        //  1239: bipush          23
        //  1241: istore_3       
        //  1242: iload           14
        //  1244: iload_3        
        //  1245: if_icmpge       1282
        //  1248: aload           10
        //  1250: invokevirtual   java/lang/String.hashCode:()I
        //  1253: istore          14
        //  1255: new             Ljava/lang/StringBuilder;
        //  1258: astore          4
        //  1260: aload           4
        //  1262: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1265: aload           4
        //  1267: aload           5
        //  1269: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1272: iload           14
        //  1274: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //  1277: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1280: astore          5
        //  1282: iload           12
        //  1284: ifeq            1416
        //  1287: iload           13
        //  1289: ifne            1416
        //  1292: new             Ljava/lang/StringBuilder;
        //  1295: astore          15
        //  1297: aload           15
        //  1299: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1302: aload           15
        //  1304: aload           5
        //  1306: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1309: astore          5
        //  1311: ldc             "_64.so"
        //  1313: astore          15
        //  1315: aload           5
        //  1317: aload           15
        //  1319: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1322: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1325: astore          5
        //  1327: iload           13
        //  1329: ifeq            1454
        //  1332: getstatic       com/stub/StubApp.\u1d62\u02d1:Landroid/content/Context;
        //  1335: astore          8
        //  1337: ldc_w           "libjgdtc_mips.so"
        //  1340: astore          9
        //  1342: aload           8
        //  1344: aload           9
        //  1346: aload           10
        //  1348: aload           5
        //  1350: invokestatic    com/stub/StubApp.\u1d62\u02cb:(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
        //  1353: pop            
        //  1354: new             Ljava/lang/StringBuilder;
        //  1357: astore          8
        //  1359: aload           8
        //  1361: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1364: aload           8
        //  1366: aload           10
        //  1368: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1371: astore          8
        //  1373: getstatic       java/io/File.separator:Ljava/lang/String;
        //  1376: astore          9
        //  1378: aload           8
        //  1380: aload           9
        //  1382: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1385: astore          8
        //  1387: aload           8
        //  1389: aload           5
        //  1391: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1394: astore          5
        //  1396: aload           5
        //  1398: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1401: astore          5
        //  1403: aload           5
        //  1405: invokestatic    java/lang/System.load:(Ljava/lang/String;)V
        //  1408: goto            297
        //  1411: astore          5
        //  1413: goto            297
        //  1416: new             Ljava/lang/StringBuilder;
        //  1419: astore          15
        //  1421: aload           15
        //  1423: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1426: aload           15
        //  1428: aload           5
        //  1430: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1433: astore          5
        //  1435: ldc             ".so"
        //  1437: astore          15
        //  1439: aload           5
        //  1441: aload           15
        //  1443: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1446: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1449: astore          5
        //  1451: goto            1327
        //  1454: iload           11
        //  1456: ifeq            1489
        //  1459: iload           12
        //  1461: ifne            1489
        //  1464: getstatic       com/stub/StubApp.\u1d62\u02d1:Landroid/content/Context;
        //  1467: astore          8
        //  1469: ldc_w           "libjgdtc_x86.so"
        //  1472: astore          9
        //  1474: aload           8
        //  1476: aload           9
        //  1478: aload           10
        //  1480: aload           5
        //  1482: invokestatic    com/stub/StubApp.\u1d62\u02cb:(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
        //  1485: pop            
        //  1486: goto            1354
        //  1489: iload           11
        //  1491: ifeq            1524
        //  1494: iload           12
        //  1496: ifeq            1524
        //  1499: getstatic       com/stub/StubApp.\u1d62\u02d1:Landroid/content/Context;
        //  1502: astore          8
        //  1504: ldc_w           "libjgdtc_x64.so"
        //  1507: astore          9
        //  1509: aload           8
        //  1511: aload           9
        //  1513: aload           10
        //  1515: aload           5
        //  1517: invokestatic    com/stub/StubApp.\u1d62\u02cb:(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
        //  1520: pop            
        //  1521: goto            1354
        //  1524: iload           11
        //  1526: ifne            1564
        //  1529: iload           13
        //  1531: ifne            1564
        //  1534: iload           12
        //  1536: ifeq            1564
        //  1539: getstatic       com/stub/StubApp.\u1d62\u02d1:Landroid/content/Context;
        //  1542: astore          8
        //  1544: ldc_w           "libjgdtc_a64.so"
        //  1547: astore          9
        //  1549: aload           8
        //  1551: aload           9
        //  1553: aload           10
        //  1555: aload           5
        //  1557: invokestatic    com/stub/StubApp.\u1d62\u02cb:(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
        //  1560: pop            
        //  1561: goto            1354
        //  1564: getstatic       com/stub/StubApp.\u1d62\u02d1:Landroid/content/Context;
        //  1567: astore          8
        //  1569: ldc_w           "libjgdtc.so"
        //  1572: astore          9
        //  1574: aload           8
        //  1576: aload           9
        //  1578: aload           10
        //  1580: aload           5
        //  1582: invokestatic    com/stub/StubApp.\u1d62\u02cb:(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
        //  1585: pop            
        //  1586: goto            1354
        //  1589: astore          5
        //  1591: new             Ljava/lang/RuntimeException;
        //  1594: astore          8
        //  1596: aload           8
        //  1598: ldc_w           "Failed to call attachBaseContext."
        //  1601: aload           5
        //  1603: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //  1606: aload           8
        //  1608: athrow         
        //  1609: iload_2        
        //  1610: invokestatic    java/lang/System.exit:(I)V
        //  1613: goto            439
        //  1616: astore          10
        //  1618: goto            1187
        //  1621: astore          5
        //  1623: goto            297
        //  1626: astore          10
        //  1628: goto            485
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  292    297    1621   1626   Ljava/lang/Error;
        //  342    347    1589   1609   Ljava/lang/Exception;
        //  362    365    1589   1609   Ljava/lang/Exception;
        //  369    374    1589   1609   Ljava/lang/Exception;
        //  386    391    1589   1609   Ljava/lang/Exception;
        //  391    394    1589   1609   Ljava/lang/Exception;
        //  399    404    1589   1609   Ljava/lang/Exception;
        //  415    417    1589   1609   Ljava/lang/Exception;
        //  421    427    1589   1609   Ljava/lang/Exception;
        //  465    469    1626   1631   Ljava/lang/Exception;
        //  471    476    1626   1631   Ljava/lang/Exception;
        //  478    483    1626   1631   Ljava/lang/Exception;
        //  1161   1164   1616   1621   Ljava/lang/Exception;
        //  1166   1171   1616   1621   Ljava/lang/Exception;
        //  1173   1178   1616   1621   Ljava/lang/Exception;
        //  1180   1185   1616   1621   Ljava/lang/Exception;
        //  1354   1357   1411   1416   Ljava/lang/Error;
        //  1359   1364   1411   1416   Ljava/lang/Error;
        //  1366   1371   1411   1416   Ljava/lang/Error;
        //  1373   1376   1411   1416   Ljava/lang/Error;
        //  1380   1385   1411   1416   Ljava/lang/Error;
        //  1389   1394   1411   1416   Ljava/lang/Error;
        //  1396   1401   1411   1416   Ljava/lang/Error;
        //  1403   1408   1411   1416   Ljava/lang/Error;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_1187:
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
    
    public native void n1100();
    
    public native int n1101();
    
    public native void n11010(final int p0);
    
    public native void n1101110(final boolean p0, final int p1, final int p2);
    
    public native void n11011130(final boolean p0, final int p1, final int p2, final Object p3);
    
    public native void n1101130(final int p0, final int p1, final Object p2);
    
    public native void n11011310(final boolean p0, final int p1, final Object p2, final int p3);
    
    public native void n110120(final int p0, final long p1);
    
    public native Object n11013(final int p0);
    
    public native void n110130(final int p0, final Object p1);
    
    public native boolean n1101321(final int p0, final Object p1, final long p2);
    
    public native void n1101330(final int p0, final Object p1, final Object p2);
    
    public native long n1102();
    
    public native void n11020(final long p0);
    
    public native Object n1103();
    
    public native void n11030(final Object p0);
    
    public native boolean n11031(final Object p0);
    
    public native void n110310(final Object p0, final boolean p1);
    
    public native boolean n110311(final Object p0, final int p1);
    
    public native Object n110323(final Object p0, final long p1);
    
    public native Object n11033(final Object p0);
    
    public native boolean n110331(final Object p0, final Object p1);
    
    public native void n1110();
    
    public native boolean n1111();
    
    public native void n11110(final int p0);
    
    public native int n11111(final int p0);
    
    public native void n111110(final int p0, final boolean p1);
    
    public native int n111111(final int p0, final int p1);
    
    public native void n1111110(final int p0, final int p1, final int p2);
    
    public native void n11111110(final int p0, final int p1, final int p2, final boolean p3);
    
    public native void n111111110(final boolean p0, final int p1, final int p2, final int p3, final int p4);
    
    public native void n11111111111111130(final boolean p0, final boolean p1, final int p2, final int p3, final boolean p4, final boolean p5, final boolean p6, final int p7, final int p8, final boolean p9, final boolean p10, final boolean p11, final Object p12);
    
    public native Object n111111113(final int p0, final int p1, final int p2, final boolean p3, final boolean p4);
    
    public native Object n11111113(final int p0, final int p1, final int p2, final boolean p3);
    
    public native Object n1111113(final boolean p0, final boolean p1, final boolean p2);
    
    public native void n11111130(final boolean p0, final int p1, final int p2, final Object p3);
    
    public native Object n111113(final int p0, final int p1);
    
    public native void n1111130(final int p0, final int p1, final Object p2);
    
    public native void n11111310(final boolean p0, final int p1, final Object p2, final int p3);
    
    public native boolean n111113131(final boolean p0, final boolean p1, final Object p2, final boolean p3, final Object p4);
    
    public native void n11111320(final int p0, final boolean p1, final Object p2, final long p3);
    
    public native boolean n11111331(final boolean p0, final boolean p1, final Object p2, final Object p3);
    
    public native Object n11111333(final int p0, final int p1, final Object p2, final Object p3);
    
    public native long n11112(final int p0);
    
    public native void n111120(final int p0, final long p1);
    
    public native void n11112110(final int p0, final long p1, final boolean p2, final boolean p3);
    
    public native long n111122(final byte p0, final long p1);
    
    public native long n1111222(final byte p0, final long p1, final long p2);
    
    public native Object n111123(final int p0, final long p1);
    
    public native void n1111230(final int p0, final long p1, final Object p2);
    
    public native void n11112330(final int p0, final long p1, final Object p2, final Object p3);
    
    public native Object n11113(final int p0);
    
    public native void n111130(final int p0, final Object p1);
    
    public native boolean n111131(final int p0, final Object p1);
    
    public native void n1111310(final int p0, final Object p1, final boolean p2);
    
    public native boolean n1111311(final int p0, final Object p1, final int p2);
    
    public native void n11113110(final int p0, final Object p1, final int p2, final boolean p3);
    
    public native boolean n11113111(final int p0, final Object p1, final int p2, final boolean p3);
    
    public native void n111131130(final int p0, final Object p1, final boolean p2, final boolean p3, final Object p4);
    
    public native Object n1111313(final int p0, final Object p1, final boolean p2);
    
    public native void n1111320(final int p0, final Object p1, final long p2);
    
    public native Object n111133(final int p0, final Object p1);
    
    public native void n1111330(final int p0, final Object p1, final Object p2);
    
    public native Object n1111333(final int p0, final Object p1, final Object p2);
    
    public native void n11113330(final int p0, final Object p1, final Object p2, final Object p3);
    
    public native void n1111333120(final int p0, final Object p1, final Object p2, final Object p3, final int p4, final long p5);
    
    public native long n1112();
    
    public native void n11120(final long p0);
    
    public native int n11121(final long p0);
    
    public native int n111211(final long p0, final int p1);
    
    public native long n11122(final long p0);
    
    public native Object n11123(final long p0);
    
    public native void n111230(final long p0, final Object p1);
    
    public native boolean n111231(final long p0, final Object p1);
    
    public native boolean n11123111(final long p0, final Object p1, final int p2, final int p3);
    
    public native long n111232(final long p0, final Object p1);
    
    public native void n1112320(final long p0, final Object p1, final long p2);
    
    public native Object n111233(final long p0, final Object p1);
    
    public native void n1112330(final long p0, final Object p1, final Object p2);
    
    public native Object n1113();
    
    public native void n11130(final Object p0);
    
    public native boolean n11131(final Object p0);
    
    public native void n111310(final Object p0, final int p1);
    
    public native boolean n111311(final Object p0, final int p1);
    
    public native void n1113110(final Object p0, final int p1, final int p2);
    
    public native int n1113111(final Object p0, final int p1, final int p2);
    
    public native void n11131110(final Object p0, final int p1, final byte p2, final int p3);
    
    public native void n111311110(final Object p0, final int p1, final int p2, final boolean p3, final boolean p4);
    
    public native Object n1113113(final Object p0, final boolean p1, final int p2);
    
    public native Object n11131133(final Object p0, final int p1, final int p2, final Object p3);
    
    public native long n111312(final Object p0, final boolean p1);
    
    public native Object n111313(final Object p0, final boolean p1);
    
    public native void n1113130(final Object p0, final boolean p1, final Object p2);
    
    public native boolean n1113131(final Object p0, final boolean p1, final Object p2);
    
    public native void n11131310(final Object p0, final int p1, final Object p2, final int p3);
    
    public native boolean n111313111(final Object p0, final int p1, final Object p2, final int p3, final int p4);
    
    public native Object n1113133(final Object p0, final boolean p1, final Object p2);
    
    public native Object n11131333(final Object p0, final boolean p1, final Object p2, final Object p3);
    
    public native void n111313330(final Object p0, final int p1, final Object p2, final Object p3, final Object p4);
    
    public native void n1113133330(final Object p0, final int p1, final Object p2, final Object p3, final Object p4, final Object p5);
    
    public native void n1113133333333330(final Object p0, final int p1, final Object p2, final Object p3, final Object p4, final Object p5, final Object p6, final Object p7, final Object p8, final Object p9, final Object p10, final Object p11);
    
    public native long n11132(final Object p0);
    
    public native void n111320(final Object p0, final long p1);
    
    public native int n111321(final Object p0, final long p1);
    
    public native void n1113210(final Object p0, final long p1, final int p2);
    
    public native Object n1113213(final Object p0, final long p1, final int p2);
    
    public native void n111321320(final Object p0, final long p1, final int p2, final Object p3, final long p4);
    
    public native long n111322(final Object p0, final long p1);
    
    public native void n1113220(final Object p0, final long p1, final long p2);
    
    public native void n11132210(final Object p0, final long p1, final long p2, final int p3);
    
    public native Object n1113223(final Object p0, final long p1, final long p2);
    
    public native Object n11132233(final Object p0, final long p1, final long p2, final Object p3);
    
    public native void n1113223310(final Object p0, final long p1, final long p2, final Object p3, final Object p4, final int p5);
    
    public native void n11132233110(final Object p0, final long p1, final long p2, final Object p3, final Object p4, final int p5, final boolean p6);
    
    public native void n111322332110(final Object p0, final long p1, final long p2, final Object p3, final Object p4, final long p5, final int p6, final boolean p7);
    
    public native Object n111323(final Object p0, final long p1);
    
    public native void n1113230(final Object p0, final long p1, final Object p2);
    
    public native void n11132320(final Object p0, final long p1, final Object p2, final long p3);
    
    public native Object n1113233(final Object p0, final long p1, final Object p2);
    
    public native void n11132330(final Object p0, final long p1, final Object p2, final Object p3);
    
    public native void n111323310(final Object p0, final long p1, final Object p2, final Object p3, final int p4);
    
    public native void n1113233110(final Object p0, final long p1, final Object p2, final Object p3, final int p4, final boolean p5);
    
    public native void n11132331210(final Object p0, final long p1, final Object p2, final Object p3, final int p4, final long p5, final boolean p6);
    
    public native Object n11132333(final Object p0, final long p1, final Object p2, final Object p3);
    
    public native void n111323330(final Object p0, final long p1, final Object p2, final Object p3, final Object p4);
    
    public native Object n11133(final Object p0);
    
    public native void n111330(final Object p0, final Object p1);
    
    public native int n111331(final Object p0, final Object p1);
    
    public native void n1113310(final Object p0, final Object p1, final boolean p2);
    
    public native void n11133110(final Object p0, final Object p1, final boolean p2, final int p3);
    
    public native void n1113311230(final Object p0, final Object p1, final int p2, final int p3, final long p4, final Object p5);
    
    public native void n11133130(final Object p0, final Object p1, final boolean p2, final Object p3);
    
    public native void n111331330(final Object p0, final Object p1, final int p2, final Object p3, final Object p4);
    
    public native void n1113320(final Object p0, final Object p1, final long p2);
    
    public native boolean n1113321(final Object p0, final Object p1, final long p2);
    
    public native boolean n11133211(final Object p0, final Object p1, final long p2, final int p3);
    
    public native Object n1113323(final Object p0, final Object p1, final long p2);
    
    public native void n111332320(final Object p0, final Object p1, final long p2, final Object p3, final long p4);
    
    public native void n111332330(final Object p0, final Object p1, final long p2, final Object p3, final Object p4);
    
    public native void n1113323311110(final Object p0, final Object p1, final long p2, final Object p3, final Object p4, final boolean p5, final boolean p6, final boolean p7, final boolean p8);
    
    public native Object n111333(final Object p0, final Object p1);
    
    public native void n1113330(final Object p0, final Object p1, final Object p2);
    
    public native int n1113331(final Object p0, final Object p1, final Object p2);
    
    public native void n11133310(final Object p0, final Object p1, final Object p2, final boolean p3);
    
    public native void n111333110(final Object p0, final Object p1, final Object p2, final int p3, final boolean p4);
    
    public native void n11133311130(final Object p0, final Object p1, final Object p2, final boolean p3, final int p4, final int p5, final Object p6);
    
    public native Object n111333113(final Object p0, final Object p1, final Object p2, final int p3, final boolean p4);
    
    public native void n111333120(final Object p0, final Object p1, final Object p2, final int p3, final long p4);
    
    public native void n111333130(final Object p0, final Object p1, final Object p2, final int p3, final Object p4);
    
    public native void n1113331310(final Object p0, final Object p1, final Object p2, final int p3, final Object p4, final boolean p5);
    
    public native void n11133313110(final Object p0, final Object p1, final Object p2, final int p3, final Object p4, final int p5, final boolean p6);
    
    public native Object n1113333(final Object p0, final Object p1, final Object p2);
    
    public native void n11133330(final Object p0, final Object p1, final Object p2, final Object p3);
    
    public native int n11133331(final Object p0, final Object p1, final Object p2, final Object p3);
    
    public native void n1113333130(final Object p0, final Object p1, final Object p2, final Object p3, final int p4, final Object p5);
    
    public native Object n11133333(final Object p0, final Object p1, final Object p2, final Object p3);
    
    public native void n111333330(final Object p0, final Object p1, final Object p2, final Object p3, final Object p4);
    
    public native Object n111333333(final Object p0, final Object p1, final Object p2, final Object p3, final Object p4);
    
    public final void onCreate() {
        super.onCreate();
        while (true) {
            if (!Configuration.ENABLE_CRASH_REPORT) {
                break Label_0067;
            }
            final String s = "com.qihoo.bugreport.CrashReport";
            try {
                Class.forName(s).getDeclaredMethod("prepareInit", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
                final Context baseContext = StubApp.\u1d62\u02cb.getBaseContext();
                try {
                    interface7(StubApp.\u1d62\u02ce, baseContext);
                    if (StubApp.\u1d62\u02ce != null) {
                        StubApp.\u1d62\u02ce.onCreate();
                    }
                    Label_0275: {
                        if (!Configuration.ENABLE_CRASH_REPORT) {
                            break Label_0275;
                        }
                        final String s2 = "com.qihoo.bugreport.CrashReport";
                        try {
                            Class.forName(s2).getDeclaredMethod("init", Context.class).invoke(null, this.getApplicationContext());
                            final Application \u1d62\u02ce = StubApp.\u1d62\u02ce;
                            final String s3 = "com.qihoo.jiagutracker.TrackerMain";
                            try {
                                Class.forName(s3).getDeclaredMethod("init", Application.class).invoke(null, \u1d62\u02ce);
                                final String s4 = "com.qihoo.util.bxb.init.DJadInit";
                                try {
                                    Class.forName(s4).getDeclaredMethod("init", Context.class).invoke(null, this.getApplicationContext());
                                }
                                finally {}
                            }
                            finally {}
                        }
                        finally {}
                    }
                }
                catch (Exception ex) {}
            }
            finally {
                continue;
            }
            break;
        }
    }
}
