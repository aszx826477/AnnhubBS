// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.TypeAdapter;

final class TypeAdapters$EnumTypeAdapter extends TypeAdapter
{
    private final Map constantToName;
    private final Map nameToConstant;
    
    public TypeAdapters$EnumTypeAdapter(final Class clazz) {
        this.nameToConstant = new HashMap();
        this.constantToName = new HashMap();
        try {
            final Enum[] enumConstants = clazz.getEnumConstants();
            try {
                final Enum[] array = enumConstants;
                try {
                    final int length = array.length;
                    int n = 0;
                Label_0172_Outer:
                    while (true) {
                        if (n >= length) {
                            return;
                        }
                        final Enum enum1 = array[n];
                        try {
                            String s = enum1.name();
                            final SerializedName annotation = clazz.getField(s).getAnnotation(SerializedName.class);
                            try {
                                final SerializedName serializedName = annotation;
                            Label_0172:
                                while (true) {
                                    if (serializedName == null) {
                                        break Label_0172;
                                    }
                                    s = serializedName.value();
                                    final String[] alternate = serializedName.alternate();
                                    try {
                                        final int length2 = alternate.length;
                                        int n2 = 0;
                                        while (true) {
                                            Label_0169: {
                                                if (n2 >= length2) {
                                                    break Label_0169;
                                                }
                                                final String s2 = alternate[n2];
                                                try {
                                                    this.nameToConstant.put(s2, enum1);
                                                    ++n2;
                                                    continue Label_0172_Outer;
                                                    this.nameToConstant.put(s, enum1);
                                                    this.constantToName.put(enum1, s);
                                                    ++n;
                                                    continue Label_0172_Outer;
                                                    continue Label_0172;
                                                }
                                                catch (NoSuchFieldException ex) {
                                                    throw new AssertionError((Object)ex);
                                                }
                                            }
                                        }
                                    }
                                    catch (NoSuchFieldException ex2) {}
                                    break;
                                }
                            }
                            catch (NoSuchFieldException ex3) {}
                        }
                        catch (NoSuchFieldException ex4) {}
                    }
                }
                catch (NoSuchFieldException ex5) {}
            }
            catch (NoSuchFieldException ex6) {}
        }
        catch (NoSuchFieldException ex7) {}
    }
    
    public Enum read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return this.nameToConstant.get(jsonReader.nextString());
    }
    
    public void write(final JsonWriter jsonWriter, final Enum enum1) {
        String s;
        if (enum1 == null) {
            s = null;
        }
        else {
            s = this.constantToName.get(enum1);
        }
        jsonWriter.value(s);
    }
}
