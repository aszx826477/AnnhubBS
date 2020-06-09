// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import java.util.Iterator;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import java.util.Collection;
import com.google.gson.stream.JsonReader;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.TypeAdapter;

final class CollectionTypeAdapterFactory$Adapter extends TypeAdapter
{
    private final ObjectConstructor constructor;
    private final TypeAdapter elementTypeAdapter;
    
    public CollectionTypeAdapterFactory$Adapter(final Gson gson, final Type type, final TypeAdapter typeAdapter, final ObjectConstructor constructor) {
        this.elementTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
        this.constructor = constructor;
    }
    
    public Collection read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        final Collection collection = (Collection)this.constructor.construct();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            collection.add(this.elementTypeAdapter.read(jsonReader));
        }
        jsonReader.endArray();
        return collection;
    }
    
    public void write(final JsonWriter jsonWriter, final Collection collection) {
        if (collection == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.elementTypeAdapter.write(jsonWriter, iterator.next());
        }
        jsonWriter.endArray();
    }
}
