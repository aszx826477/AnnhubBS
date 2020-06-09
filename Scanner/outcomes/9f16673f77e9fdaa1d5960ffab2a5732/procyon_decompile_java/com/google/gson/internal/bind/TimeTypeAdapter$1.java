// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import java.sql.Time;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.TypeAdapterFactory;

final class TimeTypeAdapter$1 implements TypeAdapterFactory
{
    public TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        TypeAdapter typeAdapter;
        if (typeToken.getRawType() == Time.class) {
            typeAdapter = new TimeTypeAdapter();
        }
        else {
            typeAdapter = null;
        }
        return typeAdapter;
    }
}
