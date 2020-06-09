// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

final class TypeAdapters$15 extends TypeAdapter
{
    public Character read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        final String nextString = jsonReader.nextString();
        if (nextString.length() == 1) {
            return nextString.charAt(0);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expecting character, got: ");
        sb.append(nextString);
        throw new JsonSyntaxException(sb.toString());
    }
    
    public void write(final JsonWriter jsonWriter, final Character c) {
        String value;
        if (c == null) {
            value = null;
        }
        else {
            value = String.valueOf(c);
        }
        jsonWriter.value(value);
    }
}
