// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.crud;

import java.util.ArrayList;
import java.util.Iterator;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.DataSupportException;
import java.util.Collection;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;

public class DeleteHandler extends DataHandler
{
    private List foreignKeyTableToDelete;
    
    DeleteHandler(final SQLiteDatabase mDatabase) {
        this.mDatabase = mDatabase;
    }
    
    private Collection analyzeAssociations(final DataSupport dataSupport) {
        try {
            final Collection associationInfo = this.getAssociationInfo(dataSupport.getClassName());
            this.analyzeAssociatedModels(dataSupport, associationInfo);
            return associationInfo;
        }
        catch (Exception ex) {
            throw new DataSupportException(ex.getMessage(), ex);
        }
    }
    
    private void analyzeAssociations(final Class clazz) {
        for (final AssociationsInfo associationsInfo : this.getAssociationInfo(clazz.getName())) {
            final String tableNameByClassName = DBUtility.getTableNameByClassName(associationsInfo.getAssociatedClassName());
            if (associationsInfo.getAssociationType() != 2 && associationsInfo.getAssociationType() != 1) {
                if (associationsInfo.getAssociationType() != 3) {
                    continue;
                }
                this.getForeignKeyTableToDelete().add(BaseUtility.changeCase(DBUtility.getIntermediateTableName(this.getTableName(clazz), tableNameByClassName)));
            }
            else {
                if (clazz.getName().equals(associationsInfo.getClassHoldsForeignKey())) {
                    continue;
                }
                this.getForeignKeyTableToDelete().add(tableNameByClassName);
            }
        }
    }
    
    private String buildConditionString(final String... array) {
        final int n = array.length - 1;
        String replaceFirst = array[0];
        for (int i = 0; i < n; ++i) {
            final String s = "\\?";
            final StringBuilder sb = new StringBuilder();
            sb.append("'");
            sb.append(array[i + 1]);
            sb.append("'");
            replaceFirst = replaceFirst.replaceFirst(s, sb.toString());
        }
        return replaceFirst;
    }
    
    private void clearAssociatedModelSaveState(final DataSupport dataSupport, final Collection collection) {
        try {
            final Iterator<AssociationsInfo> iterator = collection.iterator();
            try {
            Label_0007:
                while (true) {
                    if (!iterator.hasNext()) {
                        return;
                    }
                    final AssociationsInfo next = iterator.next();
                    try {
                        final AssociationsInfo associationsInfo = next;
                        try {
                            Label_0168: {
                                if (associationsInfo.getAssociationType() != 2) {
                                    break Label_0168;
                                }
                                final String className = dataSupport.getClassName();
                                try {
                                    if (className.equals(associationsInfo.getClassHoldsForeignKey())) {
                                        break Label_0168;
                                    }
                                    final Collection associatedModels = this.getAssociatedModels(dataSupport, associationsInfo);
                                    Label_0165: {
                                        if (associatedModels == null || associatedModels.isEmpty()) {
                                            break Label_0165;
                                        }
                                        final Iterator<DataSupport> iterator2 = associatedModels.iterator();
                                        try {
                                            DataSupport next2;
                                            DataSupport dataSupport2;
                                            DataSupport associatedModel;
                                            Block_20_Outer:Label_0210_Outer:
                                            while (true) {
                                                Label_0162: {
                                                    if (!iterator2.hasNext()) {
                                                        break Label_0162;
                                                    }
                                                    next2 = iterator2.next();
                                                    try {
                                                        dataSupport2 = next2;
                                                        if (dataSupport2 == null) {
                                                            continue Block_20_Outer;
                                                        }
                                                        dataSupport2.clearSavedState();
                                                        continue Block_20_Outer;
                                                        continue Label_0210;
                                                        // iftrue(Label_0210:, associationsInfo.getAssociationType() != 1)
                                                        // iftrue(Label_0207:, associatedModel == null)
                                                        while (true) {
                                                            associatedModel.clearSavedState();
                                                            Label_0207: {
                                                                continue Label_0210;
                                                            }
                                                            associatedModel = this.getAssociatedModel(dataSupport, associationsInfo);
                                                            continue Label_0210_Outer;
                                                        }
                                                        while (true) {
                                                            continue Label_0007;
                                                            continue;
                                                        }
                                                    }
                                                    catch (Exception ex) {
                                                        throw new DataSupportException(ex.getMessage(), ex);
                                                    }
                                                }
                                            }
                                        }
                                        catch (Exception ex2) {}
                                    }
                                }
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
    
    private int deleteAllCascade(final Class clazz, final String... array) {
        int n = 0;
        for (final String s : this.getForeignKeyTableToDelete()) {
            final String tableName = this.getTableName(clazz);
            final String foreignKeyColumnName = this.getForeignKeyColumnName(tableName);
            final StringBuilder sb = new StringBuilder();
            sb.append(foreignKeyColumnName);
            sb.append(" in (select id from ");
            sb.append(tableName);
            if (array != null && array.length > 0) {
                sb.append(" where ");
                sb.append(this.buildConditionString(array));
            }
            sb.append(")");
            n += this.mDatabase.delete(s, BaseUtility.changeCase(sb.toString()), (String[])null);
        }
        return n;
    }
    
    private int deleteAssociatedForeignKeyRows(final DataSupport dataSupport) {
        int n = 0;
        for (final String s : dataSupport.getAssociatedModelsMapWithFK().keySet()) {
            final String foreignKeyColumnName = this.getForeignKeyColumnName(dataSupport.getTableName());
            final SQLiteDatabase mDatabase = this.mDatabase;
            final StringBuilder sb = new StringBuilder();
            sb.append(foreignKeyColumnName);
            sb.append(" = ");
            sb.append(dataSupport.getBaseObjId());
            n += mDatabase.delete(s, sb.toString(), (String[])null);
        }
        return n;
    }
    
    private int deleteAssociatedJoinTableRows(final DataSupport dataSupport) {
        int n = 0;
        final Iterator<String> iterator = dataSupport.getAssociatedModelsMapForJoinTable().keySet().iterator();
        while (iterator.hasNext()) {
            final String intermediateTableName = DBUtility.getIntermediateTableName(dataSupport.getTableName(), iterator.next());
            final String foreignKeyColumnName = this.getForeignKeyColumnName(dataSupport.getTableName());
            final SQLiteDatabase mDatabase = this.mDatabase;
            final StringBuilder sb = new StringBuilder();
            sb.append(foreignKeyColumnName);
            sb.append(" = ");
            sb.append(dataSupport.getBaseObjId());
            n += mDatabase.delete(intermediateTableName, sb.toString(), (String[])null);
        }
        return n;
    }
    
    private int deleteCascade(final Class clazz, final long n) {
        int n2 = 0;
        for (final String s : this.getForeignKeyTableToDelete()) {
            final String foreignKeyColumnName = this.getForeignKeyColumnName(this.getTableName(clazz));
            final SQLiteDatabase mDatabase = this.mDatabase;
            final StringBuilder sb = new StringBuilder();
            sb.append(foreignKeyColumnName);
            sb.append(" = ");
            sb.append(n);
            n2 += mDatabase.delete(s, sb.toString(), (String[])null);
        }
        return n2;
    }
    
    private int deleteCascade(final DataSupport dataSupport) {
        return this.deleteAssociatedForeignKeyRows(dataSupport) + this.deleteAssociatedJoinTableRows(dataSupport);
    }
    
    private List getForeignKeyTableToDelete() {
        if (this.foreignKeyTableToDelete == null) {
            this.foreignKeyTableToDelete = new ArrayList();
        }
        return this.foreignKeyTableToDelete;
    }
    
    int onDelete(final Class clazz, final long n) {
        this.analyzeAssociations(clazz);
        final int deleteCascade = this.deleteCascade(clazz, n);
        final SQLiteDatabase mDatabase = this.mDatabase;
        final String tableName = this.getTableName(clazz);
        final StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(n);
        final int n2 = deleteCascade + mDatabase.delete(tableName, sb.toString(), (String[])null);
        this.getForeignKeyTableToDelete().clear();
        return n2;
    }
    
    int onDelete(final DataSupport dataSupport) {
        if (dataSupport.isSaved()) {
            final Collection analyzeAssociations = this.analyzeAssociations(dataSupport);
            final int deleteCascade = this.deleteCascade(dataSupport);
            final SQLiteDatabase mDatabase = this.mDatabase;
            final String tableName = dataSupport.getTableName();
            final StringBuilder sb = new StringBuilder();
            sb.append("id = ");
            sb.append(dataSupport.getBaseObjId());
            final int n = deleteCascade + mDatabase.delete(tableName, sb.toString(), (String[])null);
            this.clearAssociatedModelSaveState(dataSupport, analyzeAssociations);
            return n;
        }
        return 0;
    }
    
    int onDeleteAll(final Class clazz, final String... array) {
        BaseUtility.checkConditionsCorrect(array);
        this.analyzeAssociations(clazz);
        final int n = this.deleteAllCascade(clazz, array) + this.mDatabase.delete(this.getTableName(clazz), this.getWhereClause(array), this.getWhereArgs(array));
        this.getForeignKeyTableToDelete().clear();
        return n;
    }
    
    int onDeleteAll(final String s, final String... array) {
        BaseUtility.checkConditionsCorrect(array);
        return this.mDatabase.delete(s, this.getWhereClause(array), this.getWhereArgs(array));
    }
}
