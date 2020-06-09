// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.TypeAdapterFactory;

final class TypeAdapters$30 implements TypeAdapterFactory
{
    public TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        Class<? super Enum> clazz = (Class<? super Enum>)typeToken.getRawType();
        if (Enum.class.isAssignableFrom(clazz) && clazz != Enum.class) {
            if (!clazz.isEnum()) {
                clazz = clazz.getSuperclass();
            }
            return new TypeAdapters$EnumTypeAdapter(clazz);
        }
        return null;
    }
}
