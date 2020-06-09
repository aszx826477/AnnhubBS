// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.b;

import android.telephony.PhoneStateListener;
import com.baidu.location.f;
import java.util.Locale;
import android.telephony.NeighboringCellInfo;
import java.util.LinkedList;
import java.io.RandomAccessFile;
import java.io.File;
import com.baidu.location.d.j;
import java.util.Iterator;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.os.SystemClock;
import android.telephony.CellInfoWcdma;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.os.Build$VERSION;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.os.Handler;
import java.util.List;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

public class b
{
    public static int a;
    public static int b;
    private static b c;
    private static Method k;
    private static Method l;
    private static Method m;
    private static Method n;
    private static Method o;
    private static Class p;
    private TelephonyManager d;
    private Object e;
    private a f;
    private a g;
    private List h;
    private b$a i;
    private boolean j;
    private boolean q;
    private Handler r;
    
    static {
        com.baidu.location.b.b.c = null;
        com.baidu.location.b.b.k = null;
        com.baidu.location.b.b.l = null;
        com.baidu.location.b.b.m = null;
        com.baidu.location.b.b.n = null;
        com.baidu.location.b.b.o = null;
        com.baidu.location.b.b.p = null;
        com.baidu.location.b.b.a = 0;
        com.baidu.location.b.b.b = 0;
    }
    
    private b() {
        this.d = null;
        this.e = null;
        this.f = new a();
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = false;
        this.q = false;
        this.r = new Handler();
    }
    
    private int a(int n) {
        if (n == -1 >>> 1) {
            n = -1;
        }
        return n;
    }
    
    private CellLocation a(final List p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_1        
        //     1: astore_2       
        //     2: aload_1        
        //     3: ifnull          701
        //     6: aload_1        
        //     7: invokeinterface java/util/List.isEmpty:()Z
        //    12: istore_3       
        //    13: iload_3        
        //    14: ifeq            20
        //    17: goto            701
        //    20: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //    23: astore          4
        //    25: iconst_0       
        //    26: istore          5
        //    28: aconst_null    
        //    29: astore          6
        //    31: aconst_null    
        //    32: astore          7
        //    34: iconst_0       
        //    35: istore          8
        //    37: aload_1        
        //    38: invokeinterface java/util/List.size:()I
        //    43: istore_3       
        //    44: iconst_4       
        //    45: istore          9
        //    47: iload           5
        //    49: iload_3        
        //    50: if_icmpge       687
        //    53: aload_2        
        //    54: iload           5
        //    56: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //    61: astore          10
        //    63: aload           10
        //    65: ifnonnull       77
        //    68: iconst_0       
        //    69: istore          11
        //    71: aconst_null    
        //    72: astore          12
        //    74: goto            678
        //    77: ldc             "android.telephony.CellInfoGsm"
        //    79: astore          13
        //    81: aload           4
        //    83: aload           13
        //    85: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
        //    88: astore          13
        //    90: ldc             "android.telephony.CellInfoWcdma"
        //    92: astore          14
        //    94: aload           4
        //    96: aload           14
        //    98: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
        //   101: astore          14
        //   103: ldc             "android.telephony.CellInfoLte"
        //   105: astore          15
        //   107: aload           4
        //   109: aload           15
        //   111: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
        //   114: astore          15
        //   116: ldc             "android.telephony.CellInfoCdma"
        //   118: astore          16
        //   120: aload           4
        //   122: aload           16
        //   124: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
        //   127: astore          16
        //   129: aload           13
        //   131: aload           10
        //   133: invokevirtual   java/lang/Class.isInstance:(Ljava/lang/Object;)Z
        //   136: istore          17
        //   138: iconst_2       
        //   139: istore          18
        //   141: iconst_3       
        //   142: istore          19
        //   144: iconst_1       
        //   145: istore          11
        //   147: iload           17
        //   149: ifeq            158
        //   152: iconst_1       
        //   153: istore          8
        //   155: goto            221
        //   158: aload           14
        //   160: aload           10
        //   162: invokevirtual   java/lang/Class.isInstance:(Ljava/lang/Object;)Z
        //   165: istore          17
        //   167: iload           17
        //   169: ifeq            178
        //   172: iconst_2       
        //   173: istore          8
        //   175: goto            221
        //   178: aload           15
        //   180: aload           10
        //   182: invokevirtual   java/lang/Class.isInstance:(Ljava/lang/Object;)Z
        //   185: istore          17
        //   187: iload           17
        //   189: ifeq            198
        //   192: iconst_3       
        //   193: istore          8
        //   195: goto            221
        //   198: aload           16
        //   200: aload           10
        //   202: invokevirtual   java/lang/Class.isInstance:(Ljava/lang/Object;)Z
        //   205: istore          8
        //   207: iload           8
        //   209: ifeq            218
        //   212: iconst_4       
        //   213: istore          8
        //   215: goto            221
        //   218: iconst_0       
        //   219: istore          8
        //   221: iload           8
        //   223: ifle            68
        //   226: iload           8
        //   228: iload           11
        //   230: if_icmpne       245
        //   233: aload           13
        //   235: aload           10
        //   237: invokevirtual   java/lang/Class.cast:(Ljava/lang/Object;)Ljava/lang/Object;
        //   240: astore          10
        //   242: goto            307
        //   245: iload           8
        //   247: iload           18
        //   249: if_icmpne       264
        //   252: aload           14
        //   254: aload           10
        //   256: invokevirtual   java/lang/Class.cast:(Ljava/lang/Object;)Ljava/lang/Object;
        //   259: astore          10
        //   261: goto            307
        //   264: iload           8
        //   266: iload           19
        //   268: if_icmpne       283
        //   271: aload           15
        //   273: aload           10
        //   275: invokevirtual   java/lang/Class.cast:(Ljava/lang/Object;)Ljava/lang/Object;
        //   278: astore          10
        //   280: goto            307
        //   283: iload           8
        //   285: iload           9
        //   287: if_icmpne       302
        //   290: aload           16
        //   292: aload           10
        //   294: invokevirtual   java/lang/Class.cast:(Ljava/lang/Object;)Ljava/lang/Object;
        //   297: astore          10
        //   299: goto            307
        //   302: iconst_0       
        //   303: istore_3       
        //   304: aconst_null    
        //   305: astore          10
        //   307: ldc             "getCellIdentity"
        //   309: astore          12
        //   311: aconst_null    
        //   312: astore          13
        //   314: iconst_0       
        //   315: anewarray       Ljava/lang/Object;
        //   318: astore          14
        //   320: aload           10
        //   322: aload           12
        //   324: aload           14
        //   326: invokestatic    com/baidu/location/d/j.a:(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
        //   329: astore          10
        //   331: aload           10
        //   333: ifnonnull       339
        //   336: goto            68
        //   339: iload           8
        //   341: iload           9
        //   343: if_icmpne       499
        //   346: new             Landroid/telephony/cdma/CdmaCellLocation;
        //   349: astore          20
        //   351: aload           20
        //   353: invokespecial   android/telephony/cdma/CdmaCellLocation.<init>:()V
        //   356: ldc             "getSystemId"
        //   358: astore          12
        //   360: aconst_null    
        //   361: astore          7
        //   363: iconst_0       
        //   364: anewarray       Ljava/lang/Object;
        //   367: astore          13
        //   369: aload           10
        //   371: aload           12
        //   373: aload           13
        //   375: invokestatic    com/baidu/location/d/j.b:(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
        //   378: istore          17
        //   380: ldc             "getNetworkId"
        //   382: astore          12
        //   384: iconst_0       
        //   385: anewarray       Ljava/lang/Object;
        //   388: astore          13
        //   390: aload           10
        //   392: aload           12
        //   394: aload           13
        //   396: invokestatic    com/baidu/location/d/j.b:(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
        //   399: istore          18
        //   401: ldc             "getBasestationId"
        //   403: astore          12
        //   405: iconst_0       
        //   406: anewarray       Ljava/lang/Object;
        //   409: astore          13
        //   411: aload           10
        //   413: aload           12
        //   415: aload           13
        //   417: invokestatic    com/baidu/location/d/j.b:(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
        //   420: istore          21
        //   422: ldc             "getLongitude"
        //   424: astore          12
        //   426: iconst_0       
        //   427: anewarray       Ljava/lang/Object;
        //   430: astore          13
        //   432: aload           10
        //   434: aload           12
        //   436: aload           13
        //   438: invokestatic    com/baidu/location/d/j.b:(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
        //   441: istore          22
        //   443: ldc             "getLatitude"
        //   445: astore          12
        //   447: iconst_0       
        //   448: anewarray       Ljava/lang/Object;
        //   451: astore          13
        //   453: aload           10
        //   455: aload           12
        //   457: aload           13
        //   459: invokestatic    com/baidu/location/d/j.b:(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
        //   462: istore          23
        //   464: aload           20
        //   466: astore          13
        //   468: aload           20
        //   470: iload           21
        //   472: iload           23
        //   474: iload           22
        //   476: iload           17
        //   478: iload           18
        //   480: invokevirtual   android/telephony/cdma/CdmaCellLocation.setCellLocationData:(IIIII)V
        //   483: aload           20
        //   485: astore          7
        //   487: goto            687
        //   490: astore          10
        //   492: aload           20
        //   494: astore          7
        //   496: goto            68
        //   499: iload           8
        //   501: iload           19
        //   503: if_icmpne       587
        //   506: ldc             "getTac"
        //   508: astore          20
        //   510: iconst_0       
        //   511: istore          11
        //   513: aconst_null    
        //   514: astore          12
        //   516: iconst_0       
        //   517: anewarray       Ljava/lang/Object;
        //   520: astore          13
        //   522: aload           10
        //   524: aload           20
        //   526: aload           13
        //   528: invokestatic    com/baidu/location/d/j.b:(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
        //   531: istore          19
        //   533: ldc             "getCi"
        //   535: astore          13
        //   537: iconst_0       
        //   538: anewarray       Ljava/lang/Object;
        //   541: astore          14
        //   543: aload           10
        //   545: aload           13
        //   547: aload           14
        //   549: invokestatic    com/baidu/location/d/j.b:(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
        //   552: istore_3       
        //   553: new             Landroid/telephony/gsm/GsmCellLocation;
        //   556: astore          12
        //   558: aload           12
        //   560: invokespecial   android/telephony/gsm/GsmCellLocation.<init>:()V
        //   563: aload           12
        //   565: iload           19
        //   567: iload_3        
        //   568: invokevirtual   android/telephony/gsm/GsmCellLocation.setLacAndCid:(II)V
        //   571: aload           12
        //   573: astore          6
        //   575: goto            687
        //   578: astore          10
        //   580: aload           12
        //   582: astore          6
        //   584: goto            68
        //   587: ldc             "getLac"
        //   589: astore          20
        //   591: iconst_0       
        //   592: istore          11
        //   594: aconst_null    
        //   595: astore          12
        //   597: iconst_0       
        //   598: anewarray       Ljava/lang/Object;
        //   601: astore          13
        //   603: aload           10
        //   605: aload           20
        //   607: aload           13
        //   609: invokestatic    com/baidu/location/d/j.b:(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
        //   612: istore          19
        //   614: ldc             "getCid"
        //   616: astore          13
        //   618: iconst_0       
        //   619: anewarray       Ljava/lang/Object;
        //   622: astore          14
        //   624: aload           10
        //   626: aload           13
        //   628: aload           14
        //   630: invokestatic    com/baidu/location/d/j.b:(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
        //   633: istore_3       
        //   634: new             Landroid/telephony/gsm/GsmCellLocation;
        //   637: astore          13
        //   639: aload           13
        //   641: invokespecial   android/telephony/gsm/GsmCellLocation.<init>:()V
        //   644: aload           13
        //   646: iload           19
        //   648: iload_3        
        //   649: invokevirtual   android/telephony/gsm/GsmCellLocation.setLacAndCid:(II)V
        //   652: aload           13
        //   654: astore          6
        //   656: goto            687
        //   659: astore          10
        //   661: aload           13
        //   663: astore          6
        //   665: goto            678
        //   668: astore          10
        //   670: goto            678
        //   673: astore          10
        //   675: goto            68
        //   678: iload           5
        //   680: iconst_1       
        //   681: iadd           
        //   682: istore          5
        //   684: goto            37
        //   687: iload           8
        //   689: iload           9
        //   691: if_icmpne       698
        //   694: aload           7
        //   696: astore          6
        //   698: aload           6
        //   700: areturn        
        //   701: aconst_null    
        //   702: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  83     88     673    678    Ljava/lang/Exception;
        //  96     101    673    678    Ljava/lang/Exception;
        //  109    114    673    678    Ljava/lang/Exception;
        //  122    127    673    678    Ljava/lang/Exception;
        //  131    136    673    678    Ljava/lang/Exception;
        //  160    165    673    678    Ljava/lang/Exception;
        //  180    185    673    678    Ljava/lang/Exception;
        //  200    205    673    678    Ljava/lang/Exception;
        //  235    240    673    678    Ljava/lang/Exception;
        //  254    259    673    678    Ljava/lang/Exception;
        //  273    278    673    678    Ljava/lang/Exception;
        //  292    297    673    678    Ljava/lang/Exception;
        //  314    318    673    678    Ljava/lang/Exception;
        //  324    329    673    678    Ljava/lang/Exception;
        //  346    349    673    678    Ljava/lang/Exception;
        //  351    356    673    678    Ljava/lang/Exception;
        //  363    367    490    499    Ljava/lang/Exception;
        //  373    378    490    499    Ljava/lang/Exception;
        //  384    388    490    499    Ljava/lang/Exception;
        //  394    399    490    499    Ljava/lang/Exception;
        //  405    409    490    499    Ljava/lang/Exception;
        //  415    420    490    499    Ljava/lang/Exception;
        //  426    430    490    499    Ljava/lang/Exception;
        //  436    441    490    499    Ljava/lang/Exception;
        //  447    451    490    499    Ljava/lang/Exception;
        //  457    462    490    499    Ljava/lang/Exception;
        //  478    483    490    499    Ljava/lang/Exception;
        //  516    520    668    673    Ljava/lang/Exception;
        //  526    531    668    673    Ljava/lang/Exception;
        //  537    541    668    673    Ljava/lang/Exception;
        //  547    552    673    678    Ljava/lang/Exception;
        //  553    556    673    678    Ljava/lang/Exception;
        //  558    563    673    678    Ljava/lang/Exception;
        //  567    571    578    587    Ljava/lang/Exception;
        //  597    601    668    673    Ljava/lang/Exception;
        //  607    612    668    673    Ljava/lang/Exception;
        //  618    622    668    673    Ljava/lang/Exception;
        //  628    633    668    673    Ljava/lang/Exception;
        //  634    637    668    673    Ljava/lang/Exception;
        //  639    644    668    673    Ljava/lang/Exception;
        //  648    652    659    668    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0587:
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
    
    private a a(final CellInfo cellInfo) {
        final int intValue = Integer.valueOf(Build$VERSION.SDK_INT);
        if (intValue < 17) {
            return null;
        }
        final a a = new a();
        final boolean b = cellInfo instanceof CellInfoGsm;
        boolean b2 = true;
        final char i = 'g';
        Label_0629: {
            int h;
            if (b) {
                final CellInfoGsm cellInfoGsm = (CellInfoGsm)cellInfo;
                final CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
                a.c = this.a(cellIdentity.getMcc());
                a.d = this.a(cellIdentity.getMnc());
                a.a = this.a(cellIdentity.getLac());
                a.b = this.a(cellIdentity.getCid());
                a.i = i;
                h = cellInfoGsm.getCellSignalStrength().getAsuLevel();
            }
            else {
                if (cellInfo instanceof CellInfoCdma) {
                    final CellInfoCdma cellInfoCdma = (CellInfoCdma)cellInfo;
                    final CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                    a.e = cellIdentity2.getLatitude();
                    a.f = cellIdentity2.getLongitude();
                    a.d = this.a(cellIdentity2.getSystemId());
                    a.a = this.a(cellIdentity2.getNetworkId());
                    a.b = this.a(cellIdentity2.getBasestationId());
                    a.i = 'c';
                    a.h = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    final a f = this.f;
                    int c;
                    if (f != null && f.c > 0) {
                        c = this.f.c;
                    }
                    else {
                        c = -1;
                        Label_0479: {
                            try {
                                final TelephonyManager d = this.d;
                                try {
                                    final String networkOperator = d.getNetworkOperator();
                                    if (networkOperator == null || networkOperator.length() <= 0) {
                                        break Label_0479;
                                    }
                                    final int length = networkOperator.length();
                                    final int n = 3;
                                    if (length < n) {
                                        break Label_0479;
                                    }
                                    final String substring = networkOperator.substring(0, n);
                                    try {
                                        final Integer value = Integer.valueOf(substring);
                                        try {
                                            final int intValue2 = value;
                                            if (intValue2 < 0) {
                                                break Label_0479;
                                            }
                                            c = intValue2;
                                        }
                                        catch (Exception ex) {}
                                    }
                                    catch (Exception ex2) {}
                                }
                                catch (Exception ex3) {}
                            }
                            catch (Exception ex4) {}
                        }
                        if (c <= 0) {
                            break Label_0629;
                        }
                    }
                    a.c = c;
                    break Label_0629;
                }
                if (!(cellInfo instanceof CellInfoLte)) {
                    b2 = false;
                    break Label_0629;
                }
                final CellInfoLte cellInfoLte = (CellInfoLte)cellInfo;
                final CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                a.c = this.a(cellIdentity3.getMcc());
                a.d = this.a(cellIdentity3.getMnc());
                a.a = this.a(cellIdentity3.getTac());
                a.b = this.a(cellIdentity3.getCi());
                a.i = i;
                h = cellInfoLte.getCellSignalStrength().getAsuLevel();
            }
            a.h = h;
        }
        if (intValue >= 18 && !b2 && cellInfo instanceof CellInfoWcdma) {
            try {
                final CellInfoWcdma cellInfoWcdma = (CellInfoWcdma)cellInfo;
                try {
                    final CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                    try {
                        a.c = this.a(cellIdentity4.getMcc());
                        a.d = this.a(cellIdentity4.getMnc());
                        a.a = this.a(cellIdentity4.getLac());
                        a.b = this.a(cellIdentity4.getCid());
                        final a a2 = a;
                        try {
                            a2.i = i;
                            final CellInfoWcdma cellInfoWcdma2 = (CellInfoWcdma)cellInfo;
                            try {
                                final CellSignalStrengthWcdma cellSignalStrength = cellInfoWcdma2.getCellSignalStrength();
                                try {
                                    a.h = cellSignalStrength.getAsuLevel();
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
        try {
            final long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            try {
                final long n2 = (elapsedRealtimeNanos - cellInfo.getTimeStamp()) / 1000000L;
                try {
                    a.g = System.currentTimeMillis() - n2;
                }
                catch (Error error) {
                    a.g = System.currentTimeMillis();
                }
            }
            catch (Error error2) {}
        }
        catch (Error error3) {}
        return a;
    }
    
    private a a(final CellLocation cellLocation) {
        return this.a(cellLocation, false);
    }
    
    private a a(final CellLocation cellLocation, boolean b) {
        if (cellLocation != null && this.d != null) {
            final a a = new a();
            if (b != 0) {
                a.f();
            }
            a.g = System.currentTimeMillis();
            b = 3;
            try {
                final TelephonyManager d = this.d;
                try {
                    final String networkOperator = d.getNetworkOperator();
                    Label_0274: {
                        if (networkOperator == null || networkOperator.length() <= 0) {
                            break Label_0274;
                        }
                        Label_0150: {
                            if (networkOperator.length() < b) {
                                break Label_0150;
                            }
                            final String substring = networkOperator.substring(0, b);
                            try {
                                final Integer value = Integer.valueOf(substring);
                                try {
                                    int c = value;
                                    Label_0143: {
                                        if (c >= 0) {
                                            break Label_0143;
                                        }
                                        final a f = this.f;
                                        try {
                                            c = f.c;
                                            a.c = c;
                                            final String s = networkOperator;
                                            try {
                                                final String substring2 = s.substring(b);
                                                Label_0219: {
                                                    if (substring2 == null) {
                                                        break Label_0219;
                                                    }
                                                    final char[] charArray = substring2.toCharArray();
                                                    int n = 0;
                                                    while (true) {
                                                        Label_0225: {
                                                            if (n >= charArray.length) {
                                                                break Label_0225;
                                                            }
                                                            final char c2 = charArray[n];
                                                            try {
                                                                if (Character.isDigit(c2)) {
                                                                    ++n;
                                                                    continue;
                                                                }
                                                                final String substring3 = substring2.substring(0, n);
                                                                try {
                                                                    final Integer value2 = Integer.valueOf(substring3);
                                                                    try {
                                                                        int d2 = value2;
                                                                        Label_0267: {
                                                                            if (d2 >= 0) {
                                                                                break Label_0267;
                                                                            }
                                                                            final a f2 = this.f;
                                                                            try {
                                                                                d2 = f2.d;
                                                                                a.d = d2;
                                                                                final TelephonyManager d3 = this.d;
                                                                                try {
                                                                                    final int simState = d3.getSimState();
                                                                                    try {
                                                                                        b.a = simState;
                                                                                    }
                                                                                    catch (Exception ex) {
                                                                                        b.b = 1;
                                                                                    }
                                                                                }
                                                                                catch (Exception ex2) {}
                                                                            }
                                                                            catch (Exception ex3) {}
                                                                        }
                                                                    }
                                                                    catch (Exception ex4) {}
                                                                }
                                                                catch (Exception ex5) {}
                                                                n = 0;
                                                            }
                                                            catch (Exception ex6) {}
                                                        }
                                                        break;
                                                    }
                                                }
                                            }
                                            catch (Exception ex7) {}
                                        }
                                        catch (Exception ex8) {}
                                    }
                                }
                                catch (Exception ex9) {}
                            }
                            catch (Exception ex10) {}
                        }
                    }
                }
                catch (Exception ex11) {}
            }
            catch (Exception ex12) {}
            Label_0902: {
                if (cellLocation instanceof GsmCellLocation) {
                    final GsmCellLocation gsmCellLocation = (GsmCellLocation)cellLocation;
                    a.a = gsmCellLocation.getLac();
                    a.b = gsmCellLocation.getCid();
                    a.i = 'g';
                }
                else if (cellLocation instanceof CdmaCellLocation) {
                    a.i = 'c';
                    if (Integer.valueOf(Build$VERSION.SDK_INT) < 5) {
                        return a;
                    }
                    if (b.p == null) {
                        final String s2 = "android.telephony.cdma.CdmaCellLocation";
                        try {
                            final Class<?> forName = Class.forName(s2);
                            try {
                                b.p = forName;
                                final Method method = b.p.getMethod("getBaseStationId", (Class[])new Class[0]);
                                try {
                                    b.k = method;
                                    final Method method2 = b.p.getMethod("getNetworkId", (Class[])new Class[0]);
                                    try {
                                        b.l = method2;
                                        final Method method3 = b.p.getMethod("getSystemId", (Class[])new Class[0]);
                                        try {
                                            b.m = method3;
                                            final Method method4 = b.p.getMethod("getBaseStationLatitude", (Class[])new Class[0]);
                                            try {
                                                b.n = method4;
                                                final Method method5 = b.p.getMethod("getBaseStationLongitude", (Class[])new Class[0]);
                                                try {
                                                    b.o = method5;
                                                }
                                                catch (Exception ex13) {
                                                    b.p = null;
                                                    b.b = 2;
                                                    return a;
                                                }
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
                    final Class p = b.p;
                    if (p != null && p.isInstance(cellLocation)) {
                        try {
                            final Method m = b.m;
                            try {
                                final Object invoke = m.invoke(cellLocation, new Object[0]);
                                try {
                                    final Integer n2 = (Integer)invoke;
                                    try {
                                        int d4 = n2;
                                        Label_0676: {
                                            if (d4 >= 0) {
                                                break Label_0676;
                                            }
                                            final a f3 = this.f;
                                            try {
                                                d4 = f3.d;
                                                a.d = d4;
                                                final Method k = b.k;
                                                try {
                                                    final Object invoke2 = k.invoke(cellLocation, new Object[0]);
                                                    try {
                                                        final Integer n3 = (Integer)invoke2;
                                                        try {
                                                            a.b = n3;
                                                            final Method l = b.l;
                                                            try {
                                                                final Object invoke3 = l.invoke(cellLocation, new Object[0]);
                                                                try {
                                                                    final Integer n4 = (Integer)invoke3;
                                                                    try {
                                                                        a.a = n4;
                                                                        final Method n5 = b.n;
                                                                        try {
                                                                            final Object invoke4 = n5.invoke(cellLocation, new Object[0]);
                                                                            final Integer n6 = (Integer)invoke4;
                                                                            try {
                                                                                final int intValue = n6;
                                                                                final int n7 = -1 >>> 1;
                                                                                Label_0832: {
                                                                                    if (intValue >= n7) {
                                                                                        break Label_0832;
                                                                                    }
                                                                                    final Integer n8 = (Integer)invoke4;
                                                                                    try {
                                                                                        a.e = n8;
                                                                                        final Method o = b.o;
                                                                                        try {
                                                                                            final Object invoke5 = o.invoke(cellLocation, new Object[0]);
                                                                                            final Integer n9 = (Integer)invoke5;
                                                                                            try {
                                                                                                if (n9 >= n7) {
                                                                                                    break Label_0902;
                                                                                                }
                                                                                                final Integer n10 = (Integer)invoke5;
                                                                                                try {
                                                                                                    a.f = n10;
                                                                                                }
                                                                                                catch (Exception ex20) {
                                                                                                    b.b = b;
                                                                                                    return a;
                                                                                                }
                                                                                            }
                                                                                            catch (Exception ex21) {}
                                                                                        }
                                                                                        catch (Exception ex22) {}
                                                                                    }
                                                                                    catch (Exception ex23) {}
                                                                                }
                                                                            }
                                                                            catch (Exception ex24) {}
                                                                        }
                                                                        catch (Exception ex25) {}
                                                                    }
                                                                    catch (Exception ex26) {}
                                                                }
                                                                catch (Exception ex27) {}
                                                            }
                                                            catch (Exception ex28) {}
                                                        }
                                                        catch (Exception ex29) {}
                                                    }
                                                    catch (Exception ex30) {}
                                                }
                                                catch (Exception ex31) {}
                                            }
                                            catch (Exception ex32) {}
                                        }
                                    }
                                    catch (Exception ex33) {}
                                }
                                catch (Exception ex34) {}
                            }
                            catch (Exception ex35) {}
                        }
                        catch (Exception ex36) {}
                    }
                }
            }
            this.c(a);
            return a;
        }
        return null;
    }
    
    public static b a() {
        synchronized (b.class) {
            if (com.baidu.location.b.b.c == null) {
                com.baidu.location.b.b.c = new b();
            }
            return com.baidu.location.b.b.c;
        }
    }
    
    private void c(a f) {
        if (f.b()) {
            final a f2 = this.f;
            if (f2 == null || !f2.a(f)) {
                this.f = f;
                if (f.b()) {
                    final int size = this.h.size();
                    if (size == 0) {
                        f = null;
                    }
                    else {
                        f = (a)this.h.get(size - 1);
                    }
                    if (f == null || f.b != this.f.b || f.a != this.f.a) {
                        this.h.add(this.f);
                        if (this.h.size() > 3) {
                            this.h.remove(0);
                        }
                        this.j();
                        this.q = false;
                    }
                }
                else {
                    final List h = this.h;
                    if (h != null) {
                        h.clear();
                    }
                }
            }
        }
    }
    
    private String d(final a a) {
        final StringBuilder sb = new StringBuilder();
        if (Integer.valueOf(Build$VERSION.SDK_INT) >= 17) {
            try {
                final List allCellInfo = this.d.getAllCellInfo();
                if (allCellInfo != null && allCellInfo.size() > 0) {
                    sb.append("&nc=");
                    for (final CellInfo cellInfo : allCellInfo) {
                        if (cellInfo.isRegistered()) {
                            continue;
                        }
                        final a a2 = this.a(cellInfo);
                        if (a2 == null) {
                            continue;
                        }
                        final int a3 = a2.a;
                        final int n = -1;
                        if (a3 == n || a2.b == n) {
                            continue;
                        }
                        String s;
                        if (a.a != a2.a) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append(a2.a);
                            sb2.append("|");
                            sb2.append(a2.b);
                            sb2.append("|");
                            sb2.append(a2.h);
                            sb2.append(";");
                            s = sb2.toString();
                        }
                        else {
                            final StringBuilder sb3 = new StringBuilder();
                            sb3.append("|");
                            sb3.append(a2.b);
                            sb3.append("|");
                            sb3.append(a2.h);
                            sb3.append(";");
                            s = sb3.toString();
                        }
                        sb.append(s);
                    }
                }
            }
            finally {}
        }
        return sb.toString();
    }
    
    private void i() {
        final String g = com.baidu.location.d.j.g();
        if (g == null) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(g);
        sb.append(File.separator);
        sb.append("lcvif.dat");
        final File file = new File(sb.toString());
        if (file.exists()) {
            try {
                final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                long n = 0L;
                randomAccessFile.seek(n);
                final long long1 = randomAccessFile.readLong();
                try {
                    if (System.currentTimeMillis() - long1 > 60000L) {
                        randomAccessFile.close();
                        file.delete();
                        return;
                    }
                    randomAccessFile.readInt();
                    int n2 = 0;
                    while (true) {
                        Label_0352: {
                            if (n2 >= 3) {
                                break Label_0352;
                            }
                            final long long2 = randomAccessFile.readLong();
                            try {
                                final int int1 = randomAccessFile.readInt();
                                try {
                                    final int int2 = randomAccessFile.readInt();
                                    try {
                                        final int int3 = randomAccessFile.readInt();
                                        try {
                                            final int int4 = randomAccessFile.readInt();
                                            try {
                                                final int int5 = randomAccessFile.readInt();
                                                char c;
                                                if (int5 == 1) {
                                                    c = 'g';
                                                }
                                                else {
                                                    c = '\0';
                                                }
                                                char c2;
                                                if (int5 == 2) {
                                                    c2 = 'c';
                                                }
                                                else {
                                                    c2 = c;
                                                }
                                                Label_0340: {
                                                    if (long2 == n) {
                                                        break Label_0340;
                                                    }
                                                    final boolean q = true;
                                                    final a a2;
                                                    final a a = a2 = new a(int3, int4, int1, int2, 0, c2);
                                                    try {
                                                        a2.g = long2;
                                                        if (a.b()) {
                                                            this.q = q;
                                                            this.h.add(a);
                                                        }
                                                        ++n2;
                                                        n = 0L;
                                                        continue;
                                                        randomAccessFile.close();
                                                    }
                                                    catch (Exception ex) {
                                                        file.delete();
                                                    }
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
                    }
                }
                catch (Exception ex7) {}
            }
            catch (Exception ex8) {}
        }
    }
    
    private void j() {
        if (this.h == null && this.g == null) {
            return;
        }
        if (this.h == null && this.g != null) {
            (this.h = new LinkedList()).add(this.g);
        }
        final String g = com.baidu.location.d.j.g();
        if (g == null) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(g);
        sb.append(File.separator);
        sb.append("lcvif.dat");
        final File file = new File(sb.toString());
        final int size = this.h.size();
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            final long n = 0L;
            randomAccessFile.seek(n);
            final Object value = this.h.get(size - 1);
            try {
                final a a = (a)value;
                try {
                    randomAccessFile.writeLong(a.g);
                    final RandomAccessFile randomAccessFile2 = randomAccessFile;
                    try {
                        randomAccessFile2.writeInt(size);
                        int n2 = 0;
                        int n3 = 0;
                        while (true) {
                            final int n4 = 3;
                            final int n5 = 3 - size;
                            final int n6 = 2;
                            Label_0307: {
                                if (n3 >= n5) {
                                    break Label_0307;
                                }
                                randomAccessFile.writeLong(n);
                                final int n7 = -1;
                                randomAccessFile.writeInt(n7);
                                final RandomAccessFile randomAccessFile3 = randomAccessFile;
                                try {
                                    randomAccessFile3.writeInt(n7);
                                    final RandomAccessFile randomAccessFile4 = randomAccessFile;
                                    try {
                                        randomAccessFile4.writeInt(n7);
                                        final RandomAccessFile randomAccessFile5 = randomAccessFile;
                                        try {
                                            randomAccessFile5.writeInt(n7);
                                            final RandomAccessFile randomAccessFile6 = randomAccessFile;
                                            try {
                                                randomAccessFile6.writeInt(n6);
                                                ++n3;
                                                continue;
                                                final Object value2 = this.h.get(n2);
                                                try {
                                                    final a a2 = (a)value2;
                                                    try {
                                                        randomAccessFile.writeLong(a2.g);
                                                        final Object value3 = this.h.get(n2);
                                                        try {
                                                            final a a3 = (a)value3;
                                                            try {
                                                                randomAccessFile.writeInt(a3.c);
                                                                final Object value4 = this.h.get(n2);
                                                                try {
                                                                    final a a4 = (a)value4;
                                                                    try {
                                                                        randomAccessFile.writeInt(a4.d);
                                                                        final Object value5 = this.h.get(n2);
                                                                        try {
                                                                            final a a5 = (a)value5;
                                                                            try {
                                                                                randomAccessFile.writeInt(a5.a);
                                                                                final Object value6 = this.h.get(n2);
                                                                                try {
                                                                                    final a a6 = (a)value6;
                                                                                    try {
                                                                                        randomAccessFile.writeInt(a6.b);
                                                                                        final Object value7 = this.h.get(n2);
                                                                                        try {
                                                                                            final a a7 = (a)value7;
                                                                                            try {
                                                                                                Label_0617: {
                                                                                                    if (a7.i == 'g') {
                                                                                                        randomAccessFile.writeInt(1);
                                                                                                        break Label_0617;
                                                                                                    }
                                                                                                    final Object value8 = this.h.get(n2);
                                                                                                    try {
                                                                                                        final a a8 = (a)value8;
                                                                                                        try {
                                                                                                            if (a8.i == 'c') {
                                                                                                                randomAccessFile.writeInt(n6);
                                                                                                            }
                                                                                                            else {
                                                                                                                randomAccessFile.writeInt(n4);
                                                                                                            }
                                                                                                            ++n2;
                                                                                                            break Label_0307;
                                                                                                            Label_0626: {
                                                                                                                randomAccessFile.close();
                                                                                                            }
                                                                                                        }
                                                                                                        catch (Exception ex) {}
                                                                                                    }
                                                                                                    catch (Exception ex2) {}
                                                                                                }
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
                                                            catch (Exception ex11) {}
                                                        }
                                                        catch (Exception ex12) {}
                                                    }
                                                    catch (Exception ex13) {}
                                                }
                                                catch (Exception ex14) {}
                                            }
                                            // iftrue(Label_0626:, n2 >= size)
                                            catch (Exception ex15) {}
                                        }
                                        catch (Exception ex16) {}
                                    }
                                    catch (Exception ex17) {}
                                }
                                catch (Exception ex18) {}
                            }
                        }
                    }
                    catch (Exception ex19) {}
                }
                catch (Exception ex20) {}
            }
            catch (Exception ex21) {}
        }
        catch (Exception ex22) {}
    }
    
    private void k() {
        final a n = this.n();
        if (n != null) {
            this.c(n);
        }
        if (n == null || !n.b()) {
            a a = null;
            CellLocation cellLocation;
            try {
                this.d.getCellLocation();
            }
            finally {
                cellLocation = null;
            }
            if (cellLocation != null) {
                a = this.a(cellLocation);
            }
            if (a == null || !a.b()) {
                final CellLocation l = this.l();
                if (l != null) {
                    this.a(l, true);
                }
            }
        }
    }
    
    private CellLocation l() {
        final Object e = this.e;
        CellLocation cellLocation = null;
        if (e == null) {
            return null;
        }
        try {
            final Class m = this.m();
            Object a3;
            if (m.isInstance(e)) {
                final Object cast = m.cast(e);
                final String s = "getCellLocation";
                Object o = null;
                Label_0074: {
                    try {
                        o = com.baidu.location.d.j.a(cast, s, new Object[0]);
                        break Label_0074;
                    }
                    catch (Exception ex) {}
                    catch (NoSuchMethodException ex2) {}
                    o = null;
                }
                final int n = 1;
                if (o == null) {
                    try {
                        final Object[] array = new Object[n];
                        try {
                            array[0] = n;
                            o = com.baidu.location.d.j.a(cast, s, array);
                        }
                        catch (Exception ex3) {}
                        catch (NoSuchMethodException ex4) {}
                    }
                    catch (Exception ex5) {}
                    catch (NoSuchMethodException ex6) {}
                }
                if (o == null) {
                    final String s2 = "getCellLocationGemini";
                    try {
                        final Object[] array2 = new Object[n];
                        try {
                            array2[0] = n;
                            final Object a = com.baidu.location.d.j.a(cast, s2, array2);
                        }
                        catch (Exception ex7) {}
                        catch (NoSuchMethodException ex8) {}
                    }
                    catch (Exception ex9) {}
                    catch (NoSuchMethodException ex10) {}
                }
                final Object a = o;
                if (a == null) {
                    final String s3 = "getAllCellInfo";
                    try {
                        final Object a2 = com.baidu.location.d.j.a(cast, s3, new Object[0]);
                        try {
                            final List list = (List)a2;
                        }
                        catch (Exception ex11) {}
                        catch (NoSuchMethodException ex12) {}
                    }
                    catch (Exception ex13) {}
                    catch (NoSuchMethodException ex14) {}
                    final List list = null;
                    a3 = this.a(list);
                }
                else {
                    a3 = a;
                }
            }
            else {
                a3 = null;
            }
            if (a3 != null) {
                cellLocation = (CellLocation)a3;
            }
        }
        catch (Exception ex15) {}
        return cellLocation;
    }
    
    private Class m() {
        final ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        final int o = this.o();
        Class<?> loadClass = null;
        String s = null;
        switch (o) {
            default: {
                s = null;
                break;
            }
            case 2: {
                s = "android.telephony.TelephonyManager2";
                break;
            }
            case 1: {
                s = "android.telephony.MSimTelephonyManager";
                break;
            }
            case 0: {
                s = "android.telephony.TelephonyManager";
                break;
            }
        }
        final ClassLoader classLoader = systemClassLoader;
        try {
            loadClass = classLoader.loadClass(s);
        }
        catch (Exception ex) {}
        return loadClass;
    }
    
    private a n() {
        final int intValue = Integer.valueOf(Build$VERSION.SDK_INT);
        a a = null;
        if (intValue < 17) {
            return null;
        }
        try {
            com.baidu.location.b.b.a = this.d.getSimState();
            final List allCellInfo = this.d.getAllCellInfo();
            if (allCellInfo != null && allCellInfo.size() > 0) {
                final Iterator<CellInfo> iterator = allCellInfo.iterator();
                a a2 = null;
                while (iterator.hasNext()) {
                    final CellInfo cellInfo = iterator.next();
                    if (cellInfo.isRegistered()) {
                        boolean b = false;
                        if (a2 != null) {
                            b = true;
                        }
                        a a3 = this.a(cellInfo);
                        if (a3 == null) {
                            continue;
                        }
                        if (!a3.b()) {
                            a3 = null;
                        }
                        else if (b) {
                            a2.j = a3.h();
                            return a2;
                        }
                        if (a2 != null) {
                            continue;
                        }
                        a2 = a3;
                    }
                }
                a = a2;
            }
        }
        finally {}
        return a;
    }
    
    private int o() {
        final String s = "android.telephony.MSimTelephonyManager";
        int n;
        try {
            Class.forName(s);
            n = 1;
        }
        catch (Exception ex) {
            n = 0;
        }
        if (n == 0) {
            final String s2 = "android.telephony.TelephonyManager2";
            try {
                Class.forName(s2);
                n = 2;
            }
            catch (Exception ex2) {}
        }
        return n;
    }
    
    public String a(final a a) {
        String s2 = null;
        try {
            final String d = this.d(a);
            final int intValue = Integer.valueOf(Build$VERSION.SDK_INT);
            if (d != null && !d.equals("") && !d.equals("&nc=")) {
                return d;
            }
            if (intValue >= 17) {
                return d;
            }
            final List neighboringCellInfo = this.d.getNeighboringCellInfo();
            if (neighboringCellInfo != null && !neighboringCellInfo.isEmpty()) {
                String s = "&nc=";
                int n = 0;
                for (final NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                    final int lac = neighboringCellInfo2.getLac();
                    final int n2 = -1;
                    if (lac != n2 && neighboringCellInfo2.getCid() != n2) {
                        if (a.a != lac) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append(s);
                            sb.append(lac);
                            sb.append("|");
                            sb.append(neighboringCellInfo2.getCid());
                            sb.append("|");
                            sb.append(neighboringCellInfo2.getRssi());
                            sb.append(";");
                            s = sb.toString();
                        }
                        else {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append(s);
                            sb2.append("|");
                            sb2.append(neighboringCellInfo2.getCid());
                            sb2.append("|");
                            sb2.append(neighboringCellInfo2.getRssi());
                            sb2.append(";");
                            s = sb2.toString();
                        }
                    }
                    ++n;
                    if (n >= 8) {
                        break;
                    }
                }
            }
        }
        finally {
            final Throwable t;
            t.printStackTrace();
            s2 = "";
        }
        if (s2 != null && s2.equals("&nc=")) {
            return null;
        }
        return s2;
    }
    
    public String b(final a a) {
        final StringBuffer sb = new StringBuffer(128);
        sb.append("&nw=");
        sb.append(a.i);
        final Locale china = Locale.CHINA;
        final String s = "&cl=%d|%d|%d|%d&cl_s=%d";
        final Object[] array = new Object[5];
        array[0] = a.c;
        final Integer value = a.d;
        final int n = 1;
        array[n] = value;
        final Integer value2 = a.a;
        final int n2 = 2;
        array[n2] = value2;
        array[3] = a.b;
        array[4] = a.h;
        sb.append(String.format(china, s, array));
        final int e = a.e;
        final int n3 = -1 >>> 1;
        if (e < n3 && a.f < n3) {
            final Locale china2 = Locale.CHINA;
            final String s2 = "&cdmall=%.6f|%.6f";
            final Object[] array2 = new Object[n2];
            final double n4 = a.f;
            final double n5 = 14400.0;
            Double.isNaN(n4);
            array2[0] = n4 / n5;
            final double n6 = a.e;
            Double.isNaN(n6);
            array2[n] = n6 / n5;
            sb.append(String.format(china2, s2, array2));
        }
        sb.append("&cl_t=");
        sb.append(a.g);
        Label_0659: {
            try {
                if (this.h != null) {
                    final List h = this.h;
                    try {
                        if (h.size() <= 0) {
                            break Label_0659;
                        }
                        final List h2 = this.h;
                        try {
                            final int size = h2.size();
                            sb.append("&clt=");
                            int i = 0;
                            while (i < size) {
                                final Object value3 = this.h.get(i);
                                try {
                                    final a a2 = (a)value3;
                                    Label_0648: {
                                        if (a2 == null) {
                                            break Label_0648;
                                        }
                                        final int c = a2.c;
                                        try {
                                            if (c != a.c) {
                                                sb.append(a2.c);
                                            }
                                            sb.append("|");
                                            final int d = a2.d;
                                            try {
                                                if (d != a.d) {
                                                    sb.append(a2.d);
                                                }
                                                sb.append("|");
                                                final int a3 = a2.a;
                                                try {
                                                    if (a3 != a.a) {
                                                        sb.append(a2.a);
                                                    }
                                                    sb.append("|");
                                                    final int b = a2.b;
                                                    try {
                                                        if (b != a.b) {
                                                            sb.append(a2.b);
                                                        }
                                                        sb.append("|");
                                                        final long currentTimeMillis = System.currentTimeMillis();
                                                        try {
                                                            sb.append((currentTimeMillis - a2.g) / 1000L);
                                                            sb.append(";");
                                                            ++i;
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
                                }
                                catch (Exception ex6) {}
                            }
                        }
                        catch (Exception ex7) {}
                    }
                    catch (Exception ex8) {}
                }
            }
            catch (Exception ex9) {}
        }
        if (com.baidu.location.b.b.a > 100) {
            com.baidu.location.b.b.a = 0;
        }
        final int n7 = com.baidu.location.b.b.a + (com.baidu.location.b.b.b << 8);
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("&cs=");
        sb2.append(n7);
        sb.append(sb2.toString());
        if (a.j != null) {
            sb.append(a.j);
        }
        return sb.toString();
    }
    
    public void b() {
        synchronized (this) {
            final boolean j = this.j;
            final boolean i = true;
            if (j == i) {
                return;
            }
            if (!com.baidu.location.f.isServing) {
                return;
            }
            this.d = (TelephonyManager)com.baidu.location.f.getServiceContext().getSystemService("phone");
            this.h = new LinkedList();
            this.i = new b$a(this);
            this.i();
            if (this.d != null && this.i != null) {
                try {
                    final TelephonyManager d = this.d;
                    try {
                        d.listen((PhoneStateListener)this.i, 272);
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {}
                Label_0243: {
                    try {
                        Object e = null;
                        switch (this.o()) {
                            default: {
                                break Label_0243;
                            }
                            case 2: {
                                e = com.baidu.location.d.j.a(com.baidu.location.f.getServiceContext(), "phone2");
                                break;
                            }
                            case 1: {
                                e = com.baidu.location.d.j.a(com.baidu.location.f.getServiceContext(), "phone_msim");
                                break;
                            }
                            case 0: {
                                e = com.baidu.location.d.j.a(com.baidu.location.f.getServiceContext(), "phone2");
                                break;
                            }
                        }
                        this.e = e;
                    }
                    finally {
                        this.e = null;
                    }
                }
                this.j = i;
            }
        }
    }
    
    public void c() {
        synchronized (this) {
            if (!this.j) {
                return;
            }
            if (this.i != null && this.d != null) {
                this.d.listen((PhoneStateListener)this.i, 0);
            }
            this.i = null;
            this.d = null;
            this.h.clear();
            this.h = null;
            this.j();
            this.j = false;
        }
    }
    
    public boolean d() {
        return this.q;
    }
    
    public int e() {
        final TelephonyManager d = this.d;
        int networkType = 0;
        if (d == null) {
            return 0;
        }
        try {
            networkType = d.getNetworkType();
        }
        catch (Exception ex) {}
        return networkType;
    }
    
    public a f() {
        final a f = this.f;
        if ((f == null || !f.a() || !this.f.b()) && this.d != null) {
            try {
                this.k();
            }
            catch (Exception ex) {}
        }
        if (this.f.e()) {
            this.g = null;
            this.g = new a(this.f.a, this.f.b, this.f.c, this.f.d, this.f.h, this.f.i);
        }
        if (this.f.d() && this.g != null && this.f.i == 'g') {
            this.f.d = this.g.d;
            this.f.c = this.g.c;
        }
        return this.f;
    }
    
    public String g() {
        int simState = -1;
        try {
            if (this.d != null) {
                final TelephonyManager d = this.d;
                try {
                    simState = d.getSimState();
                }
                catch (Exception ex) {}
            }
        }
        catch (Exception ex2) {}
        final StringBuilder sb = new StringBuilder();
        sb.append("&sim=");
        sb.append(simState);
        return sb.toString();
    }
    
    public int h() {
        final TelephonyManager telephonyManager = (TelephonyManager)com.baidu.location.f.getServiceContext().getSystemService("phone");
        String subscriberId;
        try {
            subscriberId = telephonyManager.getSubscriberId();
        }
        catch (Exception ex) {
            subscriberId = null;
        }
        if (subscriberId != null) {
            if (subscriberId.startsWith("46000") || subscriberId.startsWith("46002") || subscriberId.startsWith("46007")) {
                return 1;
            }
            if (subscriberId.startsWith("46001")) {
                return 2;
            }
            if (subscriberId.startsWith("46003")) {
                return 3;
            }
        }
        return 0;
    }
}
