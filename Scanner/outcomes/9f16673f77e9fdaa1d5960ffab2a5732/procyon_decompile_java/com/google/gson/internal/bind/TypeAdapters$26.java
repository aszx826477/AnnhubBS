// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import java.util.Date;
import java.sql.Timestamp;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.TypeAdapterFactory;

final class TypeAdapters$26 implements TypeAdapterFactory
{
    public TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        if (typeToken.getRawType() != Timestamp.class) {
            return null;
        }
        return new TypeAdapters$26$1(this, gson.getAdapter(Date.class));
    }
}
