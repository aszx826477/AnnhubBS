// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.reflect;

import java.lang.reflect.TypeVariable;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.$Gson$Types;
import java.lang.reflect.Type;

public class TypeToken
{
    final int hashCode;
    final Class rawType;
    final Type type;
    
    protected TypeToken() {
        this.type = getSuperclassTypeParameter(this.getClass());
        this.rawType = $Gson$Types.getRawType(this.type);
        this.hashCode = this.type.hashCode();
    }
    
    TypeToken(final Type type) {
        this.type = $Gson$Types.canonicalize((Type)$Gson$Preconditions.checkNotNull(type));
        this.rawType = $Gson$Types.getRawType(this.type);
        this.hashCode = this.type.hashCode();
    }
    
    private static AssertionError buildUnexpectedTypeError(final Type type, final Class... array) {
        final StringBuilder sb = new StringBuilder("Unexpected type. Expected one of: ");
        for (int length = array.length, i = 0; i < length; ++i) {
            sb.append(array[i].getName());
            sb.append(", ");
        }
        sb.append("but got: ");
        sb.append(type.getClass().getName());
        sb.append(", for type token: ");
        sb.append(type.toString());
        sb.append('.');
        return new AssertionError((Object)sb.toString());
    }
    
    public static TypeToken get(final Class clazz) {
        return new TypeToken(clazz);
    }
    
    public static TypeToken get(final Type type) {
        return new TypeToken(type);
    }
    
    static Type getSuperclassTypeParameter(final Class clazz) {
        final Type genericSuperclass = clazz.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return $Gson$Types.canonicalize(((ParameterizedType)genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }
    
    private static boolean isAssignableFrom(final Type type, final GenericArrayType genericArrayType) {
        final Type genericComponentType = genericArrayType.getGenericComponentType();
        if (genericComponentType instanceof ParameterizedType) {
            Type genericComponentType2 = type;
            if (type instanceof GenericArrayType) {
                genericComponentType2 = ((GenericArrayType)type).getGenericComponentType();
            }
            else if (type instanceof Class) {
                Class componentType;
                for (componentType = (Class)type; componentType.isArray(); componentType = componentType.getComponentType()) {}
                genericComponentType2 = componentType;
            }
            return isAssignableFrom(genericComponentType2, (ParameterizedType)genericComponentType, new HashMap());
        }
        return true;
    }
    
    private static boolean isAssignableFrom(final Type type, final ParameterizedType parameterizedType, final Map map) {
        int i = 0;
        if (type == null) {
            return false;
        }
        final boolean equals = parameterizedType.equals(type);
        final boolean b = true;
        if (equals) {
            return b;
        }
        final Class rawType = $Gson$Types.getRawType(type);
        ParameterizedType parameterizedType2 = null;
        if (type instanceof ParameterizedType) {
            parameterizedType2 = (ParameterizedType)type;
        }
        if (parameterizedType2 != null) {
            final Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
            final TypeVariable[] typeParameters = rawType.getTypeParameters();
            for (int j = 0; j < actualTypeArguments.length; ++j) {
                Type type2 = actualTypeArguments[j];
                final TypeVariable typeVariable = typeParameters[j];
                while (type2 instanceof TypeVariable) {
                    type2 = map.get(((TypeVariable)type2).getName());
                }
                map.put(typeVariable.getName(), type2);
            }
            if (typeEquals(parameterizedType2, parameterizedType, map)) {
                return b;
            }
        }
        for (Type[] genericInterfaces = rawType.getGenericInterfaces(); i < genericInterfaces.length; ++i) {
            if (isAssignableFrom(genericInterfaces[i], parameterizedType, new HashMap(map))) {
                return b;
            }
        }
        return isAssignableFrom(rawType.getGenericSuperclass(), parameterizedType, new HashMap(map));
    }
    
    private static boolean matches(final Type type, final Type type2, final Map map) {
        return type2.equals(type) || (type instanceof TypeVariable && type2.equals(map.get(((TypeVariable)type).getName())));
    }
    
    private static boolean typeEquals(final ParameterizedType parameterizedType, final ParameterizedType parameterizedType2, final Map map) {
        if (parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
            final Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            final Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
            for (int i = 0; i < actualTypeArguments.length; ++i) {
                if (!matches(actualTypeArguments[i], actualTypeArguments2[i], map)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public final boolean equals(final Object o) {
        return o instanceof TypeToken && $Gson$Types.equals(this.type, ((TypeToken)o).type);
    }
    
    public final Class getRawType() {
        return this.rawType;
    }
    
    public final Type getType() {
        return this.type;
    }
    
    public final int hashCode() {
        return this.hashCode;
    }
    
    public boolean isAssignableFrom(final TypeToken typeToken) {
        return this.isAssignableFrom(typeToken.getType());
    }
    
    public boolean isAssignableFrom(final Class clazz) {
        return this.isAssignableFrom((Type)clazz);
    }
    
    public boolean isAssignableFrom(final Type type) {
        boolean b = false;
        if (type == null) {
            return false;
        }
        final boolean equals = this.type.equals(type);
        final int n = 1;
        if (equals) {
            return n != 0;
        }
        final Type type2 = this.type;
        if (type2 instanceof Class) {
            return this.rawType.isAssignableFrom($Gson$Types.getRawType(type));
        }
        if (type2 instanceof ParameterizedType) {
            return isAssignableFrom(type, (ParameterizedType)type2, new HashMap());
        }
        if (type2 instanceof GenericArrayType) {
            if (this.rawType.isAssignableFrom($Gson$Types.getRawType(type))) {
                if (isAssignableFrom(type, (GenericArrayType)this.type)) {
                    b = true;
                }
            }
            return b;
        }
        final Class[] array = { Class.class, null, null };
        array[n] = ParameterizedType.class;
        array[2] = GenericArrayType.class;
        throw buildUnexpectedTypeError(type2, array);
    }
    
    public final String toString() {
        return $Gson$Types.typeToString(this.type);
    }
}
