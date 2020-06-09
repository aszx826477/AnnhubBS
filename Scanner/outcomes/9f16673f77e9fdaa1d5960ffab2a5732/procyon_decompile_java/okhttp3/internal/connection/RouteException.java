// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.connection;

import java.lang.reflect.InvocationTargetException;
import java.io.IOException;
import java.lang.reflect.Method;

public final class RouteException extends RuntimeException
{
    private static final Method addSuppressedExceptionMethod;
    private IOException lastException;
    
    static {
        final Class<Throwable> clazz = Throwable.class;
        final String s = "addSuppressed";
        final int n = 1;
        Method declaredMethod;
        try {
            final Class[] array = new Class[n];
            array[0] = Throwable.class;
            declaredMethod = clazz.getDeclaredMethod(s, (Class[])array);
        }
        catch (Exception ex) {
            declaredMethod = null;
        }
        addSuppressedExceptionMethod = declaredMethod;
    }
    
    public RouteException(final IOException lastException) {
        super(lastException);
        this.lastException = lastException;
    }
    
    private void addSuppressedIfPossible(final IOException ex, final IOException ex2) {
        final Method addSuppressedExceptionMethod = RouteException.addSuppressedExceptionMethod;
        if (addSuppressedExceptionMethod != null) {
            final int n = 1;
            try {
                final Object[] array = new Object[n];
                array[0] = ex2;
                addSuppressedExceptionMethod.invoke(ex, array);
            }
            catch (IllegalAccessException ex3) {}
            catch (InvocationTargetException ex4) {}
        }
    }
    
    public void addConnectException(final IOException lastException) {
        this.addSuppressedIfPossible(lastException, this.lastException);
        this.lastException = lastException;
    }
    
    public IOException getLastConnectException() {
        return this.lastException;
    }
}
