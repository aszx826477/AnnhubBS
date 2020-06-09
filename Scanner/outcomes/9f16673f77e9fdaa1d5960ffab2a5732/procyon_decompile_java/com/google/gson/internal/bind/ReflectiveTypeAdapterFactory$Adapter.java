// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import java.util.Iterator;
import java.util.Collection;
import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.internal.ObjectConstructor;
import java.util.Map;
import com.google.gson.TypeAdapter;

public final class ReflectiveTypeAdapterFactory$Adapter extends TypeAdapter
{
    private final Map boundFields;
    private final ObjectConstructor constructor;
    
    ReflectiveTypeAdapterFactory$Adapter(final ObjectConstructor constructor, final Map boundFields) {
        this.constructor = constructor;
        this.boundFields = boundFields;
    }
    
    public Object read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        final Object construct = this.constructor.construct();
        try {
            jsonReader.beginObject();
            while (true) {
                Label_0110: {
                    if (!jsonReader.hasNext()) {
                        break Label_0110;
                    }
                    final String nextName = jsonReader.nextName();
                    try {
                        final Object value = this.boundFields.get(nextName);
                        try {
                            final ReflectiveTypeAdapterFactory$BoundField reflectiveTypeAdapterFactory$BoundField = (ReflectiveTypeAdapterFactory$BoundField)value;
                            if (reflectiveTypeAdapterFactory$BoundField != null && reflectiveTypeAdapterFactory$BoundField.deserialized) {
                                reflectiveTypeAdapterFactory$BoundField.read(jsonReader, construct);
                            }
                            else {
                                jsonReader.skipValue();
                            }
                            continue;
                            jsonReader.endObject();
                            return construct;
                        }
                        catch (IllegalAccessException ex) {
                            throw new AssertionError((Object)ex);
                        }
                        catch (IllegalStateException ex2) {
                            throw new JsonSyntaxException(ex2);
                        }
                    }
                    catch (IllegalAccessException ex3) {}
                    catch (IllegalStateException ex4) {}
                }
            }
        }
        catch (IllegalAccessException ex5) {}
        catch (IllegalStateException ex6) {}
    }
    
    public void write(final JsonWriter jsonWriter, final Object o) {
        if (o == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        try {
            final Map boundFields = this.boundFields;
            try {
                final Collection<ReflectiveTypeAdapterFactory$BoundField> values = boundFields.values();
                try {
                    final Iterator<ReflectiveTypeAdapterFactory$BoundField> iterator = values.iterator();
                    try {
                        while (true) {
                            Label_0102: {
                                if (!iterator.hasNext()) {
                                    break Label_0102;
                                }
                                final ReflectiveTypeAdapterFactory$BoundField next = iterator.next();
                                try {
                                    final ReflectiveTypeAdapterFactory$BoundField reflectiveTypeAdapterFactory$BoundField = next;
                                    if (!reflectiveTypeAdapterFactory$BoundField.writeField(o)) {
                                        continue;
                                    }
                                    jsonWriter.name(reflectiveTypeAdapterFactory$BoundField.name);
                                    reflectiveTypeAdapterFactory$BoundField.write(jsonWriter, o);
                                    continue;
                                    jsonWriter.endObject();
                                }
                                catch (IllegalAccessException ex) {
                                    throw new AssertionError((Object)ex);
                                }
                            }
                        }
                    }
                    catch (IllegalAccessException ex2) {}
                }
                catch (IllegalAccessException ex3) {}
            }
            catch (IllegalAccessException ex4) {}
        }
        catch (IllegalAccessException ex5) {}
    }
}
