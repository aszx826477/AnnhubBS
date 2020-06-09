// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;

class Gson$3 extends TypeAdapter
{
    final /* synthetic */ Gson this$0;
    
    Gson$3(final Gson this$0) {
        this.this$0 = this$0;
    }
    
    public Float read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return (float)jsonReader.nextDouble();
    }
    
    public void write(final JsonWriter jsonWriter, final Number n) {
        if (n == null) {
            jsonWriter.nullValue();
            return;
        }
        Gson.checkValidFloatingPoint(n.floatValue());
        jsonWriter.value(n);
    }
}
