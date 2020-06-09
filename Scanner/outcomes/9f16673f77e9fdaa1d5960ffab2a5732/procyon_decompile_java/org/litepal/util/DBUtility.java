// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.util;

import java.util.Collection;
import java.util.Iterator;
import android.text.TextUtils;
import org.litepal.tablemanager.model.TableModel;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;

public class DBUtility
{
    public static List findAllTableNames(final SQLiteDatabase sqLiteDatabase) {
        final ArrayList<String> list = new ArrayList<String>();
        Cursor rawQuery = null;
        final String s = "select * from sqlite_master where type = ?";
        final int n = 1;
        try {
            try {
                final String[] array = new String[n];
                array[0] = "table";
                if ((rawQuery = sqLiteDatabase.rawQuery(s, array)).moveToFirst()) {
                    do {
                        final String string = rawQuery.getString(rawQuery.getColumnIndexOrThrow("tbl_name"));
                        if (!list.contains(string)) {
                            list.add(string);
                        }
                    } while (rawQuery.moveToNext());
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return list;
            }
            finally {
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        catch (Exception ex) {}
    }
    
    public static TableModel findPragmaTableInfo(final String p0, final SQLiteDatabase p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: aload_1        
        //     2: invokestatic    org/litepal/util/DBUtility.isTableExists:(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Z
        //     5: istore_2       
        //     6: iload_2        
        //     7: ifeq            423
        //    10: aload_0        
        //    11: aload_1        
        //    12: invokestatic    org/litepal/util/DBUtility.findUniqueColumns:(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Ljava/util/List;
        //    15: astore_3       
        //    16: new             Lorg/litepal/tablemanager/model/TableModel;
        //    19: astore          4
        //    21: aload           4
        //    23: invokespecial   org/litepal/tablemanager/model/TableModel.<init>:()V
        //    26: aload           4
        //    28: aload_0        
        //    29: invokevirtual   org/litepal/tablemanager/model/TableModel.setTableName:(Ljava/lang/String;)V
        //    32: new             Ljava/lang/StringBuilder;
        //    35: astore          5
        //    37: aload           5
        //    39: invokespecial   java/lang/StringBuilder.<init>:()V
        //    42: aload           5
        //    44: ldc             "pragma table_info("
        //    46: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    49: pop            
        //    50: aload           5
        //    52: aload_0        
        //    53: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    56: pop            
        //    57: aload           5
        //    59: ldc             ")"
        //    61: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    64: pop            
        //    65: aload           5
        //    67: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    70: astore          5
        //    72: aconst_null    
        //    73: astore          6
        //    75: iconst_0       
        //    76: istore          7
        //    78: aconst_null    
        //    79: astore          8
        //    81: aload_1        
        //    82: aload           5
        //    84: aconst_null    
        //    85: invokevirtual   android/database/sqlite/SQLiteDatabase.rawQuery:(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
        //    88: astore          8
        //    90: aload           8
        //    92: astore          6
        //    94: aload           8
        //    96: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   101: istore          7
        //   103: iload           7
        //   105: ifeq            353
        //   108: new             Lorg/litepal/tablemanager/model/ColumnModel;
        //   111: astore          8
        //   113: aload           8
        //   115: invokespecial   org/litepal/tablemanager/model/ColumnModel.<init>:()V
        //   118: ldc             "name"
        //   120: astore          9
        //   122: aload           6
        //   124: aload           9
        //   126: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //   131: istore          10
        //   133: aload           6
        //   135: iload           10
        //   137: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   142: astore          9
        //   144: ldc             "type"
        //   146: astore          11
        //   148: aload           6
        //   150: aload           11
        //   152: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //   157: istore          12
        //   159: aload           6
        //   161: iload           12
        //   163: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   168: astore          11
        //   170: ldc             "notnull"
        //   172: astore          13
        //   174: aload           6
        //   176: aload           13
        //   178: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //   183: istore          14
        //   185: aload           6
        //   187: iload           14
        //   189: invokeinterface android/database/Cursor.getInt:(I)I
        //   194: istore          14
        //   196: iconst_1       
        //   197: istore          15
        //   199: iload           14
        //   201: iload           15
        //   203: if_icmpeq       209
        //   206: goto            212
        //   209: iconst_0       
        //   210: istore          15
        //   212: iload           15
        //   214: istore          14
        //   216: aload_3        
        //   217: aload           9
        //   219: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //   224: istore          15
        //   226: ldc             "dflt_value"
        //   228: astore          16
        //   230: aload           6
        //   232: aload           16
        //   234: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //   239: istore          17
        //   241: aload           6
        //   243: iload           17
        //   245: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   250: astore          16
        //   252: aload           8
        //   254: aload           9
        //   256: invokevirtual   org/litepal/tablemanager/model/ColumnModel.setColumnName:(Ljava/lang/String;)V
        //   259: aload           8
        //   261: aload           11
        //   263: invokevirtual   org/litepal/tablemanager/model/ColumnModel.setColumnType:(Ljava/lang/String;)V
        //   266: aload           8
        //   268: iload           14
        //   270: invokevirtual   org/litepal/tablemanager/model/ColumnModel.setIsNullable:(Z)V
        //   273: aload           8
        //   275: iload           15
        //   277: invokevirtual   org/litepal/tablemanager/model/ColumnModel.setIsUnique:(Z)V
        //   280: aload           16
        //   282: ifnull          311
        //   285: ldc             "'"
        //   287: astore          18
        //   289: ldc             ""
        //   291: astore          19
        //   293: aload           16
        //   295: aload           18
        //   297: aload           19
        //   299: invokevirtual   java/lang/String.replace:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //   302: astore          18
        //   304: aload           18
        //   306: astore          16
        //   308: goto            319
        //   311: ldc             ""
        //   313: astore          18
        //   315: aload           18
        //   317: astore          16
        //   319: aload           8
        //   321: aload           16
        //   323: invokevirtual   org/litepal/tablemanager/model/ColumnModel.setDefaultValue:(Ljava/lang/String;)V
        //   326: aload           4
        //   328: aload           8
        //   330: invokevirtual   org/litepal/tablemanager/model/TableModel.addColumnModel:(Lorg/litepal/tablemanager/model/ColumnModel;)V
        //   333: aload           6
        //   335: invokeinterface android/database/Cursor.moveToNext:()Z
        //   340: istore          7
        //   342: iload           7
        //   344: ifne            350
        //   347: goto            353
        //   350: goto            108
        //   353: aload           6
        //   355: ifnull          368
        //   358: aload           6
        //   360: invokeinterface android/database/Cursor.close:()V
        //   365: goto            368
        //   368: aload           4
        //   370: areturn        
        //   371: astore          8
        //   373: goto            405
        //   376: astore          8
        //   378: aload           8
        //   380: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   383: new             Lorg/litepal/exceptions/DatabaseGenerateException;
        //   386: astore          9
        //   388: aload           8
        //   390: invokevirtual   java/lang/Exception.getMessage:()Ljava/lang/String;
        //   393: astore          11
        //   395: aload           9
        //   397: aload           11
        //   399: invokespecial   org/litepal/exceptions/DatabaseGenerateException.<init>:(Ljava/lang/String;)V
        //   402: aload           9
        //   404: athrow         
        //   405: aload           6
        //   407: ifnull          420
        //   410: aload           6
        //   412: invokeinterface android/database/Cursor.close:()V
        //   417: goto            420
        //   420: aload           8
        //   422: athrow         
        //   423: new             Lorg/litepal/exceptions/DatabaseGenerateException;
        //   426: astore_3       
        //   427: new             Ljava/lang/StringBuilder;
        //   430: astore          4
        //   432: aload           4
        //   434: invokespecial   java/lang/StringBuilder.<init>:()V
        //   437: aload           4
        //   439: ldc             "Table doesn't exist when executing "
        //   441: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   444: pop            
        //   445: aload           4
        //   447: aload_0        
        //   448: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   451: pop            
        //   452: aload           4
        //   454: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   457: astore          4
        //   459: aload_3        
        //   460: aload           4
        //   462: invokespecial   org/litepal/exceptions/DatabaseGenerateException.<init>:(Ljava/lang/String;)V
        //   465: aload_3        
        //   466: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  84     88     376    405    Ljava/lang/Exception;
        //  84     88     371    423    Any
        //  94     101    376    405    Ljava/lang/Exception;
        //  94     101    371    423    Any
        //  108    111    376    405    Ljava/lang/Exception;
        //  108    111    371    423    Any
        //  113    118    376    405    Ljava/lang/Exception;
        //  113    118    371    423    Any
        //  124    131    376    405    Ljava/lang/Exception;
        //  124    131    371    423    Any
        //  135    142    376    405    Ljava/lang/Exception;
        //  135    142    371    423    Any
        //  150    157    376    405    Ljava/lang/Exception;
        //  150    157    371    423    Any
        //  161    168    376    405    Ljava/lang/Exception;
        //  161    168    371    423    Any
        //  176    183    376    405    Ljava/lang/Exception;
        //  176    183    371    423    Any
        //  187    194    376    405    Ljava/lang/Exception;
        //  187    194    371    423    Any
        //  217    224    376    405    Ljava/lang/Exception;
        //  217    224    371    423    Any
        //  232    239    376    405    Ljava/lang/Exception;
        //  232    239    371    423    Any
        //  243    250    376    405    Ljava/lang/Exception;
        //  243    250    371    423    Any
        //  254    259    376    405    Ljava/lang/Exception;
        //  254    259    371    423    Any
        //  261    266    376    405    Ljava/lang/Exception;
        //  261    266    371    423    Any
        //  268    273    376    405    Ljava/lang/Exception;
        //  268    273    371    423    Any
        //  275    280    376    405    Ljava/lang/Exception;
        //  275    280    371    423    Any
        //  297    302    376    405    Ljava/lang/Exception;
        //  297    302    371    423    Any
        //  321    326    376    405    Ljava/lang/Exception;
        //  321    326    371    423    Any
        //  328    333    376    405    Ljava/lang/Exception;
        //  328    333    371    423    Any
        //  333    340    376    405    Ljava/lang/Exception;
        //  333    340    371    423    Any
        //  378    383    371    423    Any
        //  383    386    371    423    Any
        //  388    393    371    423    Any
        //  397    402    371    423    Any
        //  402    405    371    423    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0350:
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
    
    public static List findUniqueColumns(final String p0, final SQLiteDatabase p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/util/ArrayList;
        //     3: astore_2       
        //     4: aload_2        
        //     5: invokespecial   java/util/ArrayList.<init>:()V
        //     8: aconst_null    
        //     9: astore_3       
        //    10: aconst_null    
        //    11: astore          4
        //    13: new             Ljava/lang/StringBuilder;
        //    16: astore          5
        //    18: aload           5
        //    20: invokespecial   java/lang/StringBuilder.<init>:()V
        //    23: ldc             "pragma index_list("
        //    25: astore          6
        //    27: aload           5
        //    29: aload           6
        //    31: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    34: pop            
        //    35: aload           5
        //    37: aload_0        
        //    38: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    41: pop            
        //    42: ldc             ")"
        //    44: astore          6
        //    46: aload           5
        //    48: aload           6
        //    50: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    53: pop            
        //    54: aload           5
        //    56: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    59: astore          5
        //    61: aconst_null    
        //    62: astore          6
        //    64: aload_1        
        //    65: aload           5
        //    67: aconst_null    
        //    68: invokevirtual   android/database/sqlite/SQLiteDatabase.rawQuery:(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
        //    71: astore          5
        //    73: aload           5
        //    75: astore_3       
        //    76: aload           5
        //    78: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    83: istore          7
        //    85: iload           7
        //    87: ifeq            284
        //    90: ldc             "unique"
        //    92: astore          5
        //    94: aload_3        
        //    95: aload           5
        //    97: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //   102: istore          7
        //   104: aload_3        
        //   105: iload           7
        //   107: invokeinterface android/database/Cursor.getInt:(I)I
        //   112: istore          7
        //   114: iconst_1       
        //   115: istore          8
        //   117: iload           7
        //   119: iload           8
        //   121: if_icmpne       265
        //   124: ldc             "name"
        //   126: astore          9
        //   128: aload_3        
        //   129: aload           9
        //   131: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //   136: istore          8
        //   138: aload_3        
        //   139: iload           8
        //   141: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   146: astore          9
        //   148: new             Ljava/lang/StringBuilder;
        //   151: astore          10
        //   153: aload           10
        //   155: invokespecial   java/lang/StringBuilder.<init>:()V
        //   158: ldc             "pragma index_info("
        //   160: astore          11
        //   162: aload           10
        //   164: aload           11
        //   166: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   169: pop            
        //   170: aload           10
        //   172: aload           9
        //   174: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   177: pop            
        //   178: ldc             ")"
        //   180: astore          11
        //   182: aload           10
        //   184: aload           11
        //   186: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   189: pop            
        //   190: aload           10
        //   192: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   195: astore          10
        //   197: aload_1        
        //   198: aload           10
        //   200: aconst_null    
        //   201: invokevirtual   android/database/sqlite/SQLiteDatabase.rawQuery:(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
        //   204: astore          10
        //   206: aload           10
        //   208: astore          4
        //   210: aload           10
        //   212: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   217: istore          12
        //   219: iload           12
        //   221: ifeq            262
        //   224: ldc             "name"
        //   226: astore          10
        //   228: aload           4
        //   230: aload           10
        //   232: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //   237: istore          12
        //   239: aload           4
        //   241: iload           12
        //   243: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   248: astore          10
        //   250: aload_2        
        //   251: aload           10
        //   253: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   258: pop            
        //   259: goto            265
        //   262: goto            265
        //   265: aload_3        
        //   266: invokeinterface android/database/Cursor.moveToNext:()Z
        //   271: istore          7
        //   273: iload           7
        //   275: ifne            281
        //   278: goto            284
        //   281: goto            90
        //   284: aload_3        
        //   285: ifnull          297
        //   288: aload_3        
        //   289: invokeinterface android/database/Cursor.close:()V
        //   294: goto            297
        //   297: aload           4
        //   299: ifnull          312
        //   302: aload           4
        //   304: invokeinterface android/database/Cursor.close:()V
        //   309: goto            312
        //   312: aload_2        
        //   313: areturn        
        //   314: astore          5
        //   316: goto            348
        //   319: astore          5
        //   321: aload           5
        //   323: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   326: new             Lorg/litepal/exceptions/DatabaseGenerateException;
        //   329: astore          6
        //   331: aload           5
        //   333: invokevirtual   java/lang/Exception.getMessage:()Ljava/lang/String;
        //   336: astore          9
        //   338: aload           6
        //   340: aload           9
        //   342: invokespecial   org/litepal/exceptions/DatabaseGenerateException.<init>:(Ljava/lang/String;)V
        //   345: aload           6
        //   347: athrow         
        //   348: aload_3        
        //   349: ifnull          361
        //   352: aload_3        
        //   353: invokeinterface android/database/Cursor.close:()V
        //   358: goto            361
        //   361: aload           4
        //   363: ifnull          376
        //   366: aload           4
        //   368: invokeinterface android/database/Cursor.close:()V
        //   373: goto            376
        //   376: aload           5
        //   378: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  13     16     319    348    Ljava/lang/Exception;
        //  13     16     314    379    Any
        //  18     23     319    348    Ljava/lang/Exception;
        //  18     23     314    379    Any
        //  29     35     319    348    Ljava/lang/Exception;
        //  29     35     314    379    Any
        //  37     42     319    348    Ljava/lang/Exception;
        //  37     42     314    379    Any
        //  48     54     319    348    Ljava/lang/Exception;
        //  48     54     314    379    Any
        //  54     59     319    348    Ljava/lang/Exception;
        //  54     59     314    379    Any
        //  67     71     319    348    Ljava/lang/Exception;
        //  67     71     314    379    Any
        //  76     83     319    348    Ljava/lang/Exception;
        //  76     83     314    379    Any
        //  95     102    319    348    Ljava/lang/Exception;
        //  95     102    314    379    Any
        //  105    112    319    348    Ljava/lang/Exception;
        //  105    112    314    379    Any
        //  129    136    319    348    Ljava/lang/Exception;
        //  129    136    314    379    Any
        //  139    146    319    348    Ljava/lang/Exception;
        //  139    146    314    379    Any
        //  148    151    319    348    Ljava/lang/Exception;
        //  148    151    314    379    Any
        //  153    158    319    348    Ljava/lang/Exception;
        //  153    158    314    379    Any
        //  164    170    319    348    Ljava/lang/Exception;
        //  164    170    314    379    Any
        //  172    178    319    348    Ljava/lang/Exception;
        //  172    178    314    379    Any
        //  184    190    319    348    Ljava/lang/Exception;
        //  184    190    314    379    Any
        //  190    195    319    348    Ljava/lang/Exception;
        //  190    195    314    379    Any
        //  200    204    319    348    Ljava/lang/Exception;
        //  200    204    314    379    Any
        //  210    217    319    348    Ljava/lang/Exception;
        //  210    217    314    379    Any
        //  230    237    319    348    Ljava/lang/Exception;
        //  230    237    314    379    Any
        //  241    248    319    348    Ljava/lang/Exception;
        //  241    248    314    379    Any
        //  251    259    319    348    Ljava/lang/Exception;
        //  251    259    314    379    Any
        //  265    271    319    348    Ljava/lang/Exception;
        //  265    271    314    379    Any
        //  321    326    314    379    Any
        //  326    329    314    379    Any
        //  331    336    314    379    Any
        //  340    345    314    379    Any
        //  345    348    314    379    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0262:
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
    
    public static String getIntermediateTableName(final String s, final String s2) {
        if (!TextUtils.isEmpty((CharSequence)s) && !TextUtils.isEmpty((CharSequence)s2)) {
            String s3;
            if (s.toLowerCase().compareTo(s2.toLowerCase()) <= 0) {
                final StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.append("_");
                sb.append(s2);
                s3 = sb.toString();
            }
            else {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(s2);
                sb2.append("_");
                sb2.append(s);
                s3 = sb2.toString();
            }
            return s3;
        }
        return null;
    }
    
    public static String getTableNameByClassName(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return null;
        }
        if ('.' == s.charAt(s.length() - 1)) {
            return null;
        }
        return s.substring(s.lastIndexOf(".") + 1);
    }
    
    public static String getTableNameByForeignColumn(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return null;
        }
        if (s.toLowerCase().endsWith("_id")) {
            return s.substring(0, s.length() - "_id".length());
        }
        return null;
    }
    
    public static List getTableNameListByClassNameList(final List list) {
        final ArrayList<String> list2 = new ArrayList<String>();
        if (list != null && !list.isEmpty()) {
            final Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                list2.add(getTableNameByClassName(iterator.next()));
            }
        }
        return list2;
    }
    
    public static boolean isColumnExists(final String p0, final String p1, final SQLiteDatabase p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //     4: istore_3       
        //     5: iload_3        
        //     6: ifne            231
        //     9: aload_1        
        //    10: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //    13: istore_3       
        //    14: iload_3        
        //    15: ifeq            21
        //    18: goto            231
        //    21: iconst_0       
        //    22: istore_3       
        //    23: aconst_null    
        //    24: astore          4
        //    26: new             Ljava/lang/StringBuilder;
        //    29: astore          5
        //    31: aload           5
        //    33: invokespecial   java/lang/StringBuilder.<init>:()V
        //    36: ldc             "pragma table_info("
        //    38: astore          6
        //    40: aload           5
        //    42: aload           6
        //    44: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    47: pop            
        //    48: aload           5
        //    50: aload_1        
        //    51: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    54: pop            
        //    55: ldc             ")"
        //    57: astore          6
        //    59: aload           5
        //    61: aload           6
        //    63: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    66: pop            
        //    67: aload           5
        //    69: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    72: astore          5
        //    74: iconst_0       
        //    75: istore          7
        //    77: aconst_null    
        //    78: astore          6
        //    80: aload_2        
        //    81: aload           5
        //    83: aconst_null    
        //    84: invokevirtual   android/database/sqlite/SQLiteDatabase.rawQuery:(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
        //    87: astore          6
        //    89: aload           6
        //    91: astore          4
        //    93: aload           6
        //    95: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   100: istore          7
        //   102: iload           7
        //   104: ifeq            171
        //   107: ldc             "name"
        //   109: astore          6
        //   111: aload           4
        //   113: aload           6
        //   115: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //   120: istore          7
        //   122: aload           4
        //   124: iload           7
        //   126: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   131: astore          6
        //   133: aload_0        
        //   134: aload           6
        //   136: invokevirtual   java/lang/String.equalsIgnoreCase:(Ljava/lang/String;)Z
        //   139: istore          8
        //   141: iload           8
        //   143: ifeq            151
        //   146: iconst_1       
        //   147: istore_3       
        //   148: goto            171
        //   151: aload           4
        //   153: invokeinterface android/database/Cursor.moveToNext:()Z
        //   158: istore          7
        //   160: iload           7
        //   162: ifne            168
        //   165: goto            171
        //   168: goto            107
        //   171: aload           4
        //   173: ifnull          186
        //   176: aload           4
        //   178: invokeinterface android/database/Cursor.close:()V
        //   183: goto            211
        //   186: goto            211
        //   189: astore          5
        //   191: goto            213
        //   194: astore          5
        //   196: aload           5
        //   198: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   201: iconst_0       
        //   202: istore_3       
        //   203: aload           4
        //   205: ifnull          186
        //   208: goto            176
        //   211: iload_3        
        //   212: ireturn        
        //   213: aload           4
        //   215: ifnull          228
        //   218: aload           4
        //   220: invokeinterface android/database/Cursor.close:()V
        //   225: goto            228
        //   228: aload           5
        //   230: athrow         
        //   231: iconst_0       
        //   232: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  26     29     194    211    Ljava/lang/Exception;
        //  26     29     189    231    Any
        //  31     36     194    211    Ljava/lang/Exception;
        //  31     36     189    231    Any
        //  42     48     194    211    Ljava/lang/Exception;
        //  42     48     189    231    Any
        //  50     55     194    211    Ljava/lang/Exception;
        //  50     55     189    231    Any
        //  61     67     194    211    Ljava/lang/Exception;
        //  61     67     189    231    Any
        //  67     72     194    211    Ljava/lang/Exception;
        //  67     72     189    231    Any
        //  83     87     194    211    Ljava/lang/Exception;
        //  83     87     189    231    Any
        //  93     100    194    211    Ljava/lang/Exception;
        //  93     100    189    231    Any
        //  113    120    194    211    Ljava/lang/Exception;
        //  113    120    189    231    Any
        //  124    131    194    211    Ljava/lang/Exception;
        //  124    131    189    231    Any
        //  134    139    194    211    Ljava/lang/Exception;
        //  134    139    189    231    Any
        //  151    158    194    211    Ljava/lang/Exception;
        //  151    158    189    231    Any
        //  196    201    189    231    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0107:
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
    
    public static boolean isIntermediateTable(final String s, final SQLiteDatabase sqLiteDatabase) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            if (s.matches("[0-9a-zA-Z]+_[0-9a-zA-Z]+")) {
                Cursor query = null;
                final String s2 = "table_schema";
                final String[] array = null;
                final String s3 = null;
                final String[] array2 = null;
                final String s4 = null;
                final String s5 = null;
                try {
                    Label_0199: {
                        try {
                            Label_0176: {
                                if ((query = sqLiteDatabase.query(s2, array, s3, array2, s4, s5, (String)null)).moveToFirst()) {
                                    while (!s.equalsIgnoreCase(query.getString(query.getColumnIndexOrThrow("name")))) {
                                        if (!query.moveToNext()) {
                                            break Label_0176;
                                        }
                                    }
                                    final int int1 = query.getInt(query.getColumnIndexOrThrow("type"));
                                    final boolean b = true;
                                    if (int1 == (b ? 1 : 0)) {
                                        if (query != null) {
                                            query.close();
                                        }
                                        return b;
                                    }
                                }
                            }
                            if (query != null) {
                                break Label_0199;
                            }
                            return false;
                        }
                        finally {
                            if (query != null) {
                                query.close();
                            }
                            return false;
                            query.close();
                        }
                    }
                }
                catch (Exception ex) {}
            }
        }
        return false;
    }
    
    public static boolean isTableExists(final String s, final SQLiteDatabase sqLiteDatabase) {
        boolean containsIgnoreCases;
        try {
            containsIgnoreCases = BaseUtility.containsIgnoreCases(findAllTableNames(sqLiteDatabase), s);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            containsIgnoreCases = false;
        }
        return containsIgnoreCases;
    }
}
