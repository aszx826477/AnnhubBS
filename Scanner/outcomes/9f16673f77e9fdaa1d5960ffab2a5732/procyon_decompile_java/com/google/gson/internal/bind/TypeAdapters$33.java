// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;

final class TypeAdapters$33 implements TypeAdapterFactory
{
    final /* synthetic */ Class val$boxed;
    final /* synthetic */ TypeAdapter val$typeAdapter;
    final /* synthetic */ Class val$unboxed;
    
    TypeAdapters$33(final Class val$unboxed, final Class val$boxed, final TypeAdapter val$typeAdapter) {
        this.val$unboxed = val$unboxed;
        this.val$boxed = val$boxed;
        this.val$typeAdapter = val$typeAdapter;
    }
    
    public TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        final Class rawType = typeToken.getRawType();
        TypeAdapter val$typeAdapter;
        if (rawType != this.val$unboxed && rawType != this.val$boxed) {
            val$typeAdapter = null;
        }
        else {
            val$typeAdapter = this.val$typeAdapter;
        }
        return val$typeAdapter;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Factory[type=");
        sb.append(this.val$boxed.getName());
        sb.append("+");
        sb.append(this.val$unboxed.getName());
        sb.append(",adapter=");
        sb.append(this.val$typeAdapter);
        sb.append("]");
        return sb.toString();
    }
}
