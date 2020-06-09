// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.tablemanager;

import org.litepal.util.DBUtility;
import java.util.Iterator;
import org.litepal.tablemanager.model.TableModel;
import android.database.sqlite.SQLiteDatabase;

class Creator extends AssociationCreator
{
    public static final String TAG = "Creator";
    
    protected void createOrUpgradeTable(final SQLiteDatabase sqLiteDatabase, final boolean b) {
        final Iterator<TableModel> iterator = this.getAllTableModels().iterator();
        while (iterator.hasNext()) {
            this.createOrUpgradeTable(iterator.next(), sqLiteDatabase, b);
        }
    }
    
    protected void createOrUpgradeTable(final TableModel tableModel, final SQLiteDatabase sqLiteDatabase, final boolean b) {
        this.execute(this.getCreateTableSQLs(tableModel, sqLiteDatabase, b), sqLiteDatabase);
        this.giveTableSchemaACopy(tableModel.getTableName(), 0, sqLiteDatabase);
    }
    
    protected String generateCreateTableSQL(final TableModel tableModel) {
        return this.generateCreateTableSQL(tableModel.getTableName(), tableModel.getColumnModels(), true);
    }
    
    protected String generateDropTableSQL(final TableModel tableModel) {
        return this.generateDropTableSQL(tableModel.getTableName());
    }
    
    protected String[] getCreateTableSQLs(final TableModel tableModel, final SQLiteDatabase sqLiteDatabase, final boolean b) {
        final int n = 1;
        if (b) {
            final String[] array = { this.generateDropTableSQL(tableModel), null };
            array[n] = this.generateCreateTableSQL(tableModel);
            return array;
        }
        if (DBUtility.isTableExists(tableModel.getTableName(), sqLiteDatabase)) {
            return null;
        }
        final String[] array2 = new String[n];
        array2[0] = this.generateCreateTableSQL(tableModel);
        return array2;
    }
}
