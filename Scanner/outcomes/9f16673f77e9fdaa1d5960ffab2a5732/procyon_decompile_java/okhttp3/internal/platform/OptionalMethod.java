// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class OptionalMethod
{
    private final String methodName;
    private final Class[] methodParams;
    private final Class returnType;
    
    public OptionalMethod(final Class returnType, final String methodName, final Class... methodParams) {
        this.returnType = returnType;
        this.methodName = methodName;
        this.methodParams = methodParams;
    }
    
    private Method getMethod(final Class clazz) {
        Method publicMethod = null;
        final String methodName = this.methodName;
        if (methodName != null) {
            publicMethod = getPublicMethod(clazz, methodName, this.methodParams);
            if (publicMethod != null) {
                final Class returnType = this.returnType;
                if (returnType != null) {
                    if (!returnType.isAssignableFrom(publicMethod.getReturnType())) {
                        publicMethod = null;
                    }
                }
            }
        }
        return publicMethod;
    }
    
    private static Method getPublicMethod(final Class clazz, final String s, final Class[] array) {
        Method method = null;
        try {
            if (((method = clazz.getMethod(s, (Class[])array)).getModifiers() & 0x1) == 0x0) {
                method = null;
            }
        }
        catch (NoSuchMethodException ex) {}
        return method;
    }
    
    public Object invoke(final Object o, final Object... array) {
        final Method method = this.getMethod(o.getClass());
        if (method != null) {
            final Method method2 = method;
            try {
                return method2.invoke(o, array);
            }
            catch (IllegalAccessException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unexpectedly could not call: ");
                sb.append(method);
                final AssertionError assertionError = new AssertionError((Object)sb.toString());
                assertionError.initCause(ex);
                throw assertionError;
            }
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Method ");
        sb2.append(this.methodName);
        sb2.append(" not supported for object ");
        sb2.append(o);
        throw new AssertionError((Object)sb2.toString());
    }
    
    public Object invokeOptional(final Object o, final Object... array) {
        final Method method = this.getMethod(o.getClass());
        if (method == null) {
            return null;
        }
        final Method method2 = method;
        try {
            return method2.invoke(o, array);
        }
        catch (IllegalAccessException ex) {
            return null;
        }
    }
    
    public Object invokeOptionalWithoutCheckedException(final Object o, final Object... array) {
        try {
            return this.invokeOptional(o, array);
        }
        catch (InvocationTargetException ex) {
            final Throwable targetException = ex.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw (RuntimeException)targetException;
            }
            final AssertionError assertionError = new AssertionError((Object)"Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
    
    public Object invokeWithoutCheckedException(final Object o, final Object... array) {
        try {
            return this.invoke(o, array);
        }
        catch (InvocationTargetException ex) {
            final Throwable targetException = ex.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw (RuntimeException)targetException;
            }
            final AssertionError assertionError = new AssertionError((Object)"Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
    
    public boolean isSupported(final Object o) {
        return this.getMethod(o.getClass()) != null;
    }
}
