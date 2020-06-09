// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import com.google.gson.Gson;

class ReflectiveTypeAdapterFactory$1 extends ReflectiveTypeAdapterFactory$BoundField
{
    final /* synthetic */ ReflectiveTypeAdapterFactory this$0;
    final /* synthetic */ Gson val$context;
    final /* synthetic */ Field val$field;
    final /* synthetic */ TypeToken val$fieldType;
    final /* synthetic */ boolean val$isPrimitive;
    final /* synthetic */ boolean val$jsonAdapterPresent;
    final /* synthetic */ TypeAdapter val$typeAdapter;
    
    ReflectiveTypeAdapterFactory$1(final ReflectiveTypeAdapterFactory this$0, final String s, final boolean b, final boolean b2, final Field val$field, final boolean val$jsonAdapterPresent, final TypeAdapter val$typeAdapter, final Gson val$context, final TypeToken val$fieldType, final boolean val$isPrimitive) {
        this.this$0 = this$0;
        this.val$field = val$field;
        this.val$jsonAdapterPresent = val$jsonAdapterPresent;
        this.val$typeAdapter = val$typeAdapter;
        this.val$context = val$context;
        this.val$fieldType = val$fieldType;
        this.val$isPrimitive = val$isPrimitive;
        super(s, b, b2);
    }
    
    void read(final JsonReader jsonReader, final Object o) {
        final Object read = this.val$typeAdapter.read(jsonReader);
        if (read != null || this.val$isPrimitive) {
            this.val$field.set(o, read);
        }
    }
    
    void write(final JsonWriter jsonWriter, final Object o) {
        final Object value = this.val$field.get(o);
        TypeAdapter val$typeAdapter;
        if (this.val$jsonAdapterPresent) {
            val$typeAdapter = this.val$typeAdapter;
        }
        else {
            val$typeAdapter = new TypeAdapterRuntimeTypeWrapper(this.val$context, this.val$typeAdapter, this.val$fieldType.getType());
        }
        val$typeAdapter.write(jsonWriter, value);
    }
    
    public boolean writeField(final Object o) {
        final boolean serialized = this.serialized;
        boolean b = false;
        if (!serialized) {
            return false;
        }
        if (this.val$field.get(o) != o) {
            b = true;
        }
        return b;
    }
}
