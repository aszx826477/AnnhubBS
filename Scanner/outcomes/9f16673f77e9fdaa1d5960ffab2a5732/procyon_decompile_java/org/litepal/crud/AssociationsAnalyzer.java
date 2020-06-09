// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.crud;

import java.util.HashSet;
import org.litepal.exceptions.DataSupportException;
import java.util.ArrayList;
import java.lang.reflect.Field;
import java.util.Collection;
import org.litepal.util.DBUtility;
import org.litepal.crud.model.AssociationsInfo;

abstract class AssociationsAnalyzer extends DataHandler
{
    private String getForeignKeyName(final AssociationsInfo associationsInfo) {
        return this.getForeignKeyColumnName(DBUtility.getTableNameByClassName(associationsInfo.getAssociatedClassName()));
    }
    
    protected void buildBidirectionalAssociations(final DataSupport dataSupport, final DataSupport dataSupport2, final AssociationsInfo associationsInfo) {
        this.putSetMethodValueByField(dataSupport2, associationsInfo.getAssociateSelfFromOtherModel(), dataSupport);
    }
    
    protected Collection checkAssociatedModelCollection(final Collection collection, final Field field) {
        Cloneable cloneable;
        if (this.isList(field.getType())) {
            cloneable = new ArrayList<Object>();
        }
        else {
            if (!this.isSet(field.getType())) {
                throw new DataSupportException("The field to declare many2one or many2many associations should be List or Set.");
            }
            cloneable = new HashSet<Object>();
        }
        if (collection != null) {
            ((Collection)cloneable).addAll(collection);
        }
        return (Collection)cloneable;
    }
    
    protected void dealsAssociationsOnTheSideWithoutFK(final DataSupport dataSupport, final DataSupport dataSupport2) {
        if (dataSupport2 != null) {
            if (dataSupport2.isSaved()) {
                dataSupport.addAssociatedModelWithFK(dataSupport2.getTableName(), dataSupport2.getBaseObjId());
            }
            else if (dataSupport.isSaved()) {
                dataSupport2.addAssociatedModelWithoutFK(dataSupport.getTableName(), dataSupport.getBaseObjId());
            }
        }
    }
    
    protected Collection getReverseAssociatedModels(final DataSupport dataSupport, final AssociationsInfo associationsInfo) {
        return (Collection)this.takeGetMethodValueByField(dataSupport, associationsInfo.getAssociateSelfFromOtherModel());
    }
    
    protected void mightClearFKValue(final DataSupport dataSupport, final AssociationsInfo associationsInfo) {
        dataSupport.addFKNameToClearSelf(this.getForeignKeyName(associationsInfo));
    }
    
    protected void setReverseAssociatedModels(final DataSupport dataSupport, final AssociationsInfo associationsInfo, final Collection collection) {
        this.putSetMethodValueByField(dataSupport, associationsInfo.getAssociateSelfFromOtherModel(), collection);
    }
}
