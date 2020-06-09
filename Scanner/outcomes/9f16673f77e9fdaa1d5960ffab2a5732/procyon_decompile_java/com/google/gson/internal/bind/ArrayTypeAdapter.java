// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.TypeAdapter;

public final class ArrayTypeAdapter extends TypeAdapter
{
    public static final TypeAdapterFactory FACTORY;
    private final Class componentType;
    private final TypeAdapter componentTypeAdapter;
    
    static {
        FACTORY = new ArrayTypeAdapter$1();
    }
    
    public ArrayTypeAdapter(final Gson gson, final TypeAdapter typeAdapter, final Class componentType) {
        this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, componentType);
        this.componentType = componentType;
    }
    
    public Object read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        final ArrayList<Object> list = new ArrayList<Object>();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            list.add(this.componentTypeAdapter.read(jsonReader));
        }
        jsonReader.endArray();
        final Object instance = Array.newInstance(this.componentType, list.size());
        for (int i = 0; i < list.size(); ++i) {
            Array.set(instance, i, list.get(i));
        }
        return instance;
    }
    
    public void write(final JsonWriter jsonWriter, final Object o) {
        if (o == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        for (int i = 0; i < Array.getLength(o); ++i) {
            this.componentTypeAdapter.write(jsonWriter, Array.get(o, i));
        }
        jsonWriter.endArray();
    }
}
