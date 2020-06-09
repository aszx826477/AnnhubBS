// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.tablemanager;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import android.text.TextUtils;
import org.litepal.util.LogUtil;
import org.litepal.exceptions.DatabaseGenerateException;
import android.database.Cursor;
import java.util.List;
import org.litepal.util.DBUtility;
import org.litepal.tablemanager.model.ColumnModel;
import java.util.ArrayList;
import java.util.Iterator;
import org.litepal.tablemanager.model.AssociationsModel;
import android.database.sqlite.SQLiteDatabase;
import java.util.Collection;

public abstract class AssociationCreator extends Generator
{
    private void addAssociations(final Collection collection, final SQLiteDatabase sqLiteDatabase, final boolean b) {
        for (final AssociationsModel associationsModel : collection) {
            if (2 != associationsModel.getAssociationType() && 1 != associationsModel.getAssociationType()) {
                if (3 != associationsModel.getAssociationType()) {
                    continue;
                }
                this.createIntermediateTable(associationsModel.getTableName(), associationsModel.getAssociatedTableName(), sqLiteDatabase, b);
            }
            else {
                this.addForeignKeyColumn(associationsModel.getTableName(), associationsModel.getAssociatedTableName(), associationsModel.getTableHoldsForeignKey(), sqLiteDatabase);
            }
        }
    }
    
    private void createIntermediateTable(final String s, final String s2, final SQLiteDatabase sqLiteDatabase, final boolean b) {
        final ArrayList<ColumnModel> list = new ArrayList<ColumnModel>();
        final ColumnModel columnModel = new ColumnModel();
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("_id");
        columnModel.setColumnName(sb.toString());
        columnModel.setColumnType("integer");
        final ColumnModel columnModel2 = new ColumnModel();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(s2);
        sb2.append("_id");
        columnModel2.setColumnName(sb2.toString());
        columnModel2.setColumnType("integer");
        list.add(columnModel);
        list.add(columnModel2);
        final String intermediateTableName = DBUtility.getIntermediateTableName(s, s2);
        final ArrayList<String> list2 = new ArrayList<String>();
        if (DBUtility.isTableExists(intermediateTableName, sqLiteDatabase)) {
            if (b) {
                list2.add(this.generateDropTableSQL(intermediateTableName));
                list2.add(this.generateCreateTableSQL(intermediateTableName, list, false));
            }
        }
        else {
            list2.add(this.generateCreateTableSQL(intermediateTableName, list, false));
        }
        this.execute(list2.toArray(new String[0]), sqLiteDatabase);
        this.giveTableSchemaACopy(intermediateTableName, 1, sqLiteDatabase);
    }
    
    private boolean isNeedtoGiveACopy(final Cursor cursor, final String s) {
        return !this.isValueExists(cursor, s) && !this.isSpecialTable(s);
    }
    
    private boolean isSpecialTable(final String s) {
        return "table_schema".equalsIgnoreCase(s);
    }
    
    private boolean isValueExists(final Cursor cursor, final String s) {
        boolean b = false;
        if (cursor.moveToFirst()) {
            while (!cursor.getString(cursor.getColumnIndexOrThrow("name")).equalsIgnoreCase(s)) {
                if (!cursor.moveToNext()) {
                    return b;
                }
            }
            b = true;
        }
        return b;
    }
    
    protected void addForeignKeyColumn(final String s, final String s2, final String s3, final SQLiteDatabase sqLiteDatabase) {
        if (!DBUtility.isTableExists(s, sqLiteDatabase)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Table doesn't exist with the name of ");
            sb.append(s);
            throw new DatabaseGenerateException(sb.toString());
        }
        if (DBUtility.isTableExists(s2, sqLiteDatabase)) {
            String columnName = null;
            if (s.equals(s3)) {
                columnName = this.getForeignKeyColumnName(s2);
            }
            else if (s2.equals(s3)) {
                columnName = this.getForeignKeyColumnName(s);
            }
            if (!DBUtility.isColumnExists(columnName, s3, sqLiteDatabase)) {
                final ColumnModel columnModel = new ColumnModel();
                columnModel.setColumnName(columnName);
                columnModel.setColumnType("integer");
                this.execute(new String[] { this.generateAddColumnSQL(s3, columnModel) }, sqLiteDatabase);
            }
            else {
                final String s4 = "Generator";
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("column ");
                sb2.append(columnName);
                sb2.append(" is already exist, no need to add one");
                LogUtil.d(s4, sb2.toString());
            }
            return;
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("Table doesn't exist with the name of ");
        sb3.append(s2);
        throw new DatabaseGenerateException(sb3.toString());
    }
    
    protected void addOrUpdateAssociation(final SQLiteDatabase sqLiteDatabase, final boolean b) {
        this.addAssociations(this.getAllAssociations(), sqLiteDatabase, b);
    }
    
    protected abstract void createOrUpgradeTable(final SQLiteDatabase p0, final boolean p1);
    
    protected String generateAddColumnSQL(final String s, final ColumnModel columnModel) {
        final StringBuilder sb = new StringBuilder();
        sb.append("alter table ");
        sb.append(s);
        sb.append(" add column ");
        sb.append(columnModel.getColumnName());
        sb.append(" ");
        sb.append(columnModel.getColumnType());
        if (!columnModel.isNullable()) {
            sb.append(" not null");
        }
        if (columnModel.isUnique()) {
            sb.append(" unique");
        }
        String defaultValue = columnModel.getDefaultValue();
        if (!TextUtils.isEmpty((CharSequence)defaultValue)) {
            sb.append(" default ");
            sb.append(defaultValue);
        }
        else if (!columnModel.isNullable()) {
            if ("integer".equalsIgnoreCase(columnModel.getColumnType())) {
                defaultValue = "0";
            }
            else if ("text".equalsIgnoreCase(columnModel.getColumnType())) {
                defaultValue = "''";
            }
            else if ("real".equalsIgnoreCase(columnModel.getColumnType())) {
                defaultValue = "0.0";
            }
            sb.append(" default ");
            sb.append(defaultValue);
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("add column sql is >> ");
        sb2.append((Object)sb);
        LogUtil.d("Generator", sb2.toString());
        return sb.toString();
    }
    
    protected String generateCreateTableSQL(final String s, final List list, final boolean b) {
        final StringBuilder sb = new StringBuilder("create table ");
        sb.append(s);
        sb.append(" (");
        if (b) {
            sb.append("id integer primary key autoincrement,");
        }
        if (list.size() == 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        int n = 0;
        for (final ColumnModel columnModel : list) {
            if (columnModel.isIdColumn()) {
                continue;
            }
            if (n != 0) {
                sb.append(", ");
            }
            n = 1;
            sb.append(columnModel.getColumnName());
            sb.append(" ");
            sb.append(columnModel.getColumnType());
            if (!columnModel.isNullable()) {
                sb.append(" not null");
            }
            if (columnModel.isUnique()) {
                sb.append(" unique");
            }
            final String defaultValue = columnModel.getDefaultValue();
            if (TextUtils.isEmpty((CharSequence)defaultValue)) {
                continue;
            }
            sb.append(" default ");
            sb.append(defaultValue);
        }
        sb.append(")");
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("create table sql is >> ");
        sb2.append((Object)sb);
        LogUtil.d("Generator", sb2.toString());
        return sb.toString();
    }
    
    protected String generateDropTableSQL(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("drop table if exists ");
        sb.append(s);
        return sb.toString();
    }
    
    protected void giveTableSchemaACopy(final String p0, final int p1, final SQLiteDatabase p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/lang/StringBuilder;
        //     3: astore          4
        //     5: aload           4
        //     7: ldc_w           "select * from "
        //    10: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    13: aload           4
        //    15: ldc             "table_schema"
        //    17: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    20: pop            
        //    21: new             Ljava/lang/StringBuilder;
        //    24: astore          5
        //    26: aload           5
        //    28: invokespecial   java/lang/StringBuilder.<init>:()V
        //    31: ldc_w           "giveTableSchemaACopy SQL is >> "
        //    34: astore          6
        //    36: aload           5
        //    38: aload           6
        //    40: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    43: pop            
        //    44: aload           5
        //    46: aload           4
        //    48: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    51: pop            
        //    52: aload           5
        //    54: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    57: astore          5
        //    59: ldc             "Generator"
        //    61: aload           5
        //    63: invokestatic    org/litepal/util/LogUtil.d:(Ljava/lang/String;Ljava/lang/String;)V
        //    66: aconst_null    
        //    67: astore          7
        //    69: aload           4
        //    71: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    74: astore          5
        //    76: aconst_null    
        //    77: astore          6
        //    79: aload_3        
        //    80: aload           5
        //    82: aconst_null    
        //    83: invokevirtual   android/database/sqlite/SQLiteDatabase.rawQuery:(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
        //    86: astore          5
        //    88: aload           5
        //    90: astore          7
        //    92: aload_0        
        //    93: aload           5
        //    95: aload_1        
        //    96: invokespecial   org/litepal/tablemanager/AssociationCreator.isNeedtoGiveACopy:(Landroid/database/Cursor;Ljava/lang/String;)Z
        //    99: istore          8
        //   101: iload           8
        //   103: ifeq            172
        //   106: new             Landroid/content/ContentValues;
        //   109: astore          5
        //   111: aload           5
        //   113: invokespecial   android/content/ContentValues.<init>:()V
        //   116: ldc             "name"
        //   118: astore          9
        //   120: aload_1        
        //   121: invokestatic    org/litepal/util/BaseUtility.changeCase:(Ljava/lang/String;)Ljava/lang/String;
        //   124: astore          10
        //   126: aload           5
        //   128: aload           9
        //   130: aload           10
        //   132: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/String;)V
        //   135: ldc_w           "type"
        //   138: astore          9
        //   140: iload_2        
        //   141: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   144: astore          10
        //   146: aload           5
        //   148: aload           9
        //   150: aload           10
        //   152: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Integer;)V
        //   155: ldc             "table_schema"
        //   157: astore          9
        //   159: aload_3        
        //   160: aload           9
        //   162: aconst_null    
        //   163: aload           5
        //   165: invokevirtual   android/database/sqlite/SQLiteDatabase.insert:(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
        //   168: pop2           
        //   169: goto            172
        //   172: aload           7
        //   174: ifnull          187
        //   177: aload           7
        //   179: invokeinterface android/database/Cursor.close:()V
        //   184: goto            210
        //   187: goto            210
        //   190: astore          5
        //   192: goto            211
        //   195: astore          5
        //   197: aload           5
        //   199: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   202: aload           7
        //   204: ifnull          187
        //   207: goto            177
        //   210: return         
        //   211: aload           7
        //   213: ifnull          226
        //   216: aload           7
        //   218: invokeinterface android/database/Cursor.close:()V
        //   223: goto            226
        //   226: aload           5
        //   228: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  69     74     195    210    Ljava/lang/Exception;
        //  69     74     190    229    Any
        //  82     86     195    210    Ljava/lang/Exception;
        //  82     86     190    229    Any
        //  95     99     195    210    Ljava/lang/Exception;
        //  95     99     190    229    Any
        //  106    109    195    210    Ljava/lang/Exception;
        //  106    109    190    229    Any
        //  111    116    195    210    Ljava/lang/Exception;
        //  111    116    190    229    Any
        //  120    124    195    210    Ljava/lang/Exception;
        //  120    124    190    229    Any
        //  130    135    195    210    Ljava/lang/Exception;
        //  130    135    190    229    Any
        //  140    144    195    210    Ljava/lang/Exception;
        //  140    144    190    229    Any
        //  150    155    195    210    Ljava/lang/Exception;
        //  150    155    190    229    Any
        //  163    169    195    210    Ljava/lang/Exception;
        //  163    169    190    229    Any
        //  197    202    190    229    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0172:
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
    
    protected boolean isForeignKeyColumnFormat(final String s) {
        final boolean empty = TextUtils.isEmpty((CharSequence)s);
        boolean b = false;
        if (!empty) {
            if (s.toLowerCase().endsWith("_id") && !s.equalsIgnoreCase("_id")) {
                b = true;
            }
            return b;
        }
        return false;
    }
}
