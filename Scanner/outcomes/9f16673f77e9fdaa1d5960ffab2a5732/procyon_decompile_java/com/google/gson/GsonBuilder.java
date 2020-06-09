// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.$Gson$Preconditions;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Collection;
import java.sql.Timestamp;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import com.google.gson.internal.Excluder;

public final class GsonBuilder
{
    private boolean complexMapKeySerialization;
    private String datePattern;
    private int dateStyle;
    private boolean escapeHtmlChars;
    private Excluder excluder;
    private final List factories;
    private FieldNamingStrategy fieldNamingPolicy;
    private boolean generateNonExecutableJson;
    private final List hierarchyFactories;
    private final Map instanceCreators;
    private boolean lenient;
    private LongSerializationPolicy longSerializationPolicy;
    private boolean prettyPrinting;
    private boolean serializeNulls;
    private boolean serializeSpecialFloatingPointValues;
    private int timeStyle;
    
    public GsonBuilder() {
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        this.instanceCreators = new HashMap();
        this.factories = new ArrayList();
        this.hierarchyFactories = new ArrayList();
        this.serializeNulls = false;
        final int n = 2;
        this.dateStyle = n;
        this.timeStyle = n;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
    }
    
    private void addTypeAdaptersForDate(final String s, final int n, final int n2, final List list) {
        DefaultDateTypeAdapter defaultDateTypeAdapter;
        if (s != null && !"".equals(s.trim())) {
            defaultDateTypeAdapter = new DefaultDateTypeAdapter(s);
        }
        else {
            final int n3 = 2;
            if (n == n3 || n2 == n3) {
                return;
            }
            defaultDateTypeAdapter = new DefaultDateTypeAdapter(n, n2);
        }
        list.add(TreeTypeAdapter.newFactory(TypeToken.get(Date.class), defaultDateTypeAdapter));
        list.add(TreeTypeAdapter.newFactory(TypeToken.get(Timestamp.class), defaultDateTypeAdapter));
        list.add(TreeTypeAdapter.newFactory(TypeToken.get(java.sql.Date.class), defaultDateTypeAdapter));
    }
    
    public GsonBuilder addDeserializationExclusionStrategy(final ExclusionStrategy exclusionStrategy) {
        this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, false, true);
        return this;
    }
    
    public GsonBuilder addSerializationExclusionStrategy(final ExclusionStrategy exclusionStrategy) {
        this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, true, false);
        return this;
    }
    
    public Gson create() {
        final ArrayList list = new ArrayList();
        list.addAll(this.factories);
        Collections.reverse(list);
        list.addAll(this.hierarchyFactories);
        this.addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, list);
        return new Gson(this.excluder, this.fieldNamingPolicy, this.instanceCreators, this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.lenient, this.serializeSpecialFloatingPointValues, this.longSerializationPolicy, list);
    }
    
    public GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }
    
    public GsonBuilder disableInnerClassSerialization() {
        this.excluder = this.excluder.disableInnerClassSerialization();
        return this;
    }
    
    public GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }
    
    public GsonBuilder excludeFieldsWithModifiers(final int... array) {
        this.excluder = this.excluder.withModifiers(array);
        return this;
    }
    
    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }
    
    public GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }
    
    public GsonBuilder registerTypeAdapter(final Type type, final Object o) {
        $Gson$Preconditions.checkArgument(o instanceof JsonSerializer || o instanceof JsonDeserializer || o instanceof InstanceCreator || o instanceof TypeAdapter);
        if (o instanceof InstanceCreator) {
            this.instanceCreators.put(type, o);
        }
        if (o instanceof JsonSerializer || o instanceof JsonDeserializer) {
            this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(TypeToken.get(type), o));
        }
        if (o instanceof TypeAdapter) {
            this.factories.add(TypeAdapters.newFactory(TypeToken.get(type), (TypeAdapter)o));
        }
        return this;
    }
    
    public GsonBuilder registerTypeAdapterFactory(final TypeAdapterFactory typeAdapterFactory) {
        this.factories.add(typeAdapterFactory);
        return this;
    }
    
    public GsonBuilder registerTypeHierarchyAdapter(final Class clazz, final Object o) {
        $Gson$Preconditions.checkArgument(o instanceof JsonSerializer || o instanceof JsonDeserializer || o instanceof TypeAdapter);
        if (o instanceof JsonDeserializer || o instanceof JsonSerializer) {
            this.hierarchyFactories.add(0, TreeTypeAdapter.newTypeHierarchyFactory(clazz, o));
        }
        if (o instanceof TypeAdapter) {
            this.factories.add(TypeAdapters.newTypeHierarchyFactory(clazz, (TypeAdapter)o));
        }
        return this;
    }
    
    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }
    
    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }
    
    public GsonBuilder setDateFormat(final int dateStyle) {
        this.dateStyle = dateStyle;
        this.datePattern = null;
        return this;
    }
    
    public GsonBuilder setDateFormat(final int dateStyle, final int timeStyle) {
        this.dateStyle = dateStyle;
        this.timeStyle = timeStyle;
        this.datePattern = null;
        return this;
    }
    
    public GsonBuilder setDateFormat(final String datePattern) {
        this.datePattern = datePattern;
        return this;
    }
    
    public GsonBuilder setExclusionStrategies(final ExclusionStrategy... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            final ExclusionStrategy exclusionStrategy = array[i];
            final Excluder excluder = this.excluder;
            final boolean b = true;
            this.excluder = excluder.withExclusionStrategy(exclusionStrategy, b, b);
        }
        return this;
    }
    
    public GsonBuilder setFieldNamingPolicy(final FieldNamingPolicy fieldNamingPolicy) {
        this.fieldNamingPolicy = fieldNamingPolicy;
        return this;
    }
    
    public GsonBuilder setFieldNamingStrategy(final FieldNamingStrategy fieldNamingPolicy) {
        this.fieldNamingPolicy = fieldNamingPolicy;
        return this;
    }
    
    public GsonBuilder setLenient() {
        this.lenient = true;
        return this;
    }
    
    public GsonBuilder setLongSerializationPolicy(final LongSerializationPolicy longSerializationPolicy) {
        this.longSerializationPolicy = longSerializationPolicy;
        return this;
    }
    
    public GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }
    
    public GsonBuilder setVersion(final double n) {
        this.excluder = this.excluder.withVersion(n);
        return this;
    }
}
