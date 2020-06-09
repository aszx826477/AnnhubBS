// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import java.lang.reflect.Type;
import com.google.gson.internal.$Gson$Types;
import java.util.Collection;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.TypeAdapterFactory;

public final class CollectionTypeAdapterFactory implements TypeAdapterFactory
{
    private final ConstructorConstructor constructorConstructor;
    
    public CollectionTypeAdapterFactory(final ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }
    
    public TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        final Type type = typeToken.getType();
        final Class rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        final Type collectionElementType = $Gson$Types.getCollectionElementType(type, rawType);
        return new CollectionTypeAdapterFactory$Adapter(gson, collectionElementType, gson.getAdapter(TypeToken.get(collectionElementType)), this.constructorConstructor.get(typeToken));
    }
}
