// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import java.util.Currency;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

final class TypeAdapters$25 extends TypeAdapter
{
    public Currency read(final JsonReader jsonReader) {
        return Currency.getInstance(jsonReader.nextString());
    }
    
    public void write(final JsonWriter jsonWriter, final Currency currency) {
        jsonWriter.value(currency.getCurrencyCode());
    }
}
