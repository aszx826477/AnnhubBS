// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.crud;

import org.litepal.exceptions.DatabaseGenerateException;
import android.util.SparseArray;
import java.lang.reflect.Constructor;
import org.litepal.exceptions.DataSupportException;
import java.lang.reflect.Method;
import java.util.Date;
import android.database.Cursor;
import android.content.ContentValues;
import org.litepal.util.DBUtility;
import java.lang.reflect.Field;
import org.litepal.util.BaseUtility;
import java.util.Iterator;
import java.util.Collection;
import org.litepal.crud.model.AssociationsInfo;
import java.util.ArrayList;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import org.litepal.LitePalBase;

abstract class DataHandler extends LitePalBase
{
    public static final String TAG = "DataHandler";
    private List fkInCurrentModel;
    private List fkInOtherModel;
    SQLiteDatabase mDatabase;
    private DataSupport tempEmptyModel;
    
    private void analyzeAssociations(final String s) {
        final Collection associationInfo = this.getAssociationInfo(s);
        final List fkInCurrentModel = this.fkInCurrentModel;
        if (fkInCurrentModel == null) {
            this.fkInCurrentModel = new ArrayList();
        }
        else {
            fkInCurrentModel.clear();
        }
        final List fkInOtherModel = this.fkInOtherModel;
        if (fkInOtherModel == null) {
            this.fkInOtherModel = new ArrayList();
        }
        else {
            fkInOtherModel.clear();
        }
        for (final AssociationsInfo associationsInfo : associationInfo) {
            if (associationsInfo.getAssociationType() != 2 && associationsInfo.getAssociationType() != 1) {
                if (associationsInfo.getAssociationType() != 3) {
                    continue;
                }
                this.fkInOtherModel.add(associationsInfo);
            }
            else if (associationsInfo.getClassHoldsForeignKey().equals(s)) {
                this.fkInCurrentModel.add(associationsInfo);
            }
            else {
                this.fkInOtherModel.add(associationsInfo);
            }
        }
    }
    
    private String genGetColumnMethod(final Class clazz) {
        String s;
        if (clazz.isPrimitive()) {
            s = BaseUtility.capitalize(clazz.getName());
        }
        else {
            s = clazz.getSimpleName();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("get");
        sb.append(s);
        String string = sb.toString();
        if ("getBoolean".equals(string)) {
            string = "getInt";
        }
        else if (!"getChar".equals(string) && !"getCharacter".equals(string)) {
            if ("getDate".equals(string)) {
                string = "getLong";
            }
            else if ("getInteger".equals(string)) {
                string = "getInt";
            }
            else if ("getbyte[]".equalsIgnoreCase(string)) {
                string = "getBlob";
            }
        }
        else {
            string = "getString";
        }
        return string;
    }
    
    private String genGetColumnMethod(final Field field) {
        return this.genGetColumnMethod(field.getType());
    }
    
    private String[] getCustomizedColumns(String[] array, final List list) {
        if (array != null) {
            if (list != null && list.size() > 0) {
                final String[] array2 = new String[array.length + list.size()];
                System.arraycopy(array, 0, array2, 0, array.length);
                for (int i = 0; i < list.size(); ++i) {
                    array2[array.length + i] = this.getForeignKeyColumnName(DBUtility.getTableNameByClassName(list.get(i).getAssociatedClassName()));
                }
                array = array2;
            }
            for (int j = 0; j < array.length; ++j) {
                final String s = array[j];
                if (this.isIdColumn(s)) {
                    if ("_id".equalsIgnoreCase(s)) {
                        array[j] = BaseUtility.changeCase("id");
                    }
                    return array;
                }
            }
            final String[] array3 = new String[array.length + 1];
            System.arraycopy(array, 0, array3, 0, array.length);
            array3[array.length] = BaseUtility.changeCase("id");
            return array3;
        }
        return null;
    }
    
    private Object getInitParamValue(final Class clazz, final Class clazz2) {
        final String name = clazz2.getName();
        if ("boolean".equals(name) || "java.lang.Boolean".equals(name)) {
            return false;
        }
        if ("float".equals(name) || "java.lang.Float".equals(name)) {
            return 0.0f;
        }
        if ("double".equals(name) || "java.lang.Double".equals(name)) {
            return 0.0;
        }
        if ("int".equals(name) || "java.lang.Integer".equals(name)) {
            return 0;
        }
        if ("long".equals(name) || "java.lang.Long".equals(name)) {
            return 0L;
        }
        if ("short".equals(name) || "java.lang.Short".equals(name)) {
            return 0;
        }
        if ("char".equals(name) || "java.lang.Character".equals(name)) {
            return ' ';
        }
        if ("[B".equals(name) || "[Ljava.lang.Byte;".equals(name)) {
            return new byte[0];
        }
        if ("java.lang.String".equals(name)) {
            return "";
        }
        if (clazz == clazz2) {
            return null;
        }
        return this.createInstanceFromClass(clazz2);
    }
    
    private Class getObjectType(final Class clazz) {
        if (clazz != null) {
            if (clazz.isPrimitive()) {
                final String name = clazz.getName();
                if ("int".equals(name)) {
                    return Integer.class;
                }
                if ("short".equals(name)) {
                    return Short.class;
                }
                if ("long".equals(name)) {
                    return Long.class;
                }
                if ("float".equals(name)) {
                    return Float.class;
                }
                if ("double".equals(name)) {
                    return Double.class;
                }
                if ("boolean".equals(name)) {
                    return Boolean.class;
                }
                if ("char".equals(name)) {
                    return Character.class;
                }
            }
        }
        return null;
    }
    
    private Class[] getParameterTypes(final Field field, final Object o, final Object[] array) {
        final boolean charType = this.isCharType(field);
        final int n = 2;
        final int n2 = 1;
        Class[] array2;
        if (charType) {
            array[n2] = String.valueOf(o);
            array2 = new Class[n];
            array2[n2] = (array2[0] = String.class);
        }
        else if (field.getType().isPrimitive()) {
            array2 = new Class[n];
            array2[0] = String.class;
            array2[n2] = this.getObjectType(field.getType());
        }
        else if ("java.util.Date".equals(field.getType().getName())) {
            array2 = new Class[n];
            array2[0] = String.class;
            array2[n2] = Long.class;
        }
        else {
            array2 = new Class[n];
            array2[0] = String.class;
            array2[n2] = field.getType();
        }
        return array2;
    }
    
    private boolean isCharType(final Field field) {
        final String name = field.getType().getName();
        return name.equals("char") || name.endsWith("Character");
    }
    
    private boolean isFieldWithDefaultValue(final DataSupport dataSupport, final Field field) {
        final DataSupport emptyModel = this.getEmptyModel(dataSupport);
        final Object takeGetMethodValueByField = this.takeGetMethodValueByField(dataSupport, field);
        final Object takeGetMethodValueByField2 = this.takeGetMethodValueByField(emptyModel, field);
        if (takeGetMethodValueByField != null && takeGetMethodValueByField2 != null) {
            return this.takeGetMethodValueByField(dataSupport, field).toString().equals(this.takeGetMethodValueByField(emptyModel, field).toString());
        }
        return takeGetMethodValueByField == takeGetMethodValueByField2;
    }
    
    private boolean isPrimitiveBooleanType(final Field field) {
        return "boolean".equals(field.getType().getName());
    }
    
    private boolean isSaving() {
        return SaveHandler.class.getName().equals(this.getClass().getName());
    }
    
    private boolean isUpdating() {
        return UpdateHandler.class.getName().equals(this.getClass().getName());
    }
    
    private String makeGetterMethodName(final Field field) {
        String s = field.getName();
        String s2;
        if (this.isPrimitiveBooleanType(field)) {
            if (s.matches("^is[A-Z]{1}.*$")) {
                s = s.substring(2);
            }
            s2 = "is";
        }
        else {
            s2 = "get";
        }
        if (s.matches("^[a-z]{1}[A-Z]{1}.*")) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s2);
            sb.append(s);
            return sb.toString();
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(s2);
        sb2.append(BaseUtility.capitalize(s));
        return sb2.toString();
    }
    
    private String makeSetterMethodName(final Field field) {
        final String s = "set";
        String s2;
        if (this.isPrimitiveBooleanType(field) && field.getName().matches("^is[A-Z]{1}.*$")) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(field.getName().substring(2));
            s2 = sb.toString();
        }
        else if (field.getName().matches("^[a-z]{1}[A-Z]{1}.*")) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append(field.getName());
            s2 = sb2.toString();
        }
        else {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(s);
            sb3.append(BaseUtility.capitalize(field.getName()));
            s2 = sb3.toString();
        }
        return s2;
    }
    
    private void putFieldsValueDependsOnSaveOrUpdate(final DataSupport dataSupport, final Field field, final ContentValues contentValues) {
        if (this.isUpdating()) {
            if (!this.isFieldWithDefaultValue(dataSupport, field)) {
                this.putContentValuesForUpdate(dataSupport, field, contentValues);
            }
        }
        else if (this.isSaving()) {
            this.putContentValuesForSave(dataSupport, field, contentValues);
        }
    }
    
    private void setAssociatedModel(final DataSupport p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: astore_2       
        //     2: aload_1        
        //     3: astore_3       
        //     4: aload_0        
        //     5: getfield        org/litepal/crud/DataHandler.fkInOtherModel:Ljava/util/List;
        //     8: astore          4
        //    10: aload           4
        //    12: ifnonnull       16
        //    15: return         
        //    16: aload           4
        //    18: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //    23: astore          5
        //    25: aload           5
        //    27: invokeinterface java/util/Iterator.hasNext:()Z
        //    32: istore          6
        //    34: iload           6
        //    36: ifeq            818
        //    39: aload           5
        //    41: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    46: astore          4
        //    48: aload           4
        //    50: astore          7
        //    52: aload           4
        //    54: checkcast       Lorg/litepal/crud/model/AssociationsInfo;
        //    57: astore          7
        //    59: iconst_0       
        //    60: istore          8
        //    62: aconst_null    
        //    63: astore          9
        //    65: aload           7
        //    67: invokevirtual   org/litepal/crud/model/AssociationsInfo.getAssociatedClassName:()Ljava/lang/String;
        //    70: astore          10
        //    72: aload           7
        //    74: invokevirtual   org/litepal/crud/model/AssociationsInfo.getAssociationType:()I
        //    77: istore          6
        //    79: iconst_3       
        //    80: istore          11
        //    82: aconst_null    
        //    83: astore          12
        //    85: iload           6
        //    87: iload           11
        //    89: if_icmpne       98
        //    92: iconst_1       
        //    93: istore          6
        //    95: goto            104
        //    98: iconst_0       
        //    99: istore          6
        //   101: aconst_null    
        //   102: astore          4
        //   104: iload           6
        //   106: istore          13
        //   108: aload_2        
        //   109: aload           10
        //   111: invokevirtual   org/litepal/crud/DataHandler.getSupportedFields:(Ljava/lang/String;)Ljava/util/List;
        //   114: astore          14
        //   116: iconst_2       
        //   117: istore          6
        //   119: iload           13
        //   121: ifeq            358
        //   124: aload_1        
        //   125: invokevirtual   org/litepal/crud/DataSupport.getTableName:()Ljava/lang/String;
        //   128: astore          15
        //   130: aload           10
        //   132: invokestatic    org/litepal/util/DBUtility.getTableNameByClassName:(Ljava/lang/String;)Ljava/lang/String;
        //   135: astore          16
        //   137: aload           15
        //   139: aload           16
        //   141: invokestatic    org/litepal/util/DBUtility.getIntermediateTableName:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   144: astore          17
        //   146: new             Ljava/lang/StringBuilder;
        //   149: astore          18
        //   151: aload           18
        //   153: invokespecial   java/lang/StringBuilder.<init>:()V
        //   156: ldc_w           "select * from "
        //   159: astore          19
        //   161: aload           18
        //   163: aload           19
        //   165: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   168: pop            
        //   169: aload           18
        //   171: aload           16
        //   173: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   176: pop            
        //   177: ldc_w           " a inner join "
        //   180: astore          19
        //   182: aload           18
        //   184: aload           19
        //   186: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   189: pop            
        //   190: aload           18
        //   192: aload           17
        //   194: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   197: pop            
        //   198: ldc_w           " b on a.id = b."
        //   201: astore          19
        //   203: aload           18
        //   205: aload           19
        //   207: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   210: pop            
        //   211: new             Ljava/lang/StringBuilder;
        //   214: astore          19
        //   216: aload           19
        //   218: invokespecial   java/lang/StringBuilder.<init>:()V
        //   221: aload           19
        //   223: aload           16
        //   225: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   228: pop            
        //   229: ldc             "_id"
        //   231: astore          20
        //   233: aload           19
        //   235: aload           20
        //   237: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   240: pop            
        //   241: aload           19
        //   243: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   246: astore          20
        //   248: aload           18
        //   250: aload           20
        //   252: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   255: pop            
        //   256: ldc_w           " where b."
        //   259: astore          20
        //   261: aload           18
        //   263: aload           20
        //   265: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   268: pop            
        //   269: aload           18
        //   271: aload           15
        //   273: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   276: pop            
        //   277: ldc_w           "_id = ?"
        //   280: astore          20
        //   282: aload           18
        //   284: aload           20
        //   286: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   289: pop            
        //   290: iload           6
        //   292: anewarray       Ljava/lang/String;
        //   295: astore          20
        //   297: aload           18
        //   299: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   302: astore          19
        //   304: aload           19
        //   306: invokestatic    org/litepal/util/BaseUtility.changeCase:(Ljava/lang/String;)Ljava/lang/String;
        //   309: astore          19
        //   311: aload           20
        //   313: iconst_0       
        //   314: aload           19
        //   316: aastore        
        //   317: aload_1        
        //   318: invokevirtual   org/litepal/crud/DataSupport.getBaseObjId:()J
        //   321: lstore          21
        //   323: lload           21
        //   325: invokestatic    java/lang/String.valueOf:(J)Ljava/lang/String;
        //   328: astore          12
        //   330: iconst_1       
        //   331: istore          23
        //   333: aload           20
        //   335: iload           23
        //   337: aload           12
        //   339: aastore        
        //   340: aload           20
        //   342: invokestatic    org/litepal/crud/DataSupport.findBySQL:([Ljava/lang/String;)Landroid/database/Cursor;
        //   345: astore          12
        //   347: aload           12
        //   349: astore          9
        //   351: aload           12
        //   353: astore          20
        //   355: goto            493
        //   358: aload           7
        //   360: invokevirtual   org/litepal/crud/model/AssociationsInfo.getSelfClassName:()Ljava/lang/String;
        //   363: astore          15
        //   365: aload           15
        //   367: invokestatic    org/litepal/util/DBUtility.getTableNameByClassName:(Ljava/lang/String;)Ljava/lang/String;
        //   370: astore          15
        //   372: aload_2        
        //   373: aload           15
        //   375: invokevirtual   org/litepal/crud/DataHandler.getForeignKeyColumnName:(Ljava/lang/String;)Ljava/lang/String;
        //   378: astore          15
        //   380: aload           10
        //   382: invokestatic    org/litepal/util/DBUtility.getTableNameByClassName:(Ljava/lang/String;)Ljava/lang/String;
        //   385: astore          16
        //   387: aload_2        
        //   388: getfield        org/litepal/crud/DataHandler.mDatabase:Landroid/database/sqlite/SQLiteDatabase;
        //   391: astore          17
        //   393: aload           16
        //   395: invokestatic    org/litepal/util/BaseUtility.changeCase:(Ljava/lang/String;)Ljava/lang/String;
        //   398: astore          24
        //   400: new             Ljava/lang/StringBuilder;
        //   403: astore          20
        //   405: aload           20
        //   407: invokespecial   java/lang/StringBuilder.<init>:()V
        //   410: aload           20
        //   412: aload           15
        //   414: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   417: pop            
        //   418: ldc_w           "=?"
        //   421: astore          18
        //   423: aload           20
        //   425: aload           18
        //   427: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   430: pop            
        //   431: aload           20
        //   433: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   436: astore          25
        //   438: iconst_1       
        //   439: istore          26
        //   441: iload           26
        //   443: anewarray       Ljava/lang/String;
        //   446: astore          18
        //   448: aload_1        
        //   449: invokevirtual   org/litepal/crud/DataSupport.getBaseObjId:()J
        //   452: lstore          27
        //   454: lload           27
        //   456: invokestatic    java/lang/String.valueOf:(J)Ljava/lang/String;
        //   459: astore          20
        //   461: aload           18
        //   463: iconst_0       
        //   464: aload           20
        //   466: aastore        
        //   467: aload           17
        //   469: aload           24
        //   471: aconst_null    
        //   472: aload           25
        //   474: aload           18
        //   476: aconst_null    
        //   477: aconst_null    
        //   478: aconst_null    
        //   479: aconst_null    
        //   480: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   483: astore          12
        //   485: aload           12
        //   487: astore          9
        //   489: aload           12
        //   491: astore          20
        //   493: aload           20
        //   495: ifnull          751
        //   498: aload           20
        //   500: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   505: istore          8
        //   507: iload           8
        //   509: ifeq            751
        //   512: new             Landroid/util/SparseArray;
        //   515: astore          17
        //   517: aload           17
        //   519: invokespecial   android/util/SparseArray.<init>:()V
        //   522: aload           10
        //   524: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   527: astore          9
        //   529: aload_2        
        //   530: aload           9
        //   532: invokevirtual   org/litepal/crud/DataHandler.createInstanceFromClass:(Ljava/lang/Class;)Ljava/lang/Object;
        //   535: astore          9
        //   537: aload           9
        //   539: checkcast       Lorg/litepal/crud/DataSupport;
        //   542: astore          18
        //   544: ldc             "id"
        //   546: astore          9
        //   548: aload           20
        //   550: aload           9
        //   552: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //   557: istore          8
        //   559: aload           20
        //   561: iload           8
        //   563: invokeinterface android/database/Cursor.getLong:(I)J
        //   568: lstore          29
        //   570: aload_2        
        //   571: aload           18
        //   573: lload           29
        //   575: invokevirtual   org/litepal/crud/DataHandler.giveBaseObjIdValue:(Lorg/litepal/crud/DataSupport;J)V
        //   578: aconst_null    
        //   579: astore          12
        //   581: aload_0        
        //   582: astore          9
        //   584: aload           18
        //   586: astore          15
        //   588: aload           20
        //   590: astore          16
        //   592: aload_0        
        //   593: aload           18
        //   595: aload           14
        //   597: aconst_null    
        //   598: aload           20
        //   600: aload           17
        //   602: invokevirtual   org/litepal/crud/DataHandler.setValueToModel:(Ljava/lang/Object;Ljava/util/List;Ljava/util/List;Landroid/database/Cursor;Landroid/util/SparseArray;)V
        //   605: aload           7
        //   607: invokevirtual   org/litepal/crud/model/AssociationsInfo.getAssociationType:()I
        //   610: istore          8
        //   612: iload           8
        //   614: iload           6
        //   616: if_icmpeq       669
        //   619: iload           13
        //   621: ifeq            630
        //   624: iconst_1       
        //   625: istore          11
        //   627: goto            672
        //   630: aload           7
        //   632: invokevirtual   org/litepal/crud/model/AssociationsInfo.getAssociationType:()I
        //   635: istore          8
        //   637: iconst_1       
        //   638: istore          11
        //   640: iload           8
        //   642: iload           11
        //   644: if_icmpne       666
        //   647: aload           7
        //   649: invokevirtual   org/litepal/crud/model/AssociationsInfo.getAssociateOtherModelFromSelf:()Ljava/lang/reflect/Field;
        //   652: astore          9
        //   654: aload_2        
        //   655: aload_3        
        //   656: aload           9
        //   658: aload           18
        //   660: invokevirtual   org/litepal/crud/DataHandler.putSetMethodValueByField:(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;Ljava/lang/Object;)V
        //   663: goto            708
        //   666: goto            708
        //   669: iconst_1       
        //   670: istore          11
        //   672: aload           7
        //   674: invokevirtual   org/litepal/crud/model/AssociationsInfo.getAssociateOtherModelFromSelf:()Ljava/lang/reflect/Field;
        //   677: astore          9
        //   679: aload_2        
        //   680: aload_3        
        //   681: aload           9
        //   683: invokevirtual   org/litepal/crud/DataHandler.takeGetMethodValueByField:(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;)Ljava/lang/Object;
        //   686: astore          9
        //   688: aload           9
        //   690: checkcast       Ljava/util/Collection;
        //   693: astore          9
        //   695: aload           9
        //   697: aload           18
        //   699: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   704: pop            
        //   705: goto            666
        //   708: aload           20
        //   710: invokeinterface android/database/Cursor.moveToNext:()Z
        //   715: istore          8
        //   717: iload           8
        //   719: ifne            730
        //   722: aload           17
        //   724: invokevirtual   android/util/SparseArray.clear:()V
        //   727: goto            751
        //   730: goto            522
        //   733: astore          4
        //   735: aload           20
        //   737: astore          9
        //   739: goto            800
        //   742: astore          4
        //   744: aload           20
        //   746: astore          9
        //   748: goto            776
        //   751: aload           20
        //   753: ifnull          766
        //   756: aload           20
        //   758: invokeinterface android/database/Cursor.close:()V
        //   763: goto            766
        //   766: goto            25
        //   769: astore          4
        //   771: goto            800
        //   774: astore          4
        //   776: new             Lorg/litepal/exceptions/DataSupportException;
        //   779: astore          15
        //   781: aload           4
        //   783: invokevirtual   java/lang/Exception.getMessage:()Ljava/lang/String;
        //   786: astore          14
        //   788: aload           15
        //   790: aload           14
        //   792: aload           4
        //   794: invokespecial   org/litepal/exceptions/DataSupportException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   797: aload           15
        //   799: athrow         
        //   800: aload           9
        //   802: ifnull          815
        //   805: aload           9
        //   807: invokeinterface android/database/Cursor.close:()V
        //   812: goto            815
        //   815: aload           4
        //   817: athrow         
        //   818: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  109    114    774    776    Ljava/lang/Exception;
        //  109    114    769    774    Any
        //  124    128    774    776    Ljava/lang/Exception;
        //  124    128    769    774    Any
        //  130    135    774    776    Ljava/lang/Exception;
        //  130    135    769    774    Any
        //  139    144    774    776    Ljava/lang/Exception;
        //  139    144    769    774    Any
        //  146    149    774    776    Ljava/lang/Exception;
        //  146    149    769    774    Any
        //  151    156    774    776    Ljava/lang/Exception;
        //  151    156    769    774    Any
        //  163    169    774    776    Ljava/lang/Exception;
        //  163    169    769    774    Any
        //  171    177    774    776    Ljava/lang/Exception;
        //  171    177    769    774    Any
        //  184    190    774    776    Ljava/lang/Exception;
        //  184    190    769    774    Any
        //  192    198    774    776    Ljava/lang/Exception;
        //  192    198    769    774    Any
        //  205    211    774    776    Ljava/lang/Exception;
        //  205    211    769    774    Any
        //  211    214    774    776    Ljava/lang/Exception;
        //  211    214    769    774    Any
        //  216    221    774    776    Ljava/lang/Exception;
        //  216    221    769    774    Any
        //  223    229    774    776    Ljava/lang/Exception;
        //  223    229    769    774    Any
        //  235    241    774    776    Ljava/lang/Exception;
        //  235    241    769    774    Any
        //  241    246    774    776    Ljava/lang/Exception;
        //  241    246    769    774    Any
        //  250    256    774    776    Ljava/lang/Exception;
        //  250    256    769    774    Any
        //  263    269    774    776    Ljava/lang/Exception;
        //  263    269    769    774    Any
        //  271    277    774    776    Ljava/lang/Exception;
        //  271    277    769    774    Any
        //  284    290    774    776    Ljava/lang/Exception;
        //  284    290    769    774    Any
        //  290    295    774    776    Ljava/lang/Exception;
        //  290    295    769    774    Any
        //  297    302    774    776    Ljava/lang/Exception;
        //  297    302    769    774    Any
        //  304    309    774    776    Ljava/lang/Exception;
        //  304    309    769    774    Any
        //  314    317    774    776    Ljava/lang/Exception;
        //  314    317    769    774    Any
        //  317    321    774    776    Ljava/lang/Exception;
        //  317    321    769    774    Any
        //  323    328    774    776    Ljava/lang/Exception;
        //  323    328    769    774    Any
        //  337    340    774    776    Ljava/lang/Exception;
        //  337    340    769    774    Any
        //  340    345    774    776    Ljava/lang/Exception;
        //  340    345    769    774    Any
        //  358    363    774    776    Ljava/lang/Exception;
        //  358    363    769    774    Any
        //  365    370    774    776    Ljava/lang/Exception;
        //  365    370    769    774    Any
        //  373    378    774    776    Ljava/lang/Exception;
        //  373    378    769    774    Any
        //  380    385    774    776    Ljava/lang/Exception;
        //  380    385    769    774    Any
        //  387    391    774    776    Ljava/lang/Exception;
        //  387    391    769    774    Any
        //  393    398    774    776    Ljava/lang/Exception;
        //  393    398    769    774    Any
        //  400    403    774    776    Ljava/lang/Exception;
        //  400    403    769    774    Any
        //  405    410    774    776    Ljava/lang/Exception;
        //  405    410    769    774    Any
        //  412    418    774    776    Ljava/lang/Exception;
        //  412    418    769    774    Any
        //  425    431    774    776    Ljava/lang/Exception;
        //  425    431    769    774    Any
        //  431    436    774    776    Ljava/lang/Exception;
        //  431    436    769    774    Any
        //  441    446    774    776    Ljava/lang/Exception;
        //  441    446    769    774    Any
        //  448    452    774    776    Ljava/lang/Exception;
        //  448    452    769    774    Any
        //  454    459    774    776    Ljava/lang/Exception;
        //  454    459    769    774    Any
        //  464    467    774    776    Ljava/lang/Exception;
        //  464    467    769    774    Any
        //  479    483    774    776    Ljava/lang/Exception;
        //  479    483    769    774    Any
        //  498    505    742    751    Ljava/lang/Exception;
        //  498    505    733    742    Any
        //  512    515    742    751    Ljava/lang/Exception;
        //  512    515    733    742    Any
        //  517    522    742    751    Ljava/lang/Exception;
        //  517    522    733    742    Any
        //  522    527    742    751    Ljava/lang/Exception;
        //  522    527    733    742    Any
        //  530    535    742    751    Ljava/lang/Exception;
        //  530    535    733    742    Any
        //  537    542    742    751    Ljava/lang/Exception;
        //  537    542    733    742    Any
        //  550    557    742    751    Ljava/lang/Exception;
        //  550    557    733    742    Any
        //  561    568    742    751    Ljava/lang/Exception;
        //  561    568    733    742    Any
        //  573    578    742    751    Ljava/lang/Exception;
        //  573    578    733    742    Any
        //  600    605    742    751    Ljava/lang/Exception;
        //  600    605    733    742    Any
        //  605    610    742    751    Ljava/lang/Exception;
        //  605    610    733    742    Any
        //  630    635    742    751    Ljava/lang/Exception;
        //  630    635    733    742    Any
        //  647    652    742    751    Ljava/lang/Exception;
        //  647    652    733    742    Any
        //  658    663    742    751    Ljava/lang/Exception;
        //  658    663    733    742    Any
        //  672    677    742    751    Ljava/lang/Exception;
        //  672    677    733    742    Any
        //  681    686    742    751    Ljava/lang/Exception;
        //  681    686    733    742    Any
        //  688    693    742    751    Ljava/lang/Exception;
        //  688    693    733    742    Any
        //  697    705    742    751    Ljava/lang/Exception;
        //  697    705    733    742    Any
        //  708    715    742    751    Ljava/lang/Exception;
        //  708    715    733    742    Any
        //  722    727    742    751    Ljava/lang/Exception;
        //  722    727    733    742    Any
        //  776    779    769    774    Any
        //  781    786    769    774    Any
        //  792    797    769    774    Any
        //  797    800    769    774    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0493:
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
    
    private void setToModelByReflection(final Object o, final Field field, final int n, final String s, final Cursor cursor) {
        final Class<? extends Cursor> class1 = cursor.getClass();
        final int n2 = 1;
        final Class[] array = new Class[n2];
        array[0] = Integer.TYPE;
        final Method method = class1.getMethod(s, (Class<?>[])array);
        final Object[] array2 = new Object[n2];
        array2[0] = n;
        Object o2 = method.invoke(cursor, array2);
        if (field.getType() != Boolean.TYPE && field.getType() != Boolean.class) {
            if (field.getType() != Character.TYPE && field.getType() != Character.class) {
                if (field.getType() == Date.class) {
                    final long longValue = (long)o2;
                    if (longValue <= 0L) {
                        o2 = null;
                    }
                    else {
                        o2 = new Date(longValue);
                    }
                }
            }
            else {
                o2 = ((String)o2).charAt(0);
            }
        }
        else if ("0".equals(String.valueOf(o2))) {
            o2 = false;
        }
        else if ("1".equals(String.valueOf(o2))) {
            o2 = (n2 != 0);
        }
        DynamicExecutor.setField(o, field.getName(), o2, o.getClass());
    }
    
    protected void analyzeAssociatedModels(final DataSupport dataSupport, final Collection collection) {
        try {
            final Iterator<AssociationsInfo> iterator = collection.iterator();
            try {
                while (true) {
                    if (!iterator.hasNext()) {
                        return;
                    }
                    final AssociationsInfo next = iterator.next();
                    try {
                        final AssociationsInfo associationsInfo = next;
                        try {
                            Label_0073: {
                                if (associationsInfo.getAssociationType() != 2) {
                                    break Label_0073;
                                }
                                try {
                                    new Many2OneAnalyzer().analyze(dataSupport, associationsInfo);
                                    Label_0149: {
                                        break Label_0149;
                                        try {
                                            new One2OneAnalyzer().analyze(dataSupport, associationsInfo);
                                            break Label_0149;
                                            try {
                                                new Many2ManyAnalyzer().analyze(dataSupport, associationsInfo);
                                                continue;
                                            }
                                            catch (Exception ex) {
                                                throw new DataSupportException(ex.getMessage(), ex);
                                            }
                                            Label_0111:;
                                        }
                                        // iftrue(Label_0149:, associationsInfo.getAssociationType() != 3)
                                        catch (Exception ex2) {}
                                    }
                                }
                                // iftrue(Label_0111:, associationsInfo.getAssociationType() != 1)
                                catch (Exception ex3) {}
                            }
                        }
                        catch (Exception ex4) {}
                    }
                    catch (Exception ex5) {}
                }
            }
            catch (Exception ex6) {}
        }
        catch (Exception ex7) {}
    }
    
    protected Object createInstanceFromClass(final Class clazz) {
        try {
            final Constructor bestSuitConstructor = this.findBestSuitConstructor(clazz);
            return bestSuitConstructor.newInstance(this.getConstructorParams(clazz, bestSuitConstructor));
        }
        catch (Exception ex) {
            throw new DataSupportException(ex.getMessage(), ex);
        }
    }
    
    protected Constructor findBestSuitConstructor(final Class clazz) {
        final Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        final SparseArray sparseArray = new SparseArray();
        int n = -1 >>> 1;
        final Constructor[] array = declaredConstructors;
        for (int length = declaredConstructors.length, i = 0; i < length; ++i) {
            final Constructor constructor = array[i];
            int length2 = constructor.getParameterTypes().length;
            Class[] parameterTypes;
            for (int length3 = (parameterTypes = constructor.getParameterTypes()).length, j = 0; j < length3; ++j) {
                if (parameterTypes[j] == clazz) {
                    length2 += 10000;
                }
            }
            if (sparseArray.get(length2) == null) {
                sparseArray.put(length2, (Object)constructor);
            }
            if (length2 < n) {
                n = length2;
            }
        }
        final Constructor constructor2 = (Constructor)sparseArray.get(n);
        if (constructor2 != null) {
            constructor2.setAccessible(true);
        }
        return constructor2;
    }
    
    protected Class findDataSupportClass(final DataSupport dataSupport) {
        Class<? super DataSupport> superclass;
        do {
            superclass = dataSupport.getClass().getSuperclass();
        } while (superclass != null && DataSupport.class != superclass);
        if (superclass != null) {
            return superclass;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(dataSupport.getClass().getName());
        sb.append(" should be inherited from DataSupport");
        throw new DataSupportException(sb.toString());
    }
    
    protected DataSupport getAssociatedModel(final DataSupport dataSupport, final AssociationsInfo associationsInfo) {
        return (DataSupport)this.takeGetMethodValueByField(dataSupport, associationsInfo.getAssociateOtherModelFromSelf());
    }
    
    protected Collection getAssociatedModels(final DataSupport dataSupport, final AssociationsInfo associationsInfo) {
        return (Collection)this.takeGetMethodValueByField(dataSupport, associationsInfo.getAssociateOtherModelFromSelf());
    }
    
    protected Object[] getConstructorParams(final Class clazz, final Constructor constructor) {
        final Class[] parameterTypes = constructor.getParameterTypes();
        final Object[] array = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; ++i) {
            array[i] = this.getInitParamValue(clazz, parameterTypes[i]);
        }
        return array;
    }
    
    protected DataSupport getEmptyModel(final DataSupport dataSupport) {
        final DataSupport tempEmptyModel = this.tempEmptyModel;
        if (tempEmptyModel != null) {
            return tempEmptyModel;
        }
        String className = null;
        try {
            final Class<?> forName = Class.forName(className = dataSupport.getClassName());
            try {
                final Object instance = forName.newInstance();
                try {
                    return this.tempEmptyModel = (DataSupport)instance;
                }
                catch (Exception ex) {
                    throw new DataSupportException(ex.getMessage(), ex);
                }
                catch (InstantiationException ex2) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(className);
                    sb.append(" needs a default constructor.");
                    throw new DataSupportException(sb.toString(), ex2);
                }
                catch (ClassNotFoundException ex3) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("can not find a class named ");
                    sb2.append(className);
                    throw new DatabaseGenerateException(sb2.toString());
                }
            }
            catch (Exception ex4) {}
            catch (InstantiationException ex5) {}
            catch (ClassNotFoundException ex6) {}
        }
        catch (Exception ex7) {}
        catch (InstantiationException ex8) {}
        catch (ClassNotFoundException ex9) {}
    }
    
    protected List getForeignKeyAssociations(final String s, final boolean b) {
        if (b) {
            this.analyzeAssociations(s);
            return this.fkInCurrentModel;
        }
        return null;
    }
    
    protected String getIntermediateTableName(final DataSupport dataSupport, final String s) {
        return BaseUtility.changeCase(DBUtility.getIntermediateTableName(dataSupport.getTableName(), s));
    }
    
    protected String getTableName(final Class clazz) {
        return BaseUtility.changeCase(DBUtility.getTableNameByClassName(clazz.getName()));
    }
    
    protected String[] getWhereArgs(final String... array) {
        final int n = 1;
        final Object[] array2 = new Object[n];
        array2[0] = array;
        if (this.isAffectAllLines(array2)) {
            return null;
        }
        if (array != null && array.length > n) {
            final String[] array3 = new String[array.length - n];
            System.arraycopy(array, n, array3, 0, array.length - n);
            return array3;
        }
        return null;
    }
    
    protected String getWhereClause(final String... array) {
        if (this.isAffectAllLines(array)) {
            return null;
        }
        if (array != null && array.length > 0) {
            return array[0];
        }
        return null;
    }
    
    protected String getWhereOfIdsWithOr(final Collection collection) {
        final StringBuilder sb = new StringBuilder();
        int n = 0;
        for (final long longValue : collection) {
            if (n != 0) {
                sb.append(" or ");
            }
            n = 1;
            sb.append("id = ");
            sb.append(longValue);
        }
        return BaseUtility.changeCase(sb.toString());
    }
    
    protected String getWhereOfIdsWithOr(final long... array) {
        final StringBuilder sb = new StringBuilder();
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            final long n2 = array[i];
            if (n != 0) {
                sb.append(" or ");
            }
            n = 1;
            sb.append("id = ");
            sb.append(n2);
        }
        return BaseUtility.changeCase(sb.toString());
    }
    
    protected void giveBaseObjIdValue(final DataSupport dataSupport, final long n) {
        if (n > 0L) {
            DynamicExecutor.set(dataSupport, "baseObjId", n, DataSupport.class);
        }
    }
    
    protected boolean isAffectAllLines(final Object... array) {
        return array != null && array.length == 0;
    }
    
    protected Object mathQuery(final String p0, final String[] p1, final String[] p2, final Class p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_3        
        //     1: invokestatic    org/litepal/util/BaseUtility.checkConditionsCorrect:([Ljava/lang/String;)V
        //     4: aconst_null    
        //     5: astore          5
        //     7: aconst_null    
        //     8: astore          6
        //    10: aload_0        
        //    11: getfield        org/litepal/crud/DataHandler.mDatabase:Landroid/database/sqlite/SQLiteDatabase;
        //    14: astore          7
        //    16: aload_0        
        //    17: aload_3        
        //    18: invokevirtual   org/litepal/crud/DataHandler.getWhereClause:([Ljava/lang/String;)Ljava/lang/String;
        //    21: astore          8
        //    23: aload_0        
        //    24: aload_3        
        //    25: invokevirtual   org/litepal/crud/DataHandler.getWhereArgs:([Ljava/lang/String;)[Ljava/lang/String;
        //    28: astore          9
        //    30: aload_1        
        //    31: astore          10
        //    33: aload_2        
        //    34: astore          11
        //    36: aload           7
        //    38: aload_1        
        //    39: aload_2        
        //    40: aload           8
        //    42: aload           9
        //    44: aconst_null    
        //    45: aconst_null    
        //    46: aconst_null    
        //    47: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    50: astore          7
        //    52: aload           7
        //    54: astore          5
        //    56: aload           7
        //    58: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    63: istore          12
        //    65: iload           12
        //    67: ifeq            154
        //    70: aload           7
        //    72: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //    75: astore          7
        //    77: aload_0        
        //    78: aload           4
        //    80: invokespecial   org/litepal/crud/DataHandler.genGetColumnMethod:(Ljava/lang/Class;)Ljava/lang/String;
        //    83: astore          10
        //    85: iconst_1       
        //    86: istore          13
        //    88: iload           13
        //    90: anewarray       Ljava/lang/Class;
        //    93: astore          8
        //    95: getstatic       java/lang/Integer.TYPE:Ljava/lang/Class;
        //    98: astore          9
        //   100: aload           8
        //   102: iconst_0       
        //   103: aload           9
        //   105: aastore        
        //   106: aload           7
        //   108: aload           10
        //   110: aload           8
        //   112: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   115: astore          10
        //   117: iload           13
        //   119: anewarray       Ljava/lang/Object;
        //   122: astore          11
        //   124: iconst_0       
        //   125: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   128: astore          8
        //   130: aload           11
        //   132: iconst_0       
        //   133: aload           8
        //   135: aastore        
        //   136: aload           10
        //   138: aload           5
        //   140: aload           11
        //   142: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   145: astore          11
        //   147: aload           11
        //   149: astore          6
        //   151: goto            154
        //   154: aload           5
        //   156: ifnull          169
        //   159: aload           5
        //   161: invokeinterface android/database/Cursor.close:()V
        //   166: goto            169
        //   169: aload           6
        //   171: areturn        
        //   172: astore          7
        //   174: goto            203
        //   177: astore          7
        //   179: new             Lorg/litepal/exceptions/DataSupportException;
        //   182: astore          10
        //   184: aload           7
        //   186: invokevirtual   java/lang/Exception.getMessage:()Ljava/lang/String;
        //   189: astore          11
        //   191: aload           10
        //   193: aload           11
        //   195: aload           7
        //   197: invokespecial   org/litepal/exceptions/DataSupportException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   200: aload           10
        //   202: athrow         
        //   203: aload           5
        //   205: ifnull          218
        //   208: aload           5
        //   210: invokeinterface android/database/Cursor.close:()V
        //   215: goto            218
        //   218: aload           7
        //   220: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  10     14     177    203    Ljava/lang/Exception;
        //  10     14     172    221    Any
        //  17     21     177    203    Ljava/lang/Exception;
        //  17     21     172    221    Any
        //  24     28     177    203    Ljava/lang/Exception;
        //  24     28     172    221    Any
        //  46     50     177    203    Ljava/lang/Exception;
        //  46     50     172    221    Any
        //  56     63     177    203    Ljava/lang/Exception;
        //  56     63     172    221    Any
        //  70     75     177    203    Ljava/lang/Exception;
        //  70     75     172    221    Any
        //  78     83     177    203    Ljava/lang/Exception;
        //  78     83     172    221    Any
        //  88     93     177    203    Ljava/lang/Exception;
        //  88     93     172    221    Any
        //  95     98     177    203    Ljava/lang/Exception;
        //  95     98     172    221    Any
        //  103    106    177    203    Ljava/lang/Exception;
        //  103    106    172    221    Any
        //  110    115    177    203    Ljava/lang/Exception;
        //  110    115    172    221    Any
        //  117    122    177    203    Ljava/lang/Exception;
        //  117    122    172    221    Any
        //  124    128    177    203    Ljava/lang/Exception;
        //  124    128    172    221    Any
        //  133    136    177    203    Ljava/lang/Exception;
        //  133    136    172    221    Any
        //  140    145    177    203    Ljava/lang/Exception;
        //  140    145    172    221    Any
        //  179    182    172    221    Any
        //  184    189    172    221    Any
        //  195    200    172    221    Any
        //  200    203    172    221    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0154:
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
    
    protected void putContentValuesForSave(final DataSupport dataSupport, final Field field, final ContentValues contentValues) {
        Object o = DynamicExecutor.getField(dataSupport, field.getName(), dataSupport.getClass());
        if (o != null) {
            if ("java.util.Date".equals(field.getType().getName())) {
                o = ((Date)o).getTime();
            }
            final Object[] array = { BaseUtility.changeCase(field.getName()), o };
            DynamicExecutor.send(contentValues, "put", array, contentValues.getClass(), this.getParameterTypes(field, o, array));
        }
    }
    
    protected void putContentValuesForUpdate(final DataSupport dataSupport, final Field field, final ContentValues contentValues) {
        Object o = this.takeGetMethodValueByField(dataSupport, field);
        if ("java.util.Date".equals(field.getType().getName()) && o != null) {
            o = ((Date)o).getTime();
        }
        final Object[] array = { BaseUtility.changeCase(field.getName()), o };
        DynamicExecutor.send(contentValues, "put", array, contentValues.getClass(), this.getParameterTypes(field, o, array));
    }
    
    protected void putFieldsValue(final DataSupport dataSupport, final List list, final ContentValues contentValues) {
        for (final Field field : list) {
            if (!this.isIdColumn(field.getName())) {
                this.putFieldsValueDependsOnSaveOrUpdate(dataSupport, field, contentValues);
            }
        }
    }
    
    protected void putSetMethodValueByField(final DataSupport dataSupport, final Field field, final Object o) {
        if (this.shouldGetOrSet(dataSupport, field)) {
            final String setterMethodName = this.makeSetterMethodName(field);
            final int n = 1;
            final Object[] array = new Object[n];
            array[0] = o;
            final Class<? extends DataSupport> class1 = dataSupport.getClass();
            final Class[] array2 = new Class[n];
            array2[0] = field.getType();
            DynamicExecutor.send(dataSupport, setterMethodName, array, class1, array2);
        }
    }
    
    protected List query(final Class p0, final String[] p1, final String p2, final String[] p3, final String p4, final String p5, final String p6, final String p7, final List p8) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: astore          10
        //     3: aload           9
        //     5: astore          11
        //     7: new             Ljava/util/ArrayList;
        //    10: astore          12
        //    12: aload           12
        //    14: invokespecial   java/util/ArrayList.<init>:()V
        //    17: aload           12
        //    19: astore          13
        //    21: aconst_null    
        //    22: astore          14
        //    24: aload_1        
        //    25: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //    28: astore          12
        //    30: aload_0        
        //    31: aload           12
        //    33: invokevirtual   org/litepal/crud/DataHandler.getSupportedFields:(Ljava/lang/String;)Ljava/util/List;
        //    36: astore          15
        //    38: aload_0        
        //    39: aload_1        
        //    40: invokevirtual   org/litepal/crud/DataHandler.getTableName:(Ljava/lang/Class;)Ljava/lang/String;
        //    43: astore          16
        //    45: aload_0        
        //    46: aload_2        
        //    47: aload           9
        //    49: invokespecial   org/litepal/crud/DataHandler.getCustomizedColumns:([Ljava/lang/String;Ljava/util/List;)[Ljava/lang/String;
        //    52: astore          17
        //    54: aload_0        
        //    55: getfield        org/litepal/crud/DataHandler.mDatabase:Landroid/database/sqlite/SQLiteDatabase;
        //    58: astore          18
        //    60: aload           18
        //    62: aload           16
        //    64: aload           17
        //    66: aload_3        
        //    67: aload           4
        //    69: aload           5
        //    71: aload           6
        //    73: aload           7
        //    75: aload           8
        //    77: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    80: astore          12
        //    82: aload           12
        //    84: astore          18
        //    86: aload           12
        //    88: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    93: istore          19
        //    95: iload           19
        //    97: ifeq            245
        //   100: new             Landroid/util/SparseArray;
        //   103: astore          20
        //   105: aload           20
        //   107: invokespecial   android/util/SparseArray.<init>:()V
        //   110: aload_0        
        //   111: aload_1        
        //   112: invokevirtual   org/litepal/crud/DataHandler.createInstanceFromClass:(Ljava/lang/Class;)Ljava/lang/Object;
        //   115: astore          12
        //   117: aload           12
        //   119: astore          14
        //   121: aload           12
        //   123: checkcast       Lorg/litepal/crud/DataSupport;
        //   126: astore          14
        //   128: ldc             "id"
        //   130: astore          21
        //   132: aload           18
        //   134: aload           21
        //   136: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //   141: istore          22
        //   143: aload           18
        //   145: iload           22
        //   147: invokeinterface android/database/Cursor.getLong:(I)J
        //   152: lstore          23
        //   154: aload           10
        //   156: aload           14
        //   158: lload           23
        //   160: invokevirtual   org/litepal/crud/DataHandler.giveBaseObjIdValue:(Lorg/litepal/crud/DataSupport;J)V
        //   163: aload_0        
        //   164: astore          14
        //   166: aload           12
        //   168: astore          21
        //   170: aload_0        
        //   171: aload           12
        //   173: aload           15
        //   175: aload           9
        //   177: aload           18
        //   179: aload           20
        //   181: invokevirtual   org/litepal/crud/DataHandler.setValueToModel:(Ljava/lang/Object;Ljava/util/List;Ljava/util/List;Landroid/database/Cursor;Landroid/util/SparseArray;)V
        //   184: aload           11
        //   186: ifnull          210
        //   189: aload           12
        //   191: astore          14
        //   193: aload           12
        //   195: checkcast       Lorg/litepal/crud/DataSupport;
        //   198: astore          14
        //   200: aload           10
        //   202: aload           14
        //   204: invokespecial   org/litepal/crud/DataHandler.setAssociatedModel:(Lorg/litepal/crud/DataSupport;)V
        //   207: goto            210
        //   210: aload           13
        //   212: aload           12
        //   214: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   219: pop            
        //   220: aload           18
        //   222: invokeinterface android/database/Cursor.moveToNext:()Z
        //   227: istore          19
        //   229: iload           19
        //   231: ifne            242
        //   234: aload           20
        //   236: invokevirtual   android/util/SparseArray.clear:()V
        //   239: goto            245
        //   242: goto            110
        //   245: aload           18
        //   247: ifnull          260
        //   250: aload           18
        //   252: invokeinterface android/database/Cursor.close:()V
        //   257: goto            260
        //   260: aload           13
        //   262: areturn        
        //   263: astore          12
        //   265: goto            312
        //   268: astore          12
        //   270: aload           18
        //   272: astore          14
        //   274: goto            288
        //   277: astore          12
        //   279: aload           14
        //   281: astore          18
        //   283: goto            312
        //   286: astore          12
        //   288: new             Lorg/litepal/exceptions/DataSupportException;
        //   291: astore          21
        //   293: aload           12
        //   295: invokevirtual   java/lang/Exception.getMessage:()Ljava/lang/String;
        //   298: astore          15
        //   300: aload           21
        //   302: aload           15
        //   304: aload           12
        //   306: invokespecial   org/litepal/exceptions/DataSupportException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   309: aload           21
        //   311: athrow         
        //   312: aload           18
        //   314: ifnull          327
        //   317: aload           18
        //   319: invokeinterface android/database/Cursor.close:()V
        //   324: goto            327
        //   327: aload           12
        //   329: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  24     28     286    288    Ljava/lang/Exception;
        //  24     28     277    286    Any
        //  31     36     286    288    Ljava/lang/Exception;
        //  31     36     277    286    Any
        //  39     43     286    288    Ljava/lang/Exception;
        //  39     43     277    286    Any
        //  47     52     286    288    Ljava/lang/Exception;
        //  47     52     277    286    Any
        //  54     58     286    288    Ljava/lang/Exception;
        //  54     58     277    286    Any
        //  75     80     286    288    Ljava/lang/Exception;
        //  75     80     277    286    Any
        //  86     93     268    277    Ljava/lang/Exception;
        //  86     93     263    268    Any
        //  100    103    268    277    Ljava/lang/Exception;
        //  100    103    263    268    Any
        //  105    110    268    277    Ljava/lang/Exception;
        //  105    110    263    268    Any
        //  111    115    268    277    Ljava/lang/Exception;
        //  111    115    263    268    Any
        //  121    126    268    277    Ljava/lang/Exception;
        //  121    126    263    268    Any
        //  134    141    268    277    Ljava/lang/Exception;
        //  134    141    263    268    Any
        //  145    152    268    277    Ljava/lang/Exception;
        //  145    152    263    268    Any
        //  158    163    268    277    Ljava/lang/Exception;
        //  158    163    263    268    Any
        //  179    184    268    277    Ljava/lang/Exception;
        //  179    184    263    268    Any
        //  193    198    268    277    Ljava/lang/Exception;
        //  193    198    263    268    Any
        //  202    207    268    277    Ljava/lang/Exception;
        //  202    207    263    268    Any
        //  212    220    268    277    Ljava/lang/Exception;
        //  212    220    263    268    Any
        //  220    227    268    277    Ljava/lang/Exception;
        //  220    227    263    268    Any
        //  234    239    268    277    Ljava/lang/Exception;
        //  234    239    263    268    Any
        //  288    291    277    286    Any
        //  293    298    277    286    Any
        //  304    309    277    286    Any
        //  309    312    277    286    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0110:
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
    
    protected void setValueToModel(final Object o, final List list, final List list2, final Cursor cursor, final SparseArray sparseArray) {
        final int size = sparseArray.size();
        final int n = -1;
        if (size > 0) {
            for (int i = 0; i < size; ++i) {
                final int key = sparseArray.keyAt(i);
                final DataHandler$QueryInfoCache dataHandler$QueryInfoCache = (DataHandler$QueryInfoCache)sparseArray.get(key);
                this.setToModelByReflection(o, dataHandler$QueryInfoCache.field, key, dataHandler$QueryInfoCache.getMethodName, cursor);
            }
        }
        else {
            for (final Field field : list) {
                final String genGetColumnMethod = this.genGetColumnMethod(field);
                String name;
                if (this.isIdColumn(field.getName())) {
                    name = "id";
                }
                else {
                    name = field.getName();
                }
                final int columnIndex = cursor.getColumnIndex(BaseUtility.changeCase(name));
                if (columnIndex != n) {
                    this.setToModelByReflection(o, field, columnIndex, genGetColumnMethod, cursor);
                    final DataHandler$QueryInfoCache dataHandler$QueryInfoCache2 = new DataHandler$QueryInfoCache(this);
                    dataHandler$QueryInfoCache2.getMethodName = genGetColumnMethod;
                    dataHandler$QueryInfoCache2.field = field;
                    sparseArray.put(columnIndex, (Object)dataHandler$QueryInfoCache2);
                }
            }
        }
        if (list2 != null) {
        Label_0459_Outer:
            for (final AssociationsInfo associationsInfo : list2) {
                final int columnIndex2 = cursor.getColumnIndex(this.getForeignKeyColumnName(DBUtility.getTableNameByClassName(associationsInfo.getAssociatedClassName())));
                if (columnIndex2 != n) {
                    final long long1 = cursor.getLong(columnIndex2);
                    try {
                        final String associatedClassName = associationsInfo.getAssociatedClassName();
                        try {
                            final Object find = DataSupport.find(Class.forName(associatedClassName), long1);
                            try {
                                final DataSupport dataSupport = (DataSupport)find;
                                while (true) {
                                    if (dataSupport != null) {
                                        final DataSupport dataSupport2 = (DataSupport)o;
                                        try {
                                            this.putSetMethodValueByField(dataSupport2, associationsInfo.getAssociateOtherModelFromSelf(), dataSupport);
                                        }
                                        catch (ClassNotFoundException ex) {
                                            ex.printStackTrace();
                                        }
                                        continue Label_0459_Outer;
                                    }
                                    continue;
                                }
                            }
                            catch (ClassNotFoundException ex2) {}
                        }
                        catch (ClassNotFoundException ex3) {}
                    }
                    catch (ClassNotFoundException ex4) {}
                }
            }
        }
    }
    
    protected boolean shouldGetOrSet(final DataSupport dataSupport, final Field field) {
        return dataSupport != null && field != null;
    }
    
    protected Object takeGetMethodValueByField(final DataSupport dataSupport, final Field field) {
        if (this.shouldGetOrSet(dataSupport, field)) {
            return DynamicExecutor.send(dataSupport, this.makeGetterMethodName(field), null, dataSupport.getClass(), null);
        }
        return null;
    }
}
