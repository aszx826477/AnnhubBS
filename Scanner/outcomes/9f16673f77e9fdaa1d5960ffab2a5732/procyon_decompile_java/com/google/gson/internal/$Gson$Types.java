// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.util.NoSuchElementException;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.Properties;
import java.util.Collection;
import java.util.Arrays;
import java.lang.reflect.TypeVariable;
import java.io.Serializable;
import java.lang.reflect.WildcardType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public final class $Gson$Types
{
    static final Type[] EMPTY_TYPE_ARRAY;
    
    static {
        EMPTY_TYPE_ARRAY = new Type[0];
    }
    
    private $Gson$Types() {
        throw new UnsupportedOperationException();
    }
    
    public static GenericArrayType arrayOf(final Type type) {
        return new $Gson$Types$GenericArrayTypeImpl(type);
    }
    
    public static Type canonicalize(final Type type) {
        if (type instanceof Class) {
            final Class clazz = (Class)type;
            Serializable s;
            if (clazz.isArray()) {
                s = new $Gson$Types$GenericArrayTypeImpl(canonicalize(clazz.getComponentType()));
            }
            else {
                s = clazz;
            }
            return (Type)s;
        }
        if (type instanceof ParameterizedType) {
            final ParameterizedType parameterizedType = (ParameterizedType)type;
            return new $Gson$Types$ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new $Gson$Types$GenericArrayTypeImpl(((GenericArrayType)type).getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            final WildcardType wildcardType = (WildcardType)type;
            return new $Gson$Types$WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
        return type;
    }
    
    static void checkNotPrimitive(final Type type) {
        $Gson$Preconditions.checkArgument(!(type instanceof Class) || !((Class)type).isPrimitive());
    }
    
    private static Class declaringClassOf(final TypeVariable typeVariable) {
        final Class genericDeclaration = typeVariable.getGenericDeclaration();
        Class clazz;
        if (genericDeclaration instanceof Class) {
            clazz = genericDeclaration;
        }
        else {
            clazz = null;
        }
        return clazz;
    }
    
    static boolean equal(final Object o, final Object o2) {
        return o == o2 || (o != null && o.equals(o2));
    }
    
    public static boolean equals(final Type type, final Type type2) {
        boolean b = true;
        if (type == type2) {
            return b;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            final ParameterizedType parameterizedType = (ParameterizedType)type;
            final ParameterizedType parameterizedType2 = (ParameterizedType)type2;
            if (equal(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType())) {
                if (parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
                    if (Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                        return b;
                    }
                }
            }
            b = false;
            return b;
        }
        else {
            if (type instanceof GenericArrayType) {
                return type2 instanceof GenericArrayType && equals(((GenericArrayType)type).getGenericComponentType(), ((GenericArrayType)type2).getGenericComponentType());
            }
            if (type instanceof WildcardType) {
                if (!(type2 instanceof WildcardType)) {
                    return false;
                }
                final WildcardType wildcardType = (WildcardType)type;
                final WildcardType wildcardType2 = (WildcardType)type2;
                if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || !Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                    b = false;
                }
                return b;
            }
            else {
                if (!(type instanceof TypeVariable)) {
                    return false;
                }
                if (!(type2 instanceof TypeVariable)) {
                    return false;
                }
                final TypeVariable typeVariable = (TypeVariable)type;
                final TypeVariable typeVariable2 = (TypeVariable)type2;
                if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration() || !typeVariable.getName().equals(typeVariable2.getName())) {
                    b = false;
                }
                return b;
            }
        }
    }
    
    public static Type getArrayComponentType(final Type type) {
        Type type2;
        if (type instanceof GenericArrayType) {
            type2 = ((GenericArrayType)type).getGenericComponentType();
        }
        else {
            type2 = ((Class)type).getComponentType();
        }
        return type2;
    }
    
    public static Type getCollectionElementType(final Type type, final Class clazz) {
        Type supertype = getSupertype(type, clazz, Collection.class);
        if (supertype instanceof WildcardType) {
            supertype = ((WildcardType)supertype).getUpperBounds()[0];
        }
        if (supertype instanceof ParameterizedType) {
            return ((ParameterizedType)supertype).getActualTypeArguments()[0];
        }
        return Object.class;
    }
    
    static Type getGenericSupertype(final Type type, Class clazz, final Class clazz2) {
        if (clazz2 == clazz) {
            return type;
        }
        if (clazz2.isInterface()) {
            final Class<?>[] interfaces = clazz.getInterfaces();
            for (int i = 0; i < interfaces.length; ++i) {
                if (interfaces[i] == clazz2) {
                    return clazz.getGenericInterfaces()[i];
                }
                if (clazz2.isAssignableFrom(interfaces[i])) {
                    return getGenericSupertype(clazz.getGenericInterfaces()[i], interfaces[i], clazz2);
                }
            }
        }
        if (!clazz.isInterface()) {
            while (clazz != Object.class) {
                final Class<? super Object> superclass = clazz.getSuperclass();
                if (superclass == clazz2) {
                    return clazz.getGenericSuperclass();
                }
                if (clazz2.isAssignableFrom(superclass)) {
                    return getGenericSupertype(clazz.getGenericSuperclass(), superclass, clazz2);
                }
                clazz = (Class<Object>)superclass;
            }
        }
        return clazz2;
    }
    
    public static Type[] getMapKeyAndValueTypes(final Type type, final Class clazz) {
        final Class<Properties> clazz2 = Properties.class;
        final int n = 1;
        final int n2 = 2;
        if (type == clazz2) {
            final Type[] array = new Type[n2];
            array[n] = (array[0] = String.class);
            return array;
        }
        final Type supertype = getSupertype(type, clazz, Map.class);
        if (supertype instanceof ParameterizedType) {
            return ((ParameterizedType)supertype).getActualTypeArguments();
        }
        final Type[] array2 = new Type[n2];
        array2[n] = (array2[0] = Object.class);
        return array2;
    }
    
    public static Class getRawType(final Type type) {
        if (type instanceof Class) {
            return (Class)type;
        }
        if (type instanceof ParameterizedType) {
            final Type rawType = ((ParameterizedType)type).getRawType();
            $Gson$Preconditions.checkArgument(rawType instanceof Class);
            return (Class)rawType;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(getRawType(((GenericArrayType)type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return getRawType(((WildcardType)type).getUpperBounds()[0]);
        }
        String name;
        if (type == null) {
            name = "null";
        }
        else {
            name = type.getClass().getName();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
        sb.append(type);
        sb.append("> is of type ");
        sb.append(name);
        throw new IllegalArgumentException(sb.toString());
    }
    
    static Type getSupertype(final Type type, final Class clazz, final Class clazz2) {
        $Gson$Preconditions.checkArgument(clazz2.isAssignableFrom(clazz));
        return resolve(type, clazz, getGenericSupertype(type, clazz, clazz2));
    }
    
    static int hashCodeOrZero(final Object o) {
        int hashCode;
        if (o != null) {
            hashCode = o.hashCode();
        }
        else {
            hashCode = 0;
        }
        return hashCode;
    }
    
    private static int indexOf(final Object[] array, final Object o) {
        for (int i = 0; i < array.length; ++i) {
            if (o.equals(array[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }
    
    public static ParameterizedType newParameterizedTypeWithOwner(final Type type, final Type type2, final Type... array) {
        return new $Gson$Types$ParameterizedTypeImpl(type, type2, array);
    }
    
    public static Type resolve(final Type type, final Class clazz, Type resolveTypeVariable) {
        while (resolveTypeVariable instanceof TypeVariable) {
            final TypeVariable typeVariable = (TypeVariable)resolveTypeVariable;
            resolveTypeVariable = resolveTypeVariable(type, clazz, typeVariable);
            if (resolveTypeVariable == typeVariable) {
                return resolveTypeVariable;
            }
        }
        if (resolveTypeVariable instanceof Class && ((Class)resolveTypeVariable).isArray()) {
            final Class clazz2 = (Class)resolveTypeVariable;
            final Class componentType = clazz2.getComponentType();
            final Type resolve = resolve(type, clazz, componentType);
            Object array;
            if (componentType == resolve) {
                array = clazz2;
            }
            else {
                array = arrayOf(resolve);
            }
            return (Type)array;
        }
        if (resolveTypeVariable instanceof GenericArrayType) {
            final GenericArrayType genericArrayType = (GenericArrayType)resolveTypeVariable;
            final Type genericComponentType = genericArrayType.getGenericComponentType();
            final Type resolve2 = resolve(type, clazz, genericComponentType);
            GenericArrayType array2;
            if (genericComponentType == resolve2) {
                array2 = genericArrayType;
            }
            else {
                array2 = arrayOf(resolve2);
            }
            return array2;
        }
        final boolean b = resolveTypeVariable instanceof ParameterizedType;
        int n = 1;
        if (b) {
            final ParameterizedType parameterizedType = (ParameterizedType)resolveTypeVariable;
            final Type ownerType = parameterizedType.getOwnerType();
            final Type resolve3 = resolve(type, clazz, ownerType);
            if (resolve3 == ownerType) {
                n = 0;
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i = 0; i < actualTypeArguments.length; ++i) {
                final Type resolve4 = resolve(type, clazz, actualTypeArguments[i]);
                if (resolve4 != actualTypeArguments[i]) {
                    if (n == 0) {
                        actualTypeArguments = actualTypeArguments.clone();
                        n = 1;
                    }
                    actualTypeArguments[i] = resolve4;
                }
            }
            ParameterizedType parameterizedTypeWithOwner;
            if (n != 0) {
                parameterizedTypeWithOwner = newParameterizedTypeWithOwner(resolve3, parameterizedType.getRawType(), actualTypeArguments);
            }
            else {
                parameterizedTypeWithOwner = parameterizedType;
            }
            return parameterizedTypeWithOwner;
        }
        Label_0509: {
            if (!(resolveTypeVariable instanceof WildcardType)) {
                break Label_0509;
            }
            final WildcardType wildcardType = (WildcardType)resolveTypeVariable;
            final Type[] lowerBounds = wildcardType.getLowerBounds();
            final Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == n) {
                final Type resolve5 = resolve(type, clazz, lowerBounds[0]);
                if (resolve5 != lowerBounds[0]) {
                    return supertypeOf(resolve5);
                }
                return wildcardType;
            }
            else if (upperBounds.length != n) {
                return wildcardType;
            }
            final Type type2 = upperBounds[0];
            try {
                final Type resolve6 = resolve(type, clazz, type2);
                if (resolve6 != upperBounds[0]) {
                    return subtypeOf(resolve6);
                }
                return wildcardType;
                return resolveTypeVariable;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static Type resolveTypeVariable(final Type type, final Class clazz, final TypeVariable typeVariable) {
        final Class declaringClass = declaringClassOf(typeVariable);
        if (declaringClass == null) {
            return typeVariable;
        }
        final Type genericSupertype = getGenericSupertype(type, clazz, declaringClass);
        if (genericSupertype instanceof ParameterizedType) {
            return ((ParameterizedType)genericSupertype).getActualTypeArguments()[indexOf(declaringClass.getTypeParameters(), typeVariable)];
        }
        return typeVariable;
    }
    
    public static WildcardType subtypeOf(final Type type) {
        return new $Gson$Types$WildcardTypeImpl(new Type[] { type }, $Gson$Types.EMPTY_TYPE_ARRAY);
    }
    
    public static WildcardType supertypeOf(final Type type) {
        final int n = 1;
        final Type[] array = new Type[n];
        array[0] = Object.class;
        final Type[] array2 = new Type[n];
        array2[0] = type;
        return new $Gson$Types$WildcardTypeImpl(array, array2);
    }
    
    public static String typeToString(final Type type) {
        String s;
        if (type instanceof Class) {
            s = ((Class)type).getName();
        }
        else {
            s = type.toString();
        }
        return s;
    }
}
