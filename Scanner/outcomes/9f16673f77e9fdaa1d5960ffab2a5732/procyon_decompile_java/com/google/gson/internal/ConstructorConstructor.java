// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.Queue;
import java.util.Set;
import java.util.EnumSet;
import java.util.SortedSet;
import java.util.Collection;
import java.lang.reflect.Type;
import java.lang.reflect.Constructor;
import java.util.Map;

public final class ConstructorConstructor
{
    private final Map instanceCreators;
    
    public ConstructorConstructor(final Map instanceCreators) {
        this.instanceCreators = instanceCreators;
    }
    
    private ObjectConstructor newDefaultConstructor(final Class clazz) {
        try {
            final Constructor declaredConstructor = clazz.getDeclaredConstructor((Class[])new Class[0]);
            try {
                if (!declaredConstructor.isAccessible()) {
                    declaredConstructor.setAccessible(true);
                }
                return new ConstructorConstructor$3(this, declaredConstructor);
            }
            catch (NoSuchMethodException ex) {
                return null;
            }
        }
        catch (NoSuchMethodException ex2) {}
    }
    
    private ObjectConstructor newDefaultImplementationConstructor(final Type type, final Class clazz) {
        if (Collection.class.isAssignableFrom(clazz)) {
            if (SortedSet.class.isAssignableFrom(clazz)) {
                return new ConstructorConstructor$4(this);
            }
            if (EnumSet.class.isAssignableFrom(clazz)) {
                return new ConstructorConstructor$5(this, type);
            }
            if (Set.class.isAssignableFrom(clazz)) {
                return new ConstructorConstructor$6(this);
            }
            if (Queue.class.isAssignableFrom(clazz)) {
                return new ConstructorConstructor$7(this);
            }
            return new ConstructorConstructor$8(this);
        }
        else {
            if (!Map.class.isAssignableFrom(clazz)) {
                return null;
            }
            if (ConcurrentNavigableMap.class.isAssignableFrom(clazz)) {
                return new ConstructorConstructor$9(this);
            }
            if (ConcurrentMap.class.isAssignableFrom(clazz)) {
                return new ConstructorConstructor$10(this);
            }
            if (SortedMap.class.isAssignableFrom(clazz)) {
                return new ConstructorConstructor$11(this);
            }
            if (type instanceof ParameterizedType && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType)type).getActualTypeArguments()[0]).getRawType())) {
                return new ConstructorConstructor$12(this);
            }
            return new ConstructorConstructor$13(this);
        }
    }
    
    private ObjectConstructor newUnsafeAllocator(final Type type, final Class clazz) {
        return new ConstructorConstructor$14(this, clazz, type);
    }
    
    public ObjectConstructor get(final TypeToken typeToken) {
        final Type type = typeToken.getType();
        final Class rawType = typeToken.getRawType();
        final InstanceCreator instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new ConstructorConstructor$1(this, instanceCreator, type);
        }
        final InstanceCreator instanceCreator2 = this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            return new ConstructorConstructor$2(this, instanceCreator2, type);
        }
        final ObjectConstructor defaultConstructor = this.newDefaultConstructor(rawType);
        if (defaultConstructor != null) {
            return defaultConstructor;
        }
        final ObjectConstructor defaultImplementationConstructor = this.newDefaultImplementationConstructor(type, rawType);
        if (defaultImplementationConstructor != null) {
            return defaultImplementationConstructor;
        }
        return this.newUnsafeAllocator(type, rawType);
    }
    
    public String toString() {
        return this.instanceCreators.toString();
    }
}
