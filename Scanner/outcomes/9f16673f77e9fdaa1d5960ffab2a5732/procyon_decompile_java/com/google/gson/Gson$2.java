// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;

class Gson$2 extends TypeAdapter
{
    final /* synthetic */ Gson this$0;
    
    Gson$2(final Gson this$0) {
        this.this$0 = this$0;
    }
    
    public Double read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return jsonReader.nextDouble();
    }
    
    public void write(final JsonWriter jsonWriter, final Number n) {
        if (n == null) {
            jsonWriter.nullValue();
            return;
        }
        Gson.checkValidFloatingPoint(n.doubleValue());
        jsonWriter.value(n);
    }
}
