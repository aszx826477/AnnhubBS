// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Primitives
{
    private static final Map PRIMITIVE_TO_WRAPPER_TYPE;
    private static final Map WRAPPER_TO_PRIMITIVE_TYPE;
    
    static {
        final int n = 16;
        final HashMap hashMap = new HashMap<Object, Object>(n);
        final HashMap hashMap2 = new HashMap<Object, Object>(n);
        add(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        add(hashMap, hashMap2, Byte.TYPE, Byte.class);
        add(hashMap, hashMap2, Character.TYPE, Character.class);
        add(hashMap, hashMap2, Double.TYPE, Double.class);
        add(hashMap, hashMap2, Float.TYPE, Float.class);
        add(hashMap, hashMap2, Integer.TYPE, Integer.class);
        add(hashMap, hashMap2, Long.TYPE, Long.class);
        add(hashMap, hashMap2, Short.TYPE, Short.class);
        add(hashMap, hashMap2, Void.TYPE, Void.class);
        PRIMITIVE_TO_WRAPPER_TYPE = Collections.unmodifiableMap((Map<?, ?>)hashMap);
        WRAPPER_TO_PRIMITIVE_TYPE = Collections.unmodifiableMap((Map<?, ?>)hashMap2);
    }
    
    private Primitives() {
        throw new UnsupportedOperationException();
    }
    
    private static void add(final Map map, final Map map2, final Class clazz, final Class clazz2) {
        map.put(clazz, clazz2);
        map2.put(clazz2, clazz);
    }
    
    public static boolean isPrimitive(final Type type) {
        return Primitives.PRIMITIVE_TO_WRAPPER_TYPE.containsKey(type);
    }
    
    public static boolean isWrapperType(final Type type) {
        return Primitives.WRAPPER_TO_PRIMITIVE_TYPE.containsKey($Gson$Preconditions.checkNotNull(type));
    }
    
    public static Class unwrap(final Class clazz) {
        final Class clazz2 = Primitives.WRAPPER_TO_PRIMITIVE_TYPE.get($Gson$Preconditions.checkNotNull(clazz));
        Class clazz3;
        if (clazz2 == null) {
            clazz3 = clazz;
        }
        else {
            clazz3 = clazz2;
        }
        return clazz3;
    }
    
    public static Class wrap(final Class clazz) {
        final Class clazz2 = Primitives.PRIMITIVE_TO_WRAPPER_TYPE.get($Gson$Preconditions.checkNotNull(clazz));
        Class clazz3;
        if (clazz2 == null) {
            clazz3 = clazz;
        }
        else {
            clazz3 = clazz2;
        }
        return clazz3;
    }
}
