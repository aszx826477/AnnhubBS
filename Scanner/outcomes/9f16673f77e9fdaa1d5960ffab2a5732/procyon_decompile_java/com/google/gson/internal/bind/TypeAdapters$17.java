// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.math.BigDecimal;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

final class TypeAdapters$17 extends TypeAdapter
{
    public BigDecimal read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            try {
                return new BigDecimal(jsonReader.nextString());
            }
            catch (NumberFormatException ex) {
                throw new JsonSyntaxException(ex);
            }
        }
        catch (NumberFormatException ex2) {}
    }
    
    public void write(final JsonWriter jsonWriter, final BigDecimal bigDecimal) {
        jsonWriter.value(bigDecimal);
    }
}
