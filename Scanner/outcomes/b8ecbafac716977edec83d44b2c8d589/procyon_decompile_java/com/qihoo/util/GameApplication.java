// 
// Decompiled by Procyon v0.5.30
// 

package com.qihoo.util;

import android.location.Location;
import android.location.LocationManager;
import java.io.InputStream;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import java.util.Enumeration;
import dalvik.system.DexFile;
import java.util.HashMap;
import java.util.Map;
import android.content.Context;
import android.app.Application;

public class GameApplication extends Application
{
    private static Application \u1d62\u02cb;
    private static Context \u1d62\u02ce;
    private static String \u1d62\u02cf;
    private static Map \u1d62\u02d1;
    
    static {
        GameApplication.\u1d62\u02cf = null;
        GameApplication.\u1d62\u02d1 = new HashMap();
    }
    
    public static Context getAppContext() {
        return GameApplication.\u1d62\u02ce;
    }
    
    public static String getDir() {
        return GameApplication.\u1d62\u02cf;
    }
    
    public static String getString2(final String s) {
        try {
            final int int1 = Integer.parseInt(s);
            try {
                final Map \u1d62\u02d1 = GameApplication.\u1d62\u02d1;
                try {
                    final String value = \u1d62\u02d1.get(int1);
                    try {
                        String interface14 = value;
                        if (interface14 != null) {
                            return interface14;
                        }
                        interface14 = interface14(int1);
                        try {
                            final Map \u1d62\u02d12 = GameApplication.\u1d62\u02d1;
                            try {
                                \u1d62\u02d12.put(int1, interface14);
                                return interface14;
                            }
                            catch (NumberFormatException ex) {
                                interface14 = null;
                            }
                        }
                        catch (NumberFormatException ex2) {}
                    }
                    catch (NumberFormatException ex3) {}
                }
                catch (NumberFormatException ex4) {}
            }
            catch (NumberFormatException ex5) {}
        }
        catch (NumberFormatException ex6) {}
    }
    
    public static native void interface10(final Context p0);
    
    public static native void interface11(final int p0);
    
    public static native Enumeration interface12(final DexFile p0);
    
    public static native String interface14(final int p0);
    
    public static native AssetFileDescriptor interface17(final AssetManager p0, final String p1);
    
    public static native InputStream interface18(final Class p0, final String p1);
    
    public static native InputStream interface19(final ClassLoader p0, final String p1);
    
    public static native void interface20();
    
    public static native void interface5(final Application p0);
    
    public static native String interface6(final String p0);
    
    public static native boolean interface7(final Application p0, final Context p1);
    
    public static native boolean interface8(final Application p0, final Context p1);
    
    public static void load(final Application p0, final Context p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: putstatic       com/qihoo/util/GameApplication.\u1d62\u02cb:Landroid/app/Application;
        //     4: aload_1        
        //     5: putstatic       com/qihoo/util/GameApplication.\u1d62\u02ce:Landroid/content/Context;
        //     8: aload_1        
        //     9: ifnull          61
        //    12: getstatic       com/qihoo/util/GameApplication.\u1d62\u02ce:Landroid/content/Context;
        //    15: invokevirtual   android/content/Context.getFilesDir:()Ljava/io/File;
        //    18: astore_2       
        //    19: aload_2        
        //    20: ifnull          61
        //    23: aload_2        
        //    24: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
        //    27: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //    30: astore_2       
        //    31: new             Ljava/lang/StringBuilder;
        //    34: astore_3       
        //    35: aload_3        
        //    36: invokespecial   java/lang/StringBuilder.<init>:()V
        //    39: aload_3        
        //    40: aload_2        
        //    41: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    44: astore_2       
        //    45: ldc             "/.jiagu"
        //    47: astore_3       
        //    48: aload_2        
        //    49: aload_3        
        //    50: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    53: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    56: astore_2       
        //    57: aload_2        
        //    58: putstatic       com/qihoo/util/GameApplication.\u1d62\u02cf:Ljava/lang/String;
        //    61: invokestatic    com/qihoo/util/GameApplication.\u1d62\u02cb:()Z
        //    64: istore          4
        //    66: iload           4
        //    68: ifeq            215
        //    71: ldc             "jiagu_x86"
        //    73: astore_2       
        //    74: aload_2        
        //    75: invokestatic    java/lang/System.loadLibrary:(Ljava/lang/String;)V
        //    78: getstatic       com/qihoo/util/GameApplication.\u1d62\u02cb:Landroid/app/Application;
        //    81: invokestatic    com/qihoo/util/GameApplication.interface5:(Landroid/app/Application;)V
        //    84: ldc             "com.qihoo.bugreport.CrashReport"
        //    86: astore_2       
        //    87: aload_2        
        //    88: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //    91: astore_2       
        //    92: ldc             "prepareInit"
        //    94: astore_3       
        //    95: iconst_0       
        //    96: istore          5
        //    98: aconst_null    
        //    99: astore          6
        //   101: iconst_0       
        //   102: anewarray       Ljava/lang/Class;
        //   105: astore          6
        //   107: aload_2        
        //   108: aload_3        
        //   109: aload           6
        //   111: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   114: astore_3       
        //   115: iconst_0       
        //   116: istore          5
        //   118: aconst_null    
        //   119: astore          6
        //   121: aconst_null    
        //   122: astore          7
        //   124: iconst_0       
        //   125: anewarray       Ljava/lang/Object;
        //   128: astore          7
        //   130: aload_3        
        //   131: aconst_null    
        //   132: aload           7
        //   134: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   137: pop            
        //   138: ldc             "init"
        //   140: astore_3       
        //   141: iconst_1       
        //   142: istore          5
        //   144: iload           5
        //   146: anewarray       Ljava/lang/Class;
        //   149: astore          6
        //   151: aconst_null    
        //   152: astore          7
        //   154: ldc             Landroid/content/Context;.class
        //   156: astore          8
        //   158: aload           6
        //   160: iconst_0       
        //   161: aload           8
        //   163: aastore        
        //   164: aload_2        
        //   165: aload_3        
        //   166: aload           6
        //   168: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   171: astore_2       
        //   172: aconst_null    
        //   173: astore_3       
        //   174: iconst_1       
        //   175: istore          5
        //   177: iload           5
        //   179: anewarray       Ljava/lang/Object;
        //   182: astore          6
        //   184: aconst_null    
        //   185: astore          7
        //   187: getstatic       com/qihoo/util/GameApplication.\u1d62\u02cb:Landroid/app/Application;
        //   190: astore          8
        //   192: aload           6
        //   194: iconst_0       
        //   195: aload           8
        //   197: aastore        
        //   198: aload_2        
        //   199: aconst_null    
        //   200: aload           6
        //   202: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   205: pop            
        //   206: ldc             "mono"
        //   208: astore_2       
        //   209: aload_2        
        //   210: invokestatic    java/lang/System.loadLibrary:(Ljava/lang/String;)V
        //   213: return         
        //   214: astore_2       
        //   215: ldc             "jiagu"
        //   217: astore_2       
        //   218: aload_2        
        //   219: invokestatic    java/lang/System.loadLibrary:(Ljava/lang/String;)V
        //   222: goto            78
        //   225: astore_2       
        //   226: goto            213
        //   229: astore_2       
        //   230: goto            206
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  74     78     214    215    Any
        //  87     91     229    233    Any
        //  101    105    229    233    Any
        //  109    114    229    233    Any
        //  124    128    229    233    Any
        //  132    138    229    233    Any
        //  144    149    229    233    Any
        //  161    164    229    233    Any
        //  166    171    229    233    Any
        //  177    182    229    233    Any
        //  187    190    229    233    Any
        //  195    198    229    233    Any
        //  200    206    229    233    Any
        //  209    213    225    229    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0206:
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
    
    public static native Location mark(final LocationManager p0, final String p1);
    
    public static native void mark();
    
    public static native void mark(final Location p0);
    
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
        load(this, context);
    }
}
