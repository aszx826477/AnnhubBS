// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.TypeAdapterFactory;

public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory
{
    private final ConstructorConstructor constructorConstructor;
    
    public JsonAdapterAnnotationTypeAdapterFactory(final ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }
    
    public TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        final JsonAdapter jsonAdapter = typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return this.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
    }
    
    TypeAdapter getTypeAdapter(final ConstructorConstructor constructorConstructor, final Gson gson, final TypeToken typeToken, final JsonAdapter jsonAdapter) {
        final Object construct = constructorConstructor.get(TypeToken.get(jsonAdapter.value())).construct();
        TypeAdapter typeAdapter;
        if (construct instanceof TypeAdapter) {
            typeAdapter = (TypeAdapter)construct;
        }
        else if (construct instanceof TypeAdapterFactory) {
            typeAdapter = ((TypeAdapterFactory)construct).create(gson, typeToken);
        }
        else {
            if (!(construct instanceof JsonSerializer) && !(construct instanceof JsonDeserializer)) {
                throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
            }
            final boolean b = construct instanceof JsonSerializer;
            JsonDeserializer jsonDeserializer = null;
            JsonSerializer jsonSerializer;
            if (b) {
                jsonSerializer = (JsonSerializer)construct;
            }
            else {
                jsonSerializer = null;
            }
            if (construct instanceof JsonDeserializer) {
                jsonDeserializer = (JsonDeserializer)construct;
            }
            typeAdapter = new TreeTypeAdapter(jsonSerializer, jsonDeserializer, gson, typeToken, null);
        }
        if (typeAdapter != null) {
            typeAdapter = typeAdapter.nullSafe();
        }
        return typeAdapter;
    }
}
