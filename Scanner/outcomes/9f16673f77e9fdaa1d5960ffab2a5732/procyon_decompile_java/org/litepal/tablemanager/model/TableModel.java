// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.tablemanager.model;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class TableModel
{
    private String className;
    private List columnModels;
    private String tableName;
    
    public TableModel() {
        this.columnModels = new ArrayList();
    }
    
    public void addColumnModel(final ColumnModel columnModel) {
        this.columnModels.add(columnModel);
    }
    
    public boolean containsColumn(final String s) {
        for (int i = 0; i < this.columnModels.size(); ++i) {
            if (s.equalsIgnoreCase(((ColumnModel)this.columnModels.get(i)).getColumnName())) {
                return true;
            }
        }
        return false;
    }
    
    public String getClassName() {
        return this.className;
    }
    
    public ColumnModel getColumnModelByName(final String s) {
        for (final ColumnModel columnModel : this.columnModels) {
            if (columnModel.getColumnName().equalsIgnoreCase(s)) {
                return columnModel;
            }
        }
        return null;
    }
    
    public List getColumnModels() {
        return this.columnModels;
    }
    
    public String getTableName() {
        return this.tableName;
    }
    
    public void removeColumnModelByName(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return;
        }
        int n = -1;
        for (int i = 0; i < this.columnModels.size(); ++i) {
            if (s.equalsIgnoreCase(((ColumnModel)this.columnModels.get(i)).getColumnName())) {
                n = i;
                break;
            }
        }
        if (n != -1) {
            this.columnModels.remove(n);
        }
    }
    
    public void setClassName(final String className) {
        this.className = className;
    }
    
    public void setTableName(final String tableName) {
        this.tableName = tableName;
    }
}
