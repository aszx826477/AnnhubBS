// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.stream;

public enum JsonToken
{
    BEGIN_ARRAY("BEGIN_ARRAY", 0), 
    BEGIN_OBJECT("BEGIN_OBJECT", n2), 
    BOOLEAN("BOOLEAN", n7), 
    END_ARRAY("END_ARRAY", n), 
    END_DOCUMENT("END_DOCUMENT", n9), 
    END_OBJECT("END_OBJECT", n3), 
    NAME("NAME", n4), 
    NULL("NULL", n8), 
    NUMBER("NUMBER", n6), 
    STRING("STRING", n5);
    
    static {
        final int n = 1;
        final int n2 = 2;
        final int n3 = 3;
        final int n4 = 4;
        final int n5 = 5;
        final int n6 = 6;
        final int n7 = 7;
        final int n8 = 8;
        final int n9 = 9;
        final JsonToken[] $values = new JsonToken[10];
        $values[0] = JsonToken.BEGIN_ARRAY;
        $values[n] = JsonToken.END_ARRAY;
        $values[n2] = JsonToken.BEGIN_OBJECT;
        $values[n3] = JsonToken.END_OBJECT;
        $values[n4] = JsonToken.NAME;
        $values[n5] = JsonToken.STRING;
        $values[n6] = JsonToken.NUMBER;
        $values[n7] = JsonToken.BOOLEAN;
        $values[n8] = JsonToken.NULL;
        $values[n9] = JsonToken.END_DOCUMENT;
        $VALUES = $values;
    }
    
    private JsonToken(final String s, final int n) {
    }
}
