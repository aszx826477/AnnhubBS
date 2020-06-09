// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonReader;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

final class TypeAdapterRuntimeTypeWrapper extends TypeAdapter
{
    private final Gson context;
    private final TypeAdapter delegate;
    private final Type type;
    
    TypeAdapterRuntimeTypeWrapper(final Gson context, final TypeAdapter delegate, final Type type) {
        this.context = context;
        this.delegate = delegate;
        this.type = type;
    }
    
    private Type getRuntimeTypeIfMoreSpecific(Type class1, final Object o) {
        if (o != null && (class1 == Object.class || class1 instanceof TypeVariable || class1 instanceof Class)) {
            class1 = o.getClass();
        }
        return class1;
    }
    
    public Object read(final JsonReader jsonReader) {
        return this.delegate.read(jsonReader);
    }
    
    public void write(final JsonWriter jsonWriter, final Object o) {
        TypeAdapter typeAdapter = this.delegate;
        final Type runtimeTypeIfMoreSpecific = this.getRuntimeTypeIfMoreSpecific(this.type, o);
        if (runtimeTypeIfMoreSpecific != this.type) {
            final TypeAdapter adapter = this.context.getAdapter(TypeToken.get(runtimeTypeIfMoreSpecific));
            if (!(adapter instanceof ReflectiveTypeAdapterFactory$Adapter)) {
                typeAdapter = adapter;
            }
            else if (!(this.delegate instanceof ReflectiveTypeAdapterFactory$Adapter)) {
                typeAdapter = this.delegate;
            }
            else {
                typeAdapter = adapter;
            }
        }
        typeAdapter.write(jsonWriter, o);
    }
}
