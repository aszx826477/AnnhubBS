// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.crud;

import java.util.Map;
import java.util.Collection;
import java.util.Set;
import java.util.Iterator;
import java.util.List;
import org.litepal.util.BaseUtility;
import android.content.ContentValues;
import org.litepal.exceptions.DataSupportException;
import android.database.sqlite.SQLiteDatabase;

class UpdateHandler extends DataHandler
{
    UpdateHandler(final SQLiteDatabase mDatabase) {
        this.mDatabase = mDatabase;
    }
    
    private void analyzeAssociations(final DataSupport dataSupport) {
        try {
            this.analyzeAssociatedModels(dataSupport, this.getAssociationInfo(dataSupport.getClassName()));
        }
        catch (Exception ex) {
            throw new DataSupportException(ex.getMessage(), ex);
        }
    }
    
    private int doUpdateAllAction(final String s, final ContentValues contentValues, final String... array) {
        BaseUtility.checkConditionsCorrect(array);
        if (contentValues.size() > 0) {
            return this.mDatabase.update(s, contentValues, this.getWhereClause(array), this.getWhereArgs(array));
        }
        return 0;
    }
    
    private int doUpdateAssociations(final DataSupport dataSupport, final long n, final ContentValues contentValues) {
        this.analyzeAssociations(dataSupport);
        this.updateSelfTableForeignKey(dataSupport, contentValues);
        return 0 + this.updateAssociatedTableForeignKey(dataSupport, n);
    }
    
    private void putFieldsToDefaultValue(final DataSupport dataSupport, final ContentValues contentValues) {
        String s = null;
        try {
            final DataSupport emptyModel = this.getEmptyModel(dataSupport);
            try {
                final Class<? extends DataSupport> class1 = emptyModel.getClass();
                try {
                    final List fieldsToSetToDefault = dataSupport.getFieldsToSetToDefault();
                    try {
                        final Iterator<String> iterator = fieldsToSetToDefault.iterator();
                        try {
                            while (true) {
                                if (!iterator.hasNext()) {
                                    return;
                                }
                                final String next = iterator.next();
                                try {
                                    final String s2 = next;
                                    if (this.isIdColumn(s2)) {
                                        continue;
                                    }
                                    s = s2;
                                    this.putContentValuesForUpdate(emptyModel, class1.getDeclaredField(s2), contentValues);
                                    continue;
                                }
                                catch (Exception ex) {
                                    throw new DataSupportException(ex.getMessage(), ex);
                                }
                                catch (NoSuchFieldException ex2) {
                                    throw new DataSupportException(DataSupportException.noSuchFieldExceptioin(dataSupport.getClassName(), s), ex2);
                                }
                            }
                        }
                        catch (Exception ex3) {}
                        catch (NoSuchFieldException ex4) {}
                    }
                    catch (Exception ex5) {}
                    catch (NoSuchFieldException ex6) {}
                }
                catch (Exception ex7) {}
                catch (NoSuchFieldException ex8) {}
            }
            catch (Exception ex9) {}
            catch (NoSuchFieldException ex10) {}
        }
        catch (Exception ex11) {}
        catch (NoSuchFieldException ex12) {}
    }
    
    private int updateAssociatedTableForeignKey(final DataSupport dataSupport, final long n) {
        final Map associatedModelsMapWithFK = dataSupport.getAssociatedModelsMapWithFK();
        final ContentValues contentValues = new ContentValues();
        for (final String s : associatedModelsMapWithFK.keySet()) {
            contentValues.clear();
            contentValues.put(this.getForeignKeyColumnName(dataSupport.getTableName()), n);
            final Set set = (Set)associatedModelsMapWithFK.get(s);
            if (set != null && !set.isEmpty()) {
                return this.mDatabase.update(s, contentValues, this.getWhereOfIdsWithOr(set), (String[])null);
            }
        }
        return 0;
    }
    
    private void updateSelfTableForeignKey(final DataSupport dataSupport, final ContentValues contentValues) {
        final Map associatedModelsMapWithoutFK = dataSupport.getAssociatedModelsMapWithoutFK();
        for (final String s : associatedModelsMapWithoutFK.keySet()) {
            contentValues.put(this.getForeignKeyColumnName(s), (Long)associatedModelsMapWithoutFK.get(s));
        }
    }
    
    int onUpdate(final Class clazz, final long n, final ContentValues contentValues) {
        if (contentValues.size() > 0) {
            final SQLiteDatabase mDatabase = this.mDatabase;
            final String tableName = this.getTableName(clazz);
            final StringBuilder sb = new StringBuilder();
            sb.append("id = ");
            sb.append(n);
            return mDatabase.update(tableName, contentValues, sb.toString(), (String[])null);
        }
        return 0;
    }
    
    int onUpdate(final DataSupport dataSupport, final long n) {
        final List supportedFields = this.getSupportedFields(dataSupport.getClassName());
        final ContentValues contentValues = new ContentValues();
        this.putFieldsValue(dataSupport, supportedFields, contentValues);
        this.putFieldsToDefaultValue(dataSupport, contentValues);
        if (contentValues.size() > 0) {
            final SQLiteDatabase mDatabase = this.mDatabase;
            final String tableName = dataSupport.getTableName();
            final StringBuilder sb = new StringBuilder();
            sb.append("id = ");
            sb.append(n);
            return mDatabase.update(tableName, contentValues, sb.toString(), (String[])null);
        }
        return 0;
    }
    
    int onUpdateAll(final String s, final ContentValues contentValues, final String... array) {
        return this.doUpdateAllAction(s, contentValues, array);
    }
    
    int onUpdateAll(final DataSupport dataSupport, final String... array) {
        final List supportedFields = this.getSupportedFields(dataSupport.getClassName());
        final ContentValues contentValues = new ContentValues();
        this.putFieldsValue(dataSupport, supportedFields, contentValues);
        this.putFieldsToDefaultValue(dataSupport, contentValues);
        return this.doUpdateAllAction(dataSupport.getTableName(), contentValues, array);
    }
}
