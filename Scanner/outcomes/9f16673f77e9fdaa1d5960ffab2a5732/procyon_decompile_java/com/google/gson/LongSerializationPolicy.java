// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

public enum LongSerializationPolicy
{
    DEFAULT("DEFAULT", 0) {
        LongSerializationPolicy$1(final String s, final int n) {
        }
        
        public JsonElement serialize(final Long n) {
            return new JsonPrimitive(n);
        }
    }, 
    STRING("STRING", n) {
        LongSerializationPolicy$2(final String s, final int n) {
        }
        
        public JsonElement serialize(final Long n) {
            return new JsonPrimitive(String.valueOf(n));
        }
    };
    
    static {
        final int n = 1;
        final LongSerializationPolicy[] $values = { LongSerializationPolicy.DEFAULT, null };
        $values[n] = LongSerializationPolicy.STRING;
        $VALUES = $values;
    }
    
    private LongSerializationPolicy(final String s, final int n) {
    }
    
    public abstract JsonElement serialize(final Long p0);
}
