// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.tablemanager;

import org.litepal.util.BaseUtility;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.parser.LitePalAttr;
import org.litepal.tablemanager.model.AssociationsModel;
import java.util.Iterator;
import org.litepal.util.LogUtil;
import org.litepal.util.DBUtility;
import java.util.ArrayList;
import java.util.List;
import org.litepal.tablemanager.model.TableModel;
import android.database.sqlite.SQLiteDatabase;
import java.util.Collection;

public abstract class AssociationUpdater extends Creator
{
    public static final String TAG = "AssociationUpdater";
    private Collection mAssociationModels;
    protected SQLiteDatabase mDb;
    
    private List findForeignKeyToRemove(final TableModel tableModel) {
        final ArrayList<String> list = new ArrayList<String>();
        final List foreignKeyColumns = this.getForeignKeyColumns(tableModel);
        final String tableName = tableModel.getTableName();
        for (final String s : foreignKeyColumns) {
            if (this.shouldDropForeignKey(tableName, DBUtility.getTableNameByForeignColumn(s))) {
                list.add(s);
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("findForeignKeyToRemove >> ");
        sb.append(tableModel.getTableName());
        sb.append(" ");
        sb.append(list);
        LogUtil.d("AssociationUpdater", sb.toString());
        return list;
    }
    
    private List findIntermediateTablesToDrop() {
        final ArrayList<String> list = new ArrayList<String>();
        for (final String s : DBUtility.findAllTableNames(this.mDb)) {
            if (DBUtility.isIntermediateTable(s, this.mDb)) {
                boolean b = true;
                for (final AssociationsModel associationsModel : this.mAssociationModels) {
                    if (associationsModel.getAssociationType() == 3) {
                        if (!s.equalsIgnoreCase(DBUtility.getIntermediateTableName(associationsModel.getTableName(), associationsModel.getAssociatedTableName()))) {
                            continue;
                        }
                        b = false;
                    }
                }
                if (!b) {
                    continue;
                }
                list.add(s);
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("findIntermediateTablesToDrop >> ");
        sb.append(list);
        LogUtil.d("AssociationUpdater", sb.toString());
        return list;
    }
    
    private String generateCreateNewTableSQL(final Collection collection, final TableModel tableModel) {
        final Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            tableModel.removeColumnModelByName(iterator.next());
        }
        return this.generateCreateTableSQL(tableModel);
    }
    
    private String[] getRemoveColumnSQLs(final Collection collection, final String s) {
        final TableModel tableModelFromDB = this.getTableModelFromDB(s);
        final String generateAlterToTempTableSQL = this.generateAlterToTempTableSQL(s);
        final StringBuilder sb = new StringBuilder();
        sb.append("generateRemoveColumnSQL >> ");
        sb.append(generateAlterToTempTableSQL);
        LogUtil.d("AssociationUpdater", sb.toString());
        final String generateCreateNewTableSQL = this.generateCreateNewTableSQL(collection, tableModelFromDB);
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("generateRemoveColumnSQL >> ");
        sb2.append(generateCreateNewTableSQL);
        LogUtil.d("AssociationUpdater", sb2.toString());
        final String generateDataMigrationSQL = this.generateDataMigrationSQL(tableModelFromDB);
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("generateRemoveColumnSQL >> ");
        sb3.append(generateDataMigrationSQL);
        LogUtil.d("AssociationUpdater", sb3.toString());
        final String generateDropTempTableSQL = this.generateDropTempTableSQL(s);
        final StringBuilder sb4 = new StringBuilder();
        sb4.append("generateRemoveColumnSQL >> ");
        sb4.append(generateDropTempTableSQL);
        LogUtil.d("AssociationUpdater", sb4.toString());
        return new String[] { generateAlterToTempTableSQL, generateCreateNewTableSQL, generateDataMigrationSQL, generateDropTempTableSQL };
    }
    
    private boolean isRelationCorrect(final AssociationsModel associationsModel, final String s, final String s2) {
        return associationsModel.getTableName().equalsIgnoreCase(s) && associationsModel.getAssociatedTableName().equalsIgnoreCase(s2);
    }
    
    private void removeAssociations() {
        this.removeForeignKeyColumns();
        this.removeIntermediateTables();
    }
    
    private void removeForeignKeyColumns() {
        final Iterator<String> iterator = LitePalAttr.getInstance().getClassNames().iterator();
        while (iterator.hasNext()) {
            final TableModel tableModel = this.getTableModel(iterator.next());
            this.removeColumns(this.findForeignKeyToRemove(tableModel), tableModel.getTableName());
        }
    }
    
    private void removeIntermediateTables() {
        final List intermediateTablesToDrop = this.findIntermediateTablesToDrop();
        this.dropTables(intermediateTablesToDrop, this.mDb);
        this.clearCopyInTableSchema(intermediateTablesToDrop);
    }
    
    private boolean shouldDropForeignKey(final String s, final String s2) {
        final Iterator iterator = this.mAssociationModels.iterator();
        while (true) {
            final boolean hasNext = iterator.hasNext();
            final boolean b = true;
            if (!hasNext) {
                return b;
            }
            final AssociationsModel associationsModel = iterator.next();
            if (associationsModel.getAssociationType() == (b ? 1 : 0)) {
                if (!s.equalsIgnoreCase(associationsModel.getTableHoldsForeignKey())) {
                    continue;
                }
                if (associationsModel.getTableName().equalsIgnoreCase(s)) {
                    if (this.isRelationCorrect(associationsModel, s, s2)) {
                        return false;
                    }
                    continue;
                }
                else {
                    if (!associationsModel.getAssociatedTableName().equalsIgnoreCase(s)) {
                        continue;
                    }
                    if (this.isRelationCorrect(associationsModel, s2, s)) {
                        return false;
                    }
                    continue;
                }
            }
            else {
                if (associationsModel.getAssociationType() != 2) {
                    continue;
                }
                if (this.isRelationCorrect(associationsModel, s2, s)) {
                    return false;
                }
                continue;
            }
        }
    }
    
    protected void addOrUpdateAssociation(final SQLiteDatabase mDb, final boolean b) {
        this.mAssociationModels = this.getAllAssociations();
        this.mDb = mDb;
        this.removeAssociations();
    }
    
    protected void clearCopyInTableSchema(final List list) {
        if (list != null && !list.isEmpty()) {
            final StringBuilder sb = new StringBuilder("delete from ");
            sb.append("table_schema");
            sb.append(" where");
            int n = 0;
            for (final String s : list) {
                if (n != 0) {
                    sb.append(" or ");
                }
                n = 1;
                sb.append(" lower(");
                sb.append("name");
                sb.append(") ");
                sb.append("=");
                sb.append(" lower('");
                sb.append(s);
                sb.append("')");
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("clear table schema value sql is ");
            sb2.append((Object)sb);
            LogUtil.d("AssociationUpdater", sb2.toString());
            this.execute(new String[] { sb.toString() }, this.mDb);
        }
    }
    
    protected abstract void createOrUpgradeTable(final SQLiteDatabase p0, final boolean p1);
    
    protected void dropTables(final List list, final SQLiteDatabase sqLiteDatabase) {
        if (list != null && !list.isEmpty()) {
            final String[] array = new String[list.size()];
            for (int i = 0; i < array.length; ++i) {
                array[i] = this.generateDropTableSQL(list.get(i));
            }
            this.execute(array, sqLiteDatabase);
        }
    }
    
    protected String generateAlterToTempTableSQL(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("alter table ");
        sb.append(s);
        sb.append(" rename to ");
        sb.append(this.getTempTableName(s));
        return sb.toString();
    }
    
    protected String generateDataMigrationSQL(final TableModel tableModel) {
        final String tableName = tableModel.getTableName();
        final List columnModels = tableModel.getColumnModels();
        if (!columnModels.isEmpty()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("insert into ");
            sb.append(tableName);
            sb.append("(");
            int n = 0;
            for (final ColumnModel columnModel : columnModels) {
                if (n != 0) {
                    sb.append(", ");
                }
                n = 1;
                sb.append(columnModel.getColumnName());
            }
            sb.append(") ");
            sb.append("select ");
            int n2 = 0;
            for (final ColumnModel columnModel2 : columnModels) {
                if (n2 != 0) {
                    sb.append(", ");
                }
                n2 = 1;
                sb.append(columnModel2.getColumnName());
            }
            sb.append(" from ");
            sb.append(this.getTempTableName(tableName));
            return sb.toString();
        }
        return null;
    }
    
    protected String generateDropTempTableSQL(final String s) {
        return this.generateDropTableSQL(this.getTempTableName(s));
    }
    
    protected List getForeignKeyColumns(final TableModel tableModel) {
        final ArrayList<String> list = new ArrayList<String>();
        for (final ColumnModel columnModel : this.getTableModelFromDB(tableModel.getTableName()).getColumnModels()) {
            final String columnName = columnModel.getColumnName();
            if (this.isForeignKeyColumnFormat(columnModel.getColumnName())) {
                if (tableModel.containsColumn(columnName)) {
                    continue;
                }
                final String s = "AssociationUpdater";
                final StringBuilder sb = new StringBuilder();
                sb.append("getForeignKeyColumnNames >> foreign key column is ");
                sb.append(columnName);
                LogUtil.d(s, sb.toString());
                list.add(columnName);
            }
        }
        return list;
    }
    
    protected TableModel getTableModelFromDB(final String s) {
        return DBUtility.findPragmaTableInfo(s, this.mDb);
    }
    
    protected String getTempTableName(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("_temp");
        return sb.toString();
    }
    
    protected boolean isForeignKeyColumn(final TableModel tableModel, final String s) {
        return BaseUtility.containsIgnoreCases(this.getForeignKeyColumns(tableModel), s);
    }
    
    protected void removeColumns(final Collection collection, final String s) {
        if (collection != null && !collection.isEmpty()) {
            this.execute(this.getRemoveColumnSQLs(collection, s), this.mDb);
        }
    }
}
