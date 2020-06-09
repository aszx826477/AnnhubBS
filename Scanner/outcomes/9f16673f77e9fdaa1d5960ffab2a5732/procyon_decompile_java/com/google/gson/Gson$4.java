// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;

final class Gson$4 extends TypeAdapter
{
    public Number read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return jsonReader.nextLong();
    }
    
    public void write(final JsonWriter jsonWriter, final Number n) {
        if (n == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.value(n.toString());
    }
}
