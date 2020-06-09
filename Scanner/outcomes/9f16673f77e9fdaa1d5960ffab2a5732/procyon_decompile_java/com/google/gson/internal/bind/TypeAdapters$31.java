// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapterFactory;

final class TypeAdapters$31 implements TypeAdapterFactory
{
    final /* synthetic */ TypeToken val$type;
    final /* synthetic */ TypeAdapter val$typeAdapter;
    
    TypeAdapters$31(final TypeToken val$type, final TypeAdapter val$typeAdapter) {
        this.val$type = val$type;
        this.val$typeAdapter = val$typeAdapter;
    }
    
    public TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        TypeAdapter val$typeAdapter;
        if (typeToken.equals(this.val$type)) {
            val$typeAdapter = this.val$typeAdapter;
        }
        else {
            val$typeAdapter = null;
        }
        return val$typeAdapter;
    }
}
