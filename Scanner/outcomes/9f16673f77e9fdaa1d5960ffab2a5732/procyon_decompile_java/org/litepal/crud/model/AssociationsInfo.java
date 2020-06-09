// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.crud.model;

import java.lang.reflect.Field;

public class AssociationsInfo
{
    private Field associateOtherModelFromSelf;
    private Field associateSelfFromOtherModel;
    private String associatedClassName;
    private int associationType;
    private String classHoldsForeignKey;
    private String selfClassName;
    
    public boolean equals(final Object o) {
        if (o instanceof AssociationsInfo) {
            final AssociationsInfo associationsInfo = (AssociationsInfo)o;
            if (o != null && associationsInfo != null) {
                if (associationsInfo.getAssociationType() == this.associationType && associationsInfo.getClassHoldsForeignKey().equals(this.classHoldsForeignKey)) {
                    final boolean equals = associationsInfo.getSelfClassName().equals(this.selfClassName);
                    final boolean b = true;
                    if (equals && associationsInfo.getAssociatedClassName().equals(this.associatedClassName)) {
                        return b;
                    }
                    if (associationsInfo.getSelfClassName().equals(this.associatedClassName) && associationsInfo.getAssociatedClassName().equals(this.selfClassName)) {
                        return b;
                    }
                }
            }
        }
        return false;
    }
    
    public Field getAssociateOtherModelFromSelf() {
        return this.associateOtherModelFromSelf;
    }
    
    public Field getAssociateSelfFromOtherModel() {
        return this.associateSelfFromOtherModel;
    }
    
    public String getAssociatedClassName() {
        return this.associatedClassName;
    }
    
    public int getAssociationType() {
        return this.associationType;
    }
    
    public String getClassHoldsForeignKey() {
        return this.classHoldsForeignKey;
    }
    
    public String getSelfClassName() {
        return this.selfClassName;
    }
    
    public void setAssociateOtherModelFromSelf(final Field associateOtherModelFromSelf) {
        this.associateOtherModelFromSelf = associateOtherModelFromSelf;
    }
    
    public void setAssociateSelfFromOtherModel(final Field associateSelfFromOtherModel) {
        this.associateSelfFromOtherModel = associateSelfFromOtherModel;
    }
    
    public void setAssociatedClassName(final String associatedClassName) {
        this.associatedClassName = associatedClassName;
    }
    
    public void setAssociationType(final int associationType) {
        this.associationType = associationType;
    }
    
    public void setClassHoldsForeignKey(final String classHoldsForeignKey) {
        this.classHoldsForeignKey = classHoldsForeignKey;
    }
    
    public void setSelfClassName(final String selfClassName) {
        this.selfClassName = selfClassName;
    }
}
