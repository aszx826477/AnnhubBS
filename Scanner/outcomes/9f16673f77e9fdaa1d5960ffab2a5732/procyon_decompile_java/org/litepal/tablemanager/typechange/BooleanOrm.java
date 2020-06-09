// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.tablemanager.typechange;

public class BooleanOrm extends OrmChange
{
    public String object2Relation(final String s) {
        if (s != null && (s.equals("boolean") || s.equals("java.lang.Boolean"))) {
            return "integer";
        }
        return null;
    }
}
