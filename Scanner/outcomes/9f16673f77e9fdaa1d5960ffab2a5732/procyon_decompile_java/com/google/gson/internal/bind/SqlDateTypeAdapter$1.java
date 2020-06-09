// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import java.sql.Date;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.TypeAdapterFactory;

final class SqlDateTypeAdapter$1 implements TypeAdapterFactory
{
    public TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        TypeAdapter typeAdapter;
        if (typeToken.getRawType() == Date.class) {
            typeAdapter = new SqlDateTypeAdapter();
        }
        else {
            typeAdapter = null;
        }
        return typeAdapter;
    }
}
