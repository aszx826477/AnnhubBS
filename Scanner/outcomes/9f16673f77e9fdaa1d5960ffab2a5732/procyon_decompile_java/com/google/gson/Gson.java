// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.Streams;
import java.io.StringWriter;
import com.google.gson.stream.JsonWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.HashMap;
import java.io.StringReader;
import java.io.Reader;
import java.io.EOFException;
import com.google.gson.internal.bind.JsonTreeReader;
import java.lang.reflect.Type;
import com.google.gson.internal.Primitives;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.DateTypeAdapter;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Collection;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Map;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import java.util.List;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

public final class Gson
{
    static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final boolean DEFAULT_ESCAPE_HTML = true;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final boolean DEFAULT_LENIENT = false;
    static final boolean DEFAULT_PRETTY_PRINT = false;
    static final boolean DEFAULT_SERIALIZE_NULLS = false;
    static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private static final TypeToken NULL_KEY_SURROGATE;
    private final ThreadLocal calls;
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final List factories;
    private final FieldNamingStrategy fieldNamingStrategy;
    private final boolean generateNonExecutableJson;
    private final boolean htmlSafe;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    private final boolean lenient;
    private final boolean prettyPrinting;
    private final boolean serializeNulls;
    private final Map typeTokenCache;
    
    static {
        NULL_KEY_SURROGATE = new Gson$1();
    }
    
    public Gson() {
        this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }
    
    Gson(final Excluder excluder, final FieldNamingStrategy fieldNamingStrategy, final Map map, final boolean serializeNulls, final boolean b, final boolean generateNonExecutableJson, final boolean htmlSafe, final boolean prettyPrinting, final boolean lenient, final boolean b2, final LongSerializationPolicy longSerializationPolicy, final List list) {
        this.calls = new ThreadLocal();
        this.typeTokenCache = new ConcurrentHashMap();
        this.constructorConstructor = new ConstructorConstructor(map);
        this.excluder = excluder;
        this.fieldNamingStrategy = fieldNamingStrategy;
        this.serializeNulls = serializeNulls;
        this.generateNonExecutableJson = generateNonExecutableJson;
        this.htmlSafe = htmlSafe;
        this.prettyPrinting = prettyPrinting;
        this.lenient = lenient;
        final ArrayList<CollectionTypeAdapterFactory> list2 = new ArrayList<CollectionTypeAdapterFactory>();
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.JSON_ELEMENT_FACTORY);
        list2.add((CollectionTypeAdapterFactory)ObjectTypeAdapter.FACTORY);
        list2.add((CollectionTypeAdapterFactory)excluder);
        list2.addAll((Collection<?>)list);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.STRING_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.INTEGER_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.BOOLEAN_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.BYTE_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.SHORT_FACTORY);
        final TypeAdapter longAdapter = longAdapter(longSerializationPolicy);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.newFactory(Long.TYPE, Long.class, longAdapter));
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.newFactory(Double.TYPE, Double.class, this.doubleAdapter(b2)));
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.newFactory(Float.TYPE, Float.class, this.floatAdapter(b2)));
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.NUMBER_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.ATOMIC_INTEGER_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(longAdapter)));
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(longAdapter)));
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.CHARACTER_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.STRING_BUILDER_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.STRING_BUFFER_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.URL_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.URI_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.UUID_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.CURRENCY_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.LOCALE_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.INET_ADDRESS_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.BIT_SET_FACTORY);
        list2.add((CollectionTypeAdapterFactory)DateTypeAdapter.FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.CALENDAR_FACTORY);
        list2.add((CollectionTypeAdapterFactory)TimeTypeAdapter.FACTORY);
        list2.add((CollectionTypeAdapterFactory)SqlDateTypeAdapter.FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.TIMESTAMP_FACTORY);
        list2.add((CollectionTypeAdapterFactory)ArrayTypeAdapter.FACTORY);
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.CLASS_FACTORY);
        list2.add(new CollectionTypeAdapterFactory(this.constructorConstructor));
        list2.add(new MapTypeAdapterFactory(this.constructorConstructor, b));
        list2.add(this.jsonAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(this.constructorConstructor));
        list2.add((CollectionTypeAdapterFactory)TypeAdapters.ENUM_FACTORY);
        list2.add(new ReflectiveTypeAdapterFactory(this.constructorConstructor, fieldNamingStrategy, excluder, this.jsonAdapterFactory));
        this.factories = Collections.unmodifiableList((List<?>)list2);
    }
    
    private static void assertFullConsumption(final Object o, final JsonReader jsonReader) {
        if (o != null) {
            try {
                final JsonToken peek = jsonReader.peek();
                try {
                    if (peek == JsonToken.END_DOCUMENT) {
                        return;
                    }
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
                catch (IOException ex) {
                    throw new JsonIOException(ex);
                }
                catch (MalformedJsonException ex2) {
                    throw new JsonSyntaxException(ex2);
                }
            }
            catch (IOException ex3) {}
            catch (MalformedJsonException ex4) {}
        }
    }
    
    private static TypeAdapter atomicLongAdapter(final TypeAdapter typeAdapter) {
        return new Gson$5(typeAdapter).nullSafe();
    }
    
    private static TypeAdapter atomicLongArrayAdapter(final TypeAdapter typeAdapter) {
        return new Gson$6(typeAdapter).nullSafe();
    }
    
    static void checkValidFloatingPoint(final double n) {
        if (!Double.isNaN(n) && !Double.isInfinite(n)) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.append(" is not a valid double value as per JSON specification. To override this");
        sb.append(" behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        throw new IllegalArgumentException(sb.toString());
    }
    
    private TypeAdapter doubleAdapter(final boolean b) {
        if (b) {
            return TypeAdapters.DOUBLE;
        }
        return new Gson$2(this);
    }
    
    private TypeAdapter floatAdapter(final boolean b) {
        if (b) {
            return TypeAdapters.FLOAT;
        }
        return new Gson$3(this);
    }
    
    private static TypeAdapter longAdapter(final LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            return TypeAdapters.LONG;
        }
        return new Gson$4();
    }
    
    public Excluder excluder() {
        return this.excluder;
    }
    
    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }
    
    public Object fromJson(final JsonElement jsonElement, final Class clazz) {
        return Primitives.wrap(clazz).cast(this.fromJson(jsonElement, (Type)clazz));
    }
    
    public Object fromJson(final JsonElement jsonElement, final Type type) {
        if (jsonElement == null) {
            return null;
        }
        return this.fromJson(new JsonTreeReader(jsonElement), type);
    }
    
    public Object fromJson(final JsonReader jsonReader, final Type type) {
        boolean b = true;
        final boolean lenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            try {
                jsonReader.peek();
                b = false;
                final Object read = this.getAdapter(TypeToken.get(type)).read(jsonReader);
                jsonReader.setLenient(lenient);
                return read;
            }
            finally {}
        }
        catch (IOException ex) {
            throw new JsonSyntaxException(ex);
        }
        catch (IllegalStateException ex2) {
            throw new JsonSyntaxException(ex2);
        }
        catch (EOFException ex3) {
            if (b) {
                jsonReader.setLenient(lenient);
                return null;
            }
            throw new JsonSyntaxException(ex3);
        }
        jsonReader.setLenient(lenient);
    }
    
    public Object fromJson(final Reader reader, final Class clazz) {
        final JsonReader jsonReader = this.newJsonReader(reader);
        final Object fromJson = this.fromJson(jsonReader, clazz);
        assertFullConsumption(fromJson, jsonReader);
        return Primitives.wrap(clazz).cast(fromJson);
    }
    
    public Object fromJson(final Reader reader, final Type type) {
        final JsonReader jsonReader = this.newJsonReader(reader);
        final Object fromJson = this.fromJson(jsonReader, type);
        assertFullConsumption(fromJson, jsonReader);
        return fromJson;
    }
    
    public Object fromJson(final String s, final Class clazz) {
        return Primitives.wrap(clazz).cast(this.fromJson(s, (Type)clazz));
    }
    
    public Object fromJson(final String s, final Type type) {
        if (s == null) {
            return null;
        }
        return this.fromJson(new StringReader(s), type);
    }
    
    public TypeAdapter getAdapter(final TypeToken typeToken) {
        final Map typeTokenCache = this.typeTokenCache;
        TypeToken null_KEY_SURROGATE;
        if (typeToken == null) {
            null_KEY_SURROGATE = Gson.NULL_KEY_SURROGATE;
        }
        else {
            null_KEY_SURROGATE = typeToken;
        }
        final TypeAdapter typeAdapter = typeTokenCache.get(null_KEY_SURROGATE);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map<?, ?> map = this.calls.get();
        boolean b = false;
        if (map == null) {
            map = new HashMap<Object, Object>();
            this.calls.set(map);
            b = true;
        }
        final Gson$FutureTypeAdapter gson$FutureTypeAdapter = map.get(typeToken);
        if (gson$FutureTypeAdapter != null) {
            return gson$FutureTypeAdapter;
        }
        try {
            final Gson$FutureTypeAdapter gson$FutureTypeAdapter2 = new Gson$FutureTypeAdapter();
            map.put(typeToken, gson$FutureTypeAdapter2);
            final Iterator<TypeAdapterFactory> iterator = this.factories.iterator();
            while (iterator.hasNext()) {
                final TypeAdapter create = iterator.next().create(this, typeToken);
                if (create != null) {
                    gson$FutureTypeAdapter2.setDelegate(create);
                    this.typeTokenCache.put(typeToken, create);
                    return create;
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("GSON cannot handle ");
            sb.append(typeToken);
            throw new IllegalArgumentException(sb.toString());
        }
        finally {
            map.remove(typeToken);
            if (b) {
                this.calls.remove();
            }
        }
    }
    
    public TypeAdapter getAdapter(final Class clazz) {
        return this.getAdapter(TypeToken.get(clazz));
    }
    
    public TypeAdapter getDelegateAdapter(TypeAdapterFactory jsonAdapterFactory, final TypeToken typeToken) {
        if (!this.factories.contains(jsonAdapterFactory)) {
            jsonAdapterFactory = this.jsonAdapterFactory;
        }
        int n = 0;
        for (final TypeAdapterFactory typeAdapterFactory : this.factories) {
            if (n == 0) {
                if (typeAdapterFactory != jsonAdapterFactory) {
                    continue;
                }
                n = 1;
            }
            else {
                final TypeAdapter create = typeAdapterFactory.create(this, typeToken);
                if (create != null) {
                    return create;
                }
                continue;
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("GSON cannot serialize ");
        sb.append(typeToken);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public boolean htmlSafe() {
        return this.htmlSafe;
    }
    
    public JsonReader newJsonReader(final Reader reader) {
        final JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(this.lenient);
        return jsonReader;
    }
    
    public JsonWriter newJsonWriter(final Writer writer) {
        if (this.generateNonExecutableJson) {
            writer.write(")]}'\n");
        }
        final JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.prettyPrinting) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setSerializeNulls(this.serializeNulls);
        return jsonWriter;
    }
    
    public boolean serializeNulls() {
        return this.serializeNulls;
    }
    
    public String toJson(final JsonElement jsonElement) {
        final StringWriter stringWriter = new StringWriter();
        this.toJson(jsonElement, stringWriter);
        return stringWriter.toString();
    }
    
    public String toJson(final Object o) {
        if (o == null) {
            return this.toJson(JsonNull.INSTANCE);
        }
        return this.toJson(o, o.getClass());
    }
    
    public String toJson(final Object o, final Type type) {
        final StringWriter stringWriter = new StringWriter();
        this.toJson(o, type, stringWriter);
        return stringWriter.toString();
    }
    
    public void toJson(final JsonElement jsonElement, final JsonWriter jsonWriter) {
        final boolean lenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        final boolean htmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        final boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            try {
                Streams.write(jsonElement, jsonWriter);
                jsonWriter.setLenient(lenient);
                jsonWriter.setHtmlSafe(htmlSafe);
                jsonWriter.setSerializeNulls(serializeNulls);
                return;
            }
            finally {}
        }
        catch (IOException ex) {
            throw new JsonIOException(ex);
        }
        jsonWriter.setLenient(lenient);
        jsonWriter.setHtmlSafe(htmlSafe);
        jsonWriter.setSerializeNulls(serializeNulls);
    }
    
    public void toJson(final JsonElement jsonElement, final Appendable appendable) {
        try {
            this.toJson(jsonElement, this.newJsonWriter(Streams.writerForAppendable(appendable)));
        }
        catch (IOException ex) {
            throw new JsonIOException(ex);
        }
    }
    
    public void toJson(final Object o, final Appendable appendable) {
        if (o != null) {
            this.toJson(o, o.getClass(), appendable);
        }
        else {
            this.toJson(JsonNull.INSTANCE, appendable);
        }
    }
    
    public void toJson(final Object o, final Type type, final JsonWriter jsonWriter) {
        final TypeAdapter adapter = this.getAdapter(TypeToken.get(type));
        final boolean lenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        final boolean htmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        final boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.serializeNulls);
        final TypeAdapter typeAdapter = adapter;
        try {
            try {
                typeAdapter.write(jsonWriter, o);
                jsonWriter.setLenient(lenient);
                jsonWriter.setHtmlSafe(htmlSafe);
                jsonWriter.setSerializeNulls(serializeNulls);
                return;
            }
            finally {}
        }
        catch (IOException ex) {
            throw new JsonIOException(ex);
        }
        jsonWriter.setLenient(lenient);
        jsonWriter.setHtmlSafe(htmlSafe);
        jsonWriter.setSerializeNulls(serializeNulls);
    }
    
    public void toJson(final Object o, final Type type, final Appendable appendable) {
        try {
            this.toJson(o, type, this.newJsonWriter(Streams.writerForAppendable(appendable)));
        }
        catch (IOException ex) {
            throw new JsonIOException(ex);
        }
    }
    
    public JsonElement toJsonTree(final Object o) {
        if (o == null) {
            return JsonNull.INSTANCE;
        }
        return this.toJsonTree(o, o.getClass());
    }
    
    public JsonElement toJsonTree(final Object o, final Type type) {
        final JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
        this.toJson(o, type, jsonTreeWriter);
        return jsonTreeWriter.get();
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder("{serializeNulls:");
        sb.append(this.serializeNulls);
        sb.append("factories:");
        sb.append(this.factories);
        sb.append(",instanceCreators:");
        sb.append(this.constructorConstructor);
        sb.append("}");
        return sb.toString();
    }
}
