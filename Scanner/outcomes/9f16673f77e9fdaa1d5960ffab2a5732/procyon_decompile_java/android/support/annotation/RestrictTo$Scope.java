// 
// Decompiled by Procyon v0.5.30
// 

package android.support.annotation;

public enum RestrictTo$Scope
{
    GROUP_ID("GROUP_ID", n2), 
    LIBRARY("LIBRARY", 0), 
    LIBRARY_GROUP("LIBRARY_GROUP", n), 
    SUBCLASSES("SUBCLASSES", n4), 
    TESTS("TESTS", n3);
    
    static {
        final int n = 1;
        final int n2 = 2;
        final int n3 = 3;
        final int n4 = 4;
        final RestrictTo$Scope[] $values = new RestrictTo$Scope[5];
        $values[0] = RestrictTo$Scope.LIBRARY;
        $values[n] = RestrictTo$Scope.LIBRARY_GROUP;
        $values[n2] = RestrictTo$Scope.GROUP_ID;
        $values[n3] = RestrictTo$Scope.TESTS;
        $values[n4] = RestrictTo$Scope.SUBCLASSES;
        $VALUES = $values;
    }
    
    private RestrictTo$Scope(final String s, final int n) {
    }
}
