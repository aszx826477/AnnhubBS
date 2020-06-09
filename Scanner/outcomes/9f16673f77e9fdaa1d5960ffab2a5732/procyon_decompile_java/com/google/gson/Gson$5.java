// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import com.google.gson.stream.JsonWriter;
import java.util.concurrent.atomic.AtomicLong;
import com.google.gson.stream.JsonReader;

final class Gson$5 extends TypeAdapter
{
    final /* synthetic */ TypeAdapter val$longAdapter;
    
    Gson$5(final TypeAdapter val$longAdapter) {
        this.val$longAdapter = val$longAdapter;
    }
    
    public AtomicLong read(final JsonReader jsonReader) {
        return new AtomicLong(((Number)this.val$longAdapter.read(jsonReader)).longValue());
    }
    
    public void write(final JsonWriter jsonWriter, final AtomicLong atomicLong) {
        this.val$longAdapter.write(jsonWriter, atomicLong.get());
    }
}
