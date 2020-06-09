// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.tablemanager.model;

import android.text.TextUtils;

public class ColumnModel
{
    private String columnName;
    private String columnType;
    private String defaultValue;
    private boolean isNullable;
    private boolean isUnique;
    
    public ColumnModel() {
        this.isNullable = true;
        this.isUnique = false;
        this.defaultValue = "";
    }
    
    public String getColumnName() {
        return this.columnName;
    }
    
    public String getColumnType() {
        return this.columnType;
    }
    
    public String getDefaultValue() {
        return this.defaultValue;
    }
    
    public boolean isIdColumn() {
        return "_id".equalsIgnoreCase(this.columnName) || "id".equalsIgnoreCase(this.columnName);
    }
    
    public boolean isNullable() {
        return this.isNullable;
    }
    
    public boolean isUnique() {
        return this.isUnique;
    }
    
    public void setColumnName(final String columnName) {
        this.columnName = columnName;
    }
    
    public void setColumnType(final String columnType) {
        this.columnType = columnType;
    }
    
    public void setDefaultValue(final String defaultValue) {
        if ("text".equalsIgnoreCase(this.columnType)) {
            if (!TextUtils.isEmpty((CharSequence)defaultValue)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("'");
                sb.append(defaultValue);
                sb.append("'");
                this.defaultValue = sb.toString();
            }
        }
        else {
            this.defaultValue = defaultValue;
        }
    }
    
    public void setIsNullable(final boolean isNullable) {
        this.isNullable = isNullable;
    }
    
    public void setIsUnique(final boolean isUnique) {
        this.isUnique = isUnique;
    }
}
