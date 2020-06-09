// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.platform;

import okhttp3.internal.Util;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import javax.net.ssl.SSLSocket;
import java.lang.reflect.Method;

class JdkWithJettyBootPlatform extends Platform
{
    private final Class clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class serverProviderClass;
    
    public JdkWithJettyBootPlatform(final Method putMethod, final Method getMethod, final Method removeMethod, final Class clientProviderClass, final Class serverProviderClass) {
        this.putMethod = putMethod;
        this.getMethod = getMethod;
        this.removeMethod = removeMethod;
        this.clientProviderClass = clientProviderClass;
        this.serverProviderClass = serverProviderClass;
    }
    
    public static Platform buildIfSupported() {
        final String s = "org.eclipse.jetty.alpn.ALPN";
        try {
            final Class<?> forName = Class.forName(s);
            try {
                try {
                    final StringBuilder sb2;
                    final StringBuilder sb = sb2 = new StringBuilder();
                    try {
                        sb2.append(s);
                        sb.append("$Provider");
                        final String string = sb.toString();
                        try {
                            final Class<?> forName2 = Class.forName(string);
                            try {
                                try {
                                    final StringBuilder sb4;
                                    final StringBuilder sb3 = sb4 = new StringBuilder();
                                    try {
                                        sb4.append(s);
                                        sb3.append("$ClientProvider");
                                        final String string2 = sb3.toString();
                                        try {
                                            final Class<?> forName3 = Class.forName(string2);
                                            try {
                                                try {
                                                    final StringBuilder sb6;
                                                    final StringBuilder sb5 = sb6 = new StringBuilder();
                                                    try {
                                                        sb6.append(s);
                                                        sb5.append("$ServerProvider");
                                                        final String string3 = sb5.toString();
                                                        try {
                                                            final Class<?> forName4 = Class.forName(string3);
                                                            final String s2 = "put";
                                                            final Class[] array = { SSLSocket.class, null };
                                                            final int n = 1;
                                                            array[n] = forName2;
                                                            final Method method = forName.getMethod(s2, (Class<?>[])array);
                                                            final String s3 = "get";
                                                            final Class[] array2 = new Class[n];
                                                            array2[0] = SSLSocket.class;
                                                            final Method method2 = forName.getMethod(s3, (Class<?>[])array2);
                                                            final String s4 = "remove";
                                                            final Class[] array3 = new Class[n];
                                                            array3[0] = SSLSocket.class;
                                                            final Method method3 = forName.getMethod(s4, (Class<?>[])array3);
                                                            try {
                                                                return new JdkWithJettyBootPlatform(method, method2, method3, forName3, forName4);
                                                            }
                                                            catch (NoSuchMethodException ex) {}
                                                            catch (ClassNotFoundException ex2) {}
                                                        }
                                                        catch (NoSuchMethodException ex3) {}
                                                        catch (ClassNotFoundException ex4) {}
                                                    }
                                                    catch (NoSuchMethodException ex5) {}
                                                    catch (ClassNotFoundException ex6) {}
                                                }
                                                catch (NoSuchMethodException ex7) {}
                                                catch (ClassNotFoundException ex8) {}
                                            }
                                            catch (NoSuchMethodException ex9) {}
                                            catch (ClassNotFoundException ex10) {}
                                        }
                                        catch (NoSuchMethodException ex11) {}
                                        catch (ClassNotFoundException ex12) {}
                                    }
                                    catch (NoSuchMethodException ex13) {}
                                    catch (ClassNotFoundException ex14) {}
                                }
                                catch (NoSuchMethodException ex15) {}
                                catch (ClassNotFoundException ex16) {}
                            }
                            catch (NoSuchMethodException ex17) {}
                            catch (ClassNotFoundException ex18) {}
                        }
                        catch (NoSuchMethodException ex19) {}
                        catch (ClassNotFoundException ex20) {}
                    }
                    catch (NoSuchMethodException ex21) {}
                    catch (ClassNotFoundException ex22) {}
                }
                catch (NoSuchMethodException ex23) {}
                catch (ClassNotFoundException ex24) {}
            }
            catch (NoSuchMethodException ex25) {}
            catch (ClassNotFoundException ex26) {}
        }
        catch (NoSuchMethodException ex27) {}
        catch (ClassNotFoundException ex28) {}
        return null;
    }
    
    public void afterHandshake(final SSLSocket sslSocket) {
        try {
            this.removeMethod.invoke(null, sslSocket);
            return;
        }
        catch (InvocationTargetException ex) {}
        catch (IllegalAccessException ex2) {}
        throw new AssertionError();
    }
    
    public void configureTlsExtensions(final SSLSocket sslSocket, final String s, final List list) {
        final List alpnProtocolNames = Platform.alpnProtocolNames(list);
        Object o = Platform.class;
        try {
            o = ((Class)o).getClassLoader();
            final int n = 2;
            final Class[] array = new Class[n];
            try {
                array[0] = this.clientProviderClass;
                final Class serverProviderClass = this.serverProviderClass;
                final int n2 = 1;
                array[n2] = serverProviderClass;
                o = Proxy.newProxyInstance((ClassLoader)o, array, new JdkWithJettyBootPlatform$JettyNegoProvider(alpnProtocolNames));
                try {
                    final Method putMethod = this.putMethod;
                    final Object[] array2 = new Object[n];
                    array2[0] = sslSocket;
                    array2[n2] = o;
                    putMethod.invoke(null, array2);
                    return;
                }
                catch (IllegalAccessException o) {}
                catch (InvocationTargetException ex) {}
            }
            catch (IllegalAccessException ex2) {}
            catch (InvocationTargetException ex3) {}
        }
        catch (IllegalAccessException ex4) {}
        catch (InvocationTargetException ex5) {}
        throw new AssertionError(o);
    }
    
    public String getSelectedProtocol(final SSLSocket sslSocket) {
        try {
            final Method getMethod = this.getMethod;
            final Object[] array = { sslSocket };
            String access$100 = null;
            final Object invoke = getMethod.invoke(null, array);
            try {
                final InvocationHandler invocationHandler = Proxy.getInvocationHandler(invoke);
                try {
                    final JdkWithJettyBootPlatform$JettyNegoProvider jdkWithJettyBootPlatform$JettyNegoProvider = (JdkWithJettyBootPlatform$JettyNegoProvider)invocationHandler;
                    try {
                        if (!jdkWithJettyBootPlatform$JettyNegoProvider.unsupported && jdkWithJettyBootPlatform$JettyNegoProvider.selected == null) {
                            Platform.get().log(4, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?", null);
                            return null;
                        }
                        if (!jdkWithJettyBootPlatform$JettyNegoProvider.unsupported) {
                            access$100 = jdkWithJettyBootPlatform$JettyNegoProvider.selected;
                        }
                        return access$100;
                    }
                    catch (IllegalAccessException ex) {}
                    catch (InvocationTargetException ex2) {}
                }
                catch (IllegalAccessException ex3) {}
                catch (InvocationTargetException ex4) {}
            }
            catch (IllegalAccessException ex5) {}
            catch (InvocationTargetException ex6) {}
        }
        catch (IllegalAccessException ex7) {}
        catch (InvocationTargetException ex8) {}
        throw new AssertionError();
    }
}
