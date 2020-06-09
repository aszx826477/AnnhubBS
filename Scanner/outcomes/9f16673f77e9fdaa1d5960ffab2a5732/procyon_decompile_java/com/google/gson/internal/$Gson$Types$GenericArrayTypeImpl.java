// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.lang.reflect.Type;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;

final class $Gson$Types$GenericArrayTypeImpl implements GenericArrayType, Serializable
{
    private static final long serialVersionUID;
    private final Type componentType;
    
    public $Gson$Types$GenericArrayTypeImpl(final Type type) {
        this.componentType = $Gson$Types.canonicalize(type);
    }
    
    public boolean equals(final Object o) {
        return o instanceof GenericArrayType && $Gson$Types.equals(this, (Type)o);
    }
    
    public Type getGenericComponentType() {
        return this.componentType;
    }
    
    public int hashCode() {
        return this.componentType.hashCode();
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append($Gson$Types.typeToString(this.componentType));
        sb.append("[]");
        return sb.toString();
    }
}
