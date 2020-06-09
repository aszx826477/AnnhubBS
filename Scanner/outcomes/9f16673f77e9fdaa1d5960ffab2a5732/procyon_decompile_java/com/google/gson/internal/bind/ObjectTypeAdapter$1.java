// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.TypeAdapterFactory;

final class ObjectTypeAdapter$1 implements TypeAdapterFactory
{
    public TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        if (typeToken.getRawType() == Object.class) {
            return new ObjectTypeAdapter(gson);
        }
        return null;
    }
}
