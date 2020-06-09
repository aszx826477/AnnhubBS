// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;

final class TypeAdapters$32 implements TypeAdapterFactory
{
    final /* synthetic */ Class val$type;
    final /* synthetic */ TypeAdapter val$typeAdapter;
    
    TypeAdapters$32(final Class val$type, final TypeAdapter val$typeAdapter) {
        this.val$type = val$type;
        this.val$typeAdapter = val$typeAdapter;
    }
    
    public TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        TypeAdapter val$typeAdapter;
        if (typeToken.getRawType() == this.val$type) {
            val$typeAdapter = this.val$typeAdapter;
        }
        else {
            val$typeAdapter = null;
        }
        return val$typeAdapter;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Factory[type=");
        sb.append(this.val$type.getName());
        sb.append(",adapter=");
        sb.append(this.val$typeAdapter);
        sb.append("]");
        return sb.toString();
    }
}
