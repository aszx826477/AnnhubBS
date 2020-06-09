// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

final class TypeAdapters$14 extends TypeAdapter
{
    public Number read(final JsonReader jsonReader) {
        final JsonToken peek = jsonReader.peek();
        final int n = TypeAdapters$36.$SwitchMap$com$google$gson$stream$JsonToken[peek.ordinal()];
        if (n == 1) {
            return new LazilyParsedNumber(jsonReader.nextString());
        }
        if (n == 4) {
            jsonReader.nextNull();
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expecting number, got: ");
        sb.append(peek);
        throw new JsonSyntaxException(sb.toString());
    }
    
    public void write(final JsonWriter jsonWriter, final Number n) {
        jsonWriter.value(n);
    }
}
