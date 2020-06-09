// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;

final class TypeAdapters$34 implements TypeAdapterFactory
{
    final /* synthetic */ Class val$base;
    final /* synthetic */ Class val$sub;
    final /* synthetic */ TypeAdapter val$typeAdapter;
    
    TypeAdapters$34(final Class val$base, final Class val$sub, final TypeAdapter val$typeAdapter) {
        this.val$base = val$base;
        this.val$sub = val$sub;
        this.val$typeAdapter = val$typeAdapter;
    }
    
    public TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        final Class rawType = typeToken.getRawType();
        TypeAdapter val$typeAdapter;
        if (rawType != this.val$base && rawType != this.val$sub) {
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
        sb.append(this.val$base.getName());
        sb.append("+");
        sb.append(this.val$sub.getName());
        sb.append(",adapter=");
        sb.append(this.val$typeAdapter);
        sb.append("]");
        return sb.toString();
    }
}
