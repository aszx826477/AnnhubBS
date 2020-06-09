// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.tablemanager;

import java.util.Iterator;
import java.util.ArrayList;
import android.database.SQLException;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.util.BaseUtility;
import org.litepal.parser.LitePalAttr;
import android.database.sqlite.SQLiteDatabase;
import java.util.Collection;
import org.litepal.LitePalBase;

public abstract class Generator extends LitePalBase
{
    public static final String TAG = "Generator";
    private Collection mAllRelationModels;
    private Collection mTableModels;
    
    private static void addAssociation(final SQLiteDatabase sqLiteDatabase, final boolean b) {
        new Creator().addOrUpdateAssociation(sqLiteDatabase, b);
    }
    
    private boolean canUseCache() {
        final Collection mTableModels = this.mTableModels;
        boolean b = false;
        if (mTableModels == null) {
            return false;
        }
        if (mTableModels.size() == LitePalAttr.getInstance().getClassNames().size()) {
            b = true;
        }
        return b;
    }
    
    static void create(final SQLiteDatabase sqLiteDatabase) {
        final boolean b = true;
        create(sqLiteDatabase, b);
        addAssociation(sqLiteDatabase, b);
    }
    
    private static void create(final SQLiteDatabase sqLiteDatabase, final boolean b) {
        new Creator().createOrUpgradeTable(sqLiteDatabase, b);
    }
    
    private static void drop(final SQLiteDatabase sqLiteDatabase) {
        new Dropper().createOrUpgradeTable(sqLiteDatabase, false);
    }
    
    private static void updateAssociations(final SQLiteDatabase sqLiteDatabase) {
        new Upgrader().addOrUpdateAssociation(sqLiteDatabase, false);
    }
    
    static void upgrade(final SQLiteDatabase sqLiteDatabase) {
        drop(sqLiteDatabase);
        create(sqLiteDatabase, false);
        updateAssociations(sqLiteDatabase);
        upgradeTables(sqLiteDatabase);
        addAssociation(sqLiteDatabase, false);
    }
    
    private static void upgradeTables(final SQLiteDatabase sqLiteDatabase) {
        new Upgrader().createOrUpgradeTable(sqLiteDatabase, false);
    }
    
    protected abstract void addOrUpdateAssociation(final SQLiteDatabase p0, final boolean p1);
    
    protected abstract void createOrUpgradeTable(final SQLiteDatabase p0, final boolean p1);
    
    protected void execute(final String[] array, final SQLiteDatabase sqLiteDatabase) {
        String s = "";
        if (array != null) {
            try {
                for (int length = array.length, i = 0; i < length; ++i) {
                    sqLiteDatabase.execSQL(BaseUtility.changeCase(s = array[i]));
                }
            }
            catch (SQLException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("An exception that indicates there was an error with SQL parsing or execution. ");
                sb.append(s);
                throw new DatabaseGenerateException(sb.toString());
            }
        }
    }
    
    protected Collection getAllAssociations() {
        final Collection mAllRelationModels = this.mAllRelationModels;
        if (mAllRelationModels == null || mAllRelationModels.isEmpty()) {
            this.mAllRelationModels = this.getAssociations(LitePalAttr.getInstance().getClassNames());
        }
        return this.mAllRelationModels;
    }
    
    protected Collection getAllTableModels() {
        if (this.mTableModels == null) {
            this.mTableModels = new ArrayList();
        }
        if (!this.canUseCache()) {
            this.mTableModels.clear();
            final Iterator<String> iterator = LitePalAttr.getInstance().getClassNames().iterator();
            while (iterator.hasNext()) {
                this.mTableModels.add(this.getTableModel(iterator.next()));
            }
        }
        return this.mTableModels;
    }
}
