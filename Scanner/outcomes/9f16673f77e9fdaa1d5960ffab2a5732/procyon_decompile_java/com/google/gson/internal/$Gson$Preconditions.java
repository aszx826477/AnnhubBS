// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

public final class $Gson$Preconditions
{
    private $Gson$Preconditions() {
        throw new UnsupportedOperationException();
    }
    
    public static void checkArgument(final boolean b) {
        if (b) {
            return;
        }
        throw new IllegalArgumentException();
    }
    
    public static Object checkNotNull(final Object o) {
        if (o != null) {
            return o;
        }
        throw new NullPointerException();
    }
}
