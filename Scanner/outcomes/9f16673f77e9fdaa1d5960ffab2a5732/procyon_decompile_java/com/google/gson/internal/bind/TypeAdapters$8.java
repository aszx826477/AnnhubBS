// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonSyntaxException;
import java.util.concurrent.atomic.AtomicInteger;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

final class TypeAdapters$8 extends TypeAdapter
{
    public AtomicInteger read(final JsonReader jsonReader) {
        try {
            try {
                return new AtomicInteger(jsonReader.nextInt());
            }
            catch (NumberFormatException ex) {
                throw new JsonSyntaxException(ex);
            }
        }
        catch (NumberFormatException ex2) {}
    }
    
    public void write(final JsonWriter jsonWriter, final AtomicInteger atomicInteger) {
        jsonWriter.value(atomicInteger.get());
    }
}
