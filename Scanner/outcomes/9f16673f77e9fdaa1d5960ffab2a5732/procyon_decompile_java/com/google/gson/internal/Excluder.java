// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.util.Collection;
import java.util.ArrayList;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;
import java.lang.reflect.Field;
import java.util.Iterator;
import com.google.gson.ExclusionStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.annotations.Until;
import com.google.gson.annotations.Since;
import java.util.Collections;
import java.util.List;
import com.google.gson.TypeAdapterFactory;

public final class Excluder implements TypeAdapterFactory, Cloneable
{
    public static final Excluder DEFAULT;
    private static final double IGNORE_VERSIONS = -1.0;
    private List deserializationStrategies;
    private int modifiers;
    private boolean requireExpose;
    private List serializationStrategies;
    private boolean serializeInnerClasses;
    private double version;
    
    static {
        DEFAULT = new Excluder();
    }
    
    public Excluder() {
        this.version = -1.0;
        this.modifiers = 136;
        this.serializeInnerClasses = true;
        this.serializationStrategies = Collections.emptyList();
        this.deserializationStrategies = Collections.emptyList();
    }
    
    private boolean isAnonymousOrLocal(final Class clazz) {
        return !Enum.class.isAssignableFrom(clazz) && (clazz.isAnonymousClass() || clazz.isLocalClass());
    }
    
    private boolean isInnerClass(final Class clazz) {
        return clazz.isMemberClass() && !this.isStatic(clazz);
    }
    
    private boolean isStatic(final Class clazz) {
        return (clazz.getModifiers() & 0x8) != 0x0;
    }
    
    private boolean isValidSince(final Since since) {
        return since == null || since.value() <= this.version;
    }
    
    private boolean isValidUntil(final Until until) {
        return until == null || until.value() > this.version;
    }
    
    private boolean isValidVersion(final Since since, final Until until) {
        return this.isValidSince(since) && this.isValidUntil(until);
    }
    
    protected Excluder clone() {
        try {
            final Object clone = super.clone();
            try {
                return (Excluder)clone;
            }
            catch (CloneNotSupportedException ex) {
                throw new AssertionError((Object)ex);
            }
        }
        catch (CloneNotSupportedException ex2) {}
    }
    
    public TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        final Class rawType = typeToken.getRawType();
        final boolean excludeClass = this.excludeClass(rawType, true);
        final boolean excludeClass2 = this.excludeClass(rawType, false);
        if (!excludeClass && !excludeClass2) {
            return null;
        }
        return new Excluder$1(this, excludeClass2, excludeClass, gson, typeToken);
    }
    
    public Excluder disableInnerClassSerialization() {
        final Excluder clone = this.clone();
        clone.serializeInnerClasses = false;
        return clone;
    }
    
    public boolean excludeClass(final Class clazz, final boolean b) {
        final double version = this.version;
        final boolean b2 = true;
        if (version != -1.0 && !this.isValidVersion(clazz.getAnnotation(Since.class), clazz.getAnnotation(Until.class))) {
            return b2;
        }
        if (!this.serializeInnerClasses && this.isInnerClass(clazz)) {
            return b2;
        }
        if (this.isAnonymousOrLocal(clazz)) {
            return b2;
        }
        List list;
        if (b) {
            list = this.serializationStrategies;
        }
        else {
            list = this.deserializationStrategies;
        }
        final Iterator<ExclusionStrategy> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().shouldSkipClass(clazz)) {
                return b2;
            }
        }
        return false;
    }
    
    public boolean excludeField(final Field field, final boolean b) {
        final int n = this.modifiers & field.getModifiers();
        final boolean b2 = true;
        if (n != 0) {
            return b2;
        }
        if (this.version != -1.0 && !this.isValidVersion(field.getAnnotation(Since.class), field.getAnnotation(Until.class))) {
            return b2;
        }
        if (field.isSynthetic()) {
            return b2;
        }
        Label_0169: {
            if (this.requireExpose) {
                final Expose expose = field.getAnnotation(Expose.class);
                if (expose != null) {
                    if (b) {
                        if (!expose.serialize()) {
                            return b2;
                        }
                    }
                    else if (!expose.deserialize()) {
                        return b2;
                    }
                    break Label_0169;
                }
                return b2;
            }
        }
        if (!this.serializeInnerClasses && this.isInnerClass(field.getType())) {
            return b2;
        }
        if (this.isAnonymousOrLocal(field.getType())) {
            return b2;
        }
        List list;
        if (b) {
            list = this.serializationStrategies;
        }
        else {
            list = this.deserializationStrategies;
        }
        if (!list.isEmpty()) {
            final FieldAttributes fieldAttributes = new FieldAttributes(field);
            final Iterator<ExclusionStrategy> iterator = list.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().shouldSkipField(fieldAttributes)) {
                    return b2;
                }
            }
        }
        return false;
    }
    
    public Excluder excludeFieldsWithoutExposeAnnotation() {
        final Excluder clone = this.clone();
        clone.requireExpose = true;
        return clone;
    }
    
    public Excluder withExclusionStrategy(final ExclusionStrategy exclusionStrategy, final boolean b, final boolean b2) {
        final Excluder clone = this.clone();
        if (b) {
            (clone.serializationStrategies = new ArrayList(this.serializationStrategies)).add(exclusionStrategy);
        }
        if (b2) {
            (clone.deserializationStrategies = new ArrayList(this.deserializationStrategies)).add(exclusionStrategy);
        }
        return clone;
    }
    
    public Excluder withModifiers(final int... array) {
        final Excluder clone = this.clone();
        int i = 0;
        clone.modifiers = 0;
        while (i < array.length) {
            clone.modifiers |= array[i];
            ++i;
        }
        return clone;
    }
    
    public Excluder withVersion(final double version) {
        final Excluder clone = this.clone();
        clone.version = version;
        return clone;
    }
}
