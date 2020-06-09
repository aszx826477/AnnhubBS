// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.tablemanager.typechange;

public class TextOrm extends OrmChange
{
    public String object2Relation(final String s) {
        if (s != null) {
            if (s.equals("char") || s.equals("java.lang.Character")) {
                return "text";
            }
            if (s.equals("java.lang.String")) {
                return "text";
            }
        }
        return null;
    }
}
