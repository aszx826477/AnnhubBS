// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.JsonSerializer;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.TypeAdapter;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;

final class TreeTypeAdapter$GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext
{
    final /* synthetic */ TreeTypeAdapter this$0;
    
    private TreeTypeAdapter$GsonContextImpl(final TreeTypeAdapter this$0) {
        this.this$0 = this$0;
    }
    
    public Object deserialize(final JsonElement jsonElement, final Type type) {
        return this.this$0.gson.fromJson(jsonElement, type);
    }
    
    public JsonElement serialize(final Object o) {
        return this.this$0.gson.toJsonTree(o);
    }
    
    public JsonElement serialize(final Object o, final Type type) {
        return this.this$0.gson.toJsonTree(o, type);
    }
}
