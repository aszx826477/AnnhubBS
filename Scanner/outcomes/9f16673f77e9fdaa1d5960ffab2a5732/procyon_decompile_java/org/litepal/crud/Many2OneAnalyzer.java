// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.crud;

import java.util.Iterator;
import org.litepal.util.DBUtility;
import java.util.Collection;
import org.litepal.crud.model.AssociationsInfo;

class Many2OneAnalyzer extends AssociationsAnalyzer
{
    private void analyzeManySide(final DataSupport dataSupport, final AssociationsInfo associationsInfo) {
        final DataSupport associatedModel = this.getAssociatedModel(dataSupport, associationsInfo);
        if (associatedModel != null) {
            final Collection checkAssociatedModelCollection = this.checkAssociatedModelCollection(this.getReverseAssociatedModels(associatedModel, associationsInfo), associationsInfo.getAssociateSelfFromOtherModel());
            this.setReverseAssociatedModels(associatedModel, associationsInfo, checkAssociatedModelCollection);
            this.dealAssociatedModelOnManySide(checkAssociatedModelCollection, dataSupport, associatedModel);
        }
        else {
            this.mightClearFKValue(dataSupport, associationsInfo);
        }
    }
    
    private void analyzeOneSide(final DataSupport dataSupport, final AssociationsInfo associationsInfo) {
        final Collection associatedModels = this.getAssociatedModels(dataSupport, associationsInfo);
        if (associatedModels != null && !associatedModels.isEmpty()) {
            for (final DataSupport dataSupport2 : associatedModels) {
                this.buildBidirectionalAssociations(dataSupport, dataSupport2, associationsInfo);
                this.dealAssociatedModelOnOneSide(dataSupport, dataSupport2);
            }
            return;
        }
        dataSupport.addAssociatedTableNameToClearFK(DBUtility.getTableNameByClassName(associationsInfo.getAssociatedClassName()));
    }
    
    private void dealAssociatedModelOnManySide(final Collection collection, final DataSupport dataSupport, final DataSupport dataSupport2) {
        if (!collection.contains(dataSupport)) {
            collection.add(dataSupport);
        }
        if (dataSupport2.isSaved()) {
            dataSupport.addAssociatedModelWithoutFK(dataSupport2.getTableName(), dataSupport2.getBaseObjId());
        }
    }
    
    private void dealAssociatedModelOnOneSide(final DataSupport dataSupport, final DataSupport dataSupport2) {
        this.dealsAssociationsOnTheSideWithoutFK(dataSupport, dataSupport2);
    }
    
    void analyze(final DataSupport dataSupport, final AssociationsInfo associationsInfo) {
        if (dataSupport.getClassName().equals(associationsInfo.getClassHoldsForeignKey())) {
            this.analyzeManySide(dataSupport, associationsInfo);
        }
        else {
            this.analyzeOneSide(dataSupport, associationsInfo);
        }
    }
}
