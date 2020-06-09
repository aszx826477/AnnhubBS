// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.tablemanager;

import android.database.sqlite.SQLiteDatabase;
import org.litepal.util.BaseUtility;
import java.util.Iterator;
import org.litepal.tablemanager.model.TableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class Dropper extends AssociationUpdater
{
    private Collection mTableModels;
    
    private void dropTables() {
        final List tablesToDrop = this.findTablesToDrop();
        this.dropTables(tablesToDrop, this.mDb);
        this.clearCopyInTableSchema(tablesToDrop);
    }
    
    private List findTablesToDrop() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/util/ArrayList;
        //     3: astore_1       
        //     4: aload_1        
        //     5: invokespecial   java/util/ArrayList.<init>:()V
        //     8: aconst_null    
        //     9: astore_2       
        //    10: aload_0        
        //    11: getfield        org/litepal/tablemanager/Dropper.mDb:Landroid/database/sqlite/SQLiteDatabase;
        //    14: astore_3       
        //    15: ldc             "table_schema"
        //    17: astore          4
        //    19: iconst_0       
        //    20: istore          5
        //    22: aconst_null    
        //    23: astore          6
        //    25: aconst_null    
        //    26: astore          7
        //    28: aconst_null    
        //    29: astore          8
        //    31: aload_3        
        //    32: aload           4
        //    34: aconst_null    
        //    35: aconst_null    
        //    36: aconst_null    
        //    37: aconst_null    
        //    38: aconst_null    
        //    39: aconst_null    
        //    40: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    43: astore_3       
        //    44: aload_3        
        //    45: astore_2       
        //    46: aload_3        
        //    47: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    52: istore          9
        //    54: iload           9
        //    56: ifeq            195
        //    59: ldc             "name"
        //    61: astore_3       
        //    62: aload_2        
        //    63: aload_3        
        //    64: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //    69: istore          9
        //    71: aload_2        
        //    72: iload           9
        //    74: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //    79: astore_3       
        //    80: ldc             "type"
        //    82: astore          4
        //    84: aload_2        
        //    85: aload           4
        //    87: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //    92: istore          10
        //    94: aload_2        
        //    95: iload           10
        //    97: invokeinterface android/database/Cursor.getInt:(I)I
        //   102: istore          10
        //   104: aload_0        
        //   105: aload_3        
        //   106: iload           10
        //   108: invokespecial   org/litepal/tablemanager/Dropper.shouldDropThisTable:(Ljava/lang/String;I)Z
        //   111: istore          5
        //   113: iload           5
        //   115: ifeq            176
        //   118: ldc             "AssociationUpdater"
        //   120: astore          6
        //   122: new             Ljava/lang/StringBuilder;
        //   125: astore          7
        //   127: aload           7
        //   129: invokespecial   java/lang/StringBuilder.<init>:()V
        //   132: ldc             "need to drop "
        //   134: astore          8
        //   136: aload           7
        //   138: aload           8
        //   140: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   143: pop            
        //   144: aload           7
        //   146: aload_3        
        //   147: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   150: pop            
        //   151: aload           7
        //   153: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   156: astore          7
        //   158: aload           6
        //   160: aload           7
        //   162: invokestatic    org/litepal/util/LogUtil.d:(Ljava/lang/String;Ljava/lang/String;)V
        //   165: aload_1        
        //   166: aload_3        
        //   167: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   172: pop            
        //   173: goto            176
        //   176: aload_2        
        //   177: invokeinterface android/database/Cursor.moveToNext:()Z
        //   182: istore          9
        //   184: iload           9
        //   186: ifne            192
        //   189: goto            195
        //   192: goto            59
        //   195: aload_2        
        //   196: ifnull          208
        //   199: aload_2        
        //   200: invokeinterface android/database/Cursor.close:()V
        //   205: goto            227
        //   208: goto            227
        //   211: astore_3       
        //   212: goto            229
        //   215: astore_3       
        //   216: aload_3        
        //   217: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   220: aload_2        
        //   221: ifnull          208
        //   224: goto            199
        //   227: aload_1        
        //   228: areturn        
        //   229: aload_2        
        //   230: ifnull          242
        //   233: aload_2        
        //   234: invokeinterface android/database/Cursor.close:()V
        //   239: goto            242
        //   242: aload_3        
        //   243: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  10     14     215    227    Ljava/lang/Exception;
        //  10     14     211    244    Any
        //  39     43     215    227    Ljava/lang/Exception;
        //  39     43     211    244    Any
        //  46     52     215    227    Ljava/lang/Exception;
        //  46     52     211    244    Any
        //  63     69     215    227    Ljava/lang/Exception;
        //  63     69     211    244    Any
        //  72     79     215    227    Ljava/lang/Exception;
        //  72     79     211    244    Any
        //  85     92     215    227    Ljava/lang/Exception;
        //  85     92     211    244    Any
        //  95     102    215    227    Ljava/lang/Exception;
        //  95     102    211    244    Any
        //  106    111    215    227    Ljava/lang/Exception;
        //  106    111    211    244    Any
        //  122    125    215    227    Ljava/lang/Exception;
        //  122    125    211    244    Any
        //  127    132    215    227    Ljava/lang/Exception;
        //  127    132    211    244    Any
        //  138    144    215    227    Ljava/lang/Exception;
        //  138    144    211    244    Any
        //  146    151    215    227    Ljava/lang/Exception;
        //  146    151    211    244    Any
        //  151    156    215    227    Ljava/lang/Exception;
        //  151    156    211    244    Any
        //  160    165    215    227    Ljava/lang/Exception;
        //  160    165    211    244    Any
        //  166    173    215    227    Ljava/lang/Exception;
        //  166    173    211    244    Any
        //  176    182    215    227    Ljava/lang/Exception;
        //  176    182    211    244    Any
        //  216    220    211    244    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0176:
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
    
    private List pickTableNamesFromTableModels() {
        final ArrayList<String> list = new ArrayList<String>();
        final Iterator<TableModel> iterator = this.mTableModels.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().getTableName());
        }
        return list;
    }
    
    private boolean shouldDropThisTable(final String s, final int n) {
        return !BaseUtility.containsIgnoreCases(this.pickTableNamesFromTableModels(), s) && n == 0;
    }
    
    protected void createOrUpgradeTable(final SQLiteDatabase mDb, final boolean b) {
        this.mTableModels = this.getAllTableModels();
        this.mDb = mDb;
        this.dropTables();
    }
}
