// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.crud;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import org.litepal.exceptions.DataSupportException;
import java.lang.reflect.Field;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;

class SaveHandler extends DataHandler
{
    boolean ignoreAssociations;
    ContentValues values;
    
    SaveHandler(final SQLiteDatabase mDatabase) {
        this.ignoreAssociations = false;
        this.values = new ContentValues();
        this.mDatabase = mDatabase;
    }
    
    private void afterSave(final DataSupport dataSupport, final List list, final long n) {
        this.throwIfSaveFailed(n);
        this.assignIdValue(dataSupport, this.getIdField(list), n);
        if (!this.ignoreAssociations) {
            this.updateAssociatedTableWithFK(dataSupport);
            this.insertIntermediateJoinTableValue(dataSupport, false);
        }
    }
    
    private void afterUpdate(final DataSupport dataSupport) {
        if (!this.ignoreAssociations) {
            this.updateAssociatedTableWithFK(dataSupport);
            this.insertIntermediateJoinTableValue(dataSupport, true);
            this.clearFKValueInAssociatedTable(dataSupport);
        }
    }
    
    private void assignIdValue(final DataSupport dataSupport, final Field field, final long n) {
        try {
            this.giveBaseObjIdValue(dataSupport, n);
            if (field == null) {
                return;
            }
            final String name = field.getName();
            try {
                this.giveModelIdValue(dataSupport, name, field.getType(), n);
            }
            catch (Exception ex) {
                throw new DataSupportException(ex.getMessage(), ex);
            }
        }
        catch (Exception ex2) {}
    }
    
    private void beforeSave(final DataSupport dataSupport, final List list, final ContentValues contentValues) {
        this.putFieldsValue(dataSupport, list, contentValues);
        if (!this.ignoreAssociations) {
            this.putForeignKeyValue(contentValues, dataSupport);
        }
    }
    
    private void beforeUpdate(final DataSupport dataSupport, final List list, final ContentValues contentValues) {
        this.putFieldsValue(dataSupport, list, contentValues);
        if (!this.ignoreAssociations) {
            this.putForeignKeyValue(contentValues, dataSupport);
            final Iterator<String> iterator = dataSupport.getListToClearSelfFK().iterator();
            while (iterator.hasNext()) {
                contentValues.putNull((String)iterator.next());
            }
        }
    }
    
    private void clearFKValueInAssociatedTable(final DataSupport dataSupport) {
        for (final String s : dataSupport.getListToClearAssociatedFK()) {
            final String foreignKeyColumnName = this.getForeignKeyColumnName(dataSupport.getTableName());
            final ContentValues contentValues = new ContentValues();
            contentValues.putNull(foreignKeyColumnName);
            final StringBuilder sb = new StringBuilder();
            sb.append(foreignKeyColumnName);
            sb.append(" = ");
            sb.append(dataSupport.getBaseObjId());
            this.mDatabase.update(s, contentValues, sb.toString(), (String[])null);
        }
    }
    
    private void doSaveAction(final DataSupport dataSupport, final List list) {
        this.values.clear();
        this.beforeSave(dataSupport, list, this.values);
        this.afterSave(dataSupport, list, this.saving(dataSupport, this.values));
    }
    
    private void doUpdateAction(final DataSupport dataSupport, final List list) {
        this.values.clear();
        this.beforeUpdate(dataSupport, list, this.values);
        this.updating(dataSupport, this.values);
        this.afterUpdate(dataSupport);
    }
    
    private Field getIdField(final List list) {
        for (final Field field : list) {
            if (this.isIdColumn(field.getName())) {
                return field;
            }
        }
        return null;
    }
    
    private String getWhereForJoinTableToDelete(final DataSupport dataSupport) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getForeignKeyColumnName(dataSupport.getTableName()));
        sb.append(" = ?");
        return sb.toString();
    }
    
    private void giveModelIdValue(final DataSupport dataSupport, final String s, final Class clazz, final long n) {
        if (this.shouldGiveModelIdValue(s, clazz, n)) {
            Number n2;
            if (clazz != Integer.TYPE && clazz != Integer.class) {
                if (clazz != Long.TYPE && clazz != Long.class) {
                    throw new DataSupportException("id type is not supported. Only int or long is acceptable for id");
                }
                n2 = n;
            }
            else {
                n2 = (int)n;
            }
            DynamicExecutor.setField(dataSupport, s, n2, dataSupport.getClass());
        }
    }
    
    private void insertIntermediateJoinTableValue(final DataSupport dataSupport, final boolean b) {
        final Map associatedModelsMapForJoinTable = dataSupport.getAssociatedModelsMapForJoinTable();
        final ContentValues contentValues = new ContentValues();
        for (final String s : associatedModelsMapForJoinTable.keySet()) {
            final String intermediateTableName = this.getIntermediateTableName(dataSupport, s);
            if (b) {
                this.mDatabase.delete(intermediateTableName, this.getWhereForJoinTableToDelete(dataSupport), new String[] { String.valueOf(dataSupport.getBaseObjId()) });
            }
            for (final long longValue : (Set)associatedModelsMapForJoinTable.get(s)) {
                contentValues.clear();
                contentValues.put(this.getForeignKeyColumnName(dataSupport.getTableName()), dataSupport.getBaseObjId());
                contentValues.put(this.getForeignKeyColumnName(s), longValue);
                this.mDatabase.insert(intermediateTableName, (String)null, contentValues);
            }
        }
    }
    
    private void putForeignKeyValue(final ContentValues contentValues, final DataSupport dataSupport) {
        final Map associatedModelsMapWithoutFK = dataSupport.getAssociatedModelsMapWithoutFK();
        for (final String s : associatedModelsMapWithoutFK.keySet()) {
            contentValues.put(this.getForeignKeyColumnName(s), (Long)associatedModelsMapWithoutFK.get(s));
        }
    }
    
    private long saving(final DataSupport dataSupport, final ContentValues contentValues) {
        return this.mDatabase.insert(dataSupport.getTableName(), (String)null, contentValues);
    }
    
    private boolean shouldGiveModelIdValue(final String s, final Class clazz, final long n) {
        return s != null && clazz != null && n > 0L;
    }
    
    private void throwIfSaveFailed(final long n) {
        if (n != -1) {
            return;
        }
        throw new DataSupportException("Save current model failed.");
    }
    
    private void updateAssociatedTableWithFK(final DataSupport dataSupport) {
        final Map associatedModelsMapWithFK = dataSupport.getAssociatedModelsMapWithFK();
        final ContentValues contentValues = new ContentValues();
        for (final String s : associatedModelsMapWithFK.keySet()) {
            contentValues.clear();
            contentValues.put(this.getForeignKeyColumnName(dataSupport.getTableName()), dataSupport.getBaseObjId());
            final Set set = (Set)associatedModelsMapWithFK.get(s);
            if (set != null && !set.isEmpty()) {
                this.mDatabase.update(s, contentValues, this.getWhereOfIdsWithOr(set), (String[])null);
            }
        }
    }
    
    private void updating(final DataSupport dataSupport, final ContentValues contentValues) {
        this.mDatabase.update(dataSupport.getTableName(), contentValues, "id = ?", new String[] { String.valueOf(dataSupport.getBaseObjId()) });
    }
    
    void onSave(final DataSupport dataSupport) {
        final String className = dataSupport.getClassName();
        final List supportedFields = this.getSupportedFields(className);
        final Collection associationInfo = this.getAssociationInfo(className);
        if (!dataSupport.isSaved()) {
            if (!this.ignoreAssociations) {
                this.analyzeAssociatedModels(dataSupport, associationInfo);
            }
            this.doSaveAction(dataSupport, supportedFields);
            if (!this.ignoreAssociations) {
                this.analyzeAssociatedModels(dataSupport, associationInfo);
            }
        }
        else {
            if (!this.ignoreAssociations) {
                this.analyzeAssociatedModels(dataSupport, associationInfo);
            }
            this.doUpdateAction(dataSupport, supportedFields);
        }
    }
    
    void onSaveAll(final Collection collection) {
        if (collection != null && collection.size() > 0) {
            final DataSupport[] array = collection.toArray(new DataSupport[0]);
            final String className = array[0].getClassName();
            final List supportedFields = this.getSupportedFields(className);
            final Collection associationInfo = this.getAssociationInfo(className);
            final DataSupport[] array2 = array;
            for (int length = array.length, i = 0; i < length; ++i) {
                final DataSupport dataSupport = array2[i];
                if (!dataSupport.isSaved()) {
                    this.analyzeAssociatedModels(dataSupport, associationInfo);
                    this.doSaveAction(dataSupport, supportedFields);
                    this.analyzeAssociatedModels(dataSupport, associationInfo);
                }
                else {
                    this.analyzeAssociatedModels(dataSupport, associationInfo);
                    this.doUpdateAction(dataSupport, supportedFields);
                }
                dataSupport.clearAssociatedData();
            }
        }
    }
    
    void onSaveFast(final DataSupport dataSupport) {
        this.ignoreAssociations = true;
        this.onSave(dataSupport);
    }
}
