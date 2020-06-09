// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal;

import java.util.Set;
import org.litepal.tablemanager.model.TableModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
import org.litepal.util.BaseUtility;
import org.litepal.crud.DataSupport;
import java.util.List;
import org.litepal.parser.LitePalAttr;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;
import org.litepal.annotation.Column;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.util.DBUtility;
import org.litepal.tablemanager.model.AssociationsModel;
import org.litepal.crud.model.AssociationsInfo;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.litepal.tablemanager.typechange.BlobOrm;
import org.litepal.tablemanager.typechange.DateOrm;
import org.litepal.tablemanager.typechange.DecimalOrm;
import org.litepal.tablemanager.typechange.BooleanOrm;
import org.litepal.tablemanager.typechange.TextOrm;
import org.litepal.tablemanager.typechange.NumericOrm;
import org.litepal.tablemanager.typechange.OrmChange;
import java.util.Collection;
import java.util.Map;

public abstract class LitePalBase
{
    private static final int GET_ASSOCIATIONS_ACTION = 1;
    private static final int GET_ASSOCIATION_INFO_ACTION = 2;
    public static final String TAG = "LitePalBase";
    private Map classFieldsMap;
    private Collection mAssociationInfos;
    private Collection mAssociationModels;
    private OrmChange[] typeChangeRules;
    
    public LitePalBase() {
        this.typeChangeRules = new OrmChange[] { new NumericOrm(), new TextOrm(), new BooleanOrm(), new DecimalOrm(), new DateOrm(), new BlobOrm() };
        this.classFieldsMap = new HashMap();
    }
    
    private void addIntoAssociationInfoCollection(final String selfClassName, final String associatedClassName, final String classHoldsForeignKey, final Field associateOtherModelFromSelf, final Field associateSelfFromOtherModel, final int associationType) {
        final AssociationsInfo associationsInfo = new AssociationsInfo();
        associationsInfo.setSelfClassName(selfClassName);
        associationsInfo.setAssociatedClassName(associatedClassName);
        associationsInfo.setClassHoldsForeignKey(classHoldsForeignKey);
        associationsInfo.setAssociateOtherModelFromSelf(associateOtherModelFromSelf);
        associationsInfo.setAssociateSelfFromOtherModel(associateSelfFromOtherModel);
        associationsInfo.setAssociationType(associationType);
        this.mAssociationInfos.add(associationsInfo);
    }
    
    private void addIntoAssociationModelCollection(final String s, final String s2, final String s3, final int associationType) {
        final AssociationsModel associationsModel = new AssociationsModel();
        associationsModel.setTableName(DBUtility.getTableNameByClassName(s));
        associationsModel.setAssociatedTableName(DBUtility.getTableNameByClassName(s2));
        associationsModel.setTableHoldsForeignKey(DBUtility.getTableNameByClassName(s3));
        associationsModel.setAssociationType(associationType);
        this.mAssociationModels.add(associationsModel);
    }
    
    private void analyzeClassFields(final String s, final int n) {
        try {
            final Class<?> forName = Class.forName(s);
            try {
                Field[] declaredFields;
                for (int length = (declaredFields = forName.getDeclaredFields()).length, i = 0; i < length; ++i) {
                    final Field field = declaredFields[i];
                    if (this.isPrivateAndNonPrimitive(field)) {
                        this.oneToAnyConditions(s, field, n);
                        this.manyToAnyConditions(s, field, n);
                    }
                }
            }
            catch (ClassNotFoundException ex) {
                ex.printStackTrace();
                final StringBuilder sb = new StringBuilder();
                sb.append("can not find a class named ");
                sb.append(s);
                throw new DatabaseGenerateException(sb.toString());
            }
        }
        catch (ClassNotFoundException ex2) {}
    }
    
    private ColumnModel convertFieldToColumnModel(final Field field) {
        String object2Relation = null;
        final String name = field.getType().getName();
        final OrmChange[] typeChangeRules = this.typeChangeRules;
        for (int length = typeChangeRules.length, i = 0; i < length; ++i) {
            object2Relation = typeChangeRules[i].object2Relation(name);
            if (object2Relation != null) {
                break;
            }
        }
        boolean nullable = true;
        boolean unique = false;
        String defaultValue = "";
        final Column column = field.getAnnotation(Column.class);
        if (column != null) {
            nullable = column.nullable();
            unique = column.unique();
            defaultValue = column.defaultValue();
        }
        final ColumnModel columnModel = new ColumnModel();
        columnModel.setColumnName(field.getName());
        columnModel.setColumnType(object2Relation);
        columnModel.setIsNullable(nullable);
        columnModel.setIsUnique(unique);
        columnModel.setDefaultValue(defaultValue);
        return columnModel;
    }
    
    private String getGenericTypeName(final Field field) {
        final Type genericType = field.getGenericType();
        if (genericType != null && genericType instanceof ParameterizedType) {
            return ((Class)((ParameterizedType)genericType).getActualTypeArguments()[0]).getName();
        }
        return null;
    }
    
    private boolean isPrivateAndNonPrimitive(final Field field) {
        return Modifier.isPrivate(field.getModifiers()) && !field.getType().isPrimitive();
    }
    
    private void manyToAnyConditions(final String s, final Field field, final int n) {
        if (this.isCollection(field.getType())) {
            final String genericTypeName = this.getGenericTypeName(field);
            if (LitePalAttr.getInstance().getClassNames().contains(genericTypeName)) {
                Class<?> forName = Class.forName(genericTypeName);
                final Field[] declaredFields = forName.getDeclaredFields();
                boolean b = false;
                int n2 = 0;
                boolean b2;
                int n3;
                while (true) {
                    final int length = declaredFields.length;
                    b2 = true;
                    n3 = 2;
                    if (n2 >= length) {
                        break;
                    }
                    final Field field2 = declaredFields[n2];
                    Class<?> clazz;
                    if (!Modifier.isStatic(field2.getModifiers())) {
                        final Class<?> type = field2.getType();
                        if (s.equals(type.getName())) {
                            if (n == (b2 ? 1 : 0)) {
                                this.addIntoAssociationModelCollection(s, genericTypeName, genericTypeName, n3);
                                clazz = forName;
                            }
                            else if (n == n3) {
                                final int n4 = 2;
                                clazz = forName;
                                this.addIntoAssociationInfoCollection(s, genericTypeName, genericTypeName, field, field2, n4);
                            }
                            else {
                                clazz = forName;
                            }
                            b = true;
                        }
                        else {
                            clazz = forName;
                            final Field field3 = field2;
                            if (this.isCollection(type)) {
                                if (s.equals(this.getGenericTypeName(field2))) {
                                    if (n == (b2 ? 1 : 0)) {
                                        this.addIntoAssociationModelCollection(s, genericTypeName, null, 3);
                                    }
                                    else if (n == n3) {
                                        this.addIntoAssociationInfoCollection(s, genericTypeName, null, field, field3, 3);
                                    }
                                    b = true;
                                }
                            }
                        }
                    }
                    else {
                        clazz = forName;
                    }
                    ++n2;
                    forName = clazz;
                }
                if (!b) {
                    if (n == (b2 ? 1 : 0)) {
                        this.addIntoAssociationModelCollection(s, genericTypeName, genericTypeName, n3);
                    }
                    else if (n == n3) {
                        this.addIntoAssociationInfoCollection(s, genericTypeName, genericTypeName, field, null, 2);
                    }
                }
            }
        }
    }
    
    private void oneToAnyConditions(final String s, final Field field, final int n) {
        final Class<?> type = field.getType();
        if (LitePalAttr.getInstance().getClassNames().contains(type.getName())) {
            Class<?> forName = Class.forName(type.getName());
            final Field[] declaredFields = forName.getDeclaredFields();
            boolean b = false;
            int n2 = 0;
            int n3;
            int n4;
            while (true) {
                final int length = declaredFields.length;
                n3 = 2;
                n4 = 1;
                if (n2 >= length) {
                    break;
                }
                final Field field2 = declaredFields[n2];
                Class<?> clazz;
                if (!Modifier.isStatic(field2.getModifiers())) {
                    final Class<?> type2 = field2.getType();
                    if (s.equals(type2.getName())) {
                        if (n == n4) {
                            this.addIntoAssociationModelCollection(s, type.getName(), type.getName(), n4);
                            clazz = forName;
                        }
                        else if (n == n3) {
                            final String name = type.getName();
                            final String name2 = type.getName();
                            final int n5 = 1;
                            clazz = forName;
                            this.addIntoAssociationInfoCollection(s, name, name2, field, field2, n5);
                        }
                        else {
                            clazz = forName;
                        }
                        b = true;
                    }
                    else {
                        clazz = forName;
                        if (this.isCollection(type2)) {
                            if (s.equals(this.getGenericTypeName(field2))) {
                                if (n == n4) {
                                    this.addIntoAssociationModelCollection(s, type.getName(), s, n3);
                                }
                                else if (n == n3) {
                                    this.addIntoAssociationInfoCollection(s, type.getName(), s, field, field2, 2);
                                }
                                b = true;
                            }
                        }
                    }
                }
                else {
                    clazz = forName;
                }
                ++n2;
                forName = clazz;
            }
            if (!b) {
                if (n == n4) {
                    this.addIntoAssociationModelCollection(s, type.getName(), type.getName(), n4);
                }
                else if (n == n3) {
                    this.addIntoAssociationInfoCollection(s, type.getName(), type.getName(), field, null, 1);
                }
            }
        }
    }
    
    private void recursiveSupportedFields(final Class clazz, final List list) {
        if (clazz != DataSupport.class && clazz != Object.class) {
            final Field[] declaredFields = clazz.getDeclaredFields();
            if (declaredFields != null && declaredFields.length > 0) {
                final Field[] array = declaredFields;
                for (int length = declaredFields.length, i = 0; i < length; ++i) {
                    final Field field = array[i];
                    final Column column = field.getAnnotation(Column.class);
                    if (column == null || !column.ignore()) {
                        if (!Modifier.isStatic(field.getModifiers())) {
                            if (BaseUtility.isFieldTypeSupported(field.getType().getName())) {
                                list.add(field);
                            }
                        }
                    }
                }
            }
            this.recursiveSupportedFields(clazz.getSuperclass(), list);
        }
    }
    
    protected Collection getAssociationInfo(final String s) {
        if (this.mAssociationInfos == null) {
            this.mAssociationInfos = new HashSet();
        }
        this.mAssociationInfos.clear();
        this.analyzeClassFields(s, 2);
        return this.mAssociationInfos;
    }
    
    protected Collection getAssociations(final List list) {
        if (this.mAssociationModels == null) {
            this.mAssociationModels = new HashSet();
        }
        this.mAssociationModels.clear();
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.analyzeClassFields(iterator.next(), 1);
        }
        return this.mAssociationModels;
    }
    
    protected String getForeignKeyColumnName(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("_id");
        return BaseUtility.changeCase(sb.toString());
    }
    
    protected List getSupportedFields(final String s) {
        final List list = this.classFieldsMap.get(s);
        if (list == null) {
            final ArrayList list2 = new ArrayList();
            try {
                this.recursiveSupportedFields(Class.forName(s), list2);
                this.classFieldsMap.put(s, list2);
                return list2;
            }
            catch (ClassNotFoundException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("can not find a class named ");
                sb.append(s);
                throw new DatabaseGenerateException(sb.toString());
            }
        }
        return list;
    }
    
    protected TableModel getTableModel(final String className) {
        final String tableNameByClassName = DBUtility.getTableNameByClassName(className);
        final TableModel tableModel = new TableModel();
        tableModel.setTableName(tableNameByClassName);
        tableModel.setClassName(className);
        final Iterator iterator = this.getSupportedFields(className).iterator();
        while (iterator.hasNext()) {
            tableModel.addColumnModel(this.convertFieldToColumnModel(iterator.next()));
        }
        return tableModel;
    }
    
    protected boolean isCollection(final Class clazz) {
        return this.isList(clazz) || this.isSet(clazz);
    }
    
    protected boolean isIdColumn(final String s) {
        return "_id".equalsIgnoreCase(s) || "id".equalsIgnoreCase(s);
    }
    
    protected boolean isList(final Class clazz) {
        return List.class.isAssignableFrom(clazz);
    }
    
    protected boolean isSet(final Class clazz) {
        return Set.class.isAssignableFrom(clazz);
    }
}
