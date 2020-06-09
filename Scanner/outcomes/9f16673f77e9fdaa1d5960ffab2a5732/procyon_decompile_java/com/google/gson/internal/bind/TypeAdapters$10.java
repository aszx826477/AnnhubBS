// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

final class TypeAdapters$10 extends TypeAdapter
{
    public AtomicIntegerArray read(final JsonReader jsonReader) {
        final ArrayList<Integer> list = new ArrayList<Integer>();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            try {
                final int nextInt = jsonReader.nextInt();
                try {
                    list.add(nextInt);
                }
                catch (NumberFormatException ex) {
                    throw new JsonSyntaxException(ex);
                }
            }
            catch (NumberFormatException ex2) {}
            break;
        }
        jsonReader.endArray();
        final int size = list.size();
        final AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i = 0; i < size; ++i) {
            atomicIntegerArray.set(i, (int)list.get(i));
        }
        return atomicIntegerArray;
    }
    
    public void write(final JsonWriter jsonWriter, final AtomicIntegerArray atomicIntegerArray) {
        jsonWriter.beginArray();
        for (int i = 0; i < atomicIntegerArray.length(); ++i) {
            jsonWriter.value(atomicIntegerArray.get(i));
        }
        jsonWriter.endArray();
    }
}
