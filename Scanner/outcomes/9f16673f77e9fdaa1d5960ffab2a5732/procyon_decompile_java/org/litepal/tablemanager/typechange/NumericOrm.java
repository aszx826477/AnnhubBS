// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.tablemanager.typechange;

public class NumericOrm extends OrmChange
{
    public String object2Relation(final String s) {
        if (s != null) {
            if (s.equals("int") || s.equals("java.lang.Integer")) {
                return "integer";
            }
            if (s.equals("long") || s.equals("java.lang.Long")) {
                return "integer";
            }
            if (s.equals("short") || s.equals("java.lang.Short")) {
                return "integer";
            }
        }
        return null;
    }
}
