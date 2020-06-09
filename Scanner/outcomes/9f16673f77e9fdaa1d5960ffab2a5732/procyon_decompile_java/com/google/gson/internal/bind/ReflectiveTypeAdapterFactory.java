// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import java.util.ArrayList;
import java.util.Collections;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import com.google.gson.internal.$Gson$Types;
import java.util.LinkedHashMap;
import java.util.Map;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Type;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import com.google.gson.Gson;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.TypeAdapterFactory;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory
{
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    
    public ReflectiveTypeAdapterFactory(final ConstructorConstructor constructorConstructor, final FieldNamingStrategy fieldNamingPolicy, final Excluder excluder, final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingPolicy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterFactory;
    }
    
    private ReflectiveTypeAdapterFactory$BoundField createBoundField(final Gson gson, final Field field, final String s, final TypeToken typeToken, final boolean b, final boolean b2) {
        final boolean primitive = Primitives.isPrimitive(typeToken.getRawType());
        final JsonAdapter jsonAdapter = field.getAnnotation(JsonAdapter.class);
        TypeAdapter typeAdapter = null;
        if (jsonAdapter != null) {
            typeAdapter = this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
        }
        final boolean b3 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(typeToken);
        }
        return new ReflectiveTypeAdapterFactory$1(this, s, b, b2, field, b3, typeAdapter, gson, typeToken, primitive);
    }
    
    static boolean excludeField(final Field field, final boolean b, final Excluder excluder) {
        return !excluder.excludeClass(field.getType(), b) && !excluder.excludeField(field, b);
    }
    
    private Map getBoundFields(final Gson gson, final TypeToken typeToken, final Class clazz) {
        final LinkedHashMap<String, ReflectiveTypeAdapterFactory$BoundField> linkedHashMap2;
        final LinkedHashMap<String, ReflectiveTypeAdapterFactory$BoundField> linkedHashMap = linkedHashMap2 = new LinkedHashMap<String, ReflectiveTypeAdapterFactory$BoundField>();
        if (clazz.isInterface()) {
            return linkedHashMap;
        }
        final Type type = typeToken.getType();
        TypeToken value = typeToken;
        for (Class<Object> rawType = (Class<Object>)clazz; rawType != Object.class; rawType = (Class<Object>)value.getRawType()) {
            final Field[] declaredFields = rawType.getDeclaredFields();
            for (int length = declaredFields.length, i = 0; i < length; ++i) {
                Field field = declaredFields[i];
                final boolean accessible = true;
                boolean excludeField = this.excludeField(field, accessible);
                final boolean excludeField2 = this.excludeField(field, false);
                if (excludeField || excludeField2) {
                    field.setAccessible(accessible);
                    final Type resolve = $Gson$Types.resolve(value.getType(), rawType, field.getGenericType());
                    List<String> fieldNames = (List<String>)this.getFieldNames(field);
                    ReflectiveTypeAdapterFactory$BoundField reflectiveTypeAdapterFactory$BoundField = null;
                    boolean b;
                    int n;
                    List<String> list;
                    Field field2;
                    for (int j = 0; j < fieldNames.size(); j = n + 1, excludeField = b, fieldNames = list, field = field2) {
                        final String s = fieldNames.get(j);
                        b = (j == 0 && excludeField);
                        final TypeToken value2 = TypeToken.get(resolve);
                        final String s2 = s;
                        final ReflectiveTypeAdapterFactory$BoundField reflectiveTypeAdapterFactory$BoundField2 = reflectiveTypeAdapterFactory$BoundField;
                        n = j;
                        final TypeToken typeToken2 = value2;
                        list = fieldNames;
                        field2 = field;
                        final ReflectiveTypeAdapterFactory$BoundField reflectiveTypeAdapterFactory$BoundField3 = linkedHashMap2.put(s2, this.createBoundField(gson, field, s2, typeToken2, b, excludeField2));
                        if (reflectiveTypeAdapterFactory$BoundField2 == null) {
                            reflectiveTypeAdapterFactory$BoundField = reflectiveTypeAdapterFactory$BoundField3;
                        }
                        else {
                            reflectiveTypeAdapterFactory$BoundField = reflectiveTypeAdapterFactory$BoundField2;
                        }
                    }
                    if (reflectiveTypeAdapterFactory$BoundField != null) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append(type);
                        sb.append(" declares multiple JSON fields named ");
                        sb.append(reflectiveTypeAdapterFactory$BoundField.name);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
            value = TypeToken.get($Gson$Types.resolve(value.getType(), rawType, rawType.getGenericSuperclass()));
        }
        return linkedHashMap2;
    }
    
    private List getFieldNames(final Field field) {
        final SerializedName serializedName = field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        final String value = serializedName.value();
        final String[] alternate = serializedName.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        final ArrayList list = new ArrayList<String>(alternate.length + 1);
        list.add(value);
        for (int length = alternate.length, i = 0; i < length; ++i) {
            list.add(alternate[i]);
        }
        return list;
    }
    
    public TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        final Class rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        return new ReflectiveTypeAdapterFactory$Adapter(this.constructorConstructor.get(typeToken), this.getBoundFields(gson, typeToken, rawType));
    }
    
    public boolean excludeField(final Field field, final boolean b) {
        return excludeField(field, b, this.excluder);
    }
}
