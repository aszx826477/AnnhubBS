// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.util.Arrays;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

final class $Gson$Types$ParameterizedTypeImpl implements ParameterizedType, Serializable
{
    private static final long serialVersionUID;
    private final Type ownerType;
    private final Type rawType;
    private final Type[] typeArguments;
    
    public $Gson$Types$ParameterizedTypeImpl(final Type type, final Type type2, final Type... array) {
        if (type2 instanceof Class) {
            final Class clazz = (Class)type2;
            final boolean static1 = Modifier.isStatic(clazz.getModifiers());
            boolean b = false;
            final boolean b2 = static1 || clazz.getEnclosingClass() == null;
            if (type != null || b2) {
                b = true;
            }
            $Gson$Preconditions.checkArgument(b);
        }
        Type canonicalize;
        if (type == null) {
            canonicalize = null;
        }
        else {
            canonicalize = $Gson$Types.canonicalize(type);
        }
        this.ownerType = canonicalize;
        this.rawType = $Gson$Types.canonicalize(type2);
        this.typeArguments = array.clone();
        int n = 0;
        while (true) {
            final Type[] typeArguments = this.typeArguments;
            if (n >= typeArguments.length) {
                break;
            }
            $Gson$Preconditions.checkNotNull(typeArguments[n]);
            $Gson$Types.checkNotPrimitive(this.typeArguments[n]);
            final Type[] typeArguments2 = this.typeArguments;
            typeArguments2[n] = $Gson$Types.canonicalize(typeArguments2[n]);
            ++n;
        }
    }
    
    public boolean equals(final Object o) {
        return o instanceof ParameterizedType && $Gson$Types.equals(this, (Type)o);
    }
    
    public Type[] getActualTypeArguments() {
        return this.typeArguments.clone();
    }
    
    public Type getOwnerType() {
        return this.ownerType;
    }
    
    public Type getRawType() {
        return this.rawType;
    }
    
    public int hashCode() {
        return Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode() ^ $Gson$Types.hashCodeOrZero(this.ownerType);
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder((this.typeArguments.length + 1) * 30);
        sb.append($Gson$Types.typeToString(this.rawType));
        if (this.typeArguments.length == 0) {
            return sb.toString();
        }
        sb.append("<");
        sb.append($Gson$Types.typeToString(this.typeArguments[0]));
        for (int i = 1; i < this.typeArguments.length; ++i) {
            sb.append(", ");
            sb.append($Gson$Types.typeToString(this.typeArguments[i]));
        }
        sb.append(">");
        return sb.toString();
    }
}
