// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.List;
import java.lang.reflect.Constructor;

class ParceledListSliceAdapterApi21
{
    private static Constructor sConstructor;
    
    static {
        Serializable forName = "android.content.pm.ParceledListSlice";
        try {
            forName = Class.forName((String)forName);
            final Class[] array = { List.class };
            final String s = (String)forName;
            try {
                final Constructor constructor = ((Class)s).getConstructor((Class[])array);
                try {
                    ParceledListSliceAdapterApi21.sConstructor = constructor;
                }
                catch (NoSuchMethodException forName) {}
                catch (ClassNotFoundException ex) {}
            }
            catch (NoSuchMethodException ex2) {}
            catch (ClassNotFoundException ex3) {}
        }
        catch (NoSuchMethodException ex4) {}
        catch (ClassNotFoundException ex5) {}
        ((ReflectiveOperationException)forName).printStackTrace();
    }
    
    static Object newInstance(final List list) {
        Object instance = null;
        Constructor sConstructor = null;
        try {
            sConstructor = ParceledListSliceAdapterApi21.sConstructor;
            final Object[] array = { list };
            final Constructor constructor = sConstructor;
            try {
                sConstructor = (Constructor)(instance = constructor.newInstance(array));
            }
            catch (InvocationTargetException sConstructor) {}
            catch (IllegalAccessException sConstructor) {}
            catch (InstantiationException ex) {}
        }
        catch (InvocationTargetException ex2) {}
        catch (IllegalAccessException ex3) {}
        catch (InstantiationException ex4) {}
        ((Throwable)sConstructor).printStackTrace();
        return instance;
    }
}
