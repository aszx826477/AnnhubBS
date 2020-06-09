// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.lbsapi.auth;

import java.net.URLConnection;
import java.net.MalformedURLException;
import javax.net.ssl.HostnameVerifier;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Iterator;
import java.net.URLEncoder;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import java.util.HashMap;
import android.content.Context;

public class g
{
    private Context a;
    private String b;
    private HashMap c;
    private String d;
    
    public g(final Context a) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.a = a;
    }
    
    private String a(final Context context) {
        String s = "wifi";
        final String s2 = "connectivity";
        try {
            final Object systemService = context.getSystemService(s2);
            try {
                final ConnectivityManager connectivityManager = (ConnectivityManager)systemService;
                if (connectivityManager == null) {
                    return null;
                }
                final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                Label_0199: {
                    if (activeNetworkInfo == null || activeNetworkInfo.isAvailable()) {
                        break Label_0199;
                    }
                    final String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (extraInfo == null) {
                        return s;
                    }
                    final String trim = extraInfo.trim();
                    try {
                        Label_0163: {
                            if (trim.toLowerCase().equals("cmwap")) {
                                break Label_0163;
                            }
                            final String trim2 = extraInfo.trim();
                            try {
                                if (trim2.toLowerCase().equals("uniwap")) {
                                    break Label_0163;
                                }
                                final String trim3 = extraInfo.trim();
                                try {
                                    if (trim3.toLowerCase().equals("3gwap")) {
                                        break Label_0163;
                                    }
                                    final String trim4 = extraInfo.trim();
                                    try {
                                        if (!trim4.toLowerCase().equals("ctwap")) {
                                            return s;
                                        }
                                        final String trim5 = extraInfo.trim();
                                        try {
                                            if (trim5.toLowerCase().equals("ctwap")) {
                                                s = "ctwap";
                                            }
                                            else {
                                                s = "cmwap";
                                            }
                                            return s;
                                            return null;
                                        }
                                        catch (Exception ex) {
                                            if (com.baidu.lbsapi.auth.a.a) {
                                                ex.printStackTrace();
                                            }
                                            return null;
                                        }
                                    }
                                    catch (Exception ex2) {}
                                }
                                catch (Exception ex3) {}
                            }
                            catch (Exception ex4) {}
                        }
                    }
                    catch (Exception ex5) {}
                }
            }
            catch (Exception ex6) {}
        }
        catch (Exception ex7) {}
    }
    
    private void a(final HttpsURLConnection p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/lang/StringBuilder;
        //     3: astore_2       
        //     4: aload_2        
        //     5: invokespecial   java/lang/StringBuilder.<init>:()V
        //     8: aload_2        
        //     9: ldc             "https Post start,url:"
        //    11: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    14: pop            
        //    15: aload_0        
        //    16: getfield        com/baidu/lbsapi/auth/g.b:Ljava/lang/String;
        //    19: astore_3       
        //    20: aload_2        
        //    21: aload_3        
        //    22: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    25: pop            
        //    26: aload_2        
        //    27: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    30: invokestatic    com/baidu/lbsapi/auth/a.a:(Ljava/lang/String;)V
        //    33: aload_0        
        //    34: getfield        com/baidu/lbsapi/auth/g.c:Ljava/util/HashMap;
        //    37: astore_2       
        //    38: aload_2        
        //    39: ifnonnull       54
        //    42: ldc             "httpsPost request paramters is null."
        //    44: invokestatic    com/baidu/lbsapi/auth/ErrorMessage.a:(Ljava/lang/String;)Ljava/lang/String;
        //    47: astore_1       
        //    48: aload_0        
        //    49: aload_1        
        //    50: putfield        com/baidu/lbsapi/auth/g.d:Ljava/lang/String;
        //    53: return         
        //    54: iconst_1       
        //    55: istore          4
        //    57: sipush          200
        //    60: istore          5
        //    62: iconst_m1      
        //    63: istore          6
        //    65: aconst_null    
        //    66: astore          7
        //    68: iconst_0       
        //    69: istore          8
        //    71: bipush          -11
        //    73: istore          9
        //    75: aload_1        
        //    76: invokevirtual   javax/net/ssl/HttpsURLConnection.getOutputStream:()Ljava/io/OutputStream;
        //    79: astore          10
        //    81: new             Ljava/io/BufferedWriter;
        //    84: astore          11
        //    86: new             Ljava/io/OutputStreamWriter;
        //    89: astore          12
        //    91: ldc             "UTF-8"
        //    93: astore          13
        //    95: aload           12
        //    97: aload           10
        //    99: aload           13
        //   101: invokespecial   java/io/OutputStreamWriter.<init>:(Ljava/io/OutputStream;Ljava/lang/String;)V
        //   104: aload           11
        //   106: aload           12
        //   108: invokespecial   java/io/BufferedWriter.<init>:(Ljava/io/Writer;)V
        //   111: aload_0        
        //   112: getfield        com/baidu/lbsapi/auth/g.c:Ljava/util/HashMap;
        //   115: astore          12
        //   117: aload           12
        //   119: invokestatic    com/baidu/lbsapi/auth/g.b:(Ljava/util/HashMap;)Ljava/lang/String;
        //   122: astore          12
        //   124: aload           11
        //   126: aload           12
        //   128: invokevirtual   java/io/BufferedWriter.write:(Ljava/lang/String;)V
        //   131: aload_0        
        //   132: getfield        com/baidu/lbsapi/auth/g.c:Ljava/util/HashMap;
        //   135: astore          12
        //   137: aload           12
        //   139: invokestatic    com/baidu/lbsapi/auth/g.b:(Ljava/util/HashMap;)Ljava/lang/String;
        //   142: astore          12
        //   144: aload           12
        //   146: invokestatic    com/baidu/lbsapi/auth/a.a:(Ljava/lang/String;)V
        //   149: aload           11
        //   151: invokevirtual   java/io/BufferedWriter.flush:()V
        //   154: aload           11
        //   156: invokevirtual   java/io/BufferedWriter.close:()V
        //   159: aload_1        
        //   160: invokevirtual   javax/net/ssl/HttpsURLConnection.connect:()V
        //   163: aload_1        
        //   164: invokevirtual   javax/net/ssl/HttpsURLConnection.getInputStream:()Ljava/io/InputStream;
        //   167: astore          11
        //   169: aload_1        
        //   170: invokevirtual   javax/net/ssl/HttpsURLConnection.getResponseCode:()I
        //   173: istore          14
        //   175: iload           5
        //   177: iload           14
        //   179: if_icmpne       302
        //   182: new             Ljava/io/BufferedReader;
        //   185: astore          13
        //   187: new             Ljava/io/InputStreamReader;
        //   190: astore          15
        //   192: ldc             "UTF-8"
        //   194: astore          16
        //   196: aload           15
        //   198: aload           11
        //   200: aload           16
        //   202: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/lang/String;)V
        //   205: aload           13
        //   207: aload           15
        //   209: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //   212: new             Ljava/lang/StringBuffer;
        //   215: astore          7
        //   217: aload           7
        //   219: invokespecial   java/lang/StringBuffer.<init>:()V
        //   222: aload           13
        //   224: invokevirtual   java/io/BufferedReader.read:()I
        //   227: istore          17
        //   229: iload           17
        //   231: iload           6
        //   233: if_icmpeq       252
        //   236: iload           17
        //   238: i2c            
        //   239: istore          17
        //   241: aload           7
        //   243: iload           17
        //   245: invokevirtual   java/lang/StringBuffer.append:(C)Ljava/lang/StringBuffer;
        //   248: pop            
        //   249: goto            222
        //   252: aload           7
        //   254: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //   257: astore          7
        //   259: aload_0        
        //   260: aload           7
        //   262: putfield        com/baidu/lbsapi/auth/g.d:Ljava/lang/String;
        //   265: aload           13
        //   267: astore          7
        //   269: goto            302
        //   272: astore_2       
        //   273: goto            284
        //   276: astore_2       
        //   277: goto            295
        //   280: astore_2       
        //   281: aconst_null    
        //   282: astore          13
        //   284: aload           11
        //   286: astore          7
        //   288: goto            549
        //   291: astore_2       
        //   292: aconst_null    
        //   293: astore          13
        //   295: aload           11
        //   297: astore          7
        //   299: goto            375
        //   302: aload           11
        //   304: ifnull          322
        //   307: aload           7
        //   309: ifnull          322
        //   312: aload           7
        //   314: invokevirtual   java/io/BufferedReader.close:()V
        //   317: aload           11
        //   319: invokevirtual   java/io/InputStream.close:()V
        //   322: aload_1        
        //   323: ifnull          330
        //   326: aload_1        
        //   327: invokevirtual   javax/net/ssl/HttpsURLConnection.disconnect:()V
        //   330: iconst_1       
        //   331: istore          8
        //   333: goto            517
        //   336: astore_2       
        //   337: aconst_null    
        //   338: astore          13
        //   340: aload           11
        //   342: astore          7
        //   344: goto            362
        //   347: astore_2       
        //   348: aconst_null    
        //   349: astore          13
        //   351: aload           11
        //   353: astore          7
        //   355: goto            372
        //   358: astore_2       
        //   359: aconst_null    
        //   360: astore          13
        //   362: iconst_m1      
        //   363: istore          14
        //   365: goto            549
        //   368: astore_2       
        //   369: aconst_null    
        //   370: astore          13
        //   372: iconst_m1      
        //   373: istore          14
        //   375: getstatic       com/baidu/lbsapi/auth/a.a:Z
        //   378: istore          18
        //   380: iload           18
        //   382: ifeq            437
        //   385: aload_2        
        //   386: invokevirtual   java/io/IOException.printStackTrace:()V
        //   389: new             Ljava/lang/StringBuilder;
        //   392: astore          11
        //   394: aload           11
        //   396: invokespecial   java/lang/StringBuilder.<init>:()V
        //   399: ldc             "httpsPost parse failed;"
        //   401: astore          15
        //   403: aload           11
        //   405: aload           15
        //   407: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   410: pop            
        //   411: aload_2        
        //   412: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   415: astore          15
        //   417: aload           11
        //   419: aload           15
        //   421: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   424: pop            
        //   425: aload           11
        //   427: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   430: astore          11
        //   432: aload           11
        //   434: invokestatic    com/baidu/lbsapi/auth/a.a:(Ljava/lang/String;)V
        //   437: new             Ljava/lang/StringBuilder;
        //   440: astore          11
        //   442: aload           11
        //   444: invokespecial   java/lang/StringBuilder.<init>:()V
        //   447: ldc             "httpsPost failed,IOException:"
        //   449: astore          15
        //   451: aload           11
        //   453: aload           15
        //   455: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   458: pop            
        //   459: aload_2        
        //   460: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   463: astore_2       
        //   464: aload           11
        //   466: aload_2        
        //   467: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   470: pop            
        //   471: aload           11
        //   473: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   476: astore_2       
        //   477: iload           9
        //   479: aload_2        
        //   480: invokestatic    com/baidu/lbsapi/auth/ErrorMessage.a:(ILjava/lang/String;)Ljava/lang/String;
        //   483: astore_2       
        //   484: aload_0        
        //   485: aload_2        
        //   486: putfield        com/baidu/lbsapi/auth/g.d:Ljava/lang/String;
        //   489: aload           7
        //   491: ifnull          509
        //   494: aload           13
        //   496: ifnull          509
        //   499: aload           13
        //   501: invokevirtual   java/io/BufferedReader.close:()V
        //   504: aload           7
        //   506: invokevirtual   java/io/InputStream.close:()V
        //   509: aload_1        
        //   510: ifnull          517
        //   513: aload_1        
        //   514: invokevirtual   javax/net/ssl/HttpsURLConnection.disconnect:()V
        //   517: aload           10
        //   519: ifnull          915
        //   522: aload           10
        //   524: invokevirtual   java/io/OutputStream.close:()V
        //   527: goto            915
        //   530: astore_1       
        //   531: getstatic       com/baidu/lbsapi/auth/a.a:Z
        //   534: istore          4
        //   536: iload           4
        //   538: ifeq            915
        //   541: aload_1        
        //   542: invokevirtual   java/io/IOException.printStackTrace:()V
        //   545: goto            915
        //   548: astore_2       
        //   549: aload           7
        //   551: ifnull          569
        //   554: aload           13
        //   556: ifnull          569
        //   559: aload           13
        //   561: invokevirtual   java/io/BufferedReader.close:()V
        //   564: aload           7
        //   566: invokevirtual   java/io/InputStream.close:()V
        //   569: aload_1        
        //   570: ifnull          577
        //   573: aload_1        
        //   574: invokevirtual   javax/net/ssl/HttpsURLConnection.disconnect:()V
        //   577: aload_2        
        //   578: athrow         
        //   579: astore_1       
        //   580: aload           10
        //   582: astore          7
        //   584: goto            643
        //   587: astore_1       
        //   588: aload           10
        //   590: astore          7
        //   592: goto            735
        //   595: astore_1       
        //   596: aload           10
        //   598: astore          7
        //   600: goto            827
        //   603: astore_1       
        //   604: aload           10
        //   606: astore          7
        //   608: goto            1058
        //   611: astore_1       
        //   612: aload           10
        //   614: astore          7
        //   616: goto            640
        //   619: astore_1       
        //   620: aload           10
        //   622: astore          7
        //   624: goto            732
        //   627: astore_1       
        //   628: aload           10
        //   630: astore          7
        //   632: goto            824
        //   635: astore_1       
        //   636: goto            1058
        //   639: astore_1       
        //   640: iconst_m1      
        //   641: istore          14
        //   643: getstatic       com/baidu/lbsapi/auth/a.a:Z
        //   646: istore          4
        //   648: iload           4
        //   650: ifeq            657
        //   653: aload_1        
        //   654: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   657: new             Ljava/lang/StringBuilder;
        //   660: astore_2       
        //   661: aload_2        
        //   662: invokespecial   java/lang/StringBuilder.<init>:()V
        //   665: ldc             "httpsPost failed,Exception:"
        //   667: astore          10
        //   669: aload_2        
        //   670: aload           10
        //   672: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   675: pop            
        //   676: aload_1        
        //   677: invokevirtual   java/lang/Exception.getMessage:()Ljava/lang/String;
        //   680: astore_1       
        //   681: aload_2        
        //   682: aload_1        
        //   683: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   686: pop            
        //   687: aload_2        
        //   688: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   691: astore_1       
        //   692: iload           9
        //   694: aload_1        
        //   695: invokestatic    com/baidu/lbsapi/auth/ErrorMessage.a:(ILjava/lang/String;)Ljava/lang/String;
        //   698: astore_1       
        //   699: aload_0        
        //   700: aload_1        
        //   701: putfield        com/baidu/lbsapi/auth/g.d:Ljava/lang/String;
        //   704: aload           7
        //   706: ifnull          915
        //   709: aload           7
        //   711: invokevirtual   java/io/OutputStream.close:()V
        //   714: goto            915
        //   717: astore_1       
        //   718: getstatic       com/baidu/lbsapi/auth/a.a:Z
        //   721: istore          4
        //   723: iload           4
        //   725: ifeq            915
        //   728: goto            541
        //   731: astore_1       
        //   732: iconst_m1      
        //   733: istore          14
        //   735: getstatic       com/baidu/lbsapi/auth/a.a:Z
        //   738: istore          4
        //   740: iload           4
        //   742: ifeq            749
        //   745: aload_1        
        //   746: invokevirtual   java/io/IOException.printStackTrace:()V
        //   749: new             Ljava/lang/StringBuilder;
        //   752: astore_2       
        //   753: aload_2        
        //   754: invokespecial   java/lang/StringBuilder.<init>:()V
        //   757: ldc             "httpsPost failed,IOException:"
        //   759: astore          10
        //   761: aload_2        
        //   762: aload           10
        //   764: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   767: pop            
        //   768: aload_1        
        //   769: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   772: astore_1       
        //   773: aload_2        
        //   774: aload_1        
        //   775: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   778: pop            
        //   779: aload_2        
        //   780: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   783: astore_1       
        //   784: iload           9
        //   786: aload_1        
        //   787: invokestatic    com/baidu/lbsapi/auth/ErrorMessage.a:(ILjava/lang/String;)Ljava/lang/String;
        //   790: astore_1       
        //   791: aload_0        
        //   792: aload_1        
        //   793: putfield        com/baidu/lbsapi/auth/g.d:Ljava/lang/String;
        //   796: aload           7
        //   798: ifnull          915
        //   801: aload           7
        //   803: invokevirtual   java/io/OutputStream.close:()V
        //   806: goto            915
        //   809: astore_1       
        //   810: getstatic       com/baidu/lbsapi/auth/a.a:Z
        //   813: istore          4
        //   815: iload           4
        //   817: ifeq            915
        //   820: goto            541
        //   823: astore_1       
        //   824: iconst_m1      
        //   825: istore          14
        //   827: getstatic       com/baidu/lbsapi/auth/a.a:Z
        //   830: istore          4
        //   832: iload           4
        //   834: ifeq            841
        //   837: aload_1        
        //   838: invokevirtual   java/net/MalformedURLException.printStackTrace:()V
        //   841: new             Ljava/lang/StringBuilder;
        //   844: astore_2       
        //   845: aload_2        
        //   846: invokespecial   java/lang/StringBuilder.<init>:()V
        //   849: ldc             "httpsPost failed,MalformedURLException:"
        //   851: astore          10
        //   853: aload_2        
        //   854: aload           10
        //   856: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   859: pop            
        //   860: aload_1        
        //   861: invokevirtual   java/net/MalformedURLException.getMessage:()Ljava/lang/String;
        //   864: astore_1       
        //   865: aload_2        
        //   866: aload_1        
        //   867: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   870: pop            
        //   871: aload_2        
        //   872: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   875: astore_1       
        //   876: iload           9
        //   878: aload_1        
        //   879: invokestatic    com/baidu/lbsapi/auth/ErrorMessage.a:(ILjava/lang/String;)Ljava/lang/String;
        //   882: astore_1       
        //   883: aload_0        
        //   884: aload_1        
        //   885: putfield        com/baidu/lbsapi/auth/g.d:Ljava/lang/String;
        //   888: aload           7
        //   890: ifnull          915
        //   893: aload           7
        //   895: invokevirtual   java/io/OutputStream.close:()V
        //   898: goto            915
        //   901: astore_1       
        //   902: getstatic       com/baidu/lbsapi/auth/a.a:Z
        //   905: istore          4
        //   907: iload           4
        //   909: ifeq            915
        //   912: goto            541
        //   915: iload           8
        //   917: ifeq            996
        //   920: iload           5
        //   922: iload           14
        //   924: if_icmpeq       996
        //   927: new             Ljava/lang/StringBuilder;
        //   930: astore_1       
        //   931: aload_1        
        //   932: invokespecial   java/lang/StringBuilder.<init>:()V
        //   935: aload_1        
        //   936: ldc             "httpsPost failed,statusCode:"
        //   938: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   941: pop            
        //   942: aload_1        
        //   943: iload           14
        //   945: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   948: pop            
        //   949: aload_1        
        //   950: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   953: invokestatic    com/baidu/lbsapi/auth/a.a:(Ljava/lang/String;)V
        //   956: new             Ljava/lang/StringBuilder;
        //   959: astore_1       
        //   960: aload_1        
        //   961: invokespecial   java/lang/StringBuilder.<init>:()V
        //   964: aload_1        
        //   965: ldc             "httpsPost failed,statusCode:"
        //   967: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   970: pop            
        //   971: aload_1        
        //   972: iload           14
        //   974: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   977: pop            
        //   978: aload_1        
        //   979: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   982: astore_1       
        //   983: iload           9
        //   985: aload_1        
        //   986: invokestatic    com/baidu/lbsapi/auth/ErrorMessage.a:(ILjava/lang/String;)Ljava/lang/String;
        //   989: astore_1       
        //   990: aload_0        
        //   991: aload_1        
        //   992: putfield        com/baidu/lbsapi/auth/g.d:Ljava/lang/String;
        //   995: return         
        //   996: aload_0        
        //   997: getfield        com/baidu/lbsapi/auth/g.d:Ljava/lang/String;
        //  1000: astore_1       
        //  1001: aload_1        
        //  1002: ifnonnull       1024
        //  1005: ldc             "httpsPost failed,mResult is null"
        //  1007: invokestatic    com/baidu/lbsapi/auth/a.a:(Ljava/lang/String;)V
        //  1010: iload           6
        //  1012: ldc             "httpsPost failed,internal error"
        //  1014: invokestatic    com/baidu/lbsapi/auth/ErrorMessage.a:(ILjava/lang/String;)Ljava/lang/String;
        //  1017: astore_1       
        //  1018: aload_0        
        //  1019: aload_1        
        //  1020: putfield        com/baidu/lbsapi/auth/g.d:Ljava/lang/String;
        //  1023: return         
        //  1024: new             Ljava/lang/StringBuilder;
        //  1027: astore_1       
        //  1028: aload_1        
        //  1029: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1032: aload_1        
        //  1033: ldc             "httpsPost success end,parse result = "
        //  1035: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1038: pop            
        //  1039: aload_0        
        //  1040: getfield        com/baidu/lbsapi/auth/g.d:Ljava/lang/String;
        //  1043: astore_2       
        //  1044: aload_1        
        //  1045: aload_2        
        //  1046: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1049: pop            
        //  1050: aload_1        
        //  1051: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1054: invokestatic    com/baidu/lbsapi/auth/a.a:(Ljava/lang/String;)V
        //  1057: return         
        //  1058: aload           7
        //  1060: ifnull          1086
        //  1063: aload           7
        //  1065: invokevirtual   java/io/OutputStream.close:()V
        //  1068: goto            1086
        //  1071: astore_2       
        //  1072: getstatic       com/baidu/lbsapi/auth/a.a:Z
        //  1075: istore          5
        //  1077: iload           5
        //  1079: ifeq            1086
        //  1082: aload_2        
        //  1083: invokevirtual   java/io/IOException.printStackTrace:()V
        //  1086: aload_1        
        //  1087: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  75     79     823    824    Ljava/net/MalformedURLException;
        //  75     79     731    732    Ljava/io/IOException;
        //  75     79     639    640    Ljava/lang/Exception;
        //  75     79     635    639    Any
        //  81     84     627    635    Ljava/net/MalformedURLException;
        //  81     84     619    627    Ljava/io/IOException;
        //  81     84     611    619    Ljava/lang/Exception;
        //  81     84     603    611    Any
        //  86     89     627    635    Ljava/net/MalformedURLException;
        //  86     89     619    627    Ljava/io/IOException;
        //  86     89     611    619    Ljava/lang/Exception;
        //  86     89     603    611    Any
        //  99     104    627    635    Ljava/net/MalformedURLException;
        //  99     104    619    627    Ljava/io/IOException;
        //  99     104    611    619    Ljava/lang/Exception;
        //  99     104    603    611    Any
        //  106    111    627    635    Ljava/net/MalformedURLException;
        //  106    111    619    627    Ljava/io/IOException;
        //  106    111    611    619    Ljava/lang/Exception;
        //  106    111    603    611    Any
        //  111    115    627    635    Ljava/net/MalformedURLException;
        //  111    115    619    627    Ljava/io/IOException;
        //  111    115    611    619    Ljava/lang/Exception;
        //  111    115    603    611    Any
        //  117    122    627    635    Ljava/net/MalformedURLException;
        //  117    122    619    627    Ljava/io/IOException;
        //  117    122    611    619    Ljava/lang/Exception;
        //  117    122    603    611    Any
        //  126    131    627    635    Ljava/net/MalformedURLException;
        //  126    131    619    627    Ljava/io/IOException;
        //  126    131    611    619    Ljava/lang/Exception;
        //  126    131    603    611    Any
        //  131    135    627    635    Ljava/net/MalformedURLException;
        //  131    135    619    627    Ljava/io/IOException;
        //  131    135    611    619    Ljava/lang/Exception;
        //  131    135    603    611    Any
        //  137    142    627    635    Ljava/net/MalformedURLException;
        //  137    142    619    627    Ljava/io/IOException;
        //  137    142    611    619    Ljava/lang/Exception;
        //  137    142    603    611    Any
        //  144    149    627    635    Ljava/net/MalformedURLException;
        //  144    149    619    627    Ljava/io/IOException;
        //  144    149    611    619    Ljava/lang/Exception;
        //  144    149    603    611    Any
        //  149    154    627    635    Ljava/net/MalformedURLException;
        //  149    154    619    627    Ljava/io/IOException;
        //  149    154    611    619    Ljava/lang/Exception;
        //  149    154    603    611    Any
        //  154    159    627    635    Ljava/net/MalformedURLException;
        //  154    159    619    627    Ljava/io/IOException;
        //  154    159    611    619    Ljava/lang/Exception;
        //  154    159    603    611    Any
        //  159    163    627    635    Ljava/net/MalformedURLException;
        //  159    163    619    627    Ljava/io/IOException;
        //  159    163    611    619    Ljava/lang/Exception;
        //  159    163    603    611    Any
        //  163    167    368    372    Ljava/io/IOException;
        //  163    167    358    362    Any
        //  169    173    347    358    Ljava/io/IOException;
        //  169    173    336    347    Any
        //  182    185    291    295    Ljava/io/IOException;
        //  182    185    280    284    Any
        //  187    190    291    295    Ljava/io/IOException;
        //  187    190    280    284    Any
        //  200    205    291    295    Ljava/io/IOException;
        //  200    205    280    284    Any
        //  207    212    291    295    Ljava/io/IOException;
        //  207    212    280    284    Any
        //  212    215    276    280    Ljava/io/IOException;
        //  212    215    272    276    Any
        //  217    222    276    280    Ljava/io/IOException;
        //  217    222    272    276    Any
        //  222    227    276    280    Ljava/io/IOException;
        //  222    227    272    276    Any
        //  243    249    276    280    Ljava/io/IOException;
        //  243    249    272    276    Any
        //  252    257    276    280    Ljava/io/IOException;
        //  252    257    272    276    Any
        //  260    265    276    280    Ljava/io/IOException;
        //  260    265    272    276    Any
        //  312    317    595    603    Ljava/net/MalformedURLException;
        //  312    317    587    595    Ljava/io/IOException;
        //  312    317    579    587    Ljava/lang/Exception;
        //  312    317    603    611    Any
        //  317    322    595    603    Ljava/net/MalformedURLException;
        //  317    322    587    595    Ljava/io/IOException;
        //  317    322    579    587    Ljava/lang/Exception;
        //  317    322    603    611    Any
        //  326    330    595    603    Ljava/net/MalformedURLException;
        //  326    330    587    595    Ljava/io/IOException;
        //  326    330    579    587    Ljava/lang/Exception;
        //  326    330    603    611    Any
        //  375    378    548    549    Any
        //  385    389    548    549    Any
        //  389    392    548    549    Any
        //  394    399    548    549    Any
        //  405    411    548    549    Any
        //  411    415    548    549    Any
        //  419    425    548    549    Any
        //  425    430    548    549    Any
        //  432    437    548    549    Any
        //  437    440    548    549    Any
        //  442    447    548    549    Any
        //  453    459    548    549    Any
        //  459    463    548    549    Any
        //  466    471    548    549    Any
        //  471    476    548    549    Any
        //  479    483    548    549    Any
        //  485    489    548    549    Any
        //  499    504    595    603    Ljava/net/MalformedURLException;
        //  499    504    587    595    Ljava/io/IOException;
        //  499    504    579    587    Ljava/lang/Exception;
        //  499    504    603    611    Any
        //  504    509    595    603    Ljava/net/MalformedURLException;
        //  504    509    587    595    Ljava/io/IOException;
        //  504    509    579    587    Ljava/lang/Exception;
        //  504    509    603    611    Any
        //  513    517    595    603    Ljava/net/MalformedURLException;
        //  513    517    587    595    Ljava/io/IOException;
        //  513    517    579    587    Ljava/lang/Exception;
        //  513    517    603    611    Any
        //  522    527    530    541    Ljava/io/IOException;
        //  559    564    595    603    Ljava/net/MalformedURLException;
        //  559    564    587    595    Ljava/io/IOException;
        //  559    564    579    587    Ljava/lang/Exception;
        //  559    564    603    611    Any
        //  564    569    595    603    Ljava/net/MalformedURLException;
        //  564    569    587    595    Ljava/io/IOException;
        //  564    569    579    587    Ljava/lang/Exception;
        //  564    569    603    611    Any
        //  573    577    595    603    Ljava/net/MalformedURLException;
        //  573    577    587    595    Ljava/io/IOException;
        //  573    577    579    587    Ljava/lang/Exception;
        //  573    577    603    611    Any
        //  577    579    595    603    Ljava/net/MalformedURLException;
        //  577    579    587    595    Ljava/io/IOException;
        //  577    579    579    587    Ljava/lang/Exception;
        //  577    579    603    611    Any
        //  643    646    635    639    Any
        //  653    657    635    639    Any
        //  657    660    635    639    Any
        //  661    665    635    639    Any
        //  670    676    635    639    Any
        //  676    680    635    639    Any
        //  682    687    635    639    Any
        //  687    691    635    639    Any
        //  694    698    635    639    Any
        //  700    704    635    639    Any
        //  709    714    717    731    Ljava/io/IOException;
        //  735    738    635    639    Any
        //  745    749    635    639    Any
        //  749    752    635    639    Any
        //  753    757    635    639    Any
        //  762    768    635    639    Any
        //  768    772    635    639    Any
        //  774    779    635    639    Any
        //  779    783    635    639    Any
        //  786    790    635    639    Any
        //  792    796    635    639    Any
        //  801    806    809    823    Ljava/io/IOException;
        //  827    830    635    639    Any
        //  837    841    635    639    Any
        //  841    844    635    639    Any
        //  845    849    635    639    Any
        //  854    860    635    639    Any
        //  860    864    635    639    Any
        //  866    871    635    639    Any
        //  871    875    635    639    Any
        //  878    882    635    639    Any
        //  884    888    635    639    Any
        //  893    898    901    915    Ljava/io/IOException;
        //  1063   1068   1071   1086   Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 541, Size: 541
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
    
    private static String b(final HashMap hashMap) {
        final StringBuilder sb = new StringBuilder();
        final Iterator<Map.Entry<String, V>> iterator = hashMap.entrySet().iterator();
        int n = 1;
        while (iterator.hasNext()) {
            final Map.Entry<String, V> entry = iterator.next();
            if (n != 0) {
                n = 0;
            }
            else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            sb.append("=");
            sb.append(URLEncoder.encode((String)entry.getValue(), "UTF-8"));
        }
        return sb.toString();
    }
    
    private HttpsURLConnection b() {
        try {
            try {
                final URL url = new URL(this.b);
                try {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("https URL: ");
                    sb.append(this.b);
                    final String string = sb.toString();
                    try {
                        com.baidu.lbsapi.auth.a.a(string);
                        final String a = this.a(this.a);
                        Label_0334: {
                            if (a == null || a.equals("")) {
                                break Label_0334;
                            }
                            try {
                                final StringBuilder sb2 = new StringBuilder();
                                sb2.append("checkNetwork = ");
                                final StringBuilder sb3 = sb2;
                                try {
                                    sb3.append(a);
                                    final String string2 = sb2.toString();
                                    try {
                                        com.baidu.lbsapi.auth.a.a(string2);
                                        final boolean equals = a.equals("cmwap");
                                        final int n = 80;
                                        Label_0207: {
                                            if (!equals) {
                                                break Label_0207;
                                            }
                                            try {
                                                final Proxy.Type http = Proxy.Type.HTTP;
                                                try {
                                                    final Proxy proxy = new Proxy(http, new InetSocketAddress("10.0.0.172", n));
                                                    final URL url2 = url;
                                                    try {
                                                        URLConnection urlConnection = url2.openConnection(proxy);
                                                        try {
                                                            while (true) {
                                                                final HttpsURLConnection httpsURLConnection = (HttpsURLConnection)urlConnection;
                                                                Label_0277: {
                                                                    break Label_0277;
                                                                    try {
                                                                        final Proxy.Type http2 = Proxy.Type.HTTP;
                                                                        try {
                                                                            final Proxy proxy2 = new Proxy(http2, new InetSocketAddress("10.0.0.200", n));
                                                                            final URL url3 = url;
                                                                            try {
                                                                                urlConnection = url3.openConnection(proxy2);
                                                                                continue;
                                                                                final h hostnameVerifier = new h(this);
                                                                                final HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
                                                                                try {
                                                                                    httpsURLConnection2.setHostnameVerifier(hostnameVerifier);
                                                                                    final boolean b = true;
                                                                                    httpsURLConnection.setDoInput(b);
                                                                                    final HttpsURLConnection httpsURLConnection3 = httpsURLConnection;
                                                                                    try {
                                                                                        httpsURLConnection3.setDoOutput(b);
                                                                                        httpsURLConnection.setRequestMethod("POST");
                                                                                        final int n2 = 50000;
                                                                                        httpsURLConnection.setConnectTimeout(n2);
                                                                                        final HttpsURLConnection httpsURLConnection4 = httpsURLConnection;
                                                                                        try {
                                                                                            httpsURLConnection4.setReadTimeout(n2);
                                                                                            return httpsURLConnection;
                                                                                            com.baidu.lbsapi.auth.a.c("Current network is not available.");
                                                                                            this.d = ErrorMessage.a(-10, "Current network is not available.");
                                                                                            return null;
                                                                                        }
                                                                                        catch (Exception ex) {
                                                                                            if (com.baidu.lbsapi.auth.a.a) {
                                                                                                ex.printStackTrace();
                                                                                                com.baidu.lbsapi.auth.a.a(ex.getMessage());
                                                                                            }
                                                                                        }
                                                                                        catch (MalformedURLException ex2) {
                                                                                            if (com.baidu.lbsapi.auth.a.a) {
                                                                                                ex2.printStackTrace();
                                                                                                com.baidu.lbsapi.auth.a.a(ex2.getMessage());
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ex3) {}
                                                                                    catch (MalformedURLException ex4) {}
                                                                                }
                                                                                catch (Exception ex5) {}
                                                                                catch (MalformedURLException ex6) {}
                                                                                Label_0269: {
                                                                                    urlConnection = url.openConnection();
                                                                                }
                                                                            }
                                                                            catch (Exception ex7) {}
                                                                            catch (MalformedURLException ex8) {}
                                                                        }
                                                                        catch (Exception ex9) {}
                                                                        catch (MalformedURLException ex10) {}
                                                                    }
                                                                    catch (Exception ex11) {}
                                                                    catch (MalformedURLException ex12) {}
                                                                }
                                                            }
                                                        }
                                                        // iftrue(Label_0269:, !a.equals((Object)"ctwap"))
                                                        catch (Exception ex13) {}
                                                        catch (MalformedURLException ex14) {}
                                                    }
                                                    catch (Exception ex15) {}
                                                    catch (MalformedURLException ex16) {}
                                                }
                                                catch (Exception ex17) {}
                                                catch (MalformedURLException ex18) {}
                                            }
                                            catch (Exception ex19) {}
                                            catch (MalformedURLException ex20) {}
                                        }
                                    }
                                    catch (Exception ex21) {}
                                    catch (MalformedURLException ex22) {}
                                }
                                catch (Exception ex23) {}
                                catch (MalformedURLException ex24) {}
                            }
                            catch (Exception ex25) {}
                            catch (MalformedURLException ex26) {}
                        }
                    }
                    catch (Exception ex27) {}
                    catch (MalformedURLException ex28) {}
                }
                catch (Exception ex29) {}
                catch (MalformedURLException ex30) {}
            }
            catch (Exception ex31) {}
            catch (MalformedURLException ex32) {}
        }
        catch (Exception ex33) {}
        catch (MalformedURLException ex34) {}
    }
    
    private HashMap c(final HashMap hashMap) {
        final HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
        final Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            final String string = iterator.next().toString();
            hashMap2.put(string, hashMap.get(string));
        }
        return hashMap2;
    }
    
    protected String a(HashMap c) {
        c = this.c(c);
        this.c = c;
        c = this.c;
        this.b = c.get("url");
        final HttpsURLConnection b = this.b();
        if (b == null) {
            com.baidu.lbsapi.auth.a.c("syncConnect failed,httpsURLConnection is null");
        }
        else {
            this.a(b);
        }
        return this.d;
    }
    
    protected boolean a() {
        com.baidu.lbsapi.auth.a.a("checkNetwork start");
        boolean b = false;
        try {
            final Object systemService = this.a.getSystemService("connectivity");
            try {
                final ConnectivityManager connectivityManager = (ConnectivityManager)systemService;
                if (connectivityManager == null) {
                    return false;
                }
                final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.isAvailable()) {
                        com.baidu.lbsapi.auth.a.a("checkNetwork end");
                        b = true;
                    }
                }
                return b;
            }
            catch (Exception ex) {
                if (com.baidu.lbsapi.auth.a.a) {
                    ex.printStackTrace();
                }
                return false;
            }
        }
        catch (Exception ex2) {}
    }
}
