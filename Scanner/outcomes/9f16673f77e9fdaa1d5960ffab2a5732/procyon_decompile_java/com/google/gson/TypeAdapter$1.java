// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;

class TypeAdapter$1 extends TypeAdapter
{
    final /* synthetic */ TypeAdapter this$0;
    
    TypeAdapter$1(final TypeAdapter this$0) {
        this.this$0 = this$0;
    }
    
    public Object read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return this.this$0.read(jsonReader);
    }
    
    public void write(final JsonWriter jsonWriter, final Object o) {
        if (o == null) {
            jsonWriter.nullValue();
        }
        else {
            this.this$0.write(jsonWriter, o);
        }
    }
}
