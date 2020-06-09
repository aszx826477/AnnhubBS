// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.platform;

import javax.net.ssl.X509TrustManager;
import javax.net.ssl.SSLSocketFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLParameters;
import java.lang.reflect.Method;

final class Jdk9Platform extends Platform
{
    final Method getProtocolMethod;
    final Method setProtocolMethod;
    
    public Jdk9Platform(final Method setProtocolMethod, final Method getProtocolMethod) {
        this.setProtocolMethod = setProtocolMethod;
        this.getProtocolMethod = getProtocolMethod;
    }
    
    public static Jdk9Platform buildIfSupported() {
        final Class<SSLParameters> clazz = SSLParameters.class;
        final String s = "setApplicationProtocols";
        final int n = 1;
        try {
            final Class[] array = new Class[n];
            array[0] = String[].class;
            final Method method = clazz.getMethod(s, (Class[])array);
            final Method method2 = SSLSocket.class.getMethod("getApplicationProtocol", (Class<?>[])new Class[0]);
            try {
                return new Jdk9Platform(method, method2);
            }
            catch (NoSuchMethodException ex) {
                return null;
            }
        }
        catch (NoSuchMethodException ex2) {}
    }
    
    public void configureTlsExtensions(final SSLSocket sslSocket, final String s, final List list) {
        try {
            final SSLParameters sslParameters = sslSocket.getSSLParameters();
            try {
                final List alpnProtocolNames = Platform.alpnProtocolNames(list);
                try {
                    final Method setProtocolMethod = this.setProtocolMethod;
                    final Object[] array = { null };
                    try {
                        final int size = alpnProtocolNames.size();
                        try {
                            array[0] = alpnProtocolNames.toArray(new String[size]);
                            setProtocolMethod.invoke(sslParameters, array);
                            try {
                                sslSocket.setSSLParameters(sslParameters);
                                return;
                            }
                            catch (InvocationTargetException ex) {}
                            catch (IllegalAccessException ex2) {}
                        }
                        catch (InvocationTargetException ex3) {}
                        catch (IllegalAccessException ex4) {}
                    }
                    catch (InvocationTargetException ex5) {}
                    catch (IllegalAccessException ex6) {}
                }
                catch (InvocationTargetException ex7) {}
                catch (IllegalAccessException ex8) {}
            }
            catch (InvocationTargetException ex9) {}
            catch (IllegalAccessException ex10) {}
        }
        catch (InvocationTargetException ex11) {}
        catch (IllegalAccessException ex12) {}
        throw new AssertionError();
    }
    
    public String getSelectedProtocol(final SSLSocket sslSocket) {
        try {
            final Object invoke = this.getProtocolMethod.invoke(sslSocket, new Object[0]);
            try {
                final String s = (String)invoke;
                if (s != null && !s.equals("")) {
                    return s;
                }
                return null;
            }
            catch (InvocationTargetException ex) {}
            catch (IllegalAccessException ex2) {}
        }
        catch (InvocationTargetException ex3) {}
        catch (IllegalAccessException ex4) {}
        throw new AssertionError();
    }
    
    public X509TrustManager trustManager(final SSLSocketFactory sslSocketFactory) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
