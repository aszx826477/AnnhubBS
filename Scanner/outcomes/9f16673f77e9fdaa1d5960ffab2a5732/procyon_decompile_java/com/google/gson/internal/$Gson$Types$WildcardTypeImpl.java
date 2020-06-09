// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.lang.reflect.Type;
import java.io.Serializable;
import java.lang.reflect.WildcardType;

final class $Gson$Types$WildcardTypeImpl implements WildcardType, Serializable
{
    private static final long serialVersionUID;
    private final Type lowerBound;
    private final Type upperBound;
    
    public $Gson$Types$WildcardTypeImpl(final Type[] array, final Type[] array2) {
        final int length = array2.length;
        int n = 1;
        $Gson$Preconditions.checkArgument(length <= n);
        $Gson$Preconditions.checkArgument(array.length == n);
        if (array2.length == n) {
            $Gson$Preconditions.checkNotNull(array2[0]);
            $Gson$Types.checkNotPrimitive(array2[0]);
            if (array[0] != Object.class) {
                n = 0;
            }
            $Gson$Preconditions.checkArgument(n != 0);
            this.lowerBound = $Gson$Types.canonicalize(array2[0]);
            this.upperBound = Object.class;
        }
        else {
            $Gson$Preconditions.checkNotNull(array[0]);
            $Gson$Types.checkNotPrimitive(array[0]);
            this.lowerBound = null;
            this.upperBound = $Gson$Types.canonicalize(array[0]);
        }
    }
    
    public boolean equals(final Object o) {
        return o instanceof WildcardType && $Gson$Types.equals(this, (Type)o);
    }
    
    public Type[] getLowerBounds() {
        final Type lowerBound = this.lowerBound;
        Type[] empty_TYPE_ARRAY;
        if (lowerBound != null) {
            empty_TYPE_ARRAY = new Type[] { lowerBound };
        }
        else {
            empty_TYPE_ARRAY = $Gson$Types.EMPTY_TYPE_ARRAY;
        }
        return empty_TYPE_ARRAY;
    }
    
    public Type[] getUpperBounds() {
        return new Type[] { this.upperBound };
    }
    
    public int hashCode() {
        final Type lowerBound = this.lowerBound;
        int n;
        if (lowerBound != null) {
            n = lowerBound.hashCode() + 31;
        }
        else {
            n = 1;
        }
        return n ^ this.upperBound.hashCode() + 31;
    }
    
    public String toString() {
        if (this.lowerBound != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("? super ");
            sb.append($Gson$Types.typeToString(this.lowerBound));
            return sb.toString();
        }
        if (this.upperBound == Object.class) {
            return "?";
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("? extends ");
        sb2.append($Gson$Types.typeToString(this.upperBound));
        return sb2.toString();
    }
}
