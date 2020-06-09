// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

final class TypeAdapters$4 extends TypeAdapter
{
    public Boolean read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return Boolean.valueOf(jsonReader.nextString());
    }
    
    public void write(final JsonWriter jsonWriter, final Boolean b) {
        String string;
        if (b == null) {
            string = "null";
        }
        else {
            string = b.toString();
        }
        jsonWriter.value(string);
    }
}
