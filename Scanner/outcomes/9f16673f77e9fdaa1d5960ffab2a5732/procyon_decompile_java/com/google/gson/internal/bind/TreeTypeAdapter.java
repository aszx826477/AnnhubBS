// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.JsonSerializationContext;
import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.JsonSerializer;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.TypeAdapter;

public final class TreeTypeAdapter extends TypeAdapter
{
    private final TreeTypeAdapter$GsonContextImpl context;
    private TypeAdapter delegate;
    private final JsonDeserializer deserializer;
    private final Gson gson;
    private final JsonSerializer serializer;
    private final TypeAdapterFactory skipPast;
    private final TypeToken typeToken;
    
    public TreeTypeAdapter(final JsonSerializer serializer, final JsonDeserializer deserializer, final Gson gson, final TypeToken typeToken, final TypeAdapterFactory skipPast) {
        this.context = new TreeTypeAdapter$GsonContextImpl(this, null);
        this.serializer = serializer;
        this.deserializer = deserializer;
        this.gson = gson;
        this.typeToken = typeToken;
        this.skipPast = skipPast;
    }
    
    private TypeAdapter delegate() {
        final TypeAdapter delegate = this.delegate;
        TypeAdapter delegateAdapter;
        if (delegate != null) {
            delegateAdapter = delegate;
        }
        else {
            delegateAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
            this.delegate = delegateAdapter;
        }
        return delegateAdapter;
    }
    
    public static TypeAdapterFactory newFactory(final TypeToken typeToken, final Object o) {
        return new TreeTypeAdapter$SingleTypeFactory(o, typeToken, false, null);
    }
    
    public static TypeAdapterFactory newFactoryWithMatchRawType(final TypeToken typeToken, final Object o) {
        return new TreeTypeAdapter$SingleTypeFactory(o, typeToken, typeToken.getType() == typeToken.getRawType(), null);
    }
    
    public static TypeAdapterFactory newTypeHierarchyFactory(final Class clazz, final Object o) {
        return new TreeTypeAdapter$SingleTypeFactory(o, null, false, clazz);
    }
    
    public Object read(final JsonReader jsonReader) {
        if (this.deserializer == null) {
            return this.delegate().read(jsonReader);
        }
        final JsonElement parse = Streams.parse(jsonReader);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.deserializer.deserialize(parse, this.typeToken.getType(), this.context);
    }
    
    public void write(final JsonWriter jsonWriter, final Object o) {
        final JsonSerializer serializer = this.serializer;
        if (serializer == null) {
            this.delegate().write(jsonWriter, o);
            return;
        }
        if (o == null) {
            jsonWriter.nullValue();
            return;
        }
        Streams.write(serializer.serialize(o, this.typeToken.getType(), this.context), jsonWriter);
    }
}
