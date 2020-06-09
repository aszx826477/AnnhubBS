// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

final class TypeAdapters$16 extends TypeAdapter
{
    public String read(final JsonReader jsonReader) {
        final JsonToken peek = jsonReader.peek();
        if (peek == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (peek == JsonToken.BOOLEAN) {
            return Boolean.toString(jsonReader.nextBoolean());
        }
        return jsonReader.nextString();
    }
    
    public void write(final JsonWriter jsonWriter, final String s) {
        jsonWriter.value(s);
    }
}
