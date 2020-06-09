// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import android.database.sqlite.SQLiteDatabase$CursorFactory;
import java.io.File;
import android.content.ContentValues;
import org.json.JSONObject;
import android.os.Bundle;
import com.baidu.location.b.g;
import com.baidu.location.b.b;
import com.baidu.location.d.j;
import android.database.sqlite.SQLiteDatabase;

public class h
{
    private static Object c;
    private static h d;
    private static final String e;
    h$a a;
    h$a b;
    private SQLiteDatabase f;
    private boolean g;
    
    static {
        h.c = new Object();
        h.d = null;
        final StringBuilder sb = new StringBuilder();
        sb.append(j.h());
        sb.append("/hst.db");
        e = sb.toString();
    }
    
    public h() {
        this.f = null;
        this.g = false;
        this.a = null;
        this.b = null;
    }
    
    public static h a() {
        synchronized (h.c) {
            if (h.d == null) {
                h.d = new h();
            }
            return h.d;
        }
    }
    
    private String a(final boolean b) {
        final com.baidu.location.b.a f = b.a().f();
        final g o = com.baidu.location.b.h.a().o();
        final StringBuffer sb = new StringBuffer(1024);
        if (f != null && f.b()) {
            sb.append(f.g());
        }
        Label_0117: {
            String s;
            if (o != null && o.a() > 1) {
                s = o.a(15);
            }
            else {
                if (com.baidu.location.b.h.a().l() == null) {
                    break Label_0117;
                }
                s = com.baidu.location.b.h.a().l();
            }
            sb.append(s);
        }
        if (b) {
            sb.append("&imo=1");
        }
        sb.append(com.baidu.location.d.b.a().a(false));
        sb.append(com.baidu.location.a.a.a().c());
        return sb.toString();
    }
    
    private void a(final Bundle bundle) {
        com.baidu.location.a.a.a().a(bundle, 406);
    }
    
    private void f() {
        final Bundle bundle = new Bundle();
        bundle.putInt("hotspot", -1);
        this.a(bundle);
    }
    
    public void a(String s) {
        if (this.g) {
            return;
        }
        try {
            final JSONObject jsonObject = new JSONObject(s);
            s = "content";
            JSONObject jsonObject2;
            if (jsonObject.has(s)) {
                s = "content";
                jsonObject2 = jsonObject.getJSONObject(s);
            }
            else {
                jsonObject2 = null;
            }
            if (jsonObject2 != null && jsonObject2.has("imo")) {
                final String string = jsonObject2.getJSONObject("imo").getString("mac");
                try {
                    final Long value = Long.valueOf(string);
                    final int int1 = jsonObject2.getJSONObject("imo").getInt("mv");
                    try {
                        try {
                            final ContentValues contentValues = new ContentValues();
                            contentValues.put("tt", (int)(System.currentTimeMillis() / 1000L));
                            contentValues.put("hst", int1);
                            final SQLiteDatabase f = this.f;
                            final String s2 = "hstdata";
                            try {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("id = \"");
                                final StringBuilder sb2 = sb;
                                try {
                                    sb2.append(value);
                                    sb.append("\"");
                                    if (f.update(s2, contentValues, sb.toString(), (String[])null) <= 0) {
                                        s = "id";
                                        contentValues.put(s, value);
                                        this.f.insert("hstdata", (String)null, contentValues);
                                    }
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
    
    public void b() {
        try {
            try {
                final File file = new File(h.e);
                if (!file.exists()) {
                    file.createNewFile();
                }
                if (file.exists()) {
                    (this.f = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase$CursorFactory)null)).execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
                    this.f.setVersion(1);
                }
            }
            catch (Exception ex) {
                this.f = null;
            }
        }
        catch (Exception ex2) {}
    }
    
    public void c() {
        final SQLiteDatabase f = this.f;
        if (f != null) {
            try {
                f.close();
            }
            catch (Exception ex) {}
            finally {
                this.f = null;
            }
            this.f = null;
        }
    }
    
    public int d() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/baidu/location/a/h.g:Z
        //     4: istore_1       
        //     5: bipush          -3
        //     7: istore_2       
        //     8: iload_1        
        //     9: ifeq            14
        //    12: iload_2        
        //    13: ireturn        
        //    14: invokestatic    com/baidu/location/b/h.i:()Z
        //    17: istore_1       
        //    18: iload_1        
        //    19: ifeq            241
        //    22: aload_0        
        //    23: getfield        com/baidu/location/a/h.f:Landroid/database/sqlite/SQLiteDatabase;
        //    26: astore_3       
        //    27: aload_3        
        //    28: ifnull          241
        //    31: invokestatic    com/baidu/location/b/h.a:()Lcom/baidu/location/b/h;
        //    34: astore_3       
        //    35: aload_3        
        //    36: invokevirtual   com/baidu/location/b/h.k:()Landroid/net/wifi/WifiInfo;
        //    39: astore_3       
        //    40: aload_3        
        //    41: ifnull          241
        //    44: aload_3        
        //    45: invokevirtual   android/net/wifi/WifiInfo.getBSSID:()Ljava/lang/String;
        //    48: astore          4
        //    50: aload           4
        //    52: ifnull          241
        //    55: aload_3        
        //    56: invokevirtual   android/net/wifi/WifiInfo.getBSSID:()Ljava/lang/String;
        //    59: astore_3       
        //    60: ldc_w           ":"
        //    63: astore          4
        //    65: ldc_w           ""
        //    68: astore          5
        //    70: aload_3        
        //    71: aload           4
        //    73: aload           5
        //    75: invokevirtual   java/lang/String.replace:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //    78: astore_3       
        //    79: aload_3        
        //    80: invokestatic    com/baidu/location/Jni.encode3:(Ljava/lang/String;)Ljava/lang/Long;
        //    83: astore_3       
        //    84: aconst_null    
        //    85: astore          4
        //    87: aload_0        
        //    88: getfield        com/baidu/location/a/h.f:Landroid/database/sqlite/SQLiteDatabase;
        //    91: astore          5
        //    93: new             Ljava/lang/StringBuilder;
        //    96: astore          6
        //    98: aload           6
        //   100: invokespecial   java/lang/StringBuilder.<init>:()V
        //   103: ldc_w           "select * from hstdata where id = \""
        //   106: astore          7
        //   108: aload           6
        //   110: aload           7
        //   112: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   115: pop            
        //   116: aload           6
        //   118: aload_3        
        //   119: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   122: pop            
        //   123: ldc_w           "\";"
        //   126: astore_3       
        //   127: aload           6
        //   129: aload_3        
        //   130: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   133: pop            
        //   134: aload           6
        //   136: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   139: astore_3       
        //   140: aload           5
        //   142: aload_3        
        //   143: aconst_null    
        //   144: invokevirtual   android/database/sqlite/SQLiteDatabase.rawQuery:(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
        //   147: astore          4
        //   149: aload           4
        //   151: ifnull          180
        //   154: aload           4
        //   156: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   161: istore_1       
        //   162: iload_1        
        //   163: ifeq            180
        //   166: iconst_1       
        //   167: istore_1       
        //   168: aload           4
        //   170: iload_1        
        //   171: invokeinterface android/database/Cursor.getInt:(I)I
        //   176: istore_1       
        //   177: goto            183
        //   180: bipush          -2
        //   182: istore_1       
        //   183: aload           4
        //   185: ifnull          199
        //   188: aload           4
        //   190: invokeinterface android/database/Cursor.close:()V
        //   195: goto            199
        //   198: pop            
        //   199: iload_1        
        //   200: istore_2       
        //   201: goto            241
        //   204: astore_3       
        //   205: aload           4
        //   207: ifnull          222
        //   210: aload           4
        //   212: invokeinterface android/database/Cursor.close:()V
        //   217: goto            222
        //   220: astore          4
        //   222: aload_3        
        //   223: athrow         
        //   224: astore_3       
        //   225: aload           4
        //   227: ifnull          241
        //   230: aload           4
        //   232: invokeinterface android/database/Cursor.close:()V
        //   237: goto            241
        //   240: astore_3       
        //   241: iload_2        
        //   242: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  14     17     240    241    Ljava/lang/Exception;
        //  22     26     240    241    Ljava/lang/Exception;
        //  31     34     240    241    Ljava/lang/Exception;
        //  35     39     240    241    Ljava/lang/Exception;
        //  44     48     240    241    Ljava/lang/Exception;
        //  55     59     240    241    Ljava/lang/Exception;
        //  73     78     240    241    Ljava/lang/Exception;
        //  79     83     240    241    Ljava/lang/Exception;
        //  87     91     224    240    Ljava/lang/Exception;
        //  87     91     204    224    Any
        //  93     96     224    240    Ljava/lang/Exception;
        //  93     96     204    224    Any
        //  98     103    224    240    Ljava/lang/Exception;
        //  98     103    204    224    Any
        //  110    116    224    240    Ljava/lang/Exception;
        //  110    116    204    224    Any
        //  118    123    224    240    Ljava/lang/Exception;
        //  118    123    204    224    Any
        //  129    134    224    240    Ljava/lang/Exception;
        //  129    134    204    224    Any
        //  134    139    224    240    Ljava/lang/Exception;
        //  134    139    204    224    Any
        //  143    147    224    240    Ljava/lang/Exception;
        //  143    147    204    224    Any
        //  154    161    224    240    Ljava/lang/Exception;
        //  154    161    204    224    Any
        //  170    176    224    240    Ljava/lang/Exception;
        //  170    176    204    224    Any
        //  188    195    198    199    Ljava/lang/Exception;
        //  210    217    220    222    Ljava/lang/Exception;
        //  222    224    240    241    Ljava/lang/Exception;
        //  230    237    240    241    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 121, Size: 121
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:657)
        //     at java.util.ArrayList.get(ArrayList.java:433)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3303)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3551)
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
    
    public void e() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/baidu/location/a/h.g:Z
        //     4: istore_1       
        //     5: iload_1        
        //     6: ifeq            10
        //     9: return         
        //    10: invokestatic    com/baidu/location/b/h.i:()Z
        //    13: istore_1       
        //    14: iload_1        
        //    15: ifeq            404
        //    18: aload_0        
        //    19: getfield        com/baidu/location/a/h.f:Landroid/database/sqlite/SQLiteDatabase;
        //    22: astore_2       
        //    23: aload_2        
        //    24: ifnull          404
        //    27: invokestatic    com/baidu/location/b/h.a:()Lcom/baidu/location/b/h;
        //    30: astore_2       
        //    31: aload_2        
        //    32: invokevirtual   com/baidu/location/b/h.k:()Landroid/net/wifi/WifiInfo;
        //    35: astore_2       
        //    36: aload_2        
        //    37: ifnull          404
        //    40: aload_2        
        //    41: invokevirtual   android/net/wifi/WifiInfo.getBSSID:()Ljava/lang/String;
        //    44: astore_3       
        //    45: aload_3        
        //    46: ifnull          404
        //    49: aload_2        
        //    50: invokevirtual   android/net/wifi/WifiInfo.getBSSID:()Ljava/lang/String;
        //    53: astore_2       
        //    54: ldc_w           ":"
        //    57: astore_3       
        //    58: ldc_w           ""
        //    61: astore          4
        //    63: aload_2        
        //    64: aload_3        
        //    65: aload           4
        //    67: invokevirtual   java/lang/String.replace:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //    70: astore_2       
        //    71: aload_2        
        //    72: invokestatic    com/baidu/location/Jni.encode3:(Ljava/lang/String;)Ljava/lang/Long;
        //    75: astore_3       
        //    76: iconst_0       
        //    77: istore          5
        //    79: aconst_null    
        //    80: astore          4
        //    82: aconst_null    
        //    83: astore          6
        //    85: iconst_1       
        //    86: istore          7
        //    88: aload_0        
        //    89: getfield        com/baidu/location/a/h.f:Landroid/database/sqlite/SQLiteDatabase;
        //    92: astore          8
        //    94: new             Ljava/lang/StringBuilder;
        //    97: astore          9
        //    99: aload           9
        //   101: invokespecial   java/lang/StringBuilder.<init>:()V
        //   104: ldc_w           "select * from hstdata where id = \""
        //   107: astore          10
        //   109: aload           9
        //   111: aload           10
        //   113: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   116: pop            
        //   117: aload           9
        //   119: aload_3        
        //   120: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   123: pop            
        //   124: ldc_w           "\";"
        //   127: astore_3       
        //   128: aload           9
        //   130: aload_3        
        //   131: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   134: pop            
        //   135: aload           9
        //   137: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   140: astore_3       
        //   141: aload           8
        //   143: aload_3        
        //   144: aconst_null    
        //   145: invokevirtual   android/database/sqlite/SQLiteDatabase.rawQuery:(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
        //   148: astore          6
        //   150: aload           6
        //   152: ifnull          294
        //   155: aload           6
        //   157: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   162: istore          11
        //   164: iload           11
        //   166: ifeq            294
        //   169: aload           6
        //   171: iload           7
        //   173: invokeinterface android/database/Cursor.getInt:(I)I
        //   178: istore          11
        //   180: iconst_2       
        //   181: istore          12
        //   183: aload           6
        //   185: iload           12
        //   187: invokeinterface android/database/Cursor.getInt:(I)I
        //   192: istore          12
        //   194: invokestatic    java/lang/System.currentTimeMillis:()J
        //   197: lstore          13
        //   199: ldc2_w          1000
        //   202: lstore          15
        //   204: lload           13
        //   206: lload           15
        //   208: ldiv           
        //   209: lstore          13
        //   211: iload           12
        //   213: i2l            
        //   214: lstore          15
        //   216: lload           13
        //   218: lload           15
        //   220: lsub           
        //   221: lstore          13
        //   223: ldc2_w          259200
        //   226: lstore          15
        //   228: lload           13
        //   230: lload           15
        //   232: lcmp           
        //   233: istore          12
        //   235: iload           12
        //   237: ifle            243
        //   240: goto            294
        //   243: new             Landroid/os/Bundle;
        //   246: astore          8
        //   248: aload           8
        //   250: invokespecial   android/os/Bundle.<init>:()V
        //   253: ldc             "mac"
        //   255: astore          9
        //   257: aload_2        
        //   258: invokevirtual   java/lang/String.getBytes:()[B
        //   261: astore          10
        //   263: aload           8
        //   265: aload           9
        //   267: aload           10
        //   269: invokevirtual   android/os/Bundle.putByteArray:(Ljava/lang/String;[B)V
        //   272: ldc             "hotspot"
        //   274: astore          9
        //   276: aload           8
        //   278: aload           9
        //   280: iload           11
        //   282: invokevirtual   android/os/Bundle.putInt:(Ljava/lang/String;I)V
        //   285: aload_0        
        //   286: aload           8
        //   288: invokespecial   com/baidu/location/a/h.a:(Landroid/os/Bundle;)V
        //   291: goto            297
        //   294: iconst_1       
        //   295: istore          5
        //   297: aload           6
        //   299: ifnull          344
        //   302: aload           6
        //   304: invokeinterface android/database/Cursor.close:()V
        //   309: goto            344
        //   312: astore_3       
        //   313: goto            344
        //   316: astore_2       
        //   317: aload           6
        //   319: ifnull          333
        //   322: aload           6
        //   324: invokeinterface android/database/Cursor.close:()V
        //   329: goto            333
        //   332: astore_3       
        //   333: aload_2        
        //   334: athrow         
        //   335: astore_3       
        //   336: aload           6
        //   338: ifnull          344
        //   341: goto            302
        //   344: iload           5
        //   346: ifeq            412
        //   349: aload_0        
        //   350: getfield        com/baidu/location/a/h.a:Lcom/baidu/location/a/h$a;
        //   353: astore_3       
        //   354: aload_3        
        //   355: ifnonnull       372
        //   358: new             Lcom/baidu/location/a/h$a;
        //   361: astore_3       
        //   362: aload_3        
        //   363: aload_0        
        //   364: invokespecial   com/baidu/location/a/h$a.<init>:(Lcom/baidu/location/a/h;)V
        //   367: aload_0        
        //   368: aload_3        
        //   369: putfield        com/baidu/location/a/h.a:Lcom/baidu/location/a/h$a;
        //   372: aload_0        
        //   373: getfield        com/baidu/location/a/h.a:Lcom/baidu/location/a/h$a;
        //   376: astore_3       
        //   377: aload_3        
        //   378: ifnull          412
        //   381: aload_0        
        //   382: getfield        com/baidu/location/a/h.a:Lcom/baidu/location/a/h$a;
        //   385: astore_3       
        //   386: aload_0        
        //   387: iload           7
        //   389: invokespecial   com/baidu/location/a/h.a:(Z)Ljava/lang/String;
        //   392: astore          4
        //   394: aload_3        
        //   395: aload_2        
        //   396: aload           4
        //   398: invokevirtual   com/baidu/location/a/h$a.a:(Ljava/lang/String;Ljava/lang/String;)V
        //   401: goto            412
        //   404: aload_0        
        //   405: invokespecial   com/baidu/location/a/h.f:()V
        //   408: goto            412
        //   411: astore_2       
        //   412: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  10     13     411    412    Ljava/lang/Exception;
        //  18     22     411    412    Ljava/lang/Exception;
        //  27     30     411    412    Ljava/lang/Exception;
        //  31     35     411    412    Ljava/lang/Exception;
        //  40     44     411    412    Ljava/lang/Exception;
        //  49     53     411    412    Ljava/lang/Exception;
        //  65     70     411    412    Ljava/lang/Exception;
        //  71     75     411    412    Ljava/lang/Exception;
        //  88     92     335    344    Ljava/lang/Exception;
        //  88     92     316    335    Any
        //  94     97     335    344    Ljava/lang/Exception;
        //  94     97     316    335    Any
        //  99     104    335    344    Ljava/lang/Exception;
        //  99     104    316    335    Any
        //  111    117    335    344    Ljava/lang/Exception;
        //  111    117    316    335    Any
        //  119    124    335    344    Ljava/lang/Exception;
        //  119    124    316    335    Any
        //  130    135    335    344    Ljava/lang/Exception;
        //  130    135    316    335    Any
        //  135    140    335    344    Ljava/lang/Exception;
        //  135    140    316    335    Any
        //  144    148    335    344    Ljava/lang/Exception;
        //  144    148    316    335    Any
        //  155    162    335    344    Ljava/lang/Exception;
        //  155    162    316    335    Any
        //  171    178    335    344    Ljava/lang/Exception;
        //  171    178    316    335    Any
        //  185    192    335    344    Ljava/lang/Exception;
        //  185    192    316    335    Any
        //  194    197    335    344    Ljava/lang/Exception;
        //  194    197    316    335    Any
        //  206    209    335    344    Ljava/lang/Exception;
        //  206    209    316    335    Any
        //  243    246    335    344    Ljava/lang/Exception;
        //  243    246    316    335    Any
        //  248    253    335    344    Ljava/lang/Exception;
        //  248    253    316    335    Any
        //  257    261    335    344    Ljava/lang/Exception;
        //  257    261    316    335    Any
        //  267    272    335    344    Ljava/lang/Exception;
        //  267    272    316    335    Any
        //  280    285    335    344    Ljava/lang/Exception;
        //  280    285    316    335    Any
        //  286    291    335    344    Ljava/lang/Exception;
        //  286    291    316    335    Any
        //  302    309    312    316    Ljava/lang/Exception;
        //  322    329    332    333    Ljava/lang/Exception;
        //  333    335    411    412    Ljava/lang/Exception;
        //  349    353    411    412    Ljava/lang/Exception;
        //  358    361    411    412    Ljava/lang/Exception;
        //  363    367    411    412    Ljava/lang/Exception;
        //  368    372    411    412    Ljava/lang/Exception;
        //  372    376    411    412    Ljava/lang/Exception;
        //  381    385    411    412    Ljava/lang/Exception;
        //  387    392    411    412    Ljava/lang/Exception;
        //  396    401    411    412    Ljava/lang/Exception;
        //  404    408    411    412    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 204, Size: 204
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:657)
        //     at java.util.ArrayList.get(ArrayList.java:433)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3303)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3551)
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
}
