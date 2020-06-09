// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.tablemanager.model;

public class AssociationsModel
{
    private String associatedTableName;
    private int associationType;
    private String tableHoldsForeignKey;
    private String tableName;
    
    public boolean equals(final Object o) {
        if (o instanceof AssociationsModel) {
            final AssociationsModel associationsModel = (AssociationsModel)o;
            if (associationsModel.getTableName() != null && associationsModel.getAssociatedTableName() != null) {
                if (associationsModel.getAssociationType() == this.associationType && associationsModel.getTableHoldsForeignKey().equals(this.tableHoldsForeignKey)) {
                    final boolean equals = associationsModel.getTableName().equals(this.tableName);
                    final boolean b = true;
                    if (equals && associationsModel.getAssociatedTableName().equals(this.associatedTableName) && associationsModel.getTableHoldsForeignKey().equals(this.tableHoldsForeignKey)) {
                        return b;
                    }
                    if (associationsModel.getTableName().equals(this.associatedTableName) && associationsModel.getAssociatedTableName().equals(this.tableName) && associationsModel.getTableHoldsForeignKey().equals(this.tableHoldsForeignKey)) {
                        return b;
                    }
                }
            }
        }
        return false;
    }
    
    public String getAssociatedTableName() {
        return this.associatedTableName;
    }
    
    public int getAssociationType() {
        return this.associationType;
    }
    
    public String getTableHoldsForeignKey() {
        return this.tableHoldsForeignKey;
    }
    
    public String getTableName() {
        return this.tableName;
    }
    
    public void setAssociatedTableName(final String associatedTableName) {
        this.associatedTableName = associatedTableName;
    }
    
    public void setAssociationType(final int associationType) {
        this.associationType = associationType;
    }
    
    public void setTableHoldsForeignKey(final String tableHoldsForeignKey) {
        this.tableHoldsForeignKey = tableHoldsForeignKey;
    }
    
    public void setTableName(final String tableName) {
        this.tableName = tableName;
    }
}
