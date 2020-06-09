// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.crud;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.litepal.exceptions.DataSupportException;

class DynamicExecutor
{
    static Object getField(final Object o, final String s, final Class clazz) {
        if (clazz != DataSupport.class && clazz != Object.class) {
            try {
                final Field declaredField = clazz.getDeclaredField(s);
                declaredField.setAccessible(true);
                final Field field = declaredField;
                try {
                    return field.get(o);
                }
                catch (NoSuchFieldException ex) {
                    return getField(o, s, clazz.getSuperclass());
                }
            }
            catch (NoSuchFieldException ex2) {}
        }
        throw new DataSupportException(DataSupportException.noSuchFieldExceptioin(clazz.getSimpleName(), s));
    }
    
    static Object send(final Object o, final String s, Object[] array, final Class clazz, Class[] array2) {
        if (array == null) {
            try {
                array = new Object[0];
            }
            catch (NoSuchMethodException ex) {
                throw new DataSupportException(DataSupportException.noSuchMethodException(clazz.getSimpleName(), s), ex);
            }
        }
        if (array2 == null) {
            array2 = new Class[0];
        }
        final Method declaredMethod = clazz.getDeclaredMethod(s, (Class[])array2);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(o, array);
    }
    
    static void set(final Object o, final String s, final Object o2, final Class clazz) {
        final Field declaredField = clazz.getDeclaredField(s);
        declaredField.setAccessible(true);
        declaredField.set(o, o2);
    }
    
    static void setField(final Object o, final String s, final Object o2, final Class clazz) {
        if (clazz != DataSupport.class && clazz != Object.class) {
            try {
                set(o, s, o2, clazz);
            }
            catch (NoSuchFieldException ex) {
                setField(o, s, o2, clazz.getSuperclass());
            }
            return;
        }
        throw new DataSupportException(DataSupportException.noSuchFieldExceptioin(clazz.getSimpleName(), s));
    }
}
