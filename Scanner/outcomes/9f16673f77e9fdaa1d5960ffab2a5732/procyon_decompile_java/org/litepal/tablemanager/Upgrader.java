// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.tablemanager;

import android.database.sqlite.SQLiteDatabase;
import org.litepal.util.DBUtility;
import org.litepal.crud.model.AssociationsInfo;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.util.LogUtil;
import java.util.List;
import org.litepal.tablemanager.model.TableModel;

public class Upgrader extends AssociationUpdater
{
    private boolean hasConstraintChanged;
    protected TableModel mTableModel;
    protected TableModel mTableModelDB;
    
    private void addColumns(final List list) {
        LogUtil.d("AssociationUpdater", "do addColumn");
        this.execute(this.getAddColumnSQLs(list), this.mDb);
        final Iterator<ColumnModel> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.mTableModelDB.addColumnModel(iterator.next());
        }
    }
    
    private void changeColumnsConstraints() {
        if (this.hasConstraintChanged) {
            LogUtil.d("AssociationUpdater", "do changeColumnsConstraints");
            this.execute(this.getChangeColumnsConstraintsSQL(), this.mDb);
        }
    }
    
    private void changeColumnsType(final List list) {
        LogUtil.d("AssociationUpdater", "do changeColumnsType");
        final ArrayList<String> list2 = new ArrayList<String>();
        if (list != null && !list.isEmpty()) {
            final Iterator<ColumnModel> iterator = list.iterator();
            while (iterator.hasNext()) {
                list2.add(iterator.next().getColumnName());
            }
        }
        this.removeColumns(list2);
        this.addColumns(list);
    }
    
    private List findColumnTypesToChange() {
        final ArrayList<ColumnModel> list = new ArrayList<ColumnModel>();
        for (final ColumnModel columnModel : this.mTableModelDB.getColumnModels()) {
            for (final ColumnModel columnModel2 : this.mTableModel.getColumnModels()) {
                if (columnModel.getColumnName().equalsIgnoreCase(columnModel2.getColumnName())) {
                    if (!columnModel.getColumnType().equalsIgnoreCase(columnModel2.getColumnType())) {
                        list.add(columnModel2);
                    }
                    if (this.hasConstraintChanged) {
                        continue;
                    }
                    final String s = "AssociationUpdater";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("default value db is:");
                    sb.append(columnModel.getDefaultValue());
                    sb.append(", default value is:");
                    sb.append(columnModel2.getDefaultValue());
                    LogUtil.d(s, sb.toString());
                    if (columnModel.isNullable() == columnModel2.isNullable() && columnModel.getDefaultValue().equalsIgnoreCase(columnModel2.getDefaultValue()) && (!columnModel.isUnique() || columnModel2.isUnique())) {
                        continue;
                    }
                    this.hasConstraintChanged = true;
                }
            }
        }
        return list;
    }
    
    private List findColumnsToAdd() {
        final ArrayList<ColumnModel> list = new ArrayList<ColumnModel>();
        for (final ColumnModel columnModel : this.mTableModel.getColumnModels()) {
            if (!this.mTableModelDB.containsColumn(columnModel.getColumnName())) {
                list.add(columnModel);
            }
        }
        return list;
    }
    
    private List findColumnsToRemove() {
        final String tableName = this.mTableModel.getTableName();
        final ArrayList<String> list = new ArrayList<String>();
        final Iterator<ColumnModel> iterator = (Iterator<ColumnModel>)this.mTableModelDB.getColumnModels().iterator();
        while (iterator.hasNext()) {
            final String columnName = iterator.next().getColumnName();
            if (this.isNeedToRemove(columnName)) {
                list.add(columnName);
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("remove columns from ");
        sb.append(tableName);
        sb.append(" >> ");
        sb.append(list);
        LogUtil.d("AssociationUpdater", sb.toString());
        return list;
    }
    
    private String generateAddColumnSQL(final ColumnModel columnModel) {
        return this.generateAddColumnSQL(this.mTableModel.getTableName(), columnModel);
    }
    
    private List generateAddForeignKeySQL() {
        final ArrayList<String> list = new ArrayList<String>();
        for (final String columnName : this.getForeignKeyColumns(this.mTableModel)) {
            if (!this.mTableModel.containsColumn(columnName)) {
                final ColumnModel columnModel = new ColumnModel();
                columnModel.setColumnName(columnName);
                columnModel.setColumnType("integer");
                list.add(this.generateAddColumnSQL(this.mTableModel.getTableName(), columnModel));
            }
        }
        return list;
    }
    
    private String[] getAddColumnSQLs(final List list) {
        final ArrayList<String> list2 = new ArrayList<String>();
        final Iterator<ColumnModel> iterator = list.iterator();
        while (iterator.hasNext()) {
            list2.add(this.generateAddColumnSQL(iterator.next()));
        }
        return list2.toArray(new String[0]);
    }
    
    private String[] getChangeColumnsConstraintsSQL() {
        final String generateAlterToTempTableSQL = this.generateAlterToTempTableSQL(this.mTableModel.getTableName());
        final String generateCreateTableSQL = this.generateCreateTableSQL(this.mTableModel);
        final List generateAddForeignKeySQL = this.generateAddForeignKeySQL();
        final String generateDataMigrationSQL = this.generateDataMigrationSQL(this.mTableModelDB);
        final String generateDropTempTableSQL = this.generateDropTempTableSQL(this.mTableModel.getTableName());
        final ArrayList<String> list = new ArrayList<String>();
        list.add(generateAlterToTempTableSQL);
        list.add(generateCreateTableSQL);
        list.addAll((Collection<?>)generateAddForeignKeySQL);
        list.add(generateDataMigrationSQL);
        list.add(generateDropTempTableSQL);
        LogUtil.d("AssociationUpdater", "generateChangeConstraintSQL >> ");
        final Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            LogUtil.d("AssociationUpdater", iterator.next());
        }
        LogUtil.d("AssociationUpdater", "<< generateChangeConstraintSQL");
        return list.toArray(new String[0]);
    }
    
    private boolean hasNewUniqueOrNotNullColumn() {
        for (final ColumnModel columnModel : this.mTableModel.getColumnModels()) {
            final ColumnModel columnModelByName = this.mTableModelDB.getColumnModelByName(columnModel.getColumnName());
            final boolean unique = columnModel.isUnique();
            final boolean b = true;
            if (unique && (columnModelByName == null || columnModelByName.isUnique())) {
                return b;
            }
            if (columnModelByName != null && !columnModel.isNullable() && columnModelByName.isNullable()) {
                return b;
            }
        }
        return false;
    }
    
    private boolean isNeedToRemove(final String s) {
        return this.isRemovedFromClass(s) && !this.isIdColumn(s) && !this.isForeignKeyColumn(this.mTableModel, s);
    }
    
    private boolean isRemovedFromClass(final String s) {
        return this.mTableModel.containsColumn(s) ^ true;
    }
    
    private void removeColumns(final List list) {
        LogUtil.d("AssociationUpdater", "do addColumn");
        this.removeColumns(list, this.mTableModel.getTableName());
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.mTableModelDB.removeColumnModelByName(iterator.next());
        }
    }
    
    private void upgradeTable() {
        if (this.hasNewUniqueOrNotNullColumn()) {
            final TableModel mTableModel = this.mTableModel;
            final SQLiteDatabase mDb = this.mDb;
            final boolean b = true;
            this.createOrUpgradeTable(mTableModel, mDb, b);
            for (final AssociationsInfo associationsInfo : this.getAssociationInfo(this.mTableModel.getClassName())) {
                if (associationsInfo.getAssociationType() != 2 && associationsInfo.getAssociationType() != (b ? 1 : 0)) {
                    continue;
                }
                if (!associationsInfo.getClassHoldsForeignKey().equalsIgnoreCase(this.mTableModel.getClassName())) {
                    continue;
                }
                this.addForeignKeyColumn(this.mTableModel.getTableName(), DBUtility.getTableNameByClassName(associationsInfo.getAssociatedClassName()), this.mTableModel.getTableName(), this.mDb);
            }
        }
        else {
            this.hasConstraintChanged = false;
            this.removeColumns(this.findColumnsToRemove());
            this.addColumns(this.findColumnsToAdd());
            this.changeColumnsType(this.findColumnTypesToChange());
            this.changeColumnsConstraints();
        }
    }
    
    protected void createOrUpgradeTable(final SQLiteDatabase mDb, final boolean b) {
        this.mDb = mDb;
        for (final TableModel mTableModel : this.getAllTableModels()) {
            this.mTableModel = mTableModel;
            this.mTableModelDB = this.getTableModelFromDB(mTableModel.getTableName());
            this.upgradeTable();
        }
    }
}
