// 
// Decompiled by Procyon v0.5.30
// 

package com.qihoo.util;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import android.content.Context;
import android.app.Application;

public class OverseaApplication extends Application
{
    private static boolean loadDexToC;
    private static boolean selfLoad;
    private static Context \u1d62\u02cb;
    private static String \u1d62\u02ce;
    private static Map \u1d62\u02cf;
    
    static {
        OverseaApplication.\u1d62\u02ce = null;
        OverseaApplication.loadDexToC = false;
        OverseaApplication.\u1d62\u02cf = new ConcurrentHashMap();
        OverseaApplication.selfLoad = true;
    }
    
    public static Context getAppContext() {
        return OverseaApplication.\u1d62\u02cb;
    }
    
    public static String getDir() {
        return OverseaApplication.\u1d62\u02ce;
    }
    
    public static String getString2(final int n) {
        String interface14 = OverseaApplication.\u1d62\u02cf.get(n);
        if (interface14 == null) {
            interface14 = interface14(n);
            OverseaApplication.\u1d62\u02cf.put(n, interface14);
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
                final String string2 = null;
            }
        }
        catch (NumberFormatException ex2) {}
    }
    
    public static native void interface11(final int p0);
    
    public static native String interface14(final int p0);
    
    public static native boolean interface20();
    
    public static void load() {
        Label_0017: {
            if (!\u1d62\u02cb()) {
                break Label_0017;
            }
            final String s = "safety_x86";
            try {
                System.loadLibrary(s);
                return;
            }
            finally {}
        }
        System.loadLibrary("safety");
    }
    
    public static void load(final Application application, final Context \u1d62\u02cb) {
        OverseaApplication.\u1d62\u02cb = \u1d62\u02cb;
        if (\u1d62\u02cb != null) {
            final File filesDir = OverseaApplication.\u1d62\u02cb.getFilesDir();
            if (filesDir != null) {
                OverseaApplication.\u1d62\u02ce = filesDir.getParentFile().getAbsolutePath() + "/.jiagu";
            }
        }
        if (!interface20()) {
            System.exit(1);
        }
        if (!OverseaApplication.loadDexToC) {
            return;
        }
        final String s = "jgdtc";
        try {
            System.loadLibrary(s);
        }
        catch (Error error) {}
    }
    
    private static boolean \u1d62\u02cb() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: iconst_1       
        //     1: istore_0       
        //     2: getstatic       android/os/Build.SUPPORTED_32_BIT_ABIS:[Ljava/lang/String;
        //     5: astore_1       
        //     6: aload_1        
        //     7: arraylength    
        //     8: istore_2       
        //     9: iconst_0       
        //    10: istore_3       
        //    11: aconst_null    
        //    12: astore          4
        //    14: iload_3        
        //    15: iload_2        
        //    16: if_icmpge       51
        //    19: aload_1        
        //    20: iload_3        
        //    21: aaload         
        //    22: astore          5
        //    24: ldc             "x86"
        //    26: astore          6
        //    28: aload           5
        //    30: aload           6
        //    32: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //    35: istore          7
        //    37: iload           7
        //    39: ifeq            44
        //    42: iload_0        
        //    43: ireturn        
        //    44: iload_3        
        //    45: iconst_1       
        //    46: iadd           
        //    47: istore_3       
        //    48: goto            14
        //    51: getstatic       android/os/Build.CPU_ABI:Ljava/lang/String;
        //    54: astore          4
        //    56: ldc             "x86"
        //    58: astore_1       
        //    59: aload           4
        //    61: aload_1        
        //    62: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //    65: istore_3       
        //    66: iload_3        
        //    67: ifne            42
        //    70: getstatic       android/os/Build.CPU_ABI2:Ljava/lang/String;
        //    73: astore          4
        //    75: ldc             "x86"
        //    77: astore_1       
        //    78: aload           4
        //    80: aload_1        
        //    81: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //    84: istore_3       
        //    85: iload_3        
        //    86: ifne            42
        //    89: iconst_0       
        //    90: istore          8
        //    92: aconst_null    
        //    93: astore_1       
        //    94: new             Ljava/io/RandomAccessFile;
        //    97: astore          4
        //    99: ldc             "/system/build.prop"
        //   101: astore          9
        //   103: ldc             "r"
        //   105: astore          5
        //   107: aload           4
        //   109: aload           9
        //   111: aload           5
        //   113: invokespecial   java/io/RandomAccessFile.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //   116: aload           4
        //   118: invokevirtual   java/io/RandomAccessFile.readLine:()Ljava/lang/String;
        //   121: astore_1       
        //   122: aload_1        
        //   123: ifnull          222
        //   126: ldc             "ro.product.cpu.abi"
        //   128: astore          9
        //   130: aload_1        
        //   131: aload           9
        //   133: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   136: istore_2       
        //   137: iload_2        
        //   138: ifeq            213
        //   141: ldc             "x86"
        //   143: astore          9
        //   145: aload_1        
        //   146: aload           9
        //   148: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   151: istore          8
        //   153: iload           8
        //   155: ifeq            213
        //   158: aload           4
        //   160: invokevirtual   java/io/RandomAccessFile.close:()V
        //   163: goto            42
        //   166: pop            
        //   167: goto            42
        //   170: astore          4
        //   172: getstatic       android/os/Build.CPU_ABI:Ljava/lang/String;
        //   175: astore          4
        //   177: ldc             "x86"
        //   179: astore_1       
        //   180: aload           4
        //   182: aload_1        
        //   183: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   186: istore_3       
        //   187: iload_3        
        //   188: ifne            42
        //   191: getstatic       android/os/Build.CPU_ABI2:Ljava/lang/String;
        //   194: astore          4
        //   196: ldc             "x86"
        //   198: astore_1       
        //   199: aload           4
        //   201: aload_1        
        //   202: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   205: istore_3       
        //   206: iload_3        
        //   207: ifeq            89
        //   210: goto            42
        //   213: aload           4
        //   215: invokevirtual   java/io/RandomAccessFile.readLine:()Ljava/lang/String;
        //   218: astore_1       
        //   219: goto            122
        //   222: aload           4
        //   224: invokevirtual   java/io/RandomAccessFile.close:()V
        //   227: iconst_0       
        //   228: istore_0       
        //   229: aconst_null    
        //   230: astore          10
        //   232: goto            42
        //   235: astore          10
        //   237: iconst_0       
        //   238: istore_0       
        //   239: aconst_null    
        //   240: astore          10
        //   242: aload           10
        //   244: ifnull          227
        //   247: aload           10
        //   249: invokevirtual   java/io/RandomAccessFile.close:()V
        //   252: goto            227
        //   255: astore          10
        //   257: goto            227
        //   260: astore          10
        //   262: iconst_0       
        //   263: istore_3       
        //   264: aconst_null    
        //   265: astore          4
        //   267: aload           4
        //   269: ifnull          227
        //   272: aload           4
        //   274: invokevirtual   java/io/RandomAccessFile.close:()V
        //   277: goto            227
        //   280: astore          10
        //   282: goto            227
        //   285: astore          10
        //   287: iconst_0       
        //   288: istore_3       
        //   289: aconst_null    
        //   290: astore          4
        //   292: aload           4
        //   294: ifnull          302
        //   297: aload           4
        //   299: invokevirtual   java/io/RandomAccessFile.close:()V
        //   302: aload           10
        //   304: athrow         
        //   305: astore          10
        //   307: goto            227
        //   310: pop            
        //   311: goto            302
        //   314: astore          10
        //   316: goto            292
        //   319: astore          10
        //   321: goto            267
        //   324: astore          10
        //   326: aload           4
        //   328: astore          10
        //   330: goto            242
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  2      5      170    213    Ljava/lang/NoSuchFieldError;
        //  6      8      170    213    Ljava/lang/NoSuchFieldError;
        //  20     22     170    213    Ljava/lang/NoSuchFieldError;
        //  30     35     170    213    Ljava/lang/NoSuchFieldError;
        //  51     54     170    213    Ljava/lang/NoSuchFieldError;
        //  61     65     170    213    Ljava/lang/NoSuchFieldError;
        //  70     73     170    213    Ljava/lang/NoSuchFieldError;
        //  80     84     170    213    Ljava/lang/NoSuchFieldError;
        //  94     97     235    242    Ljava/io/FileNotFoundException;
        //  94     97     260    267    Ljava/io/IOException;
        //  94     97     285    292    Any
        //  111    116    235    242    Ljava/io/FileNotFoundException;
        //  111    116    260    267    Ljava/io/IOException;
        //  111    116    285    292    Any
        //  116    121    324    333    Ljava/io/FileNotFoundException;
        //  116    121    319    324    Ljava/io/IOException;
        //  116    121    314    319    Any
        //  131    136    324    333    Ljava/io/FileNotFoundException;
        //  131    136    319    324    Ljava/io/IOException;
        //  131    136    314    319    Any
        //  146    151    324    333    Ljava/io/FileNotFoundException;
        //  146    151    319    324    Ljava/io/IOException;
        //  146    151    314    319    Any
        //  158    163    166    170    Ljava/lang/Exception;
        //  213    218    324    333    Ljava/io/FileNotFoundException;
        //  213    218    319    324    Ljava/io/IOException;
        //  213    218    314    319    Any
        //  222    227    305    310    Ljava/lang/Exception;
        //  247    252    255    260    Ljava/lang/Exception;
        //  272    277    280    285    Ljava/lang/Exception;
        //  297    302    310    314    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 173, Size: 173
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:657)
        //     at java.util.ArrayList.get(ArrayList.java:433)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3303)
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
    
    protected void attachBaseContext(final Context context) {
        super.attachBaseContext(context);
        if (OverseaApplication.selfLoad) {
            load();
        }
        load(this, context);
    }
}
