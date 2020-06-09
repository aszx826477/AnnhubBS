// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;

final class TypeAdapters$35 implements TypeAdapterFactory
{
    final /* synthetic */ Class val$clazz;
    final /* synthetic */ TypeAdapter val$typeAdapter;
    
    TypeAdapters$35(final Class val$clazz, final TypeAdapter val$typeAdapter) {
        this.val$clazz = val$clazz;
        this.val$typeAdapter = val$typeAdapter;
    }
    
    public TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        final Class rawType = typeToken.getRawType();
        if (!this.val$clazz.isAssignableFrom(rawType)) {
            return null;
        }
        return new TypeAdapters$35$1(this, rawType);
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Factory[typeHierarchy=");
        sb.append(this.val$clazz.getName());
        sb.append(",adapter=");
        sb.append(this.val$typeAdapter);
        sb.append("]");
        return sb.toString();
    }
}
