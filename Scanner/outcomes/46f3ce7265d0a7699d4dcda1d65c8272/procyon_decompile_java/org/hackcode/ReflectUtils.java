// 
// Decompiled by Procyon v0.5.30
// 

package org.hackcode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;

public class ReflectUtils
{
    public static Object getFieldObject(final String s, final Object o, final String s2) {
        try {
            final Field declaredField = Class.forName(s).getDeclaredField(s2);
            declaredField.setAccessible(true);
            final Field field = declaredField;
            try {
                return field.get(o);
            }
            catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            catch (IllegalAccessException ex2) {
                ex2.printStackTrace();
            }
            catch (IllegalArgumentException ex3) {
                ex3.printStackTrace();
            }
            catch (NoSuchFieldException ex4) {
                ex4.printStackTrace();
            }
            catch (SecurityException ex5) {
                ex5.printStackTrace();
            }
        }
        catch (ClassNotFoundException ex6) {}
        catch (IllegalAccessException ex7) {}
        catch (IllegalArgumentException ex8) {}
        catch (NoSuchFieldException ex9) {}
        catch (SecurityException ex10) {}
        return null;
    }
    
    public static Object getStaticFieldObject(final String s, final String s2) {
        try {
            final Field declaredField = Class.forName(s).getDeclaredField(s2);
            declaredField.setAccessible(true);
            final Field field = declaredField;
            try {
                return field.get(null);
            }
            catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            catch (IllegalAccessException ex2) {
                ex2.printStackTrace();
            }
            catch (IllegalArgumentException ex3) {
                ex3.printStackTrace();
            }
            catch (NoSuchFieldException ex4) {
                ex4.printStackTrace();
            }
            catch (SecurityException ex5) {
                ex5.printStackTrace();
            }
        }
        catch (ClassNotFoundException ex6) {}
        catch (IllegalAccessException ex7) {}
        catch (IllegalArgumentException ex8) {}
        catch (NoSuchFieldException ex9) {}
        catch (SecurityException ex10) {}
        return null;
    }
    
    public static Object invokeMethod(final String s, final String s2, final Object o, final Class[] array, final Object[] array2) {
        try {
            return Class.forName(s).getMethod(s2, (Class<?>[])array).invoke(o, array2);
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (InvocationTargetException ex2) {
            ex2.printStackTrace();
        }
        catch (NoSuchMethodException ex3) {
            ex3.printStackTrace();
        }
        catch (IllegalAccessException ex4) {
            ex4.printStackTrace();
        }
        catch (IllegalArgumentException ex5) {
            ex5.printStackTrace();
        }
        catch (SecurityException ex6) {
            ex6.printStackTrace();
        }
        return null;
    }
    
    public static Object invokeStaticMethod(final String s, final String s2, final Class[] array, final Object[] array2) {
        try {
            return Class.forName(s).getMethod(s2, (Class<?>[])array).invoke(null, array2);
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (InvocationTargetException ex2) {
            ex2.printStackTrace();
        }
        catch (NoSuchMethodException ex3) {
            ex3.printStackTrace();
        }
        catch (IllegalAccessException ex4) {
            ex4.printStackTrace();
        }
        catch (IllegalArgumentException ex5) {
            ex5.printStackTrace();
        }
        catch (SecurityException ex6) {
            ex6.printStackTrace();
        }
        return null;
    }
    
    public static void setFieldObject(final String s, final String s2, final Object o, final Object o2) {
        try {
            final Field declaredField = Class.forName(s).getDeclaredField(s2);
            declaredField.setAccessible(true);
            declaredField.set(o, o2);
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IllegalAccessException ex2) {
            ex2.printStackTrace();
        }
        catch (IllegalArgumentException ex3) {
            ex3.printStackTrace();
        }
        catch (NoSuchFieldException ex4) {
            ex4.printStackTrace();
        }
        catch (SecurityException ex5) {
            ex5.printStackTrace();
        }
    }
    
    public static void setStaticObject(final String s, final String s2, final Object o) {
        try {
            final Field declaredField = Class.forName(s).getDeclaredField(s2);
            declaredField.setAccessible(true);
            declaredField.set(null, o);
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IllegalAccessException ex2) {
            ex2.printStackTrace();
        }
        catch (IllegalArgumentException ex3) {
            ex3.printStackTrace();
        }
        catch (NoSuchFieldException ex4) {
            ex4.printStackTrace();
        }
        catch (SecurityException ex5) {
            ex5.printStackTrace();
        }
    }
}
