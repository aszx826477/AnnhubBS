// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.b;

import com.baidu.location.d.j;
import android.os.SystemClock;
import android.os.Build$VERSION;
import android.net.wifi.ScanResult;
import java.util.regex.Pattern;
import android.text.TextUtils;
import java.util.List;

public class g
{
    public List a;
    private long b;
    private long c;
    private boolean d;
    private boolean e;
    
    public g(final List a, final long b) {
        this.a = null;
        final long n = 0L;
        this.b = n;
        this.c = n;
        this.d = false;
        this.b = b;
        this.a = a;
        this.c = System.currentTimeMillis();
        this.l();
    }
    
    private boolean a(final String s) {
        return !TextUtils.isEmpty((CharSequence)s) && Pattern.compile("wpa|wep", 2).matcher(s).find();
    }
    
    private String b(String s) {
        if (s != null && (s.contains("&") || s.contains(";"))) {
            s = s.replace("&", "_");
            s = s.replace(";", "_");
        }
        return s;
    }
    
    private void l() {
        final int a = this.a();
        final int n = 1;
        if (a < n) {
            return;
        }
        int n4;
        for (int n2 = this.a.size() - n, n3 = 1; n2 >= n && n3 != 0; --n2, n3 = n4) {
            int i = 0;
            n4 = 0;
            while (i < n2) {
                final int level = this.a.get(i).level;
                final List a2 = this.a;
                final int n5 = i + 1;
                if (level < a2.get(n5).level) {
                    final ScanResult scanResult = this.a.get(n5);
                    final List a3 = this.a;
                    a3.set(n5, a3.get(i));
                    this.a.set(i, scanResult);
                    n4 = 1;
                }
                i = n5;
            }
        }
    }
    
    public int a() {
        final List a = this.a;
        if (a == null) {
            return 0;
        }
        return a.size();
    }
    
    public String a(final int n) {
        return this.a(n, false, false);
    }
    
    public String a(final int p0, final boolean p1, final boolean p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: astore          4
        //     3: aload_0        
        //     4: invokevirtual   com/baidu/location/b/g.a:()I
        //     7: istore          5
        //     9: iconst_0       
        //    10: istore          6
        //    12: aconst_null    
        //    13: astore          7
        //    15: iconst_1       
        //    16: istore          8
        //    18: iload           5
        //    20: iload           8
        //    22: if_icmpge       27
        //    25: aconst_null    
        //    26: areturn        
        //    27: new             Ljava/util/Random;
        //    30: astore          9
        //    32: aload           9
        //    34: invokespecial   java/util/Random.<init>:()V
        //    37: new             Ljava/lang/StringBuffer;
        //    40: astore          10
        //    42: sipush          512
        //    45: istore          5
        //    47: ldc             7.175E-43
        //    49: fstore          11
        //    51: aload           10
        //    53: iload           5
        //    55: invokespecial   java/lang/StringBuffer.<init>:(I)V
        //    58: new             Ljava/util/ArrayList;
        //    61: astore          12
        //    63: aload           12
        //    65: invokespecial   java/util/ArrayList.<init>:()V
        //    68: invokestatic    com/baidu/location/b/h.a:()Lcom/baidu/location/b/h;
        //    71: astore          13
        //    73: aload           13
        //    75: invokevirtual   com/baidu/location/b/h.k:()Landroid/net/wifi/WifiInfo;
        //    78: astore          13
        //    80: aload           13
        //    82: ifnull          163
        //    85: aload           13
        //    87: invokevirtual   android/net/wifi/WifiInfo.getBSSID:()Ljava/lang/String;
        //    90: astore          14
        //    92: aload           14
        //    94: ifnull          163
        //    97: aload           13
        //    99: invokevirtual   android/net/wifi/WifiInfo.getBSSID:()Ljava/lang/String;
        //   102: astore          14
        //   104: ldc             ":"
        //   106: astore          15
        //   108: ldc             ""
        //   110: astore          16
        //   112: aload           14
        //   114: aload           15
        //   116: aload           16
        //   118: invokevirtual   java/lang/String.replace:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //   121: astore          14
        //   123: aload           13
        //   125: invokevirtual   android/net/wifi/WifiInfo.getRssi:()I
        //   128: istore          5
        //   130: invokestatic    com/baidu/location/b/h.a:()Lcom/baidu/location/b/h;
        //   133: astore          15
        //   135: aload           15
        //   137: invokevirtual   com/baidu/location/b/h.m:()Ljava/lang/String;
        //   140: astore          15
        //   142: iload           5
        //   144: ifge            152
        //   147: iload           5
        //   149: ineg           
        //   150: istore          5
        //   152: aload           15
        //   154: astore          16
        //   156: iload           5
        //   158: istore          17
        //   160: goto            175
        //   163: iconst_0       
        //   164: istore          18
        //   166: aconst_null    
        //   167: astore          14
        //   169: aconst_null    
        //   170: astore          16
        //   172: iconst_m1      
        //   173: istore          17
        //   175: getstatic       android/os/Build$VERSION.SDK_INT:I
        //   178: istore          5
        //   180: bipush          17
        //   182: istore          19
        //   184: ldc             2.4E-44
        //   186: fstore          20
        //   188: lconst_0       
        //   189: lstore          21
        //   191: iload           5
        //   193: iload           19
        //   195: if_icmplt       246
        //   198: invokestatic    android/os/SystemClock.elapsedRealtimeNanos:()J
        //   201: lstore          23
        //   203: ldc2_w          1000
        //   206: lstore          25
        //   208: lload           23
        //   210: lload           25
        //   212: ldiv           
        //   213: lstore          23
        //   215: goto            224
        //   218: astore          13
        //   220: lload           21
        //   222: lstore          23
        //   224: lload           23
        //   226: lload           21
        //   228: lcmp           
        //   229: istore          5
        //   231: iload           5
        //   233: ifle            250
        //   236: iconst_1       
        //   237: istore          5
        //   239: ldc             1.4E-45
        //   241: fstore          11
        //   243: goto            259
        //   246: lload           21
        //   248: lstore          23
        //   250: iconst_0       
        //   251: istore          5
        //   253: fconst_0       
        //   254: fstore          11
        //   256: aconst_null    
        //   257: astore          13
        //   259: iload           5
        //   261: ifeq            292
        //   264: iload           5
        //   266: ifeq            283
        //   269: iload_2        
        //   270: ifeq            283
        //   273: iconst_1       
        //   274: istore          5
        //   276: ldc             1.4E-45
        //   278: fstore          11
        //   280: goto            292
        //   283: iconst_0       
        //   284: istore          5
        //   286: fconst_0       
        //   287: fstore          11
        //   289: aconst_null    
        //   290: astore          13
        //   292: iload           5
        //   294: istore          19
        //   296: fload           11
        //   298: fstore          20
        //   300: aload           4
        //   302: getfield        com/baidu/location/b/g.a:Ljava/util/List;
        //   305: astore          13
        //   307: aload           13
        //   309: invokeinterface java/util/List.size:()I
        //   314: istore          5
        //   316: iload_1        
        //   317: istore          6
        //   319: iload           5
        //   321: iload_1        
        //   322: if_icmple       328
        //   325: goto            332
        //   328: iload           5
        //   330: istore          6
        //   332: lload           21
        //   334: lstore          27
        //   336: iconst_0       
        //   337: istore          29
        //   339: iconst_0       
        //   340: istore          30
        //   342: iconst_1       
        //   343: istore          31
        //   345: ldc             1.4E-45
        //   347: fstore          32
        //   349: aconst_null    
        //   350: astore          33
        //   352: iconst_0       
        //   353: istore          34
        //   355: iconst_0       
        //   356: istore          35
        //   358: fconst_0       
        //   359: fstore          36
        //   361: iload           30
        //   363: iload           6
        //   365: if_icmpge       1598
        //   368: aload           4
        //   370: getfield        com/baidu/location/b/g.a:Ljava/util/List;
        //   373: astore          13
        //   375: aload           13
        //   377: iload           30
        //   379: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   384: astore          13
        //   386: aload           13
        //   388: checkcast       Landroid/net/wifi/ScanResult;
        //   391: astore          13
        //   393: aload           13
        //   395: getfield        android/net/wifi/ScanResult.level:I
        //   398: istore          5
        //   400: iload           5
        //   402: ifne            436
        //   405: iload           6
        //   407: istore          37
        //   409: iload           19
        //   411: istore          38
        //   413: fload           20
        //   415: fstore          39
        //   417: lload           27
        //   419: lstore          40
        //   421: iload           31
        //   423: istore          42
        //   425: fload           32
        //   427: fstore          43
        //   429: aload           9
        //   431: astore          44
        //   433: goto            1536
        //   436: iload           19
        //   438: ifeq            545
        //   441: aload           4
        //   443: getfield        com/baidu/location/b/g.a:Ljava/util/List;
        //   446: astore          13
        //   448: aload           13
        //   450: iload           30
        //   452: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   457: astore          13
        //   459: aload           13
        //   461: checkcast       Landroid/net/wifi/ScanResult;
        //   464: astore          13
        //   466: aload           9
        //   468: astore          45
        //   470: aload           13
        //   472: getfield        android/net/wifi/ScanResult.timestamp:J
        //   475: lstore          46
        //   477: lload           23
        //   479: lload           46
        //   481: lsub           
        //   482: lstore          46
        //   484: ldc2_w          1000000
        //   487: lstore          48
        //   489: lload           46
        //   491: lload           48
        //   493: ldiv           
        //   494: lstore          46
        //   496: goto            513
        //   499: astore          13
        //   501: goto            510
        //   504: astore          13
        //   506: aload           9
        //   508: astore          45
        //   510: lconst_0       
        //   511: lstore          46
        //   513: lload           46
        //   515: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   518: astore          13
        //   520: aload           12
        //   522: aload           13
        //   524: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   529: pop            
        //   530: lload           46
        //   532: lload           27
        //   534: lcmp           
        //   535: istore          5
        //   537: iload           5
        //   539: ifle            549
        //   542: goto            553
        //   545: aload           9
        //   547: astore          45
        //   549: lload           27
        //   551: lstore          46
        //   553: iload           31
        //   555: ifeq            657
        //   558: ldc             "&wf="
        //   560: astore          13
        //   562: aload           10
        //   564: aload           13
        //   566: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   569: pop            
        //   570: iload_3        
        //   571: ifeq            645
        //   574: new             Ljava/lang/StringBuffer;
        //   577: astore          33
        //   579: aload           33
        //   581: invokespecial   java/lang/StringBuffer.<init>:()V
        //   584: ldc             "&wf_ch="
        //   586: astore          13
        //   588: aload           33
        //   590: aload           13
        //   592: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   595: pop            
        //   596: aload           4
        //   598: getfield        com/baidu/location/b/g.a:Ljava/util/List;
        //   601: astore          13
        //   603: aload           13
        //   605: iload           30
        //   607: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   612: astore          13
        //   614: aload           13
        //   616: checkcast       Landroid/net/wifi/ScanResult;
        //   619: astore          13
        //   621: aload           13
        //   623: getfield        android/net/wifi/ScanResult.frequency:I
        //   626: istore          5
        //   628: aload           4
        //   630: iload           5
        //   632: invokevirtual   com/baidu/location/b/g.b:(I)I
        //   635: istore          5
        //   637: aload           33
        //   639: iload           5
        //   641: invokevirtual   java/lang/StringBuffer.append:(I)Ljava/lang/StringBuffer;
        //   644: pop            
        //   645: iconst_0       
        //   646: istore          31
        //   648: fconst_0       
        //   649: fstore          32
        //   651: aconst_null    
        //   652: astore          44
        //   654: goto            734
        //   657: ldc             "|"
        //   659: astore          13
        //   661: aload           10
        //   663: aload           13
        //   665: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   668: pop            
        //   669: iload_3        
        //   670: ifeq            734
        //   673: ldc             "|"
        //   675: astore          13
        //   677: aload           33
        //   679: aload           13
        //   681: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   684: pop            
        //   685: aload           4
        //   687: getfield        com/baidu/location/b/g.a:Ljava/util/List;
        //   690: astore          13
        //   692: aload           13
        //   694: iload           30
        //   696: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   701: astore          13
        //   703: aload           13
        //   705: checkcast       Landroid/net/wifi/ScanResult;
        //   708: astore          13
        //   710: aload           13
        //   712: getfield        android/net/wifi/ScanResult.frequency:I
        //   715: istore          5
        //   717: aload           4
        //   719: iload           5
        //   721: invokevirtual   com/baidu/location/b/g.b:(I)I
        //   724: istore          5
        //   726: aload           33
        //   728: iload           5
        //   730: invokevirtual   java/lang/StringBuffer.append:(I)Ljava/lang/StringBuffer;
        //   733: pop            
        //   734: aload           4
        //   736: getfield        com/baidu/location/b/g.a:Ljava/util/List;
        //   739: astore          13
        //   741: aload           13
        //   743: iload           30
        //   745: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   750: astore          13
        //   752: aload           13
        //   754: checkcast       Landroid/net/wifi/ScanResult;
        //   757: astore          13
        //   759: aload           13
        //   761: getfield        android/net/wifi/ScanResult.BSSID:Ljava/lang/String;
        //   764: astore          13
        //   766: aload           13
        //   768: ifnull          1496
        //   771: iload           6
        //   773: istore          37
        //   775: ldc             ":"
        //   777: astore          7
        //   779: lload           46
        //   781: lstore          50
        //   783: ldc             ""
        //   785: astore          52
        //   787: aload           13
        //   789: aload           7
        //   791: aload           52
        //   793: invokevirtual   java/lang/String.replace:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //   796: astore          13
        //   798: aload           10
        //   800: aload           13
        //   802: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   805: pop            
        //   806: aload           4
        //   808: getfield        com/baidu/location/b/g.a:Ljava/util/List;
        //   811: astore          7
        //   813: aload           7
        //   815: iload           30
        //   817: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   822: astore          7
        //   824: aload           7
        //   826: checkcast       Landroid/net/wifi/ScanResult;
        //   829: astore          7
        //   831: aload           7
        //   833: getfield        android/net/wifi/ScanResult.level:I
        //   836: istore          6
        //   838: iload           6
        //   840: ifge            848
        //   843: iload           6
        //   845: ineg           
        //   846: istore          6
        //   848: getstatic       java/util/Locale.CHINA:Ljava/util/Locale;
        //   851: astore          52
        //   853: ldc             ";%d;"
        //   855: astore          9
        //   857: iload           19
        //   859: istore          38
        //   861: fload           20
        //   863: fstore          39
        //   865: iload           31
        //   867: istore          42
        //   869: fload           32
        //   871: fstore          43
        //   873: iconst_1       
        //   874: istore          19
        //   876: ldc             1.4E-45
        //   878: fstore          20
        //   880: iload           19
        //   882: anewarray       Ljava/lang/Object;
        //   885: astore          44
        //   887: iload           6
        //   889: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   892: astore          7
        //   894: iconst_0       
        //   895: istore          19
        //   897: fconst_0       
        //   898: fstore          20
        //   900: aload           44
        //   902: iconst_0       
        //   903: aload           7
        //   905: aastore        
        //   906: aload           52
        //   908: aload           9
        //   910: aload           44
        //   912: invokestatic    java/lang/String.format:(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   915: astore          7
        //   917: aload           10
        //   919: aload           7
        //   921: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   924: pop            
        //   925: iload           34
        //   927: iconst_1       
        //   928: iadd           
        //   929: istore          6
        //   931: aload           14
        //   933: ifnull          1012
        //   936: aload           14
        //   938: aload           13
        //   940: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   943: istore          5
        //   945: iload           5
        //   947: ifeq            1012
        //   950: aload           4
        //   952: getfield        com/baidu/location/b/g.a:Ljava/util/List;
        //   955: astore          13
        //   957: aload           13
        //   959: iload           30
        //   961: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   966: astore          13
        //   968: aload           13
        //   970: checkcast       Landroid/net/wifi/ScanResult;
        //   973: astore          13
        //   975: aload           13
        //   977: getfield        android/net/wifi/ScanResult.capabilities:Ljava/lang/String;
        //   980: astore          13
        //   982: aload           4
        //   984: aload           13
        //   986: invokespecial   com/baidu/location/b/g.a:(Ljava/lang/String;)Z
        //   989: istore          5
        //   991: aload           4
        //   993: iload           5
        //   995: putfield        com/baidu/location/b/g.e:Z
        //   998: iload           6
        //  1000: istore          29
        //  1002: iconst_1       
        //  1003: istore          5
        //  1005: ldc             1.4E-45
        //  1007: fstore          11
        //  1009: goto            1021
        //  1012: iconst_0       
        //  1013: istore          5
        //  1015: fconst_0       
        //  1016: fstore          11
        //  1018: aconst_null    
        //  1019: astore          13
        //  1021: iload           5
        //  1023: ifne            1420
        //  1026: bipush          30
        //  1028: istore          5
        //  1030: ldc             4.2E-44
        //  1032: fstore          11
        //  1034: iconst_2       
        //  1035: istore          8
        //  1037: iload           35
        //  1039: istore          53
        //  1041: fload           36
        //  1043: fstore          54
        //  1045: iload           35
        //  1047: ifne            1225
        //  1050: bipush          10
        //  1052: istore          19
        //  1054: ldc             1.4E-44
        //  1056: fstore          20
        //  1058: aload           45
        //  1060: astore          44
        //  1062: aload           45
        //  1064: iload           19
        //  1066: invokevirtual   java/util/Random.nextInt:(I)I
        //  1069: istore          19
        //  1071: iload           19
        //  1073: iload           8
        //  1075: if_icmpne       1405
        //  1078: aload           4
        //  1080: getfield        com/baidu/location/b/g.a:Ljava/util/List;
        //  1083: astore          52
        //  1085: aload           52
        //  1087: iload           30
        //  1089: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1094: astore          52
        //  1096: aload           52
        //  1098: checkcast       Landroid/net/wifi/ScanResult;
        //  1101: astore          52
        //  1103: aload           52
        //  1105: getfield        android/net/wifi/ScanResult.SSID:Ljava/lang/String;
        //  1108: astore          52
        //  1110: aload           52
        //  1112: ifnull          1405
        //  1115: aload           4
        //  1117: getfield        com/baidu/location/b/g.a:Ljava/util/List;
        //  1120: astore          52
        //  1122: aload           52
        //  1124: iload           30
        //  1126: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1131: astore          52
        //  1133: aload           52
        //  1135: checkcast       Landroid/net/wifi/ScanResult;
        //  1138: astore          52
        //  1140: aload           52
        //  1142: getfield        android/net/wifi/ScanResult.SSID:Ljava/lang/String;
        //  1145: astore          52
        //  1147: aload           52
        //  1149: invokevirtual   java/lang/String.length:()I
        //  1152: istore          8
        //  1154: iload           8
        //  1156: iload           5
        //  1158: if_icmpge       1405
        //  1161: aload           4
        //  1163: getfield        com/baidu/location/b/g.a:Ljava/util/List;
        //  1166: astore          13
        //  1168: aload           13
        //  1170: iload           30
        //  1172: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1177: astore          13
        //  1179: aload           13
        //  1181: checkcast       Landroid/net/wifi/ScanResult;
        //  1184: astore          13
        //  1186: aload           13
        //  1188: getfield        android/net/wifi/ScanResult.SSID:Ljava/lang/String;
        //  1191: astore          13
        //  1193: aload           4
        //  1195: aload           13
        //  1197: invokespecial   com/baidu/location/b/g.b:(Ljava/lang/String;)Ljava/lang/String;
        //  1200: astore          13
        //  1202: aload           10
        //  1204: aload           13
        //  1206: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //  1209: pop            
        //  1210: iconst_1       
        //  1211: istore          35
        //  1213: ldc             1.4E-45
        //  1215: fstore          36
        //  1217: goto            1413
        //  1220: astore          13
        //  1222: goto            1481
        //  1225: aload           45
        //  1227: astore          44
        //  1229: iconst_1       
        //  1230: istore          19
        //  1232: ldc             1.4E-45
        //  1234: fstore          20
        //  1236: iload           35
        //  1238: iload           19
        //  1240: if_icmpne       1405
        //  1243: bipush          20
        //  1245: istore          8
        //  1247: aload           45
        //  1249: iload           8
        //  1251: invokevirtual   java/util/Random.nextInt:(I)I
        //  1254: istore          8
        //  1256: iload           8
        //  1258: iload           19
        //  1260: if_icmpne       1405
        //  1263: aload           4
        //  1265: getfield        com/baidu/location/b/g.a:Ljava/util/List;
        //  1268: astore          52
        //  1270: aload           52
        //  1272: iload           30
        //  1274: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1279: astore          52
        //  1281: aload           52
        //  1283: checkcast       Landroid/net/wifi/ScanResult;
        //  1286: astore          52
        //  1288: aload           52
        //  1290: getfield        android/net/wifi/ScanResult.SSID:Ljava/lang/String;
        //  1293: astore          52
        //  1295: aload           52
        //  1297: ifnull          1405
        //  1300: aload           4
        //  1302: getfield        com/baidu/location/b/g.a:Ljava/util/List;
        //  1305: astore          52
        //  1307: aload           52
        //  1309: iload           30
        //  1311: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1316: astore          52
        //  1318: aload           52
        //  1320: checkcast       Landroid/net/wifi/ScanResult;
        //  1323: astore          52
        //  1325: aload           52
        //  1327: getfield        android/net/wifi/ScanResult.SSID:Ljava/lang/String;
        //  1330: astore          52
        //  1332: aload           52
        //  1334: invokevirtual   java/lang/String.length:()I
        //  1337: istore          8
        //  1339: iload           8
        //  1341: iload           5
        //  1343: if_icmpge       1405
        //  1346: aload           4
        //  1348: getfield        com/baidu/location/b/g.a:Ljava/util/List;
        //  1351: astore          13
        //  1353: aload           13
        //  1355: iload           30
        //  1357: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1362: astore          13
        //  1364: aload           13
        //  1366: checkcast       Landroid/net/wifi/ScanResult;
        //  1369: astore          13
        //  1371: aload           13
        //  1373: getfield        android/net/wifi/ScanResult.SSID:Ljava/lang/String;
        //  1376: astore          13
        //  1378: aload           4
        //  1380: aload           13
        //  1382: invokespecial   com/baidu/location/b/g.b:(Ljava/lang/String;)Ljava/lang/String;
        //  1385: astore          13
        //  1387: aload           10
        //  1389: aload           13
        //  1391: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //  1394: pop            
        //  1395: iconst_2       
        //  1396: istore          35
        //  1398: ldc             2.8E-45
        //  1400: fstore          36
        //  1402: goto            1413
        //  1405: iload           53
        //  1407: istore          35
        //  1409: fload           54
        //  1411: fstore          36
        //  1413: iload           6
        //  1415: istore          34
        //  1417: goto            1532
        //  1420: iload           35
        //  1422: istore          53
        //  1424: fload           36
        //  1426: fstore          54
        //  1428: aload           45
        //  1430: astore          44
        //  1432: aload           4
        //  1434: getfield        com/baidu/location/b/g.a:Ljava/util/List;
        //  1437: astore          13
        //  1439: aload           13
        //  1441: iload           30
        //  1443: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1448: astore          13
        //  1450: aload           13
        //  1452: checkcast       Landroid/net/wifi/ScanResult;
        //  1455: astore          13
        //  1457: aload           13
        //  1459: getfield        android/net/wifi/ScanResult.SSID:Ljava/lang/String;
        //  1462: astore          13
        //  1464: aload           4
        //  1466: aload           13
        //  1468: invokespecial   com/baidu/location/b/g.b:(Ljava/lang/String;)Ljava/lang/String;
        //  1471: astore          13
        //  1473: aload           10
        //  1475: aload           13
        //  1477: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //  1480: pop            
        //  1481: iload           6
        //  1483: istore          34
        //  1485: iload           53
        //  1487: istore          35
        //  1489: fload           54
        //  1491: fstore          36
        //  1493: goto            1532
        //  1496: iload           6
        //  1498: istore          37
        //  1500: lload           46
        //  1502: lstore          50
        //  1504: iload           19
        //  1506: istore          38
        //  1508: fload           20
        //  1510: fstore          39
        //  1512: iload           31
        //  1514: istore          42
        //  1516: fload           32
        //  1518: fstore          43
        //  1520: iload           35
        //  1522: istore          53
        //  1524: fload           36
        //  1526: fstore          54
        //  1528: aload           45
        //  1530: astore          44
        //  1532: lload           50
        //  1534: lstore          40
        //  1536: iload           30
        //  1538: iconst_1       
        //  1539: iadd           
        //  1540: istore          30
        //  1542: aload           44
        //  1544: astore          9
        //  1546: iload           42
        //  1548: istore          31
        //  1550: fload           43
        //  1552: fstore          32
        //  1554: iload           38
        //  1556: istore          19
        //  1558: fload           39
        //  1560: fstore          20
        //  1562: lload           40
        //  1564: lstore          27
        //  1566: iload           37
        //  1568: istore          6
        //  1570: iconst_1       
        //  1571: istore          8
        //  1573: goto            361
        //  1576: astore          13
        //  1578: iconst_0       
        //  1579: istore          6
        //  1581: aconst_null    
        //  1582: astore          7
        //  1584: goto            2224
        //  1587: astore          13
        //  1589: iconst_0       
        //  1590: istore          6
        //  1592: aconst_null    
        //  1593: astore          7
        //  1595: goto            2228
        //  1598: iload           31
        //  1600: ifne            2220
        //  1603: new             Ljava/lang/StringBuilder;
        //  1606: astore          13
        //  1608: aload           13
        //  1610: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1613: ldc             "&wf_n="
        //  1615: astore          7
        //  1617: aload           13
        //  1619: aload           7
        //  1621: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1624: pop            
        //  1625: aload           13
        //  1627: iload           29
        //  1629: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //  1632: pop            
        //  1633: aload           13
        //  1635: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1638: astore          13
        //  1640: aload           10
        //  1642: aload           13
        //  1644: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //  1647: pop            
        //  1648: aload           14
        //  1650: ifnull          1708
        //  1653: iconst_m1      
        //  1654: istore          6
        //  1656: iload           17
        //  1658: iload           6
        //  1660: if_icmpeq       1708
        //  1663: new             Ljava/lang/StringBuilder;
        //  1666: astore          13
        //  1668: aload           13
        //  1670: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1673: ldc             "&wf_rs="
        //  1675: astore          7
        //  1677: aload           13
        //  1679: aload           7
        //  1681: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1684: pop            
        //  1685: aload           13
        //  1687: iload           17
        //  1689: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //  1692: pop            
        //  1693: aload           13
        //  1695: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1698: astore          13
        //  1700: aload           10
        //  1702: aload           13
        //  1704: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //  1707: pop            
        //  1708: bipush          10
        //  1710: i2l            
        //  1711: lstore          40
        //  1713: lload           27
        //  1715: lload           40
        //  1717: lcmp           
        //  1718: istore          5
        //  1720: iload           5
        //  1722: ifle            2025
        //  1725: aload           12
        //  1727: invokeinterface java/util/List.size:()I
        //  1732: istore          5
        //  1734: iload           5
        //  1736: ifle            2025
        //  1739: iconst_0       
        //  1740: istore          6
        //  1742: aconst_null    
        //  1743: astore          7
        //  1745: aload           12
        //  1747: iconst_0       
        //  1748: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1753: astore          13
        //  1755: aload           13
        //  1757: checkcast       Ljava/lang/Long;
        //  1760: astore          13
        //  1762: aload           13
        //  1764: invokevirtual   java/lang/Long.longValue:()J
        //  1767: lstore          40
        //  1769: lconst_0       
        //  1770: lstore          55
        //  1772: lload           40
        //  1774: lload           55
        //  1776: lcmp           
        //  1777: istore          5
        //  1779: iload           5
        //  1781: ifle            2025
        //  1784: new             Ljava/lang/StringBuffer;
        //  1787: astore          13
        //  1789: sipush          128
        //  1792: istore          6
        //  1794: aload           13
        //  1796: iload           6
        //  1798: invokespecial   java/lang/StringBuffer.<init>:(I)V
        //  1801: ldc_w           "&wf_ut="
        //  1804: astore          7
        //  1806: aload           13
        //  1808: aload           7
        //  1810: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //  1813: pop            
        //  1814: iconst_0       
        //  1815: istore          6
        //  1817: aconst_null    
        //  1818: astore          7
        //  1820: aload           12
        //  1822: iconst_0       
        //  1823: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1828: astore          52
        //  1830: aload           52
        //  1832: checkcast       Ljava/lang/Long;
        //  1835: astore          52
        //  1837: aload           12
        //  1839: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //  1844: astore          9
        //  1846: iconst_1       
        //  1847: istore          57
        //  1849: aload           9
        //  1851: invokeinterface java/util/Iterator.hasNext:()Z
        //  1856: istore          18
        //  1858: iload           18
        //  1860: ifeq            2007
        //  1863: aload           9
        //  1865: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //  1870: astore          14
        //  1872: aload           14
        //  1874: checkcast       Ljava/lang/Long;
        //  1877: astore          14
        //  1879: iload           57
        //  1881: ifeq            1911
        //  1884: aload           14
        //  1886: invokevirtual   java/lang/Long.longValue:()J
        //  1889: lstore          55
        //  1891: aload           13
        //  1893: lload           55
        //  1895: invokevirtual   java/lang/StringBuffer.append:(J)Ljava/lang/StringBuffer;
        //  1898: pop            
        //  1899: iconst_0       
        //  1900: istore          57
        //  1902: aconst_null    
        //  1903: astore          12
        //  1905: lconst_0       
        //  1906: lstore          58
        //  1908: goto            1992
        //  1911: aload           14
        //  1913: invokevirtual   java/lang/Long.longValue:()J
        //  1916: lstore          55
        //  1918: aload           52
        //  1920: invokevirtual   java/lang/Long.longValue:()J
        //  1923: lstore          58
        //  1925: lload           55
        //  1927: lload           58
        //  1929: lsub           
        //  1930: lstore          55
        //  1932: lconst_0       
        //  1933: lstore          58
        //  1935: lload           55
        //  1937: lload           58
        //  1939: lcmp           
        //  1940: istore          31
        //  1942: iload           31
        //  1944: ifeq            1992
        //  1947: new             Ljava/lang/StringBuilder;
        //  1950: astore          44
        //  1952: aload           44
        //  1954: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1957: ldc             ""
        //  1959: astore          60
        //  1961: aload           44
        //  1963: aload           60
        //  1965: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1968: pop            
        //  1969: aload           44
        //  1971: lload           55
        //  1973: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //  1976: pop            
        //  1977: aload           44
        //  1979: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1982: astore          14
        //  1984: aload           13
        //  1986: aload           14
        //  1988: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //  1991: pop            
        //  1992: ldc             "|"
        //  1994: astore          14
        //  1996: aload           13
        //  1998: aload           14
        //  2000: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //  2003: pop            
        //  2004: goto            1849
        //  2007: aload           13
        //  2009: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //  2012: astore          13
        //  2014: aload           10
        //  2016: aload           13
        //  2018: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //  2021: pop            
        //  2022: goto            2031
        //  2025: iconst_0       
        //  2026: istore          6
        //  2028: aconst_null    
        //  2029: astore          7
        //  2031: ldc_w           "&wf_st="
        //  2034: astore          13
        //  2036: aload           10
        //  2038: aload           13
        //  2040: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //  2043: pop            
        //  2044: aload           4
        //  2046: getfield        com/baidu/location/b/g.b:J
        //  2049: lstore          46
        //  2051: aload           10
        //  2053: lload           46
        //  2055: invokevirtual   java/lang/StringBuffer.append:(J)Ljava/lang/StringBuffer;
        //  2058: pop            
        //  2059: ldc_w           "&wf_et="
        //  2062: astore          13
        //  2064: aload           10
        //  2066: aload           13
        //  2068: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //  2071: pop            
        //  2072: aload           4
        //  2074: getfield        com/baidu/location/b/g.c:J
        //  2077: lstore          46
        //  2079: aload           10
        //  2081: lload           46
        //  2083: invokevirtual   java/lang/StringBuffer.append:(J)Ljava/lang/StringBuffer;
        //  2086: pop            
        //  2087: ldc_w           "&wf_vt="
        //  2090: astore          13
        //  2092: aload           10
        //  2094: aload           13
        //  2096: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //  2099: pop            
        //  2100: getstatic       com/baidu/location/b/h.a:J
        //  2103: lstore          46
        //  2105: aload           10
        //  2107: lload           46
        //  2109: invokevirtual   java/lang/StringBuffer.append:(J)Ljava/lang/StringBuffer;
        //  2112: pop            
        //  2113: iload           29
        //  2115: ifle            2168
        //  2118: iconst_1       
        //  2119: istore          19
        //  2121: ldc             1.4E-45
        //  2123: fstore          20
        //  2125: aload           4
        //  2127: iload           19
        //  2129: putfield        com/baidu/location/b/g.d:Z
        //  2132: ldc_w           "&wf_en="
        //  2135: astore          13
        //  2137: aload           10
        //  2139: aload           13
        //  2141: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //  2144: pop            
        //  2145: aload           4
        //  2147: getfield        com/baidu/location/b/g.e:Z
        //  2150: istore          5
        //  2152: iload           5
        //  2154: ifeq            2160
        //  2157: iconst_1       
        //  2158: istore          6
        //  2160: aload           10
        //  2162: iload           6
        //  2164: invokevirtual   java/lang/StringBuffer.append:(I)Ljava/lang/StringBuffer;
        //  2167: pop            
        //  2168: aload           16
        //  2170: ifnull          2194
        //  2173: ldc_w           "&wf_gw="
        //  2176: astore          13
        //  2178: aload           10
        //  2180: aload           13
        //  2182: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //  2185: pop            
        //  2186: aload           10
        //  2188: aload           16
        //  2190: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //  2193: pop            
        //  2194: aload           33
        //  2196: ifnull          2214
        //  2199: aload           33
        //  2201: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //  2204: astore          13
        //  2206: aload           10
        //  2208: aload           13
        //  2210: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //  2213: pop            
        //  2214: aload           10
        //  2216: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //  2219: areturn        
        //  2220: aconst_null    
        //  2221: areturn        
        //  2222: astore          13
        //  2224: aconst_null    
        //  2225: areturn        
        //  2226: astore          13
        //  2228: aconst_null    
        //  2229: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  27     30     2226   2228   Ljava/lang/Error;
        //  27     30     2222   2224   Ljava/lang/Exception;
        //  32     37     2226   2228   Ljava/lang/Error;
        //  32     37     2222   2224   Ljava/lang/Exception;
        //  37     40     2226   2228   Ljava/lang/Error;
        //  37     40     2222   2224   Ljava/lang/Exception;
        //  53     58     2226   2228   Ljava/lang/Error;
        //  53     58     2222   2224   Ljava/lang/Exception;
        //  58     61     2226   2228   Ljava/lang/Error;
        //  58     61     2222   2224   Ljava/lang/Exception;
        //  63     68     2226   2228   Ljava/lang/Error;
        //  63     68     2222   2224   Ljava/lang/Exception;
        //  68     71     2226   2228   Ljava/lang/Error;
        //  68     71     2222   2224   Ljava/lang/Exception;
        //  73     78     2226   2228   Ljava/lang/Error;
        //  73     78     2222   2224   Ljava/lang/Exception;
        //  85     90     2226   2228   Ljava/lang/Error;
        //  85     90     2222   2224   Ljava/lang/Exception;
        //  97     102    2226   2228   Ljava/lang/Error;
        //  97     102    2222   2224   Ljava/lang/Exception;
        //  116    121    2226   2228   Ljava/lang/Error;
        //  116    121    2222   2224   Ljava/lang/Exception;
        //  123    128    2226   2228   Ljava/lang/Error;
        //  123    128    2222   2224   Ljava/lang/Exception;
        //  130    133    2226   2228   Ljava/lang/Error;
        //  130    133    2222   2224   Ljava/lang/Exception;
        //  135    140    2226   2228   Ljava/lang/Error;
        //  135    140    2222   2224   Ljava/lang/Exception;
        //  175    178    2226   2228   Ljava/lang/Error;
        //  175    178    2222   2224   Ljava/lang/Exception;
        //  198    201    218    224    Ljava/lang/Error;
        //  198    201    2222   2224   Ljava/lang/Exception;
        //  210    213    218    224    Ljava/lang/Error;
        //  210    213    2222   2224   Ljava/lang/Exception;
        //  300    305    2226   2228   Ljava/lang/Error;
        //  300    305    2222   2224   Ljava/lang/Exception;
        //  307    314    2226   2228   Ljava/lang/Error;
        //  307    314    2222   2224   Ljava/lang/Exception;
        //  368    373    1587   1598   Ljava/lang/Error;
        //  368    373    1576   1587   Ljava/lang/Exception;
        //  377    384    1587   1598   Ljava/lang/Error;
        //  377    384    1576   1587   Ljava/lang/Exception;
        //  386    391    1587   1598   Ljava/lang/Error;
        //  386    391    1576   1587   Ljava/lang/Exception;
        //  393    398    1587   1598   Ljava/lang/Error;
        //  393    398    1576   1587   Ljava/lang/Exception;
        //  441    446    504    510    Ljava/lang/Exception;
        //  441    446    1587   1598   Ljava/lang/Error;
        //  450    457    504    510    Ljava/lang/Exception;
        //  450    457    1587   1598   Ljava/lang/Error;
        //  459    464    504    510    Ljava/lang/Exception;
        //  459    464    1587   1598   Ljava/lang/Error;
        //  470    475    499    504    Ljava/lang/Exception;
        //  470    475    1587   1598   Ljava/lang/Error;
        //  491    494    499    504    Ljava/lang/Exception;
        //  491    494    1587   1598   Ljava/lang/Error;
        //  513    518    1587   1598   Ljava/lang/Error;
        //  513    518    1576   1587   Ljava/lang/Exception;
        //  522    530    1587   1598   Ljava/lang/Error;
        //  522    530    1576   1587   Ljava/lang/Exception;
        //  564    570    1587   1598   Ljava/lang/Error;
        //  564    570    1576   1587   Ljava/lang/Exception;
        //  574    577    1587   1598   Ljava/lang/Error;
        //  574    577    1576   1587   Ljava/lang/Exception;
        //  579    584    1587   1598   Ljava/lang/Error;
        //  579    584    1576   1587   Ljava/lang/Exception;
        //  590    596    1587   1598   Ljava/lang/Error;
        //  590    596    1576   1587   Ljava/lang/Exception;
        //  596    601    1587   1598   Ljava/lang/Error;
        //  596    601    1576   1587   Ljava/lang/Exception;
        //  605    612    1587   1598   Ljava/lang/Error;
        //  605    612    1576   1587   Ljava/lang/Exception;
        //  614    619    1587   1598   Ljava/lang/Error;
        //  614    619    1576   1587   Ljava/lang/Exception;
        //  621    626    1587   1598   Ljava/lang/Error;
        //  621    626    1576   1587   Ljava/lang/Exception;
        //  630    635    1587   1598   Ljava/lang/Error;
        //  630    635    1576   1587   Ljava/lang/Exception;
        //  639    645    1587   1598   Ljava/lang/Error;
        //  639    645    1576   1587   Ljava/lang/Exception;
        //  663    669    1587   1598   Ljava/lang/Error;
        //  663    669    1576   1587   Ljava/lang/Exception;
        //  679    685    1587   1598   Ljava/lang/Error;
        //  679    685    1576   1587   Ljava/lang/Exception;
        //  685    690    1587   1598   Ljava/lang/Error;
        //  685    690    1576   1587   Ljava/lang/Exception;
        //  694    701    1587   1598   Ljava/lang/Error;
        //  694    701    1576   1587   Ljava/lang/Exception;
        //  703    708    1587   1598   Ljava/lang/Error;
        //  703    708    1576   1587   Ljava/lang/Exception;
        //  710    715    1587   1598   Ljava/lang/Error;
        //  710    715    1576   1587   Ljava/lang/Exception;
        //  719    724    1587   1598   Ljava/lang/Error;
        //  719    724    1576   1587   Ljava/lang/Exception;
        //  728    734    1587   1598   Ljava/lang/Error;
        //  728    734    1576   1587   Ljava/lang/Exception;
        //  734    739    1587   1598   Ljava/lang/Error;
        //  734    739    1576   1587   Ljava/lang/Exception;
        //  743    750    1587   1598   Ljava/lang/Error;
        //  743    750    1576   1587   Ljava/lang/Exception;
        //  752    757    1587   1598   Ljava/lang/Error;
        //  752    757    1576   1587   Ljava/lang/Exception;
        //  759    764    1587   1598   Ljava/lang/Error;
        //  759    764    1576   1587   Ljava/lang/Exception;
        //  791    796    1587   1598   Ljava/lang/Error;
        //  791    796    1576   1587   Ljava/lang/Exception;
        //  800    806    1587   1598   Ljava/lang/Error;
        //  800    806    1576   1587   Ljava/lang/Exception;
        //  806    811    1587   1598   Ljava/lang/Error;
        //  806    811    1576   1587   Ljava/lang/Exception;
        //  815    822    1587   1598   Ljava/lang/Error;
        //  815    822    1576   1587   Ljava/lang/Exception;
        //  824    829    1587   1598   Ljava/lang/Error;
        //  824    829    1576   1587   Ljava/lang/Exception;
        //  831    836    1587   1598   Ljava/lang/Error;
        //  831    836    1576   1587   Ljava/lang/Exception;
        //  848    851    1587   1598   Ljava/lang/Error;
        //  848    851    1576   1587   Ljava/lang/Exception;
        //  880    885    1587   1598   Ljava/lang/Error;
        //  880    885    1576   1587   Ljava/lang/Exception;
        //  887    892    1587   1598   Ljava/lang/Error;
        //  887    892    1576   1587   Ljava/lang/Exception;
        //  903    906    1587   1598   Ljava/lang/Error;
        //  903    906    1576   1587   Ljava/lang/Exception;
        //  910    915    1587   1598   Ljava/lang/Error;
        //  910    915    1576   1587   Ljava/lang/Exception;
        //  919    925    1587   1598   Ljava/lang/Error;
        //  919    925    1576   1587   Ljava/lang/Exception;
        //  938    943    1587   1598   Ljava/lang/Error;
        //  938    943    1576   1587   Ljava/lang/Exception;
        //  950    955    1587   1598   Ljava/lang/Error;
        //  950    955    1576   1587   Ljava/lang/Exception;
        //  959    966    1587   1598   Ljava/lang/Error;
        //  959    966    1576   1587   Ljava/lang/Exception;
        //  968    973    1587   1598   Ljava/lang/Error;
        //  968    973    1576   1587   Ljava/lang/Exception;
        //  975    980    1587   1598   Ljava/lang/Error;
        //  975    980    1576   1587   Ljava/lang/Exception;
        //  984    989    1587   1598   Ljava/lang/Error;
        //  984    989    1576   1587   Ljava/lang/Exception;
        //  993    998    1587   1598   Ljava/lang/Error;
        //  993    998    1576   1587   Ljava/lang/Exception;
        //  1064   1069   1220   1225   Ljava/lang/Exception;
        //  1064   1069   1587   1598   Ljava/lang/Error;
        //  1078   1083   1220   1225   Ljava/lang/Exception;
        //  1078   1083   1587   1598   Ljava/lang/Error;
        //  1087   1094   1220   1225   Ljava/lang/Exception;
        //  1087   1094   1587   1598   Ljava/lang/Error;
        //  1096   1101   1220   1225   Ljava/lang/Exception;
        //  1096   1101   1587   1598   Ljava/lang/Error;
        //  1103   1108   1220   1225   Ljava/lang/Exception;
        //  1103   1108   1587   1598   Ljava/lang/Error;
        //  1115   1120   1220   1225   Ljava/lang/Exception;
        //  1115   1120   1587   1598   Ljava/lang/Error;
        //  1124   1131   1220   1225   Ljava/lang/Exception;
        //  1124   1131   1587   1598   Ljava/lang/Error;
        //  1133   1138   1220   1225   Ljava/lang/Exception;
        //  1133   1138   1587   1598   Ljava/lang/Error;
        //  1140   1145   1220   1225   Ljava/lang/Exception;
        //  1140   1145   1587   1598   Ljava/lang/Error;
        //  1147   1152   1220   1225   Ljava/lang/Exception;
        //  1147   1152   1587   1598   Ljava/lang/Error;
        //  1161   1166   1220   1225   Ljava/lang/Exception;
        //  1161   1166   1587   1598   Ljava/lang/Error;
        //  1170   1177   1220   1225   Ljava/lang/Exception;
        //  1170   1177   1587   1598   Ljava/lang/Error;
        //  1179   1184   1220   1225   Ljava/lang/Exception;
        //  1179   1184   1587   1598   Ljava/lang/Error;
        //  1186   1191   1220   1225   Ljava/lang/Exception;
        //  1186   1191   1587   1598   Ljava/lang/Error;
        //  1195   1200   1220   1225   Ljava/lang/Exception;
        //  1195   1200   1587   1598   Ljava/lang/Error;
        //  1204   1210   1220   1225   Ljava/lang/Exception;
        //  1204   1210   1587   1598   Ljava/lang/Error;
        //  1249   1254   1220   1225   Ljava/lang/Exception;
        //  1249   1254   1587   1598   Ljava/lang/Error;
        //  1263   1268   1220   1225   Ljava/lang/Exception;
        //  1263   1268   1587   1598   Ljava/lang/Error;
        //  1272   1279   1220   1225   Ljava/lang/Exception;
        //  1272   1279   1587   1598   Ljava/lang/Error;
        //  1281   1286   1220   1225   Ljava/lang/Exception;
        //  1281   1286   1587   1598   Ljava/lang/Error;
        //  1288   1293   1220   1225   Ljava/lang/Exception;
        //  1288   1293   1587   1598   Ljava/lang/Error;
        //  1300   1305   1220   1225   Ljava/lang/Exception;
        //  1300   1305   1587   1598   Ljava/lang/Error;
        //  1309   1316   1220   1225   Ljava/lang/Exception;
        //  1309   1316   1587   1598   Ljava/lang/Error;
        //  1318   1323   1220   1225   Ljava/lang/Exception;
        //  1318   1323   1587   1598   Ljava/lang/Error;
        //  1325   1330   1220   1225   Ljava/lang/Exception;
        //  1325   1330   1587   1598   Ljava/lang/Error;
        //  1332   1337   1220   1225   Ljava/lang/Exception;
        //  1332   1337   1587   1598   Ljava/lang/Error;
        //  1346   1351   1220   1225   Ljava/lang/Exception;
        //  1346   1351   1587   1598   Ljava/lang/Error;
        //  1355   1362   1220   1225   Ljava/lang/Exception;
        //  1355   1362   1587   1598   Ljava/lang/Error;
        //  1364   1369   1220   1225   Ljava/lang/Exception;
        //  1364   1369   1587   1598   Ljava/lang/Error;
        //  1371   1376   1220   1225   Ljava/lang/Exception;
        //  1371   1376   1587   1598   Ljava/lang/Error;
        //  1380   1385   1220   1225   Ljava/lang/Exception;
        //  1380   1385   1587   1598   Ljava/lang/Error;
        //  1389   1395   1220   1225   Ljava/lang/Exception;
        //  1389   1395   1587   1598   Ljava/lang/Error;
        //  1432   1437   1587   1598   Ljava/lang/Error;
        //  1432   1437   1576   1587   Ljava/lang/Exception;
        //  1441   1448   1587   1598   Ljava/lang/Error;
        //  1441   1448   1576   1587   Ljava/lang/Exception;
        //  1450   1455   1587   1598   Ljava/lang/Error;
        //  1450   1455   1576   1587   Ljava/lang/Exception;
        //  1457   1462   1587   1598   Ljava/lang/Error;
        //  1457   1462   1576   1587   Ljava/lang/Exception;
        //  1466   1471   1587   1598   Ljava/lang/Error;
        //  1466   1471   1576   1587   Ljava/lang/Exception;
        //  1475   1481   1587   1598   Ljava/lang/Error;
        //  1475   1481   1576   1587   Ljava/lang/Exception;
        //  1603   1606   1587   1598   Ljava/lang/Error;
        //  1603   1606   1576   1587   Ljava/lang/Exception;
        //  1608   1613   1587   1598   Ljava/lang/Error;
        //  1608   1613   1576   1587   Ljava/lang/Exception;
        //  1619   1625   1587   1598   Ljava/lang/Error;
        //  1619   1625   1576   1587   Ljava/lang/Exception;
        //  1627   1633   1587   1598   Ljava/lang/Error;
        //  1627   1633   1576   1587   Ljava/lang/Exception;
        //  1633   1638   1587   1598   Ljava/lang/Error;
        //  1633   1638   1576   1587   Ljava/lang/Exception;
        //  1642   1648   1587   1598   Ljava/lang/Error;
        //  1642   1648   1576   1587   Ljava/lang/Exception;
        //  1663   1666   1587   1598   Ljava/lang/Error;
        //  1663   1666   1576   1587   Ljava/lang/Exception;
        //  1668   1673   1587   1598   Ljava/lang/Error;
        //  1668   1673   1576   1587   Ljava/lang/Exception;
        //  1679   1685   1587   1598   Ljava/lang/Error;
        //  1679   1685   1576   1587   Ljava/lang/Exception;
        //  1687   1693   1587   1598   Ljava/lang/Error;
        //  1687   1693   1576   1587   Ljava/lang/Exception;
        //  1693   1698   1587   1598   Ljava/lang/Error;
        //  1693   1698   1576   1587   Ljava/lang/Exception;
        //  1702   1708   1587   1598   Ljava/lang/Error;
        //  1702   1708   1576   1587   Ljava/lang/Exception;
        //  1725   1732   1587   1598   Ljava/lang/Error;
        //  1725   1732   1576   1587   Ljava/lang/Exception;
        //  1747   1753   1587   1598   Ljava/lang/Error;
        //  1747   1753   1576   1587   Ljava/lang/Exception;
        //  1755   1760   1587   1598   Ljava/lang/Error;
        //  1755   1760   1576   1587   Ljava/lang/Exception;
        //  1762   1767   1587   1598   Ljava/lang/Error;
        //  1762   1767   1576   1587   Ljava/lang/Exception;
        //  1784   1787   1587   1598   Ljava/lang/Error;
        //  1784   1787   1576   1587   Ljava/lang/Exception;
        //  1796   1801   1587   1598   Ljava/lang/Error;
        //  1796   1801   1576   1587   Ljava/lang/Exception;
        //  1808   1814   1587   1598   Ljava/lang/Error;
        //  1808   1814   1576   1587   Ljava/lang/Exception;
        //  1822   1828   1587   1598   Ljava/lang/Error;
        //  1822   1828   1576   1587   Ljava/lang/Exception;
        //  1830   1835   1587   1598   Ljava/lang/Error;
        //  1830   1835   1576   1587   Ljava/lang/Exception;
        //  1837   1844   1587   1598   Ljava/lang/Error;
        //  1837   1844   1576   1587   Ljava/lang/Exception;
        //  1849   1856   1587   1598   Ljava/lang/Error;
        //  1849   1856   1576   1587   Ljava/lang/Exception;
        //  1863   1870   1587   1598   Ljava/lang/Error;
        //  1863   1870   1576   1587   Ljava/lang/Exception;
        //  1872   1877   1587   1598   Ljava/lang/Error;
        //  1872   1877   1576   1587   Ljava/lang/Exception;
        //  1884   1889   1587   1598   Ljava/lang/Error;
        //  1884   1889   1576   1587   Ljava/lang/Exception;
        //  1893   1899   1587   1598   Ljava/lang/Error;
        //  1893   1899   1576   1587   Ljava/lang/Exception;
        //  1911   1916   1587   1598   Ljava/lang/Error;
        //  1911   1916   1576   1587   Ljava/lang/Exception;
        //  1918   1923   1587   1598   Ljava/lang/Error;
        //  1918   1923   1576   1587   Ljava/lang/Exception;
        //  1947   1950   1587   1598   Ljava/lang/Error;
        //  1947   1950   1576   1587   Ljava/lang/Exception;
        //  1952   1957   1587   1598   Ljava/lang/Error;
        //  1952   1957   1576   1587   Ljava/lang/Exception;
        //  1963   1969   1587   1598   Ljava/lang/Error;
        //  1963   1969   1576   1587   Ljava/lang/Exception;
        //  1971   1977   1587   1598   Ljava/lang/Error;
        //  1971   1977   1576   1587   Ljava/lang/Exception;
        //  1977   1982   1587   1598   Ljava/lang/Error;
        //  1977   1982   1576   1587   Ljava/lang/Exception;
        //  1986   1992   1587   1598   Ljava/lang/Error;
        //  1986   1992   1576   1587   Ljava/lang/Exception;
        //  1998   2004   1587   1598   Ljava/lang/Error;
        //  1998   2004   1576   1587   Ljava/lang/Exception;
        //  2007   2012   1587   1598   Ljava/lang/Error;
        //  2007   2012   1576   1587   Ljava/lang/Exception;
        //  2016   2022   1587   1598   Ljava/lang/Error;
        //  2016   2022   1576   1587   Ljava/lang/Exception;
        //  2038   2044   1587   1598   Ljava/lang/Error;
        //  2038   2044   1576   1587   Ljava/lang/Exception;
        //  2044   2049   1587   1598   Ljava/lang/Error;
        //  2044   2049   1576   1587   Ljava/lang/Exception;
        //  2053   2059   1587   1598   Ljava/lang/Error;
        //  2053   2059   1576   1587   Ljava/lang/Exception;
        //  2066   2072   1587   1598   Ljava/lang/Error;
        //  2066   2072   1576   1587   Ljava/lang/Exception;
        //  2072   2077   1587   1598   Ljava/lang/Error;
        //  2072   2077   1576   1587   Ljava/lang/Exception;
        //  2081   2087   1587   1598   Ljava/lang/Error;
        //  2081   2087   1576   1587   Ljava/lang/Exception;
        //  2094   2100   1587   1598   Ljava/lang/Error;
        //  2094   2100   1576   1587   Ljava/lang/Exception;
        //  2100   2103   1587   1598   Ljava/lang/Error;
        //  2100   2103   1576   1587   Ljava/lang/Exception;
        //  2107   2113   1587   1598   Ljava/lang/Error;
        //  2107   2113   1576   1587   Ljava/lang/Exception;
        //  2127   2132   1587   1598   Ljava/lang/Error;
        //  2127   2132   1576   1587   Ljava/lang/Exception;
        //  2139   2145   1587   1598   Ljava/lang/Error;
        //  2139   2145   1576   1587   Ljava/lang/Exception;
        //  2145   2150   1587   1598   Ljava/lang/Error;
        //  2145   2150   1576   1587   Ljava/lang/Exception;
        //  2162   2168   1587   1598   Ljava/lang/Error;
        //  2162   2168   1576   1587   Ljava/lang/Exception;
        //  2180   2186   1587   1598   Ljava/lang/Error;
        //  2180   2186   1576   1587   Ljava/lang/Exception;
        //  2188   2194   1587   1598   Ljava/lang/Error;
        //  2188   2194   1576   1587   Ljava/lang/Exception;
        //  2199   2204   1587   1598   Ljava/lang/Error;
        //  2199   2204   1576   1587   Ljava/lang/Exception;
        //  2208   2214   1587   1598   Ljava/lang/Error;
        //  2208   2214   1576   1587   Ljava/lang/Exception;
        //  2214   2219   1587   1598   Ljava/lang/Error;
        //  2214   2219   1576   1587   Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 1039, Size: 1039
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:657)
        //     at java.util.ArrayList.get(ArrayList.java:433)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3303)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3551)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
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
    
    public boolean a(final long n) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        boolean b = true;
        final long n2 = 1000L;
        final long n3 = 0L;
        int n5 = 0;
        boolean b2 = false;
        Label_0091: {
            if (sdk_INT >= 17) {
                long n4 = 0L;
                Label_0055: {
                    try {
                        n4 = SystemClock.elapsedRealtimeNanos() / n2;
                        break Label_0055;
                    }
                    catch (Exception ex) {}
                    catch (Error error) {}
                    n4 = n3;
                }
                if (n4 > n3) {
                    n5 = (int)n4;
                    b2 = true;
                    break Label_0091;
                }
                n5 = (int)n4;
            }
            else {
                n5 = (int)n3;
            }
            b2 = false;
        }
        if (!b2) {
            return false;
        }
        final List a = this.a;
        if (a != null && a.size() != 0) {
            final int size = this.a.size();
            int n6 = 16;
            if (size <= n6) {
                n6 = size;
            }
            long n7 = n3;
            long n8 = n3;
            for (int i = 0; i < n6; ++i) {
                if (((ScanResult)this.a.get(i)).level != 0) {
                    if (b2) {
                        try {
                            final Object value = this.a.get(i);
                            try {
                                final ScanResult scanResult = (ScanResult)value;
                                try {
                                    final long n9 = (n5 - scanResult.timestamp) / 1000000L;
                                }
                                catch (Error error2) {}
                                catch (Exception ex2) {}
                            }
                            catch (Error error3) {}
                            catch (Exception ex3) {}
                        }
                        catch (Error error4) {}
                        catch (Exception ex4) {}
                        final long n9 = 0L;
                        n7 += n9;
                        if (n9 > n8) {
                            n8 = n9;
                        }
                    }
                }
            }
            final long n10 = n7 / n6;
            if (n8 * n2 <= n) {
                if (n10 * n2 <= n) {
                    b = false;
                }
            }
            return b;
        }
        return false;
    }
    
    public boolean a(final g g) {
        final List a = this.a;
        if (a != null && g != null && g.a != null) {
            List list;
            if (a.size() < g.a.size()) {
                list = this.a;
            }
            else {
                list = g.a;
            }
            for (int size = list.size(), i = 0; i < size; ++i) {
                if (!((ScanResult)this.a.get(i)).BSSID.equals(((ScanResult)g.a.get(i)).BSSID)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public int b(final int n) {
        if (n > 2400 && n < 2500) {
            return 2;
        }
        if (n > 4900 && n < 5900) {
            return 5;
        }
        return 0;
    }
    
    public String b() {
        try {
            final int n = j.N;
            final boolean b = true;
            return this.a(n, b, b);
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public boolean b(final g g) {
        final List a = this.a;
        if (a != null && g != null && g.a != null) {
            List list;
            if (a.size() < g.a.size()) {
                list = this.a;
            }
            else {
                list = g.a;
            }
            for (int size = list.size(), i = 0; i < size; ++i) {
                final String bssid = this.a.get(i).BSSID;
                final int level = this.a.get(i).level;
                final String bssid2 = g.a.get(i).BSSID;
                final int level2 = g.a.get(i).level;
                if (!bssid.equals(bssid2) || level != level2) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public String c() {
        try {
            return this.a(j.N, true, false);
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public String c(final int n) {
        if (n != 0) {
            final int a = this.a();
            int n2 = 1;
            if (a >= n2) {
                final StringBuffer sb = new StringBuffer(256);
                int n3 = this.a.size();
                if (n3 > j.N) {
                    n3 = j.N;
                }
                int i = 0;
                int n4 = 0;
                while (i < n3) {
                    if ((n2 & n) != 0x0 && ((ScanResult)this.a.get(i)).BSSID != null) {
                        String s;
                        if (n4 == 0) {
                            s = "&ssid=";
                        }
                        else {
                            s = "|";
                        }
                        sb.append(s);
                        sb.append(((ScanResult)this.a.get(i)).BSSID.replace(":", ""));
                        sb.append(";");
                        sb.append(this.b(((ScanResult)this.a.get(i)).SSID));
                        ++n4;
                    }
                    n2 <<= 1;
                    ++i;
                }
                return sb.toString();
            }
        }
        return null;
    }
    
    public boolean c(final g g) {
        return h.a(g, this);
    }
    
    public String d() {
        final int n = 15;
        try {
            return this.a(n);
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public boolean e() {
        return this.a((long)j.ae);
    }
    
    public long f() {
        final List a = this.a;
        final long n = 0L;
        if (a != null && a.size() != 0) {
            final int sdk_INT = Build$VERSION.SDK_INT;
            final int n2 = 17;
            int n3 = 0;
            long n4 = 0L;
            boolean b = false;
            Label_0102: {
                if (sdk_INT >= n2) {
                    Label_0076: {
                        try {
                            n4 = SystemClock.elapsedRealtimeNanos() / 1000L;
                            break Label_0076;
                        }
                        catch (Exception ex) {}
                        catch (Error error) {}
                        n4 = n;
                    }
                    if (n4 > n) {
                        b = true;
                        break Label_0102;
                    }
                }
                else {
                    n4 = n;
                }
                b = false;
            }
            final int size = this.a.size();
            int n5 = 16;
            if (size <= n5) {
                n5 = size;
            }
            int n6 = (int)n;
            long n7 = n;
            long n8 = n;
            long n9;
            while (true) {
                n9 = 1L;
                if (n3 >= n5) {
                    break;
                }
                if (((ScanResult)this.a.get(n3)).level != 0) {
                    if (b) {
                        try {
                            final Object value = this.a.get(n3);
                            try {
                                final ScanResult scanResult = (ScanResult)value;
                                try {
                                    final long n10 = (n4 - scanResult.timestamp) / 1000000L;
                                }
                                catch (Error error2) {}
                                catch (Exception ex2) {}
                            }
                            catch (Error error3) {}
                            catch (Exception ex3) {}
                        }
                        catch (Error error4) {}
                        catch (Exception ex4) {}
                        final long n10 = 0L;
                        n8 += n10;
                        n6 += (int)n9;
                        if (n10 > n7) {
                            n7 = n10;
                        }
                    }
                }
                ++n3;
            }
            if (n6 > n9) {
                n7 = (n8 - n7) / (n6 - n9);
            }
            return n7;
        }
        return n;
    }
    
    public int g() {
        for (int i = 0; i < this.a(); ++i) {
            final int n = -this.a.get(i).level;
            if (n > 0) {
                return n;
            }
        }
        return 0;
    }
    
    public boolean h() {
        return this.d;
    }
    
    public boolean i() {
        return System.currentTimeMillis() - this.c > 0L && System.currentTimeMillis() - this.c < 5000L;
    }
    
    public boolean j() {
        return System.currentTimeMillis() - this.c > 0L && System.currentTimeMillis() - this.c < 5000L;
    }
    
    public boolean k() {
        return System.currentTimeMillis() - this.c > 0L && System.currentTimeMillis() - this.b < 5000L;
    }
}
