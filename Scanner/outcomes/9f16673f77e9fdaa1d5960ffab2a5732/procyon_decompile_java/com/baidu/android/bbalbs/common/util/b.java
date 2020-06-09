// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.android.bbalbs.common.util;

import android.telephony.TelephonyManager;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import android.os.Process;
import android.os.SystemClock;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Random;
import android.provider.Settings$Secure;
import java.util.Iterator;
import android.os.Environment;
import java.util.UUID;
import android.os.Build$VERSION;
import android.util.Log;
import android.content.pm.Signature;
import java.security.Key;
import javax.crypto.Cipher;
import java.util.HashSet;
import android.provider.Settings$System;
import java.security.cert.Certificate;
import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.io.ByteArrayInputStream;
import org.json.JSONArray;
import android.content.pm.PackageInfo;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import java.util.Comparator;
import java.util.Collections;
import java.util.Arrays;
import com.baidu.android.bbalbs.common.a.d;
import org.json.JSONObject;
import android.text.TextUtils;
import android.content.ComponentName;
import android.content.pm.ResolveInfo;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import java.io.File;
import java.security.PublicKey;
import android.content.Context;

public final class b
{
    private static final String a;
    private static b$b e;
    private final Context b;
    private int c;
    private PublicKey d;
    
    static {
        final int n = 12;
        final byte[] array2;
        final byte[] array = array2 = new byte[n];
        array2[0] = 77;
        array2[1] = 122;
        array2[2] = 65;
        array2[3] = 121;
        array2[4] = 77;
        array2[5] = 84;
        array2[6] = 73;
        array2[7] = 120;
        array2[8] = 77;
        array2[9] = 68;
        array2[10] = 73;
        array2[11] = 61;
        final String s = new String(com.baidu.android.bbalbs.common.a.b.a(array));
        final byte[] array4;
        final byte[] array3 = array4 = new byte[n];
        array4[0] = 90;
        array4[1] = 71;
        array4[2] = 108;
        array4[3] = 106;
        array4[4] = 100;
        array4[5] = 87;
        array4[6] = 82;
        array4[7] = 112;
        array4[8] = 89;
        array4[9] = 87;
        array4[10] = 73;
        array4[11] = 61;
        final String s2 = new String(com.baidu.android.bbalbs.common.a.b.a(array3));
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(s2);
        a = sb.toString();
    }
    
    private b(Context applicationContext) {
        this.c = 0;
        applicationContext = applicationContext.getApplicationContext();
        this.b = applicationContext;
        this.a();
    }
    
    public static String a(final Context context) {
        return c(context).b();
    }
    
    private static String a(final File p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_1       
        //     2: new             Ljava/io/FileReader;
        //     5: astore_2       
        //     6: aload_2        
        //     7: aload_0        
        //     8: invokespecial   java/io/FileReader.<init>:(Ljava/io/File;)V
        //    11: sipush          8192
        //    14: istore_3       
        //    15: iload_3        
        //    16: newarray        C
        //    18: astore_0       
        //    19: new             Ljava/io/CharArrayWriter;
        //    22: astore          4
        //    24: aload           4
        //    26: invokespecial   java/io/CharArrayWriter.<init>:()V
        //    29: aload_2        
        //    30: aload_0        
        //    31: invokevirtual   java/io/FileReader.read:([C)I
        //    34: istore          5
        //    36: iload           5
        //    38: ifle            53
        //    41: aload           4
        //    43: aload_0        
        //    44: iconst_0       
        //    45: iload           5
        //    47: invokevirtual   java/io/CharArrayWriter.write:([CII)V
        //    50: goto            29
        //    53: aload           4
        //    55: invokevirtual   java/io/CharArrayWriter.toString:()Ljava/lang/String;
        //    58: astore_0       
        //    59: aload_2        
        //    60: invokevirtual   java/io/FileReader.close:()V
        //    63: goto            71
        //    66: astore_1       
        //    67: aload_1        
        //    68: invokestatic    com/baidu/android/bbalbs/common/util/b.b:(Ljava/lang/Throwable;)V
        //    71: aload_0        
        //    72: areturn        
        //    73: astore_0       
        //    74: goto            86
        //    77: astore_0       
        //    78: aconst_null    
        //    79: astore_2       
        //    80: goto            109
        //    83: astore_0       
        //    84: aconst_null    
        //    85: astore_2       
        //    86: aload_0        
        //    87: invokestatic    com/baidu/android/bbalbs/common/util/b.b:(Ljava/lang/Throwable;)V
        //    90: aload_2        
        //    91: ifnull          106
        //    94: aload_2        
        //    95: invokevirtual   java/io/FileReader.close:()V
        //    98: goto            106
        //   101: astore_0       
        //   102: aload_0        
        //   103: invokestatic    com/baidu/android/bbalbs/common/util/b.b:(Ljava/lang/Throwable;)V
        //   106: aconst_null    
        //   107: areturn        
        //   108: astore_0       
        //   109: aload_2        
        //   110: ifnull          125
        //   113: aload_2        
        //   114: invokevirtual   java/io/FileReader.close:()V
        //   117: goto            125
        //   120: astore_1       
        //   121: aload_1        
        //   122: invokestatic    com/baidu/android/bbalbs/common/util/b.b:(Ljava/lang/Throwable;)V
        //   125: aload_0        
        //   126: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  2      5      83     86     Ljava/lang/Exception;
        //  2      5      77     83     Any
        //  7      11     83     86     Ljava/lang/Exception;
        //  7      11     77     83     Any
        //  15     18     73     77     Ljava/lang/Exception;
        //  15     18     108    109    Any
        //  19     22     73     77     Ljava/lang/Exception;
        //  19     22     108    109    Any
        //  24     29     73     77     Ljava/lang/Exception;
        //  24     29     108    109    Any
        //  30     34     73     77     Ljava/lang/Exception;
        //  30     34     108    109    Any
        //  45     50     73     77     Ljava/lang/Exception;
        //  45     50     108    109    Any
        //  53     58     73     77     Ljava/lang/Exception;
        //  53     58     108    109    Any
        //  59     63     66     71     Ljava/lang/Exception;
        //  86     90     108    109    Any
        //  94     98     101    106    Ljava/lang/Exception;
        //  113    117    120    125    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0053:
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
    
    private static String a(final byte[] array) {
        if (array != null) {
            String string = "";
            for (int i = 0; i < array.length; ++i) {
                final String hexString = Integer.toHexString(array[i] & 0xFF);
                StringBuilder sb;
                if (hexString.length() == 1) {
                    sb = new StringBuilder();
                    sb.append(string);
                    string = "0";
                }
                else {
                    sb = new StringBuilder();
                }
                sb.append(string);
                sb.append(hexString);
                string = sb.toString();
            }
            return string.toLowerCase();
        }
        throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }
    
    private List a(Intent iterator, final boolean b) {
        final ArrayList<Object> list = new ArrayList<Object>();
        final PackageManager packageManager = this.b.getPackageManager();
        final List queryBroadcastReceivers = packageManager.queryBroadcastReceivers(iterator, 0);
        if (queryBroadcastReceivers != null) {
            iterator = (Intent)queryBroadcastReceivers.iterator();
            while (((Iterator)iterator).hasNext()) {
                final ResolveInfo resolveInfo = ((Iterator<ResolveInfo>)iterator).next();
                if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.applicationInfo != null) {
                    try {
                        try {
                            final ActivityInfo activityInfo = resolveInfo.activityInfo;
                            try {
                                final String packageName = activityInfo.packageName;
                                try {
                                    final ActivityInfo activityInfo2 = resolveInfo.activityInfo;
                                    try {
                                        final ActivityInfo receiverInfo = packageManager.getReceiverInfo(new ComponentName(packageName, activityInfo2.name), 128);
                                        try {
                                            final Bundle metaData = receiverInfo.metaData;
                                            if (metaData == null) {
                                                continue;
                                            }
                                            final String string = metaData.getString("galaxy_data");
                                            try {
                                                if (TextUtils.isEmpty((CharSequence)string)) {
                                                    continue;
                                                }
                                                final byte[] bytes = string.getBytes("utf-8");
                                                try {
                                                    final byte[] a = b.a(bytes);
                                                    try {
                                                        final JSONObject jsonObject = new JSONObject(new String(a));
                                                        final b$a b$a = new b$a(null);
                                                        b$a.b = jsonObject.getInt("priority");
                                                        final ActivityInfo activityInfo3 = resolveInfo.activityInfo;
                                                        try {
                                                            b$a.a = activityInfo3.applicationInfo;
                                                            final Context b2 = this.b;
                                                            try {
                                                                final String packageName2 = b2.getPackageName();
                                                                try {
                                                                    final ActivityInfo activityInfo4 = resolveInfo.activityInfo;
                                                                    try {
                                                                        final ApplicationInfo applicationInfo = activityInfo4.applicationInfo;
                                                                        try {
                                                                            final boolean equals = packageName2.equals(applicationInfo.packageName);
                                                                            final boolean b3 = true;
                                                                            if (equals) {
                                                                                b$a.d = b3;
                                                                            }
                                                                            Label_0589: {
                                                                                if (!b) {
                                                                                    break Label_0589;
                                                                                }
                                                                                final String string2 = metaData.getString("galaxy_sf");
                                                                                try {
                                                                                    if (TextUtils.isEmpty((CharSequence)string2)) {
                                                                                        break Label_0589;
                                                                                    }
                                                                                    final ActivityInfo activityInfo5 = resolveInfo.activityInfo;
                                                                                    try {
                                                                                        final ApplicationInfo applicationInfo2 = activityInfo5.applicationInfo;
                                                                                        try {
                                                                                            final PackageInfo packageInfo = packageManager.getPackageInfo(applicationInfo2.packageName, 64);
                                                                                            final JSONArray jsonArray = jsonObject.getJSONArray("sigs");
                                                                                            try {
                                                                                                final int length = jsonArray.length();
                                                                                                try {
                                                                                                    final String[] array = new String[length];
                                                                                                    for (int i = 0; i < array.length; ++i) {
                                                                                                        array[i] = jsonArray.getString(i);
                                                                                                    }
                                                                                                    if (!this.a(array, this.a(packageInfo.signatures))) {
                                                                                                        break Label_0589;
                                                                                                    }
                                                                                                    final byte[] bytes2 = string2.getBytes();
                                                                                                    try {
                                                                                                        final byte[] a2 = b.a(bytes2);
                                                                                                        try {
                                                                                                            final byte[] a3 = a(a2, this.d);
                                                                                                            try {
                                                                                                                final byte[] a4 = com.baidu.android.bbalbs.common.a.d.a(a);
                                                                                                                if (a3 != null && Arrays.equals(a3, a4)) {
                                                                                                                    b$a.c = b3;
                                                                                                                }
                                                                                                                final List<b$a> list2 = (List<b$a>)list;
                                                                                                                try {
                                                                                                                    list2.add(b$a);
                                                                                                                    continue;
                                                                                                                }
                                                                                                                catch (Exception ex) {
                                                                                                                    continue;
                                                                                                                }
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
                                                                        }
                                                                        catch (Exception ex10) {}
                                                                    }
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
                    break;
                }
            }
        }
        Collections.sort(list, new c(this));
        return list;
    }
    
    private void a() {
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            byteArrayInputStream = new(java.io.ByteArrayInputStream.class);
            try {
                new ByteArrayInputStream(com.baidu.android.bbalbs.common.util.a.a());
                final String s = "X.509";
                try {
                    final Certificate generateCertificate = CertificateFactory.getInstance(s).generateCertificate(byteArrayInputStream);
                    try {
                        this.d = generateCertificate.getPublicKey();
                        final ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
                        byteArrayInputStream2.close();
                    }
                    catch (Exception ex3) {}
                }
                catch (Exception ex4) {}
            }
            catch (Exception ex5) {
                byteArrayInputStream = null;
            }
        }
        catch (Exception ex6) {}
        try {
            final ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
            byteArrayInputStream2.close();
            return;
            // iftrue(Label_0099:, byteArrayInputStream == null)
            // iftrue(Label_0078:, byteArrayInputStream == null)
            final Throwable t;
            Block_18: {
                Block_20: {
                    break Block_20;
                    break Block_18;
                    Label_0078: {
                        throw t;
                    }
                }
                byteArrayInputStream.close();
                return;
            }
            try {
                byteArrayInputStream.close();
            }
            catch (Exception ex) {
                b(ex);
            }
            throw t;
        }
        catch (Exception ex2) {
            b(ex2);
        }
        Label_0099:;
    }
    
    private boolean a(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: getstatic       android/os/Build$VERSION.SDK_INT:I
        //     3: istore_2       
        //     4: aconst_null    
        //     5: astore_3       
        //     6: iconst_1       
        //     7: istore          4
        //     9: bipush          24
        //    11: istore          5
        //    13: iload_2        
        //    14: iload           5
        //    16: if_icmplt       27
        //    19: iconst_0       
        //    20: istore_2       
        //    21: aconst_null    
        //    22: astore          6
        //    24: goto            29
        //    27: iconst_1       
        //    28: istore_2       
        //    29: iconst_0       
        //    30: istore          5
        //    32: aconst_null    
        //    33: astore          7
        //    35: aload_0        
        //    36: getfield        com/baidu/android/bbalbs/common/util/b.b:Landroid/content/Context;
        //    39: astore          8
        //    41: ldc_w           "libcuid.so"
        //    44: astore          9
        //    46: aload           8
        //    48: aload           9
        //    50: iload_2        
        //    51: invokevirtual   android/content/Context.openFileOutput:(Ljava/lang/String;I)Ljava/io/FileOutputStream;
        //    54: astore          7
        //    56: aload_1        
        //    57: invokevirtual   java/lang/String.getBytes:()[B
        //    60: astore_1       
        //    61: aload           7
        //    63: aload_1        
        //    64: invokevirtual   java/io/FileOutputStream.write:([B)V
        //    67: aload           7
        //    69: invokevirtual   java/io/FileOutputStream.flush:()V
        //    72: aload           7
        //    74: ifnull          90
        //    77: aload           7
        //    79: invokevirtual   java/io/FileOutputStream.close:()V
        //    82: goto            90
        //    85: astore_1       
        //    86: aload_1        
        //    87: invokestatic    com/baidu/android/bbalbs/common/util/b.b:(Ljava/lang/Throwable;)V
        //    90: iload_2        
        //    91: ifne            128
        //    94: new             Ljava/io/File;
        //    97: astore          6
        //    99: aload_0        
        //   100: getfield        com/baidu/android/bbalbs/common/util/b.b:Landroid/content/Context;
        //   103: invokevirtual   android/content/Context.getFilesDir:()Ljava/io/File;
        //   106: astore_3       
        //   107: aload           6
        //   109: aload_3        
        //   110: ldc_w           "libcuid.so"
        //   113: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   116: aload           6
        //   118: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //   121: sipush          436
        //   124: invokestatic    com/baidu/android/bbalbs/common/util/b$c.a:(Ljava/lang/String;I)Z
        //   127: ireturn        
        //   128: iload           4
        //   130: ireturn        
        //   131: astore_1       
        //   132: goto            160
        //   135: astore_1       
        //   136: aload_1        
        //   137: invokestatic    com/baidu/android/bbalbs/common/util/b.b:(Ljava/lang/Throwable;)V
        //   140: aload           7
        //   142: ifnull          158
        //   145: aload           7
        //   147: invokevirtual   java/io/FileOutputStream.close:()V
        //   150: goto            158
        //   153: astore_1       
        //   154: aload_1        
        //   155: invokestatic    com/baidu/android/bbalbs/common/util/b.b:(Ljava/lang/Throwable;)V
        //   158: iconst_0       
        //   159: ireturn        
        //   160: aload           7
        //   162: ifnull          180
        //   165: aload           7
        //   167: invokevirtual   java/io/FileOutputStream.close:()V
        //   170: goto            180
        //   173: astore          6
        //   175: aload           6
        //   177: invokestatic    com/baidu/android/bbalbs/common/util/b.b:(Ljava/lang/Throwable;)V
        //   180: aload_1        
        //   181: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  35     39     135    160    Ljava/lang/Exception;
        //  35     39     131    182    Any
        //  50     54     135    160    Ljava/lang/Exception;
        //  50     54     131    182    Any
        //  56     60     135    160    Ljava/lang/Exception;
        //  56     60     131    182    Any
        //  63     67     135    160    Ljava/lang/Exception;
        //  63     67     131    182    Any
        //  67     72     135    160    Ljava/lang/Exception;
        //  67     72     131    182    Any
        //  77     82     85     90     Ljava/lang/Exception;
        //  136    140    131    182    Any
        //  145    150    153    158    Ljava/lang/Exception;
        //  165    170    173    180    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0090:
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
    
    private boolean a(final String s, final String s2) {
        try {
            final Context b = this.b;
            try {
                return Settings$System.putString(b.getContentResolver(), s, s2);
            }
            catch (Exception ex) {
                b(ex);
                return false;
            }
        }
        catch (Exception ex2) {}
    }
    
    private boolean a(final String[] array, final String[] array2) {
        int i = 0;
        if (array != null && array2 != null && array.length == array2.length) {
            final HashSet<String> set = new HashSet<String>();
            for (int length = array.length, j = 0; j < length; ++j) {
                set.add(array[j]);
            }
            final HashSet<String> set2 = new HashSet<String>();
            while (i < array2.length) {
                set2.add(array2[i]);
                ++i;
            }
            return set.equals(set2);
        }
        return false;
    }
    
    private static byte[] a(final byte[] array, final PublicKey publicKey) {
        final Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, publicKey);
        return instance.doFinal(array);
    }
    
    private String[] a(final Signature[] array) {
        final String[] array2 = new String[array.length];
        for (int i = 0; i < array2.length; ++i) {
            array2[i] = a(com.baidu.android.bbalbs.common.a.d.a(array[i].toByteArray()));
        }
        return array2;
    }
    
    private b$b b() {
        final Intent setPackage = new Intent("com.baidu.intent.action.GALAXY").setPackage(this.b.getPackageName());
        final boolean b = true;
        final List a = this.a(setPackage, b);
        final int n = 3;
        boolean b2 = false;
        boolean c;
        if (a != null && a.size() != 0) {
            final b$a b$a = a.get(0);
            c = b$a.c;
            if (!b$a.c) {
                for (int i = 0; i < n; ++i) {
                    Log.w("DeviceId", "galaxy config err, In the release version of the signature should be matched");
                }
            }
        }
        else {
            for (int j = 0; j < n; ++j) {
                Log.w("DeviceId", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            c = false;
        }
        final File file = new File(this.b.getFilesDir(), "libcuid.so");
        final boolean exists = file.exists();
        String s = null;
        b$b b$b;
        if (exists) {
            b$b = com.baidu.android.bbalbs.common.util.b$b.a(f(a(file)));
        }
        else {
            b$b = null;
        }
        if (b$b == null) {
            this.c |= 0x10;
            final List a2 = this.a(new Intent("com.baidu.intent.action.GALAXY"), c);
            if (a2 != null) {
                String name = "files";
                final File filesDir = this.b.getFilesDir();
                if (!name.equals(filesDir.getName())) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("fetal error:: app files dir name is unexpectedly :: ");
                    sb.append(filesDir.getAbsolutePath());
                    Log.e("DeviceId", sb.toString());
                    name = filesDir.getName();
                }
                for (final b$a b$a2 : a2) {
                    if (b$a2.d) {
                        continue;
                    }
                    final File file2 = new File(new File(b$a2.a.dataDir, name), "libcuid.so");
                    if (!file2.exists()) {
                        continue;
                    }
                    b$b = com.baidu.android.bbalbs.common.util.b$b.a(f(a(file2)));
                    if (b$b != null) {
                        break;
                    }
                }
            }
        }
        if (b$b == null) {
            b$b = com.baidu.android.bbalbs.common.util.b$b.a(f(this.b("com.baidu.deviceid.v2")));
        }
        final boolean c2 = this.c("android.permission.READ_EXTERNAL_STORAGE");
        if (b$b == null && c2) {
            this.c |= 0x2;
            b$b = this.e();
        }
        if (b$b == null) {
            this.c |= 0x8;
            b$b = this.d();
        }
        String h2;
        if (b$b == null && c2) {
            this.c |= (b ? 1 : 0);
            final String h = this.h("");
            final b$b d = this.d(h);
            b2 = true;
            final b$b b$b2 = d;
            h2 = h;
            b$b = b$b2;
        }
        else {
            h2 = null;
        }
        if (b$b == null) {
            this.c |= 0x4;
            if (!b2) {
                h2 = this.h("");
            }
            b$b = new b$b(null);
            final String b3 = b(this.b);
            String s2;
            if (Build$VERSION.SDK_INT < 23) {
                final String string = UUID.randomUUID().toString();
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(h2);
                sb2.append(b3);
                sb2.append(string);
                s2 = sb2.toString();
            }
            else {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("com.baidu");
                sb3.append(b3);
                s2 = sb3.toString();
            }
            b$b.a = com.baidu.android.bbalbs.common.a.c.a(s2.getBytes(), b);
            b$b.b = h2;
        }
        final File file3 = new File(this.b.getFilesDir(), "libcuid.so");
        if ((this.c & 0x10) != 0x0 || !file3.exists()) {
            if (TextUtils.isEmpty((CharSequence)null)) {
                s = e(b$b.a());
            }
            this.a(s);
        }
        final boolean c3 = this.c();
        if (c3 && ((this.c & 0x2) != 0x0 || TextUtils.isEmpty((CharSequence)this.b("com.baidu.deviceid.v2")))) {
            if (TextUtils.isEmpty((CharSequence)s)) {
                s = e(b$b.a());
            }
            this.a("com.baidu.deviceid.v2", s);
        }
        if (this.c("android.permission.WRITE_EXTERNAL_STORAGE")) {
            final File file4 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if ((this.c & 0x8) != 0x0 || !file4.exists()) {
                if (TextUtils.isEmpty((CharSequence)s)) {
                    s = e(b$b.a());
                }
                g(s);
            }
        }
        if (c3 && (((b ? 1 : 0) & this.c) || TextUtils.isEmpty((CharSequence)this.b("com.baidu.deviceid")))) {
            this.a("com.baidu.deviceid", b$b.a);
        }
        if (c3 && !TextUtils.isEmpty((CharSequence)b$b.b)) {
            final File file5 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            if ((this.c & 0x2) != 0x0 || !file5.exists()) {
                b(b$b.b, b$b.a);
            }
        }
        return b$b;
    }
    
    public static String b(final Context context) {
        String string = Settings$Secure.getString(context.getContentResolver(), "android_id");
        if (TextUtils.isEmpty((CharSequence)string)) {
            string = "";
        }
        return string;
    }
    
    private String b(final String s) {
        try {
            final Context b = this.b;
            try {
                return Settings$System.getString(b.getContentResolver(), s);
            }
            catch (Exception ex) {
                b(ex);
                return null;
            }
        }
        catch (Exception ex2) {}
    }
    
    private static void b(final String s, String s2) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("=");
        sb.append(s2);
        final File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        final File file2 = new File(file, ".cuid");
        try {
            Label_0206: {
                if (!file.exists() || file.isDirectory()) {
                    break Label_0206;
                }
                try {
                    final Random random = new Random();
                    final File parentFile = file.getParentFile();
                    try {
                        final String name = file.getName();
                        try {
                            while (true) {
                                try {
                                    try {
                                        final StringBuilder sb3;
                                        final StringBuilder sb2 = sb3 = new StringBuilder();
                                        try {
                                            sb3.append(name);
                                            sb2.append(random.nextInt());
                                            sb2.append(".tmp");
                                            final File file3 = new File(parentFile, sb2.toString());
                                            if (file3.exists()) {
                                                continue;
                                            }
                                            file.renameTo(file3);
                                            file3.delete();
                                            file.mkdirs();
                                            final FileWriter fileWriter = new FileWriter(file2, false);
                                            s2 = b.a;
                                            try {
                                                final String a = b.a;
                                                try {
                                                    final String string = sb.toString();
                                                    try {
                                                        s2 = com.baidu.android.bbalbs.common.a.b.a(com.baidu.android.bbalbs.common.a.a.a(s2, a, string.getBytes()), "utf-8");
                                                        fileWriter.write(s2);
                                                        fileWriter.flush();
                                                        fileWriter.close();
                                                    }
                                                    catch (Exception ex) {}
                                                    catch (IOException ex2) {}
                                                }
                                                catch (Exception ex3) {}
                                                catch (IOException ex4) {}
                                            }
                                            catch (Exception ex5) {}
                                            catch (IOException ex6) {}
                                        }
                                        catch (Exception ex7) {}
                                        catch (IOException ex8) {}
                                    }
                                    catch (Exception ex9) {}
                                    catch (IOException ex10) {}
                                }
                                catch (Exception ex11) {}
                                catch (IOException ex12) {}
                            }
                        }
                        catch (Exception ex13) {}
                        catch (IOException ex14) {}
                    }
                    catch (Exception ex15) {}
                    catch (IOException ex16) {}
                }
                catch (Exception ex17) {}
                catch (IOException ex18) {}
            }
        }
        catch (Exception ex19) {}
        catch (IOException ex20) {}
    }
    
    private static void b(final Throwable t) {
    }
    
    private static b$b c(final Context context) {
        if (b.e == null) {
            synchronized (b$b.class) {
                if (b.e == null) {
                    SystemClock.uptimeMillis();
                    b.e = new b(context).b();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return b.e;
    }
    
    private boolean c() {
        return this.c("android.permission.WRITE_SETTINGS");
    }
    
    private boolean c(final String s) {
        return this.b.checkPermission(s, Process.myPid(), Process.myUid()) == 0;
    }
    
    private b$b d() {
        String a = this.b("com.baidu.deviceid");
        String b = this.b("bd_setting_i");
        if (TextUtils.isEmpty((CharSequence)b)) {
            b = this.h("");
            TextUtils.isEmpty((CharSequence)b);
        }
        if (TextUtils.isEmpty((CharSequence)a)) {
            final String b2 = b(this.b);
            final StringBuilder sb = new StringBuilder();
            sb.append("com.baidu");
            sb.append(b);
            sb.append(b2);
            a = this.b(com.baidu.android.bbalbs.common.a.c.a(sb.toString().getBytes(), true));
        }
        if (!TextUtils.isEmpty((CharSequence)a)) {
            final b$b b$b = new b$b(null);
            b$b.a = a;
            b$b.b = b;
            return b$b;
        }
        return null;
    }
    
    private b$b d(String b) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        final int n = 1;
        final boolean b2 = sdk_INT < 23;
        if (b2 && TextUtils.isEmpty((CharSequence)b)) {
            return null;
        }
        String a = "";
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        boolean b3;
        if (file.exists()) {
            b3 = false;
        }
        else {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            b3 = true;
        }
        try {
            final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                final StringBuilder sb = new StringBuilder();
                while (true) {
                    final String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append("\r\n");
                }
                bufferedReader.close();
                try {
                    final String a2 = b.a;
                    try {
                        final String a3 = b.a;
                        try {
                            final String string = sb.toString();
                            try {
                                final byte[] bytes = string.getBytes();
                                try {
                                    final String[] split = new String(com.baidu.android.bbalbs.common.a.a.b(a2, a3, b.a(bytes))).split("=");
                                    Label_0352: {
                                        if (split != null && split.length == 2) {
                                            String s;
                                            if (b2 && b.equals(split[0])) {
                                                s = split[n];
                                            }
                                            else {
                                                if (b2) {
                                                    break Label_0352;
                                                }
                                                if (TextUtils.isEmpty((CharSequence)b)) {
                                                    b = split[n];
                                                }
                                                s = split[n];
                                            }
                                            a = s;
                                        }
                                    }
                                    if (!b3) {
                                        b(b, a);
                                    }
                                }
                                catch (Exception ex) {}
                                catch (IOException ex2) {}
                                catch (FileNotFoundException ex3) {}
                            }
                            catch (Exception ex4) {}
                            catch (IOException ex5) {}
                            catch (FileNotFoundException ex6) {}
                        }
                        catch (Exception ex7) {}
                        catch (IOException ex8) {}
                        catch (FileNotFoundException ex9) {}
                    }
                    catch (Exception ex10) {}
                    catch (IOException ex11) {}
                    catch (FileNotFoundException ex12) {}
                }
                catch (Exception ex13) {}
                catch (IOException ex14) {}
                catch (FileNotFoundException ex15) {}
            }
            catch (Exception ex16) {}
            catch (IOException ex17) {}
            catch (FileNotFoundException ex18) {}
        }
        catch (Exception ex19) {}
        catch (IOException ex20) {}
        catch (FileNotFoundException ex21) {}
        if (!TextUtils.isEmpty((CharSequence)a)) {
            final b$b b$b = new b$b(null);
            b$b.a = a;
            b$b.b = b;
            return b$b;
        }
        return null;
    }
    
    private b$b e() {
        final File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            final String a = a(file);
            if (!TextUtils.isEmpty((CharSequence)a)) {
                try {
                    try {
                        final String a2 = com.baidu.android.bbalbs.common.util.b.a;
                        try {
                            final String a3 = com.baidu.android.bbalbs.common.util.b.a;
                            try {
                                final byte[] bytes = a.getBytes();
                                try {
                                    return b$b.a(new String(com.baidu.android.bbalbs.common.a.a.b(a2, a3, com.baidu.android.bbalbs.common.a.b.a(bytes))));
                                }
                                catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                            catch (Exception ex2) {}
                        }
                        catch (Exception ex3) {}
                    }
                    catch (Exception ex4) {}
                }
                catch (Exception ex5) {}
            }
        }
        return null;
    }
    
    private static String e(String ex) {
        if (TextUtils.isEmpty((CharSequence)ex)) {
            return null;
        }
        try {
            final String a = b.a;
            try {
                final String a2 = b.a;
                try {
                    ex = (Exception)(Object)((String)ex).getBytes();
                    ex = (Exception)(Object)com.baidu.android.bbalbs.common.a.a.a(a, a2, (byte[])(Object)ex);
                    return com.baidu.android.bbalbs.common.a.b.a((byte[])(Object)ex, "utf-8");
                }
                catch (Exception ex) {}
                catch (UnsupportedEncodingException ex2) {}
            }
            catch (Exception ex3) {}
            catch (UnsupportedEncodingException ex4) {}
        }
        catch (Exception ex5) {}
        catch (UnsupportedEncodingException ex6) {}
        b(ex);
        return "";
    }
    
    private static String f(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return null;
        }
        try {
            try {
                final String a = b.a;
                try {
                    final String a2 = b.a;
                    try {
                        final byte[] bytes = s.getBytes();
                        try {
                            return new String(com.baidu.android.bbalbs.common.a.a.b(a, a2, com.baidu.android.bbalbs.common.a.b.a(bytes)));
                        }
                        catch (Exception ex) {
                            b(ex);
                            return "";
                        }
                    }
                    catch (Exception ex2) {}
                }
                catch (Exception ex3) {}
            }
            catch (Exception ex4) {}
        }
        catch (Exception ex5) {}
    }
    
    private static void g(final String s) {
        final File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        final File file2 = new File(file, ".cuid2");
        try {
            Label_0163: {
                if (!file.exists() || file.isDirectory()) {
                    break Label_0163;
                }
                try {
                    final Random random = new Random();
                    final File parentFile = file.getParentFile();
                    try {
                        final String name = file.getName();
                        try {
                            while (true) {
                                try {
                                    try {
                                        final StringBuilder sb2;
                                        final StringBuilder sb = sb2 = new StringBuilder();
                                        try {
                                            sb2.append(name);
                                            sb.append(random.nextInt());
                                            sb.append(".tmp");
                                            final File file3 = new File(parentFile, sb.toString());
                                            if (file3.exists()) {
                                                continue;
                                            }
                                            file.renameTo(file3);
                                            file3.delete();
                                            file.mkdirs();
                                            final FileWriter fileWriter2;
                                            final FileWriter fileWriter = fileWriter2 = new FileWriter(file2, 0 != 0);
                                            try {
                                                fileWriter2.write(s);
                                                fileWriter.flush();
                                                fileWriter.close();
                                            }
                                            catch (Exception ex) {}
                                            catch (IOException ex2) {}
                                        }
                                        catch (Exception ex3) {}
                                        catch (IOException ex4) {}
                                    }
                                    catch (Exception ex5) {}
                                    catch (IOException ex6) {}
                                }
                                catch (Exception ex7) {}
                                catch (IOException ex8) {}
                            }
                        }
                        catch (Exception ex9) {}
                        catch (IOException ex10) {}
                    }
                    catch (Exception ex11) {}
                    catch (IOException ex12) {}
                }
                catch (Exception ex13) {}
                catch (IOException ex14) {}
            }
        }
        catch (Exception ex15) {}
        catch (IOException ex16) {}
    }
    
    private String h(String s) {
        String deviceId = null;
        try {
            final Object systemService = this.b.getSystemService("phone");
            try {
                final TelephonyManager telephonyManager = (TelephonyManager)systemService;
                if (telephonyManager != null) {
                    deviceId = telephonyManager.getDeviceId();
                }
            }
            catch (Exception ex) {
                Log.e("DeviceId", "Read IMEI failed", (Throwable)ex);
            }
        }
        catch (Exception ex2) {}
        final String i = i(deviceId);
        if (!TextUtils.isEmpty((CharSequence)i)) {
            s = i;
        }
        return s;
    }
    
    private static String i(String s) {
        if (s != null && s.contains(":")) {
            s = "";
        }
        return s;
    }
}
