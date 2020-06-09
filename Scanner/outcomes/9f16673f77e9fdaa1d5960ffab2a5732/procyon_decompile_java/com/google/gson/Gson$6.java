// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import com.google.gson.stream.JsonWriter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;
import com.google.gson.stream.JsonReader;

final class Gson$6 extends TypeAdapter
{
    final /* synthetic */ TypeAdapter val$longAdapter;
    
    Gson$6(final TypeAdapter val$longAdapter) {
        this.val$longAdapter = val$longAdapter;
    }
    
    public AtomicLongArray read(final JsonReader jsonReader) {
        final ArrayList<Long> list = new ArrayList<Long>();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            list.add(((Number)this.val$longAdapter.read(jsonReader)).longValue());
        }
        jsonReader.endArray();
        final int size = list.size();
        final AtomicLongArray atomicLongArray = new AtomicLongArray(size);
        for (int i = 0; i < size; ++i) {
            atomicLongArray.set(i, (long)list.get(i));
        }
        return atomicLongArray;
    }
    
    public void write(final JsonWriter jsonWriter, final AtomicLongArray atomicLongArray) {
        jsonWriter.beginArray();
        for (int i = 0; i < atomicLongArray.length(); ++i) {
            this.val$longAdapter.write(jsonWriter, atomicLongArray.get(i));
        }
        jsonWriter.endArray();
    }
}
