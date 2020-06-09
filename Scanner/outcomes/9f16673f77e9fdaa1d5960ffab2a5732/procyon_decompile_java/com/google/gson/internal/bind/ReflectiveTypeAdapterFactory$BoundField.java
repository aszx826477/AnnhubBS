// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonReader;

abstract class ReflectiveTypeAdapterFactory$BoundField
{
    final boolean deserialized;
    final String name;
    final boolean serialized;
    
    protected ReflectiveTypeAdapterFactory$BoundField(final String name, final boolean serialized, final boolean deserialized) {
        this.name = name;
        this.serialized = serialized;
        this.deserialized = deserialized;
    }
    
    abstract void read(final JsonReader p0, final Object p1);
    
    abstract void write(final JsonWriter p0, final Object p1);
    
    abstract boolean writeField(final Object p0);
}
