// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import java.util.ArrayList;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.Gson;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.TypeAdapter;

public final class ObjectTypeAdapter extends TypeAdapter
{
    public static final TypeAdapterFactory FACTORY;
    private final Gson gson;
    
    static {
        FACTORY = new ObjectTypeAdapter$1();
    }
    
    ObjectTypeAdapter(final Gson gson) {
        this.gson = gson;
    }
    
    public Object read(final JsonReader jsonReader) {
        switch (ObjectTypeAdapter$2.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()]) {
            default: {
                throw new IllegalStateException();
            }
            case 6: {
                jsonReader.nextNull();
                return null;
            }
            case 5: {
                return jsonReader.nextBoolean();
            }
            case 4: {
                return jsonReader.nextDouble();
            }
            case 3: {
                return jsonReader.nextString();
            }
            case 2: {
                final LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    linkedTreeMap.put(jsonReader.nextName(), this.read(jsonReader));
                }
                jsonReader.endObject();
                return linkedTreeMap;
            }
            case 1: {
                final ArrayList<Object> list = new ArrayList<Object>();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    list.add(this.read(jsonReader));
                }
                jsonReader.endArray();
                return list;
            }
        }
    }
    
    public void write(final JsonWriter jsonWriter, final Object o) {
        if (o == null) {
            jsonWriter.nullValue();
            return;
        }
        final TypeAdapter adapter = this.gson.getAdapter(o.getClass());
        if (adapter instanceof ObjectTypeAdapter) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
            return;
        }
        adapter.write(jsonWriter, o);
    }
}
