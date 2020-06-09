// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.crud;

import org.litepal.util.DBUtility;
import org.litepal.crud.model.AssociationsInfo;

public class One2OneAnalyzer extends AssociationsAnalyzer
{
    private void bidirectionalCondition(final DataSupport dataSupport, final DataSupport dataSupport2) {
        if (dataSupport2.isSaved()) {
            dataSupport.addAssociatedModelWithFK(dataSupport2.getTableName(), dataSupport2.getBaseObjId());
            dataSupport.addAssociatedModelWithoutFK(dataSupport2.getTableName(), dataSupport2.getBaseObjId());
        }
    }
    
    private void dealAssociatedModel(final DataSupport dataSupport, final DataSupport dataSupport2, final AssociationsInfo associationsInfo) {
        if (associationsInfo.getAssociateSelfFromOtherModel() != null) {
            this.bidirectionalCondition(dataSupport, dataSupport2);
        }
        else {
            this.unidirectionalCondition(dataSupport, dataSupport2);
        }
    }
    
    private void unidirectionalCondition(final DataSupport dataSupport, final DataSupport dataSupport2) {
        this.dealsAssociationsOnTheSideWithoutFK(dataSupport, dataSupport2);
    }
    
    void analyze(final DataSupport dataSupport, final AssociationsInfo associationsInfo) {
        final DataSupport associatedModel = this.getAssociatedModel(dataSupport, associationsInfo);
        if (associatedModel != null) {
            this.buildBidirectionalAssociations(dataSupport, associatedModel, associationsInfo);
            this.dealAssociatedModel(dataSupport, associatedModel, associationsInfo);
        }
        else {
            dataSupport.addAssociatedTableNameToClearFK(DBUtility.getTableNameByClassName(associationsInfo.getAssociatedClassName()));
        }
    }
}
