// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.tablemanager.typechange;

public class DecimalOrm extends OrmChange
{
    public String object2Relation(final String s) {
        if (s != null) {
            if (s.equals("float") || s.equals("java.lang.Float")) {
                return "real";
            }
            if (s.equals("double") || s.equals("java.lang.Double")) {
                return "real";
            }
        }
        return null;
    }
}
