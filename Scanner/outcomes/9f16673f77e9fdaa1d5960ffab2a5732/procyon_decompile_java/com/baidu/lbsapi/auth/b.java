// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.lbsapi.auth;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Base64;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.security.cert.CertificateEncodingException;
import java.security.cert.Certificate;
import android.content.pm.Signature;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;
import android.content.Context;
import java.util.Locale;

class b
{
    static String a() {
        return Locale.getDefault().getLanguage();
    }
    
    protected static String a(final Context context) {
        final String packageName = context.getPackageName();
        final String a = a(context, packageName);
        final StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(";");
        sb.append(packageName);
        return sb.toString();
    }
    
    private static String a(final Context context, String s) {
        String a = "";
        int i = 0;
        try {
            final PackageInfo packageInfo = context.getPackageManager().getPackageInfo(s, 64);
            try {
                final Signature[] signatures = packageInfo.signatures;
                s = "X.509";
                final CertificateFactory instance = CertificateFactory.getInstance(s);
                try {
                    final Signature signature = signatures[0];
                    try {
                        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
                        final CertificateFactory certificateFactory = instance;
                        try {
                            final Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
                            try {
                                final X509Certificate x509Certificate = (X509Certificate)generateCertificate;
                                try {
                                    a = a(x509Certificate);
                                }
                                catch (CertificateException ex) {}
                                catch (PackageManager$NameNotFoundException ex2) {}
                            }
                            catch (CertificateException ex3) {}
                            catch (PackageManager$NameNotFoundException ex4) {}
                        }
                        catch (CertificateException ex5) {}
                        catch (PackageManager$NameNotFoundException ex6) {}
                    }
                    catch (CertificateException ex7) {}
                    catch (PackageManager$NameNotFoundException ex8) {}
                }
                catch (CertificateException ex9) {}
                catch (PackageManager$NameNotFoundException ex10) {}
            }
            catch (CertificateException ex11) {}
            catch (PackageManager$NameNotFoundException ex12) {}
        }
        catch (CertificateException ex13) {}
        catch (PackageManager$NameNotFoundException ex14) {}
        final StringBuffer sb = new StringBuffer();
        while (i < a.length()) {
            sb.append(a.charAt(i));
            if (i > 0) {
                final int n = i % 2;
                final int n2 = 1;
                if (n == n2 && i < a.length() - n2) {
                    s = ":";
                    sb.append(s);
                }
            }
            ++i;
        }
        return sb.toString();
    }
    
    static String a(final X509Certificate x509Certificate) {
        try {
            final byte[] encoded = x509Certificate.getEncoded();
            try {
                final byte[] a = a(encoded);
                try {
                    return b$a.a(a);
                }
                catch (CertificateEncodingException ex) {
                    return null;
                }
            }
            catch (CertificateEncodingException ex2) {}
        }
        catch (CertificateEncodingException ex3) {}
    }
    
    static byte[] a(final byte[] array) {
        final String s = "SHA1";
        try {
            return MessageDigest.getInstance(s).digest(array);
        }
        catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }
    
    protected static String[] b(final Context context) {
        final String packageName = context.getPackageName();
        final String[] b = b(context, packageName);
        String[] array;
        if (b != null && b.length > 0) {
            array = new String[b.length];
            for (int i = 0; i < array.length; ++i) {
                final StringBuilder sb = new StringBuilder();
                sb.append(b[i]);
                sb.append(";");
                sb.append(packageName);
                array[i] = sb.toString();
                if (a.a) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("mcode");
                    sb2.append(array[i]);
                    a.a(sb2.toString());
                }
            }
        }
        else {
            array = null;
        }
        return array;
    }
    
    private static String[] b(final Context p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_2       
        //     2: aload_0        
        //     3: invokevirtual   android/content/Context.getPackageManager:()Landroid/content/pm/PackageManager;
        //     6: astore_0       
        //     7: bipush          64
        //     9: istore_3       
        //    10: aload_0        
        //    11: aload_1        
        //    12: iload_3        
        //    13: invokevirtual   android/content/pm/PackageManager.getPackageInfo:(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
        //    16: astore_0       
        //    17: aload_0        
        //    18: getfield        android/content/pm/PackageInfo.signatures:[Landroid/content/pm/Signature;
        //    21: astore_0       
        //    22: aload_0        
        //    23: ifnull          138
        //    26: aload_0        
        //    27: arraylength    
        //    28: istore          4
        //    30: iload           4
        //    32: ifle            138
        //    35: aload_0        
        //    36: arraylength    
        //    37: istore          4
        //    39: iload           4
        //    41: anewarray       Ljava/lang/String;
        //    44: astore_1       
        //    45: iconst_0       
        //    46: istore_3       
        //    47: aconst_null    
        //    48: astore          5
        //    50: aload_0        
        //    51: arraylength    
        //    52: istore          6
        //    54: iload_3        
        //    55: iload           6
        //    57: if_icmpge       154
        //    60: ldc             "X.509"
        //    62: astore          7
        //    64: aload           7
        //    66: invokestatic    java/security/cert/CertificateFactory.getInstance:(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
        //    69: astore          7
        //    71: new             Ljava/io/ByteArrayInputStream;
        //    74: astore          8
        //    76: aload_0        
        //    77: iload_3        
        //    78: aaload         
        //    79: astore          9
        //    81: aload           9
        //    83: invokevirtual   android/content/pm/Signature.toByteArray:()[B
        //    86: astore          9
        //    88: aload           8
        //    90: aload           9
        //    92: invokespecial   java/io/ByteArrayInputStream.<init>:([B)V
        //    95: aload           7
        //    97: aload           8
        //    99: invokevirtual   java/security/cert/CertificateFactory.generateCertificate:(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
        //   102: astore          7
        //   104: aload           7
        //   106: checkcast       Ljava/security/cert/X509Certificate;
        //   109: astore          7
        //   111: aload           7
        //   113: invokestatic    com/baidu/lbsapi/auth/b.a:(Ljava/security/cert/X509Certificate;)Ljava/lang/String;
        //   116: astore          7
        //   118: aload_1        
        //   119: iload_3        
        //   120: aload           7
        //   122: aastore        
        //   123: iload_3        
        //   124: iconst_1       
        //   125: iadd           
        //   126: istore_3       
        //   127: goto            50
        //   130: astore_0       
        //   131: goto            154
        //   134: astore_0       
        //   135: goto            154
        //   138: iconst_0       
        //   139: istore          4
        //   141: aconst_null    
        //   142: astore_1       
        //   143: goto            154
        //   146: astore_0       
        //   147: goto            138
        //   150: astore_0       
        //   151: goto            138
        //   154: aload_1        
        //   155: ifnull          333
        //   158: aload_1        
        //   159: arraylength    
        //   160: istore          10
        //   162: iload           10
        //   164: ifle            333
        //   167: aload_1        
        //   168: arraylength    
        //   169: anewarray       Ljava/lang/String;
        //   172: astore_2       
        //   173: iconst_0       
        //   174: istore          10
        //   176: aconst_null    
        //   177: astore_0       
        //   178: aload_1        
        //   179: arraylength    
        //   180: istore_3       
        //   181: iload           10
        //   183: iload_3        
        //   184: if_icmpge       333
        //   187: new             Ljava/lang/StringBuffer;
        //   190: astore          5
        //   192: aload           5
        //   194: invokespecial   java/lang/StringBuffer.<init>:()V
        //   197: iconst_0       
        //   198: istore          6
        //   200: aconst_null    
        //   201: astore          7
        //   203: aload_1        
        //   204: iload           10
        //   206: aaload         
        //   207: astore          8
        //   209: aload           8
        //   211: invokevirtual   java/lang/String.length:()I
        //   214: istore          11
        //   216: iload           6
        //   218: iload           11
        //   220: if_icmpge       311
        //   223: aload_1        
        //   224: iload           10
        //   226: aaload         
        //   227: astore          8
        //   229: aload           8
        //   231: iload           6
        //   233: invokevirtual   java/lang/String.charAt:(I)C
        //   236: istore          11
        //   238: aload           5
        //   240: iload           11
        //   242: invokevirtual   java/lang/StringBuffer.append:(C)Ljava/lang/StringBuffer;
        //   245: pop            
        //   246: iload           6
        //   248: ifle            302
        //   251: iload           6
        //   253: iconst_2       
        //   254: irem           
        //   255: istore          11
        //   257: iconst_1       
        //   258: istore          12
        //   260: iload           11
        //   262: iload           12
        //   264: if_icmpne       302
        //   267: aload_1        
        //   268: iload           10
        //   270: aaload         
        //   271: astore          8
        //   273: aload           8
        //   275: invokevirtual   java/lang/String.length:()I
        //   278: iload           12
        //   280: isub           
        //   281: istore          11
        //   283: iload           6
        //   285: iload           11
        //   287: if_icmpge       302
        //   290: ldc             ":"
        //   292: astore          8
        //   294: aload           5
        //   296: aload           8
        //   298: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   301: pop            
        //   302: iload           6
        //   304: iconst_1       
        //   305: iadd           
        //   306: istore          6
        //   308: goto            203
        //   311: aload           5
        //   313: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //   316: astore          5
        //   318: aload_2        
        //   319: iload           10
        //   321: aload           5
        //   323: aastore        
        //   324: iload           10
        //   326: iconst_1       
        //   327: iadd           
        //   328: istore          10
        //   330: goto            178
        //   333: aload_2        
        //   334: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                     
        //  -----  -----  -----  -----  ---------------------------------------------------------
        //  2      6      150    154    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  2      6      146    150    Ljava/security/cert/CertificateException;
        //  12     16     150    154    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  12     16     146    150    Ljava/security/cert/CertificateException;
        //  17     21     150    154    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  17     21     146    150    Ljava/security/cert/CertificateException;
        //  26     28     150    154    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  26     28     146    150    Ljava/security/cert/CertificateException;
        //  35     37     150    154    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  35     37     146    150    Ljava/security/cert/CertificateException;
        //  39     44     150    154    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  39     44     146    150    Ljava/security/cert/CertificateException;
        //  50     52     134    138    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  50     52     130    134    Ljava/security/cert/CertificateException;
        //  64     69     134    138    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  64     69     130    134    Ljava/security/cert/CertificateException;
        //  71     74     134    138    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  71     74     130    134    Ljava/security/cert/CertificateException;
        //  77     79     134    138    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  77     79     130    134    Ljava/security/cert/CertificateException;
        //  81     86     134    138    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  81     86     130    134    Ljava/security/cert/CertificateException;
        //  90     95     134    138    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  90     95     130    134    Ljava/security/cert/CertificateException;
        //  97     102    134    138    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  97     102    130    134    Ljava/security/cert/CertificateException;
        //  104    109    134    138    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  104    109    130    134    Ljava/security/cert/CertificateException;
        //  111    116    134    138    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  111    116    130    134    Ljava/security/cert/CertificateException;
        //  120    123    134    138    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  120    123    130    134    Ljava/security/cert/CertificateException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.assembler.ir.StackMappingVisitor.push(StackMappingVisitor.java:290)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:833)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
    
    static String c(final Context context) {
        String s = context.getSharedPreferences("mac", 0).getString("macaddr", (String)null);
        if (s == null) {
            final String d = d(context);
            if (d != null) {
                s = Base64.encodeToString(d.getBytes(), 0);
                if (!TextUtils.isEmpty((CharSequence)s)) {
                    context.getSharedPreferences("mac", 0).edit().putString("macaddr", s).commit();
                }
            }
            else {
                s = "";
            }
        }
        if (a.a) {
            final StringBuilder sb = new StringBuilder();
            sb.append("getMacID mac_adress: ");
            sb.append(s);
            a.a(sb.toString());
        }
        return s;
    }
    
    private static boolean c(final Context context, String string) {
        final boolean b = context.checkCallingOrSelfPermission(string) != -1;
        if (a.a) {
            final StringBuilder sb = new StringBuilder();
            sb.append("hasPermission ");
            sb.append(b);
            sb.append(" | ");
            sb.append(string);
            string = sb.toString();
            a.a(string);
        }
        return b;
    }
    
    static String d(final Context context) {
        String macAddress = null;
        final String s = "android.permission.ACCESS_WIFI_STATE";
        try {
            Label_0123: {
                if (!c(context, s)) {
                    break Label_0123;
                }
                final Object systemService = context.getSystemService("wifi");
                try {
                    final WifiManager wifiManager = (WifiManager)systemService;
                    try {
                        final WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                        try {
                            macAddress = connectionInfo.getMacAddress();
                            try {
                                if (!TextUtils.isEmpty((CharSequence)macAddress)) {
                                    Base64.encode(macAddress.getBytes(), 0);
                                }
                                if (!a.a) {
                                    return macAddress;
                                }
                                final String s2 = "ssid=%s mac=%s";
                                final Object[] array = new Object[2];
                                try {
                                    array[0] = connectionInfo.getSSID();
                                    array[1] = connectionInfo.getMacAddress();
                                    final String s3 = s2;
                                    try {
                                        String format = String.format(s3, array);
                                        try {
                                            a.a(format);
                                            return macAddress;
                                            // iftrue(Label_0157:, !a.a)
                                            format = "You need the android.Manifest.permission.ACCESS_WIFI_STATE permission. Open AndroidManifest.xml and just before the final </manifest> tag add:android.permission.ACCESS_WIFI_STATE";
                                        }
                                        catch (Exception ex) {
                                            if (!a.a) {
                                                return macAddress;
                                            }
                                            a.a(ex.toString());
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
        }
        catch (Exception ex8) {}
        Label_0157: {
            return macAddress;
        }
    }
}
