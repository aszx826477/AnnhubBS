// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

final class TypeAdapters$1 extends TypeAdapter
{
    public Class read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }
    
    public void write(final JsonWriter jsonWriter, final Class clazz) {
        if (clazz == null) {
            jsonWriter.nullValue();
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Attempted to serialize java.lang.Class: ");
        sb.append(clazz.getName());
        sb.append(". Forgot to register a type adapter?");
        throw new UnsupportedOperationException(sb.toString());
    }
}
