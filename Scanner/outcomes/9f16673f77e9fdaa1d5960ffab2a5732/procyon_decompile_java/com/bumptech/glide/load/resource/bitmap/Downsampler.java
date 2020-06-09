// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap$Config;
import android.os.Build$VERSION;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import android.util.Log;
import android.graphics.Rect;
import java.io.InputStream;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory$Options;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import com.bumptech.glide.util.Util;
import java.util.EnumSet;
import java.util.Set;
import java.util.Queue;

public abstract class Downsampler implements BitmapDecoder
{
    public static final Downsampler AT_LEAST;
    public static final Downsampler AT_MOST;
    private static final int MARK_POSITION = 5242880;
    public static final Downsampler NONE;
    private static final Queue OPTIONS_QUEUE;
    private static final String TAG = "Downsampler";
    private static final Set TYPES_THAT_USE_POOL;
    
    static {
        TYPES_THAT_USE_POOL = EnumSet.of(ImageHeaderParser$ImageType.JPEG, ImageHeaderParser$ImageType.PNG_A, ImageHeaderParser$ImageType.PNG);
        OPTIONS_QUEUE = Util.createQueue(0);
        AT_LEAST = new Downsampler$1();
        AT_MOST = new Downsampler$2();
        NONE = new Downsampler$3();
    }
    
    private static Bitmap decodeStream(final MarkEnforcingInputStream markEnforcingInputStream, final RecyclableBufferedInputStream recyclableBufferedInputStream, final BitmapFactory$Options bitmapFactory$Options) {
        if (bitmapFactory$Options.inJustDecodeBounds) {
            markEnforcingInputStream.mark(5242880);
        }
        else {
            recyclableBufferedInputStream.fixMarkLimit();
        }
        final Bitmap decodeStream = BitmapFactory.decodeStream((InputStream)markEnforcingInputStream, (Rect)null, bitmapFactory$Options);
        try {
            if (bitmapFactory$Options.inJustDecodeBounds) {
                markEnforcingInputStream.reset();
            }
        }
        catch (IOException ex) {
            if (Log.isLoggable("Downsampler", 6)) {
                final String s = "Downsampler";
                final StringBuilder sb = new StringBuilder();
                sb.append("Exception loading inDecodeBounds=");
                sb.append(bitmapFactory$Options.inJustDecodeBounds);
                sb.append(" sample=");
                sb.append(bitmapFactory$Options.inSampleSize);
                Log.e(s, sb.toString(), (Throwable)ex);
            }
        }
        return decodeStream;
    }
    
    private Bitmap downsampleWithSize(final MarkEnforcingInputStream markEnforcingInputStream, final RecyclableBufferedInputStream recyclableBufferedInputStream, final BitmapFactory$Options bitmapFactory$Options, final BitmapPool bitmapPool, final int n, final int n2, final int inSampleSize, final DecodeFormat decodeFormat) {
        final Bitmap$Config config = getConfig(markEnforcingInputStream, decodeFormat);
        bitmapFactory$Options.inSampleSize = inSampleSize;
        bitmapFactory$Options.inPreferredConfig = config;
        if ((bitmapFactory$Options.inSampleSize == 1 || 19 <= Build$VERSION.SDK_INT) && shouldUsePool(markEnforcingInputStream)) {
            final double n3 = n;
            final double n4 = inSampleSize;
            Double.isNaN(n3);
            Double.isNaN(n4);
            final int n5 = (int)Math.ceil(n3 / n4);
            final double n6 = n2;
            final double n7 = inSampleSize;
            Double.isNaN(n6);
            Double.isNaN(n7);
            setInBitmap(bitmapFactory$Options, bitmapPool.getDirty(n5, (int)Math.ceil(n6 / n7), config));
        }
        return decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, bitmapFactory$Options);
    }
    
    private static Bitmap$Config getConfig(final InputStream p0, final DecodeFormat p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: getstatic       com/bumptech/glide/load/DecodeFormat.ALWAYS_ARGB_8888:Lcom/bumptech/glide/load/DecodeFormat;
        //     3: astore_2       
        //     4: aload_1        
        //     5: aload_2        
        //     6: if_acmpeq       300
        //     9: getstatic       com/bumptech/glide/load/DecodeFormat.PREFER_ARGB_8888:Lcom/bumptech/glide/load/DecodeFormat;
        //    12: astore_2       
        //    13: aload_1        
        //    14: aload_2        
        //    15: if_acmpeq       300
        //    18: getstatic       android/os/Build$VERSION.SDK_INT:I
        //    21: istore_3       
        //    22: bipush          16
        //    24: istore          4
        //    26: iload_3        
        //    27: iload           4
        //    29: if_icmpne       35
        //    32: goto            300
        //    35: iconst_0       
        //    36: istore_3       
        //    37: aconst_null    
        //    38: astore_2       
        //    39: aload_0        
        //    40: sipush          1024
        //    43: invokevirtual   java/io/InputStream.mark:(I)V
        //    46: iconst_5       
        //    47: istore          4
        //    49: new             Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser;
        //    52: astore          5
        //    54: aload           5
        //    56: aload_0        
        //    57: invokespecial   com/bumptech/glide/load/resource/bitmap/ImageHeaderParser.<init>:(Ljava/io/InputStream;)V
        //    60: aload           5
        //    62: invokevirtual   com/bumptech/glide/load/resource/bitmap/ImageHeaderParser.hasAlpha:()Z
        //    65: istore          6
        //    67: iload           6
        //    69: istore_3       
        //    70: aload_0        
        //    71: invokevirtual   java/io/InputStream.reset:()V
        //    74: goto            229
        //    77: astore          5
        //    79: ldc             "Downsampler"
        //    81: astore          7
        //    83: aload           7
        //    85: iload           4
        //    87: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //    90: istore          4
        //    92: iload           4
        //    94: ifeq            118
        //    97: ldc             "Downsampler"
        //    99: astore          8
        //   101: ldc             "Cannot reset the input stream"
        //   103: astore          7
        //   105: aload           8
        //   107: aload           7
        //   109: aload           5
        //   111: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   114: pop            
        //   115: goto            118
        //   118: goto            229
        //   121: astore          5
        //   123: goto            249
        //   126: astore          5
        //   128: ldc             "Downsampler"
        //   130: astore          7
        //   132: aload           7
        //   134: iload           4
        //   136: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   139: istore          9
        //   141: iload           9
        //   143: ifeq            199
        //   146: ldc             "Downsampler"
        //   148: astore          7
        //   150: new             Ljava/lang/StringBuilder;
        //   153: astore          10
        //   155: aload           10
        //   157: invokespecial   java/lang/StringBuilder.<init>:()V
        //   160: ldc             "Cannot determine whether the image has alpha or not from header for format "
        //   162: astore          11
        //   164: aload           10
        //   166: aload           11
        //   168: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   171: pop            
        //   172: aload           10
        //   174: aload_1        
        //   175: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   178: pop            
        //   179: aload           10
        //   181: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   184: astore          10
        //   186: aload           7
        //   188: aload           10
        //   190: aload           5
        //   192: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   195: pop            
        //   196: goto            199
        //   199: aload_0        
        //   200: invokevirtual   java/io/InputStream.reset:()V
        //   203: goto            74
        //   206: astore          5
        //   208: ldc             "Downsampler"
        //   210: astore          7
        //   212: aload           7
        //   214: iload           4
        //   216: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   219: istore          4
        //   221: iload           4
        //   223: ifeq            118
        //   226: goto            97
        //   229: iload_3        
        //   230: ifeq            241
        //   233: getstatic       android/graphics/Bitmap$Config.ARGB_8888:Landroid/graphics/Bitmap$Config;
        //   236: astore          8
        //   238: goto            246
        //   241: getstatic       android/graphics/Bitmap$Config.RGB_565:Landroid/graphics/Bitmap$Config;
        //   244: astore          8
        //   246: aload           8
        //   248: areturn        
        //   249: aload_0        
        //   250: invokevirtual   java/io/InputStream.reset:()V
        //   253: goto            297
        //   256: astore          7
        //   258: ldc             "Downsampler"
        //   260: astore          10
        //   262: aload           10
        //   264: iload           4
        //   266: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   269: istore          4
        //   271: iload           4
        //   273: ifeq            297
        //   276: ldc             "Downsampler"
        //   278: astore          8
        //   280: ldc             "Cannot reset the input stream"
        //   282: astore          10
        //   284: aload           8
        //   286: aload           10
        //   288: aload           7
        //   290: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   293: pop            
        //   294: goto            297
        //   297: aload           5
        //   299: athrow         
        //   300: getstatic       android/graphics/Bitmap$Config.ARGB_8888:Landroid/graphics/Bitmap$Config;
        //   303: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  49     52     126    229    Ljava/io/IOException;
        //  49     52     121    300    Any
        //  56     60     126    229    Ljava/io/IOException;
        //  56     60     121    300    Any
        //  60     65     126    229    Ljava/io/IOException;
        //  60     65     121    300    Any
        //  70     74     77     97     Ljava/io/IOException;
        //  134    139    121    300    Any
        //  150    153    121    300    Any
        //  155    160    121    300    Any
        //  166    172    121    300    Any
        //  174    179    121    300    Any
        //  179    184    121    300    Any
        //  190    196    121    300    Any
        //  199    203    206    229    Ljava/io/IOException;
        //  249    253    256    297    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 144, Size: 144
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
    
    private static BitmapFactory$Options getDefaultOptions() {
        synchronized (Downsampler.class) {
            Object options_QUEUE = Downsampler.OPTIONS_QUEUE;
            synchronized (options_QUEUE) {
                BitmapFactory$Options bitmapFactory$Options2;
                final BitmapFactory$Options bitmapFactory$Options = bitmapFactory$Options2 = Downsampler.OPTIONS_QUEUE.poll();
                // monitorexit(options_QUEUE)
                if (bitmapFactory$Options == null) {
                    options_QUEUE = (bitmapFactory$Options2 = new BitmapFactory$Options());
                    resetOptions((BitmapFactory$Options)options_QUEUE);
                }
                return bitmapFactory$Options2;
            }
        }
    }
    
    private int getRoundedSampleSize(final int n, final int n2, final int n3, final int n4, final int n5) {
        final int n6 = -1 << -1;
        int n7;
        if (n5 == n6) {
            n7 = n3;
        }
        else {
            n7 = n5;
        }
        int n8;
        if (n4 == n6) {
            n8 = n2;
        }
        else {
            n8 = n4;
        }
        int n9;
        if (n != 90 && n != 270) {
            n9 = this.getSampleSize(n2, n3, n8, n7);
        }
        else {
            n9 = this.getSampleSize(n3, n2, n8, n7);
        }
        int highestOneBit;
        if (n9 == 0) {
            highestOneBit = 0;
        }
        else {
            highestOneBit = Integer.highestOneBit(n9);
        }
        return Math.max(1, highestOneBit);
    }
    
    private static void releaseOptions(final BitmapFactory$Options bitmapFactory$Options) {
        resetOptions(bitmapFactory$Options);
        synchronized (Downsampler.OPTIONS_QUEUE) {
            Downsampler.OPTIONS_QUEUE.offer(bitmapFactory$Options);
        }
    }
    
    private static void resetOptions(final BitmapFactory$Options bitmapFactory$Options) {
        bitmapFactory$Options.inTempStorage = null;
        bitmapFactory$Options.inDither = false;
        bitmapFactory$Options.inScaled = false;
        final boolean b = true;
        bitmapFactory$Options.inSampleSize = (b ? 1 : 0);
        bitmapFactory$Options.inPreferredConfig = null;
        bitmapFactory$Options.inJustDecodeBounds = false;
        bitmapFactory$Options.outWidth = 0;
        bitmapFactory$Options.outHeight = 0;
        bitmapFactory$Options.outMimeType = null;
        if (11 <= Build$VERSION.SDK_INT) {
            bitmapFactory$Options.inBitmap = null;
            bitmapFactory$Options.inMutable = b;
        }
    }
    
    private static void setInBitmap(final BitmapFactory$Options bitmapFactory$Options, final Bitmap inBitmap) {
        if (11 <= Build$VERSION.SDK_INT) {
            bitmapFactory$Options.inBitmap = inBitmap;
        }
    }
    
    private static boolean shouldUsePool(final InputStream p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: getstatic       android/os/Build$VERSION.SDK_INT:I
        //     3: istore_1       
        //     4: bipush          19
        //     6: istore_2       
        //     7: iload_2        
        //     8: iload_1        
        //     9: if_icmpgt       14
        //    12: iconst_1       
        //    13: ireturn        
        //    14: aload_0        
        //    15: sipush          1024
        //    18: invokevirtual   java/io/InputStream.mark:(I)V
        //    21: iconst_5       
        //    22: istore_1       
        //    23: new             Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser;
        //    26: astore_3       
        //    27: aload_3        
        //    28: aload_0        
        //    29: invokespecial   com/bumptech/glide/load/resource/bitmap/ImageHeaderParser.<init>:(Ljava/io/InputStream;)V
        //    32: aload_3        
        //    33: invokevirtual   com/bumptech/glide/load/resource/bitmap/ImageHeaderParser.getType:()Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser$ImageType;
        //    36: astore_3       
        //    37: getstatic       com/bumptech/glide/load/resource/bitmap/Downsampler.TYPES_THAT_USE_POOL:Ljava/util/Set;
        //    40: astore          4
        //    42: aload           4
        //    44: aload_3        
        //    45: invokeinterface java/util/Set.contains:(Ljava/lang/Object;)Z
        //    50: istore          5
        //    52: aload_0        
        //    53: invokevirtual   java/io/InputStream.reset:()V
        //    56: goto            97
        //    59: astore          6
        //    61: ldc             "Downsampler"
        //    63: astore          7
        //    65: aload           7
        //    67: iload_1        
        //    68: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //    71: istore_1       
        //    72: iload_1        
        //    73: ifeq            97
        //    76: ldc             "Downsampler"
        //    78: astore          8
        //    80: ldc             "Cannot reset the input stream"
        //    82: astore          7
        //    84: aload           8
        //    86: aload           7
        //    88: aload           6
        //    90: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    93: pop            
        //    94: goto            97
        //    97: iload           5
        //    99: ireturn        
        //   100: astore_3       
        //   101: goto            188
        //   104: astore_3       
        //   105: ldc             "Downsampler"
        //   107: astore          4
        //   109: aload           4
        //   111: iload_1        
        //   112: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   115: istore          5
        //   117: iload           5
        //   119: ifeq            143
        //   122: ldc             "Downsampler"
        //   124: astore          4
        //   126: ldc_w           "Cannot determine the image type from header"
        //   129: astore          6
        //   131: aload           4
        //   133: aload           6
        //   135: aload_3        
        //   136: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   139: pop            
        //   140: goto            143
        //   143: aload_0        
        //   144: invokevirtual   java/io/InputStream.reset:()V
        //   147: goto            186
        //   150: astore_3       
        //   151: ldc             "Downsampler"
        //   153: astore          4
        //   155: aload           4
        //   157: iload_1        
        //   158: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   161: istore_1       
        //   162: iload_1        
        //   163: ifeq            186
        //   166: ldc             "Downsampler"
        //   168: astore          8
        //   170: ldc             "Cannot reset the input stream"
        //   172: astore          4
        //   174: aload           8
        //   176: aload           4
        //   178: aload_3        
        //   179: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   182: pop            
        //   183: goto            186
        //   186: iconst_0       
        //   187: ireturn        
        //   188: aload_0        
        //   189: invokevirtual   java/io/InputStream.reset:()V
        //   192: goto            233
        //   195: astore          4
        //   197: ldc             "Downsampler"
        //   199: astore          6
        //   201: aload           6
        //   203: iload_1        
        //   204: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   207: istore_1       
        //   208: iload_1        
        //   209: ifeq            233
        //   212: ldc             "Downsampler"
        //   214: astore          8
        //   216: ldc             "Cannot reset the input stream"
        //   218: astore          6
        //   220: aload           8
        //   222: aload           6
        //   224: aload           4
        //   226: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   229: pop            
        //   230: goto            233
        //   233: aload_3        
        //   234: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  23     26     104    188    Ljava/io/IOException;
        //  23     26     100    235    Any
        //  28     32     104    188    Ljava/io/IOException;
        //  28     32     100    235    Any
        //  32     36     104    188    Ljava/io/IOException;
        //  32     36     100    235    Any
        //  37     40     104    188    Ljava/io/IOException;
        //  37     40     100    235    Any
        //  44     50     104    188    Ljava/io/IOException;
        //  44     50     100    235    Any
        //  52     56     59     97     Ljava/io/IOException;
        //  111    115    100    235    Any
        //  135    140    100    235    Any
        //  143    147    150    186    Ljava/io/IOException;
        //  188    192    195    233    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0097:
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
    
    public Bitmap decode(final InputStream p0, final BitmapPool p1, final int p2, final int p3, final DecodeFormat p4) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_2        
        //     1: astore          6
        //     3: invokestatic    com/bumptech/glide/util/ByteArrayPool.get:()Lcom/bumptech/glide/util/ByteArrayPool;
        //     6: astore          7
        //     8: aload           7
        //    10: invokevirtual   com/bumptech/glide/util/ByteArrayPool.getBytes:()[B
        //    13: astore          8
        //    15: aload           7
        //    17: invokevirtual   com/bumptech/glide/util/ByteArrayPool.getBytes:()[B
        //    20: astore          9
        //    22: invokestatic    com/bumptech/glide/load/resource/bitmap/Downsampler.getDefaultOptions:()Landroid/graphics/BitmapFactory$Options;
        //    25: astore          10
        //    27: new             Lcom/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream;
        //    30: astore          11
        //    32: aload           11
        //    34: aload_1        
        //    35: aload           9
        //    37: invokespecial   com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.<init>:(Ljava/io/InputStream;[B)V
        //    40: aload           11
        //    42: astore          12
        //    44: aload           11
        //    46: invokestatic    com/bumptech/glide/util/ExceptionCatchingInputStream.obtain:(Ljava/io/InputStream;)Lcom/bumptech/glide/util/ExceptionCatchingInputStream;
        //    49: astore          13
        //    51: new             Lcom/bumptech/glide/util/MarkEnforcingInputStream;
        //    54: astore          11
        //    56: aload           11
        //    58: aload           13
        //    60: invokespecial   com/bumptech/glide/util/MarkEnforcingInputStream.<init>:(Ljava/io/InputStream;)V
        //    63: aload           11
        //    65: astore          14
        //    67: ldc             5242880
        //    69: istore          15
        //    71: aload           13
        //    73: iload           15
        //    75: invokevirtual   com/bumptech/glide/util/ExceptionCatchingInputStream.mark:(I)V
        //    78: iconst_0       
        //    79: istore          16
        //    81: aconst_null    
        //    82: astore          17
        //    84: iconst_5       
        //    85: istore          18
        //    87: new             Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser;
        //    90: astore          11
        //    92: aload           11
        //    94: aload           13
        //    96: invokespecial   com/bumptech/glide/load/resource/bitmap/ImageHeaderParser.<init>:(Ljava/io/InputStream;)V
        //    99: aload           11
        //   101: invokevirtual   com/bumptech/glide/load/resource/bitmap/ImageHeaderParser.getOrientation:()I
        //   104: istore          15
        //   106: iload           15
        //   108: istore          16
        //   110: aload           13
        //   112: invokevirtual   com/bumptech/glide/util/ExceptionCatchingInputStream.reset:()V
        //   115: goto            172
        //   118: astore          11
        //   120: aload           13
        //   122: astore          19
        //   124: goto            597
        //   127: astore          11
        //   129: aload           11
        //   131: astore          20
        //   133: ldc             "Downsampler"
        //   135: astore          20
        //   137: aload           20
        //   139: iload           18
        //   141: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   144: istore          18
        //   146: iload           18
        //   148: ifeq            172
        //   151: ldc             "Downsampler"
        //   153: astore          21
        //   155: ldc             "Cannot reset the input stream"
        //   157: astore          20
        //   159: aload           21
        //   161: aload           20
        //   163: aload           11
        //   165: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   168: pop            
        //   169: goto            172
        //   172: iload           16
        //   174: istore          15
        //   176: goto            290
        //   179: astore          11
        //   181: aload           11
        //   183: astore          20
        //   185: aload           13
        //   187: astore          19
        //   189: goto            530
        //   192: astore          11
        //   194: ldc             "Downsampler"
        //   196: astore          20
        //   198: aload           20
        //   200: iload           18
        //   202: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   205: istore          22
        //   207: iload           22
        //   209: ifeq            234
        //   212: ldc             "Downsampler"
        //   214: astore          20
        //   216: ldc_w           "Cannot determine the image orientation from header"
        //   219: astore          23
        //   221: aload           20
        //   223: aload           23
        //   225: aload           11
        //   227: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   230: pop            
        //   231: goto            234
        //   234: aload           13
        //   236: invokevirtual   com/bumptech/glide/util/ExceptionCatchingInputStream.reset:()V
        //   239: goto            115
        //   242: astore          11
        //   244: aload           11
        //   246: astore          20
        //   248: ldc             "Downsampler"
        //   250: astore          20
        //   252: aload           20
        //   254: iload           18
        //   256: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   259: istore          18
        //   261: iload           18
        //   263: ifeq            287
        //   266: ldc             "Downsampler"
        //   268: astore          21
        //   270: ldc             "Cannot reset the input stream"
        //   272: astore          20
        //   274: aload           21
        //   276: aload           20
        //   278: aload           11
        //   280: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   283: pop            
        //   284: goto            172
        //   287: goto            172
        //   290: aload           10
        //   292: aload           8
        //   294: putfield        android/graphics/BitmapFactory$Options.inTempStorage:[B
        //   297: aload_0        
        //   298: aload           14
        //   300: aload           12
        //   302: aload           10
        //   304: invokevirtual   com/bumptech/glide/load/resource/bitmap/Downsampler.getDimensions:(Lcom/bumptech/glide/util/MarkEnforcingInputStream;Lcom/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream;Landroid/graphics/BitmapFactory$Options;)[I
        //   307: astore          24
        //   309: iconst_0       
        //   310: istore          16
        //   312: aconst_null    
        //   313: astore          17
        //   315: aload           24
        //   317: iconst_0       
        //   318: iaload         
        //   319: istore          25
        //   321: iconst_1       
        //   322: istore          16
        //   324: aload           24
        //   326: iload           16
        //   328: iaload         
        //   329: istore          26
        //   331: iload           15
        //   333: invokestatic    com/bumptech/glide/load/resource/bitmap/TransformationUtils.getExifOrientationDegrees:(I)I
        //   336: istore          27
        //   338: aload_0        
        //   339: iload           27
        //   341: iload           25
        //   343: iload           26
        //   345: iload_3        
        //   346: iload           4
        //   348: invokespecial   com/bumptech/glide/load/resource/bitmap/Downsampler.getRoundedSampleSize:(IIIII)I
        //   351: istore          28
        //   353: aload_0        
        //   354: astore          17
        //   356: aload           14
        //   358: astore          21
        //   360: aload           12
        //   362: astore          20
        //   364: aload           10
        //   366: astore          23
        //   368: aload           13
        //   370: astore          19
        //   372: aload           5
        //   374: astore          12
        //   376: aload_0        
        //   377: aload           14
        //   379: aload           20
        //   381: aload           10
        //   383: aload_2        
        //   384: iload           25
        //   386: iload           26
        //   388: iload           28
        //   390: aload           5
        //   392: invokespecial   com/bumptech/glide/load/resource/bitmap/Downsampler.downsampleWithSize:(Lcom/bumptech/glide/util/MarkEnforcingInputStream;Lcom/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream;Landroid/graphics/BitmapFactory$Options;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;IIILcom/bumptech/glide/load/DecodeFormat;)Landroid/graphics/Bitmap;
        //   395: astore          17
        //   397: aload           13
        //   399: invokevirtual   com/bumptech/glide/util/ExceptionCatchingInputStream.getException:()Ljava/io/IOException;
        //   402: astore          21
        //   404: aload           21
        //   406: ifnonnull       505
        //   409: iconst_0       
        //   410: istore          22
        //   412: aconst_null    
        //   413: astore          20
        //   415: aload           17
        //   417: ifnull          476
        //   420: aload           17
        //   422: aload           6
        //   424: iload           15
        //   426: invokestatic    com/bumptech/glide/load/resource/bitmap/TransformationUtils.rotateImageExif:(Landroid/graphics/Bitmap;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;I)Landroid/graphics/Bitmap;
        //   429: astore          23
        //   431: aload           23
        //   433: astore          20
        //   435: aload           17
        //   437: aload           23
        //   439: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //   442: istore          29
        //   444: iload           29
        //   446: ifne            473
        //   449: aload           6
        //   451: aload           17
        //   453: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/BitmapPool.put:(Landroid/graphics/Bitmap;)Z
        //   458: istore          29
        //   460: iload           29
        //   462: ifne            473
        //   465: aload           17
        //   467: invokevirtual   android/graphics/Bitmap.recycle:()V
        //   470: goto            476
        //   473: goto            476
        //   476: aload           7
        //   478: aload           8
        //   480: invokevirtual   com/bumptech/glide/util/ByteArrayPool.releaseBytes:([B)Z
        //   483: pop            
        //   484: aload           7
        //   486: aload           9
        //   488: invokevirtual   com/bumptech/glide/util/ByteArrayPool.releaseBytes:([B)Z
        //   491: pop            
        //   492: aload           19
        //   494: invokevirtual   com/bumptech/glide/util/ExceptionCatchingInputStream.release:()V
        //   497: aload           10
        //   499: invokestatic    com/bumptech/glide/load/resource/bitmap/Downsampler.releaseOptions:(Landroid/graphics/BitmapFactory$Options;)V
        //   502: aload           20
        //   504: areturn        
        //   505: new             Ljava/lang/RuntimeException;
        //   508: astore          20
        //   510: aload           20
        //   512: aload           21
        //   514: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //   517: aload           20
        //   519: athrow         
        //   520: astore          11
        //   522: aload           13
        //   524: astore          19
        //   526: aload           11
        //   528: astore          20
        //   530: aload           19
        //   532: invokevirtual   com/bumptech/glide/util/ExceptionCatchingInputStream.reset:()V
        //   535: goto            588
        //   538: astore          11
        //   540: goto            597
        //   543: astore          11
        //   545: aload           11
        //   547: astore          23
        //   549: ldc             "Downsampler"
        //   551: astore          23
        //   553: aload           23
        //   555: iload           18
        //   557: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   560: istore          18
        //   562: iload           18
        //   564: ifeq            588
        //   567: ldc             "Downsampler"
        //   569: astore          21
        //   571: ldc             "Cannot reset the input stream"
        //   573: astore          23
        //   575: aload           21
        //   577: aload           23
        //   579: aload           11
        //   581: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   584: pop            
        //   585: goto            588
        //   588: aload           20
        //   590: athrow         
        //   591: astore          11
        //   593: aload           13
        //   595: astore          19
        //   597: aload           7
        //   599: aload           8
        //   601: invokevirtual   com/bumptech/glide/util/ByteArrayPool.releaseBytes:([B)Z
        //   604: pop            
        //   605: aload           7
        //   607: aload           9
        //   609: invokevirtual   com/bumptech/glide/util/ByteArrayPool.releaseBytes:([B)Z
        //   612: pop            
        //   613: aload           19
        //   615: invokevirtual   com/bumptech/glide/util/ExceptionCatchingInputStream.release:()V
        //   618: aload           10
        //   620: invokestatic    com/bumptech/glide/load/resource/bitmap/Downsampler.releaseOptions:(Landroid/graphics/BitmapFactory$Options;)V
        //   623: aload           11
        //   625: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  73     78     591    597    Any
        //  87     90     192    290    Ljava/io/IOException;
        //  87     90     179    192    Any
        //  94     99     192    290    Ljava/io/IOException;
        //  94     99     179    192    Any
        //  99     104    192    290    Ljava/io/IOException;
        //  99     104    179    192    Any
        //  110    115    127    172    Ljava/io/IOException;
        //  110    115    118    127    Any
        //  139    144    118    127    Any
        //  163    169    118    127    Any
        //  200    205    520    530    Any
        //  225    231    179    192    Any
        //  234    239    242    290    Ljava/io/IOException;
        //  234    239    118    127    Any
        //  254    259    591    597    Any
        //  278    284    118    127    Any
        //  292    297    591    597    Any
        //  302    307    591    597    Any
        //  317    319    591    597    Any
        //  326    329    591    597    Any
        //  331    336    591    597    Any
        //  346    351    591    597    Any
        //  390    395    538    543    Any
        //  397    402    538    543    Any
        //  424    429    538    543    Any
        //  437    442    538    543    Any
        //  451    458    538    543    Any
        //  465    470    538    543    Any
        //  505    508    538    543    Any
        //  512    517    538    543    Any
        //  517    520    538    543    Any
        //  530    535    543    588    Ljava/io/IOException;
        //  530    535    538    543    Any
        //  555    560    538    543    Any
        //  579    585    538    543    Any
        //  588    591    538    543    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0234:
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
    
    public int[] getDimensions(final MarkEnforcingInputStream markEnforcingInputStream, final RecyclableBufferedInputStream recyclableBufferedInputStream, final BitmapFactory$Options bitmapFactory$Options) {
        final int inJustDecodeBounds = 1;
        bitmapFactory$Options.inJustDecodeBounds = (inJustDecodeBounds != 0);
        decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, bitmapFactory$Options);
        bitmapFactory$Options.inJustDecodeBounds = false;
        final int[] array = { bitmapFactory$Options.outWidth, 0 };
        array[inJustDecodeBounds] = bitmapFactory$Options.outHeight;
        return array;
    }
    
    protected abstract int getSampleSize(final int p0, final int p1, final int p2, final int p3);
}
