// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.crud;

import java.util.Iterator;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;
import org.litepal.crud.model.AssociationsInfo;
import java.util.Collection;

public class Many2ManyAnalyzer extends AssociationsAnalyzer
{
    private void addNewModelForAssociatedModel(final Collection collection, final DataSupport dataSupport) {
        if (!collection.contains(dataSupport)) {
            collection.add(dataSupport);
        }
    }
    
    private void dealAssociatedModel(final DataSupport dataSupport, final DataSupport dataSupport2) {
        if (dataSupport2.isSaved()) {
            dataSupport.addAssociatedModelForJoinTable(dataSupport2.getTableName(), dataSupport2.getBaseObjId());
        }
    }
    
    private void declareAssociations(final DataSupport dataSupport, final AssociationsInfo associationsInfo) {
        dataSupport.addEmptyModelForJoinTable(this.getAssociatedTableName(associationsInfo));
    }
    
    private String getAssociatedTableName(final AssociationsInfo associationsInfo) {
        return BaseUtility.changeCase(DBUtility.getTableNameByClassName(associationsInfo.getAssociatedClassName()));
    }
    
    private String getJoinTableName(final DataSupport dataSupport, final DataSupport dataSupport2) {
        return this.getIntermediateTableName(dataSupport, dataSupport2.getTableName());
    }
    
    private String getSelection(final DataSupport dataSupport, final DataSupport dataSupport2) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getForeignKeyColumnName(dataSupport.getTableName()));
        sb.append(" = ? and ");
        sb.append(this.getForeignKeyColumnName(dataSupport2.getTableName()));
        sb.append(" = ?");
        return sb.toString();
    }
    
    private String[] getSelectionArgs(final DataSupport dataSupport, final DataSupport dataSupport2) {
        return new String[] { String.valueOf(dataSupport.getBaseObjId()), String.valueOf(dataSupport2.getBaseObjId()) };
    }
    
    private boolean isDataExists(final DataSupport dataSupport, final DataSupport dataSupport2) {
        final SQLiteDatabase database = Connector.getDatabase();
        Cursor query = null;
        boolean b = true;
        try {
            try {
                if ((query = database.query(this.getJoinTableName(dataSupport, dataSupport2), (String[])null, this.getSelection(dataSupport, dataSupport2), this.getSelectionArgs(dataSupport, dataSupport2), (String)null, (String)null, (String)null)).getCount() <= 0) {
                    b = false;
                }
                query.close();
                return b;
            }
            finally {}
        }
        catch (Exception ex) {
            ex.printStackTrace();
            query.close();
            return b;
        }
        query.close();
    }
    
    void analyze(final DataSupport dataSupport, final AssociationsInfo associationsInfo) {
        final Collection associatedModels = this.getAssociatedModels(dataSupport, associationsInfo);
        this.declareAssociations(dataSupport, associationsInfo);
        if (associatedModels != null) {
            for (final DataSupport dataSupport2 : associatedModels) {
                final Collection checkAssociatedModelCollection = this.checkAssociatedModelCollection(this.getReverseAssociatedModels(dataSupport2, associationsInfo), associationsInfo.getAssociateSelfFromOtherModel());
                this.addNewModelForAssociatedModel(checkAssociatedModelCollection, dataSupport);
                this.setReverseAssociatedModels(dataSupport2, associationsInfo, checkAssociatedModelCollection);
                this.dealAssociatedModel(dataSupport, dataSupport2);
            }
        }
    }
}
