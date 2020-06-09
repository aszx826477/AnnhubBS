// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.lang.annotation.Annotation;
import com.google.gson.internal.$Gson$Preconditions;
import java.lang.reflect.Field;

public final class FieldAttributes
{
    private final Field field;
    
    public FieldAttributes(final Field field) {
        $Gson$Preconditions.checkNotNull(field);
        this.field = field;
    }
    
    Object get(final Object o) {
        return this.field.get(o);
    }
    
    public Annotation getAnnotation(final Class clazz) {
        return this.field.getAnnotation((Class<Annotation>)clazz);
    }
    
    public Collection getAnnotations() {
        return Arrays.asList(this.field.getAnnotations());
    }
    
    public Class getDeclaredClass() {
        return this.field.getType();
    }
    
    public Type getDeclaredType() {
        return this.field.getGenericType();
    }
    
    public Class getDeclaringClass() {
        return this.field.getDeclaringClass();
    }
    
    public String getName() {
        return this.field.getName();
    }
    
    public boolean hasModifier(final int n) {
        return (this.field.getModifiers() & n) != 0x0;
    }
    
    boolean isSynthetic() {
        return this.field.isSynthetic();
    }
}
