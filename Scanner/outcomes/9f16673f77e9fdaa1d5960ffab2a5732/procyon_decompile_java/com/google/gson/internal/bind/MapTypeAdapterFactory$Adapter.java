// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import java.util.Iterator;
import com.google.gson.internal.Streams;
import java.util.ArrayList;
import com.google.gson.stream.JsonWriter;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.util.Map;
import com.google.gson.stream.JsonReader;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.TypeAdapter;

final class MapTypeAdapterFactory$Adapter extends TypeAdapter
{
    private final ObjectConstructor constructor;
    private final TypeAdapter keyTypeAdapter;
    final /* synthetic */ MapTypeAdapterFactory this$0;
    private final TypeAdapter valueTypeAdapter;
    
    public MapTypeAdapterFactory$Adapter(final MapTypeAdapterFactory this$0, final Gson gson, final Type type, final TypeAdapter typeAdapter, final Type type2, final TypeAdapter typeAdapter2, final ObjectConstructor constructor) {
        this.this$0 = this$0;
        this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
        this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
        this.constructor = constructor;
    }
    
    private String keyToString(final JsonElement jsonElement) {
        if (jsonElement.isJsonPrimitive()) {
            final JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (asJsonPrimitive.isNumber()) {
                return String.valueOf(asJsonPrimitive.getAsNumber());
            }
            if (asJsonPrimitive.isBoolean()) {
                return Boolean.toString(asJsonPrimitive.getAsBoolean());
            }
            if (asJsonPrimitive.isString()) {
                return asJsonPrimitive.getAsString();
            }
            throw new AssertionError();
        }
        else {
            if (jsonElement.isJsonNull()) {
                return "null";
            }
            throw new AssertionError();
        }
    }
    
    public Map read(final JsonReader jsonReader) {
        final JsonToken peek = jsonReader.peek();
        if (peek == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        final Map map = (Map)this.constructor.construct();
        if (peek == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                jsonReader.beginArray();
                final Object read = this.keyTypeAdapter.read(jsonReader);
                if (map.put(read, this.valueTypeAdapter.read(jsonReader)) != null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("duplicate key: ");
                    sb.append(read);
                    throw new JsonSyntaxException(sb.toString());
                }
                jsonReader.endArray();
            }
            jsonReader.endArray();
        }
        else {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonReader);
                final Object read2 = this.keyTypeAdapter.read(jsonReader);
                if (map.put(read2, this.valueTypeAdapter.read(jsonReader)) == null) {
                    continue;
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("duplicate key: ");
                sb2.append(read2);
                throw new JsonSyntaxException(sb2.toString());
            }
            jsonReader.endObject();
        }
        return map;
    }
    
    public void write(final JsonWriter jsonWriter, final Map map) {
        if (map == null) {
            jsonWriter.nullValue();
            return;
        }
        if (!this.this$0.complexMapKeySerialization) {
            jsonWriter.beginObject();
            for (final Map.Entry<Object, V> entry : map.entrySet()) {
                jsonWriter.name(String.valueOf(entry.getKey()));
                this.valueTypeAdapter.write(jsonWriter, entry.getValue());
            }
            jsonWriter.endObject();
            return;
        }
        boolean b = false;
        final ArrayList<JsonElement> list = new ArrayList<JsonElement>(map.size());
        final ArrayList<Object> list2 = new ArrayList<Object>(map.size());
        for (final Map.Entry<Object, V> entry2 : map.entrySet()) {
            final JsonElement jsonTree = this.keyTypeAdapter.toJsonTree(entry2.getKey());
            list.add(jsonTree);
            list2.add(entry2.getValue());
            b |= (jsonTree.isJsonArray() || jsonTree.isJsonObject());
        }
        if (b) {
            jsonWriter.beginArray();
            for (int i = 0; i < list.size(); ++i) {
                jsonWriter.beginArray();
                Streams.write((JsonElement)list.get(i), jsonWriter);
                this.valueTypeAdapter.write(jsonWriter, list2.get(i));
                jsonWriter.endArray();
            }
            jsonWriter.endArray();
        }
        else {
            jsonWriter.beginObject();
            for (int j = 0; j < list.size(); ++j) {
                jsonWriter.name(this.keyToString((JsonElement)list.get(j)));
                this.valueTypeAdapter.write(jsonWriter, list2.get(j));
            }
            jsonWriter.endObject();
        }
    }
}
