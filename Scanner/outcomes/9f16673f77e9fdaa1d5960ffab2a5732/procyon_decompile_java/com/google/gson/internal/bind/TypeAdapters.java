// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonElement;
import java.util.Locale;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Currency;
import java.util.UUID;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.BitSet;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.TypeAdapter;

public final class TypeAdapters
{
    public static final TypeAdapter ATOMIC_BOOLEAN;
    public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY;
    public static final TypeAdapter ATOMIC_INTEGER;
    public static final TypeAdapter ATOMIC_INTEGER_ARRAY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY;
    public static final TypeAdapter BIG_DECIMAL;
    public static final TypeAdapter BIG_INTEGER;
    public static final TypeAdapter BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY;
    public static final TypeAdapter BOOLEAN;
    public static final TypeAdapter BOOLEAN_AS_STRING;
    public static final TypeAdapterFactory BOOLEAN_FACTORY;
    public static final TypeAdapter BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY;
    public static final TypeAdapter CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY;
    public static final TypeAdapter CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY;
    public static final TypeAdapter CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY;
    public static final TypeAdapter CURRENCY;
    public static final TypeAdapterFactory CURRENCY_FACTORY;
    public static final TypeAdapter DOUBLE;
    public static final TypeAdapterFactory ENUM_FACTORY;
    public static final TypeAdapter FLOAT;
    public static final TypeAdapter INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final TypeAdapter INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY;
    public static final TypeAdapter JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY;
    public static final TypeAdapter LONG;
    public static final TypeAdapter NUMBER;
    public static final TypeAdapterFactory NUMBER_FACTORY;
    public static final TypeAdapter SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY;
    public static final TypeAdapter STRING;
    public static final TypeAdapter STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final TypeAdapter STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final TypeAdapterFactory STRING_FACTORY;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY;
    public static final TypeAdapter URI;
    public static final TypeAdapterFactory URI_FACTORY;
    public static final TypeAdapter URL;
    public static final TypeAdapterFactory URL_FACTORY;
    public static final TypeAdapter UUID;
    public static final TypeAdapterFactory UUID_FACTORY;
    
    static {
        CLASS = new TypeAdapters$1();
        CLASS_FACTORY = newFactory(Class.class, TypeAdapters.CLASS);
        BIT_SET = new TypeAdapters$2();
        BIT_SET_FACTORY = newFactory(BitSet.class, TypeAdapters.BIT_SET);
        BOOLEAN = new TypeAdapters$3();
        BOOLEAN_AS_STRING = new TypeAdapters$4();
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, TypeAdapters.BOOLEAN);
        BYTE = new TypeAdapters$5();
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, TypeAdapters.BYTE);
        SHORT = new TypeAdapters$6();
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, TypeAdapters.SHORT);
        INTEGER = new TypeAdapters$7();
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, TypeAdapters.INTEGER);
        ATOMIC_INTEGER = new TypeAdapters$8().nullSafe();
        ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, TypeAdapters.ATOMIC_INTEGER);
        ATOMIC_BOOLEAN = new TypeAdapters$9().nullSafe();
        ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, TypeAdapters.ATOMIC_BOOLEAN);
        ATOMIC_INTEGER_ARRAY = new TypeAdapters$10().nullSafe();
        ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, TypeAdapters.ATOMIC_INTEGER_ARRAY);
        LONG = new TypeAdapters$11();
        FLOAT = new TypeAdapters$12();
        DOUBLE = new TypeAdapters$13();
        NUMBER = new TypeAdapters$14();
        NUMBER_FACTORY = newFactory(Number.class, TypeAdapters.NUMBER);
        CHARACTER = new TypeAdapters$15();
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, TypeAdapters.CHARACTER);
        STRING = new TypeAdapters$16();
        BIG_DECIMAL = new TypeAdapters$17();
        BIG_INTEGER = new TypeAdapters$18();
        STRING_FACTORY = newFactory(String.class, TypeAdapters.STRING);
        STRING_BUILDER = new TypeAdapters$19();
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, TypeAdapters.STRING_BUILDER);
        STRING_BUFFER = new TypeAdapters$20();
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, TypeAdapters.STRING_BUFFER);
        URL = new TypeAdapters$21();
        URL_FACTORY = newFactory(URL.class, TypeAdapters.URL);
        URI = new TypeAdapters$22();
        URI_FACTORY = newFactory(URI.class, TypeAdapters.URI);
        INET_ADDRESS = new TypeAdapters$23();
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, TypeAdapters.INET_ADDRESS);
        UUID = new TypeAdapters$24();
        UUID_FACTORY = newFactory(UUID.class, TypeAdapters.UUID);
        CURRENCY = new TypeAdapters$25().nullSafe();
        CURRENCY_FACTORY = newFactory(Currency.class, TypeAdapters.CURRENCY);
        TIMESTAMP_FACTORY = new TypeAdapters$26();
        CALENDAR = new TypeAdapters$27();
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, TypeAdapters.CALENDAR);
        LOCALE = new TypeAdapters$28();
        LOCALE_FACTORY = newFactory(Locale.class, TypeAdapters.LOCALE);
        JSON_ELEMENT = new TypeAdapters$29();
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, TypeAdapters.JSON_ELEMENT);
        ENUM_FACTORY = new TypeAdapters$30();
    }
    
    private TypeAdapters() {
        throw new UnsupportedOperationException();
    }
    
    public static TypeAdapterFactory newFactory(final TypeToken typeToken, final TypeAdapter typeAdapter) {
        return new TypeAdapters$31(typeToken, typeAdapter);
    }
    
    public static TypeAdapterFactory newFactory(final Class clazz, final TypeAdapter typeAdapter) {
        return new TypeAdapters$32(clazz, typeAdapter);
    }
    
    public static TypeAdapterFactory newFactory(final Class clazz, final Class clazz2, final TypeAdapter typeAdapter) {
        return new TypeAdapters$33(clazz, clazz2, typeAdapter);
    }
    
    public static TypeAdapterFactory newFactoryForMultipleTypes(final Class clazz, final Class clazz2, final TypeAdapter typeAdapter) {
        return new TypeAdapters$34(clazz, clazz2, typeAdapter);
    }
    
    public static TypeAdapterFactory newTypeHierarchyFactory(final Class clazz, final TypeAdapter typeAdapter) {
        return new TypeAdapters$35(clazz, typeAdapter);
    }
}
