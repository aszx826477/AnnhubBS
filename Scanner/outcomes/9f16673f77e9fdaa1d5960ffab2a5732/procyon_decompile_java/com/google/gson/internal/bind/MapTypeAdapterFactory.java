// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.internal.$Gson$Types;
import java.util.Map;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.TypeAdapterFactory;

public final class MapTypeAdapterFactory implements TypeAdapterFactory
{
    final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;
    
    public MapTypeAdapterFactory(final ConstructorConstructor constructorConstructor, final boolean complexMapKeySerialization) {
        this.constructorConstructor = constructorConstructor;
        this.complexMapKeySerialization = complexMapKeySerialization;
    }
    
    private TypeAdapter getKeyAdapter(final Gson gson, final Type type) {
        TypeAdapter typeAdapter;
        if (type != Boolean.TYPE && type != Boolean.class) {
            typeAdapter = gson.getAdapter(TypeToken.get(type));
        }
        else {
            typeAdapter = TypeAdapters.BOOLEAN_AS_STRING;
        }
        return typeAdapter;
    }
    
    public TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        final Type type = typeToken.getType();
        if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        final Type[] mapKeyAndValueTypes = $Gson$Types.getMapKeyAndValueTypes(type, $Gson$Types.getRawType(type));
        final TypeAdapter keyAdapter = this.getKeyAdapter(gson, mapKeyAndValueTypes[0]);
        final int n = 1;
        return new MapTypeAdapterFactory$Adapter(this, gson, mapKeyAndValueTypes[0], keyAdapter, mapKeyAndValueTypes[n], gson.getAdapter(TypeToken.get(mapKeyAndValueTypes[n])), this.constructorConstructor.get(typeToken));
    }
}
