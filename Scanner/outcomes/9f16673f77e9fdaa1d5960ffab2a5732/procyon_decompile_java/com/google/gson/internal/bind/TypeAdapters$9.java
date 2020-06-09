// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import java.util.concurrent.atomic.AtomicBoolean;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

final class TypeAdapters$9 extends TypeAdapter
{
    public AtomicBoolean read(final JsonReader jsonReader) {
        return new AtomicBoolean(jsonReader.nextBoolean());
    }
    
    public void write(final JsonWriter jsonWriter, final AtomicBoolean atomicBoolean) {
        jsonWriter.value(atomicBoolean.get());
    }
}
