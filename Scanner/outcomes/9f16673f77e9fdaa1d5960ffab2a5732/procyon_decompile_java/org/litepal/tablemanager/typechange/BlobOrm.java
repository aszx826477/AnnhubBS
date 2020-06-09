// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.tablemanager.typechange;

public class BlobOrm extends OrmChange
{
    public String object2Relation(final String s) {
        if (s != null && (s.equals("byte") || s.equals("java.lang.Byte"))) {
            return "blob";
        }
        return null;
    }
}
