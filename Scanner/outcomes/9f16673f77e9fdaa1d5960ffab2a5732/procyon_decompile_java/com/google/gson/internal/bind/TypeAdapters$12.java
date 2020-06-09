// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

final class TypeAdapters$12 extends TypeAdapter
{
    public Number read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return (float)jsonReader.nextDouble();
    }
    
    public void write(final JsonWriter jsonWriter, final Number n) {
        jsonWriter.value(n);
    }
}
