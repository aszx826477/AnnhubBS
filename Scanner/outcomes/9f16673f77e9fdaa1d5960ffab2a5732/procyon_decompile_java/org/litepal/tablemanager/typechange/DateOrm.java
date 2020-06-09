// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.tablemanager.typechange;

public class DateOrm extends OrmChange
{
    public String object2Relation(final String s) {
        if (s != null && s.equals("java.util.Date")) {
            return "integer";
        }
        return null;
    }
}
